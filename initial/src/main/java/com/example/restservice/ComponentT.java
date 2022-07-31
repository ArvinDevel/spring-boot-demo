package com.example.restservice;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ComponentT {
    public ComponentT() {
        System.out.println("initializing component");
    }

    // TODO: check why the annotation can't be taken effect here
    @RequestMapping("/test")
    public String greeting(@RequestParam(value = "name", required = false) String name) {
        return "succ";
    }
}
