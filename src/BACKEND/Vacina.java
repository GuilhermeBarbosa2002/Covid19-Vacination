package BACKEND;

import java.io.Serializable;

/**
 *
 * @author guilh
 */
public class Vacina implements Serializable {

    public String nome;
    public String codigo;
    public String fabricante;
    public int doseIndividual;
    public RepositorioDoencas restricoes;
    public int numeroTomas;
    public int idadeMinima;
    public int idadeMaxima;
    public int tempoMinimoEntreDoses;
    public int tempoMaximoEntreDoses;
    public String efeitosSecundarios;

    /**
     *
     * @param nome
     * @param codigo
     * @param fabricante
     * @param doseIndividual
     * @param restricoes
     * @param tomas
     * @param limiteMinimo
     * @param limiteMaximo
     * @param tempoMinimoEntreDoses
     * @param tempoMaximoEntreDoses
     * @param efeitosSecundarios
     */
    public Vacina(String nome, String codigo, String fabricante, int doseIndividual, RepositorioDoencas restricoes, int tomas, int limiteMinimo, int limiteMaximo, int tempoMinimoEntreDoses, int tempoMaximoEntreDoses, String efeitosSecundarios) {
        this.nome = nome;
        this.codigo = codigo;
        this.fabricante = fabricante;
        this.doseIndividual = doseIndividual;
        this.restricoes = restricoes;
        this.numeroTomas = tomas;
        this.idadeMinima = limiteMinimo;
        this.idadeMaxima = limiteMaximo;
        this.tempoMinimoEntreDoses = tempoMinimoEntreDoses;
        this.tempoMaximoEntreDoses = tempoMaximoEntreDoses;
        this.efeitosSecundarios = efeitosSecundarios;
    }

    /**
     *
     */
    public Vacina() {
    }

    /**
     *
     * @return
     */
    public int getTempoMinimoEntreDoses() {
        return tempoMinimoEntreDoses;
    }

    /**
     *
     * @param tempoMinimoEntreDoses
     */
    public void setTempoMinimoEntreDoses(int tempoMinimoEntreDoses) {
        this.tempoMinimoEntreDoses = tempoMinimoEntreDoses;
    }

    /**
     *
     * @return
     */
    public int getTempoMaximoEntreDoses() {
        return tempoMaximoEntreDoses;
    }

    /**
     *
     * @param tempoMaximoEntreDoses
     */
    public void setTempoMaximoEntreDoses(int tempoMaximoEntreDoses) {
        this.tempoMaximoEntreDoses = tempoMaximoEntreDoses;
    }

    /**
     *
     * @return
     */
    public RepositorioDoencas getRestricoes() {
        return restricoes;
    }

    /**
     *
     * @param restricoes
     */
    public void setRestricoes(RepositorioDoencas restricoes) {
        this.restricoes = restricoes;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @return
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     *
     * @return
     */
    public double getDoseIndividual() {
        return doseIndividual;
    }

    /**
     *
     * @return
     */
    public RepositorioDoencas getRestrições() {
        return restricoes;
    }

    /**
     *
     * @return
     */
    public int getTomas() {
        return numeroTomas;
    }

    /**
     *
     * @return
     */
    public int getIdadeMinima() {
        return idadeMinima;
    }

    /**
     *
     * @return
     */
    public int getIdadeMaxima() {
        return idadeMaxima;
    }

    /**
     *
     * @return
     */
    public String getEfeitosSecundarios() {
        return efeitosSecundarios;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @param fabricante
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     *
     * @param doseIndividual
     */
    public void setDoseIndividual(int doseIndividual) {
        this.doseIndividual = doseIndividual;
    }

    /**
     *
     * @param restricoes
     */
    public void setRestrições(RepositorioDoencas restricoes) {
        this.restricoes = restricoes;
    }

    /**
     *
     * @param tomas
     */
    public void setTomas(int tomas) {
        this.numeroTomas = tomas;
    }

    /**
     *
     * @param limiteMinimo
     */
    public void setLimiteMinimo(int limiteMinimo) {
        this.idadeMinima = limiteMinimo;
    }

    /**
     *
     * @param limiteMaximo
     */
    public void setLimiteMaximo(int limiteMaximo) {
        this.idadeMaxima = limiteMaximo;
    }

    /**
     *
     * @param efeitosSecundarios
     */
    public void setEfeitosSecundarios(String efeitosSecundarios) {
        this.efeitosSecundarios = efeitosSecundarios;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Vacina{" + "nome=" + nome + ", codigo=" + codigo + ", fabricante=" + fabricante + ", doseIndividual=" + doseIndividual + ", restricoes=" + restricoes + ", tomas=" + numeroTomas + ", limiteMinimo=" + idadeMinima + ", limiteMaximo=" + idadeMaxima + ", tempoMinimoEntreDoses=" + tempoMinimoEntreDoses + ", tempoMaximoEntreDoses=" + tempoMaximoEntreDoses + ", efeitosSecundarios=" + efeitosSecundarios + '}';
    }

}
