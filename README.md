# Devtools project
Quick Start:
```bash
.\gradlew run
.\gradlew test
## Packages
* `ru.mentee.power` - пакет для основных классов проекта и тестов

## MenteeProgress Fields
| Поле | Тип | Описание |
| :--- | :--- | :--- |
| `menteeName` | String | Имя студента |
| `sprintNumber` | int | Номер спринта |
| `plannedHoursPerWeek` | int | Запланированные часы |

# Локальный цикл Git

### Правило перед push
Перед отправкой кода (git push) обязательно проверять, что рабочий каталог чист (`git status clean`).
Проверку выполнять через IDE Commit Tool Window или команду `git status` в CLI.

# DevTools Project

## DVT-6 Один цикл и контроль прогресса - освоение Debug

###
- Реализован метод `calculateTotalProgress` в `ProgressTracker` с помощью цикла `while`.
- Написаны юнит-тесты на валидацию данных в `ProgressLoopTest` (`assertThatThrownBy`, `assertThatCode`).
- Проведена отладка кода через Debugger (панель Variables и окно Evaluate Expression).
- Проверена усешная сборка и прохождение всех тестов (`./gradlew test`, `./gradlew run`).