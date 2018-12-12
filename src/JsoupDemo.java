import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Class which uses Jsoup library to scrape data from
 * https://www.basketball-reference.com/teams/TOR/2019.html
 * rudimentry beginning
 * 
 * @author basil_brush
 *
 */
public class JsoupDemo {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://www.basketball-reference.com/teams/TOR/2019.html").timeout(3000).get();
		System.out.println(doc.title());
	}
}
