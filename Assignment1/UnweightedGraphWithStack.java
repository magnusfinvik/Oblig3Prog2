
import java.util.List;


public class UnweightedGraphWithStack<V> extends AbstractGraph<V> {

    public UnweightedGraphWithStack() {
    }

    public UnweightedGraphWithStack(V[] vertices, int[][] edges) {
        super(vertices, edges);
    }

    public UnweightedGraphWithStack(List<V> vertices, List<Edge> edges) {
        super(vertices, edges);
    }

    public UnweightedGraphWithStack(List<Edge> edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    public UnweightedGraphWithStack(int[][] edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

}