package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.p206e.C4958a;
import com.google.android.gms.internal.p206e.C4960c;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;

/* renamed from: com.google.android.gms.dynamite.j */
public final class C4387j extends C4958a implements C2925i {
    C4387j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    /* renamed from: a */
    public final C2758b mo2490a(C2758b c2758b, String str, int i) {
        Parcel c = c();
        C4960c.a(c, c2758b);
        c.writeString(str);
        c.writeInt(i);
        c2758b = a(2, c);
        str = C4325a.m14024a(c2758b.readStrongBinder());
        c2758b.recycle();
        return str;
    }

    /* renamed from: a */
    public final int mo2489a(C2758b c2758b, String str, boolean z) {
        Parcel c = c();
        C4960c.a(c, c2758b);
        c.writeString(str);
        C4960c.a(c, z);
        c2758b = a(3, c);
        str = c2758b.readInt();
        c2758b.recycle();
        return str;
    }

    /* renamed from: b */
    public final C2758b mo2492b(C2758b c2758b, String str, int i) {
        Parcel c = c();
        C4960c.a(c, c2758b);
        c.writeString(str);
        c.writeInt(i);
        c2758b = a(4, c);
        str = C4325a.m14024a(c2758b.readStrongBinder());
        c2758b.recycle();
        return str;
    }

    /* renamed from: b */
    public final int mo2491b(C2758b c2758b, String str, boolean z) {
        Parcel c = c();
        C4960c.a(c, c2758b);
        c.writeString(str);
        C4960c.a(c, z);
        c2758b = a(5, c);
        str = c2758b.readInt();
        c2758b.recycle();
        return str;
    }

    /* renamed from: a */
    public final int mo2488a() {
        Parcel a = a(6, c());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
