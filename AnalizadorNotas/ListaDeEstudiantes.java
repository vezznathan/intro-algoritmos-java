import java.util.ArrayList; // Importamos ArrayList del paquete java.util.
                            // A diferencia de los arreglos (int[], String[]), ArrayList es una
                            // colección de tamaño DINÁMICO: crece y decrece sola según necesitemos.
                            // Los arreglos tienen tamaño fijo definido al crearlos (ej: new int[30]).

public class ListaDeEstudiantes {

    // CAMPO: ArrayList que almacena los nombres de los estudiantes.
    // Usamos <String> para indicar que solo puede guardar objetos de tipo String.
    // ArrayList NO puede guardar tipos primitivos (int, double, boolean) directamente,
    // a diferencia de los arreglos que sí pueden (ej: int[] notas).
    // El campo existe mientras el objeto exista — no desaparece entre llamadas a métodos.
    private ArrayList<String> estudiantes;

    // CONSTRUCTOR: se ejecuta automáticamente cuando creamos un objeto con "new ListaDeEstudiantes()".
    // Su trabajo es inicializar los campos para que el objeto arranque en un estado válido.
    // Si no inicializáramos "estudiantes" acá, su valor sería null y cualquier llamada
    // a estudiantes.add() o estudiantes.size() tiraría un NullPointerException.
    public ListaDeEstudiantes() {
        estudiantes = new ArrayList<String>(); // Creamos la lista vacía. Tamaño inicial: 0.
    }

    /**
     * Agrega un estudiante a la lista.
     *
     * PRECONDICIÓN: el nombre no puede ser null y debe contener solo letras (sin espacios,
     * números ni símbolos). Es obligación de quien llama este método garantizar esto.
     * Si la precondición no se cumple, el método puede comportarse de forma errónea.
     *
     * @param nombre El nombre del estudiante a agregar.
     */
    public void agregarEstudiante(String nombre) {

        // PRECONDICIÓN con assert: chequeamos que el nombre sea válido antes de usarlo.
        // Formato: assert <condición> : <mensaje si falla>;
        // Si la condición es false, el programa se interrumpe y muestra el mensaje.
        // Si la condición es true, la ejecución continúa normalmente.
        //
        // Usamos && (Y lógico) porque AMBAS condiciones deben cumplirse:
        //   1. nombre != null       → si fuera null, llamar a .matches() tiraría un error
        //   2. nombre.matches(...)  → solo letras, sin espacios ni símbolos
        //
        // El patrón "[a-zA-ZáéíóúÁÉÍÓÚñÑ]+" significa:
        //   - a-z: letras minúsculas sin tilde
        //   - A-Z: letras mayúsculas sin tilde
        //   - áéíóú / ÁÉÍÓÚ / ñÑ: letras con tilde y ñ
        //   - +: al menos un caracter (no puede ser vacío)
        //   - Sin espacio adentro → rechaza nombres compuestos como "Juan Pablo"
        //
        // ERROR COMÚN: usar || en vez de && acá haría que un nombre null pasara
        // la validación si la segunda condición fuera true, lo cual no tiene sentido.
        assert (nombre != null && nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) : "Ingrese un nombre válido";

        // .add() agrega el elemento al final de la lista y aumenta su tamaño automáticamente.
        // Equivalente en arreglo sería: notas[cantidadNotas] = valor; cantidadNotas++;
        // Con ArrayList no necesitamos manejar índices ni tamaño manualmente.
        estudiantes.add(nombre);
    }

    /**
     * Devuelve la cantidad de estudiantes en la lista.
     *
     * PROPIEDAD: .size() es un MÉTODO de ArrayList (se llama con paréntesis).
     * Es distinto de .length en arreglos, que es un ATRIBUTO (sin paréntesis).
     *   - ArrayList: estudiantes.size()   → método, valor dinámico
     *   - Arreglo:   notas.length         → atributo, valor fijo
     *
     * @return Cantidad actual de estudiantes.
     */
    public int cantidadEstudiantes() {
        return estudiantes.size();
    }

    /**
     * Imprime por consola todos los estudiantes de la lista.
     *
     * Usamos el ciclo FOR-EACH, ideal para recorrer colecciones cuando
     * no necesitamos el índice de cada elemento.
     * Forma general: for (Tipo variable : colección) { ... }
     * Se lee: "para cada 'estudiante' de tipo String en 'estudiantes', hacer..."
     *
     * DIFERENCIA con ciclo for clásico:
     *   - For-each: más simple, no da acceso al índice
     *   - For clásico (for int i = 0; i < ...; i++): necesario cuando usamos el índice
     */
    public void imprimirEstudiantes() {
        for (String estudiante : estudiantes) {
            // "estudiante" es una VARIABLE LOCAL: existe solo dentro de este for-each
            // y toma el valor de cada elemento de la lista en cada vuelta.
            // Es distinta del CAMPO "estudiantes" que existe en todo el objeto.
            System.out.println(estudiante);
        }
    }

    /**
     * Elimina un estudiante de la lista por nombre.
     *
     * .remove() busca el primer elemento igual al parámetro y lo elimina.
     * Si el nombre no existe en la lista, no hace nada (no tira error).
     * ArrayList ajusta su tamaño automáticamente después de eliminar.
     *
     * NOTA: para comparar Strings siempre usar .equals(), nunca ==.
     *   - ==        compara si son el MISMO objeto en memoria (identidad)
     *   - .equals() compara si tienen el MISMO contenido (igualdad de texto)
     * ArrayList.remove() usa .equals() internamente, por eso funciona correctamente.
     *
     * @param nombre El nombre del estudiante a eliminar.
     */
    public void eliminarEstudiante(String nombre) {
        estudiantes.remove(nombre);
    }

    /**
     * INVARIANTE DE CLASE: condiciones que el objeto SIEMPRE debe cumplir
     * para estar en un estado válido. repOK() las chequea todas.
     *
     * Devuelve true si el objeto está sano, false si algo está roto.
     * Se usa principalmente para detectar bugs: si repOK() devuelve false,
     * algún método rompió el estado interno del objeto.
     *
     * Invariantes de esta clase:
     *   1. La lista no puede ser null
     *   2. Ningún elemento puede ser null ni contener caracteres inválidos
     *
     * @return true si el estado del objeto es consistente, false si no.
     */
    public boolean repOK() {

        // Invariante 1: la lista en sí no puede ser null.
        // Esto podría pasar si alguien modificara el campo directamente sin usar el constructor.
        if (estudiantes == null) return false;

        // Invariante 2: recorremos cada elemento y chequeamos que sea válido.
        for (String estudiante : estudiantes) {

            // Usamos || (O lógico) porque cualquiera de las dos condiciones sola ya es un problema:
            //   - estudiante == null         → elemento nulo en la lista
            //   - !estudiante.matches(...)   → nombre con caracteres inválidos
            //
            // ERROR COMÚN (que cometí antes): usar && en vez de ||.
            // Con &&, ambas condiciones tendrían que ser true a la vez para rechazar,
            // lo cual casi nunca pasa. Además, si estudiante es null y usamos &&,
            // Java igual intenta evaluar .matches() sobre null → NullPointerException.
            //
            // Con ||, si la primera condición (== null) es true, Java aplica
            // EVALUACIÓN DE CORTOCIRCUITO: no evalúa la segunda condición,
            // evitando el error de llamar .matches() sobre null.
            if (estudiante == null || !estudiante.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) return false;
        }

        // Si pasó todas las invariantes, el objeto está en estado válido.
        return true;
    }
}