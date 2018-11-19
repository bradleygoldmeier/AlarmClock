package com.company;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Bradley Goldmeier on 11/19/2018.
 */
public class Clock {
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    

}
