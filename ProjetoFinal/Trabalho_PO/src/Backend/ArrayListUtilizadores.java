package Backend;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * A classe {@code ArrayListUtilizadores} representa uma coleção de objetos do tipo {@code Utilizadores}
 * utilizando um ArrayList. Implementa a interface {@code Serializable}.
 */
public class ArrayListUtilizadores implements Serializable {
    
    private ArrayList<Utilizadores> lista;
    
    /**
     * Construtor padrão que cria uma instância de {@code ArrayListUtilizadores} inicializando o ArrayList.
     */
    public ArrayListUtilizadores() {
        lista = new ArrayList<>();
    }
    
    /**
     * Insere um objeto do tipo {@code Utilizadores} na lista.
     *
     * @param utilizador O objeto do tipo {@code Utilizadores} a ser inserido na lista.
     */
    public void inserir(Utilizadores utilizador) {
        lista.add(utilizador);               
    }
    
    /**
     * Remove um objeto do tipo {@code Utilizadores} da lista.
     *
     * @param utilizador O objeto do tipo {@code Utilizadores} a ser removido da lista.
     */
    public void remove(Utilizadores utilizador){
        lista.remove(utilizador);
    }
    
    /**
     * Obtém a lista de objetos do tipo {@code Utilizadores}.
     *
     * @return A lista de objetos do tipo {@code Utilizadores}.
     */
    public ArrayList<Utilizadores> getLista(){
        return lista;
    }

    /**
     * Define a lista de objetos do tipo {@code Utilizadores}.
     *
     * @param lista A nova lista de objetos do tipo {@code Utilizadores}.
     */
    public void setLista(ArrayList<Utilizadores> lista) {
        this.lista = lista;
    }
    
    /**
     * Retorna uma representação em formato de string da lista de {@code Utilizadores}.
     *
     * @return Uma string que representa a lista de {@code Utilizadores}.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (Utilizadores u : lista) {
            sb.append("\t{");
            sb.append(u.toString());
            sb.append("}");
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
