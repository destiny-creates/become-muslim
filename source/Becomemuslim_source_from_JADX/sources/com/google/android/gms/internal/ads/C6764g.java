package com.google.android.gms.internal.ads;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.p169c.C2627a.C2626a;
import java.util.Map;

@cm
/* renamed from: com.google.android.gms.internal.ads.g */
public final class C6764g extends C4933n {
    /* renamed from: a */
    private final Map<String, String> f24081a;
    /* renamed from: b */
    private final Context f24082b;

    public C6764g(qo qoVar, Map<String, String> map) {
        super(qoVar, "storePicture");
        this.f24081a = map;
        this.f24082b = qoVar.mo6128d();
    }

    /* renamed from: a */
    public final void m30725a() {
        if (this.f24082b == null) {
            m19930a("Activity context is not available");
            return;
        }
        ax.e();
        if (jw.m19728f(this.f24082b).m18864c()) {
            String str = (String) this.f24081a.get("iurl");
            if (TextUtils.isEmpty(str)) {
                m19930a("Image url cannot be empty.");
                return;
            } else if (URLUtil.isValidUrl(str)) {
                r1 = Uri.parse(str).getLastPathSegment();
                ax.e();
                if (jw.m19720c(r1)) {
                    Resources h = ax.i().m30843h();
                    ax.e();
                    Builder e = jw.m19724e(this.f24082b);
                    e.setTitle(h != null ? h.getString(C2626a.s1) : "Save image");
                    e.setMessage(h != null ? h.getString(C2626a.s2) : "Allow Ad to store image in Picture gallery?");
                    e.setPositiveButton(h != null ? h.getString(C2626a.s3) : "Accept", new C4927h(this, str, r1));
                    e.setNegativeButton(h != null ? h.getString(C2626a.s4) : "Decline", new C4928i(this));
                    e.create().show();
                    return;
                }
                str = "Image type not recognized: ";
                r1 = String.valueOf(r1);
                m19930a(r1.length() != 0 ? str.concat(r1) : new String(str));
                return;
            } else {
                r1 = "Invalid image url: ";
                str = String.valueOf(str);
                m19930a(str.length() != 0 ? r1.concat(str) : new String(r1));
                return;
            }
        }
        m19930a("Feature is not supported by the device.");
    }
}
