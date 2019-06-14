package host.exp.exponent.p339f.p340a.p341a;

import android.net.Uri;
import host.exp.exponent.C6301d;
import host.exp.exponent.p339f.C6352l.C6351c;
import host.exp.exponent.p339f.C6355n;

/* compiled from: LinkingKernelService */
/* renamed from: host.exp.exponent.f.a.a.a */
public class C6323a {
    /* renamed from: a */
    public void m26009a(Uri uri) {
        C6355n.m26073a().mo5406a(new C6351c(uri.toString(), uri.toString(), null));
    }

    /* renamed from: b */
    public boolean m26010b(Uri uri) {
        String scheme = uri.getScheme();
        boolean z = true;
        if (!"exp".equals(scheme)) {
            if (!"exps".equals(scheme)) {
                if (C6301d.f20497c != null && C6301d.f20497c.equals(scheme)) {
                    return true;
                }
                uri = uri.getHost();
                if (uri != null) {
                    if (!"exp.host".equals(uri)) {
                        if (uri.endsWith("exp.direct") != null) {
                        }
                    }
                    return z;
                }
                z = false;
                return z;
            }
        }
        return true;
    }
}
