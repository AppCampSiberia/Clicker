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
                buttonClick.setText(Long.toString(clickCount));
            }
        });

        final Button buttonCursor = (Button) findViewById(R.id.buttonCursor);
        buttonCursor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(1);
            }
        });

        final Button buttonShahter = (Button) findViewById(R.id.buttonShahter);
        buttonShahter .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(2);
            }
        });

        final Button buttonOpitniyshahter = (Button) findViewById(R.id.buttonOpitniyshahter);
        buttonOpitniyshahter .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(3);
            }
        });

        final Button buttonShahterloshadi = (Button) findViewById(R.id.buttonShahterloshadi);
        buttonShahterloshadi .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(4);
            }
        });

        final Button buttonShahterrobot = (Button) findViewById(R.id.buttonShahterrobot);
        buttonShahterrobot .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(5);
            }
        });
        final Button buttonAlhimik = (Button) findViewById(R.id.buttonAlhimik);
        buttonAlhimik .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(6);
            }
        });
        final Button buttonFilosovskykameni = (Button) findViewById(R.id.buttonFilosovskykameni);
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
             }
         });
     }
}
