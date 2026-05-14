/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kotapalaceschoolcanteensystem;

/**
 *
 * @author kobus
 */
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Order {
    private int id;
    private List<MenuItem> menuItems= new ArrayList<>();
    private double totalPrice = 0;
    private double pricePaid;
    private double change;
    private LocalDate date;
    
    private static int totalOrders = 0;
    
    // Constructor
    public Order(){
        this.date = LocalDate.now();
        totalOrders++;
        this.id = totalOrders;
    }
    
    // Public methods
    public void addItem(MenuItem item){
        menuItems.add(item);
    }
    public void calculateTotal(){
        for (MenuItem item : menuItems){
            totalPrice += item.getPrice();
        }
    }
    public double getTotal(){
        return totalPrice;
    }
    
    public void pay(double amount){
        if (amount < totalPrice){
            double amountShort = totalPrice-amount;
            throw new InsufficientPaymentException("Payment is R " + amountShort + " short.");
        }
        this.pricePaid = amount;
        this.change = pricePaid-totalPrice;
    }
    public double getPaid(){
        return this.pricePaid;
    }
    public double getChange(){
        return this.change;
    }
    
    public List<MenuItem> listMenuItems(){
        return menuItems;
    }
    
    public LocalDate getDate(){
        return date;
    }
  }
