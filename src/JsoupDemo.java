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
		
		Elements genericInfo = doc.select("div#meta div p"); // all generic info e.g. coach, w-l

		for (Element step : genericInfo) {

			System.out.println(step.text());

		}

		// Sorts 
		Element tableRoster = doc.getElementById("roster"); //finds id of roster
		
		Elements tableRows = tableRoster.getElementsByTag("tr");
		
		for (Element row : tableRows) {
			
		Elements tds = row.getElementsByTag("td");
		for (Element td: tds) {
			System.out.println(td.text());
		}
			

		}

	}
}
