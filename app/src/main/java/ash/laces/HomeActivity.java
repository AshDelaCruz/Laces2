package ash.laces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    ImageButton home, search, upload, activity, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
            case R.id.Notifications:
                startActivity(new Intent(this, NotificationsActivity.class));
                return true;
            case R.id.Profile:
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
            case R.id.Cart:
                startActivity(new Intent(this, ShoppingCartActivity.class));
                return true;
            case R.id.Upload:
                startActivity(new Intent(this, UploadActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
