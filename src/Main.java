import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Albérletek keresése...");

        findAlberlet(
                "bacs-kiskun",
                "kecskemet",
                "lakas",
                60000,
                85000
        );
    }

    //
    public static void findAlberlet(String state, String city, String type, int min_price, int max_price) throws IOException {

        String url = "https://ingatlan.jofogas.hu/"+state+"/"+city+"/"+type+"/van-1/igen?max_price="+max_price+"&min_price="+min_price+"&roe=3&ros=1&st=u";

        Document doc = Jsoup.connect(url).get();
        System.out.println(doc.title());
        Elements newsHeadlines = doc.select("div[itemprop=item]");
        for (Element headline : newsHeadlines) {
            System.out.println(
                    headline.select("meta[itemprop=name]").attr("content") + "\n" +
                            headline.select("span[itemprop=price]").attr("content")
            );
        }
    }

}
