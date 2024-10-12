package com.deepak.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class DemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    @GetMapping("/")
    public String index(final Model model) {

        String podIp = null;
        try {
            podIp = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            logger.error(e.toString());
            throw new RuntimeException(e);
        }
        logger.info("Pod IP Address: " + podIp);

        logger.info("INFO level log message");
        logger.debug("DEBUG level log message");
        logger.error("ERROR level log message");
        model.addAttribute("title", "This is a Spring Boot demo app version v2.0");
        model.addAttribute("msg", "Implemented using DevOps.");
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
