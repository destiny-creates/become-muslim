package com.google.android.gms.internal.p213l;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.measurement.AppMeasurement.C6846a;
import com.google.android.gms.measurement.AppMeasurement.C6847d;
import com.google.android.gms.measurement.AppMeasurement.C6848e;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.az */
public final class az extends dc {
    /* renamed from: a */
    private static final AtomicReference<String[]> f32309a = new AtomicReference();
    /* renamed from: b */
    private static final AtomicReference<String[]> f32310b = new AtomicReference();
    /* renamed from: c */
    private static final AtomicReference<String[]> f32311c = new AtomicReference();

    az(cg cgVar) {
        super(cgVar);
    }

    /* renamed from: a */
    private final String m42522a(an anVar) {
        return anVar == null ? null : !m42524g() ? anVar.toString() : m42525a(anVar.m38075b());
    }

    /* renamed from: a */
    private static String m42523a(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        C2872v.a(strArr);
        C2872v.a(strArr2);
        C2872v.a(atomicReference);
        C2872v.b(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (fw.m42649b(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = (String[]) atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(strArr2[i]);
                        stringBuilder.append("(");
                        stringBuilder.append(strArr[i]);
                        stringBuilder.append(")");
                        strArr3[i] = stringBuilder.toString();
                    }
                    str = strArr3[i];
                }
                return str;
            }
        }
        return str;
    }

    /* renamed from: g */
    private final boolean m42524g() {
        return this.q.mo4754r().m42558a(3);
    }

    /* renamed from: a */
    protected final String m42525a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!m42524g()) {
            return bundle.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : bundle.keySet()) {
            stringBuilder.append(stringBuilder.length() != 0 ? ", " : "Bundle[{");
            stringBuilder.append(m42530b(str));
            stringBuilder.append("=");
            stringBuilder.append(bundle.get(str));
        }
        stringBuilder.append("}]");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    protected final String m42526a(al alVar) {
        if (alVar == null) {
            return null;
        }
        if (!m42524g()) {
            return alVar.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event{appId='");
        stringBuilder.append(alVar.f16885a);
        stringBuilder.append("', name='");
        stringBuilder.append(m42528a(alVar.f16886b));
        stringBuilder.append("', params=");
        stringBuilder.append(m42522a(alVar.f16889e));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    protected final String m42527a(aq aqVar) {
        if (aqVar == null) {
            return null;
        }
        if (!m42524g()) {
            return aqVar.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("origin=");
        stringBuilder.append(aqVar.f28972c);
        stringBuilder.append(",name=");
        stringBuilder.append(m42528a(aqVar.f28970a));
        stringBuilder.append(",params=");
        stringBuilder.append(m42522a(aqVar.f28971b));
        return stringBuilder.toString();
    }

    /* renamed from: a */
    protected final String m42528a(String str) {
        return str == null ? null : !m42524g() ? str : az.m42523a(str, C6846a.f24653b, C6846a.f24652a, f32309a);
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: b */
    protected final String m42530b(String str) {
        return str == null ? null : !m42524g() ? str : az.m42523a(str, C6847d.f24655b, C6847d.f24654a, f32310b);
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
    }

    /* renamed from: c */
    protected final String m42532c(String str) {
        if (str == null) {
            return null;
        }
        if (!m42524g()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return az.m42523a(str, C6848e.f24657b, C6848e.f24656a, f32311c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("experiment_id");
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo6209c() {
        super.mo6209c();
    }

    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo6210d() {
        super.mo6210d();
    }

    /* renamed from: e */
    protected final boolean mo6739e() {
        return false;
    }

    /* renamed from: l */
    public final /* bridge */ /* synthetic */ ak mo6211l() {
        return super.mo6211l();
    }

    /* renamed from: m */
    public final /* bridge */ /* synthetic */ C2895e mo4751m() {
        return super.mo4751m();
    }

    /* renamed from: n */
    public final /* bridge */ /* synthetic */ Context mo4752n() {
        return super.mo4752n();
    }

    /* renamed from: o */
    public final /* bridge */ /* synthetic */ az mo6212o() {
        return super.mo6212o();
    }

    /* renamed from: p */
    public final /* bridge */ /* synthetic */ fw mo6213p() {
        return super.mo6213p();
    }

    /* renamed from: q */
    public final /* bridge */ /* synthetic */ cb mo4753q() {
        return super.mo4753q();
    }

    /* renamed from: r */
    public final /* bridge */ /* synthetic */ bb mo4754r() {
        return super.mo4754r();
    }

    /* renamed from: s */
    public final /* bridge */ /* synthetic */ bm mo6214s() {
        return super.mo6214s();
    }

    /* renamed from: t */
    public final /* bridge */ /* synthetic */ aa mo6215t() {
        return super.mo6215t();
    }

    /* renamed from: u */
    public final /* bridge */ /* synthetic */ C5052x mo4755u() {
        return super.mo4755u();
    }
}
