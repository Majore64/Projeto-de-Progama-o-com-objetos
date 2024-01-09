package Backend;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * A classe UCs representa uma Unidade Curricular no sistema acadêmico.
 * Cada UC possui uma sigla única, uma designação, uma equipa de professores associados,
 * um regente (professor responsável) e uma lista de sumários.
 * Esta classe implementa a interface Serializable para permitir a persistência em arquivos.
 */
public class UCs implements Serializable {
    private String siglaUC;
    private String desigUC;
    private ArrayList<String> equipa;
    private Professores regente;

    /**
     *
     */
    public ArrayListSumario sumariosUC;

    /**
     * Construtor padrão sem argumentos para a classe UCs.
     */
    public UCs() {
    }

    /**
     * Construtor parametrizado para a classe UCs.
     *
     * @param desig A designação da Unidade Curricular.
     * @param sigla A sigla única da Unidade Curricular.
     */
    public UCs(String desig, String sigla) {
        this.siglaUC = sigla;
        this.desigUC = desig;
        this.regente = null;
        this.sumariosUC = new ArrayListSumario();
        this.equipa = new ArrayList<>();
    }

    /**
     * Obtém a designação da Unidade Curricular.
     *
     * @return A designação da Unidade Curricular.
     */
    public String getDesig() {
        return desigUC;
    }

    /**
     * Define uma nova designação para a Unidade Curricular.
     *
     * @param novaDesig A nova designação a ser atribuída.
     */
    public void setDesig(String novaDesig) {
        desigUC = novaDesig;
    }

    /**
     * Obtém o regente (professor responsável) da Unidade Curricular.
     *
     * @return O regente da Unidade Curricular.
     */
    public Professores getRegente() {
        return regente;
    }

    /**
     * Define um novo regente (professor responsável) para a Unidade Curricular.
     *
     * @param novoRegente O novo regente a ser atribuído.
     */
    public void setRegente(Professores novoRegente) {
        regente = novoRegente;
    }

    /**
     * Obtém a sigla única da Unidade Curricular.
     *
     * @return A sigla única da Unidade Curricular.
     */
    public String getSigla() {
        return siglaUC;
    }

    /**
     * Define uma nova sigla única para a Unidade Curricular.
     *
     * @param sigla A nova sigla a ser atribuída.
     */
    public void setSigla(String sigla) {
        this.siglaUC = sigla;
    }

    /**
     * Obtém a lista de sumários associada à Unidade Curricular.
     *
     * @return A lista de sumários da Unidade Curricular.
     */
    public ArrayListSumario getSumariosUC() {
        if (sumariosUC == null) {
            sumariosUC = new ArrayListSumario();
        }
        return sumariosUC;
    }

    /**
     * Obtém a equipa de professores associada à Unidade Curricular.
     *
     * @return A equipa de professores da Unidade Curricular.
     */
    public ArrayList<String> getEquipa() {
        return equipa;
    }

    /**
     * Define uma nova equipa de professores para a Unidade Curricular.
     *
     * @param equipa A nova equipa de professores a ser atribuída.
     */
    public void setEquipa(ArrayList<String> equipa) {
        this.equipa = equipa;
    }

    /**
     * Retorna uma representação em string da Unidade Curricular.
     *
     * @return Uma representação em string da Unidade Curricular.
     */
    @Override
    public String toString() {
        return "UCs{" + "sigla=" + siglaUC + ", desig=" + desigUC + ", regente=" + regente + '}';
    }
}
