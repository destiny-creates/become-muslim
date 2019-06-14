package com.polidea.reactnativeble.p269e;

import com.facebook.react.bridge.ReadableArray;

/* compiled from: ReadableArrayConverter */
/* renamed from: com.polidea.reactnativeble.e.f */
public class C5646f {
    /* renamed from: a */
    public static String[] m23978a(ReadableArray readableArray) {
        String[] strArr = new String[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            strArr[i] = readableArray.getString(i);
        }
        return strArr;
    }
}
