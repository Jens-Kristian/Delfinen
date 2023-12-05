package Delfine;

public class Main {
    public static void main(String[] args) {

        Login login = new Login();
        boolean isAuthenticated = login.authenticateUser();

        if (isAuthenticated) {
            CompetitionOperation competitionOperation = new CompetitionOperation();
            SwimmerOperation swimmerOperation = new SwimmerOperation();
            Econ econ = new Econ();
            Menu menu = new Menu(competitionOperation, swimmerOperation, econ);

            competitionOperation.setMenu(menu);
            swimmerOperation.setMenu(menu);
            econ.setMenu(menu);

            menu.run();
        } else {
            System.out.println("Authentication failed. Exiting program.");
        }


    }
}
