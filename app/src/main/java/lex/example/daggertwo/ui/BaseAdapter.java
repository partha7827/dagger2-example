package lex.example.daggertwo.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import lex.example.daggertwo.App;

/**
 * Created by lex on 2/7/15.
 */
public abstract class BaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public BaseAdapter(Context context) {
        App.getInstance().getAppGraph().inject(this);
    }
}
