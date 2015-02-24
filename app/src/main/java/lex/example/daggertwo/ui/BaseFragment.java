package lex.example.daggertwo.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import lex.example.daggertwo.App;

/**
 * Created by lex on 2/6/15.
 */
public class BaseFragment extends Fragment {

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getInstance().getAppGraph().inject(this);
    }
}
