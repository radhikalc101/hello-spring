package org.launchcode.boot.hellospring.models;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.HashMap;

public class Student {
    private String firstName;//Required
    private String lastName;//Required
    private int id;//Required
    private Date dob;//Required
    private int age;//Not Required
    private String grade;//Not Required
    private String school;//Not Required
    private Teacher teacher;//Not Required
    private HashMap<String,Integer> marksList;

    public Student(String fName,String lName,int id, Date dob){// this is constructor
        this.firstName = fName;
        this.lastName = lName;
        this.id = id;
        this.dob = dob;
        this.marksList= new HashMap<>();
    }
    public Student(String fName,String lName,int id, Date dob,String grade,String school,Teacher teacher) {// this is constructor overloading
        this(fName,lName,id,dob);
        this.grade = grade;
        this.school = school;
        this.teacher = teacher;

    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getId() {
        return this.id;
    }

    public Date getDob() {
        return this.dob;
    }

    public String getFullName() {
        return this.getFirstName() +" "+ this.getLastName();
    }

    public int getAge() {
        if(this.age == 0) {
            Date dob = this.getDob();
            LocalDate birthDate = LocalDate.of(dob.getYear(), dob.getMonth(), dob.getDate());
            LocalDate currentDate = LocalDate.now();
            if ((birthDate != null) && (currentDate != null)) {
                this.age = Period.between(birthDate, currentDate).getYears() - 1900;
            } else {
                this.age = 0;
            }
        }
        return this.age;
    }

    public String getGrade() {
        return this.grade;
    }

    public String getSchool() {
        return this.school;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    protected void setGrade(String aGrade){
        this.grade = aGrade;

    }

    public void setSchool(String aSchool) {
        this.school = aSchool;
    }

    public void setTeacher(Teacher aTeacher) {
        this.teacher = aTeacher;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("id:").append(this.id)
                .append("\nfirstName:").append(this.firstName)
                .append("\nlastName: ").append(this.lastName)
                .append("\ngrade: ").append(this.grade)
                .append("\nschool: ").append(this.school);

        return sb.toString();
    }

    public void addMarks(String subject,Integer marks){
        marksList.put(subject,marks);

    }
    public HashMap<String,Integer> getMarksList(){
        return this.marksList;
    }


    //@Autowired
}
