package Serializacao;

import BACKEND.Sistema;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author guilh
 */
public class Serializacao {

    /**
     *
     */
    private final File ficheiro;

    /**
     *
     * @param ficheiro
     */
    public Serializacao(String ficheiro) {
        this.ficheiro = new File(ficheiro);
    }

    /**
     *
     * @return
     */
    public File getFicheiro() {
        return ficheiro;
    }

    //Carrega o sistema do ficheiro
    /**
     *
     * @return
     */
    public Sistema carregar() {
        try ( FileInputStream fileIn = new FileInputStream(ficheiro);  ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Sistema sistema = (Sistema) in.readObject();
            return sistema;
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(String.format(
                    "Ocorreu um erro ao ler o ficheiro de dados: %s",
                    ex.getLocalizedMessage()), ex);
        }
    }

    //Guarda o sistema no ficheiro
    /**
     *
     * @param sistema
     */
    public void guardar(Sistema sistema) {
        try ( FileOutputStream fileOut = new FileOutputStream(ficheiro);  ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            try {
                out.writeObject(sistema);
            } catch (IOException ex) {
                throw new RuntimeException(String.format(
                        "Ocorreu um erro ao guardar o ficheiro de dados: %s",
                        ex.getLocalizedMessage()), ex);
            }
        } catch (IOException ex) {
            throw new RuntimeException(String.format(
                    "Ocorreu um erro ao guardar o ficheiro de dados: %s",
                    ex.getLocalizedMessage()), ex);
        }
    }

}
