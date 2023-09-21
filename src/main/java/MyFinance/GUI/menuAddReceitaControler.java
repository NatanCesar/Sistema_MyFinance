package MyFinance.GUI;

import MyFinance.Model.Conta;
import MyFinance.Model.Despesa;
import MyFinance.Model.Receita;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuAddReceitaControler implements ActionListener {
    private Conta conta;
    private JFrame menu;

    public menuAddReceitaControler(Conta conta,JFrame menu){
        this.conta = conta;
        this.menu = menu;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(menu,"Qual o nome da sua receita? ");
        double valor = Double.parseDouble(JOptionPane.showInputDialog(menu, "Qual valor da receita? "));
        String dataCompra = JOptionPane.showInputDialog(menu,"Qual data vou receber essa receita? ");
        String quemVouReceber = JOptionPane.showInputDialog(menu, "Quem vai me pagar essa receita? ");

        Receita d = new Receita(nome,valor,dataCompra,quemVouReceber, conta.getIdDespesa());
        conta.adicionarReceita(d);

        JOptionPane.showMessageDialog(menu,"Receita cadastrada com sucesso com o id: " + d.getId());
    }
}
