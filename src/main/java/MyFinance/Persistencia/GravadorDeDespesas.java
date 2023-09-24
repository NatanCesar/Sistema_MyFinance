package MyFinance.Persistencia;

import MyFinance.Model.Despesa;
import MyFinance.Model.Receita;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDespesas {
    public static final String ARQUIVO_DESPESAS = "despesas.dat";



    public HashMap<Integer, Despesa> recuperarDespesas() throws IOException {

        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_DESPESAS));
            return (HashMap<Integer, Despesa>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar as despesas");
            throw new IOException("Não foi possível recuperar as despesas do arquivo: "+ARQUIVO_DESPESAS);

        } finally {
            if (in!=null){
                in.close();
            }
        }
    }




    public void salvarDespesas(Map<Integer, Despesa> despesa) throws IOException{

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DESPESAS));
            out.writeObject(despesa);
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar as despesas no arquivo "+ARQUIVO_DESPESAS);
        }
    }

}
