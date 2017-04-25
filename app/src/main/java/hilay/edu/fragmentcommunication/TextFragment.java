package hilay.edu.fragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnTextChangedListener} interface
 * to handle interaction events.
 */
public class TextFragment extends Fragment {

    TextView tvText;

    private OnTextChangedListener mListener;
    private int backgroundColor;

    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_text, container, false);
        tvText = (TextView) v.findViewById(R.id.tvText);

        return v;
    }

    public void onTextChanged(String text) {
        if (mListener != null) {
            mListener.onTextChanged(text);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTextChangedListener) {
            mListener = (OnTextChangedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnTextChangedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        tvText.setTextColor(backgroundColor);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnTextChangedListener {
        void onTextChanged(String text);
    }
}
