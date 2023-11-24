package Delfine;
import Delfinen.Login;
public class Main {
    public static void main(String[] args) {

        Login login = new Login();
        boolean isAuthenticated = login.authenticateUser();

        if (isAuthenticated) {
            System.out.println("Welcome!.");
            CompertitionOperation compertitionOperation = new CompertitionOperation();
            SwimmerOperation swimmerOperation = new SwimmerOperation();
            Menu menu = new Menu(compertitionOperation, swimmerOperation);

            compertitionOperation.setMenu(menu);
            swimmerOperation.setMenu(menu);

            menu.run();
        } else {
            System.out.println("Authentication failed. Exiting program.");
        }


    }
}
