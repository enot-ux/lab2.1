package org.university;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = true)

public class DVD extends Item {

    public int duration;

    @Override
    public void borrowItem() {
        if (!isBorrowed()) {
            isBorrowed = true;
            System.out.println("DVD is borrowed.");
        } else {
            System.out.println("DVD is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed()) {
            isBorrowed = false;
            System.out.println("DVD is returned.");
        } else {
            System.out.println("DVD is not currently borrowed.");
        }
    }

    public DVD(int duration, String title, String uniqueID) {
        super(title, uniqueID);
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "duration=" + duration +
                ", title='" + title + '\'' +
                ", uniqueID='" + uniqueID + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}