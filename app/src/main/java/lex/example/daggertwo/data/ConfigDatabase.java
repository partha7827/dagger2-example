package lex.example.daggertwo.data;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by lex on 2/8/15.
 */

@Database(name = ConfigDatabase.NAME, version = ConfigDatabase.VERSION, foreignKeysSupported = true)
public class ConfigDatabase {

    public static final String NAME = "App";
    public static final int VERSION = 1;

}
