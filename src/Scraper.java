import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Scrapes all relevant data from Basketball Reference website by using relevant
 * methods from other classes
 * 
 * @author basilbrush
 *
 */
public class Scraper {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String teamsWebPage = "https://www.basketball-reference.com/teams/";
		parseTeams(teamsWebPage);
	}

	/**
	 * 
	 * @param teamsWebPage
	 */
	private static void parseTeams(String teamsWebPage) {
		try {
			
			Document webPage = Jsoup.connect(teamsWebPage).timeout(6000).get();

			Element activeTeamTable = webPage.getElementById("div_teams_active");
			Element activeTeams = activeTeamTable.getElementById("teams_active"); // active teams in the nba
			Elements teamsData = activeTeams.getElementsByTag("tr"); //data regarding the franchise
			
			//Reads through teams
			
			for(Element team: teamsData){
				
				String url = null; // holds the url which will be passed to parse players

				
				if(team.className().equals("full_table")) { //makes sure that it is a current NBA team.
					
					for(Element name: team.getElementsByAttribute("href")) { // reads the team name
						 
						System.out.println(name.text());
						url = name.absUrl("href");
						
					}
					
					for(Element startYear: team.getElementsByAttributeValue("data-stat", "year_min")) { // reads the first year the team is in the league
						 
						System.out.println(startYear.text());
					}
					
					for(Element gamesPlayer: team.getElementsByAttributeValue("data-stat", "g")) { // reads the amount of games played by a franchise
						 
						System.out.println(gamesPlayer.text());
					}
					
					for(Element wins: team.getElementsByAttributeValue("data-stat", "wins")) {
						 
						System.out.println(wins.text());
					}
					
					for(Element loss: team.getElementsByAttributeValue("data-stat", "losses")) {
						 
						System.out.println(loss.text());
					}
					
					for(Element percentageWin: team.getElementsByAttributeValue("data-stat", "win_loss_pct")) {
						 
						System.out.println(percentageWin.text());
					}
					
					for(Element playoffAppearances: team.getElementsByAttributeValue("data-stat", "years_playoffs")) {
						 
						System.out.println(playoffAppearances.text());
					}
					
					for(Element divisionWins: team.getElementsByAttributeValue("data-stat", "years_division_champions")) {
						 
						System.out.println(divisionWins.text());
					}
					
					for(Element conferenceChamps: team.getElementsByAttributeValue("data-stat", "years_conference_champion")) {
						 
						System.out.println(conferenceChamps.text());
					}
					
					for(Element leagueChamps: team.getElementsByAttributeValue("data-stat", "years_league_champion")) {
						 
						System.out.println(leagueChamps.text());
					}
					
					parsePlayers(url);
				}
				
				
				
			}
			
			
																				
			
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Parses the relevant values which creates player onjects 
	 * 
	 * @param string
	 */
	private static void parsePlayers(String url) {
	try{
		
		String format = String.format(url);
		Document doc = Jsoup.connect(format).get(); //connects to the passed in url to team homepage
		
		
		Element previousTeams = doc.select("table").get(0); //gets the table which holds the relevant teams
		Element mostRecentTeam = previousTeams.select("tbody").first(); //parses the most recent team
		Element TeamElements = mostRecentTeam.getElementsByAttribute("href").first(); // reads the team name	
		String urlTeamPage = TeamElements.absUrl("href"); //gets the url value from the href attribute
		
		Document teamPage = Jsoup.connect(urlTeamPage).get(); //opens the page for the most recent team
		
		Element playerTable = teamPage.select("table").get(0);
		Elements rows = playerTable.select("tbody");
		
		for(Element player : rows){
			
			for(Element playerVals : player.getElementsByTag("tr")) {
				
				String playerNumber = null;
				String playerName = null;
				String playerPosition = null;
				String playerHeight= null;
				String playerWeight = null;
				String playerBirthdate = null;
				String playerCountry = null;
				String playerExperience = null;
				String playerUniversity = null;
			
				for(Element number : playerVals.getElementsByAttributeValue("data-stat","number")) {
					playerNumber = number.text();
				}
				for(Element name : playerVals.getElementsByAttributeValue("data-stat","player")) {
					playerName = name.text();
				}
				for(Element position : playerVals.getElementsByAttributeValue("data-stat", "pos")) {
					playerPosition = position.text();
				}
				for(Element height : playerVals.getElementsByAttributeValue("data-stat", "height")) {
					playerHeight = height.text();
				}
				for(Element weight : playerVals.getElementsByAttributeValue("data-stat", "weight")) {
					playerWeight = weight.text();
				}
				for(Element birthday : playerVals.getElementsByAttributeValue("data-stat", "birth_date")) {
					playerBirthdate = birthday.text();
				}
				for(Element birthCountry : playerVals.getElementsByAttributeValue("data-stat", "birth_country")) {
					playerCountry = birthCountry.text();
				}
				for(Element experience : playerVals.getElementsByAttributeValue("data-stat", "years_experience")) {
					playerExperience = experience.text();
				}
				for(Element college : playerVals.getElementsByAttributeValue("data-stat", "college")) {
					playerUniversity = college.text();
				}
		}	
			
		}
				
		
	} catch (IOException e) {

		e.printStackTrace();
	}
		
	}
}
