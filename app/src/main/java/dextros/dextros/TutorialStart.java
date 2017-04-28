package dextros.dextros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.max;
import static android.R.attr.x;
import static dextros.dextros.R.layout.activity_tutorial_start;

public class TutorialStart extends AppCompatActivity {

    float x1, x2;
    float y1, y2;

    //float weight[] = new float[];
    //getx gety
    List<Button> mButtons = new ArrayList();
    List<Integer> WEIGHT = new ArrayList();
    void DOTHETHING()
    {
        //List<Button> mButtons = new ArrayList();
        mButtons.add((Button)findViewById(R.id.button));
        WEIGHT.add(0);
        mButtons.add((Button)findViewById(R.id.button2));
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
                else if (touchevent.getAction() == MotionEvent.ACTION_UP)
                {
                    datAlg();
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
                else if (touchevent.getAction() == MotionEvent.ACTION_UP)
                {
                    datAlg();
                }
                return false;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_tutorial_start);
        DOTHETHING();


        //getAllButtons( ((ViewGroup)getCurrentFocus() ));
    }

    /*List<Button> mButtons = new ArrayList();

    void getAllButtons(ViewGroup v) {
        for (int i = 0; i < v.getChildCount(); i++) {
            View child = v.getChildAt(i);
            if(child instanceof ViewGroup)
                getAllButtons((ViewGroup)child);
            else if(child instanceof Button)
                mButtons.add((Button)child);
        }
    }*/
    public int abs( int number)
    {
        if( number < 0)
            return -1 * number;
        else
            return number;
    }

    public void datAlg()
    {
        boolean relativeTie = false;
        int maxIter = 0;
        int tieIter = 0;
        for (int i = 0; i < WEIGHT.size(); i++)
        {
            if(WEIGHT.get(i) > WEIGHT.get(maxIter))
            {
                maxIter = i;
            }
        }
        if( (abs(WEIGHT.get(0) - WEIGHT.get(1)) <= 50) && (WEIGHT.get(0) != 0 && WEIGHT.get(1) != 0 ) )
        {
            relativeTie = true;
        }
       // Log.d("RandyDandy", String.valueOf(relativeTie));


        ////////
        /// TO DO
        //////  case:   both 0     : do nothing
        /////   case:  one zero ( or only 1 button that has weight) :   click button
        /////   case: button weight isnt close, but the lesser weight is still above a certain value

        if( relativeTie)
        {
            Intent intent = new Intent(this, tutorial2.class);
            startActivity(intent);
        }
        else if( WEIGHT.get(0) != 0 || WEIGHT.get(1) != 0)
        {
            if( maxIter == 0)
            {
                TextView view = (TextView) findViewById(R.id.errormessage);
                view.setText("You have selected Button B, please try to swipe equally across A and B");
            }
            else
            {
                TextView view = (TextView) findViewById(R.id.errormessage);
                view.setText("You have selected Button A, please try to swipe equally across A and B");
            }
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
                //Button radbutton = (Button) findViewById(R.id.skiptutorial);
                int rick[] = new int[2];
                //radbutton.getLocationOnScreen(rick);
                //Log.d("BIRDPERSON1", String.valueOf(rick[0]) );
               // Log.d("BIRDPERSON2", String.valueOf(rick[1]) );

                //for( int ac = 0; ac < mButtons.size(); ac++) {
                //mButtons.get(1).getLocationOnScreen(rick);
                //Log.d("SHOWMEWHATYOUGOT", String.valueOf(rick[0]));
                //Log.d("SHOWMEWHATYOUGOT", String.valueOf(rick[1]));

                boolean morty = false;

                for(int jim = 0; jim < mButtons.size(); jim++ )
                {
                    mButtons.get(jim).getLocationOnScreen(rick);
                    if (x1 >= rick[0] && x1 <= (rick[0] + mButtons.get(jim).getWidth()) && y1 >= rick[1] && y1 <= (rick[1] + mButtons.get(jim).getHeight())) {
                        WEIGHT.set(jim, (WEIGHT.get(jim) + 1));
                    }
                    //Log.d("BIRDPERSON", String.valueOf(morty));
                }
                Log.d("BIRDPERSON", String.valueOf(WEIGHT.get(0)));
                Log.d("BIRDPERSONSCOMPANION", String.valueOf(WEIGHT.get(1)));


                //}
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                datAlg();
                break;
            }
        } //    c > x && c < (x + (width of)button)
        return false;
    }
}
