package gui;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    public static List<String> readData(File file) {
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))) {
            List<String> list = new ArrayList<>();

            while(scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }

            return list;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
