package com.methodreference;


interface Sayable{  
    void say();  
}  
public class Instancemethod {  
    public void saySomething(){  
        System.out.println("Hello, this is non-static method.");  
    }  
    public static void main(String[] args) {  
        Instancemethod methodReference = new Instancemethod(); // Creating object  
        // Referring non-static method using reference  
            Sayable sayable = methodReference::saySomething;  
        // Calling interface method  
            sayable.say();  
            // Referring non-static method using anonymous object  
            Sayable sayable2 = new Instancemethod()::saySomething; // You can use anonymous object also  
            // Calling interface method  
            sayable2.say();  
    }  
}