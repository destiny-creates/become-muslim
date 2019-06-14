package com.google.android.gms.internal.ads;

import com.facebook.stetho.server.http.HttpStatus;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@cm
public final class mu implements ml {
    /* renamed from: a */
    private final String f24178a;

    public mu() {
        this(null);
    }

    public mu(String str) {
        this.f24178a = str;
    }

    /* renamed from: a */
    public final void mo4306a(String str) {
        String str2;
        String valueOf;
        StringBuilder stringBuilder;
        HttpURLConnection httpURLConnection;
        try {
            str2 = "Pinging URL: ";
            valueOf = String.valueOf(str);
            mt.m19918b(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            aph.m18683a();
            mi.m19872a(true, httpURLConnection, this.f24178a);
            mm mmVar = new mm();
            mmVar.m19909a(httpURLConnection, null);
            int responseCode = httpURLConnection.getResponseCode();
            mmVar.m19908a(httpURLConnection, responseCode);
            if (responseCode < HttpStatus.HTTP_OK || responseCode >= 300) {
                StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(str).length() + 65);
                stringBuilder2.append("Received non-success response code ");
                stringBuilder2.append(responseCode);
                stringBuilder2.append(" from pinging URL: ");
                stringBuilder2.append(str);
                mt.m19924e(stringBuilder2.toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            str2 = e.getMessage();
            stringBuilder = new StringBuilder((String.valueOf(str).length() + 32) + String.valueOf(str2).length());
            valueOf = "Error while parsing ping URL: ";
            stringBuilder.append(valueOf);
            stringBuilder.append(str);
            stringBuilder.append(". ");
            stringBuilder.append(str2);
            mt.m19924e(stringBuilder.toString());
        } catch (IOException e2) {
            str2 = e2.getMessage();
            stringBuilder = new StringBuilder((String.valueOf(str).length() + 27) + String.valueOf(str2).length());
            valueOf = "Error while pinging URL: ";
            stringBuilder.append(valueOf);
            stringBuilder.append(str);
            stringBuilder.append(". ");
            stringBuilder.append(str2);
            mt.m19924e(stringBuilder.toString());
        } catch (RuntimeException e3) {
            str2 = e3.getMessage();
            stringBuilder = new StringBuilder((String.valueOf(str).length() + 27) + String.valueOf(str2).length());
            valueOf = "Error while pinging URL: ";
            stringBuilder.append(valueOf);
            stringBuilder.append(str);
            stringBuilder.append(". ");
            stringBuilder.append(str2);
            mt.m19924e(stringBuilder.toString());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
