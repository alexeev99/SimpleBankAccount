package com.mycompany.app.userconsole;

public class UserConsoleString {
  private String text;

  public UserConsoleString(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return this.text;
  }
}
