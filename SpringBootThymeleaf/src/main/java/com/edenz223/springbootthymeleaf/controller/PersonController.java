package com.edenz223.springbootthymeleaf.controller;


import com.edenz223.springbootthymeleaf.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {

    @GetMapping("/personList")
    public String main(Model model){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1L,"唐三藏"));
        personList.add(new Person(2L,"孙悟空"));
        personList.add(new Person(3L,"猪八戒"));
        personList.add(new Person(4L,"沙悟净"));
        personList.add(new Person(5L,"白龙马"));

        model.addAttribute("personList",personList);

        return "person";
    }

}
