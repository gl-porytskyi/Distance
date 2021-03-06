package gl.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import gl.builder.GraphBuilder;
import gl.calculator.recursive.RecursiveDistanceCalculator;
import gl.domain.Node;
import gl.domain.impl.SimpleNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Oleksandr Porytskyi
 */
@RunWith(Parameterized.class)
public class DistanceCalculatorTest {
    @Parameterized.Parameter
    public DistanceCalculator distanceCalculator;

    @Parameterized.Parameters
    public static Collection<? extends DistanceCalculator> getDistanceCalculators() {
        return Arrays.asList(new RecursiveDistanceCalculator());
    }

    @Test
    public void testSame() {
        final Node first = new SimpleNode();
        Integer d = distanceCalculator.calcDistance(first, first);
        assertEquals((Object) 0, d);
    }

    @Test
    public void testOne() {
        Node first = new SimpleNode();
        Node second = new SimpleNode();
        first.getNeighbours().add(second);
        second.getNeighbours().add(first);
        Integer d = distanceCalculator.calcDistance(first, second);
        assertEquals((Object) 1, d);
    }

    @Test
    public void testTwo() {
        Node first = new SimpleNode();
        Node second = new SimpleNode();
        Node third = new SimpleNode();
        first.getNeighbours().add(second);
        second.getNeighbours().addAll(Arrays.asList(first, third));
        third.getNeighbours().add(second);
        Integer d = distanceCalculator.calcDistance(first, third);
        assertEquals((Object) 2, d);
    }

    @Test
    public void testThree() {
        Node first = new SimpleNode();
        Node second = new SimpleNode();
        Node third = new SimpleNode();
        Node fourth = new SimpleNode();
        first.getNeighbours().add(second);
        second.getNeighbours().addAll(Arrays.asList(first, third));
        third.getNeighbours().addAll(Arrays.asList(second, fourth));
        fourth.getNeighbours().add(third);
        Integer d = distanceCalculator.calcDistance(first, fourth);
        assertEquals((Object) 3, d);
    }

    @Test
    public void testFour() {
        Node first = new SimpleNode();
        Node second = new SimpleNode();
        Node third = new SimpleNode();
        Node fourth = new SimpleNode();
        Node fifth = new SimpleNode();
        first.getNeighbours().add(second);
        second.getNeighbours().addAll(Arrays.asList(first, third));
        third.getNeighbours().addAll(Arrays.asList(second, fourth));
        fourth.getNeighbours().addAll(Arrays.asList(third, fifth));
        fifth.getNeighbours().add(fourth);
        Integer d = distanceCalculator.calcDistance(first, fifth);
        assertNull(d);
    }

    @Test
    public void testMin() {
        Node first = new SimpleNode();
        Node second = new SimpleNode();
        Node third = new SimpleNode();
        Node fourth = new SimpleNode();
        first.getNeighbours().add(second);
        second.getNeighbours().addAll(Arrays.asList(first, third, fourth));
        third.getNeighbours().addAll(Arrays.asList(second, fourth));
        fourth.getNeighbours().addAll(Arrays.asList(third, second));
        Integer d = distanceCalculator.calcDistance(first, fourth);
        assertEquals((Object) 2, d);
    }

    @Test
    public void testBuilder() {
        final int size = 5;
        List<Node> nodes = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            final SimpleNode node = new SimpleNode();
            node.setName(String.valueOf((char) ('A' + i)));
            nodes.add(node);
        }
        GraphBuilder.buildFromMatrix(nodes, new boolean[][]{
                //  A   B       C       D   E
                {false, true, false, false, true},
                {false, false, true, false, false},
                {false, false, false, true, false},
                {false, false, false, false, true},
                {false, false, false, false, false},
        });
        final Integer integer = distanceCalculator.calcDistance(nodes.get(0), nodes.get(3));
        assertEquals((Object) 2, integer);
    }
}
