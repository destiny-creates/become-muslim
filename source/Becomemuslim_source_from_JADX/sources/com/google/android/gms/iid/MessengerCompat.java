package com.google.android.gms.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class MessengerCompat implements ReflectedParcelable {
    public static final Creator<MessengerCompat> CREATOR = new aa();
    /* renamed from: a */
    private Messenger f11795a;
    /* renamed from: b */
    private C3076v f11796b;

    public MessengerCompat(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.f11795a = new Messenger(iBinder);
            return;
        }
        if (iBinder == null) {
            iBinder = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
            if (queryLocalInterface instanceof C3076v) {
                iBinder = (C3076v) queryLocalInterface;
            } else {
                iBinder = new C4433w(iBinder);
            }
        }
        this.f11796b = iBinder;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: a */
    public final void m14712a(Message message) {
        if (this.f11795a != null) {
            this.f11795a.send(message);
        } else {
            this.f11796b.mo2606a(message);
        }
    }

    /* renamed from: a */
    private final IBinder m14711a() {
        return this.f11795a != null ? this.f11795a.getBinder() : this.f11796b.asBinder();
    }

    public boolean equals(java.lang.Object r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r2.m14711a();	 Catch:{ ClassCastException -> 0x0013 }
        r3 = (com.google.android.gms.iid.MessengerCompat) r3;	 Catch:{ ClassCastException -> 0x0013 }
        r3 = r3.m14711a();	 Catch:{ ClassCastException -> 0x0013 }
        r3 = r1.equals(r3);	 Catch:{ ClassCastException -> 0x0013 }
        return r3;
    L_0x0013:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.MessengerCompat.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return m14711a().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f11795a != 0) {
            parcel.writeStrongBinder(this.f11795a.getBinder());
        } else {
            parcel.writeStrongBinder(this.f11796b.asBinder());
        }
    }
}
