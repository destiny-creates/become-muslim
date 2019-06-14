package com.google.android.gms.internal.p213l;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import com.facebook.ads.AdError;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.common.util.C2895e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.ed */
public final class ed extends C8220s {
    /* renamed from: a */
    private final er f32820a;
    /* renamed from: b */
    private at f32821b;
    /* renamed from: c */
    private volatile Boolean f32822c;
    /* renamed from: d */
    private final ai f32823d;
    /* renamed from: e */
    private final fh f32824e;
    /* renamed from: f */
    private final List<Runnable> f32825f = new ArrayList();
    /* renamed from: g */
    private final ai f32826g;

    protected ed(cg cgVar) {
        super(cgVar);
        this.f32824e = new fh(cgVar.mo4751m());
        this.f32820a = new er(this);
        this.f32823d = new ee(this, cgVar);
        this.f32826g = new ej(this, cgVar);
    }

    /* renamed from: I */
    private final boolean m44170I() {
        mo4755u();
        return true;
    }

    /* renamed from: J */
    private final void m44171J() {
        mo6210d();
        this.f32824e.m21367a();
        this.f32823d.m21242a(((Long) as.f16921O.m21260b()).longValue());
    }

    /* renamed from: K */
    private final void m44172K() {
        mo6210d();
        if (m44184B()) {
            mo4754r().m42579w().m21307a("Inactivity, disconnecting from the service");
            m44190H();
        }
    }

    /* renamed from: L */
    private final void m44173L() {
        mo6210d();
        mo4754r().m42579w().m21308a("Processing queued up service tasks", Integer.valueOf(this.f32825f.size()));
        for (Runnable run : this.f32825f) {
            try {
                run.run();
            } catch (Exception e) {
                mo4754r().I_().m21308a("Task exception while flushing queue", e);
            }
        }
        this.f32825f.clear();
        this.f32826g.m21244c();
    }

    /* renamed from: a */
    private final C7826u m44176a(boolean z) {
        mo4755u();
        return mo6743g().m43962a(z ? mo4754r().m42580x() : null);
    }

    /* renamed from: a */
    private final void m44177a(ComponentName componentName) {
        mo6210d();
        if (this.f32821b != null) {
            this.f32821b = null;
            mo4754r().m42579w().m21308a("Disconnected from device MeasurementService", componentName);
            mo6210d();
            m44188F();
        }
    }

    /* renamed from: a */
    private final void m44179a(Runnable runnable) {
        mo6210d();
        if (m44184B()) {
            runnable.run();
        } else if (((long) this.f32825f.size()) >= 1000) {
            mo4754r().I_().m21307a("Discarding data. Max runnable queue size reached");
        } else {
            this.f32825f.add(runnable);
            this.f32826g.m21242a(60000);
            m44188F();
        }
    }

    /* renamed from: B */
    public final boolean m44184B() {
        mo6210d();
        m42728w();
        return this.f32821b != null;
    }

    /* renamed from: C */
    protected final void m44185C() {
        mo6210d();
        m42728w();
        m44179a(new ek(this, m44176a(true)));
    }

    /* renamed from: D */
    protected final void m44186D() {
        mo6210d();
        mo6208b();
        m42728w();
        C7826u a = m44176a(false);
        if (m44170I()) {
            mo6746j().m43987B();
        }
        m44179a(new ef(this, a));
    }

    /* renamed from: E */
    protected final void m44187E() {
        mo6210d();
        m42728w();
        m44179a(new eh(this, m44176a(true)));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: F */
    final void m44188F() {
        /*
        r6 = this;
        r6.mo6210d();
        r6.m42728w();
        r0 = r6.m44184B();
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r6.f32822c;
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x0115;
    L_0x0013:
        r6.mo6210d();
        r6.m42728w();
        r0 = r6.mo6214s();
        r0 = r0.m42595i();
        if (r0 == 0) goto L_0x002c;
    L_0x0023:
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x002c;
    L_0x0029:
        r0 = 1;
        goto L_0x010f;
    L_0x002c:
        r6.mo4755u();
        r0 = r6.mo6743g();
        r0 = r0.m43961F();
        if (r0 != r2) goto L_0x003d;
    L_0x0039:
        r0 = 1;
    L_0x003a:
        r3 = 1;
        goto L_0x00ec;
    L_0x003d:
        r0 = r6.mo4754r();
        r0 = r0.m42579w();
        r3 = "Checking service availability";
        r0.m21307a(r3);
        r0 = r6.mo6213p();
        r3 = com.google.android.gms.common.C2830f.b();
        r0 = r0.mo4752n();
        r4 = 12451000; // 0xbdfcb8 float:1.7447567E-38 double:6.1516114E-317;
        r0 = r3.b(r0, r4);
        r3 = 9;
        if (r0 == r3) goto L_0x00e1;
    L_0x0061:
        r3 = 18;
        if (r0 == r3) goto L_0x00d6;
    L_0x0065:
        switch(r0) {
            case 0: goto L_0x00c7;
            case 1: goto L_0x00b7;
            case 2: goto L_0x008b;
            case 3: goto L_0x007d;
            default: goto L_0x0068;
        };
    L_0x0068:
        r3 = r6.mo4754r();
        r3 = r3.m42565i();
        r4 = "Unexpected service status";
        r0 = java.lang.Integer.valueOf(r0);
        r3.m21308a(r4, r0);
    L_0x0079:
        r0 = 0;
    L_0x007a:
        r3 = 0;
        goto L_0x00ec;
    L_0x007d:
        r0 = r6.mo4754r();
        r0 = r0.m42565i();
        r3 = "Service disabled";
    L_0x0087:
        r0.m21307a(r3);
        goto L_0x0079;
    L_0x008b:
        r0 = r6.mo4754r();
        r0 = r0.m42578v();
        r3 = "Service container out of date";
        r0.m21307a(r3);
        r0 = r6.mo6213p();
        r0 = r0.m42683j();
        r3 = 12600; // 0x3138 float:1.7656E-41 double:6.225E-320;
        if (r0 >= r3) goto L_0x00a5;
    L_0x00a4:
        goto L_0x00c4;
    L_0x00a5:
        r0 = r6.mo6214s();
        r0 = r0.m42595i();
        if (r0 == 0) goto L_0x00b5;
    L_0x00af:
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0079;
    L_0x00b5:
        r0 = 1;
        goto L_0x007a;
    L_0x00b7:
        r0 = r6.mo4754r();
        r0 = r0.m42579w();
        r3 = "Service missing";
        r0.m21307a(r3);
    L_0x00c4:
        r0 = 0;
        goto L_0x003a;
    L_0x00c7:
        r0 = r6.mo4754r();
        r0 = r0.m42579w();
        r3 = "Service available";
    L_0x00d1:
        r0.m21307a(r3);
        goto L_0x0039;
    L_0x00d6:
        r0 = r6.mo4754r();
        r0 = r0.m42565i();
        r3 = "Service updating";
        goto L_0x00d1;
    L_0x00e1:
        r0 = r6.mo4754r();
        r0 = r0.m42565i();
        r3 = "Service invalid";
        goto L_0x0087;
    L_0x00ec:
        if (r0 != 0) goto L_0x0106;
    L_0x00ee:
        r4 = r6.mo6215t();
        r4 = r4.m38071x();
        if (r4 == 0) goto L_0x0106;
    L_0x00f8:
        r3 = r6.mo4754r();
        r3 = r3.I_();
        r4 = "No way to upload. Consider using the full version of Analytics";
        r3.m21307a(r4);
        r3 = 0;
    L_0x0106:
        if (r3 == 0) goto L_0x010f;
    L_0x0108:
        r3 = r6.mo6214s();
        r3.m42584a(r0);
    L_0x010f:
        r0 = java.lang.Boolean.valueOf(r0);
        r6.f32822c = r0;
    L_0x0115:
        r0 = r6.f32822c;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0123;
    L_0x011d:
        r0 = r6.f32820a;
        r0.m32006a();
        return;
    L_0x0123:
        r0 = r6.mo6215t();
        r0 = r0.m38071x();
        if (r0 != 0) goto L_0x0183;
    L_0x012d:
        r6.mo4755u();
        r0 = r6.mo4752n();
        r0 = r0.getPackageManager();
        r3 = new android.content.Intent;
        r3.<init>();
        r4 = r6.mo4752n();
        r5 = "com.google.android.gms.measurement.AppMeasurementService";
        r3 = r3.setClassName(r4, r5);
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r0 = r0.queryIntentServices(r3, r4);
        if (r0 == 0) goto L_0x0156;
    L_0x014f:
        r0 = r0.size();
        if (r0 <= 0) goto L_0x0156;
    L_0x0155:
        r1 = 1;
    L_0x0156:
        if (r1 == 0) goto L_0x0176;
    L_0x0158:
        r0 = new android.content.Intent;
        r1 = "com.google.android.gms.measurement.START";
        r0.<init>(r1);
        r1 = new android.content.ComponentName;
        r2 = r6.mo4752n();
        r6.mo4755u();
        r3 = "com.google.android.gms.measurement.AppMeasurementService";
        r1.<init>(r2, r3);
        r0.setComponent(r1);
        r1 = r6.f32820a;
        r1.m32008a(r0);
        return;
    L_0x0176:
        r0 = r6.mo4754r();
        r0 = r0.I_();
        r1 = "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest";
        r0.m21307a(r1);
    L_0x0183:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.ed.F():void");
    }

    /* renamed from: G */
    final Boolean m44189G() {
        return this.f32822c;
    }

    /* renamed from: H */
    public final void m44190H() {
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
        r3 = this;
        r3.mo6210d();
        r3.m42728w();
        r0 = com.google.android.gms.common.stats.C2882a.a();	 Catch:{ IllegalStateException -> 0x0013, IllegalStateException -> 0x0013 }
        r1 = r3.mo4752n();	 Catch:{ IllegalStateException -> 0x0013, IllegalStateException -> 0x0013 }
        r2 = r3.f32820a;	 Catch:{ IllegalStateException -> 0x0013, IllegalStateException -> 0x0013 }
        r0.a(r1, r2);	 Catch:{ IllegalStateException -> 0x0013, IllegalStateException -> 0x0013 }
    L_0x0013:
        r0 = 0;
        r3.f32821b = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.ed.H():void");
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: a */
    protected final void m44192a(aq aqVar, String str) {
        C2872v.a(aqVar);
        mo6210d();
        m42728w();
        boolean I = m44170I();
        boolean z = I && mo6746j().m43990a(aqVar);
        m44179a(new el(this, I, z, aqVar, m44176a(true), str));
    }

    /* renamed from: a */
    protected final void m44193a(at atVar) {
        mo6210d();
        C2872v.a(atVar);
        this.f32821b = atVar;
        m44171J();
        m44173L();
    }

    /* renamed from: a */
    final void m44194a(at atVar, C4363a c4363a, C7826u c7826u) {
        bd I_;
        String str;
        mo6210d();
        mo6208b();
        m42728w();
        boolean I = m44170I();
        int i = 0;
        int i2 = 100;
        while (i < AdError.NO_FILL_ERROR_CODE && r4 == 100) {
            int size;
            ArrayList arrayList;
            int size2;
            int i3;
            C4363a c4363a2;
            List arrayList2 = new ArrayList();
            if (I) {
                Object a = mo6746j().m43988a(100);
                if (a != null) {
                    arrayList2.addAll(a);
                    size = a.size();
                    if (c4363a != null && size < 100) {
                        arrayList2.add(c4363a);
                    }
                    arrayList = (ArrayList) arrayList2;
                    size2 = arrayList.size();
                    i3 = 0;
                    while (i3 < size2) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        c4363a2 = (C4363a) obj;
                        if (c4363a2 instanceof aq) {
                            try {
                                atVar.mo4741a((aq) c4363a2, c7826u);
                            } catch (RemoteException e) {
                                obj = e;
                                I_ = mo4754r().I_();
                                str = "Failed to send event to the service";
                                I_.m21308a(str, obj);
                            }
                        } else if (c4363a2 instanceof ft) {
                            try {
                                atVar.mo4743a((ft) c4363a2, c7826u);
                            } catch (RemoteException e2) {
                                obj = e2;
                                I_ = mo4754r().I_();
                                str = "Failed to send attribute to the service";
                                I_.m21308a(str, obj);
                            }
                        } else if (c4363a2 instanceof C7827y) {
                            mo4754r().I_().m21307a("Discarding data. Unrecognized parcel type.");
                        } else {
                            try {
                                atVar.mo4746a((C7827y) c4363a2, c7826u);
                            } catch (RemoteException e3) {
                                obj = e3;
                                I_ = mo4754r().I_();
                                str = "Failed to send conditional property to the service";
                                I_.m21308a(str, obj);
                            }
                        }
                    }
                    i++;
                    i2 = size;
                }
            }
            size = 0;
            arrayList2.add(c4363a);
            arrayList = (ArrayList) arrayList2;
            size2 = arrayList.size();
            i3 = 0;
            while (i3 < size2) {
                Object obj2 = arrayList.get(i3);
                i3++;
                c4363a2 = (C4363a) obj2;
                if (c4363a2 instanceof aq) {
                    atVar.mo4741a((aq) c4363a2, c7826u);
                } else if (c4363a2 instanceof ft) {
                    atVar.mo4743a((ft) c4363a2, c7826u);
                } else if (c4363a2 instanceof C7827y) {
                    mo4754r().I_().m21307a("Discarding data. Unrecognized parcel type.");
                } else {
                    atVar.mo4746a((C7827y) c4363a2, c7826u);
                }
            }
            i++;
            i2 = size;
        }
    }

    /* renamed from: a */
    protected final void m44195a(dz dzVar) {
        mo6210d();
        m42728w();
        m44179a(new ei(this, dzVar));
    }

    /* renamed from: a */
    protected final void m44196a(ft ftVar) {
        mo6210d();
        m42728w();
        boolean z = m44170I() && mo6746j().m43991a(ftVar);
        m44179a(new ep(this, z, ftVar, m44176a(true)));
    }

    /* renamed from: a */
    protected final void m44197a(C7827y c7827y) {
        C2872v.a(c7827y);
        mo6210d();
        m42728w();
        mo4755u();
        m44179a(new em(this, true, mo6746j().m43992a(c7827y), new C7827y(c7827y), m44176a(true), c7827y));
    }

    /* renamed from: a */
    public final void m44198a(AtomicReference<String> atomicReference) {
        mo6210d();
        m42728w();
        m44179a(new eg(this, atomicReference, m44176a(false)));
    }

    /* renamed from: a */
    protected final void m44199a(AtomicReference<List<C7827y>> atomicReference, String str, String str2, String str3) {
        mo6210d();
        m42728w();
        m44179a(new en(this, atomicReference, str, str2, str3, m44176a(false)));
    }

    /* renamed from: a */
    protected final void m44200a(AtomicReference<List<ft>> atomicReference, String str, String str2, String str3, boolean z) {
        mo6210d();
        m42728w();
        m44179a(new eo(this, atomicReference, str, str2, str3, z, m44176a(false)));
    }

    /* renamed from: a */
    protected final void m44201a(AtomicReference<List<ft>> atomicReference, boolean z) {
        mo6210d();
        m42728w();
        m44179a(new eq(this, atomicReference, m44176a(false), z));
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo6209c() {
        super.mo6209c();
    }

    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo6210d() {
        super.mo6210d();
    }

    /* renamed from: e */
    public final /* bridge */ /* synthetic */ C8219n mo6741e() {
        return super.mo6741e();
    }

    /* renamed from: f */
    public final /* bridge */ /* synthetic */ df mo6742f() {
        return super.mo6742f();
    }

    /* renamed from: g */
    public final /* bridge */ /* synthetic */ aw mo6743g() {
        return super.mo6743g();
    }

    /* renamed from: h */
    public final /* bridge */ /* synthetic */ ed mo6744h() {
        return super.mo6744h();
    }

    /* renamed from: i */
    public final /* bridge */ /* synthetic */ ea mo6745i() {
        return super.mo6745i();
    }

    /* renamed from: j */
    public final /* bridge */ /* synthetic */ ax mo6746j() {
        return super.mo6746j();
    }

    /* renamed from: k */
    public final /* bridge */ /* synthetic */ fc mo6747k() {
        return super.mo6747k();
    }

    /* renamed from: l */
    public final /* bridge */ /* synthetic */ ak mo6211l() {
        return super.mo6211l();
    }

    /* renamed from: m */
    public final /* bridge */ /* synthetic */ C2895e mo4751m() {
        return super.mo4751m();
    }

    /* renamed from: n */
    public final /* bridge */ /* synthetic */ Context mo4752n() {
        return super.mo4752n();
    }

    /* renamed from: o */
    public final /* bridge */ /* synthetic */ az mo6212o() {
        return super.mo6212o();
    }

    /* renamed from: p */
    public final /* bridge */ /* synthetic */ fw mo6213p() {
        return super.mo6213p();
    }

    /* renamed from: q */
    public final /* bridge */ /* synthetic */ cb mo4753q() {
        return super.mo4753q();
    }

    /* renamed from: r */
    public final /* bridge */ /* synthetic */ bb mo4754r() {
        return super.mo4754r();
    }

    /* renamed from: s */
    public final /* bridge */ /* synthetic */ bm mo6214s() {
        return super.mo6214s();
    }

    /* renamed from: t */
    public final /* bridge */ /* synthetic */ aa mo6215t() {
        return super.mo6215t();
    }

    /* renamed from: u */
    public final /* bridge */ /* synthetic */ C5052x mo4755u() {
        return super.mo4755u();
    }

    /* renamed from: z */
    protected final boolean mo6852z() {
        return false;
    }
}
