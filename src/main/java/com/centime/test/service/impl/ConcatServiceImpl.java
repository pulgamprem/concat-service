package com.centime.test.service.impl;

import com.centime.test.model.PersonDTO;
import com.centime.test.service.ConcatService;
import com.centime.test.util.LogMethodParam;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.centime.test.exception.RestErrorMessage.EC_1001;

@Service
public class ConcatServiceImpl implements ConcatService {

    @Override
    @LogMethodParam
    public  Optional<String> concat(PersonDTO person) {
        if(person == null || person.getName() == null || person.getSurName() == null) {
            throw new IllegalArgumentException(EC_1001.getMessage());
        }
        return Optional.of(person.getName().concat(" ").concat(person.getSurName()));
    }
}
