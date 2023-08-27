package tech.wedev.pratice.design.combination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wedev.pratice.design.combination.pojo.TicketParam;
import tech.wedev.pratice.design.combination.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/suggest")
    public List<String> suggestRequirement(@RequestParam String username) {
        return userService.suggestRequirement(username);
    }

    @PostMapping("/ticket")
    public Object getTicket(@RequestBody TicketParam ticketParam) {
        return userService.getTicket(ticketParam);
    }

    @PostMapping("/login")
    public Boolean login(@RequestParam String name, @RequestParam String pwd, @RequestParam String type) {
        return userService.login(name, pwd, type);
    }

}
