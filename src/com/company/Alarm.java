package com.company;

import sun.awt.image.ImageWatched;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Nachi Penn on 11/23/2018.
 */
public class Alarm {
    public static LinkedList<LocalTime> alarms = new LinkedList();
    static Scanner scanner = new Scanner(System.in);
    static String userInput;

    Alarm() {
        System.out.println("Do you want to add default alarms at 6AM and 6:30AM?");
        userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("yes")){
            setDeafultAlarms();
            }
        askUser();
    }

    private static void setDeafultAlarms() {
        alarms.add(LocalTime.of(6,0));
        alarms.add(LocalTime.of(6,30));
    }

    public static void askUser() {
        System.out.println("do you want to add an alarm?");
        userInput = scanner.nextLine();
        while (userInput.equalsIgnoreCase("yes")) {
            setAlarm();
            System.out.println("do you want to add an alarm?");
            userInput = scanner.nextLine();
        }
    }

    public static void setAlarm() {
        int hour;
        int minute;

        System.out.println("what hour would you like your alarm to ring (0-23)?");
        hour = scanner.nextInt();

        System.out.println("what minute would you like your alarm to ring (0-59)?");
        minute = scanner.nextInt();

        System.out.printf("you set an alarm at %02d:%02d", hour, minute);
        System.out.println();


        //addAlarm(hour, minute);
    }

    public static void checkAlarm(LocalTime now) {
        for(int i = 0; i < alarms.size(); i++) {
            if (now.getHour() == alarms.peek().getHour() &&
                now.getMinute() == alarms.peek().getMinute() &&
                now.getSecond() == alarms.peek().getSecond()){
                System.out.println("BEEP!!!!!");
                snooze(now);
            }
        }
    }

    public static void snooze(LocalTime now){
        System.out.println("Do you want to snooze the alarm?");
        userInput = scanner.nextLine();
        if(userInput.equalsIgnoreCase("yes")){
            alarms.add(LocalTime.of(now.getHour(),now.getMinute() + 5));
        }
    }
}