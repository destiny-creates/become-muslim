package com.p079e.p080a;

import android.net.NetworkInfo;
import com.p079e.p080a.C1236t.C1234e;
import com.p079e.p080a.ae.C1204e;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PicassoExecutorService */
/* renamed from: com.e.a.v */
class C1239v extends ThreadPoolExecutor {

    /* compiled from: PicassoExecutorService */
    /* renamed from: com.e.a.v$a */
    private static final class C1238a extends FutureTask<C1210c> implements Comparable<C1238a> {
        /* renamed from: a */
        private final C1210c f3520a;

        public /* synthetic */ int compareTo(Object obj) {
            return m4322a((C1238a) obj);
        }

        public C1238a(C1210c c1210c) {
            super(c1210c, null);
            this.f3520a = c1210c;
        }

        /* renamed from: a */
        public int m4322a(C1238a c1238a) {
            C1234e n = this.f3520a.m4254n();
            C1234e n2 = c1238a.f3520a.m4254n();
            return n == n2 ? this.f3520a.f3401a - c1238a.f3520a.f3401a : n2.ordinal() - n.ordinal();
        }
    }

    C1239v() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C1204e());
    }

    /* renamed from: a */
    void m4324a(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            if (networkInfo.isConnectedOrConnecting()) {
                int type = networkInfo.getType();
                if (!(type == 6 || type == 9)) {
                    switch (type) {
                        case 0:
                            networkInfo = networkInfo.getSubtype();
                            switch (networkInfo) {
                                case 1:
                                case 2:
                                    m4323a(1);
                                    break;
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                    m4323a(2);
                                    break;
                                default:
                                    switch (networkInfo) {
                                        case 12:
                                            break;
                                        case 13:
                                        case 14:
                                        case 15:
                                            m4323a(3);
                                            break;
                                        default:
                                            m4323a(3);
                                            break;
                                    }
                                    m4323a(2);
                                    break;
                            }
                        case 1:
                            break;
                        default:
                            m4323a(3);
                            break;
                    }
                }
                m4323a(4);
                return;
            }
        }
        m4323a(3);
    }

    /* renamed from: a */
    private void m4323a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    public Future<?> submit(Runnable runnable) {
        Object c1238a = new C1238a((C1210c) runnable);
        execute(c1238a);
        return c1238a;
    }
}
