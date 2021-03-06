import java.awt.Color;

public class Grid extends PixelComponent {

    int[][] grid;
    int length;
    int width;
    Color color[] = new Color[] { Color.white, // floor
            Color.red, // apple
            Color.black, // wall
            Color.orange, // enermy snakes
            Color.green, // player snakes from here on
            Color.blue, 
            Color.lightGray};

    public Grid(int x, int y, int width, int length) {
        this(x, y, 0, width, length);
    }

    public Grid(int x, int y, int z, int width, int length) {
        super(x, y, z);
        this.length = length;
        this.width = width;
        grid = new int[width][length];

        for (int i = 0; i < length; i++) {
            grid[0][i] = 2;
            grid[width - 1][i] = 2;
        }

        for (int i = 0; i < width; i++) {
            grid[i][0] = 2;
            grid[i][length - 1] = 2;
        }

    }
    
    @Override
    public Color[][] getPixels() {
        Color[][] pixels = new Color[width * 2][length * 2];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                pixels[i * 2][j * 2] = color[grid[i][j]];
                pixels[i * 2 + 1][j * 2] = color[grid[i][j]];
                pixels[i * 2][j * 2 + 1] = color[grid[i][j]];
                pixels[i * 2 + 1][j * 2 + 1] = color[grid[i][j]];
            }
        }
        return pixels;
    }

    public void setCell(int x, int y, int code) {
        if (x >= 0 && x < width && y >= 0 && y < length)
            grid[x][y] = code;
    }

    public int getCell(int x, int y) {
        return grid[x][y];
    }

    public void addApple() {

        int x = 0;
        int y = 0;

        while (grid[x][y] != 0) {
            x = (int) (Math.random() * grid.length);
            y = (int) (Math.random() * grid[0].length);
        }

        grid[x][y] = 1;

    }

}