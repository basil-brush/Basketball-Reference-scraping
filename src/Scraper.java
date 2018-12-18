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
			Document webPage = Jsoup.connect(teamsWebPage).timeout(3000).get();

			Element activeTeamTable = webPage.getElementById("div_teams_active");

			Element activeTeams = activeTeamTable.getElementById("teams_active"); // active teams in the nba
			Elements teamsData = activeTeams.getElementsByTag("tr");
			for(Element team: teamsData){
				
				System.out.println(team.text());
			}
			
			Elements previousTeams = activeTeamTable.getElementsByClass("partial_table"); // holds active teams previous "teams"
																				
			
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
