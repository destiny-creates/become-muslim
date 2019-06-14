package versioned.host.exp.exponent.modules.api;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import host.exp.exponent.p346j.C6385c;
import host.exp.exponent.p346j.C6393j;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SQLiteModule extends ReactContextBaseJavaModule {
    private static final Map<String, SQLiteDatabase> DATABASES = new HashMap();
    private static final boolean DEBUG_MODE = false;
    private static final String[] EMPTY_COLUMNS = new String[0];
    private static final SQLitePluginResult EMPTY_RESULT = new SQLitePluginResult(EMPTY_ROWS, EMPTY_COLUMNS, 0, 0, null);
    private static final Object[][] EMPTY_ROWS = new Object[0][];
    private static final String TAG = "SQLiteModule";
    private C6393j mScopedContext;

    private static class ReadOnlyException extends Exception {
        public ReadOnlyException() {
            super("could not prepare statement (23 not authorized)");
        }
    }

    private static class SQLitePluginResult {
        public final String[] columns;
        public final Throwable error;
        public final long insertId;
        public final Object[][] rows;
        public final int rowsAffected;

        public SQLitePluginResult(Object[][] objArr, String[] strArr, int i, long j, Throwable th) {
            this.rows = objArr;
            this.columns = strArr;
            this.rowsAffected = i;
            this.insertId = j;
            this.error = th;
        }
    }

    public String getName() {
        return "ExponentSQLite";
    }

    public SQLiteModule(ReactApplicationContext reactApplicationContext, C6393j c6393j) {
        super(reactApplicationContext);
        this.mScopedContext = c6393j;
    }

    private Handler createBackgroundHandler() {
        HandlerThread handlerThread = new HandlerThread("SQLitePlugin BG Thread");
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }

    @ReactMethod
    public void exec(String str, ReadableArray readableArray, Boolean bool, Promise promise) {
        SQLiteModule sQLiteModule = this;
        Promise promise2 = promise;
        try {
            int size = readableArray.size();
            SQLitePluginResult[] sQLitePluginResultArr = new SQLitePluginResult[size];
            SQLiteDatabase database = getDatabase(str);
            for (int i = 0; i < size; i++) {
                ReadableArray array = readableArray.getArray(i);
                String string = array.getString(0);
                String[] convertParamsToStringArray = convertParamsToStringArray(array.getArray(1));
                try {
                    if (isSelect(string)) {
                        sQLitePluginResultArr[i] = doSelectInBackgroundAndPossiblyThrow(string, convertParamsToStringArray, database);
                    } else if (bool.booleanValue()) {
                        sQLitePluginResultArr[i] = new SQLitePluginResult(EMPTY_ROWS, EMPTY_COLUMNS, 0, 0, new ReadOnlyException());
                    } else {
                        sQLitePluginResultArr[i] = doUpdateInBackgroundAndPossiblyThrow(string, convertParamsToStringArray, database);
                    }
                } catch (Throwable th) {
                    sQLitePluginResultArr[i] = new SQLitePluginResult(EMPTY_ROWS, EMPTY_COLUMNS, 0, 0, th);
                }
            }
            promise2.resolve(pluginResultsToPrimitiveData(sQLitePluginResultArr));
        } catch (Throwable th2) {
            promise2.reject("SQLiteError", th2);
        }
    }

    @ReactMethod
    public void close(String str) {
        DATABASES.remove(str);
    }

    private SQLitePluginResult doUpdateInBackgroundAndPossiblyThrow(String str, String[] strArr, SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase = sQLiteDatabase.compileStatement(str);
            if (strArr != null) {
                try {
                    for (int length = strArr.length; length != 0; length--) {
                        int i = length - 1;
                        if (strArr[i] == null) {
                            sQLiteDatabase.bindNull(length);
                        } else {
                            sQLiteDatabase.bindString(length, strArr[i]);
                        }
                    }
                } catch (Throwable th) {
                    str = th;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw str;
                }
            }
            String sQLitePluginResult;
            if (isInsert(str) != null) {
                long executeInsert = sQLiteDatabase.executeInsert();
                sQLitePluginResult = new SQLitePluginResult(EMPTY_ROWS, EMPTY_COLUMNS, executeInsert >= null ? 1 : 0, executeInsert, null);
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return sQLitePluginResult;
            }
            if (isDelete(str) == null) {
                if (isUpdate(str) == null) {
                    sQLiteDatabase.execute();
                    str = EMPTY_RESULT;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return str;
                }
            }
            sQLitePluginResult = new SQLitePluginResult(EMPTY_ROWS, EMPTY_COLUMNS, sQLiteDatabase.executeUpdateDelete(), 0, null);
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            return sQLitePluginResult;
        } catch (Throwable th2) {
            str = th2;
            sQLiteDatabase = null;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            throw str;
        }
    }

    private SQLitePluginResult doSelectInBackgroundAndPossiblyThrow(String str, String[] strArr, SQLiteDatabase sQLiteDatabase) {
        try {
            str = sQLiteDatabase.rawQuery(str, strArr);
            try {
                strArr = str.getCount();
                if (strArr == null) {
                    strArr = EMPTY_RESULT;
                    if (str != null) {
                        str.close();
                    }
                    return strArr;
                }
                sQLiteDatabase = str.getColumnCount();
                Object[][] objArr = new Object[strArr][];
                String[] columnNames = str.getColumnNames();
                int i = 0;
                while (str.moveToNext()) {
                    Object[] objArr2 = new Object[sQLiteDatabase];
                    for (int i2 = 0; i2 < sQLiteDatabase; i2++) {
                        objArr2[i2] = getValueFromCursor(str, i2, str.getType(i2));
                    }
                    objArr[i] = objArr2;
                    i++;
                }
                SQLitePluginResult sQLitePluginResult = new SQLitePluginResult(objArr, columnNames, 0, 0, null);
                if (str != null) {
                    str.close();
                }
                return sQLitePluginResult;
            } catch (Throwable th) {
                strArr = th;
                if (str != null) {
                    str.close();
                }
                throw strArr;
            }
        } catch (Throwable th2) {
            strArr = th2;
            str = null;
            if (str != null) {
                str.close();
            }
            throw strArr;
        }
    }

    private Object getValueFromCursor(Cursor cursor, int i, int i2) {
        switch (i2) {
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                return new String(cursor.getBlob(i));
            default:
                return null;
        }
    }

    private String pathForDatabaseName(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mScopedContext.getFilesDir());
        stringBuilder.append(File.separator);
        stringBuilder.append("SQLite");
        File file = new File(stringBuilder.toString());
        C6385c.m26196c(file);
        stringBuilder = new StringBuilder();
        stringBuilder.append(file);
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private SQLiteDatabase getDatabase(String str) {
        String pathForDatabaseName = pathForDatabaseName(str);
        SQLiteDatabase sQLiteDatabase = new File(pathForDatabaseName).exists() ? (SQLiteDatabase) DATABASES.get(str) : null;
        if (sQLiteDatabase != null) {
            return sQLiteDatabase;
        }
        DATABASES.remove(str);
        sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(pathForDatabaseName, null);
        DATABASES.put(str, sQLiteDatabase);
        return sQLiteDatabase;
    }

    private static NativeArray pluginResultsToPrimitiveData(SQLitePluginResult[] sQLitePluginResultArr) {
        NativeArray writableNativeArray = new WritableNativeArray();
        for (SQLitePluginResult convertPluginResultToArray : sQLitePluginResultArr) {
            writableNativeArray.pushArray(convertPluginResultToArray(convertPluginResultToArray));
        }
        return writableNativeArray;
    }

    private static WritableNativeArray convertPluginResultToArray(SQLitePluginResult sQLitePluginResult) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        if (sQLitePluginResult.error != null) {
            writableNativeArray.pushString(sQLitePluginResult.error.getMessage());
        } else {
            writableNativeArray.pushNull();
        }
        writableNativeArray.pushInt((int) sQLitePluginResult.insertId);
        writableNativeArray.pushInt(sQLitePluginResult.rowsAffected);
        WritableArray writableNativeArray2 = new WritableNativeArray();
        for (String pushString : sQLitePluginResult.columns) {
            writableNativeArray2.pushString(pushString);
        }
        writableNativeArray.pushArray(writableNativeArray2);
        writableNativeArray2 = new WritableNativeArray();
        for (Object[] objArr : sQLitePluginResult.rows) {
            WritableArray writableNativeArray3 = new WritableNativeArray();
            for (Object obj : objArr) {
                if (obj == null) {
                    writableNativeArray3.pushNull();
                } else if (obj instanceof String) {
                    writableNativeArray3.pushString((String) obj);
                } else if (obj instanceof Boolean) {
                    writableNativeArray3.pushBoolean(((Boolean) obj).booleanValue());
                } else {
                    writableNativeArray3.pushDouble(((Number) obj).doubleValue());
                }
            }
            writableNativeArray2.pushArray(writableNativeArray3);
        }
        writableNativeArray.pushArray(writableNativeArray2);
        return writableNativeArray;
    }

    private static boolean isSelect(String str) {
        if (!startsWithCaseInsensitive(str, "select")) {
            if (startsWithCaseInsensitive(str, "pragma") == null) {
                return null;
            }
        }
        return true;
    }

    private static boolean isInsert(String str) {
        return startsWithCaseInsensitive(str, "insert");
    }

    private static boolean isUpdate(String str) {
        return startsWithCaseInsensitive(str, "update");
    }

    private static boolean isDelete(String str) {
        return startsWithCaseInsensitive(str, "delete");
    }

    private static boolean startsWithCaseInsensitive(String str, String str2) {
        int length = str.length();
        int i = -1;
        int i2 = -1;
        do {
            i2++;
            if (i2 >= length) {
                break;
            }
        } while (Character.isWhitespace(str.charAt(i2)));
        int length2 = str2.length();
        int i3;
        do {
            i++;
            if (i >= length2) {
                return true;
            }
            i3 = i + i2;
            if (i3 >= length) {
                return false;
            }
        } while (Character.toLowerCase(str.charAt(i3)) == str2.charAt(i));
        return false;
    }

    private static String[] convertParamsToStringArray(ReadableArray readableArray) {
        int size = readableArray.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            ReadableType type = readableArray.getType(i);
            if (type == ReadableType.String) {
                strArr[i] = unescapeBlob(readableArray.getString(i));
            } else if (type == ReadableType.Boolean) {
                strArr[i] = readableArray.getBoolean(i) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES;
            } else if (type == ReadableType.Null) {
                strArr[i] = null;
            } else if (type == ReadableType.Number) {
                strArr[i] = Double.toString(readableArray.getDouble(i));
            }
        }
        return strArr;
    }

    private static String unescapeBlob(String str) {
        return str.replaceAll("\u0001\u0001", "\u0000").replaceAll("\u0001\u0002", "\u0001").replaceAll("\u0002\u0002", "\u0002");
    }
}
