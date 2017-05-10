package ash.laces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

/**
 * Created by Ash on 4/27/17.
 */

public class CreateAccountActivity extends AppCompatActivity {
    LoginButton loginButton;
    TextView textView;
    CallbackManager callbackManager;
    Intent logIntent, homeIntent;
    static boolean loggedIn;
    TextView unameView;

    public void onCreate(Bundle savedInstanceState) {
        loggedIn = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_username);

        unameView = (TextView) findViewById(R.id.uname);
        MainActivity.unameStr = unameView.getText().toString();


        Button enter = (Button) findViewById(R.id.uname_enter_button);
        enter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(MainActivity.unameStr != "")
                    startActivity(new Intent(CreateAccountActivity.this, HomeActivity.class));
            }
        });
    }

    public void checkIfRegistered() {
        Button enter = (Button) findViewById(R.id.uname_enter_button);
        enter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateAccountActivity.this, HomeActivity.class));
            }
        });
    }

}
