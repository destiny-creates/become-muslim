package com.google.android.gms.internal.p211j;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.location.C5076f;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.j.aj */
public final class aj extends C4363a implements C5076f {
    public static final Creator<aj> CREATOR = new ak();
    /* renamed from: a */
    private final String f28943a;
    /* renamed from: b */
    private final long f28944b;
    /* renamed from: c */
    private final short f28945c;
    /* renamed from: d */
    private final double f28946d;
    /* renamed from: e */
    private final double f28947e;
    /* renamed from: f */
    private final float f28948f;
    /* renamed from: g */
    private final int f28949g;
    /* renamed from: h */
    private final int f28950h;
    /* renamed from: i */
    private final int f28951i;

    public aj(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        if (str != null) {
            if (str.length() <= 100) {
                StringBuilder stringBuilder;
                if (f <= 0.0f) {
                    stringBuilder = new StringBuilder(31);
                    stringBuilder.append("invalid radius: ");
                    stringBuilder.append(f);
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else if (d > 90.0d || d < -90.0d) {
                    stringBuilder = new StringBuilder(42);
                    stringBuilder.append("invalid latitude: ");
                    stringBuilder.append(d);
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else if (d2 > 180.0d || d2 < -180.0d) {
                    stringBuilder = new StringBuilder(43);
                    stringBuilder.append("invalid longitude: ");
                    stringBuilder.append(d2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                } else {
                    int i4 = i & 7;
                    if (i4 != 0) {
                        this.f28945c = s;
                        this.f28943a = str;
                        this.f28946d = d;
                        this.f28947e = d2;
                        this.f28948f = f;
                        this.f28944b = j;
                        this.f28949g = i4;
                        this.f28950h = i2;
                        this.f28951i = i3;
                        return;
                    }
                    StringBuilder stringBuilder2 = new StringBuilder(46);
                    stringBuilder2.append("No supported transition specified: ");
                    stringBuilder2.append(i);
                    throw new IllegalArgumentException(stringBuilder2.toString());
                }
            }
        }
        String str2 = "requestId is null or too long: ";
        str = String.valueOf(str);
        throw new IllegalArgumentException(str.length() != 0 ? str2.concat(str) : new String(str2));
    }

    /* renamed from: a */
    public static aj m38023a(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        aj ajVar = (aj) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return ajVar;
    }

    /* renamed from: a */
    public final String mo6206a() {
        return this.f28943a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof aj)) {
            return false;
        }
        aj ajVar = (aj) obj;
        return this.f28948f == ajVar.f28948f && this.f28946d == ajVar.f28946d && this.f28947e == ajVar.f28947e && this.f28945c == ajVar.f28945c;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f28946d);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f28947e);
        return (((((((i * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2))) * 31) + Float.floatToIntBits(this.f28948f)) * 31) + this.f28945c) * 31) + this.f28949g;
    }

    public final String toString() {
        Locale locale = Locale.US;
        String str = "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]";
        Object[] objArr = new Object[9];
        objArr[0] = this.f28945c != (short) 1 ? null : "CIRCLE";
        objArr[1] = this.f28943a.replaceAll("\\p{C}", "?");
        objArr[2] = Integer.valueOf(this.f28949g);
        objArr[3] = Double.valueOf(this.f28946d);
        objArr[4] = Double.valueOf(this.f28947e);
        objArr[5] = Float.valueOf(this.f28948f);
        objArr[6] = Integer.valueOf(this.f28950h / 1000);
        objArr[7] = Integer.valueOf(this.f28951i);
        objArr[8] = Long.valueOf(this.f28944b);
        return String.format(locale, str, objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 1, mo6206a(), false);
        C2835c.a(parcel, 2, this.f28944b);
        C2835c.a(parcel, 3, this.f28945c);
        C2835c.a(parcel, 4, this.f28946d);
        C2835c.a(parcel, 5, this.f28947e);
        C2835c.a(parcel, 6, this.f28948f);
        C2835c.a(parcel, 7, this.f28949g);
        C2835c.a(parcel, 8, this.f28950h);
        C2835c.a(parcel, 9, this.f28951i);
        C2835c.a(parcel, i);
    }
}
