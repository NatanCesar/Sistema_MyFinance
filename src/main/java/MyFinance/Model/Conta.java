package MyFinance.Model;

import MyFinance.Excpetions.*;

import java.util.HashMap;
import java.util.Map;

public class Conta {
    private double saldo;
    private double valorDespesas;
    private double valorReceitas;
    private Map<Integer,Receita> receitasList;
    private Map<Integer,Despesa> despesasList;

    public Conta() {
        this.despesasList = new HashMap<>();
        this.receitasList = new HashMap<>();
    }

    public void adicionarDespesa(Despesa d){
        this.despesasList.put(d.getId(), d);
        this.saldo -= d.getValor();
        this.valorDespesas += d.getValor();
    }

    public void adicionarReceita(Receita r){
        this.receitasList.put(r.getId(), r);
        this.saldo += r.getValor();
        this.valorReceitas += r.getValor();
    }

    public void removerDespesa(int idDespesa) throws DespesaNaoExisteExcpetion {
        if (despesasList.containsKey(idDespesa)){
            despesasList.remove(idDespesa);
            Despesa despesa = despesasList.get(idDespesa);
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
            receitasList.remove(idReceita);
            Receita receita = receitasList.get(idReceita);
            this.valorReceitas -= receita.getValor();
            this.saldo -= receita.getId();
        } else{
            throw new ReceitaNaoExisteExcpetion("Receita não existe no sistema.");
        }
    }


}

