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
    private int id;
    private String name;
    private double price;
    
    private static int totalItems = 0;
    private static List<MenuItem> allMenuItems = new ArrayList<>();
    
    // =====| Constructor |=====
    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;
        this.totalItems++;
        this.id = totalItems;
        
        this.allMenuItems.add(this);
    }
    
    // =====| Public methods |=====
    public static List listMenu(){
        return allMenuItems;
    }
    
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    
    public static MenuItem lookup(int lookupId){        
        // Loop through every menu item
        for (MenuItem item : allMenuItems){
            if (lookupId == item.getId()){
                return item;
            }
        }
        
        // If menu item is not found
        throw new ObjectNotFoundException("Menu item not found");
    }
}
