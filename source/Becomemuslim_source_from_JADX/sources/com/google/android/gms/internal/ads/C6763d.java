package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.util.C2896f;
import java.util.Set;

@cm
/* renamed from: com.google.android.gms.internal.ads.d */
public final class C6763d extends C4933n {
    /* renamed from: a */
    private static final Set<String> f24042a = C2896f.b(new String[]{"top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"});
    /* renamed from: b */
    private String f24043b = "top-right";
    /* renamed from: c */
    private boolean f24044c = true;
    /* renamed from: d */
    private int f24045d = 0;
    /* renamed from: e */
    private int f24046e = 0;
    /* renamed from: f */
    private int f24047f = -1;
    /* renamed from: g */
    private int f24048g = 0;
    /* renamed from: h */
    private int f24049h = 0;
    /* renamed from: i */
    private int f24050i = -1;
    /* renamed from: j */
    private final Object f24051j = new Object();
    /* renamed from: k */
    private final qo f24052k;
    /* renamed from: l */
    private final Activity f24053l;
    /* renamed from: m */
    private sc f24054m;
    /* renamed from: n */
    private ImageView f24055n;
    /* renamed from: o */
    private LinearLayout f24056o;
    /* renamed from: p */
    private C4934o f24057p;
    /* renamed from: q */
    private PopupWindow f24058q;
    /* renamed from: r */
    private RelativeLayout f24059r;
    /* renamed from: s */
    private ViewGroup f24060s;

    public C6763d(qo qoVar, C4934o c4934o) {
        super(qoVar, "resize");
        this.f24052k = qoVar;
        this.f24053l = qoVar.mo6128d();
        this.f24057p = c4934o;
    }

    /* renamed from: b */
    private final void m30687b(int i, int i2) {
        m19928a(i, i2 - ax.e().m19749c(this.f24053l)[0], this.f24050i, this.f24047f);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private final int[] m30688b() {
        /*
        r9 = this;
        r0 = com.google.android.gms.ads.internal.ax.e();
        r1 = r9.f24053l;
        r0 = r0.m19747b(r1);
        r1 = com.google.android.gms.ads.internal.ax.e();
        r2 = r9.f24053l;
        r1 = r1.m19749c(r2);
        r2 = 0;
        r3 = r0[r2];
        r4 = 1;
        r0 = r0[r4];
        r5 = r9.f24050i;
        r6 = 2;
        r7 = 50;
        if (r5 < r7) goto L_0x00fd;
    L_0x0021:
        r5 = r9.f24050i;
        if (r5 <= r3) goto L_0x0027;
    L_0x0025:
        goto L_0x00fd;
    L_0x0027:
        r5 = r9.f24047f;
        if (r5 < r7) goto L_0x00fa;
    L_0x002b:
        r5 = r9.f24047f;
        if (r5 <= r0) goto L_0x0031;
    L_0x002f:
        goto L_0x00fa;
    L_0x0031:
        r5 = r9.f24047f;
        if (r5 != r0) goto L_0x003d;
    L_0x0035:
        r0 = r9.f24050i;
        if (r0 != r3) goto L_0x003d;
    L_0x0039:
        r0 = "Cannot resize to a full-screen ad.";
        goto L_0x00ff;
    L_0x003d:
        r0 = r9.f24044c;
        if (r0 == 0) goto L_0x00f8;
    L_0x0041:
        r0 = r9.f24043b;
        r5 = -1;
        r8 = r0.hashCode();
        switch(r8) {
            case -1364013995: goto L_0x007e;
            case -1012429441: goto L_0x0074;
            case -655373719: goto L_0x006a;
            case 1163912186: goto L_0x0060;
            case 1288627767: goto L_0x0056;
            case 1755462605: goto L_0x004c;
            default: goto L_0x004b;
        };
    L_0x004b:
        goto L_0x0088;
    L_0x004c:
        r8 = "top-center";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x0088;
    L_0x0054:
        r0 = 1;
        goto L_0x0089;
    L_0x0056:
        r8 = "bottom-center";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x0088;
    L_0x005e:
        r0 = 4;
        goto L_0x0089;
    L_0x0060:
        r8 = "bottom-right";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x0088;
    L_0x0068:
        r0 = 5;
        goto L_0x0089;
    L_0x006a:
        r8 = "bottom-left";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x0088;
    L_0x0072:
        r0 = 3;
        goto L_0x0089;
    L_0x0074:
        r8 = "top-left";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x0088;
    L_0x007c:
        r0 = 0;
        goto L_0x0089;
    L_0x007e:
        r8 = "center";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x0088;
    L_0x0086:
        r0 = 2;
        goto L_0x0089;
    L_0x0088:
        r0 = -1;
    L_0x0089:
        switch(r0) {
            case 0: goto L_0x00e3;
            case 1: goto L_0x00d7;
            case 2: goto L_0x00c0;
            case 3: goto L_0x00b1;
            case 4: goto L_0x00a5;
            case 5: goto L_0x009b;
            default: goto L_0x008c;
        };
    L_0x008c:
        r0 = r9.f24045d;
        r5 = r9.f24048g;
        r0 = r0 + r5;
        r5 = r9.f24050i;
        r0 = r0 + r5;
        r0 = r0 - r7;
    L_0x0095:
        r5 = r9.f24046e;
        r8 = r9.f24049h;
        r5 = r5 + r8;
        goto L_0x00e9;
    L_0x009b:
        r0 = r9.f24045d;
        r5 = r9.f24048g;
        r0 = r0 + r5;
        r5 = r9.f24050i;
        r0 = r0 + r5;
        r0 = r0 - r7;
        goto L_0x00b6;
    L_0x00a5:
        r0 = r9.f24045d;
        r5 = r9.f24048g;
        r0 = r0 + r5;
        r5 = r9.f24050i;
        r5 = r5 / r6;
        r0 = r0 + r5;
        r0 = r0 + -25;
        goto L_0x00b6;
    L_0x00b1:
        r0 = r9.f24045d;
        r5 = r9.f24048g;
        r0 = r0 + r5;
    L_0x00b6:
        r5 = r9.f24046e;
        r8 = r9.f24049h;
        r5 = r5 + r8;
        r8 = r9.f24047f;
        r5 = r5 + r8;
        r5 = r5 - r7;
        goto L_0x00e9;
    L_0x00c0:
        r0 = r9.f24045d;
        r5 = r9.f24048g;
        r0 = r0 + r5;
        r5 = r9.f24050i;
        r5 = r5 / r6;
        r0 = r0 + r5;
        r0 = r0 + -25;
        r5 = r9.f24046e;
        r8 = r9.f24049h;
        r5 = r5 + r8;
        r8 = r9.f24047f;
        r8 = r8 / r6;
        r5 = r5 + r8;
        r5 = r5 + -25;
        goto L_0x00e9;
    L_0x00d7:
        r0 = r9.f24045d;
        r5 = r9.f24048g;
        r0 = r0 + r5;
        r5 = r9.f24050i;
        r5 = r5 / r6;
        r0 = r0 + r5;
        r0 = r0 + -25;
        goto L_0x0095;
    L_0x00e3:
        r0 = r9.f24045d;
        r5 = r9.f24048g;
        r0 = r0 + r5;
        goto L_0x0095;
    L_0x00e9:
        if (r0 < 0) goto L_0x0102;
    L_0x00eb:
        r0 = r0 + r7;
        if (r0 > r3) goto L_0x0102;
    L_0x00ee:
        r0 = r1[r2];
        if (r5 < r0) goto L_0x0102;
    L_0x00f2:
        r5 = r5 + r7;
        r0 = r1[r4];
        if (r5 <= r0) goto L_0x00f8;
    L_0x00f7:
        goto L_0x0102;
    L_0x00f8:
        r0 = 1;
        goto L_0x0103;
    L_0x00fa:
        r0 = "Height is too small or too large.";
        goto L_0x00ff;
    L_0x00fd:
        r0 = "Width is too small or too large.";
    L_0x00ff:
        com.google.android.gms.internal.ads.mt.m19924e(r0);
    L_0x0102:
        r0 = 0;
    L_0x0103:
        if (r0 != 0) goto L_0x0107;
    L_0x0105:
        r0 = 0;
        return r0;
    L_0x0107:
        r0 = r9.f24044c;
        if (r0 == 0) goto L_0x011c;
    L_0x010b:
        r0 = new int[r6];
        r1 = r9.f24045d;
        r3 = r9.f24048g;
        r1 = r1 + r3;
        r0[r2] = r1;
        r1 = r9.f24046e;
        r2 = r9.f24049h;
        r1 = r1 + r2;
        r0[r4] = r1;
        return r0;
    L_0x011c:
        r0 = com.google.android.gms.ads.internal.ax.e();
        r1 = r9.f24053l;
        r0 = r0.m19747b(r1);
        r1 = com.google.android.gms.ads.internal.ax.e();
        r3 = r9.f24053l;
        r1 = r1.m19749c(r3);
        r0 = r0[r2];
        r3 = r9.f24045d;
        r5 = r9.f24048g;
        r3 = r3 + r5;
        r5 = r9.f24046e;
        r7 = r9.f24049h;
        r5 = r5 + r7;
        if (r3 >= 0) goto L_0x0140;
    L_0x013e:
        r0 = 0;
        goto L_0x014a;
    L_0x0140:
        r7 = r9.f24050i;
        r7 = r7 + r3;
        if (r7 <= r0) goto L_0x0149;
    L_0x0145:
        r3 = r9.f24050i;
        r0 = r0 - r3;
        goto L_0x014a;
    L_0x0149:
        r0 = r3;
    L_0x014a:
        r3 = r1[r2];
        if (r5 >= r3) goto L_0x0151;
    L_0x014e:
        r5 = r1[r2];
        goto L_0x015e;
    L_0x0151:
        r3 = r9.f24047f;
        r3 = r3 + r5;
        r7 = r1[r4];
        if (r3 <= r7) goto L_0x015e;
    L_0x0158:
        r1 = r1[r4];
        r3 = r9.f24047f;
        r5 = r1 - r3;
    L_0x015e:
        r1 = new int[r6];
        r1[r2] = r0;
        r1[r4] = r5;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.d.b():int[]");
    }

    /* renamed from: a */
    public final void m30689a(int i, int i2) {
        this.f24045d = i;
        this.f24046e = i2;
    }

    /* renamed from: a */
    public final void m30690a(int i, int i2, boolean z) {
        synchronized (this.f24051j) {
            this.f24045d = i;
            this.f24046e = i2;
            if (this.f24058q != null && z) {
                int[] b = m30688b();
                if (b != null) {
                    PopupWindow popupWindow = this.f24058q;
                    aph.m18683a();
                    int a = mi.m19864a(this.f24053l, b[0]);
                    aph.m18683a();
                    popupWindow.update(a, mi.m19864a(this.f24053l, b[1]), this.f24058q.getWidth(), this.f24058q.getHeight());
                    m30687b(b[0], b[1]);
                } else {
                    m30692a(true);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void m30691a(java.util.Map<java.lang.String, java.lang.String> r14) {
        /*
        r13 = this;
        r0 = r13.f24051j;
        monitor-enter(r0);
        r1 = r13.f24053l;	 Catch:{ all -> 0x0317 }
        if (r1 != 0) goto L_0x000e;
    L_0x0007:
        r14 = "Not an activity context. Cannot resize.";
        r13.m19930a(r14);	 Catch:{ all -> 0x0317 }
        monitor-exit(r0);	 Catch:{ all -> 0x0317 }
        return;
    L_0x000e:
        r1 = r13.f24052k;	 Catch:{ all -> 0x0317 }
        r1 = r1.mo6135t();	 Catch:{ all -> 0x0317 }
        if (r1 != 0) goto L_0x001d;
    L_0x0016:
        r14 = "Webview is not yet available, size is not set.";
        r13.m19930a(r14);	 Catch:{ all -> 0x0317 }
        monitor-exit(r0);	 Catch:{ all -> 0x0317 }
        return;
    L_0x001d:
        r1 = r13.f24052k;	 Catch:{ all -> 0x0317 }
        r1 = r1.mo6135t();	 Catch:{ all -> 0x0317 }
        r1 = r1.m20093d();	 Catch:{ all -> 0x0317 }
        if (r1 == 0) goto L_0x0030;
    L_0x0029:
        r14 = "Is interstitial. Cannot resize an interstitial.";
        r13.m19930a(r14);	 Catch:{ all -> 0x0317 }
        monitor-exit(r0);	 Catch:{ all -> 0x0317 }
        return;
    L_0x0030:
        r1 = r13.f24052k;	 Catch:{ all -> 0x0317 }
        r1 = r1.mo6137z();	 Catch:{ all -> 0x0317 }
        if (r1 == 0) goto L_0x003f;
    L_0x0038:
        r14 = "Cannot resize an expanded banner.";
        r13.m19930a(r14);	 Catch:{ all -> 0x0317 }
        monitor-exit(r0);	 Catch:{ all -> 0x0317 }
        return;
    L_0x003f:
        r1 = "width";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0317 }
        r1 = (java.lang.CharSequence) r1;	 Catch:{ all -> 0x0317 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0317 }
        if (r1 != 0) goto L_0x005e;
    L_0x004d:
        com.google.android.gms.ads.internal.ax.e();	 Catch:{ all -> 0x0317 }
        r1 = "width";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0317 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0317 }
        r1 = com.google.android.gms.internal.ads.jw.m19711b(r1);	 Catch:{ all -> 0x0317 }
        r13.f24050i = r1;	 Catch:{ all -> 0x0317 }
    L_0x005e:
        r1 = "height";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0317 }
        r1 = (java.lang.CharSequence) r1;	 Catch:{ all -> 0x0317 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0317 }
        if (r1 != 0) goto L_0x007d;
    L_0x006c:
        com.google.android.gms.ads.internal.ax.e();	 Catch:{ all -> 0x0317 }
        r1 = "height";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0317 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0317 }
        r1 = com.google.android.gms.internal.ads.jw.m19711b(r1);	 Catch:{ all -> 0x0317 }
        r13.f24047f = r1;	 Catch:{ all -> 0x0317 }
    L_0x007d:
        r1 = "offsetX";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0317 }
        r1 = (java.lang.CharSequence) r1;	 Catch:{ all -> 0x0317 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0317 }
        if (r1 != 0) goto L_0x009c;
    L_0x008b:
        com.google.android.gms.ads.internal.ax.e();	 Catch:{ all -> 0x0317 }
        r1 = "offsetX";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0317 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0317 }
        r1 = com.google.android.gms.internal.ads.jw.m19711b(r1);	 Catch:{ all -> 0x0317 }
        r13.f24048g = r1;	 Catch:{ all -> 0x0317 }
    L_0x009c:
        r1 = "offsetY";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0317 }
        r1 = (java.lang.CharSequence) r1;	 Catch:{ all -> 0x0317 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0317 }
        if (r1 != 0) goto L_0x00bb;
    L_0x00aa:
        com.google.android.gms.ads.internal.ax.e();	 Catch:{ all -> 0x0317 }
        r1 = "offsetY";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0317 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0317 }
        r1 = com.google.android.gms.internal.ads.jw.m19711b(r1);	 Catch:{ all -> 0x0317 }
        r13.f24049h = r1;	 Catch:{ all -> 0x0317 }
    L_0x00bb:
        r1 = "allowOffscreen";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0317 }
        r1 = (java.lang.CharSequence) r1;	 Catch:{ all -> 0x0317 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0317 }
        if (r1 != 0) goto L_0x00d7;
    L_0x00c9:
        r1 = "allowOffscreen";
        r1 = r14.get(r1);	 Catch:{ all -> 0x0317 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0317 }
        r1 = java.lang.Boolean.parseBoolean(r1);	 Catch:{ all -> 0x0317 }
        r13.f24044c = r1;	 Catch:{ all -> 0x0317 }
    L_0x00d7:
        r1 = "customClosePosition";
        r14 = r14.get(r1);	 Catch:{ all -> 0x0317 }
        r14 = (java.lang.String) r14;	 Catch:{ all -> 0x0317 }
        r1 = android.text.TextUtils.isEmpty(r14);	 Catch:{ all -> 0x0317 }
        if (r1 != 0) goto L_0x00e7;
    L_0x00e5:
        r13.f24043b = r14;	 Catch:{ all -> 0x0317 }
    L_0x00e7:
        r14 = r13.f24050i;	 Catch:{ all -> 0x0317 }
        r1 = 1;
        r2 = 0;
        if (r14 < 0) goto L_0x00f3;
    L_0x00ed:
        r14 = r13.f24047f;	 Catch:{ all -> 0x0317 }
        if (r14 < 0) goto L_0x00f3;
    L_0x00f1:
        r14 = 1;
        goto L_0x00f4;
    L_0x00f3:
        r14 = 0;
    L_0x00f4:
        if (r14 != 0) goto L_0x00fd;
    L_0x00f6:
        r14 = "Invalid width and height options. Cannot resize.";
        r13.m19930a(r14);	 Catch:{ all -> 0x0317 }
        monitor-exit(r0);	 Catch:{ all -> 0x0317 }
        return;
    L_0x00fd:
        r14 = r13.f24053l;	 Catch:{ all -> 0x0317 }
        r14 = r14.getWindow();	 Catch:{ all -> 0x0317 }
        if (r14 == 0) goto L_0x0310;
    L_0x0105:
        r3 = r14.getDecorView();	 Catch:{ all -> 0x0317 }
        if (r3 != 0) goto L_0x010d;
    L_0x010b:
        goto L_0x0310;
    L_0x010d:
        r3 = r13.m30688b();	 Catch:{ all -> 0x0317 }
        if (r3 != 0) goto L_0x011a;
    L_0x0113:
        r14 = "Resize location out of screen or close button is not visible.";
        r13.m19930a(r14);	 Catch:{ all -> 0x0317 }
        monitor-exit(r0);	 Catch:{ all -> 0x0317 }
        return;
    L_0x011a:
        com.google.android.gms.internal.ads.aph.m18683a();	 Catch:{ all -> 0x0317 }
        r4 = r13.f24053l;	 Catch:{ all -> 0x0317 }
        r5 = r13.f24050i;	 Catch:{ all -> 0x0317 }
        r4 = com.google.android.gms.internal.ads.mi.m19864a(r4, r5);	 Catch:{ all -> 0x0317 }
        com.google.android.gms.internal.ads.aph.m18683a();	 Catch:{ all -> 0x0317 }
        r5 = r13.f24053l;	 Catch:{ all -> 0x0317 }
        r6 = r13.f24047f;	 Catch:{ all -> 0x0317 }
        r5 = com.google.android.gms.internal.ads.mi.m19864a(r5, r6);	 Catch:{ all -> 0x0317 }
        r6 = r13.f24052k;	 Catch:{ all -> 0x0317 }
        r6 = r6.getView();	 Catch:{ all -> 0x0317 }
        r6 = r6.getParent();	 Catch:{ all -> 0x0317 }
        if (r6 == 0) goto L_0x0309;
    L_0x013c:
        r7 = r6 instanceof android.view.ViewGroup;	 Catch:{ all -> 0x0317 }
        if (r7 == 0) goto L_0x0309;
    L_0x0140:
        r7 = r6;
        r7 = (android.view.ViewGroup) r7;	 Catch:{ all -> 0x0317 }
        r8 = r13.f24052k;	 Catch:{ all -> 0x0317 }
        r8 = r8.getView();	 Catch:{ all -> 0x0317 }
        r7.removeView(r8);	 Catch:{ all -> 0x0317 }
        r7 = r13.f24058q;	 Catch:{ all -> 0x0317 }
        if (r7 != 0) goto L_0x017f;
    L_0x0150:
        r6 = (android.view.ViewGroup) r6;	 Catch:{ all -> 0x0317 }
        r13.f24060s = r6;	 Catch:{ all -> 0x0317 }
        com.google.android.gms.ads.internal.ax.e();	 Catch:{ all -> 0x0317 }
        r6 = r13.f24052k;	 Catch:{ all -> 0x0317 }
        r6 = r6.getView();	 Catch:{ all -> 0x0317 }
        r6 = com.google.android.gms.internal.ads.jw.m19682a(r6);	 Catch:{ all -> 0x0317 }
        r7 = new android.widget.ImageView;	 Catch:{ all -> 0x0317 }
        r8 = r13.f24053l;	 Catch:{ all -> 0x0317 }
        r7.<init>(r8);	 Catch:{ all -> 0x0317 }
        r13.f24055n = r7;	 Catch:{ all -> 0x0317 }
        r7 = r13.f24055n;	 Catch:{ all -> 0x0317 }
        r7.setImageBitmap(r6);	 Catch:{ all -> 0x0317 }
        r6 = r13.f24052k;	 Catch:{ all -> 0x0317 }
        r6 = r6.mo6135t();	 Catch:{ all -> 0x0317 }
        r13.f24054m = r6;	 Catch:{ all -> 0x0317 }
        r6 = r13.f24060s;	 Catch:{ all -> 0x0317 }
        r7 = r13.f24055n;	 Catch:{ all -> 0x0317 }
        r6.addView(r7);	 Catch:{ all -> 0x0317 }
        goto L_0x0184;
    L_0x017f:
        r6 = r13.f24058q;	 Catch:{ all -> 0x0317 }
        r6.dismiss();	 Catch:{ all -> 0x0317 }
    L_0x0184:
        r6 = new android.widget.RelativeLayout;	 Catch:{ all -> 0x0317 }
        r7 = r13.f24053l;	 Catch:{ all -> 0x0317 }
        r6.<init>(r7);	 Catch:{ all -> 0x0317 }
        r13.f24059r = r6;	 Catch:{ all -> 0x0317 }
        r6 = r13.f24059r;	 Catch:{ all -> 0x0317 }
        r6.setBackgroundColor(r2);	 Catch:{ all -> 0x0317 }
        r6 = r13.f24059r;	 Catch:{ all -> 0x0317 }
        r7 = new android.view.ViewGroup$LayoutParams;	 Catch:{ all -> 0x0317 }
        r7.<init>(r4, r5);	 Catch:{ all -> 0x0317 }
        r6.setLayoutParams(r7);	 Catch:{ all -> 0x0317 }
        com.google.android.gms.ads.internal.ax.e();	 Catch:{ all -> 0x0317 }
        r6 = r13.f24059r;	 Catch:{ all -> 0x0317 }
        r6 = com.google.android.gms.internal.ads.jw.m19686a(r6, r4, r5, r2);	 Catch:{ all -> 0x0317 }
        r13.f24058q = r6;	 Catch:{ all -> 0x0317 }
        r6 = r13.f24058q;	 Catch:{ all -> 0x0317 }
        r6.setOutsideTouchable(r1);	 Catch:{ all -> 0x0317 }
        r6 = r13.f24058q;	 Catch:{ all -> 0x0317 }
        r6.setTouchable(r1);	 Catch:{ all -> 0x0317 }
        r6 = r13.f24058q;	 Catch:{ all -> 0x0317 }
        r7 = r13.f24044c;	 Catch:{ all -> 0x0317 }
        r7 = r7 ^ r1;
        r6.setClippingEnabled(r7);	 Catch:{ all -> 0x0317 }
        r6 = r13.f24059r;	 Catch:{ all -> 0x0317 }
        r7 = r13.f24052k;	 Catch:{ all -> 0x0317 }
        r7 = r7.getView();	 Catch:{ all -> 0x0317 }
        r8 = -1;
        r6.addView(r7, r8, r8);	 Catch:{ all -> 0x0317 }
        r6 = new android.widget.LinearLayout;	 Catch:{ all -> 0x0317 }
        r7 = r13.f24053l;	 Catch:{ all -> 0x0317 }
        r6.<init>(r7);	 Catch:{ all -> 0x0317 }
        r13.f24056o = r6;	 Catch:{ all -> 0x0317 }
        r6 = new android.widget.RelativeLayout$LayoutParams;	 Catch:{ all -> 0x0317 }
        com.google.android.gms.internal.ads.aph.m18683a();	 Catch:{ all -> 0x0317 }
        r7 = r13.f24053l;	 Catch:{ all -> 0x0317 }
        r9 = 50;
        r7 = com.google.android.gms.internal.ads.mi.m19864a(r7, r9);	 Catch:{ all -> 0x0317 }
        com.google.android.gms.internal.ads.aph.m18683a();	 Catch:{ all -> 0x0317 }
        r10 = r13.f24053l;	 Catch:{ all -> 0x0317 }
        r9 = com.google.android.gms.internal.ads.mi.m19864a(r10, r9);	 Catch:{ all -> 0x0317 }
        r6.<init>(r7, r9);	 Catch:{ all -> 0x0317 }
        r7 = r13.f24043b;	 Catch:{ all -> 0x0317 }
        r9 = r7.hashCode();	 Catch:{ all -> 0x0317 }
        switch(r9) {
            case -1364013995: goto L_0x0223;
            case -1012429441: goto L_0x0219;
            case -655373719: goto L_0x020f;
            case 1163912186: goto L_0x0205;
            case 1288627767: goto L_0x01fb;
            case 1755462605: goto L_0x01f1;
            default: goto L_0x01f0;
        };	 Catch:{ all -> 0x0317 }
    L_0x01f0:
        goto L_0x022d;
    L_0x01f1:
        r9 = "top-center";
        r7 = r7.equals(r9);	 Catch:{ all -> 0x0317 }
        if (r7 == 0) goto L_0x022d;
    L_0x01f9:
        r7 = 1;
        goto L_0x022e;
    L_0x01fb:
        r9 = "bottom-center";
        r7 = r7.equals(r9);	 Catch:{ all -> 0x0317 }
        if (r7 == 0) goto L_0x022d;
    L_0x0203:
        r7 = 4;
        goto L_0x022e;
    L_0x0205:
        r9 = "bottom-right";
        r7 = r7.equals(r9);	 Catch:{ all -> 0x0317 }
        if (r7 == 0) goto L_0x022d;
    L_0x020d:
        r7 = 5;
        goto L_0x022e;
    L_0x020f:
        r9 = "bottom-left";
        r7 = r7.equals(r9);	 Catch:{ all -> 0x0317 }
        if (r7 == 0) goto L_0x022d;
    L_0x0217:
        r7 = 3;
        goto L_0x022e;
    L_0x0219:
        r9 = "top-left";
        r7 = r7.equals(r9);	 Catch:{ all -> 0x0317 }
        if (r7 == 0) goto L_0x022d;
    L_0x0221:
        r7 = 0;
        goto L_0x022e;
    L_0x0223:
        r9 = "center";
        r7 = r7.equals(r9);	 Catch:{ all -> 0x0317 }
        if (r7 == 0) goto L_0x022d;
    L_0x022b:
        r7 = 2;
        goto L_0x022e;
    L_0x022d:
        r7 = -1;
    L_0x022e:
        r8 = 14;
        r9 = 9;
        r10 = 11;
        r11 = 12;
        r12 = 10;
        switch(r7) {
            case 0: goto L_0x025e;
            case 1: goto L_0x025a;
            case 2: goto L_0x0254;
            case 3: goto L_0x024d;
            case 4: goto L_0x0246;
            case 5: goto L_0x023f;
            default: goto L_0x023b;
        };	 Catch:{ all -> 0x0317 }
    L_0x023b:
        r6.addRule(r12);	 Catch:{ all -> 0x0317 }
        goto L_0x0242;
    L_0x023f:
        r6.addRule(r11);	 Catch:{ all -> 0x0317 }
    L_0x0242:
        r6.addRule(r10);	 Catch:{ all -> 0x0317 }
        goto L_0x0262;
    L_0x0246:
        r6.addRule(r11);	 Catch:{ all -> 0x0317 }
    L_0x0249:
        r6.addRule(r8);	 Catch:{ all -> 0x0317 }
        goto L_0x0262;
    L_0x024d:
        r6.addRule(r11);	 Catch:{ all -> 0x0317 }
    L_0x0250:
        r6.addRule(r9);	 Catch:{ all -> 0x0317 }
        goto L_0x0262;
    L_0x0254:
        r7 = 13;
        r6.addRule(r7);	 Catch:{ all -> 0x0317 }
        goto L_0x0262;
    L_0x025a:
        r6.addRule(r12);	 Catch:{ all -> 0x0317 }
        goto L_0x0249;
    L_0x025e:
        r6.addRule(r12);	 Catch:{ all -> 0x0317 }
        goto L_0x0250;
    L_0x0262:
        r7 = r13.f24056o;	 Catch:{ all -> 0x0317 }
        r8 = new com.google.android.gms.internal.ads.e;	 Catch:{ all -> 0x0317 }
        r8.<init>(r13);	 Catch:{ all -> 0x0317 }
        r7.setOnClickListener(r8);	 Catch:{ all -> 0x0317 }
        r7 = r13.f24056o;	 Catch:{ all -> 0x0317 }
        r8 = "Close button";
        r7.setContentDescription(r8);	 Catch:{ all -> 0x0317 }
        r7 = r13.f24059r;	 Catch:{ all -> 0x0317 }
        r8 = r13.f24056o;	 Catch:{ all -> 0x0317 }
        r7.addView(r8, r6);	 Catch:{ all -> 0x0317 }
        r6 = r13.f24058q;	 Catch:{ RuntimeException -> 0x02c1 }
        r14 = r14.getDecorView();	 Catch:{ RuntimeException -> 0x02c1 }
        com.google.android.gms.internal.ads.aph.m18683a();	 Catch:{ RuntimeException -> 0x02c1 }
        r7 = r13.f24053l;	 Catch:{ RuntimeException -> 0x02c1 }
        r8 = r3[r2];	 Catch:{ RuntimeException -> 0x02c1 }
        r7 = com.google.android.gms.internal.ads.mi.m19864a(r7, r8);	 Catch:{ RuntimeException -> 0x02c1 }
        com.google.android.gms.internal.ads.aph.m18683a();	 Catch:{ RuntimeException -> 0x02c1 }
        r8 = r13.f24053l;	 Catch:{ RuntimeException -> 0x02c1 }
        r9 = r3[r1];	 Catch:{ RuntimeException -> 0x02c1 }
        r8 = com.google.android.gms.internal.ads.mi.m19864a(r8, r9);	 Catch:{ RuntimeException -> 0x02c1 }
        r6.showAtLocation(r14, r2, r7, r8);	 Catch:{ RuntimeException -> 0x02c1 }
        r14 = r3[r2];	 Catch:{ all -> 0x0317 }
        r6 = r3[r1];	 Catch:{ all -> 0x0317 }
        r7 = r13.f24057p;	 Catch:{ all -> 0x0317 }
        if (r7 == 0) goto L_0x02aa;
    L_0x02a1:
        r7 = r13.f24057p;	 Catch:{ all -> 0x0317 }
        r8 = r13.f24050i;	 Catch:{ all -> 0x0317 }
        r9 = r13.f24047f;	 Catch:{ all -> 0x0317 }
        r7.m19959a(r14, r6, r8, r9);	 Catch:{ all -> 0x0317 }
    L_0x02aa:
        r14 = r13.f24052k;	 Catch:{ all -> 0x0317 }
        r4 = com.google.android.gms.internal.ads.sc.m20089a(r4, r5);	 Catch:{ all -> 0x0317 }
        r14.mo6676a(r4);	 Catch:{ all -> 0x0317 }
        r14 = r3[r2];	 Catch:{ all -> 0x0317 }
        r1 = r3[r1];	 Catch:{ all -> 0x0317 }
        r13.m30687b(r14, r1);	 Catch:{ all -> 0x0317 }
        r14 = "resized";
        r13.m19933c(r14);	 Catch:{ all -> 0x0317 }
        monitor-exit(r0);	 Catch:{ all -> 0x0317 }
        return;
    L_0x02c1:
        r14 = move-exception;
        r1 = "Cannot show popup window: ";
        r14 = r14.getMessage();	 Catch:{ all -> 0x0317 }
        r14 = java.lang.String.valueOf(r14);	 Catch:{ all -> 0x0317 }
        r2 = r14.length();	 Catch:{ all -> 0x0317 }
        if (r2 == 0) goto L_0x02d7;
    L_0x02d2:
        r14 = r1.concat(r14);	 Catch:{ all -> 0x0317 }
        goto L_0x02dc;
    L_0x02d7:
        r14 = new java.lang.String;	 Catch:{ all -> 0x0317 }
        r14.<init>(r1);	 Catch:{ all -> 0x0317 }
    L_0x02dc:
        r13.m19930a(r14);	 Catch:{ all -> 0x0317 }
        r14 = r13.f24059r;	 Catch:{ all -> 0x0317 }
        r1 = r13.f24052k;	 Catch:{ all -> 0x0317 }
        r1 = r1.getView();	 Catch:{ all -> 0x0317 }
        r14.removeView(r1);	 Catch:{ all -> 0x0317 }
        r14 = r13.f24060s;	 Catch:{ all -> 0x0317 }
        if (r14 == 0) goto L_0x0307;
    L_0x02ee:
        r14 = r13.f24060s;	 Catch:{ all -> 0x0317 }
        r1 = r13.f24055n;	 Catch:{ all -> 0x0317 }
        r14.removeView(r1);	 Catch:{ all -> 0x0317 }
        r14 = r13.f24060s;	 Catch:{ all -> 0x0317 }
        r1 = r13.f24052k;	 Catch:{ all -> 0x0317 }
        r1 = r1.getView();	 Catch:{ all -> 0x0317 }
        r14.addView(r1);	 Catch:{ all -> 0x0317 }
        r14 = r13.f24052k;	 Catch:{ all -> 0x0317 }
        r1 = r13.f24054m;	 Catch:{ all -> 0x0317 }
        r14.mo6676a(r1);	 Catch:{ all -> 0x0317 }
    L_0x0307:
        monitor-exit(r0);	 Catch:{ all -> 0x0317 }
        return;
    L_0x0309:
        r14 = "Webview is detached, probably in the middle of a resize or expand.";
        r13.m19930a(r14);	 Catch:{ all -> 0x0317 }
        monitor-exit(r0);	 Catch:{ all -> 0x0317 }
        return;
    L_0x0310:
        r14 = "Activity context is not ready, cannot get window or decor view.";
        r13.m19930a(r14);	 Catch:{ all -> 0x0317 }
        monitor-exit(r0);	 Catch:{ all -> 0x0317 }
        return;
    L_0x0317:
        r14 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0317 }
        throw r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.d.a(java.util.Map):void");
    }

    /* renamed from: a */
    public final void m30692a(boolean z) {
        synchronized (this.f24051j) {
            if (this.f24058q != null) {
                this.f24058q.dismiss();
                this.f24059r.removeView(this.f24052k.getView());
                if (this.f24060s != null) {
                    this.f24060s.removeView(this.f24055n);
                    this.f24060s.addView(this.f24052k.getView());
                    this.f24052k.mo6676a(this.f24054m);
                }
                if (z) {
                    m19933c("default");
                    if (this.f24057p != null) {
                        this.f24057p.m19958M();
                    }
                }
                this.f24058q = null;
                this.f24059r = null;
                this.f24060s = null;
                this.f24056o = null;
            }
        }
    }

    /* renamed from: a */
    public final boolean m30693a() {
        boolean z;
        synchronized (this.f24051j) {
            z = this.f24058q != null;
        }
        return z;
    }
}
