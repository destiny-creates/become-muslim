package com.facebook.ads.internal.p105q.p108c;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.p101p.p102a.C1443a;
import com.facebook.ads.internal.p101p.p102a.C1450n;
import com.facebook.ads.internal.p101p.p102a.C1452p;
import com.facebook.stetho.server.http.HttpStatus;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.facebook.ads.internal.q.c.e */
public class C1537e extends AsyncTask<String, Void, C1538f> {
    /* renamed from: a */
    private static final String f4548a = "e";
    /* renamed from: b */
    private static final Set<String> f4549b = new HashSet();
    /* renamed from: c */
    private Context f4550c;
    /* renamed from: d */
    private Map<String, String> f4551d;
    /* renamed from: e */
    private Map<String, String> f4552e;
    /* renamed from: f */
    private C1450n f4553f;
    /* renamed from: g */
    private C1536a f4554g;

    /* renamed from: com.facebook.ads.internal.q.c.e$a */
    public interface C1536a {
        /* renamed from: a */
        void mo1027a();

        /* renamed from: a */
        void mo1028a(C1538f c1538f);
    }

    static {
        f4549b.add("#");
        f4549b.add("null");
    }

    public C1537e(Context context) {
        this(context, null, null);
    }

    public C1537e(Context context, Map<String, String> map) {
        this(context, map, null);
    }

    public C1537e(Context context, Map<String, String> map, Map<String, String> map2) {
        this.f4550c = context;
        Map map3 = null;
        this.f4551d = map != null ? new HashMap(map) : null;
        if (map2 != null) {
            map3 = new HashMap(map2);
        }
        this.f4552e = map3;
    }

    /* renamed from: a */
    private String m5380a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        String str4 = str.contains("?") ? "&" : "?";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str4);
        stringBuilder.append(str2);
        stringBuilder.append("=");
        stringBuilder.append(URLEncoder.encode(str3));
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private boolean m5381a(String str) {
        C1443a a = C1535d.m5368a(this.f4550c);
        boolean z = false;
        try {
            C1450n b;
            if (this.f4552e != null) {
                if (this.f4552e.size() != 0) {
                    C1452p c1452p = new C1452p();
                    c1452p.m5140a(this.f4552e);
                    b = a.m5115b(str, c1452p);
                    this.f4553f = b;
                    if (this.f4553f != null && this.f4553f.m5133a() == HttpStatus.HTTP_OK) {
                        z = true;
                    }
                    return z;
                }
            }
            b = a.m5105a(str, null);
            this.f4553f = b;
            z = true;
            return z;
        } catch (Throwable e) {
            String str2 = f4548a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error opening url: ");
            stringBuilder.append(str);
            Log.e(str2, stringBuilder.toString(), e);
            return false;
        }
    }

    /* renamed from: b */
    private java.lang.String m5382b(java.lang.String r3) {
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
        r2 = this;
        r0 = com.facebook.ads.internal.p092g.C1384a.m4731a();	 Catch:{ Exception -> 0x000f }
        r1 = "analog";	 Catch:{ Exception -> 0x000f }
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5306a(r0);	 Catch:{ Exception -> 0x000f }
        r0 = r2.m5380a(r3, r1, r0);	 Catch:{ Exception -> 0x000f }
        return r0;
    L_0x000f:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.q.c.e.b(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    protected C1538f m5383a(String... strArr) {
        Object obj = strArr[0];
        if (!TextUtils.isEmpty(obj)) {
            if (!f4549b.contains(obj)) {
                String b = m5382b(obj);
                if (!(this.f4551d == null || this.f4551d.isEmpty())) {
                    for (Entry entry : this.f4551d.entrySet()) {
                        b = m5380a(b, (String) entry.getKey(), (String) entry.getValue());
                    }
                }
                int i = 1;
                while (true) {
                    int i2 = i + 1;
                    if (i > 2) {
                        break;
                    } else if (m5381a(b)) {
                        return new C1538f(this.f4553f);
                    } else {
                        i = i2;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m5384a(C1536a c1536a) {
        this.f4554g = c1536a;
    }

    /* renamed from: a */
    protected void m5385a(C1538f c1538f) {
        if (this.f4554g != null) {
            this.f4554g.mo1028a(c1538f);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m5383a((String[]) objArr);
    }

    protected void onCancelled() {
        if (this.f4554g != null) {
            this.f4554g.mo1027a();
        }
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m5385a((C1538f) obj);
    }
}
