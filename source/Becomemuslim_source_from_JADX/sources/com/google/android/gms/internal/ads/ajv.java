package com.google.android.gms.internal.ads;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.ads.internal.ax;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@cm
public final class ajv implements OnGlobalLayoutListener, OnScrollChangedListener {
    /* renamed from: a */
    protected final ajt f14613a;
    /* renamed from: b */
    private final Object f14614b = new Object();
    /* renamed from: c */
    private final WeakReference<is> f14615c;
    /* renamed from: d */
    private WeakReference<ViewTreeObserver> f14616d;
    /* renamed from: e */
    private final alh f14617e;
    /* renamed from: f */
    private final Context f14618f;
    /* renamed from: g */
    private final WindowManager f14619g;
    /* renamed from: h */
    private final PowerManager f14620h;
    /* renamed from: i */
    private final KeyguardManager f14621i;
    /* renamed from: j */
    private final DisplayMetrics f14622j;
    /* renamed from: k */
    private akd f14623k;
    /* renamed from: l */
    private boolean f14624l;
    /* renamed from: m */
    private boolean f14625m = false;
    /* renamed from: n */
    private boolean f14626n = false;
    /* renamed from: o */
    private boolean f14627o;
    /* renamed from: p */
    private boolean f14628p;
    /* renamed from: q */
    private boolean f14629q;
    /* renamed from: r */
    private BroadcastReceiver f14630r;
    /* renamed from: s */
    private final HashSet<ajs> f14631s = new HashSet();
    /* renamed from: t */
    private lx f14632t;
    /* renamed from: u */
    private final HashSet<akr> f14633u = new HashSet();
    /* renamed from: v */
    private final Rect f14634v = new Rect();
    /* renamed from: w */
    private final ajy f14635w;
    /* renamed from: x */
    private float f14636x;

    public ajv(Context context, aou aou, is isVar, mv mvVar, alh alh) {
        this.f14615c = new WeakReference(isVar);
        this.f14617e = alh;
        this.f14616d = new WeakReference(null);
        this.f14627o = true;
        this.f14629q = false;
        this.f14632t = new lx(200);
        this.f14613a = new ajt(UUID.randomUUID().toString(), mvVar, aou.f28279a, isVar.f15584k, isVar.m19566a(), aou.f28286h);
        this.f14619g = (WindowManager) context.getSystemService("window");
        this.f14620h = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.f14621i = (KeyguardManager) context.getSystemService("keyguard");
        this.f14618f = context;
        this.f14635w = new ajy(this, new Handler());
        this.f14618f.getContentResolver().registerContentObserver(System.CONTENT_URI, true, this.f14635w);
        this.f14622j = context.getResources().getDisplayMetrics();
        Display defaultDisplay = this.f14619g.getDefaultDisplay();
        this.f14634v.right = defaultDisplay.getWidth();
        this.f14634v.bottom = defaultDisplay.getHeight();
        m18530a();
    }

    /* renamed from: a */
    private static int m18522a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    /* renamed from: a */
    private final JSONObject m18523a(View view, Boolean bool) {
        if (view == null) {
            return m18528i().put("isAttachedToWindow", false).put("isScreenOn", m18529j()).put("isVisible", false);
        }
        boolean a = ax.g().mo6877a(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Throwable e) {
            mt.m19919b("Failure getting view location.", e);
        }
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect2, null);
        Rect rect3 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect3);
        Rect rect4 = new Rect();
        view.getHitRect(rect4);
        JSONObject i = m18528i();
        i.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", a).put("viewBox", new JSONObject().put(ViewProps.TOP, m18522a(this.f14634v.top, this.f14622j)).put(ViewProps.BOTTOM, m18522a(this.f14634v.bottom, this.f14622j)).put(ViewProps.LEFT, m18522a(this.f14634v.left, this.f14622j)).put(ViewProps.RIGHT, m18522a(this.f14634v.right, this.f14622j))).put("adBox", new JSONObject().put(ViewProps.TOP, m18522a(rect.top, this.f14622j)).put(ViewProps.BOTTOM, m18522a(rect.bottom, this.f14622j)).put(ViewProps.LEFT, m18522a(rect.left, this.f14622j)).put(ViewProps.RIGHT, m18522a(rect.right, this.f14622j))).put("globalVisibleBox", new JSONObject().put(ViewProps.TOP, m18522a(rect2.top, this.f14622j)).put(ViewProps.BOTTOM, m18522a(rect2.bottom, this.f14622j)).put(ViewProps.LEFT, m18522a(rect2.left, this.f14622j)).put(ViewProps.RIGHT, m18522a(rect2.right, this.f14622j))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put(ViewProps.TOP, m18522a(rect3.top, this.f14622j)).put(ViewProps.BOTTOM, m18522a(rect3.bottom, this.f14622j)).put(ViewProps.LEFT, m18522a(rect3.left, this.f14622j)).put(ViewProps.RIGHT, m18522a(rect3.right, this.f14622j))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put(ViewProps.TOP, m18522a(rect4.top, this.f14622j)).put(ViewProps.BOTTOM, m18522a(rect4.bottom, this.f14622j)).put(ViewProps.LEFT, m18522a(rect4.left, this.f14622j)).put(ViewProps.RIGHT, m18522a(rect4.right, this.f14622j))).put("screenDensity", (double) this.f14622j.density);
        if (bool == null) {
            bool = Boolean.valueOf(ax.e().m19743a(view, this.f14620h, this.f14621i));
        }
        i.put("isVisible", bool.booleanValue());
        return i;
    }

    /* renamed from: a */
    private static JSONObject m18524a(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }

    /* renamed from: a */
    private final void m18525a(JSONObject jSONObject, boolean z) {
        try {
            jSONObject = m18524a(jSONObject);
            ArrayList arrayList = new ArrayList(this.f14633u);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((akr) obj).mo3836a(jSONObject, z);
            }
        } catch (Throwable th) {
            mt.m19919b("Skipping active view message.", th);
        }
    }

    /* renamed from: g */
    private final void m18526g() {
        if (this.f14623k != null) {
            this.f14623k.mo3830a(this);
        }
    }

    /* renamed from: h */
    private final void m18527h() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f14616d.get();
        if (viewTreeObserver == null) {
            return;
        }
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    /* renamed from: i */
    private final JSONObject m18528i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.f14613a.m18517b()).put("activeViewJSON", this.f14613a.m18518c()).put("timestamp", ax.l().b()).put("adFormat", this.f14613a.m18516a()).put("hashCode", this.f14613a.m18519d()).put("isMraid", this.f14613a.m18520e()).put("isStopped", this.f14626n).put("isPaused", this.f14625m).put("isNative", this.f14613a.m18521f()).put("isScreenOn", m18529j()).put("appMuted", ax.D().m19781b()).put("appVolume", (double) ax.D().m19778a()).put("deviceVolume", (double) this.f14636x);
        return jSONObject;
    }

    /* renamed from: j */
    private final boolean m18529j() {
        return VERSION.SDK_INT >= 20 ? this.f14620h.isInteractive() : this.f14620h.isScreenOn();
    }

    /* renamed from: a */
    public final void m18530a() {
        this.f14636x = ko.m19776a(this.f14618f);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    protected final void m18531a(int r8) {
        /*
        r7 = this;
        r0 = r7.f14614b;
        monitor-enter(r0);
        r1 = r7.f14633u;	 Catch:{ all -> 0x00ce }
        r1 = r1.iterator();	 Catch:{ all -> 0x00ce }
    L_0x0009:
        r2 = r1.hasNext();	 Catch:{ all -> 0x00ce }
        r3 = 0;
        r4 = 1;
        if (r2 == 0) goto L_0x001f;
    L_0x0011:
        r2 = r1.next();	 Catch:{ all -> 0x00ce }
        r2 = (com.google.android.gms.internal.ads.akr) r2;	 Catch:{ all -> 0x00ce }
        r2 = r2.mo3837a();	 Catch:{ all -> 0x00ce }
        if (r2 == 0) goto L_0x0009;
    L_0x001d:
        r1 = 1;
        goto L_0x0020;
    L_0x001f:
        r1 = 0;
    L_0x0020:
        if (r1 == 0) goto L_0x00cc;
    L_0x0022:
        r1 = r7.f14627o;	 Catch:{ all -> 0x00ce }
        if (r1 != 0) goto L_0x0028;
    L_0x0026:
        goto L_0x00cc;
    L_0x0028:
        r1 = r7.f14617e;	 Catch:{ all -> 0x00ce }
        r1 = r1.mo3831a();	 Catch:{ all -> 0x00ce }
        if (r1 == 0) goto L_0x0040;
    L_0x0030:
        r2 = com.google.android.gms.ads.internal.ax.e();	 Catch:{ all -> 0x00ce }
        r5 = r7.f14620h;	 Catch:{ all -> 0x00ce }
        r6 = r7.f14621i;	 Catch:{ all -> 0x00ce }
        r2 = r2.m19743a(r1, r5, r6);	 Catch:{ all -> 0x00ce }
        if (r2 == 0) goto L_0x0040;
    L_0x003e:
        r2 = 1;
        goto L_0x0041;
    L_0x0040:
        r2 = 0;
    L_0x0041:
        if (r1 == 0) goto L_0x0053;
    L_0x0043:
        if (r2 == 0) goto L_0x0053;
    L_0x0045:
        r5 = new android.graphics.Rect;	 Catch:{ all -> 0x00ce }
        r5.<init>();	 Catch:{ all -> 0x00ce }
        r6 = 0;
        r5 = r1.getGlobalVisibleRect(r5, r6);	 Catch:{ all -> 0x00ce }
        if (r5 == 0) goto L_0x0053;
    L_0x0051:
        r5 = 1;
        goto L_0x0054;
    L_0x0053:
        r5 = 0;
    L_0x0054:
        r6 = r7.f14617e;	 Catch:{ all -> 0x00ce }
        r6 = r6.mo3832b();	 Catch:{ all -> 0x00ce }
        if (r6 == 0) goto L_0x0061;
    L_0x005c:
        r7.m18536b();	 Catch:{ all -> 0x00ce }
        monitor-exit(r0);	 Catch:{ all -> 0x00ce }
        return;
    L_0x0061:
        if (r8 != r4) goto L_0x0071;
    L_0x0063:
        r6 = r7.f14632t;	 Catch:{ all -> 0x00ce }
        r6 = r6.m19842a();	 Catch:{ all -> 0x00ce }
        if (r6 != 0) goto L_0x0071;
    L_0x006b:
        r6 = r7.f14629q;	 Catch:{ all -> 0x00ce }
        if (r5 != r6) goto L_0x0071;
    L_0x006f:
        monitor-exit(r0);	 Catch:{ all -> 0x00ce }
        return;
    L_0x0071:
        if (r5 != 0) goto L_0x007b;
    L_0x0073:
        r6 = r7.f14629q;	 Catch:{ all -> 0x00ce }
        if (r6 != 0) goto L_0x007b;
    L_0x0077:
        if (r8 != r4) goto L_0x007b;
    L_0x0079:
        monitor-exit(r0);	 Catch:{ all -> 0x00ce }
        return;
    L_0x007b:
        r8 = java.lang.Boolean.valueOf(r2);	 Catch:{ JSONException -> 0x0089, JSONException -> 0x0089 }
        r8 = r7.m18523a(r1, r8);	 Catch:{ JSONException -> 0x0089, JSONException -> 0x0089 }
        r7.m18525a(r8, r3);	 Catch:{ JSONException -> 0x0089, JSONException -> 0x0089 }
        r7.f14629q = r5;	 Catch:{ JSONException -> 0x0089, JSONException -> 0x0089 }
        goto L_0x008f;
    L_0x0089:
        r8 = move-exception;
        r1 = "Active view update failed.";
        com.google.android.gms.internal.ads.mt.m19916a(r1, r8);	 Catch:{ all -> 0x00ce }
    L_0x008f:
        r8 = r7.f14617e;	 Catch:{ all -> 0x00ce }
        r8 = r8.mo3833c();	 Catch:{ all -> 0x00ce }
        r8 = r8.mo3831a();	 Catch:{ all -> 0x00ce }
        if (r8 == 0) goto L_0x00c7;
    L_0x009b:
        r1 = r7.f14616d;	 Catch:{ all -> 0x00ce }
        r1 = r1.get();	 Catch:{ all -> 0x00ce }
        r1 = (android.view.ViewTreeObserver) r1;	 Catch:{ all -> 0x00ce }
        r8 = r8.getViewTreeObserver();	 Catch:{ all -> 0x00ce }
        if (r8 == r1) goto L_0x00c7;
    L_0x00a9:
        r7.m18527h();	 Catch:{ all -> 0x00ce }
        r2 = r7.f14624l;	 Catch:{ all -> 0x00ce }
        if (r2 == 0) goto L_0x00b8;
    L_0x00b0:
        if (r1 == 0) goto L_0x00c0;
    L_0x00b2:
        r1 = r1.isAlive();	 Catch:{ all -> 0x00ce }
        if (r1 == 0) goto L_0x00c0;
    L_0x00b8:
        r7.f14624l = r4;	 Catch:{ all -> 0x00ce }
        r8.addOnScrollChangedListener(r7);	 Catch:{ all -> 0x00ce }
        r8.addOnGlobalLayoutListener(r7);	 Catch:{ all -> 0x00ce }
    L_0x00c0:
        r1 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x00ce }
        r1.<init>(r8);	 Catch:{ all -> 0x00ce }
        r7.f14616d = r1;	 Catch:{ all -> 0x00ce }
    L_0x00c7:
        r7.m18526g();	 Catch:{ all -> 0x00ce }
        monitor-exit(r0);	 Catch:{ all -> 0x00ce }
        return;
    L_0x00cc:
        monitor-exit(r0);	 Catch:{ all -> 0x00ce }
        return;
    L_0x00ce:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00ce }
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ajv.a(int):void");
    }

    /* renamed from: a */
    public final void m18532a(akd akd) {
        synchronized (this.f14614b) {
            this.f14623k = akd;
        }
    }

    /* renamed from: a */
    public final void m18533a(akr akr) {
        if (this.f14633u.isEmpty()) {
            synchronized (this.f14614b) {
                if (this.f14630r == null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    this.f14630r = new ajw(this);
                    ax.E().m19853a(this.f14618f, this.f14630r, intentFilter);
                }
            }
            m18531a(3);
        }
        this.f14633u.add(akr);
        try {
            akr.mo3836a(m18524a(m18523a(this.f14617e.mo3831a(), null)), false);
        } catch (Throwable e) {
            mt.m19919b("Skipping measurement update for new client.", e);
        }
    }

    /* renamed from: a */
    final void m18534a(akr akr, Map<String, String> map) {
        String str = "Received request to untrack: ";
        String valueOf = String.valueOf(this.f14613a.m18519d());
        mt.m19918b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        m18537b(akr);
    }

    /* renamed from: a */
    final boolean m18535a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.f14613a.m18519d());
    }

    /* renamed from: b */
    public final void m18536b() {
        String str;
        String str2;
        synchronized (this.f14614b) {
            if (this.f14627o) {
                this.f14628p = true;
                try {
                    JSONObject i = m18528i();
                    i.put("doneReasonCode", "u");
                    m18525a(i, true);
                } catch (JSONException e) {
                    Throwable e2 = e;
                    str = "JSON failure while processing active view data.";
                    mt.m19919b(str, e2);
                    str2 = "Untracking ad unit: ";
                    str = String.valueOf(this.f14613a.m18519d());
                    mt.m19918b(str.length() != 0 ? new String(str2) : str2.concat(str));
                } catch (RuntimeException e3) {
                    e2 = e3;
                    str = "Failure while processing active view data.";
                    mt.m19919b(str, e2);
                    str2 = "Untracking ad unit: ";
                    str = String.valueOf(this.f14613a.m18519d());
                    if (str.length() != 0) {
                    }
                    mt.m19918b(str.length() != 0 ? new String(str2) : str2.concat(str));
                }
                str2 = "Untracking ad unit: ";
                str = String.valueOf(this.f14613a.m18519d());
                if (str.length() != 0) {
                }
                mt.m19918b(str.length() != 0 ? new String(str2) : str2.concat(str));
            }
        }
    }

    /* renamed from: b */
    public final void m18537b(akr akr) {
        this.f14633u.remove(akr);
        akr.mo3838b();
        if (this.f14633u.isEmpty()) {
            synchronized (this.f14614b) {
                m18527h();
                synchronized (this.f14614b) {
                    if (this.f14630r != null) {
                        try {
                            ax.E().m19852a(this.f14618f, this.f14630r);
                        } catch (Throwable e) {
                            mt.m19919b("Failed trying to unregister the receiver", e);
                        } catch (Throwable e2) {
                            ax.i().m30834a(e2, "ActiveViewUnit.stopScreenStatusMonitoring");
                        }
                        this.f14630r = null;
                    }
                }
                this.f14618f.getContentResolver().unregisterContentObserver(this.f14635w);
                int i = 0;
                this.f14627o = false;
                m18526g();
                ArrayList arrayList = new ArrayList(this.f14633u);
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    m18537b((akr) obj);
                }
            }
        }
    }

    /* renamed from: b */
    final void m18538b(Map<String, String> map) {
        m18531a(3);
    }

    /* renamed from: c */
    final void m18539c(Map<String, String> map) {
        if (map.containsKey("isVisible")) {
            boolean z;
            Iterator it;
            if (!AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("isVisible"))) {
                if (!ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(map.get("isVisible"))) {
                    z = false;
                    it = this.f14631s.iterator();
                    while (it.hasNext()) {
                        ((ajs) it.next()).m18515a(this, z);
                    }
                }
            }
            z = true;
            it = this.f14631s.iterator();
            while (it.hasNext()) {
                ((ajs) it.next()).m18515a(this, z);
            }
        }
    }

    /* renamed from: c */
    public final boolean m18540c() {
        boolean z;
        synchronized (this.f14614b) {
            z = this.f14627o;
        }
        return z;
    }

    /* renamed from: d */
    public final void m18541d() {
        synchronized (this.f14614b) {
            this.f14626n = true;
            m18531a(3);
        }
    }

    /* renamed from: e */
    public final void m18542e() {
        synchronized (this.f14614b) {
            this.f14625m = true;
            m18531a(3);
        }
    }

    /* renamed from: f */
    public final void m18543f() {
        synchronized (this.f14614b) {
            this.f14625m = false;
            m18531a(3);
        }
    }

    public final void onGlobalLayout() {
        m18531a(2);
    }

    public final void onScrollChanged() {
        m18531a(1);
    }
}
