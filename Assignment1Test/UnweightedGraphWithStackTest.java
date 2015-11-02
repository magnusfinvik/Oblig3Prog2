import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/*
    PseudoKode for å forklare fremgangsmåten i dfsmetoden

    deklarer stack, søkeOrden, og boolean erBesøkt
    lager foreldreliste og setter alle til -1
    setter current til startHjørne
    push current på stack, add til søkeOrden
    og sett den til besøkt
    så lenge stack ikke er tom
        nabo = finn neste ikke besøkte hjørne (hjelpemetode)
        hvis nabo = -1
            pop øverste element fra stack
        ellers
            legg til nabo i søkeOrden
            sett forelder til nabo til current
            sett at nabo er besøkt
            push nabo på stacken
            sett current til nabo

    returner et nytt tre av (startHjørne, foreldreListen, søkeOrden)

    hjelpemetode
        for hver nabo til current
            hvis nabo ikke er besøkt
                returner nabo
        returner -1 hvis alle naboer er besøkt

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
    public void dfstest_checkThatTheCorrectNumberOferticesIsVisited_goingFromB () {
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