package ru.linali.springwebtask.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CookieController {

    @GetMapping("/index")
    public String index(
            @CookieValue(value = "theme",
            defaultValue = "light") String theme,
            Model model) {
        System.out.println(theme);

        model.addAttribute("theme", theme);
        return "index";
    }


    @GetMapping("/set-cookie")
    public String setCookie(
            @RequestParam("theme") String theme,
            HttpServletResponse response) {
        Cookie cookie = new Cookie("theme", theme);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(7*24*60*60);
        response.addCookie(cookie);
        return "redirect:/index";
    }

}