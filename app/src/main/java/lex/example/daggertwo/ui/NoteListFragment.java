package lex.example.daggertwo.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import lex.example.daggertwo.R;
import lex.example.daggertwo.data.Note;
import lex.example.daggertwo.ui.widget.DividerItemDecoration;

public class NoteListFragment extends BaseFragment {

    @InjectView(R.id.noteList) RecyclerView noteListView;

    NoteListAdapter noteListAdapter;

    public NoteListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        noteListAdapter = new NoteListAdapter(getActivity());
        noteListView.setAdapter(noteListAdapter);
        noteListView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        noteListView.setLayoutManager(layoutManager);
        noteListView.setItemAnimator(new DefaultItemAnimator());
        noteListView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
    }

    @Override public void onAttach(Activity activity) {
        super.onAttach(activity);
        /*try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public static class NoteListAdapter extends BaseAdapter {

        static List<Note> notes = new ArrayList<>();

        static final String TITLE_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
        static final String BODY_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer tellus " +
                "metus, venenatis semper tincidunt in, eleifend nec purus.";

        static {
            notes.add(new Note(TITLE_TEXT, BODY_TEXT, String.valueOf(System.currentTimeMillis())));
            notes.add(new Note(TITLE_TEXT, BODY_TEXT, String.valueOf(System.currentTimeMillis())));
            notes.add(new Note(TITLE_TEXT, BODY_TEXT, String.valueOf(System.currentTimeMillis())));
        }

        Context context;

        public NoteListAdapter(Context context) {
            super(context);

            this.context = context;
        }

        @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_row, parent, false);
            return new ViewHolder(v);
        }

        @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Note currentNote = notes.get(position);

            ((ViewHolder) holder).title.setText(currentNote.getTitle());

            ((ViewHolder) holder).created.setText(DateUtils.getRelativeTimeSpanString(context,
                    Long.valueOf(currentNote.getCreated()), false));

            if (currentNote.getBody() == null) {
                ((ViewHolder) holder).body.setVisibility(View.GONE);

            } else {
                ((ViewHolder) holder).body.setVisibility(View.VISIBLE);
                ((ViewHolder) holder).body.setText(currentNote.getBody());
            }
        }

        @Override public int getItemCount() {
            return notes.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {

            @InjectView(R.id.title) TextView title;
            @InjectView(R.id.created) TextView created;
            @InjectView(R.id.body) TextView body;

            public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.inject(this, itemView);
            }
        }
    }
}
