package mx.itesm.examen1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String fromExchangeValue;
    String toExchangeValue;
    float CONVERSION;
    float TOTAL = 0;

    public void changeMe(View view)
    {
        startActivity(new Intent("mx.itesm.SETTINGS"));
        this.finish();
    }

    public void showMe(View view)
    {
        TextView fromtextShown = (TextView)findViewById(R.id.Label2);
        TextView totextShown = (TextView)findViewById(R.id.label3);
        EditText field = (EditText)findViewById(R.id.changeValueText);
        String valueText = field.getText().toString();
        if(TextUtils.isEmpty(valueText))
        {
            CONVERSION = 0;
        }
        else
        {
            CONVERSION = Float.parseFloat(valueText);
        }
        boolean isInvalid = false;
        boolean isNull = false;
        String equalErrorMessage = "Obviously the result is the same";
        String nullErrorMessage = "You must give a value";

        if(TextUtils.isEmpty(valueText))
        {
            isInvalid = true;
            isNull = true;
        }
        else if(fromExchangeValue.equals(toExchangeValue))
        {
            isInvalid = true;
        }
        else if (fromExchangeValue.equals("Dollars"))
        {
            if (toExchangeValue.equals("Euros"))
            {
                TOTAL = CONVERSION * 0.89f;
            }
            else if (toExchangeValue.equals("Mxn"))
            {
                TOTAL = CONVERSION * 18.4f;
            }
        }
        else if (fromExchangeValue.equals("Euros"))
        {
            if (toExchangeValue.equals("Dollars"))
            {
                TOTAL = CONVERSION * 1.13f;
            }
            else if (toExchangeValue.equals("Mxn"))
            {
                TOTAL = CONVERSION * 20.9862f;
            }
        }
        else if (fromExchangeValue.equals("Mxn") )
        {
            if (toExchangeValue.equals("Euros"))
            {
                TOTAL = CONVERSION / 20.9862f;
            }
            else if (toExchangeValue.equals("Dollars"))
            {
                TOTAL = CONVERSION / 18.4f;
            }
        }

        if(isInvalid)
        {
            if(isNull)
            {
                Toast.makeText(getApplicationContext(), nullErrorMessage, Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), equalErrorMessage, Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), Float.toString(TOTAL), Toast.LENGTH_LONG).show();
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView fromtextShown = (TextView)findViewById(R.id.Label2);
        TextView totextShown = (TextView)findViewById(R.id.label3);

        SharedPreferences exchangePrefs = getSharedPreferences("foreign_exchange",0);
        fromExchangeValue = exchangePrefs.getString("from_Foreign_Exchange","");
        toExchangeValue = exchangePrefs.getString("to_Foreign_Exchange","");
        
        fromtextShown.setText("Convert from: " + fromExchangeValue);
        totextShown.setText("Convert to: " + toExchangeValue);


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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        TextView fromtextShown = (TextView)findViewById(R.id.Label2);
        TextView totextShown = (TextView)findViewById(R.id.label3);

        SharedPreferences exchangePrefs = getSharedPreferences("foreign_exchange",0);
        fromExchangeValue = exchangePrefs.getString("from_Foreign_Exchange","Dollar");
        toExchangeValue = exchangePrefs.getString("to_Foreign_Exchange","Dollar");

        fromtextShown.setText("Convert from: " + fromExchangeValue);
        totextShown.setText("Convert to: " + toExchangeValue);
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
