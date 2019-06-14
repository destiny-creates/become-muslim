package com.google.android.exoplayer2.p157i;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.C2330e;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2543l;
import com.google.android.exoplayer2.C4690a;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2524i;
import java.util.Collections;
import java.util.List;

/* compiled from: TextRenderer */
/* renamed from: com.google.android.exoplayer2.i.l */
public final class C4868l extends C4690a implements Callback {
    /* renamed from: a */
    private final Handler f13917a;
    /* renamed from: b */
    private final C2475k f13918b;
    /* renamed from: c */
    private final C2474h f13919c;
    /* renamed from: d */
    private final C2543l f13920d;
    /* renamed from: e */
    private boolean f13921e;
    /* renamed from: f */
    private boolean f13922f;
    /* renamed from: g */
    private int f13923g;
    /* renamed from: h */
    private C2515k f13924h;
    /* renamed from: i */
    private C4230f f13925i;
    /* renamed from: j */
    private C4726i f13926j;
    /* renamed from: k */
    private C4727j f13927k;
    /* renamed from: l */
    private C4727j f13928l;
    /* renamed from: m */
    private int f13929m;

    /* renamed from: t */
    public boolean mo3418t() {
        return true;
    }

    public C4868l(C2475k c2475k, Looper looper) {
        this(c2475k, looper, C2474h.f6295a);
    }

    public C4868l(C2475k c2475k, Looper looper, C2474h c2474h) {
        super(3);
        this.f13918b = (C2475k) C2516a.m7015a((Object) c2475k);
        if (looper == null) {
            c2475k = null;
        } else {
            c2475k = new Handler(looper, this);
        }
        this.f13917a = c2475k;
        this.f13919c = c2474h;
        this.f13920d = new C2543l();
    }

    /* renamed from: a */
    public int mo3411a(C2515k c2515k) {
        if (!this.f13919c.mo2295a(c2515k)) {
            return C2524i.m7052c(c2515k.f6380f) != null ? 1 : null;
        } else {
            return C4690a.m15998a(null, (C2255a) c2515k.f6383i) != null ? 4 : 2;
        }
    }

    /* renamed from: a */
    protected void mo3420a(C2515k[] c2515kArr, long j) {
        this.f13924h = c2515kArr[0];
        if (this.f13925i != null) {
            this.f13923g = 1;
        } else {
            this.f13925i = this.f13919c.mo2296b(this.f13924h);
        }
    }

    /* renamed from: a */
    protected void mo3413a(long j, boolean z) {
        m17405z();
        this.f13921e = false;
        this.f13922f = false;
        if (this.f13923g != null) {
            m17403x();
            return;
        }
        m17401v();
        this.f13925i.mo2149c();
    }

    /* renamed from: a */
    public void mo3412a(long j, long j2) {
        if (this.f13922f == null) {
            if (this.f13928l == null) {
                this.f13925i.mo3242a(j);
                try {
                    this.f13928l = (C4727j) this.f13925i.mo2148b();
                } catch (long j3) {
                    throw C2330e.m6459a(j3, m16026r());
                }
            }
            if (mo3185d() == 2) {
                if (this.f13927k != null) {
                    long y = m17404y();
                    j2 = null;
                    while (y <= j3) {
                        this.f13929m++;
                        y = m17404y();
                        j2 = 1;
                    }
                } else {
                    j2 = null;
                }
                if (this.f13928l != null) {
                    if (this.f13928l.m6206c()) {
                        if (j2 == null && m17404y() == Clock.MAX_TIME) {
                            if (this.f13923g == 2) {
                                m17403x();
                            } else {
                                m17401v();
                                this.f13922f = true;
                            }
                        }
                    } else if (this.f13928l.a <= j3) {
                        if (this.f13927k != null) {
                            this.f13927k.mo3430e();
                        }
                        this.f13927k = this.f13928l;
                        this.f13928l = null;
                        this.f13929m = this.f13927k.mo2291a(j3);
                        j2 = 1;
                    }
                }
                if (j2 != null) {
                    m17399a(this.f13927k.mo2294b(j3));
                }
                if (this.f13923g != 2) {
                    while (this.f13921e == null) {
                        try {
                            if (this.f13926j == null) {
                                this.f13926j = (C4726i) this.f13925i.mo2146a();
                                if (this.f13926j == null) {
                                    return;
                                }
                            }
                            if (this.f13923g == 1) {
                                this.f13926j.a_(4);
                                this.f13925i.mo2147a(this.f13926j);
                                this.f13926j = null;
                                this.f13923g = 2;
                                return;
                            }
                            j3 = m16000a((C2543l) this.f13920d, this.f13926j, false);
                            if (j3 == -4) {
                                if (this.f13926j.m6206c() != null) {
                                    this.f13921e = true;
                                } else {
                                    this.f13926j.f12871d = this.f13920d.f6476a.f6397w;
                                    this.f13926j.m12756h();
                                }
                                this.f13925i.mo2147a(this.f13926j);
                                this.f13926j = null;
                            } else if (j3 == -3) {
                                return;
                            }
                        } catch (long j32) {
                            throw C2330e.m6459a(j32, m16026r());
                        }
                    }
                }
            }
        }
    }

    /* renamed from: p */
    protected void mo3417p() {
        this.f13924h = null;
        m17405z();
        m17402w();
    }

    /* renamed from: u */
    public boolean mo3419u() {
        return this.f13922f;
    }

    /* renamed from: v */
    private void m17401v() {
        this.f13926j = null;
        this.f13929m = -1;
        if (this.f13927k != null) {
            this.f13927k.mo3430e();
            this.f13927k = null;
        }
        if (this.f13928l != null) {
            this.f13928l.mo3430e();
            this.f13928l = null;
        }
    }

    /* renamed from: w */
    private void m17402w() {
        m17401v();
        this.f13925i.mo2150d();
        this.f13925i = null;
        this.f13923g = 0;
    }

    /* renamed from: x */
    private void m17403x() {
        m17402w();
        this.f13925i = this.f13919c.mo2296b(this.f13924h);
    }

    /* renamed from: y */
    private long m17404y() {
        if (this.f13929m != -1) {
            if (this.f13929m < this.f13927k.mo2293b()) {
                return this.f13927k.mo2292a(this.f13929m);
            }
        }
        return Clock.MAX_TIME;
    }

    /* renamed from: a */
    private void m17399a(List<C2458b> list) {
        if (this.f13917a != null) {
            this.f13917a.obtainMessage(0, list).sendToTarget();
        } else {
            m17400b(list);
        }
    }

    /* renamed from: z */
    private void m17405z() {
        m17399a(Collections.emptyList());
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            m17400b((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    private void m17400b(List<C2458b> list) {
        this.f13918b.mo2327a(list);
    }
}
