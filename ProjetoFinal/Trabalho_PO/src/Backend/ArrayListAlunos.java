package Backend;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * A classe {@code ArrayListAlunos} representa uma coleção de objetos do tipo {@code Alunos}
 * utilizando um ArrayList. Implementa a interface {@code Serializable}.
 */
public class ArrayListAlunos implements Serializable {
    
    private ArrayList<Alunos> lista;
    
    /**
     * Construtor padrão que cria uma instância de {@code ArrayListAlunos} inicializando o ArrayList.
     */
    public ArrayListAlunos() {
        lista = new ArrayList<>();
    }

    /**
     * Insere um objeto do tipo {@code Alunos} na lista.
     *
     * @param aluno O objeto do tipo {@code Alunos} a ser inserido na lista.
     */
    public void inserir(Alunos aluno) {
        lista.add(aluno);               
    }
    
    /**
     * Obtém a lista de objetos do tipo {@code Alunos}.
     *
     * @return A lista de objetos do tipo {@code Alunos}.
     */
    public ArrayList<Alunos> getLista(){
        return lista;
    }

    /**
     * Define a lista de objetos do tipo {@code Alunos}.
     *
     * @param lista A nova lista de objetos do tipo {@code Alunos}.
     */
    public void setLista(ArrayList<Alunos> lista) {
        this.lista = lista;
    }
}
