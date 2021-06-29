import java.io.File;
import java.util.Scanner;
import java.lang.Math;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of equations");
        int numLines = scanner.nextInt();
        System.out.println("Enter 1 or 2:\n1: enter the coefficients from the command line\n2: enter a file name");
        Integer option = scanner.nextInt();
        double[][] matrix = new double[numLines][numLines + 1];
        String fileName = "";
        if (option.equals(1)) {
            for (int i = 0; i < numLines; i++) {
                System.out.println("Please enter coefficents for row " + (i + 1));
                for (int j = 0; j < numLines + 1; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
        } else {
            System.out.println("Please enter file name");
            fileName = scanner.next();
            File file = new File("/Users/maxhartke/cpp code/cs3010/project1/src/matrices/" + fileName);
            Scanner fileReader = new Scanner(file);
            for (int i = 0; i < numLines; i++) {
                for (int j = 0; j < numLines + 1; j++) {
                    matrix[i][j] = fileReader.nextInt();
                }
            }
            fileReader.close();
        }
        System.out.println("Please enter the desired stopping error");
        double err = scanner.nextDouble();
        System.out.println("Please enter the desired starting solutions");
        double[] startingSoltuions = new double[numLines];
        int i = 0;
        while (i < numLines) {
            startingSoltuions[i] = scanner.nextInt();
            i++;
        }
        scanner.close();
        long startTime = System.currentTimeMillis();
        System.out.println("Gauss-Seidel Method");
        gs(matrix, startingSoltuions, err);
        long elapsedTime = System.currentTimeMillis() - startTime;
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(elapsedTime + "ms");
        System.out.println("Jacobi Iterative Method");
        startTime = System.currentTimeMillis();
        jacobi(matrix, startingSoltuions, err);
        System.out.println(elapsedTime + "ms");
    }

    public static void jacobi(double[][] matrix, double[] startingSoltuions, double stoppingError) {
        int iterations = 1;
        double l2err = stoppingError + 1;
        double[] solutions = startingSoltuions.clone();
        double[] relativeSolutions = startingSoltuions.clone();
        double[][] iterativeMatrix = new double[matrix.length][matrix.length + 1];
        for (int i = 0; i < iterativeMatrix.length; i++) {
            iterativeMatrix[i] = matrix[i].clone();
        }
        iterativeMatrix = iterateMatix(iterativeMatrix);
        while (l2err > stoppingError && iterations <= 50) {
            for (int i = 0; i < iterativeMatrix.length; i++) {
                double sum = iterativeMatrix[i][iterativeMatrix.length];
                for (int j = 1; j < iterativeMatrix.length; j++) {
                    if (j == i) {
                        sum = iterativeMatrix[i][j] * relativeSolutions[j - i] + sum;
                    } else {
                        sum = iterativeMatrix[i][j] * relativeSolutions[j] + sum;
                    }
                }
                solutions[i] = sum;
                sum = 0;
            }
            l2err = calculateError(relativeSolutions, solutions);
            relativeSolutions = solutions.clone();
            output(solutions, iterations, l2err);
            iterations++;
            if (iterations > 50) {
                System.out.println("Error was not reached");
            }
        }
    }

    public static void gs(double[][] matrix, double[] startingSoltuions, double stoppingError) {
        int iterations = 1;
        double l2err = stoppingError + 1;
        double[] solutions = startingSoltuions.clone();
        double[] relativeSolutions = startingSoltuions.clone();
        double[][] iterativeMatrix = new double[matrix.length][matrix.length + 1];
        for (int i = 0; i < iterativeMatrix.length; i++) {
            iterativeMatrix[i] = matrix[i].clone();
        }
        iterativeMatrix = iterateMatix(iterativeMatrix);
        while (l2err > stoppingError && iterations <= 50) {
            for (int i = 0; i < iterativeMatrix.length; i++) {
                double sum = iterativeMatrix[i][iterativeMatrix.length];
                for (int j = 1; j < iterativeMatrix.length; j++) {
                    if (j == i) {
                        sum = iterativeMatrix[i][j] * solutions[j - i] + sum;
                    } else {
                        sum = iterativeMatrix[i][j] * solutions[j] + sum;
                    }
                }
                solutions[i] = sum;
                sum = 0;
            }
            l2err = calculateError(relativeSolutions, solutions);
            relativeSolutions = solutions.clone();
            output(solutions, iterations, l2err);
            iterations++;
            if (iterations > 50) {
                System.out.println("Error was not reached");
            }
        }
    }

    public static double[][] iterateMatix(double[][] matrix) {
        double[][] iterativeMatrix = new double[matrix.length][matrix.length + 1];
        for (int i = 0; i < iterativeMatrix.length; i++) {
            iterativeMatrix[i] = matrix[i].clone();
        }
        for (int i = 0; i < iterativeMatrix.length; i++) {
            double x = matrix[i][i];
            iterativeMatrix[i][i] = matrix[i][0];
            iterativeMatrix[i][iterativeMatrix.length] = iterativeMatrix[i][iterativeMatrix.length] * -1;
            for (int j = 1; j < iterativeMatrix.length + 1; j++) {
                if (x == 0) {
                    iterativeMatrix[i][j] = 0;
                } else {
                    iterativeMatrix[i][j] = iterativeMatrix[i][j] / -x;
                }
            }
        }
        return iterativeMatrix;
    }

    public static double l2(double[] solutions) {
        double sum = 0;
        for (int i = 0; i < solutions.length; i++) {
            sum = solutions[i] * solutions[i] + sum;
        }
        return Math.sqrt(sum);
    }

    public static double calculateError(double[] solutions, double[] relativeSolutions) {
        double error = Math.abs((l2(relativeSolutions) - l2(solutions))) / l2(relativeSolutions);
        return error;
    }

    public static void output(double[] solutions, int iterations, double error) {
        System.out.print("[");
        int i = 0;
        while (i < solutions.length) {
            if (i == solutions.length - 1) {
                System.out.print(solutions[i]);
            } else {
                System.out.print(solutions[i] + " ");
            }
            i++;
        }
        System.out.print("]" + iterations + " ");
        System.out.println(error);
    }

    public static void random(int size) {
        int[][] matrix = new int[size][size + 1];
        int min = -10;
        int max = 10;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length + 1; j++) {
                matrix[i][j] = (int) Math.floor(Math.random() * (max - min + 1) + min);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
