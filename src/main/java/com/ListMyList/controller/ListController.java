package com.ListMyList.controller;

import com.ListMyList.logic.ListService;
import com.ListMyList.model.DTO.ListWriteModel;
import com.ListMyList.model.list.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/lists")
public class ListController {
    private final ListService listService;
    public static final Logger logger = LoggerFactory.getLogger(ListController.class);

     ListController(final ListService listService) {
        this.listService = listService;
    }


    @PostMapping
    ResponseEntity<List> createList(@RequestBody @Valid @ModelAttribute("list") ListWriteModel toCreate){


        List result = listService.createList(toCreate);
        logger.warn("List added");
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping(params = {"!sort", "!page", "!size" })
    ResponseEntity<?> readAllLists(){
        logger.warn("Exposing all the tasks");
        return ResponseEntity.ok(listService.findAll());
    }
}
