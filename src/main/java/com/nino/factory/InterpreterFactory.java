package com.nino.factory;

import com.nino.interpreter.*;

import java.sql.Timestamp;
import java.util.Date;

public class InterpreterFactory {

    public static Interpreter create(Object obj) throws IllegalArgumentException{
        if (obj instanceof Timestamp) {
            return new TimeStampInterpreter();
        } else if (obj instanceof Date) {
            return new DateInterpreter();
        } else if (obj instanceof DateTimeInterpreter) {
            return new DateTimeInterpreter();
        }
        throw new IllegalArgumentException("create argument type error");
    }
}
