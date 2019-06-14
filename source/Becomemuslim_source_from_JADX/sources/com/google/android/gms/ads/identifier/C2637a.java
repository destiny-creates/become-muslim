package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import com.facebook.stetho.server.http.HttpStatus;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* renamed from: com.google.android.gms.ads.identifier.a */
final class C2637a extends Thread {
    /* renamed from: a */
    private final /* synthetic */ Map f6689a;

    C2637a(AdvertisingIdClient advertisingIdClient, Map map) {
        this.f6689a = map;
    }

    public final void run() {
        Throwable e;
        String str;
        String str2;
        C2639c c2639c = new C2639c();
        Map map = this.f6689a;
        Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str3 : map.keySet()) {
            String str32;
            buildUpon.appendQueryParameter(str32, (String) map.get(str32));
        }
        String uri = buildUpon.build().toString();
        HttpURLConnection httpURLConnection;
        StringBuilder stringBuilder;
        try {
            httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < HttpStatus.HTTP_OK || responseCode >= 300) {
                stringBuilder = new StringBuilder(String.valueOf(uri).length() + 65);
                stringBuilder.append("Received non-success response code ");
                stringBuilder.append(responseCode);
                stringBuilder.append(" from pinging URL: ");
                stringBuilder.append(uri);
                Log.w("HttpUrlPinger", stringBuilder.toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
            str = "HttpUrlPinger";
            str32 = e.getMessage();
            stringBuilder = new StringBuilder((String.valueOf(uri).length() + 32) + String.valueOf(str32).length());
            str2 = "Error while parsing ping URL: ";
            stringBuilder.append(str2);
            stringBuilder.append(uri);
            stringBuilder.append(". ");
            stringBuilder.append(str32);
            Log.w(str, stringBuilder.toString(), e);
        } catch (IOException e3) {
            e = e3;
            str = "HttpUrlPinger";
            str32 = e.getMessage();
            stringBuilder = new StringBuilder((String.valueOf(uri).length() + 27) + String.valueOf(str32).length());
            str2 = "Error while pinging URL: ";
            stringBuilder.append(str2);
            stringBuilder.append(uri);
            stringBuilder.append(". ");
            stringBuilder.append(str32);
            Log.w(str, stringBuilder.toString(), e);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
