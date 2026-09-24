package ru.mentee.power;

public class ProgressDemo {
  static void main(String[] args) {
    var progress = new MenteeProgress(
        "Danil",  // значение из твоего плана PLAN-2
        2,        // номер спринта
        10        // запланированные часы на спринт
    );
    System.out.println(progress.summary());
    if (progress.readyForSprint()) {
      System.out.println("Status: sprint ready");
    } else {
      System.out.println("Status: backlog first");
    }

    System.out.println("Branch DVT-3 active");
  }
}