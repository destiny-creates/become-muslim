package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.C2872v;
import java.util.Iterator;
import java.util.LinkedList;

@cm
final class azf {
    /* renamed from: a */
    private final LinkedList<azg> f15078a = new LinkedList();
    /* renamed from: b */
    private aoq f15079b;
    /* renamed from: c */
    private final String f15080c;
    /* renamed from: d */
    private final int f15081d;
    /* renamed from: e */
    private boolean f15082e;

    azf(aoq aoq, String str, int i) {
        C2872v.a(aoq);
        C2872v.a(str);
        this.f15079b = aoq;
        this.f15080c = str;
        this.f15081d = i;
    }

    /* renamed from: a */
    final aoq m19148a() {
        return this.f15079b;
    }

    /* renamed from: a */
    final azg m19149a(aoq aoq) {
        if (aoq != null) {
            this.f15079b = aoq;
        }
        return (azg) this.f15078a.remove();
    }

    /* renamed from: a */
    final void m19150a(axy axy, aoq aoq) {
        this.f15078a.add(new azg(this, axy, aoq));
    }

    /* renamed from: a */
    final boolean m19151a(axy axy) {
        azg azg = new azg(this, axy);
        this.f15078a.add(azg);
        return azg.m19159a();
    }

    /* renamed from: b */
    final int m19152b() {
        return this.f15081d;
    }

    /* renamed from: c */
    final String m19153c() {
        return this.f15080c;
    }

    /* renamed from: d */
    final int m19154d() {
        return this.f15078a.size();
    }

    /* renamed from: e */
    final int m19155e() {
        Iterator it = this.f15078a.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((azg) it.next()).f15087e) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: f */
    final int m19156f() {
        Iterator it = this.f15078a.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((azg) it.next()).m19159a()) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: g */
    final void m19157g() {
        this.f15082e = true;
    }

    /* renamed from: h */
    final boolean m19158h() {
        return this.f15082e;
    }
}
