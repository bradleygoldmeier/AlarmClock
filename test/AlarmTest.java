import com.company.Alarm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

public class AlarmTest {

    private Alarm alarm;

    @Before
    public void setup(){
        this.alarm = new Alarm(LocalTime.of(6,30));
    }

    @Test
    public void snoozeTest(){
        Alarm snoozed = alarm.snooze();

        Assert.assertEquals(snoozed,LocalTime.of(6,30 + alarm.getSnoozeInMinutes()));
    }
    @Test
    public void shouldActivateAlarmTest(){
        boolean activated = alarm.shouldActivateAlarm(LocalTime.of(6,30));

        Assert.assertEquals(true, activated);
    }
    @Test
    public void shouldNotActivateAlarmTest(){
        boolean activated = alarm.shouldActivateAlarm(LocalTime.of(6,25));

        Assert.assertEquals(false, activated);
    }
}
