package com.depedecyinjection;

//A singleton is a design pattern that ensures that a class has only one instance throughout the entire application and
//provides a global point of access to that instance.
//In this example, the Singleton class is implemented using the singleton pattern.
//The getInstance() method ensures that only one instance of the Singleton class is
//created throughout the entire application. The Client class receives the singleton
//instance through its constructor.
//This way, the Client class is not instantiating the Singleton class by itself,
//but is instead receiving it from an external source. This allows for flexibility
//and easy testing, as the Client class can be used with any implementation of the
//Singleton interface.

class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class Client {
    private Singleton singleton;

    public Client(Singleton singleton) {
        this.singleton = singleton;
    }

    public void run() {
        System.out.println(singleton.hashCode());
    }
}

class Application {
    public static void main(String[] args) {
        Client clientA = new Client(Singleton.getInstance());
        clientA.run(); // prints the same hashcode

        Client clientB = new Client(Singleton.getInstance());
        clientB.run(); // prints the same hashcode
    }
}
