package com.example.greetingapp.service;
import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GreetingService implements IGreetingService{

    @Autowired
    private GreetingAppRepository repository;
    @Override
    public String sayHello() {
        return "Hello!!!";
    }

    @Override
    public String greetingWithName(String firstName, String lastName) {
        if(firstName.isEmpty() && lastName.isEmpty())
            return sayHello();
        else if (!(firstName.equals("")) && (lastName.equals(""))) {
            return "Welcome to the greeting app, "+firstName+"!";
        }
        else if (!(lastName.equals("")) && (firstName.equals(""))) {
            return "Welcome to the greeting app, "+lastName+"!";
        }
        else
        return "Welcome to the greeting app, "+firstName+" "+lastName+"!";
    }

    @Override
    public Greeting saveGreetings(Greeting greeting) {
        return repository.save(greeting);
    }

    @Override
    public Greeting findGreetingById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Greeting> findGreetings() {
        return repository.findAll();
    }

    @Override
    public Greeting editGreeting(Greeting greeting, Integer id) {
        Greeting existingGreeting = repository.findById(id).orElse(null);
        if (existingGreeting != null) {
            existingGreeting.setContent(greeting.getContent());
            return repository.save(existingGreeting);
        }else
            return null;
    }

    @Override
    public void deleteGreeting(Integer id) {
        repository.deleteById(id);
    }
}