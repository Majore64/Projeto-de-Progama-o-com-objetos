package Frontend;

import Backend.Sistema;
import Backend.Professores;
import Backend.UCs;
import Backend.Administrador;
import Backend.Utilizadores;
import Backend.Curso;
import java.util.ArrayList;

/**
 * A classe MenuAd representa o menu de interação para o tipo de utilizador Administrador.
 */
public class MenuAd {

    private ComandosConsola InfoConsola = new ComandosConsola();
    private Sistema sistema;

    /**
     * Construtor da classe MenuAd.
     *
     * @param sistema O sistema que contém as informações necessárias.
     */
    public MenuAd(Sistema sistema) {
        this.sistema = sistema;
    }

    /**
     * Exibe e gere as opções do menu para um Administrador.
     *
     * @param ad O Administrador
     */
    public void Menu(Administrador ad) {
        MenuAd menuAdmin = new MenuAd(sistema);

        int opcao = 0;
        do {
            InfoConsola.Esc("\n\n------MENU ADMINISTRADOR------\n");
            String[] op = {
                "Adicionar referencias dos professores",
                "Apagar referencias dos professores",                
                "Direção de curso",
                "Alterar referencias de cursos",               
                "Registar Cursos",
                "Regencia de UnidadeCurricular",
                "Alterar referencias UnidadeCurricular",               
                "Registar UnidadeCurricular",
                "Listar UnidadeCurricular",
                "Listar cursos",               
                "Listar Professores",
                "Listar Alunos",                
                "Sair"};

            opcao = menuAdmin.InfoConsola.lerInt(op);

            switch (opcao) {
                case 1 -> {
                    InfoConsola.Esc("");
                    menuAdmin.addProf(); 
                }
                case 2 -> {
                    InfoConsola.Esc("");
                    menuAdmin.EliminarProfessor(); 
                }   
                case 3 -> {
                    InfoConsola.Esc("");
                    menuAdmin.AtribuirDirecaoDeCurso();  
                }              
                case 4 -> {
                    InfoConsola.Esc("");
                    menuAdmin.AlterarCurso(); 
                }
                 case 5 -> {
                    InfoConsola.Esc("");
                    menuAdmin.RegistrarCurso(); 
                    
                } case 6 -> {
                    InfoConsola.Esc("");
                    menuAdmin.AtribuirRegenteUc();  
                    
                }case 7 -> {
                    InfoConsola.Esc("");
                    menuAdmin.AlterarUnidadeCurricular();  
                            
                }                
                case 8 -> {
                    InfoConsola.Esc("");
                    menuAdmin.registrarUC();  
                
                } case 9 -> {
                    InfoConsola.Esc("");
                    menuAdmin.ListarUnidadeCurricular();  
                }
                case 10 -> {
                    InfoConsola.Esc("");
                    menuAdmin.ListarCursos(); 
                }                        
                 case 11 -> {
                    InfoConsola.Esc("");
                    menuAdmin.ListarProfessores(); 
                }
                case 12 -> {
                    InfoConsola.Esc("");
                    menuAdmin.ListarAlunos();  
                }             
                case 13 -> InfoConsola.Esc("");

            }
        } while (opcao != 13);
    }

    /**
     * Adiciona referências aos professores.
     */
    public void addProf() {
        String numMecan = InfoConsola.LerStr("Indique o numero mecanografico do professor");
        int verificar = InfoConsola.lerNumberMecanog(numMecan);

        if (verificar == 1) {
            int opcao;
            do {
                Professores professor = sistema.pProf(numMecan);

                if (professor != null) {
                    InfoConsola.Esc("\nAdicionar referencias dos professores:");
                    String[] opcoes = {
                        "Adicionar nome",
                        "Adicionar UC",
                        "Sair"
                    };

                    opcao = InfoConsola.lerInt(opcoes);

                    switch (opcao) {
                        case 1 -> {
                            String nome = InfoConsola.LerStr("Indique o nome:");
                            sistema.adicionarProfPorNome(professor, nome);
                        }

                        case 2 -> {
                            String SiglaUc = InfoConsola.LerStr("Indique a sigla da UnidadeCurricular:");
                            UCs UnidadeC = sistema.pUC(SiglaUc);

                            if (UnidadeC != null) {
                                if (UnidadeC.getEquipa() == null) {
                                    UnidadeC.setEquipa(new ArrayList<>());
                                }

                                professor.getListaUc().add(SiglaUc);
                                UnidadeC.getEquipa().add(professor.getNumMecan());
                            } else {
                                InfoConsola.EscErro("Erro sigla de uc não encontrada!");
                            }
                        }

                        case 3 -> {
                        }
                    }
                } else {
                    InfoConsola.EscErro("Erro: Professor não encontrado!");
                    opcao = 3; // Força a saída do loop se o professor não for encontrado
                }
            } while (opcao != 3);
        } else {
            InfoConsola.EscErro("Erro: Número mecanográfico de professor não encontrado!");
        }
    }

    /**
     * Elimina um professor.
     */
    public void EliminarProfessor() {
        String numeroMecanografico = InfoConsola.LerStr("Indique o numero mecanografico");
        int verficicar = InfoConsola.lerNumberMecanog(numeroMecanografico);
        if (verficicar == 1) {
            Professores professor = sistema.pProf(numeroMecanografico);
            if (professor != null) {
                sistema.getListaUtil().remove(professor);
                InfoConsola.Esc("Professor foi eliminado do FilePrincipal");
            } else {
                InfoConsola.EscErro(" Professor desconhecido!");
            }
        } else {
            InfoConsola.EscErro("Numero Mecanografico desconhecido!");
        }
    }

    /**
     * Atribui a direção de um curso a um professor.
     */
    public void AtribuirDirecaoDeCurso() {
        String sigla = InfoConsola.LerStr("Indique a sigla do curso:");
        Curso curso = sistema.pCurso(sigla);
        if (curso != null) {
            String NUM_M = InfoConsola.LerStr("Indique o numero mecanografico");
            int verifica = InfoConsola.lerNumberMecanog(NUM_M);
            if (verifica == 1) {
                Professores professor = sistema.pProf(NUM_M);
                if (professor != null) {
                    curso.setDiretor(professor);
                    professor.setDiretor_curso(true);
                    professor.setDiretorCursoSigla(sigla);
                    InfoConsola.Esc(curso.toString());
                } else {
                    InfoConsola.EscErro("Professor nao encontrado!");
                }
            } else {
                InfoConsola.EscErro("Numero mecanografico de professor nao encontrado!");
            }
        } else {
            InfoConsola.EscErro("Sigla de curso nao existente!");
        }
    }

    /**
     * Altera a designação de um curso.
     */
    public void AlterarCurso() {
        String Sigla = InfoConsola.LerStr("Indique a sigla do curso em questao:");
        Curso curso = sistema.pCurso(Sigla);
        if (curso != null) {
            String desig = InfoConsola.LerStr("Indique por extenso o curso:");
            curso.setDesig(desig);           
            InfoConsola.Esc(curso.toString());
        } else {
            InfoConsola.EscErro("Sigla não existe!");
        }
    }

    /**
     * Regista um novo curso.
     */
    public void RegistrarCurso() {
        String Sigla = InfoConsola.LerStr("Indique a sigla do curso em questao EX:LEGSI:");
        Curso cursito = sistema.pCurso(Sigla);
        if (cursito == null) {
            String desig = InfoConsola.LerStr("Indique por extenso o curso:");
            cursito = new Curso(Sigla, desig);
            sistema.getListaCursos().inserir(cursito);           
            InfoConsola.Esc(cursito.toString());
        } else {
            InfoConsola.EscErro("Sigla ja existe!");
        }
    }

    /**
     * Atribui a regência de uma Unidade Curricular a um professor.
     */
    public void AtribuirRegenteUc() {
        String S = InfoConsola.LerStr("Sigla da UnidadeCurricular:");
        UCs UnidadeCurricular = sistema.pUC(S);
        if (UnidadeCurricular != null) {
            String NumeroMecanog = InfoConsola.LerStr("Numero mecanografico");
            int veri = InfoConsola.lerNumberMecanog(NumeroMecanog);
            if (veri == 1) {
                Professores professor = sistema.pProf(NumeroMecanog);
                if (professor != null) {
                    UnidadeCurricular.setRegente(professor);
                    professor.setRegente_uc(true);
                    professor.setRegenteUCSigla(S);
                } else {
                    InfoConsola.EscErro("Professor desconhecido!");
                }
            } else {
                InfoConsola.EscErro("Numero Mecanografico Desconhecido!");
            }
        } else {
            InfoConsola.EscErro("Sigla de unidadeCurricular desconhecida!");
        }
    }

    /**
     * Altera a designação de uma Unidade Curricular.
     */
    public void AlterarUnidadeCurricular() {
        String S = InfoConsola.LerStr("Sigla:");
        UCs UnidadeCurricular = sistema.pUC(S);
        if (UnidadeCurricular != null) {
            int opcao = 0;
            do {
                InfoConsola.Esc("\nAdicionar referencias dos professores:");
                String[] opti = {
                    "Alterar designacao",
                    "Sair"};
                opcao = InfoConsola.lerInt(opti);

                switch (opcao) {
                    case 1 -> {
                        String designacao = InfoConsola.LerStr("Nova designacao");
                        UnidadeCurricular.setDesig(designacao);
                    }
                    case 2 -> {
                    }
                }
            } while (opcao != 2);
        } else {
            InfoConsola.EscErro("Sigla nao existente!");
        }
    }

    /**
     * Regista uma nova Unidade Curricular.
     */
    public void registrarUC() {
        String sigla = InfoConsola.LerStr("Indique a sigla da Unidade Curriclar :");
        UCs UnidadeC = sistema.pUC(sigla);
        if (UnidadeC == null) {
            UnidadeC = new UCs();
            UnidadeC.setSigla(sigla);
            String designacao = InfoConsola.LerStr("Indique a designacao da Unidade Curricular:");
            UnidadeC.setDesig(designacao);
            String siglaCurso = InfoConsola.LerStr("Indique a sigla do curso a que pertence:");
            Curso Curso = sistema.pCurso(siglaCurso);
            if (Curso != null) {
                sistema.getListaUC().inserir(UnidadeC);
                Curso.getListaUcs().add(sigla);
            } else {
                InfoConsola.EscErro("Sigla de curso nao existente!");
            }
        } else {
            InfoConsola.EscErro("Sigla de UC ja existe!");
        }
    }

    /**
     * Lista todos os alunos.
     */
    public void ListarAlunos() {
        InfoConsola.Esc("\nLista de todos os alunos:");
        for (Curso curso : sistema.getListaCursos().getLista()) {
            sistema.AlunosPoCurso(curso);
        }
    }

    /**
     * Lista todos os professores.
     */
    public void ListarProfessores() {
        InfoConsola.Esc("\nLista de todos os professores:");
        for (Utilizadores unidadecurricular : sistema.getListaUtil().getLista()) {
            if (unidadecurricular instanceof Professores professor) {
                InfoConsola.Esc(professor.toString());
            }
        }
    }

    /**
     * Lista todas as Unidades Curriculares.
     */
    public void ListarUnidadeCurricular() {
        InfoConsola.Esc("\nLista de todas as Unidades Curriculares:");
        for(UCs UnidadeCurricular : sistema.getListaUC().getLista()) {
            InfoConsola.Esc(UnidadeCurricular.toString());
        }
    }

    /**
     * Lista todos os cursos.
     */
    public void ListarCursos() {
        InfoConsola.Esc("\nLista de todos Cursos:");
        for (Curso curso : sistema.getListaCursos().getLista()) {
            InfoConsola.Esc(curso.toString());
        }
    }
}

