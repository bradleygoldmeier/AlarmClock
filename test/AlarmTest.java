import com.company.Alarm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

public class AlarmTest {

    private Alarm alarm;

    @Before
    public void setup(){
        this.alarm = new Alarm();
    }

//    @Test
//    public void snooze(){
//        Alarm.snooze(LocalTime.of(6,30));
//        LocalTime test = Alarm.alarms.remove();
//        Assert.assertEquals(test,LocalTime.of(6,30));
//    }
//
//    @Test
//    public void defaultAlarms(){
//        Alarm.setDefaultAlarms();
//        LocalTime six = Alarm.alarms.remove();
//        LocalTime sixThirty = Alarm.alarms.remove();
//        Assert.assertEquals(six,LocalTime.of(6,0));
//        Assert.assertEquals(sixThirty,LocalTime.of(6,30));
//    }
//
//    @Test
//    public void userSetAlarms(){
//        Alarm.askUser();
//        Assert.assertEquals(Alarm.alarms.size(),1);
//    }
//
//    @Test
//    public void userDoesntSetAlarms(){
//        Alarm.askUser();
//        Assert.assertEquals(Alarm.alarms.size(),0);
//    }
//
//    @Test
//    public void alarm(){
//        Alarm.alarms.add(LocalTime.of(5,30));
//        Assert.assertEquals(Alarm.alarms.peek(),LocalTime.of(5,30));
//    }
//
//    @Test
//    public void alarm2(){
//        Alarm.alarms.add(LocalTime.of(5,30));
//        Alarm.alarms.add(LocalTime.of(6,30));
//
//        Alarm.checkAlarm(LocalTime.of(6,30));
//    }
//
//    @Test
//    public void alarm4(){
//        Alarm alarm = new Alarm();
//        alarm.setAlarmTime(LocalTime.now().minusMinutes(1));
//        boolean result = alarm.shouldActivateAlarm(LocalTime.now());
//
//        Assert.assertEquals(true, result);
//    }

    @Test
    public void alarm5(){
        Alarm alarm = new Alarm();
        alarm.setAlarmTime(LocalTime.now());
        boolean result = alarm.shouldActivateAlarm(LocalTime.now().plusMinutes(20));

        Assert.assertEquals(false, result);
    }
}
