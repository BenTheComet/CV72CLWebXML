import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONWriteCV72CL {

    public static void main(String[] args) {

        try (FileReader reader = new FileReader("orarendCV72CL.json");
             FileWriter writer = new FileWriter("output.txt")) {

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            JSONObject root = (JSONObject) jsonObject.get("CV72CL_orarend");
            JSONArray orarend = (JSONArray) root.get("ora");

            String cim = "CV72CL Órarend 2026 tavasz\n\n";

            System.out.print(cim);
            writer.write(cim);

            for (int i = 0; i < orarend.size(); i++) {

                JSONObject ora = (JSONObject) orarend.get(i);
                JSONObject time = (JSONObject) ora.get("idopont");

                String blokk =
                        "Tárgy: " + ora.get("targy") + "\n" +
                        "Időpont: " + time.get("nap") + " " + time.get("tol") + " - " + time.get("ig") + "\n" +
                        "Helyszín: " + ora.get("helyszin") + "\n" +
                        "Oktató: " + ora.get("oktato") + "\n" +
                        "Szak: " + ora.get("szak") + "\n\n";

                System.out.print(blokk);

                writer.write(blokk);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}