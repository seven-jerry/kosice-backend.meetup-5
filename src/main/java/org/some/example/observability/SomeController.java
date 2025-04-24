package org.some.example.observability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/some")
public class SomeController {

    @Autowired
    SomeService someService;

    @GetMapping("thing")
    public String provideThing(@RequestParam String id) {
        try {
            ObservabilityContext.setId("thingId", id);
            return someService.thing(id);
        } finally {
            ObservabilityContext.clear();
        }

    }
}
