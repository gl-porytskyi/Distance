package gl.calculator;

import gl.domain.Node;

/**
 * @author Oleksandr Porytskyi
 */
public interface DistanceCalculator {
    Integer getDistance(Node start, Node end);
}
