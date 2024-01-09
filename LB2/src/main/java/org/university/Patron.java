package org.university;

import org.apache.commons.lang3.RandomStringUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@EqualsAndHashCode
@NoArgsConstructor
@Getter

public class Patron {
    private String name;
    private String ID;
    private final List<Item> borrowedItems = new ArrayList<>();

    public Patron(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public void borrow(Item item) {
        item.borrowItem();
        borrowedItems.add(item);

    }

    public void returnItem(Item item) {
        item.returnItem();
        borrowedItems.remove(item);

    }
    static String generateRandomID(){
        return RandomStringUtils.randomNumeric(8);
    }


    @Override
    public String toString() {
        return "Patron{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", borrowedItems=" + borrowedItems +
                '}';
    }
}
