package com.mycompany.app.unit.userconsole;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mycompany.app.userconsole.UserConsoleString;

import org.junit.jupiter.api.Test;

class UserConsoleStringTest {

  @Test
  void shouldReturnSameStringInToString() {
    String raw = "Hello World";
    UserConsoleString consoleString = new UserConsoleString(raw);

    assertEquals(raw, consoleString.toString());
  }

  @Test
  void shouldPreserveEmptyString() {
    String raw = "";
    UserConsoleString consoleString = new UserConsoleString(raw);

    assertEquals("", consoleString.toString());
  }
}
