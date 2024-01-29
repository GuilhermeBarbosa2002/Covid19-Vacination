/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BACKEND;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public class Teste {

    /**
     *
     * @param args
     * @throws RepositorioDoencas.DoencaJaexistenteException
     * @throws RepositorioCentrosVacinacao.CentroVacinacaoJaExistenteException
     * @throws Marcacao.MarcacaoJaExistente
     * @throws CentroVacinacao.LimiteMarcacoesUltrapassado
     */
    public static void main(String[] args) throws RepositorioDoencas.DoencaJaexistenteException, RepositorioCentrosVacinacao.CentroVacinacaoJaExistenteException, Marcacao.MarcacaoJaExistente, CentroVacinacao.LimiteMarcacoesUltrapassado {
        RepositorioCentrosVacinacao rc = new RepositorioCentrosVacinacao();
        RepositorioDoencas vacina1doenças = new RepositorioDoencas();
        ArrayList<Vacina> listavacinas = new ArrayList<>();

        RepositorioVacinas rv = new RepositorioVacinas(listavacinas);

        vacina1doenças.adicionar("Pneumonia");
        vacina1doenças.adicionar("AVC");

        StockVacinas sv = new StockVacinas();
        Marcacao m = new Marcacao();

        Vacina v1 = new Vacina("asdasda", "ag123,", "Pfizer", 1, vacina1doenças, 2, 20, 30, 10, 11, "Febre alta, e tosse");
        Vacina v2 = new Vacina("!32312", "455,", "Moderna", 2, vacina1doenças, 2, 0, 100, 10, 11, "Febre alta, e tosse, Vomitos");

        Administrador admin = new Administrador();
        //  admin.setListaCentrosVacinacao(rc);
        Gestor g1 = new Gestor("ana1234", "1234", "ana@gmail.com", "Ana Silva");

        Utente u1 = new Utente();
        Utente u2 = new Utente();
        Utente u3 = new Utente();
        CentroVacinacao cv1 = new CentroVacinacao("cv1", "Rua João Paulo II", "Amares", null, sv, 12, rv, m, 2);
        CentroVacinacao cv2 = new CentroVacinacao("cv2", "Rua 7", "Paradela", null, sv, 12, rv, m, 25);
        // System.out.println(cv1.toString());
        // admin.alocarGestorParaCentroVacinacao(g1, cv1);
        //  System.out.println(cv1.toString());
        RepositorioDoencas repDoencas1 = new RepositorioDoencas();
        repDoencas1.adicionar("Sida");
        repDoencas1.adicionar("Fome");
        rc.adicionar(cv1);
        rc.adicionar(cv2);

        LocalDate data = LocalDate.of(2021, 12, 25);
        LocalDate data2 = LocalDate.of(2021, 11, 25);
        LocalDate data3 = LocalDate.of(2021, 10, 25);

        RepositorioDatasAdministracao datas = new RepositorioDatasAdministracao();
        u1.setCentrovacinacao(cv2);
        u1.setNome("REGADAS");
        u1.setNumSNS("0078965");
        u1.setMorada("Rua joao paulo II");
        u1.setLocalidade("Paradela");
        u1.setNumSNS("938096775");
        u1.setEmail("utente1@gmail.com");
        u1.setDataNasc(LocalDate.parse("2002-11-28"));
        u1.setDoencas(repDoencas1);
        u1.setDataAdministracao(datas);
        //   rc.listarTodosCentrosVacinacoes();
        //System.out.println(rc.existeCentroVacinacao("cv2"));

        //    rc.associarCentroVacinacaoLocalidaeUtente(u1);
        //  rc.associarCentroVacinacao(u1, cv1);
        //   System.out.println(u1.getCentrovacinacao().getLocalidade());
        /*    
        u1.listarDoencas();
        u1.getDoencas().remover("Fome");
        u1.listarDoencas();
        System.out.println(u1.calcularIdade()); */
        cv1.fazerMarcacao(data, u1);
        cv1.fazerMarcacao(data, u2);
        cv1.fazerMarcacao(data, u3);
        System.out.println(cv1.getAgendaMarcacoes().calcularNumeroMarcacoes(data));

        //admin.alocarVacinas(cv2, v2, 200);
        cv2.getListavacinas().adicionarVacina(v2);
        System.out.println(cv2.getStockvacinas().stockDisponivel(v2));
        System.out.println(cv2.getListavacinas().existeVacina(v2));
        System.out.println(cv2.getStockvacinas().stockDisponivel(v2));
        System.out.println(cv2.getGestor());

        u1.getDatasAdministracao().listar();
        System.out.println(u1.getCentrovacinacao().getListavacinas().melhorVacinaParaUtente(u1).getFabricante());
        System.out.println(u1.isVacinado());
        //     cv1.Vacinar(u1);
        System.out.println(u1.isVacinado());
        u1.getDatasAdministracao().listar();
        LocalDate dat1 = LocalDate.of(2023, 3, 11);
        // cv1.gestorMarcaOutraData(u1, dat1);
        // cv1.gestorMarcaOutraData(u1, dat1);

        Utilizador u = new Gestor();
        /*
        //  admin.alocarGestorParaCentroVacinacao(g1, cv2);
        //  System.out.println(cv2.getGestor());
        /*   cv1.getListavacinas().adicionarVacina(v1);
        System.out.println(cv1.getListavacinas().existeVacina(v1));
        System.out.println(cv1.getListavacinas().getNumeroTipoVacina());
        cv1.getListavacinas().removerVacina(v1);
        System.out.println(cv1.getListavacinas().existeVacina(v1));
        System.out.println(cv1.getListavacinas().getNumeroTipoVacina());
         */
        /* cv1.getListavacinas().adicionarVacina(v1);
        cv1.getListavacinas().adicionarVacina(v2);
        System.out.println(cv1.getListavacinas().getNumeroTipoVacina());
        System.out.println(cv1.getListavacinas().getVacina(v2).getFabricante());
        System.out.println(cv1.getListavacinas().toString());*/    }

}
