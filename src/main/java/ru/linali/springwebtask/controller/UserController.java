package ru.linali.springwebtask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.linali.springwebtask.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
//@RequestMapping("/api/{id_user}")
public class UserController {
    List<User> users = new ArrayList<User>();

    {
        users.add(new User("Angelina","Shtaf","2004",LocalDateTime.now()));
        users.add(new User("David","Michael","2004",LocalDateTime.now()));
        users.add(new User("David","Michael","2006",LocalDateTime.now()));

    }
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


    @GetMapping("/users")
    public String users(Model model ,@RequestParam(value = "number",required = false) String number) {
        System.out.println(number);
        List<User> numberUser = users.stream()
                        .filter(u -> u.getNumber().equals(number))
                        .toList();

        model.addAttribute("users", numberUser);
        return "users";
    }

    @GetMapping("/info-users/{number}")
    public String infoUsers(
            Model model ,
            @PathVariable("number") String number) {
        System.out.println(number);
        List<User> numberUser = users.stream()
                .filter(u -> u.getNumber().equals(number))
                .toList();

        model.addAttribute("users", numberUser);
        return "users";
    }


}
