package turtle;

public class Paper {

    private final int width;
    private final int height;
    private char[][] grid;

    public Paper(){
        this(10, 10);
    }

    public Paper(int width, int height){
        assert (width >= 0 && height >= 0);
        this.width = width;
        this.height = height;
        this.grid = new char[width][height];

        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                grid[i][j] = ' ';
            }
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public boolean withinBounds(int x, int y){
        return (x < width && y < height && x >= 0 && y >= 0);
    }

    public void mark(int x, int y, char c){
        if (withinBounds(x, y)){
            grid[x][y] = c;
        }
    }

    public String toString(){
        String answer = "";
        for (int y = height - 1; y >= 0; y--){
            for (int x = 0; x < width; x++){
                answer += grid[x][y];
            }
            answer += "\n";
        }
        answer += "\n";
        return answer;
    }
}
