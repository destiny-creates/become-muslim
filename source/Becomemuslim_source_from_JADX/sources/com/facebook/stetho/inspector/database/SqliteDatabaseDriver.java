package com.facebook.stetho.inspector.database;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.protocol.module.Database.DatabaseDriver;
import com.facebook.stetho.inspector.protocol.module.Database.DatabaseDriver.ExecuteResultHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SqliteDatabaseDriver extends DatabaseDriver {
    private static final String[] UNINTERESTING_FILENAME_SUFFIXES = new String[]{"-journal", "-shm", "-uid", "-wal"};
    private final DatabaseFilesProvider mDatabaseFilesProvider;
    private List<String> mDatabases;

    @Deprecated
    public SqliteDatabaseDriver(Context context) {
        this(context, new DefaultDatabaseFilesProvider(context));
    }

    public SqliteDatabaseDriver(Context context, DatabaseFilesProvider databaseFilesProvider) {
        super(context);
        this.mDatabaseFilesProvider = databaseFilesProvider;
    }

    public List<String> getDatabaseNames() {
        if (this.mDatabases == null) {
            this.mDatabases = new ArrayList();
            List databaseFiles = this.mDatabaseFilesProvider.getDatabaseFiles();
            Collections.sort(databaseFiles);
            for (File name : tidyDatabaseList(databaseFiles)) {
                this.mDatabases.add(name.getName());
            }
        }
        return this.mDatabases;
    }

    static List<File> tidyDatabaseList(List<File> list) {
        Set hashSet = new HashSet(list);
        List<File> arrayList = new ArrayList();
        for (File file : list) {
            String path = file.getPath();
            String removeSuffix = removeSuffix(path, UNINTERESTING_FILENAME_SUFFIXES);
            if (removeSuffix.equals(path) || !hashSet.contains(new File(removeSuffix))) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    private static String removeSuffix(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.endsWith(str2)) {
                return str.substring(0, str.length() - str2.length());
            }
        }
        return str;
    }

    public List<String> getTableNames(String str) {
        str = openDatabase(str);
        Cursor rawQuery;
        try {
            rawQuery = str.rawQuery("SELECT name FROM sqlite_master WHERE type IN (?, ?)", new String[]{"table", "view"});
            List<String> arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(0));
            }
            rawQuery.close();
            str.close();
            return arrayList;
        } catch (Throwable th) {
            str.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse executeSQL(java.lang.String r4, java.lang.String r5, com.facebook.stetho.inspector.protocol.module.Database.DatabaseDriver.ExecuteResultHandler<com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse> r6) {
        /*
        r3 = this;
        com.facebook.stetho.common.Util.throwIfNull(r5);
        com.facebook.stetho.common.Util.throwIfNull(r6);
        r4 = r3.openDatabase(r4);
        r0 = getFirstWord(r5);	 Catch:{ all -> 0x0082 }
        r0 = r0.toUpperCase();	 Catch:{ all -> 0x0082 }
        r1 = -1;
        r2 = r0.hashCode();	 Catch:{ all -> 0x0082 }
        switch(r2) {
            case -2130463047: goto L_0x004d;
            case -1926899396: goto L_0x0043;
            case -1852692228: goto L_0x0039;
            case -1785516855: goto L_0x002f;
            case -591179561: goto L_0x0025;
            case 2012838315: goto L_0x001b;
            default: goto L_0x001a;
        };	 Catch:{ all -> 0x0082 }
    L_0x001a:
        goto L_0x0056;
    L_0x001b:
        r2 = "DELETE";
        r0 = r0.equals(r2);	 Catch:{ all -> 0x0082 }
        if (r0 == 0) goto L_0x0056;
    L_0x0023:
        r1 = 1;
        goto L_0x0056;
    L_0x0025:
        r2 = "EXPLAIN";
        r0 = r0.equals(r2);	 Catch:{ all -> 0x0082 }
        if (r0 == 0) goto L_0x0056;
    L_0x002d:
        r1 = 5;
        goto L_0x0056;
    L_0x002f:
        r2 = "UPDATE";
        r0 = r0.equals(r2);	 Catch:{ all -> 0x0082 }
        if (r0 == 0) goto L_0x0056;
    L_0x0037:
        r1 = 0;
        goto L_0x0056;
    L_0x0039:
        r2 = "SELECT";
        r0 = r0.equals(r2);	 Catch:{ all -> 0x0082 }
        if (r0 == 0) goto L_0x0056;
    L_0x0041:
        r1 = 3;
        goto L_0x0056;
    L_0x0043:
        r2 = "PRAGMA";
        r0 = r0.equals(r2);	 Catch:{ all -> 0x0082 }
        if (r0 == 0) goto L_0x0056;
    L_0x004b:
        r1 = 4;
        goto L_0x0056;
    L_0x004d:
        r2 = "INSERT";
        r0 = r0.equals(r2);	 Catch:{ all -> 0x0082 }
        if (r0 == 0) goto L_0x0056;
    L_0x0055:
        r1 = 2;
    L_0x0056:
        switch(r1) {
            case 0: goto L_0x0072;
            case 1: goto L_0x0072;
            case 2: goto L_0x0068;
            case 3: goto L_0x005e;
            case 4: goto L_0x005e;
            case 5: goto L_0x005e;
            default: goto L_0x0059;
        };	 Catch:{ all -> 0x0082 }
    L_0x0059:
        r5 = r3.executeRawQuery(r4, r5, r6);	 Catch:{ all -> 0x0082 }
        goto L_0x007c;
    L_0x005e:
        r5 = r3.executeSelect(r4, r5, r6);	 Catch:{ all -> 0x0082 }
        r5 = (com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse) r5;	 Catch:{ all -> 0x0082 }
        r4.close();
        return r5;
    L_0x0068:
        r5 = r3.executeInsert(r4, r5, r6);	 Catch:{ all -> 0x0082 }
        r5 = (com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse) r5;	 Catch:{ all -> 0x0082 }
        r4.close();
        return r5;
    L_0x0072:
        r5 = r3.executeUpdateDelete(r4, r5, r6);	 Catch:{ all -> 0x0082 }
        r5 = (com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse) r5;	 Catch:{ all -> 0x0082 }
        r4.close();
        return r5;
    L_0x007c:
        r5 = (com.facebook.stetho.inspector.protocol.module.Database.ExecuteSQLResponse) r5;	 Catch:{ all -> 0x0082 }
        r4.close();
        return r5;
    L_0x0082:
        r5 = move-exception;
        r4.close();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.inspector.database.SqliteDatabaseDriver.executeSQL(java.lang.String, java.lang.String, com.facebook.stetho.inspector.protocol.module.Database$DatabaseDriver$ExecuteResultHandler):com.facebook.stetho.inspector.protocol.module.Database$ExecuteSQLResponse");
    }

    private static String getFirstWord(String str) {
        str = str.trim();
        int indexOf = str.indexOf(32);
        return indexOf >= 0 ? str.substring(0, indexOf) : str;
    }

    @TargetApi(11)
    private <T> T executeUpdateDelete(SQLiteDatabase sQLiteDatabase, String str, ExecuteResultHandler<T> executeResultHandler) {
        return executeResultHandler.handleUpdateDelete(sQLiteDatabase.compileStatement(str).executeUpdateDelete());
    }

    private <T> T executeInsert(SQLiteDatabase sQLiteDatabase, String str, ExecuteResultHandler<T> executeResultHandler) {
        return executeResultHandler.handleInsert(sQLiteDatabase.compileStatement(str).executeInsert());
    }

    private <T> T executeSelect(SQLiteDatabase sQLiteDatabase, String str, ExecuteResultHandler<T> executeResultHandler) {
        sQLiteDatabase = sQLiteDatabase.rawQuery(str, null);
        try {
            str = executeResultHandler.handleSelect(sQLiteDatabase);
            return str;
        } finally {
            sQLiteDatabase.close();
        }
    }

    private <T> T executeRawQuery(SQLiteDatabase sQLiteDatabase, String str, ExecuteResultHandler<T> executeResultHandler) {
        sQLiteDatabase.execSQL(str);
        return executeResultHandler.handleRawQuery();
    }

    private SQLiteDatabase openDatabase(String str) {
        Util.throwIfNull(str);
        return SQLiteDatabase.openDatabase(this.mContext.getDatabasePath(str).getAbsolutePath(), null, 0);
    }
}
