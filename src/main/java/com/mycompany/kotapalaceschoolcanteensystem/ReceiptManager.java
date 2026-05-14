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
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptManager {
    private int id;
    private Order order;
    
    // Formatted date
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/dd");
    private String formattedDate;
    
    // Static
    private static List<ReceiptManager> allReceipts = new ArrayList<>();
    private static String textFileName = "receipts.txt";
    private static int totalReceipts = 0;
    private static StringBuilder allLoadedReceipts = new StringBuilder();
    
    // =====| Constructor |=====
    public ReceiptManager(Order order){
        this.order = order;
        this.allReceipts.add(this);
        
        this.formattedDate = this.order.getDate().format(dateFormatter);
        
        totalReceipts++;
        this.id = totalReceipts;
    }
    
    
    // =====| Private methods |=====
    // Load receipts from the text file
    private static void loadReceipts(){
        try (BufferedReader br = new BufferedReader(new FileReader(textFileName))) {
            String line;
            
            // Read through every line of the file
            while ((line = br.readLine()) != null){
                allLoadedReceipts.append(line).append(System.lineSeparator());
            }
            
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
    // =====| Public methods |=====
    // Save receipts to the text file
    public void save(){
          try (BufferedWriter bw = new BufferedWriter(new FileWriter(textFileName, true))) {
          bw.write("==========| Receipt " + this.id);
          bw.newLine();
          bw.write("-----| Items");
          bw.newLine();
          
          // Write all the menu items
          for (MenuItem item : this.order.listMenuItems()) {
              bw.write(this.order.listMenuItems().indexOf(item) + ". " +item.getName() + " R "  + item.getPrice());
              
              bw.newLine();
          }
          
          // Write the total price
          bw.newLine();
          bw.newLine();
          
          bw.write("Total: R " + String.valueOf(this.order.getTotal())); 
          bw.newLine();
          
          // Write the paid price
          bw.write("Amount paid: R " + String.valueOf(this.order.getPaid()));
          bw.newLine();
          
          // Write the change given
          bw.write("Change: R " + String.valueOf(this.order.getChange()));
          bw.newLine();
          
          // Write the date
          bw.newLine();
          bw.write("Date: " + this.formattedDate);
          bw.newLine();
          
          // End receipt
          bw.write("====================|");
          bw.newLine();
          bw.newLine();

        } catch (IOException e){
            System.err.println(e.getMessage());
        }
      }
    
   
    
    // Read loaded receipts
    public static StringBuilder getLoadedReceipts(){
        loadReceipts();
        return allLoadedReceipts;
    }
}   

