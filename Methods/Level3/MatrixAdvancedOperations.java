public class MatrixAdvancedOperations {

    public static void main(String[] args) {

        double[][] matrix2x2 = createRandomMatrix(2, 2);
        double[][] matrix3x3 = createRandomMatrix(3, 3);

        System.out.println("2x2 Matrix:");
        displayMatrix(matrix2x2);

        System.out.println("\nTranspose (2x2):");
        displayMatrix(transpose(matrix2x2));

        double det2 = determinant2x2(matrix2x2);
        System.out.println("\nDeterminant (2x2): " + det2);

        if (det2 != 0) {
            System.out.println("\nInverse (2x2):");
            displayMatrix(inverse2x2(matrix2x2));
        } else {
            System.out.println("Inverse not possible (determinant is 0).");
        }

        System.out.println("\n-----------------------------------");

        System.out.println("\n3x3 Matrix:");
        displayMatrix(matrix3x3);

        System.out.println("\nTranspose (3x3):");
        displayMatrix(transpose(matrix3x3));

        double det3 = determinant3x3(matrix3x3);
        System.out.println("\nDeterminant (3x3): " + det3);

        if (det3 != 0) {
            System.out.println("\nInverse (3x3):");
            displayMatrix(inverse3x3(matrix3x3));
        } else {
            System.out.println("Inverse not possible (determinant is 0).");
        }
    }

    public static double[][] createRandomMatrix(int rows, int cols) {

        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int)(Math.random() * 9) + 1;
            }
        }

        return matrix;
    }

    public static double[][] transpose(double[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static double determinant2x2(double[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    public static double determinant3x3(double[][] m) {

        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
             - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
             + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    public static double[][] inverse2x2(double[][] m) {

        double det = determinant2x2(m);

        double[][] inv = new double[2][2];

        inv[0][0] = m[1][1] / det;
        inv[0][1] = -m[0][1] / det;
        inv[1][0] = -m[1][0] / det;
        inv[1][1] = m[0][0] / det;

        return inv;
    }

    public static double[][] inverse3x3(double[][] m) {

        double det = determinant3x3(m);
        double[][] inv = new double[3][3];

        inv[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]) / det;
        inv[0][1] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]) / det;
        inv[0][2] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]) / det;

        inv[1][0] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]) / det;
        inv[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]) / det;
        inv[1][2] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]) / det;

        inv[2][0] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]) / det;
        inv[2][1] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]) / det;
        inv[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]) / det;

        return inv;
    }

    public static void displayMatrix(double[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%8.2f", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
