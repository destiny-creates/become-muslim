package com.facebook.stetho.inspector.database;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class DefaultDatabaseFilesProvider implements DatabaseFilesProvider {
    private final Context mContext;

    public DefaultDatabaseFilesProvider(Context context) {
        this.mContext = context;
    }

    public List<File> getDatabaseFiles() {
        List<File> arrayList = new ArrayList();
        for (String file : this.mContext.databaseList()) {
            arrayList.add(new File(file));
        }
        return arrayList;
    }
}
