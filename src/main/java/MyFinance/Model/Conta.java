package MyFinance.Model;

import MyFinance.Excpetions.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conta implements Serializable {
    private double saldo = 0;
    private double valorDespesas = 0;
    private double valorReceitas = 0;
    private Map<Integer,Receita> receitasList;
    private Map<Integer,Despesa> despesasList;
    private int id;

    public Conta() {
        this.despesasList = new HashMap<>();
        this.receitasList = new HashMap<>();

    }

    public void adicionarDespesa(Despesa d){
        this.despesasList.put(d.getId(), d);
        this.saldo -= d.getValor();
        this.valorDespesas += d.getValor();
        this.id += 1;
    }

    public void adicionarReceita(Receita r){
        this.receitasList.put(r.getId(), r);
        this.saldo += r.getValor();
        this.valorReceitas += r.getValor();
    }

    public void removerDespesa(int idDespesa) throws DespesaNaoExisteExcpetion {
        if (despesasList.containsKey(idDespesa)){
            Despesa despesa = despesasList.get(idDespesa);
            despesasList.remove(idDespesa);
            this.valorDespesas -= despesa.getValor();
            if (this.saldo < 0){
                this.saldo += despesa.getValor();
            } else{
                this.saldo -= despesa.getValor();
            }
        } else{
            throw new DespesaNaoExisteExcpetion("Despesa não existe no sistema.");
        }
    }

    public void removerReceita(int idReceita) throws ReceitaNaoExisteExcpetion {
        if (receitasList.containsKey(idReceita)){
            Receita receita = receitasList.get(idReceita);
            receitasList.remove(idReceita);
            this.valorReceitas -= receita.getValor();
            this.saldo -= receita.getId();
        } else{
            throw new ReceitaNaoExisteExcpetion("Receita não existe no sistema.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public double getValorDespesas() {
        return valorDespesas;
    }

    public double getValorReceitas() {
        return valorReceitas;
    }

    public int getIdDespesa(){
        return despesasList.size();
    }



    public Map<Integer, Receita> getReceitas() {
        return receitasList;
    }

    public Map<Integer, Despesa> getDespesas() {
        return despesasList;
    }
}

