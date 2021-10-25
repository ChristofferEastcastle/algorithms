package org.pg4200.ex09;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllPathsGraphTest {

    @Test
    void testAllPaths() {
        AllPathsGraph<String> graph = new AllPathsGraph<>();
        graph.addEdge("0","X");
        graph.addEdge("X","1");
        graph.addEdge("X","Y");
        graph.addEdge("1","2");
        graph.addEdge("2","Y");
        graph.addEdge("1","3");
        graph.addEdge("3","4");
        graph.addEdge("3","5");
        graph.addEdge("4","5");

        var paths = graph.findAllPaths("X", "5");

        assertEquals(4, paths.size());
        var list = new ArrayList<>();
        for (var path : paths) {
            list.add(path.size());
        }

        assertTrue(list.containsAll(List.of(4, 5, 6, 7)));
    }
}
