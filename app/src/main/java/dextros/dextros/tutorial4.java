package dextros.dextros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class tutorial4 extends AppCompatActivity {

    float x1, x2;
    float y1, y2;

    List<Button> mButtons = new ArrayList();
    List<Integer> WEIGHT = new ArrayList();
    void DOTHETHING() {
        mButtons.add((Button) findViewById(R.id.button6));
        WEIGHT.add(0);


        mButtons.get(0).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent touchevent) {
                if (touchevent.getAction() == MotionEvent.ACTION_MOVE) {
                    int rick[] = new int[2];


                    for (int jim = 0; jim < mButtons.size(); jim++) {
                        x1 = touchevent.getX();
                        y1 = touchevent.getY();
                        Log.d("LOOKATMEX", String.valueOf(x1));
                        Log.d("LOOKATMEY", String.valueOf(y1));
                        mButtons.get(jim).getLocationOnScreen(rick);

                        x1 += rick[0];
                        y1 += rick[1];
                        //Log.d("I AM THE WALRUS", String.valueOf(rick[0]));
                        // Log.d("I AM THE WALRUS", String.valueOf(rick[1]));

                        if (x1 >= rick[0] && x1 <= (rick[0] + mButtons.get(0).getWidth()) && y1 >= rick[1] && y1 <= (rick[1] + mButtons.get(0).getHeight())) {
                            Log.d("I AM THE WALRUS", String.valueOf(0));
                            WEIGHT.set(0, (WEIGHT.get(0) + 1));
                        }

                    }

                } else if (touchevent.getAction() == MotionEvent.ACTION_DOWN) {
                    TextView view = (TextView) findViewById(R.id.errormessage2);
                    view.setText("Tip: Drag from the button to anywhere else on the screen");
                } else if (touchevent.getAction() == MotionEvent.ACTION_UP) {
                    oneButton();
                }
                return false;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial4);
        DOTHETHING();
    }

    public int abs( int number)
    {
        if( number < 0)
            return -1 * number;
        else
            return number;
    }

    public void oneButton()
    {


        if( WEIGHT.get(0) != 0)
        {
            Intent intent = new Intent(this, tutorial5.class);
            startActivity(intent);
        }
        for(int i = 0; i < WEIGHT.size(); i++)
        {
            WEIGHT.set(i, 0);
        }
    }

    public boolean onTouchEvent(final MotionEvent touchevent)
    {
        switch(touchevent.getAction())
        {
            case MotionEvent.ACTION_MOVE:
            {
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                Log.d("LOOKATMEX", String.valueOf(x1));
                Log.d("LOOKATMEY", String.valueOf(y1));
                int rick[] = new int[2];

                for(int jim = 0; jim < mButtons.size(); jim++ )
                {
                    mButtons.get(jim).getLocationOnScreen(rick);
                    if (x1 >= rick[0] && x1 <= (rick[0] + mButtons.get(jim).getWidth()) && y1 >= rick[1] && y1 <= (rick[1] + mButtons.get(jim).getHeight())) {
                        //WEIGHT.set(jim, (WEIGHT.get(jim) + 1));
                    }
                }


                break;
            }
            case MotionEvent.ACTION_UP:
            {
                TextView view = (TextView) findViewById(R.id.errormessage2);
                view.setText("Tip: Drag from the button to anywhere else on the screen");
                //oneButton();
                break;
            }
        }
        return false;
    }

}
