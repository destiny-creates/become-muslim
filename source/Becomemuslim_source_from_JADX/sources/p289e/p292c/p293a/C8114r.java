package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.concurrent.atomic.AtomicLong;
import p289e.C5974e.C7335a;
import p289e.C5984g;
import p289e.C7367k;

/* compiled from: OnSubscribeFromArray */
/* renamed from: e.c.a.r */
public final class C8114r<T> implements C7335a<T> {
    /* renamed from: a */
    final T[] f30221a;

    /* compiled from: OnSubscribeFromArray */
    /* renamed from: e.c.a.r$a */
    static final class C7273a<T> extends AtomicLong implements C5984g {
        private static final long serialVersionUID = 3534218984725836979L;
        /* renamed from: a */
        final C7367k<? super T> f25597a;
        /* renamed from: b */
        final T[] f25598b;
        /* renamed from: c */
        int f25599c;

        public C7273a(C7367k<? super T> c7367k, T[] tArr) {
            this.f25597a = c7367k;
            this.f25598b = tArr;
        }

        /* renamed from: a */
        public void mo5119a(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("n >= 0 required but it was ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (j == Clock.MAX_TIME) {
                if (C5923a.m24836a((AtomicLong) this, j) == 0) {
                    m33578a();
                }
            } else if (i != 0 && C5923a.m24836a((AtomicLong) this, j) == 0) {
                m33580b(j);
            }
        }

        /* renamed from: a */
        void m33578a() {
            C7367k c7367k = this.f25597a;
            Object[] objArr = this.f25598b;
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Object obj = objArr[i];
                if (!c7367k.mo5121b()) {
                    c7367k.mo5000a(obj);
                    i++;
                } else {
                    return;
                }
            }
            if (!c7367k.mo5121b()) {
                c7367k.L_();
            }
        }

        /* renamed from: b */
        void m33580b(long j) {
            C7367k c7367k = this.f25597a;
            Object[] objArr = this.f25598b;
            int length = objArr.length;
            int i = this.f25599c;
            loop0:
            do {
                long j2 = 0;
                while (true) {
                    if (j == 0 || i == length) {
                        j = get() + j2;
                        if (j == 0) {
                            this.f25599c = i;
                            j = addAndGet(j2);
                        }
                    } else if (!c7367k.mo5121b()) {
                        c7367k.mo5000a(objArr[i]);
                        i++;
                        if (i == length) {
                            break loop0;
                        }
                        j--;
                        j2--;
                    } else {
                        return;
                    }
                }
                if (c7367k.mo5121b() == null) {
                    c7367k.L_();
                }
                return;
            } while (j != 0);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39428a((C7367k) obj);
    }

    public C8114r(T[] tArr) {
        this.f30221a = tArr;
    }

    /* renamed from: a */
    public void m39428a(C7367k<? super T> c7367k) {
        c7367k.mo6324a(new C7273a(c7367k, this.f30221a));
    }
}
