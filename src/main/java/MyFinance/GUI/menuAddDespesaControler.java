package MyFinance.GUI;

import MyFinance.Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuAddDespesaControler implements ActionListener {
    private Conta conta;
    private JFrame menu;

    public menuAddDespesaControler(Conta conta,JFrame menu){
            this.conta = conta;
            this.menu = menu;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(menu,"Qual o nome da sua despesa? ");
        double valor = Double.parseDouble(JOptionPane.showInputDialog(menu, "Qual valor da despesa? "));
        String dataCompra = JOptionPane.showInputDialog(menu,"Qual data foi feita a despesa? ");
        String dataVencimento = JOptionPane.showInputDialog(menu,"Qual data vai vencer a despesa? ");
        String quemDevoPagar = JOptionPane.showInputDialog(menu, "A quem devo pagar a despesa? ");

        Despesa d = new Despesa(nome,valor,dataCompra,dataVencimento,quemDevoPagar, conta.getIdDespesa());
        conta.adicionarDespesa(d);

        JOptionPane.showMessageDialog(menu,"Despesa cadastrada com sucesso com o id: " + d.getId());

    }
}
