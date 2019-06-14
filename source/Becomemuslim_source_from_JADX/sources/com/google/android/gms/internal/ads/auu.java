package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.util.C2904o;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@cm
public final class auu extends avj implements OnClickListener, OnTouchListener, OnGlobalLayoutListener, OnScrollChangedListener {
    /* renamed from: a */
    private static final String[] f28393a = new String[]{"2011", "1009", "3010"};
    /* renamed from: b */
    private final Object f28394b = new Object();
    /* renamed from: c */
    private final FrameLayout f28395c;
    /* renamed from: d */
    private FrameLayout f28396d;
    /* renamed from: e */
    private View f28397e;
    /* renamed from: f */
    private final boolean f28398f;
    /* renamed from: g */
    private Map<String, WeakReference<View>> f28399g = Collections.synchronizedMap(new HashMap());
    /* renamed from: h */
    private View f28400h;
    /* renamed from: i */
    private auf f28401i;
    /* renamed from: j */
    private boolean f28402j = false;
    /* renamed from: k */
    private Point f28403k = new Point();
    /* renamed from: l */
    private Point f28404l = new Point();
    /* renamed from: m */
    private WeakReference<aks> f28405m = new WeakReference(null);

    @TargetApi(21)
    public auu(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f28395c = frameLayout;
        this.f28396d = frameLayout2;
        ax.A();
        oh.m19964a(this.f28395c, (OnGlobalLayoutListener) this);
        ax.A();
        oh.m19965a(this.f28395c, (OnScrollChangedListener) this);
        this.f28395c.setOnTouchListener(this);
        this.f28395c.setOnClickListener(this);
        if (frameLayout2 != null && C2904o.i()) {
            frameLayout2.setElevation(Float.MAX_VALUE);
        }
        asp.m18892a(this.f28395c.getContext());
        this.f28398f = ((Boolean) aph.m18688f().m18889a(asp.ci)).booleanValue();
    }

    /* renamed from: a */
    private final int m37143a(int i) {
        aph.m18683a();
        return mi.m19874b(this.f28401i.mo3993m(), i);
    }

    /* renamed from: a */
    private final void m37144a(View view) {
        if (this.f28401i != null) {
            auf f = this.f28401i instanceof aue ? ((aue) this.f28401i).m37137f() : this.f28401i;
            if (f != null) {
                f.mo3985c(view);
            }
        }
    }

    /* renamed from: b */
    private final void m37145b() {
        synchronized (this.f28394b) {
            if (!this.f28398f && this.f28402j) {
                int measuredWidth = this.f28395c.getMeasuredWidth();
                int measuredHeight = this.f28395c.getMeasuredHeight();
                if (!(measuredWidth == 0 || measuredHeight == 0 || this.f28396d == null)) {
                    this.f28396d.setLayoutParams(new LayoutParams(measuredWidth, measuredHeight));
                    this.f28402j = false;
                }
            }
        }
    }

    /* renamed from: a */
    public final C2758b mo3999a(String str) {
        synchronized (this.f28394b) {
            Object obj = null;
            if (this.f28399g == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) this.f28399g.get(str);
            if (weakReference != null) {
                obj = (View) weakReference.get();
            }
            C2758b a = C4757d.a(obj);
            return a;
        }
    }

    /* renamed from: a */
    public final void mo4000a() {
        synchronized (this.f28394b) {
            if (this.f28396d != null) {
                this.f28396d.removeAllViews();
            }
            this.f28396d = null;
            this.f28399g = null;
            this.f28400h = null;
            this.f28401i = null;
            this.f28403k = null;
            this.f28404l = null;
            this.f28405m = null;
            this.f28397e = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo4001a(com.google.android.gms.p174b.C2758b r12) {
        /*
        r11 = this;
        r0 = r11.f28394b;
        monitor-enter(r0);
        r1 = 0;
        r11.m37144a(r1);	 Catch:{ all -> 0x0257 }
        r12 = com.google.android.gms.p174b.C4757d.a(r12);	 Catch:{ all -> 0x0257 }
        r2 = r12 instanceof com.google.android.gms.internal.ads.auk;	 Catch:{ all -> 0x0257 }
        if (r2 != 0) goto L_0x0016;
    L_0x000f:
        r12 = "Not an instance of native engine. This is most likely a transient error";
        com.google.android.gms.internal.ads.mt.m19924e(r12);	 Catch:{ all -> 0x0257 }
        monitor-exit(r0);	 Catch:{ all -> 0x0257 }
        return;
    L_0x0016:
        r2 = r11.f28398f;	 Catch:{ all -> 0x0257 }
        r3 = 0;
        if (r2 != 0) goto L_0x002e;
    L_0x001b:
        r2 = r11.f28396d;	 Catch:{ all -> 0x0257 }
        if (r2 == 0) goto L_0x002e;
    L_0x001f:
        r2 = r11.f28396d;	 Catch:{ all -> 0x0257 }
        r4 = new android.widget.FrameLayout$LayoutParams;	 Catch:{ all -> 0x0257 }
        r4.<init>(r3, r3);	 Catch:{ all -> 0x0257 }
        r2.setLayoutParams(r4);	 Catch:{ all -> 0x0257 }
        r2 = r11.f28395c;	 Catch:{ all -> 0x0257 }
        r2.requestLayout();	 Catch:{ all -> 0x0257 }
    L_0x002e:
        r2 = 1;
        r11.f28402j = r2;	 Catch:{ all -> 0x0257 }
        r12 = (com.google.android.gms.internal.ads.auk) r12;	 Catch:{ all -> 0x0257 }
        r4 = r11.f28401i;	 Catch:{ all -> 0x0257 }
        if (r4 == 0) goto L_0x0052;
    L_0x0037:
        r4 = com.google.android.gms.internal.ads.asp.bZ;	 Catch:{ all -> 0x0257 }
        r5 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ all -> 0x0257 }
        r4 = r5.m18889a(r4);	 Catch:{ all -> 0x0257 }
        r4 = (java.lang.Boolean) r4;	 Catch:{ all -> 0x0257 }
        r4 = r4.booleanValue();	 Catch:{ all -> 0x0257 }
        if (r4 == 0) goto L_0x0052;
    L_0x0049:
        r4 = r11.f28401i;	 Catch:{ all -> 0x0257 }
        r5 = r11.f28395c;	 Catch:{ all -> 0x0257 }
        r6 = r11.f28399g;	 Catch:{ all -> 0x0257 }
        r4.mo3981b(r5, r6);	 Catch:{ all -> 0x0257 }
    L_0x0052:
        r4 = r11.f28401i;	 Catch:{ all -> 0x0257 }
        r4 = r4 instanceof com.google.android.gms.internal.ads.auk;	 Catch:{ all -> 0x0257 }
        if (r4 == 0) goto L_0x008c;
    L_0x0058:
        r4 = r11.f28401i;	 Catch:{ all -> 0x0257 }
        r4 = (com.google.android.gms.internal.ads.auk) r4;	 Catch:{ all -> 0x0257 }
        if (r4 == 0) goto L_0x008c;
    L_0x005e:
        r5 = r4.mo3993m();	 Catch:{ all -> 0x0257 }
        if (r5 == 0) goto L_0x008c;
    L_0x0064:
        r5 = com.google.android.gms.ads.internal.ax.B();	 Catch:{ all -> 0x0257 }
        r6 = r11.f28395c;	 Catch:{ all -> 0x0257 }
        r6 = r6.getContext();	 Catch:{ all -> 0x0257 }
        r5 = r5.m19545c(r6);	 Catch:{ all -> 0x0257 }
        if (r5 == 0) goto L_0x008c;
    L_0x0074:
        r4 = r4.m30242n();	 Catch:{ all -> 0x0257 }
        if (r4 == 0) goto L_0x007d;
    L_0x007a:
        r4.m30815a(r3);	 Catch:{ all -> 0x0257 }
    L_0x007d:
        r5 = r11.f28405m;	 Catch:{ all -> 0x0257 }
        r5 = r5.get();	 Catch:{ all -> 0x0257 }
        r5 = (com.google.android.gms.internal.ads.aks) r5;	 Catch:{ all -> 0x0257 }
        if (r5 == 0) goto L_0x008c;
    L_0x0087:
        if (r4 == 0) goto L_0x008c;
    L_0x0089:
        r5.m18558b(r4);	 Catch:{ all -> 0x0257 }
    L_0x008c:
        r4 = r11.f28401i;	 Catch:{ all -> 0x0257 }
        r4 = r4 instanceof com.google.android.gms.internal.ads.aue;	 Catch:{ all -> 0x0257 }
        if (r4 == 0) goto L_0x00a4;
    L_0x0092:
        r4 = r11.f28401i;	 Catch:{ all -> 0x0257 }
        r4 = (com.google.android.gms.internal.ads.aue) r4;	 Catch:{ all -> 0x0257 }
        r4 = r4.m37136e();	 Catch:{ all -> 0x0257 }
        if (r4 == 0) goto L_0x00a4;
    L_0x009c:
        r4 = r11.f28401i;	 Catch:{ all -> 0x0257 }
        r4 = (com.google.android.gms.internal.ads.aue) r4;	 Catch:{ all -> 0x0257 }
        r4.m37129a(r12);	 Catch:{ all -> 0x0257 }
        goto L_0x00b0;
    L_0x00a4:
        r11.f28401i = r12;	 Catch:{ all -> 0x0257 }
        r4 = r12 instanceof com.google.android.gms.internal.ads.aue;	 Catch:{ all -> 0x0257 }
        if (r4 == 0) goto L_0x00b0;
    L_0x00aa:
        r4 = r12;
        r4 = (com.google.android.gms.internal.ads.aue) r4;	 Catch:{ all -> 0x0257 }
        r4.m37129a(r1);	 Catch:{ all -> 0x0257 }
    L_0x00b0:
        r4 = r11.f28396d;	 Catch:{ all -> 0x0257 }
        if (r4 != 0) goto L_0x00b6;
    L_0x00b4:
        monitor-exit(r0);	 Catch:{ all -> 0x0257 }
        return;
    L_0x00b6:
        r4 = com.google.android.gms.internal.ads.asp.bZ;	 Catch:{ all -> 0x0257 }
        r5 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ all -> 0x0257 }
        r4 = r5.m18889a(r4);	 Catch:{ all -> 0x0257 }
        r4 = (java.lang.Boolean) r4;	 Catch:{ all -> 0x0257 }
        r4 = r4.booleanValue();	 Catch:{ all -> 0x0257 }
        if (r4 == 0) goto L_0x00cd;
    L_0x00c8:
        r4 = r11.f28396d;	 Catch:{ all -> 0x0257 }
        r4.setClickable(r3);	 Catch:{ all -> 0x0257 }
    L_0x00cd:
        r4 = r11.f28396d;	 Catch:{ all -> 0x0257 }
        r4.removeAllViews();	 Catch:{ all -> 0x0257 }
        r4 = r12.mo3977a();	 Catch:{ all -> 0x0257 }
        if (r4 == 0) goto L_0x0106;
    L_0x00d8:
        r5 = r11.f28399g;	 Catch:{ all -> 0x0257 }
        if (r5 == 0) goto L_0x00fe;
    L_0x00dc:
        r5 = "1098";
        r6 = "3011";
        r5 = new java.lang.String[]{r5, r6};	 Catch:{ all -> 0x0257 }
        r6 = 0;
    L_0x00e5:
        r7 = 2;
        if (r6 >= r7) goto L_0x00fe;
    L_0x00e8:
        r7 = r5[r6];	 Catch:{ all -> 0x0257 }
        r8 = r11.f28399g;	 Catch:{ all -> 0x0257 }
        r7 = r8.get(r7);	 Catch:{ all -> 0x0257 }
        r7 = (java.lang.ref.WeakReference) r7;	 Catch:{ all -> 0x0257 }
        if (r7 == 0) goto L_0x00fb;
    L_0x00f4:
        r5 = r7.get();	 Catch:{ all -> 0x0257 }
        r5 = (android.view.View) r5;	 Catch:{ all -> 0x0257 }
        goto L_0x00ff;
    L_0x00fb:
        r6 = r6 + 1;
        goto L_0x00e5;
    L_0x00fe:
        r5 = r1;
    L_0x00ff:
        r6 = r5 instanceof android.view.ViewGroup;	 Catch:{ all -> 0x0257 }
        if (r6 == 0) goto L_0x0106;
    L_0x0103:
        r5 = (android.view.ViewGroup) r5;	 Catch:{ all -> 0x0257 }
        goto L_0x0107;
    L_0x0106:
        r5 = r1;
    L_0x0107:
        if (r4 == 0) goto L_0x010c;
    L_0x0109:
        if (r5 == 0) goto L_0x010c;
    L_0x010b:
        goto L_0x010d;
    L_0x010c:
        r2 = 0;
    L_0x010d:
        r4 = r12.mo3969a(r11, r2);	 Catch:{ all -> 0x0257 }
        r11.f28400h = r4;	 Catch:{ all -> 0x0257 }
        r4 = r11.f28400h;	 Catch:{ all -> 0x0257 }
        r10 = -1;
        if (r4 == 0) goto L_0x0154;
    L_0x0118:
        r4 = r11.f28399g;	 Catch:{ all -> 0x0257 }
        if (r4 == 0) goto L_0x012a;
    L_0x011c:
        r4 = r11.f28399g;	 Catch:{ all -> 0x0257 }
        r6 = "1007";
        r7 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x0257 }
        r8 = r11.f28400h;	 Catch:{ all -> 0x0257 }
        r7.<init>(r8);	 Catch:{ all -> 0x0257 }
        r4.put(r6, r7);	 Catch:{ all -> 0x0257 }
    L_0x012a:
        if (r2 == 0) goto L_0x0135;
    L_0x012c:
        r5.removeAllViews();	 Catch:{ all -> 0x0257 }
        r2 = r11.f28400h;	 Catch:{ all -> 0x0257 }
        r5.addView(r2);	 Catch:{ all -> 0x0257 }
        goto L_0x0154;
    L_0x0135:
        r2 = r12.mo3993m();	 Catch:{ all -> 0x0257 }
        r4 = new com.google.android.gms.ads.b.a;	 Catch:{ all -> 0x0257 }
        r4.<init>(r2);	 Catch:{ all -> 0x0257 }
        r2 = new android.widget.FrameLayout$LayoutParams;	 Catch:{ all -> 0x0257 }
        r2.<init>(r10, r10);	 Catch:{ all -> 0x0257 }
        r4.setLayoutParams(r2);	 Catch:{ all -> 0x0257 }
        r2 = r11.f28400h;	 Catch:{ all -> 0x0257 }
        r4.addView(r2);	 Catch:{ all -> 0x0257 }
        r2 = r11.f28396d;	 Catch:{ all -> 0x0257 }
        if (r2 == 0) goto L_0x0154;
    L_0x014f:
        r2 = r11.f28396d;	 Catch:{ all -> 0x0257 }
        r2.addView(r4);	 Catch:{ all -> 0x0257 }
    L_0x0154:
        r5 = r11.f28395c;	 Catch:{ all -> 0x0257 }
        r6 = r11.f28399g;	 Catch:{ all -> 0x0257 }
        r7 = 0;
        r4 = r12;
        r8 = r11;
        r9 = r11;
        r4.mo6089a(r5, r6, r7, r8, r9);	 Catch:{ all -> 0x0257 }
        r2 = r11.f28398f;	 Catch:{ all -> 0x0257 }
        if (r2 == 0) goto L_0x018f;
    L_0x0163:
        r2 = r11.f28397e;	 Catch:{ all -> 0x0257 }
        if (r2 != 0) goto L_0x017e;
    L_0x0167:
        r2 = new android.view.View;	 Catch:{ all -> 0x0257 }
        r4 = r11.f28395c;	 Catch:{ all -> 0x0257 }
        r4 = r4.getContext();	 Catch:{ all -> 0x0257 }
        r2.<init>(r4);	 Catch:{ all -> 0x0257 }
        r11.f28397e = r2;	 Catch:{ all -> 0x0257 }
        r2 = r11.f28397e;	 Catch:{ all -> 0x0257 }
        r4 = new android.widget.FrameLayout$LayoutParams;	 Catch:{ all -> 0x0257 }
        r4.<init>(r10, r3);	 Catch:{ all -> 0x0257 }
        r2.setLayoutParams(r4);	 Catch:{ all -> 0x0257 }
    L_0x017e:
        r2 = r11.f28395c;	 Catch:{ all -> 0x0257 }
        r4 = r11.f28397e;	 Catch:{ all -> 0x0257 }
        r4 = r4.getParent();	 Catch:{ all -> 0x0257 }
        if (r2 == r4) goto L_0x018f;
    L_0x0188:
        r2 = r11.f28395c;	 Catch:{ all -> 0x0257 }
        r4 = r11.f28397e;	 Catch:{ all -> 0x0257 }
        r2.addView(r4);	 Catch:{ all -> 0x0257 }
    L_0x018f:
        r2 = r12.mo6090g();	 Catch:{ Exception -> 0x0194 }
        goto L_0x01aa;
    L_0x0194:
        r2 = move-exception;
        com.google.android.gms.ads.internal.ax.g();	 Catch:{ all -> 0x0257 }
        r4 = com.google.android.gms.internal.ads.kc.m19754e();	 Catch:{ all -> 0x0257 }
        if (r4 == 0) goto L_0x01a4;
    L_0x019e:
        r2 = "Privileged processes cannot create HTML overlays.";
        com.google.android.gms.internal.ads.mt.m19924e(r2);	 Catch:{ all -> 0x0257 }
        goto L_0x01a9;
    L_0x01a4:
        r4 = "Error obtaining overlay.";
        com.google.android.gms.internal.ads.mt.m19919b(r4, r2);	 Catch:{ all -> 0x0257 }
    L_0x01a9:
        r2 = r1;
    L_0x01aa:
        if (r2 == 0) goto L_0x01b9;
    L_0x01ac:
        r4 = r11.f28396d;	 Catch:{ all -> 0x0257 }
        if (r4 == 0) goto L_0x01b9;
    L_0x01b0:
        r4 = r11.f28396d;	 Catch:{ all -> 0x0257 }
        r2 = r2.getView();	 Catch:{ all -> 0x0257 }
        r4.addView(r2);	 Catch:{ all -> 0x0257 }
    L_0x01b9:
        r2 = r11.f28394b;	 Catch:{ all -> 0x0257 }
        monitor-enter(r2);	 Catch:{ all -> 0x0257 }
        r4 = r11.f28399g;	 Catch:{ all -> 0x0254 }
        r12.m30221a(r4);	 Catch:{ all -> 0x0254 }
        r4 = r11.f28399g;	 Catch:{ all -> 0x0254 }
        if (r4 == 0) goto L_0x01e0;
    L_0x01c5:
        r4 = f28393a;	 Catch:{ all -> 0x0254 }
        r5 = r4.length;	 Catch:{ all -> 0x0254 }
    L_0x01c8:
        if (r3 >= r5) goto L_0x01e0;
    L_0x01ca:
        r6 = r4[r3];	 Catch:{ all -> 0x0254 }
        r7 = r11.f28399g;	 Catch:{ all -> 0x0254 }
        r6 = r7.get(r6);	 Catch:{ all -> 0x0254 }
        r6 = (java.lang.ref.WeakReference) r6;	 Catch:{ all -> 0x0254 }
        if (r6 == 0) goto L_0x01dd;
    L_0x01d6:
        r1 = r6.get();	 Catch:{ all -> 0x0254 }
        r1 = (android.view.View) r1;	 Catch:{ all -> 0x0254 }
        goto L_0x01e0;
    L_0x01dd:
        r3 = r3 + 1;
        goto L_0x01c8;
    L_0x01e0:
        r3 = r1 instanceof android.widget.FrameLayout;	 Catch:{ all -> 0x0254 }
        if (r3 != 0) goto L_0x01e9;
    L_0x01e4:
        r12.mo3989i();	 Catch:{ all -> 0x0254 }
    L_0x01e7:
        monitor-exit(r2);	 Catch:{ all -> 0x0254 }
        goto L_0x01fa;
    L_0x01e9:
        r3 = new com.google.android.gms.internal.ads.auv;	 Catch:{ all -> 0x0254 }
        r3.<init>(r11, r1);	 Catch:{ all -> 0x0254 }
        r4 = r12 instanceof com.google.android.gms.internal.ads.aue;	 Catch:{ all -> 0x0254 }
        if (r4 == 0) goto L_0x01f6;
    L_0x01f2:
        r12.m30228b(r1, r3);	 Catch:{ all -> 0x0254 }
        goto L_0x01e7;
    L_0x01f6:
        r12.mo3972a(r1, r3);	 Catch:{ all -> 0x0254 }
        goto L_0x01e7;
    L_0x01fa:
        r1 = r11.f28395c;	 Catch:{ all -> 0x0257 }
        r12.m30234d(r1);	 Catch:{ all -> 0x0257 }
        r12 = r11.f28395c;	 Catch:{ all -> 0x0257 }
        r11.m37144a(r12);	 Catch:{ all -> 0x0257 }
        r12 = r11.f28401i;	 Catch:{ all -> 0x0257 }
        r1 = r11.f28395c;	 Catch:{ all -> 0x0257 }
        r12.mo3980b(r1);	 Catch:{ all -> 0x0257 }
        r12 = r11.f28401i;	 Catch:{ all -> 0x0257 }
        r12 = r12 instanceof com.google.android.gms.internal.ads.auk;	 Catch:{ all -> 0x0257 }
        if (r12 == 0) goto L_0x0252;
    L_0x0211:
        r12 = r11.f28401i;	 Catch:{ all -> 0x0257 }
        r12 = (com.google.android.gms.internal.ads.auk) r12;	 Catch:{ all -> 0x0257 }
        if (r12 == 0) goto L_0x0252;
    L_0x0217:
        r1 = r12.mo3993m();	 Catch:{ all -> 0x0257 }
        if (r1 == 0) goto L_0x0252;
    L_0x021d:
        r1 = com.google.android.gms.ads.internal.ax.B();	 Catch:{ all -> 0x0257 }
        r2 = r11.f28395c;	 Catch:{ all -> 0x0257 }
        r2 = r2.getContext();	 Catch:{ all -> 0x0257 }
        r1 = r1.m19545c(r2);	 Catch:{ all -> 0x0257 }
        if (r1 == 0) goto L_0x0252;
    L_0x022d:
        r1 = r11.f28405m;	 Catch:{ all -> 0x0257 }
        r1 = r1.get();	 Catch:{ all -> 0x0257 }
        r1 = (com.google.android.gms.internal.ads.aks) r1;	 Catch:{ all -> 0x0257 }
        if (r1 != 0) goto L_0x024b;
    L_0x0237:
        r1 = new com.google.android.gms.internal.ads.aks;	 Catch:{ all -> 0x0257 }
        r2 = r11.f28395c;	 Catch:{ all -> 0x0257 }
        r2 = r2.getContext();	 Catch:{ all -> 0x0257 }
        r3 = r11.f28395c;	 Catch:{ all -> 0x0257 }
        r1.<init>(r2, r3);	 Catch:{ all -> 0x0257 }
        r2 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x0257 }
        r2.<init>(r1);	 Catch:{ all -> 0x0257 }
        r11.f28405m = r2;	 Catch:{ all -> 0x0257 }
    L_0x024b:
        r12 = r12.m30242n();	 Catch:{ all -> 0x0257 }
        r1.m18557a(r12);	 Catch:{ all -> 0x0257 }
    L_0x0252:
        monitor-exit(r0);	 Catch:{ all -> 0x0257 }
        return;
    L_0x0254:
        r12 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0254 }
        throw r12;	 Catch:{ all -> 0x0257 }
    L_0x0257:
        r12 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0257 }
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auu.a(com.google.android.gms.b.b):void");
    }

    /* renamed from: a */
    public final void mo4002a(C2758b c2758b, int i) {
        if (ax.B().m19545c(this.f28395c.getContext()) && this.f28405m != null) {
            aks aks = (aks) this.f28405m.get();
            if (aks != null) {
                aks.m18556a();
            }
        }
        m37145b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo4003a(java.lang.String r4, com.google.android.gms.p174b.C2758b r5) {
        /*
        r3 = this;
        r5 = com.google.android.gms.p174b.C4757d.a(r5);
        r5 = (android.view.View) r5;
        r0 = r3.f28394b;
        monitor-enter(r0);
        r1 = r3.f28399g;	 Catch:{ all -> 0x0040 }
        if (r1 != 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r0);	 Catch:{ all -> 0x0040 }
        return;
    L_0x000f:
        if (r5 != 0) goto L_0x0017;
    L_0x0011:
        r5 = r3.f28399g;	 Catch:{ all -> 0x0040 }
        r5.remove(r4);	 Catch:{ all -> 0x0040 }
        goto L_0x003c;
    L_0x0017:
        r1 = r3.f28399g;	 Catch:{ all -> 0x0040 }
        r2 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x0040 }
        r2.<init>(r5);	 Catch:{ all -> 0x0040 }
        r1.put(r4, r2);	 Catch:{ all -> 0x0040 }
        r1 = "1098";
        r1 = r1.equals(r4);	 Catch:{ all -> 0x0040 }
        if (r1 != 0) goto L_0x003e;
    L_0x0029:
        r1 = "3011";
        r4 = r1.equals(r4);	 Catch:{ all -> 0x0040 }
        if (r4 == 0) goto L_0x0032;
    L_0x0031:
        goto L_0x003e;
    L_0x0032:
        r5.setOnTouchListener(r3);	 Catch:{ all -> 0x0040 }
        r4 = 1;
        r5.setClickable(r4);	 Catch:{ all -> 0x0040 }
        r5.setOnClickListener(r3);	 Catch:{ all -> 0x0040 }
    L_0x003c:
        monitor-exit(r0);	 Catch:{ all -> 0x0040 }
        return;
    L_0x003e:
        monitor-exit(r0);	 Catch:{ all -> 0x0040 }
        return;
    L_0x0040:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0040 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auu.a(java.lang.String, com.google.android.gms.b.b):void");
    }

    /* renamed from: b */
    public final void mo4004b(C2758b c2758b) {
        this.f28401i.mo3971a((View) C4757d.a(c2758b));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r9) {
        /*
        r8 = this;
        r0 = r8.f28394b;
        monitor-enter(r0);
        r1 = r8.f28401i;	 Catch:{ all -> 0x008e }
        if (r1 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);	 Catch:{ all -> 0x008e }
        return;
    L_0x0009:
        r1 = r8.f28401i;	 Catch:{ all -> 0x008e }
        r1.mo3983c();	 Catch:{ all -> 0x008e }
        r5 = new android.os.Bundle;	 Catch:{ all -> 0x008e }
        r5.<init>();	 Catch:{ all -> 0x008e }
        r1 = "x";
        r2 = r8.f28403k;	 Catch:{ all -> 0x008e }
        r2 = r2.x;	 Catch:{ all -> 0x008e }
        r2 = r8.m37143a(r2);	 Catch:{ all -> 0x008e }
        r2 = (float) r2;	 Catch:{ all -> 0x008e }
        r5.putFloat(r1, r2);	 Catch:{ all -> 0x008e }
        r1 = "y";
        r2 = r8.f28403k;	 Catch:{ all -> 0x008e }
        r2 = r2.y;	 Catch:{ all -> 0x008e }
        r2 = r8.m37143a(r2);	 Catch:{ all -> 0x008e }
        r2 = (float) r2;	 Catch:{ all -> 0x008e }
        r5.putFloat(r1, r2);	 Catch:{ all -> 0x008e }
        r1 = "start_x";
        r2 = r8.f28404l;	 Catch:{ all -> 0x008e }
        r2 = r2.x;	 Catch:{ all -> 0x008e }
        r2 = r8.m37143a(r2);	 Catch:{ all -> 0x008e }
        r2 = (float) r2;	 Catch:{ all -> 0x008e }
        r5.putFloat(r1, r2);	 Catch:{ all -> 0x008e }
        r1 = "start_y";
        r2 = r8.f28404l;	 Catch:{ all -> 0x008e }
        r2 = r2.y;	 Catch:{ all -> 0x008e }
        r2 = r8.m37143a(r2);	 Catch:{ all -> 0x008e }
        r2 = (float) r2;	 Catch:{ all -> 0x008e }
        r5.putFloat(r1, r2);	 Catch:{ all -> 0x008e }
        r1 = r8.f28400h;	 Catch:{ all -> 0x008e }
        if (r1 == 0) goto L_0x0083;
    L_0x004f:
        r1 = r8.f28400h;	 Catch:{ all -> 0x008e }
        r1 = r1.equals(r9);	 Catch:{ all -> 0x008e }
        if (r1 == 0) goto L_0x0083;
    L_0x0057:
        r1 = r8.f28401i;	 Catch:{ all -> 0x008e }
        r1 = r1 instanceof com.google.android.gms.internal.ads.aue;	 Catch:{ all -> 0x008e }
        if (r1 == 0) goto L_0x007a;
    L_0x005d:
        r1 = r8.f28401i;	 Catch:{ all -> 0x008e }
        r1 = (com.google.android.gms.internal.ads.aue) r1;	 Catch:{ all -> 0x008e }
        r1 = r1.m37137f();	 Catch:{ all -> 0x008e }
        if (r1 == 0) goto L_0x008c;
    L_0x0067:
        r1 = r8.f28401i;	 Catch:{ all -> 0x008e }
        r1 = (com.google.android.gms.internal.ads.aue) r1;	 Catch:{ all -> 0x008e }
        r2 = r1.m37137f();	 Catch:{ all -> 0x008e }
        r4 = "1007";
        r6 = r8.f28399g;	 Catch:{ all -> 0x008e }
        r7 = r8.f28395c;	 Catch:{ all -> 0x008e }
    L_0x0075:
        r3 = r9;
        r2.mo3973a(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x008e }
        goto L_0x008c;
    L_0x007a:
        r2 = r8.f28401i;	 Catch:{ all -> 0x008e }
        r4 = "1007";
        r6 = r8.f28399g;	 Catch:{ all -> 0x008e }
        r7 = r8.f28395c;	 Catch:{ all -> 0x008e }
        goto L_0x0075;
    L_0x0083:
        r1 = r8.f28401i;	 Catch:{ all -> 0x008e }
        r2 = r8.f28399g;	 Catch:{ all -> 0x008e }
        r3 = r8.f28395c;	 Catch:{ all -> 0x008e }
        r1.mo3975a(r9, r2, r5, r3);	 Catch:{ all -> 0x008e }
    L_0x008c:
        monitor-exit(r0);	 Catch:{ all -> 0x008e }
        return;
    L_0x008e:
        r9 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x008e }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auu.onClick(android.view.View):void");
    }

    public final void onGlobalLayout() {
        synchronized (this.f28394b) {
            m37145b();
            if (this.f28401i != null) {
                this.f28401i.mo3986c(this.f28395c, this.f28399g);
            }
        }
    }

    public final void onScrollChanged() {
        synchronized (this.f28394b) {
            if (this.f28401i != null) {
                this.f28401i.mo3986c(this.f28395c, this.f28399g);
            }
            m37145b();
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.f28394b) {
            if (this.f28401i == null) {
                return false;
            }
            int[] iArr = new int[2];
            this.f28395c.getLocationOnScreen(iArr);
            Point point = new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
            this.f28403k = point;
            if (motionEvent.getAction() == 0) {
                this.f28404l = point;
            }
            motionEvent = MotionEvent.obtain(motionEvent);
            motionEvent.setLocation((float) point.x, (float) point.y);
            this.f28401i.mo3970a(motionEvent);
            motionEvent.recycle();
            return false;
        }
    }
}
