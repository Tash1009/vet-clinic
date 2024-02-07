package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String EMAIL_PATTERN = "^[a-zA-z0-9._%+-]+@[a-zA-z0-9._]+\\.[a-zA-z]{2,}$";
    private static final String NAME_PATTERN = "^[a-zA-z-]{3,}$";

    public Client registerNewClient() {
        Client client = null;

        System.out.println("Please provide client detail.");
        System.out.print("Email:");
        String email = Main.scanner.nextLine();


        if (isEmailValid(email)) {

            System.out.print("First name: ");
            String firstName = Main.scanner.nextLine();
            if (isNameValid(firstName)) {
                System.out.print("Last name: ");
                String lastName = Main.scanner.nextLine();
                if (isNameValid(lastName)) {
                    client = buildClient(email, firstName, lastName);
                    System.out.println("New client: " + client.getFirstName() + " "
                            + client.getLastName() + " ("
                            + client.getEmail() + ")");
                } else {
                    System.out.println("Provided last name is invalid.");
                }

            } else {
                System.out.println("Provided first name is invalid.");
            }
        } else {
            System.out.println("Provided email is invalid.");
        }
        return client;
    }

   private static Client buildClient(String email,String firstName, String lastName) {
        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);

       System.out.print("Location: ");

       Client.Location location;
       String locationInput = Main.scanner.nextLine();
       try {
           location = Client.Location.valueOf(locationInput);
       } catch (IllegalArgumentException e){
           location = Client.Location.UNKNOW;
           System.out.println("Unable to parse value ' " + locationInput
                   + " '. Using default value: " + Client.Location.UNKNOW);
       }
       client.setLocation(location);


        return client;
    }

   private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }
   private static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return  matcher.matches();
    }

}
