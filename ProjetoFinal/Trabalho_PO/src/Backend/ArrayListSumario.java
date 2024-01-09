package Backend;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * A classe {@code ArrayListSumario} representa uma coleção de objetos do tipo {@code Sumario}
 * utilizando um ArrayList. Implementa a interface {@code Serializable}.
 */
public class ArrayListSumario implements Serializable {
    
    private ArrayList<Sumario> lista;
    
    /**
     * Construtor padrão que cria uma instância de {@code ArrayListSumario} inicializando o ArrayList.
     */
    public ArrayListSumario(){
        lista = new ArrayList<>();
    }
    
    /**
     * Insere um objeto do tipo {@code Sumario} na lista.
     *
     * @param sumario O objeto do tipo {@code Sumario} a ser inserido na lista.
     */
    public void inserir(Sumario sumario) {
        lista.add(sumario);               
    }
    
    /**
     * Obtém a lista de objetos do tipo {@code Sumario}.
     *
     * @return A lista de objetos do tipo {@code Sumario}.
     */
    public ArrayList<Sumario> getLista(){
        return lista;
    }

    /**
     * Define a lista de objetos do tipo {@code Sumario}.
     *
     * @param lista A nova lista de objetos do tipo {@code Sumario}.
     */
    public void setLista(ArrayList<Sumario> lista) {
        this.lista = lista;
    }
}
