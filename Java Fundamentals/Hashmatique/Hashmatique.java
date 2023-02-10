import java.util.Set;
import java.util.HashMap;


public class Hashmatique {
    public static void main(String[] args) {



        HashMap<String, String> devon = new HashMap<String, String>();
        devon.put("Trust Issues", "Trust Issues Lyrics");
        devon.put("Warning Signs", "Warning Signs Lyrics");
        devon.put("Out Of Context", "Out Of Context Lyrics");
        devon.put("Belong 2 U", "Belong 2 U Lyrics");

        // Get single item from Hashmap
        String lyrics = devon.get("Warning Signs");
        System.out.println("\n");
        System.out.println("\n--- The lyrics packet you requested:\n " + lyrics);

        // get the keys by using the keySet method
        System.out.println("\n--- The Devon album tracks and lyrics are: ");
        Set<String> keys = devon.keySet();
        for(String key : keys) {
            System.out.println(key);
            System.out.println(devon.get(key));   
        }


    }
}