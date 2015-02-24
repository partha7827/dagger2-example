package lex.example.daggertwo;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by lex on 2/4/15.
 */
public class App extends Application {

    private static App instance;

    private AppGraph appGraph;

    @Override public void onCreate() {
        super.onCreate();

        instance = this;
        FlowManager.init(this);
        buildComponentAndInject();
    }

    @Override public void onTerminate() {
        super.onTerminate();

        FlowManager.destroy();
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
