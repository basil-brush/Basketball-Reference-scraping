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
			Elements teamsData = activeTeams.getElementsByTag("tr");
			
			for(Element team: teamsData){
				
				if(team.className().equals("full_table")) { //makes sure that it is a current NBA team.
					
					for(Element name: team.getElementsByAttribute("href")) {
						 
						System.out.println(name.text());
					}
					
					for(Element startYear: team.getElementsByAttributeValue("data-stat", "year_min")) {
						 
						System.out.println(startYear.text());
					}
					
					for(Element gamesPlayer: team.getElementsByAttributeValue("data-stat", "g")) {
						 
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
					
					parsePlayers("TOR");
				}
				
				
				
			}
			
			//Elements previousTeams = activeTeamTable.getElementsByAttribute("partial_table"); // holds active teams previous "teams"
			//System.out.println(previousTeams);
																				
			
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * @param string
	 */
	private static void parsePlayers(String string) {
	try{
		String format = String.format("https://www.basketball-reference.com/teams/%s/2019.html", string);
		Document doc = Jsoup.connect(format).timeout(6000).get();
		
		
	} catch (IOException e) {

		e.printStackTrace();
	}
		
	}
}
