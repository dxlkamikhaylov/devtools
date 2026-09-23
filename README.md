# Devtools project
Quick Start:
```bash
.\gradlew run
.\gradlew test
```
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

## Сценарий ручной проверки DVT-7

### 1. Debug-сценарий (StudentList)
1. Запустить приложение в режиме отладки (Debug).
2. Установить точку останова (breakpoint) в методе `addStudent` класса `StudentList`.
3. Вызвать метод addStudent через Evaluate Expression (Alt+F8).
4. Убедиться, что программа остановилась на точке останова.
5. Проверить значения переменных в отладчике.
6. Выполнить шаг с обходом (Step Over) или шаг с заходом (Step Into) для проверки логики.
7. Убедиться, что студент успешно добавлен в список.
8. Проверить размер коллекции studentList.size().

### 2. Сценарий «Checkstyle упал — починил»

1. Запустить проверку Checkstyle командой `./gradlew checkstyleMain`.
2. Сборка упала с ошибкой `BUILD FAILED`.
3. Открыть отчет Checkstyle (`build/reports/checkstyle/main.html`).
4. Обнаружено нарушение правила **LineLength** в файле ProgressTracker.java (метод calculateTotalProgress).
    *   *Текст ошибки в отчете:* "Line is longer than 100 characters (found 120)."
5. Исправить код: перенести часть длинной строки на новую строку.
    *   *Было:* `return "Суммарно: пройдено " + totalCompleted + " из " + totalTotal + " уроков осталось " + left + " уроков";`
    *   *Стало:*
     ```java
     return "Суммарно: пройдено " + totalCompleted + " из " + totalTotal
             + " уроков осталось " + left + " уроков";