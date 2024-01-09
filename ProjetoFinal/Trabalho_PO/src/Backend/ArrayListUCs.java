package Backend;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A classe {@code ArrayListUCs} representa uma coleção de objetos do tipo {@code UCs}
 * utilizando um ArrayList. Implementa a interface {@code Serializable}.
 */
public class ArrayListUCs implements Serializable {
    
    private ArrayList<UCs> lista;
    
    /**
     * Construtor padrão que cria uma instância de {@code ArrayListUCs} inicializando o ArrayList.
     */
    public ArrayListUCs() {
        lista = new ArrayList<>(); 
    }
    
    /**
     * Insere um objeto do tipo {@code UCs} na lista.
     *
     * @param uc O objeto do tipo {@code UCs} a ser inserido na lista.
     */
    public void inserir(UCs uc) {
        lista.add(uc);               
    }
    
    /**
     * Obtém a lista de objetos do tipo {@code UCs}.
     *
     * @return A lista de objetos do tipo {@code UCs}.
     */
    public ArrayList<UCs> getLista(){
        return lista;
    }

    /**
     * Define a lista de objetos do tipo {@code UCs}.
     *
     * @param lista A nova lista de objetos do tipo {@code UCs}.
     */
    public void setLista(ArrayList<UCs> lista) {
        this.lista = lista;
    }
}
