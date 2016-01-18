package gl.calculator.recursive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
        if (depth < DEFAULT_MAX_DEPTH) {
            final List<Integer> distances = new ArrayList<>(connections.size());
            for (Node person : connections) {
                Integer distance = calcDistance(person, end, depth + 1);
                if (distance != null) {
                    distances.add(distance);
                }
            }
            if (!distances.isEmpty()) {
                return Collections.min(distances);
            }
        }
        return null;
    }
}
