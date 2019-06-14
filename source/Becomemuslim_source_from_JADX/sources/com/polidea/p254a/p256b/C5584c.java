package com.polidea.p254a.p256b;

import android.bluetooth.BluetoothDevice;
import com.p071c.p072a.C4535a;
import com.polidea.p254a.af.C5554a;
import com.polidea.p254a.p256b.p258b.C5570m;
import com.polidea.p254a.p256b.p259c.C5583t;
import com.polidea.p254a.p256b.p262f.C5610w;
import java.util.concurrent.TimeUnit;
import p289e.C5986h;

/* compiled from: DeviceModule */
/* renamed from: com.polidea.a.b.c */
public class C5584c {
    /* renamed from: a */
    final String f18697a;

    C5584c(String str) {
        this.f18697a = str;
    }

    /* renamed from: a */
    BluetoothDevice m23769a(C5610w c5610w) {
        return c5610w.m23836a(this.f18697a);
    }

    /* renamed from: a */
    String m23770a() {
        return this.f18697a;
    }

    /* renamed from: a */
    static C5583t m23766a(C5986h c5986h) {
        return new C5583t(35, TimeUnit.SECONDS, c5986h);
    }

    /* renamed from: b */
    static C5583t m23768b(C5986h c5986h) {
        return new C5583t(10, TimeUnit.SECONDS, c5986h);
    }

    /* renamed from: b */
    static C4535a<C5554a> m23767b() {
        return C4535a.a(C5554a.DISCONNECTED);
    }

    /* renamed from: a */
    static C5570m m23765a(final C4535a<C5554a> c4535a) {
        return new C5570m() {
            /* renamed from: a */
            public void mo4998a(C5554a c5554a) {
                c4535a.b(c5554a);
            }
        };
    }
}
