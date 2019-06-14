package host.exp.exponent.p339f.p340a.p342b;

import android.content.Context;
import android.hardware.SensorEvent;
import host.exp.exponent.p339f.C6330b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SubscribableSensorKernelService */
/* renamed from: host.exp.exponent.f.a.b.k */
public abstract class C8176k extends C7546b {
    /* renamed from: a */
    protected static int f30364a = 100;
    /* renamed from: b */
    private Map<C6330b, Integer> f30365b = new HashMap();
    /* renamed from: c */
    private Map<C6326j, Long> f30366c = new WeakHashMap();
    /* renamed from: d */
    private Map<C6330b, List<WeakReference<C6326j>>> f30367d = new HashMap();

    C8176k(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo5404a(C6330b c6330b) {
        m39709f();
    }

    /* renamed from: b */
    public void mo5405b(C6330b c6330b) {
        m39709f();
    }

    /* renamed from: a */
    public void m39711a(SensorEvent sensorEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        List<WeakReference> list = (List) this.f30367d.get(m26013b());
        if (list != null) {
            for (WeakReference weakReference : list) {
                C6326j c6326j = (C6326j) weakReference.get();
                if (c6326j != null && c6326j.m26018b()) {
                    long j = 0;
                    if (this.f30366c.containsKey(c6326j)) {
                        j = ((Long) this.f30366c.get(c6326j)).longValue();
                    }
                    long j2 = (long) f30364a;
                    if (c6326j.m26020d() != null) {
                        j2 = c6326j.m26020d().longValue();
                    }
                    if (currentTimeMillis - j > j2) {
                        c6326j.m26021e().onSensorDataChanged(sensorEvent);
                        this.f30366c.put(c6326j, Long.valueOf(currentTimeMillis));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public C6326j m39710a(C6330b c6330b, C6325i c6325i) {
        C6326j c6326j = new C6326j(c6330b, this, c6325i);
        if (this.f30367d.containsKey(c6330b) == null) {
            this.f30367d.put(c6330b, new ArrayList());
        }
        ((List) this.f30367d.get(c6330b)).add(new WeakReference(c6326j));
        return c6326j;
    }

    /* renamed from: a */
    public void m39712a(C6326j c6326j) {
        this.f30366c.remove(c6326j);
        C6330b c = c6326j.m26019c();
        if (this.f30367d.containsKey(c)) {
            List<WeakReference> list = (List) this.f30367d.get(c);
            List arrayList = new ArrayList();
            for (WeakReference weakReference : list) {
                C6326j c6326j2 = (C6326j) weakReference.get();
                if (!(c6326j2 == null || c6326j2 == c6326j)) {
                    arrayList.add(weakReference);
                }
            }
            if (arrayList.size() > null) {
                this.f30367d.put(c, arrayList);
            } else {
                this.f30367d.remove(c);
            }
        }
    }

    /* renamed from: b */
    void m39714b(C6326j c6326j) {
        C6330b c = c6326j.m26019c();
        int c2 = m39707c(c);
        if (c6326j.m26018b() != null) {
            this.f30365b.put(c, Integer.valueOf(c2 + 1));
        } else {
            this.f30365b.put(c, Integer.valueOf(c2 - 1));
        }
        if (m39707c(c) == null) {
            this.f30365b.remove(c);
        }
        m39709f();
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == mo6767c()) {
            m39711a(sensorEvent);
        }
    }

    /* renamed from: c */
    private int m39707c(C6330b c6330b) {
        return this.f30365b.containsKey(c6330b) ? ((Integer) this.f30365b.get(c6330b)).intValue() : null;
    }

    /* renamed from: d */
    private void m39708d(C6330b c6330b) {
        List<WeakReference> list = (List) this.f30367d.get(c6330b);
        List arrayList = new ArrayList();
        if (list != null) {
            for (WeakReference weakReference : list) {
                if (weakReference.get() != null) {
                    arrayList.add(weakReference);
                }
            }
        }
        if (arrayList.size() > 0) {
            this.f30367d.put(c6330b, arrayList);
        } else {
            this.f30367d.remove(c6330b);
        }
    }

    /* renamed from: f */
    private void m39709f() {
        C6330b b = m26013b();
        m39708d(b);
        if (m39707c(b) > 0) {
            super.m34173d();
        } else {
            super.m34174e();
        }
    }
}
