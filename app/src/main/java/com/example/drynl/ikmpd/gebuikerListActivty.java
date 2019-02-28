package com.example.drynl.ikmpd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.drynl.ikmpd.Model.Gebruiker;

import java.util.ArrayList;
import java.util.List;

public class gebuikerListActivty extends AppCompatActivity {
    private ListView gListView;
    private GebruikerListAdapter gebruikerListAdapter;
    private List<Gebruiker> gebruikers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerbuiker_list_activty);
        gListView = (ListView) findViewById(R.id.gebruikerListViewID);
        gebruikers.add(new Gebruiker("Mohammed","ABC"));
        gebruikers.add(new Gebruiker("Shaban","Jama"));
        gebruikers.add(new Gebruiker("Sangam","Nepali"));

        gebruikerListAdapter = new GebruikerListAdapter(gebuikerListActivty.this ,0 ,gebruikers);
        gListView.setAdapter(gebruikerListAdapter);
    }
}
