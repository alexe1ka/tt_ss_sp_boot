package com.alexe1ka;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

@SpringBootApplication

public class TtSsSpBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtSsSpBootApplication.class, args);
    }
}
