package MyFinance.GUI;
import javax.swing.*;
import java.awt.*;

public class menuPrincipal extends JFrame {
    JLabel titulo;
    JButton criarDespesaButton, criarReceitaButton, PesquisarButton, AlterarButton, ApagarButton;
    JMenuBar barraMenu = new JMenuBar();

    public menuPrincipal(){

        setTitle("MyFinance");
        setSize(800,600);
        setLocation(150,150);
        setResizable(false);
        setBackground(Color.white);
        setLayout(new GridLayout(3,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        titulo = new JLabel("MyFinance!");

        add(titulo);



        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarReceita = new JMenuItem("Cadastrar nova Receita");
        JMenuItem menuCadastrarDivida = new JMenuItem("Cadastrar nova Divida");
        menuCadastrar.add(menuCadastrarDivida);
        menuCadastrar.add(menuCadastrarReceita);


        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarReceita = new JMenuItem("Pesquisar Receita");
        JMenuItem menuPesquisarDivida = new JMenuItem("Pesquisar Divida");
        menuPesquisar.add(menuPesquisarReceita);
        menuPesquisar.add(menuPesquisarDivida);





    }
}
