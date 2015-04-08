package com.navent.integrations.igi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.navent.integrations.igi.config.MvcConfig;
import com.navent.integrations.igi.config.WebServicesConfig;

@SpringBootApplication
@Import({ WebServicesConfig.class, MvcConfig.class })
public class IgiApp {

    public static void main(String[] args) {
        SpringApplication.run(IgiApp.class, args);
    }

}
