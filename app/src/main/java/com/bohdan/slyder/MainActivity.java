package com.bohdan.slyder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    //UI
    private Button ovalButton;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button changeButton;

    float x, x1;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        changeButton = (Button) findViewById(R.id.changeButton);
        ovalButton = (Button) findViewById(R.id.ovalButton);
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button1);
        button3 = (Button) findViewById(R.id.button2);
        button4 = (Button) findViewById(R.id.button3);

        ovalButton.setWidth(button1.getWidth());
        ovalButton.setHeight(button1.getHeight());

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (i) {
                    case 1:
                        x = ovalButton.getX();
                        x1 = button2.getX();
                        break;
                    case 2:
                        x = button2.getX();
                        x1 = button3.getX();
                        break;
                    case 3:
                        x = button3.getX();
                        x1 = button4.getX();
                        break;
                }
                moveButton(ovalButton, x, x1, ovalButton.getY(), ovalButton.getY());
                i++;
            }
        });

    }

    public void moveButton(final View view, float x, float x1, float y, float y1) {
        TranslateAnimation anim = new TranslateAnimation(x, x1, y, y1);
        anim.setDuration(1000);
        anim.setFillAfter(true);
        view.startAnimation(anim);
    }
}
