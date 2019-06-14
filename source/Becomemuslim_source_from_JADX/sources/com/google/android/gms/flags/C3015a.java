package com.google.android.gms.flags;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;

/* renamed from: com.google.android.gms.flags.a */
public interface C3015a extends IInterface {

    /* renamed from: com.google.android.gms.flags.a$a */
    public static abstract class C4416a extends zzb implements C3015a {

        /* renamed from: com.google.android.gms.flags.a$a$a */
        public static class C4415a extends zza implements C3015a {
            C4415a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.flags.IFlagProvider");
            }
        }

        public C4416a() {
            super("com.google.android.gms.flags.IFlagProvider");
        }

        public static C3015a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
            return queryLocalInterface instanceof C3015a ? (C3015a) queryLocalInterface : new C4415a(iBinder);
        }
    }
}
