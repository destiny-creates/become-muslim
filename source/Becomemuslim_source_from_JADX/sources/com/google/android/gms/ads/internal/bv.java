package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.dr;
import com.google.android.gms.internal.ads.id;
import com.google.android.gms.internal.ads.jw;

@cm
public final class bv {
    /* renamed from: a */
    private final Context f6847a;
    /* renamed from: b */
    private boolean f6848b;
    /* renamed from: c */
    private id f6849c;
    /* renamed from: d */
    private dr f6850d;

    public bv(Context context, id idVar, dr drVar) {
        this.f6847a = context;
        this.f6849c = idVar;
        this.f6850d = drVar;
        if (this.f6850d == null) {
            this.f6850d = new dr();
        }
    }

    /* renamed from: c */
    private final boolean m7505c() {
        return (this.f6849c != null && this.f6849c.a().f28698f) || this.f6850d.f28622a;
    }

    /* renamed from: a */
    public final void m7506a() {
        this.f6848b = true;
    }

    /* renamed from: a */
    public final void m7507a(String str) {
        if (m7505c()) {
            if (str == null) {
                str = "";
            }
            if (this.f6849c != null) {
                this.f6849c.a(str, null, 3);
                return;
            }
            if (this.f6850d.f28622a && this.f6850d.f28623b != null) {
                for (String str2 : this.f6850d.f28623b) {
                    String str22;
                    if (!TextUtils.isEmpty(str22)) {
                        str22 = str22.replace("{NAVIGATION_URL}", Uri.encode(str));
                        ax.m7464e();
                        jw.a(this.f6847a, "", str22);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public final boolean m7508b() {
        if (m7505c()) {
            if (!this.f6848b) {
                return false;
            }
        }
        return true;
    }
}
