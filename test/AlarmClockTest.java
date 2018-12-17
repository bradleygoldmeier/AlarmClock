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
    public void alarm5(){
        alarmClock.addAlarm(new Alarm());
        int result = alarmClock.getAlarms().size();
        Assert.assertEquals(result, 1);
    }

    @Test
    public void alarm6(){
        alarmClock.setDefaultAlarms();
        int result = alarmClock.getAlarms().size();
        Assert.assertEquals(result, 2);
    }
}
