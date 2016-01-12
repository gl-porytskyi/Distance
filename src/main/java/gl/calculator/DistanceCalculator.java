package gl.calculator;

import gl.domain.Node;

/**
 * @author Oleksandr Porytskyi
 */
public interface DistanceCalculator {
    int DEFAULT_MAX_DEPTH = 3;

    Integer calcDistance(Node start, Node end);
}
