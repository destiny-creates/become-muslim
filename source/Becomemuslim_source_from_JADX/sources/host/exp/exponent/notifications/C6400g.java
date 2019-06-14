package host.exp.exponent.notifications;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import android.support.v4.app.ac.C0278a.C0277a;
import android.support.v4.app.ac.C0279d;
import android.support.v4.app.ah.C0286a;
import com.facebook.react.uimanager.ViewProps;
import com.raizlabs.android.dbflow.p276d.p277a.C8023b;
import com.raizlabs.android.dbflow.p276d.p278b.C7132g;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: NotificationActionCenter */
/* renamed from: host.exp.exponent.notifications.g */
public class C6400g {
    /* renamed from: a */
    public static synchronized void m26286a(String str, List<Map<String, Object>> list) {
        synchronized (C6400g.class) {
            C6400g.m26282a();
            for (int i = 0; i < list.size(); i++) {
                Map map = (Map) list.get(i);
                map.put("categoryId", str);
                new C8178a(map, i).mo5063a();
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m26284a(String str) {
        synchronized (C6400g.class) {
            for (C8178a b : new C7132g().m33176a(C8178a.class).m38893a(C8023b.m38874a("categoryId").m38875a((Object) str)).mo6280b()) {
                b.m33195b();
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m26285a(String str, C0279d c0279d, Context context, C6399f c6399f) {
        synchronized (C6400g.class) {
            C6400g.m26282a();
            c0279d.d(2);
            for (C8178a a : new C7132g().m33176a(C8178a.class).m38893a(C8023b.m38874a("categoryId").m38875a((Object) str)).m38901a(true, ViewProps.POSITION).mo6280b()) {
                C6400g.m26283a(c0279d, a, c6399f, context);
            }
        }
    }

    /* renamed from: a */
    private static void m26283a(C0279d c0279d, C8178a c8178a, C6399f c6399f, Context context) {
        c6399f = c6399f.mo5430a();
        c6399f.putExtra("actionType", c8178a.m39727d());
        context = new C0277a(0, c8178a.m39729e(), PendingIntent.getActivity(context, UUID.randomUUID().hashCode(), c6399f, 134217728));
        if (c8178a.m39731f() != null) {
            context.a(new C0286a("notification_remote_input").a(c8178a.m39737l()).a());
        }
        c0279d.a(context.a());
    }

    /* renamed from: a */
    private static void m26282a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("Do not use NotificationActionCenter class on the main thread!");
        }
    }
}
