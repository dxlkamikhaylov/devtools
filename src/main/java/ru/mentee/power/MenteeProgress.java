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
   * Проверяет, готов ли менти к спринту.
   *
   * @return {@code true}, если запланировано не менее 3 часов в неделю
   */

  public boolean readyForSprint() {
    return plannedHoursPerWeek >= 3;
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