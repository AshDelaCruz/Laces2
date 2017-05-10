package ash.laces;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Tito on 3/14/2017.
 */

public class HdoubleTP
{
    public void send(String data1)
    {
        String data;

        // The JSON string would best be made using either javax.json.JsonObject or org.json.JSONObject, but this class is just for testing HttpUrlConnection.
        data = "{\"SecurityString\":\"5QU1DCOD3\",\"UserId\":\"1\",\"UserIdToGet\":\"2\"}";

        if(data1 != null){data = data1;}

        try
        {
            URL urlObject = new URL("http://localhost:18074/User/GetUser/");

            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

            connection.setDoInput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(120000);
            connection.setReadTimeout(120000);
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());

            wr.write(data);
            wr.flush();
            wr.close();

            String result = "";

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                InputStream inputStream = connection.getInputStream();

                BufferedReader reader = null;
                String inputLine;
                StringBuilder builder = new StringBuilder();

                reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));

                while ((inputLine = reader.readLine()) != null)
                {
                    builder.append(inputLine);
                }

                if (reader != null)
                {
                    reader.close();
                }

                result = builder.toString();
            }
            else
            {
                result = "An error occurred while sending the request: " + connection.getResponseMessage();
            }

            System.out.println(result);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void recieve()
    {

    }

}