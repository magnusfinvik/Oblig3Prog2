import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


/*
    PseudoKode for � forklare fremgangsm�ten i dfsmetoden

    deklarer stack, s�keOrden, og boolean erBes�kt
    lager foreldreliste og setter alle til -1
    setter current til startHj�rne
    push current p� stack, add til s�keOrden
    og sett den til bes�kt
    loop: s� lenge stack ikke er tom
        finn neste nabo
        hvis nabo = -1
            hent �verste element fra stack
        ellers
            legg til nabo i s�keOrden
            sett forelder til nabo til current
            sett at nabo er bes�kt
            push nabo p� stacken
            sett current til nabo

    returner et nytt tre av (startHj�rne, foreldreListen, s�keOrden)

    hjelpemetode for � hente neste nabo
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

    String[] cityVertices = {"bod�", "troms�", "trondheim", "oslo"};

    int[][] cityEdges = {
            {0, 2}, {0, 3},
            {1, 0}, {1, 2},
            {2, 0}, {2, 3},
            {3, 1}, {3, 0}
    };

    Graph<String> cityGraph = new UnweightedGraphWithStack<>(cityVertices, cityEdges);

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
    public void dfstest_checkThatTheFirstVertexAfterAIsCorrect_goingFromA() {
        AbstractGraph<Character>.Tree dfs = graph.dfs(0);

        List<Integer> searchOrder = dfs.getSearchOrder();
        assertEquals(1, (int) searchOrder.get(1));
    }

    @Test
    public void dfstest_findingAllStepsFromVertexD() {
        AbstractGraph<Character>.Tree dfs = graph.dfs(3);

        List<Integer> searchOrder = dfs.getSearchOrder();
        assertEquals("[3, 1, 0, 2]", searchOrder.toString());
    }

    @Test
    public void dfstest_findingAllStepsFromVertexA() {
        AbstractGraph<Character>.Tree dfs = graph.dfs(0);

        List<Integer> searchOrder = dfs.getSearchOrder();
        assertEquals("[0, 1, 3, 2]", searchOrder.toString());
    }

    @Test
    public void dfsTest_findingAllStepsFromBodo() {
        AbstractGraph<String>.Tree dfs = cityGraph.dfs(0);

        List<Integer> searchOrder = dfs.getSearchOrder();
        assertEquals("[0, 2, 3, 1]", searchOrder.toString());
    }

    @Test
    public void dfsTest_findingAllStepsFromTrondheim() {
        AbstractGraph<String>.Tree dfs = cityGraph.dfs(2);

        List<Integer> searchOrder = dfs.getSearchOrder();
        assertEquals("[2, 0, 3, 1]", searchOrder.toString());
    }

    @Test
    public void getPath_checkThatTheFirstStepIsCorrect_shouldBeTheStartingVertex() {
        List<Integer> path = graph.getPath(0, 3);

        assertEquals(0, (int) path.get(0));
    }

    @Test
    public void getPath_checkThatTheWholePathIsCorrect_shouldBe013() {
        List<Integer> path = graph.getPath(0, 3);
        assertEquals("[0, 1, 3]", path.toString());
    }

    @Test
    public void getPath_checkThatThePathIsCorrectFromBodoToTrondheim_shouldBe02() {
        List<Integer> path = cityGraph.getPath(0, 2);
        assertEquals("[0, 2]", path.toString());
    }

    @Test
    public void getPath_checkThatThePathIsCorrectFromOsloToTrondheim_shouldBe312() {
        List<Integer> path = cityGraph.getPath(3, 2);
        assertEquals("[3, 1, 2]", path.toString());
    }

    @Test
    public void isConnected_checkThatTheGraphIsConnected_returnTrue() {
        assertTrue(graph.isConnected());
    }

    @Test
    public void isConnected_addingAnotherVertexToMakeItANotConnectedGraph_returnFalse() {
        graph.addVertex('E');
        assertFalse(graph.isConnected());
    }

    @Test
    public void isCycle_checkThatTheGraphHasNoCycles_returnsTrue() {
        assertTrue(graph.isCyclic());
    }

    @Test
    public void isCycle_usingAdifferentGraphThatIsntCyclic_returnFalse() {
        Character[] vertices = {'A', 'B', 'C'};

        int[][] edges = {
                {0, 1},
                {1, 0}, {1, 2},
                {2, 1}
        };

        Graph<Character> graphWithoutCycle = new UnweightedGraphWithStack<>(vertices, edges);
        assertFalse(graphWithoutCycle.isCyclic());
    }
}