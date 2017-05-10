package ash.laces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {
    LoginButton loginButton;
    TextView textView;
    CallbackManager callbackManager;
    Intent logIntent, homeIntent;
    static boolean loggedIn;
    static String unameStr ="";

    public void onCreate(Bundle savedInstanceState) {
        loggedIn = false;
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, FBLogin.class));

        //homeIntent = new Intent(this, HomeActivity.class);
        //startActivity(homeIntent);
        //loginButton = (LoginButton)findViewById(R.id.fb_login_bn);
        //textView = (TextView)findViewById(R.id.greeting);
        //callbackManager = CallbackManager.Factory.create();

        /*loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                textView.setText("Login Success \n" +
                        loginResult.getAccessToken().getUserId()+
                        "\n"+loginResult.getAccessToken().getToken());

            }


            @Override
            public void onCancel() {

                textView.setText("Login Cancelled");

            }

            @Override
            public void onError(FacebookException error) {

            }
        });*/
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
            case R.id.Profile:
                startActivity(new Intent(this, ProfileActivity.class));
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
}
