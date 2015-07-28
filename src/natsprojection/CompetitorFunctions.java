package natsprojection;

import org.jsoup.Jsoup;

import java.util.Scanner;

public class CompetitorFunctions {
  public String WCAID, full_name, pb_average, pb_single;
  public CompetitorFunctions(String WCAID) {
    this.WCAID = WCAID;
    String html = "";
    try {
      html = Jsoup.connect("https://www.worldcubeassociation.org/results/p.php?i=" + this.WCAID).get().html();
      //System.out.println(html);
    } catch (Exception e) {
      System.out.println("OMG exception!!");
    }
    Scanner scanner = new Scanner(System.in);
    String relevant_place = "<a href=\"person_set.php?personId=" + this.WCAID + "\">";
    //full_name = html.substring(html.indexOf(relevant_place), html.indexOf('<', html.indexOf(relevant_place + 1)));
    int start = html.indexOf(relevant_place) + 45;
    int end = html.indexOf('<', start + 1);
    full_name = html.substring(start, end);
    relevant_place = "<a class=\"e\" href=\"/results/e.php?i=333\">";
    start = html.indexOf(relevant_place) + 41;
    end = html.indexOf('<', start + 1);
    pb_single = html.substring(start, end);
    relevant_place = "href=\"/results/e.php?i=333&amp;average=1\">";
    start = html.indexOf(relevant_place) + 42;
    end = html.indexOf('<', start + 1);
    pb_average = html.substring(start, end);
    System.out.println("name/single/average: " + full_name + " " + pb_single + " " + pb_average);
  }
}
