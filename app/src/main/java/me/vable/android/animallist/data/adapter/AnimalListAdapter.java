package me.vable.android.animallist.data.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import me.vable.android.animallist.R;
import me.vable.android.animallist.data.Animal;

/**
 * Created by Varavut on 9/28/2014.
 */
public class AnimalListAdapter extends BaseAdapter {

    List<Animal> animalList;
    Context context;

    public AnimalListAdapter(Context context,List<Animal> animalList){
        this.context = context;
        this.animalList = animalList;
    }

    @Override
    public int getCount() {
        return animalList==null?0:animalList.size();
    }

    @Override
    public Animal getItem(int i) {
        return animalList==null?null:animalList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,null);
        Animal animal = getItem(i);
        TextView nameTextView = (TextView)view.findViewById(android.R.id.text1);
        nameTextView.setText(animal.getName());
        return view;
    }
}
