package gl.domain.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import gl.domain.Node;

/**
 * @author Oleksandr Porytskyi
 */
public class SimpleNode implements Node {
    private String name;
    private Set<Node> neighbours = new HashSet<>();

    @Override
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public Collection<Node> getNeighbours() {
        return neighbours;
    }
}
