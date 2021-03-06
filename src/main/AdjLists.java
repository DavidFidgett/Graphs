package main;

/**
 * Clase auxiliar que contiene listas de adyacencias de
 * diferentes grafos.
 *
 * @author David Gutierrez Marin
 */
public class AdjLists {

    /**
     * Grafo No Ponderado No Dirigido #1.
     * <br><br>
     * <img src="doc-files/g_01.png" alt="Grafo No Ponderado No Dirigido #1">
     */
    public static final int[][] g_01 = {
            {1, 2, 3},
            {0, 3},
            {0, 3, 4},
            {0, 1, 2, 4},
            {2, 3}
    };

    /**
     * Grafo No Ponderado No Dirigido #2.
     * <br><br>
     * <img src="doc-files/g_02.png" alt="Grafo No Ponderado No Dirigido #2">
     */
    public static final int[][] g_02 = {
            {2, 4, 6},
            {5},
            {0},
            {7},
            {0, 5, 7},
            {1, 4, 7},
            {0},
            {3, 4, 5}
    };


//    public static final int[][] g_03 = {
//            {1, 4},
//            {0, 4, 5, 6},
//            {3},
//            {2, 4},
//            {0, 1, 3, 5},
//            {1, 4},
//            {1}
//    };

//    public static final int[][] dg_01 = {
//            {2, 3},
//            {0},
//            {3, 4},
//            {1, 4},
//            {}
//    };

    /**
     * Grafo Ponderado No Dirigido #1.
     * <br><br>
     * <img src="doc-files/wg_01.png" alt="Grafo Ponderado No Dirigido #1">
     */
    public static final int[][][] wg_01 = {
            {{1, 4}, {6, 5}},
            {{0, 4}, {4, 4}, {5, 4}},
            {{3, 3}, {6, 3}},
            {{2, 3}, {4, 3}, {5, 4}},
            {{1, 4}, {3, 3}, {5, 2}, {6, 3}},
            {{1, 4}, {3, 4}, {4, 2}},
            {{0, 5}, {2, 3}, {4, 3}}
    };

    /**
     * Grafo Ponderado No Dirigido #2.
     * <br><br>
     * <img src="doc-files/wg_02.png" alt="Grafo Ponderado No Dirigido #2">
     */
    public static final int[][][] wg_02 = {
            {{2, 5}, {9, 6}},
            {{8, 6}, {9, 3}},
            {{0, 5}, {3, 5}},
            {{2, 5}, {4, 3}, {5, 4}, {9, 4}},
            {{3, 3}, {5, 2}, {6, 2}},
            {{3, 4}, {4, 2}, {6, 4}, {8, 4}},
            {{4, 2}, {5, 4}, {7, 3}},
            {{6, 3}},
            {{1, 6}, {5, 4}, {9, 3}},
            {{0, 6}, {1, 3}, {3, 4}, {8, 3}}
    };

    /**
     * Grafo Ponderado No Dirigido #3.
     * <br><br>
     * <img src="doc-files/wg_03.png" alt="Grafo Ponderado No Dirigido #3">
     */
    public static final int[][][] wg_03 = {
            {{1, 5}, {3, 4}},
            {{0, 5}, {2, 4}, {5, 5}},
            {{1, 4}, {3, 4}, {4, 5}},
            {{0, 4}, {2, 4}},
            {{2, 5}, {5, 3}},
            {{1, 5}, {4, 3}}
    };

}
