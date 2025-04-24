package org.some.example.observability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    @Autowired
    AlertSender alertSender;


    public String thing(String id) {
        if ("fail".equals(id)) {
            alertSender.raiseAlert(ErrorCodes.SOME_THING_FAILED);
        }
        alertSender.raiseAlert(ErrorCodes.THING_ELSE_FAILED);
        return "ok";
    }
}
