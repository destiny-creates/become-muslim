package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.ae;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.gmsg.C2653o;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

@cm
public final class bi {
    /* renamed from: a */
    private final Object f15246a = new Object();
    /* renamed from: b */
    private final Context f15247b;
    /* renamed from: c */
    private final ahi f15248c;
    /* renamed from: d */
    private final it f15249d;
    /* renamed from: e */
    private final atc f15250e;
    /* renamed from: f */
    private final ae f15251f;
    /* renamed from: g */
    private OnGlobalLayoutListener f15252g;
    /* renamed from: h */
    private OnScrollChangedListener f15253h;
    /* renamed from: i */
    private final DisplayMetrics f15254i;
    /* renamed from: j */
    private lx f15255j;
    /* renamed from: k */
    private int f15256k = -1;
    /* renamed from: l */
    private int f15257l = -1;

    public bi(Context context, ahi ahi, it itVar, atc atc, ae aeVar) {
        this.f15247b = context;
        this.f15248c = ahi;
        this.f15249d = itVar;
        this.f15250e = atc;
        this.f15251f = aeVar;
        this.f15255j = new lx(200);
        ax.e();
        this.f15254i = jw.m19684a((WindowManager) context.getSystemService("window"));
    }

    /* renamed from: a */
    private final void m19361a(WeakReference<qo> weakReference, boolean z) {
        if (weakReference != null) {
            qo qoVar = (qo) weakReference.get();
            if (qoVar != null) {
                if (qoVar.getView() != null) {
                    if (!z || this.f15255j.m19842a()) {
                        int[] iArr = new int[2];
                        qoVar.getView().getLocationOnScreen(iArr);
                        aph.m18683a();
                        int b = mi.m19875b(this.f15254i, iArr[0]);
                        aph.m18683a();
                        int b2 = mi.m19875b(this.f15254i, iArr[1]);
                        synchronized (this.f15246a) {
                            if (!(this.f15256k == b && this.f15257l == b2)) {
                                this.f15256k = b;
                                this.f15257l = b2;
                                qoVar.mo6718v().mo4340a(this.f15256k, this.f15257l, z ^ true);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    final /* synthetic */ void m19362a(nz nzVar, qo qoVar, boolean z) {
        this.f15251f.Q();
        nzVar.m30915b(qoVar);
    }

    /* renamed from: a */
    final /* synthetic */ void m19363a(JSONObject jSONObject, nz nzVar) {
        try {
            ax.f();
            qo a = qv.m20039a(this.f15247b, sc.m20088a(), "native-video", false, false, this.f15248c, this.f15249d.f15600a.f28555k, this.f15250e, null, this.f15251f.h(), this.f15249d.f15608i);
            a.mo6676a(sc.m20091b());
            this.f15251f.a(a);
            WeakReference weakReference = new WeakReference(a);
            rw v = a.mo6718v();
            if (this.f15252g == null) {
                this.f15252g = new bo(this, weakReference);
            }
            OnGlobalLayoutListener onGlobalLayoutListener = this.f15252g;
            if (this.f15253h == null) {
                this.f15253h = new bp(this, weakReference);
            }
            v.mo4341a(onGlobalLayoutListener, this.f15253h);
            a.mo6678a("/video", C2653o.f6888l);
            a.mo6678a("/videoMeta", C2653o.f6889m);
            a.mo6678a("/precache", new qd());
            a.mo6678a("/delayPageLoaded", C2653o.f6892p);
            a.mo6678a("/instrument", C2653o.f6890n);
            a.mo6678a("/log", C2653o.f6883g);
            a.mo6678a("/videoClicked", C2653o.f6884h);
            a.mo6678a("/trackActiveViewUnit", new bm(this));
            a.mo6678a("/untrackActiveViewUnit", new bn(this));
            a.mo6718v().mo4344a(new bk(a, jSONObject));
            a.mo6718v().mo4343a(new bl(this, nzVar, a));
            a.loadUrl((String) aph.m18688f().m18889a(asp.bY));
        } catch (Throwable e) {
            mt.m19921c("Exception occurred while getting video view", e);
            nzVar.m30915b(null);
        }
    }
}
