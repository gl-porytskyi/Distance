package gl.builder;

import java.util.List;

import gl.domain.Node;

/**
 * @author Oleksandr Porytskyi
 */
public class GraphBuilder {
    public static void buildFromMatrix(List<Node> nodes, boolean[][] matrix) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (matrix[i][j]) {
                    makeBidirectionalConnection(nodes.get(i), nodes.get(j));
                }
            }
        }
    }

    private static void makeBidirectionalConnection(Node first, Node second) {
        first.getNeighbours().add(second);
        second.getNeighbours().add(first);
    }
}
