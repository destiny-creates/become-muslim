package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.util.C3211a;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.WebView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.C2631d;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.ads.aks;
import com.google.android.gms.internal.ads.aoq;
import com.google.android.gms.internal.ads.aou;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.aqv;
import com.google.android.gms.internal.ads.bcy;
import com.google.android.gms.internal.ads.bdk;
import com.google.android.gms.internal.ads.bdo;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.id;
import com.google.android.gms.internal.ads.ih;
import com.google.android.gms.internal.ads.is;
import com.google.android.gms.internal.ads.it;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.jw;
import com.google.android.gms.internal.ads.mv;
import com.google.android.gms.internal.ads.qo;
import com.google.android.gms.internal.ads.sc;
import com.google.android.gms.p174b.C4757d;
import java.lang.ref.WeakReference;
import java.util.List;

@cm
public final class bw extends bg implements OnGlobalLayoutListener, OnScrollChangedListener {
    /* renamed from: k */
    private boolean f14107k;
    /* renamed from: l */
    private boolean f14108l;
    /* renamed from: m */
    private WeakReference<Object> f14109m = new WeakReference(null);

    public bw(Context context, aou aou, String str, bcy bcy, mv mvVar, bu buVar) {
        super(context, aou, str, bcy, mvVar, buVar);
    }

    /* renamed from: b */
    private final boolean m17750b(is isVar, is isVar2) {
        if (isVar2.f15587n) {
            View a = C2674t.m7549a(isVar2);
            if (a == null) {
                jn.e("Could not get mediation view");
                return false;
            }
            View nextView = this.e.f6795f.getNextView();
            if (nextView != null) {
                if (nextView instanceof qo) {
                    ((qo) nextView).destroy();
                }
                this.e.f6795f.removeView(nextView);
            }
            if (!C2674t.m7561b(isVar2)) {
                try {
                    if (ax.m7455B().b(this.e.f6792c)) {
                        new aks(this.e.f6792c, a).a(new ih(this.e.f6792c, this.e.f6791b));
                    }
                    if (isVar2.f15594u != null) {
                        this.e.f6795f.setMinimumWidth(isVar2.f15594u.f28284f);
                        this.e.f6795f.setMinimumHeight(isVar2.f15594u.f28281c);
                    }
                    m16428a(a);
                } catch (Throwable e) {
                    ax.m7468i().a(e, "BannerAdManager.swapViews");
                    jn.c("Could not add mediation view to view hierarchy.", e);
                    return false;
                }
            }
        } else if (!(isVar2.f15594u == null || isVar2.f15575b == null)) {
            isVar2.f15575b.a(sc.a(isVar2.f15594u));
            this.e.f6795f.removeAllViews();
            this.e.f6795f.setMinimumWidth(isVar2.f15594u.f28284f);
            this.e.f6795f.setMinimumHeight(isVar2.f15594u.f28281c);
            m16428a(isVar2.f15575b.getView());
        }
        if (this.e.f6795f.getChildCount() > 1) {
            this.e.f6795f.showNext();
        }
        if (isVar != null) {
            View nextView2 = this.e.f6795f.getNextView();
            if (nextView2 instanceof qo) {
                ((qo) nextView2).destroy();
            } else if (nextView2 != null) {
                this.e.f6795f.removeView(nextView2);
            }
            this.e.m7492c();
        }
        this.e.f6795f.setVisibility(0);
        return true;
    }

    /* renamed from: c */
    private final void m17751c(qo qoVar) {
        if (m17679L()) {
            WebView webView = qoVar.getWebView();
            if (webView != null) {
                View view = qoVar.getView();
                if (view != null && ax.m7480u().a(this.e.f6792c)) {
                    int i = this.e.f6794e.f28710b;
                    int i2 = this.e.f6794e.f28711c;
                    StringBuilder stringBuilder = new StringBuilder(23);
                    stringBuilder.append(i);
                    stringBuilder.append(".");
                    stringBuilder.append(i2);
                    this.h = ax.m7480u().a(stringBuilder.toString(), webView, "", "javascript", m16424G());
                    if (this.h != null) {
                        ax.m7480u().a(this.h, view);
                        ax.m7480u().a(this.h);
                        this.f14108l = true;
                    }
                }
            }
        }
    }

    /* renamed from: H */
    public final void mo3534H() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    /* renamed from: K */
    public final void m17753K() {
        this.d.m7444d();
    }

    /* renamed from: W */
    protected final boolean mo3585W() {
        boolean z;
        ax.m7464e();
        if (jw.a(this.e.f6792c, "android.permission.INTERNET")) {
            z = true;
        } else {
            aph.a().a(this.e.f6795f, this.e.f6798i, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        ax.m7464e();
        if (!jw.a(this.e.f6792c)) {
            aph.a().a(this.e.f6795f, this.e.f6798i, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!(z || this.e.f6795f == null)) {
            this.e.f6795f.setVisibility(0);
        }
        return z;
    }

    /* renamed from: a */
    protected final qo mo3586a(it itVar, bv bvVar, id idVar) {
        if (this.e.f6798i.f28285g == null && this.e.f6798i.f28287i) {
            aou aou;
            ay ayVar = this.e;
            if (itVar.f15601b.f28620y) {
                aou = this.e.f6798i;
            } else {
                C2631d c2631d;
                String str = itVar.f15601b.f28607l;
                if (str != null) {
                    String[] split = str.split("[xX]");
                    split[0] = split[0].trim();
                    split[1] = split[1].trim();
                    c2631d = new C2631d(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                } else {
                    c2631d = this.e.f6798i.b();
                }
                aou = new aou(this.e.f6792c, c2631d);
            }
            ayVar.f6798i = aou;
        }
        return super.mo3586a(itVar, bvVar, idVar);
    }

    /* renamed from: a */
    protected final void mo3587a(is isVar, boolean z) {
        qo qoVar;
        if (m17679L()) {
            qoVar = isVar != null ? isVar.f15575b : null;
            if (qoVar != null) {
                if (!this.f14108l) {
                    m17751c(qoVar);
                }
                if (this.h != null) {
                    qoVar.a("onSdkImpression", new C3211a());
                }
            }
        }
        super.mo3587a(isVar, z);
        if (C2674t.m7561b(isVar)) {
            C2641d c2641d = new C2641d(this);
            if (isVar != null && C2674t.m7561b(isVar)) {
                qoVar = isVar.f15575b;
                Object view = qoVar != null ? qoVar.getView() : null;
                if (view == null) {
                    jn.e("AdWebView is null");
                    return;
                }
                try {
                    List list = isVar.f15588o != null ? isVar.f15588o.f15190r : null;
                    if (list != null) {
                        if (!list.isEmpty()) {
                            bdk h = isVar.f15589p != null ? isVar.f15589p.h() : null;
                            bdo i = isVar.f15589p != null ? isVar.f15589p.i() : null;
                            if (list.contains("2") && h != null) {
                                h.b(C4757d.m16684a(view));
                                if (!h.j()) {
                                    h.i();
                                }
                                qoVar.a("/nativeExpressViewClicked", C2674t.m7550a(h, null, c2641d));
                                return;
                            } else if (!list.contains(AppEventsConstants.EVENT_PARAM_VALUE_YES) || i == null) {
                                jn.e("No matching template id and mapper");
                                return;
                            } else {
                                i.b(C4757d.m16684a(view));
                                if (!i.h()) {
                                    i.g();
                                }
                                qoVar.a("/nativeExpressViewClicked", C2674t.m7550a(null, i, c2641d));
                                return;
                            }
                        }
                    }
                    jn.e("No template ids present in mediation response");
                } catch (Throwable e) {
                    jn.c("Error occurred while recording impression and registering for clicks", e);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo3435a(com.google.android.gms.internal.ads.is r5, com.google.android.gms.internal.ads.is r6) {
        /*
        r4 = this;
        r0 = super.mo3435a(r5, r6);
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r4.e;
        r0 = r0.m7493d();
        if (r0 == 0) goto L_0x0025;
    L_0x0010:
        r5 = r4.m17750b(r5, r6);
        if (r5 != 0) goto L_0x0025;
    L_0x0016:
        r5 = r6.f15565K;
        if (r5 == 0) goto L_0x0021;
    L_0x001a:
        r5 = r6.f15565K;
        r6 = com.google.android.gms.internal.ads.amz.C8283a.C6762b.f23735c;
        r5.a(r6);
    L_0x0021:
        r4.mo3538a(r1);
        return r1;
    L_0x0025:
        r4.m17434b(r6, r1);
        r5 = r6.f15585l;
        r0 = 0;
        if (r5 == 0) goto L_0x0064;
    L_0x002d:
        r4.m17760d(r6);
        com.google.android.gms.ads.internal.ax.m7454A();
        r5 = r4.e;
        r5 = r5.f6795f;
        com.google.android.gms.internal.ads.oh.a(r5, r4);
        com.google.android.gms.ads.internal.ax.m7454A();
        r5 = r4.e;
        r5 = r5.f6795f;
        com.google.android.gms.internal.ads.oh.a(r5, r4);
        r5 = r6.f15586m;
        if (r5 != 0) goto L_0x0081;
    L_0x0048:
        r5 = new com.google.android.gms.ads.internal.c;
        r5.<init>(r4);
        r1 = r6.f15575b;
        if (r1 == 0) goto L_0x0058;
    L_0x0051:
        r1 = r6.f15575b;
        r1 = r1.v();
        goto L_0x0059;
    L_0x0058:
        r1 = r0;
    L_0x0059:
        if (r1 == 0) goto L_0x0081;
    L_0x005b:
        r2 = new com.google.android.gms.ads.internal.bx;
        r2.<init>(r6, r5);
        r1.a(r2);
        goto L_0x0081;
    L_0x0064:
        r5 = r4.e;
        r5 = r5.m7494e();
        if (r5 == 0) goto L_0x007e;
    L_0x006c:
        r5 = com.google.android.gms.internal.ads.asp.bW;
        r2 = com.google.android.gms.internal.ads.aph.f();
        r5 = r2.a(r5);
        r5 = (java.lang.Boolean) r5;
        r5 = r5.booleanValue();
        if (r5 == 0) goto L_0x0081;
    L_0x007e:
        r4.mo3587a(r6, r1);
    L_0x0081:
        r5 = r6.f15575b;
        if (r5 == 0) goto L_0x00a5;
    L_0x0085:
        r5 = r6.f15575b;
        r5 = r5.b();
        r1 = r6.f15575b;
        r1 = r1.v();
        if (r1 == 0) goto L_0x0096;
    L_0x0093:
        r1.g();
    L_0x0096:
        r1 = r4.e;
        r1 = r1.f6813x;
        if (r1 == 0) goto L_0x00a5;
    L_0x009c:
        if (r5 == 0) goto L_0x00a5;
    L_0x009e:
        r1 = r4.e;
        r1 = r1.f6813x;
        r5.a(r1);
    L_0x00a5:
        r5 = com.google.android.gms.common.util.C2904o.m8456b();
        if (r5 == 0) goto L_0x0142;
    L_0x00ab:
        r5 = r4.e;
        r5 = r5.m7493d();
        if (r5 == 0) goto L_0x011e;
    L_0x00b3:
        r5 = r6.f15575b;
        if (r5 == 0) goto L_0x0139;
    L_0x00b7:
        r5 = r6.f15584k;
        if (r5 == 0) goto L_0x00c4;
    L_0x00bb:
        r5 = r4.g;
        r0 = r4.e;
        r0 = r0.f6798i;
        r5.a(r0, r6);
    L_0x00c4:
        r5 = r6.f15575b;
        r0 = r5.getView();
        r5 = new com.google.android.gms.internal.ads.aks;
        r1 = r4.e;
        r1 = r1.f6792c;
        r5.<init>(r1, r0);
        r1 = com.google.android.gms.ads.internal.ax.m7455B();
        r2 = r4.e;
        r2 = r2.f6792c;
        r1 = r1.b(r2);
        if (r1 == 0) goto L_0x0103;
    L_0x00e1:
        r1 = r6.f15574a;
        r1 = com.google.android.gms.ads.internal.C4736a.m16416a(r1);
        if (r1 == 0) goto L_0x0103;
    L_0x00e9:
        r1 = r4.e;
        r1 = r1.f6791b;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x0103;
    L_0x00f3:
        r1 = new com.google.android.gms.internal.ads.ih;
        r2 = r4.e;
        r2 = r2.f6792c;
        r3 = r4.e;
        r3 = r3.f6791b;
        r1.<init>(r2, r3);
        r5.a(r1);
    L_0x0103:
        r1 = r6.a();
        if (r1 == 0) goto L_0x010f;
    L_0x0109:
        r1 = r6.f15575b;
        r5.a(r1);
        goto L_0x0139;
    L_0x010f:
        r1 = r6.f15575b;
        r1 = r1.v();
        r2 = new com.google.android.gms.ads.internal.b;
        r2.<init>(r5, r6);
        r1.a(r2);
        goto L_0x0139;
    L_0x011e:
        r5 = r4.e;
        r5 = r5.f6780H;
        if (r5 == 0) goto L_0x0139;
    L_0x0124:
        r5 = r6.f15584k;
        if (r5 == 0) goto L_0x0139;
    L_0x0128:
        r5 = r4.g;
        r0 = r4.e;
        r0 = r0.f6798i;
        r1 = r4.e;
        r1 = r1.f6780H;
        r5.a(r0, r6, r1);
        r5 = r4.e;
        r0 = r5.f6780H;
    L_0x0139:
        r5 = r6.f15587n;
        if (r5 != 0) goto L_0x0142;
    L_0x013d:
        r5 = r4.e;
        r5.m7488a(r0);
    L_0x0142:
        r5 = 1;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.bw.a(com.google.android.gms.internal.ads.is, com.google.android.gms.internal.ads.is):boolean");
    }

    /* renamed from: b */
    public final void mo3550b(boolean z) {
        C2872v.m8389b("setManualImpressionsEnabled must be called from the main thread.");
        this.f14107k = z;
    }

    /* renamed from: b */
    public final boolean mo3551b(aoq aoq) {
        aoq aoq2 = aoq;
        if (aoq2.f28268h != this.f14107k) {
            boolean z;
            int i = aoq2.f28261a;
            long j = aoq2.f28262b;
            Bundle bundle = aoq2.f28263c;
            int i2 = aoq2.f28264d;
            List list = aoq2.f28265e;
            boolean z2 = aoq2.f28266f;
            int i3 = aoq2.f28267g;
            if (!aoq2.f28268h) {
                if (!r0.f14107k) {
                    z = false;
                    aoq2 = new aoq(i, j, bundle, i2, list, z2, i3, z, aoq2.f28269i, aoq2.f28270j, aoq2.f28271k, aoq2.f28272l, aoq2.f28273m, aoq2.f28274n, aoq2.f28275o, aoq2.f28276p, aoq2.f28277q, aoq2.f28278r);
                }
            }
            z = true;
            aoq2 = new aoq(i, j, bundle, i2, list, z2, i3, z, aoq2.f28269i, aoq2.f28270j, aoq2.f28271k, aoq2.f28272l, aoq2.f28273m, aoq2.f28274n, aoq2.f28275o, aoq2.f28276p, aoq2.f28277q, aoq2.f28278r);
        }
        return super.mo3551b(aoq2);
    }

    /* renamed from: d */
    final void m17760d(is isVar) {
        if (!(isVar == null || isVar.f15586m || this.e.f6795f == null || !ax.m7464e().a(this.e.f6795f, this.e.f6792c))) {
            if (this.e.f6795f.getGlobalVisibleRect(new Rect(), null)) {
                if (!(isVar == null || isVar.f15575b == null || isVar.f15575b.v() == null)) {
                    isVar.f15575b.v().a(null);
                }
                mo3587a(isVar, false);
                isVar.f15586m = true;
            }
        }
    }

    public final void onGlobalLayout() {
        m17760d(this.e.f6799j);
    }

    public final void onScrollChanged() {
        m17760d(this.e.f6799j);
    }

    /* renamed from: s */
    public final aqv mo3552s() {
        C2872v.m8389b("getVideoController must be called from the main thread.");
        return (this.e.f6799j == null || this.e.f6799j.f15575b == null) ? null : this.e.f6799j.f15575b.b();
    }

    /* renamed from: w */
    protected final void mo3546w() {
        qo qoVar = this.e.f6799j != null ? this.e.f6799j.f15575b : null;
        if (!(this.f14108l || qoVar == null)) {
            m17751c(qoVar);
        }
        super.mo3546w();
    }
}
