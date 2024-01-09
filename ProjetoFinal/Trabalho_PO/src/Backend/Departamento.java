package Backend;

import java.io.Serializable;

/**
 * A classe {@code Departamento} representa um departamento acadêmico em uma instituição de ensino.
 * Implementa a interface {@code Serializable}.
 */
public class Departamento implements Serializable {
    
    private String nomeD;
    private String siglaD;
    
    /**
     * Construtor que cria uma instância de {@code Departamento} com um nome e sigla fornecidos.
     *
     * @param nome O nome do departamento.
     * @param sigla A sigla do departamento.
     */
    public Departamento(String nome, String sigla) {
        this.nomeD = nome;
        this.siglaD = sigla;
    }

    /**
     * Obtém a sigla do departamento.
     *
     * @return A sigla do departamento.
     */
    public String getSigla() {
        return siglaD;
    }

    /**
     * Define a sigla do departamento.
     *
     * @param sigla A nova sigla do departamento.
     */
    public void setSigla(String sigla) {
        this.siglaD = sigla;
    }
    
    /**
     * Obtém o nome do departamento.
     *
     * @return O nome do departamento.
     */
    public String getNome() {
        return nomeD;
    }

    /**
     * Define o nome do departamento.
     *
     * @param nome O novo nome do departamento.
     */
    public void setNome(String nome) {
        this.nomeD = nome;
    }
}
