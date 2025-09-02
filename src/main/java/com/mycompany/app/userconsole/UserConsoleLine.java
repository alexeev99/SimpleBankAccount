package com.mycompany.app.userconsole;

import java.util.HashMap;
import java.util.Map;

public class UserConsoleLine {
  private final Map<Integer, UserConsoleString> indexWordMap = new HashMap<>();
  private Integer countWords = 0;
  private String text;

  public UserConsoleLine(String text) {
    this.constructIndexWordMap(text);
    this.text = text;
  }

  private void constructIndexWordMap(String text) {
    String[] splitText = text.split(" ");
    for (String word : splitText) {
      UserConsoleString consoleString = new UserConsoleString(word);
      this.indexWordMap.put(this.countWords, consoleString);
      this.countWords++;
    }
  }

  @Override
  public String toString() {
    return this.text;
  }
}
