package com.example.SpringMvc.serves;

import com.example.SpringMvc.Repo.FlightRepo;
import com.example.SpringMvc.Repo.UserRepo;
import com.example.SpringMvc.model.Flight;
import com.example.SpringMvc.model.Role;
import com.example.SpringMvc.model.User;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

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
        session.setAttribute("pass", passengers);
        session.setAttribute("date", date);
        mav.addObject("result", result);

        return mav;
    }

    public ModelAndView register(String username, String password, HttpServletRequest req){
        if(username.length() <= 0 || password.length() <= 0){
            return new ModelAndView("redirect:/register?error=1");
        }
        User user = userRepo.getByUsername(username);
        if(user != null){
            return new ModelAndView("redirect:/register?error=2");
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
            return new ModelAndView("redirect:/");

        return mav;
    }

    public String checkoutPage(HttpServletRequest req){
        if(req.getParameter("fno") == null){
            return "redirect:/";
        }
        int flightNum = Integer.parseInt(req.getParameter("fno"));
        HttpSession session = req.getSession();
        session.setAttribute("flightNum", flightNum);
        if(session.getAttribute("user") == null){
            return "redirect:/register";
        }
        return "checkout";
    }

    public String bookTicket(HttpServletRequest req, String fname, String cc){
        HttpSession session = req.getSession();
        if(session.getAttribute("flightNum") == null){
            return "redirect:/";
        }
        int fno = (int) session.getAttribute("flightNum");
        Flight flight = flightRepo.getById(fno);

        Hashtable<String, Object> ticket = new Hashtable<String, Object>();
        //generate order number
        String num = RandomStringUtils.random(8, "0123456789abcdef");

        ticket.put("ticketNumber", num);
        ticket.put("pass", session.getAttribute("pass"));
        ticket.put("date", session.getAttribute("date"));
        ticket.put("fname", fname);
        ticket.put("user", session.getAttribute("user"));
        ticket.put("flight", flight);

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
