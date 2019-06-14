package com.google.android.gms.p174b;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.p206e.C4958a;
import com.google.android.gms.internal.p206e.C4959b;

/* renamed from: com.google.android.gms.b.b */
public interface C2758b extends IInterface {

    /* renamed from: com.google.android.gms.b.b$a */
    public static abstract class C4325a extends C4959b implements C2758b {

        /* renamed from: com.google.android.gms.b.b$a$a */
        public static class C4324a extends C4958a implements C2758b {
            C4324a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public C4325a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        /* renamed from: a */
        public static C2758b m14024a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof C2758b) {
                return (C2758b) queryLocalInterface;
            }
            return new C4324a(iBinder);
        }
    }
}
