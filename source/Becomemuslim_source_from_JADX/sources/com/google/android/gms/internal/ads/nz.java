package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@cm
public class nz<T> implements no<T> {
    /* renamed from: a */
    private final Object f24185a = new Object();
    /* renamed from: b */
    private T f24186b;
    /* renamed from: c */
    private Throwable f24187c;
    /* renamed from: d */
    private boolean f24188d;
    /* renamed from: e */
    private boolean f24189e;
    /* renamed from: f */
    private final nq f24190f = new nq();

    /* renamed from: a */
    private final boolean mo6111a() {
        if (this.f24187c == null) {
            if (!this.f24188d) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public final void mo4319a(Runnable runnable, Executor executor) {
        this.f24190f.m19953a(runnable, executor);
    }

    /* renamed from: a */
    public final void m30914a(Throwable th) {
        synchronized (this.f24185a) {
            if (this.f24189e) {
            } else if (mo6111a()) {
                ax.i().m30837b(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.setException");
            } else {
                this.f24187c = th;
                this.f24185a.notifyAll();
                this.f24190f.m19952a();
            }
        }
    }

    /* renamed from: b */
    public final void m30915b(T t) {
        synchronized (this.f24185a) {
            if (this.f24189e) {
            } else if (mo6111a()) {
                ax.i().m30837b(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.set");
            } else {
                this.f24188d = true;
                this.f24186b = t;
                this.f24185a.notifyAll();
                this.f24190f.m19952a();
            }
        }
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.f24185a) {
            if (mo6111a()) {
                return false;
            }
            this.f24189e = true;
            this.f24188d = true;
            this.f24185a.notifyAll();
            this.f24190f.m19952a();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.f24185a) {
            if (!mo6111a()) {
                try {
                    this.f24185a.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.f24187c != null) {
                throw new ExecutionException(this.f24187c);
            } else if (this.f24189e) {
                throw new CancellationException("SettableFuture was cancelled.");
            } else {
                t = this.f24186b;
            }
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) {
        T t;
        synchronized (this.f24185a) {
            if (!mo6111a()) {
                try {
                    j = timeUnit.toMillis(j);
                    if (j != 0) {
                        this.f24185a.wait(j);
                    }
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.f24187c != null) {
                throw new ExecutionException(this.f24187c);
            } else if (!this.f24188d) {
                throw new TimeoutException("SettableFuture timed out.");
            } else if (this.f24189e) {
                throw new CancellationException("SettableFuture was cancelled.");
            } else {
                t = this.f24186b;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.f24185a) {
            z = this.f24189e;
        }
        return z;
    }

    public boolean isDone() {
        boolean a;
        synchronized (this.f24185a) {
            a = mo6111a();
        }
        return a;
    }
}
