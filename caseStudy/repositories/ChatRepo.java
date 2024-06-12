package caseStudy.repositories;

import java.io.*;

public class ChatRepo {

    private static final String URL_INFOR = "D:\\Module_2\\Module2\\src\\caseStudy\\data\\infor.csv";
    private static final String URL_CHAT = "caseStudy\\data\\chat.csv";

    public static void writeFile(String message, boolean append) {
        File file = new File(URL_INFOR);
        try (FileWriter fileWriter = new FileWriter(file, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(message);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.out.println("Lỗi ghi File!");
        }
    }
    public static void readFile() {
        File file = new File(URL_INFOR);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại.");
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi đọc file.");
            e.printStackTrace();
        }
    }

    public static void writeFileChat(String message, boolean append) {
        File file = new File(URL_CHAT);
        try (FileWriter fileWriter = new FileWriter(file, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(message);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.out.println("Lỗi ghi File!");
        }
    }
    public static void readFileChat() {
        File file = new File(URL_CHAT);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại.");
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi đọc file.");
            e.printStackTrace();
        }
    }

}
