package graph.node;

import java.util.Hashtable;

/**
 * Tabla hash con los valores numericos del alfabeto.
 * Esta tabla hash tomara como clave los numeros del
 * 0 al 25 y sus respectivos valores seran la letra del
 * alfabeto que les corresponde (0 = A, 1 = B, etc).
 *
 * @author David Fidgett
 */
public class Diccionario extends Hashtable<Integer, Character> {
    /**
     * Constructor de la Clase Diccionario.
     */
    public Diccionario(){
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            put(i, c);
        }
    }
}
