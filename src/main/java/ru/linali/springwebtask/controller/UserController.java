package ru.linali.springwebtask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.linali.springwebtask.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    List<User> users = new ArrayList<User>();
    @RequestMapping(method = RequestMethod.GET, value = "/time")
    public String time(Model model) {
        model.addAttribute("currentTime", LocalDateTime.now());
        return "time";
    }
    @RequestMapping(method = RequestMethod.GET, value ="/reg")
    public String reg(Model model) {
        System.out.println("GET запрос");
        return "reg";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/reg")
    public String reg(@RequestParam("firstname") String firstname,
                      @RequestParam("lastname") String lastname,
                      @RequestParam("number") String number,
                      @RequestParam("date") String date) {
        System.out.println("Post запрос " + firstname);
        System.out.println(lastname);
        System.out.println(number);
        System.out.println(date);
        users.add(new User(firstname, lastname, number, LocalDateTime.now()));
        return "reg";
    }

}
