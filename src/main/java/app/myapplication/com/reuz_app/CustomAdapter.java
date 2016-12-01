package app.myapplication.com.reuz_app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<CategoryItem> categoryItems;

    public CustomAdapter(Context context, List<CategoryItem> categoryItems) {
        this.context = context;
        this.categoryItems = categoryItems;
    }

    @Override
    public int getCount() {
        return categoryItems.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return categoryItems.indexOf(getItem(position));
    }

    /* private view holder class */
    private class ViewHolder {
        ImageView imageView2;
        TextView category_name;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        view=convertView;
        ViewHolder holder;
        CategoryItem row_pos=null;


        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();

            holder.category_name = (TextView) view
                    .findViewById(R.id.category_name);
            holder.imageView2 = (ImageView) view
                    .findViewById(R.id.imageView2);




            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }
        row_pos = categoryItems.get(position);
        holder.imageView2.setImageResource(row_pos.getImageId());
        holder.category_name.setText(row_pos.getCategory_name());

        return view;
    }
}

