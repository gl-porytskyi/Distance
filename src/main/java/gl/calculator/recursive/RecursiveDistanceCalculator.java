package gl.calculator.recursive;

import java.util.Collection;

import gl.calculator.DistanceCalculator;
import gl.domain.Node;

/**
 * @author Oleksandr Porytskyi
 */
public class RecursiveDistanceCalculator implements DistanceCalculator {
    @Override
    public Integer calcDistance(final Node start, final Node end) {
        if (start == end) {
            return 0;
        }
        return calcDistance(start, end, 1);
    }

    private Integer calcDistance(final Node start, final Node end, final int depth) {
        final Collection<Node> connections = start.getNeighbours();
        for (Node person : connections) {
            if (person == end) {
                return depth;
            }
        }
        for (Node person : connections) {
            if (depth < DEFAULT_MAX_DEPTH) {
                Integer d = calcDistance(person, end, depth + 1);
                if (d != null) {
                    return d;   //  TODO mb not shortest
                }
            }
        }
        return null;
    }
}
