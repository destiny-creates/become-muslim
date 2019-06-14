package com.google.android.gms.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.p186f.C2955h;

abstract class aj<T> {
    /* renamed from: a */
    final int f7819a;
    /* renamed from: b */
    final C2955h<T> f7820b = new C2955h();
    /* renamed from: c */
    final int f7821c;
    /* renamed from: d */
    final Bundle f7822d;

    aj(int i, int i2, Bundle bundle) {
        this.f7819a = i;
        this.f7821c = i2;
        this.f7822d = bundle;
    }

    /* renamed from: a */
    abstract void mo2602a(Bundle bundle);

    /* renamed from: a */
    abstract boolean mo2603a();

    /* renamed from: a */
    final void m8954a(C3061c c3061c) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(c3061c);
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 14) + String.valueOf(valueOf2).length());
            stringBuilder.append("Failing ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" with ");
            stringBuilder.append(valueOf2);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        this.f7820b.m8784a((Exception) c3061c);
    }

    public String toString() {
        int i = this.f7821c;
        int i2 = this.f7819a;
        mo2603a();
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("Request { what=");
        stringBuilder.append(i);
        stringBuilder.append(" id=");
        stringBuilder.append(i2);
        stringBuilder.append(" oneWay=false}");
        return stringBuilder.toString();
    }
}
