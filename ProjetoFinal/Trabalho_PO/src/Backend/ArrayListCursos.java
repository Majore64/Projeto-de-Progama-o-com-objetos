package Backend;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * A classe {@code ArrayListCursos} representa uma coleção de objetos do tipo {@code Curso}
 * utilizando um ArrayList. Implementa a interface {@code Serializable}.
 */
public class ArrayListCursos implements Serializable {
    
    private ArrayList<Curso> lista;
    
    /**
     * Construtor padrão que cria uma instância de {@code ArrayListCursos} inicializando o ArrayList.
     */
    public ArrayListCursos() {
        lista = new ArrayList<>(); 
    }
    
    /**
     * Insere um objeto do tipo {@code Curso} na lista.
     *
     * @param curso O objeto do tipo {@code Curso} a ser inserido na lista.
     */
    public void inserir(Curso curso) {
        lista.add(curso);               
    }
    
    /**
     * Obtém a lista de objetos do tipo {@code Curso}.
     *
     * @return A lista de objetos do tipo {@code Curso}.
     */
    public ArrayList<Curso> getLista(){
        return lista;
    }

    /**
     * Define a lista de objetos do tipo {@code Curso}.
     *
     * @param lista A nova lista de objetos do tipo {@code Curso}.
     */
    public void setLista(ArrayList<Curso> lista) {
        this.lista = lista;
    }
}
