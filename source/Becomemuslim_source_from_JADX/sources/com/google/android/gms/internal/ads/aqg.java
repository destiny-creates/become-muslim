package com.google.android.gms.internal.ads;

import android.text.TextUtils;

public final class aqg {
    /* renamed from: a */
    private final String f14819a;
    /* renamed from: b */
    private final String f14820b;

    public aqg(String str, String str2) {
        this.f14819a = str;
        this.f14820b = str2;
    }

    /* renamed from: a */
    public final String m18748a() {
        return this.f14819a;
    }

    /* renamed from: b */
    public final String m18749b() {
        return this.f14820b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                aqg aqg = (aqg) obj;
                return TextUtils.equals(this.f14819a, aqg.f14819a) && TextUtils.equals(this.f14820b, aqg.f14820b);
            }
        }
    }

    public final int hashCode() {
        return (this.f14819a.hashCode() * 31) + this.f14820b.hashCode();
    }

    public final String toString() {
        String str = this.f14819a;
        String str2 = this.f14820b;
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 20) + String.valueOf(str2).length());
        stringBuilder.append("Header[name=");
        stringBuilder.append(str);
        stringBuilder.append(",value=");
        stringBuilder.append(str2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
