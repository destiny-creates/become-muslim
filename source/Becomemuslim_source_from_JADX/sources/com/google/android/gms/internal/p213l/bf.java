package com.google.android.gms.internal.p213l;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.C2895e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.google.android.gms.internal.l.bf */
public final class bf extends fl {
    /* renamed from: b */
    private final SSLSocketFactory f32799b;

    public bf(fm fmVar) {
        super(fmVar);
        this.f32799b = VERSION.SDK_INT < 19 ? new fx() : null;
    }

    /* renamed from: a */
    private static byte[] m44015a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        Throwable th;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                bArr = byteArrayOutputStream.toByteArray();
                if (inputStream != null) {
                    inputStream.close();
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public final /* bridge */ /* synthetic */ ad E_() {
        return super.E_();
    }

    public final /* bridge */ /* synthetic */ C8339w F_() {
        return super.F_();
    }

    public final /* bridge */ /* synthetic */ fs G_() {
        return super.G_();
    }

    /* renamed from: a */
    protected final HttpURLConnection m44016a(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            if (this.f32799b != null && (openConnection instanceof HttpsURLConnection)) {
                ((HttpsURLConnection) openConnection).setSSLSocketFactory(this.f32799b);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo6209c() {
        super.mo6209c();
    }

    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo6210d() {
        super.mo6210d();
    }

    /* renamed from: e */
    protected final boolean mo6850e() {
        return false;
    }

    /* renamed from: f */
    public final boolean m44022f() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r2.m42632I();
        r0 = r2.mo4752n();
        r1 = "connectivity";
        r0 = r0.getSystemService(r1);
        r0 = (android.net.ConnectivityManager) r0;
        r0 = r0.getActiveNetworkInfo();	 Catch:{ SecurityException -> 0x0014 }
        goto L_0x0015;
    L_0x0014:
        r0 = 0;
    L_0x0015:
        if (r0 == 0) goto L_0x001f;
    L_0x0017:
        r0 = r0.isConnected();
        if (r0 == 0) goto L_0x001f;
    L_0x001d:
        r0 = 1;
        return r0;
    L_0x001f:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.bf.f():boolean");
    }

    /* renamed from: l */
    public final /* bridge */ /* synthetic */ ak mo6211l() {
        return super.mo6211l();
    }

    /* renamed from: m */
    public final /* bridge */ /* synthetic */ C2895e mo4751m() {
        return super.mo4751m();
    }

    /* renamed from: n */
    public final /* bridge */ /* synthetic */ Context mo4752n() {
        return super.mo4752n();
    }

    /* renamed from: o */
    public final /* bridge */ /* synthetic */ az mo6212o() {
        return super.mo6212o();
    }

    /* renamed from: p */
    public final /* bridge */ /* synthetic */ fw mo6213p() {
        return super.mo6213p();
    }

    /* renamed from: q */
    public final /* bridge */ /* synthetic */ cb mo4753q() {
        return super.mo4753q();
    }

    /* renamed from: r */
    public final /* bridge */ /* synthetic */ bb mo4754r() {
        return super.mo4754r();
    }

    /* renamed from: s */
    public final /* bridge */ /* synthetic */ bm mo6214s() {
        return super.mo6214s();
    }

    /* renamed from: t */
    public final /* bridge */ /* synthetic */ aa mo6215t() {
        return super.mo6215t();
    }

    /* renamed from: u */
    public final /* bridge */ /* synthetic */ C5052x mo4755u() {
        return super.mo4755u();
    }
}
