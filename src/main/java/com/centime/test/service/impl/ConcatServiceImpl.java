package com.centime.test.service.impl;

import com.centime.test.model.Person;
import com.centime.test.service.ConcatService;
import com.centime.test.util.LogMethodParam;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConcatServiceImpl implements ConcatService {

    @Override
    @LogMethodParam
    public  Optional<String> concat(Person person) {
        if(person == null || person.getName() == null || person.getSurName() == null) {
            throw new IllegalArgumentException("Name/Surname cannot be null");
        }
        return Optional.of(person.getName().concat(" ").concat(person.getSurName()));
    }
}
