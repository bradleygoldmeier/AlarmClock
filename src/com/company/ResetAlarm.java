package com.company;

public class ResetAlarm extends Thread {
    Alarm alarm;

    public ResetAlarm(Alarm alarm) {
        this.alarm = alarm;

    }

    @Override
    public void run() {
        try {
            sleep(60*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        alarm.setRang(false);
    }
}
