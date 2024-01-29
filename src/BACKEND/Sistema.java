package BACKEND;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author guilh
 */
public class Sistema implements Serializable {

    private final RepositorioUtilizador utilizadores;
    private Utilizador utilizadorligado;
    private final RepositorioCentrosVacinacao centrosVacinacoes;
    private final RepositorioVacinas vacinas;

    /**
     * Construtor
     */
    public Sistema() {
        utilizadores = new RepositorioUtilizador();
        centrosVacinacoes = new RepositorioCentrosVacinacao();
        vacinas = new RepositorioVacinas();

    }

    /**
     *
     * @return RepositorioVacinas
     */
    public RepositorioVacinas getVacinas() {
        return vacinas;
    }

    /**
     *
     * @param utilizadorligado Utilizador
     */
    public void setUtilizadorligado(Utilizador utilizadorligado) {
        this.utilizadorligado = utilizadorligado;
    }

    /**
     *
     * @return RepositorioUtilizador
     */
    public RepositorioUtilizador getUtilizadores() {
        return utilizadores;
    }

    /**
     *
     * @return Utilizador
     */
    public Utilizador getUtilizadorligado() {
        return utilizadorligado;
    }

    /**
     *
     * @return RepositorioCentrosVacinacao
     */
    public RepositorioCentrosVacinacao getCentrosVacinacoes() {
        return centrosVacinacoes;
    }

    /**
     *
     * @param username String
     * @param password String
     * @return boolean
     */
    public boolean autenticarUtilizador(String username, String password) {
        if (utilizadores.existeUtilizador(username)) {
            try {
                Utilizador u = utilizadores.getUtilizador(username);
                if (u.getPassword().equals(password)) {
                    utilizadorligado = u;

                    return true;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    /**
     * <h2> Inicializar os valores predefinidos </h2>
     *
     * @throws RepositorioUtilizador.UtilizadorDuplicadoException
     * @throws RepositorioDoencas.DoencaJaexistenteException
     * @throws RepositorioCentrosVacinacao.CentroVacinacaoJaExistenteException
     */
    public void inicializar() throws RepositorioUtilizador.UtilizadorDuplicadoException, RepositorioDoencas.DoencaJaexistenteException, RepositorioCentrosVacinacao.CentroVacinacaoJaExistenteException {
        RepositorioDoencas rd = new RepositorioDoencas();
        RepositorioDoencas vacina1doencas = new RepositorioDoencas();
        RepositorioDoencas vacina2doencas = new RepositorioDoencas();
        RepositorioDoencas vacina3doencas = new RepositorioDoencas();
        RepositorioDoencas vacina4doencas = new RepositorioDoencas();
        vacina3doencas.adicionar("Cancro");
        vacina4doencas.adicionar("Miopia");

        //vacinas com a maior aproximação possível às normas consultadas no site da DGS (exceto as restrições e efeitos secundários)
        Vacina v1 = new Vacina("COMIRNATY", "001", "Pfizer", 100, vacina1doencas, 2, 16, 150, 28, 40, "Febre alta, e tosse");
        Vacina v2 = new Vacina("Vaccine MODERNA", "002", "Moderna", 250, vacina2doencas, 2, 18, 150, 28, 50, "Febre alta, tosse, vómitos");
        Vacina v3 = new Vacina("VAXZEVRIA", "003,", "AstraZeneca ", 200, vacina3doencas, 2, 60, 150, 84, 150, "Febre alta, tosse, vómitos");
        Vacina v4 = new Vacina("Johnson & Johnson", "004,", "Janssen ", 200, vacina4doencas, 1, 50, 150, 0, 0, "Febre alta, tosse, tonturas, derrames vasculares");
        vacinas.adicionarVacina(v1);
        vacinas.adicionarVacina(v2);
        vacinas.adicionarVacina(v3);
        vacinas.adicionarVacina(v4);

        rd.adicionar("Cancro"); //doença para o utente default

        //utilizadores default
        utilizadores.adicionar(new Administrador("admin", "admin", "Aministrador@gmail.com", "123"));
        utilizadores.adicionar(new Utente("123", "Amares", "Amares", LocalDate.parse("2002-11-28"), "9736337", rd, null, null, new RepositorioDatasAdministracao(), "123", "123", "sad@gmcil.com", "joão"));
        utilizadores.adicionar(new Gestor("G001", "1234", "bruno@gmail.com", "Bruno Miguel"));
        utilizadores.adicionar(new Gestor("G002", "1234", "sergio@gmail.com", "Sérgio Pimenta"));
        centrosVacinacoes.adicionar(new CentroVacinacao("CV002", "Alberto Caeiro, Nº8", "Guimarães", (Gestor) utilizadores.getGestor("G001"), new StockVacinas(), 5, vacinas, new Marcacao(), 150));
        centrosVacinacoes.adicionar(new CentroVacinacao("CV001", "Rua 7, Nº8", "Amares", (Gestor) utilizadores.getGestor("G002"), new StockVacinas(), 7, vacinas, new Marcacao(), 100));
    }

    /**
     * Encerrar
     */
    public void terminar() {
        System.exit(0);
    }
}
