package ru.netology;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class DiplomCloudStorageApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DiplomCloudStorageApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
