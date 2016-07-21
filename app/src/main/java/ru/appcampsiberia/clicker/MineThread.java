package ru.appcampsiberia.clicker;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jukov on 18.07.2016.
 */
public class MineThread implements Runnable {

    MainActivity mainActivity;

    public long dobuchaVsek = 0;

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
    public long dobuchaLoshadshahterov = 40;
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


    public MineThread(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        SharedPreferences sharedPreferences=mainActivity.getSharedPreferences("a", Context.MODE_PRIVATE);
        mainActivity.clickCount = sharedPreferences.getLong("clickCount", 0);
        kolichestvoCursorov = sharedPreferences.getLong("kolvoKursorov",0);
        kolichestvoShahterov = sharedPreferences.getLong("kolvoShahterov",0);
        kolichestvoOpshahterov = sharedPreferences.getLong("kolvoOpitniyshahterov",0);
        kolichestvoLoshadshahterov = sharedPreferences.getLong("kolvoLoshadshahterov",0);
        kolichestvoRoboshahterov = sharedPreferences.getLong("kolvoRoboshahterov",0);
        kolichestvoAlhimikov = sharedPreferences.getLong("kolvoAlhimikov",0);
        kolichestvoFilosovskiykamen = sharedPreferences.getLong("kolvoFilosovskiykamen",0);
        dobuchaVsek = sharedPreferences.getLong("dobuchaVsek",0);

    }

    @Override
    public void run() {

        while (true) {
            mainActivity.clickCount += dobuchaVsek;
            mainActivity.render();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void buy(int who) {
        switch (who) {
            case 1: //kursor
                if (mainActivity.clickCount >= 20) {
                    kolichestvoCursorov++;
                    dobuchaVsek += dobuchaCursorov;
                    mainActivity.clickCount -= costCursorov;
                }
                break;
            case 2: //shahter
                if (mainActivity.clickCount >= 100) {
                    kolichestvoShahterov++;
                    dobuchaVsek += dobuchaShahterov;
                    mainActivity.clickCount -= costShahterov;
                }
                break;
            case 3: //opshahter
                if (mainActivity.clickCount >= 1000) {
                    kolichestvoOpshahterov++;
                    dobuchaVsek += dobuchaOpshahterov;
                    mainActivity.clickCount -= costOpshahterov;
                }
                break;
            case 4: //loshadshahter
                if (mainActivity.clickCount >= 15000) {
                    kolichestvoLoshadshahterov++;
                    dobuchaVsek += dobuchaLoshadshahterov;
                    mainActivity.clickCount -= costLoshadshahterov;
                }
                break;
            case 5: //roboshahter
                if (mainActivity.clickCount >= 50000) {
                    kolichestvoRoboshahterov++;
                    dobuchaVsek += dobuchaRoboshahterov;
                    mainActivity.clickCount -= costRoboshahterov;
                }
                break;
            case 6: //alhimic
                if (mainActivity.clickCount >= 250000) {
                    kolichestvoAlhimikov++;
                    dobuchaVsek += dobuchaAlhimikov;
                    mainActivity.clickCount -= costAlhimikov;
                }
                break;
            case 7: //filosovskiykamen
                if (mainActivity.clickCount >= 5000000) {
                    kolichestvoFilosovskiykamen++;
                    dobuchaVsek += dobuchaFilosovskiykamen;
                    mainActivity.clickCount -= costFilosovskiykamen;
                }
                break;
        }
        mainActivity.render();
    }
}
