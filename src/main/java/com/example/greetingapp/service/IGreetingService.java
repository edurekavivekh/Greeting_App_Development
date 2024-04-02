package com.example.greetingapp.service;

import com.example.greetingapp.model.Greeting;

import java.util.List;

public interface IGreetingService {

    String sayHello();

    String greetingWithName(String firstName, String lastName);

    Greeting saveGreetings(Greeting greeting);

    Greeting findGreetingById(Integer id);

    List<Greeting> findGreetings();

    Greeting editGreeting(Greeting greeting, Integer id);

    void deleteGreeting(Integer id);
}