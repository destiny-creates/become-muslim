package com.facebook.react.modules.network;

import android.os.Build.VERSION;
import com.facebook.common.logging.FLog;
import expolib_v1.p321a.C6226k;
import expolib_v1.p321a.C6226k.C6225a;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.C7490w.C6243a;
import expolib_v1.p321a.ae;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OkHttpClientProvider {
    public static C7490w sClient;
    public static OkHttpClientFactory sFactory;

    public static void setOkHttpClientFactory(OkHttpClientFactory okHttpClientFactory) {
        sFactory = okHttpClientFactory;
    }

    public static C7490w getOkHttpClient() {
        if (sClient == null) {
            sClient = createClient();
        }
        return sClient;
    }

    public static void replaceOkHttpClient(C7490w c7490w) {
        sClient = c7490w;
    }

    public static C7490w createClient() {
        try {
            return (C7490w) Class.forName("host.exp.exponent.ReactNativeStaticHelpers").getMethod("getOkHttpClient", new Class[]{Class.class}).invoke(null, new Object[]{OkHttpClientProvider.class});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static C6243a createClientBuilder() {
        return enableTls12OnPreLollipop(new C6243a().a(0, TimeUnit.MILLISECONDS).b(0, TimeUnit.MILLISECONDS).c(0, TimeUnit.MILLISECONDS).a(new ReactCookieJarContainer()));
    }

    public static C6243a enableTls12OnPreLollipop(C6243a c6243a) {
        if (VERSION.SDK_INT >= 16 && VERSION.SDK_INT <= 19) {
            try {
                c6243a.a(new TLSSocketFactory());
                C6226k a = new C6225a(C6226k.f20250a).a(new ae[]{ae.f20130b}).a();
                List arrayList = new ArrayList();
                arrayList.add(a);
                arrayList.add(C6226k.f20251b);
                arrayList.add(C6226k.f20252c);
                c6243a.b(arrayList);
            } catch (Throwable e) {
                FLog.m5675e("OkHttpClientProvider", "Error while enabling TLS 1.2", e);
            }
        }
        return c6243a;
    }
}
