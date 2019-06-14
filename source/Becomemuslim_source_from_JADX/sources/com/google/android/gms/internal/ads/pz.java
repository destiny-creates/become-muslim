package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.api.C2791i;
import java.lang.ref.WeakReference;
import java.util.Map;

@cm
public abstract class pz implements C2791i {
    /* renamed from: a */
    protected Context f24244a;
    /* renamed from: b */
    private String f24245b;
    /* renamed from: c */
    private WeakReference<pn> f24246c;

    public pz(pn pnVar) {
        this.f24244a = pnVar.getContext();
        this.f24245b = ax.e().m19744b(this.f24244a, pnVar.mo6133k().f28709a);
        this.f24246c = new WeakReference(pnVar);
    }

    /* renamed from: a */
    private final void m30993a(String str, Map<String, String> map) {
        pn pnVar = (pn) this.f24246c.get();
        if (pnVar != null) {
            pnVar.mo6650a(str, (Map) map);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static java.lang.String m30994b(java.lang.String r2) {
        /*
        r0 = "internal";
        r1 = r2.hashCode();
        switch(r1) {
            case -1947652542: goto L_0x007f;
            case -1396664534: goto L_0x0074;
            case -1347010958: goto L_0x006a;
            case -918817863: goto L_0x005f;
            case -659376217: goto L_0x0055;
            case -642208130: goto L_0x004b;
            case -354048396: goto L_0x0040;
            case -32082395: goto L_0x0035;
            case 3387234: goto L_0x002b;
            case 96784904: goto L_0x0021;
            case 580119100: goto L_0x0016;
            case 725497484: goto L_0x000b;
            default: goto L_0x0009;
        };
    L_0x0009:
        goto L_0x0089;
    L_0x000b:
        r1 = "noCacheDir";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0089;
    L_0x0013:
        r2 = 7;
        goto L_0x008a;
    L_0x0016:
        r1 = "expireFailed";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0089;
    L_0x001e:
        r2 = 6;
        goto L_0x008a;
    L_0x0021:
        r1 = "error";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0089;
    L_0x0029:
        r2 = 1;
        goto L_0x008a;
    L_0x002b:
        r1 = "noop";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0089;
    L_0x0033:
        r2 = 4;
        goto L_0x008a;
    L_0x0035:
        r1 = "externalAbort";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0089;
    L_0x003d:
        r2 = 10;
        goto L_0x008a;
    L_0x0040:
        r1 = "sizeExceeded";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0089;
    L_0x0048:
        r2 = 11;
        goto L_0x008a;
    L_0x004b:
        r1 = "playerFailed";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0089;
    L_0x0053:
        r2 = 5;
        goto L_0x008a;
    L_0x0055:
        r1 = "contentLengthMissing";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0089;
    L_0x005d:
        r2 = 0;
        goto L_0x008a;
    L_0x005f:
        r1 = "downloadTimeout";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0089;
    L_0x0067:
        r2 = 9;
        goto L_0x008a;
    L_0x006a:
        r1 = "inProgress";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0089;
    L_0x0072:
        r2 = 2;
        goto L_0x008a;
    L_0x0074:
        r1 = "badUrl";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0089;
    L_0x007c:
        r2 = 8;
        goto L_0x008a;
    L_0x007f:
        r1 = "interrupted";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0089;
    L_0x0087:
        r2 = 3;
        goto L_0x008a;
    L_0x0089:
        r2 = -1;
    L_0x008a:
        switch(r2) {
            case 0: goto L_0x0097;
            case 1: goto L_0x0097;
            case 2: goto L_0x0097;
            case 3: goto L_0x0097;
            case 4: goto L_0x0097;
            case 5: goto L_0x0097;
            case 6: goto L_0x0094;
            case 7: goto L_0x0094;
            case 8: goto L_0x0091;
            case 9: goto L_0x0091;
            case 10: goto L_0x008e;
            case 11: goto L_0x008e;
            default: goto L_0x008d;
        };
    L_0x008d:
        goto L_0x0099;
    L_0x008e:
        r0 = "policy";
        goto L_0x0099;
    L_0x0091:
        r0 = "network";
        goto L_0x0099;
    L_0x0094:
        r0 = "io";
        goto L_0x0099;
    L_0x0097:
        r0 = "internal";
    L_0x0099:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.pz.b(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public void m30995a() {
    }

    /* renamed from: a */
    protected final void m30996a(String str, String str2, int i) {
        mi.f15796a.post(new qb(this, str, str2, i));
    }

    /* renamed from: a */
    public final void m30997a(String str, String str2, String str3, String str4) {
        mi.f15796a.post(new qc(this, str, str2, str3, str4));
    }

    /* renamed from: a */
    public abstract boolean mo6124a(String str);

    /* renamed from: b */
    public abstract void mo6125b();
}
