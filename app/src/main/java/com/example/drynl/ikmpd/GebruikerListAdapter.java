package com.example.drynl.ikmpd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.drynl.ikmpd.Model.Gebruiker;

import java.util.List;

/**
 * Created by drynl on 13-12-2016.
 */

public class GebruikerListAdapter extends ArrayAdapter<Gebruiker>{

    public GebruikerListAdapter(Context context, int resource, List<Gebruiker> gebruikerObjecten) {
        super(context, resource,gebruikerObjecten);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater li = LayoutInflater.from(getContext());
            convertView = li.inflate(R.layout.content_gebruiker_list,parent,false);
            viewHolder.naam =(TextView) convertView.findViewById(R.id.subject_name);
            viewHolder.wachtwoord =(TextView) convertView.findViewById(R.id.subject_code);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Gebruiker gebruiker = getItem(position);
        viewHolder.naam.setText((CharSequence) gebruiker.getNaam());
        viewHolder.wachtwoord.setText((CharSequence) gebruiker.getNaam());
       return convertView;
    }

    private static class ViewHolder{
        TextView naam;
        TextView wachtwoord;

    }
}
