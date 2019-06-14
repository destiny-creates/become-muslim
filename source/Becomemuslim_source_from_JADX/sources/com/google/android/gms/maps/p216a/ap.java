package com.google.android.gms.maps.p216a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p212k.C5022a;
import com.google.android.gms.internal.p212k.C5023d;
import com.google.android.gms.internal.p212k.C5026k;
import com.google.android.gms.internal.p212k.C5029p;
import com.google.android.gms.internal.p212k.C5030s;
import com.google.android.gms.internal.p212k.C5031v;
import com.google.android.gms.internal.p212k.C6808b;
import com.google.android.gms.internal.p212k.C6810e;
import com.google.android.gms.internal.p212k.C6816q;
import com.google.android.gms.internal.p212k.C6818t;
import com.google.android.gms.internal.p212k.C6820w;
import com.google.android.gms.internal.p212k.ab;
import com.google.android.gms.internal.p212k.ac;
import com.google.android.gms.internal.p212k.ae;
import com.google.android.gms.internal.p212k.af;
import com.google.android.gms.internal.p212k.ah;
import com.google.android.gms.maps.model.C7848f;
import com.google.android.gms.maps.model.C7849h;
import com.google.android.gms.maps.model.C7850k;
import com.google.android.gms.maps.model.C7851m;
import com.google.android.gms.maps.model.C7854q;
import com.google.android.gms.maps.model.C7855s;
import com.google.android.gms.maps.model.C7857y;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.p174b.C2758b;

/* renamed from: com.google.android.gms.maps.a.ap */
public final class ap extends C5022a implements C5092b {
    ap(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IGoogleMapDelegate");
    }

    /* renamed from: a */
    public final ab mo4796a(C7851m c7851m) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) c7851m);
        Parcel a = m21121a(11, D_);
        ab a2 = ac.m31840a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final ae mo4797a(C7854q c7854q) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) c7854q);
        Parcel a = m21121a(10, D_);
        ae a2 = af.m31861a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final ah mo4798a(C7855s c7855s) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) c7855s);
        Parcel a = m21121a(9, D_);
        ah a2 = C6808b.m31875a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final C5023d mo4799a(C7857y c7857y) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) c7857y);
        Parcel a = m21121a(13, D_);
        C5023d a2 = C6810e.m31889a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final C5029p mo4800a(C7848f c7848f) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) c7848f);
        Parcel a = m21121a(35, D_);
        C5029p a2 = C6816q.m31901a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final C5030s mo4801a(C7849h c7849h) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) c7849h);
        Parcel a = m21121a(12, D_);
        C5030s a2 = C6818t.m31910a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final CameraPosition mo4802a() {
        Parcel a = m21121a(1, D_());
        CameraPosition cameraPosition = (CameraPosition) C5026k.m21175a(a, CameraPosition.CREATOR);
        a.recycle();
        return cameraPosition;
    }

    /* renamed from: a */
    public final void mo4803a(float f) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        m21122b(92, D_);
    }

    /* renamed from: a */
    public final void mo4804a(int i) {
        Parcel D_ = D_();
        D_.writeInt(i);
        m21122b(16, D_);
    }

    /* renamed from: a */
    public final void mo4805a(int i, int i2, int i3, int i4) {
        Parcel D_ = D_();
        D_.writeInt(i);
        D_.writeInt(i2);
        D_.writeInt(i3);
        D_.writeInt(i4);
        m21122b(39, D_);
    }

    /* renamed from: a */
    public final void mo4806a(C2758b c2758b) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c2758b);
        m21122b(4, D_);
    }

    /* renamed from: a */
    public final void mo4807a(C2758b c2758b, int i, al alVar) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c2758b);
        D_.writeInt(i);
        C5026k.m21176a(D_, (IInterface) alVar);
        m21122b(7, D_);
    }

    /* renamed from: a */
    public final void mo4808a(ab abVar) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) abVar);
        m21122b(85, D_);
    }

    /* renamed from: a */
    public final void mo4809a(ad adVar) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) adVar);
        m21122b(87, D_);
    }

    /* renamed from: a */
    public final void mo4810a(ag agVar, C2758b c2758b) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) agVar);
        C5026k.m21176a(D_, (IInterface) c2758b);
        m21122b(38, D_);
    }

    /* renamed from: a */
    public final void mo4811a(aq aqVar) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) aqVar);
        m21122b(33, D_);
    }

    /* renamed from: a */
    public final void mo4812a(at atVar) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) atVar);
        m21122b(99, D_);
    }

    /* renamed from: a */
    public final void mo4813a(av avVar) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) avVar);
        m21122b(97, D_);
    }

    /* renamed from: a */
    public final void mo4814a(ax axVar) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) axVar);
        m21122b(96, D_);
    }

    /* renamed from: a */
    public final void mo4815a(az azVar) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) azVar);
        m21122b(45, D_);
    }

    /* renamed from: a */
    public final void mo4816a(C5097i c5097i) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c5097i);
        m21122b(32, D_);
    }

    /* renamed from: a */
    public final void mo4817a(C5098k c5098k) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c5098k);
        m21122b(28, D_);
    }

    /* renamed from: a */
    public final void mo4818a(C5099m c5099m) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c5099m);
        m21122b(42, D_);
    }

    /* renamed from: a */
    public final void mo4819a(C5100o c5100o) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c5100o);
        m21122b(29, D_);
    }

    /* renamed from: a */
    public final void mo4820a(C5102s c5102s) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c5102s);
        m21122b(30, D_);
    }

    /* renamed from: a */
    public final void mo4821a(C5103u c5103u) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c5103u);
        m21122b(31, D_);
    }

    /* renamed from: a */
    public final void mo4822a(C5104w c5104w) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c5104w);
        m21122b(36, D_);
    }

    /* renamed from: a */
    public final void mo4823a(C5105z c5105z) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c5105z);
        m21122b(80, D_);
    }

    /* renamed from: a */
    public final void mo4824a(LatLngBounds latLngBounds) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) latLngBounds);
        m21122b(95, D_);
    }

    /* renamed from: a */
    public final void mo4825a(boolean z) {
        Parcel D_ = D_();
        C5026k.m21178a(D_, z);
        m21122b(18, D_);
    }

    /* renamed from: a */
    public final boolean mo4826a(C7850k c7850k) {
        Parcel D_ = D_();
        C5026k.m21177a(D_, (Parcelable) c7850k);
        Parcel a = m21121a(91, D_);
        boolean a2 = C5026k.m21179a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final C5095e mo4827b() {
        C5095e c5095e;
        Parcel a = m21121a(25, D_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            c5095e = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            c5095e = queryLocalInterface instanceof C5095e ? (C5095e) queryLocalInterface : new ai(readStrongBinder);
        }
        a.recycle();
        return c5095e;
    }

    /* renamed from: b */
    public final void mo4828b(float f) {
        Parcel D_ = D_();
        D_.writeFloat(f);
        m21122b(93, D_);
    }

    /* renamed from: b */
    public final void mo4829b(C2758b c2758b) {
        Parcel D_ = D_();
        C5026k.m21176a(D_, (IInterface) c2758b);
        m21122b(5, D_);
    }

    /* renamed from: b */
    public final boolean mo4830b(boolean z) {
        Parcel D_ = D_();
        C5026k.m21178a(D_, z);
        Parcel a = m21121a(20, D_);
        boolean a2 = C5026k.m21179a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: c */
    public final C5094d mo4831c() {
        C5094d c5094d;
        Parcel a = m21121a(26, D_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            c5094d = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            c5094d = queryLocalInterface instanceof C5094d ? (C5094d) queryLocalInterface : new af(readStrongBinder);
        }
        a.recycle();
        return c5094d;
    }

    /* renamed from: c */
    public final void mo4832c(boolean z) {
        Parcel D_ = D_();
        C5026k.m21178a(D_, z);
        m21122b(22, D_);
    }

    /* renamed from: d */
    public final C5031v mo4833d() {
        Parcel a = m21121a(44, D_());
        C5031v a2 = C6820w.m31918a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: d */
    public final void mo4834d(boolean z) {
        Parcel D_ = D_();
        C5026k.m21178a(D_, z);
        m21122b(41, D_);
    }
}
