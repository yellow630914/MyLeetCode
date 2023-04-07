import org.junit.jupiter.api.Test;

public class Rotate {
    @Test
    public void testRotate() {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        this.rotate(matrix);
        System.out.println(matrix);
    }
    public void rotate(int[][] matrix) {
        int temp = 0;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                temp = matrix[matrix.length - i - 1][j];
                matrix[matrix.length - i - 1][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0;j < i;j++){
                temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
