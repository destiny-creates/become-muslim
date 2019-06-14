package com.polidea.p254a.p255a;

import com.polidea.p254a.p264d.C5625a;

/* compiled from: BleDisconnectedException */
/* renamed from: com.polidea.a.a.f */
public class C6973f extends C5548g {
    /* renamed from: a */
    public final String f24860a;
    /* renamed from: b */
    public final int f24861b;

    /* renamed from: a */
    public static C6973f m32746a(String str) {
        return new C6973f(new C6968a(), str, -1);
    }

    @Deprecated
    public C6973f() {
        this("", -1);
    }

    public C6973f(Throwable th, String str, int i) {
        super(C6973f.m32747a(str, i), th);
        this.f24860a = str;
        this.f24861b = i;
    }

    public C6973f(String str, int i) {
        super(C6973f.m32747a(str, i));
        this.f24860a = str;
        this.f24861b = i;
    }

    /* renamed from: a */
    private static String m32747a(String str, int i) {
        String a = C5625a.m23920a(i);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Disconnected from ");
        stringBuilder.append(str);
        stringBuilder.append(" with status ");
        stringBuilder.append(i);
        stringBuilder.append(" (");
        stringBuilder.append(a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
