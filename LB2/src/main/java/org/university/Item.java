package org.university;
import lombok.*;
@Data
@NoArgsConstructor


public abstract class Item {
    protected String title;
    protected String uniqueID;
    protected boolean isBorrowed;

    abstract void borrowItem();
    abstract void returnItem();


    public Item(String title, String uniqueID) {
        this.title = title;
        this.uniqueID = uniqueID;
    }
}
