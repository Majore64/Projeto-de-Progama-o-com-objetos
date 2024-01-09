package Backend;

import java.io.Serializable;

/**
 * A classe {@code Administrador} representa um utilizador com privilégios de administrador.
 * Estende a classe {@code Utilizadores} e implementa a interface {@code Serializable}.
 * Um administrador é caracterizado pelo seu número de identificação e palavra-passe.
 */
public class Administrador extends Utilizadores implements Serializable {

    /**
     * Construtor padrão que cria uma instância de {@code Administrador} sem parâmetros.
     */
    public Administrador() {

    }

    /**
     * Construtor que cria uma instância de {@code Administrador} com um número de identificação
     * e palavra-passe fornecidos.
     *
     * @param novoNum  O número de identificação do administrador.
     * @param novaPass A palavra-passe do administrador.
     */
    public Administrador(String novoNum, String novaPass) {
        super(novoNum, novaPass);
    }

    /**
     * Retorna uma representação em formato de string do objeto {@code Administrador}.
     *
     * @return Uma string que representa o objeto {@code Administrador}.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
