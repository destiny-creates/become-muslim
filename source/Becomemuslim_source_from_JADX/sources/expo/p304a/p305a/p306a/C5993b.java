package expo.p304a.p305a.p306a;

import expo.p304a.p305a.C5994a;
import expo.p304a.p305a.C6000g;

/* compiled from: UIManager */
/* renamed from: expo.a.a.a.b */
public interface C5993b {

    /* compiled from: UIManager */
    /* renamed from: expo.a.a.a.b$a */
    public interface C5992a<T> {
        void reject(Throwable th);

        void resolve(T t);
    }

    <T> void addUIBlock(int i, C5992a<T> c5992a, Class<T> cls);

    void registerActivityEventListener(C5994a c5994a);

    void registerLifecycleEventListener(C6000g c6000g);

    void runOnClientCodeQueueThread(Runnable runnable);

    void runOnUiQueueThread(Runnable runnable);

    void unregisterLifecycleEventListener(C6000g c6000g);
}
