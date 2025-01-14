import java.util.Arrays;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SortDemo {

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }


    public static void main(String[] args) {

        int[] sizes = {10, 100, 1000, 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000, 110000, 120000, 130000, 140000, 150000, 160000, 170000, 180000, 190000, 200000};


        try {
            String filePath = "output.csv";
            FileWriter fileWriter = new FileWriter(filePath, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printRow(printWriter, "Bubble");
            printWriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        for (int size : sizes) {
            int[] randomArray = generateRandomArray(size);
            long startTime = System.nanoTime();
            bubbleSort(randomArray);
            long endTime = System.nanoTime();
            double elapsedTimeInMilliSeconds = (endTime - startTime) / 1e6;
            System.out.println("Bubble Sorted array of size " + size + " Sorting took " + ((int) elapsedTimeInMilliSeconds) + " milliseconds");
            try {
                String filePath = "output.csv";
                FileWriter fileWriter = new FileWriter(filePath, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                printRow(printWriter, String.valueOf((int)elapsedTimeInMilliSeconds));
                printWriter.close();
            } catch (IOException e) {
                System.out.println("File not found");
            }

        }

        try {
            String filePath = "output.csv";
            FileWriter fileWriter = new FileWriter(filePath, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println();
            printRow(printWriter, "Quick");
            printWriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        for (int size : sizes) {
            int[] randomArray = generateRandomArray(size);
            long startTime = System.nanoTime();
            Arrays.sort(randomArray);
            long endTime = System.nanoTime();
            double elapsedTimeInMilliSeconds = (endTime - startTime) / 1e6;
            System.out.println("Quick Sorted array of size " + size + " Sorting took " + ((int) elapsedTimeInMilliSeconds) + " milliseconds");
            try {
                String filePath = "output.csv";
                FileWriter fileWriter = new FileWriter(filePath, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                printRow(printWriter, String.valueOf((int)elapsedTimeInMilliSeconds));
                printWriter.close();
            } catch (IOException e) {
                System.out.println("File not found");
            }
        }

        try {
            String filePath = "output.csv";
            FileWriter fileWriter = new FileWriter(filePath, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println();
            printRow(printWriter, "Merge");
            printWriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        for (int size : sizes) {
            int[] randomArray = generateRandomArray(size);
            long startTime = System.nanoTime();
            MergeSort merge = new MergeSort(randomArray);
            long endTime = System.nanoTime();
            double elapsedTimeInMilliSeconds = (endTime - startTime) / 1e6;
            System.out.println("Merge Sorted array of size " + size + " Sorting took " + ((int) elapsedTimeInMilliSeconds) + " milliseconds");
            try {
                String filePath = "output.csv";
                FileWriter fileWriter = new FileWriter(filePath, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                printRow(printWriter, String.valueOf((int)elapsedTimeInMilliSeconds));
                printWriter.close();
            } catch (IOException e) {
                System.out.println("File not found");
            }

        }

        try {
            String filePath = "output.csv";
            FileWriter fileWriter = new FileWriter(filePath, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println();
            printRow(printWriter, "Selection");
            printWriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        for (int size : sizes) {
            int[] randomArray = generateRandomArray(size);
            long startTime = System.nanoTime();
            selection(randomArray);
            long endTime = System.nanoTime();
            double elapsedTimeInMilliSeconds = (endTime - startTime) / 1e6;
            System.out.println("Selection Sorted array of size " + size + " Sorting took " + ((int) elapsedTimeInMilliSeconds) + " milliseconds");
            try {
                String filePath = "output.csv";
                FileWriter fileWriter = new FileWriter(filePath, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                printRow(printWriter, String.valueOf((int)elapsedTimeInMilliSeconds));
                printWriter.close();
            } catch (IOException e) {
                System.out.println("File not found");
            }

        }

        try {
            String filePath = "output.csv";
            FileWriter fileWriter = new FileWriter(filePath, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println();
            printRow(printWriter, "Insertion");
            printWriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        for (int size : sizes) {
            int[] randomArray = generateRandomArray(size);
            long startTime = System.nanoTime();
            insertionSort(randomArray);
            long endTime = System.nanoTime();
            double elapsedTimeInMilliSeconds = (endTime - startTime) / 1e6;
            System.out.println("Insertion Sorted array of size " + size + " Sorting took " + ((int) elapsedTimeInMilliSeconds) + " milliseconds");
            try {
                String filePath = "output.csv";
                FileWriter fileWriter = new FileWriter(filePath, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                printRow(printWriter, String.valueOf((int)elapsedTimeInMilliSeconds));
                printWriter.close();
            } catch (IOException e) {
                System.out.println("File not found");
            }

        }



    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1] > array[j]) {
                    //swap
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
    public static class MergeSort {
        private int[] temp, array;

        MergeSort(int[] array) {
            this.array = array;
            temp = new int[array.length];

            split(0, array.length - 1);
        }

        private void split(int low, int high) {
            //base case
            if (low == high) {
                return;
            }

            int mid = (low + high) / 2;

            split(low, mid);
            split(mid + 1, high);

            merge(low, mid, high);
        }

        private void merge(int low, int mid, int high) {
            int i = low, j = mid + 1, temppos = low;

            while (i <= mid && j <= high) {
                if (array[i] <= array[j]) {
                    temp[temppos++] = array[i++];
                } else {
                    temp[temppos++] = array[j++];
                }
            }

            while (i <= mid) {
                temp[temppos++] = array[i++];

            }
            while (j <= high) {
                temp[temppos++] = array[j++];

            }
            for (temppos = low; temppos <= high; temppos++) {
                array[temppos] = temp[temppos];
            }
        }
    }
    public static void selection(int[] array) {
        //outer loop tracks sorted elements
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;

            //loops through rest of array
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }

            }//swap
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;


        }
    }
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }

            //insert
            array[j + 1] = current;

        }
    }


    private static void printRow(PrintWriter writer, String time) {
        for (int i = 0; i < 1; i++) {
            writer.print(time);
            writer.print(",");
            }
        }

    }
