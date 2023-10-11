package Utilities;

import java.util.Scanner;

public class InputFromUser {
    private Scanner input = new Scanner(System.in);
    public String getInputFromUser() {
        return input.nextLine();
    }
}
