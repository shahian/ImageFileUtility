package com.shahian;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Set the path to the directory containing your images
        String directoryPath = "G:\\هیئت پرورش اندام شهرری\\دعوت نامه مهمان ها جام قهرمانان 15 تیر 1402";
        // Get a reference to the directory
        File directory = new File(directoryPath);

        // Get an array of all the image files in the directory
        File[] imageFiles = directory.listFiles((dir, name) ->
                name.toLowerCase().endsWith(".jpg") ||
                        name.toLowerCase().endsWith(".jpeg") ||
                        name.toLowerCase().endsWith(".png") ||
                        name.toLowerCase().endsWith(".gif") ||
                        name.toLowerCase().endsWith(".bmp")
        );

        // Create a string to store the names of the image files
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (int i = 0; i < imageFiles.length; i++) {
            String fileNameWithoutExtension = imageFiles[i].getName().substring(0, imageFiles[i].getName().lastIndexOf('.'));
            sb.append(counter++).append(". ").append(fileNameWithoutExtension).append(System.lineSeparator());
        }

        // Write the names of the image files to a text file
        try (FileWriter writer = new FileWriter("image_names.txt")) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // If you want to save the names to an Excel file, you can use a library like Apache POI
        // Here's an example of how you can use Apache POI to create an Excel file and write the names to it:
        /*
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Image Names");
        int rowNum = 0;
        for (int i = 0; i < imageFiles.length; i++) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(i + 1);
            String fileNameWithoutExtension = imageFiles[i].getName().substring(0, imageFiles[i].getName().lastIndexOf('.'));
            row.createCell(1).setCellValue(fileNameWithoutExtension);
        }
        try (FileOutputStream outputStream = new FileOutputStream("image_names.xlsx")) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        // Print the count of the number of image files
        System.out.println("Number of image files: " + imageFiles.length);
    }
}
