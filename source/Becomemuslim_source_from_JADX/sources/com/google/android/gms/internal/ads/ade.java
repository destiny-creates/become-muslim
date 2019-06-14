package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

final class ade<T> implements adq<T> {
    /* renamed from: a */
    private final acx f23559a;
    /* renamed from: b */
    private final aej<?, ?> f23560b;
    /* renamed from: c */
    private final boolean f23561c;
    /* renamed from: d */
    private final abf<?> f23562d;

    private ade(aej<?, ?> aej, abf<?> abf, acx acx) {
        this.f23560b = aej;
        this.f23561c = abf.mo3734a(acx);
        this.f23562d = abf;
        this.f23559a = acx;
    }

    /* renamed from: a */
    static <T> ade<T> m29818a(aej<?, ?> aej, abf<?> abf, acx acx) {
        return new ade(aej, abf, acx);
    }

    /* renamed from: a */
    public final int mo3753a(T t) {
        int hashCode = this.f23560b.mo3780b(t).hashCode();
        return this.f23561c ? (hashCode * 53) + this.f23562d.mo3727a((Object) t).hashCode() : hashCode;
    }

    /* renamed from: a */
    public final T mo3754a() {
        return this.f23559a.mo6639o().mo6630d();
    }

    /* renamed from: a */
    public final void mo3755a(T t, adp adp, abd abd) {
        aej aej = this.f23560b;
        abf abf = this.f23562d;
        Object c = aej.mo3784c(t);
        abi b = abf.mo3735b(t);
        while (adp.mo3643a() != Integer.MAX_VALUE) {
            try {
                boolean a;
                int b2 = adp.mo3648b();
                if (b2 != 11) {
                    if ((b2 & 7) == 2) {
                        Object a2 = abf.mo3728a(abd, this.f23559a, b2 >>> 3);
                        if (a2 != null) {
                            abf.mo3731a(adp, a2, abd, b);
                        } else {
                            a = aej.m18185a(c, adp);
                            continue;
                        }
                    } else {
                        a = adp.mo3653c();
                        continue;
                    }
                    if (!a) {
                        return;
                    }
                }
                Object obj = null;
                aai aai = null;
                int i = 0;
                while (adp.mo3643a() != Integer.MAX_VALUE) {
                    int b3 = adp.mo3648b();
                    if (b3 == 16) {
                        i = adp.mo3676o();
                        obj = abf.mo3728a(abd, this.f23559a, i);
                    } else if (b3 == 26) {
                        if (obj != null) {
                            abf.mo3731a(adp, obj, abd, b);
                        } else {
                            aai = adp.mo3674n();
                        }
                    } else if (!adp.mo3653c()) {
                        break;
                    }
                }
                if (adp.mo3648b() != 12) {
                    throw abw.m17949e();
                } else if (aai != null) {
                    if (obj != null) {
                        abf.mo3730a(aai, obj, abd, b);
                    } else {
                        aej.mo3775a(c, i, aai);
                    }
                }
                a = true;
                continue;
                if (a) {
                    return;
                }
            } finally {
                aej.mo3783b((Object) t, c);
            }
        }
        aej.mo3783b((Object) t, c);
    }

    /* renamed from: a */
    public final void mo3756a(T t, afd afd) {
        Iterator e = this.f23562d.mo3727a((Object) t).m17916e();
        while (e.hasNext()) {
            Entry entry = (Entry) e.next();
            abk abk = (abk) entry.getKey();
            if (abk.m17925c() != afc.MESSAGE || abk.m17926d() || abk.m17927e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            int a;
            Object c;
            if (entry instanceof acb) {
                a = abk.m17921a();
                c = ((acb) entry).m17958a().m17962c();
            } else {
                a = abk.m17921a();
                c = entry.getValue();
            }
            afd.mo3693a(a, c);
        }
        aej aej = this.f23560b;
        aej.mo3782b(aej.mo3780b(t), afd);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo3757a(T r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.ads.aaf r11) {
        /*
        r6 = this;
        r7 = (com.google.android.gms.internal.ads.abq) r7;
        r0 = r7.zzdtt;
        r1 = com.google.android.gms.internal.ads.aek.m18195a();
        if (r0 != r1) goto L_0x0010;
    L_0x000a:
        r0 = com.google.android.gms.internal.ads.aek.m18198b();
        r7.zzdtt = r0;
    L_0x0010:
        r7 = r0;
    L_0x0011:
        if (r9 >= r10) goto L_0x0069;
    L_0x0013:
        r2 = com.google.android.gms.internal.ads.aae.m17820a(r8, r9, r11);
        r0 = r11.f14129a;
        r9 = 11;
        r1 = 2;
        if (r0 == r9) goto L_0x0030;
    L_0x001e:
        r9 = r0 & 7;
        if (r9 != r1) goto L_0x002b;
    L_0x0022:
        r1 = r8;
        r3 = r10;
        r4 = r7;
        r5 = r11;
        r9 = com.google.android.gms.internal.ads.aae.m17817a(r0, r1, r2, r3, r4, r5);
        goto L_0x0011;
    L_0x002b:
        r9 = com.google.android.gms.internal.ads.aae.m17815a(r0, r8, r2, r10, r11);
        goto L_0x0011;
    L_0x0030:
        r9 = 0;
        r0 = 0;
    L_0x0032:
        if (r2 >= r10) goto L_0x005f;
    L_0x0034:
        r2 = com.google.android.gms.internal.ads.aae.m17820a(r8, r2, r11);
        r3 = r11.f14129a;
        r4 = r3 >>> 3;
        r5 = r3 & 7;
        switch(r4) {
            case 2: goto L_0x004d;
            case 3: goto L_0x0042;
            default: goto L_0x0041;
        };
    L_0x0041:
        goto L_0x0056;
    L_0x0042:
        if (r5 != r1) goto L_0x0056;
    L_0x0044:
        r2 = com.google.android.gms.internal.ads.aae.m17828e(r8, r2, r11);
        r0 = r11.f14131c;
        r0 = (com.google.android.gms.internal.ads.aai) r0;
        goto L_0x0032;
    L_0x004d:
        if (r5 != 0) goto L_0x0056;
    L_0x004f:
        r2 = com.google.android.gms.internal.ads.aae.m17820a(r8, r2, r11);
        r9 = r11.f14129a;
        goto L_0x0032;
    L_0x0056:
        r4 = 12;
        if (r3 == r4) goto L_0x005f;
    L_0x005a:
        r2 = com.google.android.gms.internal.ads.aae.m17815a(r3, r8, r2, r10, r11);
        goto L_0x0032;
    L_0x005f:
        if (r0 == 0) goto L_0x0067;
    L_0x0061:
        r9 = r9 << 3;
        r9 = r9 | r1;
        r7.m18199a(r9, r0);
    L_0x0067:
        r9 = r2;
        goto L_0x0011;
    L_0x0069:
        if (r9 != r10) goto L_0x006c;
    L_0x006b:
        return;
    L_0x006c:
        r7 = com.google.android.gms.internal.ads.abw.m17951g();
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ade.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.aaf):void");
    }

    /* renamed from: a */
    public final boolean mo3758a(T t, T t2) {
        return !this.f23560b.mo3780b(t).equals(this.f23560b.mo3780b(t2)) ? false : this.f23561c ? this.f23562d.mo3727a((Object) t).equals(this.f23562d.mo3727a((Object) t2)) : true;
    }

    /* renamed from: b */
    public final int mo3759b(T t) {
        aej aej = this.f23560b;
        int e = aej.mo3787e(aej.mo3780b(t)) + 0;
        return this.f23561c ? e + this.f23562d.mo3727a((Object) t).m17920i() : e;
    }

    /* renamed from: b */
    public final void mo3760b(T t, T t2) {
        ads.m18107a(this.f23560b, (Object) t, (Object) t2);
        if (this.f23561c) {
            ads.m18105a(this.f23562d, (Object) t, (Object) t2);
        }
    }

    /* renamed from: c */
    public final void mo3761c(T t) {
        this.f23560b.mo3786d(t);
        this.f23562d.mo3736c(t);
    }

    /* renamed from: d */
    public final boolean mo3762d(T t) {
        return this.f23562d.mo3727a((Object) t).m17918g();
    }
}
