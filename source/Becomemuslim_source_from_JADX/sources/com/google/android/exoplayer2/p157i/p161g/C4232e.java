package com.google.android.exoplayer2.p157i.p161g;

import android.support.v7.widget.LinearLayoutManager;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.util.Log;
import com.google.android.exoplayer2.p157i.C2458b;

/* compiled from: WebvttCue */
/* renamed from: com.google.android.exoplayer2.i.g.e */
public final class C4232e extends C2458b {
    /* renamed from: m */
    public final long f11137m;
    /* renamed from: n */
    public final long f11138n;

    /* compiled from: WebvttCue */
    /* renamed from: com.google.android.exoplayer2.i.g.e$1 */
    static /* synthetic */ class C24671 {
        /* renamed from: a */
        static final /* synthetic */ int[] f6272a = new int[Alignment.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r0 = android.text.Layout.Alignment.values();
            r0 = r0.length;
            r0 = new int[r0];
            f6272a = r0;
            r0 = f6272a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.text.Layout.Alignment.ALIGN_NORMAL;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f6272a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.text.Layout.Alignment.ALIGN_CENTER;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f6272a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.g.e.1.<clinit>():void");
        }
    }

    /* compiled from: WebvttCue */
    /* renamed from: com.google.android.exoplayer2.i.g.e$a */
    public static class C2468a {
        /* renamed from: a */
        private long f6273a;
        /* renamed from: b */
        private long f6274b;
        /* renamed from: c */
        private SpannableStringBuilder f6275c;
        /* renamed from: d */
        private Alignment f6276d;
        /* renamed from: e */
        private float f6277e;
        /* renamed from: f */
        private int f6278f;
        /* renamed from: g */
        private int f6279g;
        /* renamed from: h */
        private float f6280h;
        /* renamed from: i */
        private int f6281i;
        /* renamed from: j */
        private float f6282j;

        public C2468a() {
            m6880a();
        }

        /* renamed from: a */
        public void m6880a() {
            this.f6273a = 0;
            this.f6274b = 0;
            this.f6275c = null;
            this.f6276d = null;
            this.f6277e = Float.MIN_VALUE;
            this.f6278f = LinearLayoutManager.INVALID_OFFSET;
            this.f6279g = LinearLayoutManager.INVALID_OFFSET;
            this.f6280h = Float.MIN_VALUE;
            this.f6281i = LinearLayoutManager.INVALID_OFFSET;
            this.f6282j = Float.MIN_VALUE;
        }

        /* renamed from: b */
        public C4232e m6884b() {
            if (this.f6280h != Float.MIN_VALUE && this.f6281i == LinearLayoutManager.INVALID_OFFSET) {
                m6874c();
            }
            return new C4232e(this.f6273a, this.f6274b, this.f6275c, this.f6276d, this.f6277e, this.f6278f, this.f6279g, this.f6280h, this.f6281i, this.f6282j);
        }

        /* renamed from: a */
        public C2468a m6877a(long j) {
            this.f6273a = j;
            return this;
        }

        /* renamed from: b */
        public C2468a m6883b(long j) {
            this.f6274b = j;
            return this;
        }

        /* renamed from: a */
        public C2468a m6879a(SpannableStringBuilder spannableStringBuilder) {
            this.f6275c = spannableStringBuilder;
            return this;
        }

        /* renamed from: a */
        public C2468a m6878a(Alignment alignment) {
            this.f6276d = alignment;
            return this;
        }

        /* renamed from: a */
        public C2468a m6875a(float f) {
            this.f6277e = f;
            return this;
        }

        /* renamed from: a */
        public C2468a m6876a(int i) {
            this.f6278f = i;
            return this;
        }

        /* renamed from: b */
        public C2468a m6882b(int i) {
            this.f6279g = i;
            return this;
        }

        /* renamed from: b */
        public C2468a m6881b(float f) {
            this.f6280h = f;
            return this;
        }

        /* renamed from: c */
        public C2468a m6886c(int i) {
            this.f6281i = i;
            return this;
        }

        /* renamed from: c */
        public C2468a m6885c(float f) {
            this.f6282j = f;
            return this;
        }

        /* renamed from: c */
        private C2468a m6874c() {
            if (this.f6276d != null) {
                switch (C24671.f6272a[this.f6276d.ordinal()]) {
                    case 1:
                        this.f6281i = 0;
                        break;
                    case 2:
                        this.f6281i = 1;
                        break;
                    case 3:
                        this.f6281i = 2;
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unrecognized alignment: ");
                        stringBuilder.append(this.f6276d);
                        Log.w("WebvttCueBuilder", stringBuilder.toString());
                        this.f6281i = 0;
                        break;
                }
            }
            this.f6281i = LinearLayoutManager.INVALID_OFFSET;
            return this;
        }
    }

    public C4232e(CharSequence charSequence) {
        this(0, 0, charSequence);
    }

    public C4232e(long j, long j2, CharSequence charSequence) {
        this(j, j2, charSequence, null, Float.MIN_VALUE, LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET, Float.MIN_VALUE, LinearLayoutManager.INVALID_OFFSET, Float.MIN_VALUE);
    }

    public C4232e(long j, long j2, CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3);
        this.f11137m = j;
        this.f11138n = j2;
    }

    /* renamed from: a */
    public boolean m13720a() {
        return this.d == Float.MIN_VALUE && this.g == Float.MIN_VALUE;
    }
}
