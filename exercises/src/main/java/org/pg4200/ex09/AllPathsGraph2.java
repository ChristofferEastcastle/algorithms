package org.pg4200.ex09;

import org.pg4200.les09.UndirectedGraph;

import java.util.*;

public class AllPathsGraph2<V> extends UndirectedGraph {

    public List<List<V>> findAllPaths(V start, V end) {
        List<List<V>> paths = new ArrayList<>();
        Deque<V> stack = new ArrayDeque<>();

        findAllPaths(paths, stack, start, end);
        return paths;
    }

    private void findAllPaths(List<List<V>> paths, Deque<V> stack, V current, V end) {
        stack.push(current);
        if (current == end) {
            ArrayList<V> path = new ArrayList<>(stack);
            Collections.reverse(path);
            paths.add(path);
            return;
        }

        for (var node : getAdjacents(current)) {
            if (stack.contains(node)) continue;

            findAllPaths(paths, stack, (V) node, end);
            stack.pop();
        }
    }
}
