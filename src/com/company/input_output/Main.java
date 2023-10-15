package com.company.input_output;

/** файловый менеджер (в виде консольного приложения).
 На вход программе указывается абсолютный путь к файлу и ключ операции (с параметрами),
 которую необходимо выполнить над файлом.
 Должны быть реализованы операции создания файла, удаления, чтения, записи в файл.
 Учесть пограничные случаи и не забыть про удобную обработку исключений с выводом валидаций пользователю в консоль.

 Пример вызова программы:
 >>c:\\testdata\myfile.txt -create (создаст пустой файл)
 или
 >>c:\\testdata\myfile.txt -write "blablabla" (запишет в файл строку blablabla
 */

import java.io.*;
import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("------------------------------------\n" +
                "|Welcome to file-managment utility!|\n" +
                "|Enter \'help\' to see all commands|\n" +
                "------------------------------------");

        File file = null;
        String inputString = null;

        do {
            inputString = in.nextLine();

            if (inputString.equals("help")) {
                System.out.println("Input format: absolute_path_to_the_file -command\n" +
                        "commands: create, delete, write \"text_to_write\", read\n" +
                        "Enter \'exit\' to terminate the program:)");
                inputString = in.nextLine();
            }
            if (inputString.equals("exit"))
                break;

            String[] splitedInput = inputString.split(" ", 3);
            if (splitedInput.length < 2) {
                System.out.print("Enter path and command:");
                inputString = in.nextLine();
                splitedInput = inputString.split(" ", 3);
            }

            String path = splitedInput[0];
            String key = splitedInput[1];
            String textToWrite = "";

            if (splitedInput.length == 3)
                textToWrite = splitedInput[2].substring(1, splitedInput[2].length() - 1);

            switch (key) {
                case "-create":
                    try {
                        file = new File(path);
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "-delete":
                    file = new File(path);

                    if (file.exists()) file.delete();
                    else System.out.println("File doesn't exist on this path.");

                    break;
                case "-write":
                    try (FileWriter fileWriter = new FileWriter(path, true)) {
                        fileWriter.write(textToWrite);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "-read":
                    try (FileReader fileReader = new FileReader(path)) {
                        int c;
                        while ((c = fileReader.read()) != -1) {
                            System.out.print((char) c);
                        }
                        System.out.println();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Incorrect key syntax.\n" +
                            "|Enter \'help\' to see all commands|\n" +
                            "------------------------------------");
            }
        } while (true);

        System.out.println("Completion...");
        in.close();
    }

}
