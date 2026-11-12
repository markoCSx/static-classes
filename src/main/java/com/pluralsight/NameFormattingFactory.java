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
                    if (lastName.isEmpty()) {
                        throw new IllegalArgumentException("Last name not found.");
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
                    if (firstName.isEmpty()) {
                        throw new IllegalArgumentException("First name not found.");
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
        for (int i = 0; i < fullNameArray.size(); i++) {
            switch (i) {
                case 0 -> prefix = fullNameArray.get(i);
                case 1 -> firstName = fullNameArray.get(i);
                case 2 -> middleName = fullNameArray.get(i);
                case 3 -> lastName = fullNameArray.get(i).substring(0, fullNameArray.get(i).length() - 1);
                case 4 -> suffix = fullNameArray.get(i);
            }
        }

        return format(prefix, firstName, middleName, lastName, suffix);
    }

}
