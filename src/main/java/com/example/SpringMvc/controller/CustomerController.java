package com.example.SpringMvc.controller;

import com.example.SpringMvc.serves.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/checkout")
    public ModelAndView checkout(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("register");
        String fno = req.getParameter("fno");
        mav.addObject("fno", fno);
        return mav;
    }
}
