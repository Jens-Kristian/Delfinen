package Delfine;

public class Main {
    public static void main(String[] args) {
        CompertitionOperation compertitionOperation = new CompertitionOperation();
        SwimmerOperation swimmerOperation = new SwimmerOperation();
        Menu menu = new Menu(compertitionOperation, swimmerOperation);


        compertitionOperation.setMenu(menu);
        swimmerOperation.setMenu(menu);

        menu.run();
    }
}
