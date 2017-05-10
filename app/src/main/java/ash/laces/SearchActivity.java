package ash.laces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    int[] productIdList;
    ArrayList<Response.ProductInfo> productNamesArraylist = new ArrayList<Response.ProductInfo>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button options = (Button) findViewById(R.id.options_button);
        options.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(SearchActivity.this, Pop.class));
            }
        });

        // Generate sample data
        Date current = new Date();
        Response.ProductInfo temp1 = new Response.ProductInfo();
        temp1.setName("Puma");
        temp1.setAskingPrice(14);
        temp1.setSize("6 Women's");
        productNamesArraylist.add(temp1);

        Response.ProductInfo temp2 = new Response.ProductInfo();
        temp2.setName("Nike");
        temp2.setAskingPrice(5);
        temp2.setSize("10 Men's");
        productNamesArraylist.add(temp2);

        Response.ProductInfo temp3 = new Response.ProductInfo();
        temp3.setName("Yeezys");
        temp3.setAskingPrice(26);
        temp3.setSize("9 Women's");
        productNamesArraylist.add(temp3);

        Response.ProductInfo temp4 = new Response.ProductInfo();
        temp4.setName("Jordan");
        temp4.setAskingPrice(78);
        temp4.setSize("11 Men's");
        productNamesArraylist.add(temp4);

        Response.ProductInfo temp5 = new Response.ProductInfo();
        temp5.setName("Adidas");
        temp5.setAskingPrice(125);
        temp5.setSize("8 Men's");
        productNamesArraylist.add(temp5);

        Response.ProductInfo temp6 = new Response.ProductInfo();
        temp6.setName("Bass");
        temp6.setAskingPrice(45);
        temp6.setSize("7 Women's");
        productNamesArraylist.add(temp6);

        Response.ProductInfo temp7 = new Response.ProductInfo();
        temp7.setName("Call it Spring");
        temp7.setAskingPrice(23);
        temp7.setSize("10 Women's");
        productNamesArraylist.add(temp7);


        try {
            if(getProductIds("") != null) {
                productIdList = getProductIds("a");
                for (int i = 0; i < productIdList.length; i++) {
                    Response.ProductInfo temp = showProduct(productIdList[i]);
                    productNamesArraylist.add(temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, productNamesArraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
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

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }

    public int[] getProductIds(String query) throws IOException {

        Request.SearchRequest request = new Request.SearchRequest();
        request.setSecurityString("5QU1DCOD3");
        request.setUserId(1);
        String[] strArray = {query};
        request.setKeywords(strArray);


        RestHelper helper = new RestHelper() {

            protected Object doInBackground(Object[] params) {
                return null;
            }
        };

        Response.SearchResponse response = helper.<Request.SearchRequest, Response.SearchResponse>ProcessRequest(request, Response.SearchResponse.class, "http://zmunson-001-site1.atempurl.com/api/Search/Search");
        // porduct/getdetailedproduct
        // product/getshortproduct image, name, user that uploaded

        if(response != null){

            int[] productIds = response.getProducts();
            if(productIds.length > 0) {
                return productIds;
            }else{
                return null;
            }
        }else{

            return null;
        }

    }

    public Response.ProductInfo showProduct(int productId) throws IOException {
        Request.ProductRequest request1 = new Request.ProductRequest();
        request1.setSecurityString("5QU1DCOD3");
        request1.setUserId(2);
        request1.setProductId(productId);

        RestHelper helper = new RestHelper() {
            protected Object doInBackground(Object[] params) {
                return null;
            }
        };

        Response.GetDetailedProductResponse response1 = helper.<Request.ProductRequest, Response.GetDetailedProductResponse>ProcessRequest(request1, Response.GetDetailedProductResponse.class, "http://zmunson-001-site1.atempurl.com/api/Product/GetDetailedProduct");

        if(response1 != null){
            Response.ProductInfo names = response1.getProduct();
            return names;
        }else{
            return null;
        }
    }

}