package Util;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class CheckInput {
    public final String REGEX_NAME = "[a-zA-Z ]+";
    public final String REGEX_STUDENTID = "^(SE|HE|DE|QE|CE)\\d{6}$";
    public final String REGEX_PHONE = "^\\d{10}$";
    public final String REGEX_EMAIL = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
    public final String REGEX_MOUNTAINCODE = "[0-9]+";
    public final String REGEX_YESORNO = "[Y|N|y|n]";
    public final String REGEX_CAMPUSCODE = "(SE|HE|DE|QE|CE)";
    public final String REGEX_NAMEFILE = "^[A-Za-z0-9_-]+\\.[A-Za-z0-9]+$";
    public int getInteger(String message, String error, int min, int max) {
        Scanner scanner = new Scanner(System.in);

        //- Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Not is empty !");
                } else {
                    int number = Integer.parseInt(input);
                    //check number in range
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.err.println("Input must be in range " + min + "-" + max);
                    }
                }
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    public double getDouble(String message, String error, double min, double max) {
        Scanner scanner = new Scanner(System.in);

        //- Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Not is empty !");
                } else {
                    double number = Double.parseDouble(input);
                    //check number in range
                    if (number >= min && number <= max) {
                        return number;
                    } else if(number % 0.5 != 0){
                        System.out.println("Must be modulo 0.5");
                    }else {
                        System.err.println("Must be in range " + min + "-" + max);
                    }
                    
                }
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    public float getFloat(String message, String error, float min, float max) {
        Scanner scanner = new Scanner(System.in);

        //- Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Not is empty !");
                } else {
                    float number = Float.parseFloat(input);
                    //check number in range
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.err.println("Must be in range " + min + "-" + max);
                    }
                }
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    public String getString(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //nhap vao
            System.out.print(message);
            String input = scanner.nextLine();
            //kiem tra xem input co rong hay khong
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!");
            } else {
                //kiem tra xem input co matches regex hay ko
                //neu nhu matches voi regex => return string
                if (input.matches(regex)) {
                    return input;
                } else {
                    //tell error
                    System.out.println(error);
                }
            }
        }
    }
}

