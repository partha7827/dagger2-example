package lex.example.daggertwo;

import javax.inject.Singleton;

import dagger.Component;
import lex.example.daggertwo.ui.BaseActivity;
import lex.example.daggertwo.ui.BaseAdapter;
import lex.example.daggertwo.ui.BaseFragment;

/**
 * Created by lex on 2/4/15.
 */

@Singleton
@Component(modules = {SystemServicesModule.class})
public interface AppGraph {

    void inject(BaseActivity activity);

    void inject(BaseFragment fragment);

    void inject(BaseAdapter adapter);

    //void inject(BaseActivityTest test);

    public final static class Initializer {

        public static AppGraph init(App app) {
            return Dagger_AppGraph.builder()
                    .systemServicesModule(new SystemServicesModule(app))
                    .build();
        }

    }
}
