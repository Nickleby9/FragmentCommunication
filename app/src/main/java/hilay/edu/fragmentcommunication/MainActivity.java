package hilay.edu.fragmentcommunication;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements ColorFragment.OnColorChangedListener,
        TextFragment.OnTextChangedListener {

    FrameLayout f1, f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f1 = (FrameLayout) findViewById(R.id.frameLayout);
        f2 = (FrameLayout) findViewById(R.id.frameLayout2);

        getSupportFragmentManager().beginTransaction().replace(
                R.id.frameLayout, new ColorFragment(), "colorFrag").commit();
        getSupportFragmentManager().beginTransaction().replace(
                R.id.frameLayout2, new TextFragment(), "textFrag").commit();
    }

    @Override
    public void onColorChanged(int color) {
//        Toast.makeText(this, "Color: " + color, Toast.LENGTH_SHORT).show();
        Fragment colorFrag = getSupportFragmentManager()
                .findFragmentByTag("colorFrag");
        if (colorFrag != null){
            Fragment textFrag = getSupportFragmentManager()
                    .findFragmentByTag("textFrag");
            if (textFrag != null) {

                TextFragment tf = (TextFragment) textFrag;
                tf.setBackgroundColor(color);

//                View v = textFrag.getView();
//                TextView tv = (TextView) v.findViewById(R.id.tvText);
//                tv.setTextColor(color);

            }
        }
    }

    @Override
    public void onTextChanged(String text) {

    }
}
