package lex.example.daggertwo;

import android.test.ActivityInstrumentationTestCase2;

import lex.example.daggertwo.ui.BaseActivity;

/**
 * Created by lex on 2/23/15.
 */
public abstract class BaseActivityTest<T extends BaseActivity> extends ActivityInstrumentationTestCase2<T> {

    public BaseActivityTest(Class<T> activityClass) {
        super(activityClass);
    }

    @Override protected void setUp() throws Exception {
        super.setUp();

        App app = (App) getInstrumentation().getTargetContext().getApplicationContext();
        //app.getAppGraph().inject(this);
    }

    @Override protected void tearDown() throws Exception {
        super.tearDown();
    }
}
