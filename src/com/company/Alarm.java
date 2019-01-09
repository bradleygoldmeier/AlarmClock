package com.company;

import java.time.LocalTime;

public class Alarm {
    public LocalTime getAlarmTime() {
        return alarmTime;
    }

    private LocalTime alarmTime;
    private LocalTime originalAlarmTime;
    private int snoozeInMinutes = 1;
    private boolean isRinging;
    public boolean inSnoozeMode;
    private boolean rang;



    public  Alarm(LocalTime alarmTime){
        this.alarmTime = alarmTime;
        this.originalAlarmTime = alarmTime;
    }

    public  Alarm(){
        alarmTime = LocalTime.now();
        originalAlarmTime = LocalTime.now();
    }

    public void setAlarmTime(LocalTime localTime){
        this.alarmTime = localTime;
    }

    public boolean isRinging(){
        return isRinging;
    }

    public LocalTime nextAlarmTime(){
        if (inSnoozeMode){
            return alarmTime;
        }

        return originalAlarmTime.plusHours(24);
    }

    public boolean shouldActivateAlarm(LocalTime localTime){
        return alarmTime.getHour() == localTime.getHour()
                && alarmTime.getMinute() == localTime.getMinute()
                && localTime.getNano() == 0
                && !rang;
    }

    public Alarm snooze() {
        Alarm snoozeAlarmTime = new Alarm(alarmTime.plusMinutes(this.snoozeInMinutes));
        snoozeAlarmTime.inSnoozeMode = true;
        return snoozeAlarmTime;
    }

    public void resetAlarm(Alarm alarm) {
        ResetAlarm reset = new ResetAlarm(alarm);
        reset.start();
    }


    public boolean getRang() {
        return rang;
    }

    public void setRang(boolean rang) {
        this.rang = rang;
    }

    public int getSnoozeInMinutes(){
        return snoozeInMinutes;
    }
}
