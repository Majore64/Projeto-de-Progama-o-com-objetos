package Frontend;

import Backend.Alunos;
import Backend.Curso;
import Backend.UCs;
import Backend.Professores;
import Backend.Sistema;
import Backend.Sumario;

/**
 * A classe MenuDoProfessor representa o menu disponível para um professor no sistema.
 */

public class MenuDoProfessor {

    private ComandosConsola InfoConsola = new ComandosConsola();
    private Sistema sistema;

    /**
     * Construtor da classe MenuDoProfessor.
     *
     * @param sistema O sistema ao qual o professor está associado.
     */
    
    public MenuDoProfessor(Sistema sistema) {
        this.sistema = sistema;
    }

     /**
     * Apresenta o menu para um professor e processa as opções escolhidas.
     *
     * @param professor O professor para o qual o menu está sendo apresentado.
     */
    
    public void Menu(Professores professor) {
        MenuDoProfessor ProfessorMenu = new MenuDoProfessor(sistema);
        int opcao = 0;

        if (professor.isDiretor_curso() == false && professor.isRegente_uc() == false) {
            do {
                InfoConsola.Esc("\n\n----MENU DO PROFESSOR----\n");
                String[] opcoes = {
                    "Consultar Servicos de Docentes",
                    "Criar Sumario",                                       
                    "Sair"};
                opcao = ProfessorMenu.InfoConsola.lerInt(opcoes);

                switch (opcao) {
                    case 1 -> {
                         InfoConsola.Esc("");
                         ProfessorMenu.LServicoDocente(professor);
                    }
                    case 2 -> {
                        InfoConsola.Esc("");
                        ProfessorMenu.CriarSumarios(professor);
                    }                                                              
                    case 3 -> {
                        break;
                    }

                }
            } while (opcao != 4);
        }
        if (professor.isDiretor_curso() == false && professor.isRegente_uc() == true) { 
            do {
                InfoConsola.Esc("----MENU DE PROFESSORES----");
                String[] opcoes = {
                    "Criar Sumario",
                    "Adicionar Alunos",
                    "Remover Alunos",
                    "Consultar Servicos de Docentes",                    
                    "Sair"};
                opcao = ProfessorMenu.InfoConsola.lerInt(opcoes);

                switch (opcao) {
                    case 1 -> {
                        InfoConsola.Esc("");
                        ProfessorMenu.CriarSumarios(professor);
                    }   
                    
                    case 2 -> {
                        InfoConsola.Esc("");
                        ProfessorMenu.AdicionarAlunos();
                    }
                    case 3 -> {
                        InfoConsola.Esc("");
                        ProfessorMenu.RemoverAlunos();
                    }
                    case 4 -> {
                        InfoConsola.Esc("");
                        ProfessorMenu.LServicoDocente(professor);
                    }                   
                    case 5 -> {
                    }
                }
            } while (opcao != 6);
        }
        if (professor.isDiretor_curso() == true && professor.isRegente_uc() == false) { //Professore diretor
            do {
                InfoConsola.Esc("----Menu de Professores----");
                String[] opcoes = {
                    "Alterar nome do Curso",
                    "Fazer listagem de professores do Curso",
                    "Fazer listagem de alunos do Curso",
                    "Criar Sumario",                    
                    "Consultar Servicos de Docentes",                  
                    "Sair"};
                
                opcao = ProfessorMenu.InfoConsola.lerInt(opcoes);

                switch (opcao) {
                    case 1 -> ProfessorMenu.AlterarDesignacaoDoCurso(professor);
                    case 2 -> ProfessorMenu.ListaProfC(professor);
                    case 3 -> ProfessorMenu.ListaAlunosC(professor);
                    case 4 -> ProfessorMenu.CriarSumarios(professor);
                    case 5 -> ProfessorMenu.LServicoDocente(professor);                   
                    case 6 -> {
                    }
                }
            } while (opcao != 7);
        }

        if (professor.isDiretor_curso() == true && professor.isRegente_uc() == true) { //Professore diretor e regente
            do {
                InfoConsola.Esc("----Menu de Professores----");
                String[] opcoes = {
                    "Alterar nome do Curso",
                    "Fazer listagem de professores do Curso",
                    "Fazer listagem de alunos do Curso",                   
                    "Adicionar Alunos",
                    "Remover Alunos", 
                    "Criar Sumario", 
                    "Consultar Servicos de Docentes",
                    "Sair"};
                opcao = ProfessorMenu.InfoConsola.lerInt(opcoes);

                switch (opcao) {
                    case 1 -> ProfessorMenu.AlterarDesignacaoDoCurso(professor);
                    case 2 -> ProfessorMenu.ListaProfC(professor);
                    case 3 -> ProfessorMenu.ListaAlunosC(professor);
                    case 4 -> ProfessorMenu.AdicionarAlunos();
                    case 5 -> ProfessorMenu.RemoverAlunos();
                    case 6 -> ProfessorMenu.CriarSumarios(professor);
                    case 7 -> ProfessorMenu.LServicoDocente(professor);                                      
                    case 8 -> {
                    }
                }
            } while (opcao != 9);
        }

    }

    /**
     * Cria sumários para uma Unidade Curricular.
     *
     * @param p O professor responsável pelos sumários.
     */
    
    public void CriarSumarios(Professores p) {
        String siglaUC = InfoConsola.LerStr("Indique a sigla da UnidadeCurricular");
        UCs unidadeC = sistema.pUC(siglaUC);
        if (unidadeC != null) {
            int opcao;
            String tipo = null;
            String data;
            String cont;

            InfoConsola.Esc("Indique o tipo de aula frequentadas:");
            String[] opcoes = {"T", "TP", "PL"};
            String NM;
            Sumario sumarioT;
            opcao = InfoConsola.lerInt(opcoes);

            switch (opcao) {
                case 1 -> tipo = "T";
                case 2 -> tipo = "TP";
                case 3 -> tipo = "PL";

            }
            data = InfoConsola.LeituraData("Indique a data (dd-mm-aa):");
            cont = InfoConsola.LerStr("Indique o sumario da aula: ");
            sumarioT = new Sumario(data, p.getNumMecan(), tipo);
            sumarioT.setConteudo(cont);
            int nA = InfoConsola.ReadInteger("Indique o numero total de alunos na aula:");
            for(int i = 0; i<nA; i++){
                NM = InfoConsola.LerStr("Indique o numero mecanografico do aluno:");
                sumarioT.getAlunosPresentes().add(NM);
            }
            unidadeC.getSumariosUC().getLista().add(sumarioT);
        } else {
            InfoConsola.EscErro("Sigla de UC desconhecida!");
        }
    }

    /**
     * Lista os serviços de docência do professor.
     *
     * @param prof O professor para o qual os serviços de docência serão listados.
     */

    public void LServicoDocente(Professores prof) {
        sistema.ProfPorUc(prof);
    }
    
     /**
     * Lista os professores associados a um curso.
     *
     * @param prof O professor diretor do curso.
     */
    
     public void ListaProfC(Professores prof) {
        Curso curso = sistema.pCurso(prof.getDiretorCursoSigla());
        if (curso != null) {
            InfoConsola.Esc("Professores:");
            sistema.ProfPorCurso(curso);
        } else {
            InfoConsola.EscErro("Sigla desconhecida!");
        }
    }

     /**
     * Altera a designação de um curso.
     *
     * @param prof O professor diretor do curso.
     */
     
     public void AlterarDesignacaoDoCurso(Professores prof) {
        Curso curso = sistema.pCurso(prof.getDiretorCursoSigla());
        if (curso != null) {
            String novaN = InfoConsola.LerStr("Indique o novo nome do curso:");
            curso.setDesig(novaN);
        } else {
            InfoConsola.EscErro("Sigla desconhecida!");
        }
    }
  
     /**
     * Lista os alunos associados a um curso.
     *
     * @param prof O professor diretor do curso.
     */
     
   public void ListaAlunosC(Professores prof){
        Curso curso = sistema.pCurso(prof.getDiretorCursoSigla());
        sistema.AlunosPoCurso(curso);
    }   

    /**
     * Remove alunos de um curso.
     */
   
    public void RemoverAlunos() {
        String CursoS = InfoConsola.LerStr("Indique a sigla do curso:");
        Curso curso = sistema.pCurso(CursoS);
        if (curso != null) {
            String numMecanA = InfoConsola.LerStr("Indique o numero mecanografico do Aluno:");
            Alunos Aluno = sistema.pAlunos(curso, numMecanA);
            if (Aluno != null) {
                curso.getAlunosCurso().getLista().remove(Aluno);
            } else {
                InfoConsola.EscErro("Aluno nao pertencente ao curso");
            }
        } else {
            InfoConsola.EscErro("Sigla desconhecida!");
        }
    }

    /**
     * Adiciona alunos a um curso.
     */
    
     public void AdicionarAlunos() {
        String CursoS = InfoConsola.LerStr("Indique a sigla do curso:");
        Curso curso = sistema.pCurso(CursoS);
        if (curso != null) {
            String numMecan = InfoConsola.LerStr("Indique o numero mecanografico do aluno:");
            String nome = InfoConsola.LerStr("Indique o nome do aluno:");
            Alunos aluno = new Alunos(numMecan, nome, CursoS);
            curso.getAlunosCurso().getLista().add(aluno);
        } else {
            InfoConsola.EscErro("Sigla desconhecida!");
        }
    }
        
}
