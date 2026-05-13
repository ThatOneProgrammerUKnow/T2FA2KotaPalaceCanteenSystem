/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kotapalaceschoolcanteensystem;

/**
 *
 * @author kobus
 */
import java.util.List;
import java.util.ArrayList;

public class MenuItem {
    private String name;
    private double price;
    private static List<MenuItem> allMenuItems = new ArrayList<>();
    
    // =====| Constructor |=====
    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;
        this.allMenuItems.add(this);
    }
    
    // =====| Public methods |=====
    public static List listMenu(){
        return allMenuItems;
    }
}
