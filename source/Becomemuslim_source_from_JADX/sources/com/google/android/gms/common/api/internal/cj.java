package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.C4361e;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.internal.p205d.C4956e;
import java.util.concurrent.atomic.AtomicReference;

public abstract class cj extends LifecycleCallback implements OnCancelListener {
    /* renamed from: b */
    protected volatile boolean f11492b;
    /* renamed from: c */
    protected final AtomicReference<ck> f11493c;
    /* renamed from: d */
    protected final C4361e f11494d;
    /* renamed from: e */
    private final Handler f11495e;

    protected cj(C2801g c2801g) {
        this(c2801g, C4361e.m14332a());
    }

    /* renamed from: a */
    protected abstract void mo3285a(C4775b c4775b, int i);

    /* renamed from: f */
    protected abstract void mo3287f();

    private cj(C2801g c2801g, C4361e c4361e) {
        super(c2801g);
        this.f11493c = new AtomicReference(null);
        this.f11495e = new C4956e(Looper.getMainLooper());
        this.f11494d = c4361e;
    }

    public void onCancel(DialogInterface dialogInterface) {
        mo3285a(new C4775b(13, null), m14200a((ck) this.f11493c.get()));
        m14209h();
    }

    /* renamed from: a */
    public void mo2432a(Bundle bundle) {
        super.mo2432a(bundle);
        if (bundle != null) {
            this.f11493c.set(bundle.getBoolean("resolving_error", false) ? new ck(new C4775b(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    /* renamed from: b */
    public void mo2434b(Bundle bundle) {
        super.mo2434b(bundle);
        ck ckVar = (ck) this.f11493c.get();
        if (ckVar != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", ckVar.m8035a());
            bundle.putInt("failed_status", ckVar.m8036b().m16827c());
            bundle.putParcelable("failed_resolution", ckVar.m8036b().m16828d());
        }
    }

    /* renamed from: b */
    public void mo2433b() {
        super.mo2433b();
        this.f11492b = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo2431a(int r4, int r5, android.content.Intent r6) {
        /*
        r3 = this;
        r0 = r3.f11493c;
        r0 = r0.get();
        r0 = (com.google.android.gms.common.api.internal.ck) r0;
        r1 = 1;
        r2 = 0;
        switch(r4) {
            case 1: goto L_0x002e;
            case 2: goto L_0x000e;
            default: goto L_0x000d;
        };
    L_0x000d:
        goto L_0x0053;
    L_0x000e:
        r4 = r3.f11494d;
        r5 = r3.m7971a();
        r4 = r4.mo2455a(r5);
        if (r4 != 0) goto L_0x001b;
    L_0x001a:
        goto L_0x001c;
    L_0x001b:
        r1 = 0;
    L_0x001c:
        if (r0 != 0) goto L_0x001f;
    L_0x001e:
        return;
    L_0x001f:
        r5 = r0.m8036b();
        r5 = r5.m16827c();
        r6 = 18;
        if (r5 != r6) goto L_0x0054;
    L_0x002b:
        if (r4 != r6) goto L_0x0054;
    L_0x002d:
        return;
    L_0x002e:
        r4 = -1;
        if (r5 != r4) goto L_0x0032;
    L_0x0031:
        goto L_0x0054;
    L_0x0032:
        if (r5 != 0) goto L_0x0053;
    L_0x0034:
        r4 = 13;
        if (r6 == 0) goto L_0x003e;
    L_0x0038:
        r5 = "<<ResolutionFailureErrorDetail>>";
        r4 = r6.getIntExtra(r5, r4);
    L_0x003e:
        r5 = new com.google.android.gms.common.api.internal.ck;
        r6 = new com.google.android.gms.common.b;
        r1 = 0;
        r6.<init>(r4, r1);
        r4 = m14200a(r0);
        r5.<init>(r6, r4);
        r4 = r3.f11493c;
        r4.set(r5);
        r0 = r5;
    L_0x0053:
        r1 = 0;
    L_0x0054:
        if (r1 == 0) goto L_0x005a;
    L_0x0056:
        r3.m14209h();
        return;
    L_0x005a:
        if (r0 == 0) goto L_0x0067;
    L_0x005c:
        r4 = r0.m8036b();
        r5 = r0.m8035a();
        r3.mo3285a(r4, r5);
    L_0x0067:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.cj.a(int, int, android.content.Intent):void");
    }

    /* renamed from: d */
    public void mo2435d() {
        super.mo2435d();
        this.f11492b = false;
    }

    /* renamed from: h */
    protected final void m14209h() {
        this.f11493c.set(null);
        mo3287f();
    }

    /* renamed from: b */
    public final void m14206b(C4775b c4775b, int i) {
        ck ckVar = new ck(c4775b, i);
        if (this.f11493c.compareAndSet(0, ckVar) != null) {
            this.f11495e.post(new cl(this, ckVar));
        }
    }

    /* renamed from: a */
    private static int m14200a(ck ckVar) {
        return ckVar == null ? -1 : ckVar.m8035a();
    }
}
