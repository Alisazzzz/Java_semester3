package someClasses;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws Exception {

        Path path = Path.of("src", "someClasses/inFile.txt");
        writeFile(readFile(path));

    }

    private static void writeFile(int[] numbers) throws Exception {

        try (PrintStream outFile = new PrintStream("src/outFile.txt", StandardCharsets.UTF_8)) {
            String[] strings = aligning(numbers);
            for (String i: strings) outFile.println(i);
        }
    }

    private static int[] readFile(Path path) throws Exception {
        try (Scanner inFile = new Scanner(path, StandardCharsets.UTF_8)) {
            int x = inFile.nextInt();
            int[] numbers = new int[x];
            int i = 0;
            while (inFile.hasNextInt()) {
                numbers[i] = inFile.nextInt();
                i += 1;
            }
            return numbers;
        }
    }

    private static String[] aligning(int[] numbers) {
        int max = 0;
        String[] strings = new String[numbers.length];
        for (int i: numbers)
            if (Integer.toString(i).length() > max)
                max = Integer.toString(i).length();
        for (int i = 0; i < numbers.length; i++) {
            if (Integer.toString(numbers[i]).length() < max) {
                String res = "";
                for (int j = 0; j < max - Integer.toString(numbers[i]).length(); j++)
                    res = res.concat(" ");
                strings[i] = res.concat(Integer.toString(numbers[i]));
            } else {
                strings[i] = Integer.toString(numbers[i]);
            }
        }
        return strings;
    }
}
