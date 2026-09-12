package ru.mentee.power;

public class ProgressDemo {
    public static void main(String[] args) {
        var progress = new MenteeProgress(
           "Daniil", // значение из твоего плана PLAN-2
            2,               // номер спринта
            10               // запланированные часы на спринт
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
