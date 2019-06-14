package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.p186f.C2955h;

/* renamed from: com.google.firebase.iid.n */
abstract class C5364n<T> {
    /* renamed from: a */
    final int f18112a;
    /* renamed from: b */
    final C2955h<T> f18113b = new C2955h();
    /* renamed from: c */
    final int f18114c;
    /* renamed from: d */
    final Bundle f18115d;

    C5364n(int i, int i2, Bundle bundle) {
        this.f18112a = i;
        this.f18114c = i2;
        this.f18115d = bundle;
    }

    /* renamed from: a */
    abstract void mo4894a(Bundle bundle);

    /* renamed from: a */
    abstract boolean mo4895a();

    /* renamed from: a */
    final void m22775a(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 16) + String.valueOf(valueOf2).length());
            stringBuilder.append("Finishing ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" with ");
            stringBuilder.append(valueOf2);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        this.f18113b.a(t);
    }

    /* renamed from: a */
    final void m22774a(C5365o c5365o) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(c5365o);
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 14) + String.valueOf(valueOf2).length());
            stringBuilder.append("Failing ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" with ");
            stringBuilder.append(valueOf2);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        this.f18113b.a(c5365o);
    }

    public String toString() {
        int i = this.f18114c;
        int i2 = this.f18112a;
        boolean a = mo4895a();
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("Request { what=");
        stringBuilder.append(i);
        stringBuilder.append(" id=");
        stringBuilder.append(i2);
        stringBuilder.append(" oneWay=");
        stringBuilder.append(a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
