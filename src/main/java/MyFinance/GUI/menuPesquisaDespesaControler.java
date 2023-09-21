package MyFinance.GUI;

import MyFinance.Model.Conta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuPesquisaDespesaControler implements ActionListener {
    private Conta conta;
    private JFrame menu;

    public menuPesquisaDespesaControler(Conta conta, JFrame menu) {
        this.conta = conta;
        this.menu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (conta.getDespesas().size() == 0){
            JOptionPane.showMessageDialog(menu,"Nenhuma despesa cadastrada");
        } else{
            String resposta = JOptionPane.showInputDialog(menu,"1 - Ver todas as despesas \n2 - Pesquisar específica\n").toUpperCase();
            if (resposta.equals("1")) {
                JOptionPane.showMessageDialog(menu, conta.getDespesas().toString());
            } else if (resposta.equals("2")) {
                int id = Integer.parseInt(JOptionPane.showInputDialog(menu,"Qual o id da despesa que deseja pesquisar? "));
                if (conta.getDespesas().containsKey(id)){
                    JOptionPane.showMessageDialog(menu,"Despesa encontrada: \n" + conta.getDespesas().get(id).toString());
                } else {
                    JOptionPane.showMessageDialog(menu, "Não foi impossível encontrar uma despesa com o id informado.");
                }
            }
        }

    }
}
