package com.example.SpringMvc.controller;

import com.example.SpringMvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/search")
    public ModelAndView search(HttpServletRequest req){
        return customerService.searchResult(req);
    }

    @GetMapping("/register")
    public String registerPage(HttpServletRequest req){
        HttpSession session = req.getSession();
        if(session.getAttribute("user") != null){
            return "redirect:/checkout";
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(HttpServletRequest req, @RequestParam String username, @RequestParam String password){
        return customerService.register(username, password, req);
    }

    @GetMapping("/checkout")
    public ModelAndView checkout(HttpServletRequest req){
        return customerService.checkoutPage(req);
    }

    @PostMapping("/checkout")
    public String checkoutHandler(HttpServletRequest req, @RequestParam String fname, @RequestParam String cardNum, @RequestParam String cc){
        return customerService.bookTicket(req, fname, cardNum, cc);
    }

    @GetMapping("/confirmation")
    public ModelAndView confirmation(HttpServletRequest req){
        return customerService.confirmation(req);
    }
}
