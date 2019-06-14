package com.polidea.p254a.p256b;

import android.bluetooth.BluetoothGatt;
import android.os.DeadObjectException;
import com.polidea.p254a.p255a.C5548g;
import com.polidea.p254a.p255a.C5549m;
import com.polidea.p254a.p255a.C6973f;
import com.polidea.p254a.p255a.C7929h;
import com.polidea.p254a.p255a.C7930i;
import com.polidea.p254a.p256b.p258b.av;
import com.polidea.p254a.p256b.p259c.C5583t;
import com.polidea.p254a.p256b.p261e.C5598i;
import com.polidea.p254a.p256b.p262f.C7082v;
import p289e.C5974e;
import p289e.C5982f;
import p289e.C5986h;
import p289e.C7332c;

/* compiled from: SingleResponseOperation */
/* renamed from: com.polidea.a.b.q */
public abstract class C7998q<T> extends C7084k<T> {
    /* renamed from: a */
    private final BluetoothGatt f29748a;
    /* renamed from: b */
    private final av f29749b;
    /* renamed from: c */
    private final C5549m f29750c;
    /* renamed from: d */
    private final C5583t f29751d;

    /* renamed from: a */
    protected abstract C5974e<T> mo6755a(av avVar);

    /* renamed from: a */
    protected abstract boolean mo6756a(BluetoothGatt bluetoothGatt);

    public C7998q(BluetoothGatt bluetoothGatt, av avVar, C5549m c5549m, C5583t c5583t) {
        this.f29748a = bluetoothGatt;
        this.f29749b = avVar;
        this.f29750c = c5549m;
        this.f29751d = c5583t;
    }

    /* renamed from: a */
    protected final void mo6272a(C7332c<T> c7332c, C5598i c5598i) {
        C5982f c7082v = new C7082v(c7332c, c5598i);
        c7332c = mo6755a(this.f29749b).m25042k().m24990a(this.f29751d.f18694a, this.f29751d.f18695b, mo6760a(this.f29748a, this.f29749b, this.f29751d.f18696c), this.f29751d.f18696c).m25006a(c7082v);
        if (mo6756a(this.f29748a) == null) {
            c7332c.U_();
            c7082v.mo5001a(new C7930i(this.f29748a, this.f29750c));
        }
    }

    /* renamed from: a */
    protected C5974e<T> mo6760a(BluetoothGatt bluetoothGatt, av avVar, C5986h c5986h) {
        return C5974e.m24984b(new C7929h(this.f29748a, this.f29750c));
    }

    /* renamed from: a */
    protected C5548g mo6271a(DeadObjectException deadObjectException) {
        return new C6973f(deadObjectException, this.f29748a.getDevice().getAddress(), -1);
    }
}
