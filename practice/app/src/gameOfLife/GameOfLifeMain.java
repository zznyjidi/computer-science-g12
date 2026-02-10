package gameOfLife;

public class GameOfLifeMain {
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife();
        switch (IO.readln("Graph> ")) {
            case "spinner" -> drawSpinner(game, 5, 5);
            case "glider" -> drawGlider(game, 1, 1);
            case "square" -> drawSquare(game, 5, 5);
        }
        while (true) {
            IO.println(game);
            game.process();
            IO.readln();
        }
    }

    public static void drawSquare(GameOfLife game, int centerX, int centerY) {
        int[][] graph = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };
        game.drawGraph(graph, centerX, centerY);
    }

    public static void drawSpinner(GameOfLife game, int centerX, int centerY) {
        int[][] graph = {
                { 1, 1, 1 }
        };
        game.drawGraph(graph, centerX, centerY);
    }

    public static void drawGlider(GameOfLife game, int centerX, int centerY) {
        int[][] graph = {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 }
        };
        game.drawGraph(graph, centerX, centerY);
    }
}
