package ru.appcampsiberia.clicker;

/**
 * Created by jukov on 18.07.2016.
 */
public class MineThread implements Runnable {

    MainActivity mainActivity;

    long dobuchaVsek = 0;

    long kolichestvoCursorov = 0;
    long kolichestvoShahterov = 0;
    long kolichestvoOpshahterov = 0;
    long kolichestvoLoshadshahterov = 0;
    long kolichestvoRoboshahterov = 0;
    long kolichestvoAlhimikov = 0;
    long kolichestvoFilosovskiykamen = 0;

    long dobuchaCursorov = 1;
    long dobuchaShahterov = 2;
    long dobuchaOpshahterov = 5;
    long dobuchaLoshadshahterov = 20;
    long dobuchaRoboshahterov = 40;
    long dobuchaAlhimikov = 100;
    long dobuchaFilosovskiykamen = 1000;

    long costCursorov = 20;
    long costShahterov = 100;
    long costOpshahterov = 1000;
    long costLoshadshahterov = 15000;
    long costRoboshahterov = 500000;
    long costAlhimikov = 2500000;
    long costFilosovskiykamen = 5000000;

    public MineThread(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
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
                    dobuchaVsek += dobuchaOpshahterov;
                    mainActivity.clickCount -= costLoshadshahterov;
                }
                break;
            case 5: //roboshahter
                if (mainActivity.clickCount >= 500000) {
                    kolichestvoRoboshahterov++;
                    dobuchaVsek += dobuchaRoboshahterov;
                    mainActivity.clickCount -= costRoboshahterov;
                }
                break;
            case 6: //alhimic
                if (mainActivity.clickCount >= 2500000) {
                    kolichestvoAlhimikov++;
                    dobuchaVsek += dobuchaAlhimikov;
                    mainActivity.clickCount -= costAlhimikov;
                }
                break;
            case 7: //filosovskiykamen
                if (mainActivity.clickCount >= 50000000) {
                    kolichestvoFilosovskiykamen++;
                    dobuchaVsek += dobuchaFilosovskiykamen;
                    mainActivity.clickCount -= costFilosovskiykamen;
                }
                break;
        }
    }
}
