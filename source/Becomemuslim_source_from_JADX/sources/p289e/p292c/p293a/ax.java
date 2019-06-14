package p289e.p292c.p293a;

import java.util.concurrent.atomic.AtomicLong;
import p289e.C5974e.C7336b;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;

/* compiled from: OperatorTake */
/* renamed from: e.c.a.ax */
public final class ax<T> implements C7336b<T, T> {
    /* renamed from: a */
    final int f30109a;

    public ax(int i) {
        if (i >= 0) {
            this.f30109a = i;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("limit >= 0 required but it was ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public C7367k<? super T> m39294a(final C7367k<? super T> c7367k) {
        C5989l c80791 = new C7367k<T>(this) {
            /* renamed from: a */
            int f30105a;
            /* renamed from: b */
            boolean f30106b;
            /* renamed from: d */
            final /* synthetic */ ax f30108d;

            public void L_() {
                if (!this.f30106b) {
                    this.f30106b = true;
                    c7367k.L_();
                }
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                if (!this.f30106b) {
                    this.f30106b = true;
                    try {
                        c7367k.mo5001a(th);
                    } finally {
                        U_();
                    }
                }
            }

            /* renamed from: a */
            public void mo5000a(T t) {
                if (!mo5121b()) {
                    int i = this.f30105a;
                    this.f30105a = i + 1;
                    if (i < this.f30108d.f30109a) {
                        Object obj = this.f30105a == this.f30108d.f30109a ? 1 : null;
                        c7367k.mo5000a((Object) t);
                        if (obj != null && this.f30106b == null) {
                            this.f30106b = true;
                            try {
                                c7367k.L_();
                            } finally {
                                U_();
                            }
                        }
                    }
                }
            }

            /* renamed from: a */
            public void mo6324a(final C5984g c5984g) {
                c7367k.mo6324a(new C5984g(this) {
                    /* renamed from: a */
                    final AtomicLong f25559a = new AtomicLong(0);
                    /* renamed from: c */
                    final /* synthetic */ C80791 f25561c;

                    /* renamed from: a */
                    public void mo5119a(long j) {
                        if (j > 0 && !this.f25561c.f30106b) {
                            long min;
                            long j2;
                            do {
                                j2 = this.f25559a.get();
                                min = Math.min(j, ((long) this.f25561c.f30108d.f30109a) - j2);
                                if (min == 0) {
                                    return;
                                }
                            } while (!this.f25559a.compareAndSet(j2, j2 + min));
                            c5984g.mo5119a(min);
                        }
                    }
                });
            }
        };
        if (this.f30109a == 0) {
            c7367k.L_();
            c80791.U_();
        }
        c7367k.m33781a(c80791);
        return c80791;
    }
}
