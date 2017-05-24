package ru.astar.testservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startServiceButton;
    private Button stopServiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startServiceButton = (Button) findViewById(R.id.startService);
        stopServiceButton = (Button) findViewById(R.id.stopService);
        ClickListener listener = new ClickListener();
        startServiceButton.setOnClickListener(listener);
        stopServiceButton.setOnClickListener(listener);
    }

    class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.equals(startServiceButton)) {

                Intent intent = new Intent(MainActivity.this, MyService.class);
                intent.putExtra(MyService.PARAM_NAME, "Этот текст передан сервису из активности!");
                startService(intent);

                return;
            }

            if (view.equals(stopServiceButton)) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                stopService(intent);
                return;
            }

        }
    }
}
