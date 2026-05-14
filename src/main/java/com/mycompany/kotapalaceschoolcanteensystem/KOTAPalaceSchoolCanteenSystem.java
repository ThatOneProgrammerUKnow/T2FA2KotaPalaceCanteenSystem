/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.kotapalaceschoolcanteensystem;

/**
 *
 * @author kobus
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class KOTAPalaceSchoolCanteenSystem {

    // Main method
    public static void main(String[] args) {
        // Objects
        List<MenuItem> menuItems = new ArrayList<>(Arrays.asList(
                new MenuItem("Coke", 16.00),
                new MenuItem("Creme Soda", 16.00),
                new MenuItem("Pepsi", 15),
                new MenuItem("Basic Kota", 30.00),
                new MenuItem("Russian & Egg Kota", 35.00),
                new MenuItem("Full house", 40.00)
        ));
        
        menuItems = MenuItem.listMenu();
        
        List<Order> orders = new ArrayList<>();
        List<ReceiptManager> receipts = new ArrayList<>();
        
        // Declaring variables
        boolean systemRunning = true;
        double amountPaid;
        String userString;
        
        byte userInput;
        
        // =====| Main loop |=====
        System.out.println("Welcome to the Kota Palace School Canteen System!");
        
        Scanner input = new Scanner(System.in);
        while (systemRunning){
            System.out.println("""
                               What would you like to do?
                               1. Exit
                               2. List Menu
                               3. Create Order
                               4. View all saved Receipts
                               """);
            
            userInput = 0;
            boolean validInput = false;
            
            while (!validInput) {
                try {
                     userInput = input.nextByte();
                     validInput = true;
                } catch (InputMismatchException e){
                    System.err.println("Please enter a valid number");
                } finally {
                    input.nextLine();
                }
            }
            
            switch (userInput) {

                case 1 -> { //----->>> User exits
                    systemRunning = false;
                }
                
                case 2 -> { //----->>> List Menu
                    for (MenuItem item : menuItems){
                        System.out.println(item.getId() + ". " + item.getName() + " R " + item.getPrice());
                    }
                }
                
                case 3 -> { //----->>> Create Order
                    // ===| Order Selection |===
                    // --->>> List Menu items
                    System.out.println("0. Create order");
                    for (MenuItem item : menuItems){
                        System.out.println(item.getId() + ". " + item.getName() + " R " + item.getPrice());
                    }
                    
                    // --->>> Construct order
                    orders.add(new Order());
                    
                    // --->>> Add menu items to order
                    boolean addItem = true;
                    short orderUserInput;
                    
                    // user addItem in while loop to keep the loop going
                    while (addItem){
                        // User chooses menu item
                        System.out.println("Add an item to your order (Enter the number next to the item to add)");
                        orderUserInput = input.nextShort();
                        input.nextLine();
                        
                        // Exit loop 
                        if (orderUserInput == 0){
                            break;
                        }
                        
                        // Lookup chosen item and add to order 
                        try {
                            orders.getLast().addItem(MenuItem.lookup(orderUserInput)); // <- Adding menu item to orderItems
                            
                        } catch (ObjectNotFoundException e) {
                            System.err.println(e.getMessage());
                            System.out.println("Please enter a valid number, displayed in the menu list above\n");
                        }              
                    }
                    
                    // ===| Total calculation |===
                    orders.getLast().calculateTotal();
                    System.out.println("The total amount due is R " + orders.getLast().getTotal());
                    
                    // ===| Payment processing |===
                    // Accept user payment and validate payment amount (Throws InsufficientPaymentException)
                    System.out.println("Enter the amount paid: ");
                    userString = input.nextLine();
                    
                    // Validating  input
                    try {
                        amountPaid = Double.parseDouble(userString);
                        
                        // Sufficient amount
                        try {
                            orders.getLast().pay(amountPaid);
                        } catch (InsufficientPaymentException e) {
                            System.out.println(e.getMessage());
                        }
                        
                    } catch (NumberFormatException e){
                        System.err.println("Please enter a valid double amount");
                    } catch (InputMismatchException e) {
                            System.out.println("Please enter a valid double amount");
                        }
                    

                    // Calculate and display change
                    System.out.println("Your total change is: R " + orders.getLast().getChange());
                    
                    // ===| Receipt generation |===
                    receipts.add(new ReceiptManager(orders.getLast()));
                    receipts.getLast().save();
                    
                    
                }
                case 4 -> { //----->>> Loading aall receipts and printing them to the screen
                    System.out.println("===============| All saved receipts |===============");
                    System.out.println(ReceiptManager.getLoadedReceipts().toString());
                    System.out.println();
                }
            }
            System.out.println("");
        }
        input.close();
       
    }
}
