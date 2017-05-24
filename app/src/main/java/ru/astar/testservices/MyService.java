package ru.astar.testservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadFactory;

/**
 * Created by molot on 24.05.2017.
 */

public class MyService extends Service {

    public static final String PARAM_NAME = "PARAM_NAME";
    private String mString = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (intent != null) {
            mString = intent.getStringExtra(PARAM_NAME);

            if (mString != null)
                Toast.makeText(this, mString, Toast.LENGTH_SHORT).show();
        }


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Вызван onDestroy()", Toast.LENGTH_SHORT).show();
    }
}
