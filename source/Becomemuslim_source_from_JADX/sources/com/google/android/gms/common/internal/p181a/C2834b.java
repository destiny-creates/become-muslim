package com.google.android.gms.common.internal.p181a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.soloader.MinElf;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.a.b */
public class C2834b {

    /* renamed from: com.google.android.gms.common.internal.a.b$a */
    public static class C2833a extends RuntimeException {
        public C2833a(String str, Parcel parcel) {
            int dataPosition = parcel.dataPosition();
            parcel = parcel.dataSize();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 41);
            stringBuilder.append(str);
            stringBuilder.append(" Parcel: pos=");
            stringBuilder.append(dataPosition);
            stringBuilder.append(" size=");
            stringBuilder.append(parcel);
            super(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public static int m8147a(int i) {
        return i & MinElf.PN_XNUM;
    }

    /* renamed from: a */
    public static int m8148a(Parcel parcel) {
        return parcel.readInt();
    }

    /* renamed from: a */
    public static int m8149a(Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (i >> 16) & MinElf.PN_XNUM : parcel.readInt();
    }

    /* renamed from: b */
    public static void m8155b(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + C2834b.m8149a(parcel, i));
    }

    /* renamed from: a */
    private static void m8151a(Parcel parcel, int i, int i2) {
        i = C2834b.m8149a(parcel, i);
        if (i != i2) {
            String toHexString = Integer.toHexString(i);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(toHexString).length() + 46);
            stringBuilder.append("Expected size ");
            stringBuilder.append(i2);
            stringBuilder.append(" got ");
            stringBuilder.append(i);
            stringBuilder.append(" (0x");
            stringBuilder.append(toHexString);
            stringBuilder.append(")");
            throw new C2833a(stringBuilder.toString(), parcel);
        }
    }

    /* renamed from: a */
    private static void m8152a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            String toHexString = Integer.toHexString(i2);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(toHexString).length() + 46);
            stringBuilder.append("Expected size ");
            stringBuilder.append(i3);
            stringBuilder.append(" got ");
            stringBuilder.append(i2);
            stringBuilder.append(" (0x");
            stringBuilder.append(toHexString);
            stringBuilder.append(")");
            throw new C2833a(stringBuilder.toString(), parcel);
        }
    }

    /* renamed from: b */
    public static int m8154b(Parcel parcel) {
        int a = C2834b.m8148a(parcel);
        int a2 = C2834b.m8149a(parcel, a);
        int dataPosition = parcel.dataPosition();
        if (C2834b.m8147a(a) != 20293) {
            String str = "Expected object header. Got 0x";
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new C2833a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), parcel);
        }
        a2 += dataPosition;
        if (a2 >= dataPosition && a2 <= parcel.dataSize()) {
            return a2;
        }
        StringBuilder stringBuilder = new StringBuilder(54);
        stringBuilder.append("Size read is invalid start=");
        stringBuilder.append(dataPosition);
        stringBuilder.append(" end=");
        stringBuilder.append(a2);
        throw new C2833a(stringBuilder.toString(), parcel);
    }

    /* renamed from: c */
    public static boolean m8158c(Parcel parcel, int i) {
        C2834b.m8151a(parcel, i, 4);
        return parcel.readInt() != null ? true : null;
    }

    /* renamed from: d */
    public static Boolean m8159d(Parcel parcel, int i) {
        int a = C2834b.m8149a(parcel, i);
        if (a == 0) {
            return null;
        }
        C2834b.m8152a(parcel, i, a, 4);
        return Boolean.valueOf(parcel.readInt() != null ? true : null);
    }

    /* renamed from: e */
    public static byte m8160e(Parcel parcel, int i) {
        C2834b.m8151a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    /* renamed from: f */
    public static short m8161f(Parcel parcel, int i) {
        C2834b.m8151a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    /* renamed from: g */
    public static int m8162g(Parcel parcel, int i) {
        C2834b.m8151a(parcel, i, 4);
        return parcel.readInt();
    }

    /* renamed from: h */
    public static long m8163h(Parcel parcel, int i) {
        C2834b.m8151a(parcel, i, 8);
        return parcel.readLong();
    }

    /* renamed from: i */
    public static Long m8164i(Parcel parcel, int i) {
        int a = C2834b.m8149a(parcel, i);
        if (a == 0) {
            return null;
        }
        C2834b.m8152a(parcel, i, a, 8);
        return Long.valueOf(parcel.readLong());
    }

    /* renamed from: j */
    public static float m8165j(Parcel parcel, int i) {
        C2834b.m8151a(parcel, i, 4);
        return parcel.readFloat();
    }

    /* renamed from: k */
    public static Float m8166k(Parcel parcel, int i) {
        int a = C2834b.m8149a(parcel, i);
        if (a == 0) {
            return null;
        }
        C2834b.m8152a(parcel, i, a, 4);
        return Float.valueOf(parcel.readFloat());
    }

    /* renamed from: l */
    public static double m8167l(Parcel parcel, int i) {
        C2834b.m8151a(parcel, i, 8);
        return parcel.readDouble();
    }

    /* renamed from: m */
    public static Double m8168m(Parcel parcel, int i) {
        int a = C2834b.m8149a(parcel, i);
        if (a == 0) {
            return null;
        }
        C2834b.m8152a(parcel, i, a, 8);
        return Double.valueOf(parcel.readDouble());
    }

    /* renamed from: n */
    public static String m8169n(Parcel parcel, int i) {
        i = C2834b.m8149a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + i);
        return readString;
    }

    /* renamed from: o */
    public static IBinder m8170o(Parcel parcel, int i) {
        i = C2834b.m8149a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + i);
        return readStrongBinder;
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m8150a(Parcel parcel, int i, Creator<T> creator) {
        i = C2834b.m8149a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + i);
        return parcelable;
    }

    /* renamed from: p */
    public static Bundle m8171p(Parcel parcel, int i) {
        i = C2834b.m8149a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + i);
        return readBundle;
    }

    /* renamed from: q */
    public static byte[] m8172q(Parcel parcel, int i) {
        i = C2834b.m8149a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + i);
        return createByteArray;
    }

    /* renamed from: r */
    public static int[] m8173r(Parcel parcel, int i) {
        i = C2834b.m8149a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + i);
        return createIntArray;
    }

    /* renamed from: s */
    public static float[] m8174s(Parcel parcel, int i) {
        i = C2834b.m8149a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + i);
        return createFloatArray;
    }

    /* renamed from: t */
    public static String[] m8175t(Parcel parcel, int i) {
        i = C2834b.m8149a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + i);
        return createStringArray;
    }

    /* renamed from: u */
    public static ArrayList<Integer> m8176u(Parcel parcel, int i) {
        i = C2834b.m8149a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + i);
        return arrayList;
    }

    /* renamed from: v */
    public static ArrayList<String> m8177v(Parcel parcel, int i) {
        i = C2834b.m8149a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + i);
        return createStringArrayList;
    }

    /* renamed from: b */
    public static <T> T[] m8156b(Parcel parcel, int i, Creator<T> creator) {
        i = C2834b.m8149a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        creator = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + i);
        return creator;
    }

    /* renamed from: c */
    public static <T> ArrayList<T> m8157c(Parcel parcel, int i, Creator<T> creator) {
        i = C2834b.m8149a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i == 0) {
            return null;
        }
        creator = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + i);
        return creator;
    }

    /* renamed from: a */
    public static void m8153a(Parcel parcel, int i, List list, ClassLoader classLoader) {
        i = C2834b.m8149a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (i != 0) {
            parcel.readList(list, classLoader);
            parcel.setDataPosition(dataPosition + i);
        }
    }

    /* renamed from: w */
    public static void m8178w(Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            StringBuilder stringBuilder = new StringBuilder(37);
            stringBuilder.append("Overread allowed size end=");
            stringBuilder.append(i);
            throw new C2833a(stringBuilder.toString(), parcel);
        }
    }
}
