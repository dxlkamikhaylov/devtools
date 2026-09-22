package ru.mentee.power.devtools.progress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование ProgressTracker")
@SuppressWarnings("checkstyle:MethodName")
class ProgressLoopTest {
  @Test
  @DisplayName("Суммарный прогресс для нескольких mentee с разным прогрессом")
  void shouldCalculateTotalProgressWhenMultipleMentees() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
        new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
        new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertThat(result)
        .contains("пройдено 25 из 36 уроков")
        .contains("осталось 11 уроков");
  }

  @Test
  @DisplayName("Все mentee завершили курс — осталось 0")
  void shouldCalculateTotalProgressWhenAllMenteesCompleted() {
    ProgressTracker tracker = new ProgressTracker();
    Mentee[] mentees = {
        new Mentee("Иван", "Москва", "Backend", 12, 12),
        new Mentee("Мария", "СПб", "Fullstack", 12, 12)
    };

    String result = tracker.calculateTotalProgress(mentees);

    assertThat(result)
        .contains("пройдено 24 из 24 уроков")
        .contains("осталось 0 уроков");
  }

  @Test
  @DisplayName("Ошибка, если завершенных уроков больше, чем уроков существует")
  void checkMenteeInvalidData() {
    assertThatThrownBy(() -> new Mentee("Иван", "Москва", "Backend", 15, 10))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Некорректные значения прогресса");
  }

  @Test
  @DisplayName("Успешное создание при корректных данных")
  void checkMenteeValidData() {
    assertThatCode(() -> new Mentee("Иван", "Москва", "Backend", 5, 12))
        .doesNotThrowAnyException();
  }

}
