package BACKEND;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public class RepositorioCentrosVacinacao implements Serializable {

    private ArrayList<CentroVacinacao> lista = new ArrayList<>();

    /**
     *
     * @return ArrayList de Centro de Vacinações
     */
    public ArrayList<CentroVacinacao> getLista() {
        return lista;
    }

    /**
     *
     * @param lista ArrayList de Centro de Vacinações
     */
    public void setLista(ArrayList<CentroVacinacao> lista) {
        this.lista = lista;
    }

    /** <h2>Adiconar</h2>
     * Adiciona Centro de Vacinação, não permite adicionar centros repetidos
     *
     * @param centrovacinacao CentroVacinacao
     * @throws CentroVacinacaoJaExistenteException
     * CentroVacinacaoJaExistenteException
     */
    public void adicionar(CentroVacinacao centrovacinacao) throws CentroVacinacaoJaExistenteException {
        if (lista == null) {
            lista = new ArrayList<>();
        }
        if (!lista.contains(centrovacinacao)) {
            lista.add(centrovacinacao);
        } else {
            throw new CentroVacinacaoJaExistenteException("Centro De Vacinação já existe!");
        }

    }

    /** <h2>Remover</h2>
     * Remove um Centro Vacinação
     *
     * @param centroVacinacao CentroVacinacao
     */
    public void remover(CentroVacinacao centroVacinacao) {
        if (lista.contains(centroVacinacao)) {
            lista.remove(centroVacinacao);
        } else {
            System.err.println("ERRO! Não podemos remover um Centro inexistente!");
        }
    }

    /**
     * <h2>Adicionar centro comparando o código:</h2>
     * <ul>
     * <li>Adiciona Centro de Vacinação, não permite adicionar centros com
     * códigos repetidos</li>
     * <li>Usamos um contador, para que sempre que exista um centro com dado
     * username é somado uma unidade ao contador</li>
     * <li>No fim, se o contador possuir um valor maior que 0, quer dizer que já
     * temos um centro com esse código</li>
     * <li>Perante esta situação, não podemos adicionar o Centro</li>
     * </ul>
     *
     * @param centrovacinacao CentroVacinacao
     * @throws CentroVacinacaoJaExistenteException
     * CentroVacinacaoJaExistenteException
     */
    public void adicionarCentroVacinacaoCodigo(CentroVacinacao centrovacinacao) throws CentroVacinacaoJaExistenteException {
        int contador = 0;
        for (CentroVacinacao cv : lista) {
            if (cv.getCodigo().equalsIgnoreCase(centrovacinacao.getCodigo())) {
                contador++;
            }

        }
        if (contador > 0) {
            throw new CentroVacinacaoJaExistenteException("Centro De Vacinação já existe!");
        } else {
            lista.add(centrovacinacao);
        }

    }

    /**
     *
     * @return int
     */
    public int getTotalCentrosVacinacao() {
        return lista.size();

    }

    /**
     * Verifica se existe um Centro de Vacinação
     *
     * @param codigo String
     * @return boolean
     */
    public boolean existeCentroVacinacao(String codigo) {
        for (CentroVacinacao u : lista) {

            if (u != null && u.getCodigo().equals(codigo)) {
                return true;

            }

        }
        return false;

    }

    /**
     * Verifica se existe um Centro de Vacinação em dada Localidade
     *
     * @param localidade String
     * @return boolean
     */
    public boolean existeCentroVacinacaoPorLocalidade(String localidade) {
        for (CentroVacinacao cv : lista) {
            if (cv != null && cv.getLocalidade().equals(localidade)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param centroVacinacao CentroVacinacao
     * @return CentroVacinacao
     */
    public CentroVacinacao getCentroVacinacao(CentroVacinacao centroVacinacao) {
        for (CentroVacinacao cv : lista) {
            if (cv != null && cv.getLocalidade().equals(centroVacinacao)) {
                return cv;
            }
        }
        return null;
    }

    /**
     * Retorna um Centro de Vacinação dada uma Localidade
     *
     * @param localidade String
     * @return CentroVacinacao
     */
    public CentroVacinacao CentroVacinacaoPorLocalidade(String localidade) {
        for (CentroVacinacao cv : lista) {
            if (cv != null && cv.getLocalidade().equals(localidade)) {
                return cv;
            }
        }
        return null;
    }

    /**
     * Retorna um Centro de Vacinação dado um codigo
     *
     * @param codigo String
     * @return CentroVacinacao
     */
    public CentroVacinacao CentroVacinacaoPorCod(String codigo) {
        for (CentroVacinacao cv : lista) {
            if (cv != null && cv.getCodigo().equals(codigo)) {
                return cv;
            }
        }
        return null;
    }

    /**
     * Retorna um Centro de Vacinação dado um Gestor
     *
     * @param gestor Gestor
     * @return CentroVacinacao
     */
    public CentroVacinacao getCentroVacinacaoPorGestor(Gestor gestor) {
        for (CentroVacinacao u : lista) {

            if (u != null && u.getGestor().equals(gestor)) {
                return u;

            }

        }

        return null;

    }

    /**
     * <h2>Associar Centro Vacinação</h2>
     * <ul>
     * <li>Dado um utente e um centro de vacinação, associa-os</li>
     * <li>Verifica se existe um centro de vacinação na localidade onde o utente
     * existe, se sim, chama outro metodo</li>
     * <li>Se não existir centro nessa localidade, associa esse centro
     * vacinação</li>
     * </ul>
     *
     * @param utente Utente
     * @param centrovacinacao CentroVacinacao
     */
    public void associarCentroVacinacao(Utente utente, CentroVacinacao centrovacinacao) {
        String localidadeUtente = utente.getLocalidade();
        if (existeCentroVacinacaoPorLocalidade(localidadeUtente)) {
            utente.setCentrovacinacao(CentroVacinacaoPorLocalidade(localidadeUtente));
            System.out.println("Como em " + utente.getLocalidade() + " existe um Centro de Vacinação, o utente " + utente.getNome() + "foi registado no mesmo.");
        } else {
            utente.setCentrovacinacao(centrovacinacao);
        }

    }

    /** <h2>Associar Centro a Utente, comparando as localidades</h2>
     * <ul>
     * <li>Dado um utente, verifica se existe um centro na localidade do
     * utente.</li>
     * <li>Em caso afirmativo, associa o centro ao utente</li>
     * </ul>
     *
     * @param utente Utente
     * @throws CentroVacinacaoInexistenteException
     * CentroVacinacaoInexistenteException
     */
    public void associarCentroVacinacaoLocalidaeUtente(Utente utente) throws CentroVacinacaoInexistenteException {
        String localidadeUtente = utente.getLocalidade();
        if (existeCentroVacinacaoPorLocalidade(localidadeUtente)) {
            CentroVacinacao cv = utente.getCentrovacinacao();
            associarCentroVacinacao(utente, cv);
        } else {
            throw new CentroVacinacaoInexistenteException("ERRO! Não Existe centro de Vacinação na localidade no Utente, escolha um centro de vacinação");

        }
    }

    /**
     * <h2>Aloca o gestor a um Centro de Vacinação</h2>
     *
     * @param gestor Gestor
     * @param centrovacinacao CentroVacinacao
     */
    public void alocarGestorParaCentroVacinacao(Gestor gestor, CentroVacinacao centrovacinacao) {
        centrovacinacao.setGestor(gestor);
    }

    /**
     *
     * @param centrovacinacao CentroVacinacao
     */
    public void listarCentroVacinacao(CentroVacinacao centrovacinacao) {
        if (lista.contains(centrovacinacao)) {

            System.out.println(centrovacinacao.toString());
        } else {
            System.err.println("ERRO! Centro de Vacinação não existe!");
        }
    }

    /**
     *
     */
    public void listarTodosCentrosVacinacoes() {
        for (CentroVacinacao cv : lista) {
            System.out.println(cv.toString());
        }

    }

    /**
     * <h2>Total Vacinas Administradas em todos os centros</h2>
     * Retorna o total de vacinas administradas em todos os centros (soma os
     * contadores das vacinas administradas de todos os centros)
     *
     * @return CentroVacinacao
     */
    public long totalVacinasAdministradasEmTodosOsCentros() {
        long total = 0;
        for (CentroVacinacao cv : lista) {
            total += cv.getNumVacinasAdministradas();

        }
        return total;
    }

    /**
     * <h2>Total de vacinas administradas num centro</h2>
     *
     * @param centroVacinacao CentroVacinacao
     * @return long
     */
    public long totalVacinasAdministradasCentro(CentroVacinacao centroVacinacao) {
        return centroVacinacao.getNumVacinasAdministradas();
    }

    public class CentroVacinacaoInexistenteException extends Exception implements Serializable {

        public CentroVacinacaoInexistenteException() {
        }

        /**
         *
         * @param message String
         */
        public CentroVacinacaoInexistenteException(String message) {
            super(message);
        }
    }

    public class CentroVacinacaoJaExistenteException extends Exception implements Serializable {

        public CentroVacinacaoJaExistenteException() {
        }

        /**
         *
         * @param message String
         */
        public CentroVacinacaoJaExistenteException(String message) {
            super(message);
        }
    }

}
