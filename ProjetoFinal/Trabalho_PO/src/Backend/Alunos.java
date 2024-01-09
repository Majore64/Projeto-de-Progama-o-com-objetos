package Backend;

import java.io.Serializable;

/**
 * A classe {@code Alunos} representa um estudante matriculado em um curso.
 * Implementa a interface {@code Serializable}.
 * Um aluno é caracterizado pelo seu número de mecânica, nome e curso.
 */
public class Alunos implements Serializable {
    
    private String nome;
    private String numMecan;
    private String curso;
   
    /**
     * Construtor que cria uma instância de {@code Alunos} com um número de mecânica, nome e curso fornecidos.
     *
     * @param numMecan O número de mecânica do aluno.
     * @param nome O nome do aluno.
     * @param curso O curso em que o aluno está matriculado.
     */
    public Alunos(String numMecan, String nome, String curso) {
        this.curso = curso; 
        this.nome = nome;
        this.numMecan = numMecan;
    }

    /**
     * Obtém o número de mecânica do aluno.
     *
     * @return O número de mecânica do aluno.
     */
    public String getNumMecan() {
        return numMecan;
    }

    /**
     * Define o número de mecânica do aluno.
     *
     * @param numMecan O novo número de mecânica do aluno.
     */
    public void setNumMecan(String numMecan) {
        this.numMecan = numMecan;
    }

    /**
     * Obtém o nome do aluno.
     *
     * @return O nome do aluno.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do aluno.
     *
     * @param nome O novo nome do aluno.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o curso em que o aluno está matriculado.
     *
     * @return O curso do aluno.
     */
    public String getCurso() {
        return curso;
    }

    /**
     * Define o curso em que o aluno está matriculado.
     *
     * @param curso O novo curso do aluno.
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * Retorna uma representação em formato de string do objeto {@code Alunos}.
     *
     * @return Uma string que representa o objeto {@code Alunos}.
     */
    @Override
    public String toString() {
        return "Alunos{" + "numMecan=" + numMecan + ", nome=" + nome + ", curso=" + curso + '}';
    }
}
