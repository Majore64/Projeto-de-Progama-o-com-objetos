package Backend;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A classe {@code Professores} representa um professor em uma instituição de ensino,
 * estendendo a classe {@code Utilizadores}. Implementa a interface {@code Serializable}.
 */
public class Professores extends Utilizadores implements Serializable {

    private String nomeP;
    private boolean diretor_curso = false;
    private String diretorCursoSigla;
    private ArrayList<String> listaUc;
    private boolean regente_uc = false;
    private String regenteUCSigla;
    private String dataInicio;
    
    /**
     * Construtor padrão de {@code Professores}.
     */
    public Professores(){
        
    }
    
    /**
     * Construtor de {@code Professores} com número, senha e data de início fornecidos.
     *
     * @param novoNum O número do professor.
     * @param novaPass A senha do professor.
     * @param data A data de início do professor.
     */
    public Professores(String novoNum, String novaPass, String data){
        super(novoNum, novaPass);
        dataInicio = data;
        nomeP = ""; 
        listaUc = new ArrayList<>();
    }

    /**
     * Obtém a sigla do curso do qual o professor é diretor, se aplicável.
     *
     * @return A sigla do curso.
     */
    public String getDiretorCursoSigla() {
        return diretorCursoSigla;
    }

    /**
     * Define a sigla do curso do qual o professor é diretor.
     *
     * @param diretorCursoSigla A nova sigla do curso.
     */
    public void setDiretorCursoSigla(String diretorCursoSigla) {
        this.diretorCursoSigla = diretorCursoSigla;
    }

    /**
     * Obtém a sigla da Unidade Curricular da qual o professor é regente, se aplicável.
     *
     * @return A sigla da Unidade Curricular.
     */
    public String getRegenteUCSigla() {
        return regenteUCSigla;
    }

    /**
     * Define a sigla da Unidade Curricular da qual o professor é regente.
     *
     * @param regenteUCSigla A nova sigla da Unidade Curricular.
     */
    public void setRegenteUCSigla(String regenteUCSigla) {
        this.regenteUCSigla = regenteUCSigla;
    }

    /**
     * Obtém a lista de siglas das Unidades Curriculares associadas ao professor.
     *
     * @return A lista de siglas das Unidades Curriculares.
     */
    public ArrayList<String> getListaUc() {
        return listaUc;
    }

    /**
     * Obtém a data de início do professor.
     *
     * @return A data de início do professor.
     */
    public String getDataIn() {
        return dataInicio;
    }

    /**
     * Define a data de início do professor.
     *
     * @param novaDataIn A nova data de início do professor.
     */
    public void setDataIn(String novaDataIn) {
        dataInicio = novaDataIn;
    }

    /**
     * Obtém o nome do professor.
     *
     * @return O nome do professor.
     */
    public String getNome() {
        return nomeP;
    }

    /**
     * Define o nome do professor.
     *
     * @param novoNome O novo nome do professor.
     */
    public void setNome(String novoNome) {
        nomeP = novoNome;
    }

    /**
     * Verifica se o professor é diretor de curso.
     *
     * @return {@code true} se o professor for diretor de curso, {@code false} caso contrário.
     */
    public boolean isDiretor_curso() {
        return diretor_curso;
    }

    /**
     * Define se o professor é diretor de curso.
     *
     * @param diretor_curso {@code true} se o professor for diretor de curso, {@code false} caso contrário.
     */
    public void setDiretor_curso(boolean diretor_curso) {
        this.diretor_curso = diretor_curso;
    }

    /**
     * Verifica se o professor é regente de Unidade Curricular.
     *
     * @return {@code true} se o professor for regente de Unidade Curricular, {@code false} caso contrário.
     */
    public boolean isRegente_uc() {
        return regente_uc;
    }

    /**
     * Define se o professor é regente de Unidade Curricular.
     *
     * @param regente_uc {@code true} se o professor for regente de Unidade Curricular, {@code false} caso contrário.
     */
    public void setRegente_uc(boolean regente_uc) {
        this.regente_uc = regente_uc;
    }

    /**
     * Retorna uma representação em formato de string do objeto {@code Professores}.
     *
     * @return Uma string que representa o objeto {@code Professores}.
     */
    @Override
    public String toString() {
        return "Professores{" + "nome='" + nomeP + "', dataInicio='" + dataInicio + "'}";
    }
}
