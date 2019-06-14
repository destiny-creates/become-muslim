package com.onesignal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import com.onesignal.am.C5464i;
import java.util.HashMap;

/* compiled from: OneSignalPrefs */
class aq {
    /* renamed from: a */
    public static final String f18435a = am.class.getSimpleName();
    /* renamed from: b */
    static HashMap<String, HashMap<String, Object>> f18436b;
    /* renamed from: c */
    public static C5473a f18437c;

    /* compiled from: OneSignalPrefs */
    /* renamed from: com.onesignal.aq$a */
    public static class C5473a extends HandlerThread {
        /* renamed from: a */
        public Handler f18433a;
        /* renamed from: b */
        private long f18434b = 0;

        /* compiled from: OneSignalPrefs */
        /* renamed from: com.onesignal.aq$a$1 */
        class C54721 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C5473a f18432a;

            C54721(C5473a c5473a) {
                this.f18432a = c5473a;
            }

            public void run() {
                this.f18432a.m23271c();
            }
        }

        C5473a() {
            super("OSH_WritePrefs");
            start();
            this.f18433a = new Handler(getLooper());
        }

        /* renamed from: a */
        void m23272a() {
            synchronized (this.f18433a) {
                this.f18433a.removeCallbacksAndMessages(null);
                if (this.f18434b == 0) {
                    this.f18434b = System.currentTimeMillis();
                }
                this.f18433a.postDelayed(m23270b(), (this.f18434b - System.currentTimeMillis()) + 200);
            }
        }

        /* renamed from: b */
        private Runnable m23270b() {
            return new C54721(this);
        }

        /* renamed from: c */
        private void m23271c() {
            if (am.f18401b != null) {
                for (String str : aq.f18436b.keySet()) {
                    Editor edit = aq.m23282b(str).edit();
                    HashMap hashMap = (HashMap) aq.f18436b.get(str);
                    synchronized (hashMap) {
                        for (String str2 : hashMap.keySet()) {
                            Object obj = hashMap.get(str2);
                            if (obj instanceof String) {
                                edit.putString(str2, (String) obj);
                            } else if (obj instanceof Boolean) {
                                edit.putBoolean(str2, ((Boolean) obj).booleanValue());
                            } else if (obj instanceof Integer) {
                                edit.putInt(str2, ((Integer) obj).intValue());
                            } else if (obj instanceof Long) {
                                edit.putLong(str2, ((Long) obj).longValue());
                            }
                        }
                        hashMap.clear();
                    }
                    edit.apply();
                }
                this.f18434b = System.currentTimeMillis();
            }
        }
    }

    static {
        m23276a();
    }

    /* renamed from: a */
    public static void m23276a() {
        f18436b = new HashMap();
        f18436b.put(f18435a, new HashMap());
        f18436b.put("GTPlayerPurchases", new HashMap());
        f18437c = new C5473a();
    }

    /* renamed from: b */
    public static void m23284b() {
        f18437c.m23272a();
    }

    /* renamed from: a */
    public static void m23279a(String str, String str2, String str3) {
        m23278a(str, str2, (Object) str3);
    }

    /* renamed from: a */
    public static void m23280a(String str, String str2, boolean z) {
        m23278a(str, str2, Boolean.valueOf(z));
    }

    /* renamed from: a */
    public static void m23277a(String str, String str2, long j) {
        m23278a(str, str2, Long.valueOf(j));
    }

    /* renamed from: a */
    private static void m23278a(String str, String str2, Object obj) {
        HashMap hashMap = (HashMap) f18436b.get(str);
        synchronized (hashMap) {
            hashMap.put(str2, obj);
        }
        m23284b();
    }

    /* renamed from: b */
    static String m23283b(String str, String str2, String str3) {
        return (String) m23275a(str, str2, String.class, str3);
    }

    /* renamed from: b */
    static boolean m23285b(String str, String str2, boolean z) {
        return ((Boolean) m23275a(str, str2, Boolean.class, Boolean.valueOf(z))).booleanValue();
    }

    /* renamed from: a */
    static int m23273a(String str, String str2, int i) {
        return ((Integer) m23275a(str, str2, Integer.class, Integer.valueOf(i))).intValue();
    }

    /* renamed from: b */
    static long m23281b(String str, String str2, long j) {
        return ((Long) m23275a(str, str2, Long.class, Long.valueOf(j))).longValue();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static java.lang.Object m23275a(java.lang.String r3, java.lang.String r4, java.lang.Class r5, java.lang.Object r6) {
        /*
        r0 = f18436b;
        r0 = r0.get(r3);
        r0 = (java.util.HashMap) r0;
        monitor-enter(r0);
        r1 = java.lang.Object.class;
        r1 = r5.equals(r1);	 Catch:{ all -> 0x009c }
        if (r1 == 0) goto L_0x001e;
    L_0x0011:
        r1 = r0.containsKey(r4);	 Catch:{ all -> 0x009c }
        if (r1 == 0) goto L_0x001e;
    L_0x0017:
        r3 = 1;
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x009c }
        monitor-exit(r0);	 Catch:{ all -> 0x009c }
        return r3;
    L_0x001e:
        r1 = r0.get(r4);	 Catch:{ all -> 0x009c }
        if (r1 != 0) goto L_0x009a;
    L_0x0024:
        r2 = r0.containsKey(r4);	 Catch:{ all -> 0x009c }
        if (r2 == 0) goto L_0x002b;
    L_0x002a:
        goto L_0x009a;
    L_0x002b:
        monitor-exit(r0);	 Catch:{ all -> 0x009c }
        r3 = m23282b(r3);
        if (r3 == 0) goto L_0x0099;
    L_0x0032:
        r0 = java.lang.String.class;
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0041;
    L_0x003a:
        r6 = (java.lang.String) r6;
        r3 = r3.getString(r4, r6);
        return r3;
    L_0x0041:
        r0 = java.lang.Boolean.class;
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0058;
    L_0x0049:
        r6 = (java.lang.Boolean) r6;
        r5 = r6.booleanValue();
        r3 = r3.getBoolean(r4, r5);
        r3 = java.lang.Boolean.valueOf(r3);
        return r3;
    L_0x0058:
        r0 = java.lang.Integer.class;
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x006f;
    L_0x0060:
        r6 = (java.lang.Integer) r6;
        r5 = r6.intValue();
        r3 = r3.getInt(r4, r5);
        r3 = java.lang.Integer.valueOf(r3);
        return r3;
    L_0x006f:
        r0 = java.lang.Long.class;
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0086;
    L_0x0077:
        r6 = (java.lang.Long) r6;
        r5 = r6.longValue();
        r3 = r3.getLong(r4, r5);
        r3 = java.lang.Long.valueOf(r3);
        return r3;
    L_0x0086:
        r6 = java.lang.Object.class;
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0097;
    L_0x008e:
        r3 = r3.contains(r4);
        r3 = java.lang.Boolean.valueOf(r3);
        return r3;
    L_0x0097:
        r3 = 0;
        return r3;
    L_0x0099:
        return r6;
    L_0x009a:
        monitor-exit(r0);	 Catch:{ all -> 0x009c }
        return r1;
    L_0x009c:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x009c }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.aq.a(java.lang.String, java.lang.String, java.lang.Class, java.lang.Object):java.lang.Object");
    }

    /* renamed from: b */
    private static synchronized SharedPreferences m23282b(String str) {
        synchronized (aq.class) {
            if (am.f18401b == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("OneSignal.appContext null, could not read ");
                stringBuilder.append(str);
                stringBuilder.append(" from getSharedPreferences.");
                am.m23161a(C5464i.WARN, stringBuilder.toString(), new Throwable());
                return null;
            }
            str = am.f18401b.getSharedPreferences(str, 0);
            return str;
        }
    }
}
