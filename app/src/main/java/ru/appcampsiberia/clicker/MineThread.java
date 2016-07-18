package ru.appcampsiberia.clicker;

/**
 * Created by jukov on 18.07.2016.
 */
public class MineThread implements Runnable {

    long kolichestvoCursorov=0;
    long kolichestvoShahterov=0;
    long kolichestvoOpshahterov=0;
    long kolichestvoLoshadshahterov=0;
    long kolichestvoRoboshahterov=0;
    long kolichestvoAlhimikov=0;
    long kolichestvoFilosovskiykamen=0;

    long dobuchaCursorov=1;
    long dobuchaShahterov=2;
    long dobuchaOpshahterov=5;
    long dobuchaLoshadshahterov=20;
    long dobuchaRoboshahterov=40;
    long dobuchaAlhimikov=100;
    long dobuchaFilosovskiykamen=1000;

    long costCursorov=20;
    long costShahterov=100;
    long costOpshahterov=1000;
    long costLoshadshahterov=15000;
    long costRoboshahterov=500000;
    long costAlhimikov=2500000;
    long costFilosovskiykamen=5000000;

    @Override
    public void run() {
    }

    public void buy(int who) {
        switch (who) {
            case 1: //kursor
                kolichestvoCursorov++;
                break;
            case 2: //shahter
                kolichestvoShahterov++;
                break;
            case 3: //opshahter
                kolichestvoOpshahterov++;
                break;
            case 4: //loshadshahter
                kolichestvoLoshadshahterov++;
                break;
            case 5: //roboshahter
                kolichestvoRoboshahterov++;
                break;
            case 6: //alhimic
                kolichestvoAlhimikov++;
                break;
            case 7: //filosovskiykamen
                kolichestvoFilosovskiykamen++;
                break;

        }
    }

}
