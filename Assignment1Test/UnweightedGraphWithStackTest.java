import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/*
    PseudoKode for � forklare fremgangsm�ten i dfsmetoden

    deklarer stack, s�keOrden, og boolean erBes�kt
    lager foreldreliste og setter alle til -1
    setter current til startHj�rne
    push current p� stack, add til s�keOrden
    og sett den til bes�kt
    s� lenge stack ikke er tom
        nabo = finn neste ikke bes�kte hj�rne (hjelpemetode)
        hvis nabo = -1
            pop �verste element fra stack
        ellers
            legg til nabo i s�keOrden
            sett forelder til nabo til current
            sett at nabo er bes�kt
            push nabo p� stacken
            sett current til nabo

    returner et nytt tre av (startHj�rne, foreldreListen, s�keOrden)

    hjelpemetode
        for hver nabo til current
            hvis nabo ikke er bes�kt
                returner nabo
        returner -1 hvis alle naboer er bes�kt

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
    public void dfstest_checkThatTheCorrectAmountOfVerticesIsAddedToTheVisitedList_goingFromA() {

        AbstractGraph<Character>.Tree dfs = graph.dfs(0);

        int numberOfVerticesFound = dfs.getNumberOfVerticesFound();

        assertEquals(4, numberOfVerticesFound);
    }

    @Test
    public void dfstest_checkThatTheCorrectNumberOfVerticesIsVisited_goingFromB () {
        AbstractGraph<Character>.Tree dfs = graph.dfs(1);

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
    public void dfstest_findingAllStepsFromVertixD() {
        AbstractGraph<Character>.Tree dfs = graph.dfs(3);

        List<Integer> searchOrder = dfs.getSearchOrder();
        assertEquals(1, (int) searchOrder.get(1));
        assertEquals(0, (int) searchOrder.get(2));
        assertEquals(2, (int) searchOrder.get(3));
    }

    @Test
    public void dfstest_findingAllStepsFromVertixA() {
        AbstractGraph<Character>.Tree dfs = graph.dfs(0);

        List<Integer> searchOrder = dfs.getSearchOrder();
        assertEquals(0, (int) searchOrder.get(0));
        assertEquals(1, (int) searchOrder.get(1));
        assertEquals(3, (int) searchOrder.get(2));
        assertEquals(2, (int) searchOrder.get(3));
    }

    @Test
    public void getPath_checkThatTheFirstStepIsCorrect_shouldBeTheStartingVertix() {
        List<Integer> path = graph.getPath(0, 3);

        assertEquals(0, (int) path.get(0));
    }

    @Test
    public void getPath_checkThatTheWholePathIsCorrect_shouldBe013() {
        List<Integer> path = graph.getPath(0, 3);
        assertEquals("[0, 1, 3]", path.toString());
    }

    @Test
    public void isConnected_checkThatTheGraphIsConnected_returnTrue() {
        assertTrue(graph.isConnected());
    }

    @Test
    public void isConnected_addingAnotherVertixToMakeItANotConnectedGraph_returnFalse() {
        graph.addVertex('E');
        assertFalse(graph.isConnected());
    }

    @Test
    public void isCycle_checkThatTheGraphHasNoCycles_returnsTrue() {
        assertFalse(graph.isCyclic());
    }
}