package com.google.android.gms.p185e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.stetho.server.http.HttpStatus;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;

/* renamed from: com.google.android.gms.e.ef */
final class ef implements aj {
    /* renamed from: a */
    private final String f11710a;
    /* renamed from: b */
    private final Context f11711b;
    /* renamed from: c */
    private final ei f11712c;
    /* renamed from: d */
    private final eh f11713d;

    private ef(ei eiVar, Context context, eh ehVar) {
        this.f11712c = eiVar;
        this.f11711b = context.getApplicationContext();
        this.f11713d = ehVar;
        eiVar = "GoogleTagManager";
        context = "4.00";
        ehVar = VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        String str = null;
        if (locale != null) {
            if (locale.getLanguage() != null) {
                if (locale.getLanguage().length() != 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(locale.getLanguage().toLowerCase());
                    if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
                        stringBuilder.append("-");
                        stringBuilder.append(locale.getCountry().toLowerCase());
                    }
                    str = stringBuilder.toString();
                }
            }
        }
        String str2 = Build.MODEL;
        String str3 = Build.ID;
        this.f11710a = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{eiVar, context, ehVar, str, str2, str3});
    }

    ef(Context context, eh ehVar) {
        this(new eg(), context, ehVar);
    }

    /* renamed from: a */
    public final boolean mo2557a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f11711b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.isConnected()) {
                return true;
            }
        }
        bs.m8588e("...no network connectivity");
        return false;
    }

    /* renamed from: a */
    public final void mo2556a(List<aw> list) {
        Throwable th;
        InputStream inputStream;
        int min = Math.min(list.size(), 40);
        Object obj = 1;
        for (int i = 0; i < min; i++) {
            aw awVar = (aw) list.get(i);
            URL a = ef.m14561a(awVar);
            if (a == null) {
                bs.m8584b("No destination: discarding hit.");
                this.f11713d.mo2543b(awVar);
            } else {
                try {
                    HttpURLConnection a2 = this.f11712c.mo2558a(a);
                    if (obj != null) {
                        try {
                            bx.m8599a(this.f11711b);
                            obj = null;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = null;
                        }
                    }
                    a2.setRequestProperty("User-Agent", this.f11710a);
                    int responseCode = a2.getResponseCode();
                    inputStream = a2.getInputStream();
                    if (responseCode != HttpStatus.HTTP_OK) {
                        try {
                            StringBuilder stringBuilder = new StringBuilder(25);
                            stringBuilder.append("Bad response: ");
                            stringBuilder.append(responseCode);
                            bs.m8584b(stringBuilder.toString());
                            this.f11713d.mo2544c(awVar);
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } else {
                        this.f11713d.mo2542a(awVar);
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    a2.disconnect();
                } catch (IOException e) {
                    String str = "Exception sending hit: ";
                    String valueOf = String.valueOf(e.getClass().getSimpleName());
                    bs.m8584b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    bs.m8584b(e.getMessage());
                    this.f11713d.mo2544c(awVar);
                }
            }
        }
        return;
        if (inputStream != null) {
            inputStream.close();
        }
        a2.disconnect();
        throw th;
    }

    /* renamed from: a */
    private static java.net.URL m14561a(com.google.android.gms.p185e.aw r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r1 = r1.m8563c();
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x000a }
        r0.<init>(r1);	 Catch:{ MalformedURLException -> 0x000a }
        return r0;
    L_0x000a:
        r1 = "Error trying to parse the GTM url.";
        com.google.android.gms.p185e.bs.m8582a(r1);
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.ef.a(com.google.android.gms.e.aw):java.net.URL");
    }
}
