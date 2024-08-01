package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) {

        String path = "/home/samuel-raymundo/Documents/Programming/Codes/Java/Curso-Java-Basic/Map/src/in.txt";
        Map<String, Integer>candidateMap = new TreeMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                int votes = Integer.parseInt(fields[1]);

                if (candidateMap.containsKey(name)) {
                    int votesSoFar = candidateMap.get(name);
                    candidateMap.put(name,votes + votesSoFar);
                }
                else {
                    candidateMap.put(name,votes);
                }
                line = br.readLine();
            }

            for (String key : candidateMap.keySet()) {
                System.out.println(key + ":" + candidateMap.get(key));
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
