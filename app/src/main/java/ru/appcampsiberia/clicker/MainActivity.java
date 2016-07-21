package ru.appcampsiberia.clicker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ru.appcampsibria.clicker.R;

/**
 * Created by Алексей on 17.07.2016.
 */
public class MainActivity extends AppCompatActivity {
    public long clickCount;

    MineThread mineThread;

    ImageView imageGold;
    Button buttonCursor;
    Button buttonShahter;
    Button buttonOpitniyshahter;
    Button buttonShahterloshadi;
    Button buttonShahterrobot;
    Button buttonAlhimik;
    Button buttonFilosovskykameni;

    TextView textViewCursorKolichestvo;
    TextView textViewShahterKolichestvo;
    TextView textViewOpitniyShahterKolichestvo;
    TextView textViewShahterloshadiKolichestvo;
    TextView textViewShahterrobotrKolichestvo;
    TextView textViewAlhimikKolichestvo;
    TextView textViewFilosovskykameniKolichestvo;

    TextView textViewCursorCost;
    TextView textViewShahterCost;
    TextView textViewOpitniyShahterCost;
    TextView textViewShahterloshadiCost;
    TextView textViewShahterrobotrCost;
    TextView textViewAlhimikCost;
    TextView textViewFilosovskykameniCost;

    TextView textViewCursorPower;
    TextView textViewShahterPower;
    TextView textViewOpitniyShahterPower;
    TextView textViewShahterloshadiPower;
    TextView textViewShahterrobotrPower;
    TextView textViewAlhimikPower;
    TextView textViewFilosovskykameniPower;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickCount = 0;

        textViewCursorKolichestvo = (TextView) findViewById(R.id.textViewCursor);
        textViewShahterKolichestvo = (TextView) findViewById(R.id.textViewShahterCount);
        textViewOpitniyShahterKolichestvo = (TextView) findViewById(R.id.textViewOpitniyshahterCount);
        textViewShahterloshadiKolichestvo = (TextView) findViewById(R.id.textViewShahterloshadiCount);
        textViewShahterrobotrKolichestvo = (TextView) findViewById(R.id.textViewShahterrobotCount);
        textViewAlhimikKolichestvo = (TextView) findViewById(R.id.textViewAlhimikCount);
        textViewFilosovskykameniKolichestvo = (TextView) findViewById(R.id.textViewFilosovskykameniCount);

        textViewCursorCost = (TextView) findViewById(R.id.textViewCursorCost);
        textViewShahterCost = (TextView) findViewById(R.id.textViewShahterCost);
        textViewOpitniyShahterCost = (TextView) findViewById(R.id.textViewOpitniyshahterCost);
        textViewShahterloshadiCost = (TextView) findViewById(R.id.textViewShahterloshadiCost);
        textViewShahterrobotrCost = (TextView) findViewById(R.id.textViewShahterrobotCost);
        textViewAlhimikCost = (TextView) findViewById(R.id.textViewAlhimikCost);
        textViewFilosovskykameniCost = (TextView) findViewById(R.id.textViewFilosovskykameniCost);

        textViewCursorPower = (TextView) findViewById(R.id.textViewCursorPower);
        textViewShahterPower = (TextView) findViewById(R.id.textViewShahterPower);
        textViewOpitniyShahterPower = (TextView) findViewById(R.id.textViewOpitniyshahterPower);
        textViewShahterloshadiPower = (TextView) findViewById(R.id.textViewShahterloshadiPower);
        textViewShahterrobotrPower = (TextView) findViewById(R.id.textViewShahterrobotPower);
        textViewAlhimikPower = (TextView) findViewById(R.id.textViewAlhimikPower);
        textViewFilosovskykameniPower = (TextView) findViewById(R.id.textViewFilosovskykameniPower);

        mineThread = new MineThread(this);
        Thread thread = new Thread(mineThread);
        thread.start();

        imageGold = (ImageView) findViewById(R.id.imageViewGold);
        imageGold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                render();
            }
        });

        buttonCursor = (Button) findViewById(R.id.buttonCursorCount);
        buttonCursor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(1);
            }
        });

        buttonShahter = (Button) findViewById(R.id.buttonShahter);
        buttonShahter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(2);
            }
        });

        buttonOpitniyshahter = (Button) findViewById(R.id.buttonOpitniyshahter);
        buttonOpitniyshahter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(3);
            }
        });

        buttonShahterloshadi = (Button) findViewById(R.id.buttonShahterloshadi);
        buttonShahterloshadi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(4);
            }
        });

        buttonShahterrobot = (Button) findViewById(R.id.buttonShahterrobot);
        buttonShahterrobot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(5);
            }
        });
        buttonAlhimik = (Button) findViewById(R.id.buttonAlhimik);
        buttonAlhimik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(6);
            }
        });
        buttonFilosovskykameni = (Button) findViewById(R.id.buttonFilosovskykameni);
        buttonFilosovskykameni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mineThread.buy(7);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(getClass().getSimpleName(), "onStop");
        SharedPreferences.Editor shardPreferences = getSharedPreferences("a", MODE_PRIVATE).edit();
        shardPreferences.putLong("clickCount", clickCount);
        shardPreferences.putLong("kolvoKursorov", mineThread.kolichestvoCursorov);
        shardPreferences.putLong("kolvoShahterov", mineThread.kolichestvoShahterov);
        shardPreferences.putLong("kolvoOpitniyshahterov", mineThread.kolichestvoOpshahterov);
        shardPreferences.putLong("kolvoLoshadshahterov", mineThread.kolichestvoLoshadshahterov);
        shardPreferences.putLong("kolvoRoboshahterov", mineThread.kolichestvoRoboshahterov);
        shardPreferences.putLong("kolvoAlhimikov", mineThread.kolichestvoAlhimikov);
        shardPreferences.putLong("kolvoFilosovskiykamen", mineThread.kolichestvoFilosovskiykamen);
        shardPreferences.putLong("dobuchaVsek", mineThread.dobuchaVsek);
        shardPreferences.apply();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about)
            startActivity(new Intent(this, AboutActivity.class));
        return super.onOptionsItemSelected(item);
    }

    public void render() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getSupportActionBar().setTitle("Добыто золота: " + Long.toString(clickCount) + " доход: " + Long.toString(mineThread.dobuchaVsek));

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
                if (clickCount >= 50000) {
                    buttonShahterrobot.setEnabled(true);
                } else {
                    buttonShahterrobot.setEnabled(false);
                }
                if (clickCount >= 250000) {
                    buttonAlhimik.setEnabled(true);
                } else {
                    buttonAlhimik.setEnabled(false);
                }
                if (clickCount >= 5000000) {
                    buttonFilosovskykameni.setEnabled(true);
                } else {
                    buttonFilosovskykameni.setEnabled(false);
                }

                textViewCursorKolichestvo.setText("Количество: " + Long.toString(mineThread.kolichestvoCursorov));
                textViewShahterKolichestvo.setText("Количество: " + Long.toString(mineThread.kolichestvoShahterov));
                textViewOpitniyShahterKolichestvo.setText("Количество: " + Long.toString(mineThread.kolichestvoOpshahterov));
                textViewShahterloshadiKolichestvo.setText("Количество: " + Long.toString(mineThread.kolichestvoLoshadshahterov));
                textViewShahterrobotrKolichestvo.setText("Количество: " + Long.toString(mineThread.kolichestvoRoboshahterov));
                textViewAlhimikKolichestvo.setText("Количество: " + Long.toString(mineThread.kolichestvoAlhimikov));
                textViewFilosovskykameniKolichestvo.setText("Количество: " + Long.toString(mineThread.kolichestvoFilosovskiykamen));

                textViewCursorCost.setText("Цена: " + Long.toString(mineThread.costCursorov));
                textViewShahterCost.setText("Цена: " + Long.toString(mineThread.costShahterov));
                textViewOpitniyShahterCost.setText("Цена: " + Long.toString(mineThread.costOpshahterov));
                textViewShahterloshadiCost.setText("Цена: " + Long.toString(mineThread.costLoshadshahterov));
                textViewShahterrobotrCost.setText("Цена: " + Long.toString(mineThread.costRoboshahterov));
                textViewAlhimikCost.setText("Цена: " + Long.toString(mineThread.costAlhimikov));
                textViewFilosovskykameniCost.setText("Цена: " + Long.toString(mineThread.costFilosovskiykamen));

                textViewCursorPower.setText("Доход/сек: " + Long.toString(mineThread.dobuchaCursorov));
                textViewShahterPower.setText("Доход/сек: " + Long.toString(mineThread.dobuchaShahterov));
                textViewOpitniyShahterPower.setText("Доход/сек: " + Long.toString(mineThread.dobuchaOpshahterov));
                textViewShahterloshadiPower.setText("Доход/сек: " + Long.toString(mineThread.dobuchaLoshadshahterov));
                textViewShahterrobotrPower.setText("Доход/сек: " + Long.toString(mineThread.dobuchaRoboshahterov));
                textViewAlhimikPower.setText("Доход/сек: " + Long.toString(mineThread.dobuchaAlhimikov));
                textViewFilosovskykameniPower.setText("Доход/сек: " + Long.toString(mineThread.dobuchaFilosovskiykamen));

            }
        });
    }
}
