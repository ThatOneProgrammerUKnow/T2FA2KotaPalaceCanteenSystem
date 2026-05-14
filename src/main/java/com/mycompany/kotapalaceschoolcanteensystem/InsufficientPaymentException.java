/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kotapalaceschoolcanteensystem;

/**
 *
 * @author kobus
 */
public class InsufficientPaymentException extends RuntimeException{
    public InsufficientPaymentException(String message){
        super(message);
    }
}
