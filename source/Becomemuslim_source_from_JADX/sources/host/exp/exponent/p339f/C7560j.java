package host.exp.exponent.p339f;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.p026a.C0355a.C0354a;
import android.support.v4.content.p026a.C0357b;
import android.support.v4.p020a.p021a.C0260b;
import android.support.v7.app.C4473b.C0609a;
import android.util.Log;
import android.widget.Toast;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.network.ReactCookieJarContainer;
import com.facebook.react.shell.MainReactPackage;
import de.p287a.p288a.C5884c;
import expolib_v1.p321a.C7490w.C6243a;
import host.exp.exponent.C6301d;
import host.exp.exponent.C6369g;
import host.exp.exponent.C6369g.C6359a;
import host.exp.exponent.C6394j;
import host.exp.exponent.ExponentDevActivity;
import host.exp.exponent.LauncherActivity;
import host.exp.exponent.ReactNativeStaticHelpers;
import host.exp.exponent.experience.C8362a;
import host.exp.exponent.experience.ExperienceActivity;
import host.exp.exponent.experience.HomeActivity;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p337d.C6299a;
import host.exp.exponent.p338e.C7526a;
import host.exp.exponent.p339f.C6338h.C6337c;
import host.exp.exponent.p339f.C6352l.C6351c;
import host.exp.exponent.p339f.C7560j;
import host.exp.exponent.p343g.C6368f;
import host.exp.exponent.p344h.C6373d;
import host.exp.exponent.p346j.C6383a;
import host.exp.exponent.p346j.C6383a.C6382a;
import host.exp.exponent.p346j.C6388f;
import host.exp.p333a.C6263a;
import host.exp.p333a.C6271b;
import host.exp.p333a.C6271b.C6266a;
import host.exp.p333a.C6279c.C6276e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.C6562a;
import org.json.JSONObject;
import versioned.host.exp.exponent.ExponentPackage;
import versioned.host.exp.exponent.ReactUnthemedRootView;
import versioned.host.exp.exponent.ReadableObjectUtils;

/* compiled from: Kernel */
/* renamed from: host.exp.exponent.f.j */
public class C7560j extends C6353m {
    /* renamed from: f */
    private static final String f26175f = "j";
    /* renamed from: g */
    private static C7560j f26176g;
    /* renamed from: j */
    private static Map<String, C6346a> f26177j = new HashMap();
    /* renamed from: p */
    private static final Map<String, C6351c> f26178p = new HashMap();
    @C6562a
    /* renamed from: a */
    Context f26179a;
    @C6562a
    /* renamed from: b */
    Application f26180b;
    @C6562a
    /* renamed from: c */
    C6369g f26181c;
    @C6562a
    /* renamed from: d */
    C6373d f26182d;
    @C6562a
    /* renamed from: e */
    C6368f f26183e;
    /* renamed from: h */
    private ReactInstanceManager f26184h;
    /* renamed from: i */
    private Activity f26185i;
    /* renamed from: k */
    private ExperienceActivity f26186k;
    /* renamed from: l */
    private Integer f26187l;
    /* renamed from: m */
    private boolean f26188m = false;
    /* renamed from: n */
    private boolean f26189n = false;
    /* renamed from: o */
    private boolean f26190o = false;

    /* compiled from: Kernel */
    /* renamed from: host.exp.exponent.f.j$1 */
    class C63401 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C7560j f20587a;

        C63401(C7560j c7560j) {
            this.f20587a = c7560j;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                Toast.makeText(this.f20587a.f26185i, "Kernel manifest invalid. Make sure `expu start` is running inside of exponent/home and rebuild the app.", 1).show();
            }
        }
    }

    /* compiled from: Kernel */
    /* renamed from: host.exp.exponent.f.j$a */
    public static class C6346a {
        /* renamed from: a */
        public final String f20597a;
        /* renamed from: b */
        public int f20598b;
        /* renamed from: c */
        public WeakReference<ExperienceActivity> f20599c;
        /* renamed from: d */
        public int f20600d;
        /* renamed from: e */
        public String f20601e;

        public C6346a(String str) {
            this.f20597a = str;
        }
    }

    /* compiled from: Kernel */
    /* renamed from: host.exp.exponent.f.j$b */
    public static class C6347b {
    }

    /* compiled from: Kernel */
    /* renamed from: host.exp.exponent.f.j$4 */
    class C75544 implements C6266a {
        /* renamed from: a */
        final /* synthetic */ C7560j f26161a;

        C75544(C7560j c7560j) {
            this.f26161a = c7560j;
        }

        public void onBundleLoaded(final String str) {
            if (!C6263a.f20400b) {
                this.f26161a.f26182d.m26157b("kernel_revision_id", this.f26161a.m34233o());
            }
            C6271b.m25897a().m25913a(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C75544 f20592b;

                /* compiled from: Kernel */
                /* renamed from: host.exp.exponent.f.j$4$1$1 */
                class C63421 implements OnClickListener {
                    /* renamed from: a */
                    final /* synthetic */ C63431 f20590a;

                    C63421(C63431 c63431) {
                        this.f20590a = c63431;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("package:");
                        stringBuilder.append(this.f20590a.f20592b.f26161a.f26185i.getPackageName());
                        this.f20590a.f20592b.f26161a.f26185i.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(stringBuilder.toString())), 123);
                    }
                }

                public void run() {
                    Object initialLifecycleState = ReactInstanceManager.builder().setApplication(this.f20592b.f26161a.f26180b).setJSBundleFile(str).addPackage(new MainReactPackage()).addPackage(ExponentPackage.kernelExponentPackage(this.f20592b.f26161a.f26179a, this.f20592b.f26161a.f26181c.m26138a(), HomeActivity.m44610a())).setInitialLifecycleState(LifecycleState.RESUMED);
                    if (!C6348k.f20603b) {
                        C6369g c6369g = this.f20592b.f26161a.f26181c;
                        if (C6369g.m26131b(this.f20592b.f26161a.f26181c.m26138a())) {
                            if (C6271b.m25897a().m25926f()) {
                                new C0609a(this.f20592b.f26161a.f26185i).a("Please enable \"Permit drawing over other apps\"").b("Click \"ok\" to open settings. Once you've enabled the setting you'll have to restart the app.").a(17039370, new C63421(this)).a(false).c();
                                return;
                            }
                            C6271b.m25901a("UNVERSIONED", this.f20592b.f26161a.f26181c.m26137a("debuggerHost"), this.f20592b.f26161a.f26181c.m26137a("mainModuleName"), C6394j.m26225a(initialLifecycleState));
                        }
                    }
                    this.f20592b.f26161a.f26184h = initialLifecycleState.build();
                    this.f20592b.f26161a.f26184h.createReactContextInBackground();
                    if (this.f20592b.f26161a.m34252c() != null) {
                        this.f20592b.f26161a.f26184h.onHostResume(this.f20592b.f26161a.m34252c(), null);
                    }
                    this.f20592b.f26161a.f26189n = true;
                    C5884c.m24753a().m24770e(new C6347b());
                    C6289b.m25949a(C7560j.f26175f, "Kernel started running.");
                    this.f20592b.f26161a.f26182d.m26153a("should_not_use_kernel_cache", false);
                }
            });
        }

        public void onError(Exception exception) {
            this.f26161a.m34262h();
            if (C6263a.f20400b) {
                C7560j c7560j = this.f26161a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Can't load kernel. Are you sure your packager is running and your phone is on the same wifi? ");
                stringBuilder.append(exception.getMessage());
                c7560j.mo5408a(stringBuilder.toString());
                return;
            }
            this.f26161a.mo5408a("Expo requires an internet connection.");
            String j = C7560j.f26175f;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Expo requires an internet connection.");
            stringBuilder.append(exception.getMessage());
            C6289b.m25949a(j, stringBuilder.toString());
        }
    }

    /* compiled from: Kernel */
    /* renamed from: host.exp.exponent.f.j$6 */
    class C75566 implements C6337c {
        /* renamed from: a */
        final /* synthetic */ C7560j f26165a;

        C75566(C7560j c7560j) {
            this.f26165a = c7560j;
        }

        public void onEventSuccess(ReadableMap readableMap) {
            C6289b.m25949a(C7560j.f26175f, "Successfully called ExponentKernel.addHistoryItem in kernel JS.");
        }

        public void onEventFailure(String str) {
            String j = C7560j.f26175f;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error calling ExponentKernel.addHistoryItem in kernel JS: ");
            stringBuilder.append(str);
            C6289b.m25953c(j, stringBuilder.toString());
        }
    }

    /* renamed from: b */
    private C6346a m34221b(int i) {
        for (C6346a c6346a : f26177j.values()) {
            if (c6346a.f20598b == i) {
                return c6346a;
            }
        }
        return 0;
    }

    public C7560j() {
        C6294a.m25957a().m25961b(C7560j.class, this);
        f26176g = this;
        m34230l();
    }

    /* renamed from: l */
    private void m34230l() {
        this.f26183e.m26116a(new C6243a().m25791a(0, TimeUnit.MILLISECONDS).m25801b(0, TimeUnit.MILLISECONDS).m25805c(0, TimeUnit.MILLISECONDS).m25794a(new ReactCookieJarContainer()).m25792a(this.f26183e.m26119d()));
        ReactNativeStaticHelpers.m25937a(this.f26183e);
    }

    /* renamed from: a */
    public void m34237a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = host.exp.exponent.C6301d.m26001a();
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r10.f26179a;
        r1 = 0;
        com.facebook.soloader.SoLoader.init(r0, r1);
        monitor-enter(r10);
        r0 = r10.f26188m;	 Catch:{ all -> 0x00cb }
        if (r0 == 0) goto L_0x0018;	 Catch:{ all -> 0x00cb }
    L_0x0012:
        r0 = r10.f26190o;	 Catch:{ all -> 0x00cb }
        if (r0 != 0) goto L_0x0018;	 Catch:{ all -> 0x00cb }
    L_0x0016:
        monitor-exit(r10);	 Catch:{ all -> 0x00cb }
        return;	 Catch:{ all -> 0x00cb }
    L_0x0018:
        r0 = 1;	 Catch:{ all -> 0x00cb }
        r10.f26188m = r0;	 Catch:{ all -> 0x00cb }
        monitor-exit(r10);	 Catch:{ all -> 0x00cb }
        r10.f26190o = r1;
        r1 = r10.f26182d;
        r1 = r1.m26159b();
        if (r1 != 0) goto L_0x0039;
    L_0x0026:
        r1 = r10.f26181c;	 Catch:{ Throwable -> 0x002c }
        r1.m26138a();	 Catch:{ Throwable -> 0x002c }
        goto L_0x0039;
    L_0x002c:
        r0 = host.exp.p333a.C6271b.m25897a();
        r1 = new host.exp.exponent.f.j$1;
        r1.<init>(r10);
        r0.m25913a(r1);
        return;
    L_0x0039:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r10.m34232n();
        r1.append(r2);
        r2 = host.exp.p333a.C6263a.f20400b;
        if (r2 == 0) goto L_0x004c;
    L_0x0049:
        r2 = "";
        goto L_0x0065;
    L_0x004c:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "?versionName=";
        r2.append(r3);
        r3 = host.exp.exponent.p339f.C7549c.m34188a();
        r3 = r3.m34193b();
        r2.append(r3);
        r2 = r2.toString();
    L_0x0065:
        r1.append(r2);
        r5 = r1.toString();
        r1 = r10.f26182d;
        r1 = r1.m26159b();
        if (r1 == 0) goto L_0x0097;
    L_0x0074:
        r1 = r10.f26182d;
        r2 = "is_first_kernel_run";
        r1 = r1.m26155a(r2);
        if (r1 == 0) goto L_0x0097;
    L_0x007e:
        r0 = r10.m34231m();
        r1 = "assets://kernel.android.bundle";
        r0.onBundleLoaded(r1);
        r0 = new android.os.Handler;
        r0.<init>();
        r1 = new host.exp.exponent.f.j$3;
        r1.<init>(r10, r5);
        r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r0.postDelayed(r1, r2);
        goto L_0x00ca;
    L_0x0097:
        r1 = r10.f26182d;
        r2 = "should_not_use_kernel_cache";
        r1 = r1.m26155a(r2);
        r2 = host.exp.p333a.C6263a.f20400b;
        if (r2 != 0) goto L_0x00b9;
    L_0x00a3:
        r2 = r10.f26182d;
        r3 = "kernel_revision_id";
        r4 = "";
        r2 = r2.m26150a(r3, r4);
        r3 = r10.m34233o();
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x00b9;
    L_0x00b7:
        r9 = 1;
        goto L_0x00ba;
    L_0x00b9:
        r9 = r1;
    L_0x00ba:
        r3 = host.exp.p333a.C6271b.m25897a();
        r4 = 0;
        r6 = "kernel";
        r7 = "UNVERSIONED";
        r8 = r10.m34231m();
        r3.m25918a(r4, r5, r6, r7, r8, r9);
    L_0x00ca:
        return;
    L_0x00cb:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x00cb }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.f.j.a():void");
    }

    /* renamed from: b */
    public void m34250b() {
        if (!C6301d.m26001a()) {
            String n = m34232n();
            this.f26190o = false;
            C6271b.m25897a().m25918a(null, n, "kernel", "UNVERSIONED", m34231m(), true);
        }
    }

    /* renamed from: a */
    public static void m34213a(Intent intent) {
        intent.addFlags(67108864);
        intent.addFlags(524288);
        intent.addFlags(134217728);
    }

    /* renamed from: m */
    private C6266a m34231m() {
        return new C75544(this);
    }

    /* renamed from: n */
    private String m34232n() {
        return this.f26181c.m26137a("bundleUrl");
    }

    /* renamed from: o */
    private String m34233o() {
        return this.f26181c.m26137a("revisionId");
    }

    /* renamed from: c */
    public Activity m34252c() {
        return this.f26185i;
    }

    /* renamed from: a */
    public void m34239a(Activity activity) {
        if (activity != null) {
            this.f26185i = activity;
        }
    }

    /* renamed from: d */
    public ReactInstanceManager m34254d() {
        return this.f26184h;
    }

    /* renamed from: e */
    public ReactRootView m34256e() {
        ReactRootView reactUnthemedRootView = new ReactUnthemedRootView(this.f26179a);
        reactUnthemedRootView.startReactApplication(this.f26184h, "main", m34234p());
        return reactUnthemedRootView;
    }

    /* renamed from: p */
    private Bundle m34234p() {
        JSONObject jSONObject = new JSONObject();
        String b = this.f26182d.m26156b("referrer");
        if (b != null) {
            try {
                jSONObject.put("referrer", b);
            } catch (Throwable e) {
                C6289b.m25950a(f26175f, e);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("exp", C6388f.m26203a(jSONObject));
        return bundle;
    }

    /* renamed from: b */
    public Boolean m34249b(String str) {
        return Boolean.valueOf(f26178p.containsKey(str));
    }

    /* renamed from: c */
    public C6351c m34253c(String str) {
        return (C6351c) f26178p.remove(str);
    }

    /* renamed from: d */
    public C6346a m34255d(String str) {
        C6346a c6346a = (C6346a) f26177j.get(str);
        if (c6346a != null) {
            return c6346a;
        }
        c6346a = new C6346a(str);
        f26177j.put(str, c6346a);
        return c6346a;
    }

    /* renamed from: e */
    public void m34257e(String str) {
        if (str != null) {
            f26177j.remove(str);
        }
    }

    /* renamed from: q */
    private void m34235q() {
        for (AppTask appTask : ((ActivityManager) this.f26179a.getSystemService("activity")).getAppTasks()) {
            if (HomeActivity.class.getName().equals(appTask.getTaskInfo().baseIntent.getComponent().getClassName())) {
                appTask.moveToFront();
                return;
            }
        }
        Intent intent = new Intent(this.f26185i, HomeActivity.class);
        C7560j.m34213a(intent);
        this.f26185i.startActivity(intent);
    }

    /* renamed from: a */
    private void m34219a(boolean r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = "host.exp.exponent.MainActivity";	 Catch:{ ClassNotFoundException -> 0x005e }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x005e }
        r1 = r5.f26179a;	 Catch:{ ClassNotFoundException -> 0x005e }
        r2 = "activity";	 Catch:{ ClassNotFoundException -> 0x005e }
        r1 = r1.getSystemService(r2);	 Catch:{ ClassNotFoundException -> 0x005e }
        r1 = (android.app.ActivityManager) r1;	 Catch:{ ClassNotFoundException -> 0x005e }
        r1 = r1.getAppTasks();	 Catch:{ ClassNotFoundException -> 0x005e }
        r1 = r1.iterator();	 Catch:{ ClassNotFoundException -> 0x005e }
    L_0x0018:
        r2 = r1.hasNext();	 Catch:{ ClassNotFoundException -> 0x005e }
        if (r2 == 0) goto L_0x0046;	 Catch:{ ClassNotFoundException -> 0x005e }
    L_0x001e:
        r2 = r1.next();	 Catch:{ ClassNotFoundException -> 0x005e }
        r2 = (android.app.ActivityManager.AppTask) r2;	 Catch:{ ClassNotFoundException -> 0x005e }
        r3 = r2.getTaskInfo();	 Catch:{ ClassNotFoundException -> 0x005e }
        r3 = r3.baseIntent;	 Catch:{ ClassNotFoundException -> 0x005e }
        r4 = r0.getName();	 Catch:{ ClassNotFoundException -> 0x005e }
        r3 = r3.getComponent();	 Catch:{ ClassNotFoundException -> 0x005e }
        r3 = r3.getClassName();	 Catch:{ ClassNotFoundException -> 0x005e }
        r3 = r4.equals(r3);	 Catch:{ ClassNotFoundException -> 0x005e }
        if (r3 == 0) goto L_0x0018;	 Catch:{ ClassNotFoundException -> 0x005e }
    L_0x003c:
        r6 = r2.getTaskInfo();	 Catch:{ ClassNotFoundException -> 0x005e }
        r6 = r6.id;	 Catch:{ ClassNotFoundException -> 0x005e }
        r5.m34238a(r6);	 Catch:{ ClassNotFoundException -> 0x005e }
        return;	 Catch:{ ClassNotFoundException -> 0x005e }
    L_0x0046:
        r1 = new android.content.Intent;	 Catch:{ ClassNotFoundException -> 0x005e }
        r2 = r5.f26185i;	 Catch:{ ClassNotFoundException -> 0x005e }
        r1.<init>(r2, r0);	 Catch:{ ClassNotFoundException -> 0x005e }
        host.exp.exponent.p339f.C7560j.m34213a(r1);	 Catch:{ ClassNotFoundException -> 0x005e }
        if (r6 == 0) goto L_0x0058;	 Catch:{ ClassNotFoundException -> 0x005e }
    L_0x0052:
        r6 = "loadFromCache";	 Catch:{ ClassNotFoundException -> 0x005e }
        r0 = 1;	 Catch:{ ClassNotFoundException -> 0x005e }
        r1.putExtra(r6, r0);	 Catch:{ ClassNotFoundException -> 0x005e }
    L_0x0058:
        r6 = r5.f26185i;	 Catch:{ ClassNotFoundException -> 0x005e }
        r6.startActivity(r1);	 Catch:{ ClassNotFoundException -> 0x005e }
        return;
    L_0x005e:
        r6 = new java.lang.IllegalStateException;
        r0 = "Could not find activity to open (MainActivity is not present).";
        r6.<init>(r0);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.f.j.a(boolean):void");
    }

    /* renamed from: a */
    public void m34240a(android.app.Activity r7, android.content.Intent r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = "EXKernelDisableNuxDefaultsKey";	 Catch:{ Throwable -> 0x000c }
        r1 = 0;	 Catch:{ Throwable -> 0x000c }
        r0 = r8.getBooleanExtra(r0, r1);	 Catch:{ Throwable -> 0x000c }
        if (r0 == 0) goto L_0x000c;	 Catch:{ Throwable -> 0x000c }
    L_0x0009:
        r0 = 1;	 Catch:{ Throwable -> 0x000c }
        host.exp.exponent.C6301d.f20502h = r0;	 Catch:{ Throwable -> 0x000c }
    L_0x000c:
        r0 = r8.getExtras();
        r6.m34239a(r7);
        r1 = r8.getData();
        r2 = 0;
        if (r1 != 0) goto L_0x001c;
    L_0x001a:
        r3 = r2;
        goto L_0x0020;
    L_0x001c:
        r3 = r1.toString();
    L_0x0020:
        if (r0 == 0) goto L_0x0093;
    L_0x0022:
        r4 = "dev_flag";
        r4 = r0.getBoolean(r4);
        if (r4 == 0) goto L_0x002e;
    L_0x002a:
        r6.m34224c(r7);
        return;
    L_0x002e:
        r7 = "notification";
        r7 = r0.getString(r7);
        r4 = "notification_object";
        r4 = r0.getString(r4);
        r5 = "notificationExperienceUrl";
        r5 = r0.getString(r5);
        if (r5 == 0) goto L_0x0082;
    L_0x0042:
        r1 = host.exp.exponent.notifications.C6396c.m26252a(r4);
        if (r1 == 0) goto L_0x0076;
    L_0x0048:
        r2 = "actionType";
        r2 = r0.containsKey(r2);
        if (r2 == 0) goto L_0x0067;
    L_0x0050:
        r2 = "actionType";
        r0 = r0.getString(r2);
        r1.m26256d(r0);
        r0 = new host.exp.exponent.notifications.e;
        r2 = r6.f26179a;
        r0.<init>(r2);
        r2 = r1.f20701a;
        r4 = r1.f20703c;
        r0.m26270a(r2, r4);
    L_0x0067:
        r8 = android.app.RemoteInput.getResultsFromIntent(r8);
        if (r8 == 0) goto L_0x0076;
    L_0x006d:
        r0 = "notification_remote_input";
        r8 = r8.getString(r0);
        r1.m26255c(r8);
    L_0x0076:
        r8 = new host.exp.exponent.f.l$c;
        if (r3 != 0) goto L_0x007b;
    L_0x007a:
        r3 = r5;
    L_0x007b:
        r8.<init>(r5, r3, r7, r1);
        r6.mo5406a(r8);
        return;
    L_0x0082:
        r7 = "shortcutExperienceUrl";
        r7 = r0.getString(r7);
        if (r7 == 0) goto L_0x0093;
    L_0x008a:
        r8 = new host.exp.exponent.f.l$c;
        r8.<init>(r7, r3, r2);
        r6.mo5406a(r8);
        return;
    L_0x0093:
        if (r1 == 0) goto L_0x00ad;
    L_0x0095:
        r7 = host.exp.exponent.C6301d.f20496b;
        if (r7 != 0) goto L_0x00a2;
    L_0x0099:
        r7 = new host.exp.exponent.f.l$c;
        r7.<init>(r3, r3, r2);
        r6.mo5406a(r7);
        return;
    L_0x00a2:
        r7 = new host.exp.exponent.f.l$c;
        r8 = host.exp.exponent.C6301d.f20496b;
        r7.<init>(r8, r3, r2);
        r6.mo5406a(r7);
        return;
    L_0x00ad:
        r7 = host.exp.exponent.C6301d.f20496b;
        if (r7 != 0) goto L_0x00b4;
    L_0x00b1:
        r7 = "";
        goto L_0x00b6;
    L_0x00b4:
        r7 = host.exp.exponent.C6301d.f20496b;
    L_0x00b6:
        r8 = new host.exp.exponent.f.l$c;
        r8.<init>(r7, r7, r2);
        r6.mo5406a(r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.f.j.a(android.app.Activity, android.content.Intent):void");
    }

    /* renamed from: c */
    private void m34224c(Activity activity) {
        for (AppTask appTask : ((ActivityManager) activity.getSystemService("activity")).getAppTasks()) {
            if (ExponentDevActivity.class.getName().equals(appTask.getTaskInfo().baseIntent.getComponent().getClassName())) {
                appTask.moveToFront();
                return;
            }
        }
        Intent intent = new Intent(activity, ExponentDevActivity.class);
        C7560j.m34213a(intent);
        activity.startActivity(intent);
    }

    /* renamed from: a */
    public void mo5406a(C6351c c6351c) {
        m34216a(m34228k(c6351c.f20609a), c6351c, Boolean.valueOf(true));
    }

    /* renamed from: k */
    private String m34228k(String str) {
        if (str == null) {
            return null;
        }
        Uri parse = Uri.parse(str);
        Builder buildUpon = parse.buildUpon();
        str = str.indexOf("--/");
        if (str >= null) {
            List<String> pathSegments = parse.getPathSegments();
            buildUpon.path(null);
            for (String str2 : pathSegments) {
                if ("--".equals(str2)) {
                    break;
                }
                buildUpon.appendEncodedPath(str2);
            }
        }
        String queryParameter = parse.getQueryParameter("release-channel");
        buildUpon.query(null);
        if (queryParameter != null) {
            int indexOf = queryParameter.indexOf(32);
            if (indexOf > -1) {
                queryParameter = queryParameter.substring(0, indexOf);
            }
            buildUpon.appendQueryParameter("release-channel", queryParameter);
        }
        buildUpon.fragment(null);
        String uri = buildUpon.build().toString();
        int indexOf2 = uri.indexOf(43);
        if (indexOf2 >= 0 && str < null) {
            uri = uri.substring(0, indexOf2);
        }
        if (uri.length() > null && uri.charAt(uri.length() - 1) == 47) {
            uri = uri.substring(0, uri.length() - 1);
        }
        return uri;
    }

    /* renamed from: a */
    private void m34216a(String str, C6351c c6351c, Boolean bool) {
        m34217a(str, c6351c, bool, false);
    }

    /* renamed from: a */
    private void m34217a(java.lang.String r10, host.exp.exponent.p339f.C6352l.C6351c r11, java.lang.Boolean r12, boolean r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = r9.f26179a;
        r1 = 0;
        com.facebook.soloader.SoLoader.init(r0, r1);
        if (r11 != 0) goto L_0x000e;
    L_0x0008:
        r11 = f26178p;
        r11.remove(r10);
        goto L_0x0013;
    L_0x000e:
        r0 = f26178p;
        r0.put(r10, r11);
    L_0x0013:
        if (r10 == 0) goto L_0x008d;
    L_0x0015:
        r11 = "";
        r11 = r10.equals(r11);
        if (r11 == 0) goto L_0x001f;
    L_0x001d:
        goto L_0x008d;
    L_0x001f:
        r11 = host.exp.exponent.C6301d.f20496b;
        r11 = r10.equals(r11);
        if (r11 == 0) goto L_0x002b;
    L_0x0027:
        r9.m34219a(r13);
        return;
    L_0x002b:
        host.exp.exponent.experience.ErrorActivity.m44451b();
        r11 = r9.m34260g();
        r0 = 0;
        if (r11 == 0) goto L_0x005f;
    L_0x0035:
        r2 = r11.size();
        if (r1 >= r2) goto L_0x005f;
    L_0x003b:
        r2 = r11.get(r1);
        r2 = (android.app.ActivityManager.AppTask) r2;
        r3 = r2.getTaskInfo();
        r3 = r3.baseIntent;
        r4 = "experienceUrl";
        r4 = r3.hasExtra(r4);
        if (r4 == 0) goto L_0x005c;
    L_0x004f:
        r4 = "experienceUrl";
        r3 = r3.getStringExtra(r4);
        r3 = r3.equals(r10);
        if (r3 == 0) goto L_0x005c;
    L_0x005b:
        goto L_0x0060;
    L_0x005c:
        r1 = r1 + 1;
        goto L_0x0035;
    L_0x005f:
        r2 = r0;
    L_0x0060:
        r11 = r12.booleanValue();
        if (r11 == 0) goto L_0x006b;
    L_0x0066:
        if (r2 != 0) goto L_0x006b;
    L_0x0068:
        r9.m34259f(r10);
    L_0x006b:
        if (r2 == 0) goto L_0x007c;
    L_0x006d:
        r11 = r2.getTaskInfo();	 Catch:{ IllegalArgumentException -> 0x0077 }
        r11 = r11.id;	 Catch:{ IllegalArgumentException -> 0x0077 }
        r9.m34238a(r11);	 Catch:{ IllegalArgumentException -> 0x0077 }
        goto L_0x007c;
    L_0x0077:
        r9.m34259f(r10);
        r8 = r0;
        goto L_0x007d;
    L_0x007c:
        r8 = r2;
    L_0x007d:
        if (r8 != 0) goto L_0x008c;
    L_0x007f:
        r11 = new host.exp.exponent.f.j$5;
        r3 = r11;
        r4 = r9;
        r5 = r10;
        r6 = r13;
        r7 = r10;
        r3.<init>(r4, r5, r6, r7, r8);
        r11.m25983a();
    L_0x008c:
        return;
    L_0x008d:
        r9.m34235q();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.f.j.a(java.lang.String, host.exp.exponent.f.l$c, java.lang.Boolean, boolean):void");
    }

    /* renamed from: a */
    private void m34218a(String str, JSONObject jSONObject, AppTask appTask) {
        String a = C6339i.m26062a(jSONObject.getString("bundleUrl"));
        m34255d(str).f20601e = a;
        jSONObject = this.f26181c.m26139a(str, jSONObject);
        boolean a2 = this.f26182d.m26155a("nux_has_finished_first_run");
        boolean z = false;
        Object obj = (C6301d.m26001a() || C6348k.f20605d) ? null : 1;
        if (!(obj == null || a2)) {
            z = true;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("loadNux", z);
        if (appTask == null) {
            m34246a(str, jSONObject, a, jSONObject2);
        }
        if (z) {
            this.f26182d.m26153a("nux_has_finished_first_run", true);
        }
        appTask = Arguments.createMap();
        appTask.putString("manifestUrl", str);
        appTask.putString("manifestString", jSONObject.toString());
        C6338h.m26060a("ExponentKernel.addHistoryItem", appTask, new C75566(this));
        m34236r();
    }

    @DoNotStrip
    public static String getBundleUrlForActivityId(int i, String str, String str2, String str3, boolean z, boolean z2) {
        if (i == -1) {
            return f26176g.m34232n();
        }
        if (C7526a.m34121a(i) != null) {
            return C7526a.m34123b(i);
        }
        for (C6346a c6346a : f26177j.values()) {
            if (c6346a.f20600d == i) {
                return c6346a.f20601e;
            }
        }
        return 0;
    }

    @DoNotStrip
    public static String getBundleUrlForActivityId(int i, String str, String str2, boolean z, boolean z2) {
        if (i == -1) {
            return f26176g.m34232n();
        }
        for (C6346a c6346a : f26177j.values()) {
            if (c6346a.f20600d == i) {
                return c6346a.f20601e;
            }
        }
        return 0;
    }

    @DoNotStrip
    public static String getBundleUrlForActivityId(int i, String str, String str2, boolean z, boolean z2, boolean z3) {
        if (i == -1) {
            return f26176g.m34232n();
        }
        for (C6346a c6346a : f26177j.values()) {
            if (c6346a.f20600d == i) {
                i = c6346a.f20601e;
                if (i == 0) {
                    return null;
                }
                if (z2) {
                    if (i.contains("hot=false") != null) {
                        i = i.replace("hot=false", "hot=true");
                    } else {
                        str = new StringBuilder();
                        str.append(i);
                        str.append("&hot=true");
                        i = str.toString();
                    }
                }
                return i;
            }
        }
        return null;
    }

    /* renamed from: f */
    public void m34259f(String str) {
        try {
            Intent intent = new Intent(this.f26185i, ExperienceActivity.class);
            C7560j.m34213a(intent);
            intent.putExtra("experienceUrl", str);
            intent.putExtra("isOptimistic", true);
            this.f26185i.startActivity(intent);
        } catch (Throwable th) {
            C6289b.m25950a(f26175f, th);
        }
    }

    /* renamed from: a */
    public void m34241a(ExperienceActivity experienceActivity, int i) {
        this.f26186k = experienceActivity;
        this.f26187l = Integer.valueOf(i);
        C6383a.m26189a("openOptimisticExperienceActivity");
        C6383a.m26189a("openExperienceActivity");
    }

    /* renamed from: a */
    public void m34247a(final JSONObject jSONObject) {
        C6383a.m26190a("openOptimisticExperienceActivity", new C6382a(this) {
            /* renamed from: b */
            final /* synthetic */ C7560j f26167b;

            /* renamed from: a */
            public boolean mo5390a() {
                return (this.f26167b.f26186k == null || this.f26167b.f26187l == null) ? false : true;
            }

            /* renamed from: b */
            public void mo5391b() {
                this.f26167b.f26186k.m44595a(jSONObject);
            }
        });
    }

    /* renamed from: a */
    public void m34246a(String str, JSONObject jSONObject, String str2, JSONObject jSONObject2) {
        final String str3 = str;
        final JSONObject jSONObject3 = jSONObject;
        final String str4 = str2;
        final JSONObject jSONObject4 = jSONObject2;
        C6383a.m26190a("openExperienceActivity", new C6382a(this) {
            /* renamed from: e */
            final /* synthetic */ C7560j f26172e;

            /* renamed from: a */
            public boolean mo5390a() {
                return (this.f26172e.f26186k == null || this.f26172e.f26187l == null) ? false : true;
            }

            /* renamed from: b */
            public void mo5391b() {
                this.f26172e.f26186k.m44593a(str3, jSONObject3, str4, jSONObject4);
                C6383a.m26189a("loadBundleForExperienceActivity");
            }
        });
    }

    /* renamed from: g */
    public void m34261g(final String str) {
        C6383a.m26190a("loadBundleForExperienceActivity", new C6382a(this) {
            /* renamed from: b */
            final /* synthetic */ C7560j f26174b;

            /* renamed from: a */
            public boolean mo5390a() {
                return (this.f26174b.f26186k == null || this.f26174b.f26187l == null) ? false : true;
            }

            /* renamed from: b */
            public void mo5391b() {
                this.f26174b.f26186k.m44592a(str);
                this.f26174b.f26186k = null;
                this.f26174b.f26187l = null;
            }
        });
    }

    /* renamed from: f */
    public List<AppTask> m34258f() {
        return ((ActivityManager) this.f26179a.getSystemService("activity")).getAppTasks();
    }

    /* renamed from: g */
    public List<AppTask> m34260g() {
        return m34258f();
    }

    /* renamed from: r */
    private void m34236r() {
        try {
            RecentTaskInfo.class.getDeclaredField("numActivities");
            for (AppTask appTask : m34258f()) {
                RecentTaskInfo taskInfo = appTask.getTaskInfo();
                if (taskInfo.numActivities == 0 && taskInfo.baseIntent.getAction().equals("android.intent.action.MAIN")) {
                    appTask.finishAndRemoveTask();
                    return;
                } else if (VERSION.SDK_INT >= 23 && taskInfo.numActivities == 1 && taskInfo.topActivity.getClassName().equals(LauncherActivity.class.getName())) {
                    appTask.finishAndRemoveTask();
                    return;
                }
            }
        } catch (NoSuchFieldException e) {
            Log.e(f26175f, e.toString());
        } catch (Throwable th) {
            C6289b.m25950a(f26175f, th);
        }
    }

    /* renamed from: a */
    public void m34238a(int i) {
        for (AppTask appTask : m34258f()) {
            if (appTask.getTaskInfo().id == i) {
                C6346a b = m34221b(i);
                if (b != null) {
                    ExperienceActivity experienceActivity = (ExperienceActivity) b.f20599c.get();
                    if (experienceActivity != null) {
                        experienceActivity.mo6921k();
                    }
                }
                appTask.moveToFront();
            }
        }
    }

    /* renamed from: b */
    public void m34251b(Activity activity) {
        C6346a b = m34221b(activity.getTaskId());
        if (b != null) {
            m34257e(b.f20597a);
        }
        for (AppTask appTask : ((ActivityManager) activity.getSystemService("activity")).getAppTasks()) {
            if (appTask.getTaskInfo().id == activity.getTaskId()) {
                appTask.finishAndRemoveTask();
            }
        }
    }

    /* renamed from: a */
    public boolean mo5409a(String str, boolean z) {
        if (str == null) {
            return null;
        }
        final Activity activity;
        for (C6346a c6346a : f26177j.values()) {
            if (str.equals(c6346a.f20597a)) {
                activity = c6346a.f20599c == null ? null : (ExperienceActivity) c6346a.f20599c.get();
                if (activity != null) {
                    if (activity.m44475u()) {
                        return true;
                    }
                    C6271b.m25897a().m25913a(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ C7560j f20586b;

                        public void run() {
                            activity.m44471c(null);
                        }
                    });
                }
                if (activity != null) {
                    m34251b(activity);
                }
                m34217a(str, null, Boolean.valueOf(true), z);
                return true;
            }
        }
        activity = null;
        if (activity != null) {
            m34251b(activity);
        }
        m34217a(str, null, Boolean.valueOf(true), z);
        return true;
    }

    @DoNotStrip
    public static void handleReactNativeError(String str, Object obj, Integer num, Boolean bool) {
        C7560j.m34214a(C6333f.m26051a(str), obj, num, bool);
    }

    @DoNotStrip
    public static void handleReactNativeError(Throwable th, String str, Object obj, Integer num, Boolean bool) {
        C7560j.m34214a(C6333f.m26051a(str), obj, num, bool);
        if (th != null) {
            C6271b.m25902a(th);
        }
    }

    /* renamed from: a */
    private static void m34214a(C6333f c6333f, Object obj, Integer num, Boolean bool) {
        ArrayList arrayList = new ArrayList();
        if (obj != null) {
            obj = C6394j.m26225a(obj);
            C6394j c6394j = new C6394j("com.facebook.react.bridge.Arguments");
            c6394j.m26233a(obj.m26248e());
            for (int i = 0; i < ((Integer) obj.m26236a("size", new Object[0])).intValue(); i++) {
                try {
                    Object[] objArr = new Object[1];
                    objArr[0] = obj.m26236a("getMap", Integer.valueOf(i));
                    arrayList.add((Bundle) c6394j.m26245c("toBundle", objArr));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        C8362a.m44555a(new C6332e(c6333f, (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]), C7560j.m34208a(num), bool.booleanValue()));
    }

    /* renamed from: a */
    public void mo5408a(String str) {
        C7560j.m34214a(C6333f.m26051a(str), null, Integer.valueOf(-1), Boolean.valueOf(true));
    }

    /* renamed from: a */
    public void mo5407a(Exception exception) {
        C7560j.m34214a(C6299a.m25994a(exception), null, Integer.valueOf(-1), Boolean.valueOf(true));
        C6271b.m25902a((Throwable) exception);
    }

    /* renamed from: a */
    private static int m34208a(Integer num) {
        if (num != null) {
            if (num.intValue() != -1) {
                return num.intValue();
            }
        }
        return (int) (-(Math.random() * 2.147483647E9d));
    }

    /* renamed from: h */
    public void m34262h() {
        this.f26190o = true;
    }

    /* renamed from: a */
    public void m34245a(String str, ReadableMap readableMap, String str2) {
        this.f26182d.m26152a(str, ReadableObjectUtils.readableToJson(readableMap), str2);
        m34263h(str);
    }

    /* renamed from: h */
    public void m34263h(final String str) {
        final JSONObject jSONObject = this.f26182d.m26160c(str).f20639a;
        this.f26181c.m26140a(jSONObject.optString("iconUrl"), new C6359a(this) {
            /* renamed from: c */
            final /* synthetic */ C7560j f26159c;

            /* renamed from: a */
            public void mo5380a(Bitmap bitmap) {
                Intent intent = new Intent(this.f26159c.f26179a, LauncherActivity.class);
                intent.setAction("android.intent.action.MAIN");
                intent.addFlags(536870912);
                intent.putExtra("shortcutExperienceUrl", str);
                C0357b.a(this.f26159c.f26179a, new C0354a(this.f26159c.f26179a, str).a(C0260b.a(bitmap)).a(jSONObject.optString("name")).a(intent).a(), null);
            }
        });
    }

    /* renamed from: i */
    public void m34264i() {
        Intent intent = new Intent(this.f26179a, LauncherActivity.class);
        intent.setAction("android.intent.action.MAIN");
        intent.addFlags(536870912);
        intent.putExtra("dev_flag", true);
        C0357b.a(this.f26179a, new C0354a(this.f26179a, "devtools_shortcut").a(C0260b.a(this.f26179a, C6276e.dev_icon)).a("Dev Tools").a(intent).a(), null);
    }
}
