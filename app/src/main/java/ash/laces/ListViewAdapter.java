package ash.laces;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private List<Response.ProductInfo> productNamesList = null;
    private ArrayList<Response.ProductInfo> productArraylist;

    public ListViewAdapter(Context context, List<Response.ProductInfo> namesList) {
        mContext = context;
        productNamesList = namesList;
        inflater = LayoutInflater.from(mContext);
        productArraylist = new ArrayList<Response.ProductInfo>();
        productArraylist.addAll(productNamesList);
    }

    public class ViewHolder {
        TextView product_name;
        TextView product_sizenumber;
        TextView product_pricenumber;
        ImageView productImage;
    }

    @Override
    public int getCount() {
        return productNamesList.size();
    }

    @Override
    public Response.ProductInfo getItem(int position) {
        return productNamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_items, null);
            // Locate the TextViews in listview_item.xml
            holder.productImage = (ImageView) view.findViewById(R.id.productImage);
            holder.product_name = (TextView) view.findViewById(R.id.product_name);
            holder.product_sizenumber = (TextView) view.findViewById(R.id.product_sizenumber);
            holder.product_pricenumber = (TextView) view.findViewById(R.id.product_pricenumber);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.product_name.setText(productNamesList.get(position).getName());
        holder.product_sizenumber.setText(productNamesList.get(position).getSize());
        holder.product_pricenumber.setText(String.valueOf(productNamesList.get(position).getAskingPrice()));
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        productNamesList.clear();
        if (charText.length() == 0) {
            productNamesList.addAll(productArraylist);
        } else {
            for (Response.ProductInfo wp : productArraylist) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    productNamesList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}