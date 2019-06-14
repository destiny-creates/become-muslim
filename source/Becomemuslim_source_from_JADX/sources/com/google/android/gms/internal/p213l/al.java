package com.google.android.gms.internal.p213l;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2872v;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.l.al */
public final class al {
    /* renamed from: a */
    final String f16885a;
    /* renamed from: b */
    final String f16886b;
    /* renamed from: c */
    final long f16887c;
    /* renamed from: d */
    final long f16888d;
    /* renamed from: e */
    final an f16889e;
    /* renamed from: f */
    private final String f16890f;

    al(cg cgVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        an anVar;
        C2872v.a(str2);
        C2872v.a(str3);
        this.f16885a = str2;
        this.f16886b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f16890f = str;
        this.f16887c = j;
        this.f16888d = j2;
        if (this.f16888d != 0 && this.f16888d > this.f16887c) {
            cgVar.mo4754r().m42565i().m21308a("Event created with reverse previous/current timestamps. appId", bb.m42550a(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            anVar = new an(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                str3 = (String) it.next();
                if (str3 == null) {
                    cgVar.mo4754r().I_().m21307a("Param name can't be null");
                } else {
                    Object a = cgVar.m31969k().m42660a(str3, bundle2.get(str3));
                    if (a == null) {
                        cgVar.mo4754r().m42565i().m21308a("Param value can't be null", cgVar.m31970l().m42530b(str3));
                    } else {
                        cgVar.m31969k().m42663a(bundle2, str3, a);
                    }
                }
                it.remove();
            }
            anVar = new an(bundle2);
        }
        this.f16889e = anVar;
    }

    private al(cg cgVar, String str, String str2, String str3, long j, long j2, an anVar) {
        C2872v.a(str2);
        C2872v.a(str3);
        C2872v.a(anVar);
        this.f16885a = str2;
        this.f16886b = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f16890f = str;
        this.f16887c = j;
        this.f16888d = j2;
        if (this.f16888d != 0 && this.f16888d > this.f16887c) {
            cgVar.mo4754r().m42565i().m21309a("Event created with reverse previous/current timestamps. appId, name", bb.m42550a(str2), bb.m42550a(str3));
        }
        this.f16889e = anVar;
    }

    /* renamed from: a */
    final al m21245a(cg cgVar, long j) {
        return new al(cgVar, this.f16890f, this.f16885a, this.f16886b, this.f16887c, j, this.f16889e);
    }

    public final String toString() {
        String str = this.f16885a;
        String str2 = this.f16886b;
        String valueOf = String.valueOf(this.f16889e);
        StringBuilder stringBuilder = new StringBuilder(((String.valueOf(str).length() + 33) + String.valueOf(str2).length()) + String.valueOf(valueOf).length());
        stringBuilder.append("Event{appId='");
        stringBuilder.append(str);
        stringBuilder.append("', name='");
        stringBuilder.append(str2);
        stringBuilder.append("', params=");
        stringBuilder.append(valueOf);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
