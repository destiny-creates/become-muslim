package com.google.android.gms.internal.p210i;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.gw */
final class gw {
    /* renamed from: a */
    static String m20619a(gt gtVar, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("# ");
        stringBuilder.append(str);
        gw.m20621a(gtVar, stringBuilder, null);
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static void m20621a(com.google.android.gms.internal.p210i.gt r12, java.lang.StringBuilder r13, int r14) {
        /*
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = new java.util.TreeSet;
        r2.<init>();
        r3 = r12.getClass();
        r3 = r3.getDeclaredMethods();
        r4 = r3.length;
        r5 = 0;
        r6 = 0;
    L_0x001a:
        if (r6 >= r4) goto L_0x0049;
    L_0x001c:
        r7 = r3[r6];
        r8 = r7.getName();
        r1.put(r8, r7);
        r8 = r7.getParameterTypes();
        r8 = r8.length;
        if (r8 != 0) goto L_0x0046;
    L_0x002c:
        r8 = r7.getName();
        r0.put(r8, r7);
        r8 = r7.getName();
        r9 = "get";
        r8 = r8.startsWith(r9);
        if (r8 == 0) goto L_0x0046;
    L_0x003f:
        r7 = r7.getName();
        r2.add(r7);
    L_0x0046:
        r6 = r6 + 1;
        goto L_0x001a;
    L_0x0049:
        r2 = r2.iterator();
    L_0x004d:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x0280;
    L_0x0053:
        r3 = r2.next();
        r3 = (java.lang.String) r3;
        r4 = "get";
        r6 = "";
        r4 = r3.replaceFirst(r4, r6);
        r6 = "List";
        r6 = r4.endsWith(r6);
        r7 = 1;
        if (r6 == 0) goto L_0x00c7;
    L_0x006a:
        r6 = "OrBuilderList";
        r6 = r4.endsWith(r6);
        if (r6 != 0) goto L_0x00c7;
    L_0x0072:
        r6 = "List";
        r6 = r4.equals(r6);
        if (r6 != 0) goto L_0x00c7;
    L_0x007a:
        r6 = r4.substring(r5, r7);
        r6 = r6.toLowerCase();
        r6 = java.lang.String.valueOf(r6);
        r8 = r4.length();
        r8 = r8 + -4;
        r8 = r4.substring(r7, r8);
        r8 = java.lang.String.valueOf(r8);
        r9 = r8.length();
        if (r9 == 0) goto L_0x009f;
    L_0x009a:
        r6 = r6.concat(r8);
        goto L_0x00a5;
    L_0x009f:
        r8 = new java.lang.String;
        r8.<init>(r6);
        r6 = r8;
    L_0x00a5:
        r8 = r0.get(r3);
        r8 = (java.lang.reflect.Method) r8;
        if (r8 == 0) goto L_0x00c7;
    L_0x00ad:
        r9 = r8.getReturnType();
        r10 = java.util.List.class;
        r9 = r9.equals(r10);
        if (r9 == 0) goto L_0x00c7;
    L_0x00b9:
        r3 = com.google.android.gms.internal.p210i.gw.m20620a(r6);
        r4 = new java.lang.Object[r5];
        r4 = com.google.android.gms.internal.p210i.fk.m42485a(r8, r12, r4);
        com.google.android.gms.internal.p210i.gw.m20622a(r13, r14, r3, r4);
        goto L_0x004d;
    L_0x00c7:
        r6 = "Map";
        r6 = r4.endsWith(r6);
        if (r6 == 0) goto L_0x0137;
    L_0x00cf:
        r6 = "Map";
        r6 = r4.equals(r6);
        if (r6 != 0) goto L_0x0137;
    L_0x00d7:
        r6 = r4.substring(r5, r7);
        r6 = r6.toLowerCase();
        r6 = java.lang.String.valueOf(r6);
        r8 = r4.length();
        r8 = r8 + -3;
        r8 = r4.substring(r7, r8);
        r8 = java.lang.String.valueOf(r8);
        r9 = r8.length();
        if (r9 == 0) goto L_0x00fc;
    L_0x00f7:
        r6 = r6.concat(r8);
        goto L_0x0102;
    L_0x00fc:
        r8 = new java.lang.String;
        r8.<init>(r6);
        r6 = r8;
    L_0x0102:
        r3 = r0.get(r3);
        r3 = (java.lang.reflect.Method) r3;
        if (r3 == 0) goto L_0x0137;
    L_0x010a:
        r8 = r3.getReturnType();
        r9 = java.util.Map.class;
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x0137;
    L_0x0116:
        r8 = java.lang.Deprecated.class;
        r8 = r3.isAnnotationPresent(r8);
        if (r8 != 0) goto L_0x0137;
    L_0x011e:
        r8 = r3.getModifiers();
        r8 = java.lang.reflect.Modifier.isPublic(r8);
        if (r8 == 0) goto L_0x0137;
    L_0x0128:
        r4 = com.google.android.gms.internal.p210i.gw.m20620a(r6);
        r6 = new java.lang.Object[r5];
        r3 = com.google.android.gms.internal.p210i.fk.m42485a(r3, r12, r6);
        com.google.android.gms.internal.p210i.gw.m20622a(r13, r14, r4, r3);
        goto L_0x004d;
    L_0x0137:
        r3 = "set";
        r6 = java.lang.String.valueOf(r4);
        r8 = r6.length();
        if (r8 == 0) goto L_0x0148;
    L_0x0143:
        r3 = r3.concat(r6);
        goto L_0x014e;
    L_0x0148:
        r6 = new java.lang.String;
        r6.<init>(r3);
        r3 = r6;
    L_0x014e:
        r3 = r1.get(r3);
        r3 = (java.lang.reflect.Method) r3;
        if (r3 == 0) goto L_0x004d;
    L_0x0156:
        r3 = "Bytes";
        r3 = r4.endsWith(r3);
        if (r3 == 0) goto L_0x0185;
    L_0x015e:
        r3 = "get";
        r6 = r4.length();
        r6 = r6 + -5;
        r6 = r4.substring(r5, r6);
        r6 = java.lang.String.valueOf(r6);
        r8 = r6.length();
        if (r8 == 0) goto L_0x0179;
    L_0x0174:
        r3 = r3.concat(r6);
        goto L_0x017f;
    L_0x0179:
        r6 = new java.lang.String;
        r6.<init>(r3);
        r3 = r6;
    L_0x017f:
        r3 = r0.containsKey(r3);
        if (r3 != 0) goto L_0x004d;
    L_0x0185:
        r3 = r4.substring(r5, r7);
        r3 = r3.toLowerCase();
        r3 = java.lang.String.valueOf(r3);
        r6 = r4.substring(r7);
        r6 = java.lang.String.valueOf(r6);
        r8 = r6.length();
        if (r8 == 0) goto L_0x01a4;
    L_0x019f:
        r3 = r3.concat(r6);
        goto L_0x01aa;
    L_0x01a4:
        r6 = new java.lang.String;
        r6.<init>(r3);
        r3 = r6;
    L_0x01aa:
        r6 = "get";
        r8 = java.lang.String.valueOf(r4);
        r9 = r8.length();
        if (r9 == 0) goto L_0x01bb;
    L_0x01b6:
        r6 = r6.concat(r8);
        goto L_0x01c1;
    L_0x01bb:
        r8 = new java.lang.String;
        r8.<init>(r6);
        r6 = r8;
    L_0x01c1:
        r6 = r0.get(r6);
        r6 = (java.lang.reflect.Method) r6;
        r8 = "has";
        r4 = java.lang.String.valueOf(r4);
        r9 = r4.length();
        if (r9 == 0) goto L_0x01d8;
    L_0x01d3:
        r4 = r8.concat(r4);
        goto L_0x01dd;
    L_0x01d8:
        r4 = new java.lang.String;
        r4.<init>(r8);
    L_0x01dd:
        r4 = r0.get(r4);
        r4 = (java.lang.reflect.Method) r4;
        if (r6 == 0) goto L_0x004d;
    L_0x01e5:
        r8 = new java.lang.Object[r5];
        r6 = com.google.android.gms.internal.p210i.fk.m42485a(r6, r12, r8);
        if (r4 != 0) goto L_0x0269;
    L_0x01ed:
        r4 = r6 instanceof java.lang.Boolean;
        if (r4 == 0) goto L_0x0200;
    L_0x01f1:
        r4 = r6;
        r4 = (java.lang.Boolean) r4;
        r4 = r4.booleanValue();
        if (r4 != 0) goto L_0x01fd;
    L_0x01fa:
        r4 = 1;
        goto L_0x0263;
    L_0x01fd:
        r4 = 0;
        goto L_0x0263;
    L_0x0200:
        r4 = r6 instanceof java.lang.Integer;
        if (r4 == 0) goto L_0x020e;
    L_0x0204:
        r4 = r6;
        r4 = (java.lang.Integer) r4;
        r4 = r4.intValue();
        if (r4 != 0) goto L_0x01fd;
    L_0x020d:
        goto L_0x01fa;
    L_0x020e:
        r4 = r6 instanceof java.lang.Float;
        if (r4 == 0) goto L_0x021f;
    L_0x0212:
        r4 = r6;
        r4 = (java.lang.Float) r4;
        r4 = r4.floatValue();
        r8 = 0;
        r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r4 != 0) goto L_0x01fd;
    L_0x021e:
        goto L_0x01fa;
    L_0x021f:
        r4 = r6 instanceof java.lang.Double;
        if (r4 == 0) goto L_0x0231;
    L_0x0223:
        r4 = r6;
        r4 = (java.lang.Double) r4;
        r8 = r4.doubleValue();
        r10 = 0;
        r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r4 != 0) goto L_0x01fd;
    L_0x0230:
        goto L_0x01fa;
    L_0x0231:
        r4 = r6 instanceof java.lang.String;
        if (r4 == 0) goto L_0x023c;
    L_0x0235:
        r4 = "";
        r4 = r6.equals(r4);
        goto L_0x0263;
    L_0x023c:
        r4 = r6 instanceof com.google.android.gms.internal.p210i.dy;
        if (r4 == 0) goto L_0x0247;
    L_0x0240:
        r4 = com.google.android.gms.internal.p210i.dy.f16513a;
        r4 = r6.equals(r4);
        goto L_0x0263;
    L_0x0247:
        r4 = r6 instanceof com.google.android.gms.internal.p210i.gt;
        if (r4 == 0) goto L_0x0255;
    L_0x024b:
        r4 = r6;
        r4 = (com.google.android.gms.internal.p210i.gt) r4;
        r4 = r4.mo6732v();
        if (r6 != r4) goto L_0x01fd;
    L_0x0254:
        goto L_0x01fa;
    L_0x0255:
        r4 = r6 instanceof java.lang.Enum;
        if (r4 == 0) goto L_0x01fd;
    L_0x0259:
        r4 = r6;
        r4 = (java.lang.Enum) r4;
        r4 = r4.ordinal();
        if (r4 != 0) goto L_0x01fd;
    L_0x0262:
        goto L_0x01fa;
    L_0x0263:
        if (r4 != 0) goto L_0x0267;
    L_0x0265:
        r4 = 1;
        goto L_0x0275;
    L_0x0267:
        r4 = 0;
        goto L_0x0275;
    L_0x0269:
        r7 = new java.lang.Object[r5];
        r4 = com.google.android.gms.internal.p210i.fk.m42485a(r4, r12, r7);
        r4 = (java.lang.Boolean) r4;
        r4 = r4.booleanValue();
    L_0x0275:
        if (r4 == 0) goto L_0x004d;
    L_0x0277:
        r3 = com.google.android.gms.internal.p210i.gw.m20620a(r3);
        com.google.android.gms.internal.p210i.gw.m20622a(r13, r14, r3, r6);
        goto L_0x004d;
    L_0x0280:
        r0 = r12 instanceof com.google.android.gms.internal.p210i.fk.C8336c;
        if (r0 == 0) goto L_0x02a3;
    L_0x0284:
        r0 = r12;
        r0 = (com.google.android.gms.internal.p210i.fk.C8336c) r0;
        r0 = r0.zzbaq;
        r0 = r0.m20538d();
        r1 = r0.hasNext();
        if (r1 != 0) goto L_0x0294;
    L_0x0293:
        goto L_0x02a3;
    L_0x0294:
        r12 = r0.next();
        r12 = (java.util.Map.Entry) r12;
        r12.getKey();
        r12 = new java.lang.NoSuchMethodError;
        r12.<init>();
        throw r12;
    L_0x02a3:
        r12 = (com.google.android.gms.internal.p210i.fk) r12;
        r0 = r12.zzbak;
        if (r0 == 0) goto L_0x02ae;
    L_0x02a9:
        r12 = r12.zzbak;
        r12.m20789a(r13, r14);
    L_0x02ae:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.gw.a(com.google.android.gms.internal.i.gt, java.lang.StringBuilder, int):void");
    }

    /* renamed from: a */
    static final void m20622a(StringBuilder stringBuilder, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object a : (List) obj) {
                gw.m20622a(stringBuilder, i, str, a);
            }
        } else if (obj instanceof Map) {
            for (Entry a2 : ((Map) obj).entrySet()) {
                gw.m20622a(stringBuilder, i, str, a2);
            }
        } else {
            stringBuilder.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(str);
            if ((obj instanceof String) != null) {
                stringBuilder.append(": \"");
                stringBuilder.append(hx.m20761a(dy.m20451a((String) obj)));
                stringBuilder.append('\"');
            } else if ((obj instanceof dy) != null) {
                stringBuilder.append(": \"");
                stringBuilder.append(hx.m20761a((dy) obj));
                stringBuilder.append('\"');
            } else if ((obj instanceof fk) != null) {
                stringBuilder.append(" {");
                gw.m20621a((fk) obj, stringBuilder, i + 2);
                stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                while (i2 < i) {
                    stringBuilder.append(' ');
                    i2++;
                }
                stringBuilder.append("}");
            } else if ((obj instanceof Entry) != null) {
                stringBuilder.append(" {");
                Entry entry = (Entry) obj;
                str = i + 2;
                gw.m20622a(stringBuilder, str, "key", entry.getKey());
                gw.m20622a(stringBuilder, str, "value", entry.getValue());
                stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                while (i2 < i) {
                    stringBuilder.append(' ');
                    i2++;
                }
                stringBuilder.append("}");
            } else {
                stringBuilder.append(": ");
                stringBuilder.append(obj.toString());
            }
        }
    }

    /* renamed from: a */
    private static final String m20620a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                stringBuilder.append("_");
            }
            stringBuilder.append(Character.toLowerCase(charAt));
        }
        return stringBuilder.toString();
    }
}
