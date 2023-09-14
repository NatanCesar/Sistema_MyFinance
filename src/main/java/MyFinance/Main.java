package MyFinance;


import MyFinance.GUI.menuPrincipal;
import MyFinance.Model.Conta;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
            Conta myConta = new Conta();
            menuPrincipal menuPrincipal = new menuPrincipal();
            menuPrincipal.setVisible(true);

        }
}


