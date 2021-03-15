import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
import org.apache.commons.io.FileUtils;

public class Contains {
    public static TreeSet<Integer> tree;

    public static void main(String[] args) throws IOException {
        FileWriter finalOut = new FileWriter("C:\\Users\\dsayf\\YandexDisk\\University\\8_semestr\\" +
                "AlgorithmAnalisys\\AlgAnalysis\\src\\output.txt");

        for (int i = 0; i < 7; ++i) {
            tree = new TreeSet<>();

            FileWriter out = new FileWriter("C:\\Users\\dsayf\\YandexDisk\\University\\8_semestr\\" +
                    "AlgorithmAnalisys\\AlgAnalysis\\src\\out.txt");

            Scanner in = new Scanner(new File("C:\\Users\\dsayf\\YandexDisk\\University\\8_semestr\\" +
                    "AlgorithmAnalisys\\AlgAnalysis\\src\\test\\" + (i+1) + ".in"));

            int size = in.nextInt();
            for (int j = 0; j < size; ++j) {
                if (tree.add(in.nextInt()))
                    out.write("-\n");
                else
                    out.write("+\n");
            }

            out.close();

            File testOut = new File("C:\\Users\\dsayf\\YandexDisk\\University\\8_semestr\\" +
                    "AlgorithmAnalisys\\AlgAnalysis\\src\\test\\" + (i+1) + ".contains.out");

            File outCompare = new File("C:\\Users\\dsayf\\YandexDisk\\University\\8_semestr\\" +
                    "AlgorithmAnalisys\\AlgAnalysis\\src\\out.txt");

            if (FileUtils.contentEquals(testOut, outCompare))
                finalOut.write((i+1) + ". Correct\n");
            else
                finalOut.write((i+1) + ". Incorrect\n");

            in.close();
        }

        finalOut.close();
    }
}
