package BACKEND;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

/*
Os utentes têm um nº de utente do Serviço Nacional de Saúde, deverá ser registado o seu
nome, morada e localidade, data de nascimento, contacto telefónico, email, centro de
vacinação ao qual são alocados, indicação se já foi administrada a vacina e qual a vacina
administrada, as datas da administração da vacina se for o caso.
 */
/**
 *
 * @author guilh
 */
public class Utente extends Utilizador implements Serializable {

    private String numSNS; // usar string, não vamos fazer contas e existem numeros que começam em 0 e se fosse int nao eram contados
    private String morada;
    private String localidade;
    private LocalDate dataNasc;
    private String numTelemovel;
    private RepositorioDoencas doencas;
    private CentroVacinacao centrovacinacao;
    private int numvacinasTomadas = 0;
    private boolean vacinado = false;
    private Vacina vacina;
    private RepositorioDatasAdministracao datasAdministracao;
    private RepositorioDoencas efeitosSecundarios;

    /**
     *
     * @param numSNS String
     * @param morada String
     * @param localidade String
     * @param dataNasc LocalDate
     * @param numTelemovel String
     * @param doencas RepositorioDoencas
     * @param centrovacinacao CentroVacinacao
     * @param vacina Vacina
     * @param dataAdministracao RepositorioDatasAdministracao
     * @param username String
     * @param password String
     * @param email String
     * @param nome String
     */
    public Utente(String numSNS, String morada, String localidade, LocalDate dataNasc, String numTelemovel, RepositorioDoencas doencas, CentroVacinacao centrovacinacao, Vacina vacina, RepositorioDatasAdministracao dataAdministracao, String username, String password, String email, String nome) {
        super(username, password, email, nome);
        this.numSNS = numSNS;
        this.morada = morada;
        this.localidade = localidade;
        this.dataNasc = dataNasc;
        this.numTelemovel = numTelemovel;
        this.doencas = doencas;
        this.centrovacinacao = null;
        this.vacina = null;
        this.datasAdministracao = new RepositorioDatasAdministracao();
        this.efeitosSecundarios = new RepositorioDoencas();
    }

    public Utente() {
    }

    /**
     *
     * @return LocalDate
     */
    public LocalDate getDataNasc() {
        return dataNasc;
    }

    /**
     *
     * @param dataNasc LocalDate
     */
    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    /**
     *
     * @return RepositorioDoencas
     */
    public RepositorioDoencas getEfeitosSecundarios() {
        return efeitosSecundarios;
    }

    /**
     *
     * @param efeitosSecundarios RepositorioDoencas
     */
    public void setEfeitosSecundarios(RepositorioDoencas efeitosSecundarios) {
        this.efeitosSecundarios = efeitosSecundarios;
    }

    /**
     *
     * @return boolean
     */
    public boolean isVacinado() {
        return vacinado;
    }

    /**
     *
     * @param vacinado boolean
     */
    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }

    /**
     *
     * @return String
     */
    public String getNumSNS() {
        return numSNS;
    }

    /**
     *
     * @param numSNS String
     */
    public void setNumSNS(String numSNS) {
        this.numSNS = numSNS;
    }

    /**
     *
     * @return String
     */
    public String getMorada() {
        return morada;
    }

    /**
     *
     * @param morada String
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     *
     * @return String
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     *
     * @param localidade String
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     *
     * @return String
     */
    public String getNumTelemovel() {
        return numTelemovel;
    }

    /**
     *
     * @param numTelemovel String
     */
    public void setNumTelemovel(String numTelemovel) {
        this.numTelemovel = numTelemovel;
    }

    /**
     *
     * @return RepositorioDoencas
     */
    public RepositorioDoencas getDoencas() {
        return doencas;
    }

    /**
     *
     * @param doencas RepositorioDoencas
     */
    public void setDoencas(RepositorioDoencas doencas) {
        this.doencas = doencas;
    }

    /**
     *
     * @return CentroVacinacao
     */
    public CentroVacinacao getCentrovacinacao() {
        return centrovacinacao;
    }

    /**
     *
     * @param centrovacinacao CentroVacinacao
     */
    public void setCentrovacinacao(CentroVacinacao centrovacinacao) {
        this.centrovacinacao = centrovacinacao;
    }

    /**
     *
     * @return Vacina
     */
    public Vacina getVacina() {
        return vacina;
    }

    /**
     *
     * @param vacina Vacina
     */
    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    /**
     *
     * @return RepositorioDatasAdministracao
     */
    public RepositorioDatasAdministracao getDatasAdministracao() {
        return datasAdministracao;
    }

    /**
     *
     * @param dataAdministracao RepositorioDatasAdministracao
     */
    public void setDataAdministracao(RepositorioDatasAdministracao dataAdministracao) {
        this.datasAdministracao = dataAdministracao;
    }

    /**
     *
     * @param numvacinasTomadas int
     */
    public void setNumvacinasTomadas(int numvacinasTomadas) {
        this.numvacinasTomadas = numvacinasTomadas;
    }

    /**
     *
     * @return int
     */
    public int getNumvacinasTomadas() {
        return numvacinasTomadas;
    }

    /**
     *
     * @return CentroVacinacao
     */
    public CentroVacinacao consultarCentroVacinacao() {
        return getCentrovacinacao();
    }

    /**
     *
     * @return int
     */
    public int calcularIdade() {
        LocalDate hoje = LocalDate.now();
        int idade = Period.between(dataNasc, hoje).getYears();
        return idade;
    }

}
