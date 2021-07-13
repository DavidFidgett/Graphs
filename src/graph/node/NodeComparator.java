package graph.node;

import java.util.Comparator;

/**
 * Clase Comparator para la clase {@link Node}
 *
 * @author David Gutierrez Marin
 */
public class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        if (o1.weight < o2.weight) {
            return -1;
        } else if (o1.weight > o2.weight) {
            return 1;
        }
        return 0;
    }
}
