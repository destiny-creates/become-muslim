package com.polidea.p254a;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.p071c.p072a.C4535a;
import com.polidea.p254a.C5550a.C5547b;
import com.polidea.p254a.af.C5554a;
import com.polidea.p254a.p256b.C5577b;
import com.polidea.p254a.p256b.C5577b.C5561a;
import com.polidea.p254a.p256b.C5584c;
import com.polidea.p254a.p256b.C5613n;
import com.polidea.p254a.p256b.C7978d;
import com.polidea.p254a.p256b.C7982e;
import com.polidea.p254a.p256b.C7992f;
import com.polidea.p254a.p256b.C7993g;
import com.polidea.p254a.p256b.C7994h;
import com.polidea.p254a.p256b.C7995i;
import com.polidea.p254a.p256b.C7996m;
import com.polidea.p254a.p256b.C7997o;
import com.polidea.p254a.p256b.p257a.C5557b;
import com.polidea.p254a.p256b.p257a.C7935c;
import com.polidea.p254a.p256b.p258b.C5562a;
import com.polidea.p254a.p256b.p258b.C5567c;
import com.polidea.p254a.p256b.p258b.C5567c.C5566a;
import com.polidea.p254a.p256b.p258b.C5568d;
import com.polidea.p254a.p256b.p258b.C5570m;
import com.polidea.p254a.p256b.p258b.C5571n;
import com.polidea.p254a.p256b.p258b.C7939b;
import com.polidea.p254a.p256b.p258b.C7940f;
import com.polidea.p254a.p256b.p258b.C7941g;
import com.polidea.p254a.p256b.p258b.C7942h;
import com.polidea.p254a.p256b.p258b.C7943i;
import com.polidea.p254a.p256b.p258b.C7944j;
import com.polidea.p254a.p256b.p258b.C7945k;
import com.polidea.p254a.p256b.p258b.C7946l;
import com.polidea.p254a.p256b.p258b.C7947q;
import com.polidea.p254a.p256b.p258b.C7948s;
import com.polidea.p254a.p256b.p258b.C7949u;
import com.polidea.p254a.p256b.p258b.C7950x;
import com.polidea.p254a.p256b.p258b.C7951z;
import com.polidea.p254a.p256b.p258b.ac;
import com.polidea.p254a.p256b.p258b.af;
import com.polidea.p254a.p256b.p258b.ah;
import com.polidea.p254a.p256b.p258b.aj;
import com.polidea.p254a.p256b.p258b.am;
import com.polidea.p254a.p256b.p258b.ao;
import com.polidea.p254a.p256b.p258b.ar;
import com.polidea.p254a.p256b.p258b.at;
import com.polidea.p254a.p256b.p258b.au;
import com.polidea.p254a.p256b.p258b.av;
import com.polidea.p254a.p256b.p258b.aw;
import com.polidea.p254a.p256b.p258b.ay;
import com.polidea.p254a.p256b.p258b.ba;
import com.polidea.p254a.p256b.p259c.C5583t;
import com.polidea.p254a.p256b.p259c.C7953c;
import com.polidea.p254a.p256b.p259c.C7954d;
import com.polidea.p254a.p256b.p259c.C7957h;
import com.polidea.p254a.p256b.p259c.C7958m;
import com.polidea.p254a.p256b.p259c.C7959o;
import com.polidea.p254a.p256b.p260d.C5587d;
import com.polidea.p254a.p256b.p260d.C5592s;
import com.polidea.p254a.p256b.p260d.C7961b;
import com.polidea.p254a.p256b.p260d.C7962e;
import com.polidea.p254a.p256b.p260d.C7963g;
import com.polidea.p254a.p256b.p260d.C7964k;
import com.polidea.p254a.p256b.p260d.C7965m;
import com.polidea.p254a.p256b.p260d.C7971q;
import com.polidea.p254a.p256b.p260d.C7973u;
import com.polidea.p254a.p256b.p260d.C7975w;
import com.polidea.p254a.p256b.p260d.C7977y;
import com.polidea.p254a.p256b.p261e.C5593a;
import com.polidea.p254a.p256b.p261e.C7979c;
import com.polidea.p254a.p256b.p261e.C7980e;
import com.polidea.p254a.p256b.p261e.C7981f;
import com.polidea.p254a.p256b.p262f.C5600b;
import com.polidea.p254a.p256b.p262f.C5610w;
import com.polidea.p254a.p256b.p262f.C7983h;
import com.polidea.p254a.p256b.p262f.C7984j;
import com.polidea.p254a.p256b.p262f.C7985l;
import com.polidea.p254a.p256b.p262f.C7986n;
import com.polidea.p254a.p256b.p262f.C7987q;
import com.polidea.p254a.p256b.p262f.C7988s;
import com.polidea.p254a.p256b.p262f.C7990x;
import com.polidea.p254a.p256b.p262f.C7991z;
import com.polidea.p254a.p256b.p262f.ab;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import p000a.p001a.p002a.C0000d;
import p000a.p001a.p002a.C0001e;
import p000a.p001a.p002a.C3085b;
import p000a.p001a.p002a.C4436a;
import p000a.p003b.p004a.C0003a;
import p289e.C5986h;

/* compiled from: DaggerClientComponent */
/* renamed from: com.polidea.a.y */
public final class C7095y implements C5550a {
    /* renamed from: A */
    private C7975w f25115A;
    /* renamed from: B */
    private C7977y f25116B;
    /* renamed from: C */
    private C0003a<C5592s> f25117C;
    /* renamed from: D */
    private C7964k f25118D;
    /* renamed from: E */
    private C7965m f25119E;
    /* renamed from: F */
    private C8018u f25120F;
    /* renamed from: G */
    private C7963g f25121G;
    /* renamed from: H */
    private C0003a<ExecutorService> f25122H;
    /* renamed from: I */
    private C0003a<ExecutorService> f25123I;
    /* renamed from: J */
    private C8013p f25124J;
    /* renamed from: K */
    private ae f25125K;
    /* renamed from: L */
    private C0003a<ac> f25126L;
    /* renamed from: M */
    private C0003a<C5986h> f25127M;
    /* renamed from: N */
    private C8005h f25128N;
    /* renamed from: a */
    private C5547b f25129a;
    /* renamed from: b */
    private C7999b f25130b;
    /* renamed from: c */
    private C8008k f25131c;
    /* renamed from: d */
    private C8015r f25132d;
    /* renamed from: e */
    private C7984j f25133e;
    /* renamed from: f */
    private C7983h f25134f;
    /* renamed from: g */
    private C8020w f25135g;
    /* renamed from: h */
    private C8014q f25136h;
    /* renamed from: i */
    private C7988s f25137i;
    /* renamed from: j */
    private C8017t f25138j;
    /* renamed from: k */
    private C7986n f25139k;
    /* renamed from: l */
    private C7990x f25140l;
    /* renamed from: m */
    private C0003a<ExecutorService> f25141m;
    /* renamed from: n */
    private C0003a<C5986h> f25142n;
    /* renamed from: o */
    private C7979c f25143o;
    /* renamed from: p */
    private C0003a<C5593a> f25144p;
    /* renamed from: q */
    private ab f25145q;
    /* renamed from: r */
    private C8016s f25146r;
    /* renamed from: s */
    private C7985l f25147s;
    /* renamed from: t */
    private C0003a<C5557b> f25148t;
    /* renamed from: u */
    private C0003a<C5561a> f25149u;
    /* renamed from: v */
    private C0003a<C5613n> f25150v;
    /* renamed from: w */
    private C0003a<C5587d> f25151w;
    /* renamed from: x */
    private C7971q f25152x;
    /* renamed from: y */
    private C7973u f25153y;
    /* renamed from: z */
    private C7961b f25154z;

    /* compiled from: DaggerClientComponent */
    /* renamed from: com.polidea.a.y$a */
    public static final class C5630a {
        /* renamed from: a */
        private C5547b f18808a;

        private C5630a() {
        }

        /* renamed from: a */
        public C5550a m23930a() {
            if (this.f18808a != null) {
                return new C7095y();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C5547b.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        /* renamed from: a */
        public C5630a m23931a(C5547b c5547b) {
            this.f18808a = (C5547b) C0000d.a(c5547b);
            return this;
        }
    }

    /* compiled from: DaggerClientComponent */
    /* renamed from: com.polidea.a.y$1 */
    class C70891 implements C0003a<C5561a> {
        /* renamed from: a */
        final /* synthetic */ C7095y f25073a;

        C70891(C7095y c7095y) {
            this.f25073a = c7095y;
        }

        /* renamed from: a */
        public /* synthetic */ Object m33003a() {
            return m33004b();
        }

        /* renamed from: b */
        public C5561a m33004b() {
            return new C7090b();
        }
    }

    /* compiled from: DaggerClientComponent */
    /* renamed from: com.polidea.a.y$b */
    private final class C7090b implements C5561a {
        /* renamed from: a */
        final /* synthetic */ C7095y f25074a;
        /* renamed from: b */
        private C5584c f25075b;

        private C7090b(C7095y c7095y) {
            this.f25074a = c7095y;
        }

        /* renamed from: b */
        public /* synthetic */ C5561a mo5029b(C5584c c5584c) {
            return m33007a(c5584c);
        }

        /* renamed from: a */
        public C5577b mo5028a() {
            if (this.f25075b != null) {
                return new C7094c(this);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C5584c.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        /* renamed from: a */
        public C7090b m33007a(C5584c c5584c) {
            this.f25075b = (C5584c) C0000d.a(c5584c);
            return this;
        }
    }

    /* compiled from: DaggerClientComponent */
    /* renamed from: com.polidea.a.y$c */
    private final class C7094c implements C5577b {
        /* renamed from: a */
        final /* synthetic */ C7095y f25105a;
        /* renamed from: b */
        private C5584c f25106b;
        /* renamed from: c */
        private C7978d f25107c;
        /* renamed from: d */
        private C0003a<C5566a> f25108d;
        /* renamed from: e */
        private C7947q f25109e;
        /* renamed from: f */
        private C0003a<C4535a<C5554a>> f25110f;
        /* renamed from: g */
        private C0003a f25111g;
        /* renamed from: h */
        private C7993g f25112h;
        /* renamed from: i */
        private C0003a<C5570m> f25113i;
        /* renamed from: j */
        private C7995i f25114j;

        /* compiled from: DaggerClientComponent */
        /* renamed from: com.polidea.a.y$c$1 */
        class C70911 implements C0003a<C5566a> {
            /* renamed from: a */
            final /* synthetic */ C7094c f25076a;

            C70911(C7094c c7094c) {
                this.f25076a = c7094c;
            }

            /* renamed from: a */
            public /* synthetic */ Object m33009a() {
                return m33010b();
            }

            /* renamed from: b */
            public C5566a m33010b() {
                return new C7092a();
            }
        }

        /* compiled from: DaggerClientComponent */
        /* renamed from: com.polidea.a.y$c$a */
        private final class C7092a implements C5566a {
            /* renamed from: a */
            final /* synthetic */ C7094c f25077a;
            /* renamed from: b */
            private C5568d f25078b;

            private C7092a(C7094c c7094c) {
                this.f25077a = c7094c;
            }

            /* renamed from: b */
            public /* synthetic */ C5566a mo5031b(C5568d c5568d) {
                return m33013a(c5568d);
            }

            /* renamed from: a */
            public C5567c mo5030a() {
                if (this.f25078b != null) {
                    return new C7093b(this);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(C5568d.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }

            /* renamed from: a */
            public C7092a m33013a(C5568d c5568d) {
                this.f25078b = (C5568d) C0000d.a(c5568d);
                return this;
            }
        }

        /* compiled from: DaggerClientComponent */
        /* renamed from: com.polidea.a.y$c$b */
        private final class C7093b implements C5567c {
            /* renamed from: a */
            final /* synthetic */ C7094c f25079a;
            /* renamed from: b */
            private C0003a<C5562a> f25080b;
            /* renamed from: c */
            private C0003a f25081c;
            /* renamed from: d */
            private C0003a<av> f25082d;
            /* renamed from: e */
            private C0003a<Boolean> f25083e;
            /* renamed from: f */
            private C0003a<C7980e> f25084f;
            /* renamed from: g */
            private C0003a<BluetoothGatt> f25085g;
            /* renamed from: h */
            private C7944j f25086h;
            /* renamed from: i */
            private C7991z f25087i;
            /* renamed from: j */
            private C7946l f25088j;
            /* renamed from: k */
            private C7959o f25089k;
            /* renamed from: l */
            private C7958m f25090l;
            /* renamed from: m */
            private C0003a f25091m;
            /* renamed from: n */
            private C0003a f25092n;
            /* renamed from: o */
            private C0003a f25093o;
            /* renamed from: p */
            private C0003a f25094p;
            /* renamed from: q */
            private C0003a<at> f25095q;
            /* renamed from: r */
            private C0003a f25096r;
            /* renamed from: s */
            private ah f25097s;
            /* renamed from: t */
            private ac f25098t;
            /* renamed from: u */
            private af f25099u;
            /* renamed from: v */
            private ba f25100v;
            /* renamed from: w */
            private C7945k f25101w;
            /* renamed from: x */
            private C7951z f25102x;
            /* renamed from: y */
            private C7957h f25103y;
            /* renamed from: z */
            private C0003a f25104z;

            private C7093b(C7094c c7094c, C7092a c7092a) {
                this.f25079a = c7094c;
                m33015a(c7092a);
            }

            /* renamed from: e */
            private C5600b m33016e() {
                return new C5600b(C7999b.m38797b(this.f25079a.f25105a.f25129a));
            }

            /* renamed from: a */
            private void m33015a(C7092a c7092a) {
                this.f25080b = C3085b.a(C7939b.m38594c());
                this.f25081c = C3085b.a(C7950x.m38630a(this.f25079a.f25112h, this.f25079a.f25105a.f25140l, this.f25079a.f25105a.f25145q));
                this.f25082d = C3085b.a(aw.m38588a(this.f25079a.f25105a.f25127M, this.f25080b, this.f25081c, ao.m38572c()));
                this.f25083e = C3085b.a(C7943i.m38609a(c7092a.f25078b));
                this.f25084f = C3085b.a(C7981f.m38738a(this.f25079a.f25112h, this.f25081c, this.f25079a.f25105a.f25123I, this.f25079a.f25105a.f25142n));
                this.f25085g = C3085b.a(C7942h.m38606a(this.f25080b));
                this.f25086h = C7944j.m38612a(c7092a.f25078b);
                this.f25087i = C7991z.m38770a(this.f25086h);
                this.f25088j = C7946l.m38618a(c7092a.f25078b, C8006i.m38818c());
                this.f25089k = C7959o.m38667a(this.f25082d, this.f25085g, this.f25088j);
                this.f25090l = C7958m.m38664a(this.f25082d, this.f25085g, this.f25087i, this.f25088j, this.f25079a.f25105a.f25142n, C8006i.m38818c(), this.f25089k);
                this.f25091m = C3085b.a(ay.m38591a(this.f25084f, this.f25085g, this.f25090l));
                this.f25092n = C3085b.a(C7948s.m38624a(this.f25084f, this.f25090l));
                this.f25093o = C3085b.a(ar.m38579a(C8012o.m38837c(), C8011n.m38834c(), C8010m.m38831c(), this.f25085g, this.f25082d, this.f25092n));
                this.f25094p = C3085b.a(am.m38569a(this.f25082d, C7941g.m38603c()));
                this.f25095q = new C4436a();
                this.f25096r = C3085b.a(aj.m38566a(this.f25095q, C7940f.m38600c()));
                this.f25097s = ah.m38563a(this.f25084f, this.f25096r, this.f25095q, this.f25090l);
                this.f25098t = ac.m38557a(this.f25086h);
                this.f25099u = af.m38560a(this.f25098t);
                this.f25100v = ba.m38597a(this.f25098t);
                this.f25101w = C7945k.m38615a(c7092a.f25078b, this.f25099u, this.f25100v);
                this.f25102x = C7951z.m38633a(this.f25101w);
                C4436a c4436a = (C4436a) this.f25095q;
                this.f25095q = C3085b.a(au.m38585a(this.f25084f, this.f25082d, this.f25085g, this.f25091m, this.f25093o, this.f25094p, this.f25092n, this.f25090l, this.f25097s, this.f25079a.f25105a.f25142n, this.f25102x));
                c4436a.a(this.f25095q);
                this.f25103y = C7957h.m38661a(this.f25082d, this.f25080b, this.f25079a.f25112h, this.f25079a.f25105a.f25128N, this.f25079a.f25105a.f25142n, this.f25079a.f25114j, this.f25079a.f25113i);
                this.f25104z = C3085b.a(C7949u.m38627a(this.f25079a.f25105a.f25144p, this.f25103y));
            }

            /* renamed from: a */
            public C7953c mo5032a() {
                return C7954d.m38651a(this.f25079a.m33023b(), m33016e(), (av) this.f25082d.a(), (C5562a) this.f25080b.a(), this.f25079a.m33026c(), ((Boolean) this.f25083e.a()).booleanValue(), (C5570m) this.f25079a.f25113i.a());
            }

            /* renamed from: b */
            public af mo5033b() {
                return (af) this.f25095q.a();
            }

            /* renamed from: c */
            public av mo5034c() {
                return (av) this.f25082d.a();
            }

            /* renamed from: d */
            public Set<C5571n> mo5035d() {
                return C0001e.a(3).a((C5571n) this.f25094p.a()).a((C5571n) this.f25104z.a()).a(this.f25084f.a()).a();
            }
        }

        private C7094c(C7095y c7095y, C7090b c7090b) {
            this.f25105a = c7095y;
            m33022a(c7090b);
        }

        /* renamed from: b */
        private BluetoothDevice m33023b() {
            return C7978d.m38723a(this.f25106b, this.f25105a.m33035c());
        }

        /* renamed from: c */
        private C5583t m33026c() {
            return C7994h.m38779a(C8006i.m38819d());
        }

        /* renamed from: a */
        private void m33022a(C7090b c7090b) {
            this.f25107c = C7978d.m38724a(c7090b.f25075b, this.f25105a.f25140l);
            this.f25108d = new C70911(this);
            this.f25109e = C7947q.m38621a(this.f25105a.f25144p, this.f25108d, this.f25105a.f25127M);
            this.f25110f = C3085b.a(C7992f.m38773c());
            this.f25111g = C3085b.a(C7996m.m38785a(this.f25107c, this.f25109e, this.f25110f));
            this.f25106b = c7090b.f25075b;
            this.f25112h = C7993g.m38776a(c7090b.f25075b);
            this.f25113i = C3085b.a(C7982e.m38741a(this.f25110f));
            this.f25114j = C7995i.m38782a(C8006i.m38818c());
        }

        /* renamed from: a */
        public ah mo5036a() {
            return (ah) this.f25111g.a();
        }
    }

    private C7095y(C5630a c5630a) {
        m33031a(c5630a);
    }

    /* renamed from: b */
    public static C5630a m33033b() {
        return new C5630a();
    }

    /* renamed from: c */
    private C5610w m33035c() {
        return new C5610w(C5547b.m23599c());
    }

    /* renamed from: a */
    private void m33031a(C5630a c5630a) {
        this.f25129a = c5630a.f18808a;
        this.f25130b = C7999b.m38796a(c5630a.f18808a);
        this.f25131c = C8008k.m38825a(c5630a.f18808a);
        this.f25132d = C8015r.m38846a(c5630a.f18808a);
        this.f25133e = C7984j.m38750a(this.f25131c, this.f25132d);
        this.f25134f = C7983h.m38747a(this.f25130b);
        this.f25135g = C8020w.m38861a(c5630a.f18808a);
        this.f25136h = C8014q.m38843a(c5630a.f18808a, C8009l.m38828c());
        this.f25137i = C7988s.m38762a(this.f25133e, this.f25134f, this.f25135g, this.f25136h);
        this.f25138j = C8017t.m38852a(c5630a.f18808a, C8009l.m38828c(), C7987q.m38759c(), this.f25137i);
        this.f25139k = C7986n.m38756a(this.f25130b, this.f25138j);
        this.f25140l = C7990x.m38767a(C8000c.m38800c());
        this.f25141m = C3085b.a(C8003f.m38809c());
        this.f25142n = C3085b.a(C8004g.m38812a(this.f25141m));
        this.f25143o = C7979c.m38727a(this.f25142n);
        this.f25144p = C3085b.a(this.f25143o);
        this.f25145q = ab.m38548a(this.f25130b);
        this.f25146r = C8016s.m38849a(c5630a.f18808a, C8009l.m38828c(), this.f25139k);
        this.f25147s = C7985l.m38753a(this.f25140l, this.f25145q, this.f25146r, this.f25138j, C8006i.m38818c());
        this.f25148t = C3085b.a(C7935c.m38554c());
        this.f25149u = new C70891(this);
        this.f25150v = C3085b.a(C7997o.m38788a(this.f25148t, this.f25149u));
        this.f25151w = C3085b.a(C7962e.m38679a(ab.m38744c()));
        this.f25152x = C7971q.m38705a(C8006i.m38818c());
        this.f25153y = C7973u.m38710a(this.f25140l, this.f25151w, this.f25152x);
        this.f25154z = C7961b.m38676a(C8009l.m38828c());
        this.f25115A = C7975w.m38715a(this.f25140l, this.f25151w, this.f25152x, this.f25154z);
        this.f25116B = C7977y.m38720a(this.f25140l, this.f25151w, this.f25154z);
        this.f25117C = C3085b.a(C8019v.m38858a(C8009l.m38828c(), this.f25153y, this.f25115A, this.f25116B));
        this.f25118D = C7964k.m38685a(this.f25140l, this.f25138j);
        this.f25119E = C7965m.m38688a(this.f25118D, C8006i.m38818c());
        this.f25120F = C8018u.m38855a(C8009l.m38828c(), this.f25118D, this.f25119E);
        this.f25121G = C7963g.m38682a(this.f25150v);
        this.f25122H = C3085b.a(C8001d.m38803c());
        this.f25123I = C3085b.a(C8007j.m38822c());
        this.f25124J = C8013p.m38840a(this.f25141m, this.f25122H, this.f25123I);
        this.f25125K = ae.m38551a(this.f25140l, this.f25144p, this.f25145q, ab.m38744c(), this.f25138j, this.f25147s, this.f25150v, this.f25117C, this.f25120F, this.f25121G, this.f25142n, this.f25124J);
        this.f25126L = C3085b.a(this.f25125K);
        this.f25127M = C3085b.a(C8002e.m38806a(this.f25122H));
        this.f25128N = C8005h.m38815a(c5630a.f18808a);
    }

    /* renamed from: a */
    public ac mo5037a() {
        return (ac) this.f25126L.a();
    }
}
