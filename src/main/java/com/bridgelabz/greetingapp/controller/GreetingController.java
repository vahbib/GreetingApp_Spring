package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;


    @RequestMapping(value = {"","/","/home"})
    public Greeting gretting (@RequestParam(value = "name", defaultValue = "World") String name){
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }
    @GetMapping("/getById/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable long id){
        return greetingService.getGreetingById(id);
    }
    @GetMapping("/getAllGreetings")
    public List<Greeting> getGreetings(){
        return greetingService.getAllGreetings();
    }

    @PutMapping("/updateGreeting/{id}")
    public Greeting updateGreeting(@PathVariable long id,@RequestParam(value = "message") String message){
        return greetingService.updateGreeting(id,message);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public Greeting editId(@PathVariable long id, @RequestParam(value = "message") String message) {
        return greetingService.updateGreeting(id,message);
    }
    @DeleteMapping("/deleteGreeting/{id}")
    public void deleteGreeting(@PathVariable long id){
        greetingService.deleteGreeting(id);
    }
}