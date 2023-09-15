package GDSC.hw01.Test03;

import GDSC.hw01.Test02.Person;

public class Student extends Person {

    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void introduce() {
        System.out.println("제 이름은 " + super.name + "이고 나이는 " + super.age + ", 학점은 " + this.grade + "입니다.");
    }
}
