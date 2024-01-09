package Backend;

import java.util.ArrayList;
import java.io.Serializable;


//metodo

/**
 *
 * @author vitor
 */
public class Curso implements Serializable{
    private String sigla; 
    private ArrayListAlunos alunosCurso; 
    private Professores diretor;
    private ArrayList<String> listaUcs;
    private String desig;
    
    //metodo

    /**
     *
     * @param novaDesig
     * @param novaSigla
     */
    public Curso(String novaDesig, String novaSigla){
        sigla = novaSigla;
        desig = novaDesig;
        diretor = null;
        listaUcs = new ArrayList<>();
        alunosCurso = new ArrayListAlunos();
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getListaUcs() {
        return listaUcs;
    }

    /**
     *
     * @return
     */
    public ArrayListAlunos getAlunosCurso() {
        return alunosCurso;
    }
    
    //getetes e setters

    /**
     *
     * @return
     */
    public String getDesig() {
        return desig;
    }

    /**
     *
     * @param desig
     */
    public void setDesig(String desig) {
        this.desig = desig;
    }
    
    /**
     *
     * @param diretor
     */
    public void getDiretor(String diretor){
        
    }

    /**
     *
     * @return
     */
    public Professores getDiretor() {
        return diretor;
    }

    /**
     *
     * @param diretor
     */
    public void setDiretor(Professores diretor) {
        this.diretor = diretor;
    }
    
    /**
     *
     * @return
     */
    public String getSigla() {
        return sigla;
    }

    /**
     *
     * @param sigla
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "O Curso{" + "A sigla=" + sigla + ", O desig=" + desig + ",O diretor=" + diretor + '}';
    } 
}