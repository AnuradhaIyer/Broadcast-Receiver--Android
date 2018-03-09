package intent.android.example.com.myapplication2;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static String message;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendOutBroadcast(View view) {
        EditText text = (EditText) findViewById(R.id.editText4);
        TextView text1 =(TextView) findViewById( R.id.textView4 );
        //Spinner spinner= findViewById(R.id.spinner2)
        int amount = Integer.valueOf(text.getText().toString());
        Intent intent = new Intent();


        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        String strCurrency= spinner.getSelectedItem().toString();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.currency_array, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(this);
        intent.setAction("intent.android.example.com.myapplication2");
        intent.putExtra("Dollar Amount($)", amount);
        intent.putExtra("Convert to", strCurrency);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String item = adapterView.getSelectedItem().toString();



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        TextView Message = findViewById(R.id.textView5);
        Message.setText(message);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


