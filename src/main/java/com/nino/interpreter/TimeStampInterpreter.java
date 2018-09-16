package com.nino.interpreter;

import com.nino.model.ScheduleBean;

import java.sql.Timestamp;

public class TimeStampInterpreter implements Interpreter<Timestamp> {

    @Override
    public ScheduleBean interpret(Timestamp origin) {
        return null;
    }
}
