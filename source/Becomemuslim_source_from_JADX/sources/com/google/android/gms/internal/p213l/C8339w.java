package com.google.android.gms.internal.p213l;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v4.util.C3211a;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.measurement.AppMeasurement.C6846a;
import com.google.android.gms.measurement.AppMeasurement.C6847d;
import com.google.android.gms.measurement.AppMeasurement.C6848e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.l.w */
final class C8339w extends fl {
    C8339w(fm fmVar) {
        super(fmVar);
    }

    /* renamed from: a */
    private final java.lang.Boolean m44311a(double r2, com.google.android.gms.internal.p213l.gc r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x000e }
        r0.<init>(r2);	 Catch:{ NumberFormatException -> 0x000e }
        r2 = java.lang.Math.ulp(r2);	 Catch:{ NumberFormatException -> 0x000e }
        r2 = com.google.android.gms.internal.p213l.C8339w.m44319a(r0, r4, r2);	 Catch:{ NumberFormatException -> 0x000e }
        return r2;
    L_0x000e:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.w.a(double, com.google.android.gms.internal.l.gc):java.lang.Boolean");
    }

    /* renamed from: a */
    private final java.lang.Boolean m44312a(long r2, com.google.android.gms.internal.p213l.gc r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x000c }
        r0.<init>(r2);	 Catch:{ NumberFormatException -> 0x000c }
        r2 = 0;	 Catch:{ NumberFormatException -> 0x000c }
        r2 = com.google.android.gms.internal.p213l.C8339w.m44319a(r0, r4, r2);	 Catch:{ NumberFormatException -> 0x000c }
        return r2;
    L_0x000c:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.w.a(long, com.google.android.gms.internal.l.gc):java.lang.Boolean");
    }

    /* renamed from: a */
    private final Boolean m44313a(ga gaVar, String str, gl[] glVarArr, long j) {
        if (gaVar.f28997f != null) {
            Boolean a = m44312a(j, gaVar.f28997f);
            if (a == null) {
                return null;
            }
            if (!a.booleanValue()) {
                return Boolean.valueOf(false);
            }
        }
        Set hashSet = new HashSet();
        for (gb gbVar : gaVar.f28996e) {
            if (TextUtils.isEmpty(gbVar.f29003f)) {
                mo4754r().m42565i().m21308a("null or empty param name in filter. event", mo6212o().m42528a(str));
                return null;
            }
            hashSet.add(gbVar.f29003f);
        }
        Map c3211a = new C3211a();
        for (gl glVar : glVarArr) {
            if (hashSet.contains(glVar.f29048c)) {
                Object obj;
                Object obj2;
                if (glVar.f29050e != null) {
                    obj = glVar.f29048c;
                    obj2 = glVar.f29050e;
                } else if (glVar.f29051f != null) {
                    obj = glVar.f29048c;
                    obj2 = glVar.f29051f;
                } else if (glVar.f29049d != null) {
                    obj = glVar.f29048c;
                    obj2 = glVar.f29049d;
                } else {
                    mo4754r().m42565i().m21309a("Unknown value for param. event, param", mo6212o().m42528a(str), mo6212o().m42530b(glVar.f29048c));
                    return null;
                }
                c3211a.put(obj, obj2);
            }
        }
        for (gb gbVar2 : gaVar.f28996e) {
            boolean equals = Boolean.TRUE.equals(gbVar2.f29002e);
            String str2 = gbVar2.f29003f;
            if (TextUtils.isEmpty(str2)) {
                mo4754r().m42565i().m21308a("Event has empty param name. event", mo6212o().m42528a(str));
                return null;
            }
            Object obj3 = c3211a.get(str2);
            Boolean a2;
            if (obj3 instanceof Long) {
                if (gbVar2.f29001d == null) {
                    mo4754r().m42565i().m21309a("No number filter for long param. event, param", mo6212o().m42528a(str), mo6212o().m42530b(str2));
                    return null;
                }
                a2 = m44312a(((Long) obj3).longValue(), gbVar2.f29001d);
                if (a2 == null) {
                    return null;
                }
                if (((1 ^ a2.booleanValue()) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj3 instanceof Double) {
                if (gbVar2.f29001d == null) {
                    mo4754r().m42565i().m21309a("No number filter for double param. event, param", mo6212o().m42528a(str), mo6212o().m42530b(str2));
                    return null;
                }
                a2 = m44311a(((Double) obj3).doubleValue(), gbVar2.f29001d);
                if (a2 == null) {
                    return null;
                }
                if (((1 ^ a2.booleanValue()) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj3 instanceof String) {
                if (gbVar2.f29000c != null) {
                    a2 = m44318a((String) obj3, gbVar2.f29000c);
                } else if (gbVar2.f29001d != null) {
                    String str3 = (String) obj3;
                    if (fs.m44280a(str3)) {
                        a2 = m44317a(str3, gbVar2.f29001d);
                    } else {
                        mo4754r().m42565i().m21309a("Invalid param value for number filter. event, param", mo6212o().m42528a(str), mo6212o().m42530b(str2));
                        return null;
                    }
                } else {
                    mo4754r().m42565i().m21309a("No filter for String param. event, param", mo6212o().m42528a(str), mo6212o().m42530b(str2));
                    return null;
                }
                if (a2 == null) {
                    return null;
                }
                if (((1 ^ a2.booleanValue()) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj3 == null) {
                mo4754r().m42579w().m21309a("Missing param for filter. event, param", mo6212o().m42528a(str), mo6212o().m42530b(str2));
                return Boolean.valueOf(false);
            } else {
                mo4754r().m42565i().m21309a("Unknown param type. event, param", mo6212o().m42528a(str), mo6212o().m42530b(str2));
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    /* renamed from: a */
    private final Boolean m44314a(gd gdVar, gq gqVar) {
        bd i;
        String str;
        gb gbVar = gdVar.f29014e;
        if (gbVar == null) {
            i = mo4754r().m42565i();
            str = "Missing property filter. property";
        } else {
            Boolean a;
            boolean equals = Boolean.TRUE.equals(gbVar.f29002e);
            if (gqVar.f29104f != null) {
                if (gbVar.f29001d == null) {
                    i = mo4754r().m42565i();
                    str = "No number filter for long property. property";
                } else {
                    a = m44312a(gqVar.f29104f.longValue(), gbVar.f29001d);
                }
            } else if (gqVar.f29105g != null) {
                if (gbVar.f29001d == null) {
                    i = mo4754r().m42565i();
                    str = "No number filter for double property. property";
                } else {
                    a = m44311a(gqVar.f29105g.doubleValue(), gbVar.f29001d);
                }
            } else if (gqVar.f29103e == null) {
                i = mo4754r().m42565i();
                str = "User property has no value, property";
            } else if (gbVar.f29000c == null) {
                if (gbVar.f29001d == null) {
                    mo4754r().m42565i().m21308a("No string or number filter defined. property", mo6212o().m42532c(gqVar.f29102d));
                } else if (fs.m44280a(gqVar.f29103e)) {
                    a = m44317a(gqVar.f29103e, gbVar.f29001d);
                } else {
                    mo4754r().m42565i().m21309a("Invalid user property value for Numeric number filter. property, value", mo6212o().m42532c(gqVar.f29102d), gqVar.f29103e);
                }
                return null;
            } else {
                a = m44318a(gqVar.f29103e, gbVar.f29000c);
            }
            return C8339w.m44315a(a, equals);
        }
        i.m21308a(str, mo6212o().m42532c(gqVar.f29102d));
        return null;
    }

    /* renamed from: a */
    private static Boolean m44315a(Boolean bool, boolean z) {
        return bool == null ? null : Boolean.valueOf(bool.booleanValue() ^ z);
    }

    /* renamed from: a */
    private final java.lang.Boolean m44316a(java.lang.String r3, int r4, boolean r5, java.lang.String r6, java.util.List<java.lang.String> r7, java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 6;
        if (r4 != r1) goto L_0x0010;
    L_0x0007:
        if (r7 == 0) goto L_0x000f;
    L_0x0009:
        r1 = r7.size();
        if (r1 != 0) goto L_0x0013;
    L_0x000f:
        return r0;
    L_0x0010:
        if (r6 != 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        if (r5 != 0) goto L_0x001f;
    L_0x0015:
        r1 = 1;
        if (r4 != r1) goto L_0x0019;
    L_0x0018:
        goto L_0x001f;
    L_0x0019:
        r1 = java.util.Locale.ENGLISH;
        r3 = r3.toUpperCase(r1);
    L_0x001f:
        switch(r4) {
            case 1: goto L_0x0040;
            case 2: goto L_0x003b;
            case 3: goto L_0x0036;
            case 4: goto L_0x0031;
            case 5: goto L_0x002c;
            case 6: goto L_0x0023;
            default: goto L_0x0022;
        };
    L_0x0022:
        return r0;
    L_0x0023:
        r3 = r7.contains(r3);
    L_0x0027:
        r3 = java.lang.Boolean.valueOf(r3);
        return r3;
    L_0x002c:
        r3 = r3.equals(r6);
        goto L_0x0027;
    L_0x0031:
        r3 = r3.contains(r6);
        goto L_0x0027;
    L_0x0036:
        r3 = r3.endsWith(r6);
        goto L_0x0027;
    L_0x003b:
        r3 = r3.startsWith(r6);
        goto L_0x0027;
    L_0x0040:
        if (r5 == 0) goto L_0x0044;
    L_0x0042:
        r4 = 0;
        goto L_0x0046;
    L_0x0044:
        r4 = 66;
    L_0x0046:
        r4 = java.util.regex.Pattern.compile(r8, r4);	 Catch:{ PatternSyntaxException -> 0x0057 }
        r3 = r4.matcher(r3);	 Catch:{ PatternSyntaxException -> 0x0057 }
        r3 = r3.matches();	 Catch:{ PatternSyntaxException -> 0x0057 }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ PatternSyntaxException -> 0x0057 }
        return r3;
    L_0x0057:
        r3 = r2.mo4754r();
        r3 = r3.m42565i();
        r4 = "Invalid regular expression in REGEXP audience filter. expression";
        r3.m21308a(r4, r8);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.w.a(java.lang.String, int, boolean, java.lang.String, java.util.List, java.lang.String):java.lang.Boolean");
    }

    /* renamed from: a */
    private final java.lang.Boolean m44317a(java.lang.String r5, com.google.android.gms.internal.p213l.gc r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = com.google.android.gms.internal.p213l.fs.m44280a(r5);
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0014 }
        r0.<init>(r5);	 Catch:{ NumberFormatException -> 0x0014 }
        r2 = 0;	 Catch:{ NumberFormatException -> 0x0014 }
        r5 = com.google.android.gms.internal.p213l.C8339w.m44319a(r0, r6, r2);	 Catch:{ NumberFormatException -> 0x0014 }
        return r5;
    L_0x0014:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.w.a(java.lang.String, com.google.android.gms.internal.l.gc):java.lang.Boolean");
    }

    /* renamed from: a */
    private final Boolean m44318a(String str, ge geVar) {
        C2872v.a(geVar);
        if (!(str == null || geVar.f29015c == null)) {
            if (geVar.f29015c.intValue() != 0) {
                String toUpperCase;
                String str2;
                List list;
                String[] strArr;
                List arrayList;
                if (geVar.f29015c.intValue() == 6) {
                    if (geVar.f29018f == null || geVar.f29018f.length == 0) {
                        return null;
                    }
                } else if (geVar.f29016d == null) {
                    return null;
                }
                int intValue = geVar.f29015c.intValue();
                boolean z = geVar.f29017e != null && geVar.f29017e.booleanValue();
                if (!(z || intValue == 1)) {
                    if (intValue != 6) {
                        toUpperCase = geVar.f29016d.toUpperCase(Locale.ENGLISH);
                        str2 = toUpperCase;
                        if (geVar.f29018f != null) {
                            list = null;
                        } else {
                            strArr = geVar.f29018f;
                            if (z) {
                                arrayList = new ArrayList();
                                for (String toUpperCase2 : strArr) {
                                    arrayList.add(toUpperCase2.toUpperCase(Locale.ENGLISH));
                                }
                                list = arrayList;
                            } else {
                                list = Arrays.asList(strArr);
                            }
                        }
                        return m44316a(str, intValue, z, str2, list, intValue != 1 ? str2 : null);
                    }
                }
                toUpperCase = geVar.f29016d;
                str2 = toUpperCase;
                if (geVar.f29018f != null) {
                    strArr = geVar.f29018f;
                    if (z) {
                        arrayList = new ArrayList();
                        while (r3 < r2) {
                            arrayList.add(toUpperCase2.toUpperCase(Locale.ENGLISH));
                        }
                        list = arrayList;
                    } else {
                        list = Arrays.asList(strArr);
                    }
                } else {
                    list = null;
                }
                if (intValue != 1) {
                }
                return m44316a(str, intValue, z, str2, list, intValue != 1 ? str2 : null);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static java.lang.Boolean m44319a(java.math.BigDecimal r7, com.google.android.gms.internal.p213l.gc r8, double r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        com.google.android.gms.common.internal.C2872v.a(r8);
        r0 = r8.f29006c;
        r1 = 0;
        if (r0 == 0) goto L_0x00ed;
    L_0x0008:
        r0 = r8.f29006c;
        r0 = r0.intValue();
        if (r0 != 0) goto L_0x0012;
    L_0x0010:
        goto L_0x00ed;
    L_0x0012:
        r0 = r8.f29006c;
        r0 = r0.intValue();
        r2 = 4;
        if (r0 != r2) goto L_0x0024;
    L_0x001b:
        r0 = r8.f29009f;
        if (r0 == 0) goto L_0x0023;
    L_0x001f:
        r0 = r8.f29010g;
        if (r0 != 0) goto L_0x0029;
    L_0x0023:
        return r1;
    L_0x0024:
        r0 = r8.f29008e;
        if (r0 != 0) goto L_0x0029;
    L_0x0028:
        return r1;
    L_0x0029:
        r0 = r8.f29006c;
        r0 = r0.intValue();
        r3 = r8.f29006c;
        r3 = r3.intValue();
        if (r3 != r2) goto L_0x005a;
    L_0x0037:
        r3 = r8.f29009f;
        r3 = com.google.android.gms.internal.p213l.fs.m44280a(r3);
        if (r3 == 0) goto L_0x0059;
    L_0x003f:
        r3 = r8.f29010g;
        r3 = com.google.android.gms.internal.p213l.fs.m44280a(r3);
        if (r3 != 0) goto L_0x0048;
    L_0x0047:
        goto L_0x0059;
    L_0x0048:
        r3 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0059 }
        r4 = r8.f29009f;	 Catch:{ NumberFormatException -> 0x0059 }
        r3.<init>(r4);	 Catch:{ NumberFormatException -> 0x0059 }
        r4 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0059 }
        r8 = r8.f29010g;	 Catch:{ NumberFormatException -> 0x0059 }
        r4.<init>(r8);	 Catch:{ NumberFormatException -> 0x0059 }
        r8 = r3;
        r3 = r1;
        goto L_0x006c;
    L_0x0059:
        return r1;
    L_0x005a:
        r3 = r8.f29008e;
        r3 = com.google.android.gms.internal.p213l.fs.m44280a(r3);
        if (r3 != 0) goto L_0x0063;
    L_0x0062:
        return r1;
    L_0x0063:
        r3 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x00ed }
        r8 = r8.f29008e;	 Catch:{ NumberFormatException -> 0x00ed }
        r3.<init>(r8);	 Catch:{ NumberFormatException -> 0x00ed }
        r8 = r1;
        r4 = r8;
    L_0x006c:
        if (r0 != r2) goto L_0x0071;
    L_0x006e:
        if (r8 != 0) goto L_0x0073;
    L_0x0070:
        return r1;
    L_0x0071:
        if (r3 == 0) goto L_0x00ed;
    L_0x0073:
        r2 = -1;
        r5 = 0;
        r6 = 1;
        switch(r0) {
            case 1: goto L_0x00e1;
            case 2: goto L_0x00d5;
            case 3: goto L_0x008c;
            case 4: goto L_0x007a;
            default: goto L_0x0079;
        };
    L_0x0079:
        goto L_0x00ed;
    L_0x007a:
        r8 = r7.compareTo(r8);
        if (r8 == r2) goto L_0x0087;
    L_0x0080:
        r7 = r7.compareTo(r4);
        if (r7 == r6) goto L_0x0087;
    L_0x0086:
        r5 = 1;
    L_0x0087:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x008c:
        r0 = 0;
        r8 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r8 == 0) goto L_0x00c9;
    L_0x0092:
        r8 = new java.math.BigDecimal;
        r8.<init>(r9);
        r0 = new java.math.BigDecimal;
        r1 = 2;
        r0.<init>(r1);
        r8 = r8.multiply(r0);
        r8 = r3.subtract(r8);
        r8 = r7.compareTo(r8);
        if (r8 != r6) goto L_0x00c4;
    L_0x00ab:
        r8 = new java.math.BigDecimal;
        r8.<init>(r9);
        r9 = new java.math.BigDecimal;
        r9.<init>(r1);
        r8 = r8.multiply(r9);
        r8 = r3.add(r8);
        r7 = r7.compareTo(r8);
        if (r7 != r2) goto L_0x00c4;
    L_0x00c3:
        r5 = 1;
    L_0x00c4:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00c9:
        r7 = r7.compareTo(r3);
        if (r7 != 0) goto L_0x00d0;
    L_0x00cf:
        r5 = 1;
    L_0x00d0:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00d5:
        r7 = r7.compareTo(r3);
        if (r7 != r6) goto L_0x00dc;
    L_0x00db:
        r5 = 1;
    L_0x00dc:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00e1:
        r7 = r7.compareTo(r3);
        if (r7 != r2) goto L_0x00e8;
    L_0x00e7:
        r5 = 1;
    L_0x00e8:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00ed:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.w.a(java.math.BigDecimal, com.google.android.gms.internal.l.gc, double):java.lang.Boolean");
    }

    /* renamed from: a */
    private final void m44320a(Integer num, Integer num2, gb gbVar, Boolean bool, Boolean bool2) {
        if (gbVar == null) {
            mo4754r().m42565i().m21309a("The leaf filter of event or user property filter is null. audience ID, filter ID", num, num2);
            return;
        }
        boolean z = false;
        boolean z2 = (bool != null && bool.booleanValue()) || (bool2 != null && bool2.booleanValue());
        gbVar.f29004g = Boolean.valueOf(z2);
        if (bool2 != null && bool2.booleanValue()) {
            z = true;
        }
        gbVar.f29005h = Boolean.valueOf(z);
    }

    /* renamed from: a */
    private static void m44321a(Map<Integer, Long> map, int i, long j) {
        Long l = (Long) map.get(Integer.valueOf(i));
        j /= 1000;
        if (l == null || j > l.longValue()) {
            map.put(Integer.valueOf(i), Long.valueOf(j));
        }
    }

    /* renamed from: a */
    private static gj[] m44322a(Map<Integer, Long> map) {
        if (map == null) {
            return null;
        }
        int i = 0;
        gj[] gjVarArr = new gj[map.size()];
        for (Integer num : map.keySet()) {
            gj gjVar = new gj();
            gjVar.f29039c = num;
            gjVar.f29040d = (Long) map.get(num);
            int i2 = i + 1;
            gjVarArr[i] = gjVar;
            i = i2;
        }
        return gjVarArr;
    }

    /* renamed from: a */
    final void m44323a(String str, fz[] fzVarArr) {
        fz[] fzVarArr2 = fzVarArr;
        C2872v.a(fzVarArr);
        for (fz fzVar : fzVarArr2) {
            for (ga gaVar : fzVar.f28990e) {
                String a = C6846a.m32210a(gaVar.f28995d);
                if (a != null) {
                    gaVar.f28995d = a;
                }
                for (gb gbVar : gaVar.f28996e) {
                    String a2 = C6847d.m32211a(gbVar.f29003f);
                    if (a2 != null) {
                        gbVar.f29003f = a2;
                    }
                    m44320a(fzVar.f28988c, gaVar.f28994c, gbVar, fzVar.f28991f, fzVar.f28992g);
                }
            }
            for (gd gdVar : fzVar.f28989d) {
                String a3 = C6848e.m32212a(gdVar.f29013d);
                if (a3 != null) {
                    gdVar.f29013d = a3;
                }
                m44320a(fzVar.f28988c, gdVar.f29012c, gdVar.f29014e, fzVar.f28991f, fzVar.f28992g);
            }
        }
        E_().m43923a(str, fzVarArr2);
    }

    /* renamed from: a */
    final gi[] m44324a(String str, gk[] gkVarArr, gq[] gqVarArr) {
        int intValue;
        BitSet bitSet;
        Map c3211a;
        int length;
        int i;
        int i2;
        Map map;
        Map map2;
        Map map3;
        Object obj;
        Long l;
        long j;
        String str2;
        Object e;
        gk gkVar;
        gk gkVar2;
        gl[] glVarArr;
        gl[] glVarArr2;
        int length2;
        int i3;
        gl glVar;
        gk gkVar3;
        String str3;
        Long l2;
        am a;
        C3211a c3211a2;
        HashSet hashSet;
        gk gkVar4;
        String str4;
        Map map4;
        Map map5;
        Map map6;
        Iterator it;
        int intValue2;
        HashSet hashSet2;
        Map map7;
        gi giVar;
        Map map8;
        Map map9;
        BitSet bitSet2;
        BitSet bitSet3;
        Iterator it2;
        Map map10;
        C3211a c3211a3;
        Map map11;
        BitSet bitSet4;
        Map map12;
        gk gkVar5;
        Map map13;
        Map map14;
        Map map15;
        Map map16;
        Boolean a2;
        bd w;
        Object valueOf;
        Map map17;
        Map map18;
        Map map19;
        C8339w c8339w;
        bd I_;
        C8339w c8339w2 = this;
        String str5 = str;
        gk[] gkVarArr2 = gkVarArr;
        gq[] gqVarArr2 = gqVarArr;
        C2872v.a(str);
        HashSet hashSet3 = new HashSet();
        Map c3211a4 = new C3211a();
        Map c3211a5 = new C3211a();
        Map c3211a6 = new C3211a();
        Map c3211a7 = new C3211a();
        boolean d = mo6215t().m38047d(str5, as.ab);
        Map e2 = E_().m43938e(str5);
        if (e2 != null) {
            Iterator it3 = e2.keySet().iterator();
            while (it3.hasNext()) {
                Map map20;
                Iterator it4;
                BitSet bitSet5;
                intValue = ((Integer) it3.next()).intValue();
                go goVar = (go) e2.get(Integer.valueOf(intValue));
                BitSet bitSet6 = (BitSet) c3211a5.get(Integer.valueOf(intValue));
                bitSet = (BitSet) c3211a6.get(Integer.valueOf(intValue));
                if (d) {
                    c3211a = new C3211a();
                    if (goVar != null) {
                        map20 = e2;
                        if (goVar.f29095e != null) {
                            gj[] gjVarArr = goVar.f29095e;
                            it4 = it3;
                            length = gjVarArr.length;
                            bitSet5 = bitSet;
                            i = 0;
                            while (i < length) {
                                int i4 = length;
                                gj gjVar = gjVarArr[i];
                                gj[] gjVarArr2 = gjVarArr;
                                if (gjVar.f29039c != null) {
                                    c3211a.put(gjVar.f29039c, gjVar.f29040d);
                                }
                                i++;
                                length = i4;
                                gjVarArr = gjVarArr2;
                            }
                            c3211a7.put(Integer.valueOf(intValue), c3211a);
                        }
                    } else {
                        map20 = e2;
                    }
                    it4 = it3;
                    bitSet5 = bitSet;
                    c3211a7.put(Integer.valueOf(intValue), c3211a);
                } else {
                    map20 = e2;
                    it4 = it3;
                    bitSet5 = bitSet;
                    c3211a = null;
                }
                if (bitSet6 == null) {
                    bitSet6 = new BitSet();
                    c3211a5.put(Integer.valueOf(intValue), bitSet6);
                    bitSet = new BitSet();
                    c3211a6.put(Integer.valueOf(intValue), bitSet);
                } else {
                    bitSet = bitSet5;
                }
                i2 = 0;
                while (i2 < (goVar.f29093c.length << 6)) {
                    if (fs.m44281a(goVar.f29093c, i2)) {
                        map = c3211a7;
                        map2 = c3211a6;
                        map3 = c3211a5;
                        mo4754r().m42579w().m21309a("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i2));
                        bitSet.set(i2);
                        if (fs.m44281a(goVar.f29094d, i2)) {
                            bitSet6.set(i2);
                            obj = 1;
                            if (c3211a != null && r1 == null) {
                                c3211a.remove(Integer.valueOf(i2));
                            }
                            i2++;
                            c3211a7 = map;
                            c3211a6 = map2;
                            c3211a5 = map3;
                        }
                    } else {
                        map = c3211a7;
                        map2 = c3211a6;
                        map3 = c3211a5;
                    }
                    obj = null;
                    c3211a.remove(Integer.valueOf(i2));
                    i2++;
                    c3211a7 = map;
                    c3211a6 = map2;
                    c3211a5 = map3;
                }
                map = c3211a7;
                map2 = c3211a6;
                map3 = c3211a5;
                gi giVar2 = new gi();
                c3211a4.put(Integer.valueOf(intValue), giVar2);
                giVar2.f29037f = Boolean.valueOf(false);
                giVar2.f29036e = goVar;
                giVar2.f29035d = new go();
                giVar2.f29035d.f29094d = fs.m44282a(bitSet6);
                giVar2.f29035d.f29093c = fs.m44282a(bitSet);
                if (d) {
                    giVar2.f29035d.f29095e = C8339w.m44322a(c3211a);
                }
                e2 = map20;
                it3 = it4;
                c3211a7 = map;
                c3211a6 = map2;
                c3211a5 = map3;
            }
        }
        map = c3211a7;
        map2 = c3211a6;
        map3 = c3211a5;
        if (gkVarArr2 != null) {
            C3211a c3211a8 = new C3211a();
            int length3 = gkVarArr2.length;
            long j2 = 0;
            gk gkVar6 = null;
            Long l3 = null;
            i = 0;
            while (i < length3) {
                Object obj2;
                int i5;
                int i6;
                boolean z;
                gl[] glVarArr3;
                Map map21;
                gq[] gqVarArr3;
                Map map22;
                Map map23;
                am amVar;
                long j3;
                gk gkVar7;
                Map map24;
                C3211a c3211a9;
                BitSet bitSet7;
                BitSet bitSet8;
                BitSet bitSet9;
                Map map25;
                Object obj3;
                ga gaVar;
                gq[] gqVarArr4;
                BitSet bitSet10;
                ga gaVar2;
                C3211a c3211a10;
                gk gkVar8 = gkVarArr2[i];
                String str6 = gkVar8.f29043d;
                gl[] glVarArr4 = gkVar8.f29042c;
                long j4 = j2;
                if (mo6215t().m38047d(str5, as.f16928V)) {
                    int i7;
                    gk gkVar9;
                    long j5;
                    db E_;
                    SQLiteDatabase i8;
                    gk gkVar10;
                    String[] strArr;
                    gk gkVar11;
                    Pair a3;
                    long longValue;
                    Long l4;
                    G_();
                    Long l5 = (Long) fs.m44284b(gkVar8, "_eid");
                    Object obj4 = l5 != null ? 1 : null;
                    if (obj4 != null) {
                        i7 = i;
                        if (str6.equals("_ep")) {
                            obj2 = 1;
                            if (obj2 == null) {
                                G_();
                                str6 = (String) fs.m44284b(gkVar8, "_en");
                                if (!TextUtils.isEmpty(str6)) {
                                    if (!(gkVar6 == null || l3 == null)) {
                                        if (l5.longValue() != l3.longValue()) {
                                            gkVar9 = gkVar6;
                                            l = l3;
                                            j5 = j4;
                                            j = j5 - 1;
                                            if (j > 0) {
                                                E_ = E_();
                                                E_.mo6210d();
                                                E_.mo4754r().m42579w().m21308a("Clearing complex main event info. appId", str5);
                                                try {
                                                    i8 = E_.m43947i();
                                                    str2 = "delete from main_event_params where app_id=?";
                                                    gkVar10 = gkVar9;
                                                    try {
                                                        strArr = new String[1];
                                                    } catch (SQLiteException e3) {
                                                        e = e3;
                                                        E_.mo4754r().I_().m21308a("Error clearing complex main event", e);
                                                        gkVar = gkVar8;
                                                        i5 = length3;
                                                        i6 = i7;
                                                        gkVar2 = gkVar10;
                                                        z = true;
                                                        glVarArr = new gl[(gkVar2.f29042c.length + glVarArr4.length)];
                                                        glVarArr2 = gkVar2.f29042c;
                                                        length2 = glVarArr2.length;
                                                        i = 0;
                                                        i3 = 0;
                                                        while (i < length2) {
                                                            glVar = glVarArr2[i];
                                                            G_();
                                                            gkVar3 = gkVar2;
                                                            if (fs.m44274a(gkVar, glVar.f29048c) != null) {
                                                                length = i3 + 1;
                                                                glVarArr[i3] = glVar;
                                                                i3 = length;
                                                            }
                                                            i++;
                                                            gkVar2 = gkVar3;
                                                        }
                                                        gkVar3 = gkVar2;
                                                        if (i3 > 0) {
                                                            length = glVarArr4.length;
                                                            intValue = 0;
                                                            while (intValue < length) {
                                                                i = i3 + 1;
                                                                glVarArr[i3] = glVarArr4[intValue];
                                                                intValue++;
                                                                i3 = i;
                                                            }
                                                            if (i3 == glVarArr.length) {
                                                                glVarArr = (gl[]) Arrays.copyOf(glVarArr, i3);
                                                            }
                                                            glVarArr3 = glVarArr;
                                                            str3 = str6;
                                                        } else {
                                                            mo4754r().m42565i().m21308a("No unique parameters in main event. eventName", str6);
                                                            str3 = str6;
                                                            glVarArr3 = glVarArr4;
                                                        }
                                                        l2 = l;
                                                        j4 = j;
                                                        a = E_().m43915a(str5, gkVar.f29043d);
                                                        if (a != null) {
                                                            c3211a2 = c3211a8;
                                                            hashSet = hashSet3;
                                                            map21 = c3211a4;
                                                            gkVar4 = gkVar;
                                                            gqVarArr3 = gqVarArr2;
                                                            str4 = str5;
                                                            map4 = map;
                                                            map22 = map2;
                                                            map23 = map3;
                                                            a = a.m21246a();
                                                        } else {
                                                            mo4754r().m42565i().m21309a("Event aggregate wasn't created during raw event logging. appId, event", bb.m42550a(str), mo6212o().m42528a(str3));
                                                            c3211a2 = c3211a8;
                                                            map4 = map;
                                                            map22 = map2;
                                                            map23 = map3;
                                                            hashSet = hashSet3;
                                                            map21 = c3211a4;
                                                            gkVar4 = gkVar;
                                                            gqVarArr3 = gqVarArr2;
                                                            str4 = str5;
                                                            amVar = new am(str, gkVar.f29043d, 1, 1, gkVar.f29044e.longValue(), 0, null, null, null);
                                                        }
                                                        E_().m43921a(a);
                                                        j3 = a.f16893c;
                                                        c3211a5 = c3211a2;
                                                        map5 = (Map) c3211a5.get(str3);
                                                        if (map5 == null) {
                                                            map5 = E_().m43941f(str4, str3);
                                                            if (map5 == null) {
                                                                map5 = new C3211a();
                                                            }
                                                            c3211a5.put(str3, map5);
                                                        }
                                                        map6 = map5;
                                                        it = map6.keySet().iterator();
                                                        while (it.hasNext()) {
                                                            intValue2 = ((Integer) it.next()).intValue();
                                                            hashSet2 = hashSet;
                                                            if (hashSet2.contains(Integer.valueOf(intValue2))) {
                                                                mo4754r().m42579w().m21308a("Skipping failed audience ID", Integer.valueOf(intValue2));
                                                                hashSet = hashSet2;
                                                            } else {
                                                                map7 = map21;
                                                                giVar = (gi) map7.get(Integer.valueOf(intValue2));
                                                                map8 = map23;
                                                                bitSet = (BitSet) map8.get(Integer.valueOf(intValue2));
                                                                gkVar7 = gkVar4;
                                                                map9 = c3211a5;
                                                                c3211a5 = map22;
                                                                bitSet2 = (BitSet) c3211a5.get(Integer.valueOf(intValue2));
                                                                if (d) {
                                                                    bitSet3 = bitSet2;
                                                                    it2 = it;
                                                                    c3211a4 = map4;
                                                                    map24 = (Map) c3211a4.get(Integer.valueOf(intValue2));
                                                                } else {
                                                                    bitSet3 = bitSet2;
                                                                    it2 = it;
                                                                    c3211a4 = map4;
                                                                    map24 = null;
                                                                }
                                                                if (giVar != null) {
                                                                    map10 = map24;
                                                                    bitSet2 = bitSet3;
                                                                    c3211a9 = map10;
                                                                } else {
                                                                    giVar = new gi();
                                                                    map7.put(Integer.valueOf(intValue2), giVar);
                                                                    giVar.f29037f = Boolean.valueOf(z);
                                                                    bitSet = new BitSet();
                                                                    map8.put(Integer.valueOf(intValue2), bitSet);
                                                                    bitSet7 = new BitSet();
                                                                    map10 = map24;
                                                                    c3211a5.put(Integer.valueOf(intValue2), bitSet7);
                                                                    if (d) {
                                                                        c3211a3 = new C3211a();
                                                                        bitSet8 = bitSet7;
                                                                        c3211a4.put(Integer.valueOf(intValue2), c3211a3);
                                                                        c3211a9 = c3211a3;
                                                                    } else {
                                                                        bitSet8 = bitSet7;
                                                                        c3211a9 = map10;
                                                                    }
                                                                    bitSet2 = bitSet8;
                                                                }
                                                                for (ga gaVar3 : (List) r11.get(Integer.valueOf(intValue2))) {
                                                                    bitSet9 = bitSet2;
                                                                    map11 = map6;
                                                                    if (mo4754r().m42558a(2)) {
                                                                        map25 = map8;
                                                                        mo4754r().m42579w().m21310a("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), gaVar3.f28994c, mo6212o().m42528a(gaVar3.f28995d));
                                                                        mo4754r().m42579w().m21308a("Filter definition", G_().m44286a(gaVar3));
                                                                    } else {
                                                                        map25 = map8;
                                                                    }
                                                                    if (gaVar3.f28994c != null) {
                                                                        if (gaVar3.f28994c.intValue() > 256) {
                                                                            if (d) {
                                                                                if (gaVar3 == null) {
                                                                                }
                                                                                obj3 = null;
                                                                                if (bitSet.get(gaVar3.f28994c.intValue())) {
                                                                                }
                                                                                gaVar = gaVar3;
                                                                                bitSet4 = bitSet9;
                                                                                map12 = c3211a4;
                                                                                gqVarArr4 = gqVarArr;
                                                                                gkVar5 = gkVar7;
                                                                                map13 = c3211a5;
                                                                                bitSet10 = bitSet;
                                                                                map14 = c3211a9;
                                                                                map15 = map7;
                                                                                map16 = map25;
                                                                                gaVar2 = gaVar;
                                                                                a2 = m44313a(gaVar, str3, glVarArr3, j3);
                                                                                mo4754r().m42579w().m21308a("Event filter result", a2 == null ? "null" : a2);
                                                                                if (a2 == null) {
                                                                                    bitSet4.set(gaVar2.f28994c.intValue());
                                                                                    if (a2.booleanValue()) {
                                                                                        bitSet10.set(gaVar2.f28994c.intValue());
                                                                                        C8339w.m44321a(map14, gaVar2.f28994c.intValue(), gkVar5.f29044e.longValue());
                                                                                    }
                                                                                    c3211a9 = map14;
                                                                                    bitSet = bitSet10;
                                                                                    bitSet2 = bitSet4;
                                                                                    gkVar7 = gkVar5;
                                                                                    map6 = map11;
                                                                                    c3211a4 = map12;
                                                                                    c3211a5 = map13;
                                                                                    map7 = map15;
                                                                                    map8 = map16;
                                                                                    gqVarArr3 = gqVarArr;
                                                                                    str4 = str;
                                                                                    c8339w2 = this;
                                                                                }
                                                                            } else {
                                                                                map13 = c3211a5;
                                                                                map12 = c3211a4;
                                                                                map15 = map7;
                                                                                gkVar5 = gkVar7;
                                                                                map14 = c3211a9;
                                                                                bitSet4 = bitSet9;
                                                                                map16 = map25;
                                                                                gaVar2 = gaVar3;
                                                                                bitSet10 = bitSet;
                                                                                if (bitSet10.get(gaVar2.f28994c.intValue())) {
                                                                                    w = mo4754r().m42579w();
                                                                                    str2 = "Event filter already evaluated true. audience ID, filter ID";
                                                                                    valueOf = Integer.valueOf(intValue2);
                                                                                    obj2 = gaVar2.f28994c;
                                                                                    w.m21309a(str2, valueOf, obj2);
                                                                                    c3211a9 = map14;
                                                                                    bitSet = bitSet10;
                                                                                    bitSet2 = bitSet4;
                                                                                    gkVar7 = gkVar5;
                                                                                    map6 = map11;
                                                                                    c3211a4 = map12;
                                                                                    c3211a5 = map13;
                                                                                    map7 = map15;
                                                                                    map8 = map16;
                                                                                    gqVarArr3 = gqVarArr;
                                                                                    str4 = str;
                                                                                    c8339w2 = this;
                                                                                } else {
                                                                                    a2 = m44313a(gaVar2, str3, glVarArr3, j3);
                                                                                    mo4754r().m42579w().m21308a("Event filter result", a2 != null ? a2 : "null");
                                                                                    if (a2 != null) {
                                                                                        bitSet4.set(gaVar2.f28994c.intValue());
                                                                                        if (a2.booleanValue()) {
                                                                                            bitSet10.set(gaVar2.f28994c.intValue());
                                                                                        }
                                                                                        c3211a9 = map14;
                                                                                        bitSet = bitSet10;
                                                                                        bitSet2 = bitSet4;
                                                                                        gkVar7 = gkVar5;
                                                                                        map6 = map11;
                                                                                        c3211a4 = map12;
                                                                                        c3211a5 = map13;
                                                                                        map7 = map15;
                                                                                        map8 = map16;
                                                                                        gqVarArr3 = gqVarArr;
                                                                                        str4 = str;
                                                                                        c8339w2 = this;
                                                                                    }
                                                                                }
                                                                            }
                                                                            hashSet2.add(Integer.valueOf(intValue2));
                                                                            c3211a9 = map14;
                                                                            bitSet = bitSet10;
                                                                            bitSet2 = bitSet4;
                                                                            gkVar7 = gkVar5;
                                                                            map6 = map11;
                                                                            c3211a4 = map12;
                                                                            c3211a5 = map13;
                                                                            map7 = map15;
                                                                            map8 = map16;
                                                                            gqVarArr3 = gqVarArr;
                                                                            str4 = str;
                                                                            c8339w2 = this;
                                                                        }
                                                                    }
                                                                    map13 = c3211a5;
                                                                    map12 = c3211a4;
                                                                    map15 = map7;
                                                                    gkVar5 = gkVar7;
                                                                    map14 = c3211a9;
                                                                    bitSet4 = bitSet9;
                                                                    map16 = map25;
                                                                    gaVar2 = gaVar3;
                                                                    bitSet10 = bitSet;
                                                                    w = mo4754r().m42565i();
                                                                    str2 = "Invalid event filter ID. appId, id";
                                                                    valueOf = bb.m42550a(str);
                                                                    obj2 = String.valueOf(gaVar2.f28994c);
                                                                    w.m21309a(str2, valueOf, obj2);
                                                                    c3211a9 = map14;
                                                                    bitSet = bitSet10;
                                                                    bitSet2 = bitSet4;
                                                                    gkVar7 = gkVar5;
                                                                    map6 = map11;
                                                                    c3211a4 = map12;
                                                                    c3211a5 = map13;
                                                                    map7 = map15;
                                                                    map8 = map16;
                                                                    gqVarArr3 = gqVarArr;
                                                                    str4 = str;
                                                                    c8339w2 = this;
                                                                }
                                                                map12 = c3211a4;
                                                                map23 = map8;
                                                                map22 = c3211a5;
                                                                hashSet = hashSet2;
                                                                map21 = map7;
                                                                gkVar4 = gkVar7;
                                                                c3211a5 = map9;
                                                                it = it2;
                                                                map4 = map12;
                                                                gqVarArr3 = gqVarArr;
                                                                str4 = str;
                                                                c8339w2 = this;
                                                            }
                                                        }
                                                        c3211a10 = c3211a5;
                                                        map13 = map22;
                                                        map12 = map4;
                                                        map16 = map23;
                                                        hashSet2 = hashSet;
                                                        map15 = map21;
                                                        l3 = l2;
                                                        j2 = j4;
                                                        gkVar6 = gkVar3;
                                                        i = i6 + 1;
                                                        gkVarArr2 = gkVarArr;
                                                        hashSet3 = hashSet2;
                                                        length3 = i5;
                                                        c3211a8 = c3211a10;
                                                        map = map12;
                                                        map2 = map13;
                                                        c3211a4 = map15;
                                                        map3 = map16;
                                                        c8339w2 = this;
                                                        gqVarArr2 = gqVarArr;
                                                        str5 = str;
                                                    }
                                                    try {
                                                        strArr[0] = str5;
                                                        i8.execSQL(str2, strArr);
                                                    } catch (SQLiteException e4) {
                                                        e = e4;
                                                        E_.mo4754r().I_().m21308a("Error clearing complex main event", e);
                                                        gkVar = gkVar8;
                                                        i5 = length3;
                                                        i6 = i7;
                                                        gkVar2 = gkVar10;
                                                        z = true;
                                                        glVarArr = new gl[(gkVar2.f29042c.length + glVarArr4.length)];
                                                        glVarArr2 = gkVar2.f29042c;
                                                        length2 = glVarArr2.length;
                                                        i = 0;
                                                        i3 = 0;
                                                        while (i < length2) {
                                                            glVar = glVarArr2[i];
                                                            G_();
                                                            gkVar3 = gkVar2;
                                                            if (fs.m44274a(gkVar, glVar.f29048c) != null) {
                                                                length = i3 + 1;
                                                                glVarArr[i3] = glVar;
                                                                i3 = length;
                                                            }
                                                            i++;
                                                            gkVar2 = gkVar3;
                                                        }
                                                        gkVar3 = gkVar2;
                                                        if (i3 > 0) {
                                                            mo4754r().m42565i().m21308a("No unique parameters in main event. eventName", str6);
                                                            str3 = str6;
                                                            glVarArr3 = glVarArr4;
                                                        } else {
                                                            length = glVarArr4.length;
                                                            intValue = 0;
                                                            while (intValue < length) {
                                                                i = i3 + 1;
                                                                glVarArr[i3] = glVarArr4[intValue];
                                                                intValue++;
                                                                i3 = i;
                                                            }
                                                            if (i3 == glVarArr.length) {
                                                                glVarArr = (gl[]) Arrays.copyOf(glVarArr, i3);
                                                            }
                                                            glVarArr3 = glVarArr;
                                                            str3 = str6;
                                                        }
                                                        l2 = l;
                                                        j4 = j;
                                                        a = E_().m43915a(str5, gkVar.f29043d);
                                                        if (a != null) {
                                                            mo4754r().m42565i().m21309a("Event aggregate wasn't created during raw event logging. appId, event", bb.m42550a(str), mo6212o().m42528a(str3));
                                                            c3211a2 = c3211a8;
                                                            map4 = map;
                                                            map22 = map2;
                                                            map23 = map3;
                                                            hashSet = hashSet3;
                                                            map21 = c3211a4;
                                                            gkVar4 = gkVar;
                                                            gqVarArr3 = gqVarArr2;
                                                            str4 = str5;
                                                            amVar = new am(str, gkVar.f29043d, 1, 1, gkVar.f29044e.longValue(), 0, null, null, null);
                                                        } else {
                                                            c3211a2 = c3211a8;
                                                            hashSet = hashSet3;
                                                            map21 = c3211a4;
                                                            gkVar4 = gkVar;
                                                            gqVarArr3 = gqVarArr2;
                                                            str4 = str5;
                                                            map4 = map;
                                                            map22 = map2;
                                                            map23 = map3;
                                                            a = a.m21246a();
                                                        }
                                                        E_().m43921a(a);
                                                        j3 = a.f16893c;
                                                        c3211a5 = c3211a2;
                                                        map5 = (Map) c3211a5.get(str3);
                                                        if (map5 == null) {
                                                            map5 = E_().m43941f(str4, str3);
                                                            if (map5 == null) {
                                                                map5 = new C3211a();
                                                            }
                                                            c3211a5.put(str3, map5);
                                                        }
                                                        map6 = map5;
                                                        it = map6.keySet().iterator();
                                                        while (it.hasNext()) {
                                                            intValue2 = ((Integer) it.next()).intValue();
                                                            hashSet2 = hashSet;
                                                            if (hashSet2.contains(Integer.valueOf(intValue2))) {
                                                                mo4754r().m42579w().m21308a("Skipping failed audience ID", Integer.valueOf(intValue2));
                                                                hashSet = hashSet2;
                                                            } else {
                                                                map7 = map21;
                                                                giVar = (gi) map7.get(Integer.valueOf(intValue2));
                                                                map8 = map23;
                                                                bitSet = (BitSet) map8.get(Integer.valueOf(intValue2));
                                                                gkVar7 = gkVar4;
                                                                map9 = c3211a5;
                                                                c3211a5 = map22;
                                                                bitSet2 = (BitSet) c3211a5.get(Integer.valueOf(intValue2));
                                                                if (d) {
                                                                    bitSet3 = bitSet2;
                                                                    it2 = it;
                                                                    c3211a4 = map4;
                                                                    map24 = (Map) c3211a4.get(Integer.valueOf(intValue2));
                                                                } else {
                                                                    bitSet3 = bitSet2;
                                                                    it2 = it;
                                                                    c3211a4 = map4;
                                                                    map24 = null;
                                                                }
                                                                if (giVar != null) {
                                                                    giVar = new gi();
                                                                    map7.put(Integer.valueOf(intValue2), giVar);
                                                                    giVar.f29037f = Boolean.valueOf(z);
                                                                    bitSet = new BitSet();
                                                                    map8.put(Integer.valueOf(intValue2), bitSet);
                                                                    bitSet7 = new BitSet();
                                                                    map10 = map24;
                                                                    c3211a5.put(Integer.valueOf(intValue2), bitSet7);
                                                                    if (d) {
                                                                        c3211a3 = new C3211a();
                                                                        bitSet8 = bitSet7;
                                                                        c3211a4.put(Integer.valueOf(intValue2), c3211a3);
                                                                        c3211a9 = c3211a3;
                                                                    } else {
                                                                        bitSet8 = bitSet7;
                                                                        c3211a9 = map10;
                                                                    }
                                                                    bitSet2 = bitSet8;
                                                                } else {
                                                                    map10 = map24;
                                                                    bitSet2 = bitSet3;
                                                                    c3211a9 = map10;
                                                                }
                                                                for (ga gaVar32 : (List) r11.get(Integer.valueOf(intValue2))) {
                                                                    bitSet9 = bitSet2;
                                                                    map11 = map6;
                                                                    if (mo4754r().m42558a(2)) {
                                                                        map25 = map8;
                                                                        mo4754r().m42579w().m21310a("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), gaVar32.f28994c, mo6212o().m42528a(gaVar32.f28995d));
                                                                        mo4754r().m42579w().m21308a("Filter definition", G_().m44286a(gaVar32));
                                                                    } else {
                                                                        map25 = map8;
                                                                    }
                                                                    if (gaVar32.f28994c != null) {
                                                                        if (gaVar32.f28994c.intValue() > 256) {
                                                                            if (d) {
                                                                                if (gaVar32 == null) {
                                                                                }
                                                                                obj3 = null;
                                                                                if (bitSet.get(gaVar32.f28994c.intValue())) {
                                                                                }
                                                                                gaVar = gaVar32;
                                                                                bitSet4 = bitSet9;
                                                                                map12 = c3211a4;
                                                                                gqVarArr4 = gqVarArr;
                                                                                gkVar5 = gkVar7;
                                                                                map13 = c3211a5;
                                                                                bitSet10 = bitSet;
                                                                                map14 = c3211a9;
                                                                                map15 = map7;
                                                                                map16 = map25;
                                                                                gaVar2 = gaVar;
                                                                                a2 = m44313a(gaVar, str3, glVarArr3, j3);
                                                                                if (a2 == null) {
                                                                                }
                                                                                mo4754r().m42579w().m21308a("Event filter result", a2 == null ? "null" : a2);
                                                                                if (a2 == null) {
                                                                                    bitSet4.set(gaVar2.f28994c.intValue());
                                                                                    if (a2.booleanValue()) {
                                                                                        bitSet10.set(gaVar2.f28994c.intValue());
                                                                                        C8339w.m44321a(map14, gaVar2.f28994c.intValue(), gkVar5.f29044e.longValue());
                                                                                    }
                                                                                    c3211a9 = map14;
                                                                                    bitSet = bitSet10;
                                                                                    bitSet2 = bitSet4;
                                                                                    gkVar7 = gkVar5;
                                                                                    map6 = map11;
                                                                                    c3211a4 = map12;
                                                                                    c3211a5 = map13;
                                                                                    map7 = map15;
                                                                                    map8 = map16;
                                                                                    gqVarArr3 = gqVarArr;
                                                                                    str4 = str;
                                                                                    c8339w2 = this;
                                                                                }
                                                                            } else {
                                                                                map13 = c3211a5;
                                                                                map12 = c3211a4;
                                                                                map15 = map7;
                                                                                gkVar5 = gkVar7;
                                                                                map14 = c3211a9;
                                                                                bitSet4 = bitSet9;
                                                                                map16 = map25;
                                                                                gaVar2 = gaVar32;
                                                                                bitSet10 = bitSet;
                                                                                if (bitSet10.get(gaVar2.f28994c.intValue())) {
                                                                                    w = mo4754r().m42579w();
                                                                                    str2 = "Event filter already evaluated true. audience ID, filter ID";
                                                                                    valueOf = Integer.valueOf(intValue2);
                                                                                    obj2 = gaVar2.f28994c;
                                                                                    w.m21309a(str2, valueOf, obj2);
                                                                                    c3211a9 = map14;
                                                                                    bitSet = bitSet10;
                                                                                    bitSet2 = bitSet4;
                                                                                    gkVar7 = gkVar5;
                                                                                    map6 = map11;
                                                                                    c3211a4 = map12;
                                                                                    c3211a5 = map13;
                                                                                    map7 = map15;
                                                                                    map8 = map16;
                                                                                    gqVarArr3 = gqVarArr;
                                                                                    str4 = str;
                                                                                    c8339w2 = this;
                                                                                } else {
                                                                                    a2 = m44313a(gaVar2, str3, glVarArr3, j3);
                                                                                    if (a2 != null) {
                                                                                    }
                                                                                    mo4754r().m42579w().m21308a("Event filter result", a2 != null ? a2 : "null");
                                                                                    if (a2 != null) {
                                                                                        bitSet4.set(gaVar2.f28994c.intValue());
                                                                                        if (a2.booleanValue()) {
                                                                                            bitSet10.set(gaVar2.f28994c.intValue());
                                                                                        }
                                                                                        c3211a9 = map14;
                                                                                        bitSet = bitSet10;
                                                                                        bitSet2 = bitSet4;
                                                                                        gkVar7 = gkVar5;
                                                                                        map6 = map11;
                                                                                        c3211a4 = map12;
                                                                                        c3211a5 = map13;
                                                                                        map7 = map15;
                                                                                        map8 = map16;
                                                                                        gqVarArr3 = gqVarArr;
                                                                                        str4 = str;
                                                                                        c8339w2 = this;
                                                                                    }
                                                                                }
                                                                            }
                                                                            hashSet2.add(Integer.valueOf(intValue2));
                                                                            c3211a9 = map14;
                                                                            bitSet = bitSet10;
                                                                            bitSet2 = bitSet4;
                                                                            gkVar7 = gkVar5;
                                                                            map6 = map11;
                                                                            c3211a4 = map12;
                                                                            c3211a5 = map13;
                                                                            map7 = map15;
                                                                            map8 = map16;
                                                                            gqVarArr3 = gqVarArr;
                                                                            str4 = str;
                                                                            c8339w2 = this;
                                                                        }
                                                                    }
                                                                    map13 = c3211a5;
                                                                    map12 = c3211a4;
                                                                    map15 = map7;
                                                                    gkVar5 = gkVar7;
                                                                    map14 = c3211a9;
                                                                    bitSet4 = bitSet9;
                                                                    map16 = map25;
                                                                    gaVar2 = gaVar32;
                                                                    bitSet10 = bitSet;
                                                                    w = mo4754r().m42565i();
                                                                    str2 = "Invalid event filter ID. appId, id";
                                                                    valueOf = bb.m42550a(str);
                                                                    obj2 = String.valueOf(gaVar2.f28994c);
                                                                    w.m21309a(str2, valueOf, obj2);
                                                                    c3211a9 = map14;
                                                                    bitSet = bitSet10;
                                                                    bitSet2 = bitSet4;
                                                                    gkVar7 = gkVar5;
                                                                    map6 = map11;
                                                                    c3211a4 = map12;
                                                                    c3211a5 = map13;
                                                                    map7 = map15;
                                                                    map8 = map16;
                                                                    gqVarArr3 = gqVarArr;
                                                                    str4 = str;
                                                                    c8339w2 = this;
                                                                }
                                                                map12 = c3211a4;
                                                                map23 = map8;
                                                                map22 = c3211a5;
                                                                hashSet = hashSet2;
                                                                map21 = map7;
                                                                gkVar4 = gkVar7;
                                                                c3211a5 = map9;
                                                                it = it2;
                                                                map4 = map12;
                                                                gqVarArr3 = gqVarArr;
                                                                str4 = str;
                                                                c8339w2 = this;
                                                            }
                                                        }
                                                        c3211a10 = c3211a5;
                                                        map13 = map22;
                                                        map12 = map4;
                                                        map16 = map23;
                                                        hashSet2 = hashSet;
                                                        map15 = map21;
                                                        l3 = l2;
                                                        j2 = j4;
                                                        gkVar6 = gkVar3;
                                                        i = i6 + 1;
                                                        gkVarArr2 = gkVarArr;
                                                        hashSet3 = hashSet2;
                                                        length3 = i5;
                                                        c3211a8 = c3211a10;
                                                        map = map12;
                                                        map2 = map13;
                                                        c3211a4 = map15;
                                                        map3 = map16;
                                                        c8339w2 = this;
                                                        gqVarArr2 = gqVarArr;
                                                        str5 = str;
                                                    }
                                                } catch (SQLiteException e5) {
                                                    e = e5;
                                                    gkVar10 = gkVar9;
                                                    E_.mo4754r().I_().m21308a("Error clearing complex main event", e);
                                                    gkVar = gkVar8;
                                                    i5 = length3;
                                                    i6 = i7;
                                                    gkVar2 = gkVar10;
                                                    z = true;
                                                    glVarArr = new gl[(gkVar2.f29042c.length + glVarArr4.length)];
                                                    glVarArr2 = gkVar2.f29042c;
                                                    length2 = glVarArr2.length;
                                                    i = 0;
                                                    i3 = 0;
                                                    while (i < length2) {
                                                        glVar = glVarArr2[i];
                                                        G_();
                                                        gkVar3 = gkVar2;
                                                        if (fs.m44274a(gkVar, glVar.f29048c) != null) {
                                                            length = i3 + 1;
                                                            glVarArr[i3] = glVar;
                                                            i3 = length;
                                                        }
                                                        i++;
                                                        gkVar2 = gkVar3;
                                                    }
                                                    gkVar3 = gkVar2;
                                                    if (i3 > 0) {
                                                        length = glVarArr4.length;
                                                        intValue = 0;
                                                        while (intValue < length) {
                                                            i = i3 + 1;
                                                            glVarArr[i3] = glVarArr4[intValue];
                                                            intValue++;
                                                            i3 = i;
                                                        }
                                                        if (i3 == glVarArr.length) {
                                                            glVarArr = (gl[]) Arrays.copyOf(glVarArr, i3);
                                                        }
                                                        glVarArr3 = glVarArr;
                                                        str3 = str6;
                                                    } else {
                                                        mo4754r().m42565i().m21308a("No unique parameters in main event. eventName", str6);
                                                        str3 = str6;
                                                        glVarArr3 = glVarArr4;
                                                    }
                                                    l2 = l;
                                                    j4 = j;
                                                    a = E_().m43915a(str5, gkVar.f29043d);
                                                    if (a != null) {
                                                        c3211a2 = c3211a8;
                                                        hashSet = hashSet3;
                                                        map21 = c3211a4;
                                                        gkVar4 = gkVar;
                                                        gqVarArr3 = gqVarArr2;
                                                        str4 = str5;
                                                        map4 = map;
                                                        map22 = map2;
                                                        map23 = map3;
                                                        a = a.m21246a();
                                                    } else {
                                                        mo4754r().m42565i().m21309a("Event aggregate wasn't created during raw event logging. appId, event", bb.m42550a(str), mo6212o().m42528a(str3));
                                                        c3211a2 = c3211a8;
                                                        map4 = map;
                                                        map22 = map2;
                                                        map23 = map3;
                                                        hashSet = hashSet3;
                                                        map21 = c3211a4;
                                                        gkVar4 = gkVar;
                                                        gqVarArr3 = gqVarArr2;
                                                        str4 = str5;
                                                        amVar = new am(str, gkVar.f29043d, 1, 1, gkVar.f29044e.longValue(), 0, null, null, null);
                                                    }
                                                    E_().m43921a(a);
                                                    j3 = a.f16893c;
                                                    c3211a5 = c3211a2;
                                                    map5 = (Map) c3211a5.get(str3);
                                                    if (map5 == null) {
                                                        map5 = E_().m43941f(str4, str3);
                                                        if (map5 == null) {
                                                            map5 = new C3211a();
                                                        }
                                                        c3211a5.put(str3, map5);
                                                    }
                                                    map6 = map5;
                                                    it = map6.keySet().iterator();
                                                    while (it.hasNext()) {
                                                        intValue2 = ((Integer) it.next()).intValue();
                                                        hashSet2 = hashSet;
                                                        if (hashSet2.contains(Integer.valueOf(intValue2))) {
                                                            map7 = map21;
                                                            giVar = (gi) map7.get(Integer.valueOf(intValue2));
                                                            map8 = map23;
                                                            bitSet = (BitSet) map8.get(Integer.valueOf(intValue2));
                                                            gkVar7 = gkVar4;
                                                            map9 = c3211a5;
                                                            c3211a5 = map22;
                                                            bitSet2 = (BitSet) c3211a5.get(Integer.valueOf(intValue2));
                                                            if (d) {
                                                                bitSet3 = bitSet2;
                                                                it2 = it;
                                                                c3211a4 = map4;
                                                                map24 = null;
                                                            } else {
                                                                bitSet3 = bitSet2;
                                                                it2 = it;
                                                                c3211a4 = map4;
                                                                map24 = (Map) c3211a4.get(Integer.valueOf(intValue2));
                                                            }
                                                            if (giVar != null) {
                                                                map10 = map24;
                                                                bitSet2 = bitSet3;
                                                                c3211a9 = map10;
                                                            } else {
                                                                giVar = new gi();
                                                                map7.put(Integer.valueOf(intValue2), giVar);
                                                                giVar.f29037f = Boolean.valueOf(z);
                                                                bitSet = new BitSet();
                                                                map8.put(Integer.valueOf(intValue2), bitSet);
                                                                bitSet7 = new BitSet();
                                                                map10 = map24;
                                                                c3211a5.put(Integer.valueOf(intValue2), bitSet7);
                                                                if (d) {
                                                                    bitSet8 = bitSet7;
                                                                    c3211a9 = map10;
                                                                } else {
                                                                    c3211a3 = new C3211a();
                                                                    bitSet8 = bitSet7;
                                                                    c3211a4.put(Integer.valueOf(intValue2), c3211a3);
                                                                    c3211a9 = c3211a3;
                                                                }
                                                                bitSet2 = bitSet8;
                                                            }
                                                            for (ga gaVar322 : (List) r11.get(Integer.valueOf(intValue2))) {
                                                                bitSet9 = bitSet2;
                                                                map11 = map6;
                                                                if (mo4754r().m42558a(2)) {
                                                                    map25 = map8;
                                                                } else {
                                                                    map25 = map8;
                                                                    mo4754r().m42579w().m21310a("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), gaVar322.f28994c, mo6212o().m42528a(gaVar322.f28995d));
                                                                    mo4754r().m42579w().m21308a("Filter definition", G_().m44286a(gaVar322));
                                                                }
                                                                if (gaVar322.f28994c != null) {
                                                                    if (gaVar322.f28994c.intValue() > 256) {
                                                                        if (d) {
                                                                            map13 = c3211a5;
                                                                            map12 = c3211a4;
                                                                            map15 = map7;
                                                                            gkVar5 = gkVar7;
                                                                            map14 = c3211a9;
                                                                            bitSet4 = bitSet9;
                                                                            map16 = map25;
                                                                            gaVar2 = gaVar322;
                                                                            bitSet10 = bitSet;
                                                                            if (bitSet10.get(gaVar2.f28994c.intValue())) {
                                                                                a2 = m44313a(gaVar2, str3, glVarArr3, j3);
                                                                                if (a2 != null) {
                                                                                }
                                                                                mo4754r().m42579w().m21308a("Event filter result", a2 != null ? a2 : "null");
                                                                                if (a2 != null) {
                                                                                    bitSet4.set(gaVar2.f28994c.intValue());
                                                                                    if (a2.booleanValue()) {
                                                                                        bitSet10.set(gaVar2.f28994c.intValue());
                                                                                    }
                                                                                    c3211a9 = map14;
                                                                                    bitSet = bitSet10;
                                                                                    bitSet2 = bitSet4;
                                                                                    gkVar7 = gkVar5;
                                                                                    map6 = map11;
                                                                                    c3211a4 = map12;
                                                                                    c3211a5 = map13;
                                                                                    map7 = map15;
                                                                                    map8 = map16;
                                                                                    gqVarArr3 = gqVarArr;
                                                                                    str4 = str;
                                                                                    c8339w2 = this;
                                                                                }
                                                                            } else {
                                                                                w = mo4754r().m42579w();
                                                                                str2 = "Event filter already evaluated true. audience ID, filter ID";
                                                                                valueOf = Integer.valueOf(intValue2);
                                                                                obj2 = gaVar2.f28994c;
                                                                                w.m21309a(str2, valueOf, obj2);
                                                                                c3211a9 = map14;
                                                                                bitSet = bitSet10;
                                                                                bitSet2 = bitSet4;
                                                                                gkVar7 = gkVar5;
                                                                                map6 = map11;
                                                                                c3211a4 = map12;
                                                                                c3211a5 = map13;
                                                                                map7 = map15;
                                                                                map8 = map16;
                                                                                gqVarArr3 = gqVarArr;
                                                                                str4 = str;
                                                                                c8339w2 = this;
                                                                            }
                                                                        } else {
                                                                            if (gaVar322 == null) {
                                                                            }
                                                                            obj3 = null;
                                                                            if (bitSet.get(gaVar322.f28994c.intValue())) {
                                                                            }
                                                                            gaVar = gaVar322;
                                                                            bitSet4 = bitSet9;
                                                                            map12 = c3211a4;
                                                                            gqVarArr4 = gqVarArr;
                                                                            gkVar5 = gkVar7;
                                                                            map13 = c3211a5;
                                                                            bitSet10 = bitSet;
                                                                            map14 = c3211a9;
                                                                            map15 = map7;
                                                                            map16 = map25;
                                                                            gaVar2 = gaVar;
                                                                            a2 = m44313a(gaVar, str3, glVarArr3, j3);
                                                                            if (a2 == null) {
                                                                            }
                                                                            mo4754r().m42579w().m21308a("Event filter result", a2 == null ? "null" : a2);
                                                                            if (a2 == null) {
                                                                                bitSet4.set(gaVar2.f28994c.intValue());
                                                                                if (a2.booleanValue()) {
                                                                                    bitSet10.set(gaVar2.f28994c.intValue());
                                                                                    C8339w.m44321a(map14, gaVar2.f28994c.intValue(), gkVar5.f29044e.longValue());
                                                                                }
                                                                                c3211a9 = map14;
                                                                                bitSet = bitSet10;
                                                                                bitSet2 = bitSet4;
                                                                                gkVar7 = gkVar5;
                                                                                map6 = map11;
                                                                                c3211a4 = map12;
                                                                                c3211a5 = map13;
                                                                                map7 = map15;
                                                                                map8 = map16;
                                                                                gqVarArr3 = gqVarArr;
                                                                                str4 = str;
                                                                                c8339w2 = this;
                                                                            }
                                                                        }
                                                                        hashSet2.add(Integer.valueOf(intValue2));
                                                                        c3211a9 = map14;
                                                                        bitSet = bitSet10;
                                                                        bitSet2 = bitSet4;
                                                                        gkVar7 = gkVar5;
                                                                        map6 = map11;
                                                                        c3211a4 = map12;
                                                                        c3211a5 = map13;
                                                                        map7 = map15;
                                                                        map8 = map16;
                                                                        gqVarArr3 = gqVarArr;
                                                                        str4 = str;
                                                                        c8339w2 = this;
                                                                    }
                                                                }
                                                                map13 = c3211a5;
                                                                map12 = c3211a4;
                                                                map15 = map7;
                                                                gkVar5 = gkVar7;
                                                                map14 = c3211a9;
                                                                bitSet4 = bitSet9;
                                                                map16 = map25;
                                                                gaVar2 = gaVar322;
                                                                bitSet10 = bitSet;
                                                                w = mo4754r().m42565i();
                                                                str2 = "Invalid event filter ID. appId, id";
                                                                valueOf = bb.m42550a(str);
                                                                obj2 = String.valueOf(gaVar2.f28994c);
                                                                w.m21309a(str2, valueOf, obj2);
                                                                c3211a9 = map14;
                                                                bitSet = bitSet10;
                                                                bitSet2 = bitSet4;
                                                                gkVar7 = gkVar5;
                                                                map6 = map11;
                                                                c3211a4 = map12;
                                                                c3211a5 = map13;
                                                                map7 = map15;
                                                                map8 = map16;
                                                                gqVarArr3 = gqVarArr;
                                                                str4 = str;
                                                                c8339w2 = this;
                                                            }
                                                            map12 = c3211a4;
                                                            map23 = map8;
                                                            map22 = c3211a5;
                                                            hashSet = hashSet2;
                                                            map21 = map7;
                                                            gkVar4 = gkVar7;
                                                            c3211a5 = map9;
                                                            it = it2;
                                                            map4 = map12;
                                                            gqVarArr3 = gqVarArr;
                                                            str4 = str;
                                                            c8339w2 = this;
                                                        } else {
                                                            mo4754r().m42579w().m21308a("Skipping failed audience ID", Integer.valueOf(intValue2));
                                                            hashSet = hashSet2;
                                                        }
                                                    }
                                                    c3211a10 = c3211a5;
                                                    map13 = map22;
                                                    map12 = map4;
                                                    map16 = map23;
                                                    hashSet2 = hashSet;
                                                    map15 = map21;
                                                    l3 = l2;
                                                    j2 = j4;
                                                    gkVar6 = gkVar3;
                                                    i = i6 + 1;
                                                    gkVarArr2 = gkVarArr;
                                                    hashSet3 = hashSet2;
                                                    length3 = i5;
                                                    c3211a8 = c3211a10;
                                                    map = map12;
                                                    map2 = map13;
                                                    c3211a4 = map15;
                                                    map3 = map16;
                                                    c8339w2 = this;
                                                    gqVarArr2 = gqVarArr;
                                                    str5 = str;
                                                }
                                                gkVar = gkVar8;
                                                i5 = length3;
                                                i6 = i7;
                                                gkVar2 = gkVar10;
                                                z = true;
                                            } else {
                                                gkVar = gkVar8;
                                                i6 = i7;
                                                gkVar11 = gkVar9;
                                                z = true;
                                                i5 = length3;
                                                E_().m43929a(str, l5, j, gkVar11);
                                                gkVar2 = gkVar11;
                                            }
                                            glVarArr = new gl[(gkVar2.f29042c.length + glVarArr4.length)];
                                            glVarArr2 = gkVar2.f29042c;
                                            length2 = glVarArr2.length;
                                            i = 0;
                                            i3 = 0;
                                            while (i < length2) {
                                                glVar = glVarArr2[i];
                                                G_();
                                                gkVar3 = gkVar2;
                                                if (fs.m44274a(gkVar, glVar.f29048c) != null) {
                                                    length = i3 + 1;
                                                    glVarArr[i3] = glVar;
                                                    i3 = length;
                                                }
                                                i++;
                                                gkVar2 = gkVar3;
                                            }
                                            gkVar3 = gkVar2;
                                            if (i3 > 0) {
                                                length = glVarArr4.length;
                                                intValue = 0;
                                                while (intValue < length) {
                                                    i = i3 + 1;
                                                    glVarArr[i3] = glVarArr4[intValue];
                                                    intValue++;
                                                    i3 = i;
                                                }
                                                if (i3 == glVarArr.length) {
                                                    glVarArr = (gl[]) Arrays.copyOf(glVarArr, i3);
                                                }
                                                glVarArr3 = glVarArr;
                                                str3 = str6;
                                            } else {
                                                mo4754r().m42565i().m21308a("No unique parameters in main event. eventName", str6);
                                                str3 = str6;
                                                glVarArr3 = glVarArr4;
                                            }
                                            l2 = l;
                                            j4 = j;
                                        }
                                    }
                                    a3 = E_().m43913a(str5, l5);
                                    if (a3 != null) {
                                        if (a3.first == null) {
                                            gkVar6 = (gk) a3.first;
                                            j5 = ((Long) a3.second).longValue();
                                            G_();
                                            l = (Long) fs.m44284b(gkVar6, "_eid");
                                            gkVar9 = gkVar6;
                                            j = j5 - 1;
                                            if (j > 0) {
                                                gkVar = gkVar8;
                                                i6 = i7;
                                                gkVar11 = gkVar9;
                                                z = true;
                                                i5 = length3;
                                                E_().m43929a(str, l5, j, gkVar11);
                                                gkVar2 = gkVar11;
                                            } else {
                                                E_ = E_();
                                                E_.mo6210d();
                                                E_.mo4754r().m42579w().m21308a("Clearing complex main event info. appId", str5);
                                                i8 = E_.m43947i();
                                                str2 = "delete from main_event_params where app_id=?";
                                                gkVar10 = gkVar9;
                                                strArr = new String[1];
                                                strArr[0] = str5;
                                                i8.execSQL(str2, strArr);
                                                gkVar = gkVar8;
                                                i5 = length3;
                                                i6 = i7;
                                                gkVar2 = gkVar10;
                                                z = true;
                                            }
                                            glVarArr = new gl[(gkVar2.f29042c.length + glVarArr4.length)];
                                            glVarArr2 = gkVar2.f29042c;
                                            length2 = glVarArr2.length;
                                            i = 0;
                                            i3 = 0;
                                            while (i < length2) {
                                                glVar = glVarArr2[i];
                                                G_();
                                                gkVar3 = gkVar2;
                                                if (fs.m44274a(gkVar, glVar.f29048c) != null) {
                                                    length = i3 + 1;
                                                    glVarArr[i3] = glVar;
                                                    i3 = length;
                                                }
                                                i++;
                                                gkVar2 = gkVar3;
                                            }
                                            gkVar3 = gkVar2;
                                            if (i3 > 0) {
                                                mo4754r().m42565i().m21308a("No unique parameters in main event. eventName", str6);
                                                str3 = str6;
                                                glVarArr3 = glVarArr4;
                                            } else {
                                                length = glVarArr4.length;
                                                intValue = 0;
                                                while (intValue < length) {
                                                    i = i3 + 1;
                                                    glVarArr[i3] = glVarArr4[intValue];
                                                    intValue++;
                                                    i3 = i;
                                                }
                                                if (i3 == glVarArr.length) {
                                                    glVarArr = (gl[]) Arrays.copyOf(glVarArr, i3);
                                                }
                                                glVarArr3 = glVarArr;
                                                str3 = str6;
                                            }
                                            l2 = l;
                                            j4 = j;
                                        }
                                    }
                                    i5 = length3;
                                    i6 = i7;
                                    mo4754r().I_().m21309a("Extra parameter without existing main event. eventName, eventId", str6, l5);
                                } else {
                                    mo4754r().I_().m21308a("Extra parameter without an event name. eventId", l5);
                                    i5 = length3;
                                    i6 = i7;
                                }
                                c3211a10 = c3211a8;
                                hashSet2 = hashSet3;
                                map15 = c3211a4;
                                map12 = map;
                                map13 = map2;
                                map16 = map3;
                                j2 = j4;
                                i = i6 + 1;
                                gkVarArr2 = gkVarArr;
                                hashSet3 = hashSet2;
                                length3 = i5;
                                c3211a8 = c3211a10;
                                map = map12;
                                map2 = map13;
                                c3211a4 = map15;
                                map3 = map16;
                                c8339w2 = this;
                                gqVarArr2 = gqVarArr;
                                str5 = str;
                            } else {
                                gkVar = gkVar8;
                                i5 = length3;
                                i6 = i7;
                                z = true;
                                if (obj4 != null) {
                                    G_();
                                    l3 = Long.valueOf(0);
                                    e = fs.m44284b(gkVar, "_epc");
                                    if (e == null) {
                                        e = l3;
                                    }
                                    longValue = ((Long) e).longValue();
                                    if (longValue > 0) {
                                        mo4754r().m42565i().m21308a("Complex event with zero extra param count. eventName", str6);
                                        l4 = l5;
                                    } else {
                                        l4 = l5;
                                        E_().m43929a(str, l5, longValue, gkVar);
                                    }
                                    l2 = l4;
                                    str3 = str6;
                                    glVarArr3 = glVarArr4;
                                    gkVar3 = gkVar;
                                    j4 = longValue;
                                }
                            }
                            a = E_().m43915a(str5, gkVar.f29043d);
                            if (a != null) {
                                mo4754r().m42565i().m21309a("Event aggregate wasn't created during raw event logging. appId, event", bb.m42550a(str), mo6212o().m42528a(str3));
                                c3211a2 = c3211a8;
                                map4 = map;
                                map22 = map2;
                                map23 = map3;
                                hashSet = hashSet3;
                                map21 = c3211a4;
                                gkVar4 = gkVar;
                                gqVarArr3 = gqVarArr2;
                                str4 = str5;
                                amVar = new am(str, gkVar.f29043d, 1, 1, gkVar.f29044e.longValue(), 0, null, null, null);
                            } else {
                                c3211a2 = c3211a8;
                                hashSet = hashSet3;
                                map21 = c3211a4;
                                gkVar4 = gkVar;
                                gqVarArr3 = gqVarArr2;
                                str4 = str5;
                                map4 = map;
                                map22 = map2;
                                map23 = map3;
                                a = a.m21246a();
                            }
                            E_().m43921a(a);
                            j3 = a.f16893c;
                            c3211a5 = c3211a2;
                            map5 = (Map) c3211a5.get(str3);
                            if (map5 == null) {
                                map5 = E_().m43941f(str4, str3);
                                if (map5 == null) {
                                    map5 = new C3211a();
                                }
                                c3211a5.put(str3, map5);
                            }
                            map6 = map5;
                            it = map6.keySet().iterator();
                            while (it.hasNext()) {
                                intValue2 = ((Integer) it.next()).intValue();
                                hashSet2 = hashSet;
                                if (hashSet2.contains(Integer.valueOf(intValue2))) {
                                    mo4754r().m42579w().m21308a("Skipping failed audience ID", Integer.valueOf(intValue2));
                                    hashSet = hashSet2;
                                } else {
                                    map7 = map21;
                                    giVar = (gi) map7.get(Integer.valueOf(intValue2));
                                    map8 = map23;
                                    bitSet = (BitSet) map8.get(Integer.valueOf(intValue2));
                                    gkVar7 = gkVar4;
                                    map9 = c3211a5;
                                    c3211a5 = map22;
                                    bitSet2 = (BitSet) c3211a5.get(Integer.valueOf(intValue2));
                                    if (d) {
                                        bitSet3 = bitSet2;
                                        it2 = it;
                                        c3211a4 = map4;
                                        map24 = (Map) c3211a4.get(Integer.valueOf(intValue2));
                                    } else {
                                        bitSet3 = bitSet2;
                                        it2 = it;
                                        c3211a4 = map4;
                                        map24 = null;
                                    }
                                    if (giVar != null) {
                                        giVar = new gi();
                                        map7.put(Integer.valueOf(intValue2), giVar);
                                        giVar.f29037f = Boolean.valueOf(z);
                                        bitSet = new BitSet();
                                        map8.put(Integer.valueOf(intValue2), bitSet);
                                        bitSet7 = new BitSet();
                                        map10 = map24;
                                        c3211a5.put(Integer.valueOf(intValue2), bitSet7);
                                        if (d) {
                                            c3211a3 = new C3211a();
                                            bitSet8 = bitSet7;
                                            c3211a4.put(Integer.valueOf(intValue2), c3211a3);
                                            c3211a9 = c3211a3;
                                        } else {
                                            bitSet8 = bitSet7;
                                            c3211a9 = map10;
                                        }
                                        bitSet2 = bitSet8;
                                    } else {
                                        map10 = map24;
                                        bitSet2 = bitSet3;
                                        c3211a9 = map10;
                                    }
                                    for (ga gaVar3222 : (List) r11.get(Integer.valueOf(intValue2))) {
                                        bitSet9 = bitSet2;
                                        map11 = map6;
                                        if (mo4754r().m42558a(2)) {
                                            map25 = map8;
                                            mo4754r().m42579w().m21310a("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), gaVar3222.f28994c, mo6212o().m42528a(gaVar3222.f28995d));
                                            mo4754r().m42579w().m21308a("Filter definition", G_().m44286a(gaVar3222));
                                        } else {
                                            map25 = map8;
                                        }
                                        if (gaVar3222.f28994c != null) {
                                            if (gaVar3222.f28994c.intValue() > 256) {
                                                if (d) {
                                                    if (gaVar3222 == null && gaVar3222.f28996e != null && gaVar3222.f28996e.length > 0) {
                                                        if (gaVar3222.f28996e[0].f29004g != null && gaVar3222.f28996e[0].f29004g.booleanValue()) {
                                                            obj3 = 1;
                                                            if (bitSet.get(gaVar3222.f28994c.intValue()) || obj3 != null) {
                                                                gaVar = gaVar3222;
                                                                bitSet4 = bitSet9;
                                                                map12 = c3211a4;
                                                                gqVarArr4 = gqVarArr;
                                                                gkVar5 = gkVar7;
                                                                map13 = c3211a5;
                                                                bitSet10 = bitSet;
                                                                map14 = c3211a9;
                                                                map15 = map7;
                                                                map16 = map25;
                                                                gaVar2 = gaVar;
                                                                a2 = m44313a(gaVar, str3, glVarArr3, j3);
                                                                if (a2 == null) {
                                                                }
                                                                mo4754r().m42579w().m21308a("Event filter result", a2 == null ? "null" : a2);
                                                                if (a2 == null) {
                                                                    bitSet4.set(gaVar2.f28994c.intValue());
                                                                    if (a2.booleanValue()) {
                                                                        bitSet10.set(gaVar2.f28994c.intValue());
                                                                        if (!(obj3 == null || gkVar5.f29044e == null)) {
                                                                            C8339w.m44321a(map14, gaVar2.f28994c.intValue(), gkVar5.f29044e.longValue());
                                                                        }
                                                                    }
                                                                    c3211a9 = map14;
                                                                    bitSet = bitSet10;
                                                                    bitSet2 = bitSet4;
                                                                    gkVar7 = gkVar5;
                                                                    map6 = map11;
                                                                    c3211a4 = map12;
                                                                    c3211a5 = map13;
                                                                    map7 = map15;
                                                                    map8 = map16;
                                                                    gqVarArr3 = gqVarArr;
                                                                    str4 = str;
                                                                    c8339w2 = this;
                                                                }
                                                            } else {
                                                                mo4754r().m42579w().m21309a("Event filter already evaluated true and it is not associated with a dynamic audience. audience ID, filter ID", Integer.valueOf(intValue2), gaVar3222.f28994c);
                                                                bitSet2 = bitSet9;
                                                                map6 = map11;
                                                                map8 = map25;
                                                                gqVarArr3 = gqVarArr;
                                                                str4 = str;
                                                                c8339w2 = this;
                                                            }
                                                        }
                                                    }
                                                    obj3 = null;
                                                    if (bitSet.get(gaVar3222.f28994c.intValue())) {
                                                    }
                                                    gaVar = gaVar3222;
                                                    bitSet4 = bitSet9;
                                                    map12 = c3211a4;
                                                    gqVarArr4 = gqVarArr;
                                                    gkVar5 = gkVar7;
                                                    map13 = c3211a5;
                                                    bitSet10 = bitSet;
                                                    map14 = c3211a9;
                                                    map15 = map7;
                                                    map16 = map25;
                                                    gaVar2 = gaVar;
                                                    a2 = m44313a(gaVar, str3, glVarArr3, j3);
                                                    if (a2 == null) {
                                                    }
                                                    mo4754r().m42579w().m21308a("Event filter result", a2 == null ? "null" : a2);
                                                    if (a2 == null) {
                                                        bitSet4.set(gaVar2.f28994c.intValue());
                                                        if (a2.booleanValue()) {
                                                            bitSet10.set(gaVar2.f28994c.intValue());
                                                            C8339w.m44321a(map14, gaVar2.f28994c.intValue(), gkVar5.f29044e.longValue());
                                                        }
                                                        c3211a9 = map14;
                                                        bitSet = bitSet10;
                                                        bitSet2 = bitSet4;
                                                        gkVar7 = gkVar5;
                                                        map6 = map11;
                                                        c3211a4 = map12;
                                                        c3211a5 = map13;
                                                        map7 = map15;
                                                        map8 = map16;
                                                        gqVarArr3 = gqVarArr;
                                                        str4 = str;
                                                        c8339w2 = this;
                                                    }
                                                } else {
                                                    map13 = c3211a5;
                                                    map12 = c3211a4;
                                                    map15 = map7;
                                                    gkVar5 = gkVar7;
                                                    map14 = c3211a9;
                                                    bitSet4 = bitSet9;
                                                    map16 = map25;
                                                    gaVar2 = gaVar3222;
                                                    bitSet10 = bitSet;
                                                    if (bitSet10.get(gaVar2.f28994c.intValue())) {
                                                        w = mo4754r().m42579w();
                                                        str2 = "Event filter already evaluated true. audience ID, filter ID";
                                                        valueOf = Integer.valueOf(intValue2);
                                                        obj2 = gaVar2.f28994c;
                                                        w.m21309a(str2, valueOf, obj2);
                                                        c3211a9 = map14;
                                                        bitSet = bitSet10;
                                                        bitSet2 = bitSet4;
                                                        gkVar7 = gkVar5;
                                                        map6 = map11;
                                                        c3211a4 = map12;
                                                        c3211a5 = map13;
                                                        map7 = map15;
                                                        map8 = map16;
                                                        gqVarArr3 = gqVarArr;
                                                        str4 = str;
                                                        c8339w2 = this;
                                                    } else {
                                                        a2 = m44313a(gaVar2, str3, glVarArr3, j3);
                                                        if (a2 != null) {
                                                        }
                                                        mo4754r().m42579w().m21308a("Event filter result", a2 != null ? a2 : "null");
                                                        if (a2 != null) {
                                                            bitSet4.set(gaVar2.f28994c.intValue());
                                                            if (a2.booleanValue()) {
                                                                bitSet10.set(gaVar2.f28994c.intValue());
                                                            }
                                                            c3211a9 = map14;
                                                            bitSet = bitSet10;
                                                            bitSet2 = bitSet4;
                                                            gkVar7 = gkVar5;
                                                            map6 = map11;
                                                            c3211a4 = map12;
                                                            c3211a5 = map13;
                                                            map7 = map15;
                                                            map8 = map16;
                                                            gqVarArr3 = gqVarArr;
                                                            str4 = str;
                                                            c8339w2 = this;
                                                        }
                                                    }
                                                }
                                                hashSet2.add(Integer.valueOf(intValue2));
                                                c3211a9 = map14;
                                                bitSet = bitSet10;
                                                bitSet2 = bitSet4;
                                                gkVar7 = gkVar5;
                                                map6 = map11;
                                                c3211a4 = map12;
                                                c3211a5 = map13;
                                                map7 = map15;
                                                map8 = map16;
                                                gqVarArr3 = gqVarArr;
                                                str4 = str;
                                                c8339w2 = this;
                                            }
                                        }
                                        map13 = c3211a5;
                                        map12 = c3211a4;
                                        map15 = map7;
                                        gkVar5 = gkVar7;
                                        map14 = c3211a9;
                                        bitSet4 = bitSet9;
                                        map16 = map25;
                                        gaVar2 = gaVar3222;
                                        bitSet10 = bitSet;
                                        w = mo4754r().m42565i();
                                        str2 = "Invalid event filter ID. appId, id";
                                        valueOf = bb.m42550a(str);
                                        obj2 = String.valueOf(gaVar2.f28994c);
                                        w.m21309a(str2, valueOf, obj2);
                                        c3211a9 = map14;
                                        bitSet = bitSet10;
                                        bitSet2 = bitSet4;
                                        gkVar7 = gkVar5;
                                        map6 = map11;
                                        c3211a4 = map12;
                                        c3211a5 = map13;
                                        map7 = map15;
                                        map8 = map16;
                                        gqVarArr3 = gqVarArr;
                                        str4 = str;
                                        c8339w2 = this;
                                    }
                                    map12 = c3211a4;
                                    map23 = map8;
                                    map22 = c3211a5;
                                    hashSet = hashSet2;
                                    map21 = map7;
                                    gkVar4 = gkVar7;
                                    c3211a5 = map9;
                                    it = it2;
                                    map4 = map12;
                                    gqVarArr3 = gqVarArr;
                                    str4 = str;
                                    c8339w2 = this;
                                }
                            }
                            c3211a10 = c3211a5;
                            map13 = map22;
                            map12 = map4;
                            map16 = map23;
                            hashSet2 = hashSet;
                            map15 = map21;
                            l3 = l2;
                            j2 = j4;
                            gkVar6 = gkVar3;
                            i = i6 + 1;
                            gkVarArr2 = gkVarArr;
                            hashSet3 = hashSet2;
                            length3 = i5;
                            c3211a8 = c3211a10;
                            map = map12;
                            map2 = map13;
                            c3211a4 = map15;
                            map3 = map16;
                            c8339w2 = this;
                            gqVarArr2 = gqVarArr;
                            str5 = str;
                        }
                    } else {
                        i7 = i;
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        gkVar = gkVar8;
                        i5 = length3;
                        i6 = i7;
                        z = true;
                        if (obj4 != null) {
                            G_();
                            l3 = Long.valueOf(0);
                            e = fs.m44284b(gkVar, "_epc");
                            if (e == null) {
                                e = l3;
                            }
                            longValue = ((Long) e).longValue();
                            if (longValue > 0) {
                                l4 = l5;
                                E_().m43929a(str, l5, longValue, gkVar);
                            } else {
                                mo4754r().m42565i().m21308a("Complex event with zero extra param count. eventName", str6);
                                l4 = l5;
                            }
                            l2 = l4;
                            str3 = str6;
                            glVarArr3 = glVarArr4;
                            gkVar3 = gkVar;
                            j4 = longValue;
                        }
                    } else {
                        G_();
                        str6 = (String) fs.m44284b(gkVar8, "_en");
                        if (!TextUtils.isEmpty(str6)) {
                            mo4754r().I_().m21308a("Extra parameter without an event name. eventId", l5);
                            i5 = length3;
                            i6 = i7;
                        } else if (l5.longValue() != l3.longValue()) {
                            gkVar9 = gkVar6;
                            l = l3;
                            j5 = j4;
                            j = j5 - 1;
                            if (j > 0) {
                                E_ = E_();
                                E_.mo6210d();
                                E_.mo4754r().m42579w().m21308a("Clearing complex main event info. appId", str5);
                                i8 = E_.m43947i();
                                str2 = "delete from main_event_params where app_id=?";
                                gkVar10 = gkVar9;
                                strArr = new String[1];
                                strArr[0] = str5;
                                i8.execSQL(str2, strArr);
                                gkVar = gkVar8;
                                i5 = length3;
                                i6 = i7;
                                gkVar2 = gkVar10;
                                z = true;
                            } else {
                                gkVar = gkVar8;
                                i6 = i7;
                                gkVar11 = gkVar9;
                                z = true;
                                i5 = length3;
                                E_().m43929a(str, l5, j, gkVar11);
                                gkVar2 = gkVar11;
                            }
                            glVarArr = new gl[(gkVar2.f29042c.length + glVarArr4.length)];
                            glVarArr2 = gkVar2.f29042c;
                            length2 = glVarArr2.length;
                            i = 0;
                            i3 = 0;
                            while (i < length2) {
                                glVar = glVarArr2[i];
                                G_();
                                gkVar3 = gkVar2;
                                if (fs.m44274a(gkVar, glVar.f29048c) != null) {
                                    length = i3 + 1;
                                    glVarArr[i3] = glVar;
                                    i3 = length;
                                }
                                i++;
                                gkVar2 = gkVar3;
                            }
                            gkVar3 = gkVar2;
                            if (i3 > 0) {
                                length = glVarArr4.length;
                                intValue = 0;
                                while (intValue < length) {
                                    i = i3 + 1;
                                    glVarArr[i3] = glVarArr4[intValue];
                                    intValue++;
                                    i3 = i;
                                }
                                if (i3 == glVarArr.length) {
                                    glVarArr = (gl[]) Arrays.copyOf(glVarArr, i3);
                                }
                                glVarArr3 = glVarArr;
                                str3 = str6;
                            } else {
                                mo4754r().m42565i().m21308a("No unique parameters in main event. eventName", str6);
                                str3 = str6;
                                glVarArr3 = glVarArr4;
                            }
                            l2 = l;
                            j4 = j;
                        } else {
                            a3 = E_().m43913a(str5, l5);
                            if (a3 != null) {
                                if (a3.first == null) {
                                    gkVar6 = (gk) a3.first;
                                    j5 = ((Long) a3.second).longValue();
                                    G_();
                                    l = (Long) fs.m44284b(gkVar6, "_eid");
                                    gkVar9 = gkVar6;
                                    j = j5 - 1;
                                    if (j > 0) {
                                        gkVar = gkVar8;
                                        i6 = i7;
                                        gkVar11 = gkVar9;
                                        z = true;
                                        i5 = length3;
                                        E_().m43929a(str, l5, j, gkVar11);
                                        gkVar2 = gkVar11;
                                    } else {
                                        E_ = E_();
                                        E_.mo6210d();
                                        E_.mo4754r().m42579w().m21308a("Clearing complex main event info. appId", str5);
                                        i8 = E_.m43947i();
                                        str2 = "delete from main_event_params where app_id=?";
                                        gkVar10 = gkVar9;
                                        strArr = new String[1];
                                        strArr[0] = str5;
                                        i8.execSQL(str2, strArr);
                                        gkVar = gkVar8;
                                        i5 = length3;
                                        i6 = i7;
                                        gkVar2 = gkVar10;
                                        z = true;
                                    }
                                    glVarArr = new gl[(gkVar2.f29042c.length + glVarArr4.length)];
                                    glVarArr2 = gkVar2.f29042c;
                                    length2 = glVarArr2.length;
                                    i = 0;
                                    i3 = 0;
                                    while (i < length2) {
                                        glVar = glVarArr2[i];
                                        G_();
                                        gkVar3 = gkVar2;
                                        if (fs.m44274a(gkVar, glVar.f29048c) != null) {
                                            length = i3 + 1;
                                            glVarArr[i3] = glVar;
                                            i3 = length;
                                        }
                                        i++;
                                        gkVar2 = gkVar3;
                                    }
                                    gkVar3 = gkVar2;
                                    if (i3 > 0) {
                                        mo4754r().m42565i().m21308a("No unique parameters in main event. eventName", str6);
                                        str3 = str6;
                                        glVarArr3 = glVarArr4;
                                    } else {
                                        length = glVarArr4.length;
                                        intValue = 0;
                                        while (intValue < length) {
                                            i = i3 + 1;
                                            glVarArr[i3] = glVarArr4[intValue];
                                            intValue++;
                                            i3 = i;
                                        }
                                        if (i3 == glVarArr.length) {
                                            glVarArr = (gl[]) Arrays.copyOf(glVarArr, i3);
                                        }
                                        glVarArr3 = glVarArr;
                                        str3 = str6;
                                    }
                                    l2 = l;
                                    j4 = j;
                                }
                            }
                            i5 = length3;
                            i6 = i7;
                            mo4754r().I_().m21309a("Extra parameter without existing main event. eventName, eventId", str6, l5);
                        }
                        c3211a10 = c3211a8;
                        hashSet2 = hashSet3;
                        map15 = c3211a4;
                        map12 = map;
                        map13 = map2;
                        map16 = map3;
                        j2 = j4;
                        i = i6 + 1;
                        gkVarArr2 = gkVarArr;
                        hashSet3 = hashSet2;
                        length3 = i5;
                        c3211a8 = c3211a10;
                        map = map12;
                        map2 = map13;
                        c3211a4 = map15;
                        map3 = map16;
                        c8339w2 = this;
                        gqVarArr2 = gqVarArr;
                        str5 = str;
                    }
                    a = E_().m43915a(str5, gkVar.f29043d);
                    if (a != null) {
                        c3211a2 = c3211a8;
                        hashSet = hashSet3;
                        map21 = c3211a4;
                        gkVar4 = gkVar;
                        gqVarArr3 = gqVarArr2;
                        str4 = str5;
                        map4 = map;
                        map22 = map2;
                        map23 = map3;
                        a = a.m21246a();
                    } else {
                        mo4754r().m42565i().m21309a("Event aggregate wasn't created during raw event logging. appId, event", bb.m42550a(str), mo6212o().m42528a(str3));
                        c3211a2 = c3211a8;
                        map4 = map;
                        map22 = map2;
                        map23 = map3;
                        hashSet = hashSet3;
                        map21 = c3211a4;
                        gkVar4 = gkVar;
                        gqVarArr3 = gqVarArr2;
                        str4 = str5;
                        amVar = new am(str, gkVar.f29043d, 1, 1, gkVar.f29044e.longValue(), 0, null, null, null);
                    }
                    E_().m43921a(a);
                    j3 = a.f16893c;
                    c3211a5 = c3211a2;
                    map5 = (Map) c3211a5.get(str3);
                    if (map5 == null) {
                        map5 = E_().m43941f(str4, str3);
                        if (map5 == null) {
                            map5 = new C3211a();
                        }
                        c3211a5.put(str3, map5);
                    }
                    map6 = map5;
                    it = map6.keySet().iterator();
                    while (it.hasNext()) {
                        intValue2 = ((Integer) it.next()).intValue();
                        hashSet2 = hashSet;
                        if (hashSet2.contains(Integer.valueOf(intValue2))) {
                            map7 = map21;
                            giVar = (gi) map7.get(Integer.valueOf(intValue2));
                            map8 = map23;
                            bitSet = (BitSet) map8.get(Integer.valueOf(intValue2));
                            gkVar7 = gkVar4;
                            map9 = c3211a5;
                            c3211a5 = map22;
                            bitSet2 = (BitSet) c3211a5.get(Integer.valueOf(intValue2));
                            if (d) {
                                bitSet3 = bitSet2;
                                it2 = it;
                                c3211a4 = map4;
                                map24 = null;
                            } else {
                                bitSet3 = bitSet2;
                                it2 = it;
                                c3211a4 = map4;
                                map24 = (Map) c3211a4.get(Integer.valueOf(intValue2));
                            }
                            if (giVar != null) {
                                map10 = map24;
                                bitSet2 = bitSet3;
                                c3211a9 = map10;
                            } else {
                                giVar = new gi();
                                map7.put(Integer.valueOf(intValue2), giVar);
                                giVar.f29037f = Boolean.valueOf(z);
                                bitSet = new BitSet();
                                map8.put(Integer.valueOf(intValue2), bitSet);
                                bitSet7 = new BitSet();
                                map10 = map24;
                                c3211a5.put(Integer.valueOf(intValue2), bitSet7);
                                if (d) {
                                    bitSet8 = bitSet7;
                                    c3211a9 = map10;
                                } else {
                                    c3211a3 = new C3211a();
                                    bitSet8 = bitSet7;
                                    c3211a4.put(Integer.valueOf(intValue2), c3211a3);
                                    c3211a9 = c3211a3;
                                }
                                bitSet2 = bitSet8;
                            }
                            for (ga gaVar32222 : (List) r11.get(Integer.valueOf(intValue2))) {
                                bitSet9 = bitSet2;
                                map11 = map6;
                                if (mo4754r().m42558a(2)) {
                                    map25 = map8;
                                } else {
                                    map25 = map8;
                                    mo4754r().m42579w().m21310a("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), gaVar32222.f28994c, mo6212o().m42528a(gaVar32222.f28995d));
                                    mo4754r().m42579w().m21308a("Filter definition", G_().m44286a(gaVar32222));
                                }
                                if (gaVar32222.f28994c != null) {
                                    if (gaVar32222.f28994c.intValue() > 256) {
                                        if (d) {
                                            map13 = c3211a5;
                                            map12 = c3211a4;
                                            map15 = map7;
                                            gkVar5 = gkVar7;
                                            map14 = c3211a9;
                                            bitSet4 = bitSet9;
                                            map16 = map25;
                                            gaVar2 = gaVar32222;
                                            bitSet10 = bitSet;
                                            if (bitSet10.get(gaVar2.f28994c.intValue())) {
                                                a2 = m44313a(gaVar2, str3, glVarArr3, j3);
                                                if (a2 != null) {
                                                }
                                                mo4754r().m42579w().m21308a("Event filter result", a2 != null ? a2 : "null");
                                                if (a2 != null) {
                                                    bitSet4.set(gaVar2.f28994c.intValue());
                                                    if (a2.booleanValue()) {
                                                        bitSet10.set(gaVar2.f28994c.intValue());
                                                    }
                                                    c3211a9 = map14;
                                                    bitSet = bitSet10;
                                                    bitSet2 = bitSet4;
                                                    gkVar7 = gkVar5;
                                                    map6 = map11;
                                                    c3211a4 = map12;
                                                    c3211a5 = map13;
                                                    map7 = map15;
                                                    map8 = map16;
                                                    gqVarArr3 = gqVarArr;
                                                    str4 = str;
                                                    c8339w2 = this;
                                                }
                                            } else {
                                                w = mo4754r().m42579w();
                                                str2 = "Event filter already evaluated true. audience ID, filter ID";
                                                valueOf = Integer.valueOf(intValue2);
                                                obj2 = gaVar2.f28994c;
                                                w.m21309a(str2, valueOf, obj2);
                                                c3211a9 = map14;
                                                bitSet = bitSet10;
                                                bitSet2 = bitSet4;
                                                gkVar7 = gkVar5;
                                                map6 = map11;
                                                c3211a4 = map12;
                                                c3211a5 = map13;
                                                map7 = map15;
                                                map8 = map16;
                                                gqVarArr3 = gqVarArr;
                                                str4 = str;
                                                c8339w2 = this;
                                            }
                                        } else {
                                            if (gaVar32222 == null) {
                                            }
                                            obj3 = null;
                                            if (bitSet.get(gaVar32222.f28994c.intValue())) {
                                            }
                                            gaVar = gaVar32222;
                                            bitSet4 = bitSet9;
                                            map12 = c3211a4;
                                            gqVarArr4 = gqVarArr;
                                            gkVar5 = gkVar7;
                                            map13 = c3211a5;
                                            bitSet10 = bitSet;
                                            map14 = c3211a9;
                                            map15 = map7;
                                            map16 = map25;
                                            gaVar2 = gaVar;
                                            a2 = m44313a(gaVar, str3, glVarArr3, j3);
                                            if (a2 == null) {
                                            }
                                            mo4754r().m42579w().m21308a("Event filter result", a2 == null ? "null" : a2);
                                            if (a2 == null) {
                                                bitSet4.set(gaVar2.f28994c.intValue());
                                                if (a2.booleanValue()) {
                                                    bitSet10.set(gaVar2.f28994c.intValue());
                                                    C8339w.m44321a(map14, gaVar2.f28994c.intValue(), gkVar5.f29044e.longValue());
                                                }
                                                c3211a9 = map14;
                                                bitSet = bitSet10;
                                                bitSet2 = bitSet4;
                                                gkVar7 = gkVar5;
                                                map6 = map11;
                                                c3211a4 = map12;
                                                c3211a5 = map13;
                                                map7 = map15;
                                                map8 = map16;
                                                gqVarArr3 = gqVarArr;
                                                str4 = str;
                                                c8339w2 = this;
                                            }
                                        }
                                        hashSet2.add(Integer.valueOf(intValue2));
                                        c3211a9 = map14;
                                        bitSet = bitSet10;
                                        bitSet2 = bitSet4;
                                        gkVar7 = gkVar5;
                                        map6 = map11;
                                        c3211a4 = map12;
                                        c3211a5 = map13;
                                        map7 = map15;
                                        map8 = map16;
                                        gqVarArr3 = gqVarArr;
                                        str4 = str;
                                        c8339w2 = this;
                                    }
                                }
                                map13 = c3211a5;
                                map12 = c3211a4;
                                map15 = map7;
                                gkVar5 = gkVar7;
                                map14 = c3211a9;
                                bitSet4 = bitSet9;
                                map16 = map25;
                                gaVar2 = gaVar32222;
                                bitSet10 = bitSet;
                                w = mo4754r().m42565i();
                                str2 = "Invalid event filter ID. appId, id";
                                valueOf = bb.m42550a(str);
                                obj2 = String.valueOf(gaVar2.f28994c);
                                w.m21309a(str2, valueOf, obj2);
                                c3211a9 = map14;
                                bitSet = bitSet10;
                                bitSet2 = bitSet4;
                                gkVar7 = gkVar5;
                                map6 = map11;
                                c3211a4 = map12;
                                c3211a5 = map13;
                                map7 = map15;
                                map8 = map16;
                                gqVarArr3 = gqVarArr;
                                str4 = str;
                                c8339w2 = this;
                            }
                            map12 = c3211a4;
                            map23 = map8;
                            map22 = c3211a5;
                            hashSet = hashSet2;
                            map21 = map7;
                            gkVar4 = gkVar7;
                            c3211a5 = map9;
                            it = it2;
                            map4 = map12;
                            gqVarArr3 = gqVarArr;
                            str4 = str;
                            c8339w2 = this;
                        } else {
                            mo4754r().m42579w().m21308a("Skipping failed audience ID", Integer.valueOf(intValue2));
                            hashSet = hashSet2;
                        }
                    }
                    c3211a10 = c3211a5;
                    map13 = map22;
                    map12 = map4;
                    map16 = map23;
                    hashSet2 = hashSet;
                    map15 = map21;
                    l3 = l2;
                    j2 = j4;
                    gkVar6 = gkVar3;
                    i = i6 + 1;
                    gkVarArr2 = gkVarArr;
                    hashSet3 = hashSet2;
                    length3 = i5;
                    c3211a8 = c3211a10;
                    map = map12;
                    map2 = map13;
                    c3211a4 = map15;
                    map3 = map16;
                    c8339w2 = this;
                    gqVarArr2 = gqVarArr;
                    str5 = str;
                } else {
                    i6 = i;
                    gkVar = gkVar8;
                    i5 = length3;
                    z = true;
                }
                gkVar3 = gkVar6;
                l2 = l3;
                str3 = str6;
                glVarArr3 = glVarArr4;
                a = E_().m43915a(str5, gkVar.f29043d);
                if (a != null) {
                    mo4754r().m42565i().m21309a("Event aggregate wasn't created during raw event logging. appId, event", bb.m42550a(str), mo6212o().m42528a(str3));
                    c3211a2 = c3211a8;
                    map4 = map;
                    map22 = map2;
                    map23 = map3;
                    hashSet = hashSet3;
                    map21 = c3211a4;
                    gkVar4 = gkVar;
                    gqVarArr3 = gqVarArr2;
                    str4 = str5;
                    amVar = new am(str, gkVar.f29043d, 1, 1, gkVar.f29044e.longValue(), 0, null, null, null);
                } else {
                    c3211a2 = c3211a8;
                    hashSet = hashSet3;
                    map21 = c3211a4;
                    gkVar4 = gkVar;
                    gqVarArr3 = gqVarArr2;
                    str4 = str5;
                    map4 = map;
                    map22 = map2;
                    map23 = map3;
                    a = a.m21246a();
                }
                E_().m43921a(a);
                j3 = a.f16893c;
                c3211a5 = c3211a2;
                map5 = (Map) c3211a5.get(str3);
                if (map5 == null) {
                    map5 = E_().m43941f(str4, str3);
                    if (map5 == null) {
                        map5 = new C3211a();
                    }
                    c3211a5.put(str3, map5);
                }
                map6 = map5;
                it = map6.keySet().iterator();
                while (it.hasNext()) {
                    intValue2 = ((Integer) it.next()).intValue();
                    hashSet2 = hashSet;
                    if (hashSet2.contains(Integer.valueOf(intValue2))) {
                        mo4754r().m42579w().m21308a("Skipping failed audience ID", Integer.valueOf(intValue2));
                        hashSet = hashSet2;
                    } else {
                        map7 = map21;
                        giVar = (gi) map7.get(Integer.valueOf(intValue2));
                        map8 = map23;
                        bitSet = (BitSet) map8.get(Integer.valueOf(intValue2));
                        gkVar7 = gkVar4;
                        map9 = c3211a5;
                        c3211a5 = map22;
                        bitSet2 = (BitSet) c3211a5.get(Integer.valueOf(intValue2));
                        if (d) {
                            bitSet3 = bitSet2;
                            it2 = it;
                            c3211a4 = map4;
                            map24 = (Map) c3211a4.get(Integer.valueOf(intValue2));
                        } else {
                            bitSet3 = bitSet2;
                            it2 = it;
                            c3211a4 = map4;
                            map24 = null;
                        }
                        if (giVar != null) {
                            giVar = new gi();
                            map7.put(Integer.valueOf(intValue2), giVar);
                            giVar.f29037f = Boolean.valueOf(z);
                            bitSet = new BitSet();
                            map8.put(Integer.valueOf(intValue2), bitSet);
                            bitSet7 = new BitSet();
                            map10 = map24;
                            c3211a5.put(Integer.valueOf(intValue2), bitSet7);
                            if (d) {
                                c3211a3 = new C3211a();
                                bitSet8 = bitSet7;
                                c3211a4.put(Integer.valueOf(intValue2), c3211a3);
                                c3211a9 = c3211a3;
                            } else {
                                bitSet8 = bitSet7;
                                c3211a9 = map10;
                            }
                            bitSet2 = bitSet8;
                        } else {
                            map10 = map24;
                            bitSet2 = bitSet3;
                            c3211a9 = map10;
                        }
                        for (ga gaVar322222 : (List) r11.get(Integer.valueOf(intValue2))) {
                            bitSet9 = bitSet2;
                            map11 = map6;
                            if (mo4754r().m42558a(2)) {
                                map25 = map8;
                                mo4754r().m42579w().m21310a("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), gaVar322222.f28994c, mo6212o().m42528a(gaVar322222.f28995d));
                                mo4754r().m42579w().m21308a("Filter definition", G_().m44286a(gaVar322222));
                            } else {
                                map25 = map8;
                            }
                            if (gaVar322222.f28994c != null) {
                                if (gaVar322222.f28994c.intValue() > 256) {
                                    if (d) {
                                        if (gaVar322222 == null) {
                                        }
                                        obj3 = null;
                                        if (bitSet.get(gaVar322222.f28994c.intValue())) {
                                        }
                                        gaVar = gaVar322222;
                                        bitSet4 = bitSet9;
                                        map12 = c3211a4;
                                        gqVarArr4 = gqVarArr;
                                        gkVar5 = gkVar7;
                                        map13 = c3211a5;
                                        bitSet10 = bitSet;
                                        map14 = c3211a9;
                                        map15 = map7;
                                        map16 = map25;
                                        gaVar2 = gaVar;
                                        a2 = m44313a(gaVar, str3, glVarArr3, j3);
                                        if (a2 == null) {
                                        }
                                        mo4754r().m42579w().m21308a("Event filter result", a2 == null ? "null" : a2);
                                        if (a2 == null) {
                                            bitSet4.set(gaVar2.f28994c.intValue());
                                            if (a2.booleanValue()) {
                                                bitSet10.set(gaVar2.f28994c.intValue());
                                                C8339w.m44321a(map14, gaVar2.f28994c.intValue(), gkVar5.f29044e.longValue());
                                            }
                                            c3211a9 = map14;
                                            bitSet = bitSet10;
                                            bitSet2 = bitSet4;
                                            gkVar7 = gkVar5;
                                            map6 = map11;
                                            c3211a4 = map12;
                                            c3211a5 = map13;
                                            map7 = map15;
                                            map8 = map16;
                                            gqVarArr3 = gqVarArr;
                                            str4 = str;
                                            c8339w2 = this;
                                        }
                                    } else {
                                        map13 = c3211a5;
                                        map12 = c3211a4;
                                        map15 = map7;
                                        gkVar5 = gkVar7;
                                        map14 = c3211a9;
                                        bitSet4 = bitSet9;
                                        map16 = map25;
                                        gaVar2 = gaVar322222;
                                        bitSet10 = bitSet;
                                        if (bitSet10.get(gaVar2.f28994c.intValue())) {
                                            w = mo4754r().m42579w();
                                            str2 = "Event filter already evaluated true. audience ID, filter ID";
                                            valueOf = Integer.valueOf(intValue2);
                                            obj2 = gaVar2.f28994c;
                                            w.m21309a(str2, valueOf, obj2);
                                            c3211a9 = map14;
                                            bitSet = bitSet10;
                                            bitSet2 = bitSet4;
                                            gkVar7 = gkVar5;
                                            map6 = map11;
                                            c3211a4 = map12;
                                            c3211a5 = map13;
                                            map7 = map15;
                                            map8 = map16;
                                            gqVarArr3 = gqVarArr;
                                            str4 = str;
                                            c8339w2 = this;
                                        } else {
                                            a2 = m44313a(gaVar2, str3, glVarArr3, j3);
                                            if (a2 != null) {
                                            }
                                            mo4754r().m42579w().m21308a("Event filter result", a2 != null ? a2 : "null");
                                            if (a2 != null) {
                                                bitSet4.set(gaVar2.f28994c.intValue());
                                                if (a2.booleanValue()) {
                                                    bitSet10.set(gaVar2.f28994c.intValue());
                                                }
                                                c3211a9 = map14;
                                                bitSet = bitSet10;
                                                bitSet2 = bitSet4;
                                                gkVar7 = gkVar5;
                                                map6 = map11;
                                                c3211a4 = map12;
                                                c3211a5 = map13;
                                                map7 = map15;
                                                map8 = map16;
                                                gqVarArr3 = gqVarArr;
                                                str4 = str;
                                                c8339w2 = this;
                                            }
                                        }
                                    }
                                    hashSet2.add(Integer.valueOf(intValue2));
                                    c3211a9 = map14;
                                    bitSet = bitSet10;
                                    bitSet2 = bitSet4;
                                    gkVar7 = gkVar5;
                                    map6 = map11;
                                    c3211a4 = map12;
                                    c3211a5 = map13;
                                    map7 = map15;
                                    map8 = map16;
                                    gqVarArr3 = gqVarArr;
                                    str4 = str;
                                    c8339w2 = this;
                                }
                            }
                            map13 = c3211a5;
                            map12 = c3211a4;
                            map15 = map7;
                            gkVar5 = gkVar7;
                            map14 = c3211a9;
                            bitSet4 = bitSet9;
                            map16 = map25;
                            gaVar2 = gaVar322222;
                            bitSet10 = bitSet;
                            w = mo4754r().m42565i();
                            str2 = "Invalid event filter ID. appId, id";
                            valueOf = bb.m42550a(str);
                            obj2 = String.valueOf(gaVar2.f28994c);
                            w.m21309a(str2, valueOf, obj2);
                            c3211a9 = map14;
                            bitSet = bitSet10;
                            bitSet2 = bitSet4;
                            gkVar7 = gkVar5;
                            map6 = map11;
                            c3211a4 = map12;
                            c3211a5 = map13;
                            map7 = map15;
                            map8 = map16;
                            gqVarArr3 = gqVarArr;
                            str4 = str;
                            c8339w2 = this;
                        }
                        map12 = c3211a4;
                        map23 = map8;
                        map22 = c3211a5;
                        hashSet = hashSet2;
                        map21 = map7;
                        gkVar4 = gkVar7;
                        c3211a5 = map9;
                        it = it2;
                        map4 = map12;
                        gqVarArr3 = gqVarArr;
                        str4 = str;
                        c8339w2 = this;
                    }
                }
                c3211a10 = c3211a5;
                map13 = map22;
                map12 = map4;
                map16 = map23;
                hashSet2 = hashSet;
                map15 = map21;
                l3 = l2;
                j2 = j4;
                gkVar6 = gkVar3;
                i = i6 + 1;
                gkVarArr2 = gkVarArr;
                hashSet3 = hashSet2;
                length3 = i5;
                c3211a8 = c3211a10;
                map = map12;
                map2 = map13;
                c3211a4 = map15;
                map3 = map16;
                c8339w2 = this;
                gqVarArr2 = gqVarArr;
                str5 = str;
            }
        }
        hashSet2 = hashSet3;
        map15 = c3211a4;
        map12 = map;
        map13 = map2;
        map16 = map3;
        gq[] gqVarArr5 = gqVarArr;
        if (gqVarArr5 != null) {
            e2 = new C3211a();
            intValue = gqVarArr5.length;
            length2 = 0;
            while (length2 < intValue) {
                String str7;
                Map map26;
                int i9;
                gq gqVar = gqVarArr5[length2];
                c3211a = (Map) e2.get(gqVar.f29102d);
                if (c3211a == null) {
                    c3211a = E_().m43943g(str, gqVar.f29102d);
                    if (c3211a == null) {
                        c3211a = new C3211a();
                    }
                    e2.put(gqVar.f29102d, c3211a);
                } else {
                    str7 = str;
                }
                Iterator it5 = c3211a.keySet().iterator();
                while (it5.hasNext()) {
                    int intValue3 = ((Integer) it5.next()).intValue();
                    if (hashSet2.contains(Integer.valueOf(intValue3))) {
                        mo4754r().m42579w().m21308a("Skipping failed audience ID", Integer.valueOf(intValue3));
                    } else {
                        Iterator it6;
                        c3211a5 = map15;
                        gi giVar3 = (gi) c3211a5.get(Integer.valueOf(intValue3));
                        c3211a4 = map16;
                        bitSet4 = (BitSet) c3211a4.get(Integer.valueOf(intValue3));
                        map7 = map13;
                        BitSet bitSet11 = (BitSet) map7.get(Integer.valueOf(intValue3));
                        if (d) {
                            map26 = e2;
                            map5 = map12;
                            e2 = (Map) map5.get(Integer.valueOf(intValue3));
                        } else {
                            map26 = e2;
                            map5 = map12;
                            e2 = null;
                        }
                        if (giVar3 == null) {
                            giVar3 = new gi();
                            c3211a5.put(Integer.valueOf(intValue3), giVar3);
                            giVar3.f29037f = Boolean.valueOf(true);
                            bitSet4 = new BitSet();
                            c3211a4.put(Integer.valueOf(intValue3), bitSet4);
                            bitSet11 = new BitSet();
                            map7.put(Integer.valueOf(intValue3), bitSet11);
                            if (d) {
                                e2 = new C3211a();
                                map5.put(Integer.valueOf(intValue3), e2);
                            }
                        }
                        Iterator it7 = ((List) c3211a.get(Integer.valueOf(intValue3))).iterator();
                        while (it7.hasNext()) {
                            Iterator it8;
                            i9 = intValue;
                            gd gdVar = (gd) it7.next();
                            Map map27 = c3211a;
                            it6 = it5;
                            if (mo4754r().m42558a(2)) {
                                it8 = it7;
                                map17 = map5;
                                map18 = map7;
                                mo4754r().m42579w().m21310a("Evaluating filter. audience, filter, property", Integer.valueOf(intValue3), gdVar.f29012c, mo6212o().m42532c(gdVar.f29013d));
                                mo4754r().m42579w().m21308a("Filter definition", G_().m44287a(gdVar));
                            } else {
                                map17 = map5;
                                it8 = it7;
                                map18 = map7;
                            }
                            if (gdVar.f29012c != null) {
                                if (gdVar.f29012c.intValue() <= 256) {
                                    if (d) {
                                        obj = (gdVar == null || gdVar.f29014e == null || gdVar.f29014e.f29004g == null || !gdVar.f29014e.f29004g.booleanValue()) ? null : 1;
                                        if (bitSet4.get(gdVar.f29012c.intValue()) && obj == null) {
                                            mo4754r().m42579w().m21309a("Property filter already evaluated true and it is not associated with a dynamic audience. audience ID, filter ID", Integer.valueOf(intValue3), gdVar.f29012c);
                                        } else {
                                            Boolean a4 = m44314a(gdVar, gqVar);
                                            mo4754r().m42579w().m21308a("Property filter result", a4 == null ? "null" : a4);
                                            if (a4 == null) {
                                                hashSet2.add(Integer.valueOf(intValue3));
                                            } else {
                                                bitSet11.set(gdVar.f29012c.intValue());
                                                bitSet4.set(gdVar.f29012c.intValue(), a4.booleanValue());
                                                if (!(!a4.booleanValue() || obj == null || gqVar.f29101c == null)) {
                                                    map19 = c3211a5;
                                                    C8339w.m44321a(e2, gdVar.f29012c.intValue(), gqVar.f29101c.longValue());
                                                }
                                            }
                                        }
                                        intValue = i9;
                                        c3211a = map27;
                                        it5 = it6;
                                        it7 = it8;
                                        map5 = map17;
                                        map7 = map18;
                                        str7 = str;
                                    } else {
                                        map19 = c3211a5;
                                        c8339w = this;
                                        if (bitSet4.get(gdVar.f29012c.intValue())) {
                                            mo4754r().m42579w().m21309a("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), gdVar.f29012c);
                                        } else {
                                            a2 = m44314a(gdVar, gqVar);
                                            mo4754r().m42579w().m21308a("Property filter result", a2 == null ? "null" : a2);
                                            if (a2 == null) {
                                                hashSet2.add(Integer.valueOf(intValue3));
                                            } else {
                                                bitSet11.set(gdVar.f29012c.intValue());
                                                if (a2.booleanValue()) {
                                                    bitSet4.set(gdVar.f29012c.intValue());
                                                }
                                            }
                                        }
                                    }
                                    intValue = i9;
                                    c3211a = map27;
                                    it5 = it6;
                                    it7 = it8;
                                    map5 = map17;
                                    map7 = map18;
                                    c3211a5 = map19;
                                    str7 = str;
                                }
                            }
                            map19 = c3211a5;
                            c8339w = this;
                            mo4754r().m42565i().m21309a("Invalid property filter ID. appId, id", bb.m42550a(str), String.valueOf(gdVar.f29012c));
                            hashSet2.add(Integer.valueOf(intValue3));
                            map16 = c3211a4;
                            e2 = map26;
                            intValue = i9;
                            c3211a = map27;
                            it5 = it6;
                            map12 = map17;
                            map13 = map18;
                            map15 = map19;
                        }
                        it6 = it5;
                        c8339w = this;
                        map12 = map5;
                        map15 = c3211a5;
                        map16 = c3211a4;
                        map13 = map7;
                        e2 = map26;
                        it5 = it6;
                        gqVarArr5 = gqVarArr;
                        str7 = str;
                    }
                }
                map26 = e2;
                i9 = intValue;
                map17 = map12;
                map18 = map13;
                map19 = map15;
                c3211a4 = map16;
                c8339w = this;
                length2++;
                gqVarArr5 = gqVarArr;
            }
        }
        map17 = map12;
        map18 = map13;
        map19 = map15;
        c3211a4 = map16;
        c8339w = this;
        gi[] giVarArr = new gi[c3211a4.size()];
        i3 = 0;
        for (Integer intValue4 : c3211a4.keySet()) {
            i2 = intValue4.intValue();
            if (hashSet2.contains(Integer.valueOf(i2))) {
                str5 = str;
            } else {
                Map map28 = map19;
                gi giVar4 = (gi) map28.get(Integer.valueOf(i2));
                if (giVar4 == null) {
                    giVar4 = new gi();
                }
                int i10 = i3 + 1;
                giVarArr[i3] = giVar4;
                giVar4.f29034c = Integer.valueOf(i2);
                giVar4.f29035d = new go();
                giVar4.f29035d.f29094d = fs.m44282a((BitSet) c3211a4.get(Integer.valueOf(i2)));
                c3211a6 = map18;
                giVar4.f29035d.f29093c = fs.m44282a((BitSet) c3211a6.get(Integer.valueOf(i2)));
                if (d) {
                    c3211a5 = map17;
                    giVar4.f29035d.f29095e = C8339w.m44322a((Map) c3211a5.get(Integer.valueOf(i2)));
                } else {
                    c3211a5 = map17;
                }
                db E_2 = E_();
                C5043j c5043j = giVar4.f29035d;
                E_2.m42632I();
                E_2.mo6210d();
                C2872v.a(str);
                C2872v.a(c5043j);
                try {
                    byte[] bArr = new byte[c5043j.m21444d()];
                    C5035b a5 = C5035b.m21284a(bArr, 0, bArr.length);
                    c5043j.mo4757a(a5);
                    a5.m21294a();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("audience_id", Integer.valueOf(i2));
                    contentValues.put("current_results", bArr);
                    try {
                        try {
                            if (E_2.m43947i().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                E_2.mo4754r().I_().m21308a("Failed to insert filter results (got -1). appId", bb.m42550a(str));
                            }
                        } catch (SQLiteException e6) {
                            e = e6;
                            I_ = E_2.mo4754r().I_();
                            str4 = "Error storing filter results. appId";
                            I_.m21309a(str4, bb.m42550a(str), e);
                            map19 = map28;
                            i3 = i10;
                            map18 = c3211a6;
                            map17 = c3211a5;
                        }
                    } catch (SQLiteException e7) {
                        e = e7;
                        I_ = E_2.mo4754r().I_();
                        str4 = "Error storing filter results. appId";
                        I_.m21309a(str4, bb.m42550a(str), e);
                        map19 = map28;
                        i3 = i10;
                        map18 = c3211a6;
                        map17 = c3211a5;
                    }
                } catch (IOException e8) {
                    e = e8;
                    str5 = str;
                    I_ = E_2.mo4754r().I_();
                    str4 = "Configuration loss. Failed to serialize filter results. appId";
                    I_.m21309a(str4, bb.m42550a(str), e);
                    map19 = map28;
                    i3 = i10;
                    map18 = c3211a6;
                    map17 = c3211a5;
                }
                map19 = map28;
                i3 = i10;
                map18 = c3211a6;
                map17 = c3211a5;
            }
        }
        return (gi[]) Arrays.copyOf(giVarArr, i3);
    }

    /* renamed from: e */
    protected final boolean mo6850e() {
        return false;
    }
}
