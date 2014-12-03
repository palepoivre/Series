package com.example.labo.ingesup.series.list;

/**
 * Created by Eliott on 17/10/2014.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.labo.ingesup.series.R;
import com.example.labo.ingesup.series.bean.Genre;

import java.util.List;

/**
 * Cette classe est utilisée pour afficher chaque ligne dans un Spinner
 */
public class GenreSpinnerAdapter extends ArrayAdapter {

    private List<Genre> mGenres;

    private int mResource;

    public GenreSpinnerAdapter(Context context, int resource, List<Genre> objects) {
        super(context, resource, objects);

        mGenres = objects;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(mResource, parent, false);
        }

        Genre currentGenre = mGenres.get(position);

        TextView textViewItem = (TextView) convertView.findViewById(R.id.tv_item_genre_spinner);
        textViewItem.setText(currentGenre.getNom());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        if(convertView == null){
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(mResource, parent, false);
        }

        Genre currentGenre = mGenres.get(position);

        TextView textViewItem = (TextView) convertView.findViewById(R.id.tv_item_genre_spinner);
        textViewItem.setText(currentGenre.getNom());

        return convertView;
    }
}
