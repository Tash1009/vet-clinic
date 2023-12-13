package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;

public class Authenticator {
  private static final String PASSWORD = "d";
   public static boolean auth() {
        boolean accepted = false;
        for (int i=0; i<3 ; i++ ) {
            System.out.print("Pasword: ");
            String input = Main.scanner.nextLine();

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

}
