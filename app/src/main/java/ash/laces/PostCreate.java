package ash.laces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class PostCreate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_create);
    }

    EditText str = (EditText) findViewById(R.id.productDescription);
    String postDescription = str.getText().toString();
}
