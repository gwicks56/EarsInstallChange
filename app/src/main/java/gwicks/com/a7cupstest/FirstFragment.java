package gwicks.com.a7cupstest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gwicks on 20/01/2018.
 */

//No longer used, I moved the Intro to its own Activity


public class FirstFragment extends Fragment {

    private static final String TAG = "FirstFragment";

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser) {
//            ((SetupStepOne) getActivity()).updateStatusBarColor("#07dddd", this);
//            Log.d(TAG, "onCreateView: update coulour in : 2");
//
//        } else {
//            Log.d(TAG, "setUserVisibleHint: in else");
//        }
//    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.setup_step_one, container, false);
        //((SetupStepOne)getActivity()).updateStatusBarColor("#07dddd", this);
        Log.d(TAG, "onCreateView: update coulour in : 1");



        return v;
    }

    public static FirstFragment newInstance(String text) {

        Log.d(TAG, "newInstance: first");

        FirstFragment f = new FirstFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}