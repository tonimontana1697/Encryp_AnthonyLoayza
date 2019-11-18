package algoritmo;

import java.io.IOException;
import java.util.Scanner;

public class algoritmoFinal {

    //ALGORITMO CESAR -------------------------------------------------------------------------------
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        algoritmoCifrado algoritmoCifrado = new algoritmoCifrado();
        algoritmoTranposicion m = new algoritmoTranposicion();
        String texto;
        int codigo;
        int codigo2;
        char opcion;
        //Introducir un texto
        do {
            System.out.print("Introduce un texto: ");   // toni
            texto = sc.nextLine();
        } while (texto.isEmpty());
        //Introducir el valor del desplazamiento
        do {
            System.out.print("Introduce el código: ");   // 4
            codigo = sc.nextInt();
        } while (codigo < 1);
        //Introducir la operación a realizar: cifrar o descifrar
        do {
            sc.nextLine();
            System.out.print("(C) cifrar o (D) descifrar?: ");
            opcion = (char) System.in.read();
        } while (Character.toUpperCase(opcion) != 'C' && Character.toUpperCase(opcion) != 'D');
        if (Character.toUpperCase(opcion) == 'C') {
            System.out.println("Texto cifrado: " + cifradoCesar(texto, codigo));
        } else {
            System.out.println("Texto descifrado: " + descifradoCesar(texto, codigo));
        }

        //------------------------------CIFRADO TRANSPOSICION-----------------------------------------
        String output = m.transposition("xsrm", 1);
        System.out.println("Cifrado transposicion: " + output);

        //-------------------------------CIFRADO NUMERICO--------------------------------------------
        //Cifrando texto
        String textoCifrado = algoritmoCifrado.cifrar(output);
        System.out.println("Cifrado numerico: " + textoCifrado);

        //Descifrando texto
        String textoDescifrado = algoritmoCifrado.descifrar(textoCifrado);
        System.out.println("Descifrado numerico: " + textoDescifrado);

        //------------------------------DESCIFRADO TRANSPOSICION-----------------------------------------
        
        String output2 = m.transposition(textoDescifrado, -1);
        System.out.println("Descifrado tranposicion: " + output2);
        
        //-------------------------------DESCIFRADO CESAR------------------------------------------------
        
        //Introducir el valor del desplazamiento
        do {
            System.out.print("Introduce el código Descifrador: ");
            codigo2 = sc.nextInt();
        } while (codigo2 < 1);
        
        //Introducir la operación a realizar: cifrar o descifrar
        do {
            sc.nextLine();
            System.out.print("(C) cifrar o (D) descifrar?: ");
            opcion = (char) System.in.read();
        } while (Character.toUpperCase(opcion) != 'C' && Character.toUpperCase(opcion) != 'D');
        if (Character.toUpperCase(opcion) == 'C') {
            System.out.println("Texto cifrado: " + cifradoCesar(output2, codigo2));
        } else {
            System.out.println("Texto descifrado: " + descifradoCesar(output2, codigo2));
        }
    }

    //método para cifrar el texto
    public static String cifradoCesar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + codigo) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
    }

    //método para descifrar el texto
    public static String descifradoCesar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) - codigo) < 'a') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) - codigo) < 'A') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            }
        }
        return cifrado.toString();
    }

}
