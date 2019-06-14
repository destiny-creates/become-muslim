package io.nlopez.smartlocation;

import android.content.Context;
import android.location.Location;
import io.nlopez.smartlocation.geocoding.C6553a;
import io.nlopez.smartlocation.geocoding.providers.AndroidGeocodingProvider;
import io.nlopez.smartlocation.p359a.C6527a;
import io.nlopez.smartlocation.p359a.p360a.C6526b;
import io.nlopez.smartlocation.p359a.p361b.C7631b;
import io.nlopez.smartlocation.p359a.p362c.C6531a;
import io.nlopez.smartlocation.p364b.C6538b;
import io.nlopez.smartlocation.p364b.C6540c;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SmartLocation */
/* renamed from: io.nlopez.smartlocation.f */
public class C6550f {
    /* renamed from: a */
    private Context f21065a;
    /* renamed from: b */
    private C6538b f21066b;
    /* renamed from: c */
    private boolean f21067c;

    /* compiled from: SmartLocation */
    /* renamed from: io.nlopez.smartlocation.f$a */
    public static class C6547a {
        /* renamed from: a */
        private final Context f21052a;
        /* renamed from: b */
        private boolean f21053b = null;
        /* renamed from: c */
        private boolean f21054c = true;

        public C6547a(Context context) {
            this.f21052a = context;
        }

        /* renamed from: a */
        public C6550f m26721a() {
            return new C6550f(this.f21052a, C6540c.m26716a(this.f21053b), this.f21054c);
        }
    }

    /* compiled from: SmartLocation */
    /* renamed from: io.nlopez.smartlocation.f$b */
    public static class C6548b {
        /* renamed from: a */
        private static final Map<Context, C6553a> f21055a = new WeakHashMap();
        /* renamed from: b */
        private final C6550f f21056b;
        /* renamed from: c */
        private C6553a f21057c;
        /* renamed from: d */
        private boolean f21058d = false;
        /* renamed from: e */
        private boolean f21059e = false;

        public C6548b(C6550f c6550f, C6553a c6553a) {
            this.f21056b = c6550f;
            if (!f21055a.containsKey(c6550f.f21065a)) {
                f21055a.put(c6550f.f21065a, c6553a);
            }
            this.f21057c = (C6553a) f21055a.get(c6550f.f21065a);
            if (c6550f.f21067c != null) {
                this.f21057c.mo5503a(c6550f.f21065a, c6550f.f21066b);
            }
        }

        /* renamed from: a */
        public void m26725a(Location location, C6545e c6545e) {
            m26722a(location);
            m26728a(c6545e);
        }

        /* renamed from: a */
        public void m26729a(String str, C6542b c6542b) {
            m26723a(str);
            m26726a(c6542b);
        }

        /* renamed from: a */
        public C6548b m26722a(Location location) {
            this.f21059e = true;
            this.f21057c.mo5504a(location, 1);
            return this;
        }

        /* renamed from: a */
        public C6548b m26723a(String str) {
            this.f21058d = true;
            this.f21057c.mo5506a(str, 1);
            return this;
        }

        /* renamed from: a */
        public void m26726a(C6542b c6542b) {
            m26727a(c6542b, null);
        }

        /* renamed from: a */
        public void m26728a(C6545e c6545e) {
            m26727a(null, c6545e);
        }

        /* renamed from: a */
        public void m26727a(C6542b c6542b, C6545e c6545e) {
            if (this.f21057c != null) {
                if (this.f21058d && c6542b == null) {
                    this.f21056b.f21066b.mo5500c("Some places were added for geocoding but the listener was not specified!", new Object[0]);
                }
                if (this.f21059e && c6545e == null) {
                    this.f21056b.f21066b.mo5500c("Some places were added for reverse geocoding but the listener was not specified!", new Object[0]);
                }
                this.f21057c.mo5505a(c6542b, c6545e);
                return;
            }
            throw new RuntimeException("A provider must be initialized");
        }

        /* renamed from: a */
        public void m26724a() {
            this.f21057c.mo5502a();
        }
    }

    /* compiled from: SmartLocation */
    /* renamed from: io.nlopez.smartlocation.f$c */
    public static class C6549c {
        /* renamed from: a */
        private static final Map<Context, C6527a> f21060a = new WeakHashMap();
        /* renamed from: b */
        private final C6550f f21061b;
        /* renamed from: c */
        private C6526b f21062c = C6526b.f21034b;
        /* renamed from: d */
        private C6527a f21063d;
        /* renamed from: e */
        private boolean f21064e = false;

        public C6549c(C6550f c6550f, C6527a c6527a) {
            this.f21061b = c6550f;
            if (!f21060a.containsKey(c6550f.f21065a)) {
                f21060a.put(c6550f.f21065a, c6527a);
            }
            this.f21063d = (C6527a) f21060a.get(c6550f.f21065a);
            if (c6550f.f21067c != null) {
                this.f21063d.mo5492a(c6550f.f21065a, c6550f.f21066b);
            }
        }

        /* renamed from: a */
        public C6549c m26731a(C6526b c6526b) {
            this.f21062c = c6526b;
            return this;
        }

        /* renamed from: a */
        public C6549c m26730a() {
            this.f21064e = true;
            return this;
        }

        /* renamed from: b */
        public C6531a m26733b() {
            return C6531a.m26696a(this.f21061b.f21065a);
        }

        /* renamed from: c */
        public Location m26734c() {
            return this.f21063d.mo5496b();
        }

        /* renamed from: a */
        public void m26732a(C6544d c6544d) {
            if (this.f21063d != null) {
                this.f21063d.mo5495a(c6544d, this.f21062c, this.f21064e);
                return;
            }
            throw new RuntimeException("A provider must be initialized");
        }

        /* renamed from: d */
        public void m26735d() {
            this.f21063d.mo5490a();
        }
    }

    private C6550f(Context context, C6538b c6538b, boolean z) {
        this.f21065a = context;
        this.f21066b = c6538b;
        this.f21067c = z;
    }

    /* renamed from: a */
    public static C6550f m26737a(Context context) {
        return new C6547a(context).m26721a();
    }

    /* renamed from: a */
    public C6549c m26741a() {
        return m26742a(new C7631b(this.f21065a));
    }

    /* renamed from: a */
    public C6549c m26742a(C6527a c6527a) {
        return new C6549c(this, c6527a);
    }

    /* renamed from: b */
    public C6548b m26743b() {
        return m26740a(new AndroidGeocodingProvider());
    }

    /* renamed from: a */
    public C6548b m26740a(C6553a c6553a) {
        return new C6548b(this, c6553a);
    }
}
