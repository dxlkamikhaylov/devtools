package ru.mentee.power;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MenteeProgressTest {

  @Test
  void shouldFormatSummary_whenProgressCreated() {
    MenteeProgress progress = new MenteeProgress("Даниил", 1, 8);

    assertThat(progress.summary()).isEqualTo("Sprint 1 → Даниил: planned 8 h");
  }

  @Test
  void shouldDetectReadiness_whenHoursAboveThreshold() {
    assertThat(new MenteeProgress("Даниил", 1, 4).readyForSprint()).isTrue();
  }

  @Test
  void shouldDetectLackOfReadiness_whenHoursBelowThreshold() {
    assertThat(new MenteeProgress("Даниил", 1, 2).readyForSprint()).isFalse();
  }
}