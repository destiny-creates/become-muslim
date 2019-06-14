package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.gmsg.ae;
import java.util.Map;

@cm
/* renamed from: com.google.android.gms.internal.ads.m */
public final class C6765m extends C4933n implements ae<qo> {
    /* renamed from: a */
    private final qo f24157a;
    /* renamed from: b */
    private final Context f24158b;
    /* renamed from: c */
    private final WindowManager f24159c;
    /* renamed from: d */
    private final asa f24160d;
    /* renamed from: e */
    private DisplayMetrics f24161e;
    /* renamed from: f */
    private float f24162f;
    /* renamed from: g */
    private int f24163g = -1;
    /* renamed from: h */
    private int f24164h = -1;
    /* renamed from: i */
    private int f24165i;
    /* renamed from: j */
    private int f24166j = -1;
    /* renamed from: k */
    private int f24167k = -1;
    /* renamed from: l */
    private int f24168l = -1;
    /* renamed from: m */
    private int f24169m = -1;

    public C6765m(qo qoVar, Context context, asa asa) {
        super(qoVar);
        this.f24157a = qoVar;
        this.f24158b = context;
        this.f24160d = asa;
        this.f24159c = (WindowManager) context.getSystemService("window");
    }

    /* renamed from: a */
    public final void m30898a(int i, int i2) {
        int i3 = 0;
        if (this.f24158b instanceof Activity) {
            i3 = ax.e().m19749c((Activity) this.f24158b)[0];
        }
        if (this.f24157a.mo6135t() == null || !this.f24157a.mo6135t().m20093d()) {
            aph.m18683a();
            this.f24168l = mi.m19874b(this.f24158b, this.f24157a.getWidth());
            aph.m18683a();
            this.f24169m = mi.m19874b(this.f24158b, this.f24157a.getHeight());
        }
        m19931b(i, i2 - i3, this.f24168l, this.f24169m);
        this.f24157a.mo6718v().mo4339a(i, i2);
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        int b;
        int[] iArr;
        int b2;
        this.f24161e = new DisplayMetrics();
        Display defaultDisplay = this.f24159c.getDefaultDisplay();
        defaultDisplay.getMetrics(this.f24161e);
        this.f24162f = this.f24161e.density;
        this.f24165i = defaultDisplay.getRotation();
        aph.m18683a();
        this.f24163g = mi.m19875b(this.f24161e, this.f24161e.widthPixels);
        aph.m18683a();
        this.f24164h = mi.m19875b(this.f24161e, this.f24161e.heightPixels);
        Activity d = this.f24157a.mo6128d();
        if (d != null) {
            if (d.getWindow() != null) {
                ax.e();
                int[] a = jw.m19710a(d);
                aph.m18683a();
                this.f24166j = mi.m19875b(this.f24161e, a[0]);
                aph.m18683a();
                b = mi.m19875b(this.f24161e, a[1]);
                this.f24167k = b;
                if (this.f24157a.mo6135t().m20093d()) {
                    this.f24157a.measure(0, 0);
                } else {
                    this.f24168l = this.f24163g;
                    this.f24169m = this.f24164h;
                }
                m19929a(this.f24163g, this.f24164h, this.f24166j, this.f24167k, this.f24162f, this.f24165i);
                this.f24157a.mo4089a("onDeviceFeaturesReceived", new C4930j(new C4932l().m19817b(this.f24160d.m18862a()).m19816a(this.f24160d.m18863b()).m19818c(this.f24160d.m18865d()).m19819d(this.f24160d.m18864c()).m19820e(true)).m19585a());
                iArr = new int[2];
                this.f24157a.getLocationOnScreen(iArr);
                aph.m18683a();
                b2 = mi.m19874b(this.f24158b, iArr[0]);
                aph.m18683a();
                m30898a(b2, mi.m19874b(this.f24158b, iArr[1]));
                if (mt.m19917a(2)) {
                    mt.m19922d("Dispatching Ready Event.");
                }
                m19932b(this.f24157a.mo6133k().f28709a);
            }
        }
        this.f24166j = this.f24163g;
        b = this.f24164h;
        this.f24167k = b;
        if (this.f24157a.mo6135t().m20093d()) {
            this.f24157a.measure(0, 0);
        } else {
            this.f24168l = this.f24163g;
            this.f24169m = this.f24164h;
        }
        m19929a(this.f24163g, this.f24164h, this.f24166j, this.f24167k, this.f24162f, this.f24165i);
        this.f24157a.mo4089a("onDeviceFeaturesReceived", new C4930j(new C4932l().m19817b(this.f24160d.m18862a()).m19816a(this.f24160d.m18863b()).m19818c(this.f24160d.m18865d()).m19819d(this.f24160d.m18864c()).m19820e(true)).m19585a());
        iArr = new int[2];
        this.f24157a.getLocationOnScreen(iArr);
        aph.m18683a();
        b2 = mi.m19874b(this.f24158b, iArr[0]);
        aph.m18683a();
        m30898a(b2, mi.m19874b(this.f24158b, iArr[1]));
        if (mt.m19917a(2)) {
            mt.m19922d("Dispatching Ready Event.");
        }
        m19932b(this.f24157a.mo6133k().f28709a);
    }
}
