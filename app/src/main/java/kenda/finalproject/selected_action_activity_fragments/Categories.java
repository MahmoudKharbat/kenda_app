package kenda.finalproject.selected_action_activity_fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;

import kenda.finalproject.Data_Center.Category;
import kenda.finalproject.R;
import kenda.finalproject.SelectedCategoryActivity;


public class Categories extends Fragment {

    private View view;
    private GridView gridView;
    private ArrayList<Category> categories;
    private CategoryAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_categories, container, false);

        categories = new ArrayList<>();

        categories.add(new Category(R.drawable.men_fashion, "Men", 0, R.color.men_background));
        categories.add(new Category(R.drawable.women_fashion, "Women", 7, R.color.women_background));
        categories.add(new Category(R.drawable.babies_fashion, "Babies", 0, R.color.babies_background));
        categories.add(new Category(R.drawable.kitchen, "Kitchen", 6, R.color.kitchen_background));
        categories.add(new Category(R.drawable.bathroom, "Bathroom", 0, R.color.bathroom_background));
        categories.add(new Category(R.drawable.decoration, "Decoration", 4, R.color.decoration_background));
        categories.add(new Category(R.drawable.garden, "Garden", 3, R.color.garden_background));
        categories.add(new Category(R.drawable.other, "Other", 5, R.color.other_background));

        gridView = view.findViewById(R.id.categories_grid_view);
        adapter = new CategoryAdapter(getActivity(), categories);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(categories.get(position).getItemsNum() == 0)
                    Toast.makeText(getContext(), "Sorry there is no items in this category yet", Toast.LENGTH_SHORT).show();
                else{
                    Intent intent = new Intent(view.getContext(), SelectedCategoryActivity.class);
                    Bundle categoryInfo = new Bundle();
                    categoryInfo.putString("category_name", categories.get(position).getName());
                    intent.putExtra("category_info", categoryInfo);
                    view.getContext().startActivity(intent);
                }
            }
        });

        return view;
    }
}