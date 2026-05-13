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

public class ReceiptManager {
    private List<String> menuItemNames;
    private List<Double> menuItemPrices;
    private double totalPrice;
    private double pricePaid;
    private double change;
    private LocalDate date;
    
    // Static
    private static List<ReceiptManager> allReceipts = new ArrayList<>();
    
    // =====| Constructor |=====
    public ReceiptManager(List<String> menuItemNames, List<Double> menuItemPrices, double totalPrice, double pricePaid, double change, LocalDate date){
        this.menuItemNames = menuItemNames;
        this.menuItemPrices = menuItemPrices;
        this.totalPrice = totalPrice;
        this.pricePaid = pricePaid;
        this.change = change;
        this.date = date;
        
        this.allReceipts.add(this);
    }
    
    // =====| Private methods |=====
  
    
    // =====| Public methods |=====
}
