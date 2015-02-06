package lex.example.daggertwo.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import javax.inject.Inject;

import lex.example.daggertwo.App;

/**
 * Created by lex on 2/4/15.
 */

public abstract class BaseActivity extends ActionBarActivity {

    @Inject SharedPreferences sharedPreferences;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getInstance().getAppGraph().inject(this);
    }
}

