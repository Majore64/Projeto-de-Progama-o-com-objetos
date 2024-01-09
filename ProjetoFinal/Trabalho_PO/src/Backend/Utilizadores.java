package Backend;

import java.io.Serializable;

/**
 * A classe Utilizadores é uma classe abstrata que representa os usuários do sistema acadêmico.
 * Cada utilizador possui um número mecanográfico único e uma senha.
 * Esta classe implementa a interface Serializable para permitir a persistência em arquivos.
 */
public abstract class Utilizadores implements Serializable {
    private String pass;
    private String numMecan;

    /**
     * Construtor padrão sem argumentos para a classe Utilizadores.
     */
    public Utilizadores() {
    }

    /**
     * Construtor parametrizado para a classe Utilizadores.
     *
     * @param novoNum  O novo número mecanográfico do utilizador.
     * @param novaPass A nova senha do utilizador.
     */
    public Utilizadores(String novoNum, String novaPass) {
        numMecan = novoNum;
        pass = novaPass;
    }

    /**
     * Obtém o número mecanográfico do utilizador.
     *
     * @return O número mecanográfico do utilizador.
     */
    public String getNumMecan() {
        return numMecan;
    }

    /**
     * Define um novo número mecanográfico para o utilizador.
     *
     * @param novoNum O novo número mecanográfico a ser atribuído.
     */
    public void setNumMecan(String novoNum) {
        numMecan = novoNum;
    }

    /**
     * Obtém a senha do utilizador.
     *
     * @return A senha do utilizador.
     */
    public String getPass() {
        return pass;
    }

    /**
     * Define uma nova senha para o utilizador.
     *
     * @param novaPass A nova senha a ser atribuída.
     */
    public void setPass(String novaPass) {
        pass = novaPass;
    }

    /**
     * Retorna uma representação em string do utilizador.
     *
     * @return Uma representação em string do utilizador.
     */
    @Override
    public String toString() {
        return "Utilizadores{" + "numMecan=" + numMecan + ", pass=" + pass + '}';
    }
}
