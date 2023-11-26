package com.iweb.test1;

/**
 * @author LYH
 * @date 2023/11/25 9:15
 */
public class Student implements Person{
    String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void eat() {
        System.out.println("学生喜欢吃杂粮煎饼");
    }
}
