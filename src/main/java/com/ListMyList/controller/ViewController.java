package com.ListMyList.controller;

import com.ListMyList.model.DTO.ListWriteModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping
    String getView(Model model){
        model.addAttribute("list", new ListWriteModel());
        return "view";
    }
}
