import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class pokeAPITesting {

    public static void main(String[] args) {
        // Create OkHttpClient instance
        OkHttpClient client = new OkHttpClient();
        
        System.out.println("Seeing if pushing works");

        // Pokémon API URL (e.g., Pikachu)
        String url = "https://pokeapi.co/api/v2/pokemon/pikachu";

        // Create the request
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Send the request and handle the response
        try (Response response = client.newCall(request).execute()) {
            // Print out the response body
            System.out.println(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
