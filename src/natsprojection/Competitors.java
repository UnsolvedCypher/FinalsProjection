package natsprojection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Competitors {
  Scanner read;
  private String currentLine;
  public String[] name = new String[12];
  public String[] WCAID = new String[12];
  public String[] pb_single = new String[12];
  public String[] pb_average = new String[12];
  public String[] round1_single = new String[12];
  public String[] round1_average = new String[12];
  public String[] round2_single = new String[12];
  public String[] round2_average = new String[12];
  public String[] round3_single = new String[12];
  public String[] round3_average = new String[12];
  void nextLine() {currentLine = read.nextLine();}
  void setPreConfig() {
    System.out.println("setting pre-config...");
    try {
      read = new Scanner(new FileReader("pre_config.txt"));
    } catch (FileNotFoundException e) {
      System.out.println("error while opening pre_config");
    }
    nextLine();
    for (int i = 0; i < 12; i++) {
      nextLine();
      System.out.println("current line: " + currentLine);
      System.out.println("id: " + currentLine.substring(0, 10));
      WCAID[i] = currentLine.substring(0, 10);
      CompetitorFunctions current_competitor = new CompetitorFunctions(WCAID[i]);
      name[i] = current_competitor.full_name;
      pb_single[i] = current_competitor.pb_single;
      pb_average[i] = current_competitor.pb_average;
    }
  }
}
