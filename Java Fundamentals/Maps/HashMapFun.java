import java.util.Set;
import java.util.HashMap;


public class HashMapFun {
    public static void main(String[] args) {
        HashMap<String, String> userMap = new HashMap<String, String>();
        userMap.put("nninja@codingdojo.com", "Nancy Ninja");
        userMap.put("ssamurai@codingdojo.com", "Sam Samurai");
        userMap.put("wwizard@codingdojo.com", "Walter Wizard");

        // Get single item from Hashmap
        String name = userMap.get("nninja@codingdojo.com");
        System.out.println("The full name is: " + name);

        // get the keys by using the keySet method
        Set<String> keys = userMap.keySet();
        for(String key : keys) {
            System.out.println(key);
            System.out.println(userMap.get(key));   
        }

        
        HashMap<String, String> countryCapitals = new HashMap<String, String>();
        countryCapitals.put("Oman","Muscat");
        countryCapitals.put("China","Beijing");
        countryCapitals.put("Fiji","Suva");
        countryCapitals.put("Japan","Tokyo");
        countryCapitals.put("Mexico","Mexico City");

        Set<String> CountryKeys = countryCapitals.keySet();
        for(String CountryKey : CountryKeys) {
            System.out.println(CountryKey);
            System.out.println(countryCapitals.get(CountryKey)); 
        }

        
        String capital = countryCapitals.get("Japan");
        System.out.printf("The capital is: %s " , capital);



    }
}