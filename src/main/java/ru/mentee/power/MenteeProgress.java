package ru.mentee.power;

/**
 * Прогресс менти в рамках спринта.
 *
 * @param menteeName имя менти
 * @param sprintNumber номер спринта
 * @param plannedHoursPerWeek запланированное количество часов в неделю
 */

public record MenteeProgress(String menteeName, int sprintNumber, int plannedHoursPerWeek) {

  /**
   * Минимальное количество часов в неделю, при котором менти считается
   * готовым к спринту.
   */
  private static final int MIN_HOURS_FOR_SPRINT = 3;

  /**
   * Компактный конструктор. Проверяет входные данные при создании объекта.
   * Если данные некорректны — выбрасывает {@link IllegalArgumentException}.
   */
  public MenteeProgress {
    if (menteeName == null || menteeName.isBlank()) {
      throw new IllegalArgumentException(
          "menteeName must not be null or blank");
    }
    if (sprintNumber < 1) {
      throw new IllegalArgumentException(
          "sprintNumber must be positive");
    }
    if (plannedHoursPerWeek < 0) {
      throw new IllegalArgumentException(
          "plannedHoursPerWeek cannot be negative");
    }
  }

  /**
   * Проверяет, готов ли менти к спринту.
   *
   * @return {@code true}, если запланировано не менее
   *         {@value #MIN_HOURS_FOR_SPRINT} часов в неделю
   */

  public boolean readyForSprint() {
    return plannedHoursPerWeek >= MIN_HOURS_FOR_SPRINT;
  }

  /**
   * Формирует краткое описание прогресса менти.
   *
   * @return строка в формате "Спринт %d -> %s: planned %d h"
   */

  public String summary() {
    return "Спринт %d -> %s: planned %d h".formatted(sprintNumber, menteeName, plannedHoursPerWeek);
  }
}