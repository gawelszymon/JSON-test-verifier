package com.example.test_projekt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.apache.logging.log4j.*;


public class JsonPolicyVerifierLogs {

    private static Logger policyLogger = LogManager.getLogger(JsonPolicyVerifierLogs.class.getName());

    public static boolean verifyPolicy() {

        System.out.println("Enter JSON file path: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        try {
            String jsonChecking = path.substring(path.length() - 5);

            if (!jsonChecking.equals(".json")) {
                System.out.println("\nOnly a JSON file can be loaded\n");
                policyLogger.error("Not JSON file extension error\n");

                return true;
            }

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("\nWrong Data\n");
            policyLogger.error("StringIndexOutOfBoundsException\n");
            return true;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            StringBuilder jsonFile = new StringBuilder();

            System.out.print("\n");

            while ((line = reader.readLine()) != null) {
                jsonFile.append(line);
                System.out.println(line);
            }

            System.out.print("\n");
            policyLogger.info("File loaded successfully\n");

            String jsonToString = jsonFile.toString().trim();
            int resourceJsonIndex = jsonToString.indexOf("\"Resource\":");

            /*
            System.out.println(resourceJsonIndex);
            System.out.println(jsonToString);
            System.out.println(jsonToString.indexOf("{"));
            */

            if (resourceJsonIndex != -1) {
                int beginning = jsonToString.indexOf("\"", resourceJsonIndex + 11) + 1;
                int end = jsonToString.indexOf("\"", beginning);
                String middle = jsonToString.substring(beginning, end);

                /*
                System.out.println("end: " + end);
                System.out.println("beginning: " + beginning);
                System.out.println(end - beginning);
                */

                if ((end - beginning == 1) && middle.equals("*")) {
                    return false;
                } else {
                    return true;
                }
            }

            reader.close();

            return true;

        } catch (FileNotFoundException e) {
            System.out.println("\nSuch file cannot be found\n");
            policyLogger.error("FileNotFoundException\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("\nWrong Data\n");
            policyLogger.error("\nStringIndexOutOfBoundsException");
            return true;
        }
    }

    public static void main(String[] args) {
        boolean validation = verifyPolicy();
        System.out.println("\n\nInput JSON return: " + validation + "\n\n\n");
        policyLogger.info("File verified successfully");
    }

}

