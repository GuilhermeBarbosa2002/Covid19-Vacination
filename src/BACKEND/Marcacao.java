package BACKEND;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author guilh
 */
public class Marcacao implements Serializable {

    private HashMap<LocalDate, ArrayList<Utente>> repositorioMarcacoes; //repositorio vai guardar as marcações 

    /**
     * Construtor
     */
    public Marcacao() {
        repositorioMarcacoes = new HashMap();
    }

    /**
     *
     * @param repositorioMarcacoes HashMap de LocalDate, ArrayList de Utentes
     */
    public Marcacao(HashMap<LocalDate, ArrayList<Utente>> repositorioMarcacoes) {
        this.repositorioMarcacoes = repositorioMarcacoes;
    }

    /**
     *
     * @return HashMap de LocalDate, ArrayList de Utentes
     */
    public HashMap<LocalDate, ArrayList<Utente>> getRepositorioMarcacoes() {
        return repositorioMarcacoes;
    }

    /**
     * <h1> Metodo adicionar </h1>
     * Adicona uma marcação (data, Utente) ao repositorio, se ainda não existir
     * (Se existir é atirado um erro)
     *
     * @param data LocalDate
     * @param utente Utente
     * @throws BACKEND.Marcacao.MarcacaoJaExistente MarcacaoJaExistente
     */
    public void adicionar(LocalDate data, Utente utente) throws MarcacaoJaExistente {

        ArrayList<Utente> lista = repositorioMarcacoes.get(data); //vai ao repositorio, consoante a data atribuida e um certo utilizador, verificar se já tem marcacao para o dia específico

        // verifica se ainda nao existe agendamento para a data especificada
        if (lista == null) {
            lista = new ArrayList<>();
            repositorioMarcacoes.put(data, lista);
        }

        if (lista.contains(utente)) {
            throw new MarcacaoJaExistente("Já existe uma marcação para esta data");

        } else {
            lista.add(utente);   //adiciona marcação desse utilizador, para a data especifica
            repositorioMarcacoes.put(data, lista);
        }

    }

    /**
     *
     * @param data LocalDate
     * @param utente Utente
     */
    public void remover(LocalDate data, Utente utente) {
        ArrayList<Utente> lista = repositorioMarcacoes.get(data);
        if (lista != null) {
            lista.remove(utente);
            if (lista.isEmpty()) {
                lista.remove(data);
            }
        }

    }

    /**
     *
     * @param data LocalDate
     * @param utente Utente
     * @return boolean
     */
    public boolean existeMarcacao(LocalDate data, Utente utente) {
        ArrayList<Utente> lista = repositorioMarcacoes.get(data);
        return lista.contains(utente);

    }

    /**
     *
     * @param data Localdate
     * @return ArrayList de Utentes
     */
    public ArrayList<Utente> listaUtentesPorData(LocalDate data) {
        return repositorioMarcacoes.get(data);
    }

    /**
     * <h1> Calcular Número Marcações </h1>
     * Dada uma data, calcula quantos utentes estão associados à mesma data
     *
     * @param data String
     * @return int
     */
    public int calcularNumeroMarcacoes(LocalDate data) {
        ArrayList<Utente> lista = repositorioMarcacoes.get(data);
        if (lista == null) {
            return 0;
        } else {
            return lista.size();
        }
    }

    /**
     * <h1> Data da próxima marcação </h1>
     * <ul>
     * <li>Dado um determinado utente, é retornado a data da sua próxima
     * marcação</li>
     * <li> Usamos o entrySet, para retornar um conjunto de Maps contido no mapa
     * configurado, podendo ser possível acessar suas chaves e valores </li>
     * <li>Para cada entry (chave, valores) se os valores de contiverem o
     * utente, retorna chave (localDate) que está associado.</li>
     * </ul>
     *
     * @param utente Utente
     * @return LocalDate
     */
    public LocalDate dataProximaMarcacao(Utente utente) {
        var entrySet = repositorioMarcacoes.entrySet();
        for (var entry : repositorioMarcacoes.entrySet()) {
            if (entry.getValue().contains(utente)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public class MarcacaoJaExistente extends Exception implements Serializable {

        public MarcacaoJaExistente() {
        }

        /**
         *
         * @param message String
         */
        public MarcacaoJaExistente(String message) {
            super(message);
        }
    }

    public class MarcacaoNaoExiste extends Exception implements Serializable {

        public MarcacaoNaoExiste() {
        }

        /**
         *
         * @param message String
         */
        public MarcacaoNaoExiste(String message) {
            super(message);
        }
    }

}
