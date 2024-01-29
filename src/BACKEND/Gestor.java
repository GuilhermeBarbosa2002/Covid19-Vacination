package BACKEND;

import java.io.Serializable;

/**
 *
 * @author guilh
 */
public class Gestor extends Utilizador implements Serializable {

    private CentroVacinacao centroVacinacao;

    public Gestor() {
    }

    /**
     *
     * @param username String
     * @param password String
     * @param email String
     * @param nome String
     */
    public Gestor(String username, String password, String email, String nome) {
        super(username, password, email, nome);
    }

    /**
     *
     * @return CentroVacinacao
     */
    public CentroVacinacao getCentroVacinacao() {
        return centroVacinacao;
    }

    /**
     *
     * @param centroVacinacao CentroVacinacao
     */
    public void setCentroVacinacao(CentroVacinacao centroVacinacao) {
        this.centroVacinacao = centroVacinacao;
    }

}
