
import java.util.List;


public class UnweightedGraphWithStack<V> extends AbstractGraph<V> {
    /** Construct an empty graph */
    public UnweightedGraphWithStack() {
    }

    /** Construct a graph from vertices and edges stored in arrays */
    public UnweightedGraphWithStack(V[] vertices, int[][] edges) {
        super(vertices, edges);
    }

    /** Construct a graph from vertices and edges stored in List */
    public UnweightedGraphWithStack(List<V> vertices, List<Edge> edges) {
        super(vertices, edges);
    }

    /** Construct a graph for integer vertices 0, 1, 2 and edge list */
    public UnweightedGraphWithStack(List<Edge> edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    /** Construct a graph from integer vertices 0, 1, and edge array */
    public UnweightedGraphWithStack(int[][] edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

}