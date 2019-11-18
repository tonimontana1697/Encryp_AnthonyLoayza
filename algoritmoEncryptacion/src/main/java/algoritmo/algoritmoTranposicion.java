package algoritmo;


public class algoritmoTranposicion {

    
        public static void main(String[] args) {
            algoritmoTranposicion m = new algoritmoTranposicion();
            //Los parametros del metodo tranposition es la cadena a cifrar y la direccion a forma de un entero positivo
            String output = m.transposition("xsrm", 1);
            System.out.println(output);
            //Si va a decifrar o a cifrar a la inversa se manda un entero negativo
            String output2 = m.transposition(output, -1);
            System.out.println( output2);
        }

        public char[][] define_list(String input) {
            int root = input.length() / 2;
            if (root % 2 == 0) {
                root = root;
            } else {
                root = root + 1;
            }
            char map[][] = new char[2][root];
            int pos = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < root; j++) {
                    if (pos >= input.length()) {
                        map[i][j] = ' ';
                    } else {
                        map[i][j] = input.charAt(pos);
                    }
                    pos++;
                }
            }
            return map;
        }

        public char[][] define_inverse_list(String input) {
            int root = input.length() / 2;
            if (root % 2 == 0) {
                root = root;
            } else {
                root = root + 1;
            }
            char map[][] = new char[root][2];
            int pos = 0;
            for (int i = 0; i < root; i++) {
                for (int j = 0; j < 2; j++) {
                    if (pos >= input.length()) {
                        map[i][j] = ' ';
                    } else {
                        map[i][j] = input.charAt(pos);
                    }
                    pos++;
                }
            }
            return map;
        }

        public String transposition(String message, int l) {
            //Crea la tabla que se va a necesitar para aplicar el algoritmo, al momento esta vacia
            char[][] matrix;
            //Si es negativo el entero entonces crea una tabla inversa
            if (l < 0) {
                matrix = define_inverse_list(message);
            } //Caso contrario crea una tabla normal, en ambos casos el parametro que toma es la cadena a cifrar
            else {
                matrix = define_list(message);
            }
            //Arreglo para obtener la primer columna de la tabla
            char[] temp = matrix[0];
            String out = "";
            for (int x = 0; x < temp.length; ++x) {
                for (int y = 0; y < matrix.length; ++y) {
                    //Lo recorre de manera vertical
                    out += matrix[y][x];
                }
            }
            return out;
        }

    
}
