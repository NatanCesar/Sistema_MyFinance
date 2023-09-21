package MyFinance.Model;

import java.io.Serializable;
import java.util.Objects;

public class Receita implements Serializable {
    private String nome;
    private double valor;
    private String dataRecebimento;
    private String quemVaiPagar;
    private int id;


    public Receita(String nome, double valor, String dataRecebimento, String quemTaPagando, int id) {
        this.nome = nome;
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.quemVaiPagar = quemTaPagando;
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getQuemVaiPagar() {
        return quemVaiPagar;
    }

    public void setQuemVaiPagar(String quemVaiPagar) {
        this.quemVaiPagar = quemVaiPagar;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receita receita = (Receita) o;

        if (Double.compare(receita.valor, valor) != 0) return false;
        if (!Objects.equals(dataRecebimento, receita.dataRecebimento))
            return false;
        return Objects.equals(quemVaiPagar, receita.quemVaiPagar);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(valor);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (dataRecebimento != null ? dataRecebimento.hashCode() : 0);
        result = 31 * result + (quemVaiPagar != null ? quemVaiPagar.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\nReceita: " + this.nome + ", Valor: R$" + this.valor + ", Data que vou receber: " + this.dataRecebimento +
                ", Quem vai me pagar: " + this.quemVaiPagar + ", ID: " + this.id;
    }
}
