package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@cm
public final class ii {
    /* renamed from: a */
    private final AtomicReference<ThreadPoolExecutor> f15542a = new AtomicReference(null);
    /* renamed from: b */
    private final Object f15543b = new Object();
    /* renamed from: c */
    private String f15544c = null;
    /* renamed from: d */
    private final AtomicBoolean f15545d = new AtomicBoolean(false);
    /* renamed from: e */
    private final AtomicInteger f15546e = new AtomicInteger(-1);
    /* renamed from: f */
    private final AtomicReference<Object> f15547f = new AtomicReference(null);
    /* renamed from: g */
    private final AtomicReference<Object> f15548g = new AtomicReference(null);
    /* renamed from: h */
    private ConcurrentMap<String, Method> f15549h = new ConcurrentHashMap(9);

    /* renamed from: a */
    private static Bundle m19528a(Context context, String str, boolean z) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (Throwable e) {
            String str2 = "Invalid event ID: ";
            str = String.valueOf(str);
            mt.m19919b(str.length() == 0 ? new String(str2) : str2.concat(str), e);
        }
        if (z) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    /* renamed from: a */
    private final Object m19529a(String str, Context context) {
        if (!m19532a(context, "com.google.android.gms.measurement.AppMeasurement", this.f15547f, true)) {
            return null;
        }
        Object invoke;
        try {
            invoke = m19535h(context, str).invoke(this.f15547f.get(), new Object[0]);
        } catch (Exception e) {
            m19531a(e, str, true);
            invoke = null;
        }
        return invoke;
    }

    /* renamed from: a */
    private final void m19530a(Context context, String str, Bundle bundle) {
        if (m19541a(context)) {
            if (m19532a(context, "com.google.android.gms.measurement.AppMeasurement", this.f15547f, true)) {
                Method l = m19537l(context);
                try {
                    l.invoke(this.f15547f.get(), new Object[]{"am", str, bundle});
                } catch (Exception e) {
                    m19531a(e, "logEventInternal", true);
                }
            }
        }
    }

    /* renamed from: a */
    private final void m19531a(Exception exception, String str, boolean z) {
        if (!this.f15545d.get()) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 30);
            stringBuilder.append("Invoke Firebase method ");
            stringBuilder.append(str);
            stringBuilder.append(" error.");
            mt.m19924e(stringBuilder.toString());
            if (z) {
                mt.m19924e("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
                this.f15545d.set(true);
            }
        }
    }

    /* renamed from: a */
    private final boolean m19532a(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet(null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{context}));
            } catch (Exception e) {
                m19531a(e, "getInstance", z);
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private final void m19533b(Context context, String str, String str2) {
        if (m19532a(context, "com.google.android.gms.measurement.AppMeasurement", this.f15547f, true)) {
            Method g = m19534g(context, str2);
            try {
                g.invoke(this.f15547f.get(), new Object[]{str});
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(str2).length() + 37) + String.valueOf(str).length());
                stringBuilder.append("Invoke Firebase method ");
                stringBuilder.append(str2);
                stringBuilder.append(", Ad Unit Id: ");
                stringBuilder.append(str);
                jn.m30864a(stringBuilder.toString());
            } catch (Exception e) {
                m19531a(e, str2, false);
            }
        }
    }

    /* renamed from: g */
    private final Method m19534g(Context context, String str) {
        Method method = (Method) this.f15549h.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[]{String.class});
            this.f15549h.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            m19531a(e, str, false);
            return null;
        }
    }

    /* renamed from: h */
    private final Method m19535h(Context context, String str) {
        Method method = (Method) this.f15549h.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.f15549h.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            m19531a(e, str, false);
            return null;
        }
    }

    /* renamed from: i */
    private final Method m19536i(Context context, String str) {
        Method method = (Method) this.f15549h.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, new Class[]{Activity.class, String.class, String.class});
            this.f15549h.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            m19531a(e, str, false);
            return null;
        }
    }

    /* renamed from: l */
    private final Method m19537l(Context context) {
        Method method = (Method) this.f15549h.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", new Class[]{String.class, String.class, Bundle.class});
            this.f15549h.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            m19531a(e, "logEventInternal", true);
            return null;
        }
    }

    /* renamed from: a */
    public final void m19538a(Context context, String str) {
        if (m19541a(context)) {
            m19533b(context, str, "beginAdUnitExposure");
        }
    }

    /* renamed from: a */
    public final void m19539a(Context context, String str, String str2) {
        if (m19541a(context)) {
            m19530a(context, str, m19528a(context, str2, "_ac".equals(str)));
        }
    }

    /* renamed from: a */
    public final void m19540a(Context context, String str, String str2, String str3, int i) {
        if (m19541a(context)) {
            Bundle a = m19528a(context, str, false);
            a.putString("_ai", str2);
            a.putString("type", str3);
            a.putInt("value", i);
            m19530a(context, "_ar", a);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str3).length() + 75);
            stringBuilder.append("Log a Firebase reward video event, reward type: ");
            stringBuilder.append(str3);
            stringBuilder.append(", reward value: ");
            stringBuilder.append(i);
            jn.m30864a(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public final boolean m19541a(Context context) {
        if (((Boolean) aph.m18688f().m18889a(asp.al)).booleanValue()) {
            if (!this.f15545d.get()) {
                if (this.f15546e.get() == -1) {
                    aph.m18683a();
                    if (!mi.m19880c(context)) {
                        aph.m18683a();
                        if (mi.m19883f(context)) {
                            mt.m19924e("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                            this.f15546e.set(0);
                        }
                    }
                    this.f15546e.set(1);
                }
                if (this.f15546e.get() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public final void m19542b(Context context, String str) {
        if (m19541a(context)) {
            m19533b(context, str, "endAdUnitExposure");
        }
    }

    /* renamed from: b */
    public final boolean m19543b(Context context) {
        return ((Boolean) aph.m18688f().m18889a(asp.am)).booleanValue() && m19541a(context);
    }

    /* renamed from: c */
    public final void m19544c(Context context, String str) {
        if (m19541a(context) && (context instanceof Activity) && m19532a(context, "com.google.firebase.analytics.FirebaseAnalytics", this.f15548g, false)) {
            Method i = m19536i(context, "setCurrentScreen");
            try {
                Activity activity = (Activity) context;
                i.invoke(this.f15548g.get(), new Object[]{activity, str, context.getPackageName()});
            } catch (Exception e) {
                m19531a(e, "setCurrentScreen", false);
            }
        }
    }

    /* renamed from: c */
    public final boolean m19545c(Context context) {
        return ((Boolean) aph.m18688f().m18889a(asp.an)).booleanValue() && m19541a(context);
    }

    /* renamed from: d */
    public final void m19546d(Context context, String str) {
        m19539a(context, "_ac", str);
    }

    /* renamed from: d */
    public final boolean m19547d(Context context) {
        return ((Boolean) aph.m18688f().m18889a(asp.ao)).booleanValue() && m19541a(context);
    }

    /* renamed from: e */
    public final void m19548e(Context context, String str) {
        m19539a(context, "_ai", str);
    }

    /* renamed from: e */
    public final boolean m19549e(Context context) {
        return ((Boolean) aph.m18688f().m18889a(asp.ap)).booleanValue() && m19541a(context);
    }

    /* renamed from: f */
    public final void m19550f(Context context, String str) {
        m19539a(context, "_aq", str);
    }

    /* renamed from: f */
    public final boolean m19551f(Context context) {
        return ((Boolean) aph.m18688f().m18889a(asp.as)).booleanValue() && m19541a(context);
    }

    /* renamed from: g */
    public final String m19552g(Context context) {
        if (!m19541a(context)) {
            return "";
        }
        if (!m19532a(context, "com.google.android.gms.measurement.AppMeasurement", this.f15547f, true)) {
            return "";
        }
        try {
            String str = (String) m19535h(context, "getCurrentScreenName").invoke(this.f15547f.get(), new Object[0]);
            if (str == null) {
                str = (String) m19535h(context, "getCurrentScreenClass").invoke(this.f15547f.get(), new Object[0]);
            }
            return str != null ? str : "";
        } catch (Exception e) {
            m19531a(e, "getCurrentScreenName", false);
            return "";
        }
    }

    /* renamed from: h */
    public final String m19553h(Context context) {
        if (!m19541a(context)) {
            return null;
        }
        synchronized (this.f15543b) {
            if (this.f15544c != null) {
                String str = this.f15544c;
                return str;
            }
            this.f15544c = (String) m19529a("getGmpAppId", context);
            str = this.f15544c;
            return str;
        }
    }

    /* renamed from: i */
    public final String m19554i(Context context) {
        if (!m19541a(context)) {
            return null;
        }
        long longValue = ((Long) aph.m18688f().m18889a(asp.av)).longValue();
        if (longValue < 0) {
            return (String) m19529a("getAppInstanceId", context);
        }
        if (this.f15542a.get() == null) {
            this.f15542a.compareAndSet(null, new ThreadPoolExecutor(((Integer) aph.m18688f().m18889a(asp.aw)).intValue(), ((Integer) aph.m18688f().m18889a(asp.aw)).intValue(), 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), new il(this)));
        }
        Future submit = ((ThreadPoolExecutor) this.f15542a.get()).submit(new ij(this, context));
        try {
            return (String) submit.get(longValue, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            submit.cancel(true);
            return e instanceof TimeoutException ? "TIME_OUT" : null;
        }
    }

    /* renamed from: j */
    public final String m19555j(Context context) {
        if (!m19541a(context)) {
            return null;
        }
        Object a = m19529a("generateEventId", context);
        return a != null ? a.toString() : null;
    }

    /* renamed from: k */
    final /* synthetic */ String m19556k(Context context) {
        return (String) m19529a("getAppInstanceId", context);
    }
}
