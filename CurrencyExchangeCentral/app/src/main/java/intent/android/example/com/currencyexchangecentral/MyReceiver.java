package intent.android.example.com.currencyexchangecentral;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import static intent.android.example.com.currencyexchangecentral.MainActivity.currency;
import static intent.android.example.com.currencyexchangecentral.MainActivity.dollar;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("intent.android.example.com.myapplication2")) {
            MainActivity.dollar = intent.getExtras().getInt("Dollar Amount($)");
            MainActivity.currency = intent.getExtras().getString(( "Convert to" ));
        }
    }
}
