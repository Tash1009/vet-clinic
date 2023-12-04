package main.java.com.magicvet;

import main.java.com.magicvet.Client;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

   static String PASSWORD = "default";
   static Scanner scanner = new Scanner(System.in);

   static String EMAIL_PATTERN = "^[a-zA-z0-9._%+-]+@[a-zA-z0-9._]+\\.[a-zA-z]{2,}$";
   static String NAME_PATTERN = "^[a-zA-z-]{3,}$";
        public static void main(String[] args) {
            run ();
        }

   static void run () {
            if (auth()){
                registerNewClient();
            }
   }
   static boolean auth() {
        boolean accepted = false;
        for (int i=0; i<3 ; i++ ) {
            System.out.println("Pasword: ");
            String input = scanner.nextLine();

            if (PASSWORD.equals(input) ){
                accepted = true;
                break;
            }else {
                System.out.println("Access denied. Please check you password. ");
            }
        }
        System.out.println(accepted ? "welcome to the Magic Vet!" : "Aplication has been bloced.");
        return accepted;
    }
    static void registerNewClient() {
        System.out.println("Please provide client detail.");
        System.out.print("Email:");
        String email = scanner.nextLine();


        if (isEmailValid(email)) {
            System.out.print("First name: ");
            String firstName = scanner.nextLine();
            if (isNameValid(firstName)) {
                System.out.print("Last name: ");
                String lastName = scanner.nextLine();
                if (isNameValid(lastName)) {
                    Client client = buildClient(email, firstName, lastName);
                    System.out.println("New client: " + client.firstName + " " + client.lastName + " (" + client.email + ")");
                } else {
                    System.out.println("Provided last name is invalid.");
                }

            } else {
                System.out.println("Provided first name is invalid.");
            }
        } else {
            System.out.println("Provided email is invalid.");
        }
    }




   static Client buildClient(String email,String firstName, String lastName) {
       Client client = new Client();
       client.email = email;
       client.firstName = firstName;
       client.lastName = lastName;
       return client;

    }

     static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }
    static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return  matcher.matches();
    }

}