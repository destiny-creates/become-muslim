package host.exp.exponent.experience;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ac.C0279d;
import android.support.v4.content.C0366b;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RemoteViews;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.soloader.SoLoader;
import de.p287a.p288a.C5884c;
import expo.p304a.p305a.C6002i;
import host.exp.exponent.C6290a;
import host.exp.exponent.C6295c;
import host.exp.exponent.C6301d;
import host.exp.exponent.C6369g;
import host.exp.exponent.C6394j;
import host.exp.exponent.ExponentIntentService;
import host.exp.exponent.LauncherActivity;
import host.exp.exponent.experience.C8355f.C6321a;
import host.exp.exponent.notifications.C6396c;
import host.exp.exponent.notifications.C6398e;
import host.exp.exponent.notifications.C6408j;
import host.exp.exponent.notifications.C7595k;
import host.exp.exponent.p334a.C6288a;
import host.exp.exponent.p334a.C6288a.C6287a;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p335b.C6291a;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C6332e;
import host.exp.exponent.p339f.C6339i;
import host.exp.exponent.p339f.C6352l.C6350b;
import host.exp.exponent.p339f.C6352l.C6351c;
import host.exp.exponent.p339f.C6355n;
import host.exp.exponent.p339f.C7560j.C6347b;
import host.exp.exponent.p346j.C6383a;
import host.exp.exponent.p346j.C6383a.C6382a;
import host.exp.exponent.p346j.C6386d;
import host.exp.exponent.p346j.C6387e;
import host.exp.p333a.C6271b;
import host.exp.p333a.C6271b.C6268c;
import host.exp.p333a.C6271b.C6270e;
import host.exp.p333a.C6279c.C6272a;
import host.exp.p333a.C6279c.C6273b;
import host.exp.p333a.C6279c.C6274c;
import host.exp.p333a.C6279c.C6275d;
import java.util.List;
import javax.inject.C6562a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import versioned.host.exp.exponent.ExponentPackageDelegate;
import versioned.host.exp.exponent.ReactUnthemedRootView;

public class ExperienceActivity extends C8362a implements C6270e {
    /* renamed from: t */
    private static final String f32972t = "ExperienceActivity";
    /* renamed from: u */
    private static String f32973u = "readyForBundle";
    /* renamed from: A */
    private boolean f32974A;
    /* renamed from: B */
    private RemoteViews f32975B;
    /* renamed from: C */
    private C0279d f32976C;
    /* renamed from: D */
    private boolean f32977D = false;
    /* renamed from: E */
    private boolean f32978E = false;
    /* renamed from: F */
    private C6317d f32979F = new C75341(this);
    @C6562a
    /* renamed from: b */
    C6369g f32980b;
    /* renamed from: v */
    private ReactUnthemedRootView f32981v;
    /* renamed from: w */
    private C6396c f32982w;
    /* renamed from: x */
    private C6396c f32983x;
    /* renamed from: y */
    private boolean f32984y;
    /* renamed from: z */
    private String f32985z;

    /* renamed from: host.exp.exponent.experience.ExperienceActivity$1 */
    class C75341 implements C6317d {
        /* renamed from: a */
        final /* synthetic */ ExperienceActivity f26125a;

        /* renamed from: host.exp.exponent.experience.ExperienceActivity$1$2 */
        class C63072 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C75341 f20521a;

            C63072(C75341 c75341) {
                this.f20521a = c75341;
            }

            public void run() {
                this.f20521a.f26125a.m44479y();
            }
        }

        /* renamed from: host.exp.exponent.experience.ExperienceActivity$1$3 */
        class C63083 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C75341 f20522a;

            C63083(C75341 c75341) {
                this.f20522a = c75341;
            }

            public void run() {
                this.f20522a.f26125a.m44477w();
            }
        }

        C75341(ExperienceActivity experienceActivity) {
            this.f26125a = experienceActivity;
        }

        /* renamed from: a */
        public void mo5402a(final String str, final Integer num, final Integer num2) {
            UiThreadUtil.runOnUiThread(new Runnable(this) {
                /* renamed from: d */
                final /* synthetic */ C75341 f20520d;

                public void run() {
                    this.f20520d.f26125a.m44466a(str, num, num2);
                }
            });
        }

        /* renamed from: a */
        public void mo5400a() {
            UiThreadUtil.runOnUiThread(new C63072(this));
        }

        /* renamed from: a */
        public void mo5401a(Exception exception) {
            UiThreadUtil.runOnUiThread(new C63083(this));
        }
    }

    /* renamed from: host.exp.exponent.experience.ExperienceActivity$6 */
    class C75376 implements C6268c {
        /* renamed from: a */
        final /* synthetic */ ExperienceActivity f26130a;

        C75376(ExperienceActivity experienceActivity) {
            this.f26130a = experienceActivity;
        }

        /* renamed from: a */
        public void mo5392a() {
            this.f26130a.c = this.f26130a.m44464a(this.f26130a, this.f26130a.f32985z, this.f26130a.k, this.f26130a.f32982w, this.f26130a.f32984y, this.f26130a.mo6911c(), this.f26130a.mo6912d(), this.f26130a.f32979F);
        }

        /* renamed from: a */
        public void mo5393a(String str) {
            C6355n.m26073a().mo5408a(str);
        }
    }

    /* renamed from: c */
    public List<ReactPackage> mo6911c() {
        return null;
    }

    /* renamed from: d */
    public List<C6002i> mo6912d() {
        return null;
    }

    /* renamed from: l */
    public ExponentPackageDelegate mo5397l() {
        return null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = true;
        this.f32977D = true;
        this.f32978E = true;
        C6294a.m25957a().m25961b(ExperienceActivity.class, this);
        C5884c.m24753a().m24767b(this);
        this.j = C6387e.m26201a();
        if (bundle != null) {
            bundle = bundle.getString("experienceUrl");
            if (bundle != null) {
                this.f = bundle;
            }
        }
        bundle = getIntent().getExtras();
        if (bundle != null && this.f == null) {
            String string = bundle.getString("experienceUrl");
            if (string != null) {
                this.f = string;
            }
            if (bundle.getBoolean("isOptimistic") != null) {
                z = false;
            }
        }
        if (this.f != null && r0) {
            new C6295c(this, this.f, getIntent().getBooleanExtra("loadFromCache", false)) {
                /* renamed from: d */
                final /* synthetic */ ExperienceActivity f26126d;

                /* renamed from: a */
                public void mo5386a(final JSONObject jSONObject) {
                    C6271b.m25897a().m25913a(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ C75352 f20524b;

                        public void run() {
                            this.f20524b.f26126d.m44595a(jSONObject);
                        }
                    });
                }

                /* renamed from: b */
                public void mo5388b(final JSONObject jSONObject) {
                    C6271b.m25897a().m25913a(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ C75352 f20526b;

                        public void run() {
                            try {
                                this.f20526b.f26126d.m44593a(this.f20526b.f26126d.f, jSONObject, C6339i.m26062a(jSONObject.getString("bundleUrl")), null);
                            } catch (Exception e) {
                                this.f20526b.f26126d.a.mo5407a(e);
                            }
                        }
                    });
                }

                /* renamed from: a */
                public void mo5385a(String str) {
                    this.f26126d.m44592a(str);
                }

                /* renamed from: c */
                public void mo5389c(JSONObject jSONObject) {
                    this.f26126d.m44598b(jSONObject);
                }

                /* renamed from: a */
                public void mo5384a(Exception exception) {
                    this.f26126d.a.mo5407a(exception);
                }

                /* renamed from: b */
                public void mo5387b(String str) {
                    this.f26126d.a.mo5408a(str);
                }
            }.m25983a();
        }
        this.a.m34241a(this, getTaskId());
    }

    protected void onResume() {
        super.onResume();
        m44604m();
        m44583d(null);
        C6288a.m25943a("EXPERIENCE_APPEARED", this.f);
        m44562i();
    }

    /* renamed from: m */
    public void m44604m() {
        if (this.k != null) {
            SoLoader.init(this, false);
        }
    }

    /* renamed from: k */
    public void mo6921k() {
        if (this.f != null && this.a.m34249b(this.f).booleanValue()) {
            m44591a(this.a.m34253c(this.f));
        }
        if (this.i != null && C6290a.m25954a(this.i) < C6290a.m25954a("28.0.0")) {
            m44605n();
        }
    }

    /* renamed from: n */
    protected void m44605n() {
        String optString = this.o.optString("id");
        if (optString != null) {
            new C6398e(this).m26269a(optString);
        }
    }

    protected void onPause() {
        super.onPause();
        mo6917a();
        C6288a.m25939a();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("experienceUrl", this.f);
        super.onSaveInstanceState(bundle);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent = intent.getData();
        if (intent != null) {
            m44581c(intent.toString());
        }
    }

    public void onEventMainThread(C6347b c6347b) {
        C6383a.m26189a("experienceActivityKernelDidLoad");
    }

    /* renamed from: o */
    protected void mo6913o() {
        C6288a.m25941a(C6287a.FINISHED_LOADING_REACT_NATIVE);
        C6288a.m25948b(this.f);
    }

    /* renamed from: a */
    public void m44595a(final JSONObject jSONObject) {
        runOnUiThread(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ ExperienceActivity f20528b;

            public void run() {
                if (this.f20528b.m44476v() && this.f20528b.f32978E) {
                    C6386d.m26199a(jSONObject.optString("sdkVersion"), jSONObject, this.f20528b);
                    this.f20528b.m44471c(jSONObject);
                    C6386d.m26198a(this.f20528b.f32980b, jSONObject, this.f20528b);
                }
            }
        });
    }

    /* renamed from: a */
    public void m44593a(java.lang.String r4, final org.json.JSONObject r5, java.lang.String r6, final org.json.JSONObject r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.m44476v();
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r3.f32977D;
        if (r0 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r0 = 0;
        r3.f32977D = r0;
        r3.f32974A = r0;
        r3.f = r4;
        r3.o = r5;
        r1 = new host.exp.exponent.notifications.e;
        r1.<init>(r3);
        r2 = r3.o;
        r1.m26275a(r2);
        r1 = r3.a;
        r2 = r3.f;
        r1 = r1.m34255d(r2);
        r2 = r3.getTaskId();
        r1.f20598b = r2;
        r2 = new java.lang.ref.WeakReference;
        r2.<init>(r3);
        r1.f20599c = r2;
        r2 = r3.j;
        r1.f20600d = r2;
        r1.f20601e = r6;
        r6 = "sdkVersion";
        r6 = r5.optString(r6);
        r3.i = r6;
        r6 = host.exp.exponent.C6301d.f20496b;
        r6 = r4.equals(r6);
        r3.f32984y = r6;
        r6 = "32.0.0";
        r1 = r3.i;
        r6 = r6.equals(r1);
        if (r6 == 0) goto L_0x0058;
    L_0x0054:
        r6 = "UNVERSIONED";
        r3.i = r6;
    L_0x0058:
        r6 = host.exp.exponent.C6301d.m26001a();
        if (r6 == 0) goto L_0x0061;
    L_0x005e:
        r6 = "UNVERSIONED";
        goto L_0x0063;
    L_0x0061:
        r6 = r3.i;
    L_0x0063:
        r3.k = r6;
        r6 = "UNVERSIONED";
        r1 = r3.i;
        r6 = r6.equals(r1);
        if (r6 != 0) goto L_0x00c3;
    L_0x006f:
        r6 = host.exp.exponent.C6301d.f20500f;
        r6 = r6.iterator();
    L_0x0075:
        r1 = r6.hasNext();
        if (r1 == 0) goto L_0x008b;
    L_0x007b:
        r1 = r6.next();
        r1 = (java.lang.String) r1;
        r2 = r3.i;
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0075;
    L_0x0089:
        r6 = 1;
        goto L_0x008c;
    L_0x008b:
        r6 = 0;
    L_0x008c:
        if (r6 != 0) goto L_0x00c3;
    L_0x008e:
        r4 = host.exp.exponent.p339f.C6355n.m26073a();
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r3.i;
        r5.append(r6);
        r6 = " is not a valid SDK version. Options are ";
        r5.append(r6);
        r6 = ", ";
        r7 = host.exp.exponent.C6301d.f20500f;
        r6 = android.text.TextUtils.join(r6, r7);
        r5.append(r6);
        r6 = ", ";
        r5.append(r6);
        r6 = "UNVERSIONED";
        r5.append(r6);
        r6 = ".";
        r5.append(r6);
        r5 = r5.toString();
        r4.mo5408a(r5);
        return;
    L_0x00c3:
        r3.m44604m();
        r6 = "id";	 Catch:{ JSONException -> 0x0147 }
        r6 = r5.getString(r6);	 Catch:{ JSONException -> 0x0147 }
        r3.g = r6;	 Catch:{ JSONException -> 0x0147 }
        r6 = r3.g;	 Catch:{ JSONException -> 0x0147 }
        r6 = host.exp.exponent.p339f.C6330b.m26047a(r6);	 Catch:{ JSONException -> 0x0147 }
        r3.h = r6;	 Catch:{ JSONException -> 0x0147 }
        r6 = "experienceIdSetForActivity";	 Catch:{ JSONException -> 0x0147 }
        host.exp.exponent.p346j.C6383a.m26189a(r6);	 Catch:{ JSONException -> 0x0147 }
        r3.d = r0;
        r6 = "LOAD_EXPERIENCE";
        r0 = r3.f;
        r1 = r3.i;
        host.exp.exponent.p334a.C6288a.m25944a(r6, r0, r1);
        r6 = r3.o;
        host.exp.exponent.p346j.C6386d.m26200a(r6, r3);
        r3.m44583d(r7);
        r6 = 0;
        r0 = r3.a;
        r0 = r0.m34249b(r4);
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x010b;
    L_0x00fb:
        r6 = r3.a;
        r4 = r6.m34253c(r4);
        r6 = r4.f20610b;
        if (r6 == 0) goto L_0x0109;
    L_0x0105:
        r6 = r4.f20610b;
        r3.f32985z = r6;
    L_0x0109:
        r6 = r4.f20612d;
    L_0x010b:
        r4 = r3.f32985z;
        if (r4 == 0) goto L_0x0119;
    L_0x010f:
        r4 = r3.f32985z;
        r0 = host.exp.exponent.C6301d.f20496b;
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x0137;
    L_0x0119:
        r4 = host.exp.exponent.C6301d.f20497c;
        if (r4 == 0) goto L_0x0133;
    L_0x011d:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = host.exp.exponent.C6301d.f20497c;
        r4.append(r0);
        r0 = "://";
        r4.append(r0);
        r4 = r4.toString();
        r3.f32985z = r4;
        goto L_0x0137;
    L_0x0133:
        r4 = r3.f;
        r3.f32985z = r4;
    L_0x0137:
        r4 = r3.f32985z;
        r0 = r3.k;
        host.exp.exponent.p335b.C6291a.m25955a(r3, r4, r0);
        r4 = new host.exp.exponent.experience.ExperienceActivity$4;
        r4.<init>(r3, r6, r5, r7);
        r3.runOnUiThread(r4);
        return;
    L_0x0147:
        r4 = host.exp.exponent.p339f.C6355n.m26073a();
        r5 = "No ID found in manifest.";
        r4.mo5408a(r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.experience.ExperienceActivity.a(java.lang.String, org.json.JSONObject, java.lang.String, org.json.JSONObject):void");
    }

    /* renamed from: a */
    public void m44592a(final String str) {
        this.f32978E = false;
        if (!mo6900h()) {
            final boolean z = this.f32974A;
            C6383a.m26190a(f32973u, new C6382a(this) {
                /* renamed from: c */
                final /* synthetic */ ExperienceActivity f26129c;

                /* renamed from: a */
                public boolean mo5390a() {
                    return z;
                }

                /* renamed from: b */
                public void mo5391b() {
                    this.f26129c.f32982w = this.f26129c.f32983x;
                    this.f26129c.f32983x = null;
                    this.f26129c.m44469b(str);
                    C6383a.m26191b(ExperienceActivity.f32973u);
                }
            });
        }
    }

    public void onEventMainThread(C7595k c7595k) {
        if (c7595k.a.equals(this.g)) {
            try {
                new C6394j("com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter").m26233a(this.k);
                Object[] objArr = new Object[]{"Exponent.notification", c7595k.m26253a(this.k, "received")};
                this.c.m26241b("getCurrentReactContext", new Object[0]).m26241b("getJSModule", r0.m26247d()).m26236a("emit", objArr);
            } catch (Throwable th) {
                C6289b.m25950a(f32972t, th);
            }
        }
    }

    /* renamed from: a */
    public void m44591a(C6351c c6351c) {
        try {
            if (c6351c.f20610b != null) {
                m44581c(c6351c.f20610b);
                if (c6351c.f20610b != null) {
                    new C6394j("com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter").m26233a(this.k);
                    Object[] objArr = new Object[]{"Exponent.openUri", r0};
                    this.c.m26241b("getCurrentReactContext", new Object[0]).m26241b("getJSModule", r4.m26247d()).m26236a("emit", objArr);
                }
                C6291a.m25955a(this, c6351c.f20610b, this.k);
            }
            if ((c6351c.f20611c != null || c6351c.f20612d != null) && this.k != null) {
                new C6394j("com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter").m26233a(this.k);
                Object[] objArr2 = new Object[]{"Exponent.notification", c6351c.f20612d.m26253a(this.k, "selected")};
                this.c.m26241b("getCurrentReactContext", new Object[0]).m26241b("getJSModule", r0.m26247d()).m26236a("emit", objArr2);
            }
        } catch (Throwable th) {
            C6289b.m25950a(f32972t, th);
        }
    }

    /* renamed from: c */
    private void m44581c(String str) {
        super.onNewIntent(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    /* renamed from: b */
    public void m44598b(JSONObject jSONObject) {
        C6355n.m26073a().m26068a(this.f, new C6350b("Exponent.nativeUpdatesEvent", jSONObject.toString()));
    }

    /* renamed from: h */
    public boolean mo6900h() {
        return C6369g.m26131b(this.o);
    }

    /* renamed from: p */
    protected void mo6915p() {
        C6271b.m25897a().m25914a(mo6900h(), this.o, new C75376(this));
    }

    /* renamed from: a */
    public void mo5395a(JSONArray jSONArray) {
        C6408j a = C6408j.m26297a();
        if (a != null) {
            a.m26306a((Context) this, jSONArray);
        }
    }

    public void onEvent(C6321a c6321a) {
        this.a.m34237a();
    }

    /* renamed from: d */
    private void m44583d(JSONObject jSONObject) {
        if (this.f != null) {
            if (this.o != null) {
                jSONObject = this.o.optString("name", null);
                if (jSONObject != null) {
                    if (this.o.optBoolean("androidShowExponentNotificationInShellApp") || !this.f32984y) {
                        RemoteViews remoteViews = new RemoteViews(getPackageName(), this.f32984y ? C6275d.notification_shell_app : C6275d.notification);
                        remoteViews.setCharSequence(C6274c.home_text_button, "setText", jSONObject);
                        remoteViews.setOnClickPendingIntent(C6274c.home_image_button, PendingIntent.getActivity(this, 0, new Intent(this, LauncherActivity.class), 0));
                        remoteViews.setOnClickPendingIntent(C6274c.home_text_button, PendingIntent.getService(this, 0, ExponentIntentService.m25928a((Context) this, this.f), 134217728));
                        if (!this.f32984y) {
                            Intent intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(jSONObject);
                            stringBuilder.append(" on Exponent");
                            intent.putExtra("android.intent.extra.SUBJECT", stringBuilder.toString());
                            intent.putExtra("android.intent.extra.TEXT", this.f);
                            int i = C6274c.share_button;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Share a link to ");
                            stringBuilder.append(jSONObject);
                            remoteViews.setOnClickPendingIntent(i, PendingIntent.getActivity(this, 0, Intent.createChooser(intent, stringBuilder.toString()), 134217728));
                            remoteViews.setOnClickPendingIntent(C6274c.save_button, PendingIntent.getService(this, 0, ExponentIntentService.m25934c(this, this.f), 134217728));
                        }
                        remoteViews.setOnClickPendingIntent(C6274c.reload_button, PendingIntent.getService(this, 0, ExponentIntentService.m25932b(this, this.f), 134217728));
                        this.f32975B = remoteViews;
                        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
                        notificationManager.cancel(10101);
                        new C6398e(this).m26268a();
                        this.f32976C = new C0279d(this, "expo-experience").a(this.f32975B).a(C6273b.notification_icon).a(false).b(true).d(2);
                        this.f32976C.e(C0366b.c(this, C6272a.colorPrimary));
                        notificationManager.notify(10101, this.f32976C.a());
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void mo6917a() {
        this.f32975B = null;
        this.f32976C = null;
        m44574a((Context) this);
    }

    /* renamed from: e */
    private void m44584e(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.getBoolean("loadNux") != null) {
                    jSONObject = C6301d.f20502h;
                }
            } catch (JSONObject jSONObject2) {
                C6289b.m25953c(f32972t, jSONObject2.getMessage());
            }
        }
    }

    /* renamed from: a */
    public static void m44574a(Context context) {
        ((NotificationManager) context.getSystemService("notification")).cancel(10101);
    }

    /* renamed from: q */
    public void m44608q() {
        m44596a(true);
    }

    /* renamed from: a */
    public void m44596a(final boolean z) {
        if (this.f32981v != null) {
            runOnUiThread(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ ExperienceActivity f20535b;

                /* renamed from: host.exp.exponent.experience.ExperienceActivity$7$1 */
                class C63131 implements AnimationListener {
                    /* renamed from: a */
                    final /* synthetic */ C63147 f20533a;

                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    C63131(C63147 c63147) {
                        this.f20533a = c63147;
                    }

                    public void onAnimationEnd(Animation animation) {
                        this.f20533a.f20535b.m44470c(this.f20533a.f20535b.f32981v);
                        this.f20533a.f20535b.f32981v = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("IS_FROM_NOTIFICATION", z);
                        } catch (JSONException e) {
                            C6289b.m25953c(ExperienceActivity.f32972t, e.getMessage());
                        }
                        C6288a.m25945a("NUX_EXPERIENCE_OVERLAY_DISMISSED", jSONObject);
                    }
                }

                public void run() {
                    Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setInterpolator(new AccelerateInterpolator());
                    alphaAnimation.setDuration(500);
                    alphaAnimation.setAnimationListener(new C63131(this));
                    this.f20535b.f32981v.startAnimation(alphaAnimation);
                }
            });
        }
    }

    /* renamed from: a */
    protected void mo6909a(Intent intent) {
        if (this.f != null) {
            intent.putExtra("manifestUrl", this.f);
        }
    }

    /* renamed from: b */
    protected void mo6910b(C6332e c6332e) {
        if (this.o != null) {
            c6332e = c6332e.m26050a();
            if (c6332e != null) {
                String optString = this.o.optString("id");
                if (optString != null) {
                    JSONObject e = this.r.m26165e(optString);
                    if (e == null) {
                        e = new JSONObject();
                    }
                    JSONArray optJSONArray = e.optJSONArray("lastErrors");
                    if (optJSONArray == null) {
                        optJSONArray = new JSONArray();
                    }
                    optJSONArray.put(c6332e);
                    try {
                        e.put("lastErrors", optJSONArray);
                        this.r.m26158b(optString, e);
                    } catch (C6332e c6332e2) {
                        c6332e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: r */
    public String m44609r() {
        return this.g;
    }
}
