package ru.appcampsiberia.clicker;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import ru.appcampsibria.clicker.R;

/**
 * Created by Алексей on 17.07.2016.
 */
public class MainActivity extends AppCompatActivity {
    public long clickCount;

    MineThread mineThread;
    Button buttonClick;
    Button buttonCursor;
    Button buttonShahter;
    Button buttonOpitniyshahter;
    Button buttonShahterloshadi;
    Button buttonShahterrobot;
    Button buttonAlhimik;
    Button buttonFilosovskykameni;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickCount = 0;

        mineThread = new MineThread(this);
        Thread thread = new Thread(mineThread);
        thread.start();

        buttonClick = (Button) findViewById(R.id.buttonClick);
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                render();
            }
        });

        buttonCursor = (Button) findViewById(R.id.buttonCursor);
        buttonCursor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(1);
            }
        });

        buttonShahter = (Button) findViewById(R.id.buttonShahter);
        buttonShahter .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(2);
            }
        });

        buttonOpitniyshahter = (Button) findViewById(R.id.buttonOpitniyshahter);
        buttonOpitniyshahter .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(3);
            }
        });

        buttonShahterloshadi = (Button) findViewById(R.id.buttonShahterloshadi);
        buttonShahterloshadi .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(4);
            }
        });

        buttonShahterrobot = (Button) findViewById(R.id.buttonShahterrobot);
        buttonShahterrobot .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(5);
            }
        });
        buttonAlhimik = (Button) findViewById(R.id.buttonAlhimik);
        buttonAlhimik .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(6);
            }
        });
        buttonFilosovskykameni = (Button) findViewById(R.id.buttonFilosovskykameni);
        buttonFilosovskykameni .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(7);
            }
        });
    }

     public void render() {
         runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 buttonClick.setText(Long.toString(clickCount));

                 if (clickCount >= 20) {
                     buttonCursor.setEnabled(true);
                 } else {
                     buttonCursor.setEnabled(false);
                 }
                 if (clickCount >= 100) {
                     buttonShahter.setEnabled(true);
                 } else {
                     buttonShahter.setEnabled(false);
                 }
                 if (clickCount >= 1000) {
                     buttonOpitniyshahter.setEnabled(true);
                 } else {
                     buttonOpitniyshahter.setEnabled(false);
                 }
                 if (clickCount >= 15000) {
                     buttonShahterloshadi.setEnabled(true);
                 } else {
                     buttonShahterloshadi.setEnabled(false);
             }
                 if (clickCount >= 510000) {
                     buttonShahterrobot.setEnabled(true);
                 } else {
                     buttonShahterrobot.setEnabled(false);
                 }
                 if (clickCount >= 2500000) {
                     buttonAlhimik.setEnabled(true);
                 } else {
                     buttonAlhimik.setEnabled(false);
                 }
                 if (clickCount >= 6000000) {
                     buttonFilosovskykameni.setEnabled(true);
                 } else {
                     buttonFilosovskykameni.setEnabled(false);
                 }
         }
         });
     }
}
