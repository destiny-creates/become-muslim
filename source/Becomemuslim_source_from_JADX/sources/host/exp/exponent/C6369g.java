package host.exp.exponent;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.util.Log;
import android.util.LruCache;
import com.facebook.common.util.UriUtil;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.ServerProtocol;
import expolib_v1.p321a.C6214d;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.C6246z.C6245a;
import host.exp.exponent.p334a.C6288a;
import host.exp.exponent.p334a.C6288a.C6287a;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p337d.C7519c;
import host.exp.exponent.p339f.C6329a;
import host.exp.exponent.p339f.C6329a.C6322a;
import host.exp.exponent.p339f.C6339i;
import host.exp.exponent.p339f.C6355n;
import host.exp.exponent.p343g.C6362b;
import host.exp.exponent.p343g.C6364d;
import host.exp.exponent.p343g.C6366e.C6365a;
import host.exp.exponent.p343g.C6368f;
import host.exp.exponent.p344h.C6373d;
import host.exp.exponent.p346j.C6384b;
import host.exp.p333a.C6279c.C6272a;
import host.exp.p333a.C6279c.C6276e;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.inject.C6562a;
import org.apache.p371a.p376c.C6646d;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ExponentManifest */
/* renamed from: host.exp.exponent.g */
public class C6369g {
    /* renamed from: e */
    private static final String f20631e = "g";
    /* renamed from: f */
    private static boolean f20632f = false;
    /* renamed from: a */
    Context f20633a;
    /* renamed from: b */
    C6368f f20634b;
    /* renamed from: c */
    C6329a f20635c;
    /* renamed from: d */
    C6373d f20636d;
    /* renamed from: g */
    private LruCache<String, Bitmap> f20637g = new LruCache<String, Bitmap>(this, ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 16) {
        /* renamed from: a */
        final /* synthetic */ C6369g f20619a;

        protected /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return m26078a((String) obj, (Bitmap) obj2);
        }

        /* renamed from: a */
        protected int m26078a(String str, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024;
        }
    };

    /* compiled from: ExponentManifest */
    /* renamed from: host.exp.exponent.g$a */
    public interface C6359a {
        /* renamed from: a */
        void mo5380a(Bitmap bitmap);
    }

    /* compiled from: ExponentManifest */
    /* renamed from: host.exp.exponent.g$b */
    public interface C6360b {
        void onCompleted(JSONObject jSONObject);

        void onError(Exception exception);

        void onError(String str);
    }

    @C6562a
    public C6369g(Context context, C6368f c6368f, C6329a c6329a, C6373d c6373d) {
        this.f20633a = context;
        this.f20634b = c6368f;
        this.f20635c = c6329a;
        this.f20636d = c6373d;
    }

    /* renamed from: b */
    private Builder m26129b(String str) {
        if (str.contains("exp.host/--/to-exp/")) {
            str = Uri.decode(str.substring(str.indexOf("exp.host/--/to-exp/") + "exp.host/--/to-exp/".length()));
        }
        str = Uri.parse(C6339i.m26062a(str));
        String path = str.getPath();
        if (path == null) {
            path = "";
        }
        int indexOf = path.indexOf("--/");
        if (indexOf > -1) {
            path = path.substring(0, indexOf);
        }
        return str.buildUpon().encodedPath(path);
    }

    /* renamed from: a */
    public void m26141a(String str, C6360b c6360b) {
        m26142a(str, c6360b, true);
    }

    /* renamed from: a */
    public void m26142a(final String str, final C6360b c6360b, boolean z) {
        C6288a.m25941a(C6287a.STARTED_FETCHING_MANIFEST);
        Builder b = m26129b(str);
        if (!z) {
            b.appendQueryParameter("cache", "false");
        }
        z = C6339i.m26061a(b.build().toString(), str.equals(C6301d.f20496b), this.f20636d.m26167g());
        z.m25816a("Exponent-Accept-Signature", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        z.m25816a("Expo-JSON-Error", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        z.m25810a(C6214d.f20163a);
        C6288a.m25941a(C6287a.STARTED_MANIFEST_NETWORK_REQUEST);
        C6246z b2 = z.m25820b();
        final String c6237r = b2.m25821a().toString();
        this.f20634b.m26115a().m26104a(b2, new C6365a(this) {
            /* renamed from: d */
            final /* synthetic */ C6369g f26197d;

            /* renamed from: a */
            public void mo5374a(IOException iOException) {
                c6360b.onError(new C7519c(iOException, str));
            }

            /* renamed from: a */
            public void mo5372a(C6364d c6364d) {
                this.f26197d.m26123a(c6364d, str, c6237r, c6360b, false, c6364d.mo5427e() == null);
            }

            /* renamed from: a */
            public void mo5373a(C6364d c6364d, boolean z) {
                this.f26197d.m26123a(c6364d, str, c6237r, c6360b, z, true);
            }
        });
    }

    /* renamed from: b */
    public boolean m26143b(String str, C6360b c6360b) {
        C6369g c6369g = this;
        final String str2 = str;
        final C6360b c6360b2 = c6360b;
        Uri build = m26129b(str).build();
        String uri = build.toString();
        if (build.getHost() == null) {
            String str3 = "Could not load manifest.";
            StringBuilder stringBuilder;
            if (C6301d.m26001a()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str3);
                stringBuilder.append(" Are you sure this experience has been published?");
                str3 = stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str3);
                stringBuilder.append(" Are you sure this is a valid URL?");
                str3 = stringBuilder.toString();
            }
            c6360b2.onError(str3);
        }
        if (!build.getHost().equals("localhost")) {
            if (!build.getHost().endsWith(".exp.direct")) {
                C6245a a = C6339i.m26061a(uri, str2.equals(C6301d.f20496b), c6369g.f20636d.m26167g());
                a.m25816a("Exponent-Accept-Signature", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                a.m25816a("Expo-JSON-Error", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                C6246z b = a.m25820b();
                final String c6237r = b.m25821a().toString();
                String d = c6369g.f20636d.m26163d(str2);
                if (d != null) {
                    try {
                        m26126a(str, c6237r, d, null, c6360b, false, true);
                        return true;
                    } catch (Throwable e) {
                        C6289b.m25950a(f20631e, e);
                    }
                }
                c6369g.f20634b.m26115a().m26105a(c6237r, b, new C6365a(this) {
                    /* renamed from: d */
                    final /* synthetic */ C6369g f26201d;

                    /* renamed from: a */
                    public void mo5374a(IOException iOException) {
                        c6360b2.onError(new C7519c(iOException, str2));
                    }

                    /* renamed from: a */
                    public void mo5372a(C6364d c6364d) {
                        this.f26201d.m26123a(c6364d, str2, c6237r, c6360b2, false, true);
                    }

                    /* renamed from: a */
                    public void mo5373a(C6364d c6364d, boolean z) {
                        this.f26201d.m26123a(c6364d, str2, c6237r, c6360b2, z, true);
                    }
                }, null, null);
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public void m26144c(String str, C6360b c6360b) {
        C6245a a = C6339i.m26061a(m26129b(str).build().toString(), str.equals(C6301d.f20496b), this.f20636d.m26167g());
        a.m25816a("Exponent-Accept-Signature", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        a.m25816a("Expo-JSON-Error", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        try {
            JSONObject jSONObject = new JSONObject(this.f20634b.m26115a().m26102a(a.m25820b().m25821a().toString()));
            jSONObject.put("loadedFromCache", true);
            m26127a(str, jSONObject, true, c6360b);
        } catch (String str2) {
            c6360b.onError(new Exception("Could not load embedded manifest. Are you sure this experience has been published?", str2));
            str2.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m26123a(host.exp.exponent.p343g.C6364d r10, java.lang.String r11, java.lang.String r12, host.exp.exponent.C6369g.C6360b r13, boolean r14, boolean r15) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = r10.mo5423a();
        if (r0 != 0) goto L_0x0023;
    L_0x0006:
        r12 = 0;
        r14 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x001a, JSONException -> 0x001a }
        r10 = r10.mo5424b();	 Catch:{ JSONException -> 0x001a, JSONException -> 0x001a }
        r10 = r10.mo5419a();	 Catch:{ JSONException -> 0x001a, JSONException -> 0x001a }
        r14.<init>(r10);	 Catch:{ JSONException -> 0x001a, JSONException -> 0x001a }
        r10 = new host.exp.exponent.d.c;	 Catch:{ JSONException -> 0x001a, JSONException -> 0x001a }
        r10.<init>(r12, r11, r14);	 Catch:{ JSONException -> 0x001a, JSONException -> 0x001a }
        goto L_0x001f;
    L_0x001a:
        r10 = new host.exp.exponent.d.c;
        r10.<init>(r12, r11);
    L_0x001f:
        r13.onError(r10);
        return;
    L_0x0023:
        r0 = r10.mo5424b();	 Catch:{ JSONException -> 0x0043, IOException -> 0x003e, URISyntaxException -> 0x0039 }
        r4 = r0.mo5419a();	 Catch:{ JSONException -> 0x0043, IOException -> 0x003e, URISyntaxException -> 0x0039 }
        r5 = r10.mo5426d();	 Catch:{ JSONException -> 0x0043, IOException -> 0x003e, URISyntaxException -> 0x0039 }
        r1 = r9;	 Catch:{ JSONException -> 0x0043, IOException -> 0x003e, URISyntaxException -> 0x0039 }
        r2 = r11;	 Catch:{ JSONException -> 0x0043, IOException -> 0x003e, URISyntaxException -> 0x0039 }
        r3 = r12;	 Catch:{ JSONException -> 0x0043, IOException -> 0x003e, URISyntaxException -> 0x0039 }
        r6 = r13;	 Catch:{ JSONException -> 0x0043, IOException -> 0x003e, URISyntaxException -> 0x0039 }
        r7 = r14;	 Catch:{ JSONException -> 0x0043, IOException -> 0x003e, URISyntaxException -> 0x0039 }
        r8 = r15;	 Catch:{ JSONException -> 0x0043, IOException -> 0x003e, URISyntaxException -> 0x0039 }
        r1.m26126a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ JSONException -> 0x0043, IOException -> 0x003e, URISyntaxException -> 0x0039 }
        goto L_0x0047;
    L_0x0039:
        r10 = move-exception;
        r13.onError(r10);
        goto L_0x0047;
    L_0x003e:
        r10 = move-exception;
        r13.onError(r10);
        goto L_0x0047;
    L_0x0043:
        r10 = move-exception;
        r13.onError(r10);
    L_0x0047:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.g.a(host.exp.exponent.g.d, java.lang.String, java.lang.String, host.exp.exponent.g$b, boolean, boolean):void");
    }

    /* renamed from: a */
    private JSONObject m26122a(JSONObject jSONObject, JSONObject jSONObject2) {
        String optString = jSONObject.optString("commitTime");
        if (optString == null) {
            optString = jSONObject.getString("publishedTime");
        }
        String optString2 = jSONObject2.optString("commitTime");
        if (optString2 == null) {
            optString2 = jSONObject2.getString("publishedTime");
        }
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        return simpleDateFormat.parse(optString).after(simpleDateFormat.parse(optString2)) ? jSONObject : jSONObject2;
    }

    /* renamed from: c */
    private org.json.JSONObject m26133c(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0006 }
        r0.<init>(r6);	 Catch:{ JSONException -> 0x0006 }
        return r0;
    L_0x0006:
        r0 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0049 }
        r0.<init>(r6);	 Catch:{ JSONException -> 0x0049 }
        r1 = 0;	 Catch:{ JSONException -> 0x0049 }
    L_0x000c:
        r2 = r0.length();	 Catch:{ JSONException -> 0x0049 }
        if (r1 >= r2) goto L_0x0028;	 Catch:{ JSONException -> 0x0049 }
    L_0x0012:
        r2 = r0.getJSONObject(r1);	 Catch:{ JSONException -> 0x0049 }
        r3 = "sdkVersion";	 Catch:{ JSONException -> 0x0049 }
        r3 = r2.getString(r3);	 Catch:{ JSONException -> 0x0049 }
        r4 = host.exp.exponent.C6301d.f20500f;	 Catch:{ JSONException -> 0x0049 }
        r3 = r4.contains(r3);	 Catch:{ JSONException -> 0x0049 }
        if (r3 == 0) goto L_0x0025;
    L_0x0024:
        return r2;
    L_0x0025:
        r1 = r1 + 1;
        goto L_0x000c;
    L_0x0028:
        r0 = new java.io.IOException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "No compatible manifest found. SDK Versions supported: ";
        r1.append(r2);
        r2 = host.exp.exponent.C6301d.f20499e;
        r1.append(r2);
        r2 = " Provided manifestString: ";
        r1.append(r2);
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        throw r0;
    L_0x0049:
        r0 = move-exception;
        r1 = new java.io.IOException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Manifest string is not a valid JSONObject or JSONArray: ";
        r2.append(r3);
        r2.append(r6);
        r6 = r2.toString();
        r1.<init>(r6, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.g.c(java.lang.String):org.json.JSONObject");
    }

    /* renamed from: a */
    private void m26126a(String str, String str2, String str3, C6362b c6362b, C6360b c6360b, boolean z, boolean z2) {
        String a;
        boolean z3;
        boolean z4;
        boolean a2;
        final JSONObject jSONObject;
        String path;
        String string;
        StringBuilder stringBuilder;
        C6369g c6369g = this;
        String str4 = str;
        C6362b c6362b2 = c6362b;
        C6360b c6360b2 = c6360b;
        if (c6362b2 != null) {
            C6288a.m25941a(C6287a.FINISHED_MANIFEST_NETWORK_REQUEST);
        }
        JSONObject c = m26133c(str3);
        boolean equals = str4.equals(C6301d.f20496b);
        URI uri = new URI(str4);
        Object obj = (c.has("manifestString") && c.has("signature")) ? 1 : null;
        JSONObject jSONObject2 = obj != null ? new JSONObject(c.getString("manifestString")) : c;
        if (!z && z2) {
            a = c6369g.f20634b.m26115a().m26102a(str2);
            if (a != null) {
                try {
                    JSONObject jSONObject3 = new JSONObject(a);
                    JSONObject a3 = m26122a(jSONObject3, jSONObject2);
                    z3 = jSONObject3 == a3;
                    jSONObject2 = a3;
                } catch (Throwable e) {
                    C6289b.m25950a(f20631e, e);
                }
                a = "loadedFromCache";
                if (!z2) {
                    if (z3) {
                        z4 = false;
                        jSONObject2.put(a, z4);
                        if (obj == null) {
                            a2 = C6368f.m26111a(c6369g.f20633a) ^ 1;
                            if (!(m26134c(jSONObject2) || equals)) {
                                if (z3) {
                                    equals = a2;
                                    str4 = str;
                                    jSONObject = jSONObject2;
                                    c6360b2 = c6360b;
                                    c6369g.f20635c.m26046a("https://exp.host/--/manifest-public-key", c.getString("manifestString"), c.getString("signature"), new C6322a(this) {
                                        /* renamed from: e */
                                        final /* synthetic */ C6369g f26206e;

                                        /* renamed from: a */
                                        public void mo5416a(String str, boolean z) {
                                            if (equals && z) {
                                                this.f26206e.m26127a(str4, jSONObject, true, c6360b2);
                                                return;
                                            }
                                            Log.w(C6369g.f20631e, str);
                                            this.f26206e.m26127a(str4, jSONObject, false, c6360b2);
                                        }

                                        /* renamed from: a */
                                        public void mo5417a(boolean z) {
                                            this.f26206e.m26127a(str4, jSONObject, z, c6360b2);
                                        }
                                    });
                                }
                            }
                            m26127a(str4, jSONObject2, true, c6360b2);
                        } else {
                            if (!(z2 || z3)) {
                                if (equals) {
                                    if (m26128a(uri)) {
                                        m26127a(str4, jSONObject2, false, c6360b2);
                                    } else {
                                        if (!C6301d.m26001a()) {
                                            a = uri.getScheme();
                                            if (!a.equals(UriUtil.HTTPS_SCHEME)) {
                                                if (!a.equals("exps")) {
                                                    a = "UNVERIFIED-";
                                                    path = uri.getPath() == null ? uri.getPath() : "";
                                                    string = jSONObject2.has("slug") ? jSONObject2.getString("slug") : "";
                                                    stringBuilder = new StringBuilder();
                                                    stringBuilder.append(a);
                                                    stringBuilder.append(uri.getHost());
                                                    stringBuilder.append(path);
                                                    stringBuilder.append("-");
                                                    stringBuilder.append(string);
                                                    jSONObject2.put("id", stringBuilder.toString());
                                                }
                                            }
                                            a = "";
                                            if (uri.getPath() == null) {
                                            }
                                            if (jSONObject2.has("slug")) {
                                            }
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append(a);
                                            stringBuilder.append(uri.getHost());
                                            stringBuilder.append(path);
                                            stringBuilder.append("-");
                                            stringBuilder.append(string);
                                            jSONObject2.put("id", stringBuilder.toString());
                                        }
                                        m26127a(str4, jSONObject2, true, c6360b2);
                                    }
                                }
                            }
                            m26127a(str4, jSONObject2, true, c6360b2);
                        }
                        if (c6362b2 == null) {
                            a = c6362b2.mo5422a("Exponent-Server");
                            if (a == null) {
                                try {
                                    C6288a.m25945a("LOAD_DEVELOPER_MANIFEST", new JSONObject(a));
                                } catch (Throwable e2) {
                                    C6289b.m25950a(f20631e, e2);
                                    return;
                                }
                            }
                        }
                    }
                }
                z4 = true;
                jSONObject2.put(a, z4);
                if (obj == null) {
                    a2 = C6368f.m26111a(c6369g.f20633a) ^ 1;
                    if (z3) {
                        equals = a2;
                        str4 = str;
                        jSONObject = jSONObject2;
                        c6360b2 = c6360b;
                        c6369g.f20635c.m26046a("https://exp.host/--/manifest-public-key", c.getString("manifestString"), c.getString("signature"), /* anonymous class already generated */);
                    } else {
                        m26127a(str4, jSONObject2, true, c6360b2);
                    }
                } else if (equals) {
                    m26127a(str4, jSONObject2, true, c6360b2);
                } else if (m26128a(uri)) {
                    m26127a(str4, jSONObject2, false, c6360b2);
                } else {
                    if (C6301d.m26001a()) {
                        a = uri.getScheme();
                        if (a.equals(UriUtil.HTTPS_SCHEME)) {
                            if (!a.equals("exps")) {
                                a = "UNVERIFIED-";
                                if (uri.getPath() == null) {
                                }
                                if (jSONObject2.has("slug")) {
                                }
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(a);
                                stringBuilder.append(uri.getHost());
                                stringBuilder.append(path);
                                stringBuilder.append("-");
                                stringBuilder.append(string);
                                jSONObject2.put("id", stringBuilder.toString());
                            }
                        }
                        a = "";
                        if (uri.getPath() == null) {
                        }
                        if (jSONObject2.has("slug")) {
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(a);
                        stringBuilder.append(uri.getHost());
                        stringBuilder.append(path);
                        stringBuilder.append("-");
                        stringBuilder.append(string);
                        jSONObject2.put("id", stringBuilder.toString());
                    }
                    m26127a(str4, jSONObject2, true, c6360b2);
                }
                if (c6362b2 == null) {
                    a = c6362b2.mo5422a("Exponent-Server");
                    if (a == null) {
                        C6288a.m25945a("LOAD_DEVELOPER_MANIFEST", new JSONObject(a));
                    }
                }
            }
        }
        z3 = z;
        a = "loadedFromCache";
        if (z2) {
            if (z3) {
                z4 = false;
                jSONObject2.put(a, z4);
                if (obj == null) {
                    a2 = C6368f.m26111a(c6369g.f20633a) ^ 1;
                    if (z3) {
                        m26127a(str4, jSONObject2, true, c6360b2);
                    } else {
                        equals = a2;
                        str4 = str;
                        jSONObject = jSONObject2;
                        c6360b2 = c6360b;
                        c6369g.f20635c.m26046a("https://exp.host/--/manifest-public-key", c.getString("manifestString"), c.getString("signature"), /* anonymous class already generated */);
                    }
                } else if (equals) {
                    m26127a(str4, jSONObject2, true, c6360b2);
                } else if (m26128a(uri)) {
                    if (C6301d.m26001a()) {
                        a = uri.getScheme();
                        if (a.equals(UriUtil.HTTPS_SCHEME)) {
                            if (!a.equals("exps")) {
                                a = "UNVERIFIED-";
                                if (uri.getPath() == null) {
                                }
                                if (jSONObject2.has("slug")) {
                                }
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(a);
                                stringBuilder.append(uri.getHost());
                                stringBuilder.append(path);
                                stringBuilder.append("-");
                                stringBuilder.append(string);
                                jSONObject2.put("id", stringBuilder.toString());
                            }
                        }
                        a = "";
                        if (uri.getPath() == null) {
                        }
                        if (jSONObject2.has("slug")) {
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(a);
                        stringBuilder.append(uri.getHost());
                        stringBuilder.append(path);
                        stringBuilder.append("-");
                        stringBuilder.append(string);
                        jSONObject2.put("id", stringBuilder.toString());
                    }
                    m26127a(str4, jSONObject2, true, c6360b2);
                } else {
                    m26127a(str4, jSONObject2, false, c6360b2);
                }
                if (c6362b2 == null) {
                    a = c6362b2.mo5422a("Exponent-Server");
                    if (a == null) {
                        C6288a.m25945a("LOAD_DEVELOPER_MANIFEST", new JSONObject(a));
                    }
                }
            }
        }
        z4 = true;
        jSONObject2.put(a, z4);
        if (obj == null) {
            a2 = C6368f.m26111a(c6369g.f20633a) ^ 1;
            if (z3) {
                equals = a2;
                str4 = str;
                jSONObject = jSONObject2;
                c6360b2 = c6360b;
                c6369g.f20635c.m26046a("https://exp.host/--/manifest-public-key", c.getString("manifestString"), c.getString("signature"), /* anonymous class already generated */);
            } else {
                m26127a(str4, jSONObject2, true, c6360b2);
            }
        } else if (equals) {
            m26127a(str4, jSONObject2, true, c6360b2);
        } else if (m26128a(uri)) {
            m26127a(str4, jSONObject2, false, c6360b2);
        } else {
            if (C6301d.m26001a()) {
                a = uri.getScheme();
                if (a.equals(UriUtil.HTTPS_SCHEME)) {
                    if (!a.equals("exps")) {
                        a = "UNVERIFIED-";
                        if (uri.getPath() == null) {
                        }
                        if (jSONObject2.has("slug")) {
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(a);
                        stringBuilder.append(uri.getHost());
                        stringBuilder.append(path);
                        stringBuilder.append("-");
                        stringBuilder.append(string);
                        jSONObject2.put("id", stringBuilder.toString());
                    }
                }
                a = "";
                if (uri.getPath() == null) {
                }
                if (jSONObject2.has("slug")) {
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(uri.getHost());
                stringBuilder.append(path);
                stringBuilder.append("-");
                stringBuilder.append(string);
                jSONObject2.put("id", stringBuilder.toString());
            }
            m26127a(str4, jSONObject2, true, c6360b2);
        }
        if (c6362b2 == null) {
            a = c6362b2.mo5422a("Exponent-Server");
            if (a == null) {
                C6288a.m25945a("LOAD_DEVELOPER_MANIFEST", new JSONObject(a));
            }
        }
    }

    /* renamed from: a */
    private boolean m26128a(URI uri) {
        uri = uri.getHost();
        if (!(uri.equals("exp.host") || uri.equals("expo.io") || uri.equals("exp.direct") || uri.equals("expo.test") || uri.endsWith(".exp.host") || uri.endsWith(".expo.io") || uri.endsWith(".exp.direct"))) {
            if (uri.endsWith(".expo.test") == null) {
                uri = null;
                return uri ^ 1;
            }
        }
        uri = true;
        return uri ^ 1;
    }

    /* renamed from: a */
    private void m26127a(String str, JSONObject jSONObject, boolean z, C6360b c6360b) {
        if (jSONObject.has("bundleUrl") == null) {
            c6360b.onError("No bundleUrl in manifest");
            return;
        }
        try {
            jSONObject.put("isVerified", z);
            c6360b.onCompleted(jSONObject);
        } catch (Exception e) {
            c6360b.onError(e);
        }
    }

    /* renamed from: a */
    public JSONObject m26139a(String str, JSONObject jSONObject) {
        if (!jSONObject.has("id")) {
            jSONObject.put("id", str);
        }
        if (jSONObject.has("name") == null) {
            jSONObject.put("name", "My New Experience");
        }
        if (jSONObject.has("primaryColor") == null) {
            jSONObject.put("primaryColor", "#023C69");
        }
        if (jSONObject.has("iconUrl") == null) {
            jSONObject.put("iconUrl", "https://d3lwq5rlu14cro.cloudfront.net/ExponentEmptyManifest_192.png");
        }
        if (jSONObject.has("orientation") == null) {
            jSONObject.put("orientation", "default");
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void m26140a(final String str, final C6359a c6359a) {
        if (str == null || str.isEmpty()) {
            c6359a.mo5380a(BitmapFactory.decodeResource(this.f20633a.getResources(), C6276e.ic_launcher));
        } else {
            Bitmap bitmap = (Bitmap) this.f20637g.get(str);
            if (bitmap != null) {
                c6359a.mo5380a(bitmap);
                return;
            }
            new AsyncTask<Void, Void, Bitmap>(this) {
                /* renamed from: c */
                final /* synthetic */ C6369g f20622c;

                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m26079a((Void[]) objArr);
                }

                protected /* synthetic */ void onPostExecute(Object obj) {
                    m26080a((Bitmap) obj);
                }

                /* renamed from: a */
                protected Bitmap m26079a(Void... voidArr) {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.connect();
                        voidArr = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                        int width = voidArr.getWidth();
                        int height = voidArr.getHeight();
                        if (width > JfifUtil.MARKER_SOFn || height > JfifUtil.MARKER_SOFn) {
                            float max = (float) Math.max(width, height);
                            voidArr = Bitmap.createScaledBitmap(voidArr, (int) ((((float) width) * 192.0f) / max), (int) ((((float) height) * 192.0f) / max), true);
                            this.f20622c.f20637g.put(str, voidArr);
                            return voidArr;
                        }
                        this.f20622c.f20637g.put(str, voidArr);
                        return voidArr;
                    } catch (Throwable e) {
                        C6289b.m25950a(C6369g.f20631e, e);
                        return BitmapFactory.decodeResource(this.f20622c.f20633a.getResources(), C6276e.ic_launcher);
                    } catch (Throwable e2) {
                        C6289b.m25950a(C6369g.f20631e, e2);
                        return BitmapFactory.decodeResource(this.f20622c.f20633a.getResources(), C6276e.ic_launcher);
                    }
                }

                /* renamed from: a */
                protected void m26080a(Bitmap bitmap) {
                    c6359a.mo5380a(bitmap);
                }
            }.execute(new Void[null]);
        }
    }

    /* renamed from: a */
    public int m26136a(JSONObject jSONObject) {
        jSONObject = jSONObject.optString("primaryColor");
        if (jSONObject == null || !C6384b.m26192a(jSONObject)) {
            return C6272a.colorPrimary;
        }
        return Color.parseColor(jSONObject);
    }

    /* renamed from: c */
    private boolean m26134c(JSONObject jSONObject) {
        if (jSONObject.has("id")) {
            jSONObject = jSONObject.optString("id");
            if (!(jSONObject == null || jSONObject.startsWith("@anonymous/") == null)) {
                return true;
            }
        }
        return null;
    }

    /* renamed from: c */
    private JSONObject m26132c() {
        try {
            JSONObject jSONObject = new JSONObject("{\"android\":{\"package\":\"host.exp.exponent\"},\"description\":\"\",\"extra\":{\"amplitudeApiKey\":\"081e5ec53f869b440b225d5e40ec73f9\"},\"icon\":\"https://s3.amazonaws.com/exp-brand-assets/ExponentEmptyManifest_192.png\",\"iconUrl\":\"https://s3.amazonaws.com/exp-brand-assets/ExponentEmptyManifest_192.png\",\"ios\":{\"bundleIdentifier\":\"host.exp.exponent\",\"supportsTablet\":true},\"locales\":{},\"name\":\"expo-home\",\"orientation\":\"portrait\",\"packagerOpts\":{\"config\":\"rn-cli.config.js\"},\"platforms\":[\"ios\",\"android\"],\"primaryColor\":\"#cccccc\",\"privacy\":\"unlisted\",\"scheme\":\"exp\",\"sdkVersion\":\"UNVERSIONED\",\"slug\":\"expo-home-dev-80c1c20fa4afd3e17e37fa9a8317268844d9b789\",\"updates\":{\"checkAutomatically\":\"ON_LOAD\",\"fallbackToCacheTimeout\":0},\"version\":\"32.0.0\",\"id\":\"@expo-home-dev/expo-home-dev-80c1c20fa4afd3e17e37fa9a8317268844d9b789\",\"revisionId\":\"32.0.0-r.N6Br90z2ad\",\"publishedTime\":\"2019-02-01T22:31:44.627Z\",\"commitTime\":\"2019-02-01T22:31:44.732Z\",\"bundleUrl\":\"https://d1wp6m56sqw74a.cloudfront.net/%40expo-home-dev%2Fexpo-home-dev-80c1c20fa4afd3e17e37fa9a8317268844d9b789%2F32.0.0%2Fe71a1feecbfc512ba3617522b090c785-32.0.0-android.js\",\"releaseChannel\":\"default\",\"hostUri\":\"expo.io/@expo-home-dev/expo-home-dev-80c1c20fa4afd3e17e37fa9a8317268844d9b789\"}");
            jSONObject.put("isVerified", true);
            return jSONObject;
        } catch (JSONException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can't get local manifest: ");
            stringBuilder.append(e.toString());
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    /* renamed from: d */
    private JSONObject m26135d() {
        try {
            JSONObject jSONObject = new JSONObject(C6646d.m27063b(this.f20633a.getAssets().open("kernel-manifest.json")));
            jSONObject.put("isVerified", true);
            return jSONObject;
        } catch (Exception e) {
            C6355n.m26073a().mo5407a(e);
            return null;
        }
    }

    /* renamed from: a */
    public JSONObject m26138a() {
        String str;
        JSONObject d;
        if (this.f20636d.m26159b()) {
            str = "Using remote Expo kernel manifest";
            d = m26135d();
        } else {
            str = "Using local Expo kernel manifest";
            d = m26132c();
        }
        if (!f20632f) {
            f20632f = true;
            String str2 = f20631e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(d.toString());
            C6289b.m25949a(str2, stringBuilder.toString());
        }
        return d;
    }

    /* renamed from: a */
    public String m26137a(String str) {
        try {
            return m26138a().getString(str);
        } catch (Exception e) {
            C6355n.m26073a().mo5407a(e);
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m26131b(org.json.JSONObject r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r2 == 0) goto L_0x0024;
    L_0x0003:
        r1 = "developer";	 Catch:{ JSONException -> 0x0023 }
        r1 = r2.has(r1);	 Catch:{ JSONException -> 0x0023 }
        if (r1 == 0) goto L_0x0024;	 Catch:{ JSONException -> 0x0023 }
    L_0x000b:
        r1 = "packagerOpts";	 Catch:{ JSONException -> 0x0023 }
        r1 = r2.has(r1);	 Catch:{ JSONException -> 0x0023 }
        if (r1 == 0) goto L_0x0024;	 Catch:{ JSONException -> 0x0023 }
    L_0x0013:
        r1 = "packagerOpts";	 Catch:{ JSONException -> 0x0023 }
        r2 = r2.getJSONObject(r1);	 Catch:{ JSONException -> 0x0023 }
        r1 = "dev";	 Catch:{ JSONException -> 0x0023 }
        r2 = r2.optBoolean(r1, r0);	 Catch:{ JSONException -> 0x0023 }
        if (r2 == 0) goto L_0x0024;
    L_0x0021:
        r0 = 1;
        goto L_0x0024;
    L_0x0023:
        return r0;
    L_0x0024:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.g.b(org.json.JSONObject):boolean");
    }
}
