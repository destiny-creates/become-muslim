package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.maps.model.n */
public class C7852n extends C4363a {
    public static final Creator<C7852n> CREATOR = new ak();
    /* renamed from: a */
    private static final String f29282a = "n";
    /* renamed from: b */
    private final int f29283b;
    /* renamed from: c */
    private final Float f29284c;

    public C7852n(int i, Float f) {
        boolean z = true;
        if (i != 1) {
            if (f == null || f.floatValue() < 0.0f) {
                z = false;
            }
        }
        String valueOf = String.valueOf(f);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 45);
        stringBuilder.append("Invalid PatternItem: type=");
        stringBuilder.append(i);
        stringBuilder.append(" length=");
        stringBuilder.append(valueOf);
        C2872v.b(z, stringBuilder.toString());
        this.f29283b = i;
        this.f29284c = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7852n)) {
            return false;
        }
        C7852n c7852n = (C7852n) obj;
        return this.f29283b == c7852n.f29283b && C2868t.a(this.f29284c, c7852n.f29284c);
    }

    public int hashCode() {
        return C2868t.a(new Object[]{Integer.valueOf(this.f29283b), this.f29284c});
    }

    public String toString() {
        int i = this.f29283b;
        String valueOf = String.valueOf(this.f29284c);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 39);
        stringBuilder.append("[PatternItem: type=");
        stringBuilder.append(i);
        stringBuilder.append(" length=");
        stringBuilder.append(valueOf);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29283b);
        C2835c.a(parcel, 3, this.f29284c, false);
        C2835c.a(parcel, i);
    }
}
