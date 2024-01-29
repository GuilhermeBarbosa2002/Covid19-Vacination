package BACKEND;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public class RepositorioDoencas implements Serializable {

    private ArrayList<String> doencas = new ArrayList<>();

    public class DoencaJaexistenteException extends Exception implements Serializable {

        public DoencaJaexistenteException() {
        }

        /**
         *
         * @param message String
         */
        public DoencaJaexistenteException(String message) {
            super(message);
        }
    }

    /**
     *
     * @return ArrayList de String
     */
    public ArrayList<String> getDoencas() {
        return doencas;
    }

    /**
     *
     * @param doenca String
     * @throws DoencaJaexistenteException DoencaJaexistenteException
     */
    public void adicionar(String doenca) throws DoencaJaexistenteException {

        if (!doencas.contains(doenca)) {
            doencas.add(doenca);

        } else {
            throw new DoencaJaexistenteException("Doença já existente!");
        }

    }

    /**
     *
     * @param doenca String
     */
    public void remover(String doenca) {
        if (doenca == null) {
            System.out.println("O utente não tem doenças registadas!");
        }
        if (doencas.contains(doenca)) {
            doencas.remove(doenca);
        } else {
            System.err.println("ERRO! Não podemos remover uma doença inexistente!");
        }

    }

    /**
     *
     * @param doenca String
     * @return boolean
     */
    public boolean existeDoenca(String doenca) {
        return doencas.contains(doenca);
    }

    /**
     *
     */
    public void listarDoencas() {
        System.out.print(" \n Doenças: ");
        for (String s : doencas) {
            System.out.print(s + " ");
        }

    }

    /**
     *
     * @param index int
     * @return String
     */
    public String getDoenca(int index) {
        return doencas.get(index);
    }

    /**
     *
     * @return int
     */
    public int size() {
        return doencas.size();
    }

}
