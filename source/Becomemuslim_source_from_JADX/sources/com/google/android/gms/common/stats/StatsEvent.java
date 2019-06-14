package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C4363a;

public abstract class StatsEvent extends C4363a implements ReflectedParcelable {
    /* renamed from: a */
    public abstract long mo3463a();

    /* renamed from: b */
    public abstract int mo3464b();

    /* renamed from: c */
    public abstract long mo3465c();

    /* renamed from: d */
    public abstract String mo3466d();

    public String toString() {
        long a = mo3463a();
        int b = mo3464b();
        long c = mo3465c();
        String d = mo3466d();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(d).length() + 53);
        stringBuilder.append(a);
        stringBuilder.append("\t");
        stringBuilder.append(b);
        stringBuilder.append("\t");
        stringBuilder.append(c);
        stringBuilder.append(d);
        return stringBuilder.toString();
    }
}
