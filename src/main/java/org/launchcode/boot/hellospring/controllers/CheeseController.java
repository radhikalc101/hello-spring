package org.launchcode.boot.hellospring.controllers;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    //static ArrayList<String> cheeses = new ArrayList<>();
    static HashMap<String, String> cheeses = new HashMap<>();
    ArrayList<String> errors = new ArrayList<>();

    //request path:/cheese
    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("cheeses",cheeses);
        model.addAttribute("title","My Cheeses");

        return "cheese/index";//rendering template
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("title","Add Cheese");
        model.addAttribute("errors",errors);
        return "cheese/add";//rendering template

    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
//        System.out.println(cheeseName);
        errors = new ArrayList<>();
        if(cheeseName == null || cheeseName.equals("")){
            errors.add("please enter the cheese name!");
            return "redirect:add";
        }else if(isValid(cheeseName)){
            cheeses.put(cheeseName, cheeseDescription);
            //redirecting to index page
            return "redirect:";
        }else {
            errors.add("please enter valid cheese name!");
            return "redirect:add";
        }


        //redirect to /cheese

    }

    private boolean isValid(String cheeseName) {
//        return cheeseName.matches("[a-zA-Z]+(\\s[a-zA-Z]*)");
//        return cheeseName.matches("[a-zA-Z]+(\\s)");
        return cheeseName.matches("[a-zA-Z]*[^0-9][a-zA-Z]*(\\s?)");
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST )
    public String processRemoveCheeseForm(HttpServletRequest request) {
        String[] cheese = request.getParameterValues("cheese");
        if(cheese != null) {
            for (String chs : cheese) {
                System.out.println(chs);
                cheeses.remove(chs);
            }
        }
        return "redirect:";
    }

//    @RequestMapping(value = "add", method = RequestMethod.POST)
//    public String processAddCheeseForm(@RequestParam String cheeseName) {
//        cheeses.add(cheeseName);

        //redirect to /cheese
        //return "redirect:";
    //}
}
