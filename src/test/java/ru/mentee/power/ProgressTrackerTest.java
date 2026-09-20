package ru.mentee.power;

import org.junit.jupiter.api.Test;
import ru.mentee.power.devtools.progress.Mentee;
import ru.mentee.power.devtools.progress.ProgressTracker;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProgressTrackerTest {

  @Test
  void shouldCalculateTotalProgress() {
    ProgressTracker tracker = new ProgressTracker();

    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
        new Mentee("Мария", "Санкт-Петербург", "Full stack", 8, 12),
        new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertEquals(
        "Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков",
        result
    );
  }
}