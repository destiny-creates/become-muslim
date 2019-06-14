package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.p186f.C2954g;
import com.google.android.gms.p186f.C2955h;
import com.google.android.gms.p186f.C2958j;
import com.google.firebase.C5335b;
import java.io.IOException;
import java.util.concurrent.Executor;

final class au implements C5353b {
    /* renamed from: a */
    private final C5335b f24746a;
    /* renamed from: b */
    private final C5366q f24747b;
    /* renamed from: c */
    private final C5369w f24748c;
    /* renamed from: d */
    private final Executor f24749d;

    au(C5335b c5335b, C5366q c5366q, Executor executor) {
        this(c5335b, c5366q, executor, new C5369w(c5335b.m22611a(), c5366q));
    }

    /* renamed from: a */
    public final boolean mo4889a() {
        return true;
    }

    private au(C5335b c5335b, C5366q c5366q, Executor executor, C5369w c5369w) {
        this.f24746a = c5335b;
        this.f24747b = c5366q;
        this.f24748c = c5369w;
        this.f24749d = executor;
    }

    /* renamed from: b */
    public final boolean mo4891b() {
        return this.f24747b.m22782a() != 0;
    }

    /* renamed from: a */
    public final C2954g<Void> mo4886a(String str, String str2) {
        return C2958j.a(null);
    }

    /* renamed from: a */
    public final C2954g<String> mo4888a(String str, String str2, String str3, String str4) {
        return m32389b(m32386a(str, str3, str4, new Bundle()));
    }

    /* renamed from: a */
    public final C2954g<Void> mo4887a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String str4 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str3);
        bundle.putString(str4, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        str4 = String.valueOf("/topics/");
        str3 = String.valueOf(str3);
        return m32385a(m32389b(m32386a(str, str2, str3.length() != 0 ? str4.concat(str3) : new String(str4), bundle)));
    }

    /* renamed from: b */
    public final C2954g<Void> mo4890b(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String str4 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str3);
        bundle.putString(str4, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        bundle.putString("delete", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        str4 = String.valueOf("/topics/");
        str3 = String.valueOf(str3);
        return m32385a(m32389b(m32386a(str, str2, str3.length() != 0 ? str4.concat(str3) : new String(str4), bundle)));
    }

    /* renamed from: a */
    private final C2954g<Bundle> m32386a(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.f24746a.m22614c().m22622a());
        bundle.putString("gmsv", Integer.toString(this.f24747b.m22785d()));
        bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
        bundle.putString("app_ver", this.f24747b.m22783b());
        bundle.putString("app_ver_name", this.f24747b.m22784c());
        bundle.putString("cliv", "fiid-12451000");
        str = new C2955h();
        this.f24749d.execute(new av(this, bundle, str));
        return str.a();
    }

    /* renamed from: a */
    private static String m32387a(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            string = bundle.getString("unregistered");
            if (string != null) {
                return string;
            }
            string = bundle.getString("error");
            if ("RST".equals(string)) {
                throw new IOException("INSTANCE_ID_RESET");
            } else if (string != null) {
                throw new IOException(string);
            } else {
                bundle = String.valueOf(bundle);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(bundle).length() + 21);
                stringBuilder.append("Unexpected response: ");
                stringBuilder.append(bundle);
                Log.w("FirebaseInstanceId", stringBuilder.toString(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    /* renamed from: a */
    private final <T> C2954g<Void> m32385a(C2954g<T> c2954g) {
        return c2954g.a(al.m22722a(), new aw(this));
    }

    /* renamed from: b */
    private final C2954g<String> m32389b(C2954g<Bundle> c2954g) {
        return c2954g.a(this.f24749d, new ax(this));
    }

    /* renamed from: a */
    final /* synthetic */ void m32393a(Bundle bundle, C2955h c2955h) {
        try {
            c2955h.a(this.f24748c.m22796a(bundle));
        } catch (Bundle bundle2) {
            c2955h.a(bundle2);
        }
    }
}
