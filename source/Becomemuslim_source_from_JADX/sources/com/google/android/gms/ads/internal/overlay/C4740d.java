package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.util.C2904o;
import com.google.android.gms.internal.ads.C4933n;
import com.google.android.gms.internal.ads.C6767s;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.jw;
import com.google.android.gms.internal.ads.kc;
import com.google.android.gms.internal.ads.qo;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.Collections;

@cm
/* renamed from: com.google.android.gms.ads.internal.overlay.d */
public class C4740d extends C6767s implements C2671w {
    /* renamed from: e */
    private static final int f13045e = Color.argb(0, 0, 0, 0);
    /* renamed from: a */
    protected final Activity f13046a;
    /* renamed from: b */
    AdOverlayInfoParcel f13047b;
    /* renamed from: c */
    qo f13048c;
    /* renamed from: d */
    int f13049d = 0;
    /* renamed from: f */
    private C2661i f13050f;
    /* renamed from: g */
    private C2666o f13051g;
    /* renamed from: h */
    private boolean f13052h = false;
    /* renamed from: i */
    private FrameLayout f13053i;
    /* renamed from: j */
    private CustomViewCallback f13054j;
    /* renamed from: k */
    private boolean f13055k = false;
    /* renamed from: l */
    private boolean f13056l = false;
    /* renamed from: m */
    private C2660h f13057m;
    /* renamed from: n */
    private boolean f13058n = false;
    /* renamed from: o */
    private final Object f13059o = new Object();
    /* renamed from: p */
    private Runnable f13060p;
    /* renamed from: q */
    private boolean f13061q;
    /* renamed from: r */
    private boolean f13062r;
    /* renamed from: s */
    private boolean f13063s = false;
    /* renamed from: t */
    private boolean f13064t = false;
    /* renamed from: u */
    private boolean f13065u = true;

    public C4740d(Activity activity) {
        this.f13046a = activity;
    }

    /* renamed from: a */
    private final void m16555a(boolean z) {
        int intValue = ((Integer) aph.f().a(asp.da)).intValue();
        C2667p c2667p = new C2667p();
        c2667p.f6916e = 50;
        c2667p.f6912a = z ? intValue : 0;
        c2667p.f6913b = z ? 0 : intValue;
        c2667p.f6914c = 0;
        c2667p.f6915d = intValue;
        this.f13051g = new C2666o(this.f13046a, c2667p, this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        m16565a(z, this.f13047b.f13027g);
        this.f13057m.addView(this.f13051g, layoutParams);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private final void m16556b(boolean r19) {
        /*
        r18 = this;
        r1 = r18;
        r2 = r1.f13062r;
        r3 = 1;
        if (r2 != 0) goto L_0x000c;
    L_0x0007:
        r2 = r1.f13046a;
        r2.requestWindowFeature(r3);
    L_0x000c:
        r2 = r1.f13046a;
        r2 = r2.getWindow();
        if (r2 == 0) goto L_0x0260;
    L_0x0014:
        r4 = com.google.android.gms.common.util.C2904o.m8465k();
        if (r4 == 0) goto L_0x0040;
    L_0x001a:
        r4 = com.google.android.gms.internal.ads.asp.cY;
        r5 = com.google.android.gms.internal.ads.aph.f();
        r4 = r5.a(r4);
        r4 = (java.lang.Boolean) r4;
        r4 = r4.booleanValue();
        if (r4 == 0) goto L_0x0040;
    L_0x002c:
        com.google.android.gms.ads.internal.ax.m7464e();
        r4 = r1.f13046a;
        r5 = r1.f13046a;
        r5 = r5.getResources();
        r5 = r5.getConfiguration();
        r4 = com.google.android.gms.internal.ads.jw.a(r4, r5);
        goto L_0x0041;
    L_0x0040:
        r4 = 1;
    L_0x0041:
        r5 = r1.f13047b;
        r5 = r5.f13035o;
        r6 = 0;
        if (r5 == 0) goto L_0x0052;
    L_0x0048:
        r5 = r1.f13047b;
        r5 = r5.f13035o;
        r5 = r5.f13074b;
        if (r5 == 0) goto L_0x0052;
    L_0x0050:
        r5 = 1;
        goto L_0x0053;
    L_0x0052:
        r5 = 0;
    L_0x0053:
        r7 = r1.f13056l;
        if (r7 == 0) goto L_0x0059;
    L_0x0057:
        if (r5 == 0) goto L_0x008f;
    L_0x0059:
        if (r4 == 0) goto L_0x008f;
    L_0x005b:
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2.setFlags(r4, r4);
        r4 = com.google.android.gms.internal.ads.asp.aQ;
        r5 = com.google.android.gms.internal.ads.aph.f();
        r4 = r5.a(r4);
        r4 = (java.lang.Boolean) r4;
        r4 = r4.booleanValue();
        if (r4 == 0) goto L_0x008f;
    L_0x0072:
        r4 = com.google.android.gms.common.util.C2904o.m8461g();
        if (r4 == 0) goto L_0x008f;
    L_0x0078:
        r4 = r1.f13047b;
        r4 = r4.f13035o;
        if (r4 == 0) goto L_0x008f;
    L_0x007e:
        r4 = r1.f13047b;
        r4 = r4.f13035o;
        r4 = r4.f13078f;
        if (r4 == 0) goto L_0x008f;
    L_0x0086:
        r4 = r2.getDecorView();
        r5 = 4098; // 0x1002 float:5.743E-42 double:2.0247E-320;
        r4.setSystemUiVisibility(r5);
    L_0x008f:
        r4 = r1.f13047b;
        r4 = r4.f13024d;
        r5 = 0;
        if (r4 == 0) goto L_0x009f;
    L_0x0096:
        r4 = r1.f13047b;
        r4 = r4.f13024d;
        r4 = r4.v();
        goto L_0x00a0;
    L_0x009f:
        r4 = r5;
    L_0x00a0:
        if (r4 == 0) goto L_0x00a7;
    L_0x00a2:
        r4 = r4.b();
        goto L_0x00a8;
    L_0x00a7:
        r4 = 0;
    L_0x00a8:
        r1.f13058n = r6;
        if (r4 == 0) goto L_0x00ea;
    L_0x00ac:
        r7 = r1.f13047b;
        r7 = r7.f13030j;
        r8 = com.google.android.gms.ads.internal.ax.m7466g();
        r8 = r8.a();
        if (r7 != r8) goto L_0x00cc;
    L_0x00ba:
        r7 = r1.f13046a;
        r7 = r7.getResources();
        r7 = r7.getConfiguration();
        r7 = r7.orientation;
        if (r7 != r3) goto L_0x00c9;
    L_0x00c8:
        r6 = 1;
    L_0x00c9:
        r1.f13058n = r6;
        goto L_0x00ea;
    L_0x00cc:
        r7 = r1.f13047b;
        r7 = r7.f13030j;
        r8 = com.google.android.gms.ads.internal.ax.m7466g();
        r8 = r8.b();
        if (r7 != r8) goto L_0x00ea;
    L_0x00da:
        r7 = r1.f13046a;
        r7 = r7.getResources();
        r7 = r7.getConfiguration();
        r7 = r7.orientation;
        r8 = 2;
        if (r7 != r8) goto L_0x00c9;
    L_0x00e9:
        goto L_0x00c8;
    L_0x00ea:
        r6 = r1.f13058n;
        r7 = 46;
        r8 = new java.lang.StringBuilder;
        r8.<init>(r7);
        r7 = "Delay onShow to next orientation change: ";
        r8.append(r7);
        r8.append(r6);
        r6 = r8.toString();
        com.google.android.gms.internal.ads.jn.b(r6);
        r6 = r1.f13047b;
        r6 = r6.f13030j;
        r1.m16560a(r6);
        r6 = com.google.android.gms.ads.internal.ax.m7466g();
        r2 = r6.a(r2);
        if (r2 == 0) goto L_0x0118;
    L_0x0113:
        r2 = "Hardware acceleration on the AdActivity window enabled.";
        com.google.android.gms.internal.ads.jn.b(r2);
    L_0x0118:
        r2 = r1.f13056l;
        if (r2 != 0) goto L_0x0124;
    L_0x011c:
        r2 = r1.f13057m;
        r6 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
    L_0x0120:
        r2.setBackgroundColor(r6);
        goto L_0x0129;
    L_0x0124:
        r2 = r1.f13057m;
        r6 = f13045e;
        goto L_0x0120;
    L_0x0129:
        r2 = r1.f13046a;
        r6 = r1.f13057m;
        r2.setContentView(r6);
        r1.f13062r = r3;
        if (r19 == 0) goto L_0x020a;
    L_0x0134:
        com.google.android.gms.ads.internal.ax.m7465f();	 Catch:{ Exception -> 0x01fc }
        r7 = r1.f13046a;	 Catch:{ Exception -> 0x01fc }
        r2 = r1.f13047b;	 Catch:{ Exception -> 0x01fc }
        r2 = r2.f13024d;	 Catch:{ Exception -> 0x01fc }
        if (r2 == 0) goto L_0x0149;
    L_0x013f:
        r2 = r1.f13047b;	 Catch:{ Exception -> 0x01fc }
        r2 = r2.f13024d;	 Catch:{ Exception -> 0x01fc }
        r2 = r2.t();	 Catch:{ Exception -> 0x01fc }
        r8 = r2;
        goto L_0x014a;
    L_0x0149:
        r8 = r5;
    L_0x014a:
        r2 = r1.f13047b;	 Catch:{ Exception -> 0x01fc }
        r2 = r2.f13024d;	 Catch:{ Exception -> 0x01fc }
        if (r2 == 0) goto L_0x015a;
    L_0x0150:
        r2 = r1.f13047b;	 Catch:{ Exception -> 0x01fc }
        r2 = r2.f13024d;	 Catch:{ Exception -> 0x01fc }
        r2 = r2.u();	 Catch:{ Exception -> 0x01fc }
        r9 = r2;
        goto L_0x015b;
    L_0x015a:
        r9 = r5;
    L_0x015b:
        r10 = 1;
        r12 = 0;
        r2 = r1.f13047b;	 Catch:{ Exception -> 0x01fc }
        r13 = r2.f13033m;	 Catch:{ Exception -> 0x01fc }
        r14 = 0;
        r15 = 0;
        r2 = r1.f13047b;	 Catch:{ Exception -> 0x01fc }
        r2 = r2.f13024d;	 Catch:{ Exception -> 0x01fc }
        if (r2 == 0) goto L_0x0174;
    L_0x0169:
        r2 = r1.f13047b;	 Catch:{ Exception -> 0x01fc }
        r2 = r2.f13024d;	 Catch:{ Exception -> 0x01fc }
        r2 = r2.e();	 Catch:{ Exception -> 0x01fc }
        r16 = r2;
        goto L_0x0176;
    L_0x0174:
        r16 = r5;
    L_0x0176:
        r17 = com.google.android.gms.internal.ads.amx.a();	 Catch:{ Exception -> 0x01fc }
        r11 = r4;
        r2 = com.google.android.gms.internal.ads.qv.a(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);	 Catch:{ Exception -> 0x01fc }
        r1.f13048c = r2;	 Catch:{ Exception -> 0x01fc }
        r2 = r1.f13048c;
        r6 = r2.v();
        r7 = 0;
        r2 = r1.f13047b;
        r8 = r2.f13036p;
        r9 = 0;
        r2 = r1.f13047b;
        r10 = r2.f13025e;
        r2 = r1.f13047b;
        r11 = r2.f13029i;
        r12 = 1;
        r13 = 0;
        r2 = r1.f13047b;
        r2 = r2.f13024d;
        if (r2 == 0) goto L_0x01a9;
    L_0x019d:
        r2 = r1.f13047b;
        r2 = r2.f13024d;
        r2 = r2.v();
        r5 = r2.a();
    L_0x01a9:
        r14 = r5;
        r15 = 0;
        r16 = 0;
        r6.a(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        r2 = r1.f13048c;
        r2 = r2.v();
        r5 = new com.google.android.gms.ads.internal.overlay.e;
        r5.<init>(r1);
        r2.a(r5);
        r2 = r1.f13047b;
        r2 = r2.f13032l;
        if (r2 == 0) goto L_0x01ce;
    L_0x01c4:
        r2 = r1.f13048c;
        r5 = r1.f13047b;
        r5 = r5.f13032l;
        r2.loadUrl(r5);
        goto L_0x01e6;
    L_0x01ce:
        r2 = r1.f13047b;
        r2 = r2.f13028h;
        if (r2 == 0) goto L_0x01f4;
    L_0x01d4:
        r5 = r1.f13048c;
        r2 = r1.f13047b;
        r6 = r2.f13026f;
        r2 = r1.f13047b;
        r7 = r2.f13028h;
        r8 = "text/html";
        r9 = "UTF-8";
        r10 = 0;
        r5.loadDataWithBaseURL(r6, r7, r8, r9, r10);
    L_0x01e6:
        r2 = r1.f13047b;
        r2 = r2.f13024d;
        if (r2 == 0) goto L_0x0217;
    L_0x01ec:
        r2 = r1.f13047b;
        r2 = r2.f13024d;
        r2.b(r1);
        goto L_0x0217;
    L_0x01f4:
        r0 = new com.google.android.gms.ads.internal.overlay.g;
        r2 = "No URL or HTML to display in ad overlay.";
        r0.<init>(r2);
        throw r0;
    L_0x01fc:
        r0 = move-exception;
        r2 = "Error obtaining webview.";
        com.google.android.gms.internal.ads.jn.b(r2, r0);
        r0 = new com.google.android.gms.ads.internal.overlay.g;
        r2 = "Could not obtain webview for the overlay.";
        r0.<init>(r2);
        throw r0;
    L_0x020a:
        r2 = r1.f13047b;
        r2 = r2.f13024d;
        r1.f13048c = r2;
        r2 = r1.f13048c;
        r5 = r1.f13046a;
        r2.a(r5);
    L_0x0217:
        r2 = r1.f13048c;
        r2.a(r1);
        r2 = r1.f13048c;
        r2 = r2.getParent();
        if (r2 == 0) goto L_0x0233;
    L_0x0224:
        r5 = r2 instanceof android.view.ViewGroup;
        if (r5 == 0) goto L_0x0233;
    L_0x0228:
        r2 = (android.view.ViewGroup) r2;
        r5 = r1.f13048c;
        r5 = r5.getView();
        r2.removeView(r5);
    L_0x0233:
        r2 = r1.f13056l;
        if (r2 == 0) goto L_0x023c;
    L_0x0237:
        r2 = r1.f13048c;
        r2.I();
    L_0x023c:
        r2 = r1.f13057m;
        r5 = r1.f13048c;
        r5 = r5.getView();
        r6 = -1;
        r2.addView(r5, r6, r6);
        if (r19 != 0) goto L_0x0251;
    L_0x024a:
        r0 = r1.f13058n;
        if (r0 != 0) goto L_0x0251;
    L_0x024e:
        r18.m16558s();
    L_0x0251:
        r1.m16555a(r4);
        r0 = r1.f13048c;
        r0 = r0.x();
        if (r0 == 0) goto L_0x025f;
    L_0x025c:
        r1.m16565a(r4, r3);
    L_0x025f:
        return;
    L_0x0260:
        r0 = new com.google.android.gms.ads.internal.overlay.g;
        r2 = "Invalid activity, no window available.";
        r0.<init>(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.d.b(boolean):void");
    }

    /* renamed from: r */
    private final void m16557r() {
        if (this.f13046a.isFinishing()) {
            if (!this.f13063s) {
                this.f13063s = true;
                if (this.f13048c != null) {
                    this.f13048c.a(this.f13049d);
                    synchronized (this.f13059o) {
                        if (this.f13061q || !this.f13048c.E()) {
                        } else {
                            this.f13060p = new C2658f(this);
                            jw.f15691a.postDelayed(this.f13060p, ((Long) aph.f().a(asp.aP)).longValue());
                            return;
                        }
                    }
                }
                m16579n();
            }
        }
    }

    /* renamed from: s */
    private final void m16558s() {
        this.f13048c.o();
    }

    /* renamed from: a */
    public final void m16559a() {
        this.f13049d = 2;
        this.f13046a.finish();
    }

    /* renamed from: a */
    public final void m16560a(int i) {
        if (this.f13046a.getApplicationInfo().targetSdkVersion >= ((Integer) aph.f().a(asp.dn)).intValue()) {
            if (this.f13046a.getApplicationInfo().targetSdkVersion <= ((Integer) aph.f().a(asp.f14940do)).intValue()) {
                if (VERSION.SDK_INT >= ((Integer) aph.f().a(asp.dp)).intValue()) {
                    if (VERSION.SDK_INT <= ((Integer) aph.f().a(asp.dq)).intValue()) {
                        return;
                    }
                }
            }
        }
        this.f13046a.setRequestedOrientation(i);
    }

    /* renamed from: a */
    public final void m16561a(int i, int i2, Intent intent) {
    }

    /* renamed from: a */
    public void mo3447a(Bundle bundle) {
        this.f13046a.requestWindowFeature(1);
        this.f13055k = bundle != null ? bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) : false;
        try {
            this.f13047b = AdOverlayInfoParcel.m16553a(this.f13046a.getIntent());
            if (this.f13047b != null) {
                if (this.f13047b.f13033m.f28711c > 7500000) {
                    this.f13049d = 3;
                }
                if (this.f13046a.getIntent() != null) {
                    this.f13065u = this.f13046a.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
                }
                if (this.f13047b.f13035o != null) {
                    this.f13056l = this.f13047b.f13035o.f13073a;
                } else {
                    this.f13056l = false;
                }
                if (((Boolean) aph.f().a(asp.bR)).booleanValue() && this.f13056l && this.f13047b.f13035o.f13077e != -1) {
                    new C4741j().h();
                }
                if (bundle == null) {
                    if (this.f13047b.f13023c != null && this.f13065u) {
                        this.f13047b.f13023c.v_();
                    }
                    if (!(this.f13047b.f13031k == 1 || this.f13047b.f13022b == null)) {
                        this.f13047b.f13022b.onAdClicked();
                    }
                }
                this.f13057m = new C2660h(this.f13046a, this.f13047b.f13034n, this.f13047b.f13033m.f28709a);
                this.f13057m.setId(1000);
                switch (this.f13047b.f13031k) {
                    case 1:
                        m16556b(false);
                        return;
                    case 2:
                        this.f13050f = new C2661i(this.f13047b.f13024d);
                        m16556b(false);
                        return;
                    case 3:
                        m16556b(true);
                        return;
                    default:
                        throw new C2659g("Could not determine ad overlay type.");
                }
            }
            throw new C2659g("Could not get info for ad overlay.");
        } catch (C2659g e) {
            jn.e(e.getMessage());
            this.f13049d = 3;
            this.f13046a.finish();
        }
    }

    /* renamed from: a */
    public final void m16563a(View view, CustomViewCallback customViewCallback) {
        this.f13053i = new FrameLayout(this.f13046a);
        this.f13053i.setBackgroundColor(-16777216);
        this.f13053i.addView(view, -1, -1);
        this.f13046a.setContentView(this.f13053i);
        this.f13062r = true;
        this.f13054j = customViewCallback;
        this.f13052h = true;
    }

    /* renamed from: a */
    public final void m16564a(C2758b c2758b) {
        if (((Boolean) aph.f().a(asp.cY)).booleanValue() && C2904o.m8465k()) {
            Configuration configuration = (Configuration) C4757d.m16685a(c2758b);
            ax.m7464e();
            if (jw.a(this.f13046a, configuration)) {
                this.f13046a.getWindow().addFlags(1024);
                this.f13046a.getWindow().clearFlags(2048);
                return;
            }
            this.f13046a.getWindow().addFlags(2048);
            this.f13046a.getWindow().clearFlags(1024);
        }
    }

    /* renamed from: a */
    public final void m16565a(boolean z, boolean z2) {
        boolean z3 = true;
        Object obj = (!((Boolean) aph.f().a(asp.aR)).booleanValue() || this.f13047b == null || this.f13047b.f13035o == null || !this.f13047b.f13035o.f13079g) ? null : 1;
        Object obj2 = (!((Boolean) aph.f().a(asp.aS)).booleanValue() || this.f13047b == null || this.f13047b.f13035o == null || !this.f13047b.f13035o.f13080h) ? null : 1;
        if (z && z2 && obj != null && obj2 == null) {
            new C4933n(this.f13048c, "useCustomClose").a("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        if (this.f13051g != null) {
            C2666o c2666o = this.f13051g;
            if (obj2 == null) {
                if (!z2 || obj != null) {
                    z3 = false;
                }
            }
            c2666o.m7546a(z3);
        }
    }

    /* renamed from: b */
    public final void m16566b() {
        if (this.f13047b != null && this.f13052h) {
            m16560a(this.f13047b.f13030j);
        }
        if (this.f13053i != null) {
            this.f13046a.setContentView(this.f13057m);
            this.f13062r = true;
            this.f13053i.removeAllViews();
            this.f13053i = null;
        }
        if (this.f13054j != null) {
            this.f13054j.onCustomViewHidden();
            this.f13054j = null;
        }
        this.f13052h = false;
    }

    /* renamed from: b */
    public final void m16567b(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f13055k);
    }

    /* renamed from: c */
    public final void mo3254c() {
        this.f13049d = 1;
        this.f13046a.finish();
    }

    /* renamed from: d */
    public final void m16569d() {
        this.f13049d = 0;
    }

    /* renamed from: e */
    public final boolean m16570e() {
        this.f13049d = 0;
        if (this.f13048c == null) {
            return true;
        }
        boolean C = this.f13048c.C();
        if (!C) {
            this.f13048c.a("onbackblocked", Collections.emptyMap());
        }
        return C;
    }

    /* renamed from: f */
    public final void m16571f() {
    }

    /* renamed from: g */
    public final void m16572g() {
        if (((Boolean) aph.f().a(asp.cZ)).booleanValue()) {
            if (this.f13048c == null || this.f13048c.A()) {
                jn.e("The webview does not exist. Ignoring action.");
            } else {
                ax.m7466g();
                kc.b(this.f13048c);
            }
        }
    }

    /* renamed from: h */
    public final void m16573h() {
        if (this.f13047b.f13023c != null) {
            this.f13047b.f13023c.mo3439e();
        }
        if (!((Boolean) aph.f().a(asp.cZ)).booleanValue()) {
            if (this.f13048c == null || this.f13048c.A()) {
                jn.e("The webview does not exist. Ignoring action.");
            } else {
                ax.m7466g();
                kc.b(this.f13048c);
            }
        }
    }

    /* renamed from: i */
    public final void m16574i() {
        m16566b();
        if (this.f13047b.f13023c != null) {
            this.f13047b.f13023c.mo3438d();
        }
        if (!(((Boolean) aph.f().a(asp.cZ)).booleanValue() || this.f13048c == null || (this.f13046a.isFinishing() && this.f13050f != null))) {
            ax.m7466g();
            kc.a(this.f13048c);
        }
        m16557r();
    }

    /* renamed from: j */
    public final void m16575j() {
        if (((Boolean) aph.f().a(asp.cZ)).booleanValue() && this.f13048c != null && (!this.f13046a.isFinishing() || this.f13050f == null)) {
            ax.m7466g();
            kc.a(this.f13048c);
        }
        m16557r();
    }

    /* renamed from: k */
    public final void m16576k() {
        if (this.f13048c != null) {
            this.f13057m.removeView(this.f13048c.getView());
        }
        m16557r();
    }

    /* renamed from: l */
    public final void m16577l() {
        this.f13062r = true;
    }

    /* renamed from: m */
    public final void m16578m() {
        this.f13057m.removeView(this.f13051g);
        m16555a(true);
    }

    /* renamed from: n */
    final void m16579n() {
        if (!this.f13064t) {
            this.f13064t = true;
            if (this.f13048c != null) {
                this.f13057m.removeView(this.f13048c.getView());
                if (this.f13050f != null) {
                    this.f13048c.a(this.f13050f.f6907d);
                    this.f13048c.b(false);
                    this.f13050f.f6906c.addView(this.f13048c.getView(), this.f13050f.f6904a, this.f13050f.f6905b);
                    this.f13050f = null;
                } else if (this.f13046a.getApplicationContext() != null) {
                    this.f13048c.a(this.f13046a.getApplicationContext());
                }
                this.f13048c = null;
            }
            if (!(this.f13047b == null || this.f13047b.f13023c == null)) {
                this.f13047b.f13023c.u_();
            }
        }
    }

    /* renamed from: o */
    public final void m16580o() {
        if (this.f13058n) {
            this.f13058n = false;
            m16558s();
        }
    }

    /* renamed from: p */
    public final void m16581p() {
        this.f13057m.f6902a = true;
    }

    /* renamed from: q */
    public final void m16582q() {
        synchronized (this.f13059o) {
            this.f13061q = true;
            if (this.f13060p != null) {
                jw.f15691a.removeCallbacks(this.f13060p);
                jw.f15691a.post(this.f13060p);
            }
        }
    }
}
