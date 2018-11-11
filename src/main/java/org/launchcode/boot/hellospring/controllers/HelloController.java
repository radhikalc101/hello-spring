package org.launchcode.boot.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request){
        String name = request.getParameter("name");
        if(name == null){
             name ="World";
        }
        return "Hello " + name;
    }
    @RequestMapping(value = "goodbye")
    @ResponseBody
    public String goodbye(){
        return "Good Bye";

    }
    @RequestMapping(value = "hello")
    @ResponseBody
    public String helloForm() {
        String html = "<form method ='post'>" +
                "<input type = 'text' name = 'name'/>"+
                "<input type = 'submit' value = 'Gteat me!'/>"+
                "</form>";
        return html;

    }

    /*@RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {
        String html = "<form method ='post'>" +
                "<input type = 'text' name = 'name'/>"+
                "<select name='language'>"+
                "<option value='Bonjour' selected>French</option>"+
                "<option value='Hello'>English</option>"+
                "<option value='Namasthe'>Telugu</option>"+
                "<option value='Aloha'>Hawaiian</option>"+
                "<option value='Hola'>Spanish</option>"+
                "</select>"+
                "<input type = 'submit' value = 'Gteat me!'/>"+
                "</form>";
        return html;

    }
    */

    @RequestMapping(value = "hello",method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {
        String language = request.getParameter("language");
        String name = request.getParameter("name");
        return "<h1 style='color:red'>"+language +" "+ name+"</h1>";
    }
    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "Hello "+ name;
    }
}
