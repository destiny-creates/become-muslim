package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.C3211a;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.common.util.C2900k;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* renamed from: com.google.android.gms.fitness.data.h */
public final class C4806h extends C4363a {
    public static final Creator<C4806h> CREATOR = new C2999n();
    /* renamed from: a */
    private final int f13541a;
    /* renamed from: b */
    private boolean f13542b;
    /* renamed from: c */
    private float f13543c;
    /* renamed from: d */
    private String f13544d;
    /* renamed from: e */
    private Map<String, MapValue> f13545e;
    /* renamed from: f */
    private int[] f13546f;
    /* renamed from: g */
    private float[] f13547g;
    /* renamed from: h */
    private byte[] f13548h;

    C4806h(int i, boolean z, float f, String str, Bundle bundle, int[] iArr, float[] fArr, byte[] bArr) {
        Map map;
        this.f13541a = i;
        this.f13542b = z;
        this.f13543c = f;
        this.f13544d = str;
        if (bundle == null) {
            map = null;
        } else {
            bundle.setClassLoader(MapValue.class.getClassLoader());
            map = new C3211a(bundle.size());
            for (String str2 : bundle.keySet()) {
                map.put(str2, (MapValue) bundle.getParcelable(str2));
            }
        }
        this.f13545e = map;
        this.f13546f = iArr;
        this.f13547g = fArr;
        this.f13548h = bArr;
    }

    /* renamed from: a */
    public final boolean m17032a() {
        return this.f13542b;
    }

    /* renamed from: b */
    public final int m17033b() {
        return this.f13541a;
    }

    /* renamed from: c */
    public final int m17034c() {
        boolean z = true;
        if (this.f13541a != 1) {
            z = false;
        }
        C2872v.m8387a(z, (Object) "Value is not in int format");
        return Float.floatToRawIntBits(this.f13543c);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4806h)) {
            return false;
        }
        C4806h c4806h = (C4806h) obj;
        if (this.f13541a == c4806h.f13541a && this.f13542b == c4806h.f13542b) {
            switch (this.f13541a) {
                case 1:
                    if (m17034c() == c4806h.m17034c()) {
                        return true;
                    }
                    break;
                case 2:
                    return this.f13543c == c4806h.f13543c;
                case 3:
                    return C2868t.m8374a(this.f13544d, c4806h.f13544d);
                case 4:
                    return C2868t.m8374a(this.f13545e, c4806h.f13545e);
                case 5:
                    return Arrays.equals(this.f13546f, c4806h.f13546f);
                case 6:
                    return Arrays.equals(this.f13547g, c4806h.f13547g);
                case 7:
                    return Arrays.equals(this.f13548h, c4806h.f13548h);
                default:
                    if (this.f13543c == c4806h.f13543c) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    public final int hashCode() {
        return C2868t.m8372a(Float.valueOf(this.f13543c), this.f13544d, this.f13545e, this.f13546f, this.f13547g, this.f13548h);
    }

    public final String toString() {
        if (!this.f13542b) {
            return "unset";
        }
        switch (this.f13541a) {
            case 1:
                return Integer.toString(m17034c());
            case 2:
                return Float.toString(this.f13543c);
            case 3:
                return this.f13544d;
            case 4:
                return new TreeMap(this.f13545e).toString();
            case 5:
                return Arrays.toString(this.f13546f);
            case 6:
                return Arrays.toString(this.f13547g);
            case 7:
                return C2900k.m8447a(this.f13548h, 0, this.f13548h.length, false);
            default:
                return "unknown";
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle;
        i = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 1, m17033b());
        C2835c.m8196a(parcel, 2, m17032a());
        C2835c.m8183a(parcel, 3, this.f13543c);
        C2835c.m8193a(parcel, 4, this.f13544d, false);
        if (this.f13545e == null) {
            bundle = null;
        } else {
            bundle = new Bundle(this.f13545e.size());
            for (Entry entry : this.f13545e.entrySet()) {
                bundle.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
            }
        }
        C2835c.m8186a(parcel, 5, bundle, false);
        C2835c.m8199a(parcel, 6, this.f13546f, false);
        C2835c.m8198a(parcel, 7, this.f13547g, false);
        C2835c.m8197a(parcel, 8, this.f13548h, false);
        C2835c.m8180a(parcel, i);
    }
}
