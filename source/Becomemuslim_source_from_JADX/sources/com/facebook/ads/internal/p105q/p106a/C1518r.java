package com.facebook.ads.internal.p105q.p106a;

import android.os.Handler;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

/* renamed from: com.facebook.ads.internal.q.a.r */
public class C1518r implements OnSystemUiVisibilityChangeListener {
    /* renamed from: a */
    private final View f4478a;
    /* renamed from: b */
    private int f4479b;
    /* renamed from: c */
    private Window f4480c;
    /* renamed from: d */
    private C1517a f4481d = C1517a.DEFAULT;
    /* renamed from: e */
    private final Runnable f4482e = new C15151(this);

    /* renamed from: com.facebook.ads.internal.q.a.r$1 */
    class C15151 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1518r f4473a;

        C15151(C1518r c1518r) {
            this.f4473a = c1518r;
        }

        public void run() {
            this.f4473a.m5323a(false);
        }
    }

    /* renamed from: com.facebook.ads.internal.q.a.r$2 */
    static /* synthetic */ class C15162 {
        /* renamed from: a */
        static final /* synthetic */ int[] f4474a = new int[C1517a.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r0 = com.facebook.ads.internal.p105q.p106a.C1518r.C1517a.values();
            r0 = r0.length;
            r0 = new int[r0];
            f4474a = r0;
            r0 = f4474a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.facebook.ads.internal.p105q.p106a.C1518r.C1517a.FULL_SCREEN;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.q.a.r.2.<clinit>():void");
        }
    }

    /* renamed from: com.facebook.ads.internal.q.a.r$a */
    public enum C1517a {
        DEFAULT,
        FULL_SCREEN
    }

    public C1518r(View view) {
        this.f4478a = view;
        this.f4478a.setOnSystemUiVisibilityChangeListener(this);
    }

    /* renamed from: a */
    private void m5321a(int i, boolean z) {
        if (this.f4480c != null) {
            LayoutParams attributes = this.f4480c.getAttributes();
            if (z) {
                i |= attributes.flags;
            } else {
                i = (~i) & attributes.flags;
            }
            attributes.flags = i;
            this.f4480c.setAttributes(attributes);
        }
    }

    /* renamed from: a */
    private void m5323a(boolean z) {
        if (!C1517a.DEFAULT.equals(this.f4481d)) {
            int i = 3840;
            if (!z) {
                i = 3847;
            }
            Handler handler = this.f4478a.getHandler();
            if (handler != null && z) {
                handler.removeCallbacks(this.f4482e);
                handler.postDelayed(this.f4482e, 2000);
            }
            this.f4478a.setSystemUiVisibility(i);
        }
    }

    /* renamed from: a */
    public void m5324a() {
        this.f4480c = null;
    }

    /* renamed from: a */
    public void m5325a(Window window) {
        this.f4480c = window;
    }

    /* renamed from: a */
    public void m5326a(C1517a c1517a) {
        this.f4481d = c1517a;
        if (C15162.f4474a[this.f4481d.ordinal()] != 1) {
            m5321a(67108864, false);
            m5321a(134217728, false);
            this.f4478a.setSystemUiVisibility(0);
            return;
        }
        m5321a(67108864, true);
        m5321a(134217728, true);
        m5323a(false);
    }

    public void onSystemUiVisibilityChange(int i) {
        int i2 = this.f4479b ^ i;
        this.f4479b = i;
        if ((i2 & 2) != 0 && (i & 2) == 0) {
            m5323a(true);
        }
    }
}
