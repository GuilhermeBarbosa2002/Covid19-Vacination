package BACKEND;

import java.io.Serializable;
import java.time.LocalDate;

/*
 Cada centro de vacinação tem um código, uma morada, incluindo a localidade, um gestor, um
número de postos de atendimento, stock de cada tipo de vacinas, uma agenda de marcações.
 */
/**
 *
 * @author guilh
 */
public class CentroVacinacao implements Serializable {

    private String codigo;
    private String morada;
    private String localidade;
    private Gestor gestor;
    private StockVacinas stockvacinas;
    private int numeroPostosAtendimento;
    private RepositorioVacinas listavacinas;
    private Marcacao agendaMarcacoes;
    private int numeroMaximoVacinacaoPorDia;
    private long numVacinasAdministradas = 0;
    private Marcacao faltasVacinacao;

    /**
     *
     */
    public CentroVacinacao() {
    }

    /**
     *
     * @param codigo String
     * @param morada String
     * @param localidade String
     * @param gestor Gestor
     * @param stockvacinas StockVacinas
     * @param numeroPostosAtendimento String
     * @param listavacinas RepositorioVacinas
     * @param agendaMarcacoes Marcacao
     * @param numeroMaximoVacinacaoPorDia int
     */
    public CentroVacinacao(String codigo, String morada, String localidade, Gestor gestor, StockVacinas stockvacinas, int numeroPostosAtendimento, RepositorioVacinas listavacinas, Marcacao agendaMarcacoes, int numeroMaximoVacinacaoPorDia) {
        this.codigo = codigo;
        this.morada = morada;
        this.localidade = localidade;
        this.gestor = gestor;
        this.stockvacinas = stockvacinas;
        this.numeroPostosAtendimento = numeroPostosAtendimento;
        this.listavacinas = listavacinas;
        this.agendaMarcacoes = agendaMarcacoes;
        this.numeroMaximoVacinacaoPorDia = numeroMaximoVacinacaoPorDia;
        this.faltasVacinacao = new Marcacao();
    }

    /**
     *
     * @return long
     */
    public long getNumVacinasAdministradas() {
        return numVacinasAdministradas;
    }

    /**
     *
     * @param numVacinasAdministradas int
     */
    public void setNumVacinasAdministradas(int numVacinasAdministradas) {
        this.numVacinasAdministradas = numVacinasAdministradas;
    }

    /**
     *
     * @return Marcacao
     */
    public Marcacao getFaltasVacinacao() {
        return faltasVacinacao;
    }

    /**
     *
     * @param faltasVacinacao Marcacao
     */
    public void setFaltasVacinacao(Marcacao faltasVacinacao) {
        this.faltasVacinacao = faltasVacinacao;
    }

    /**
     *
     */
    public class LimiteMarcacoesUltrapassado extends Exception implements Serializable {

        /**
         *
         */
        public LimiteMarcacoesUltrapassado() {
        }

        /**
         *
         * @param message String
         */
        public LimiteMarcacoesUltrapassado(String message) {
            super(message);
        }
    }

    /**
     *
     * @return String
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @return RepositorioVacinas
     */
    public RepositorioVacinas getListavacinas() {
        return listavacinas;
    }

    /**
     *
     * @param listavacinas RepositorioVacinas
     */
    public void setListavacinas(RepositorioVacinas listavacinas) {
        this.listavacinas = listavacinas;
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
     * @return String
     */
    public StockVacinas getStockvacinas() {
        return stockvacinas;
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
     * @return Gestor
     */
    public Gestor getGestor() {
        return gestor;
    }

    /**
     *
     * @return int
     */
    public int getNumeroPostosAtendimento() {
        return numeroPostosAtendimento;
    }

    /**
     *
     * @return Marcacao
     */
    public Marcacao getAgendaMarcacoes() {
        return agendaMarcacoes;
    }

    /**
     *
     * @return int
     */
    public int getNumeroMaximoVacinacaoPorDia() {
        return numeroMaximoVacinacaoPorDia;
    }

    /**
     *
     * @param codigo String
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * @param localidade String
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     *
     * @param gestor Gestor
     */
    public void setGestor(Gestor gestor) {
        if (gestor.getCentroVacinacao() == null) {
            this.gestor = gestor;
        } else {
            this.gestor = null;
        }
    }

    /**
     *
     * @param stockvacinas StockVacinas
     */
    public void setStockvacinas(StockVacinas stockvacinas) {
        this.stockvacinas = stockvacinas;
    }

    /**
     *
     * @param numeroPostosAtendimento int
     */
    public void setNumeroPostosAtendimento(int numeroPostosAtendimento) {
        this.numeroPostosAtendimento = numeroPostosAtendimento;
    }

    /**
     *
     * @param agendaMarcacoes Marcacao
     */
    public void setAgendaMarcacoes(Marcacao agendaMarcacoes) {
        this.agendaMarcacoes = agendaMarcacoes;
    }

    /**
     *
     * @param numeroMaximoVacinacaoPorDia int
     */
    public void setNumeroMaximoVacinacaoPorDia(int numeroMaximoVacinacaoPorDia) {
        this.numeroMaximoVacinacaoPorDia = numeroMaximoVacinacaoPorDia;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "CentroVacinacao{" + "codigo=" + codigo + ", morada=" + morada + ", localidade=" + localidade + ", gestor=" + gestor + ", stockvacinas=" + stockvacinas + ", numeroPostosAtendimento=" + numeroPostosAtendimento + ", listavacinas=" + listavacinas + ", agendaMarcacoes=" + agendaMarcacoes + ", numeroMaximoVacinacaoPorDia=" + numeroMaximoVacinacaoPorDia + '}';
    }

    /**
     *
     * @param data LocalDate
     * @return int
     */
    public int getTotalMarcacoesPorData(LocalDate data) {
        return getAgendaMarcacoes().calcularNumeroMarcacoes(data);
    }

    /**
     * <h2>MARCAÇÃO</h2>
     * Para fazer uma marcação, precisamos de verificar se o limite de marcações
     * ainda não foi ultrapassado, só depois podemos fazer a marcação. Se não
     * for possivel, é atirado um erro.
     *
     * @param data LocalDate
     * @param utente Utente
     * @throws Marcacao.MarcacaoJaExistente Marcacao.MarcacaoJaExistente
     * @throws LimiteMarcacoesUltrapassado LimiteMarcacoesUltrapassado
     */
    public void fazerMarcacao(LocalDate data, Utente utente) throws Marcacao.MarcacaoJaExistente, LimiteMarcacoesUltrapassado {
      /*  if (agendaMarcacoes.calcularNumeroMarcacoes(data) > numeroMaximoVacinacaoPorDia) {
            agendaMarcacoes.adicionar(data, utente);
        } else {
            throw new LimiteMarcacoesUltrapassado("ERRO! O numero máximo de marcações permitido é  " + numeroMaximoVacinacaoPorDia + " marcações");
        }*/

    }

    /**
     * <h1>REMOVER MARCAÇÃO</h1>
     * Dada uma marcação existente, removemos a marcação!
     *
     * @param data LocalDate
     * @param utente Utente
     */
    public void removerMarcacao(LocalDate data, Utente utente) {
        agendaMarcacoes.remover(data, utente);
    }

    /**
     * Verificamos se existe marcação para um utente em certo dia
     *
     * @param data LocalDate
     * @param utente Utente
     * @return boolean
     */
    public boolean existeMarcacao(LocalDate data, Utente utente) {
        return agendaMarcacoes.existeMarcacao(data, utente);
    }

    /**
     * <h2>VACINAR</h2>
     * <ul>
     * <li>Precisamos da data atual para passarmos a data de administração ao
     * utente</li>
     * <li> Se o número de tomas da vacina for maior ao numero de vacinas
     * tomadas pelo utente, podemos vacinar. Se o utente já tiver todas as tomas
     * tomadas, não podemos vacinar</li>
     * <li> Se a quantidade de vacinas em stock for maior que 0, podemos
     * administrar a vacina, se o stock for 0, não podemos vacinar!</li>
     * <li>Vacinamos, removendo uma unidade ao stock da vacina administrada, e
     * fazemos associamis a vacina ao utente! </li>
     * <li>Somamos uma unidade às vacinas administradas no centro (para vermos a
     * estatistica no fim), e somamos uma unidade ao número de vacinas tomadas
     * pelo utente</li>
     * <li>Se o número de tomas da vacina for igual ao numero de de vacinas
     * tomadas pelo utente, este fica vacinado!</li>
     * </ul>
     *
     * @param utente Utente
     * @param vacina Vacina
     */
    public void Vacinar(Utente utente, Vacina vacina) {
        LocalDate hoje = LocalDate.now();
        if (vacina.getTomas() > utente.getNumvacinasTomadas()) {

            long quantidadeVacinas = stockvacinas.stockDisponivel(vacina);

            if (quantidadeVacinas > 0) {
                stockvacinas.RemoverVacinas(vacina, 1);
                utente.setVacina(vacina);
                numVacinasAdministradas++;
                utente.setNumvacinasTomadas(utente.getNumvacinasTomadas() + 1);
                utente.getDatasAdministracao().adicionar(hoje);
                if (vacina.getTomas() == utente.getNumvacinasTomadas()) {
                    utente.setVacinado(true);
                }

            } else {
                System.err.println("ERRO! Vacina esgotada!");
            }
        } else {
            System.out.println("Utente já está vacinado");
        }

    }
}
