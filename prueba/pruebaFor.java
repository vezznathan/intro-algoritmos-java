public class pruebaFor { 

public static void main(String[] args) {
    String[] frutas = {"manzana", "pera", "naranja"};
    
    // FOR clásico
    System.out.println("--- FOR clásico ---");
    for (int i = 0; i < frutas.length; i++) {
        System.out.println(i + ": " + frutas[i]);
    }
    
    // FOR-EACH
    System.out.println("--- FOR-EACH ---");
    for (String fruta : frutas) {
        System.out.println(fruta);
    }
    
    // WHILE
    System.out.println("--- WHILE ---");
    int i = 0;
    while (i < frutas.length) {
        System.out.println(frutas[i]);
        i++;
    }
}







}