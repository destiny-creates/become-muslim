package com.p079e.p080a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.facebook.internal.ServerProtocol;
import com.p079e.p080a.C3506r.C1227a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: Dispatcher */
/* renamed from: com.e.a.i */
class C1219i {
    /* renamed from: a */
    final C1217b f3428a = new C1217b();
    /* renamed from: b */
    final Context f3429b;
    /* renamed from: c */
    final ExecutorService f3430c;
    /* renamed from: d */
    final C1222j f3431d;
    /* renamed from: e */
    final Map<String, C1210c> f3432e;
    /* renamed from: f */
    final Map<Object, C1194a> f3433f;
    /* renamed from: g */
    final Map<Object, C1194a> f3434g;
    /* renamed from: h */
    final Set<Object> f3435h;
    /* renamed from: i */
    final Handler f3436i;
    /* renamed from: j */
    final Handler f3437j;
    /* renamed from: k */
    final C1211d f3438k;
    /* renamed from: l */
    final aa f3439l;
    /* renamed from: m */
    final List<C1210c> f3440m;
    /* renamed from: n */
    final C1218c f3441n;
    /* renamed from: o */
    final boolean f3442o;
    /* renamed from: p */
    boolean f3443p;

    /* compiled from: Dispatcher */
    /* renamed from: com.e.a.i$a */
    private static class C1216a extends Handler {
        /* renamed from: a */
        private final C1219i f3426a;

        public C1216a(Looper looper, C1219i c1219i) {
            super(looper);
            this.f3426a = c1219i;
        }

        public void handleMessage(final Message message) {
            boolean z = false;
            switch (message.what) {
                case 1:
                    this.f3426a.m4282c((C1194a) message.obj);
                    return;
                case 2:
                    this.f3426a.m4284d((C1194a) message.obj);
                    return;
                case 4:
                    this.f3426a.m4286e((C1210c) message.obj);
                    return;
                case 5:
                    this.f3426a.m4285d((C1210c) message.obj);
                    return;
                case 6:
                    this.f3426a.m4274a((C1210c) message.obj, false);
                    return;
                case 7:
                    this.f3426a.m4269a();
                    return;
                case 9:
                    this.f3426a.m4277b((NetworkInfo) message.obj);
                    return;
                case 10:
                    C1219i c1219i = this.f3426a;
                    if (message.arg1 == 1) {
                        z = true;
                    }
                    c1219i.m4281b(z);
                    return;
                case 11:
                    this.f3426a.m4275a(message.obj);
                    return;
                case 12:
                    this.f3426a.m4280b(message.obj);
                    return;
                default:
                    C1236t.f3495a.post(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ C1216a f3425b;

                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unknown handler message received: ");
                            stringBuilder.append(message.what);
                            throw new AssertionError(stringBuilder.toString());
                        }
                    });
                    return;
            }
        }
    }

    /* compiled from: Dispatcher */
    /* renamed from: com.e.a.i$b */
    static class C1217b extends HandlerThread {
        C1217b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* compiled from: Dispatcher */
    /* renamed from: com.e.a.i$c */
    static class C1218c extends BroadcastReceiver {
        /* renamed from: a */
        private final C1219i f3427a;

        C1218c(C1219i c1219i) {
            this.f3427a = c1219i;
        }

        /* renamed from: a */
        void m4263a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f3427a.f3442o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f3427a.f3429b.registerReceiver(this, intentFilter);
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra(ServerProtocol.DIALOG_PARAM_STATE) != null) {
                        this.f3427a.m4276a(intent.getBooleanExtra(ServerProtocol.DIALOG_PARAM_STATE, false));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) != null) {
                    this.f3427a.m4270a(((ConnectivityManager) ae.m4211a(context, "connectivity")).getActiveNetworkInfo());
                }
            }
        }
    }

    C1219i(Context context, ExecutorService executorService, Handler handler, C1222j c1222j, C1211d c1211d, aa aaVar) {
        this.f3428a.start();
        ae.m4218a(this.f3428a.getLooper());
        this.f3429b = context;
        this.f3430c = executorService;
        this.f3432e = new LinkedHashMap();
        this.f3433f = new WeakHashMap();
        this.f3434g = new WeakHashMap();
        this.f3435h = new HashSet();
        this.f3436i = new C1216a(this.f3428a.getLooper(), this);
        this.f3431d = c1222j;
        this.f3437j = handler;
        this.f3438k = c1211d;
        this.f3439l = aaVar;
        this.f3440m = new ArrayList(4);
        this.f3443p = ae.m4229d(this.f3429b);
        this.f3442o = ae.m4225b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.f3441n = new C1218c(this);
        this.f3441n.m4263a();
    }

    /* renamed from: a */
    void m4271a(C1194a c1194a) {
        this.f3436i.sendMessage(this.f3436i.obtainMessage(1, c1194a));
    }

    /* renamed from: b */
    void m4278b(C1194a c1194a) {
        this.f3436i.sendMessage(this.f3436i.obtainMessage(2, c1194a));
    }

    /* renamed from: a */
    void m4273a(C1210c c1210c) {
        this.f3436i.sendMessage(this.f3436i.obtainMessage(4, c1210c));
    }

    /* renamed from: b */
    void m4279b(C1210c c1210c) {
        this.f3436i.sendMessageDelayed(this.f3436i.obtainMessage(5, c1210c), 500);
    }

    /* renamed from: c */
    void m4283c(C1210c c1210c) {
        this.f3436i.sendMessage(this.f3436i.obtainMessage(6, c1210c));
    }

    /* renamed from: a */
    void m4270a(NetworkInfo networkInfo) {
        this.f3436i.sendMessage(this.f3436i.obtainMessage(9, networkInfo));
    }

    /* renamed from: a */
    void m4276a(boolean z) {
        this.f3436i.sendMessage(this.f3436i.obtainMessage(10, z, 0));
    }

    /* renamed from: c */
    void m4282c(C1194a c1194a) {
        m4272a(c1194a, true);
    }

    /* renamed from: a */
    void m4272a(C1194a c1194a, boolean z) {
        if (this.f3435h.contains(c1194a.m4184l())) {
            this.f3434g.put(c1194a.m4176d(), c1194a);
            if (c1194a.m4182j().f3506l) {
                String a = c1194a.f3349b.m4329a();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("because tag '");
                stringBuilder.append(c1194a.m4184l());
                stringBuilder.append("' is paused");
                ae.m4221a("Dispatcher", "paused", a, stringBuilder.toString());
            }
            return;
        }
        C1210c c1210c = (C1210c) this.f3432e.get(c1194a.m4177e());
        if (c1210c != null) {
            c1210c.m4239a(c1194a);
        } else if (this.f3430c.isShutdown()) {
            if (c1194a.m4182j().f3506l) {
                ae.m4221a("Dispatcher", "ignored", c1194a.f3349b.m4329a(), "because shut down");
            }
        } else {
            Object a2 = C1210c.m4234a(c1194a.m4182j(), this, this.f3438k, this.f3439l, c1194a);
            a2.f3414n = this.f3430c.submit(a2);
            this.f3432e.put(c1194a.m4177e(), a2);
            if (z) {
                this.f3433f.remove(c1194a.m4176d());
            }
            if (c1194a.m4182j().f3506l) {
                ae.m4220a("Dispatcher", "enqueued", c1194a.f3349b.m4329a());
            }
        }
    }

    /* renamed from: d */
    void m4284d(C1194a c1194a) {
        String e = c1194a.m4177e();
        C1210c c1210c = (C1210c) this.f3432e.get(e);
        if (c1210c != null) {
            c1210c.m4241b(c1194a);
            if (c1210c.m4242b()) {
                this.f3432e.remove(e);
                if (c1194a.m4182j().f3506l) {
                    ae.m4220a("Dispatcher", "canceled", c1194a.m4175c().m4329a());
                }
            }
        }
        if (this.f3435h.contains(c1194a.m4184l())) {
            this.f3434g.remove(c1194a.m4176d());
            if (c1194a.m4182j().f3506l) {
                ae.m4221a("Dispatcher", "canceled", c1194a.m4175c().m4329a(), "because paused request got canceled");
            }
        }
        c1194a = (C1194a) this.f3433f.remove(c1194a.m4176d());
        if (c1194a != null && c1194a.m4182j().f3506l) {
            ae.m4221a("Dispatcher", "canceled", c1194a.m4175c().m4329a(), "from replaying");
        }
    }

    /* renamed from: a */
    void m4275a(Object obj) {
        if (this.f3435h.add(obj)) {
            Iterator it = this.f3432e.values().iterator();
            while (it.hasNext()) {
                C1210c c1210c = (C1210c) it.next();
                boolean z = c1210c.m4250j().f3506l;
                C1194a i = c1210c.m4249i();
                List k = c1210c.m4251k();
                Object obj2 = (k == null || k.isEmpty()) ? null : 1;
                if (i != null || obj2 != null) {
                    if (i != null && i.m4184l().equals(obj)) {
                        c1210c.m4241b(i);
                        this.f3434g.put(i.m4176d(), i);
                        if (z) {
                            String a = i.f3349b.m4329a();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("because tag '");
                            stringBuilder.append(obj);
                            stringBuilder.append("' was paused");
                            ae.m4221a("Dispatcher", "paused", a, stringBuilder.toString());
                        }
                    }
                    if (obj2 != null) {
                        for (int size = k.size() - 1; size >= 0; size--) {
                            C1194a c1194a = (C1194a) k.get(size);
                            if (c1194a.m4184l().equals(obj)) {
                                c1210c.m4241b(c1194a);
                                this.f3434g.put(c1194a.m4176d(), c1194a);
                                if (z) {
                                    String a2 = c1194a.f3349b.m4329a();
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append("because tag '");
                                    stringBuilder2.append(obj);
                                    stringBuilder2.append("' was paused");
                                    ae.m4221a("Dispatcher", "paused", a2, stringBuilder2.toString());
                                }
                            }
                        }
                    }
                    if (c1210c.m4242b()) {
                        it.remove();
                        if (z) {
                            ae.m4221a("Dispatcher", "canceled", ae.m4213a(c1210c), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    void m4280b(Object obj) {
        if (this.f3435h.remove(obj)) {
            Object obj2 = null;
            Iterator it = this.f3434g.values().iterator();
            while (it.hasNext()) {
                C1194a c1194a = (C1194a) it.next();
                if (c1194a.m4184l().equals(obj)) {
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                    }
                    obj2.add(c1194a);
                    it.remove();
                }
            }
            if (obj2 != null) {
                this.f3437j.sendMessage(this.f3437j.obtainMessage(13, obj2));
            }
        }
    }

    /* renamed from: d */
    void m4285d(C1210c c1210c) {
        if (!c1210c.m4243c()) {
            boolean z = false;
            if (this.f3430c.isShutdown()) {
                m4274a(c1210c, false);
                return;
            }
            NetworkInfo networkInfo = null;
            if (this.f3442o) {
                networkInfo = ((ConnectivityManager) ae.m4211a(this.f3429b, "connectivity")).getActiveNetworkInfo();
            }
            Object obj = (networkInfo == null || !networkInfo.isConnected()) ? null : 1;
            boolean a = c1210c.m4240a(this.f3443p, networkInfo);
            boolean d = c1210c.m4244d();
            if (a) {
                if (this.f3442o) {
                    if (obj == null) {
                        m4274a(c1210c, d);
                        if (d) {
                            m4267f(c1210c);
                        }
                        return;
                    }
                }
                if (c1210c.m4250j().f3506l) {
                    ae.m4220a("Dispatcher", "retrying", ae.m4213a(c1210c));
                }
                if (c1210c.m4252l() instanceof C1227a) {
                    c1210c.f3409i |= C1226q.NO_CACHE.f3470d;
                }
                c1210c.f3414n = this.f3430c.submit(c1210c);
                return;
            }
            if (this.f3442o && d) {
                z = true;
            }
            m4274a(c1210c, z);
            if (z) {
                m4267f(c1210c);
            }
        }
    }

    /* renamed from: e */
    void m4286e(C1210c c1210c) {
        if (C1225p.m4296b(c1210c.m4247g())) {
            this.f3438k.mo824a(c1210c.m4246f(), c1210c.m4245e());
        }
        this.f3432e.remove(c1210c.m4246f());
        m4268g(c1210c);
        if (c1210c.m4250j().f3506l) {
            ae.m4221a("Dispatcher", "batched", ae.m4213a(c1210c), "for completion");
        }
    }

    /* renamed from: a */
    void m4269a() {
        List arrayList = new ArrayList(this.f3440m);
        this.f3440m.clear();
        this.f3437j.sendMessage(this.f3437j.obtainMessage(8, arrayList));
        m4264a(arrayList);
    }

    /* renamed from: a */
    void m4274a(C1210c c1210c, boolean z) {
        if (c1210c.m4250j().f3506l) {
            String str = "Dispatcher";
            String str2 = "batched";
            String a = ae.m4213a(c1210c);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("for error");
            stringBuilder.append(z ? " (will replay)" : "");
            ae.m4221a(str, str2, a, stringBuilder.toString());
        }
        this.f3432e.remove(c1210c.m4246f());
        m4268g(c1210c);
    }

    /* renamed from: b */
    void m4281b(boolean z) {
        this.f3443p = z;
    }

    /* renamed from: b */
    void m4277b(NetworkInfo networkInfo) {
        if (this.f3430c instanceof C1239v) {
            ((C1239v) this.f3430c).m4324a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected() != null) {
            m4265b();
        }
    }

    /* renamed from: b */
    private void m4265b() {
        if (!this.f3433f.isEmpty()) {
            Iterator it = this.f3433f.values().iterator();
            while (it.hasNext()) {
                C1194a c1194a = (C1194a) it.next();
                it.remove();
                if (c1194a.m4182j().f3506l) {
                    ae.m4220a("Dispatcher", "replaying", c1194a.m4175c().m4329a());
                }
                m4272a(c1194a, false);
            }
        }
    }

    /* renamed from: f */
    private void m4267f(C1210c c1210c) {
        C1194a i = c1210c.m4249i();
        if (i != null) {
            m4266e(i);
        }
        c1210c = c1210c.m4251k();
        if (c1210c != null) {
            int size = c1210c.size();
            for (int i2 = 0; i2 < size; i2++) {
                m4266e((C1194a) c1210c.get(i2));
            }
        }
    }

    /* renamed from: e */
    private void m4266e(C1194a c1194a) {
        Object d = c1194a.m4176d();
        if (d != null) {
            c1194a.f3358k = true;
            this.f3433f.put(d, c1194a);
        }
    }

    /* renamed from: g */
    private void m4268g(C1210c c1210c) {
        if (!c1210c.m4243c()) {
            this.f3440m.add(c1210c);
            if (this.f3436i.hasMessages(7) == null) {
                this.f3436i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    /* renamed from: a */
    private void m4264a(List<C1210c> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                if (((C1210c) list.get(0)).m4250j().f3506l) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (C1210c c1210c : list) {
                        if (stringBuilder.length() > 0) {
                            stringBuilder.append(", ");
                        }
                        stringBuilder.append(ae.m4213a(c1210c));
                    }
                    ae.m4220a("Dispatcher", "delivered", stringBuilder.toString());
                }
            }
        }
    }
}
