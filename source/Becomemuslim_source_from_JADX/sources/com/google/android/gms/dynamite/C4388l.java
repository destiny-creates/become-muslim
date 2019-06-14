package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.p206e.C4958a;
import com.google.android.gms.internal.p206e.C4960c;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C2758b.C4325a;

/* renamed from: com.google.android.gms.dynamite.l */
public final class C4388l extends C4958a implements C2926k {
    C4388l(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    /* renamed from: a */
    public final C2758b mo2493a(C2758b c2758b, String str, int i, C2758b c2758b2) {
        Parcel c = c();
        C4960c.a(c, c2758b);
        c.writeString(str);
        c.writeInt(i);
        C4960c.a(c, c2758b2);
        c2758b = a(2, c);
        str = C4325a.m14024a(c2758b.readStrongBinder());
        c2758b.recycle();
        return str;
    }

    /* renamed from: b */
    public final C2758b mo2494b(C2758b c2758b, String str, int i, C2758b c2758b2) {
        Parcel c = c();
        C4960c.a(c, c2758b);
        c.writeString(str);
        c.writeInt(i);
        C4960c.a(c, c2758b2);
        c2758b = a(3, c);
        str = C4325a.m14024a(c2758b.readStrongBinder());
        c2758b.recycle();
        return str;
    }
}
