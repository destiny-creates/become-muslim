package com.facebook.react.modules.storage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONObject;

public class AsyncLocalStorageUtil {
    static String buildKeySelection(int i) {
        i = new String[i];
        Arrays.fill(i, "?");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ReactDatabaseSupplier.KEY_COLUMN);
        stringBuilder.append(" IN (");
        stringBuilder.append(TextUtils.join(", ", i));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    static String[] buildKeySelectionArgs(ReadableArray readableArray, int i, int i2) {
        String[] strArr = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            strArr[i3] = readableArray.getString(i + i3);
        }
        return strArr;
    }

    public static String getItemImpl(SQLiteDatabase sQLiteDatabase, String str) {
        String[] strArr = new String[]{ReactDatabaseSupplier.VALUE_COLUMN};
        String[] strArr2 = new String[]{str};
        String str2 = ReactDatabaseSupplier.TABLE_CATALYST;
        str = new StringBuilder();
        str.append(ReactDatabaseSupplier.KEY_COLUMN);
        str.append("=?");
        sQLiteDatabase = sQLiteDatabase.query(str2, strArr, str.toString(), strArr2, null, null, null);
        try {
            if (sQLiteDatabase.moveToFirst() == null) {
                return null;
            }
            str = sQLiteDatabase.getString(0);
            sQLiteDatabase.close();
            return str;
        } finally {
            sQLiteDatabase.close();
        }
    }

    static boolean setItemImpl(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ReactDatabaseSupplier.KEY_COLUMN, str);
        contentValues.put(ReactDatabaseSupplier.VALUE_COLUMN, str2);
        return -1 != sQLiteDatabase.insertWithOnConflict(ReactDatabaseSupplier.TABLE_CATALYST, null, contentValues, 5) ? true : null;
    }

    static boolean mergeImpl(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        String itemImpl = getItemImpl(sQLiteDatabase, str);
        if (itemImpl != null) {
            JSONObject jSONObject = new JSONObject(itemImpl);
            deepMergeInto(jSONObject, new JSONObject(str2));
            str2 = jSONObject.toString();
        }
        return setItemImpl(sQLiteDatabase, str, str2);
    }

    private static void deepMergeInto(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject optJSONObject = jSONObject2.optJSONObject(str);
            JSONObject optJSONObject2 = jSONObject.optJSONObject(str);
            if (optJSONObject == null || optJSONObject2 == null) {
                jSONObject.put(str, jSONObject2.get(str));
            } else {
                deepMergeInto(optJSONObject2, optJSONObject);
                jSONObject.put(str, optJSONObject2);
            }
        }
    }
}
