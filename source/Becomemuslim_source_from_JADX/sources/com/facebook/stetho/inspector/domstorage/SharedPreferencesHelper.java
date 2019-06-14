package com.facebook.stetho.inspector.domstorage;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

public class SharedPreferencesHelper {
    private static final String PREFS_SUFFIX = ".xml";

    private SharedPreferencesHelper() {
    }

    public static List<String> getSharedPreferenceTags(Context context) {
        List<String> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getApplicationInfo().dataDir);
        stringBuilder.append("/shared_prefs");
        File file = new File(stringBuilder.toString());
        if (file.exists() != null) {
            for (File name : file.listFiles()) {
                String name2 = name.getName();
                if (name2.endsWith(PREFS_SUFFIX)) {
                    arrayList.add(name2.substring(0, name2.length() - PREFS_SUFFIX.length()));
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static String valueToString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Set)) {
            return obj.toString();
        }
        JSONArray jSONArray = new JSONArray();
        for (String put : (Set) obj) {
            jSONArray.put(put);
        }
        return jSONArray.toString();
    }

    public static Object valueFromString(String str, Object obj) {
        if (obj instanceof Integer) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf(Float.parseFloat(str));
        }
        if (obj instanceof Boolean) {
            return parseBoolean(str);
        }
        if (obj instanceof String) {
            return str;
        }
        if (obj instanceof Set) {
            try {
                obj = new JSONArray(str);
                str = obj.length();
                HashSet hashSet = new HashSet(str);
                for (int i = 0; i < str; i++) {
                    hashSet.add(obj.getString(i));
                }
                return hashSet;
            } catch (String str2) {
                throw new IllegalArgumentException(str2);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported type: ");
        stringBuilder.append(obj.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static Boolean parseBoolean(String str) {
        if (!AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(str)) {
            if (!ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str)) {
                if (!AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
                    if (!"false".equalsIgnoreCase(str)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Expected boolean, got ");
                        stringBuilder.append(str);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
