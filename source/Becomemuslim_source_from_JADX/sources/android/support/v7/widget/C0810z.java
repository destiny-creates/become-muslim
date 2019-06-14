package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.C0534b;
import android.support.v7.p035a.C0591a.C0590j;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* compiled from: AppCompatTextHelper */
/* renamed from: android.support.v7.widget.z */
class C0810z {
    /* renamed from: a */
    final TextView f2252a;
    /* renamed from: b */
    private bo f2253b;
    /* renamed from: c */
    private bo f2254c;
    /* renamed from: d */
    private bo f2255d;
    /* renamed from: e */
    private bo f2256e;
    /* renamed from: f */
    private final ab f2257f;
    /* renamed from: g */
    private int f2258g = 0;
    /* renamed from: h */
    private Typeface f2259h;
    /* renamed from: i */
    private boolean f2260i;

    /* renamed from: a */
    static C0810z m2939a(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new aa(textView);
        }
        return new C0810z(textView);
    }

    C0810z(TextView textView) {
        this.f2252a = textView;
        this.f2257f = new ab(this.f2252a);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    void mo604a(AttributeSet attributeSet, int i) {
        bq a;
        Object obj;
        boolean z;
        ColorStateList e;
        ColorStateList e2;
        Context context = this.f2252a.getContext();
        C0799m a2 = C0799m.m2896a();
        bq a3 = bq.m2769a(context, attributeSet, C0590j.AppCompatTextHelper, i, 0);
        int g = a3.m2786g(C0590j.AppCompatTextHelper_android_textAppearance, -1);
        if (a3.m2787g(C0590j.AppCompatTextHelper_android_drawableLeft)) {
            this.f2253b = C0810z.m2938a(context, a2, a3.m2786g(C0590j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a3.m2787g(C0590j.AppCompatTextHelper_android_drawableTop)) {
            this.f2254c = C0810z.m2938a(context, a2, a3.m2786g(C0590j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a3.m2787g(C0590j.AppCompatTextHelper_android_drawableRight)) {
            this.f2255d = C0810z.m2938a(context, a2, a3.m2786g(C0590j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a3.m2787g(C0590j.AppCompatTextHelper_android_drawableBottom)) {
            this.f2256e = C0810z.m2938a(context, a2, a3.m2786g(C0590j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        a3.m2774a();
        boolean z2 = this.f2252a.getTransformationMethod() instanceof PasswordTransformationMethod;
        Object obj2 = 1;
        ColorStateList colorStateList = null;
        if (g != -1) {
            a = bq.m2767a(context, g, C0590j.TextAppearance);
            if (z2 || !a.m2787g(C0590j.TextAppearance_textAllCaps)) {
                obj = null;
                z = false;
            } else {
                z = a.m2775a(C0590j.TextAppearance_textAllCaps, false);
                obj = 1;
            }
            m2940a(context, a);
            if (VERSION.SDK_INT < 23) {
                e = a.m2787g(C0590j.TextAppearance_android_textColor) ? a.m2783e(C0590j.TextAppearance_android_textColor) : null;
                e2 = a.m2787g(C0590j.TextAppearance_android_textColorHint) ? a.m2783e(C0590j.TextAppearance_android_textColorHint) : null;
                if (a.m2787g(C0590j.TextAppearance_android_textColorLink)) {
                    colorStateList = a.m2783e(C0590j.TextAppearance_android_textColorLink);
                }
                ColorStateList colorStateList2 = e;
                e = colorStateList;
                colorStateList = colorStateList2;
            } else {
                e = null;
                e2 = e;
            }
            a.m2774a();
        } else {
            e = null;
            e2 = e;
            obj = null;
            z = false;
        }
        a = bq.m2769a(context, attributeSet, C0590j.TextAppearance, i, 0);
        if (z2 || !a.m2787g(C0590j.TextAppearance_textAllCaps)) {
            obj2 = obj;
        } else {
            z = a.m2775a(C0590j.TextAppearance_textAllCaps, false);
        }
        if (VERSION.SDK_INT < 23) {
            if (a.m2787g(C0590j.TextAppearance_android_textColor)) {
                colorStateList = a.m2783e(C0590j.TextAppearance_android_textColor);
            }
            if (a.m2787g(C0590j.TextAppearance_android_textColorHint)) {
                e2 = a.m2783e(C0590j.TextAppearance_android_textColorHint);
            }
            if (a.m2787g(C0590j.TextAppearance_android_textColorLink)) {
                e = a.m2783e(C0590j.TextAppearance_android_textColorLink);
            }
        }
        m2940a(context, a);
        a.m2774a();
        if (colorStateList != null) {
            this.f2252a.setTextColor(colorStateList);
        }
        if (e2 != null) {
            this.f2252a.setHintTextColor(e2);
        }
        if (e != null) {
            this.f2252a.setLinkTextColor(e);
        }
        if (!(z2 || r2 == null)) {
            m2951a(z);
        }
        if (this.f2259h != null) {
            this.f2252a.setTypeface(this.f2259h, this.f2258g);
        }
        this.f2257f.m2504a(attributeSet, i);
        if (C0534b.f1339a != null && this.f2257f.m2500a() != null) {
            attributeSet = this.f2257f.m2509e();
            if (attributeSet.length <= 0) {
                return;
            }
            if (((float) this.f2252a.getAutoSizeStepGranularity()) != -1082130432) {
                this.f2252a.setAutoSizeTextTypeUniformWithConfiguration(this.f2257f.m2507c(), this.f2257f.m2508d(), this.f2257f.m2506b(), 0);
            } else {
                this.f2252a.setAutoSizeTextTypeUniformWithPresetSizes(attributeSet, 0);
            }
        }
    }

    /* renamed from: a */
    private void m2940a(android.content.Context r5, android.support.v7.widget.bq r6) {
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
        r4 = this;
        r0 = android.support.v7.p035a.C0591a.C0590j.TextAppearance_android_textStyle;
        r1 = r4.f2258g;
        r0 = r6.m2771a(r0, r1);
        r4.f2258g = r0;
        r0 = android.support.v7.p035a.C0591a.C0590j.TextAppearance_android_fontFamily;
        r0 = r6.m2787g(r0);
        r1 = 1;
        r2 = 0;
        if (r0 != 0) goto L_0x0040;
    L_0x0014:
        r0 = android.support.v7.p035a.C0591a.C0590j.TextAppearance_fontFamily;
        r0 = r6.m2787g(r0);
        if (r0 == 0) goto L_0x001d;
    L_0x001c:
        goto L_0x0040;
    L_0x001d:
        r5 = android.support.v7.p035a.C0591a.C0590j.TextAppearance_android_typeface;
        r5 = r6.m2787g(r5);
        if (r5 == 0) goto L_0x003f;
    L_0x0025:
        r4.f2260i = r2;
        r5 = android.support.v7.p035a.C0591a.C0590j.TextAppearance_android_typeface;
        r5 = r6.m2771a(r5, r1);
        switch(r5) {
            case 1: goto L_0x003b;
            case 2: goto L_0x0036;
            case 3: goto L_0x0031;
            default: goto L_0x0030;
        };
    L_0x0030:
        goto L_0x003f;
    L_0x0031:
        r5 = android.graphics.Typeface.MONOSPACE;
        r4.f2259h = r5;
        goto L_0x003f;
    L_0x0036:
        r5 = android.graphics.Typeface.SERIF;
        r4.f2259h = r5;
        goto L_0x003f;
    L_0x003b:
        r5 = android.graphics.Typeface.SANS_SERIF;
        r4.f2259h = r5;
    L_0x003f:
        return;
    L_0x0040:
        r0 = 0;
        r4.f2259h = r0;
        r0 = android.support.v7.p035a.C0591a.C0590j.TextAppearance_fontFamily;
        r0 = r6.m2787g(r0);
        if (r0 == 0) goto L_0x004e;
    L_0x004b:
        r0 = android.support.v7.p035a.C0591a.C0590j.TextAppearance_fontFamily;
        goto L_0x0050;
    L_0x004e:
        r0 = android.support.v7.p035a.C0591a.C0590j.TextAppearance_android_fontFamily;
    L_0x0050:
        r5 = r5.isRestricted();
        if (r5 != 0) goto L_0x0074;
    L_0x0056:
        r5 = new java.lang.ref.WeakReference;
        r3 = r4.f2252a;
        r5.<init>(r3);
        r3 = new android.support.v7.widget.z$1;
        r3.<init>(r4, r5);
        r5 = r4.f2258g;	 Catch:{ UnsupportedOperationException -> 0x0073, UnsupportedOperationException -> 0x0073 }
        r5 = r6.m2772a(r0, r5, r3);	 Catch:{ UnsupportedOperationException -> 0x0073, UnsupportedOperationException -> 0x0073 }
        r4.f2259h = r5;	 Catch:{ UnsupportedOperationException -> 0x0073, UnsupportedOperationException -> 0x0073 }
        r5 = r4.f2259h;	 Catch:{ UnsupportedOperationException -> 0x0073, UnsupportedOperationException -> 0x0073 }
        if (r5 != 0) goto L_0x006f;	 Catch:{ UnsupportedOperationException -> 0x0073, UnsupportedOperationException -> 0x0073 }
    L_0x006e:
        goto L_0x0070;	 Catch:{ UnsupportedOperationException -> 0x0073, UnsupportedOperationException -> 0x0073 }
    L_0x006f:
        r1 = 0;	 Catch:{ UnsupportedOperationException -> 0x0073, UnsupportedOperationException -> 0x0073 }
    L_0x0070:
        r4.f2260i = r1;	 Catch:{ UnsupportedOperationException -> 0x0073, UnsupportedOperationException -> 0x0073 }
        goto L_0x0074;
    L_0x0074:
        r5 = r4.f2259h;
        if (r5 != 0) goto L_0x0086;
    L_0x0078:
        r5 = r6.m2781d(r0);
        if (r5 == 0) goto L_0x0086;
    L_0x007e:
        r6 = r4.f2258g;
        r5 = android.graphics.Typeface.create(r5, r6);
        r4.f2259h = r5;
    L_0x0086:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.z.a(android.content.Context, android.support.v7.widget.bq):void");
    }

    /* renamed from: a */
    private void m2942a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f2260i) {
            this.f2259h = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f2258g);
            }
        }
    }

    /* renamed from: a */
    void m2948a(Context context, int i) {
        bq a = bq.m2767a(context, i, C0590j.TextAppearance);
        if (a.m2787g(C0590j.TextAppearance_textAllCaps)) {
            m2951a(a.m2775a(C0590j.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && a.m2787g(C0590j.TextAppearance_android_textColor)) {
            ColorStateList e = a.m2783e(C0590j.TextAppearance_android_textColor);
            if (e != null) {
                this.f2252a.setTextColor(e);
            }
        }
        m2940a(context, a);
        a.m2774a();
        if (this.f2259h != null) {
            this.f2252a.setTypeface(this.f2259h, this.f2258g);
        }
    }

    /* renamed from: a */
    void m2951a(boolean z) {
        this.f2252a.setAllCaps(z);
    }

    /* renamed from: a */
    void mo603a() {
        if (this.f2253b != null || this.f2254c != null || this.f2255d != null || this.f2256e != null) {
            Drawable[] compoundDrawables = this.f2252a.getCompoundDrawables();
            m2949a(compoundDrawables[0], this.f2253b);
            m2949a(compoundDrawables[1], this.f2254c);
            m2949a(compoundDrawables[2], this.f2255d);
            m2949a(compoundDrawables[3], this.f2256e);
        }
    }

    /* renamed from: a */
    final void m2949a(Drawable drawable, bo boVar) {
        if (drawable != null && boVar != null) {
            C0799m.m2899a(drawable, boVar, this.f2252a.getDrawableState());
        }
    }

    /* renamed from: a */
    protected static bo m2938a(Context context, C0799m c0799m, int i) {
        context = c0799m.m2919b(context, i);
        if (context == null) {
            return null;
        }
        c0799m = new bo();
        c0799m.f2136d = true;
        c0799m.f2133a = context;
        return c0799m;
    }

    /* renamed from: a */
    void m2952a(boolean z, int i, int i2, int i3, int i4) {
        if (!C0534b.f1339a) {
            m2954b();
        }
    }

    /* renamed from: a */
    void m2946a(int i, float f) {
        if (!C0534b.f1339a && !m2955c()) {
            m2943b(i, f);
        }
    }

    /* renamed from: b */
    void m2954b() {
        this.f2257f.m2510f();
    }

    /* renamed from: c */
    boolean m2955c() {
        return this.f2257f.m2511g();
    }

    /* renamed from: b */
    private void m2943b(int i, float f) {
        this.f2257f.m2502a(i, f);
    }

    /* renamed from: a */
    void m2945a(int i) {
        this.f2257f.m2501a(i);
    }

    /* renamed from: a */
    void m2947a(int i, int i2, int i3, int i4) {
        this.f2257f.m2503a(i, i2, i3, i4);
    }

    /* renamed from: a */
    void m2953a(int[] iArr, int i) {
        this.f2257f.m2505a(iArr, i);
    }

    /* renamed from: d */
    int m2956d() {
        return this.f2257f.m2500a();
    }

    /* renamed from: e */
    int m2957e() {
        return this.f2257f.m2506b();
    }

    /* renamed from: f */
    int m2958f() {
        return this.f2257f.m2507c();
    }

    /* renamed from: g */
    int m2959g() {
        return this.f2257f.m2508d();
    }

    /* renamed from: h */
    int[] m2960h() {
        return this.f2257f.m2509e();
    }
}
