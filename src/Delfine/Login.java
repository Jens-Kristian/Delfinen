package Delfinen;
import java.util.Scanner;

public class Login {
    public boolean authenticateUser() {
        int maxAttempts = 3;
        String correctCode = "justdrown";
        String correctSecurityCode = "theydrowned";

        Scanner scanner = new Scanner(System.in);

        for (int attempts = 1; attempts <= maxAttempts; attempts++) {
            System.out.print("Log in: ");
            String userCode = scanner.nextLine();

            if (userCode.equals(correctCode)) {
                System.out.println("User authenticated. Proceed to main menu.");
                return true;
            } else if (attempts < maxAttempts) {
                System.out.println("Login failed. Try again.");
            } else {
                // Hvis det er tredje forsøg, kræv en sikkerhedskode
                System.out.print("For your own safety, enter validation code: ");
                String securityCode = scanner.nextLine();

                if (securityCode.equals(correctSecurityCode)) {
                    System.out.println("Welcome!");
                    return true;
                } else {
                    System.out.println("Login failed.");
                    break;
                }
            }
        }
        scanner.close();
        return false;
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