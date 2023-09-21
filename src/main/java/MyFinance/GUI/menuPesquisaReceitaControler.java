package MyFinance.GUI;

import MyFinance.Model.Conta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuPesquisaReceitaControler implements ActionListener {
    private Conta conta;
    private JFrame menu;

    public menuPesquisaReceitaControler(Conta conta, JFrame menu) {
        this.conta = conta;
        this.menu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (conta.getReceitas().size() == 0){
            JOptionPane.showMessageDialog(menu,"Nenhuma receita cadastrada");
        } else{
            String resposta = JOptionPane.showInputDialog(menu,"1 - Ver todas as receitas \n2 - Pesquisar específica\n").toUpperCase();
            if (resposta.equals("1")) {
                JOptionPane.showMessageDialog(menu, conta.getReceitas().toString());
            } else if (resposta.equals("2")) {
                int id = Integer.parseInt(JOptionPane.showInputDialog(menu,"Qual o id da receita que deseja pesquisar? "));
                if (conta.getReceitas().containsKey(id)){
                    JOptionPane.showMessageDialog(menu,"Receita encontrada: \n" + conta.getReceitas().get(id).toString());
                } else {
                    JOptionPane.showMessageDialog(menu, "Não foi impossível encontrar uma receita com o id informado.");
                }
            }
        }

    }
}
