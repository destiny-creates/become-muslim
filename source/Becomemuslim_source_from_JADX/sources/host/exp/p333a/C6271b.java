package host.exp.p333a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.os.UserManager;
import android.provider.Settings;
import android.util.Log;
import com.facebook.common.internal.ByteStreams;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.common.Utf8Charset;
import com.p064b.p065a.C3414a;
import com.raizlabs.android.dbflow.config.C5680f;
import expo.p304a.p305a.C6002i;
import expo.p304a.p305a.C6003j;
import expolib_v1.p321a.C6214d;
import expolib_v1.p321a.C6216e;
import expolib_v1.p321a.C6217f;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.ab;
import host.exp.exponent.C6292b;
import host.exp.exponent.C6356f;
import host.exp.exponent.C6369g;
import host.exp.exponent.C6369g.C6360b;
import host.exp.exponent.C6394j;
import host.exp.exponent.p334a.C6288a;
import host.exp.exponent.p334a.C6288a.C6287a;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p339f.C6339i;
import host.exp.exponent.p343g.C6363c;
import host.exp.exponent.p343g.C6364d;
import host.exp.exponent.p343g.C6366e.C6365a;
import host.exp.exponent.p343g.C6368f;
import host.exp.exponent.p346j.C6391h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.C6562a;
import org.apache.p371a.p376c.C6646d;
import org.apache.p371a.p376c.p377a.C6640a;
import org.apache.p371a.p376c.p377a.C7680d;
import org.json.JSONArray;
import org.json.JSONObject;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import versioned.host.exp.exponent.ExponentPackageDelegate;

/* compiled from: Exponent */
/* renamed from: host.exp.a.b */
public class C6271b {
    /* renamed from: d */
    private static final String f20411d = "b";
    /* renamed from: e */
    private static C6271b f20412e;
    /* renamed from: m */
    private static Provider f20413m;
    @C6562a
    /* renamed from: a */
    C6368f f20414a;
    @C6562a
    /* renamed from: b */
    C6369g f20415b;
    @C6562a
    /* renamed from: c */
    C6356f f20416c;
    /* renamed from: f */
    private Context f20417f;
    /* renamed from: g */
    private Application f20418g;
    /* renamed from: h */
    private Activity f20419h;
    /* renamed from: i */
    private Map<String, String> f20420i = new HashMap();
    /* renamed from: j */
    private String f20421j;
    /* renamed from: k */
    private List<C6292b> f20422k = new ArrayList();
    /* renamed from: l */
    private C6391h f20423l;

    /* compiled from: Exponent */
    /* renamed from: host.exp.a.b$a */
    public interface C6266a {
        void onBundleLoaded(String str);

        void onError(Exception exception);
    }

    /* compiled from: Exponent */
    /* renamed from: host.exp.a.b$b */
    public static class C6267b {
        /* renamed from: a */
        public Application f20404a;
        /* renamed from: b */
        public String f20405b;
        /* renamed from: c */
        public Map<String, Object> f20406c;
        /* renamed from: d */
        public List<C6002i> f20407d;
        /* renamed from: e */
        public ExponentPackageDelegate f20408e;
        /* renamed from: f */
        public JSONObject f20409f;
        /* renamed from: g */
        public List<C6003j> f20410g;
    }

    /* compiled from: Exponent */
    /* renamed from: host.exp.a.b$c */
    public interface C6268c {
        /* renamed from: a */
        void mo5392a();

        /* renamed from: a */
        void mo5393a(String str);
    }

    /* compiled from: Exponent */
    /* renamed from: host.exp.a.b$d */
    public interface C6269d {
        void permissionsDenied();

        void permissionsGranted();
    }

    /* compiled from: Exponent */
    /* renamed from: host.exp.a.b$e */
    public interface C6270e {
        /* renamed from: a */
        void mo5395a(JSONArray jSONArray);

        /* renamed from: h */
        boolean mo5396h();

        /* renamed from: l */
        ExponentPackageDelegate mo5397l();

        /* renamed from: v */
        boolean mo5398v();
    }

    /* compiled from: Exponent */
    /* renamed from: host.exp.a.b$1 */
    class C75091 implements C6363c {
        /* renamed from: a */
        final /* synthetic */ C6271b f26054a;

        C75091(C6271b c6271b) {
            this.f26054a = c6271b;
        }

        /* renamed from: a */
        public void mo5371a(IOException iOException) {
            C6289b.m25949a(C6271b.f20411d, iOException.toString());
        }

        /* renamed from: a */
        public void mo5370a(C6364d c6364d) {
            C6368f.m26110a(c6364d);
            C6289b.m25949a(C6271b.f20411d, "Loaded exp.host status page.");
        }
    }

    /* renamed from: a */
    public String m25908a(String str) {
        synchronized (this.f20420i) {
            if (this.f20420i.containsKey(str)) {
                String str2 = (String) this.f20420i.get(str);
                this.f20420i.remove(str);
                return str2;
            }
            return null;
        }
    }

    /* renamed from: a */
    public static void m25899a(Context context, Application application) {
        if (f20412e == null) {
            C6271b c6271b = new C6271b(context, application);
        }
    }

    /* renamed from: a */
    public static C6271b m25897a() {
        return f20412e;
    }

    private C6271b(Context context, Application application) {
        f20412e = this;
        this.f20417f = context;
        this.f20418g = application;
        C6271b.m25906e();
        C6294a.m25958a(application);
        C6294a.m25957a().m25961b(C6271b.class, this);
        try {
            this.f20414a.m26115a().m26103a(new C6245a().m25814a("https://exp.host/status").m25820b(), new C75091(this));
        } catch (Throwable th) {
            C6289b.m25950a(f20411d, th);
        }
        try {
            UserManager.class.getMethod("get", new Class[]{Context.class}).invoke(null, new Object[]{context});
        } catch (Throwable th2) {
            C6289b.m25951a(th2);
        }
        try {
            Fresco.initialize(context);
        } catch (Throwable th22) {
            C6289b.m25951a(th22);
        }
        C6288a.m25940a(context, application);
        C5680f.m24083a(context);
        if (C6263a.f20400b != null) {
            Stetho.initializeWithDefaults(context);
        }
        if (C6263a.f20400b == null) {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
        }
    }

    /* renamed from: a */
    public void m25911a(Activity activity) {
        this.f20419h = activity;
    }

    /* renamed from: b */
    public Activity m25920b() {
        return this.f20419h;
    }

    /* renamed from: a */
    public final void m25913a(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            new Handler(this.f20417f.getMainLooper()).post(runnable);
        } else {
            runnable.run();
        }
    }

    /* renamed from: b */
    public void m25921b(String str) {
        this.f20421j = str;
    }

    /* renamed from: c */
    public String m25922c() {
        return this.f20421j;
    }

    /* renamed from: a */
    public boolean m25916a(String str, C6330b c6330b) {
        return new C6391h(c6330b).m26223a(str);
    }

    /* renamed from: a */
    public boolean m25915a(C6269d c6269d, String[] strArr, C6330b c6330b, String str) {
        this.f20423l = new C6391h(c6330b);
        return this.f20423l.m26222a(c6269d, strArr, str);
    }

    /* renamed from: a */
    public void m25910a(int i, String[] strArr, int[] iArr) {
        if (strArr.length > 0 && iArr.length > 0 && this.f20423l != null) {
            this.f20423l.m26221a(i, strArr, iArr);
            this.f20423l = 0;
        }
    }

    /* renamed from: a */
    public void m25912a(C6292b c6292b) {
        this.f20422k.add(c6292b);
    }

    /* renamed from: a */
    public void m25909a(int i, int i2, Intent intent) {
        for (C6292b onActivityResult : this.f20422k) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    /* renamed from: d */
    public Application m25924d() {
        return this.f20418g;
    }

    /* renamed from: a */
    public static void m25902a(Throwable th) {
        if (!C6263a.f20400b) {
            try {
                C3414a.a(th);
            } catch (Throwable th2) {
                Log.e(f20411d, th2.toString());
            }
        }
    }

    /* renamed from: e */
    public static synchronized Provider m25906e() {
        Provider provider;
        synchronized (C6271b.class) {
            if (f20413m == null) {
                f20413m = new BouncyCastleProvider();
                Security.insertProviderAt(f20413m, 1);
            }
            provider = f20413m;
        }
        return provider;
    }

    /* renamed from: c */
    public String m25923c(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("experience-");
        stringBuilder.append(str);
        return URLEncoder.encode(stringBuilder.toString(), Utf8Charset.NAME);
    }

    /* renamed from: a */
    public boolean m25917a(JSONObject jSONObject, String str, String str2, String str3, C6266a c6266a) {
        return m25918a(jSONObject, str, str2, str3, c6266a, false);
    }

    /* renamed from: a */
    public boolean m25918a(JSONObject jSONObject, String str, String str2, String str3, C6266a c6266a, boolean z) {
        return m25919a(jSONObject, str, str2, str3, c6266a, z, false);
    }

    /* renamed from: a */
    public boolean m25919a(JSONObject jSONObject, String str, String str2, String str3, C6266a c6266a, boolean z, boolean z2) {
        C6271b c6271b = this;
        String str4 = str2;
        String str5 = str3;
        if (!str4.equals("kernel")) {
            C6288a.m25941a(C6287a.STARTED_FETCHING_BUNDLE);
        }
        boolean z3 = (jSONObject == null ? new JSONObject() : jSONObject).has("developer") ? true : z;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cached-bundle-");
        stringBuilder.append(str4);
        stringBuilder.append(Integer.toString(str.hashCode()));
        stringBuilder.append('-');
        stringBuilder.append(str5);
        String stringBuilder2 = stringBuilder.toString();
        File file = new File(c6271b.f20417f.getFilesDir(), str5);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            C6245a b;
            String str6;
            if ("kernel".equals(str4)) {
                b = C6339i.m26063b(str);
                str6 = str;
            } else {
                b = new C6245a().m25814a(str);
            }
            if (z3) {
                b.m25810a(C6214d.f20163a);
            }
            C6246z b2 = b.m25820b();
            final C6266a c6266a2 = c6266a;
            final String str7 = str2;
            final File file2 = file;
            final String str8 = stringBuilder2;
            str6 = str;
            C6365a c75102 = new C6365a(this) {
                /* renamed from: f */
                final /* synthetic */ C6271b f26060f;

                /* renamed from: a */
                public void mo5374a(IOException iOException) {
                    c6266a2.onError(iOException);
                }

                /* renamed from: a */
                public void mo5372a(C6364d c6364d) {
                    InputStream b;
                    OutputStream fileOutputStream;
                    Throwable th;
                    OutputStream outputStream;
                    StringBuilder stringBuilder;
                    if (c6364d.mo5423a()) {
                        if (!str7.equals("kernel")) {
                            C6288a.m25941a(C6287a.FINISHED_FETCHING_BUNDLE);
                        }
                        try {
                            String g;
                            if (!str7.equals("kernel")) {
                                C6288a.m25941a(C6287a.STARTED_WRITING_BUNDLE);
                            }
                            final File file = new File(file2, str8);
                            Object obj = null;
                            if (c6364d.mo5427e() == null || c6364d.mo5427e().mo5425c() == 304) {
                                g = C6271b.f20411d;
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("Got cached OkHttp response for ");
                                stringBuilder.append(str6);
                                C6289b.m25949a(g, stringBuilder.toString());
                                if (file.exists()) {
                                    obj = 1;
                                    g = C6271b.f20411d;
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Have cached source file for ");
                                    stringBuilder.append(str6);
                                    C6289b.m25949a(g, stringBuilder.toString());
                                }
                            }
                            if (obj == null) {
                                OutputStream outputStream2 = null;
                                try {
                                    g = C6271b.f20411d;
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Do not have cached source file for ");
                                    stringBuilder.append(str6);
                                    C6289b.m25949a(g, stringBuilder.toString());
                                    b = c6364d.mo5424b().mo5420b();
                                    try {
                                        fileOutputStream = new FileOutputStream(file);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileOutputStream = null;
                                        outputStream = fileOutputStream;
                                        C6646d.m27060a(outputStream2);
                                        C6646d.m27060a(fileOutputStream);
                                        C6646d.m27060a(outputStream);
                                        C6646d.m27058a(b);
                                        throw th;
                                    }
                                    try {
                                        outputStream = new C6640a();
                                        try {
                                            OutputStream c7680d = new C7680d(fileOutputStream, outputStream);
                                            try {
                                                ByteStreams.copy(b, c7680d);
                                                c7680d.flush();
                                                this.f26060f.f20420i.put(file.getAbsolutePath(), outputStream.toString());
                                                fileOutputStream.flush();
                                                fileOutputStream.getFD().sync();
                                                C6646d.m27060a(c7680d);
                                                C6646d.m27060a(fileOutputStream);
                                                C6646d.m27060a(outputStream);
                                                C6646d.m27058a(b);
                                            } catch (Throwable th3) {
                                                th = th3;
                                                outputStream2 = c7680d;
                                                C6646d.m27060a(outputStream2);
                                                C6646d.m27060a(fileOutputStream);
                                                C6646d.m27060a(outputStream);
                                                C6646d.m27058a(b);
                                                throw th;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            C6646d.m27060a(outputStream2);
                                            C6646d.m27060a(fileOutputStream);
                                            C6646d.m27060a(outputStream);
                                            C6646d.m27058a(b);
                                            throw th;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        outputStream = null;
                                        C6646d.m27060a(outputStream2);
                                        C6646d.m27060a(fileOutputStream);
                                        C6646d.m27060a(outputStream);
                                        C6646d.m27058a(b);
                                        throw th;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    b = null;
                                    fileOutputStream = b;
                                    outputStream = fileOutputStream;
                                    C6646d.m27060a(outputStream2);
                                    C6646d.m27060a(fileOutputStream);
                                    C6646d.m27060a(outputStream);
                                    C6646d.m27058a(b);
                                    throw th;
                                }
                            }
                            if (str7.equals("kernel") == null) {
                                C6288a.m25941a(C6287a.FINISHED_WRITING_BUNDLE);
                            }
                            this.f26060f.f20416c.m26075a(new Runnable(this) {
                                /* renamed from: b */
                                final /* synthetic */ C75102 f20402b;

                                public void run() {
                                    c6266a2.onBundleLoaded(file.getAbsolutePath());
                                }
                            });
                        } catch (C6364d c6364d2) {
                            c6266a2.onError(c6364d2);
                        }
                        return;
                    }
                    String str = "(could not render body)";
                    try {
                        str = c6364d2.mo5424b().mo5419a();
                    } catch (Throwable e) {
                        C6289b.m25950a(C6271b.f20411d, e);
                    }
                    C6266a c6266a = c6266a2;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Bundle return code: ");
                    stringBuilder.append(c6364d2.mo5425c());
                    stringBuilder.append(". With body: ");
                    stringBuilder.append(str);
                    c6266a.onError(new Exception(stringBuilder.toString()));
                }

                /* renamed from: a */
                public void mo5373a(C6364d c6364d, boolean z) {
                    C6289b.m25949a(C6271b.f20411d, "Using cached or embedded response.");
                    mo5372a(c6364d);
                }
            };
            if (z2) {
                c6271b.f20414a.m26117b().m26105a(b2.m25821a().toString(), b2, c75102, null, null);
            } else if (z3) {
                c6271b.f20414a.m26117b().m26104a(b2, c75102);
            } else {
                c6271b.f20414a.m26117b().m26106b(b2, c75102);
            }
        } catch (Exception e) {
            c6266a.onError(e);
        }
        return new File(file, stringBuilder2).exists();
    }

    /* renamed from: d */
    public static int m25904d(String str) {
        if (!str.contains("://")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://");
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        str = Uri.parse(str).getPort();
        return str == -1 ? 80 : str;
    }

    /* renamed from: e */
    public static String m25905e(String str) {
        if (!str.contains("://")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://");
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        return Uri.parse(str).getHost();
    }

    /* renamed from: a */
    public static void m25901a(String str, String str2, String str3, C6394j c6394j) {
        if (str2.isEmpty() == null && str3.isEmpty() == null) {
            try {
                str = new C6394j("com.facebook.react.modules.systeminfo.AndroidInfoHelpers");
                str.m26233a(c6394j.m26248e());
                String e = C6271b.m25905e(str2);
                str2 = C6271b.m25904d(str2);
                Field declaredField = str.m26247d().getDeclaredField("DEVICE_LOCALHOST");
                declaredField.setAccessible(true);
                declaredField.set(null, e);
                declaredField = str.m26247d().getDeclaredField("GENYMOTION_LOCALHOST");
                declaredField.setAccessible(true);
                declaredField.set(null, e);
                declaredField = str.m26247d().getDeclaredField("EMULATOR_LOCALHOST");
                declaredField.setAccessible(true);
                declaredField.set(null, e);
                Field declaredField2 = str.m26247d().getDeclaredField("DEBUG_SERVER_HOST_PORT");
                declaredField2.setAccessible(true);
                declaredField2.set(null, Integer.valueOf(str2));
                str = str.m26247d().getDeclaredField("INSPECTOR_PROXY_PORT");
                str.setAccessible(true);
                str.set(null, Integer.valueOf(str2));
                c6394j.m26241b("setUseDeveloperSupport", new Object[]{Boolean.valueOf(true)});
                c6394j.m26241b("setJSMainModulePath", new Object[]{str3});
            } catch (String str4) {
                str4.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m25914a(boolean z, JSONObject jSONObject, final C6268c c6268c) {
        if (z) {
            z = jSONObject.optString("debuggerHost");
            jSONObject = this.f20414a.m26118c();
            C6245a c6245a = new C6245a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://");
            stringBuilder.append(z);
            stringBuilder.append("/status");
            jSONObject.mo5339a(c6245a.m25814a(stringBuilder.toString()).m25820b()).mo5341a(new C6217f(this) {
                /* renamed from: c */
                final /* synthetic */ C6271b f26063c;

                /* compiled from: Exponent */
                /* renamed from: host.exp.a.b$3$1 */
                class C62651 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C75113 f20403a;

                    C62651(C75113 c75113) {
                        this.f20403a = c75113;
                    }

                    public void run() {
                        c6268c.mo5392a();
                    }
                }

                public void onFailure(C6216e c6216e, IOException iOException) {
                    C6289b.m25949a(C6271b.f20411d, iOException.toString());
                    c6216e = c6268c;
                    iOException = new StringBuilder();
                    iOException.append("Packager is not running at http://");
                    iOException.append(z);
                    c6216e.mo5393a(iOException.toString());
                }

                public void onResponse(C6216e c6216e, ab abVar) {
                    if (abVar.m25585h().string().contains("running") != null) {
                        this.f26063c.m25913a(new C62651(this));
                        return;
                    }
                    c6216e = c6268c;
                    abVar = new StringBuilder();
                    abVar.append("Packager is not running at http://");
                    abVar.append(z);
                    c6216e.mo5393a(abVar.toString());
                }
            });
            return;
        }
        c6268c.mo5392a();
    }

    /* renamed from: f */
    public boolean m25926f() {
        return VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this.f20417f);
    }

    /* renamed from: f */
    public void m25925f(final String str) {
        try {
            this.f20415b.m26141a(str, new C6360b(this) {
                /* renamed from: b */
                final /* synthetic */ C6271b f26065b;

                public void onCompleted(JSONObject jSONObject) {
                    try {
                        JSONObject jSONObject2 = jSONObject;
                        this.f26065b.m25903a(jSONObject2, str, jSONObject.getString("bundleUrl"), jSONObject.getString("id"), jSONObject.getString("sdkVersion"));
                    } catch (Throwable e) {
                        C6289b.m25950a(C6271b.f20411d, e);
                    } catch (JSONObject jSONObject3) {
                        String g = C6271b.f20411d;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Couldn't preload bundle: ");
                        stringBuilder.append(jSONObject3.toString());
                        C6289b.m25953c(g, stringBuilder.toString());
                    }
                }

                public void onError(Exception exception) {
                    String g = C6271b.f20411d;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Couldn't preload manifest: ");
                    stringBuilder.append(exception.toString());
                    C6289b.m25953c(g, stringBuilder.toString());
                }

                public void onError(String str) {
                    String g = C6271b.f20411d;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Couldn't preload manifest: ");
                    stringBuilder.append(str);
                    C6289b.m25953c(g, stringBuilder.toString());
                }
            });
        } catch (String str2) {
            String str3 = f20411d;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Couldn't preload manifest: ");
            stringBuilder.append(str2.toString());
            C6289b.m25953c(str3, stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private void m25903a(JSONObject jSONObject, final String str, final String str2, String str3, String str4) {
        try {
            C6271b.m25897a().m25918a(jSONObject, str2, C6271b.m25897a().m25923c(str3), str4, new C6266a(this) {
                /* renamed from: c */
                final /* synthetic */ C6271b f26068c;

                public void onError(Exception exception) {
                    String g = C6271b.f20411d;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Couldn't preload bundle: ");
                    stringBuilder.append(exception.toString());
                    C6289b.m25953c(g, stringBuilder.toString());
                }

                public void onBundleLoaded(String str) {
                    str = C6271b.f20411d;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Successfully preloaded manifest and bundle for ");
                    stringBuilder.append(str);
                    stringBuilder.append(" ");
                    stringBuilder.append(str2);
                    C6289b.m25949a(str, stringBuilder.toString());
                }
            }, true);
        } catch (JSONObject jSONObject2) {
            str = f20411d;
            str2 = new StringBuilder();
            str2.append("Couldn't encode preloaded bundle id: ");
            str2.append(jSONObject2.toString());
            C6289b.m25953c(str, str2.toString());
        }
    }
}
