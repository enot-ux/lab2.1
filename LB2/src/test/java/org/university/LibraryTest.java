package org.university;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Patron testPatron;
    private Item book;
    @BeforeEach
    void setUp() {
        library = new Library();
        testPatron = new Patron("Frank",Patron.generateRandomID());
        book = new Book("Author","title",Item.generateUniqueID());
    }

    @Test
    void testRegisterPatron() {
        library.registerPatron(testPatron);
        assertTrue(library.getPatrons().contains(testPatron));
    }

    @Test
    void testLendItem() {

        library.registerPatron(testPatron);
        library.add(book);
        library.lendItem(testPatron,book);
        assertTrue(testPatron.getBorrowedItems().contains(book));
        assertTrue(book.isBorrowed);

    }

    @Test
    void testReturnItem() {
        library.registerPatron(testPatron);
        library.lendItem(testPatron,book);
        library.returnItem(testPatron,book);
        assertFalse(testPatron.getBorrowedItems().contains(book));
        assertFalse(book.isBorrowed);
    }

    @Test
    void testAddItemToLibrary() {
        library.add(book);
        assertTrue(library.getItems().contains(book));
    }

    @Test
    void testRemoveItemFromLibrary() {
        library.add(book);
        library.remove(book);
        assertFalse(library.getItems().contains(book));
    }

}