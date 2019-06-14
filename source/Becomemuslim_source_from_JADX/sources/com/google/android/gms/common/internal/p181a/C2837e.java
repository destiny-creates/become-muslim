package com.google.android.gms.common.internal.p181a;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.common.internal.a.e */
public final class C2837e {
    /* renamed from: a */
    public static <T extends C2836d> byte[] m8212a(T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        t = obtain.marshall();
        obtain.recycle();
        return t;
    }

    /* renamed from: a */
    public static <T extends C2836d> T m8210a(byte[] bArr, Creator<T> creator) {
        C2872v.m8380a((Object) creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        C2836d c2836d = (C2836d) creator.createFromParcel(obtain);
        obtain.recycle();
        return c2836d;
    }

    /* renamed from: a */
    public static <T extends C2836d> void m8211a(T t, Intent intent, String str) {
        intent.putExtra(str, C2837e.m8212a(t));
    }

    /* renamed from: a */
    public static <T extends C2836d> T m8209a(Intent intent, String str, Creator<T> creator) {
        intent = intent.getByteArrayExtra(str);
        if (intent == null) {
            return null;
        }
        return C2837e.m8210a(intent, creator);
    }

    /* renamed from: b */
    public static <T extends C2836d> ArrayList<T> m8213b(Intent intent, String str, Creator<T> creator) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        str = new ArrayList(arrayList.size());
        arrayList = arrayList;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            str.add(C2837e.m8210a((byte[]) obj, creator));
        }
        return str;
    }
}
