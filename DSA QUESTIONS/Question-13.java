// Given a boolean 2D matrix, find the number of islands 
// (A group of connected 1s forms an island.). A group of 
// connected 1s forms an island. For example, the below 
// matrix contains 5 islands. 
// 			Input : mat[][] = {{1, 1, 0, 0, 0},
//                {0, 1, 0, 0, 1},
//                {1, 0, 0, 1, 1},
//                {0, 0, 0, 0, 0},
//                {1, 0, 1, 0, 1} 
// Output : 5

public class IslandCount {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
        };
        int islandCount = countIslands(matrix);
        System.out.println("Number of islands: " + islandCount);
    }

    public static int countIslands(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int count = 0;

        boolean[][] visited = new boolean[rows][columns];

        // Iterate through each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    searchIslandMatrix(matrix, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void searchIslandMatrix(int[][] matrix, boolean[][] visited, int row, int col) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Check if the current cell is out of bounds or already visited
        if (row < 0 || row >= rows || col < 0 || col >= columns || visited[row][col] || matrix[row][col] == 0) {
            return;
        }

        // Mark the current cell as visited
        visited[row][col] = true;

        // Explore neighboring cells in all 8 directions
        searchIslandMatrix(matrix, visited, row - 1, col); // Up
        searchIslandMatrix(matrix, visited, row + 1, col); // Down
        searchIslandMatrix(matrix, visited, row, col - 1); // Left
        searchIslandMatrix(matrix, visited, row, col + 1); // Right
        searchIslandMatrix(matrix, visited, row - 1, col - 1); // Diagonal: Up-Left
        searchIslandMatrix(matrix, visited, row - 1, col + 1); // Diagonal: Up-Right
        searchIslandMatrix(matrix, visited, row + 1, col - 1); // Diagonal: Down-Left
        searchIslandMatrix(matrix, visited, row + 1, col + 1); // Diagonal: Down-Right
    }
}
