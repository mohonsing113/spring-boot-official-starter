package com.oocl.web.sampleWebApp.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.logging.Logger;
@RestController
@RequestMapping("/users")
public class HelloController {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @RequestMapping(value = "", method =RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody User user) {
        return ResponseEntity.created(URI.create("/users/"+user.getUsername())).body("created");
    }
}