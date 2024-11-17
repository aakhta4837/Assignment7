import java.io.*;
import java.util.*;

public class BubbleSort {

    public static int[] createRandomArray(int arrayLength) {
        Random rand = new Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = rand.nextInt(101); // random number between 0 and 100
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int number : array) {
                writer.write(Integer.toString(number));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static int[] readFileToArray(String filename) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        // Convert list to array
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static void bubbleSort(int[] array) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Main method 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

                System.out.print("Enter the length of the array: ");
                int length = scanner.nextInt();
                System.out.print("Enter the filename to store the array: ");
                String outputFilename = scanner.next();
                int[] randomArray = createRandomArray(length);
                writeArrayToFile(randomArray, outputFilename);
                System.out.println("Random array has been written to " + outputFilename);
                

                System.out.print("Enter the filename to read the array from: ");
                String inputFilename = scanner.next();
                System.out.print("Enter the filename to store the sorted array: ");
                String sortedFilename = scanner.next();
                int[] array = readFileToArray(inputFilename);
                bubbleSort(array);
                writeArrayToFile(array, sortedFilename);
                System.out.println("Sorted array has been written to " + sortedFilename);

        scanner.close();
    }
}
