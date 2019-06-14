package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p136c.C2255a.C2254a;
import com.google.android.exoplayer2.p145g.C2344a;
import com.google.android.exoplayer2.p164l.C2541v;
import com.google.android.exoplayer2.p165m.C2546b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Format */
/* renamed from: com.google.android.exoplayer2.k */
public final class C2515k implements Parcelable {
    public static final Creator<C2515k> CREATOR = new C24901();
    /* renamed from: A */
    private int f6374A;
    /* renamed from: a */
    public final String f6375a;
    /* renamed from: b */
    public final int f6376b;
    /* renamed from: c */
    public final String f6377c;
    /* renamed from: d */
    public final C2344a f6378d;
    /* renamed from: e */
    public final String f6379e;
    /* renamed from: f */
    public final String f6380f;
    /* renamed from: g */
    public final int f6381g;
    /* renamed from: h */
    public final List<byte[]> f6382h;
    /* renamed from: i */
    public final C2255a f6383i;
    /* renamed from: j */
    public final int f6384j;
    /* renamed from: k */
    public final int f6385k;
    /* renamed from: l */
    public final float f6386l;
    /* renamed from: m */
    public final int f6387m;
    /* renamed from: n */
    public final float f6388n;
    /* renamed from: o */
    public final int f6389o;
    /* renamed from: p */
    public final byte[] f6390p;
    /* renamed from: q */
    public final C2546b f6391q;
    /* renamed from: r */
    public final int f6392r;
    /* renamed from: s */
    public final int f6393s;
    /* renamed from: t */
    public final int f6394t;
    /* renamed from: u */
    public final int f6395u;
    /* renamed from: v */
    public final int f6396v;
    /* renamed from: w */
    public final long f6397w;
    /* renamed from: x */
    public final int f6398x;
    /* renamed from: y */
    public final String f6399y;
    /* renamed from: z */
    public final int f6400z;

    /* compiled from: Format */
    /* renamed from: com.google.android.exoplayer2.k$1 */
    static class C24901 implements Creator<C2515k> {
        C24901() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6940a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6941a(i);
        }

        /* renamed from: a */
        public C2515k m6940a(Parcel parcel) {
            return new C2515k(parcel);
        }

        /* renamed from: a */
        public C2515k[] m6941a(int i) {
            return new C2515k[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: a */
    public static C2515k m6994a(String str, String str2, String str3, String str4, int i, int i2, int i3, float f, List<byte[]> list, int i4) {
        return new C2515k(str, str2, str3, str4, i, -1, i2, i3, f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i4, null, -1, Clock.MAX_TIME, list, null, null);
    }

    /* renamed from: a */
    public static C2515k m6984a(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, C2255a c2255a) {
        return C2515k.m6985a(str, str2, str3, i, i2, i3, i4, f, (List) list, i5, f2, null, -1, null, c2255a);
    }

    /* renamed from: a */
    public static C2515k m6985a(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, C2546b c2546b, C2255a c2255a) {
        return new C2515k(str, null, str2, str3, i, i2, i3, i4, f, i5, f2, bArr, i6, c2546b, -1, -1, -1, -1, -1, 0, null, -1, Clock.MAX_TIME, list, c2255a, null);
    }

    /* renamed from: a */
    public static C2515k m6995a(String str, String str2, String str3, String str4, int i, int i2, int i3, List<byte[]> list, int i4, String str5) {
        return new C2515k(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i2, i3, -1, -1, -1, i4, str5, -1, Clock.MAX_TIME, list, null, null);
    }

    /* renamed from: a */
    public static C2515k m6988a(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, C2255a c2255a, int i5, String str4) {
        return C2515k.m6987a(str, str2, str3, i, i2, i3, i4, -1, (List) list, c2255a, i5, str4);
    }

    /* renamed from: a */
    public static C2515k m6987a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, C2255a c2255a, int i6, String str4) {
        return C2515k.m6986a(str, str2, str3, i, i2, i3, i4, i5, -1, -1, (List) list, c2255a, i6, str4, null);
    }

    /* renamed from: a */
    public static C2515k m6986a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, int i6, int i7, List<byte[]> list, C2255a c2255a, int i8, String str4, C2344a c2344a) {
        return new C2515k(str, null, str2, str3, i, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, i6, i7, i8, str4, -1, Clock.MAX_TIME, list, c2255a, c2344a);
    }

    /* renamed from: a */
    public static C2515k m6996a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        return C2515k.m6997a(str, str2, str3, str4, i, i2, str5, -1);
    }

    /* renamed from: a */
    public static C2515k m6997a(String str, String str2, String str3, String str4, int i, int i2, String str5, int i3) {
        return new C2515k(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str5, i3, Clock.MAX_TIME, null, null, null);
    }

    /* renamed from: a */
    public static C2515k m6981a(String str, String str2, int i, String str3) {
        return C2515k.m6982a(str, str2, i, str3, null);
    }

    /* renamed from: a */
    public static C2515k m6982a(String str, String str2, int i, String str3, C2255a c2255a) {
        return C2515k.m6990a(str, str2, null, -1, i, str3, -1, c2255a, (long) Clock.MAX_TIME, Collections.emptyList());
    }

    /* renamed from: a */
    public static C2515k m6989a(String str, String str2, String str3, int i, int i2, String str4, int i3, C2255a c2255a) {
        return C2515k.m6990a(str, str2, str3, i, i2, str4, i3, c2255a, (long) Clock.MAX_TIME, Collections.emptyList());
    }

    /* renamed from: a */
    public static C2515k m6991a(String str, String str2, String str3, int i, int i2, String str4, C2255a c2255a, long j) {
        return C2515k.m6990a(str, str2, str3, i, i2, str4, -1, c2255a, j, Collections.emptyList());
    }

    /* renamed from: a */
    public static C2515k m6990a(String str, String str2, String str3, int i, int i2, String str4, int i3, C2255a c2255a, long j, List<byte[]> list) {
        return new C2515k(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, i3, j, list, c2255a, null);
    }

    /* renamed from: a */
    public static C2515k m6993a(String str, String str2, String str3, int i, List<byte[]> list, String str4, C2255a c2255a) {
        return new C2515k(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, Clock.MAX_TIME, list, c2255a, null);
    }

    /* renamed from: b */
    public static C2515k m7004b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        return new C2515k(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str5, -1, Clock.MAX_TIME, null, null, null);
    }

    /* renamed from: a */
    public static C2515k m6983a(String str, String str2, long j) {
        return new C2515k(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j, null, null, null);
    }

    /* renamed from: a */
    public static C2515k m6992a(String str, String str2, String str3, int i, C2255a c2255a) {
        return new C2515k(str, null, str2, str3, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Clock.MAX_TIME, null, c2255a, null);
    }

    C2515k(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, C2546b c2546b, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, C2255a c2255a, C2344a c2344a) {
        this.f6375a = str;
        this.f6379e = str2;
        this.f6380f = str3;
        this.f6377c = str4;
        this.f6376b = i;
        this.f6381g = i2;
        this.f6384j = i3;
        this.f6385k = i4;
        this.f6386l = f;
        this.f6387m = i5;
        this.f6388n = f2;
        this.f6390p = bArr;
        this.f6389o = i6;
        this.f6391q = c2546b;
        this.f6392r = i7;
        this.f6393s = i8;
        this.f6394t = i9;
        this.f6395u = i10;
        this.f6396v = i11;
        this.f6398x = i12;
        this.f6399y = str5;
        this.f6400z = i13;
        this.f6397w = j;
        r0.f6382h = list == null ? Collections.emptyList() : list;
        r0.f6383i = c2255a;
        r0.f6378d = c2344a;
    }

    C2515k(Parcel parcel) {
        this.f6375a = parcel.readString();
        this.f6379e = parcel.readString();
        this.f6380f = parcel.readString();
        this.f6377c = parcel.readString();
        this.f6376b = parcel.readInt();
        this.f6381g = parcel.readInt();
        this.f6384j = parcel.readInt();
        this.f6385k = parcel.readInt();
        this.f6386l = parcel.readFloat();
        this.f6387m = parcel.readInt();
        this.f6388n = parcel.readFloat();
        this.f6390p = (parcel.readInt() != 0 ? 1 : null) != null ? parcel.createByteArray() : null;
        this.f6389o = parcel.readInt();
        this.f6391q = (C2546b) parcel.readParcelable(C2546b.class.getClassLoader());
        this.f6392r = parcel.readInt();
        this.f6393s = parcel.readInt();
        this.f6394t = parcel.readInt();
        this.f6395u = parcel.readInt();
        this.f6396v = parcel.readInt();
        this.f6398x = parcel.readInt();
        this.f6399y = parcel.readString();
        this.f6400z = parcel.readInt();
        this.f6397w = parcel.readLong();
        int readInt = parcel.readInt();
        this.f6382h = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f6382h.add(parcel.createByteArray());
        }
        this.f6383i = (C2255a) parcel.readParcelable(C2255a.class.getClassLoader());
        this.f6378d = (C2344a) parcel.readParcelable(C2344a.class.getClassLoader());
    }

    /* renamed from: a */
    public C2515k m7006a(int i) {
        int i2 = i;
        return new C2515k(this.f6375a, this.f6379e, this.f6380f, this.f6377c, this.f6376b, i2, this.f6384j, this.f6385k, this.f6386l, this.f6387m, this.f6388n, this.f6390p, this.f6389o, this.f6391q, this.f6392r, this.f6393s, this.f6394t, this.f6395u, this.f6396v, this.f6398x, this.f6399y, this.f6400z, this.f6397w, this.f6382h, this.f6383i, this.f6378d);
    }

    /* renamed from: a */
    public C2515k m7008a(long j) {
        return new C2515k(this.f6375a, this.f6379e, this.f6380f, this.f6377c, this.f6376b, this.f6381g, this.f6384j, this.f6385k, this.f6386l, this.f6387m, this.f6388n, this.f6390p, this.f6389o, this.f6391q, this.f6392r, this.f6393s, this.f6394t, this.f6395u, this.f6396v, this.f6398x, this.f6399y, this.f6400z, j, this.f6382h, this.f6383i, this.f6378d);
    }

    /* renamed from: a */
    public C2515k m7012a(String str, String str2, int i, int i2, int i3, int i4, String str3) {
        return new C2515k(str, this.f6379e, this.f6380f, str2, i, this.f6381g, i2, i3, this.f6386l, this.f6387m, this.f6388n, this.f6390p, this.f6389o, this.f6391q, this.f6392r, this.f6393s, this.f6394t, this.f6395u, this.f6396v, i4, str3, this.f6400z, this.f6397w, this.f6382h, this.f6383i, this.f6378d);
    }

    /* renamed from: a */
    public C2515k m7011a(C2515k c2515k) {
        C2515k c2515k2 = c2515k;
        if (this == c2515k2) {
            return r0;
        }
        return new C2515k(c2515k2.f6375a, r0.f6379e, r0.f6380f, r0.f6377c == null ? c2515k2.f6377c : r0.f6377c, r0.f6376b == -1 ? c2515k2.f6376b : r0.f6376b, r0.f6381g, r0.f6384j, r0.f6385k, r0.f6386l == -1.0f ? c2515k2.f6386l : r0.f6386l, r0.f6387m, r0.f6388n, r0.f6390p, r0.f6389o, r0.f6391q, r0.f6392r, r0.f6393s, r0.f6394t, r0.f6395u, r0.f6396v, r0.f6398x | c2515k2.f6398x, r0.f6399y == null ? c2515k2.f6399y : r0.f6399y, r0.f6400z, r0.f6397w, r0.f6382h, c2515k2.f6383i != null ? m7003b(c2515k2.f6383i) : r0.f6383i, r0.f6378d);
    }

    /* renamed from: a */
    public C2515k m7007a(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        return new C2515k(this.f6375a, this.f6379e, this.f6380f, this.f6377c, this.f6376b, this.f6381g, this.f6384j, this.f6385k, this.f6386l, this.f6387m, this.f6388n, this.f6390p, this.f6389o, this.f6391q, this.f6392r, this.f6393s, this.f6394t, i3, i4, this.f6398x, this.f6399y, this.f6400z, this.f6397w, this.f6382h, this.f6383i, this.f6378d);
    }

    /* renamed from: a */
    public C2515k m7009a(C2255a c2255a) {
        C2255a c2255a2 = c2255a;
        return new C2515k(this.f6375a, this.f6379e, this.f6380f, this.f6377c, this.f6376b, this.f6381g, this.f6384j, this.f6385k, this.f6386l, this.f6387m, this.f6388n, this.f6390p, this.f6389o, this.f6391q, this.f6392r, this.f6393s, this.f6394t, this.f6395u, this.f6396v, this.f6398x, this.f6399y, this.f6400z, this.f6397w, this.f6382h, c2255a2, this.f6378d);
    }

    /* renamed from: a */
    public C2515k m7010a(C2344a c2344a) {
        C2344a c2344a2 = c2344a;
        return new C2515k(this.f6375a, this.f6379e, this.f6380f, this.f6377c, this.f6376b, this.f6381g, this.f6384j, this.f6385k, this.f6386l, this.f6387m, this.f6388n, this.f6390p, this.f6389o, this.f6391q, this.f6392r, this.f6393s, this.f6394t, this.f6395u, this.f6396v, this.f6398x, this.f6399y, this.f6400z, this.f6397w, this.f6382h, this.f6383i, c2344a2);
    }

    /* renamed from: a */
    public int m7005a() {
        if (this.f6384j == -1) {
            return -1;
        }
        if (this.f6385k == -1) {
            return -1;
        }
        return this.f6385k * this.f6384j;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    /* renamed from: b */
    public final MediaFormat m7013b() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.f6380f);
        C2515k.m7001a(mediaFormat, "language", this.f6399y);
        C2515k.m7000a(mediaFormat, "max-input-size", this.f6381g);
        C2515k.m7000a(mediaFormat, "width", this.f6384j);
        C2515k.m7000a(mediaFormat, "height", this.f6385k);
        C2515k.m6999a(mediaFormat, "frame-rate", this.f6386l);
        C2515k.m7000a(mediaFormat, "rotation-degrees", this.f6387m);
        C2515k.m7000a(mediaFormat, "channel-count", this.f6392r);
        C2515k.m7000a(mediaFormat, "sample-rate", this.f6393s);
        for (int i = 0; i < this.f6382h.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("csd-");
            stringBuilder.append(i);
            mediaFormat.setByteBuffer(stringBuilder.toString(), ByteBuffer.wrap((byte[]) this.f6382h.get(i)));
        }
        C2515k.m6998a(mediaFormat, this.f6391q);
        return mediaFormat;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Format(");
        stringBuilder.append(this.f6375a);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6379e);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6380f);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6376b);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6399y);
        stringBuilder.append(", [");
        stringBuilder.append(this.f6384j);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6385k);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6386l);
        stringBuilder.append("]");
        stringBuilder.append(", [");
        stringBuilder.append(this.f6392r);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6393s);
        stringBuilder.append("])");
        return stringBuilder.toString();
    }

    public int hashCode() {
        if (this.f6374A == 0) {
            int i = 0;
            int hashCode = (((((((((((((((((((((((527 + (this.f6375a == null ? 0 : this.f6375a.hashCode())) * 31) + (this.f6379e == null ? 0 : this.f6379e.hashCode())) * 31) + (this.f6380f == null ? 0 : this.f6380f.hashCode())) * 31) + (this.f6377c == null ? 0 : this.f6377c.hashCode())) * 31) + this.f6376b) * 31) + this.f6384j) * 31) + this.f6385k) * 31) + this.f6392r) * 31) + this.f6393s) * 31) + (this.f6399y == null ? 0 : this.f6399y.hashCode())) * 31) + this.f6400z) * 31) + (this.f6383i == null ? 0 : this.f6383i.hashCode())) * 31;
            if (this.f6378d != null) {
                i = this.f6378d.hashCode();
            }
            this.f6374A = hashCode + i;
        }
        return this.f6374A;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C2515k c2515k = (C2515k) obj;
                if (this.f6376b == c2515k.f6376b && this.f6381g == c2515k.f6381g && this.f6384j == c2515k.f6384j && this.f6385k == c2515k.f6385k && this.f6386l == c2515k.f6386l && this.f6387m == c2515k.f6387m && this.f6388n == c2515k.f6388n && this.f6389o == c2515k.f6389o && this.f6392r == c2515k.f6392r && this.f6393s == c2515k.f6393s && this.f6394t == c2515k.f6394t && this.f6395u == c2515k.f6395u && this.f6396v == c2515k.f6396v && this.f6397w == c2515k.f6397w && this.f6398x == c2515k.f6398x && C2541v.m7179a(this.f6375a, c2515k.f6375a) && C2541v.m7179a(this.f6399y, c2515k.f6399y) && this.f6400z == c2515k.f6400z && C2541v.m7179a(this.f6379e, c2515k.f6379e) && C2541v.m7179a(this.f6380f, c2515k.f6380f) && C2541v.m7179a(this.f6377c, c2515k.f6377c) && C2541v.m7179a(this.f6383i, c2515k.f6383i) && C2541v.m7179a(this.f6378d, c2515k.f6378d) && C2541v.m7179a(this.f6391q, c2515k.f6391q) && Arrays.equals(this.f6390p, c2515k.f6390p)) {
                    if (this.f6382h.size() == c2515k.f6382h.size()) {
                        for (int i = 0; i < this.f6382h.size(); i++) {
                            if (!Arrays.equals((byte[]) this.f6382h.get(i), (byte[]) c2515k.f6382h.get(i))) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    @TargetApi(24)
    /* renamed from: a */
    private static void m6998a(MediaFormat mediaFormat, C2546b c2546b) {
        if (c2546b != null) {
            C2515k.m7000a(mediaFormat, "color-transfer", c2546b.f6484c);
            C2515k.m7000a(mediaFormat, "color-standard", c2546b.f6482a);
            C2515k.m7000a(mediaFormat, "color-range", c2546b.f6483b);
            C2515k.m7002a(mediaFormat, "hdr-static-info", c2546b.f6485d);
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    private static void m7001a(MediaFormat mediaFormat, String str, String str2) {
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    private static void m7000a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    private static void m6999a(MediaFormat mediaFormat, String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    private static void m7002a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6375a);
        parcel.writeString(this.f6379e);
        parcel.writeString(this.f6380f);
        parcel.writeString(this.f6377c);
        parcel.writeInt(this.f6376b);
        parcel.writeInt(this.f6381g);
        parcel.writeInt(this.f6384j);
        parcel.writeInt(this.f6385k);
        parcel.writeFloat(this.f6386l);
        parcel.writeInt(this.f6387m);
        parcel.writeFloat(this.f6388n);
        parcel.writeInt(this.f6390p != null ? 1 : 0);
        if (this.f6390p != null) {
            parcel.writeByteArray(this.f6390p);
        }
        parcel.writeInt(this.f6389o);
        parcel.writeParcelable(this.f6391q, i);
        parcel.writeInt(this.f6392r);
        parcel.writeInt(this.f6393s);
        parcel.writeInt(this.f6394t);
        parcel.writeInt(this.f6395u);
        parcel.writeInt(this.f6396v);
        parcel.writeInt(this.f6398x);
        parcel.writeString(this.f6399y);
        parcel.writeInt(this.f6400z);
        parcel.writeLong(this.f6397w);
        i = this.f6382h.size();
        parcel.writeInt(i);
        for (int i2 = 0; i2 < i; i2++) {
            parcel.writeByteArray((byte[]) this.f6382h.get(i2));
        }
        parcel.writeParcelable(this.f6383i, 0);
        parcel.writeParcelable(this.f6378d, 0);
    }

    /* renamed from: b */
    private C2255a m7003b(C2255a c2255a) {
        int i;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (i = 0; i < c2255a.f5387b; i++) {
            C2254a a = c2255a.m6232a(i);
            if (a.m6228a()) {
                arrayList.add(a);
            } else {
                arrayList2.add(a);
            }
        }
        if (arrayList2.isEmpty()) {
            return c2255a;
        }
        C2255a c2255a2 = null;
        if (this.f6383i == null) {
            return null;
        }
        i = arrayList2.size();
        for (int i2 = 0; i2 < this.f6383i.f5387b; i2++) {
            C2254a a2 = this.f6383i.m6232a(i2);
            for (int i3 = 0; i3 < i; i3++) {
                if (a2.m6229a((C2254a) arrayList2.get(i3))) {
                    arrayList.add(a2);
                    break;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            c2255a2 = new C2255a(c2255a.f5386a, (C2254a[]) arrayList.toArray(new C2254a[arrayList.size()]));
        }
        return c2255a2;
    }
}
