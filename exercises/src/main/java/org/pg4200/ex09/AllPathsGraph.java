package org.pg4200.ex09;

import org.pg4200.ex02.QueueLinkedList;
import org.pg4200.les09.UndirectedGraph;

import java.util.*;

public class AllPathsGraph<V> extends UndirectedGraph<V> {

    public List<List<V>> findAllPaths(V start, V end) {

        Stack<V> visited = new Stack<>();
        List<List<V>> paths = new ArrayList<>();
        findAllPathsDfs(paths, visited, start, end);

        return paths;
    }

    private void findAllPathsDfs(List<List<V>> paths, Stack<V> visited, V current, V end) {
        visited.push(current);

        if (current == end) {
            var path = new ArrayList<>(visited);
            Collections.reverse(path);
            paths.add(path);
            return;
        }

        for (var vertex : getAdjacents(current)) {
            if (visited.contains(vertex)) continue;

            findAllPathsDfs(paths, visited, vertex, end);
            visited.pop();
        }
    }
}
