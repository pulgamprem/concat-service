package com.centime.test.service;

import com.centime.test.model.PersonDTO;

import java.util.Optional;

public interface ConcatService {

    Optional<String> concat(PersonDTO person);

}
