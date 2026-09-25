package ru.mentee.power;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MenteeProgressTest {

  @Test
  void shouldFormatSummaryWhenProgressCreated() {
    MenteeProgress progress = new MenteeProgress("Даниил", 1, 8);

    assertThat(progress.summary()).isEqualTo("Спринт 1 -> Даниил: planned 8 h");
  }

  @Test
  void shouldDetectReadinessWhenHoursAboveThreshold() {
    assertThat(new MenteeProgress("Даниил", 1, 4).readyForSprint()).isTrue();
  }

  @Test
  void shouldDetectLackOfReadinessWhenHoursBelowThreshold() {
    assertThat(new MenteeProgress("Даниил", 1, 2).readyForSprint()).isFalse();
  }

  @Test
  void shouldThrowExceptionWhenMenteeNameIsNull() {
    assertThrows(IllegalArgumentException.class,
        () -> new MenteeProgress(null, 1, 10));
  }

  @Test
  void shouldThrowExceptionWhenMenteeNameIsBlank() {
    assertThrows(IllegalArgumentException.class,
        () -> new MenteeProgress("   ", 1, 10));
  }

  @Test
  void shouldThrowExceptionWhenSprintNumberIsZero() {
    assertThrows(IllegalArgumentException.class,
        () -> new MenteeProgress("Данил", 0, 10));
  }

  @Test
  void shouldThrowExceptionWhenSprintNumberIsNegative() {
    assertThrows(IllegalArgumentException.class,
        () -> new MenteeProgress("Данил", -1, 10));
  }

  @Test
  void shouldThrowExceptionWhenPlannedHoursIsNegative() {
    assertThrows(IllegalArgumentException.class,
        () -> new MenteeProgress("Данил", 1, -5));
  }

}