package cn.infomany.arithmetic;

/**
 * 编辑距离
 *
 * @author zjb
 * @date 2020/6/25
 */
public class EditDistance {

    public static void main(String[] args) {
        String source = "11";
        String target = "12";
        int count = minEditDist(source, target);
        System.out.println("count = " + count);
    }

    private static int minEditDist(String source, String target) {
        int m = source.length();
        int n = target.length();

        int[][] matrix = new int[m + 1][n + 1];
        matrix[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            matrix[i][0] = i;
        }

        for (int j = 1; j <= n; j++) {
            matrix[0][j] = j;
        }

        println(matrix);

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = source.charAt(i - 1) == target.charAt(j - 1) ? 0 : 1;
                int minDirect = Math.min(matrix[i - 1][j] + 1, matrix[i][j - 1] + 1);
                matrix[i][j] = Math.min(minDirect, matrix[i - 1][j - 1] + cost);
            }
        }

        println(matrix);
        return matrix[m][n];
    }

    private static void println(int[][] matrix) {
        System.out.println("======start=======");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println("=======end======");
    }


}
