package MyFinance.Model;

import java.io.Serializable;
import java.util.Objects;

public class Despesa implements Serializable {
    private String nome;
    private double valor;
    private String dataDaCompra;
    private String dataVencimento;
    private String quemDevoPagar;
    private int id;

    public Despesa(String nome, double valor, String dataDaCompra, String dataVencimento, String quemDevoPagar, int id) {
        this.nome = nome;
        this.valor = valor;
        this.dataDaCompra = dataDaCompra;
        this.dataVencimento = dataVencimento;
        this.quemDevoPagar = quemDevoPagar;
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(String dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getQuemDevoPagar() {
        return quemDevoPagar;
    }

    public void setQuemDevoPagar(String quemDevoPagar) {
        this.quemDevoPagar = quemDevoPagar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Despesa despesa = (Despesa) o;

        if (Double.compare(despesa.valor, valor) != 0) return false;
        if (!Objects.equals(dataDaCompra, despesa.dataDaCompra))
            return false;
        if (!Objects.equals(dataVencimento, despesa.dataVencimento))
            return false;
        return Objects.equals(quemDevoPagar, despesa.quemDevoPagar);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(valor);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (dataDaCompra != null ? dataDaCompra.hashCode() : 0);
        result = 31 * result + (dataVencimento != null ? dataVencimento.hashCode() : 0);
        result = 31 * result + (quemDevoPagar != null ? quemDevoPagar.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\nDespesa: " + this.nome + "| Valor : R$" + this.valor + "| Data da compra: " + this.dataDaCompra + "| Data do vencimento: "
                + this.dataVencimento + "| A quem devo pagar: " + this.quemDevoPagar + "| ID: " + this.id;
    }
}
