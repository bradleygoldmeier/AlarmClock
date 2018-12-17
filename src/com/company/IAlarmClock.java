package com.company;

import java.util.List;

public interface IAlarmClock {
    void addAlarm(Alarm alarm);
    List<Alarm> getAlarms();
    List<Alarm> getActiveAlarms();
}
