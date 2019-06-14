package android.arch.p010a.p012b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap */
/* renamed from: android.arch.a.b.b */
public class C0064b<K, V> implements Iterable<Entry<K, V>> {
    /* renamed from: a */
    private C0062c<K, V> f173a;
    /* renamed from: b */
    private C0062c<K, V> f174b;
    /* renamed from: c */
    private WeakHashMap<C0063f<K, V>, Boolean> f175c = new WeakHashMap();
    /* renamed from: d */
    private int f176d = 0;

    /* compiled from: SafeIterableMap */
    /* renamed from: android.arch.a.b.b$c */
    static class C0062c<K, V> implements Entry<K, V> {
        /* renamed from: a */
        final K f169a;
        /* renamed from: b */
        final V f170b;
        /* renamed from: c */
        C0062c<K, V> f171c;
        /* renamed from: d */
        C0062c<K, V> f172d;

        C0062c(K k, V v) {
            this.f169a = k;
            this.f170b = v;
        }

        public K getKey() {
            return this.f169a;
        }

        public V getValue() {
            return this.f170b;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f169a);
            stringBuilder.append("=");
            stringBuilder.append(this.f170b);
            return stringBuilder.toString();
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0062c)) {
                return false;
            }
            C0062c c0062c = (C0062c) obj;
            if (!this.f169a.equals(c0062c.f169a) || this.f170b.equals(c0062c.f170b) == null) {
                z = false;
            }
            return z;
        }
    }

    /* compiled from: SafeIterableMap */
    /* renamed from: android.arch.a.b.b$f */
    interface C0063f<K, V> {
        void a_(C0062c<K, V> c0062c);
    }

    /* compiled from: SafeIterableMap */
    /* renamed from: android.arch.a.b.b$d */
    private class C3105d implements C0063f<K, V>, Iterator<Entry<K, V>> {
        /* renamed from: a */
        final /* synthetic */ C0064b f7927a;
        /* renamed from: b */
        private C0062c<K, V> f7928b;
        /* renamed from: c */
        private boolean f7929c;

        private C3105d(C0064b c0064b) {
            this.f7927a = c0064b;
            this.f7929c = true;
        }

        public /* synthetic */ Object next() {
            return m9108a();
        }

        public void a_(C0062c<K, V> c0062c) {
            if (c0062c == this.f7928b) {
                this.f7928b = this.f7928b.f172d;
                this.f7929c = this.f7928b == null ? true : null;
            }
        }

        public boolean hasNext() {
            boolean z = false;
            if (this.f7929c) {
                if (this.f7927a.f173a != null) {
                    z = true;
                }
                return z;
            }
            if (!(this.f7928b == null || this.f7928b.f171c == null)) {
                z = true;
            }
            return z;
        }

        /* renamed from: a */
        public Entry<K, V> m9108a() {
            if (this.f7929c) {
                this.f7929c = false;
                this.f7928b = this.f7927a.f173a;
            } else {
                this.f7928b = this.f7928b != null ? this.f7928b.f171c : null;
            }
            return this.f7928b;
        }
    }

    /* compiled from: SafeIterableMap */
    /* renamed from: android.arch.a.b.b$e */
    private static abstract class C3106e<K, V> implements C0063f<K, V>, Iterator<Entry<K, V>> {
        /* renamed from: a */
        C0062c<K, V> f7930a;
        /* renamed from: b */
        C0062c<K, V> f7931b;

        /* renamed from: a */
        abstract C0062c<K, V> mo2618a(C0062c<K, V> c0062c);

        /* renamed from: b */
        abstract C0062c<K, V> mo2619b(C0062c<K, V> c0062c);

        public /* synthetic */ Object next() {
            return m9111a();
        }

        C3106e(C0062c<K, V> c0062c, C0062c<K, V> c0062c2) {
            this.f7930a = c0062c2;
            this.f7931b = c0062c;
        }

        public boolean hasNext() {
            return this.f7931b != null;
        }

        public void a_(C0062c<K, V> c0062c) {
            if (this.f7930a == c0062c && c0062c == this.f7931b) {
                this.f7931b = null;
                this.f7930a = null;
            }
            if (this.f7930a == c0062c) {
                this.f7930a = mo2619b(this.f7930a);
            }
            if (this.f7931b == c0062c) {
                this.f7931b = m9109b();
            }
        }

        /* renamed from: b */
        private C0062c<K, V> m9109b() {
            if (this.f7931b != this.f7930a) {
                if (this.f7930a != null) {
                    return mo2618a(this.f7931b);
                }
            }
            return null;
        }

        /* renamed from: a */
        public Entry<K, V> m9111a() {
            Entry entry = this.f7931b;
            this.f7931b = m9109b();
            return entry;
        }
    }

    /* compiled from: SafeIterableMap */
    /* renamed from: android.arch.a.b.b$a */
    static class C4437a<K, V> extends C3106e<K, V> {
        C4437a(C0062c<K, V> c0062c, C0062c<K, V> c0062c2) {
            super(c0062c, c0062c2);
        }

        /* renamed from: a */
        C0062c<K, V> mo2618a(C0062c<K, V> c0062c) {
            return c0062c.f171c;
        }

        /* renamed from: b */
        C0062c<K, V> mo2619b(C0062c<K, V> c0062c) {
            return c0062c.f172d;
        }
    }

    /* compiled from: SafeIterableMap */
    /* renamed from: android.arch.a.b.b$b */
    private static class C4438b<K, V> extends C3106e<K, V> {
        C4438b(C0062c<K, V> c0062c, C0062c<K, V> c0062c2) {
            super(c0062c, c0062c2);
        }

        /* renamed from: a */
        C0062c<K, V> mo2618a(C0062c<K, V> c0062c) {
            return c0062c.f172d;
        }

        /* renamed from: b */
        C0062c<K, V> mo2619b(C0062c<K, V> c0062c) {
            return c0062c.f171c;
        }
    }

    /* renamed from: a */
    protected C0062c<K, V> mo18a(K k) {
        C0062c<K, V> c0062c = this.f173a;
        while (c0062c != null) {
            if (c0062c.f169a.equals(k)) {
                break;
            }
            c0062c = c0062c.f171c;
        }
        return c0062c;
    }

    /* renamed from: a */
    public V mo19a(K k, V v) {
        C0062c a = mo18a((Object) k);
        if (a != null) {
            return a.f170b;
        }
        m141b(k, v);
        return null;
    }

    /* renamed from: b */
    protected C0062c<K, V> m141b(K k, V v) {
        C0062c<K, V> c0062c = new C0062c(k, v);
        this.f176d++;
        if (this.f174b == null) {
            this.f173a = c0062c;
            this.f174b = this.f173a;
            return c0062c;
        }
        this.f174b.f171c = c0062c;
        c0062c.f172d = this.f174b;
        this.f174b = c0062c;
        return c0062c;
    }

    /* renamed from: b */
    public V mo20b(K k) {
        k = mo18a((Object) k);
        if (k == null) {
            return null;
        }
        this.f176d--;
        if (!this.f175c.isEmpty()) {
            for (C0063f a_ : this.f175c.keySet()) {
                a_.a_(k);
            }
        }
        if (k.f172d != null) {
            k.f172d.f171c = k.f171c;
        } else {
            this.f173a = k.f171c;
        }
        if (k.f171c != null) {
            k.f171c.f172d = k.f172d;
        } else {
            this.f174b = k.f172d;
        }
        k.f171c = null;
        k.f172d = null;
        return k.f170b;
    }

    /* renamed from: a */
    public int m138a() {
        return this.f176d;
    }

    public Iterator<Entry<K, V>> iterator() {
        Iterator c4437a = new C4437a(this.f173a, this.f174b);
        this.f175c.put(c4437a, Boolean.valueOf(false));
        return c4437a;
    }

    /* renamed from: b */
    public Iterator<Entry<K, V>> m143b() {
        Iterator c4438b = new C4438b(this.f174b, this.f173a);
        this.f175c.put(c4438b, Boolean.valueOf(false));
        return c4438b;
    }

    /* renamed from: c */
    public C3105d m144c() {
        C3105d c3105d = new C3105d();
        this.f175c.put(c3105d, Boolean.valueOf(false));
        return c3105d;
    }

    /* renamed from: d */
    public Entry<K, V> m145d() {
        return this.f173a;
    }

    /* renamed from: e */
    public Entry<K, V> m146e() {
        return this.f174b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0064b)) {
            return false;
        }
        C0064b c0064b = (C0064b) obj;
        if (m138a() != c0064b.m138a()) {
            return false;
        }
        Iterator it = iterator();
        obj = c0064b.iterator();
        while (it.hasNext() && obj.hasNext()) {
            Entry entry = (Entry) it.next();
            Object next = obj.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || obj.hasNext() != null) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            stringBuilder.append(((Entry) it.next()).toString());
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
