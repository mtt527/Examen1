package mx.itesm.examen1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Spinner fromExchangeSpinner;
    Spinner toExchangeSpinner;
    String fromExchangeValue;
    String toExchangeValue;
    Button returnButton;

    public void returnMe(View view)
    {
        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences exchangePrefs = getSharedPreferences("foreign_exchange", 0);
        SharedPreferences.Editor exchangeEditor = exchangePrefs.edit();

        TextView fromtextShown = (TextView)findViewById(R.id.label3View2);
        TextView totextShown = (TextView)findViewById(R.id.label4View2);
        returnButton = (Button) findViewById(R.id.backButton);

        fromExchangeSpinner = (Spinner)findViewById(R.id.fromSpinner);
        String[] money = getResources().getStringArray(R.array.Exchange_Rate);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, money);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromExchangeSpinner.setAdapter(myAdapter);
        fromExchangeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences exchangePrefs = getSharedPreferences("foreign_exchange", 0);
                SharedPreferences.Editor exchangeEditor = exchangePrefs.edit();
                fromExchangeValue = fromExchangeSpinner.getSelectedItem().toString();
                exchangeEditor.putString("from_Foreign_Exchange", fromExchangeValue);
                exchangeEditor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        toExchangeSpinner = (Spinner)findViewById(R.id.toSpinner);
        String[] money2 = getResources().getStringArray(R.array.Exchange_Rate);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, money2);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toExchangeSpinner.setAdapter(myAdapter2);
        toExchangeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences exchangePrefs = getSharedPreferences("foreign_exchange", 0);
                SharedPreferences.Editor exchangeEditor = exchangePrefs.edit();
                toExchangeValue = toExchangeSpinner.getSelectedItem().toString();
                exchangeEditor.putString("to_Foreign_Exchange", toExchangeValue);
                exchangeEditor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void onResume()
    {
        super.onResume();

    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
