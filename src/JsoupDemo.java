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
	 * Main.
	 * 
	 * Get data from web page
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://www.basketball-reference.com/teams/TOR/2019.html").timeout(3000).get();
		
		Elements genericInfo = doc.select("div#meta div p"); // all generic info e.g. coach, w-l
		
		for (Element step : genericInfo) {

			System.out.println(step.text());

		}
		System.out.println(doc.title());
	}
}
