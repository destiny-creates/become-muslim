package com.google.android.gms.internal.p213l;

import com.google.android.gms.common.internal.C2872v;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.l.bj */
final class bj implements Runnable {
    /* renamed from: a */
    private final URL f16978a;
    /* renamed from: b */
    private final byte[] f16979b;
    /* renamed from: c */
    private final bh f16980c;
    /* renamed from: d */
    private final String f16981d;
    /* renamed from: e */
    private final Map<String, String> f16982e;
    /* renamed from: f */
    private final /* synthetic */ bf f16983f;

    public bj(bf bfVar, String str, URL url, byte[] bArr, Map<String, String> map, bh bhVar) {
        this.f16983f = bfVar;
        C2872v.a(str);
        C2872v.a(url);
        C2872v.a(bhVar);
        this.f16978a = url;
        this.f16979b = bArr;
        this.f16980c = bhVar;
        this.f16981d = str;
        this.f16982e = map;
    }

    public final void run() {
        Map map;
        Throwable th;
        Throwable e;
        int i;
        cb q;
        Runnable biVar;
        this.f16983f.mo6209c();
        OutputStream outputStream = null;
        HttpURLConnection a;
        try {
            a = this.f16983f.m44016a(this.f16978a);
            try {
                if (this.f16982e != null) {
                    for (Entry entry : this.f16982e.entrySet()) {
                        a.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (this.f16979b != null) {
                    byte[] b = this.f16983f.G_().m44297b(this.f16979b);
                    this.f16983f.mo4754r().m42579w().m21308a("Uploading data. size", Integer.valueOf(b.length));
                    a.setDoOutput(true);
                    a.addRequestProperty("Content-Encoding", "gzip");
                    a.setFixedLengthStreamingMode(b.length);
                    a.connect();
                    OutputStream outputStream2 = a.getOutputStream();
                    try {
                        outputStream2.write(b);
                        outputStream2.close();
                    } catch (Throwable e2) {
                        map = null;
                        th = e2;
                        outputStream = outputStream2;
                        i = 0;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                this.f16983f.mo4754r().I_().m21309a("Error closing HTTP compressed POST connection output stream. appId", bb.m42550a(this.f16981d), e3);
                            }
                        }
                        if (a != null) {
                            a.disconnect();
                        }
                        q = this.f16983f.mo4753q();
                        biVar = new bi(this.f16981d, this.f16980c, i, th, null, map);
                        q.m42612a(r1);
                    } catch (Throwable th2) {
                        e2 = th2;
                        map = null;
                        outputStream = outputStream2;
                        i = 0;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e32) {
                                this.f16983f.mo4754r().I_().m21309a("Error closing HTTP compressed POST connection output stream. appId", bb.m42550a(this.f16981d), e32);
                            }
                        }
                        if (a != null) {
                            a.disconnect();
                        }
                        this.f16983f.mo4753q().m42612a(new bi(this.f16981d, this.f16980c, i, null, null, map));
                        throw e2;
                    }
                }
                i = a.getResponseCode();
            } catch (IOException e4) {
                e2 = e4;
                map = null;
                th = e2;
                i = 0;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                q = this.f16983f.mo4753q();
                biVar = new bi(this.f16981d, this.f16980c, i, th, null, map);
                q.m42612a(r1);
            } catch (Throwable th3) {
                e2 = th3;
                map = null;
                i = 0;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                this.f16983f.mo4753q().m42612a(new bi(this.f16981d, this.f16980c, i, null, null, map));
                throw e2;
            }
            try {
                map = a.getHeaderFields();
                try {
                    byte[] a2 = bf.m44015a(a);
                    if (a != null) {
                        a.disconnect();
                    }
                    q = this.f16983f.mo4753q();
                    biVar = new bi(this.f16981d, this.f16980c, i, null, a2, map);
                } catch (IOException e5) {
                    e2 = e5;
                    th = e2;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    q = this.f16983f.mo4753q();
                    biVar = new bi(this.f16981d, this.f16980c, i, th, null, map);
                    q.m42612a(r1);
                } catch (Throwable th4) {
                    e2 = th4;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f16983f.mo4753q().m42612a(new bi(this.f16981d, this.f16980c, i, null, null, map));
                    throw e2;
                }
            } catch (IOException e6) {
                e2 = e6;
                map = null;
                th = e2;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                q = this.f16983f.mo4753q();
                biVar = new bi(this.f16981d, this.f16980c, i, th, null, map);
                q.m42612a(r1);
            } catch (Throwable th5) {
                e2 = th5;
                map = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                this.f16983f.mo4753q().m42612a(new bi(this.f16981d, this.f16980c, i, null, null, map));
                throw e2;
            }
        } catch (IOException e7) {
            e2 = e7;
            a = null;
            map = a;
            th = e2;
            i = 0;
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.disconnect();
            }
            q = this.f16983f.mo4753q();
            biVar = new bi(this.f16981d, this.f16980c, i, th, null, map);
            q.m42612a(r1);
        } catch (Throwable th6) {
            e2 = th6;
            a = null;
            map = a;
            i = 0;
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.disconnect();
            }
            this.f16983f.mo4753q().m42612a(new bi(this.f16981d, this.f16980c, i, null, null, map));
            throw e2;
        }
        q.m42612a(r1);
    }
}
