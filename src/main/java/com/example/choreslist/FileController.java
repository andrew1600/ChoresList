package com.example.choreslist;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class FileController {
    private static Scanner scanner;
    private static FileWriter filewriter;

    public static ArrayList<String> collectTask(String name) throws FileNotFoundException {
        ArrayList<String> tasks = new ArrayList<>();
        File file = new File(name);
        scanner = new Scanner(file);

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            tasks.add(line);
        }

        return tasks;
    }

    public static void Addtask(String name, String task) throws FileNotFoundException {
        File file = new File(name);
        try(FileWriter filewriter = new FileWriter(file, true)) {
            filewriter.write("\n" + task);

        }catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    public static void Removetask(String name, String task) throws FileNotFoundException {
        File file = new File(name);
        try {
            String content = new String(Files.readAllBytes(Paths.get(name)));


            content = content.replace(task + "\n", "");
            content = content.replace(task, "");


            Files.write(Paths.get(name), content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
