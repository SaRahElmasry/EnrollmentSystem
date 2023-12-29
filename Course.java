/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaproject1;

/**
 *
 * @author LURA
 */
public class Course {
    private String name;
    private Course next;

    public Course(String name) {
        this.name = name;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public Course getNext() {
        return next;
    }

    public void setNext(Course next) {
        this.next = next;
    }
}
