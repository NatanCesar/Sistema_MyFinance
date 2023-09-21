package MyFinance.Persistencia;

import MyFinance.Model.Despesa;
import MyFinance.Model.Receita;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {
    public static final String ARQUIVO_CONTAS = "contas.dat";

    public HashMap<Integer, Receita> recuperarReceitas() throws IOException {
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTAS));
            return (HashMap<Integer, Receita>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar as receitas");
            throw new IOException("Não foi possível recuperar os dados do arquivo "+ARQUIVO_CONTAS);

        } finally {
            if (in!=null){
                in.close();
            }
        }
    }



    public HashMap<Integer, Despesa> recuperarDespesas() throws IOException {
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTAS));
            return (HashMap<Integer, Despesa>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar as despesas");
            throw new IOException("Não foi possível recuperar os dados do arquivo "+ARQUIVO_CONTAS);

        } finally {
            if (in!=null){
                in.close();
            }
        }
    }




    public void salvarReceitas(Map<Integer, Receita> receita) throws IOException{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTAS));
            out.writeObject(receita);
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar os conta no arquivo "+ARQUIVO_CONTAS);
        }
    }

    public void salvarDespesas(Map<Integer, Despesa> despesa) throws IOException{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTAS));
            out.writeObject(despesa);
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar os conta no arquivo "+ARQUIVO_CONTAS);
        }
    }

}
