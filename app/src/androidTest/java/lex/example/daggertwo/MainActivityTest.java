package lex.example.daggertwo;

import android.app.Application;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.LargeTest;

import lex.example.daggertwo.ui.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.Mockito.when;

@LargeTest
public class MainActivityTest extends BaseActivityTest<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override protected void setUp() throws Exception {
        super.setUp();

        getActivity();
    }

    public void testLoadNoteListFragmentSuccess() {
        onView(withId(R.id.noteListFragment)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}