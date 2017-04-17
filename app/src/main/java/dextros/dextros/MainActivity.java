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


public class MainActivity extends AppCompatActivity {

    float x1, x2;
    float y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    // Example of a call to a native method
    TextView tv = (TextView) findViewById(R.id.greeting);
    //tv.setText(stringFromJNI());
        Button button = (Button) findViewById(R.id.nextpagebutton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                goToTutorialStart();
            }
        });

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    private void goToTutorialStart(){
        Intent intent = new Intent(this, TutorialStart.class);
        startActivity(intent);
    }

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
                Button radbutton = (Button) findViewById(R.id.skiptutorial);
                int rick[] = new int[2];
                radbutton.getLocationOnScreen(rick);
                Log.d("BIRDPERSON1", String.valueOf(rick[0]) );
                Log.d("BIRDPERSON2", String.valueOf(rick[1]) );

                break;
            }
        } //    c > x && c < (x + (width of)button)
        return false;
    }
}
