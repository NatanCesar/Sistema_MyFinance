import MyFinance.Excpetions.DespesaNaoExisteExcpetion;
import MyFinance.Excpetions.ReceitaNaoExisteExcpetion;
import MyFinance.Model.Conta;
import MyFinance.Model.Despesa;
import MyFinance.Model.Receita;
import MyFinance.Persistencia.GravadorDeDespesas;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


public class ContaTest {
    @Test
    public void testaConta(){
        Conta c = new Conta();
        assertEquals(0, c.getSaldo());
        assertEquals(0, c.getValorDespesas());
        assertEquals(0, c.getValorReceitas());
        assertEquals(0,c.getDespesas().size());
        assertEquals(0,c.getReceitas().size());
    }

    @Test
    public void testaDespesas() throws DespesaNaoExisteExcpetion {
        Conta c = new Conta();
        Despesa despesa = new Despesa("Conta de Luz",110.50,"Mês de dezembro",
                "05/01/2024","Energisa",c.getIdDespesa());
        c.adicionarDespesa(despesa);
        assertEquals(1,c.getDespesas().size());
        assertTrue(c.getDespesas().containsValue(despesa));
        c.removerDespesa(despesa.getId());
        assertFalse(c.getDespesas().containsKey(despesa.getId()));
        assertEquals(0,c.getDespesas().size());

    }

    @Test
    public void testaReceitas() throws ReceitaNaoExisteExcpetion {
        Conta c = new Conta();
        Receita receita = new Receita("Salário",1400,"dia 15",
                "Empresa RU",c.getIDReceita());
        c.adicionarReceita(receita);
        assertEquals(1,c.getReceitas().size());
        assertTrue(c.getReceitas().containsValue(receita));
        c.removerReceita(receita.getId());
        assertFalse(c.getReceitas().containsKey(receita.getId()));
        assertEquals(0,c.getReceitas().size());

    }

    @Test
    public void testaGravacaoDespesa(){
        File f = new File(GravadorDeDespesas.ARQUIVO_DESPESAS);
        if (f.exists()){
            f.delete();
        }
        Conta c = new Conta();
        c.adicionarReceita(new Receita("Salário",1400,"dia 15",
                "Empresa RU",c.getIDReceita()));
        c.salvarDados();
        assertEquals(1, c.getReceitas().size());
        assertTrue(f.exists());
        f.delete();
    }




}
