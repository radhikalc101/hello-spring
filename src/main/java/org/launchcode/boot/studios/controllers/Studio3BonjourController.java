package org.launchcode.boot.studios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.HashSet;

@Controller
public class Studio3BonjourController {

    private static HashMap<String, Integer> visitTracking = new HashMap<>();

    @RequestMapping(value = "studio3", method = RequestMethod.GET)
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
    @RequestMapping(value = "studio3",method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {
        String language = request.getParameter("language");
        String name = request.getParameter("name");
        Integer visitedCount = this.getCount(name);
        return "<h1 style='color:red'>" + language + " " + name + "</h1><h4>This user visited "+visitedCount+" times";
    }

    private Integer getCount(String user) {
        Integer count = visitTracking.get(user);
        if(count == null){
            count = 1;
        } else {
            count+=1;
        }
        visitTracking.put(user,count);
        return count;
    }
}
