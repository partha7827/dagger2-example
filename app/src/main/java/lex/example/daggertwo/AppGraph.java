package lex.example.daggertwo;

import javax.inject.Singleton;

import dagger.Component;
import lex.example.daggertwo.ui.BaseActivity;

/**
 * Created by lex on 2/4/15.
 */

@Singleton
@Component(modules = {SystemServicesModule.class})
public interface AppGraph {

    void inject(BaseActivity activity);

    public final static class Initializer {

        public static AppGraph init(App app) {
            return Dagger_AppGraph.builder()
                    .systemServicesModule(new SystemServicesModule(app))
                    .build();
        }

    }
}
