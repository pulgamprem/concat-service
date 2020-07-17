package com.centime.test.service;

import com.centime.test.model.Person;

import java.util.Optional;

public interface ConcatService {

    Optional<String> concat(Person person);

}
