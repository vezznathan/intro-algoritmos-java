/**
 * Analizador de notas de examen.
 * Guarda hasta 30 notas y calcula estadísticas básicas.
 */
public class AnalizadorNotas {

    // Arreglo de tamaño fijo: máximo 30 notas
    private int[] notas;

    // Cuántas notas cargamos hasta ahora
    private int cantidadNotas;

    /**
     * Constructor: crea el arreglo vacío.
     */
    public AnalizadorNotas() {
        notas = new int[30];   // 30 posiciones, índices 0 a 29
        cantidadNotas = 0;     // todavía no hay notas cargadas
    }

    /**
     * Agrega una nota al arreglo.
     * Precondición: nota >= 0 && nota <= 10
     */
    public void agregarNota(int nota) {
        assert nota >= 0 && nota <= 10 : "La nota debe estar entre 0 y 10";
        assert cantidadNotas < 30 : "El arreglo está lleno";

        notas[cantidadNotas] = nota;  // guardamos en la posición actual
        cantidadNotas++;               // avanzamos al siguiente lugar
    }

    /**
     * Imprime todas las notas cargadas.
     */
    public void imprimirNotas() {
        // for clásico: recorre solo hasta cantidadNotas, no hasta 30
        for (int i = 0; i < cantidadNotas; i++) {
            System.out.println("Nota " + i + ": " + notas[i]);
        }
    }

    /**
     * Calcula el promedio de las notas cargadas.
     * Precondición: cantidadNotas > 0
     */
    public double calcularPromedio() {
        assert cantidadNotas > 0 : "No hay notas cargadas";

        int suma = 0;
        for (int i = 0; i < cantidadNotas; i++) {
            suma = suma + notas[i];
        }

        // OJO: (double) convierte la división a decimal
        return (double) suma / cantidadNotas;
    }

    /**
     * Invariante de clase: verifica que el estado del objeto es consistente.
     * El profe mencionó que puede caer un repOK() en el parcial.
     */
    public boolean repOK() {
        // cantidadNotas nunca puede ser negativa ni superar el tamaño del arreglo
        if (cantidadNotas < 0 || cantidadNotas > notas.length) return false;

        // cada nota cargada debe estar en rango válido
        for (int i = 0; i < cantidadNotas; i++) {
            if (notas[i] < 0 || notas[i] > 10) return false;
        }

        return true;
    }
}