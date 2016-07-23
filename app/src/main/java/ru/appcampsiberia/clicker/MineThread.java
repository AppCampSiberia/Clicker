package ru.appcampsiberia.clicker;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jukov on 18.07.2016.
 */
public class MineThread implements Runnable {

    MainActivity mainActivity;

    public MineThread(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        SharedPreferences sharedPreferences=mainActivity.getSharedPreferences("a", Context.MODE_PRIVATE);
        mainActivity.clickCount = sharedPreferences.getLong("clickCount", 0);
        mainActivity.kolichestvoCursorov = sharedPreferences.getLong("kolvoKursorov",0);
        mainActivity.kolichestvoShahterov = sharedPreferences.getLong("kolvoShahterov",0);
        mainActivity.kolichestvoOpshahterov = sharedPreferences.getLong("kolvoOpitniyshahterov",0);
        mainActivity.kolichestvoLoshadshahterov = sharedPreferences.getLong("kolvoLoshadshahterov",0);
        mainActivity.kolichestvoRoboshahterov = sharedPreferences.getLong("kolvoRoboshahterov",0);
        mainActivity.kolichestvoAlhimikov = sharedPreferences.getLong("kolvoAlhimikov",0);
        mainActivity.kolichestvoFilosovskiykamen = sharedPreferences.getLong("kolvoFilosovskiykamen",0);

        mainActivity.dobuchaVsek = sharedPreferences.getLong("dobuchaVsek",0);
        mainActivity.dobuchaZaClick = sharedPreferences.getLong("dobuchaZaClick",1);
        mainActivity.CostZaClick = sharedPreferences.getLong("CostZaClick",100);

        mainActivity.dobuchaCursorov = sharedPreferences.getLong("dobuchaKursorov",1);
        mainActivity.dobuchaShahterov = sharedPreferences.getLong("dobuchaShahterov",5);
        mainActivity.dobuchaOpshahterov = sharedPreferences.getLong("dobuchaOpitniyshahterov",10);
        mainActivity.dobuchaLoshadshahterov = sharedPreferences.getLong("dobuchaLoshadshahterov",50);
        mainActivity.dobuchaRoboshahterov = sharedPreferences.getLong("dobuchaRoboshahterov",80);
        mainActivity.dobuchaAlhimikov = sharedPreferences.getLong("dobuchaAlhimikov",150);
        mainActivity.dobuchaFilosovskiykamen = sharedPreferences.getLong("dobuchaFilosovskiykamen",1000);

        mainActivity.costCursorov = sharedPreferences.getLong("costKursorov",20);
        mainActivity.costShahterov = sharedPreferences.getLong("costShahterov",100);
        mainActivity.costOpshahterov = sharedPreferences.getLong("costOpitniyshahterov",1000);
        mainActivity.costLoshadshahterov = sharedPreferences.getLong("costLoshadshahterov",15000);
        mainActivity.costRoboshahterov = sharedPreferences.getLong("costRoboshahterov",50000);
        mainActivity.costAlhimikov = sharedPreferences.getLong("costAlhimikov",250000);
        mainActivity.costFilosovskiykamen = sharedPreferences.getLong("costFilosovskiykamen",4000000);

    }

    @Override
    public void run() {

        while (true) {
            mainActivity.clickCount += mainActivity.dobuchaVsek;
            mainActivity.render();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void upgrede() {
        if (mainActivity.clickCount >= mainActivity.CostZaClick){
            mainActivity.dobuchaZaClick*=2;
            mainActivity.clickCount -= mainActivity.CostZaClick;
            mainActivity.CostZaClick*=3;
        }
    }
    public void buy(int who) {
        switch (who) {
            case 1: //kursor
                if (mainActivity.clickCount >= mainActivity.costCursorov) {
                    mainActivity.kolichestvoCursorov++;
                    mainActivity.dobuchaVsek += mainActivity.dobuchaCursorov;
                    mainActivity.clickCount -= mainActivity.costCursorov;
                    mainActivity.costCursorov *= 1.1;
                    mainActivity.dobuchaCursorov *= 1.01;
                }
                break;
            case 2: //opshahter
                if (mainActivity.clickCount >= mainActivity.costShahterov) {
                    mainActivity.kolichestvoShahterov++;
                    mainActivity.dobuchaVsek += mainActivity.dobuchaShahterov;
                    mainActivity.clickCount -= mainActivity.costShahterov;
                    mainActivity.costShahterov *= 1.1;
                    mainActivity.dobuchaShahterov *= 1.01;
                }
                break;
            case 3: //opshahter
                if (mainActivity.clickCount >= mainActivity.costOpshahterov) {
                    mainActivity.kolichestvoOpshahterov++;
                    mainActivity.dobuchaVsek += mainActivity.dobuchaOpshahterov;
                    mainActivity.clickCount -= mainActivity.costOpshahterov;
                    mainActivity.costOpshahterov *= 1.1;
                    mainActivity.dobuchaOpshahterov *= 1.01;
                }
                break;
            case 4: //loshadshahter
                if (mainActivity.clickCount >= mainActivity.costLoshadshahterov) {
                    mainActivity.kolichestvoLoshadshahterov++;
                    mainActivity.dobuchaVsek += mainActivity.dobuchaLoshadshahterov;
                    mainActivity.clickCount -= mainActivity.costLoshadshahterov;
                    mainActivity.costLoshadshahterov *= 1.1;
                    mainActivity.dobuchaLoshadshahterov *= 1.01;
                }
                break;
            case 5: //roboshahter
                if (mainActivity.clickCount >= mainActivity.costRoboshahterov) {
                    mainActivity.kolichestvoRoboshahterov++;
                    mainActivity.dobuchaVsek += mainActivity.dobuchaRoboshahterov;
                    mainActivity.clickCount -= mainActivity.costRoboshahterov;
                    mainActivity.costRoboshahterov *= 1.1;
                    mainActivity.dobuchaRoboshahterov *= 1.01;
                }
                break;
            case 6: //alhimic
                if (mainActivity.clickCount >= mainActivity.costAlhimikov) {
                    mainActivity.kolichestvoAlhimikov++;
                    mainActivity.dobuchaVsek += mainActivity.dobuchaAlhimikov;
                    mainActivity.clickCount -= mainActivity.costAlhimikov;
                    mainActivity.costAlhimikov *= 1.1;
                    mainActivity.dobuchaAlhimikov *= 1.01;
                }
                break;
            case 7: //filosovskiykamen
                if (mainActivity.clickCount >= mainActivity.costFilosovskiykamen) {
                    mainActivity.kolichestvoFilosovskiykamen++;
                    mainActivity.dobuchaVsek += mainActivity.dobuchaFilosovskiykamen;
                    mainActivity.clickCount -= mainActivity.costFilosovskiykamen;
                    mainActivity.costFilosovskiykamen *= 1.1;
                    mainActivity.dobuchaFilosovskiykamen *= 1.01 ;
                }
                break;
        }
        mainActivity.render();
    }
}
