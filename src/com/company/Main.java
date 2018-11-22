package com.company;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Alarm alarm = new Alarm();


        System.out.println("do you want to add an alarm?");
        String userInput = scanner.nextLine();

        while (userInput.equalsIgnoreCase("yes")){
            alarm.setAlarm();
            System.out.println("do you want to add an alarm?");
            userInput = scanner.nextLine();
        }

        Clock clock = new Clock();
        while(true){
            clock.updateAndPrintTime();
        }
    }
}
