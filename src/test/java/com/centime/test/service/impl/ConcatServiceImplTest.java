package com.centime.test.service.impl;

import com.centime.test.model.PersonDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static com.centime.test.exception.RestErrorMessage.EC_1001;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class ConcatServiceImplTest {

    public static final String SUR_NAME = "Doe";
    public static final String NAME = "John";
    public static final String CONCAT_RESPONSE = "John Doe";

    @InjectMocks
    private ConcatServiceImpl concatService;

    private PersonDTO person;

    @Before
    public void setUp() {
        person = buildPersonDTO();
    }

    @Test
    public void concatSuccess() {
        Optional<String> concatResponse = concatService.concat(person);
        assertThat(concatResponse).isNotEmpty();
        assertThat(concatResponse.get()).isEqualTo(CONCAT_RESPONSE);
    }

    @Test
    public void concatWhenPersonNull() throws IllegalArgumentException{
        /*Optional<String> concatResponse = concatService.concat(null);
        assertFalse(concatResponse.isPresent());*/
        assertThatThrownBy(() -> concatService.concat(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(EC_1001.getMessage());
    }

    public PersonDTO buildPersonDTO() {
        PersonDTO personDTO = PersonDTO.builder()
                .name(NAME)
                .surName(SUR_NAME)
                .build();
        return personDTO;
    }
}