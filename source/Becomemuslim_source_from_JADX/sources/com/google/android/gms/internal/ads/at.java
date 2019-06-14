package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.widget.PopupWindow;

@TargetApi(19)
@cm
public final class at extends aq {
    /* renamed from: d */
    private Object f32196d = new Object();
    /* renamed from: e */
    private PopupWindow f32197e;
    /* renamed from: f */
    private boolean f32198f = false;

    at(Context context, it itVar, qo qoVar, ap apVar) {
        super(context, itVar, qoVar, apVar);
    }

    /* renamed from: e */
    private final void m42189e() {
        synchronized (this.f32196d) {
            this.f32198f = true;
            if ((this.a instanceof Activity) && ((Activity) this.a).isDestroyed()) {
                this.f32197e = null;
            }
            if (this.f32197e != null) {
                if (this.f32197e.isShowing()) {
                    this.f32197e.dismiss();
                }
                this.f32197e = null;
            }
        }
    }

    /* renamed from: a */
    protected final void mo6642a(int i) {
        m42189e();
        super.mo6642a(i);
    }

    /* renamed from: b */
    public final void mo3818b() {
        m42189e();
        super.mo3818b();
    }

    /* renamed from: d */
    protected final void mo6643d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.a;
        r0 = r0 instanceof android.app.Activity;
        r1 = 0;
        if (r0 == 0) goto L_0x0010;
    L_0x0007:
        r0 = r8.a;
        r0 = (android.app.Activity) r0;
        r0 = r0.getWindow();
        goto L_0x0011;
    L_0x0010:
        r0 = r1;
    L_0x0011:
        if (r0 == 0) goto L_0x0070;
    L_0x0013:
        r2 = r0.getDecorView();
        if (r2 != 0) goto L_0x001a;
    L_0x0019:
        goto L_0x0070;
    L_0x001a:
        r2 = r8.a;
        r2 = (android.app.Activity) r2;
        r2 = r2.isDestroyed();
        if (r2 == 0) goto L_0x0025;
    L_0x0024:
        return;
    L_0x0025:
        r2 = new android.widget.FrameLayout;
        r3 = r8.a;
        r2.<init>(r3);
        r3 = new android.view.ViewGroup$LayoutParams;
        r4 = -1;
        r3.<init>(r4, r4);
        r2.setLayoutParams(r3);
        r3 = r8.b;
        r3 = r3.getView();
        r2.addView(r3, r4, r4);
        r3 = r8.f32196d;
        monitor-enter(r3);
        r5 = r8.f32198f;	 Catch:{ all -> 0x006d }
        if (r5 == 0) goto L_0x0047;	 Catch:{ all -> 0x006d }
    L_0x0045:
        monitor-exit(r3);	 Catch:{ all -> 0x006d }
        return;	 Catch:{ all -> 0x006d }
    L_0x0047:
        r5 = new android.widget.PopupWindow;	 Catch:{ all -> 0x006d }
        r6 = 0;	 Catch:{ all -> 0x006d }
        r7 = 1;	 Catch:{ all -> 0x006d }
        r5.<init>(r2, r7, r7, r6);	 Catch:{ all -> 0x006d }
        r8.f32197e = r5;	 Catch:{ all -> 0x006d }
        r2 = r8.f32197e;	 Catch:{ all -> 0x006d }
        r2.setOutsideTouchable(r7);	 Catch:{ all -> 0x006d }
        r2 = r8.f32197e;	 Catch:{ all -> 0x006d }
        r2.setClippingEnabled(r6);	 Catch:{ all -> 0x006d }
        r2 = "Displaying the 1x1 popup off the screen.";	 Catch:{ all -> 0x006d }
        com.google.android.gms.internal.ads.mt.m19918b(r2);	 Catch:{ all -> 0x006d }
        r2 = r8.f32197e;	 Catch:{ Exception -> 0x0069 }
        r0 = r0.getDecorView();	 Catch:{ Exception -> 0x0069 }
        r2.showAtLocation(r0, r6, r4, r4);	 Catch:{ Exception -> 0x0069 }
        goto L_0x006b;
    L_0x0069:
        r8.f32197e = r1;	 Catch:{ all -> 0x006d }
    L_0x006b:
        monitor-exit(r3);	 Catch:{ all -> 0x006d }
        return;	 Catch:{ all -> 0x006d }
    L_0x006d:
        r0 = move-exception;	 Catch:{ all -> 0x006d }
        monitor-exit(r3);	 Catch:{ all -> 0x006d }
        throw r0;
    L_0x0070:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.at.d():void");
    }
}
