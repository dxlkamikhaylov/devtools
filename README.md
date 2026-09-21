# Devtools project
Quick Start:
```bash
.\gradlew run
.\gradlew test
````
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
```text
BUILD SUCCESSFUL
```

### 2. Тесты

**Команда:**
```bash
./gradlew test jacocoTestReport
```

**Ожидаемый вывод:**
```text
BUILD SUCCESSFUL
```

Отчёт покрытия: `build/reports/jacoco/test/html/index.html`

### 3. Запуск приложения

**Команда:**
```bash
./gradlew run
```

**Ожидаемый вывод:**
```text
Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков
```

### 4. Debug-сценарий

1. Открыть `ProgressTracker.calculateTotalProgress`
2. Поставить breakpoint на строке с `while`
3. Запустить Debug (Shift+F9)
4. Проверить значения переменных `totalCompleted`, `totalTotal`, `left` в окне Variables
```
## Кодстайл-гайд проекта devtools

Проект следует правилам Google Java Style Guide с адаптацией.
Автоматическая проверка: ./gradlew checkstyleMain

### 1. Именование полей и методов: camelCase
До:    private List<Student> student_list;
       public void add_student(Student student) { ... }
После: private List<Student> studentList;
       public void addStudent(Student student) { ... }
Почему: Единый стиль именования (camelCase) улучшает читаемость кода и соответствует стандартам Java.
Источник: [Google Java Style Guide — Naming conventions](https://google.github.io/styleguide/javaguide.html#s5.3-camel-case)

### 2. Порядок импортов
До:    import static org.junit.jupiter.api.Assertions.assertEquals;
       import java.util.List;
После: import java.util.List;

       import static org.junit.jupiter.api.Assertions.assertEquals;
Почему: Группировка импортов (сначала обычные, потом статические) и алфавитный порядок упрощают навигацию по коду.
Источник: Checkstyle — CustomImportOrder

### 3. Whitespace вокруг ключевых слов и операторов
До:    if(student != null){
           studentList.stream().filter(s->s.city().equals(city))
После: if (student != null) {
           studentList.stream().filter(s -> s.city().equals(city))
Почему: Пробелы вокруг операторов и ключевых слов визуально разделяют логические блоки, улучшая восприятие.
Источник: Checkstyle — WhitespaceAround

### 4. Пустые строки: не больше одной между методами
До:    public void methodA() { ... }
       
       
       public void methodB() { ... }
После: public void methodA() { ... }

       public void methodB() { ... }
Почему: Избыточные пустые строки увеличивают длину файла и затрудняют чтение.
Источник: [Google Java Style Guide — Vertical whitespace](https://google.github.io/styleguide/javaguide.html#s4.6.1-vertical-whitespace)

### 5. Длина строки: не более 100 символов
До:    return "Суммарно: пройдено " + totalCompleted + " из " + totalTotal + " уроков осталось " + left + " уроков";
После: return "Суммарно: пройдено " + totalCompleted + " из " + totalTotal
               + " уроков осталось " + left + " уроков";
Почему: Длинные строки сложно читать в редакторе, они не помещаются на экран и усложняют code review.
Источник: Checkstyle — LineLength (max = 100)