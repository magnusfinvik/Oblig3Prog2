import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/*
    lager en stack og en searchOrder liste
    og lager en parent med plass til alle hjørner
    og setter alle disse til -1
    lager en boolean liste isVisited
    dfs(vertice v)
        pusher v på stacken og setter v til besøkt
        for hver nabo til v i listen naboer
            if(nabo ikke er besøkt)
                legg til v som forelder til nabo i graph
        kall dfs(nabo)
    når alle hjørner er besøkt:
        while(stacken ikke er tom)
            legger til øverste element i stack til searchOrder
   return et tre med v som rot, parent listen og searchOrder

*/
public class UnweightedGraphWithStackTest {
    Character[] vertices = {'A', 'B', 'C', 'D' };

    int[][] edges = {
            {0, 1}, {0, 2},
            {1, 0}, {1, 3},
            {2, 0}, {2, 1},
            {3, 1}
    };

    Graph<Character> graph = new UnweightedGraphWithStack<>(vertices, edges);


    @Test
    public void dfstest_checkThatTheCorrectAmountOfVerticesIsAddedToTheVisitedList() {

        AbstractGraph<Character>.Tree dfs = graph.dfs(0);

        int numberOfVerticesFound = dfs.getNumberOfVerticesFound();

        assertEquals(4, numberOfVerticesFound);
    }

    @Test
    public void dfstest_checkThatTheFirstVertixAfterAIsCorrect_goingFromA() {
        AbstractGraph<Character>.Tree dfs = graph.dfs(0);

        List<Integer> searchOrder = dfs.getSearchOrder();
        assertEquals(1, (int) searchOrder.get(1));
    }

    @Test
    public void dfstest_findingAllStepsFromVerticeD() {
        AbstractGraph<Character>.Tree dfs = graph.dfs(3);

        List<Integer> searchOrder = dfs.getSearchOrder();
        assertEquals(1, (int) searchOrder.get(1));
        assertEquals(0, (int) searchOrder.get(2));
        assertEquals(2, (int) searchOrder.get(3));
    }

    @Test
    public void dfstest_findingAllStepsFromVerticeA() {
        AbstractGraph<Character>.Tree dfs = graph.dfs(0);

        List<Integer> searchOrder = dfs.getSearchOrder();
        assertEquals(0, (int) searchOrder.get(0));
        assertEquals(1, (int) searchOrder.get(1));
        assertEquals(3, (int) searchOrder.get(2));
        assertEquals(2, (int) searchOrder.get(3));
    }

    @Test
    public void getPath_checkThatTheFirstStepIsCorrect_shouldBeTheStartinVertice() {
        List<Character> path = graph.getPath(0, 3);

        assertEquals(0, (int) path.get(0));
    }

    @Test
    public void isConnected_checkThatTheGraphIsConnected_returnTrue() {
        assertTrue(graph.isConnected());
    }

}