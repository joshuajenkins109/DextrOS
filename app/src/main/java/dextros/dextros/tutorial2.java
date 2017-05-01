package dextros.dextros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class tutorial2 extends AppCompatActivity {
    List<Button> mButtons = new ArrayList();
    List<Integer> WEIGHT = new ArrayList();
    float x1, x2;
    float y1, y2;
    void DOTHETHING()
    {
        //List<Button> mButtons = new ArrayList();
        mButtons.add((Button)findViewById(R.id.button3));
        WEIGHT.add(0);
        mButtons.add((Button)findViewById(R.id.button4));
        WEIGHT.add(0);

        mButtons.get(0).setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent touchevent) {
                if (touchevent.getAction() == MotionEvent.ACTION_MOVE) {
                    int rick[] = new int[2];
                    int randy[] = new int[2];

                    boolean morty = false;

                    for(int jim = 0; jim < mButtons.size(); jim++ )
                    {
                        x1 = touchevent.getX();
                        y1 = touchevent.getY();
                        Log.d("LOOKATMEX", String.valueOf(x1));
                        Log.d("LOOKATMEY", String.valueOf(y1));
                        mButtons.get(jim).getLocationOnScreen(rick);
                        mButtons.get(1).getLocationOnScreen(randy);
                        x1 += rick[0];
                        y1 += rick[1];
                        Log.d("I AM THE WALRUS", String.valueOf(rick[0]));
                        Log.d("I AM THE WALRUS", String.valueOf(rick[1]));

                        if (x1 >= rick[0] && x1 <= (rick[0] + mButtons.get(0).getWidth()) && y1 >= rick[1] && y1 <= (rick[1] + mButtons.get(0).getHeight())) {
                            Log.d("I AM THE WALRUS", String.valueOf(0));
                            WEIGHT.set(0, (WEIGHT.get(0) + 1));
                        }
                        else if (x1 >= randy[0] && x1 <= (randy[0] + mButtons.get(1).getWidth()) && y1 >= randy[1] && y1 <= (randy[1] + mButtons.get(1).getHeight())) {
                            Log.d("I AM THE WALRUS", String.valueOf(1));
                            WEIGHT.set(1, (WEIGHT.get(1) + 1));
                        }
                    }
                    Log.d("BIRDPERSON", String.valueOf(WEIGHT.get(0)));
                    Log.d("BIRDPERSONSCOMPANION", String.valueOf(WEIGHT.get(1)));
                }
                else if (touchevent.getAction() == MotionEvent.ACTION_DOWN)
                {
                    WEIGHT.set(0, (WEIGHT.get(0)+1));
                }
                else if (touchevent.getAction() == MotionEvent.ACTION_UP)
                {
                    //datAlg();
                }
                return false;
            }
        });
        mButtons.get(1).setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent touchevent) {
                if (touchevent.getAction() == MotionEvent.ACTION_MOVE) {
                    int rick[] = new int[2];
                    int randy[] = new int[2];

                    boolean morty = false;

                    for(int jim = 0; jim < mButtons.size(); jim++ )
                    {
                        x1 = touchevent.getX();
                        y1 = touchevent.getY();
                        Log.d("LOOKATMEX", String.valueOf(x1));
                        Log.d("LOOKATMEY", String.valueOf(y1));
                        mButtons.get(jim).getLocationOnScreen(rick);
                        mButtons.get(0).getLocationOnScreen(randy);
                        x1 += rick[0];
                        y1 += rick[1];
                        Log.d("I AM THE WALRUS", String.valueOf(rick[0]));
                        Log.d("I AM THE WALRUS", String.valueOf(rick[1]));

                        if (x1 >= rick[0] && x1 <= (rick[0] + mButtons.get(1).getWidth()) && y1 >= rick[1] && y1 <= (rick[1] + mButtons.get(1).getHeight())) {
                            Log.d("I AM THE WALRUS", String.valueOf(0));
                            WEIGHT.set(1, (WEIGHT.get(1) + 1));
                        }
                        else if (x1 >= randy[0] && x1 <= (randy[0] + mButtons.get(0).getWidth()) && y1 >= randy[1] && y1 <= (randy[1] + mButtons.get(0).getHeight())) {
                            Log.d("I AM THE WALRUS", String.valueOf(1));
                            WEIGHT.set(0, (WEIGHT.get(0) + 1));
                        }
                    }
                    Log.d("BIRDPERSON", String.valueOf(WEIGHT.get(0)));
                    Log.d("BIRDPERSONSCOMPANION", String.valueOf(WEIGHT.get(1)));
                }
                else if (touchevent.getAction() == MotionEvent.ACTION_DOWN)
                {
                    WEIGHT.set(1, (WEIGHT.get(1)+1));
                }
                else if (touchevent.getAction() == MotionEvent.ACTION_UP)
                {
                    //datAlg();
                }
                return false;
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial2);
        DOTHETHING();
    }


    public void selectHighest()
    {
        int maxIter = 0;
        for (int i = 0; i < WEIGHT.size(); i++)
        {
            if(WEIGHT.get(i) > WEIGHT.get(maxIter))
            {
                maxIter = i;
            }
        }
        if( maxIter == 0)
        {
            ///GO TO NEXT
            //TextView view = (TextView) findViewById(R.id.errormessage);
            //view.setText("You have selected Button B, please try to swipe equally across A and B");
        }
        else
        {
            ///PRINT ERROR and possibly an explanation?
            //TextView view = (TextView) findViewById(R.id.errormessage);
            //view.setText("You have selected Button A, please try to swipe equally across A and B");
        }
    }
}
