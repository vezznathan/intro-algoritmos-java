import java.util.HashMap;


public class ContadorPalabras {

    public static void main(String[] args) {
        String frase = "el gato negro come pescado y el gato duerme";
        String[] palabras = frase.split (" ");
        
        HashMap<String, Integer> conteo = new HashMap<>();
        for (String palabra : palabras) {
            if (conteo.containsKey(palabra)) {
                conteo.put(palabra, conteo.get(palabra) + 1);
            } else {
                conteo.put(palabra, 1);
            }
            }
        for (String palabra : conteo.keySet()) {
            System.out.println(palabra + ": " + conteo.get(palabra));
        }
        }
        }