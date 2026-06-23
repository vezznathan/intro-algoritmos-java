import java.util.ArrayList;

public class Playlist {

    private String nombre;
    private ArrayList<String> canciones;
    private int maxCanciones;

    /**
     * Constructor.
     * Precondición: nombre != null y solo letras, max > 0
     */
    public Playlist(String nombre, int max) {
        assert (nombre != null && nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")): "ingresar nombre valido";
        this.nombre = nombre;
        canciones = new ArrayList<String>();
        maxCanciones = max;
    }

    /**
     * Agrega una canción a la playlist.
     * Precondición: cancion != null, la playlist no está llena
     * Postcondición: la playlist tiene una canción más
     */
    public void agregarCancion(String cancion) {
        // COMPLETAR
        assert cancion != null;
        assert canciones.size() < maxCanciones;
        canciones.add(cancion);
    }

    /**
     * Devuelve true si la playlist está llena.
     */
    public boolean estaLlena() {
        // COMPLETAR
        return canciones.size() == maxCanciones;
        
    }

    /**
     * Devuelve la cantidad de canciones.
     */
    public int cantidadCanciones() {
        // COMPLETAR
        return canciones.size();
    }

    /**
     * Imprime todas las canciones numeradas desde 1.
     * Ejemplo: "1. Bohemian Rhapsody"
     */
    public void imprimirPlaylist() {
        // COMPLETAR — usá for clásico con índice, no for-each
        for (int i = 0; i < canciones.size(); i++) {
            System.out.println((i + 1) + ". " + canciones.get(i));
        }
    }

    /**
     * Elimina todas las canciones que contengan una palabra clave.
     * Ejemplo: eliminarPor("Rock") elimina todas las que tengan "Rock" en el nombre.
     * Postcondición: ninguna canción en la lista contiene la palabra clave
     */
    public void eliminarPor(String clave) {
        // COMPLETAR — pista: necesitás while + índice, no for-each
        // ¿por qué? pensalo antes de arrancar
        int i = 0;
        while (i < canciones.size()) {
            if (canciones.get(i).contains(clave)) {
                canciones.remove(i); // no avanzamos i
            } else {
                i++; // solo avanzamos si no eliminamos
    }
}
    }

    public boolean repOK() {
        // COMPLETAR
        if (canciones == null || canciones.size() > maxCanciones || maxCanciones <= 0 || nombre == null || !nombre.matches ("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) return false;
        return true;
    }
}