package com.nino.interpreter;

import com.nino.model.ScheduleBean;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;

public class DateTimeInterpreter implements Interpreter<DateTime> {

    @Override
    public ScheduleBean interpret(DateTime origin) {
        if (origin.isBeforeNow()) return new ScheduleBean(ScheduleBean.TimeValid.INVALID);
        Duration duration = new Duration(DateTime.now(), origin);
        long interval = duration.getMillis();
        return new ScheduleBean(0, interval, ScheduleBean.TimeValid.VALID);
    }

}
