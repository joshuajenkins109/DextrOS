package dextros.dextros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

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




    public boolean onTouchEvent(MotionEvent touchevent)
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
        } //    c > x && c < (x + (width of)button)
        return false;
    }
}
