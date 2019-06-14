package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

@cm
public final class la extends ik {
    /* renamed from: a */
    private final Context f28703a;

    private la(Context context, qs qsVar) {
        super(qsVar);
        this.f28703a = context;
    }

    /* renamed from: a */
    public static bai m37558a(Context context) {
        bai bai = new bai(new ln(new File(context.getCacheDir(), "admob_volley")), new la(context, new rt()));
        bai.m19194a();
        return bai;
    }

    /* renamed from: a */
    public final aug mo4084a(awi<?> awi) {
        if (awi.m19068h() && awi.m19062c() == 0) {
            if (Pattern.matches((String) aph.m18688f().m18889a(asp.cJ), awi.m19065e())) {
                aph.m18683a();
                if (mi.m19880c(this.f28703a)) {
                    aug a = new axs(this.f28703a).mo4084a((awi) awi);
                    String str;
                    if (a != null) {
                        str = "Got gmscore asset response: ";
                        String valueOf = String.valueOf(awi.m19065e());
                        jn.m30864a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                        return a;
                    }
                    String str2 = "Failed to get gmscore asset response: ";
                    str = String.valueOf(awi.m19065e());
                    jn.m30864a(str.length() != 0 ? str2.concat(str) : new String(str2));
                }
            }
        }
        return super.mo4084a(awi);
    }
}
