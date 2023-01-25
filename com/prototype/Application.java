package com.prototype;
//Prototype is a design pattern that creates new
//objects by cloning existing ones, rather than
//creating new instances from scratch. This allows
//for efficient object creation, as it eliminates
//the need to re-create an object's state from scratch
//In this example, the Prototype class has a clone() method that
//creates a new object by copying the state of the existing object.
//The Client class receives the prototype object through its
//constructor.
//This way, the Client class is not instantiating the Prototype
//class by itself, but is instead receiving it from an external source.
//This allows for flexibility and easy testing, as the Client
//class can be used with any implementation of the Prototype
//interface.
class Prototype {
    private String state;

    public Prototype(String state) {
        this.state = state;
    }

    public Prototype clone() {
        return new Prototype(this.state);
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Client {
    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public void run() {
        Prototype newPrototype = prototype.clone();
        newPrototype.setState("Modified state");
        System.out.println(newPrototype.getState());
    }
}

class Application {
    public static void main(String[] args) {
        Client client = new Client(new Prototype("Initial state"));
        client.run();
    }
}
