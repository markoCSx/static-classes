package com.pluralsight;

public class NameFormattingFactory {
    private String prefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;


    public static String formatter (String prefix, String firstName, String middleName, String lastName, String suffix) {
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
        return formatter(null, firstName, null, lastName, null);
    }

}
