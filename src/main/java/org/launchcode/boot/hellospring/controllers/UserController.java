package org.launchcode.boot.hellospring.controllers;

import org.launchcode.boot.hellospring.models.User;
import org.launchcode.boot.hellospring.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value="user")
public class UserController {

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("users", UserData.getUsers());
        model.addAttribute("title","Users");
        return "user/index"; // rendering template
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model){

        model.addAttribute("title","Add User");
        model.addAttribute(new User());
        return "user/add";//rendering template
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String prossesAddUserForm(Model model, @ModelAttribute  @Valid User user , Errors errors,
                                     String varifypassword ){
        if(errors.hasErrors()){
            model.addAttribute("title","Add User");
            return "user/add";
        }
        if(!(user.getPassword() == null || varifypassword == null) && user.getPassword().equals(varifypassword)){
            UserData.add(user);
            // instead of add method we can use this directly
            // model.addAttribute("username",user.getUsername());
            //model.addAttribute("email",user.getEmail());
            //model.addAttribute("password",user.getPassword());
            //model.addAttribute("errors",errors);

            return "redirect:";
        }
        return "user/add";
    }

    //public String prossesAddUserForm(@RequestParam String username, @RequestParam String email, @RequestParam String password,@RequestParam String verifyPassword ){
        //return "redirect:add";
    //}

}
