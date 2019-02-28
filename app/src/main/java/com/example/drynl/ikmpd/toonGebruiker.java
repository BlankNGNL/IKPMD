package com.example.drynl.ikmpd;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.drynl.ikmpd.Database.DatabaseHelper;
import com.example.drynl.ikmpd.Database.DatabaseInfo;
import com.example.drynl.ikmpd.Model.Gebruiker;

public class toonGebruiker extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toon_gebruiker);
        EditText  gebruikersnaamText =  (EditText) findViewById(R.id.gebruikersnaamText);
        Gebruiker gebruiker = (Gebruiker) getIntent().getSerializableExtra("login");
        gebruikersnaamText.setText("Hello "+ gebruiker.getNaam());

        DatabaseHelper dbHelper = DatabaseHelper.getHelper(this);
        ContentValues values = new ContentValues();
        values.put(DatabaseInfo.GebruikerKolom.NAAM, gebruiker.getNaam());
        values.put(DatabaseInfo.GebruikerKolom.WACHTWOORD, gebruiker.getPassword());

        dbHelper.insert(DatabaseInfo.GebruikerTables.GEBRUIKER, null,values);

        Cursor rs = dbHelper.query(DatabaseInfo.GebruikerTables.GEBRUIKER, new String[]{"*"}, null, null, null, null, null);
        rs.moveToFirst();

        String name = (String) rs.getString(rs.getColumnIndex("naam"));

        Log.d("Dit is gevonden","dab" + name);


    }
}
