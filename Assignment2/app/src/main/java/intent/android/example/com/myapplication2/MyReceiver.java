package intent.android.example.com.myapplication2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("intent.android.example.com.currencyexchangecentral"))
        {
            MainActivity.message= intent.getExtras().getString("Message");
        }
    }
}
