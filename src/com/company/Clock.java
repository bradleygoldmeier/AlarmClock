package com.company;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Bradley Goldmeier on 11/19/2018.
 */
public class Clock {

    AlarmClock alarmClock = new AlarmClock(null);

    public void updateAndPrintTime() {

        LocalTime now = LocalTime.now();
        if (now.getNano() == 0) {
            System.out.println(now);
        }

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        alarmClock.checkAlarm(now);
    }
}
