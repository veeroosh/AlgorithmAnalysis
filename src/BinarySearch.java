import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BinarySearch {

    private static int array[];

    private static int arraySize;
    private static int aimSize;

    private static Scanner in;

    static {
        try {
            in = new Scanner(new File("C:\\Users\\dsayf\\YandexDisk\\University\\8_semestr\\" +
                    "AlgorithmAnalisys\\AlgAnalysis\\src\\input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        arraySize = in.nextInt();
        array = new int[arraySize];

        for (int i = 0; i < arraySize; ++i)
            array[i] = in.nextInt();

        aimSize = in.nextInt();

        search();
    }

    private static void search() throws IOException {
        FileWriter out = new FileWriter("C:\\Users\\dsayf\\YandexDisk\\University\\8_semestr\\" +
                "AlgorithmAnalisys\\AlgAnalysis\\src\\output.txt");

        for (int i = 0; i < aimSize; ++i) {
            int index = binarySearch(in.nextInt());
            out.write(index + "\n");
        }

        out.close();
    }

    private static int binarySearch(int key) {
        int left = 0, right = arraySize - 1,
                middle, index = -1;

        while (left <= right) {
            middle = (left + right) / 2;

            if (array[middle] == key)
                return middle;

            if (array[middle] > key)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return index;
    }
}
