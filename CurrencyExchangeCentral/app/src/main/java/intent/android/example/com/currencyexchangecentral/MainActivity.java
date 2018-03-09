package intent.android.example.com.currencyexchangecentral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;


public class MainActivity extends AppCompatActivity {
    public static int dollar, res;
    public static String currency, message;
    Button apply, close;
    TextView text, text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    @Override
    protected void onResume() {
        super.onResume();
        text = (TextView) findViewById( R.id.textView );
        text1 = (TextView) findViewById( R.id.textView2 );
        text.setText( "Dollar Amount($) : " + dollar );
        text1.setText( "Currency:" + currency );
    }

    public void onClick(View view) {

        if (currency.equals( "British Pound" ))
            res = (int) (Math.round( dollar * 0.71 *100)/100.0);
        else if (currency.equals( "Euro" ))
            res = (int) (Math.round( dollar * 0.81 *100)/100.0);

        else
            res = (int) (Math.round( dollar * 64.39 *100)/100.0);
            message = "Dollar Amount" + " " + dollar + "\r " + "Converted to" + "\r\r" + res + "\r " + currency;
            Intent intent = new Intent( "intent.android.example.com.currencyexchangecentral" );
            intent.putExtra( "Message", message );
            sendBroadcast( intent );


        }
public void onCloseclick(View view)
{
    MainActivity.this.finish();
}

    }


