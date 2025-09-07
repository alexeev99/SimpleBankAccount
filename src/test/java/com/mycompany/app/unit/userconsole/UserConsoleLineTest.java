package com.mycompany.app.unit.userconsole;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mycompany.app.userconsole.UserConsoleLine;
import com.mycompany.app.userconsole.UserConsoleString;

import java.lang.reflect.Field;
import java.util.Map;
import org.junit.jupiter.api.Test;

class UserConsoleLineTest {

  @SuppressWarnings("unchecked")
  private Map<Integer, UserConsoleString> getIndexWordMap(UserConsoleLine line) throws Exception {
    Field field = UserConsoleLine.class.getDeclaredField("indexWordMap");
    field.setAccessible(true);
    return (Map<Integer, UserConsoleString>) field.get(line);
  }

  private int getCountWords(UserConsoleLine line) throws Exception {
    Field field = UserConsoleLine.class.getDeclaredField("countWords");
    field.setAccessible(true);
    return (Integer) field.get(line);
  }

  @Test
  void shouldStoreOriginalTextInToString() {
    String raw = "Hello World from Console";
    UserConsoleLine line = new UserConsoleLine(raw);

    assertEquals(raw, line.toString());
  }

  @Test
  void shouldSplitTextIntoCorrectNumberOfWords() throws Exception {
    String raw = "Hello World from Console";
    UserConsoleLine line = new UserConsoleLine(raw);

    assertEquals(4, getCountWords(line));

    Map<Integer, UserConsoleString> map = getIndexWordMap(line);
    assertEquals("Hello", map.get(0).toString());
    assertEquals("World", map.get(1).toString());
    assertEquals("from", map.get(2).toString());
    assertEquals("Console", map.get(3).toString());
  }

  @Test
  void shouldHandleSingleWord() throws Exception {
    String raw = "Single";
    UserConsoleLine line = new UserConsoleLine(raw);

    assertEquals(1, getCountWords(line));

    Map<Integer, UserConsoleString> map = getIndexWordMap(line);
    assertEquals("Single", map.get(0).toString());
  }

  @Test
  void shouldHandleEmptyString() throws Exception {
    String raw = "";
    UserConsoleLine line = new UserConsoleLine(raw);

    // split("") produces [""], so one empty word is created
    assertEquals(1, getCountWords(line));

    Map<Integer, UserConsoleString> map = getIndexWordMap(line);
    assertEquals("", map.get(0).toString());
  }

  @Test
  void shouldHandleMultipleSpacesBetweenWords() throws Exception {
    String raw = "Hello   World";
    UserConsoleLine line = new UserConsoleLine(raw);

    // "Hello   World".split(" ") = ["Hello", "", "", "World"]
    assertEquals(4, getCountWords(line));

    Map<Integer, UserConsoleString> map = getIndexWordMap(line);
    assertEquals("Hello", map.get(0).toString());
    assertEquals("", map.get(1).toString()); // empty tokens
    assertEquals("", map.get(2).toString());
    assertEquals("World", map.get(3).toString());
  }
}
