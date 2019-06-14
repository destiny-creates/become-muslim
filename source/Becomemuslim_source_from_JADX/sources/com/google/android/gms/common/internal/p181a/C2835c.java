package com.google.android.gms.common.internal.p181a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.soloader.MinElf;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.a.c */
public class C2835c {
    /* renamed from: b */
    private static void m8204b(Parcel parcel, int i, int i2) {
        if (i2 >= MinElf.PN_XNUM) {
            parcel.writeInt(i | -65536);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt(i | (i2 << 16));
    }

    /* renamed from: b */
    private static int m8203b(Parcel parcel, int i) {
        parcel.writeInt(i | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    /* renamed from: c */
    private static void m8206c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    /* renamed from: a */
    public static int m8179a(Parcel parcel) {
        return C2835c.m8203b(parcel, 20293);
    }

    /* renamed from: a */
    public static void m8180a(Parcel parcel, int i) {
        C2835c.m8206c(parcel, i);
    }

    /* renamed from: a */
    public static void m8196a(Parcel parcel, int i, boolean z) {
        C2835c.m8204b(parcel, i, 4);
        parcel.writeInt(z);
    }

    /* renamed from: a */
    public static void m8189a(Parcel parcel, int i, Boolean bool, boolean z) {
        if (bool == null) {
            if (z) {
                C2835c.m8204b(parcel, i, null);
            }
            return;
        }
        C2835c.m8204b(parcel, i, true);
        parcel.writeInt(bool.booleanValue());
    }

    /* renamed from: a */
    public static void m8181a(Parcel parcel, int i, byte b) {
        C2835c.m8204b(parcel, i, 4);
        parcel.writeInt(b);
    }

    /* renamed from: a */
    public static void m8195a(Parcel parcel, int i, short s) {
        C2835c.m8204b(parcel, i, 4);
        parcel.writeInt(s);
    }

    /* renamed from: a */
    public static void m8184a(Parcel parcel, int i, int i2) {
        C2835c.m8204b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    /* renamed from: a */
    public static void m8185a(Parcel parcel, int i, long j) {
        C2835c.m8204b(parcel, i, 8);
        parcel.writeLong(j);
    }

    /* renamed from: a */
    public static void m8192a(Parcel parcel, int i, Long l, boolean z) {
        if (l == null) {
            if (z) {
                C2835c.m8204b(parcel, i, null);
            }
            return;
        }
        C2835c.m8204b(parcel, i, true);
        parcel.writeLong(l.longValue());
    }

    /* renamed from: a */
    public static void m8183a(Parcel parcel, int i, float f) {
        C2835c.m8204b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    /* renamed from: a */
    public static void m8191a(Parcel parcel, int i, Float f, boolean z) {
        if (f == null) {
            if (z) {
                C2835c.m8204b(parcel, i, null);
            }
            return;
        }
        C2835c.m8204b(parcel, i, true);
        parcel.writeFloat(f.floatValue());
    }

    /* renamed from: a */
    public static void m8182a(Parcel parcel, int i, double d) {
        C2835c.m8204b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    /* renamed from: a */
    public static void m8190a(Parcel parcel, int i, Double d, boolean z) {
        if (d == null) {
            if (z) {
                C2835c.m8204b(parcel, i, null);
            }
            return;
        }
        C2835c.m8204b(parcel, i, true);
        parcel.writeDouble(d.doubleValue());
    }

    /* renamed from: a */
    public static void m8193a(Parcel parcel, int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                C2835c.m8204b(parcel, i, null);
            }
            return;
        }
        i = C2835c.m8203b(parcel, i);
        parcel.writeString(str);
        C2835c.m8206c(parcel, i);
    }

    /* renamed from: a */
    public static void m8187a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                C2835c.m8204b(parcel, i, null);
            }
            return;
        }
        i = C2835c.m8203b(parcel, i);
        parcel.writeStrongBinder(iBinder);
        C2835c.m8206c(parcel, i);
    }

    /* renamed from: a */
    public static void m8188a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                C2835c.m8204b(parcel, i, null);
            }
            return;
        }
        i = C2835c.m8203b(parcel, i);
        parcelable.writeToParcel(parcel, i2);
        C2835c.m8206c(parcel, i);
    }

    /* renamed from: a */
    public static void m8186a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                C2835c.m8204b(parcel, i, null);
            }
            return;
        }
        i = C2835c.m8203b(parcel, i);
        parcel.writeBundle(bundle);
        C2835c.m8206c(parcel, i);
    }

    /* renamed from: a */
    public static void m8197a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                C2835c.m8204b(parcel, i, null);
            }
            return;
        }
        i = C2835c.m8203b(parcel, i);
        parcel.writeByteArray(bArr);
        C2835c.m8206c(parcel, i);
    }

    /* renamed from: a */
    public static void m8199a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr == null) {
            if (z) {
                C2835c.m8204b(parcel, i, null);
            }
            return;
        }
        i = C2835c.m8203b(parcel, i);
        parcel.writeIntArray(iArr);
        C2835c.m8206c(parcel, i);
    }

    /* renamed from: a */
    public static void m8198a(Parcel parcel, int i, float[] fArr, boolean z) {
        if (fArr == null) {
            if (z) {
                C2835c.m8204b(parcel, i, null);
            }
            return;
        }
        i = C2835c.m8203b(parcel, i);
        parcel.writeFloatArray(fArr);
        C2835c.m8206c(parcel, i);
    }

    /* renamed from: a */
    public static void m8201a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr == null) {
            if (z) {
                C2835c.m8204b(parcel, i, null);
            }
            return;
        }
        i = C2835c.m8203b(parcel, i);
        parcel.writeStringArray(strArr);
        C2835c.m8206c(parcel, i);
    }

    /* renamed from: a */
    public static void m8194a(Parcel parcel, int i, List<Integer> list, boolean z) {
        boolean z2 = false;
        if (list == null) {
            if (z) {
                C2835c.m8204b(parcel, i, 0);
            }
            return;
        }
        i = C2835c.m8203b(parcel, i);
        z = list.size();
        parcel.writeInt(z);
        while (z2 < z) {
            parcel.writeInt(((Integer) list.get(z2)).intValue());
            z2++;
        }
        C2835c.m8206c(parcel, i);
    }

    /* renamed from: b */
    public static void m8205b(Parcel parcel, int i, List<String> list, boolean z) {
        if (list == null) {
            if (z) {
                C2835c.m8204b(parcel, i, null);
            }
            return;
        }
        i = C2835c.m8203b(parcel, i);
        parcel.writeStringList(list);
        C2835c.m8206c(parcel, i);
    }

    /* renamed from: a */
    public static <T extends Parcelable> void m8200a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr == null) {
            if (z) {
                C2835c.m8204b(parcel, i, 0);
            }
            return;
        }
        i = C2835c.m8203b(parcel, i);
        parcel.writeInt(z);
        for (Parcelable parcelable : tArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                C2835c.m8202a(parcel, parcelable, i2);
            }
        }
        C2835c.m8206c(parcel, i);
    }

    /* renamed from: c */
    public static <T extends Parcelable> void m8207c(Parcel parcel, int i, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                C2835c.m8204b(parcel, i, 0);
            }
            return;
        }
        i = C2835c.m8203b(parcel, i);
        z = list.size();
        parcel.writeInt(z);
        for (boolean z2 = false; z2 < z; z2++) {
            Parcelable parcelable = (Parcelable) list.get(z2);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                C2835c.m8202a(parcel, parcelable, 0);
            }
        }
        C2835c.m8206c(parcel, i);
    }

    /* renamed from: a */
    private static <T extends Parcelable> void m8202a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        t = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(t - dataPosition2);
        parcel.setDataPosition(t);
    }

    /* renamed from: d */
    public static void m8208d(Parcel parcel, int i, List list, boolean z) {
        if (list == null) {
            if (z) {
                C2835c.m8204b(parcel, i, null);
            }
            return;
        }
        i = C2835c.m8203b(parcel, i);
        parcel.writeList(list);
        C2835c.m8206c(parcel, i);
    }
}
