package com.facebook.ads.internal.view.p120f;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.internal.p087b.C1347b;
import com.facebook.ads.internal.p095j.C1402f;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.view.p120f.C4584b;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3654h;
import com.facebook.ads.internal.view.p120f.p122b.C3656j;
import com.facebook.ads.internal.view.p120f.p122b.C3658l;
import com.facebook.ads.internal.view.p120f.p122b.C3659m;
import com.facebook.ads.internal.view.p120f.p122b.C3660n;
import com.facebook.ads.internal.view.p120f.p122b.C3662p;
import com.facebook.ads.internal.view.p120f.p122b.C3664r;
import com.facebook.ads.internal.view.p120f.p122b.C3665s;
import com.facebook.ads.internal.view.p120f.p122b.C3668v;
import com.facebook.ads.internal.view.p120f.p122b.C3669w;
import com.facebook.ads.internal.view.p120f.p122b.C3670x;
import com.facebook.ads.internal.view.p120f.p122b.C3671y;
import com.facebook.stetho.server.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.view.f.b */
public class C4584b extends C3684c {
    /* renamed from: a */
    public int f12473a;
    /* renamed from: b */
    private final C3669w f12474b;
    /* renamed from: c */
    private final C1402f<C3664r> f12475c;
    /* renamed from: d */
    private final C1402f<C3654h> f12476d;
    /* renamed from: e */
    private final C1402f<C3656j> f12477e;
    /* renamed from: f */
    private final C1402f<C3660n> f12478f;
    /* renamed from: g */
    private final C1402f<C3648b> f12479g;
    /* renamed from: h */
    private final C1402f<C3662p> f12480h;
    /* renamed from: i */
    private final C1402f<C3670x> f12481i;
    /* renamed from: j */
    private final C1402f<C3671y> f12482j;
    /* renamed from: k */
    private final C1402f<C3665s> f12483k;
    /* renamed from: l */
    private final C3659m f12484l;
    /* renamed from: m */
    private final C3640a f12485m;
    /* renamed from: n */
    private boolean f12486n;

    /* renamed from: com.facebook.ads.internal.view.f.b$4 */
    class C16264 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C4584b f4877a;

        C16264(C4584b c4584b) {
            this.f4877a = c4584b;
        }

        public void run() {
            this.f4877a.f12485m.getEventBus().m4806b(this.f4877a.f12474b, this.f4877a.f12478f, this.f4877a.f12475c, this.f4877a.f12477e, this.f4877a.f12476d, this.f4877a.f12479g, this.f4877a.f12480h, this.f4877a.f12481i, this.f4877a.f12482j, this.f4877a.f12484l, this.f4877a.f12483k);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.b$2 */
    class C36412 extends C1402f<C3665s> {
        /* renamed from: a */
        final /* synthetic */ C4584b f9771a;

        C36412(C4584b c4584b) {
            this.f9771a = c4584b;
        }

        /* renamed from: a */
        public Class<C3665s> mo930a() {
            return C3665s.class;
        }

        /* renamed from: a */
        public void m11940a(C3665s c3665s) {
            this.f9771a.m12052a(this.f9771a.m12062j(), this.f9771a.m12062j());
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.b$5 */
    class C36425 extends C1402f<C3664r> {
        /* renamed from: a */
        static final /* synthetic */ boolean f9772a = (C4584b.class.desiredAssertionStatus() ^ 1);
        /* renamed from: b */
        final /* synthetic */ C4584b f9773b;

        C36425(C4584b c4584b) {
            this.f9773b = c4584b;
        }

        /* renamed from: a */
        public Class<C3664r> mo930a() {
            return C3664r.class;
        }

        /* renamed from: a */
        public void m11943a(C3664r c3664r) {
            if (!f9772a) {
                if (this.f9773b == null) {
                    throw new AssertionError();
                }
            }
            if (this.f9773b != null) {
                this.f9773b.m12058f();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.b$6 */
    class C36436 extends C1402f<C3654h> {
        /* renamed from: a */
        static final /* synthetic */ boolean f9774a = (C4584b.class.desiredAssertionStatus() ^ 1);
        /* renamed from: b */
        final /* synthetic */ C4584b f9775b;

        C36436(C4584b c4584b) {
            this.f9775b = c4584b;
        }

        /* renamed from: a */
        public Class<C3654h> mo930a() {
            return C3654h.class;
        }

        /* renamed from: a */
        public void m11946a(C3654h c3654h) {
            if (!f9774a) {
                if (this.f9775b == null) {
                    throw new AssertionError();
                }
            }
            if (this.f9775b != null) {
                this.f9775b.m12060h();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.b$7 */
    class C36447 extends C1402f<C3656j> {
        /* renamed from: a */
        static final /* synthetic */ boolean f9776a = (C4584b.class.desiredAssertionStatus() ^ 1);
        /* renamed from: b */
        final /* synthetic */ C4584b f9777b;

        C36447(C4584b c4584b) {
            this.f9777b = c4584b;
        }

        /* renamed from: a */
        public Class<C3656j> mo930a() {
            return C3656j.class;
        }

        /* renamed from: a */
        public void m11949a(C3656j c3656j) {
            if (!f9776a) {
                if (this.f9777b == null) {
                    throw new AssertionError();
                }
            }
            if (this.f9777b != null) {
                if (this.f9777b.f12486n) {
                    this.f9777b.m12061i();
                } else {
                    this.f9777b.f12486n = true;
                }
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.b$8 */
    class C36458 extends C1402f<C3660n> {
        /* renamed from: a */
        final /* synthetic */ C4584b f9778a;

        C36458(C4584b c4584b) {
            this.f9778a = c4584b;
        }

        /* renamed from: a */
        public Class<C3660n> mo930a() {
            return C3660n.class;
        }

        /* renamed from: a */
        public void m11952a(C3660n c3660n) {
            int a = c3660n.m11963a();
            if (this.f9778a.f12473a <= 0 || a != this.f9778a.f12485m.getDuration() || this.f9778a.f12485m.getDuration() <= this.f9778a.f12473a) {
                this.f9778a.m12051a(a);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.b$9 */
    class C36469 extends C1402f<C3648b> {
        /* renamed from: a */
        final /* synthetic */ C4584b f9779a;

        C36469(C4584b c4584b) {
            this.f9779a = c4584b;
        }

        /* renamed from: a */
        public Class<C3648b> mo930a() {
            return C3648b.class;
        }

        /* renamed from: a */
        public void m11955a(C3648b c3648b) {
            int a = c3648b.m11956a();
            int b = c3648b.m11957b();
            if (this.f9779a.f12473a <= 0 || a != b || b <= this.f9779a.f12473a) {
                C4584b c4584b;
                if (b >= a + HttpStatus.HTTP_INTERNAL_SERVER_ERROR) {
                    c4584b = this.f9779a;
                } else if (b == 0) {
                    c4584b = this.f9779a;
                    a = this.f9779a.f12473a;
                } else {
                    this.f9779a.m12054b(b);
                }
                c4584b.m12054b(a);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.b$1 */
    class C45821 extends C3669w {
        /* renamed from: a */
        static final /* synthetic */ boolean f12470a = (C4584b.class.desiredAssertionStatus() ^ 1);
        /* renamed from: b */
        final /* synthetic */ C4584b f12471b;

        C45821(C4584b c4584b) {
            this.f12471b = c4584b;
        }

        /* renamed from: a */
        public void m15796a(C3668v c3668v) {
            if (!f12470a) {
                if (this.f12471b == null) {
                    throw new AssertionError();
                }
            }
            if (this.f12471b != null) {
                this.f12471b.m12057e();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.b$3 */
    class C45833 extends C3659m {
        /* renamed from: a */
        final /* synthetic */ C4584b f12472a;

        C45833(C4584b c4584b) {
            this.f12472a = c4584b;
        }

        /* renamed from: a */
        public void m15798a(C3658l c3658l) {
            this.f12472a.f12473a = this.f12472a.f12485m.getDuration();
        }
    }

    public C4584b(Context context, C1412c c1412c, C3640a c3640a, String str) {
        this(context, c1412c, c3640a, new ArrayList(), str);
    }

    public C4584b(Context context, C1412c c1412c, C3640a c3640a, String str, Bundle bundle) {
        this(context, c1412c, c3640a, new ArrayList(), str, bundle, null);
    }

    public C4584b(Context context, C1412c c1412c, C3640a c3640a, String str, Map<String, String> map) {
        this(context, c1412c, c3640a, new ArrayList(), str, null, map);
    }

    public C4584b(Context context, C1412c c1412c, C3640a c3640a, List<C1347b> list, String str) {
        super(context, c1412c, c3640a, list, str);
        this.f12474b = new C45821(this);
        this.f12475c = new C36425(this);
        this.f12476d = new C36436(this);
        this.f12477e = new C36447(this);
        this.f12478f = new C36458(this);
        this.f12479g = new C36469(this);
        this.f12480h = new C1402f<C3662p>(this) {
            /* renamed from: a */
            final /* synthetic */ C4584b f9768a;

            {
                this.f9768a = r1;
            }

            /* renamed from: a */
            public Class<C3662p> mo930a() {
                return C3662p.class;
            }

            /* renamed from: a */
            public void m11931a(C3662p c3662p) {
                this.f9768a.m12052a(c3662p.m11965a(), c3662p.m11966b());
            }
        };
        this.f12481i = new C1402f<C3670x>(this) {
            /* renamed from: a */
            final /* synthetic */ C4584b f9769a;

            {
                this.f9769a = r1;
            }

            /* renamed from: a */
            public Class<C3670x> mo930a() {
                return C3670x.class;
            }

            /* renamed from: a */
            public void m11934a(C3670x c3670x) {
                this.f9769a.m12053b();
            }
        };
        this.f12482j = new C1402f<C3671y>(this) {
            /* renamed from: a */
            final /* synthetic */ C4584b f9770a;

            {
                this.f9770a = r1;
            }

            /* renamed from: a */
            public Class<C3671y> mo930a() {
                return C3671y.class;
            }

            /* renamed from: a */
            public void m11937a(C3671y c3671y) {
                this.f9770a.m12055c();
            }
        };
        this.f12483k = new C36412(this);
        this.f12484l = new C45833(this);
        this.f12486n = false;
        this.f12485m = c3640a;
        this.f12485m.getEventBus().m4804a(this.f12474b, this.f12478f, this.f12475c, this.f12477e, this.f12476d, this.f12479g, this.f12480h, this.f12481i, this.f12482j, this.f12484l, this.f12483k);
    }

    public C4584b(Context context, C1412c c1412c, C3640a c3640a, List<C1347b> list, String str, Bundle bundle, Map<String, String> map) {
        super(context, c1412c, c3640a, list, str, bundle, map);
        this.f12474b = new C45821(this);
        this.f12475c = new C36425(this);
        this.f12476d = new C36436(this);
        this.f12477e = new C36447(this);
        this.f12478f = new C36458(this);
        this.f12479g = new C36469(this);
        this.f12480h = /* anonymous class already generated */;
        this.f12481i = /* anonymous class already generated */;
        this.f12482j = /* anonymous class already generated */;
        this.f12483k = new C36412(this);
        this.f12484l = new C45833(this);
        this.f12486n = false;
        this.f12485m = c3640a;
        this.f12485m.getEventBus().m4804a(this.f12474b, this.f12478f, this.f12475c, this.f12477e, this.f12476d, this.f12479g, this.f12480h, this.f12481i, this.f12482j, this.f12483k);
    }

    /* renamed from: a */
    public void mo2876a() {
        this.f12485m.getStateHandler().post(new C16264(this));
    }
}
