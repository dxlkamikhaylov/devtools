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

## Сценарий ручной проверки DVT-6

### 1. Checkstyle

**Команда:**
```bash
./gradlew checkstyleMain

**Ожидаемый вывод:**
```
BUILD SUCCESSFUL
```

### 2. Тесты

**Команда:**
```bash
./gradlew test jacocoTestReport
```

**Ожидаемый вывод:**
```
BUILD SUCCESSFUL
```

Отчёт покрытия: `build/reports/jacoco/test/html/index.html`

### 3. Запуск приложения

**Команда:**
```bash
./gradlew run
```

**Ожидаемый вывод:**
```
Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков
```

### 4. Debug-сценарий

1. Открыть `ProgressTracker.calculateTotalProgress`
2. Поставить breakpoint на строке с `while`
3. Запустить Debug (Shift+F9)
4. Проверить значения переменных `totalCompleted`, `totalTotal`, `left` в окне Variables