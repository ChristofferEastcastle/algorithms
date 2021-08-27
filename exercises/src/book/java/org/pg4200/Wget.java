package org.pg4200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Wget {
    public static void main(String[] args) {
        String urlString = args[0];
        String data = readData(urlString);
        System.out.println(data);
    }

    private static String readData(String urlString)  {
        StringBuilder content = new StringBuilder();
        try {

            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = reader.readLine();

            while (line != null) {
                content.append(line).append("\n");
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return content.toString();
    }
}