package MyFinance.Model;

import MyFinance.Excpetions.*;
import MyFinance.Persistencia.GravadorDeDespesas;
import MyFinance.Persistencia.GravadorDeReceitas;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Conta implements ContaInterface {
    private double saldo = 0;
    private double valorDespesas = 0;
    private double valorReceitas = 0;
    private Map<Integer,Receita> receitasList;
    private Map<Integer,Despesa> despesasList;
    private int id;
    private GravadorDeDespesas gravadorDeDespesas = new GravadorDeDespesas();
    private GravadorDeReceitas gravadorDeReceitas = new GravadorDeReceitas();


    public Conta() {
        receitasList = new HashMap<>();
        despesasList = new HashMap<>();
        recuperaDados();

    }

    @Override
    public void adicionarDespesa(Despesa d){
        this.despesasList.put(d.getId(), d);
        this.saldo -= d.getValor();
        this.valorDespesas += d.getValor();
        this.id += 1;
    }

    @Override
    public void adicionarReceita(Receita r){
        this.receitasList.put(r.getId(), r);
        this.saldo += r.getValor();
        this.valorReceitas += r.getValor();
        this.id =+ 1;
    }

    @Override
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

    @Override
    public void removerReceita(int idReceita) throws ReceitaNaoExisteExcpetion {
        if (receitasList.containsKey(idReceita)){
            Receita receita = receitasList.get(idReceita);
            receitasList.remove(idReceita);
            this.valorReceitas -= receita.getValor();
            this.saldo -= receita.getValor();
        } else{
            throw new ReceitaNaoExisteExcpetion("Receita não existe no sistema.");
        }
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public double getValorDespesas() {
        return valorDespesas;
    }

    @Override
    public double getValorReceitas() {
        return valorReceitas;
    }

    @Override
    public int getIdDespesa(){
        return despesasList.size();
    }

    @Override
    public int getIDReceita(){ return receitasList.size();};

    @Override
    public Map<Integer, Receita> getReceitas() {
        return receitasList;
    }

    @Override
    public Map<Integer, Despesa> getDespesas() {
        return despesasList;
    }

    @Override
    public void salvarDados(){
        try {
            this.gravadorDeDespesas.salvarDespesas(this.despesasList);
            this.gravadorDeReceitas.salvarReceitas(this.receitasList);
        } catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    @Override
    public void recuperaDados(){
        try {
            this.despesasList = this.gravadorDeDespesas.recuperarDespesas();
            this.receitasList = this.gravadorDeReceitas.recuperarReceitas();
            for (Receita r: receitasList.values()){
                this.saldo += r.getValor();
                this.valorReceitas += r.getValor();
                this.id =+ 1;
            }
            for (Despesa d: despesasList.values()){
                this.despesasList.put(d.getId(), d);
                this.saldo -= d.getValor();
                this.valorDespesas += d.getValor();
                this.id += 1;
            }
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}

