package com.google.android.gms.auth.api.signin.internal;

import com.facebook.stetho.server.http.HttpHeaders;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.C2790h;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C4773n;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.p178b.C2823a;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.google.android.gms.auth.api.signin.internal.f */
public final class C2744f implements Runnable {
    /* renamed from: a */
    private static final C2823a f7035a = new C2823a("RevokeAccessOperation", new String[0]);
    /* renamed from: b */
    private final String f7036b;
    /* renamed from: c */
    private final C4773n f7037c = new C4773n(null);

    private C2744f(String str) {
        C2872v.m8382a(str);
        this.f7036b = str;
    }

    public final void run() {
        String valueOf;
        C2814k c2814k = Status.f13153c;
        String valueOf2;
        C2823a c2823a;
        try {
            String valueOf3 = String.valueOf("https://accounts.google.com/o/oauth2/revoke?token=");
            valueOf2 = String.valueOf(this.f7036b);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3)).openConnection();
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpStatus.HTTP_OK) {
                c2814k = Status.f13151a;
            } else {
                f7035a.m8117d("Unable to revoke access!", new Object[0]);
            }
            c2823a = f7035a;
            StringBuilder stringBuilder = new StringBuilder(26);
            stringBuilder.append("Response Code: ");
            stringBuilder.append(responseCode);
            c2823a.m8113a(stringBuilder.toString(), new Object[0]);
        } catch (IOException e) {
            c2823a = f7035a;
            valueOf2 = "IOException when revoking access: ";
            valueOf = String.valueOf(e.toString());
            c2823a.m8117d(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2), new Object[0]);
        } catch (Exception e2) {
            c2823a = f7035a;
            valueOf2 = "Exception when revoking access: ";
            valueOf = String.valueOf(e2.toString());
            c2823a.m8117d(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2), new Object[0]);
        }
        this.f7037c.m14069b(c2814k);
    }

    /* renamed from: a */
    public static C2789g<Status> m7813a(String str) {
        if (str == null) {
            return C2790h.m7966a(new Status(4), null);
        }
        Object c2744f = new C2744f(str);
        new Thread(c2744f).start();
        return c2744f.f7037c;
    }
}
