package com.google.android.gms.internal.p213l;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.C2873j;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2909t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.l.ci */
public final class ci extends au {
    /* renamed from: a */
    private final fm f28974a;
    /* renamed from: b */
    private Boolean f28975b;
    /* renamed from: c */
    private String f28976c;

    public ci(fm fmVar) {
        this(fmVar, null);
    }

    private ci(fm fmVar, String str) {
        C2872v.a(fmVar);
        this.f28974a = fmVar;
        this.f28976c = null;
    }

    /* renamed from: a */
    private final void m38080a(Runnable runnable) {
        C2872v.a(runnable);
        if (((Boolean) as.aa.m21260b()).booleanValue() && this.f28974a.mo4753q().m42619g()) {
            runnable.run();
        } else {
            this.f28974a.mo4753q().m42612a(runnable);
        }
    }

    /* renamed from: a */
    private final void m38081a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.f28974a.mo4754r().I_().m21307a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.f28975b == null) {
                    if (!("com.google.android.gms".equals(this.f28976c) || C2909t.a(this.f28974a.mo4752n(), Binder.getCallingUid()))) {
                        if (!C2873j.a(this.f28974a.mo4752n()).a(Binder.getCallingUid())) {
                            z = false;
                            this.f28975b = Boolean.valueOf(z);
                        }
                    }
                    z = true;
                    this.f28975b = Boolean.valueOf(z);
                }
                if (this.f28975b.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.f28974a.mo4754r().I_().m21308a("Measurement Service called with invalid calling package. appId", bb.m42550a(str));
                throw e;
            }
        }
        if (this.f28976c == null && C2832i.uidHasPackageName(this.f28974a.mo4752n(), Binder.getCallingUid(), str)) {
            this.f28976c = str;
        }
        if (!str.equals(this.f28976c)) {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
        }
    }

    /* renamed from: b */
    private final void m38082b(C7826u c7826u, boolean z) {
        C2872v.a(c7826u);
        m38081a(c7826u.f29107a, false);
        this.f28974a.m32068h().m42677e(c7826u.f29108b);
    }

    /* renamed from: a */
    public final List<ft> mo4735a(C7826u c7826u, boolean z) {
        m38082b(c7826u, false);
        try {
            List<fv> list = (List) this.f28974a.mo4753q().m42610a(new cy(this, c7826u)).get();
            List<ft> arrayList = new ArrayList(list.size());
            for (fv fvVar : list) {
                if (z || !fw.m42652g(fvVar.f17239c)) {
                    arrayList.add(new ft(fvVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            this.f28974a.mo4754r().I_().m21309a("Failed to get user attributes. appId", bb.m42550a(c7826u.f29107a), e);
            return null;
        }
    }

    /* renamed from: a */
    public final List<C7827y> mo4736a(String str, String str2, C7826u c7826u) {
        m38082b(c7826u, false);
        try {
            return (List) this.f28974a.mo4753q().m42610a(new cq(this, c7826u, str, str2)).get();
        } catch (InterruptedException e) {
            this.f28974a.mo4754r().I_().m21308a("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    public final List<C7827y> mo4737a(String str, String str2, String str3) {
        m38081a(str, true);
        try {
            return (List) this.f28974a.mo4753q().m42610a(new cr(this, str, str2, str3)).get();
        } catch (InterruptedException e) {
            this.f28974a.mo4754r().I_().m21308a("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    public final List<ft> mo4738a(String str, String str2, String str3, boolean z) {
        m38081a(str, true);
        try {
            List<fv> list = (List) this.f28974a.mo4753q().m42610a(new cp(this, str, str2, str3)).get();
            List<ft> arrayList = new ArrayList(list.size());
            for (fv fvVar : list) {
                if (z || !fw.m42652g(fvVar.f17239c)) {
                    arrayList.add(new ft(fvVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            this.f28974a.mo4754r().I_().m21309a("Failed to get user attributes. appId", bb.m42550a(str), e);
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    public final List<ft> mo4739a(String str, String str2, boolean z, C7826u c7826u) {
        m38082b(c7826u, false);
        try {
            List<fv> list = (List) this.f28974a.mo4753q().m42610a(new co(this, c7826u, str, str2)).get();
            List<ft> arrayList = new ArrayList(list.size());
            for (fv fvVar : list) {
                if (z || !fw.m42652g(fvVar.f17239c)) {
                    arrayList.add(new ft(fvVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            this.f28974a.mo4754r().I_().m21309a("Failed to get user attributes. appId", bb.m42550a(c7826u.f29107a), e);
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    public final void mo4740a(long j, String str, String str2, String str3) {
        m38080a(new da(this, str2, str3, str, j));
    }

    /* renamed from: a */
    public final void mo4741a(aq aqVar, C7826u c7826u) {
        C2872v.a(aqVar);
        m38082b(c7826u, false);
        m38080a(new ct(this, aqVar, c7826u));
    }

    /* renamed from: a */
    public final void mo4742a(aq aqVar, String str, String str2) {
        C2872v.a(aqVar);
        C2872v.a(str);
        m38081a(str, true);
        m38080a(new cu(this, aqVar, str));
    }

    /* renamed from: a */
    public final void mo4743a(ft ftVar, C7826u c7826u) {
        C2872v.a(ftVar);
        m38082b(c7826u, false);
        m38080a(ftVar.m38105a() == null ? new cw(this, ftVar, c7826u) : new cx(this, ftVar, c7826u));
    }

    /* renamed from: a */
    public final void mo4744a(C7826u c7826u) {
        m38082b(c7826u, false);
        m38080a(new cz(this, c7826u));
    }

    /* renamed from: a */
    public final void mo4745a(C7827y c7827y) {
        C2872v.a(c7827y);
        C2872v.a(c7827y.f29126c);
        m38081a(c7827y.f29124a, true);
        C7827y c7827y2 = new C7827y(c7827y);
        m38080a(c7827y.f29126c.m38105a() == null ? new cm(this, c7827y2) : new cn(this, c7827y2));
    }

    /* renamed from: a */
    public final void mo4746a(C7827y c7827y, C7826u c7826u) {
        C2872v.a(c7827y);
        C2872v.a(c7827y.f29126c);
        m38082b(c7826u, false);
        C7827y c7827y2 = new C7827y(c7827y);
        c7827y2.f29124a = c7826u.f29107a;
        m38080a(c7827y.f29126c.m38105a() == null ? new ck(this, c7827y2, c7826u) : new cl(this, c7827y2, c7826u));
    }

    /* renamed from: a */
    public final byte[] mo4747a(aq aqVar, String str) {
        C2872v.a(str);
        C2872v.a(aqVar);
        m38081a(str, true);
        this.f28974a.mo4754r().m42578v().m21308a("Log and bundle. event", this.f28974a.m32067g().m42528a(aqVar.f28970a));
        long c = this.f28974a.mo4751m().c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f28974a.mo4753q().m42613b(new cv(this, aqVar, str)).get();
            if (bArr == null) {
                this.f28974a.mo4754r().I_().m21308a("Log and bundle returned null. appId", bb.m42550a(str));
                bArr = new byte[0];
            }
            this.f28974a.mo4754r().m42578v().m21310a("Log and bundle processed. event, size, time_ms", this.f28974a.m32067g().m42528a(aqVar.f28970a), Integer.valueOf(bArr.length), Long.valueOf((this.f28974a.mo4751m().c() / 1000000) - c));
            return bArr;
        } catch (InterruptedException e) {
            this.f28974a.mo4754r().I_().m21310a("Failed to log and bundle. appId, event, error", bb.m42550a(str), this.f28974a.m32067g().m42528a(aqVar.f28970a), e);
            return null;
        }
    }

    /* renamed from: b */
    public final void mo4748b(C7826u c7826u) {
        m38082b(c7826u, false);
        m38080a(new cj(this, c7826u));
    }

    /* renamed from: c */
    public final String mo4749c(C7826u c7826u) {
        m38082b(c7826u, false);
        return this.f28974a.m32064d(c7826u);
    }

    /* renamed from: d */
    public final void mo4750d(C7826u c7826u) {
        m38081a(c7826u.f29107a, false);
        m38080a(new cs(this, c7826u));
    }
}
