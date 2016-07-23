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

    public long dobuchaVsek = 0;
    public long dobuchaZaClick = 1;
    public long CostZaClick = 100;

    public long kolichestvoCursorov = 0;
    public long kolichestvoShahterov = 0;
    public long kolichestvoOpshahterov = 0;
    public long kolichestvoLoshadshahterov = 0;
    public long kolichestvoRoboshahterov = 0;
    public long kolichestvoAlhimikov = 0;
    public long kolichestvoFilosovskiykamen = 0;

    public long dobuchaCursorov = 1;
    public long dobuchaShahterov = 5;
    public long dobuchaOpshahterov = 10;
    public long dobuchaLoshadshahterov = 50;
    public long dobuchaRoboshahterov = 80;
    public long dobuchaAlhimikov = 150;
    public long dobuchaFilosovskiykamen = 1000;

    public long costCursorov = 20;
    public long costShahterov = 100;
    public long costOpshahterov = 1000;
    public long costLoshadshahterov = 15000;
    public long costRoboshahterov = 50000;
    public long costAlhimikov = 250000;
    public long costFilosovskiykamen = 5000000;

    MineThread mineThread;

    ImageView imageGold;
    Button buttonCursor;
    Button buttonShahter;
    Button buttonOpitniyshahter;
    Button buttonShahterloshadi;
    Button buttonShahterrobot;
    Button buttonAlhimik;
    Button buttonFilosovskykameni;
    Button buttonClickUpgrade;

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
                clickCount+=dobuchaZaClick;
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
        buttonClickUpgrade = (Button) findViewById(R.id.buttonClickupgreid);
                buttonClickUpgrade.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mineThread.upgrede();
                    }
                });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(getClass().getSimpleName(), "onStop");
        SharedPreferences.Editor shardPreferences = getSharedPreferences("a", MODE_PRIVATE).edit();
        shardPreferences.putLong("clickCount", clickCount);
        shardPreferences.putLong("kolvoKursorov", kolichestvoCursorov);
        shardPreferences.putLong("kolvoShahterov", kolichestvoShahterov);
        shardPreferences.putLong("kolvoOpitniyshahterov", kolichestvoOpshahterov);
        shardPreferences.putLong("kolvoLoshadshahterov", kolichestvoLoshadshahterov);
        shardPreferences.putLong("kolvoRoboshahterov", kolichestvoRoboshahterov);
        shardPreferences.putLong("kolvoAlhimikov", kolichestvoAlhimikov);
        shardPreferences.putLong("kolvoFilosovskiykamen", kolichestvoFilosovskiykamen);

        shardPreferences.putLong("dobuchaVsek", dobuchaVsek);
        shardPreferences.putLong("dobuchaZaClick",dobuchaZaClick);
        shardPreferences.putLong("CostZaClick",CostZaClick);

        if (dobuchaCursorov != 0)
            shardPreferences.putLong("dobuchaKursorov",dobuchaCursorov);
        if (dobuchaShahterov != 0)
            shardPreferences.putLong("dobuchaShahterov",dobuchaShahterov);
        if (dobuchaOpshahterov != 0)
            shardPreferences.putLong("dobuchaOpitniyshahterov",dobuchaOpshahterov);
        if (dobuchaLoshadshahterov != 0)
            shardPreferences.putLong("dobuchaLoshadshahterov",dobuchaLoshadshahterov);
        if (dobuchaRoboshahterov != 0)
            shardPreferences.putLong("dobuchaRoboshahterov",dobuchaRoboshahterov);
        if (dobuchaAlhimikov != 0)
            shardPreferences.putLong("dobuchaAlhimikov",dobuchaAlhimikov);
        if (dobuchaFilosovskiykamen != 0)
            shardPreferences.putLong("dobuchaFilosovskiykamen",dobuchaFilosovskiykamen);

        if (costCursorov!= 0)
        shardPreferences.putLong("costKursorov",costCursorov);
        if (costShahterov!= 0)
        shardPreferences.putLong("costShahterov ",costShahterov);
        if (costOpshahterov!= 0)
        shardPreferences.putLong("costOpitniyshahterov",costOpshahterov);
        if (costLoshadshahterov!= 0)
        shardPreferences.putLong("costLoshadshahterov",costLoshadshahterov);
        if (costRoboshahterov!= 0)
        shardPreferences.putLong("costRoboshahterov",costRoboshahterov);
        if (costAlhimikov!= 0)
        shardPreferences.putLong("costAlhimikov",costAlhimikov);
        if (costFilosovskiykamen!= 0)
        shardPreferences.putLong("costFilosovskiykamen",costFilosovskiykamen);

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
                getSupportActionBar().setTitle("Золото: " + Long.toString(clickCount));
                getSupportActionBar().setSubtitle("Доход: " + Long.toString(dobuchaVsek));
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
                buttonClickUpgrade.setText(getString(R.string.button_clickupgreit, CostZaClick, dobuchaZaClick));

                textViewCursorKolichestvo.setText("Количество: " + Long.toString(kolichestvoCursorov));
                textViewShahterKolichestvo.setText("Количество: " + Long.toString(kolichestvoShahterov));
                textViewOpitniyShahterKolichestvo.setText("Количество: " + Long.toString(kolichestvoOpshahterov));
                textViewShahterloshadiKolichestvo.setText("Количество: " + Long.toString(kolichestvoLoshadshahterov));
                textViewShahterrobotrKolichestvo.setText("Количество: " + Long.toString(kolichestvoRoboshahterov));
                textViewAlhimikKolichestvo.setText("Количество: " + Long.toString(kolichestvoAlhimikov));
                textViewFilosovskykameniKolichestvo.setText("Количество: " + Long.toString(kolichestvoFilosovskiykamen));

                textViewCursorCost.setText("Цена: " + Long.toString(costCursorov));
                textViewShahterCost.setText("Цена: " + Long.toString(costShahterov));
                textViewOpitniyShahterCost.setText("Цена: " + Long.toString(costOpshahterov));
                textViewShahterloshadiCost.setText("Цена: " + Long.toString(costLoshadshahterov));
                textViewShahterrobotrCost.setText("Цена: " + Long.toString(costRoboshahterov));
                textViewAlhimikCost.setText("Цена: " + Long.toString(costAlhimikov));
                textViewFilosovskykameniCost.setText("Цена: " + Long.toString(costFilosovskiykamen));

                textViewCursorPower.setText("Доход/сек: " + Long.toString(dobuchaCursorov));
                textViewShahterPower.setText("Доход/сек: " + Long.toString(dobuchaShahterov));
                textViewOpitniyShahterPower.setText("Доход/сек: " + Long.toString(dobuchaOpshahterov));
                textViewShahterloshadiPower.setText("Доход/сек: " + Long.toString(dobuchaLoshadshahterov));
                textViewShahterrobotrPower.setText("Доход/сек: " + Long.toString(dobuchaRoboshahterov));
                textViewAlhimikPower.setText("Доход/сек: " + Long.toString(dobuchaAlhimikov));
                textViewFilosovskykameniPower.setText("Доход/сек: " + Long.toString(dobuchaFilosovskiykamen));

            }
        });
    }
}
