package Backend;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileOutputStream;

/**
 * A classe {@code Sistema} representa o sistema principal da aplicação.
 * É responsável por gerenciar listas de utilizadores, cursos e unidades curriculares,
 * além de fornecer métodos para manipular e persistir essas informações.
 */
public class Sistema {

    private final ArrayListCursos listaCu;
    private final ArrayListUCs listaUC;
    private ArrayListUtilizadores listaU;

    /**
     * Construtor que inicializa o sistema com listas de utilizadores, cursos e unidades curriculares fornecidas.
     *
     * @param listaUtilizadores A lista de utilizadores.
     * @param listaUC           A lista de unidades curriculares.
     * @param listaCursos       A lista de cursos.
     */
    public Sistema(ArrayListUtilizadores listaUtilizadores, ArrayListUCs listaUC, ArrayListCursos listaCursos) {
        this.listaU = listaUtilizadores;
        this.listaUC = listaUC;
        this.listaCu = listaCursos;
    }

    /**
     * Obtém a lista de unidades curriculares.
     *
     * @return A lista de unidades curriculares.
     */
    public ArrayListUCs getListaUC() {
        return listaUC;
    }

    /**
     * Obtém a lista de cursos.
     *
     * @return A lista de cursos.
     */
    public ArrayListCursos getListaCursos() {
        return listaCu;
    }

    /**
     * Obtém a lista de utilizadores.
     *
     * @return A lista de utilizadores.
     */
    public ArrayListUtilizadores getListaUtil() {
        return listaU;
    }

    /**
     * Verifica se um utilizador com o número de mecanografia e senha fornecidos existe na lista de utilizadores.
     *
     * @param numMecan O número de mecanografia do utilizador.
     * @param pass     A senha do utilizador.
     * @return 1 se o utilizador existe, 0 se não.
     */
    public int verificaU(String numMecan, String pass) {
        for (Utilizadores u : listaU.getLista()) {
            if (numMecan.equals(u.getNumMecan()) && pass.equals(u.getPass())) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Encontra e retorna um curso com a sigla fornecida.
     *
     * @param sigla A sigla do curso.
     * @return O curso correspondente à sigla fornecida, ou null se não for encontrado.
     */
    public Curso pCurso(String sigla) {
        for (Curso c : listaCu.getLista()) {
            if (c.getSigla().equals(sigla)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Encontra e retorna um professor com o número de mecanografia fornecido.
     *
     * @param numMecan O número de mecanografia do professor.
     * @return O professor correspondente ao número de mecanografia fornecido, ou null se não for encontrado.
     */
    public Professores pProf(String numMecan) {
        for (Utilizadores uti : listaU.getLista()) {
            if (uti instanceof Professores && ((Professores) uti).getNumMecan().equals(numMecan)) {
                return (Professores) uti;
            }
        }
        return null;
    }

    /**
     * Encontra e retorna um administrador com o número de mecanografia fornecido.
     *
     * @param numMecan O número de mecanografia do administrador.
     * @return O administrador correspondente ao número de mecanografia fornecido, ou null se não for encontrado.
     */
    public Administrador pAdmin(String numMecan) {
        for (Utilizadores uti : listaU.getLista()) {
            if (uti instanceof Administrador && ((Administrador) uti).getNumMecan().equals(numMecan)) {
                return (Administrador) uti;
            }
        }
        return null;
    }

    /**
     * Encontra e retorna um aluno em um curso específico com o número de mecanografia fornecido.
     *
     * @param c        O curso do aluno.
     * @param numMecan O número de mecanografia do aluno.
     * @return O aluno correspondente ao número de mecanografia fornecido no curso especificado, ou null se não for encontrado.
     */
    public Alunos pAlunos(Curso c, String numMecan) {
        for (Alunos a : c.getAlunosCurso().getLista()) {
            if (a.getNumMecan().equals(numMecan)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Encontra e retorna uma unidade curricular com a sigla fornecida.
     *
     * @param sigla A sigla da unidade curricular.
     * @return A unidade curricular correspondente à sigla fornecida, ou null se não for encontrada.
     */
    public UCs pUC(String sigla) {
        for (UCs uc : listaUC.getLista()) {
            if (uc.getSigla().equals(sigla)) {
                return uc;
            }
        }
        return null;
    }

    /**
     * Adiciona o nome fornecido a um professor existente.
     *
     * @param p    O professor a ser modificado.
     * @param nome O novo nome do professor.
     */
    public void adicionarProfPorNome(Professores p, String nome) {
        if (p != null) {
            p.setNome(nome);
            System.out.println(p.toString());
        } else {
            System.err.println("Ocorreu um erro!");
        }
    }

    /**
     * Exibe os professores associados a um curso.
     *
     * @param curso O curso para o qual se deseja listar os professores.
     */
    public void ProfPorCurso(Curso curso) {
        for (String ucSigla : curso.getListaUcs()) {
            UCs uc = pUC(ucSigla);
            if (uc != null) {
                System.out.println("Professores da UC " + ucSigla + ":");
                for (String pNumMecan : uc.getEquipa()) {
                    Professores professor = pProf(pNumMecan);
                    System.out.println(professor.toString());
                }
            } else {
                System                .err.println("Ocorreu um erro!");
            }
        }
    }

    /**
     * Exibe os alunos inscritos em um curso.
     *
     * @param cursito O curso para o qual se deseja listar os alunos.
     */
    public void AlunosPoCurso(Curso cursito) {
        System.out.println("Alunos inscritos no Curso " + cursito.getSigla() + ":");
        for (Alunos a : cursito.getAlunosCurso().getLista()) {
            System.out.println(a.toString());
        }
    }

    /**
     * Exibe as unidades curriculares associadas a um professor.
     *
     * @param professor O professor para o qual se deseja listar as unidades curriculares.
     */
    public void ProfPorUc(Professores professor) {
        for (String ucSigla : professor.getListaUc()) {
            UCs uc = pUC(ucSigla);
            System.out.println(uc.toString());
        }
    }

    /**
     * Exibe os sumários associados a um aluno.
     *
     * @param numMecanAl O número de mecanografia do aluno.
     */
    public void pAlSumario(String numMecanAl) {
        for (Curso u : getListaCursos().getLista()) {
            for (String ucSigla : u.getListaUcs()) {
                UCs uc = pUC(ucSigla);
                for (Sumario sum : uc.getSumariosUC().getLista()) {
                    for (String numMecan : sum.getAlunosPresentes()) {
                        if (numMecan.equals(numMecanAl)) {
                            System.out.println(sum.toString());
                        }
                    }
                }
            }
        }
    }

    //Ficheiros

    /**
     * Salva as listas de utilizadores, cursos e unidades curriculares em arquivos específicos.
     *
     * @param ArquivoU      O nome do arquivo para salvar a lista de utilizadores.
     * @param ArquivoUCs    O nome do arquivo para salvar a lista de unidades curriculares.
     * @param ArquivoCursos O nome do arquivo para salvar a lista de cursos.
     */
    public void SalvarEmArquivo(String ArquivoU, String ArquivoUCs, String ArquivoCursos) {
        salvarListaEmArquivo(listaU.getLista(), ArquivoU);
        salvarListaEmArquivo(listaUC.getLista(), ArquivoUCs);
        salvarListaEmArquivo(listaCu.getLista(), ArquivoCursos);
    }

    /**
     * Salva uma lista de objetos em um arquivo.
     *
     * @param List          A lista de objetos a ser salva.
     * @param FilePrincipal O nome do arquivo onde a lista será salva.
     * @param <Vi>          O tipo dos objetos na lista.
     */
    private <Vi> void salvarListaEmArquivo(ArrayList<Vi> List, String FilePrincipal) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FilePrincipal))) {
            oos.writeObject(List);
            System.out.println("Lista salva em: " + FilePrincipal);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Não foi possível salvar em: " + FilePrincipal);
        }
    }

    /**
     * Carrega as listas de utilizadores, cursos e unidades curriculares de arquivos específicos.
     *
     * @param ArquivoU      O nome do arquivo para carregar a lista de utilizadores.
     * @param ArquivoUCs    O nome do arquivo para carregar a lista de unidades curriculares.
     * @param ArquivoCursos O nome do arquivo para carregar a lista de cursos.
     */
    public void carregarEmArquivo(String ArquivoU, String ArquivoUCs, String ArquivoCursos) {
        listaU.setLista(carregarListaDeArquivo(ArquivoU));
        listaUC.setLista(carregarListaDeArquivo(ArquivoUCs));
        listaCu.setLista(carregarListaDeArquivo(ArquivoCursos));
    }

    /**
     * Carrega uma lista de objetos de um arquivo.
     *
     * @param FilePrincipal O nome do arquivo de onde a lista será carregada.
     * @param <Vi>          O tipo dos objetos na lista.
     * @return A lista de objetos carregada do arquivo.
     */
    private <Vi> ArrayList<Vi> carregarListaDeArquivo(String FilePrincipal) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FilePrincipal))) {
            return (ArrayList<Vi>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar a lista do arquivo " + FilePrincipal);
            return new ArrayList<>();
        }
    }
}

