package Frontend;

import Backend.Administrador;
import Backend.ArrayListCursos;
import Backend.ArrayListUtilizadores;
import Backend.Sistema;
import Backend.Professores;
import Backend.ArrayListUCs;
import java.io.File;

/**
 * A classe MenuGeral representa o menu principal do sistema.
 */
public class MenuGeral {

    private final ComandosConsola InfoConsola = new ComandosConsola();
    private final Sistema sistema;

    /**
     * Construtor da classe MenuGeral.
     *
     * @param sistema O sistema associado ao menu.
     */
    public MenuGeral(Sistema sistema) {
        this.sistema = sistema;
    }

    /**
     * Método principal que inicia o programa.
     *
     * @param args Os argumentos da linha de comando (não utilizados neste caso).
     */
    public static void main(String[] args) {
        ArrayListUtilizadores listaUtilizadores = new ArrayListUtilizadores();
        ArrayListCursos listaCursos = new ArrayListCursos();
        ArrayListUCs listaUC = new ArrayListUCs();
        Sistema sistema = new Sistema(listaUtilizadores, listaUC, listaCursos);

        MenuGeral MenuAqui = new MenuGeral(sistema);

        System.out.println(new File("utilizadores.txt").getAbsolutePath());
        System.out.println(new File("ucs.txt").getAbsolutePath());
        System.out.println(new File("cursos.txt").getAbsolutePath());

        System.out.println("Diretório: " + System.getProperty("user.dir"));

        sistema.carregarEmArquivo("utilizadores.txt", "ucs.txt", "cursos.txt");

        int option = 0;
        do {
            System.out.println("--------Menu Principal--------");
            String[] opcoes = {
                "Criar Conta",
                "Login",
                "Sair"};
            option = MenuAqui.InfoConsola.lerInt(opcoes);

            switch (option) {
                case 1:
                    int op = MenuAqui.criarConta();
                    if (op > 2 || op == 0) {
                        break;
                    }
                case 2:
                    MenuAqui.loginConta();
                    break;
                case 3:
                    sistema.SalvarEmArquivo("utilizadores.txt", "ucs.txt", "cursos.txt");
            }
        } while (option != 3);
    }

    /**
     * Cria uma nova conta de utilizador.
     *
     * @return Um código de verificação indicando o tipo de conta criada.
     */
    private int criarConta() {
        int verifica = 0;
        InfoConsola.Esc("CRIAR CONTA:");
        String numeroMecanografico = InfoConsola.LerStr("Introduza o numero mecanografico: ");
        String palavraChave = InfoConsola.LerStr("Introduza a palavra chave:");

        verifica = InfoConsola.lerNumberMecanog(numeroMecanografico);
        if (verifica == 1) {
            if (sistema.pProf(numeroMecanografico) == null) {
                String dataIn = InfoConsola.LeituraData("Indique a data de hoje (dd-mm-aa):");
                Professores p = new Professores(numeroMecanografico, palavraChave, dataIn);
                sistema.getListaUtil().inserir(p);
            } else {
                InfoConsola.EscErro("Numero mecanografico ja utilizado!");
                verifica = 3;
            }
        }
        if (verifica == 2) {
            if (sistema.pAdmin(numeroMecanografico) == null) {
                Administrador admin = new Administrador(numeroMecanografico, palavraChave);
                sistema.getListaUtil().inserir(admin);
            } else {
                InfoConsola.EscErro("Numero mecanografico ja utilizado!");
                verifica = 3;
            }
        }
        InfoConsola.LerStr(sistema.getListaUtil().toString());
        return verifica;
    }

    /**
     * Realiza o login de um utilizador existente.
     */
    private void loginConta() {
        int verifica = 0;
        InfoConsola.Esc("LOGIN:");
        String NumeroMecanografico = InfoConsola.LerStr("Numero mecanografico: ");
        String passChave = InfoConsola.LerStr("Palavra chave:");

        verifica = sistema.verificaU(NumeroMecanografico, passChave);

        switch (verifica) {
            case 1 -> {
                verifica = InfoConsola.lerNumberMecanog(NumeroMecanografico);
                if (verifica == 1) {
                    MenuDoProfessor menuProf = new MenuDoProfessor(sistema);
                    Professores professor = sistema.pProf(NumeroMecanografico);
                    menuProf.Menu(professor);
                }
                if (verifica == 2) {
                    MenuAd administrador = new MenuAd(sistema);
                    Administrador ad = sistema.pAdmin(NumeroMecanografico);
                    administrador.Menu(ad);
                }
            }
            case 0 -> InfoConsola.EscErro("Utilizador não encontrado!");
        }
    }
}
