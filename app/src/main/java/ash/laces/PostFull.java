package ash.laces;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;


/**
 * Created by Tito on 3/6/2017.
 */

public class PostFull extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        posting();
    }


    public void posting()
    {
        ImageView g = (ImageView) findViewById(R.id.pic);
        Intent getMessage = getIntent();
        g.setImageResource(Integer.parseInt(getMessage.getExtras().getString("callingActivity")));
    }

}
