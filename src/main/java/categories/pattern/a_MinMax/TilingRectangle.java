package categories.pattern.a_MinMax;

public class TilingRectangle {
    private int numRows;         // Number of rows in the rectangle
    private int numCols;         // Number of columns in the rectangle
    private int[] tileCovered;   // Bit representation of tiles covered in each row
    private int minTiles;        // Minimum number of tiles needed to cover the rectangle

    public int tilingRectangle(int n, int m) {
        numRows = n;
        numCols = m;
        minTiles = n * m;     // Initial maximum is the total area, which is the worst case
        tileCovered = new int[n];
        fillRectangle(0, 0, 0);
        return minTiles;
    }

    private void fillRectangle(int row, int col, int tilesUsed) {
        if (col == numCols) {
            row++;        // Move to the next row
            col = 0;      // Reset column to the first one
        }
        if (row == numRows) {
            minTiles = tilesUsed;  // Update the minimum tiles used
            return;
        }
        if ((tileCovered[row] >> col & 1) == 1) {
            fillRectangle(row, col + 1, tilesUsed);  // If the tile at (row, col) is covered, move to next tile
        } else if (tilesUsed + 1 < minTiles) {
            int maxRow = 0, maxCol = 0;
            // Calculate how far we can extend squares to the right and downwards
            for (int i = row; i < numRows && (tileCovered[i] >> col & 1) == 0; ++i) {
                maxRow++;
            }
            for (int j = col; j < numCols && (tileCovered[row] >> j & 1) == 0; ++j) {
                maxCol++;
            }
            int maxSize = Math.min(maxRow, maxCol); // Maximum size of the square we can place

            // Mark the tiles as covered for the largest square initially
            for (int x = row; x < row + maxSize; ++x) {
                for (int y = col; y < col + maxSize; ++y) {
                    tileCovered[x] |= 1 << y;
                }
            }

            // Try placing squares of all possible sizes starting from largest to smallest
            for (int squareSize = maxSize; squareSize > 0; --squareSize) {
                fillRectangle(row, col + squareSize, tilesUsed + 1);

                // Uncover tiles for a square of the current size
                for (int k = 0; k < squareSize; ++k) {
                    tileCovered[row + squareSize - 1] ^= 1 << (col + k);
                    if (k < squareSize - 1) {
                        tileCovered[row + k] ^= 1 << (col + squareSize - 1);
                    }
                }
            }
        }
    }
}
