package com.company;

import javax.swing.*;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nachi Penn on 11/23/2018.
 */
public class AlarmClock implements IAlarmClock{
    private LinkedList<Alarm> alarms = new LinkedList();
    private AlarmClockRinger alarmClockRinger;
    private Scanner scanner = new Scanner(System.in);
    private String userInput;

    public AlarmClock(AlarmClockRinger alarmClockRinger) {
        this.alarmClockRinger = alarmClockRinger;
        System.out.println("Do you want to add default alarms at 6AM and 6:30AM?");
        userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("yes")){
            setDefaultAlarms();
            }
        askUser();
    }

    public void setDefaultAlarms() {
        alarms.add(new Alarm(LocalTime.of(6,0)));
        alarms.add(new Alarm(LocalTime.of(6,30)));
    }

    public void askUser() {
        System.out.println("do you want to add an alarm?");
        userInput = scanner.nextLine();
        while (userInput.equalsIgnoreCase("yes")) {
            setAlarm();
            //System.out.println("do you want to add an alarm?");
            userInput = JOptionPane.showInputDialog("Do you want to add an alarm?");
            //userInput = scanner.nextLine();
        }
    }

    public void setAlarm() {
        int hour;
        int minute;

        System.out.println("what hour would you like your alarm to ring (0-23)?");
        hour = scanner.nextInt();

        System.out.println("what minute would you like your alarm to ring (0-59)?");
        minute = scanner.nextInt();

        System.out.printf("you set an alarm at %02d:%02d", hour, minute);
        System.out.println();

        addAlarm(new Alarm(LocalTime.of(hour,minute)));
    }

    public void checkAlarm(LocalTime now) {
        for(int i = 0; i < alarms.size(); i++) {
            if (alarms.get(i).shouldActivateAlarm(LocalTime.now())){
                alarms.get(i).setRang(true);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("BEEP!!!!!");
                snooze(alarms.get(i));
                if (!alarms.get(i).inSnoozeMode){
                    alarms.get(i).resetAlarm(alarms.get(i));
                }
                if (alarms.get(i).inSnoozeMode){
                    alarms.remove(alarms.get(i));
                }
            }
        }
    }

    public void snooze(Alarm currentAlarm){
        userInput = JOptionPane.showInputDialog("Do you want to snooze the alarm?");
        if(userInput.equalsIgnoreCase("yes")){
            Alarm snoozedAlarm = currentAlarm.snooze();
            addAlarm(snoozedAlarm);
        }
    }

    @Override
    public void addAlarm(Alarm alarm) {
        alarms.add(alarm);
    }

    @Override
    public List<Alarm> getAlarms() {
        return alarms;
    }

    @Override
    public List<Alarm> getActiveAlarms() {
        //TODO implement
        return getAlarms();
    }
}