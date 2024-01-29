package BACKEND;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public class RepositorioDatasAdministracao implements Serializable {

    private ArrayList<LocalDate> datas;

    public RepositorioDatasAdministracao() {
        datas = new ArrayList<>();
    }

    /**
     *
     * @return ArrayList de LocalDate
     *
     */
    public ArrayList<LocalDate> getDatas() {
        return datas;
    }

    /**
     *
     * @param datas ArrayList de LocalDate
     */
    public void setDatas(ArrayList<LocalDate> datas) {
        this.datas = datas;
    }

    /**
     *
     * @param data LocalDate
     */
    public void adicionar(LocalDate data) {

        if (datas == null) {

            datas = new ArrayList<>();

        }

        if (datas.contains(data)) {
            System.err.println("Data já existe");

        } else {

            datas.add(data);
        }

    }

    /**
     *
     */
    public void listar() {
        for (LocalDate d : datas) {
            System.out.println(d.toString());
        }
    }

}
