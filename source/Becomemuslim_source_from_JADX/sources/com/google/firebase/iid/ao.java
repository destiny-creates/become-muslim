package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

public class ao implements Parcelable {
    public static final Creator<ao> CREATOR = new ap();
    /* renamed from: a */
    private Messenger f18082a;
    /* renamed from: b */
    private ay f18083b;

    /* renamed from: com.google.firebase.iid.ao$a */
    public static final class C5352a extends ClassLoader {
        protected final Class<?> loadClass(String str, boolean z) {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z);
            }
            if (FirebaseInstanceId.m22672h() != null) {
                Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
            }
            return ao.class;
        }
    }

    public ao(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.f18082a = new Messenger(iBinder);
        } else {
            this.f18083b = new az(iBinder);
        }
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: a */
    public final void m22726a(Message message) {
        if (this.f18082a != null) {
            this.f18082a.send(message);
        } else {
            this.f18083b.mo4892a(message);
        }
    }

    /* renamed from: a */
    private final IBinder m22725a() {
        return this.f18082a != null ? this.f18082a.getBinder() : this.f18083b.asBinder();
    }

    public boolean equals(java.lang.Object r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r2.m22725a();	 Catch:{ ClassCastException -> 0x0013 }
        r3 = (com.google.firebase.iid.ao) r3;	 Catch:{ ClassCastException -> 0x0013 }
        r3 = r3.m22725a();	 Catch:{ ClassCastException -> 0x0013 }
        r3 = r1.equals(r3);	 Catch:{ ClassCastException -> 0x0013 }
        return r3;
    L_0x0013:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.ao.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return m22725a().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f18082a != 0) {
            parcel.writeStrongBinder(this.f18082a.getBinder());
        } else {
            parcel.writeStrongBinder(this.f18083b.asBinder());
        }
    }
}
