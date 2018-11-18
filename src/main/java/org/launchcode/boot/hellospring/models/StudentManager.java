package org.launchcode.boot.hellospring.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StudentManager {

    public static void main(String[] args){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {

            Date rishiDob = (Date) dateFormat.parse( "12-07-2009");
            Student rishi = new Student("Rishi","Gudimalla",12,rishiDob);
            Teacher klumb = new Teacher("Klumb","4th grade","4.5****");

            rishi.addMarks("English = ",90);
            rishi.addMarks("Math = ",80);
            rishi.setGrade("4th");
            rishi.setSchool("Mckelvey Elementary");
            rishi.setTeacher(klumb);

            //System.out.println(rishi.getFirstName());
            //System.out.println(rishi.getLastName());
            System.out.println("Name: "+rishi.getFullName());
            System.out.println("Id: "+rishi.getId());
            System.out.println("Date of birth: "+rishi.getDob());
            System.out.println("Age: "+rishi.getAge() + " years old");
            System.out.println("Mark list");
            System.out.println("----------");
            for(Map.Entry<String, Integer> entry : rishi.getMarksList().entrySet()){
                System.out.println(entry.getKey() + entry.getValue());// when we  are printging strings concotination.

            }

            System.out.println("Grade: "+rishi.getGrade());
            System.out.println("School name: "+rishi.getSchool());
            System.out.println("Teacher name: "+rishi.getTeacher().getName());
            System.out.println("Teacheaing Grade: "+rishi.getTeacher().getTeachingGrade());
            System.out.println("Teacher Rating: "+rishi.getTeacher().getRatings());


            System.out.println("************************");

            Date tejuDob = (Date) dateFormat.parse( "09-05-2014");
            Teacher kera = new Teacher("Kera","Preschool","4 ****");
            Student teju = new Student("Tejasvi","Gudimalla",123,tejuDob,"preschool","Maryland Heights Community Center",kera);
            teju.addMarks("English",98);
            teju.addMarks("Math",89);

            System.out.println("Name: "+teju.getFullName());
            System.out.println("Id: "+ teju.getId());
            System.out.println("Date of birth: "+teju.getDob());
            System.out.println("Age: "+teju.getAge() + " years old");
            System.out.println("Grade: "+teju.getGrade());
            System.out.println("School name: "+teju.getSchool());
            System.out.println("Teacher name: "+teju.getTeacher().getName());
            System.out.println("Teacheaing Grade: "+teju.getTeacher().getTeachingGrade());
            System.out.println("Teacher Rating: "+teju.getTeacher().getRatings());
            System.out.println("Mark list of Teju: "+ teju.getMarksList());





        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
