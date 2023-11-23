package Delfine;

import java.util.Scanner;

public class Login {
    public void performLogin() {
        int maxAttempts = 3;
        String correctCode = "justdrown";

        try (Scanner scanner = new Scanner(System.in)) {
            for (int attempts = 1; attempts <= maxAttempts; attempts++) {
                System.out.print("Log in: ");
                String userCode = scanner.nextLine();

                if (userCode.equals(correctCode)) {
                    System.out.println("Welcome!");
                    break;
                } else if (attempts < maxAttempts) {
                    System.out.println("Login failed. Try again.");
                } else {
                    System.out.print("For your own safety, enter validationcode: ");
                    String securityCode = scanner.nextLine();

                    String correctSecurityCode = "theydrowned";

                    if (securityCode.equals(correctSecurityCode)) {

                        System.out.println("Welcome!");
                        Menu menu = new Menu();
                        menu.run();
                    } else {
                        System.out.println("Login failed.");
                    }
                }
            }
        }
    }
}

/*
public class Login {

    public Login {
        this.main = main;
        password = new Password();
    }

    public void loginAdmin() {
        while (main.isRunning()) {
            (...)
        }
    }

    public void loginAdmin() {
        UI.println("Enter password");
        UI.promptString();
        password.checkPassword(UI.promptString(), "drowningkids");
        while (password.isPasswordCorrect() && main.isRunning()) {
            showMenu.showHarryMenu();
        }
        if (!password.isPasswordCorrect()) {
            main.setRunning(false);
        }
    }

    public void loginCash(Main.main) {
        UI.println("Enter password");
        UI.promptString();
        password.checkPassword(UI.promptString(), "oldmandrowned");
        while (password.isPasswordCorrect() && main.isRunning()) {
        }
        if (!password.isPasswordCorrect()) {
            main.setRunning(false);

            public void loginCoach () {
                UI.println("Enter password");
                UI.promptString();
                password.checkPassword(UI.promptString(), "fuck");
                while (password.isPasswordCorrect() && main.isRunning()) {
                    showMenu.showAccountantMenu();
                }
                if (!password.isPasswordCorrect()) {
                    main.setRunning(false);
                }
            }
        }
    }
}

 */