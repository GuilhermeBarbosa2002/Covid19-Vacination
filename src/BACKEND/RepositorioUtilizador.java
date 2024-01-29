package BACKEND;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public class RepositorioUtilizador implements Serializable {

    private ArrayList<Utilizador> lista = new ArrayList<>();

    public class UtilizadorDuplicadoException extends Exception {

        public UtilizadorDuplicadoException() {
        }

        /**
         *
         * @param message String
         */
        public UtilizadorDuplicadoException(String message) {
            super(message);
        }
    }

    public class UtilizadorNaoExistenteException extends Exception {

        public UtilizadorNaoExistenteException() {
        }

        /**
         *
         * @param message String
         */
        public UtilizadorNaoExistenteException(String message) {
            super(message);
        }
    }

    public RepositorioUtilizador() {
        lista = new ArrayList<>();
    }

    /**
     *
     * @param limite int
     */
    public RepositorioUtilizador(int limite) {
        lista = new ArrayList<>(limite);
    }

    /**
     *
     * @param index int
     * @return Utilizador
     */
    public Utilizador get(int index) {
        return lista.get(index);
    }

    /**
     *
     * @return ArrayList Utilizadores
     */
    public ArrayList<Utilizador> getListaUtilizador() {
        return lista;
    }

    /**
     *
     * @param lista ArrayList Utilizadores
     */
    public void setListaUtilizador(ArrayList<Utilizador> lista) {
        this.lista = lista;
    }

    /**
     * Adiciona um novo Utilizador ao repositorio
     *
     * @param utilizador Utilizador
     * @throws UtilizadorDuplicadoException UtilizadorDuplicadoException
     */
    public void adicionar(Utilizador utilizador) throws UtilizadorDuplicadoException {
        if (utilizador == null) {
            throw new NullPointerException("O parâmetro 'utilizador' não pode ser um valor nulo");
        }

        if (!lista.contains(utilizador.getUsername())) {
            lista.add(utilizador);
        } else {
            throw new UtilizadorDuplicadoException(String.format("O utilizador '%s' já existe na coleção", utilizador.getUsername()));
        }

    }

    /**
     * Adiciona um novo Utilizador ao Repositorio, mas verifica se o username já
     * está a ser utilizado
     *
     * @param utilizador Utilizador
     * @throws UtilizadorDuplicadoException UtilizadorDuplicadoException
     */
    public void adicionarUtilizadorUsername(Utilizador utilizador) throws UtilizadorDuplicadoException {
        int contador = 0;
        if (lista == null) {
            lista = new ArrayList<>();
        }
        for (Utilizador u : lista) {
            if (u.getUsername().equalsIgnoreCase(utilizador.getUsername())) {
                contador++;
            }

        }
        if (contador > 0) {
            throw new UtilizadorDuplicadoException("Utilizador já existe!");
        } else {
            lista.add(utilizador);
        }

    }

    /**
     * Verifica se o email já está a ser utilizado
     *
     * @param email String
     * @return boolean
     */
    public boolean verificarEmail(String email) {
        for (Utilizador u : lista) {
            if (u != null && u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove o Utilizador
     *
     * @param utilizador Utilizador
     */
    public void remover(Utilizador utilizador) {
        lista.remove(utilizador);
    }

    /**
     *
     * @return int
     */
    public int getTotalUtilizador() {
        return lista.size();
    }

    /**
     * Verifica se existe Utilizador com dado username
     *
     * @param username String
     * @return boolean
     */
    public boolean existeUtilizador(String username) {
        for (Utilizador u : lista) {
            if (u != null && u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se existe Utente com dado username
     *
     * @param username String
     * @return boolean
     */
    public boolean existeUtente(String username) {
        ArrayList<Utente> utentes = new ArrayList<>();
        for (Utilizador u : lista) {
            if (u instanceof Utente) {
                utentes.add((Utente) u);
            }

        }

        for (Utente u : utentes) {
            if (u != null && u.getUsername().equals(username)) {
                return true;
            }

        }

        return false;
    }

    /**
     * Verifica se existe um Gestor com dado username
     *
     * @param username String
     * @return boolean
     */
    public boolean existeGestor(String username) {
        ArrayList<Gestor> gestores = new ArrayList<>();
        for (Utilizador g : lista) {
            if (g instanceof Gestor) {
                gestores.add((Gestor) g);
            }

        }

        for (Gestor u : gestores) {
            if (u != null && u.getUsername().equals(username)) {
                return true;
            }

        }

        return false;
    }

    /**
     * Verifica se existe Utilizador e retorna-o se existir com dado username
     *
     * @param username String
     * @return Utilizador
     * @throws UtilizadorNaoExistenteException UtilizadorNaoExistenteException
     */
    public Utilizador getUtilizador(String username) throws UtilizadorNaoExistenteException {
        for (Utilizador u : lista) {
            if (u != null && u.getUsername().equals(username)) {
                return u;
            }
        }

        throw new UtilizadorNaoExistenteException("O utilizador %s não existe!");
    }

    /**
     * Retorna um Gestor(Utilizador) dado o seu username
     *
     * @param username String
     * @return Utilizador
     */
    public Utilizador getGestor(String username) {
        for (Utilizador g : lista) {
            if (g instanceof Gestor && g != null && g.getUsername().equals(username)) {
                return g;
            }
        }
        return null;
    }

    /**
     * Retorna um Utente(Utilizador) dado o seu username
     *
     * @param username String
     * @return Utilizador
     */
    public Utilizador getUtente(String username) {
        for (Utilizador u : lista) {
            if (u instanceof Utente && u != null && u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    /**
     *
     * @param centroVacinacao CentroVacinacao
     */
    public void listarUtentesDeCentroVacinacao(CentroVacinacao centroVacinacao) {
        ArrayList<Utente> utentes = new ArrayList<>();
        for (Utilizador u : lista) {
            if (u instanceof Utente) {
                utentes.add((Utente) u);
            }

        }

        for (Utente u : utentes) {
            if (u.getCentrovacinacao().equals(centroVacinacao)) {
                System.out.println(u.toString());
            }

        }

    }

    /**
     *
     */
    public void listarTodosUtentes() {
        ArrayList<Utente> utentes = new ArrayList<>();
        for (Utilizador u : lista) {
            if (u instanceof Utente) {
                utentes.add((Utente) u);
            }

        }

        for (Utente u : utentes) {

            System.out.println(u.toString());

        }
    }

    /**
     *
     */
    public void listarGestores() {
        ArrayList<Gestor> gestores = new ArrayList<>();
        for (Utilizador u : lista) {
            if (u instanceof Gestor) {
                gestores.add((Gestor) u);
            }
        }

        for (Gestor g : gestores) {
            System.out.println(g.toString());
        }

    }

    /**
     * <h2>Utentes por centro</h2>
     * <ul>
     * <li>Retorna todos os Utilizadores de um determinado Centro de
     * vacinação</li>
     * <li>Se o Utilizador for Utente, e se o seu Centro associado for igual ao
     * inserido, é adicionado a uma lista que é retornada no fim</li>
     * </ul>
     *
     * @param cv CentroVacinacao
     * @return ArrayList de Utentes
     */
    public ArrayList<Utente> getUtentesPorCentro(CentroVacinacao cv) {
        ArrayList<Utente> listaUtentes = new ArrayList<>();
        for (Utilizador u : lista) {
            if (u instanceof Utente) {
                try {
                    if (((Utente) u).getCentrovacinacao().equals(cv)) { //se ainda não tiver centro associado, não da erro!
                        listaUtentes.add((Utente) u);
                    }
                } catch (Exception e) {
                    System.out.println("Ainda não tem centro associado");
                }

            }

        }
        return listaUtentes;

    }

}
