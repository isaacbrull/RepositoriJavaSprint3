/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquet1;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Biblioteca de métodos de Entrada y Salida
 *
 * @author Grupo2: Marc España, Vlad Udod, Josep López y Carlos Masana
 */
public class InputOutput {
    private final Scanner teclado = new Scanner(System.in);


    /**
     * Método que imprime por pantalla una cadena de caracteres (OUTPUT)
     * @param texto String - Cadena de caracteres que se quiere mostrar por pantalla
     */
    public void imprimirTexto(String texto){
        System.out.println(texto);
    }


    /**
     * Método que imprime las opciones de un menú (OUTPUT)
     * @param menu - Menú que se quiere mostrar por pantalla
     * 
     */
    public void imprimirMenu(String[] menu){
        for(int i = 0; i < menu.length; i++){
            System.out.println((i+1) + "). " + menu[i]);
        }
    }

    /**
     * Método para adjuntar un nº indefinido de argumentos y mostrarlos por pantalla (OUTPUT)
     * @param textos
     */
    public void imprimir(Object... textos) {
        if (textos.length > 1) {
            for(int i=0;i<textos.length;i++) {
                System.out.println((i+1) + "). " + textos[i]);
            }
        } else {
            System.out.println(textos[0]);
        }
    }

    /**
     * Método que permite validar los datos STRING introducidos por el usuario (INPUT/OUTPUT)
     * @param mensaje String - Mensaje que se muestra
     * @return
     */
    public String entradaText(String mensaje) {
        String res;

        do try {
            System.out.println(mensaje + ": ");
            res = teclado.nextLine();
            return res;

        } catch (Exception e) {
            teclado.next();

        } while (true);
    }


    /**
     * Método que permite validar los datos INT introducidos por el usuario (INPUT/OUTPUT)
     *
     * @param mensaje
     * @return
     */
    public int entradaNumero(String mensaje) {
        int res;

        do try {
            System.out.println(mensaje + ": ");
            res = teclado.nextInt();
            return res;

        } catch (Exception e) {
            System.out.println("Opción incorrecta");
            teclado.nextLine();

        } while (true);

    }

    /**
     * Atajo para las entradas (0. Texto, 1. Número)
     * @param mensaje
     * @param tipo
     */
    public void entrada(String mensaje, int tipo) {
        switch (tipo) {
            case 0:
                entradaText(mensaje);
                break;
            case 1:
                entradaNumero(mensaje);
                break;
            default:
        }
    }

    /**
     * Método que recoge el String introducido por el usuario (INPUT)
     * @return texto String - Devuelve cadena de caracteres introducida por el usuario
     */
    public String insertarString(){
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    /**
     * Método que recoge el número entero introducido por el usuario (INPUT)
     * @return num int - Devuelve nº entero introducido por el usuario
     */
    public int insertarInt(){
        int respuesta;
        do {
            try {
                respuesta = teclado.nextInt();
                return respuesta;

            } catch (InputMismatchException e) {
                imprimirTexto("Valor incorrecto, pruebe de nuevo:");
                teclado.nextLine();
            }
        }
        while (true);
    }

    /**
     * Método que permite validar que un String solo contenga letras (mayúsculas y minúsculas) y espacios
     *
     * @return cadenaText String Devuelve un String validado
     */
    public String validarDatosPersonales() {
        final String REGEXP = "([a-zA-Z ])";
        String cadenaText = this.insertarString();

        // RegExp
        Pattern p = Pattern.compile(REGEXP);
        Matcher m = p.matcher(cadenaText);

        // Controla que la cadena contenga únicamente letras y espacios
        while (!m.find()) {
            this.imprimirTexto("Error: El campo debe contener únicamente letras.");
            cadenaText = this.insertarString();
            m = p.matcher(cadenaText);
        }
        return cadenaText;
    }
}

