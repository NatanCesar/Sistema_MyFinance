package MyFinance.Persistencia;

import MyFinance.Model.Receita;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeReceitas {

    public static final String ARQUIVO_RECEITAS = "receitas.dat";


    public HashMap<Integer, Receita> recuperarReceitas() throws IOException {
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_RECEITAS));
            return (HashMap<Integer, Receita>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar as receitas");
            throw new IOException("Não foi possível recuperar as receitas do arquivo "+ ARQUIVO_RECEITAS);

        } finally {
            if (in!=null){
                in.close();
            }
        }
    }


    public void salvarReceitas(Map<Integer, Receita> receita) throws IOException{

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_RECEITAS));
            out.writeObject(receita);
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar as receitas no arquivo "+ ARQUIVO_RECEITAS);
        }
    }

}
