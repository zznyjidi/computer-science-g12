package gameOfLife;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class GameOfLife {
    static final String COLORED_CHAR = "██";
    static final String EMPTY_CHAR = "[]";

    final int SIZE = 11;
    private boolean[][] grid = new boolean[SIZE][SIZE];

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (boolean[] line : grid) {
            for (boolean space : line) {
                builder.append(space ? COLORED_CHAR : EMPTY_CHAR);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public void setBox(int x, int y, boolean state) {
        grid[y][x] = state;
    }

    public boolean getBox(int x, int y) {
        return grid[y][x];
    }

    public void toggleBox(int x, int y) {
        setBox(x, y, !getBox(x, y));
    }

    private int getBoxToInt(int x, int y) {
        return getBox(x, y) ? 1 : 0;
    }

    public int getSurroundingBoxCount(int x, int y) {
        int count = 0;
        boolean hasLeft = x > 0;
        boolean hasRight = x < SIZE - 1;
        boolean hasTop = y > 0;
        boolean hasBottom = y < SIZE - 1;

        if (hasTop) {
            count += getBoxToInt(x, y - 1);
            count += hasLeft ? getBoxToInt(x - 1, y - 1) : 0;
            count += hasRight ? getBoxToInt(x + 1, y - 1) : 0;
        }
        if (hasBottom) {
            count += getBoxToInt(x, y + 1);
            count += hasLeft ? getBoxToInt(x - 1, y + 1) : 0;
            count += hasRight ? getBoxToInt(x + 1, y + 1) : 0;
        }
        count += hasLeft ? getBoxToInt(x - 1, y) : 0;
        count += hasRight ? getBoxToInt(x + 1, y) : 0;

        return count;
    }

    public void process() {
        List<Point> togglePoints = new LinkedList<>();
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                int count = getSurroundingBoxCount(x, y);
                if (getBox(x, y)) {
                    if (count < 2 || count > 3)
                        togglePoints.add(new Point(x, y));
                } else {
                    if (count == 3)
                        togglePoints.add(new Point(x, y));
                }
            }
        }
        for (Point point : togglePoints) {
            toggleBox(point.x, point.y);
        }
    }

    public void drawGraph(int[][] graph, int centerX, int centerY) {
        int graphOffsetY = graph.length / 2;
        int graphOffsetX = graph[0].length / 2;
        for (int y = 0; y < graph.length; y++) {
            for (int x = 0; x < graph[y].length; x++) {
                setBox(centerX - graphOffsetX + x, centerY - graphOffsetY + y, graph[y][x] > 0);
            }
        }
    }
}
