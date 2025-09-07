package com.mycompany.app.unit.userconsole;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mycompany.app.userconsole.UserConsoleLine;
import com.mycompany.app.userconsole.UserConsoleScreen;

import java.lang.reflect.Field;
import java.util.Map;
import org.junit.jupiter.api.Test;

class UserConsoleScreenTest {

  @SuppressWarnings("unchecked")
  private Map<Integer, UserConsoleLine> getIndexLineMap(UserConsoleScreen screen) throws Exception {
    Field field = UserConsoleScreen.class.getDeclaredField("indexLineMap");
    field.setAccessible(true);
    return (Map<Integer, UserConsoleLine>) field.get(screen);
  }

  private int getCountLines(UserConsoleScreen screen) throws Exception {
    Field field = UserConsoleScreen.class.getDeclaredField("countLines");
    field.setAccessible(true);
    return (Integer) field.get(screen);
  }

  @Test
  void shouldStoreOriginalTextInToString() {
    String raw = "Line one\nLine two\nLine three";
    UserConsoleScreen screen = new UserConsoleScreen(raw);

    assertEquals(raw, screen.toString());
  }

  @Test
  void shouldSplitTextIntoCorrectNumberOfLines() throws Exception {
    String raw = "Line one\nLine two\nLine three";
    UserConsoleScreen screen = new UserConsoleScreen(raw);

    assertEquals(3, getCountLines(screen));

    Map<Integer, UserConsoleLine> map = getIndexLineMap(screen);
    assertEquals("Line one", map.get(0).toString());
    assertEquals("Line two", map.get(1).toString());
    assertEquals("Line three", map.get(2).toString());
  }

  @Test
  void shouldHandleSingleLine() throws Exception {
    String raw = "Single line only";
    UserConsoleScreen screen = new UserConsoleScreen(raw);

    assertEquals(1, getCountLines(screen));

    Map<Integer, UserConsoleLine> map = getIndexLineMap(screen);
    assertEquals("Single line only", map.get(0).toString());
  }

  @Test
  void shouldHandleEmptyString() throws Exception {
    String raw = "";
    UserConsoleScreen screen = new UserConsoleScreen(raw);

    // split("") -> [""] → one empty line
    assertEquals(1, getCountLines(screen));

    Map<Integer, UserConsoleLine> map = getIndexLineMap(screen);
    assertEquals("", map.get(0).toString());
  }

  @Test
  void shouldHandleMultipleConsecutiveNewlines() throws Exception {
    String raw = "Line one\n\nLine three";
    UserConsoleScreen screen = new UserConsoleScreen(raw);

    // split("\n") -> ["Line one", "", "Line three"]
    assertEquals(3, getCountLines(screen));

    Map<Integer, UserConsoleLine> map = getIndexLineMap(screen);
    assertEquals("Line one", map.get(0).toString());
    assertEquals("", map.get(1).toString());
    assertEquals("Line three", map.get(2).toString());
  }
}
