package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.gmsg.C2651k;
import com.google.android.gms.ads.internal.gmsg.C2652m;
import com.google.android.gms.ads.internal.overlay.C2668t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2898i;
import com.google.android.gms.internal.ads.C4939y;
import com.google.android.gms.internal.ads.af;
import com.google.android.gms.internal.ads.aju;
import com.google.android.gms.internal.ads.amx;
import com.google.android.gms.internal.ads.amz.C8283a.C6762b;
import com.google.android.gms.internal.ads.aok;
import com.google.android.gms.internal.ads.aoq;
import com.google.android.gms.internal.ads.aor;
import com.google.android.gms.internal.ads.aou;
import com.google.android.gms.internal.ads.ap;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.apk;
import com.google.android.gms.internal.ads.apn;
import com.google.android.gms.internal.ads.apz;
import com.google.android.gms.internal.ads.aqd;
import com.google.android.gms.internal.ads.aqh;
import com.google.android.gms.internal.ads.aqn;
import com.google.android.gms.internal.ads.aqv;
import com.google.android.gms.internal.ads.arb;
import com.google.android.gms.internal.ads.arw;
import com.google.android.gms.internal.ads.ary;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.ata;
import com.google.android.gms.internal.ads.atc;
import com.google.android.gms.internal.ads.atj;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.co;
import com.google.android.gms.internal.ads.fx;
import com.google.android.gms.internal.ads.gc;
import com.google.android.gms.internal.ads.gf;
import com.google.android.gms.internal.ads.gn;
import com.google.android.gms.internal.ads.hq;
import com.google.android.gms.internal.ads.im;
import com.google.android.gms.internal.ads.is;
import com.google.android.gms.internal.ads.it;
import com.google.android.gms.internal.ads.iu;
import com.google.android.gms.internal.ads.jd;
import com.google.android.gms.internal.ads.jf;
import com.google.android.gms.internal.ads.jk;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.jw;
import com.google.android.gms.internal.ads.mi;
import com.google.android.gms.internal.ads.mt;
import com.google.android.gms.internal.ads.sc;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

@cm
/* renamed from: com.google.android.gms.ads.internal.a */
public abstract class C4736a extends apz implements C2651k, C2652m, C2668t, aok, ap, co, jd {
    /* renamed from: a */
    protected atc f12965a;
    /* renamed from: b */
    protected ata f12966b;
    /* renamed from: c */
    protected boolean f12967c = false;
    /* renamed from: d */
    protected final an f12968d;
    /* renamed from: e */
    protected final ay f12969e;
    /* renamed from: f */
    protected transient aoq f12970f;
    /* renamed from: g */
    protected final aju f12971g;
    /* renamed from: h */
    protected C2758b f12972h;
    /* renamed from: i */
    protected final bu f12973i;
    /* renamed from: j */
    private ata f12974j;
    /* renamed from: k */
    private final Bundle f12975k = new Bundle();
    /* renamed from: l */
    private boolean f12976l = false;

    C4736a(ay ayVar, an anVar, bu buVar) {
        this.f12969e = ayVar;
        this.f12968d = new an(this);
        this.f12973i = buVar;
        ax.m7464e().b(this.f12969e.f6792c);
        ax.m7464e().c(this.f12969e.f6792c);
        jk.a(this.f12969e.f6792c);
        ax.m7456C().a(this.f12969e.f6792c);
        ax.m7468i().a(this.f12969e.f6792c, this.f12969e.f6794e);
        ax.m7470k().a(this.f12969e.f6792c);
        this.f12971g = ax.m7468i().g();
        ax.m7467h().a(this.f12969e.f6792c);
        ax.m7458E().a(this.f12969e.f6792c);
        if (((Boolean) aph.f().a(asp.cn)).booleanValue()) {
            Timer timer = new Timer();
            timer.schedule(new ab(this, new CountDownLatch(((Integer) aph.f().a(asp.cp)).intValue()), timer), 0, ((Long) aph.f().a(asp.co)).longValue());
        }
    }

    /* renamed from: a */
    protected static boolean m16416a(aoq aoq) {
        Bundle bundle = aoq.f28273m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            if (bundle.containsKey("gw")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static long mo3544b(String str) {
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (Throwable e) {
            mt.b("", e);
            return -1;
        }
    }

    /* renamed from: A */
    protected final void m16418A() {
        if (this.f12969e.f6775C != null) {
            try {
                this.f12969e.f6775C.f();
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
            }
        }
    }

    /* renamed from: B */
    public final void m16419B() {
        is isVar = this.f12969e.f6799j;
        if (isVar != null && !TextUtils.isEmpty(isVar.f15556B) && !isVar.f15563I) {
            if (ax.m7474o().b()) {
                jn.b("Sending troubleshooting signals to the server.");
                ax.m7474o().b(this.f12969e.f6792c, this.f12969e.f6794e.f28709a, isVar.f15556B, this.f12969e.f6791b);
                isVar.f15563I = true;
            }
        }
    }

    /* renamed from: C */
    public String mo3533C() {
        return this.f12969e.f6791b;
    }

    /* renamed from: D */
    public final aqh m16421D() {
        return this.f12969e.f6804o;
    }

    /* renamed from: E */
    public final apn m16422E() {
        return this.f12969e.f6803n;
    }

    /* renamed from: F */
    protected final void m16423F() {
        if (this.f12972h != null) {
            ax.m7480u().b(this.f12972h);
            this.f12972h = null;
        }
    }

    /* renamed from: G */
    protected final String m16424G() {
        it itVar = this.f12969e.f6800k;
        if (itVar == null) {
            return "javascript";
        }
        if (itVar.f15601b == null) {
            return "javascript";
        }
        Object obj = itVar.f15601b.f28591T;
        if (TextUtils.isEmpty(obj)) {
            return "javascript";
        }
        try {
            return new JSONObject(obj).optInt(MessengerShareContentUtility.MEDIA_TYPE, -1) == 0 ? null : "javascript";
        } catch (Throwable e) {
            mt.c("", e);
            return "javascript";
        }
    }

    /* renamed from: a */
    protected final List<String> m16425a(List<String> list) {
        List arrayList = new ArrayList(list.size());
        for (String b : list) {
            arrayList.add(im.b(b, this.f12969e.f6792c));
        }
        return arrayList;
    }

    /* renamed from: a */
    protected void mo3538a(int i) {
        mo3539a(i, false);
    }

    /* renamed from: a */
    protected void mo3539a(int i, boolean z) {
        StringBuilder stringBuilder = new StringBuilder(30);
        stringBuilder.append("Failed to load ad: ");
        stringBuilder.append(i);
        jn.e(stringBuilder.toString());
        this.f12967c = z;
        if (this.f12969e.f6803n != null) {
            try {
                this.f12969e.f6803n.a(i);
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
            }
        }
        if (this.f12969e.f6775C != null) {
            try {
                this.f12969e.f6775C.a(i);
            } catch (Throwable e2) {
                jn.d("#007 Could not call remote method.", e2);
            }
        }
    }

    /* renamed from: a */
    protected final void m16428a(View view) {
        az azVar = this.f12969e.f6795f;
        if (azVar != null) {
            azVar.addView(view, ax.m7466g().d());
        }
    }

    /* renamed from: a */
    public final void m16429a(af afVar, String str) {
        jn.e("#006 Unexpected call to a deprecated method.");
    }

    /* renamed from: a */
    public final void m16430a(aou aou) {
        C2872v.m8389b("#008 Must be called on the main UI thread.: setAdSize");
        this.f12969e.f6798i = aou;
        if (!(this.f12969e.f6799j == null || this.f12969e.f6799j.f15575b == null || this.f12969e.f6781I != 0)) {
            this.f12969e.f6799j.f15575b.a(sc.a(aou));
        }
        if (this.f12969e.f6795f != null) {
            if (this.f12969e.f6795f.getChildCount() > 1) {
                this.f12969e.f6795f.removeView(this.f12969e.f6795f.getNextView());
            }
            this.f12969e.f6795f.setMinimumWidth(aou.f28284f);
            this.f12969e.f6795f.setMinimumHeight(aou.f28281c);
            this.f12969e.f6795f.requestLayout();
        }
    }

    /* renamed from: a */
    public final void m16431a(apk apk) {
        C2872v.m8389b("#008 Must be called on the main UI thread.: setAdClickListener");
        this.f12969e.f6802m = apk;
    }

    /* renamed from: a */
    public final void m16432a(apn apn) {
        C2872v.m8389b("#008 Must be called on the main UI thread.: setAdListener");
        this.f12969e.f6803n = apn;
    }

    /* renamed from: a */
    public final void m16433a(aqd aqd) {
        this.f12969e.f6805p = aqd;
    }

    /* renamed from: a */
    public final void m16434a(aqh aqh) {
        C2872v.m8389b("#008 Must be called on the main UI thread.: setAppEventListener");
        this.f12969e.f6804o = aqh;
    }

    /* renamed from: a */
    public final void m16435a(aqn aqn) {
        C2872v.m8389b("#008 Must be called on the main UI thread.: setCorrelationIdProvider");
        this.f12969e.f6806q = aqn;
    }

    /* renamed from: a */
    public final void m16436a(arb arb) {
        C2872v.m8389b("#008 Must be called on the main UI thread.: setIconAdOptions");
        this.f12969e.f6814y = arb;
    }

    /* renamed from: a */
    public final void m16437a(ary ary) {
        C2872v.m8389b("#008 Must be called on the main UI thread.: setVideoOptions");
        this.f12969e.f6813x = ary;
    }

    /* renamed from: a */
    public final void m16438a(ata ata) {
        this.f12965a = new atc(((Boolean) aph.f().a(asp.f14923N)).booleanValue(), "load_ad", this.f12969e.f6798i.f28279a);
        this.f12974j = new ata(-1, null, null);
        if (ata == null) {
            this.f12966b = new ata(-1, null, null);
        } else {
            this.f12966b = new ata(ata.a(), ata.b(), ata.c());
        }
    }

    /* renamed from: a */
    public void mo3540a(atj atj) {
        throw new IllegalStateException("#005 Unexpected call to an abstract (unimplemented) method.");
    }

    /* renamed from: a */
    public final void m16440a(gf gfVar) {
        C2872v.m8389b("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.f12969e.f6776D = gfVar;
    }

    /* renamed from: a */
    public final void m16441a(gn gnVar) {
        C2872v.m8389b("#008 Must be called on the main UI thread.: setRewardedVideoAdListener");
        this.f12969e.f6775C = gnVar;
    }

    /* renamed from: a */
    public final void m16442a(it itVar) {
        if (!(itVar.f15601b.f28608m == -1 || TextUtils.isEmpty(itVar.f15601b.f28618w))) {
            long b = C4736a.mo3544b(itVar.f15601b.f28618w);
            if (b != -1) {
                this.f12965a.a(this.f12965a.a(itVar.f15601b.f28608m + b), new String[]{"stc"});
            }
        }
        this.f12965a.a(itVar.f15601b.f28618w);
        this.f12965a.a(this.f12966b, new String[]{"arf"});
        this.f12974j = this.f12965a.a();
        this.f12965a.a("gqi", itVar.f15601b.f28619x);
        this.f12969e.f6796g = null;
        this.f12969e.f6800k = itVar;
        itVar.f15608i.a(new ba(this, itVar));
        itVar.f15608i.a(C6762b.f23734b);
        mo3541a(itVar, this.f12965a);
    }

    /* renamed from: a */
    protected abstract void mo3541a(it itVar, atc atc);

    /* renamed from: a */
    public void mo3542a(C4939y c4939y) {
        jn.e("#006 Unexpected call to a deprecated method.");
    }

    /* renamed from: a */
    public final void m16445a(String str) {
        C2872v.m8389b("#008 Must be called on the main UI thread.: setUserId");
        this.f12969e.f6777E = str;
    }

    /* renamed from: a */
    public final void mo3251a(String str, Bundle bundle) {
        this.f12975k.putAll(bundle);
        if (this.f12976l && this.f12969e.f6805p != null) {
            try {
                this.f12969e.f6805p.a();
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
            }
        }
    }

    /* renamed from: a */
    public final void mo3252a(String str, String str2) {
        if (this.f12969e.f6804o != null) {
            try {
                this.f12969e.f6804o.a(str, str2);
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
            }
        }
    }

    /* renamed from: a */
    public final void m16448a(HashSet<iu> hashSet) {
        this.f12969e.m7489a((HashSet) hashSet);
    }

    /* renamed from: a */
    protected abstract boolean mo3433a(aoq aoq, atc atc);

    /* renamed from: a */
    boolean mo3434a(is isVar) {
        return false;
    }

    /* renamed from: a */
    protected abstract boolean mo3435a(is isVar, is isVar2);

    /* renamed from: b */
    protected final List<String> m16452b(List<String> list) {
        List arrayList = new ArrayList(list.size());
        for (String a : list) {
            arrayList.add(im.a(a, this.f12969e.f6792c));
        }
        return arrayList;
    }

    /* renamed from: b */
    protected final void m16453b(hq hqVar) {
        if (this.f12969e.f6775C != null) {
            try {
                String str = "";
                int i = 1;
                if (hqVar != null) {
                    str = hqVar.f28691a;
                    i = hqVar.f28692b;
                }
                gc fxVar = new fx(str, i);
                this.f12969e.f6775C.a(fxVar);
                if (this.f12969e.f6776D != null) {
                    this.f12969e.f6776D.a(fxVar, this.f12969e.f6800k.f15600a.f28566v);
                }
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
            }
        }
    }

    /* renamed from: b */
    public void mo3436b(is isVar) {
        this.f12965a.a(this.f12974j, new String[]{"awr"});
        this.f12969e.f6797h = null;
        if (!(isVar.f15577d == -2 || isVar.f15577d == 3 || this.f12969e.m7487a() == null)) {
            ax.m7469j().a(this.f12969e.m7487a());
        }
        if (isVar.f15577d == -1) {
            this.f12967c = false;
            return;
        }
        if (mo3434a(isVar)) {
            jn.b("Ad refresh scheduled.");
        }
        if (isVar.f15577d != -2) {
            amx amx;
            C6762b c6762b;
            if (isVar.f15577d == 3) {
                amx = isVar.f15565K;
                c6762b = C6762b.f23736d;
            } else {
                amx = isVar.f15565K;
                c6762b = C6762b.f23735c;
            }
            amx.a(c6762b);
            mo3538a(isVar.f15577d);
            return;
        }
        if (this.f12969e.f6779G == null) {
            this.f12969e.f6779G = new jf(this.f12969e.f6791b);
        }
        if (this.f12969e.f6795f != null) {
            this.f12969e.f6795f.m7496a().d(isVar.f15556B);
        }
        this.f12971g.a(this.f12969e.f6799j);
        if (mo3435a(this.f12969e.f6799j, isVar)) {
            this.f12969e.f6799j = isVar;
            ay ayVar = this.f12969e;
            if (ayVar.f6801l != null) {
                if (ayVar.f6799j != null) {
                    ayVar.f6801l.a(ayVar.f6799j.f15598y);
                    ayVar.f6801l.b(ayVar.f6799j.f15599z);
                    ayVar.f6801l.b(ayVar.f6799j.f15587n);
                }
                ayVar.f6801l.a(ayVar.f6798i.f28282d);
            }
            this.f12965a.a("is_mraid", this.f12969e.f6799j.a() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.f12965a.a("is_mediation", this.f12969e.f6799j.f15587n ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            if (!(this.f12969e.f6799j.f15575b == null || this.f12969e.f6799j.f15575b.v() == null)) {
                this.f12965a.a("is_delay_pl", this.f12969e.f6799j.f15575b.v().f() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            this.f12965a.a(this.f12966b, new String[]{"ttc"});
            if (ax.m7468i().b() != null) {
                ax.m7468i().b().a(this.f12965a);
            }
            m16419B();
            if (this.f12969e.m7493d()) {
                mo3546w();
            }
        }
        if (isVar.f15564J != null) {
            ax.m7464e().a(this.f12969e.f6792c, isVar.f15564J);
        }
    }

    /* renamed from: b */
    public void mo3550b(boolean z) {
        jn.e("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    /* renamed from: b */
    public boolean mo3551b(aoq aoq) {
        C2872v.m8389b("#008 Must be called on the main UI thread.: loadAd");
        ax.m7470k().a();
        this.f12975k.clear();
        this.f12976l = false;
        if (((Boolean) aph.f().a(asp.aN)).booleanValue()) {
            aoq = aoq.a();
            if (((Boolean) aph.f().a(asp.aO)).booleanValue()) {
                aoq.f28263c.putBoolean(AdMobAdapter.NEW_BUNDLE, true);
            }
        }
        if (C2898i.m8444c(this.f12969e.f6792c) && aoq.f28271k != null) {
            aoq = new aor(aoq).a(null).a();
        }
        if (this.f12969e.f6796g == null) {
            if (this.f12969e.f6797h == null) {
                String str;
                jn.d("Starting ad request.");
                m16438a(null);
                this.f12966b = this.f12965a.a();
                if (aoq.f28266f) {
                    str = "This request is sent from a test device.";
                } else {
                    aph.a();
                    str = mi.a(this.f12969e.f6792c);
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 71);
                    stringBuilder.append("Use AdRequest.Builder.addTestDevice(\"");
                    stringBuilder.append(str);
                    stringBuilder.append("\") to get test ads on this device.");
                    str = stringBuilder.toString();
                }
                jn.d(str);
                this.f12968d.m7439a(aoq);
                this.f12967c = mo3433a(aoq, this.f12965a);
                return this.f12967c;
            }
        }
        jn.e(this.f12970f != null ? "Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes." : "Loading already in progress, saving this object for future refreshes.");
        this.f12970f = aoq;
        return false;
    }

    /* renamed from: c */
    public void mo3591c(boolean z) {
        throw new IllegalStateException("#005 Unexpected call to an abstract (unimplemented) method.");
    }

    /* renamed from: c */
    protected boolean mo3437c(aoq aoq) {
        if (this.f12969e.f6795f == null) {
            return false;
        }
        ViewParent parent = this.f12969e.f6795f.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        return ax.m7464e().a(view, view.getContext());
    }

    /* renamed from: d */
    protected void mo3545d(boolean z) {
        jn.a("Ad finished loading.");
        this.f12967c = z;
        this.f12976l = true;
        if (this.f12969e.f6803n != null) {
            try {
                this.f12969e.f6803n.c();
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
            }
        }
        if (this.f12969e.f6775C != null) {
            try {
                this.f12969e.f6775C.a();
            } catch (Throwable e2) {
                jn.d("#007 Could not call remote method.", e2);
            }
        }
        if (this.f12969e.f6805p != null) {
            try {
                this.f12969e.f6805p.a();
            } catch (Throwable e22) {
                jn.d("#007 Could not call remote method.", e22);
            }
        }
    }

    /* renamed from: g */
    public final void mo3253g() {
        m16474u();
    }

    /* renamed from: h */
    public final bu m16461h() {
        return this.f12973i;
    }

    /* renamed from: i */
    public void m16462i() {
        C2872v.m8389b("#008 Must be called on the main UI thread.: destroy");
        this.f12968d.m7438a();
        this.f12971g.b(this.f12969e.f6799j);
        ay ayVar = this.f12969e;
        if (ayVar.f6795f != null) {
            ayVar.f6795f.m7497b();
        }
        ayVar.f6803n = null;
        ayVar.f6805p = null;
        ayVar.f6804o = null;
        ayVar.f6774B = null;
        ayVar.f6806q = null;
        ayVar.m7490a(false);
        if (ayVar.f6795f != null) {
            ayVar.f6795f.removeAllViews();
        }
        ayVar.m7491b();
        ayVar.m7492c();
        ayVar.f6799j = null;
    }

    /* renamed from: j */
    public final C2758b m16463j() {
        C2872v.m8389b("#008 Must be called on the main UI thread.: getAdFrame");
        return C4757d.m16684a(this.f12969e.f6795f);
    }

    /* renamed from: k */
    public final aou m16464k() {
        C2872v.m8389b("#008 Must be called on the main UI thread.: getAdSize");
        return this.f12969e.f6798i == null ? null : new arw(this.f12969e.f6798i);
    }

    /* renamed from: l */
    public final boolean m16465l() {
        C2872v.m8389b("#008 Must be called on the main UI thread.: isLoaded");
        return this.f12969e.f6796g == null && this.f12969e.f6797h == null && this.f12969e.f6799j != null;
    }

    /* renamed from: m */
    public final void m16466m() {
        C2872v.m8389b("#008 Must be called on the main UI thread.: recordManualImpression");
        if (this.f12969e.f6799j == null) {
            jn.e("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        jn.b("Pinging manual tracking URLs.");
        if (!this.f12969e.f6799j.f15562H) {
            List arrayList = new ArrayList();
            if (this.f12969e.f6799j.f15580g != null) {
                arrayList.addAll(this.f12969e.f6799j.f15580g);
            }
            if (!(this.f12969e.f6799j.f15588o == null || this.f12969e.f6799j.f15588o.f15181i == null)) {
                arrayList.addAll(this.f12969e.f6799j.f15588o.f15181i);
            }
            if (!arrayList.isEmpty()) {
                ax.m7464e();
                jw.a(this.f12969e.f6792c, this.f12969e.f6794e.f28709a, arrayList);
                this.f12969e.f6799j.f15562H = true;
            }
        }
    }

    /* renamed from: n */
    public void mo3441n() {
        C2872v.m8389b("#008 Must be called on the main UI thread.: pause");
    }

    /* renamed from: o */
    public void mo3443o() {
        C2872v.m8389b("#008 Must be called on the main UI thread.: resume");
    }

    public void onAdClicked() {
        if (this.f12969e.f6799j == null) {
            jn.e("Ad state was null when trying to ping click URLs.");
            return;
        }
        jn.b("Pinging click URLs.");
        if (this.f12969e.f6801l != null) {
            this.f12969e.f6801l.b();
        }
        if (this.f12969e.f6799j.f15576c != null) {
            ax.m7464e();
            jw.a(this.f12969e.f6792c, this.f12969e.f6794e.f28709a, m16452b(this.f12969e.f6799j.f15576c));
        }
        if (this.f12969e.f6802m != null) {
            try {
                this.f12969e.f6802m.a();
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
            }
        }
    }

    /* renamed from: p */
    public final Bundle m16469p() {
        return this.f12976l ? this.f12975k : new Bundle();
    }

    /* renamed from: q */
    public final void m16470q() {
        C2872v.m8389b("#008 Must be called on the main UI thread.: stopLoading");
        this.f12967c = false;
        this.f12969e.m7490a(true);
    }

    /* renamed from: r */
    public final boolean m16471r() {
        return this.f12967c;
    }

    /* renamed from: s */
    public aqv mo3552s() {
        return null;
    }

    /* renamed from: t */
    protected void mo3594t() {
        jn.a("Ad closing.");
        if (this.f12969e.f6803n != null) {
            try {
                this.f12969e.f6803n.a();
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
            }
        }
        if (this.f12969e.f6775C != null) {
            try {
                this.f12969e.f6775C.d();
            } catch (Throwable e2) {
                jn.d("#007 Could not call remote method.", e2);
            }
        }
    }

    /* renamed from: u */
    protected final void m16474u() {
        jn.a("Ad leaving application.");
        if (this.f12969e.f6803n != null) {
            try {
                this.f12969e.f6803n.b();
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
            }
        }
        if (this.f12969e.f6775C != null) {
            try {
                this.f12969e.f6775C.e();
            } catch (Throwable e2) {
                jn.d("#007 Could not call remote method.", e2);
            }
        }
    }

    /* renamed from: v */
    protected final void m16475v() {
        jn.a("Ad opening.");
        if (this.f12969e.f6803n != null) {
            try {
                this.f12969e.f6803n.d();
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
            }
        }
        if (this.f12969e.f6775C != null) {
            try {
                this.f12969e.f6775C.b();
            } catch (Throwable e2) {
                jn.d("#007 Could not call remote method.", e2);
            }
        }
    }

    /* renamed from: w */
    protected void mo3546w() {
        mo3545d(false);
    }

    /* renamed from: x */
    public final void m16477x() {
        jn.d("Ad impression.");
        if (this.f12969e.f6803n != null) {
            try {
                this.f12969e.f6803n.f();
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
            }
        }
    }

    /* renamed from: y */
    public final void m16478y() {
        jn.d("Ad clicked.");
        if (this.f12969e.f6803n != null) {
            try {
                this.f12969e.f6803n.e();
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
            }
        }
    }

    /* renamed from: z */
    protected final void m16479z() {
        if (this.f12969e.f6775C != null) {
            try {
                this.f12969e.f6775C.c();
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
            }
        }
    }
}
