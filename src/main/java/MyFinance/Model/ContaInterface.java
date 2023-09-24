package MyFinance.Model;

import MyFinance.Excpetions.DespesaNaoExisteExcpetion;
import MyFinance.Excpetions.ReceitaNaoExisteExcpetion;

import java.io.Serializable;
import java.util.Map;

public interface ContaInterface extends Serializable {
    void adicionarDespesa(Despesa d);

    void adicionarReceita(Receita r);

    void removerDespesa(int idDespesa) throws DespesaNaoExisteExcpetion;

    void removerReceita(int idReceita) throws ReceitaNaoExisteExcpetion;

    double getSaldo();

    double getValorDespesas();

    double getValorReceitas();

    int getIdDespesa();

    int getIDReceita();

    Map<Integer, Receita> getReceitas();

    Map<Integer, Despesa> getDespesas();

    void salvarDados();

    void recuperaDados();
}
