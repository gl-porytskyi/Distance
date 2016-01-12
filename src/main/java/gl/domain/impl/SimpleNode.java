package gl.domain.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import gl.domain.Node;

/**
 * @author Oleksandr Porytskyi
 */
public class SimpleNode implements Node {
    private String name;
    private List<Node> neighbours = new ArrayList<>();

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
