package gl.domain;

import java.util.Collection;

/**
 * @author Oleksandr Porytskyi
 */
public interface Node {
    String getName();

    Collection<Node> getNeighbours();
}
