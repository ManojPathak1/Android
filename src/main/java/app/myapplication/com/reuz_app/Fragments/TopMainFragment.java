package app.myapplication.com.reuz_app.Fragments;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;



import java.util.ArrayList;
import java.util.List;

import app.myapplication.com.reuz_app.Activities.SubmitAdActivity;
import app.myapplication.com.reuz_app.CategoryItem;
import app.myapplication.com.reuz_app.CustomAdapter;
import app.myapplication.com.reuz_app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopMainFragment extends Fragment {
private ListView categoryList;
private Button submitButton;
private View view;
private Context context;

    String[] category_names;
    TypedArray images;


    List<CategoryItem> categoryItems;
    public TopMainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // keep the fragment and all its data across screen rotation
        setRetainInstance(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_top_main, container, false);
        this.mapping();
        this.addItem();
        this.listeners();
        return view;
    }

    public void mapping()
    {
        submitButton=(Button)view.findViewById(R.id.button);
        categoryList=(ListView)view.findViewById(R.id.listView);
    }
    public void addItem()
    {

        categoryItems = new ArrayList<CategoryItem>();

        category_names = getResources().getStringArray(R.array.category_names);

        images = getResources().obtainTypedArray(R.array.category_pics);

        for (int i = 0; i < category_names.length; i++) {
            CategoryItem item = new CategoryItem(category_names[i],
                    images.getResourceId(i, -1));
            categoryItems.add(item);
        }
        CustomAdapter adapter = new CustomAdapter(getActivity(),categoryItems);
        categoryList.setAdapter(adapter);
    }


    public void listeners()
    {

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), SubmitAdActivity.class);
                startActivity(intent);

            }
        });

        categoryList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}