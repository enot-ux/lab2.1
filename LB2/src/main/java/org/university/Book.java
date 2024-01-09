package org.university;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = true)
public class Book extends Item {

    public String author;

    @Override
    public void borrowItem() {
        if (!isBorrowed()) {
            isBorrowed = true;
            System.out.println("Book is borrowed.");
        } else {
            System.out.println("Book is not currently borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed()) {
            isBorrowed = false;
            System.out.println("Book is returned.");
        } else {
            System.out.println("Book is not currently borrowed.");
        }
    }

    public Book(String author, String title, String uniqueID) {
        super(title, uniqueID);
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", uniqueID='" + uniqueID + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}
