package caseStudy.services.iml;

import java.util.Scanner;

public class CommonCheck {

    private static final Scanner sc = new Scanner(System.in);

    public static int checkParseInteger() {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.print("Sai định dạng, nhập lại:");
            }
        }
        return value;
    }

    private static final String REGEX_POINT = "^[A-Z]{2}-\\d{3}$";

    public static String checkRegexPoint() {
        String value = sc.nextLine();
        while (!value.matches(REGEX_POINT)) {
            System.err.print("Sai định dạng, nhập lại: ");
            value = sc.nextLine();
        }
        return value;
    }
}
