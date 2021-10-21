

public class SzallitasiFeladat {

    public static void main(String[] args) {

        double[][] matrix = {
                {1, 3, 4, 3, 4},
                {3, 3, 2, 1,3},
                {5, 4, 3, 3,3},
                {2,2,4,2,10}
        };

        double[][] matrix2 = Linearis.matrixMasolas(matrix);

        double megoldas = megoldas(matrix, matrix2);

        kezdetiMegoldas(matrix);

        Linearis.matrixKiiras(matrix);
        System.out.println(megoldas);
        //oszlopok szama
        //System.out.println(matrix[0].length);

        //sorok szama
        //System.out.println(matrix.length);
    }


    public static void kezdetiMegoldas(double[][] matrix) {
        double mentes;
        int kezdoI = 0;
        int kezdoJ = 0;
        int i = 0;
        int j = 0;

        while (i < matrix.length-1 && j < matrix[0].length-1) {
            System.out.println("i: " + i);
            System.out.println("j: " + j);
            if (oszlopVagySor(matrix, i, j) == 1) {
                mentes = matrix[i][matrix[0].length - 1];
                matrix[i][j] = matrix[i][matrix[0].length - 1];
                for (int k = j + 1; k < matrix[0].length; k++)
                    matrix[i][k] = 0;
                matrix[matrix.length - 1][j] = matrix[matrix.length - 1][j] - mentes;
                i++;
                kezdoI++;
                j = kezdoJ;
            } else {
                mentes = matrix[matrix.length - 1][j];
                matrix[i][j] = matrix[matrix.length - 1][j];
                if (i + 1 < matrix.length ) {
                    for (int k = i + 1; k < matrix.length; k++)
                        matrix[k][j] = 0;
                }
                System.out.println(" ");
                System.out.println(matrix[i][matrix[0].length - 1]);
                System.out.println(mentes);
                System.out.println(matrix[matrix.length-1][j]);

                System.out.println(" ");
                matrix[i][matrix[0].length - 1] = matrix[i][matrix[0].length - 1] - mentes;
                //matrix[matrix.length-1][j]=matrix[matrix.length-1][j]-mentes;
                j++;
                kezdoJ++;
                i = kezdoI;
            }

            System.out.println();
            Linearis.matrixKiiras(matrix);
            System.out.println();
        }




    }

    public static int oszlopVagySor(double[][] matrix, int sor, int oszlop) {
        //1 -et ad vissza ha sor kisebb, 2 -t ha az oszlop
        if (matrix[sor][matrix[0].length - 1] < matrix[matrix.length - 1][oszlop] || matrix[sor][matrix[0].length - 1] == matrix[matrix.length - 1][oszlop])
            return 1;
        return 0;


    }

    public static double megoldas(double[][] matrix, double[][] matrix2) {
        double megoldas = -1;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0)
                    megoldas = matrix[i][j] * matrix2[i][j];
            }
        return megoldas;

    }


}
