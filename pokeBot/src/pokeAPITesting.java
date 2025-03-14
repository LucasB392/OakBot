import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class pokeAPITesting {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        String url = "https://pokeapi.co/api/v2/pokemon/snorlax"; // URL to Pikachu

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            // Parse the response body into JSON
            String responseBody = response.body().string();
            JSONObject jsonObject = new JSONObject(responseBody);

            // Extract data (e.g., Pikachu's name, height, and weight)
            String name = jsonObject.getString("name");
            int height = jsonObject.getInt("height");
            int weight = jsonObject.getInt("weight");
            JSONArray abilitiesArray = jsonObject.getJSONArray("abilities");
            System.out.println("Abilities: ");

            // Loop through the abilities and extract ability names
            for (int i = 0; i < abilitiesArray.length(); i++) {
                JSONObject abilityObj = abilitiesArray.getJSONObject(i);
                JSONObject abilityDetails = abilityObj.getJSONObject("ability");
                String abilityName = abilityDetails.getString("name");
                boolean isHidden = abilityObj.getBoolean("is_hidden");
                int slot = abilityObj.getInt("slot");
                
             // Print ability name, hidden status, and slot
                System.out.println("- " + abilityName + (isHidden ? " (Hidden)" : "") + " [Slot: " + slot + "]");
            }
            
            

            System.out.println("Name: " + name);
            System.out.println("Height: " + height);
            System.out.println("Weight: " + weight);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
