package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.ax;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@cm
public final class atc {
    /* renamed from: a */
    private boolean f14986a;
    /* renamed from: b */
    private final List<ata> f14987b = new LinkedList();
    /* renamed from: c */
    private final Map<String, String> f14988c = new LinkedHashMap();
    /* renamed from: d */
    private final Object f14989d = new Object();
    /* renamed from: e */
    private String f14990e;
    /* renamed from: f */
    private atc f14991f;

    public atc(boolean z, String str, String str2) {
        this.f14986a = z;
        this.f14988c.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        this.f14988c.put("ad_format", str2);
    }

    /* renamed from: a */
    public final ata m18916a() {
        return m18917a(ax.l().b());
    }

    /* renamed from: a */
    public final ata m18917a(long j) {
        return !this.f14986a ? null : new ata(j, null, null);
    }

    /* renamed from: a */
    public final void m18918a(atc atc) {
        synchronized (this.f14989d) {
            this.f14991f = atc;
        }
    }

    /* renamed from: a */
    public final void m18919a(String str) {
        if (this.f14986a) {
            synchronized (this.f14989d) {
                this.f14990e = str;
            }
        }
    }

    /* renamed from: a */
    public final void m18920a(String str, String str2) {
        if (this.f14986a) {
            if (!TextUtils.isEmpty(str2)) {
                ass b = ax.i().m30836b();
                if (b != null) {
                    synchronized (this.f14989d) {
                        asw a = b.m18901a(str);
                        Map map = this.f14988c;
                        map.put(str, a.mo3958a((String) map.get(str), str2));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean m18921a(ata ata, long j, String... strArr) {
        synchronized (this.f14989d) {
            for (String ata2 : strArr) {
                this.f14987b.add(new ata(j, ata2, ata));
            }
        }
        return true;
    }

    /* renamed from: a */
    public final boolean m18922a(ata ata, String... strArr) {
        if (this.f14986a) {
            if (ata != null) {
                return m18921a(ata, ax.l().b(), strArr);
            }
        }
        return false;
    }

    /* renamed from: b */
    public final String m18923b() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        synchronized (this.f14989d) {
            for (ata ata : this.f14987b) {
                long a = ata.m18910a();
                String b = ata.m18911b();
                ata ata2 = ata2.m18912c();
                if (ata2 != null && a > 0) {
                    a -= ata2.m18910a();
                    stringBuilder2.append(b);
                    stringBuilder2.append('.');
                    stringBuilder2.append(a);
                    stringBuilder2.append(',');
                }
            }
            this.f14987b.clear();
            if (!TextUtils.isEmpty(this.f14990e)) {
                stringBuilder2.append(this.f14990e);
            } else if (stringBuilder2.length() > 0) {
                stringBuilder2.setLength(stringBuilder2.length() - 1);
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    /* renamed from: c */
    final Map<String, String> m18924c() {
        synchronized (this.f14989d) {
            Map<String, String> a;
            ass b = ax.i().m30836b();
            if (b != null) {
                if (this.f14991f != null) {
                    a = b.m18902a(this.f14988c, this.f14991f.m18924c());
                    return a;
                }
            }
            a = this.f14988c;
            return a;
        }
    }

    /* renamed from: d */
    public final ata m18925d() {
        synchronized (this.f14989d) {
        }
        return null;
    }
}
