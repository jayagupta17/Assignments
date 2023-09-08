package com.jaya.controller;

import com.jaya.DAO.UserDAO;
import com.jaya.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    UserDAO udao;

    @GetMapping("/loginPage")
    public String getLoginPage()
    {
        return "Login";
    }

    @PostMapping("/validateUser")
    public String validateUser(@RequestParam("uname")String username, @RequestParam("pswrd")String password, Model model)
    {
        String message = "Invalid username / password";
        User user = new User(username, password);
        if(udao.validateUser(user))
            return "Search";
        model.addAttribute("message", message);
        return "Display";
    }
}
