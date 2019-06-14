package net.openid.appauth.p369b;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import net.openid.appauth.C6605p;

/* compiled from: DefaultConnectionBuilder */
/* renamed from: net.openid.appauth.b.b */
public final class C7639b implements C6575a {
    /* renamed from: a */
    public static final C7639b f26409a = new C7639b();
    /* renamed from: b */
    private static final int f26410b = ((int) TimeUnit.SECONDS.toMillis(15));
    /* renamed from: c */
    private static final int f26411c = ((int) TimeUnit.SECONDS.toMillis(10));

    private C7639b() {
    }

    public HttpURLConnection openConnection(Uri uri) {
        C6605p.m26933a((Object) uri, (Object) "url must not be null");
        C6605p.m26935a(UriUtil.HTTPS_SCHEME.equals(uri.getScheme()), (Object) "only https connections are permitted");
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(f26410b);
        httpURLConnection.setReadTimeout(f26411c);
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }
}
