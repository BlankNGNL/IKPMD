package com.example.drynl.ikmpd;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.drynl.ikmpd.Model.Gebruiker;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    EditText editTextUserName;
    EditText editTextWachtwoord;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserName = (EditText) findViewById(R.id.gebruikersNaamField);
        editTextWachtwoord = (EditText) findViewById(R.id.passwordText);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        parseJSON();

        Button graphButton = (Button) findViewById(R.id.ChartButton);
        graphButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("graph", "graph button zetten");
                startActivity(new Intent(MainActivity.this, PieChartActivity.class));
            }
        });

        Button barButton = (Button) findViewById(R.id.BarChart);
        barButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, barChart.class));
            }
        });


    }


    public void parseJSON() {
        Gson gs = new Gson();
        String jsonString = "[{naam: 'Mohammed', wachtwoord: 'ABC'}," + " {naam: 'Shaban', wachtwoord:'HOI'}]";
        Gebruiker[] gebruikers = gs.fromJson(jsonString, Gebruiker[].class);

        for(Gebruiker g: gebruikers){
//            Log.d("qweqwe",g.getNaam());
            System.out.println(g.getNaam());
        }

    }

    public void login(View v) {
        String username = editTextUserName.getText().toString();
        String wachtwoord = editTextWachtwoord.getText().toString();

        Gebruiker gebruiker = new Gebruiker(username, wachtwoord);
        Intent intent = new Intent(this, toonGebruiker.class);
        intent.putExtra("login", gebruiker);
        startActivity(intent);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}


