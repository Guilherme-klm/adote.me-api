package com.adote.me.controller;

import com.adote.me.model.AppStatus;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Tag(name = "status")
public class StatusController {

    @Value("${version}")
    private String version;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping(value = "/status")
    public AppStatus status () {
        return new AppStatus(version, applicationName, OK.value());
    }
}
