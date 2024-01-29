package BACKEND;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author guilh
 */
public class StockVacinas implements Serializable {

    private Map<Vacina, Long> stock = new HashMap<>();

    /**
     *
     * @param vacina Vacina
     * @param quantidade long
     */
    public void AdicionarVacinas(Vacina vacina, long quantidade) {

        Long stockatual = stock.get(vacina);
        if (stockatual == null) {

            stock.put(vacina, quantidade);

        } else {
            stock.put(vacina, stockatual + quantidade);

        }
    }

    /**
     *
     * @param vacina Vacina
     * @param quantidade long
     */
    public void RemoverVacinas(Vacina vacina, long quantidade) {

        Long stockatual = stock.get(vacina);
        if (stockatual == null) {
            System.err.println("Impossivel, não existem vacinas!");
        } else if (quantidade > stockatual) {
            System.err.println("Impossivel, não existem vacinas suficientes!");
        } else {
            stock.put(vacina, stockatual - quantidade);

        }

    }

    /**
     *
     * @param vacina Vacina
     * @return boolean
     */
    public boolean ExisteVacina(Vacina vacina) {
        return stock.containsKey(vacina);
    }

    /**
     *
     * @param vacina Vacina
     * @return long
     */
    public long stockDisponivel(Vacina vacina) {
        try {
           return stock.get(vacina);
        }catch (Exception e){
            return 0;
        }

    }

    /**
     *
     * @return int
     */
    public int quantidadeTipoVacinas() { // ver o nome!
        if (stock == null) {
            return 0;
        } else {
            return stock.size();
        }
    }

}
