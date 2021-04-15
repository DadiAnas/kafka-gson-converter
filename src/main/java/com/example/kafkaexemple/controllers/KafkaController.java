package com.example.kafkaexemple.controllers;

import com.example.kafkaexemple.entities.Product;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/kafka")
public class KafkaController {
    KafkaTemplate<String,String> kafkaTemplate;
    Gson jsonConverter;

    @Autowired
    public KafkaController(KafkaTemplate<String, String> kafkaTemplate, Gson jsonConverter) {
        this.kafkaTemplate = kafkaTemplate;
        this.jsonConverter = jsonConverter;
    }

    @PostMapping
    public void post(@RequestBody Product product){
        kafkaTemplate.send("productTopic",jsonConverter.toJson(product));
        //System.out.println(product.getName());
    }

    @KafkaListener(topics="productTopic")
    public void getFromKafka(String productString){
        System.out.println(productString);
        Product product = jsonConverter.fromJson(productString,Product.class);
        System.out.println(product.getName());
    }
}
