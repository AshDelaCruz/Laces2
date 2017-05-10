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

public class NotificationsActivity extends AppCompatActivity {
    ImageButton home, search, upload, activity, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        /*addListenerOnHomeButton();
        addListenerOnSearchButton();
        addListenerOnUploadButton();
        addListenerOnActivityButton();
        addListenerOnProfileButton();*/
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

    /*
    public void addListenerOnHomeButton() {
        home = (ImageButton) findViewById(R.id.homeButtonGray);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(NotificationsActivity.this, HomeActivity.class);
                NotificationsActivity.this.startActivity(myIntent);
                Toast.makeText(NotificationsActivity.this, "Home button is clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addListenerOnSearchButton() {
        search = (ImageButton) findViewById(R.id.searchButtonGray);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(NotificationsActivity.this, SearchActivity.class);
                NotificationsActivity.this.startActivity(myIntent);
                Toast.makeText(NotificationsActivity.this, "Search button is clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addListenerOnUploadButton() {
        upload = (ImageButton) findViewById(R.id.uploadButtonGray);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(NotificationsActivity.this, "Upload button is clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addListenerOnActivityButton() {
        activity = (ImageButton) findViewById(R.id.activityButtonGray);
        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(NotificationsActivity.this, NotificationsActivity.class);
                NotificationsActivity.this.startActivity(myIntent);
                Toast.makeText(NotificationsActivity.this, "Activity button is clicked!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void addListenerOnProfileButton() {
        profile = (ImageButton) findViewById(R.id.profileButtonGray);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(NotificationsActivity.this, ProfileActivity.class);
                NotificationsActivity.this.startActivity(myIntent);
                Toast.makeText(NotificationsActivity.this, "Profile button is clicked!", Toast.LENGTH_SHORT).show();

            }
        });
    }*/
}
