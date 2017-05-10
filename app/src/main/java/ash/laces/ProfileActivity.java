package ash.laces;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

public class ProfileActivity extends AppCompatActivity
{
    String userName2;
    String userName;
    String send = null;
    final ImageAdapter t = new ImageAdapter(this);
    TextView vew;
    TextView description;
    TextView Followers;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        new GetUserTest().execute("");
        new GetDescription().execute("");
        new GetFollowers().execute("");


        getSupportActionBar().hide();

        vew = (TextView) findViewById(R.id.txtv);
        description = (TextView) findViewById(R.id.textView3);
        Followers = (TextView) findViewById(R.id.textView11);


        /*gridview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                t.getImage(position);
                send = Integer.toString(t.getImage(position));
                activityCall();
            }
        });*/




    /*   btn.setOnClickListener(new View.OnClickListener()
       {
           public void onClick(View view)
           {
              //Toast.makeText(getApplicationContext(), tst.userName, Toast.LENGTH_SHORT).show();

              vew.setText(userName);
           }

       }); */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Search:
                startActivity(new Intent(this, SearchActivity.class));
                return true;
            case R.id.Home:
                startActivity(new Intent(this, HomeActivity.class));
                return true;
            case R.id.Notifications:
                startActivity(new Intent(this, NotificationsActivity.class));
                return true;
            case R.id.Upload:
                startActivity(new Intent(this, UploadActivity.class));
                return true;
            case R.id.Cart:
                startActivity(new Intent(this, ShoppingCartActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void activityCall()
    {
        Intent t = new Intent(this, PostFull.class);
        t.putExtra("callingActivity", send);
        startActivity(t);
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
                return "Zac Munson";

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
                return "My name is Zac and I love shoes!";

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
                return "3";

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

