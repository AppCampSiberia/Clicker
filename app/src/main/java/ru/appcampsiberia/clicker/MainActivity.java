package ru.appcampsiberia.clicker;

import android.os.Bundle;
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
    long clickCount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickCount = 0;
        final Button buttonClick = (Button) findViewById(R.id.buttonClick);
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                buttonClick.setText(Long.toString(clickCount));
            }
        });
    }
}
