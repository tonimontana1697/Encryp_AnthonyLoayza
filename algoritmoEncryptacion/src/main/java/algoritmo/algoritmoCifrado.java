package algoritmo;

public class algoritmoCifrado {

    //Charset de caracteres cuando se cifra
    private String charset1 = "1234567890!#$%&/()=¿?¡_-+*:";
    //Charset de caracteres cuando se descifra
    private String charset2 = "abcdefghijklmnopqrstuvwxyz ";

    public String cifrar(String texto) {
        //Convierto a minuscula las letras del alfabeto que existan en el texto
        texto = texto.toLowerCase();
        //Reemplazo los caracteres del charset2 con los del charset1
        for (int i = 0; i < charset2.length(); i++) {
            texto = texto.replace(charset2.charAt(i), charset1.charAt(i));
        }
        //Retorno el texto cifrado con el charset2
        return texto;
    }

    public String descifrar(String texto) {
        //Convierto a minuscula las letras del alfabeto que existan en el texto
        texto = texto.toLowerCase();
        //Reemplazo los caracteres del charset1 con los del charset2
        for (int i = 0; i < charset1.length(); i++) {
            texto = texto.replace(charset1.charAt(i), charset2.charAt(i));
        }
        //Retorno el texto cifrado con el charset2
        return texto;
    }

    public static void main(String[] args) {

        //Instancia de la clase cifrado_dvl y creacion de un nuevo objeto
        algoritmoCifrado algoritmoCifrado = new algoritmoCifrado();

        //Cifrando texto
        String textoCifrado = algoritmoCifrado.cifrar("Cifrando...");
        System.out.println(textoCifrado);

        //Descifrando texto
        String textoDescifrado = algoritmoCifrado.descifrar(textoCifrado);
        System.out.println(textoDescifrado);

        // cadenas
        String[] cadenas = new String[4];
        cadenas[0] = "Profesor";
        cadenas[1] = "Por favor";
        cadenas[2] = "Apruebe me";
        cadenas[3] = "El ciclo";

        //Cifrando cada cadena del arreglo
        System.out.println("\n Cifrando ");
        for (int i = 0; i < cadenas.length; i++) {
            cadenas[i] = algoritmoCifrado.cifrar(cadenas[i]);
            System.out.println("Cadena " + (i + 1) + " : " + cadenas[i]);
        }

        //Ahora Descifrando el contenido de las cadenas
        System.out.println("\n Descifrando");
        for (int i = 0; i < cadenas.length; i++) {
            cadenas[i] = algoritmoCifrado.descifrar(cadenas[i]);
            System.out.println("Cadena " + (i + 1) + " : " + cadenas[i]);
        }
    }

}
