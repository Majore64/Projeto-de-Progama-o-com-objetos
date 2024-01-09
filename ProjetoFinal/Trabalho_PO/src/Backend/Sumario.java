package Backend;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * The {@code Sumario} class represents a summary of a class or lecture.
 * It includes information such as the date, student number, type, content,
 * and a list of students present.
 * 
 * @author Your Name
 * @version 1.0
 * @since 2024-01-02
 */
public class Sumario implements Serializable {

    /** The date of the summary. */
    private String dataSumario;

    /** The student number associated with the summary. */
    private String numMecan;

    /** The type of the summary (e.g., class summary, lecture summary). */
    private String tipo;

    /** The content of the summary. */
    private String conteudo;

    /** The list of students present during the summary. */
    private ArrayList<String> alunosP;

    /**
     * Constructs a new instance of {@code Sumario} with the specified date,
     * student number, and type.
     *
     * @param data The date of the summary.
     * @param numMecan The student number associated with the summary.
     * @param tipo The type of the summary.
     */
    public Sumario(String data, String numMecan, String tipo) {
        this.dataSumario = data;
        this.tipo = tipo;
        alunosP = new ArrayList<>();
        this.numMecan = numMecan;
    }

    /**
     * Gets the date of the summary.
     *
     * @return The date of the summary.
     */
    public String getData() {
        return dataSumario;
    }

    /**
     * Sets the date of the summary.
     *
     * @param data The date to set.
     */
    public void setData(String data) {
        this.dataSumario = data;
    }

    /**
     * Gets the student number associated with the summary.
     *
     * @return The student number.
     */
    public String getNumMecan() {
        return numMecan;
    }

    /**
     * Sets the student number associated with the summary.
     *
     * @param numMecan The student number to set.
     */
    public void setNumMecan(String numMecan) {
        this.numMecan = numMecan;
    }

    /**
     * Gets the type of the summary.
     *
     * @return The type of the summary.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets the type of the summary.
     *
     * @param tipo The type to set.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Gets the content of the summary.
     *
     * @return The content of the summary.
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Sets the content of the summary.
     *
     * @param conteudo The content to set.
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * Gets the list of students present during the summary.
     *
     * @return The list of students present.
     */
    public ArrayList<String> getAlunosPresentes() {
        return alunosP;
    }

    /**
     * Returns a string representation of the {@code Sumario} object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Sumario{" +
                "data=" + dataSumario +
                ", numMecan=" + numMecan +
                ", tipo=" + tipo +
                ", conteudo=" + conteudo +
                ", alunosPresentes=" + alunosP +
                '}';
    }
}
