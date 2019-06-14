package host.exp.exponent.p346j;

import android.os.Bundle;
import java.lang.reflect.Array;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JSONBundleConverter */
/* renamed from: host.exp.exponent.j.f */
public class C6388f {
    /* renamed from: a */
    public static android.os.Bundle m26203a(org.json.JSONObject r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new android.os.Bundle;
        r0.<init>();
        r1 = r6.keys();
    L_0x0009:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x00d4;
    L_0x000f:
        r2 = r1.next();	 Catch:{ JSONException -> 0x00d1 }
        r2 = (java.lang.String) r2;	 Catch:{ JSONException -> 0x00d1 }
        r3 = r6.get(r2);	 Catch:{ JSONException -> 0x00d1 }
        if (r3 == 0) goto L_0x0009;	 Catch:{ JSONException -> 0x00d1 }
    L_0x001b:
        r4 = org.json.JSONObject.NULL;	 Catch:{ JSONException -> 0x00d1 }
        if (r3 != r4) goto L_0x0020;	 Catch:{ JSONException -> 0x00d1 }
    L_0x001f:
        goto L_0x0009;	 Catch:{ JSONException -> 0x00d1 }
    L_0x0020:
        r4 = r3 instanceof org.json.JSONObject;	 Catch:{ JSONException -> 0x00d1 }
        if (r4 == 0) goto L_0x002e;	 Catch:{ JSONException -> 0x00d1 }
    L_0x0024:
        r3 = (org.json.JSONObject) r3;	 Catch:{ JSONException -> 0x00d1 }
        r3 = host.exp.exponent.p346j.C6388f.m26203a(r3);	 Catch:{ JSONException -> 0x00d1 }
        r0.putBundle(r2, r3);	 Catch:{ JSONException -> 0x00d1 }
        goto L_0x0009;	 Catch:{ JSONException -> 0x00d1 }
    L_0x002e:
        r4 = r3.getClass();	 Catch:{ JSONException -> 0x00d1 }
        r5 = org.json.JSONArray.class;	 Catch:{ JSONException -> 0x00d1 }
        if (r4 != r5) goto L_0x003c;	 Catch:{ JSONException -> 0x00d1 }
    L_0x0036:
        r3 = (org.json.JSONArray) r3;	 Catch:{ JSONException -> 0x00d1 }
        host.exp.exponent.p346j.C6388f.m26206a(r0, r2, r3);	 Catch:{ JSONException -> 0x00d1 }
        goto L_0x0009;	 Catch:{ JSONException -> 0x00d1 }
    L_0x003c:
        r5 = java.lang.String.class;	 Catch:{ JSONException -> 0x00d1 }
        if (r4 != r5) goto L_0x0046;	 Catch:{ JSONException -> 0x00d1 }
    L_0x0040:
        r3 = (java.lang.String) r3;	 Catch:{ JSONException -> 0x00d1 }
        r0.putString(r2, r3);	 Catch:{ JSONException -> 0x00d1 }
        goto L_0x0009;	 Catch:{ JSONException -> 0x00d1 }
    L_0x0046:
        r5 = java.lang.Boolean.class;	 Catch:{ JSONException -> 0x00d1 }
        if (r4 != r5) goto L_0x0054;	 Catch:{ JSONException -> 0x00d1 }
    L_0x004a:
        r3 = (java.lang.Boolean) r3;	 Catch:{ JSONException -> 0x00d1 }
        r3 = r3.booleanValue();	 Catch:{ JSONException -> 0x00d1 }
        r0.putBoolean(r2, r3);	 Catch:{ JSONException -> 0x00d1 }
        goto L_0x0009;	 Catch:{ JSONException -> 0x00d1 }
    L_0x0054:
        r5 = java.lang.Boolean.TYPE;	 Catch:{ JSONException -> 0x00d1 }
        if (r4 != r5) goto L_0x0062;	 Catch:{ JSONException -> 0x00d1 }
    L_0x0058:
        r3 = (java.lang.Boolean) r3;	 Catch:{ JSONException -> 0x00d1 }
        r3 = r3.booleanValue();	 Catch:{ JSONException -> 0x00d1 }
        r0.putBoolean(r2, r3);	 Catch:{ JSONException -> 0x00d1 }
        goto L_0x0009;	 Catch:{ JSONException -> 0x00d1 }
    L_0x0062:
        r5 = java.lang.Integer.class;	 Catch:{ JSONException -> 0x00d1 }
        if (r4 != r5) goto L_0x0070;	 Catch:{ JSONException -> 0x00d1 }
    L_0x0066:
        r3 = (java.lang.Integer) r3;	 Catch:{ JSONException -> 0x00d1 }
        r3 = r3.intValue();	 Catch:{ JSONException -> 0x00d1 }
        r0.putInt(r2, r3);	 Catch:{ JSONException -> 0x00d1 }
        goto L_0x0009;	 Catch:{ JSONException -> 0x00d1 }
    L_0x0070:
        r5 = java.lang.Integer.TYPE;	 Catch:{ JSONException -> 0x00d1 }
        if (r4 != r5) goto L_0x007e;	 Catch:{ JSONException -> 0x00d1 }
    L_0x0074:
        r3 = (java.lang.Integer) r3;	 Catch:{ JSONException -> 0x00d1 }
        r3 = r3.intValue();	 Catch:{ JSONException -> 0x00d1 }
        r0.putInt(r2, r3);	 Catch:{ JSONException -> 0x00d1 }
        goto L_0x0009;	 Catch:{ JSONException -> 0x00d1 }
    L_0x007e:
        r5 = java.lang.Long.class;	 Catch:{ JSONException -> 0x00d1 }
        if (r4 != r5) goto L_0x008d;	 Catch:{ JSONException -> 0x00d1 }
    L_0x0082:
        r3 = (java.lang.Long) r3;	 Catch:{ JSONException -> 0x00d1 }
        r3 = r3.longValue();	 Catch:{ JSONException -> 0x00d1 }
        r0.putLong(r2, r3);	 Catch:{ JSONException -> 0x00d1 }
        goto L_0x0009;	 Catch:{ JSONException -> 0x00d1 }
    L_0x008d:
        r5 = java.lang.Long.TYPE;	 Catch:{ JSONException -> 0x00d1 }
        if (r4 != r5) goto L_0x009c;	 Catch:{ JSONException -> 0x00d1 }
    L_0x0091:
        r3 = (java.lang.Long) r3;	 Catch:{ JSONException -> 0x00d1 }
        r3 = r3.longValue();	 Catch:{ JSONException -> 0x00d1 }
        r0.putLong(r2, r3);	 Catch:{ JSONException -> 0x00d1 }
        goto L_0x0009;	 Catch:{ JSONException -> 0x00d1 }
    L_0x009c:
        r5 = java.lang.Double.class;	 Catch:{ JSONException -> 0x00d1 }
        if (r4 != r5) goto L_0x00ab;	 Catch:{ JSONException -> 0x00d1 }
    L_0x00a0:
        r3 = (java.lang.Double) r3;	 Catch:{ JSONException -> 0x00d1 }
        r3 = r3.doubleValue();	 Catch:{ JSONException -> 0x00d1 }
        r0.putDouble(r2, r3);	 Catch:{ JSONException -> 0x00d1 }
        goto L_0x0009;	 Catch:{ JSONException -> 0x00d1 }
    L_0x00ab:
        r5 = java.lang.Double.TYPE;	 Catch:{ JSONException -> 0x00d1 }
        if (r4 != r5) goto L_0x00ba;	 Catch:{ JSONException -> 0x00d1 }
    L_0x00af:
        r3 = (java.lang.Double) r3;	 Catch:{ JSONException -> 0x00d1 }
        r3 = r3.doubleValue();	 Catch:{ JSONException -> 0x00d1 }
        r0.putDouble(r2, r3);	 Catch:{ JSONException -> 0x00d1 }
        goto L_0x0009;	 Catch:{ JSONException -> 0x00d1 }
    L_0x00ba:
        r2 = new java.lang.IllegalArgumentException;	 Catch:{ JSONException -> 0x00d1 }
        r3 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x00d1 }
        r3.<init>();	 Catch:{ JSONException -> 0x00d1 }
        r5 = "Unexpected type: ";	 Catch:{ JSONException -> 0x00d1 }
        r3.append(r5);	 Catch:{ JSONException -> 0x00d1 }
        r3.append(r4);	 Catch:{ JSONException -> 0x00d1 }
        r3 = r3.toString();	 Catch:{ JSONException -> 0x00d1 }
        r2.<init>(r3);	 Catch:{ JSONException -> 0x00d1 }
        throw r2;	 Catch:{ JSONException -> 0x00d1 }
        goto L_0x0009;
    L_0x00d4:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.j.f.a(org.json.JSONObject):android.os.Bundle");
    }

    /* renamed from: a */
    private static Object m26205a(Class cls, JSONArray jSONArray) {
        Object newInstance = Array.newInstance(cls, jSONArray.length());
        int i = 0;
        while (i < jSONArray.length()) {
            Object obj = jSONArray.get(i);
            if (cls.isAssignableFrom(C6388f.m26204a(obj.getClass()))) {
                Array.set(newInstance, i, obj);
                i++;
            } else {
                jSONArray = new StringBuilder();
                jSONArray.append("Unexpected type in an array: ");
                jSONArray.append(obj.getClass());
                jSONArray.append(". All array elements must be same type.");
                throw new IllegalArgumentException(jSONArray.toString());
            }
        }
        return newInstance;
    }

    /* renamed from: a */
    private static Class m26204a(Class cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        return cls == Long.class ? Long.TYPE : cls;
    }

    /* renamed from: a */
    private static void m26206a(Bundle bundle, String str, JSONArray jSONArray) {
        int i = 0;
        if (jSONArray.length() == 0) {
            bundle.putStringArray(str, new String[0]);
            return;
        }
        Object obj = jSONArray.get(0);
        Class a = C6388f.m26204a(obj.getClass());
        if (Byte.TYPE.isAssignableFrom(a)) {
            bundle.putByteArray(str, (byte[]) C6388f.m26205a(Byte.TYPE, jSONArray));
        } else if (Character.TYPE.isAssignableFrom(a)) {
            bundle.putCharArray(str, (char[]) C6388f.m26205a(Character.TYPE, jSONArray));
        } else if (Float.TYPE.isAssignableFrom(a)) {
            bundle.putFloatArray(str, (float[]) C6388f.m26205a(Float.TYPE, jSONArray));
        } else if (Short.TYPE.isAssignableFrom(a)) {
            bundle.putShortArray(str, (short[]) C6388f.m26205a(Short.TYPE, jSONArray));
        } else if (String.class.isAssignableFrom(a)) {
            bundle.putStringArray(str, (String[]) C6388f.m26205a(String.class, jSONArray));
        } else if (Boolean.TYPE.isAssignableFrom(a)) {
            bundle.putBooleanArray(str, (boolean[]) C6388f.m26205a(Boolean.TYPE, jSONArray));
        } else if (Double.TYPE.isAssignableFrom(a)) {
            bundle.putDoubleArray(str, (double[]) C6388f.m26205a(Double.TYPE, jSONArray));
        } else if (Integer.TYPE.isAssignableFrom(a)) {
            bundle.putIntArray(str, (int[]) C6388f.m26205a(Integer.TYPE, jSONArray));
        } else if (Long.TYPE.isAssignableFrom(a)) {
            bundle.putLongArray(str, (long[]) C6388f.m26205a(Long.TYPE, jSONArray));
        } else if (obj instanceof JSONObject) {
            ArrayList arrayList = new ArrayList();
            while (i < jSONArray.length()) {
                Object obj2 = jSONArray.get(i);
                if (obj2 instanceof JSONObject) {
                    arrayList.add(C6388f.m26203a((JSONObject) obj2));
                    i++;
                } else {
                    str = new StringBuilder();
                    str.append("Unexpected type in an array: ");
                    str.append(obj2.getClass());
                    throw new IllegalArgumentException(str.toString());
                }
            }
            bundle.putParcelableArray(str, (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]));
        } else {
            str = new StringBuilder();
            str.append("Unexpected type in an array: ");
            str.append(obj.getClass());
            throw new IllegalArgumentException(str.toString());
        }
    }
}
