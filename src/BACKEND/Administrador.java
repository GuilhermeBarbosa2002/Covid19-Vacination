package BACKEND;

import java.io.Serializable;
//PERGUNTAR AO STOR SE O ADMIN VAI TER UM REPOSITORIO!

/**
 *
 * @author guilh
 */
public class Administrador extends Utilizador implements Serializable {

    /**
     * Construtor
     */
    public Administrador() {

    }

    /**
     *
     * @param username String
     * @param Nome String
     * @param email String
     * @param Password String
     */
    public Administrador(String username, String Nome, String email, String Password) {
        super(username, Nome, email, Password);
    }

}
