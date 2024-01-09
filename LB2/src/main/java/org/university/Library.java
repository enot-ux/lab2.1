package org.university;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
@EqualsAndHashCode

public class Library implements IManageable {
    private final List<Item> items = new ArrayList<>();
    private final List<Patron> patrons = new ArrayList<>();
    public void registerPatron(Patron patron){
        patrons.add(patron);

    }

    public void lendItem(Patron patron, Item item){
        if(!patrons.contains(patron)){
            System.err.println("Patron is not registered!");

        }
        else if(!items.contains(item)){
            System.err.println("No a such book in a library!");

        }
        else {
            patron.borrow(item);
        }


    }
    public void returnItem(Patron patron, Item item){
        if(!patrons.contains(patron)){
            System.err.println("Patron is not registered!");

        }
        else if(!items.contains(item)){
            System.err.println("No a such book in a library!");

        }
        else {
            patron.returnItem(item);
        }


    }
    public void add(Item item){
        if(items.contains(item)){
            System.err.println("This book already exist");

        }
        else{
            items.add(item);
            System.out.println("Item was successfully added");
        }


    }
    public void remove(Item item){

        if(!items.contains(item)){
            System.err.println("No a such book in a library!");

        }
        else{
            items.remove(item);
            System.out.println("Item was successfully removed");
        }

    }
    public void listAvailable(){
        items.stream()
                .filter(item -> !item.isBorrowed)
                .forEach(System.out::println);
    }
    public void listBorrowed(){
        items.stream()
                .filter(item -> item.isBorrowed)
                .forEach(System.out::println);
    }
}
