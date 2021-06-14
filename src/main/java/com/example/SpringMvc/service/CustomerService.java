package com.example.SpringMvc.service;

import com.example.SpringMvc.Repo.FlightRepo;
import com.example.SpringMvc.Repo.UserRepo;
import com.example.SpringMvc.model.Flight;
import com.example.SpringMvc.model.Role;
import com.example.SpringMvc.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerService {

    private final FlightRepo flightRepo;
    private final UserRepo userRepo;

    @Autowired
    public CustomerService(FlightRepo flightRepo, UserRepo userRepo) {
        this.flightRepo = flightRepo;
        this.userRepo = userRepo;
    }

    public ModelAndView searchResult(HttpServletRequest req){
        HttpSession session = req.getSession();
        ModelAndView mav = new ModelAndView("searchPage");

        String source = req.getParameter("source");
        String destination = req.getParameter("destination");
        String date = req.getParameter("date");
        String passengers = req.getParameter("passengers");

        if(source.length() <= 0 || destination.length() <= 0 || date.length() <= 0|| passengers.length() <= 0){
            return new ModelAndView("redirect:/?error=1");
        }

        System.out.println(source+" "+destination+" "+date+" "+passengers);
        List<Flight> result = flightRepo.findFlight(source, destination);
        System.out.println("result "+ result.size());

        session.setAttribute("pass", passengers);
        session.setAttribute("date", date);
        mav.addObject("result", result);

        return mav;
    }

    public String register(String username, String password, HttpServletRequest req){
        if(username.length() <= 0 || password.length() <= 0){
            return "redirect:/register?error=1";
        }

        User user = userRepo.getByUsername(username);

        if(user != null){
            return "redirect:/register?error=2";
        }

        ModelAndView mav = new ModelAndView("checkout");
        User newUser = new User(
                username,
                password,
                Role.USER
        );

        HttpSession session = req.getSession();
        userRepo.addUser(newUser);
        session.setAttribute("user", newUser);

        if(session.getAttribute("pass") == null || session.getAttribute("date")==null)
            return "redirect:/";

        return "redirect:/checkout";
    }

    //get request
    public ModelAndView checkoutPage(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("checkout");
        HttpSession session = req.getSession();
        if(req.getParameter("fno")!=null){
            session.setAttribute("fno", req.getParameter("fno"));
        }

        if(session.getAttribute("fno") == null)
            return new ModelAndView("redirect:/");

        int fno = Integer.parseInt((String) session.getAttribute("fno")) ;
        System.out.println(fno);
        Flight flight = flightRepo.getById(34);

        if(flight == null){
            return new ModelAndView("redirect:/");
        }

        session.setAttribute("flight", flight);

        if(session.getAttribute("user") == null){
            return new ModelAndView("redirect:/register");
        }

        mav.addObject("flight", flight);
        return mav;
    }

    // post request
    public String bookTicket(HttpServletRequest req, String fname, String cardNum,  String cc){

        if(fname.length() <= 0 || cardNum.length() <= 0 || cc.length() <= 0){
            return "redirect:/checkout?error=1";
        }

        Pattern creditCardPattern = Pattern.compile("^\\d{10,20}$");
        Pattern sycCodePattern = Pattern.compile("^\\d{3}$");
        Matcher matchSycCode = sycCodePattern.matcher(cc);
        Matcher matchCard = creditCardPattern.matcher(cardNum);
        if(!matchCard.matches()){
            return "redirect:/checkout?error=2";
        }
        else if(!matchSycCode.matches()){
            return "redirect:/checkout?error=3";
        }

        HttpSession session = req.getSession();
        if(session.getAttribute("flight") == null){
            return "redirect:/";
        }

        Hashtable<String, Object> ticket = new Hashtable<String, Object>();
        //generate order number
        String num = RandomStringUtils.random(8, "0123456789abcdef");

        ticket.put("ticketNumber", num);
        ticket.put("pass", session.getAttribute("pass"));
        ticket.put("date", session.getAttribute("date"));
        ticket.put("fname", fname);
        ticket.put("user", session.getAttribute("user"));
        ticket.put("flight", session.getAttribute("flight"));

        // put the ticket in session so it can be accessed from the confirmation page
        session.setAttribute("ticket", ticket);

        return "redirect:/confirmation";
    }

    public ModelAndView confirmation(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView("confirmationPage");
        HttpSession session = req.getSession();
        if(session.getAttribute("ticket") == null){
            return new ModelAndView("redirect:/");
        }
        Hashtable ticket = (Hashtable) session.getAttribute("ticket");
        mav.addObject(ticket);
        return mav;
    }
}
