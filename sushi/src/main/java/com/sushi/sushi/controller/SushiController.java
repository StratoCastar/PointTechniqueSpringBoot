package com.sushi.sushi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.sushi.sushi.jpa.Sushi;
import com.sushi.sushi.jpa.SushiRepository;

@RestController
class SushiController{

    @Autowired
    private SushiRepository repository;

@PostMapping("/sushis")
Sushi newSushi(@RequestBody Sushi sushi)
{
    return repository.save(sushi);
}

@GetMapping("/sushis")
List<Sushi> all(){
    return repository.findAll();
}

}