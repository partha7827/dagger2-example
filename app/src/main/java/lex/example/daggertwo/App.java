package lex.example.daggertwo;

import android.app.Application;

/**
 * Created by lex on 2/4/15.
 */
public class App extends Application {

    private static App instance;

    private AppGraph appGraph;

    @Override public void onCreate() {
        super.onCreate();

        instance = this;
        buildComponentAndInject();
    }

    public static App getInstance() {
        return instance;
    }

    private void buildComponentAndInject() {
        appGraph = AppGraph.Initializer.init(this);
    }

    public AppGraph getAppGraph() {
        return appGraph;
    }
}
