package Frontend;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;

/**
 * A classe ComandosConsola fornece métodos para interação com o utilizador através da consola.
 */
public class ComandosConsola {
    private final Scanner Texto = new Scanner(System.in);

    /**
     * Exibe uma mensagem de erro no standard error.
     *
     * @param msg A mensagem de erro a ser exibida.
     */
    public void EscErro(String msg){
        System.err.println(msg);
    }

    /**
     * Exibe uma mensagem no standard output.
     *
     * @param msg A mensagem a ser exibida.
     */
    public void Esc(String msg){
        System.out.println(msg);
    }

    /**
     * Solicita a introdução de uma string ao utilizador.
     *
     * @param msg A mensagem a ser exibida antes da entrada.
     * @return A string inserida pelo utilizador.
     */
    public String LerStr(String msg){
        Esc(msg);
        return Texto.nextLine();
    }

    /**
     * Solicita ao utilizador que escolha uma opção num conjunto de opções.
     *
     * @param op As opções disponíveis.
     * @return O número da opção escolhida pelo utilizador.
     */
    public int lerInt(String[] op){
        Integer number = null;
        String texto = "";

        do{
            Esc("Selecionar a opção pretendida:");
            for(int i= 0; i<op.length; i++){
                System.out.println(" "+ (i+1) +"- "+ op[i]);
            }
            try{
                texto = Texto.nextLine();
                number = Integer.valueOf(texto);
            }catch(NumberFormatException e){
                EscErro(texto +" O valor introduzido não é um valor válido");
            }

            if( number <= 0 || number > op.length || number == null ){
                EscErro(texto +" não é uma opção válida");
            }
        }while(number == null);
        return number;
    }

    /**
     * Solicita ao utilizador que introduza um número inteiro.
     *
     * @param msg A mensagem a ser exibida antes da entrada.
     * @return O número inteiro inserido pelo utilizador.
     */
    public int ReadInteger(String msg){
        Integer number = null;

        do{
            Esc(msg);
            String scan = Texto.nextLine();

            try{
                number = Integer.valueOf(scan);
            }catch(NumberFormatException e){
                EscErro(scan +" O valor introduzido não é um valor válido");
            }
        }while(number == null);
        return number;
    }

    /**
     * Solicita ao utilizador que introduza uma data no formato "dd-MM-yy".
     *
     * @param msg A mensagem a ser exibida antes da entrada.
     * @return A data inserida pelo utilizador formatada como "dd-MM-yy".
     */
    public String LeituraData(String msg) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        dateFormat.setLenient(false);

        while (true) {
            try {
                System.out.print(msg);
                String input = Texto.nextLine();
                Date datafornecida = dateFormat.parse(input);
                return dateFormat.format(datafornecida);
            } catch (ParseException e) {
                System.out.println("Data inválida");
            }
        }
    }

    /**
     * Verifica o formato do número mecanográfico e retorna um código correspondente.
     *
     * @param numeroMecanog O número mecanográfico fornecido.
     * @return 1 se começar com "p", 2 se começar com "admin", 0 caso contrário.
     */
    public int lerNumberMecanog(String numeroMecanog){
        ComandosConsola consola = new ComandosConsola();
        int verifica = 0;
        if (numeroMecanog.startsWith("p")){
            verifica = 1;
            return verifica;
        }
        if(numeroMecanog.startsWith("admin")){
            verifica = 2;
            return verifica;
        }
        else{
            consola.EscErro("Número inválido!!");
        }
        return verifica;
    }

    /**
     * Solicita ao utilizador que introduza um número decimal.
     *
     * @param msg A mensagem a ser exibida antes da entrada.
     * @return O número decimal inserido pelo utilizador.
     */
    public double readDe(String msg){
        Double number = null;

        do{
            Esc(msg);
            String texto = Texto.nextLine();

            try{
                number = Double.valueOf(texto);
            }catch(NumberFormatException e){
                EscErro(texto +"Não é válido");
            }
        }while(number == null);
        return number;
    }
}
