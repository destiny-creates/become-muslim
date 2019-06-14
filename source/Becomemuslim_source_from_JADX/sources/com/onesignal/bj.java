package com.onesignal;

import android.os.Handler;
import android.os.HandlerThread;
import com.onesignal.C5526p.C5525f;
import com.onesignal.am.C5457b;
import com.onesignal.am.C5464i;
import com.onesignal.am.C5470o;
import com.onesignal.ar.C5480a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserStateSynchronizer */
abstract class bj {
    /* renamed from: a */
    protected final Object f18509a = new C54931(this);
    /* renamed from: b */
    HashMap<Integer, C5497b> f18510b = new HashMap();
    /* renamed from: c */
    protected boolean f18511c = false;
    /* renamed from: d */
    protected boolean f18512d = false;
    /* renamed from: e */
    protected be f18513e;
    /* renamed from: f */
    protected be f18514f;
    /* renamed from: g */
    private AtomicBoolean f18515g = new AtomicBoolean();
    /* renamed from: h */
    private ArrayList<C5457b> f18516h = new ArrayList();
    /* renamed from: i */
    private final Object f18517i = new C54942(this);

    /* compiled from: UserStateSynchronizer */
    /* renamed from: com.onesignal.bj$1 */
    class C54931 {
        /* renamed from: a */
        final /* synthetic */ bj f18500a;

        C54931(bj bjVar) {
            this.f18500a = bjVar;
        }
    }

    /* compiled from: UserStateSynchronizer */
    /* renamed from: com.onesignal.bj$2 */
    class C54942 {
        /* renamed from: a */
        final /* synthetic */ bj f18501a;

        C54942(bj bjVar) {
            this.f18501a = bjVar;
        }
    }

    /* compiled from: UserStateSynchronizer */
    /* renamed from: com.onesignal.bj$a */
    static class C5495a {
        /* renamed from: a */
        boolean f18502a;
        /* renamed from: b */
        JSONObject f18503b;

        C5495a(boolean z, JSONObject jSONObject) {
            this.f18502a = z;
            this.f18503b = jSONObject;
        }
    }

    /* compiled from: UserStateSynchronizer */
    /* renamed from: com.onesignal.bj$b */
    class C5497b extends HandlerThread {
        /* renamed from: a */
        int f18505a;
        /* renamed from: b */
        Handler f18506b = null;
        /* renamed from: c */
        int f18507c;
        /* renamed from: d */
        final /* synthetic */ bj f18508d;

        /* compiled from: UserStateSynchronizer */
        /* renamed from: com.onesignal.bj$b$1 */
        class C54961 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C5497b f18504a;

            C54961(C5497b c5497b) {
                this.f18504a = c5497b;
            }

            public void run() {
                if (!this.f18504a.f18508d.f18515g.get()) {
                    this.f18504a.f18508d.m23425e(false);
                }
            }
        }

        C5497b(bj bjVar, int i) {
            this.f18508d = bjVar;
            super("OSH_NetworkHandlerThread");
            this.f18505a = i;
            start();
            this.f18506b = new Handler(getLooper());
        }

        /* renamed from: a */
        void m23390a() {
            synchronized (this.f18506b) {
                this.f18507c = 0;
                this.f18506b.removeCallbacksAndMessages(null);
                this.f18506b.postDelayed(m23389c(), 5000);
            }
        }

        /* renamed from: c */
        private Runnable m23389c() {
            if (this.f18505a != 0) {
                return null;
            }
            return new C54961(this);
        }

        /* renamed from: b */
        boolean m23391b() {
            boolean hasMessages;
            synchronized (this.f18506b) {
                Object obj = this.f18507c < 3 ? 1 : null;
                boolean hasMessages2 = this.f18506b.hasMessages(0);
                if (!(obj == null || hasMessages2)) {
                    this.f18507c++;
                    this.f18506b.postDelayed(m23389c(), (long) (this.f18507c * 15000));
                }
                hasMessages = this.f18506b.hasMessages(0);
            }
            return hasMessages;
        }
    }

    /* compiled from: UserStateSynchronizer */
    /* renamed from: com.onesignal.bj$3 */
    class C69573 extends C5480a {
        /* renamed from: a */
        final /* synthetic */ bj f24827a;

        C69573(bj bjVar) {
            this.f24827a = bjVar;
        }

        /* renamed from: a */
        void mo4936a(int i, String str, Throwable th) {
            C5464i c5464i = C5464i.WARN;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed last request. statusCode: ");
            stringBuilder.append(i);
            stringBuilder.append("\nresponse: ");
            stringBuilder.append(str);
            am.m23187b(c5464i, stringBuilder.toString());
            if (this.f24827a.m23394a(i, str, "already logged out of email") != null) {
                this.f24827a.m23404o();
                return;
            }
            if (this.f24827a.m23394a(i, str, "not a valid device_type") != 0) {
                this.f24827a.m23406q();
            } else {
                this.f24827a.m23405p();
            }
        }

        /* renamed from: a */
        void mo4940a(String str) {
            this.f24827a.m23404o();
        }
    }

    /* renamed from: a */
    protected abstract be mo4946a(String str, boolean z);

    /* renamed from: a */
    abstract C5495a mo4947a(boolean z);

    /* renamed from: a */
    abstract void mo4948a(String str);

    /* renamed from: a */
    abstract void mo4949a(JSONObject jSONObject);

    /* renamed from: a */
    abstract boolean mo4950a();

    /* renamed from: b */
    protected abstract void mo4952b(JSONObject jSONObject);

    /* renamed from: b */
    abstract void mo4953b(boolean z);

    /* renamed from: c */
    protected abstract void mo4954c();

    /* renamed from: c */
    protected abstract void mo4955c(JSONObject jSONObject);

    /* renamed from: d */
    protected abstract String mo4956d();

    /* renamed from: d */
    protected abstract void mo4957d(JSONObject jSONObject);

    /* renamed from: e */
    abstract void mo4958e();

    bj() {
    }

    /* renamed from: f */
    String m23426f() {
        return m23428g().f18498b.optString("identifier", null);
    }

    /* renamed from: a */
    protected JSONObject m23410a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set<String> set) {
        synchronized (this.f18509a) {
            jSONObject = C5518o.m23504a(jSONObject, jSONObject2, jSONObject3, (Set) set);
        }
        return jSONObject;
    }

    /* renamed from: g */
    protected be m23428g() {
        synchronized (this.f18509a) {
            if (this.f18514f == null) {
                this.f18514f = mo4946a("TOSYNC_STATE", true);
            }
        }
        return this.f18514f;
    }

    /* renamed from: h */
    void m23429h() {
        synchronized (this.f18509a) {
            if (this.f18513e == null) {
                this.f18513e = mo4946a("CURRENT_STATE", true);
            }
        }
        m23428g();
    }

    /* renamed from: i */
    void m23430i() {
        m23428g().m23387c();
        m23428g().m23388d();
    }

    /* renamed from: j */
    boolean m23431j() {
        boolean z = false;
        if (this.f18514f == null) {
            return false;
        }
        synchronized (this.f18509a) {
            if (this.f18513e.m23380a(this.f18514f, mo4951b()) != null) {
                z = true;
            }
            this.f18514f.m23388d();
        }
        return z;
    }

    /* renamed from: b */
    private boolean mo4951b() {
        return this.f18511c && !this.f18512d;
    }

    /* renamed from: n */
    private boolean m23403n() {
        return m23428g().f18497a.optBoolean("logoutEmail", false);
    }

    /* renamed from: e */
    void m23425e(boolean z) {
        this.f18515g.set(true);
        mo4959c(z);
        this.f18515g.set(false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private void mo4959c(boolean r8) {
        /*
        r7 = this;
        r0 = r7.mo4956d();
        r1 = r7.m23403n();
        if (r1 == 0) goto L_0x0010;
    L_0x000a:
        if (r0 == 0) goto L_0x0010;
    L_0x000c:
        r7.m23400c(r0);
        return;
    L_0x0010:
        r1 = r7.f18513e;
        if (r1 != 0) goto L_0x0017;
    L_0x0014:
        r7.m23429h();
    L_0x0017:
        r1 = r7.mo4951b();
        r2 = r7.f18509a;
        monitor-enter(r2);
        r3 = r7.f18513e;	 Catch:{ all -> 0x0079 }
        r4 = r7.m23428g();	 Catch:{ all -> 0x0079 }
        r3 = r3.m23380a(r4, r1);	 Catch:{ all -> 0x0079 }
        r4 = r7.f18513e;	 Catch:{ all -> 0x0079 }
        r4 = r4.f18497a;	 Catch:{ all -> 0x0079 }
        r5 = r7.m23428g();	 Catch:{ all -> 0x0079 }
        r5 = r5.f18497a;	 Catch:{ all -> 0x0079 }
        r6 = 0;
        r4 = r7.m23410a(r4, r5, r6, r6);	 Catch:{ all -> 0x0079 }
        if (r3 != 0) goto L_0x0064;
    L_0x0039:
        r8 = r7.f18513e;	 Catch:{ all -> 0x0079 }
        r8.m23383a(r4, r6);	 Catch:{ all -> 0x0079 }
        r8 = r7.f18516h;	 Catch:{ all -> 0x0079 }
        r8 = r8.iterator();	 Catch:{ all -> 0x0079 }
    L_0x0044:
        r0 = r8.hasNext();	 Catch:{ all -> 0x0079 }
        if (r0 == 0) goto L_0x005d;
    L_0x004a:
        r0 = r8.next();	 Catch:{ all -> 0x0079 }
        r0 = (com.onesignal.am.C5457b) r0;	 Catch:{ all -> 0x0079 }
        if (r0 == 0) goto L_0x0044;
    L_0x0052:
        r1 = 0;
        r1 = com.onesignal.as.m23314d(r1);	 Catch:{ all -> 0x0079 }
        r1 = r1.f18503b;	 Catch:{ all -> 0x0079 }
        r0.m23110a(r1);	 Catch:{ all -> 0x0079 }
        goto L_0x0044;
    L_0x005d:
        r8 = r7.f18516h;	 Catch:{ all -> 0x0079 }
        r8.clear();	 Catch:{ all -> 0x0079 }
        monitor-exit(r2);	 Catch:{ all -> 0x0079 }
        return;
    L_0x0064:
        r5 = r7.m23428g();	 Catch:{ all -> 0x0079 }
        r5.m23388d();	 Catch:{ all -> 0x0079 }
        monitor-exit(r2);	 Catch:{ all -> 0x0079 }
        if (r1 == 0) goto L_0x0075;
    L_0x006e:
        if (r8 == 0) goto L_0x0071;
    L_0x0070:
        goto L_0x0075;
    L_0x0071:
        r7.m23397b(r0, r3, r4);
        goto L_0x0078;
    L_0x0075:
        r7.m23393a(r0, r3, r4);
    L_0x0078:
        return;
    L_0x0079:
        r8 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0079 }
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.bj.c(boolean):void");
    }

    /* renamed from: c */
    private void m23400c(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("players/");
        stringBuilder.append(str);
        stringBuilder.append("/email_logout");
        str = stringBuilder.toString();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = this.f18513e.f18497a;
            if (jSONObject2.has("email_auth_hash")) {
                jSONObject.put("email_auth_hash", jSONObject2.optString("email_auth_hash"));
            }
            jSONObject2 = this.f18513e.f18498b;
            if (jSONObject2.has("parent_player_id")) {
                jSONObject.put("parent_player_id", jSONObject2.optString("parent_player_id"));
            }
            jSONObject.put("app_id", jSONObject2.optString("app_id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ar.m23300d(str, jSONObject, new C69573(this));
    }

    /* renamed from: o */
    private void m23404o() {
        m23428g().f18497a.remove("logoutEmail");
        this.f18514f.f18497a.remove("email_auth_hash");
        this.f18514f.f18498b.remove("parent_player_id");
        this.f18514f.m23388d();
        this.f18513e.f18497a.remove("email_auth_hash");
        this.f18513e.f18498b.remove("parent_player_id");
        String optString = this.f18513e.f18498b.optString("email");
        this.f18513e.f18498b.remove("email");
        as.m23323l();
        C5464i c5464i = C5464i.INFO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Device successfully logged out of email: ");
        stringBuilder.append(optString);
        am.m23187b(c5464i, stringBuilder.toString());
        am.m23260x();
    }

    /* renamed from: a */
    private void m23393a(String str, final JSONObject jSONObject, final JSONObject jSONObject2) {
        if (str == null) {
            str = this.f18516h.iterator();
            while (str.hasNext() != null) {
                C5457b c5457b = (C5457b) str.next();
                if (c5457b != null) {
                    c5457b.m23109a(new C5470o(-1, "Unable to update tags: the current user is not registered with OneSignal"));
                }
            }
            this.f18516h.clear();
            return;
        }
        final ArrayList arrayList = (ArrayList) this.f18516h.clone();
        this.f18516h.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("players/");
        stringBuilder.append(str);
        ar.m23298c(stringBuilder.toString(), jSONObject, new C5480a(this) {
            /* renamed from: d */
            final /* synthetic */ bj f24831d;

            /* renamed from: a */
            void mo4936a(int i, String str, Throwable th) {
                C5464i c5464i = C5464i.WARN;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed last request. statusCode: ");
                stringBuilder.append(i);
                stringBuilder.append("\nresponse: ");
                stringBuilder.append(str);
                am.m23187b(c5464i, stringBuilder.toString());
                synchronized (this.f24831d.f18509a) {
                    if (this.f24831d.m23394a(i, str, "No user with this id found")) {
                        this.f24831d.m23406q();
                    } else {
                        this.f24831d.m23405p();
                    }
                }
                if (jSONObject.has("tags") != null) {
                    th = arrayList.iterator();
                    while (th.hasNext()) {
                        C5457b c5457b = (C5457b) th.next();
                        if (c5457b != null) {
                            c5457b.m23109a(new C5470o(i, str));
                        }
                    }
                }
            }

            /* renamed from: a */
            void mo4940a(String str) {
                synchronized (this.f24831d.f18509a) {
                    this.f24831d.f18513e.m23383a(jSONObject2, jSONObject);
                    this.f24831d.mo4957d(jSONObject);
                }
                JSONObject jSONObject = as.m23314d(null).f18503b;
                if (jSONObject.has("tags") && jSONObject != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        C5457b c5457b = (C5457b) it.next();
                        if (c5457b != null) {
                            c5457b.m23110a(jSONObject);
                        }
                    }
                }
            }
        });
    }

    /* renamed from: b */
    private void m23397b(final String str, final JSONObject jSONObject, final JSONObject jSONObject2) {
        String str2;
        if (str == null) {
            str2 = "players";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("players/");
            stringBuilder.append(str);
            stringBuilder.append("/on_session");
            str2 = stringBuilder.toString();
        }
        this.f18512d = true;
        mo4952b(jSONObject);
        ar.m23300d(str2, jSONObject, new C5480a(this) {
            /* renamed from: d */
            final /* synthetic */ bj f24835d;

            /* renamed from: a */
            void mo4936a(int i, String str, Throwable th) {
                synchronized (this.f24835d.f18509a) {
                    this.f24835d.f18512d = false;
                    C5464i c5464i = C5464i.WARN;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed last request. statusCode: ");
                    stringBuilder.append(i);
                    stringBuilder.append("\nresponse: ");
                    stringBuilder.append(str);
                    am.m23187b(c5464i, stringBuilder.toString());
                    if (this.f24835d.m23394a(i, str, "not a valid device_type") != 0) {
                        this.f24835d.m23406q();
                    } else {
                        this.f24835d.m23405p();
                    }
                }
            }

            /* renamed from: a */
            void mo4940a(String str) {
                synchronized (this.f24835d.f18509a) {
                    bj bjVar = this.f24835d;
                    this.f24835d.f18512d = false;
                    bjVar.f18511c = false;
                    this.f24835d.f18513e.m23383a(jSONObject2, jSONObject);
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("id") != null) {
                            str = jSONObject.optString("id");
                            this.f24835d.mo4948a(str);
                            C5464i c5464i = C5464i.INFO;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Device registered, UserId = ");
                            stringBuilder.append(str);
                            am.m23187b(c5464i, stringBuilder.toString());
                        } else {
                            C5464i c5464i2 = C5464i.INFO;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("session sent, UserId = ");
                            stringBuilder2.append(str);
                            am.m23187b(c5464i2, stringBuilder2.toString());
                        }
                        am.m23258v();
                        this.f24835d.mo4957d(jSONObject);
                    } catch (Throwable th) {
                        am.m23161a(C5464i.ERROR, "ERROR parsing on_session or create JSON Response.", th);
                    }
                }
            }
        });
    }

    /* renamed from: p */
    private void m23405p() {
        if (!m23409a(Integer.valueOf(0)).m23391b()) {
            JSONObject a = this.f18513e.m23380a(this.f18514f, false);
            if (a != null) {
                mo4955c(a);
            }
            if (m23428g().f18497a.optBoolean("logoutEmail", false)) {
                am.m23261y();
            }
        }
    }

    /* renamed from: a */
    private boolean m23394a(int i, String str, String str2) {
        boolean z = false;
        if (i == 400 && str != null) {
            try {
                i = new JSONObject(str);
                if (!(i.has("errors") == null || i.optString("errors").contains(str2) == 0)) {
                    z = true;
                }
                return z;
            } catch (int i2) {
                i2.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: a */
    protected C5497b m23409a(Integer num) {
        C5497b c5497b;
        synchronized (this.f18517i) {
            if (!this.f18510b.containsKey(num)) {
                this.f18510b.put(num, new C5497b(this, num.intValue()));
            }
            c5497b = (C5497b) this.f18510b.get(num);
        }
        return c5497b;
    }

    /* renamed from: k */
    protected be m23432k() {
        if (this.f18514f == null) {
            this.f18514f = this.f18513e.m23384b("TOSYNC_STATE");
        }
        mo4954c();
        return this.f18514f;
    }

    /* renamed from: e */
    void m23424e(JSONObject jSONObject) {
        JSONObject jSONObject2 = m23432k().f18498b;
        m23410a(jSONObject2, jSONObject, jSONObject2, null);
    }

    /* renamed from: l */
    void m23433l() {
        this.f18511c = true;
    }

    /* renamed from: a */
    void m23414a(JSONObject jSONObject, C5457b c5457b) {
        this.f18516h.add(c5457b);
        JSONObject jSONObject2 = m23432k().f18498b;
        m23410a(jSONObject2, jSONObject, jSONObject2, null);
    }

    /* renamed from: f */
    void m23427f(JSONObject jSONObject) {
        JSONObject jSONObject2 = m23432k().f18498b;
        m23410a(jSONObject2, jSONObject, jSONObject2, null);
    }

    /* renamed from: b */
    void m23416b(String str) {
        m23432k().f18498b.put("external_user_id", str);
    }

    /* renamed from: q */
    private void m23406q() {
        am.m23260x();
        m23434m();
        this.f18511c = true;
        mo4954c();
    }

    /* renamed from: m */
    void m23434m() {
        this.f18513e.f18498b = new JSONObject();
        this.f18513e.m23388d();
    }

    /* renamed from: a */
    void m23411a(C5525f c5525f) {
        m23432k().m23382a(c5525f);
    }
}
