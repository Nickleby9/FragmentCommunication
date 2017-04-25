package hilay.edu.fragmentcommunication;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment implements View.OnClickListener {

    public interface OnColorChangedListener {
        void onColorChanged(int color);
    }

    FrameLayout f;

    public ColorFragment() {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_color, container, false);

        f = (FrameLayout) v.findViewById(R.id.colorLayout);
        f.setOnClickListener(this);

        return v;
    }

    public static ColorFragment newInstance() {

        Bundle args = new Bundle();

        ColorFragment fragment = new ColorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnColorChangedListener){

        } else {
            Toast.makeText(context, "fragment tor attached well", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        Random r = new Random();
        int color = Color.rgb(
                r.nextInt(256), r.nextInt(256), r.nextInt(256));
        f.setBackgroundColor(color);

        OnColorChangedListener listener =
                (OnColorChangedListener) getActivity();
        listener.onColorChanged(color);
    }
}
