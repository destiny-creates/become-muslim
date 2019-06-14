package com.amplitude.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class DatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_EVENTS_TABLE = "CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);";
    private static final String CREATE_IDENTIFYS_TABLE = "CREATE TABLE IF NOT EXISTS identifys (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);";
    private static final String CREATE_LONG_STORE_TABLE = "CREATE TABLE IF NOT EXISTS long_store (key TEXT PRIMARY KEY NOT NULL, value INTEGER);";
    private static final String CREATE_STORE_TABLE = "CREATE TABLE IF NOT EXISTS store (key TEXT PRIMARY KEY NOT NULL, value TEXT);";
    private static final String EVENT_FIELD = "event";
    protected static final String EVENT_TABLE_NAME = "events";
    protected static final String IDENTIFY_TABLE_NAME = "identifys";
    private static final String ID_FIELD = "id";
    private static final String KEY_FIELD = "key";
    protected static final String LONG_STORE_TABLE_NAME = "long_store";
    protected static final String STORE_TABLE_NAME = "store";
    private static final String TAG = "com.amplitude.api.DatabaseHelper";
    private static final String VALUE_FIELD = "value";
    static final Map<String, DatabaseHelper> instances = new HashMap();
    private static final AmplitudeLog logger = AmplitudeLog.getLogger();
    private File file;
    private String instanceName;

    @Deprecated
    static DatabaseHelper getDatabaseHelper(Context context) {
        return getDatabaseHelper(context, null);
    }

    static synchronized DatabaseHelper getDatabaseHelper(Context context, String str) {
        DatabaseHelper databaseHelper;
        synchronized (DatabaseHelper.class) {
            str = Utils.normalizeInstanceName(str);
            databaseHelper = (DatabaseHelper) instances.get(str);
            if (databaseHelper == null) {
                databaseHelper = new DatabaseHelper(context.getApplicationContext(), str);
                instances.put(str, databaseHelper);
            }
        }
        return databaseHelper;
    }

    private static String getDatabaseName(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.equals(Constants.DEFAULT_INSTANCE)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("com.amplitude.api_");
                stringBuilder.append(str);
                return stringBuilder.toString();
            }
        }
        return "com.amplitude.api";
    }

    protected DatabaseHelper(Context context) {
        this(context, null);
    }

    protected DatabaseHelper(Context context, String str) {
        super(context, getDatabaseName(str), null, 3);
        this.file = context.getDatabasePath(getDatabaseName(str));
        this.instanceName = Utils.normalizeInstanceName(str);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_STORE_TABLE);
        sQLiteDatabase.execSQL(CREATE_LONG_STORE_TABLE);
        sQLiteDatabase.execSQL(CREATE_EVENTS_TABLE);
        sQLiteDatabase.execSQL(CREATE_IDENTIFYS_TABLE);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            logger.m3415e(TAG, "onUpgrade() with invalid oldVersion and newVersion");
            resetDatabase(sQLiteDatabase);
        } else if (i2 > 1) {
            switch (i) {
                case 1:
                    sQLiteDatabase.execSQL(CREATE_STORE_TABLE);
                    if (i2 <= 2) {
                        break;
                    }
                case 2:
                    sQLiteDatabase.execSQL(CREATE_IDENTIFYS_TABLE);
                    sQLiteDatabase.execSQL(CREATE_LONG_STORE_TABLE);
                    break;
                case 3:
                    break;
                default:
                    i2 = logger;
                    String str = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onUpgrade() with unknown oldVersion ");
                    stringBuilder.append(i);
                    i2.m3415e(str, stringBuilder.toString());
                    resetDatabase(sQLiteDatabase);
                    break;
            }
        }
    }

    private void resetDatabase(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS long_store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS identifys");
        onCreate(sQLiteDatabase);
    }

    synchronized long insertOrReplaceKeyValue(String str, String str2) {
        if (str2 == null) {
            str = deleteKeyFromTable(STORE_TABLE_NAME, str);
        } else {
            str = insertOrReplaceKeyValueToTable(STORE_TABLE_NAME, str, str2);
        }
        return str;
    }

    synchronized long insertOrReplaceKeyLongValue(String str, Long l) {
        if (l == null) {
            str = deleteKeyFromTable(LONG_STORE_TABLE_NAME, str);
        } else {
            str = insertOrReplaceKeyValueToTable(LONG_STORE_TABLE_NAME, str, l);
        }
        return str;
    }

    synchronized long insertOrReplaceKeyValueToTable(String str, String str2, Object obj) {
        long j;
        long j2;
        j = -1;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(KEY_FIELD, str2);
            if ((obj instanceof Long) != null) {
                contentValues.put(VALUE_FIELD, (Long) obj);
            } else {
                contentValues.put(VALUE_FIELD, (String) obj);
            }
            str2 = writableDatabase.insertWithOnConflict(str, null, contentValues, 5);
            if (str2 == -1) {
                try {
                    logger.m3421w(TAG, "Insert failed");
                } catch (SQLiteException e) {
                    j2 = str2;
                    str2 = e;
                    j = j2;
                    logger.m3416e(TAG, String.format("insertOrReplaceKeyValue in %s failed", new Object[]{str}), str2);
                    delete();
                    close();
                    return j;
                } catch (StackOverflowError e2) {
                    j2 = str2;
                    str2 = e2;
                    j = j2;
                    try {
                        logger.m3416e(TAG, String.format("insertOrReplaceKeyValue in %s failed", new Object[]{str}), str2);
                        delete();
                        close();
                        return j;
                    } catch (Throwable th) {
                        close();
                    }
                }
            }
            close();
            j = str2;
        } catch (SQLiteException e3) {
            str2 = e3;
            logger.m3416e(TAG, String.format("insertOrReplaceKeyValue in %s failed", new Object[]{str}), str2);
            delete();
            close();
            return j;
        } catch (StackOverflowError e4) {
            str2 = e4;
            logger.m3416e(TAG, String.format("insertOrReplaceKeyValue in %s failed", new Object[]{str}), str2);
            delete();
            close();
            return j;
        }
        return j;
    }

    synchronized long deleteKeyFromTable(String str, String str2) {
        long j;
        j = -1;
        try {
            j = (long) getWritableDatabase().delete(str, "key=?", new String[]{str2});
            close();
        } catch (String str22) {
            logger.m3416e(TAG, String.format("deleteKey from %s failed", new Object[]{str}), str22);
            delete();
            close();
            return j;
        } catch (String str222) {
            try {
                logger.m3416e(TAG, String.format("deleteKey from %s failed", new Object[]{str}), str222);
                delete();
                close();
                return j;
            } catch (Throwable th) {
                close();
            }
        }
        return j;
    }

    synchronized long addEvent(String str) {
        return addEventToTable(EVENT_TABLE_NAME, str);
    }

    synchronized long addIdentify(String str) {
        return addEventToTable(IDENTIFY_TABLE_NAME, str);
    }

    private synchronized long addEventToTable(String str, String str2) {
        long insert;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(EVENT_FIELD, str2);
            insert = writableDatabase.insert(str, null, contentValues);
            if (insert == -1) {
                try {
                    logger.m3421w(TAG, String.format("Insert into %s failed", new Object[]{str}));
                } catch (SQLiteException e) {
                    str2 = e;
                    logger.m3416e(TAG, String.format("addEvent to %s failed", new Object[]{str}), str2);
                    delete();
                    close();
                    return insert;
                } catch (StackOverflowError e2) {
                    str2 = e2;
                    try {
                        logger.m3416e(TAG, String.format("addEvent to %s failed", new Object[]{str}), str2);
                        delete();
                        close();
                        return insert;
                    } catch (Throwable th) {
                        close();
                    }
                }
            }
        } catch (SQLiteException e3) {
            str2 = e3;
            insert = -1;
            logger.m3416e(TAG, String.format("addEvent to %s failed", new Object[]{str}), str2);
            delete();
            close();
            return insert;
        } catch (StackOverflowError e4) {
            str2 = e4;
            insert = -1;
            logger.m3416e(TAG, String.format("addEvent to %s failed", new Object[]{str}), str2);
            delete();
            close();
            return insert;
        }
        close();
        return insert;
    }

    synchronized String getValue(String str) {
        return (String) getValueFromTable(STORE_TABLE_NAME, str);
    }

    synchronized Long getLongValue(String str) {
        return (Long) getValueFromTable(LONG_STORE_TABLE_NAME, str);
    }

    protected synchronized Object getValueFromTable(String str, String str2) {
        Object obj;
        Throwable e;
        obj = null;
        try {
            str2 = queryDb(getReadableDatabase(), str, new String[]{KEY_FIELD, VALUE_FIELD}, "key = ?", new String[]{str2}, null, null, null, null);
            try {
                if (str2.moveToFirst()) {
                    obj = str.equals(STORE_TABLE_NAME) ? str2.getString(1) : Long.valueOf(str2.getLong(1));
                }
                if (str2 != null) {
                    str2.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                logger.m3416e(TAG, String.format("getValue from %s failed", new Object[]{str}), e);
                delete();
                if (str2 != null) {
                    str2.close();
                }
                close();
                return obj;
            } catch (StackOverflowError e3) {
                e = e3;
                logger.m3416e(TAG, String.format("getValue from %s failed", new Object[]{str}), e);
                delete();
                if (str2 != null) {
                    str2.close();
                }
                close();
                return obj;
            } catch (RuntimeException e4) {
                str = e4;
                try {
                    convertIfCursorWindowException(str);
                    if (str2 != null) {
                        str2.close();
                    }
                    close();
                    return obj;
                } catch (Throwable th) {
                    str = th;
                    if (str2 != null) {
                        str2.close();
                    }
                    close();
                    throw str;
                }
            }
        } catch (SQLiteException e5) {
            e = e5;
            str2 = null;
            logger.m3416e(TAG, String.format("getValue from %s failed", new Object[]{str}), e);
            delete();
            if (str2 != null) {
                str2.close();
            }
            close();
            return obj;
        } catch (StackOverflowError e6) {
            e = e6;
            str2 = null;
            logger.m3416e(TAG, String.format("getValue from %s failed", new Object[]{str}), e);
            delete();
            if (str2 != null) {
                str2.close();
            }
            close();
            return obj;
        } catch (RuntimeException e7) {
            str = e7;
            str2 = null;
            convertIfCursorWindowException(str);
            if (str2 != null) {
                str2.close();
            }
            close();
            return obj;
        } catch (Throwable th2) {
            str = th2;
            str2 = null;
            if (str2 != null) {
                str2.close();
            }
            close();
            throw str;
        }
        close();
        return obj;
    }

    synchronized List<JSONObject> getEvents(long j, long j2) {
        return getEventsFromTable(EVENT_TABLE_NAME, j, j2);
    }

    synchronized List<JSONObject> getIdentifys(long j, long j2) {
        return getEventsFromTable(IDENTIFY_TABLE_NAME, j, j2);
    }

    protected synchronized List<JSONObject> getEventsFromTable(String str, long j, long j2) {
        List<JSONObject> linkedList;
        Throwable e;
        RuntimeException e2;
        long j3 = j;
        long j4 = j2;
        synchronized (this) {
            linkedList = new LinkedList();
            Cursor cursor = null;
            try {
                String stringBuilder;
                String stringBuilder2;
                SQLiteDatabase readableDatabase = getReadableDatabase();
                String[] strArr = new String[]{"id", EVENT_FIELD};
                if (j3 >= 0) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("id <= ");
                    stringBuilder3.append(j3);
                    stringBuilder = stringBuilder3.toString();
                } else {
                    stringBuilder = null;
                }
                String str2 = "id ASC";
                if (j4 >= 0) {
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("");
                    stringBuilder4.append(j4);
                    stringBuilder2 = stringBuilder4.toString();
                } else {
                    stringBuilder2 = null;
                }
                Cursor queryDb = queryDb(readableDatabase, str, strArr, stringBuilder, null, null, null, str2, stringBuilder2);
                while (queryDb.moveToNext()) {
                    try {
                        j4 = queryDb.getLong(0);
                        Object string = queryDb.getString(1);
                        if (!TextUtils.isEmpty(string)) {
                            JSONObject jSONObject = new JSONObject(string);
                            jSONObject.put("event_id", j4);
                            linkedList.add(jSONObject);
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                        cursor = queryDb;
                    } catch (StackOverflowError e4) {
                        e = e4;
                        cursor = queryDb;
                    } catch (RuntimeException e5) {
                        e2 = e5;
                        cursor = queryDb;
                    } catch (Throwable th) {
                        e = th;
                        cursor = queryDb;
                    }
                }
                if (queryDb != null) {
                    queryDb.close();
                }
            } catch (SQLiteException e6) {
                e = e6;
                logger.m3416e(TAG, String.format("getEvents from %s failed", new Object[]{str}), e);
                delete();
                if (cursor != null) {
                    cursor.close();
                }
                close();
                return linkedList;
            } catch (StackOverflowError e7) {
                e = e7;
                logger.m3416e(TAG, String.format("removeEvent from %s failed", new Object[]{str}), e);
                delete();
                if (cursor != null) {
                    cursor.close();
                }
                close();
                return linkedList;
            } catch (RuntimeException e8) {
                e2 = e8;
                try {
                    convertIfCursorWindowException(e2);
                    if (cursor != null) {
                        cursor.close();
                    }
                    close();
                    return linkedList;
                } catch (Throwable th2) {
                    e = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    close();
                    throw e;
                }
            }
            close();
        }
        return linkedList;
    }

    synchronized long getEventCount() {
        return getEventCountFromTable(EVENT_TABLE_NAME);
    }

    synchronized long getIdentifyCount() {
        return getEventCountFromTable(IDENTIFY_TABLE_NAME);
    }

    synchronized long getTotalEventCount() {
        return getEventCount() + getIdentifyCount();
    }

    private synchronized long getEventCountFromTable(String str) {
        long j;
        SQLiteStatement sQLiteStatement;
        Throwable th;
        j = 0;
        SQLiteStatement sQLiteStatement2 = null;
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT COUNT(*) FROM ");
            stringBuilder.append(str);
            SQLiteStatement compileStatement = readableDatabase.compileStatement(stringBuilder.toString());
            try {
                long simpleQueryForLong = compileStatement.simpleQueryForLong();
                if (compileStatement != null) {
                    compileStatement.close();
                }
                close();
                j = simpleQueryForLong;
            } catch (Throwable e) {
                sQLiteStatement = compileStatement;
                th = e;
                sQLiteStatement2 = sQLiteStatement;
                logger.m3416e(TAG, String.format("getNumberRows for %s failed", new Object[]{str}), th);
                delete();
                if (sQLiteStatement2 != null) {
                    sQLiteStatement2.close();
                }
                close();
                return j;
            } catch (Throwable e2) {
                sQLiteStatement = compileStatement;
                th = e2;
                sQLiteStatement2 = sQLiteStatement;
                try {
                    logger.m3416e(TAG, String.format("getNumberRows for %s failed", new Object[]{str}), th);
                    delete();
                    if (sQLiteStatement2 != null) {
                        sQLiteStatement2.close();
                    }
                    close();
                    return j;
                } catch (Throwable th2) {
                    str = th2;
                    if (sQLiteStatement2 != null) {
                        sQLiteStatement2.close();
                    }
                    close();
                    throw str;
                }
            } catch (Throwable th3) {
                str = th3;
                sQLiteStatement2 = compileStatement;
                if (sQLiteStatement2 != null) {
                    sQLiteStatement2.close();
                }
                close();
                throw str;
            }
        } catch (SQLiteException e3) {
            th = e3;
            logger.m3416e(TAG, String.format("getNumberRows for %s failed", new Object[]{str}), th);
            delete();
            if (sQLiteStatement2 != null) {
                sQLiteStatement2.close();
            }
            close();
            return j;
        } catch (StackOverflowError e4) {
            th = e4;
            logger.m3416e(TAG, String.format("getNumberRows for %s failed", new Object[]{str}), th);
            delete();
            if (sQLiteStatement2 != null) {
                sQLiteStatement2.close();
            }
            close();
            return j;
        }
        return j;
    }

    synchronized long getNthEventId(long j) {
        return getNthEventIdFromTable(EVENT_TABLE_NAME, j);
    }

    synchronized long getNthIdentifyId(long j) {
        return getNthEventIdFromTable(IDENTIFY_TABLE_NAME, j);
    }

    private synchronized long getNthEventIdFromTable(String str, long j) {
        long j2;
        Throwable e;
        SQLiteStatement sQLiteStatement = null;
        j2 = -1;
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT id FROM ");
            stringBuilder.append(str);
            stringBuilder.append(" LIMIT 1 OFFSET ");
            stringBuilder.append(j - 1);
            j = readableDatabase.compileStatement(stringBuilder.toString());
            try {
                j2 = j.simpleQueryForLong();
            } catch (Throwable e2) {
                try {
                    logger.m3423w(TAG, e2);
                } catch (SQLiteException e3) {
                    e2 = e3;
                    sQLiteStatement = j;
                    logger.m3416e(TAG, String.format("getNthEventId from %s failed", new Object[]{str}), e2);
                    delete();
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    close();
                    return j2;
                } catch (StackOverflowError e4) {
                    e2 = e4;
                    sQLiteStatement = j;
                    try {
                        logger.m3416e(TAG, String.format("getNthEventId from %s failed", new Object[]{str}), e2);
                        delete();
                        if (sQLiteStatement != null) {
                            sQLiteStatement.close();
                        }
                        close();
                        return j2;
                    } catch (Throwable th) {
                        str = th;
                        if (sQLiteStatement != null) {
                            sQLiteStatement.close();
                        }
                        close();
                        throw str;
                    }
                } catch (Throwable th2) {
                    str = th2;
                    sQLiteStatement = j;
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    close();
                    throw str;
                }
            }
            if (j != null) {
                j.close();
            }
        } catch (SQLiteException e5) {
            e2 = e5;
            logger.m3416e(TAG, String.format("getNthEventId from %s failed", new Object[]{str}), e2);
            delete();
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            close();
            return j2;
        } catch (StackOverflowError e6) {
            e2 = e6;
            logger.m3416e(TAG, String.format("getNthEventId from %s failed", new Object[]{str}), e2);
            delete();
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            close();
            return j2;
        }
        close();
        return j2;
    }

    synchronized void removeEvents(long j) {
        removeEventsFromTable(EVENT_TABLE_NAME, j);
    }

    synchronized void removeIdentifys(long j) {
        removeEventsFromTable(IDENTIFY_TABLE_NAME, j);
    }

    private synchronized void removeEventsFromTable(String str, long j) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("id <= ");
            stringBuilder.append(j);
            writableDatabase.delete(str, stringBuilder.toString(), null);
        } catch (long j2) {
            logger.m3416e(TAG, String.format("removeEvents from %s failed", new Object[]{str}), j2);
            delete();
        } catch (long j22) {
            try {
                logger.m3416e(TAG, String.format("removeEvents from %s failed", new Object[]{str}), j22);
                delete();
            } catch (Throwable th) {
                close();
            }
        }
        close();
    }

    synchronized void removeEvent(long j) {
        removeEventFromTable(EVENT_TABLE_NAME, j);
    }

    synchronized void removeIdentify(long j) {
        removeEventFromTable(IDENTIFY_TABLE_NAME, j);
    }

    private synchronized void removeEventFromTable(String str, long j) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("id = ");
            stringBuilder.append(j);
            writableDatabase.delete(str, stringBuilder.toString(), null);
        } catch (long j2) {
            logger.m3416e(TAG, String.format("removeEvent from %s failed", new Object[]{str}), j2);
            delete();
        } catch (long j22) {
            try {
                logger.m3416e(TAG, String.format("removeEvent from %s failed", new Object[]{str}), j22);
                delete();
            } catch (Throwable th) {
                close();
            }
        }
        close();
    }

    private void delete() {
        try {
            close();
            this.file.delete();
        } catch (Throwable e) {
            logger.m3416e(TAG, "delete failed", e);
        }
    }

    boolean dbFileExists() {
        return this.file.exists();
    }

    Cursor queryDb(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    private static void convertIfCursorWindowException(RuntimeException runtimeException) {
        String message = runtimeException.getMessage();
        if (TextUtils.isEmpty(message) || !message.startsWith("Cursor window allocation of")) {
            throw runtimeException;
        }
        throw new CursorWindowAllocationException(message);
    }
}
