package com.pluralsight;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class NameFormattingFactory {
    private String prefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    private NameFormattingFactory (String prefix, String firstName, String middleName, String lastName, String suffix) {
        this.prefix = prefix;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    public static String format (String prefix, String firstName, String middleName, String lastName, String suffix) {
        int counter = 0;
        String formattedName = "";
        do {
            switch (counter) {
                case 0 -> {
                    if (lastName == null) {
                        break;
                    }
                    formattedName += lastName + ", ";
                }
                case 1 -> {
                    if (prefix == null) {
                        break;
                    }
                    formattedName += prefix + " ";
                }
                case 2 -> {
                    if (firstName == null) {
                        break;
                    }
                    formattedName += firstName + " ";
                }
                case 3 -> {
                    if (middleName == null) {
                        break;
                    }
                    formattedName += middleName + ", ";
                }
                case 4 -> {
                    if (suffix == null) {
                        break;
                    }
                    formattedName += suffix;
                }
                default -> {
                    return "Sorry, something went wrong";
                }
            }
            counter++;
        } while (counter < 5);
        return formattedName;
    }

    public static String format (String firstName, String lastName) {
        return format(null, firstName, null, lastName, null);
    }

    public static String format (String fullName) {
        String prefix = null;
        String firstName = null;
        String middleName = null;
        String lastName = null;
        String suffix = null;
        String[] fullNameSplit = fullName.split(Pattern.quote(" "));
        ArrayList<String> fullNameArray = new ArrayList<>();
        for (int i = 0; i < fullNameSplit.length; i++) {
            if (i == 0 && (fullNameSplit.length == 4 || fullNameSplit.length == 3)) {
                fullNameArray.add(null);
            }
            fullNameArray.add(fullNameSplit[i]);
            if (i == 2 && fullNameSplit.length == 3) {
                fullNameArray.add(null);
            }
        }
        prefix = fullNameArray.get(0);
        firstName = fullNameArray.get(1);
        middleName = fullNameArray.get(2);
        lastName = fullNameArray.get(3).substring(0, fullNameArray.get(3).length() - 1);
        suffix = fullNameArray.get(4);
        return format(prefix, firstName, middleName, lastName, suffix);
    }

}
