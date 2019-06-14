package com.facebook.ads.internal.p111r;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.internal.p105q.p106a.C1519s;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p105q.p106a.C1524x;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.r.a */
public class C1545a {
    /* renamed from: a */
    private static final String f4579a = "a";
    /* renamed from: b */
    private final View f4580b;
    /* renamed from: c */
    private final int f4581c;
    /* renamed from: d */
    private final int f4582d;
    /* renamed from: e */
    private final WeakReference<C1544a> f4583e;
    /* renamed from: f */
    private final Handler f4584f;
    /* renamed from: g */
    private final boolean f4585g;
    /* renamed from: h */
    private Runnable f4586h;
    /* renamed from: i */
    private int f4587i;
    /* renamed from: j */
    private int f4588j;
    /* renamed from: k */
    private boolean f4589k;
    /* renamed from: l */
    private C1546b f4590l;
    /* renamed from: m */
    private Map<String, Integer> f4591m;
    /* renamed from: n */
    private long f4592n;
    /* renamed from: o */
    private int f4593o;

    /* renamed from: com.facebook.ads.internal.r.a$a */
    public static abstract class C1544a {
        /* renamed from: a */
        public abstract void mo925a();

        /* renamed from: b */
        public void mo962b() {
        }
    }

    /* renamed from: com.facebook.ads.internal.r.a$b */
    private static final class C3609b extends C1524x<C1545a> {
        C3609b(C1545a c1545a) {
            super(c1545a);
        }

        public void run() {
            C1545a c1545a = (C1545a) m5347a();
            if (c1545a != null) {
                View a = c1545a.f4580b;
                C1544a c1544a = (C1544a) c1545a.f4583e.get();
                if (a != null) {
                    if (c1544a != null) {
                        C1546b a2 = C1545a.m5413a(a, c1545a.f4581c);
                        int i = 0;
                        if (a2.m5438a()) {
                            c1545a.f4593o = c1545a.f4593o + 1;
                        } else {
                            c1545a.f4593o = 0;
                        }
                        Object obj = c1545a.f4593o > c1545a.f4582d ? 1 : null;
                        Object obj2 = (c1545a.f4590l == null || !c1545a.f4590l.m5438a()) ? null : 1;
                        if (!(obj == null && a2.m5438a())) {
                            c1545a.f4590l = a2;
                        }
                        String valueOf = String.valueOf(a2.m5439b());
                        synchronized (c1545a) {
                            if (c1545a.f4591m.containsKey(valueOf)) {
                                i = ((Integer) c1545a.f4591m.get(valueOf)).intValue();
                            }
                            c1545a.f4591m.put(valueOf, Integer.valueOf(i + 1));
                        }
                        if (obj != null && obj2 == null) {
                            c1545a.f4592n = System.currentTimeMillis();
                            c1544a.mo925a();
                            if (!c1545a.f4585g) {
                                return;
                            }
                        } else if (obj == null && obj2 != null) {
                            c1544a.mo962b();
                        }
                        if (!(c1545a.f4589k || c1545a.f4586h == null)) {
                            c1545a.f4584f.postDelayed(c1545a.f4586h, (long) c1545a.f4588j);
                        }
                    }
                }
            }
        }
    }

    public C1545a(View view, int i, int i2, boolean z, C1544a c1544a) {
        this.f4584f = new Handler();
        this.f4587i = 0;
        this.f4588j = 1000;
        this.f4589k = true;
        this.f4590l = new C1546b(C1547c.UNKNOWN);
        this.f4591m = new HashMap();
        this.f4592n = 0;
        this.f4593o = 0;
        this.f4580b = view;
        if (this.f4580b.getId() == -1) {
            C1523w.m5341a(this.f4580b);
        }
        this.f4581c = i;
        this.f4583e = new WeakReference(c1544a);
        this.f4585g = z;
        if (i2 < 0) {
            i2 = 0;
        }
        this.f4582d = i2;
    }

    public C1545a(View view, int i, C1544a c1544a) {
        this(view, i, 0, false, c1544a);
    }

    public C1545a(View view, int i, boolean z, C1544a c1544a) {
        this(view, i, 0, z, c1544a);
    }

    /* renamed from: a */
    static float m5406a(View view) {
        float alpha = view.getAlpha();
        while (view.getParent() instanceof ViewGroup) {
            view = (View) view.getParent();
            float alpha2 = view.getAlpha();
            if (alpha2 < 0.0f) {
                alpha2 = 0.0f;
            }
            if (alpha2 > 1.0f) {
                alpha2 = 1.0f;
            }
            alpha *= alpha2;
        }
        return alpha;
    }

    /* renamed from: a */
    public static int m5407a(int i, View view) {
        int width = view.getWidth() * view.getHeight();
        float f = 100.0f;
        if (width > 0) {
            f = 100.0f / ((float) width);
        }
        return (int) Math.max((double) i, Math.ceil((double) f));
    }

    /* renamed from: a */
    private static int m5409a(Vector<Rect> vector) {
        int size = vector.size();
        int i = size * 2;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        boolean[][] zArr = (boolean[][]) Array.newInstance(boolean.class, new int[]{i, i});
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            Rect rect = (Rect) vector.elementAt(i2);
            int i5 = i3 + 1;
            iArr[i3] = rect.left;
            i3 = i4 + 1;
            iArr2[i4] = rect.bottom;
            i4 = i5 + 1;
            iArr[i5] = rect.right;
            i5 = i3 + 1;
            iArr2[i3] = rect.top;
            i2++;
            i3 = i4;
            i4 = i5;
        }
        Arrays.sort(iArr);
        Arrays.sort(iArr2);
        for (i2 = 0; i2 < size; i2++) {
            Rect rect2 = (Rect) vector.elementAt(i2);
            i4 = C1545a.m5410a(iArr, rect2.left);
            int a = C1545a.m5410a(iArr, rect2.right);
            i5 = C1545a.m5410a(iArr2, rect2.top);
            i3 = C1545a.m5410a(iArr2, rect2.bottom);
            for (i4++; i4 <= a; i4++) {
                for (int i6 = i5 + 1; i6 <= i3; i6++) {
                    zArr[i4][i6] = true;
                }
            }
        }
        int i7 = 0;
        size = 0;
        while (i7 < i) {
            i2 = size;
            for (size = 0; size < i; size++) {
                i2 += zArr[i7][size] ? (iArr[i7] - iArr[i7 - 1]) * (iArr2[size] - iArr2[size - 1]) : 0;
            }
            i7++;
            size = i2;
        }
        return size;
    }

    /* renamed from: a */
    private static int m5410a(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = ((length - i2) / 2) + i2;
            if (iArr[i3] == i) {
                return i3;
            }
            if (iArr[i3] > i) {
                length = i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static com.facebook.ads.internal.p111r.C1546b m5413a(android.view.View r18, int r19) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = r18;
        r1 = 0;
        r2 = 0;
        if (r0 != 0) goto L_0x0013;
    L_0x0006:
        r0 = "mAdView is null.";
        com.facebook.ads.internal.p111r.C1545a.m5415a(r1, r2, r0);
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.AD_IS_NULL;
        r0.<init>(r1);
        return r0;
    L_0x0013:
        r3 = r18.getParent();
        if (r3 != 0) goto L_0x0026;
    L_0x0019:
        r1 = "mAdView has no parent.";
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r2, r1);
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.INVALID_PARENT;
        r0.<init>(r1);
        return r0;
    L_0x0026:
        r3 = r18.isShown();
        if (r3 != 0) goto L_0x0039;
    L_0x002c:
        r1 = "mAdView parent is not set to VISIBLE.";
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r2, r1);
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.INVALID_PARENT;
        r0.<init>(r1);
        return r0;
    L_0x0039:
        r3 = r18.getWindowVisibility();
        if (r3 == 0) goto L_0x004c;
    L_0x003f:
        r1 = "mAdView window is not set to VISIBLE.";
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r2, r1);
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.INVALID_WINDOW;
        r0.<init>(r1);
        return r0;
    L_0x004c:
        r3 = r18.getMeasuredWidth();
        if (r3 <= 0) goto L_0x022b;
    L_0x0052:
        r3 = r18.getMeasuredHeight();
        if (r3 > 0) goto L_0x005a;
    L_0x0058:
        goto L_0x022b;
    L_0x005a:
        r3 = com.facebook.ads.internal.p111r.C1545a.m5406a(r18);
        r4 = 1063675494; // 0x3f666666 float:0.9 double:5.2552552E-315;
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r3 >= 0) goto L_0x0072;
    L_0x0065:
        r1 = "mAdView is too transparent.";
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r2, r1);
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.AD_IS_TRANSPARENT;
        r0.<init>(r1);
        return r0;
    L_0x0072:
        r3 = r18.getWidth();
        r4 = r18.getHeight();
        r5 = 2;
        r6 = new int[r5];
        r0.getLocationOnScreen(r6);	 Catch:{ NullPointerException -> 0x021e }
        r7 = new android.graphics.Rect;
        r7.<init>();
        r8 = r0.getGlobalVisibleRect(r7);
        if (r8 != 0) goto L_0x0093;
    L_0x008b:
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.AD_IS_NOT_VISIBLE;
        r0.<init>(r1);
        return r0;
    L_0x0093:
        r8 = r18.getContext();
        r9 = android.os.Build.VERSION.SDK_INT;
        r10 = 17;
        if (r9 < r10) goto L_0x00b2;
    L_0x009d:
        r9 = "window";
        r9 = r8.getSystemService(r9);
        r9 = (android.view.WindowManager) r9;
        r9 = r9.getDefaultDisplay();
        r10 = new android.util.DisplayMetrics;
        r10.<init>();
        r9.getRealMetrics(r10);
        goto L_0x00ba;
    L_0x00b2:
        r9 = r8.getResources();
        r10 = r9.getDisplayMetrics();
    L_0x00ba:
        r9 = com.facebook.ads.internal.p111r.C1545a.m5417b(r18);
        r11 = com.facebook.ads.internal.p111r.C1545a.m5409a(r9);
        r9.add(r7);
        r9 = com.facebook.ads.internal.p111r.C1545a.m5409a(r9);
        r9 = r9 - r11;
        r11 = r18.getMeasuredHeight();
        r12 = r18.getMeasuredWidth();
        r11 = r11 * r12;
        r9 = (float) r9;
        r12 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r9 = r9 * r12;
        r11 = (float) r11;
        r9 = r9 / r11;
        r11 = com.facebook.ads.internal.p097l.C1405a.m4840u(r8);
        r12 = r19;
        r12 = com.facebook.ads.internal.p111r.C1545a.m5407a(r12, r0);
        r13 = (float) r12;
        r14 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r13 = r13 / r14;
        r14 = 1;
        if (r11 == 0) goto L_0x0111;
    L_0x00ec:
        r3 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1));
        if (r3 >= 0) goto L_0x0154;
    L_0x00f0:
        r1 = java.util.Locale.US;
        r3 = "mAdView visible area is too small [%.2f%% visible, current threshold %.2f%%]";
        r4 = new java.lang.Object[r5];
        r5 = java.lang.Float.valueOf(r9);
        r4[r2] = r5;
        r5 = java.lang.Float.valueOf(r13);
        r4[r14] = r5;
        r1 = java.lang.String.format(r1, r3, r4);
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r2, r1);
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.AD_INSUFFICIENT_VISIBLE_AREA;
        r0.<init>(r1, r9);
        return r0;
    L_0x0111:
        r11 = r6[r2];
        if (r11 < 0) goto L_0x0210;
    L_0x0115:
        r10 = r10.widthPixels;
        r11 = r6[r2];
        r10 = r10 - r11;
        if (r10 >= r3) goto L_0x011e;
    L_0x011c:
        goto L_0x0210;
    L_0x011e:
        r10 = (double) r4;
        r1 = (double) r12;
        r16 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r1 = r16 - r1;
        r10 = r10 * r1;
        r10 = r10 / r16;
        r1 = (int) r10;
        r2 = r7.top;
        r3 = r6[r14];
        r2 = r2 - r3;
        if (r2 <= r1) goto L_0x013e;
    L_0x0130:
        r1 = "mAdView is not visible from the top.";
        r2 = 0;
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r2, r1);
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.AD_OFFSCREEN_TOP;
        r0.<init>(r1, r9);
        return r0;
    L_0x013e:
        r2 = 0;
        r3 = r6[r14];
        r3 = r3 + r4;
        r4 = r7.bottom;
        r3 = r3 - r4;
        if (r3 <= r1) goto L_0x0154;
    L_0x0147:
        r1 = "mAdView is not visible from the bottom.";
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r2, r1);
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.AD_OFFSCREEN_BOTTOM;
        r0.<init>(r1, r9);
        return r0;
    L_0x0154:
        r1 = com.facebook.ads.internal.p105q.p110e.C1542a.m5400b(r8);
        if (r1 != 0) goto L_0x0167;
    L_0x015a:
        r1 = "Screen is not interactive.";
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r2, r1);
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.SCREEN_NOT_INTERACTIVE;
        r0.<init>(r1, r9);
        return r0;
    L_0x0167:
        r1 = com.facebook.ads.internal.p105q.p110e.C1543b.m5401a(r8);
        r3 = com.facebook.ads.internal.p105q.p106a.C1525y.m5350b(r1);
        if (r3 == 0) goto L_0x017e;
    L_0x0171:
        r1 = "Keyguard is obstructing view.";
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r2, r1);
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.AD_IS_OBSTRUCTED_BY_KEYGUARD;
        r0.<init>(r1, r9);
        return r0;
    L_0x017e:
        r3 = com.facebook.ads.internal.p097l.C1405a.m4822c(r8);
        if (r3 == 0) goto L_0x0197;
    L_0x0184:
        r3 = com.facebook.ads.internal.p105q.p106a.C1525y.m5349a(r1);
        if (r3 == 0) goto L_0x0197;
    L_0x018a:
        r3 = "Ad is on top of the Lockscreen.";
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r2, r3);
        r0 = new com.facebook.ads.internal.r.b;
        r2 = com.facebook.ads.internal.p111r.C1547c.AD_IN_LOCKSCREEN;
        r0.<init>(r2, r9, r1);
        return r0;
    L_0x0197:
        r2 = com.facebook.ads.internal.p097l.C1405a.m4838s(r8);
        if (r2 == 0) goto L_0x01a3;
    L_0x019d:
        r2 = com.facebook.ads.internal.p111r.C1548d.m5443a(r18);
        r15 = r2;
        goto L_0x01a4;
    L_0x01a3:
        r15 = 0;
    L_0x01a4:
        if (r15 == 0) goto L_0x01d5;
    L_0x01a6:
        r2 = r15.floatValue();
        r3 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 != 0) goto L_0x01be;
    L_0x01b0:
        r1 = "mAdView is not in the top activity";
        r2 = 0;
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r2, r1);
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.AD_IS_NOT_IN_ACTIVITY;
        r0.<init>(r1);
        return r0;
    L_0x01be:
        r2 = 0;
        r3 = r15.floatValue();
        r4 = 0;
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r3 != 0) goto L_0x01d5;
    L_0x01c8:
        r1 = "mAdView is not visible";
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r2, r1);
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.AD_IS_NOT_VISIBLE;
        r0.<init>(r1);
        return r0;
    L_0x01d5:
        r2 = com.facebook.ads.internal.p097l.C1405a.m4839t(r8);
        if (r2 == 0) goto L_0x0203;
    L_0x01db:
        if (r15 == 0) goto L_0x0203;
    L_0x01dd:
        r2 = r15.floatValue();
        r2 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1));
        if (r2 >= 0) goto L_0x0203;
    L_0x01e5:
        r2 = java.util.Locale.US;
        r3 = "mAdView visible area is too small [%.2f%% visible, current threshold %.2f%%]";
        r4 = new java.lang.Object[r5];
        r5 = 0;
        r4[r5] = r15;
        r6 = java.lang.Float.valueOf(r13);
        r4[r14] = r6;
        r2 = java.lang.String.format(r2, r3, r4);
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r5, r2);
        r0 = new com.facebook.ads.internal.r.b;
        r2 = com.facebook.ads.internal.p111r.C1547c.AD_INSUFFICIENT_VISIBLE_AREA;
        r0.<init>(r2, r9, r1);
        return r0;
    L_0x0203:
        r2 = "mAdView is visible.";
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r14, r2);
        r0 = new com.facebook.ads.internal.r.b;
        r2 = com.facebook.ads.internal.p111r.C1547c.IS_VIEWABLE;
        r0.<init>(r2, r9, r1);
        return r0;
    L_0x0210:
        r1 = "mAdView is not fully on screen horizontally.";
        r2 = 0;
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r2, r1);
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.AD_OFFSCREEN_HORIZONTALLY;
        r0.<init>(r1, r9);
        return r0;
    L_0x021e:
        r1 = "Cannot get location on screen.";
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r2, r1);
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.INVALID_DIMENSIONS;
        r0.<init>(r1);
        return r0;
    L_0x022b:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "mAdView has invisible dimensions (w=";
        r1.append(r2);
        r2 = r18.getMeasuredWidth();
        r1.append(r2);
        r2 = ", h=";
        r1.append(r2);
        r2 = r18.getMeasuredHeight();
        r1.append(r2);
        r1 = r1.toString();
        r2 = 0;
        com.facebook.ads.internal.p111r.C1545a.m5415a(r0, r2, r1);
        r0 = new com.facebook.ads.internal.r.b;
        r1 = com.facebook.ads.internal.p111r.C1547c.INVALID_DIMENSIONS;
        r0.<init>(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.r.a.a(android.view.View, int):com.facebook.ads.internal.r.b");
    }

    /* renamed from: a */
    private static void m5415a(View view, boolean z, String str) {
    }

    /* renamed from: b */
    private static Vector<Rect> m5417b(View view) {
        Vector<Rect> vector = new Vector();
        if (!(view.getParent() instanceof ViewGroup)) {
            return vector;
        }
        View view2 = (ViewGroup) view.getParent();
        int indexOfChild = view2.indexOfChild(view);
        while (true) {
            indexOfChild++;
            if (indexOfChild < view2.getChildCount()) {
                vector.addAll(C1545a.m5419c(view2.getChildAt(indexOfChild)));
            } else {
                vector.addAll(C1545a.m5417b(view2));
                return vector;
            }
        }
    }

    /* renamed from: c */
    private static Vector<Rect> m5419c(View view) {
        Vector<Rect> vector = new Vector();
        if (view.isShown()) {
            if (VERSION.SDK_INT < 11 || view.getAlpha() > 0.0f) {
                if ((view instanceof ViewGroup) && C1545a.m5421d(view)) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        vector.addAll(C1545a.m5419c(viewGroup.getChildAt(i)));
                    }
                    return vector;
                }
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    vector.add(rect);
                }
            }
        }
        return vector;
    }

    /* renamed from: d */
    private static boolean m5421d(View view) {
        if (view.getBackground() != null) {
            if (VERSION.SDK_INT < 19 || view.getBackground().getAlpha() > 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public synchronized void m5431a() {
        if (this.f4586h != null) {
            m5436c();
        }
        this.f4586h = new C3609b(this);
        this.f4584f.postDelayed(this.f4586h, (long) this.f4587i);
        this.f4589k = false;
        this.f4593o = 0;
        this.f4590l = new C1546b(C1547c.UNKNOWN);
        this.f4591m = new HashMap();
    }

    /* renamed from: a */
    public void m5432a(int i) {
        this.f4587i = i;
    }

    /* renamed from: a */
    public synchronized void m5433a(Map<String, String> map) {
        map.put("vrc", String.valueOf(this.f4590l.m5439b()));
        map.put("vp", String.valueOf(this.f4590l.m5440c()));
        map.put("vh", new JSONObject(this.f4591m).toString());
        map.put("vt", C1519s.m5328a(this.f4592n));
        map.putAll(this.f4590l.m5441d());
    }

    /* renamed from: b */
    public void m5434b(int i) {
        this.f4588j = i;
    }

    /* renamed from: b */
    public synchronized boolean m5435b() {
        return this.f4589k;
    }

    /* renamed from: c */
    public synchronized void m5436c() {
        this.f4584f.removeCallbacks(this.f4586h);
        this.f4586h = null;
        this.f4589k = true;
        this.f4593o = 0;
    }

    /* renamed from: d */
    public synchronized String m5437d() {
        StringBuilder stringBuilder;
        C1547c c1547c = C1547c.values()[this.f4590l.m5439b()];
        stringBuilder = new StringBuilder();
        stringBuilder.append(c1547c.toString());
        stringBuilder.append(String.format(" (%.1f%%)", new Object[]{Float.valueOf(this.f4590l.m5440c() * 100.0f)}));
        return stringBuilder.toString();
    }
}
