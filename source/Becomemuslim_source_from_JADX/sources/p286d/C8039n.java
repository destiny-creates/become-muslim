package p286d;

import java.nio.ByteBuffer;

/* compiled from: RealBufferedSink */
/* renamed from: d.n */
final class C8039n implements C7203d {
    /* renamed from: a */
    public final C8037c f29841a = new C8037c();
    /* renamed from: b */
    public final C5875s f29842b;
    /* renamed from: c */
    boolean f29843c;

    C8039n(C5875s c5875s) {
        if (c5875s != null) {
            this.f29842b = c5875s;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    /* renamed from: b */
    public C8037c mo6292b() {
        return this.f29841a;
    }

    public void write(C8037c c8037c, long j) {
        if (this.f29843c) {
            throw new IllegalStateException("closed");
        }
        this.f29841a.write(c8037c, j);
        mo6320w();
    }

    /* renamed from: b */
    public C7203d mo6293b(C5869f c5869f) {
        if (this.f29843c) {
            throw new IllegalStateException("closed");
        }
        this.f29841a.m38968a(c5869f);
        return mo6320w();
    }

    /* renamed from: b */
    public C7203d mo6294b(String str) {
        if (this.f29843c) {
            throw new IllegalStateException("closed");
        }
        this.f29841a.m38969a(str);
        return mo6320w();
    }

    /* renamed from: c */
    public C7203d mo6296c(byte[] bArr) {
        if (this.f29843c) {
            throw new IllegalStateException("closed");
        }
        this.f29841a.m38982b(bArr);
        return mo6320w();
    }

    /* renamed from: c */
    public C7203d mo6297c(byte[] bArr, int i, int i2) {
        if (this.f29843c) {
            throw new IllegalStateException("closed");
        }
        this.f29841a.m38983b(bArr, i, i2);
        return mo6320w();
    }

    public int write(ByteBuffer byteBuffer) {
        if (this.f29843c) {
            throw new IllegalStateException("closed");
        }
        byteBuffer = this.f29841a.write(byteBuffer);
        mo6320w();
        return byteBuffer;
    }

    /* renamed from: a */
    public long mo6286a(C5876t c5876t) {
        if (c5876t != null) {
            long j = 0;
            while (true) {
                long read = c5876t.read(this.f29841a, 8192);
                if (read == -1) {
                    return j;
                }
                j += read;
                mo6320w();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: i */
    public C7203d mo6307i(int i) {
        if (this.f29843c) {
            throw new IllegalStateException("closed");
        }
        this.f29841a.m38981b(i);
        return mo6320w();
    }

    /* renamed from: h */
    public C7203d mo6305h(int i) {
        if (this.f29843c) {
            throw new IllegalStateException("closed");
        }
        this.f29841a.m38989c(i);
        return mo6320w();
    }

    /* renamed from: g */
    public C7203d mo6303g(int i) {
        if (this.f29843c) {
            throw new IllegalStateException("closed");
        }
        this.f29841a.m38992d(i);
        return mo6320w();
    }

    /* renamed from: n */
    public C7203d mo6316n(long j) {
        if (this.f29843c) {
            throw new IllegalStateException("closed");
        }
        this.f29841a.m39013k(j);
        return mo6320w();
    }

    /* renamed from: m */
    public C7203d mo6314m(long j) {
        if (this.f29843c) {
            throw new IllegalStateException("closed");
        }
        this.f29841a.m39014l(j);
        return mo6320w();
    }

    /* renamed from: w */
    public C7203d mo6320w() {
        if (this.f29843c) {
            throw new IllegalStateException("closed");
        }
        long g = this.f29841a.m39001g();
        if (g > 0) {
            this.f29842b.write(this.f29841a, g);
        }
        return this;
    }

    /* renamed from: d */
    public C7203d mo6298d() {
        if (this.f29843c) {
            throw new IllegalStateException("closed");
        }
        long a = this.f29841a.m38961a();
        if (a > 0) {
            this.f29842b.write(this.f29841a, a);
        }
        return this;
    }

    public void flush() {
        if (this.f29843c) {
            throw new IllegalStateException("closed");
        }
        if (this.f29841a.f29839b > 0) {
            this.f29842b.write(this.f29841a, this.f29841a.f29839b);
        }
        this.f29842b.flush();
    }

    public boolean isOpen() {
        return this.f29843c ^ 1;
    }

    public void close() {
        if (!this.f29843c) {
            Throwable th = null;
            try {
                if (this.f29841a.f29839b > 0) {
                    this.f29842b.write(this.f29841a, this.f29841a.f29839b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f29842b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f29843c = true;
            if (th != null) {
                C5878v.m24747a(th);
            }
        }
    }

    public C5877u timeout() {
        return this.f29842b.timeout();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append(this.f29842b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
