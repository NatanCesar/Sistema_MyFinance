package MyFinance.GUI;

import MyFinance.Excpetions.DespesaNaoExisteExcpetion;
import MyFinance.Excpetions.ReceitaNaoExisteExcpetion;
import MyFinance.Model.Conta;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalGUI extends JFrame {
    JLabel titulo;
    JButton consultarSaldo, ConsultarDespesaReceita;
    Conta conta = new Conta();
    JMenuBar barraDeMenu = new JMenuBar();

    public MenuPrincipalGUI() {
        setTitle("MyFinance");
        setSize(800, 600); //tamanho da janela
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.lightGray);
        titulo = new JLabel("MyFinance", JLabel.CENTER);
        titulo.setForeground(Color.green);
        titulo.setFont(new Font("Serif", Font.BOLD, 34));
        consultarSaldo = new JButton("Consultar Saldo");
        ConsultarDespesaReceita = new JButton("Consultar Valor das Receitas e Despesas");

        setLayout(new GridLayout(3, 1));
        add(titulo);
        add(consultarSaldo);
        add(ConsultarDespesaReceita);



        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarDespesa = new JMenuItem(
                "Cadastrar Despesa");
        JMenuItem menuCadastrarReceita= new JMenuItem(
                "Cadastrar Receita");
        menuCadastrar.add(menuCadastrarDespesa);
        menuCadastrar.add(menuCadastrarReceita);

        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarDespesa = new JMenuItem(
                "Pesquisar Despesa");
        JMenuItem menuPesquisarReceita = new JMenuItem(
                "Pesquisar Receita");
        menuPesquisar.add(menuPesquisarDespesa);
        menuPesquisar.add(menuPesquisarReceita);

        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverReceita = new JMenuItem(
                "Remover Receita");
        JMenuItem menuRemoverDespesa = new JMenuItem(
                "Remover Despesa");
        menuRemover.add(menuRemoverDespesa);
        menuRemover.add(menuRemoverReceita);



        menuCadastrarReceita.addActionListener(new menuAddReceitaControler(conta,this));
        menuCadastrarDespesa.addActionListener(new menuAddDespesaControler(conta,this));
        menuPesquisarDespesa.addActionListener(new menuPesquisaDespesaControler(conta,this));
        menuPesquisarReceita.addActionListener(new menuPesquisaReceitaControler(conta,this));
        consultarSaldo.addActionListener((ae) ->{
            JOptionPane.showMessageDialog(null, "R$"+conta.getSaldo());
        });
        ConsultarDespesaReceita.addActionListener((ae -> {
            JOptionPane.showMessageDialog(null,"Despesas: R$" + conta.getValorDespesas() +
                    "\nReceitas: R$" + conta.getValorReceitas());
        }));

        menuRemoverDespesa.addActionListener((ae -> {
            if(!(conta.getDespesas().size() == 0)) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Qual id da despesa? "));
                try {
                    conta.removerDespesa(id);
                    JOptionPane.showMessageDialog(null, "Despesa removida com sucesso");
                } catch (DespesaNaoExisteExcpetion e) {
                    JOptionPane.showMessageDialog(null, "ID não encontrada.");
                }
            } else{
                JOptionPane.showMessageDialog(null,"Nenhuma despesa foi cadastrada ainda.");
            }

        }));
        menuRemoverReceita.addActionListener((ae -> {
            if(!(conta.getDespesas().size() == 0)) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Qual id da receita? "));
                try {
                    conta.removerReceita(id);
                    JOptionPane.showMessageDialog(null,"Receita removida com sucesso");
                } catch (ReceitaNaoExisteExcpetion e) {
                    JOptionPane.showMessageDialog(null, "ID não encontrada.");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Nenhuma receita foi cadastrada ainda.");
            }

        }));


        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        setJMenuBar(barraDeMenu);


    }

    public static void main(String[] args) {
        JFrame janela = new MenuPrincipalGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
