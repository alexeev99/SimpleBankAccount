package com.mycompany.app.userconsole;

import java.util.HashMap;
import java.util.Map;

public class UserConsoleScreen {
  private final Map<Integer, UserConsoleLine> indexLineMap = new HashMap<>();
  private Integer countLines = 0;
  private String text;

  public UserConsoleScreen(String text) {
    this.constructIndexLineMap(text);
    this.text = text;
  }

  private void constructIndexLineMap(String text) {
    String[] splitText = text.split("\n");
    for (String line : splitText) {
      UserConsoleLine consoleLine = new UserConsoleLine(line);
      this.indexLineMap.put(this.countLines, consoleLine);
      this.countLines++;
    }
  }

  @Override
  public String toString() {
    return this.text;
  }
}
