package BACKEND;

import java.io.Serializable;

/**
 *
 * @author guilh
 */
public class Utilizador implements Serializable {

    private String username;
    private String password;
    private String email;
    private String nome;

    public Utilizador() {

    }

    /**
     *
     * @param username String
     * @param password String
     * @param email String
     * @param nome String
     */
    public Utilizador(String username, String password, String email, String nome) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nome = nome;
    }

    /**
     *
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param Nome String
     */
    public void setNome(String Nome) {
        this.nome = nome;
    }

    /**
     *
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param Password String
     */
    public void setPassword(String Password) {
        this.password = Password;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Utilizador{" + "username=" + username + ", email=" + email + ", nome=" + nome + '}';
    }

}
