package MyFinance;

import MyFinance.GUI.MenuPrincipalGUI;
import MyFinance.Model.Conta;

public class Main {
    public static void main(String[] args) {
        MenuPrincipalGUI menuPrincipal = new MenuPrincipalGUI();
        Conta myConta = new Conta();
        menuPrincipal.setVisible(true);
        }
}


