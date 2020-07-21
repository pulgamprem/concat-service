package com.centime.test.controller;

import com.centime.test.model.PersonDTO;
import com.centime.test.service.ConcatService;
import com.centime.test.util.LogMethodParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController class to expose concatenation service
 *
 * @author Prem
 */
@RestController
@RequestMapping("/concat")
public class ConcatController {

    private ConcatService concatService;

    @Autowired
    public ConcatController(ConcatService concatService) {
        this.concatService = concatService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @LogMethodParam
    public ResponseEntity<String> concat(@RequestBody PersonDTO person) {
        return ResponseEntity.of(concatService.concat(person));
    }
}
