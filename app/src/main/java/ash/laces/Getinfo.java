package ash.laces;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Getinfo
{
    String  userName2;
    String userName;
    String send = null;
    TextView vew;
    TextView description;
    TextView Followers;


    protected void onCreate(Bundle savedInstanceState)
    {

    }



// embedded class

    public class GetUserTest extends AsyncTask<String, String, String>
    {

        @Override
        protected String doInBackground(String...params)
        {
            userName = "Before try";
            Request.GetUserRequest request = new Request.GetUserRequest();
            request.setSecurityString("5QU1DCOD3");
            request.setUserId(1);
            request.setUserIdToGet(1);
            Gson gson = new Gson();

            String data = gson.toJson(request);

            try
            {
                URL urlObject = new URL("http://zmunson-001-site1.atempurl.com/api/User/GetUser");
                //http://zmunson-001-site1.atempurl.com/

                HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
                //userName = connection.toString();
                userName = "after the try";

                connection.setDoInput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(120000);
                connection.setReadTimeout(120000);
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);

                // userName = String.valueOf(connection.getResponseCode() == HttpURLConnection.HTTP_OK);


                OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());


                wr.write(data);
                wr.flush();
                wr.close();

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

                    String result = builder.toString();

                    Response.GetUserResponse response = gson.fromJson(result, Response.GetUserResponse.class);

                    if (response.getSuccess() == true)
                    {
                        Response.UserInfo user = response.getUser();

                    /*System.out.println("UserName: " + user.getUserName());
                    System.out.println("DisplayName: " + user.getDisplayName());
                    System.out.println("Description: " + user.getDescription());
                    System.out.println("Email: " + user.getEmail());
                    System.out.println("ProductCount: " + user.getProductCount());
                    System.out.println("FollowedUsers: " + user.getFollowedUsers());
                    System.out.println("FollowingUsers: " + user.getFollowingUsers());*/
                        //System.out.println("Join Date:" + user.getCreatedDate());

                        // userName = "in if statement";

                        userName2 = user.getDisplayName();
                    }
                }
                else
                {
                    userName = "error in after else";
                }
            }
            catch (Exception ex)
            {
                //userName = ex.getMessage();

                userName = "An error occurred while sending the request: in the catch ";
                return "in the catch";

            }
            return userName2;
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            userName = s;
            sendBack();
        }

        public void sendBack()
        {
            vew.setText(userName);
        }
    }



    // Get User description
    public class GetDescription extends AsyncTask<String, String, String>
    {

        @Override
        protected String doInBackground(String...params)
        {
            userName = "Before try";
            Request.GetUserRequest request = new Request.GetUserRequest();
            request.setSecurityString("5QU1DCOD3");
            request.setUserId(1);
            request.setUserIdToGet(1);
            Gson gson = new Gson();

            String data = gson.toJson(request);

            try
            {
                URL urlObject = new URL("http://zmunson-001-site1.atempurl.com/api/User/GetUser");
                //http://zmunson-001-site1.atempurl.com/

                HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
                //userName = connection.toString();
                userName = "after the try";

                connection.setDoInput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(120000);
                connection.setReadTimeout(120000);
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);

                // userName = String.valueOf(connection.getResponseCode() == HttpURLConnection.HTTP_OK);


                OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());


                wr.write(data);
                wr.flush();
                wr.close();

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

                    String result = builder.toString();

                    Response.GetUserResponse response = gson.fromJson(result, Response.GetUserResponse.class);

                    if (response.getSuccess() == true)
                    {
                        Response.UserInfo user = response.getUser();

                    /*System.out.println("UserName: " + user.getUserName());
                    System.out.println("DisplayName: " + user.getDisplayName());
                    System.out.println("Description: " + user.getDescription());
                    System.out.println("Email: " + user.getEmail());
                    System.out.println("ProductCount: " + user.getProductCount());
                    System.out.println("FollowedUsers: " + user.getFollowedUsers());
                    System.out.println("FollowingUsers: " + user.getFollowingUsers());*/
                        //System.out.println("Join Date:" + user.getCreatedDate());

                        // userName = "in if statement";

                        userName2 = user.getDescription();

                        //img = (ImageView) user.getProfilePicture();

                        //Uri path = Uri.parse("android.resource://com.segf4ult.test/" + R.drawable.img);

                        //Uri otherPath = Uri.parse("android.resource://com.segf4ult.test/drawable/");

                        //FileOutputStream fil = new FileOutputStream(y);
                        // FileOutputStream fil = new FileOutputStream("android.resource://com.segf4ult.test/values/");

                    }
                }
                else
                {
                    userName = "error in after else";
                    //userName = "An error occurred while sending the request: " + connection.getResponseMessage();
                }
            }
            catch (Exception ex)
            {
                //userName = ex.getMessage();

                userName = "An error occurred while sending the request: in the catch ";
                return "in the catch";

            }
            return userName2;
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            userName = s;
            sendBack();
        }

        public void sendBack()
        {
            description.setText(userName);
        }
    }

    public class GetFollowers extends AsyncTask<String, String, String>
    {

        @Override
        protected String doInBackground(String...params)
        {
            userName = "Before try";
            Request.GetUserRequest request = new Request.GetUserRequest();
            request.setSecurityString("5QU1DCOD3");
            request.setUserId(1);
            request.setUserIdToGet(1);
            Gson gson = new Gson();

            String data = gson.toJson(request);

            try
            {
                URL urlObject = new URL("http://zmunson-001-site1.atempurl.com/api/User/GetUser");
                //http://zmunson-001-site1.atempurl.com/

                HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
                //userName = connection.toString();
                userName = "after the try";

                connection.setDoInput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(120000);
                connection.setReadTimeout(120000);
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);

                // userName = String.valueOf(connection.getResponseCode() == HttpURLConnection.HTTP_OK);


                OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());


                wr.write(data);
                wr.flush();
                wr.close();

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

                    String result = builder.toString();

                    Response.GetUserResponse response = gson.fromJson(result, Response.GetUserResponse.class);

                    if (response.getSuccess() == true)
                    {
                        Response.UserInfo user = response.getUser();

                    /*System.out.println("UserName: " + user.getUserName());
                    System.out.println("DisplayName: " + user.getDisplayName());
                    System.out.println("Description: " + user.getDescription());
                    System.out.println("Email: " + user.getEmail());
                    System.out.println("ProductCount: " + user.getProductCount());
                    System.out.println("FollowedUsers: " + user.getFollowedUsers());
                    System.out.println("FollowingUsers: " + user.getFollowingUsers());*/
                        //System.out.println("Join Date:" + user.getCreatedDate());

                        userName2 = Integer.toString(user.getFollowedUsers());
                    }
                }
                else
                {
                    userName = "error in after else";
                    //userName = "An error occurred while sending the request: " + connection.getResponseMessage();
                }
            }
            catch (Exception ex)
            {
                //userName = ex.getMessage();

                userName = "An error occurred while sending the request: in the catch ";
                return "in the catch";

            }
            return userName2;
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            userName = s;
            sendBack();
        }

        public void sendBack()
        {
            Followers.setText(userName);
        }
    }

    public class GetFollowing extends AsyncTask<String, String, String>
    {

        @Override
        protected String doInBackground(String...params)
        {
            userName = "Before try";
            Request.GetUserRequest request = new Request.GetUserRequest();
            request.setSecurityString("5QU1DCOD3");
            request.setUserId(1);
            request.setUserIdToGet(1);
            Gson gson = new Gson();

            String data = gson.toJson(request);

            try
            {
                URL urlObject = new URL("http://zmunson-001-site1.atempurl.com/api/User/GetUser");
                //http://zmunson-001-site1.atempurl.com/

                HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
                //userName = connection.toString();
                userName = "after the try";

                connection.setDoInput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(120000);
                connection.setReadTimeout(120000);
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);

                // userName = String.valueOf(connection.getResponseCode() == HttpURLConnection.HTTP_OK);


                OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());


                wr.write(data);
                wr.flush();
                wr.close();

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

                    String result = builder.toString();

                    Response.GetUserResponse response = gson.fromJson(result, Response.GetUserResponse.class);

                    if (response.getSuccess() == true)
                    {
                        Response.UserInfo user = response.getUser();

                    /*System.out.println("UserName: " + user.getUserName());
                    System.out.println("DisplayName: " + user.getDisplayName());
                    System.out.println("Description: " + user.getDescription());
                    System.out.println("Email: " + user.getEmail());
                    System.out.println("ProductCount: " + user.getProductCount());
                    System.out.println("FollowedUsers: " + user.getFollowedUsers());
                    System.out.println("FollowingUsers: " + user.getFollowingUsers());*/
                        //System.out.println("Join Date:" + user.getCreatedDate());

                        userName2 = Integer.toString(user.getFollowingUsers());
                    }
                }
                else
                {
                    userName = "error in after else";
                    //userName = "An error occurred while sending the request: " + connection.getResponseMessage();
                }
            }
            catch (Exception ex)
            {
                //userName = ex.getMessage();

                userName = "An error occurred while sending the request: in the catch ";
                return "in the catch";

            }
            return userName2;
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            userName = s;
            sendBack();
        }

        public void sendBack()
        {
            Followers.setText(userName);
        }
    }
}

