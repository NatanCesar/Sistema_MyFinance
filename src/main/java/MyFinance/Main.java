package MyFinance;

import MyFinance.GUI.MenuPrincipalGUI;
import MyFinance.Model.Conta;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        MenuPrincipalGUI menuPrincipal = new MenuPrincipalGUI();
        Conta myConta = new Conta();
        menuPrincipal.setVisible(true);
        menuPrincipal.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                int resp = JOptionPane.showConfirmDialog(menuPrincipal,
                        "Tem certeza de que quer sair e salvar?");
                if (resp == JOptionPane.YES_OPTION) {
                    myConta.salvarDados();
                    System.exit(0);
                }
            }
        });
        }
}


