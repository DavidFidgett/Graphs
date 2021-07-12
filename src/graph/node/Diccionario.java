package graph.node;

import java.util.Hashtable;

public class Diccionario extends Hashtable<Integer, Character> {
    public Diccionario(){
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            put(i, c);
        }
    }
}
