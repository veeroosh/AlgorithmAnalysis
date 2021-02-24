import java.io.*;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;

public class Addition {
    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("C:\\Users\\User\\YandexDisk\\University\\8_semestr\\AlgorithmAnalisys\\AlgAnalysis\\src\\input.txt");
        FileWriter out = new FileWriter("C:\\Users\\User\\YandexDisk\\University\\8_semestr\\AlgorithmAnalisys\\AlgAnalysis\\src\\output.txt");

        int quantity = getQuantity(in);

        for (int i = 0; i < quantity; ++i) {
            ArrayList<Integer> arrayFirst = new ArrayList<>(),
                    arraySecond = new ArrayList<>();

            fillArray(arrayFirst, in);
            fillArray(arraySecond, in);
            add(arrayFirst, arraySecond, out);
        }
        out.close();
        in.close();
    }

    private static int getQuantity(FileReader in) throws IOException {
        int ch, quantity = 0, i = 0;

        while ((ch = in.read()) != 13)  // '\r'
            quantity += (ch - 48) * Math.pow(10, i++);

        return quantity;
    }

    private static void fillArray(ArrayList<Integer> array, FileReader in) throws IOException {
        int ch = in.read();

        if (ch == 10)
            ch = in.read();

        while (ch != -1 && ch != 13 && ch != 32) {
            array.add(ch - 48);
            ch = in.read();
        }

        Collections.reverse(array);
    }

    private static void add(ArrayList<Integer> arrayFirst, ArrayList<Integer> arraySecond, FileWriter out)
            throws IOException {
        int length = 0;

        ArrayList<Integer> array = new ArrayList<>();
        int previous = 0, current = 0;

        if (arrayFirst.size() > arraySecond.size()) {
            for (int i = 0; i < arrayFirst.size(); ++i) {
                if (i < arraySecond.size()) {
                    current = arrayFirst.get(i) + arraySecond.get(i) + previous;
                    array.add(current % 10);
                    previous = current / 10;
                } else {
                    current = arrayFirst.get(i) + previous;
                    array.add(current % 10);
                    previous = current / 10;
                }
            }
        }
        else {
            for (int i = 0; i < arraySecond.size(); ++i) {
                if (i < arrayFirst.size()) {
                    current = arrayFirst.get(i) + arraySecond.get(i) + previous;
                    array.add(current % 10);
                    previous = current / 10;
                } else {
                    current = arraySecond.get(i) + previous;
                    array.add(current % 10);
                    previous = current / 10;
                }
            }
        }

        if (previous != 0)
            array.add(previous);

        for (int i = array.size() - 1; i >= 0; --i)
            out.write(array.get(i).intValue()+48);

        out.write("\n");
    }
}