package com.data.resultprocessor.userController;


import com.data.resultprocessor.rabbitmq1.RequestSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {
    @Autowired
    RequestSender requestSender;


    @GetMapping("/getresult")
    public String producer(@RequestParam String name) {

        requestSender.send(name);
        return "Sent to RabbitMQ";

    }

}