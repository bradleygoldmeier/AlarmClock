import com.company.Alarm;
import com.company.AlarmClock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

public class AlarmClockTest {

    private AlarmClock alarmClock;

    @Before
    public void setup(){
        this.alarmClock = new AlarmClock(null);
    }

    @Test
    public void defaultAlarmTest(){
        alarmClock.setDefaultAlarms();
        int result = alarmClock.getAlarms().size();
        Assert.assertEquals(result, 2);
    }

    @Test
    public void addAlarmTest(){
        Alarm alarm = new Alarm(LocalTime.of(7,0));
        alarmClock.addAlarm(alarm);
        Alarm result = alarmClock.getAlarms().remove(alarmClock.getAlarms().size());
        Assert.assertEquals(alarm, result);
    }

    // TODO: 1/8/19 dont know how check to see if method worked
    @Test
    public void checkAlarmTest(){
        Alarm alarm1 = new Alarm(LocalTime.of(7,0));
        alarmClock.addAlarm(alarm1);
        alarmClock.checkAlarm(LocalTime.of(7,0));
    }

    // TODO: 1/8/19 dont know how check to see if method worked
    @Test
    public void checkSecondAlarmTest(){
        Alarm alarm1 = new Alarm(LocalTime.of(7,0));
        Alarm alarm2 = new Alarm(LocalTime.of(7,5));
        alarmClock.addAlarm(alarm1);
        alarmClock.addAlarm(alarm2);
        alarmClock.checkAlarm(LocalTime.of(7,5));
    }

    @Test
    public void snoozeTest(){
        Alarm alarm = new Alarm(LocalTime.of(7,0));
        alarmClock.addAlarm(alarm);
        alarmClock.snooze(alarm);
        int size = alarmClock.getAlarms().size();
        Alarm snoozed = alarmClock.getAlarms().get(size);
        Assert.assertEquals(snoozed,LocalTime.of(7,0 + snoozed.getSnoozeInMinutes()));
    }
}
