package BACKEND;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author guilh
 */
public class RepositorioVacinas implements Serializable {

    private ArrayList<Vacina> listavacinas = new ArrayList<Vacina>();

    public RepositorioVacinas() {
    }

    /**
     *
     * @param listavacinas ArrayList de Vacinas
     */
    public RepositorioVacinas(ArrayList<Vacina> listavacinas) {
        this.listavacinas = listavacinas;
    }

    /**
     *
     * @return ArrayList de Vacinas
     */
    public ArrayList<Vacina> getListavacinas() {
        return listavacinas;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        for (Vacina v : listavacinas) {
            System.out.println(v.toString());
        }
        return null;

    }

    /**
     *
     * @param listavacinas ArrayList de Vacinas
     */
    public void setListavacinas(ArrayList<Vacina> listavacinas) {
        this.listavacinas = listavacinas;
    }

    /**
     *
     * @param vacina Vacina
     */
    public void adicionarVacina(Vacina vacina) {
        if (listavacinas.contains(vacina)) {
            System.err.println("ERRO! Vacina já foi previamente adicionada!");
        } else {
            listavacinas.add(vacina);
        }

    }

    /**
     *
     * @param vacina Vacina
     */
    public void removerVacina(Vacina vacina) {
        if (listavacinas.contains(vacina)) {
            listavacinas.remove(vacina);
        } else {
            System.err.println("ERRO! Vacina não encontrada!");
        }
    }

    /**
     *
     * @param vacina Vacina
     * @return boolean
     */
    public boolean existeVacina(Vacina vacina) {
        return listavacinas.contains(vacina);
    }

    /**
     *
     * @param vacina Vacina
     * @return Vacina
     */
    public Vacina getVacina(Vacina vacina) {
        if (existeVacina(vacina)) {
            return vacina;
        } else {
            return null;
        }
    }

    /**
     *
     * @param fabricante String
     * @return Vacina
     */
    public Vacina getVacinaPorFabricante(String fabricante) {
        for (Vacina v : listavacinas) {
            if (v.getFabricante().equals(fabricante)) {
                return v;
            }
        }
        return null;

    }

    /**
     *
     * @return int
     */
    public int getTotalTipoVacina() {
        return listavacinas.size();
    }

    /**
     * <h2>Verificar as doenças em comum</h2>
     * <ul>
     * <li>Dado as doenças do utente e as estrições da Vacina, compara-as e vê
     * se existem "doenças iguais"</li>
     * <li>Se existir, retorna Verdadeiro, senão retorna Falso</li>
     * </ul>
     *
     * @param vacina Vacina
     * @param utente Utente
     * @return boolean
     */
    private boolean verificarDoençasEmComum(Vacina vacina, Utente utente) {
        RepositorioDoencas doencasutente = utente.getDoencas();
        RepositorioDoencas restricoes = vacina.getRestricoes();
        for (int i = 0; i < doencasutente.size(); i++) {
            if (restricoes.existeDoenca(doencasutente.getDoenca(i))) {
                return true;
            }

        }
        return false;
    }

    /**
     * <h2>Verificar idade do utente com os limites de idade minima e máxima da
     * vacina</h2>
     * <ul>
     * <li>Calculamos a idade do utente</li>
     * <li>Se for maior que o limite minimo e menor que o limite máximo retorna
     * Verdadeiro, senão retorna Falso</li>
     * </ul>
     *
     * @param vacina Vacina
     * @param utente Utente
     * @return boolean
     */
    private boolean verificarIdadeComVacina(Vacina vacina, Utente utente) {
        if (utente.calcularIdade() >= vacina.idadeMinima && utente.calcularIdade() <= vacina.idadeMaxima) {
            return true;

        }

        return false;

    }

    /**
     * <h2>Vacinas possiveis para dado Utente</h2>
     * <ul>
     * <li>Para todas as Vacinas na lista verificamos as condições</li>
     * <li>Se não existirem doenças em comum entre a vacina e o utente e a sua
     * idade estiver entre os limites da vacina, adiconamos a vacina a uma lista
     * de vacinas possiveis, que é retornada no fim</li>
     *
     * </ul>
     *
     * @param utente Utente
     * @return ArrayList de Vacinas
     */
    public ArrayList<Vacina> melhoresVacinasParaUtente(Utente utente) {
        ArrayList<Vacina> lista = new ArrayList<>();
        for (Vacina v : listavacinas) {
            if (!verificarDoençasEmComum(v, utente) && verificarIdadeComVacina(v, utente)) {
                lista.add(v);
            }
        }

        return lista;
    }

    /**
     * <h2>Vacinas possivel para Utente</h2>
     * <ul>
     * <li>Para todas as Vacinas na lista verificamos as condições</li>
     * <li>Se não existirem doenças em comum entre a vacina e o utente e a sua
     * idade estiver entre os limites da vacina, retornamos a primeira vacina a
     * verificar as condições</li>
     * </ul>
     *
     * @param utente Utente
     * @return Vacina Vacina
     */
    public Vacina melhorVacinaParaUtente(Utente utente) {

        for (Vacina v : listavacinas) {
            if (!verificarDoençasEmComum(v, utente) && verificarIdadeComVacina(v, utente)) {
                return v;
            }
        }

        return null;
    }

}
