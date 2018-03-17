package com.example.WTFIsMyVictoryCondition;

import com.example.WTFIsMyVictoryCondition.model.Objective;
import com.example.WTFIsMyVictoryCondition.model.Objectives;
import com.example.WTFIsMyVictoryCondition.model.Player;
import com.example.WTFIsMyVictoryCondition.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.*;

@SpringBootApplication
@EnableAutoConfiguration
public class WtfIsMyVictoryConditionApplication implements ApplicationRunner{

    @Autowired
    private static MailProperties mailProperties;

    @Autowired
    private EmailService emailService;
	private VictoryManager victoryManager;
	public static void main(String[] args) throws IOException, JAXBException, MessagingException {
        SpringApplication.run(WtfIsMyVictoryConditionApplication.class, args);
    }
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
		//String conditionsFile = args[0];
		InputStream majorResource = new ClassPathResource("majorObjectiveList.xml").getInputStream();
		InputStream minorResource = new ClassPathResource("minorObjectiveList.xml").getInputStream();
		//Integer playerCount = Integer.parseInt(args[1]);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter number of players");
		Integer players = Integer.parseInt(scanner.nextLine());
		List<Player> playerInfo = createPlayers(players);
		Objectives majorObjectives = searchMajorObjectivesXML(majorResource);
		Objectives minorObjectives = searchMinorObjectivesXML(minorResource);
		Map<Integer, Objective> mappedMajorObjectives = mapMajorObjectives(majorObjectives);
		Map<Integer, Objective> mappedMinorObjectives = mapMinorObjectives(minorObjectives);

		List<Player> completedPlayerInfo = assignPlayerObjectives(playerInfo, mappedMajorObjectives, mappedMinorObjectives);
		//createPlayerFilesExternal(completedPlayerInfo);
		sendPlayerEmails(completedPlayerInfo);
		System.out.println("Have fun!");
		System.exit(1);
	}

	private void createPlayerFilesExternal(List<Player> completedPlayerInfo) throws IOException {
		//String baseDirectory = "C:/Users/AndrewSantarelli/Desktop/PlayerFiles/";
		Scanner scanner = new Scanner( System.in );
		System.out.println("Please enter directory for files to be deposited");
		String baseDirectory  = scanner.nextLine();
		for(Player player : completedPlayerInfo)
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(baseDirectory + player.getPlayerName()));
			writer.write(player.toString());
			writer.close();
		}
	}

	private void sendPlayerEmails(List<Player> completedPlayerInfo) throws IOException, MessagingException {
		//String baseDirectory = "C:/Users/AndrewSantarelli/Desktop/PlayerFiles/";
		Scanner scanner = new Scanner( System.in );
		for(Player player: completedPlayerInfo)
		{
			System.out.println("Please enter email address for " + player.getPlayerName());
			player.setEmailAddress(scanner.nextLine());
		}
		for(Player player : completedPlayerInfo)
		{
			emailService.sendSimpleMessage(player);
		}
	}

	private List<Player> assignPlayerObjectives(List<Player> playerInfo, Map<Integer, Objective> mappedMajorObjecives, Map<Integer, Objective> mappedMinorObjecives) {
		List<Player> completedPlayers = new ArrayList<Player>();
		for (Player player : playerInfo)
		{
			Random random = new Random();
			Integer select = random.nextInt(mappedMajorObjecives.size()) + 1;
			Objective major = mappedMajorObjecives.get(select);
			Integer select1 = random.nextInt(mappedMinorObjecives.size()) + 1;
			Integer select2 = select1;
			Objective minorOne = mappedMinorObjecives.get(select1);
			while(select2 == select1)
			{
				//this is to prevent getting the same objective over and over
				select2 = random.nextInt(mappedMinorObjecives.size()) + 1;
			}
			Objective minorTwo = mappedMinorObjecives.get(select2);
			player.setMajorObjective(major);
			player.setMinorObjectiveOne(minorOne);
			player.setMinorObjectiveTwo(minorTwo);
			completedPlayers.add(player);
		}
		return completedPlayers;
	}

	private List<Player> createPlayers(Integer playerCount) {
		List<Player> players = new ArrayList<Player>();
		for (Integer count = 0; count < playerCount ; count++)
		{
			Scanner scanner = new Scanner( System.in );
			System.out.println("Please enter name of player " + (count + 1));
			String playerName = scanner.nextLine();
			Player player = new Player(playerName, null, null,null, "");
			players.add(player);
		}
		return players;
	}


	private Objectives searchMajorObjectivesXML(InputStream conditionsFile) throws IOException, JAXBException {
		ObjectMapper objectMapper = new XmlMapper();
		Objectives objectives = objectMapper.readValue(conditionsFile,Objectives.class);
		//Objectives objectives = objectMapper.readValue(StringUtils.toEncodedString(Files.readAllBytes(Paths.get(conditionsFile.getURI())),StandardCharsets.UTF_8),Objectives.class);
		return objectives;
	}

	private Objectives searchMinorObjectivesXML(InputStream conditionsFile) throws IOException, JAXBException {
		ObjectMapper objectMapper = new XmlMapper();
		Objectives objectives = objectMapper.readValue(conditionsFile,Objectives.class);
		//Objectives objectives = objectMapper.readValue(StringUtils.toEncodedString(Files.readAllBytes(Paths.get(conditionsFile.getURI())),StandardCharsets.UTF_8),Objectives.class);
		return objectives;
	}

	private Map<Integer,Objective> mapMinorObjectives(Objectives minorObjectives) {
		Integer count = 1;
		Map<Integer,Objective> mapped = new HashMap<>();
		for (Objective objective : minorObjectives.getObjective())
		{
			mapped.put(count,objective);
			count++;
		}
		return mapped;
	}

	private Map<Integer,Objective> mapMajorObjectives(Objectives majorObjectives) {
		Integer count = 1;
		Map<Integer,Objective> mapped = new HashMap<>();
		for (Objective objective : majorObjectives.getObjective())
		{
			mapped.put(count,objective);
			count++;
		}
		return mapped;
	}
	private Map<String,String> searchMajorObjectives(String conditionsFile, Integer playerCount) throws IOException {
		BufferedReader conditions = new BufferedReader(new FileReader(conditionsFile));

		String line = conditions.readLine();
		String[] lineSplit;
		HashMap<String, String> titleDescriptions = new HashMap<>();
		ArrayList<String> titles = new ArrayList<>();
		ArrayList<String> weightedObjectives = new ArrayList<>();
		//parse file
		while (line != null) {
			line = line.replace("<", "");
			line = line.replaceAll("\"", "");
			lineSplit = line.split(">", 2);
			String title = lineSplit[0];
			String description = lineSplit[1];
			titles.add(title);
			titleDescriptions.put(title, description);
			//System.out.println(title + " : " + description);
			//read in blank line between conditions
			line = conditions.readLine();
			//this is the actual condition line
			line = conditions.readLine();
		}
		Integer addCount = 0;
		while (addCount < 3) {
			for (String title : titles) {
				weightedObjectives.add(title);
			}
			addCount++;
		}
		Integer assigned = 1;
		while (assigned <= playerCount) {
			Random randomGenerator = new Random();
			int objectiveNumber = randomGenerator.nextInt(weightedObjectives.size());
			String objective = weightedObjectives.get(objectiveNumber);
			String objectiveDescription = titleDescriptions.get(objective);
			assigned++;
			weightedObjectives.remove(objectiveNumber);
		}
		return titleDescriptions;
	}

}
