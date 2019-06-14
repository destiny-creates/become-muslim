package com.google.android.gms.p185e;

import com.facebook.internal.ServerProtocol;
import com.google.android.gms.internal.p210i.ct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.e.eu */
public final class eu {
    /* renamed from: a */
    private static final Object f7570a = null;
    /* renamed from: b */
    private static Long f7571b = new Long(0);
    /* renamed from: c */
    private static Double f7572c = new Double(0.0d);
    /* renamed from: d */
    private static et f7573d = et.m8710a(0);
    /* renamed from: e */
    private static String f7574e = new String("");
    /* renamed from: f */
    private static Boolean f7575f = new Boolean(false);
    /* renamed from: g */
    private static List<Object> f7576g = new ArrayList(0);
    /* renamed from: h */
    private static Map<Object, Object> f7577h = new HashMap();
    /* renamed from: i */
    private static ct f7578i = eu.m8716a(f7574e);

    /* renamed from: a */
    public static Object m8718a() {
        return null;
    }

    /* renamed from: b */
    public static Long m8722b() {
        return f7571b;
    }

    /* renamed from: c */
    public static Double m8724c() {
        return f7572c;
    }

    /* renamed from: d */
    public static Boolean m8728d() {
        return f7575f;
    }

    /* renamed from: e */
    public static et m8730e() {
        return f7573d;
    }

    /* renamed from: f */
    public static String m8735f() {
        return f7574e;
    }

    /* renamed from: g */
    public static ct m8736g() {
        return f7578i;
    }

    /* renamed from: b */
    private static String m8723b(Object obj) {
        return obj == null ? f7574e : obj.toString();
    }

    /* renamed from: a */
    public static String m8719a(ct ctVar) {
        return eu.m8723b(eu.m8734f(ctVar));
    }

    /* renamed from: b */
    public static et m8720b(ct ctVar) {
        Object f = eu.m8734f(ctVar);
        if (f instanceof et) {
            return (et) f;
        }
        if (eu.m8732e(f)) {
            return et.m8710a(eu.m8733f(f));
        }
        if (eu.m8726c(f)) {
            return et.m8711a(Double.valueOf(eu.m8727d(f)));
        }
        return eu.m8721b(eu.m8723b(f));
    }

    /* renamed from: c */
    public static Long m8725c(ct ctVar) {
        Object f = eu.m8734f(ctVar);
        if (eu.m8732e(f)) {
            return Long.valueOf(eu.m8733f(f));
        }
        ctVar = eu.m8721b(eu.m8723b(f));
        return ctVar == f7573d ? f7571b : Long.valueOf(ctVar.longValue());
    }

    /* renamed from: d */
    public static Double m8729d(ct ctVar) {
        Object f = eu.m8734f(ctVar);
        if (eu.m8726c(f)) {
            return Double.valueOf(eu.m8727d(f));
        }
        ctVar = eu.m8721b(eu.m8723b(f));
        return ctVar == f7573d ? f7572c : Double.valueOf(ctVar.doubleValue());
    }

    /* renamed from: e */
    public static Boolean m8731e(ct ctVar) {
        Object f = eu.m8734f(ctVar);
        if (f instanceof Boolean) {
            return (Boolean) f;
        }
        ctVar = eu.m8723b(f);
        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(ctVar)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(ctVar) != null) {
            return Boolean.FALSE;
        }
        return f7575f;
    }

    /* renamed from: a */
    public static ct m8716a(Object obj) {
        ct ctVar = new ct();
        if (obj instanceof ct) {
            return (ct) obj;
        }
        boolean z = false;
        if (obj instanceof String) {
            ctVar.f28857a = 1;
            ctVar.f28858b = (String) obj;
        } else if (obj instanceof List) {
            ctVar.f28857a = 2;
            List<Object> list = (List) obj;
            r1 = new ArrayList(list.size());
            boolean z2 = false;
            for (Object a : list) {
                ct a2 = eu.m8716a(a);
                if (a2 == f7578i) {
                    return f7578i;
                }
                if (!z2) {
                    if (!a2.f28868l) {
                        z2 = false;
                        r1.add(a2);
                    }
                }
                z2 = true;
                r1.add(a2);
            }
            ctVar.f28859c = (ct[]) r1.toArray(new ct[0]);
            z = z2;
        } else if (obj instanceof Map) {
            ctVar.f28857a = 3;
            Object<Entry> entrySet = ((Map) obj).entrySet();
            r1 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            boolean z3 = false;
            for (Entry entry : entrySet) {
                ct a3 = eu.m8716a(entry.getKey());
                ct a4 = eu.m8716a(entry.getValue());
                if (a3 != f7578i) {
                    if (a4 != f7578i) {
                        if (!(z3 || a3.f28868l)) {
                            if (!a4.f28868l) {
                                z3 = false;
                                r1.add(a3);
                                arrayList.add(a4);
                            }
                        }
                        z3 = true;
                        r1.add(a3);
                        arrayList.add(a4);
                    }
                }
                return f7578i;
            }
            ctVar.f28860d = (ct[]) r1.toArray(new ct[0]);
            ctVar.f28861e = (ct[]) arrayList.toArray(new ct[0]);
            z = z3;
        } else if (eu.m8726c(obj)) {
            ctVar.f28857a = 1;
            ctVar.f28858b = obj.toString();
        } else if (eu.m8732e(obj)) {
            ctVar.f28857a = 6;
            ctVar.f28864h = eu.m8733f(obj);
        } else if (obj instanceof Boolean) {
            ctVar.f28857a = 8;
            ctVar.f28865i = ((Boolean) obj).booleanValue();
        } else {
            String str = "Converting to Value from unknown object type: ";
            if (obj == null) {
                obj = "null";
            } else {
                obj = obj.getClass().toString();
            }
            obj = String.valueOf(obj);
            bs.m8582a(obj.length() != 0 ? str.concat(obj) : new String(str));
            return f7578i;
        }
        ctVar.f28868l = z;
        return ctVar;
    }

    /* renamed from: a */
    public static ct m8717a(String str) {
        ct ctVar = new ct();
        ctVar.f28857a = 5;
        ctVar.f28863g = str;
        return ctVar;
    }

    /* renamed from: c */
    private static boolean m8726c(Object obj) {
        if (!((obj instanceof Double) || (obj instanceof Float))) {
            if (!(obj instanceof et) || ((et) obj).m8714a() == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: d */
    private static double m8727d(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        bs.m8582a("getDouble received non-Number");
        return 0.0d;
    }

    /* renamed from: e */
    private static boolean m8732e(Object obj) {
        if (!((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long))) {
            if (!(obj instanceof et) || ((et) obj).m8715b() == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: f */
    private static long m8733f(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        bs.m8582a("getInt64 received non-Number");
        return 0;
    }

    /* renamed from: b */
    private static com.google.android.gms.p185e.et m8721b(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = com.google.android.gms.p185e.et.m8712a(r2);	 Catch:{ NumberFormatException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = java.lang.String.valueOf(r2);
        r0 = r0.length();
        r0 = r0 + 33;
        r1 = new java.lang.StringBuilder;
        r1.<init>(r0);
        r0 = "Failed to convert '";
        r1.append(r0);
        r1.append(r2);
        r2 = "' to a number.";
        r1.append(r2);
        r2 = r1.toString();
        com.google.android.gms.p185e.bs.m8582a(r2);
        r2 = f7573d;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.eu.b(java.lang.String):com.google.android.gms.e.et");
    }

    /* renamed from: f */
    public static Object m8734f(ct ctVar) {
        if (ctVar == null) {
            return null;
        }
        int i = 0;
        int length;
        Object f;
        switch (ctVar.f28857a) {
            case 1:
                return ctVar.f28858b;
            case 2:
                ArrayList arrayList = new ArrayList(ctVar.f28859c.length);
                ctVar = ctVar.f28859c;
                length = ctVar.length;
                while (i < length) {
                    f = eu.m8734f(ctVar[i]);
                    if (f == null) {
                        return null;
                    }
                    arrayList.add(f);
                    i++;
                }
                return arrayList;
            case 3:
                if (ctVar.f28860d.length != ctVar.f28861e.length) {
                    String str = "Converting an invalid value to object: ";
                    ctVar = String.valueOf(ctVar.toString());
                    bs.m8582a(ctVar.length() != 0 ? str.concat(ctVar) : new String(str));
                    return null;
                }
                Map hashMap = new HashMap(ctVar.f28861e.length);
                while (i < ctVar.f28860d.length) {
                    Object f2 = eu.m8734f(ctVar.f28860d[i]);
                    f = eu.m8734f(ctVar.f28861e[i]);
                    if (f2 != null) {
                        if (f != null) {
                            hashMap.put(f2, f);
                            i++;
                        }
                    }
                    return null;
                }
                return hashMap;
            case 4:
                bs.m8582a("Trying to convert a macro reference to object");
                return null;
            case 5:
                bs.m8582a("Trying to convert a function id to object");
                return null;
            case 6:
                return Long.valueOf(ctVar.f28864h);
            case 7:
                StringBuilder stringBuilder = new StringBuilder();
                ctVar = ctVar.f28866j;
                length = ctVar.length;
                while (i < length) {
                    String b = eu.m8723b(eu.m8734f(ctVar[i]));
                    if (b == f7574e) {
                        return null;
                    }
                    stringBuilder.append(b);
                    i++;
                }
                return stringBuilder.toString();
            case 8:
                return Boolean.valueOf(ctVar.f28865i);
            default:
                ctVar = ctVar.f28857a;
                StringBuilder stringBuilder2 = new StringBuilder(46);
                stringBuilder2.append("Failed to convert a value of type: ");
                stringBuilder2.append(ctVar);
                bs.m8582a(stringBuilder2.toString());
                return null;
        }
    }
}
