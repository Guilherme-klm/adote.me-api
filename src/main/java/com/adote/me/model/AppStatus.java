package com.adote.me.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppStatus {

    @JsonProperty("version")
    private String version;

    @JsonProperty("applicationName")
    private String applicationName;

    @JsonProperty("httpStatus")
    private int httpStatus;

    public AppStatus(String version, String applicationName, int httpStatus) {
        this.version = version;
        this.applicationName = applicationName;
        this.httpStatus = httpStatus;
    }
}
