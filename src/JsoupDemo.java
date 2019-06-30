import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Class which uses Jsoup library to scrape data from
 * https://www.basketball-reference.com/teams/TOR/2019.html rudimentry beginning
 * 
 * @author basil_brush
 *
 */
public class JsoupDemo {

	/**
	 * Main. s Get data from web page
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		//connect to the page
		Document doc = Jsoup.connect("https://www.basketball-reference.com/teams/TOR/2019.html").timeout(6000).get();
		
		System.out.println(doc.title());
		
		//Scrapes the generic content
		
		Elements genericInfo = doc.select("div#meta div p"); // all generic info e.g. coach, w-l

		for (Element step : genericInfo) {

			System.out.println(step.text());

		}

		// Sorts the table 
		
		Element tableRoster = doc.getElementById("roster"); //finds id of roster
		
		Elements tableRows = tableRoster.getElementsByTag("tr");
		
		for (Element row : tableRows) { //row of the roster table
		
		Elements number = row.getElementsByTag("th"); // gets the number of the player
		
		String num = number.text();
		
			
		Elements tds = row.getElementsByTag("td");
		
		int currentPos = 0;
		
		String name = null;
		String position = null;
		String height= null;
		String weight = null;
		String birthdate = null;
		String country = null;
		String experience = null;
		String university = null;
		
		for (Element td: tds) {
			
		if(currentPos == 0) {
			name = td.text();
			currentPos++;
		} else if(currentPos == 1) {
			position = td.text();
			currentPos++;
		}else if(currentPos == 2) {
			height = td.text();
			currentPos++;
		}else if(currentPos == 3) {
			weight = td.text();
			currentPos++;
		}else if(currentPos == 4) {
			birthdate = td.text();
			currentPos++;
		}else if(currentPos == 5) {
			country = td.text();
			currentPos++;
		}else if(currentPos == 6) {
			experience = td.text();
			currentPos++;
		}else if(currentPos == 7) {
			university = td.text();
			currentPos++;
		} else {
			currentPos = 0;
		}
		
		
		}
		
		Player newPlayer = new Player(num,name,position,height,weight,birthdate,country,experience,university);
			System.out.println(newPlayer.getBirthdate());

		}

	}
}
