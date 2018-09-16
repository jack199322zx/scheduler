package com.nino.interpreter;

import com.nino.model.ScheduleBean;

public interface Interpreter<E> {
    ScheduleBean interpret(E origin);
}
