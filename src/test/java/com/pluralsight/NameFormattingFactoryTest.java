package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;

class NameFormattingFactoryTest {

    @org.junit.jupiter.api.Test
    void format() {
        //testing fullName method
        System.out.println(NameFormattingFactory.format("Mr. Martin Marty Kolaj, Phd"));
        //testing if it works with no spaces
        System.out.println(NameFormattingFactory.format("martin"));
    }

    @org.junit.jupiter.api.Test
    void testFormat() {
        //testing firstname lastname method
        System.out.println(NameFormattingFactory.format("Martin", "Kolaj"));
    }

    @org.junit.jupiter.api.Test
    void testFormat1() {
        //testing all individual parts method
        System.out.println(NameFormattingFactory.format("Mr.", "Martin", "Marty", "Kolaj", "Phd"));

    }
}