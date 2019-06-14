package android.support.v4.util;

public final class Pools {

    /* renamed from: android.support.v4.util.Pools$a */
    public interface C0447a<T> {
        T acquire();

        boolean release(T t);
    }

    public static class SimplePool<T> implements C0447a<T> {
        /* renamed from: a */
        private final Object[] f8263a;
        /* renamed from: b */
        private int f8264b;

        public SimplePool(int i) {
            if (i > 0) {
                this.f8263a = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        public T acquire() {
            if (this.f8264b <= 0) {
                return null;
            }
            int i = this.f8264b - 1;
            T t = this.f8263a[i];
            this.f8263a[i] = null;
            this.f8264b--;
            return t;
        }

        public boolean release(T t) {
            if (m9757a(t)) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.f8264b >= this.f8263a.length) {
                return null;
            } else {
                this.f8263a[this.f8264b] = t;
                this.f8264b += 1;
                return true;
            }
        }

        /* renamed from: a */
        private boolean m9757a(T t) {
            for (int i = 0; i < this.f8264b; i++) {
                if (this.f8263a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: android.support.v4.util.Pools$b */
    public static class C4463b<T> extends SimplePool<T> {
        /* renamed from: a */
        private final Object f11914a = new Object();

        public C4463b(int i) {
            super(i);
        }

        public T acquire() {
            T acquire;
            synchronized (this.f11914a) {
                acquire = super.acquire();
            }
            return acquire;
        }

        public boolean release(T t) {
            synchronized (this.f11914a) {
                t = super.release(t);
            }
            return t;
        }
    }
}
