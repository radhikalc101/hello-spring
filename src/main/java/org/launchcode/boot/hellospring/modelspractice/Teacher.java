package org.launchcode.boot.hellospring.modelspractice;

public class Teacher {
    private String name;
    private String teachingGrades;
    private String rating;

    public Teacher(String name, String teachingGrade,String ratings){
        this.name=name;
        this.teachingGrades=teachingGrade;
        this.rating=ratings;
    }

    public String getName() {
        return this.name;
    }

    public String getTeachingGrade() {
        return this.teachingGrades;
    }

    public String getRatings() {
        return this.rating;
    }
}
