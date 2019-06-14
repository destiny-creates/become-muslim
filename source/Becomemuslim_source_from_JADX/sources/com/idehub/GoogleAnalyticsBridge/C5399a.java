package com.idehub.GoogleAnalyticsBridge;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: ConvertReadableToMap */
/* renamed from: com.idehub.GoogleAnalyticsBridge.a */
public class C5399a {

    /* compiled from: ConvertReadableToMap */
    /* renamed from: com.idehub.GoogleAnalyticsBridge.a$1 */
    static /* synthetic */ class C53981 {
        /* renamed from: a */
        static final /* synthetic */ int[] f18192a = new int[ReadableType.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = com.facebook.react.bridge.ReadableType.values();
            r0 = r0.length;
            r0 = new int[r0];
            f18192a = r0;
            r0 = f18192a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.facebook.react.bridge.ReadableType.Null;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f18192a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = com.facebook.react.bridge.ReadableType.Boolean;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f18192a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = com.facebook.react.bridge.ReadableType.Number;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = f18192a;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = com.facebook.react.bridge.ReadableType.String;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r0 = f18192a;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = com.facebook.react.bridge.ReadableType.Map;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r0 = f18192a;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = com.facebook.react.bridge.ReadableType.Array;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6;	 Catch:{ NoSuchFieldError -> 0x004b }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.idehub.GoogleAnalyticsBridge.a.1.<clinit>():void");
        }
    }

    /* renamed from: a */
    public static HashMap<String, Object> m22944a(ReadableMap readableMap) {
        HashMap<String, Object> hashMap = new HashMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            ReadableType type = readableMap.getType(nextKey);
            switch (C53981.f18192a[type.ordinal()]) {
                case 1:
                    hashMap.put(nextKey, null);
                    break;
                case 2:
                    hashMap.put(nextKey, Boolean.valueOf(readableMap.getBoolean(nextKey)));
                    break;
                case 3:
                    hashMap.put(nextKey, Double.valueOf(readableMap.getDouble(nextKey)));
                    break;
                case 4:
                    hashMap.put(nextKey, readableMap.getString(nextKey));
                    break;
                case 5:
                    hashMap.put(nextKey, C5399a.m22944a(readableMap.getMap(nextKey)));
                    break;
                case 6:
                    hashMap.put(nextKey, C5399a.m22945a(readableMap.getArray(nextKey)));
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Could not convert of type: ");
                    stringBuilder.append(type);
                    stringBuilder.append(" and key: ");
                    stringBuilder.append(nextKey);
                    stringBuilder.append(".");
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private static List<Object> m22945a(ReadableArray readableArray) {
        List<Object> arrayList = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableType type = readableArray.getType(i);
            switch (C53981.f18192a[type.ordinal()]) {
                case 1:
                    arrayList.add(i, null);
                    break;
                case 2:
                    arrayList.add(i, Boolean.valueOf(readableArray.getBoolean(i)));
                    break;
                case 3:
                    arrayList.add(i, Double.valueOf(readableArray.getDouble(i)));
                    break;
                case 4:
                    arrayList.add(i, readableArray.getString(i));
                    break;
                case 5:
                    arrayList.add(i, C5399a.m22944a(readableArray.getMap(i)));
                    break;
                case 6:
                    arrayList.add(i, C5399a.m22945a(readableArray.getArray(i)));
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Could not convert of type: ");
                    stringBuilder.append(type);
                    stringBuilder.append(" and index: ");
                    stringBuilder.append(i);
                    stringBuilder.append(".");
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return arrayList;
    }
}
