package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.p016d.p017a.C4440c;
import android.support.p016d.p017a.C4441i;
import android.support.v4.content.C0366b;
import android.support.v4.p020a.C0264a;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v4.util.C0452f;
import android.support.v4.util.C0453g;
import android.support.v4.util.C0464m;
import android.support.v4.util.C3211a;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0583c;
import android.support.v7.p035a.C0591a.C0585e;
import android.support.v7.p037c.p038a.C0631b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AppCompatDrawableManager */
/* renamed from: android.support.v7.widget.m */
public final class C0799m {
    /* renamed from: a */
    private static final Mode f2218a = Mode.SRC_IN;
    /* renamed from: b */
    private static C0799m f2219b;
    /* renamed from: c */
    private static final C3324b f2220c = new C3324b(6);
    /* renamed from: d */
    private static final int[] f2221d = new int[]{C0585e.abc_textfield_search_default_mtrl_alpha, C0585e.abc_textfield_default_mtrl_alpha, C0585e.abc_ab_share_pack_mtrl_alpha};
    /* renamed from: e */
    private static final int[] f2222e = new int[]{C0585e.abc_ic_commit_search_api_mtrl_alpha, C0585e.abc_seekbar_tick_mark_material, C0585e.abc_ic_menu_share_mtrl_alpha, C0585e.abc_ic_menu_copy_mtrl_am_alpha, C0585e.abc_ic_menu_cut_mtrl_alpha, C0585e.abc_ic_menu_selectall_mtrl_alpha, C0585e.abc_ic_menu_paste_mtrl_am_alpha};
    /* renamed from: f */
    private static final int[] f2223f = new int[]{C0585e.abc_textfield_activated_mtrl_alpha, C0585e.abc_textfield_search_activated_mtrl_alpha, C0585e.abc_cab_background_top_mtrl_alpha, C0585e.abc_text_cursor_material, C0585e.abc_text_select_handle_left_mtrl_dark, C0585e.abc_text_select_handle_middle_mtrl_dark, C0585e.abc_text_select_handle_right_mtrl_dark, C0585e.abc_text_select_handle_left_mtrl_light, C0585e.abc_text_select_handle_middle_mtrl_light, C0585e.abc_text_select_handle_right_mtrl_light};
    /* renamed from: g */
    private static final int[] f2224g = new int[]{C0585e.abc_popup_background_mtrl_mult, C0585e.abc_cab_background_internal_bg, C0585e.abc_menu_hardkey_panel_mtrl_mult};
    /* renamed from: h */
    private static final int[] f2225h = new int[]{C0585e.abc_tab_indicator_material, C0585e.abc_textfield_search_material};
    /* renamed from: i */
    private static final int[] f2226i = new int[]{C0585e.abc_btn_check_material, C0585e.abc_btn_radio_material};
    /* renamed from: j */
    private WeakHashMap<Context, C0464m<ColorStateList>> f2227j;
    /* renamed from: k */
    private C3211a<String, C0798c> f2228k;
    /* renamed from: l */
    private C0464m<String> f2229l;
    /* renamed from: m */
    private final Object f2230m = new Object();
    /* renamed from: n */
    private final WeakHashMap<Context, C0452f<WeakReference<ConstantState>>> f2231n = new WeakHashMap(0);
    /* renamed from: o */
    private TypedValue f2232o;
    /* renamed from: p */
    private boolean f2233p;

    /* compiled from: AppCompatDrawableManager */
    /* renamed from: android.support.v7.widget.m$c */
    private interface C0798c {
        /* renamed from: a */
        Drawable mo707a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    /* compiled from: AppCompatDrawableManager */
    /* renamed from: android.support.v7.widget.m$a */
    private static class C3323a implements C0798c {
        C3323a() {
        }

        /* renamed from: a */
        public Drawable mo707a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C4440c.m14750a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Context context2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", context2);
                return null;
            }
        }
    }

    /* compiled from: AppCompatDrawableManager */
    /* renamed from: android.support.v7.widget.m$b */
    private static class C3324b extends C0453g<Integer, PorterDuffColorFilter> {
        public C3324b(int i) {
            super(i);
        }

        /* renamed from: a */
        PorterDuffColorFilter m10623a(int i, Mode mode) {
            return (PorterDuffColorFilter) m1423a((Object) Integer.valueOf(C3324b.m10622b(i, mode)));
        }

        /* renamed from: a */
        PorterDuffColorFilter m10624a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) m1424a(Integer.valueOf(C3324b.m10622b(i, mode)), porterDuffColorFilter);
        }

        /* renamed from: b */
        private static int m10622b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    /* compiled from: AppCompatDrawableManager */
    /* renamed from: android.support.v7.widget.m$d */
    private static class C3325d implements C0798c {
        C3325d() {
        }

        /* renamed from: a */
        public Drawable mo707a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C4441i.m14756a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Context context2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", context2);
                return null;
            }
        }
    }

    /* renamed from: a */
    public static C0799m m2896a() {
        if (f2219b == null) {
            f2219b = new C0799m();
            C0799m.m2900a(f2219b);
        }
        return f2219b;
    }

    /* renamed from: a */
    private static void m2900a(C0799m c0799m) {
        if (VERSION.SDK_INT < 24) {
            c0799m.m2901a("vector", new C3325d());
            c0799m.m2901a("animated-vector", new C3323a());
        }
    }

    /* renamed from: a */
    public Drawable m2915a(Context context, int i) {
        return m2916a(context, i, false);
    }

    /* renamed from: a */
    Drawable m2916a(Context context, int i, boolean z) {
        m2914f(context);
        Drawable d = m2910d(context, i);
        if (d == null) {
            d = m2908c(context, i);
        }
        if (d == null) {
            d = C0366b.m1103a(context, i);
        }
        if (d != null) {
            d = m2894a(context, i, z, d);
        }
        if (d != null) {
            al.m2614b(d);
        }
        return d;
    }

    /* renamed from: a */
    public void m2918a(Context context) {
        synchronized (this.f2230m) {
            C0452f c0452f = (C0452f) this.f2231n.get(context);
            if (c0452f != null) {
                c0452f.m1421c();
            }
        }
    }

    /* renamed from: a */
    private static long m2890a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    /* renamed from: c */
    private Drawable m2908c(Context context, int i) {
        if (this.f2232o == null) {
            this.f2232o = new TypedValue();
        }
        TypedValue typedValue = this.f2232o;
        context.getResources().getValue(i, typedValue, true);
        long a = C0799m.m2890a(typedValue);
        Drawable a2 = m2895a(context, a);
        if (a2 != null) {
            return a2;
        }
        if (i == C0585e.abc_cab_background_top_material) {
            a2 = new LayerDrawable(new Drawable[]{m2915a(context, C0585e.abc_cab_background_internal_bg), m2915a(context, C0585e.abc_cab_background_top_mtrl_alpha)});
        }
        if (a2 != null) {
            a2.setChangingConfigurations(typedValue.changingConfigurations);
            m2903a(context, a, a2);
        }
        return a2;
    }

    /* renamed from: a */
    private Drawable m2894a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = m2919b(context, i);
        if (b != null) {
            if (al.m2615c(drawable) != null) {
                drawable = drawable.mutate();
            }
            drawable = C0259a.m703g(drawable);
            C0259a.m692a(drawable, b);
            Mode a = C0799m.m2891a(i);
            if (a == null) {
                return drawable;
            }
            C0259a.m695a(drawable, a);
            return drawable;
        } else if (i == C0585e.abc_seekbar_track_material) {
            r6 = (LayerDrawable) drawable;
            C0799m.m2898a(r6.findDrawableByLayerId(16908288), bl.m2757a(context, C0581a.colorControlNormal), f2218a);
            C0799m.m2898a(r6.findDrawableByLayerId(16908303), bl.m2757a(context, C0581a.colorControlNormal), f2218a);
            C0799m.m2898a(r6.findDrawableByLayerId(16908301), bl.m2757a(context, C0581a.colorControlActivated), f2218a);
            return drawable;
        } else {
            if (!(i == C0585e.abc_ratingbar_material || i == C0585e.abc_ratingbar_indicator_material)) {
                if (i != C0585e.abc_ratingbar_small_material) {
                    if (C0799m.m2902a(context, i, drawable) == null && z) {
                        return null;
                    }
                    return drawable;
                }
            }
            r6 = (LayerDrawable) drawable;
            C0799m.m2898a(r6.findDrawableByLayerId(16908288), bl.m2761c(context, C0581a.colorControlNormal), f2218a);
            C0799m.m2898a(r6.findDrawableByLayerId(16908303), bl.m2757a(context, C0581a.colorControlActivated), f2218a);
            C0799m.m2898a(r6.findDrawableByLayerId(16908301), bl.m2757a(context, C0581a.colorControlActivated), f2218a);
            return drawable;
        }
    }

    /* renamed from: d */
    private Drawable m2910d(Context context, int i) {
        if (this.f2228k == null || this.f2228k.isEmpty()) {
            return null;
        }
        if (this.f2229l != null) {
            String str = (String) this.f2229l.m1467a(i);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f2228k.get(str) == null)) {
                return null;
            }
        }
        this.f2229l = new C0464m();
        if (this.f2232o == null) {
            this.f2232o = new TypedValue();
        }
        TypedValue typedValue = this.f2232o;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long a = C0799m.m2890a(typedValue);
        Drawable a2 = m2895a(context, a);
        if (a2 != null) {
            return a2;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                int next;
                String name;
                C0798c c0798c;
                XmlPullParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        if (next != 2) {
                            name = xml.getName();
                            this.f2229l.m1474c(i, name);
                            c0798c = (C0798c) this.f2228k.get(name);
                            if (c0798c != null) {
                                a2 = c0798c.mo707a(context, xml, asAttributeSet, context.getTheme());
                            }
                            if (a2 != null) {
                                a2.setChangingConfigurations(typedValue.changingConfigurations);
                                m2903a(context, a, a2);
                            }
                        } else {
                            throw new XmlPullParserException("No start tag found");
                        }
                    }
                }
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                name = xml.getName();
                this.f2229l.m1474c(i, name);
                c0798c = (C0798c) this.f2228k.get(name);
                if (c0798c != null) {
                    a2 = c0798c.mo707a(context, xml, asAttributeSet, context.getTheme());
                }
                if (a2 != null) {
                    a2.setChangingConfigurations(typedValue.changingConfigurations);
                    m2903a(context, a, a2);
                }
            } catch (Context context2) {
                Log.e("AppCompatDrawableManag", "Exception while inflating drawable", context2);
            }
        }
        if (a2 == null) {
            this.f2229l.m1474c(i, "appcompat_skip_skip");
        }
        return a2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private android.graphics.drawable.Drawable m2895a(android.content.Context r5, long r6) {
        /*
        r4 = this;
        r0 = r4.f2230m;
        monitor-enter(r0);
        r1 = r4.f2231n;	 Catch:{ all -> 0x002f }
        r1 = r1.get(r5);	 Catch:{ all -> 0x002f }
        r1 = (android.support.v4.util.C0452f) r1;	 Catch:{ all -> 0x002f }
        r2 = 0;
        if (r1 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        return r2;
    L_0x0010:
        r3 = r1.m1412a(r6);	 Catch:{ all -> 0x002f }
        r3 = (java.lang.ref.WeakReference) r3;	 Catch:{ all -> 0x002f }
        if (r3 == 0) goto L_0x002d;
    L_0x0018:
        r3 = r3.get();	 Catch:{ all -> 0x002f }
        r3 = (android.graphics.drawable.Drawable.ConstantState) r3;	 Catch:{ all -> 0x002f }
        if (r3 == 0) goto L_0x002a;
    L_0x0020:
        r5 = r5.getResources();	 Catch:{ all -> 0x002f }
        r5 = r3.newDrawable(r5);	 Catch:{ all -> 0x002f }
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        return r5;
    L_0x002a:
        r1.m1417b(r6);	 Catch:{ all -> 0x002f }
    L_0x002d:
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        return r2;
    L_0x002f:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.m.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    /* renamed from: a */
    private boolean m2903a(Context context, long j, Drawable drawable) {
        drawable = drawable.getConstantState();
        if (drawable == null) {
            return null;
        }
        synchronized (this.f2230m) {
            C0452f c0452f = (C0452f) this.f2231n.get(context);
            if (c0452f == null) {
                c0452f = new C0452f();
                this.f2231n.put(context, c0452f);
            }
            c0452f.m1418b(j, new WeakReference(drawable));
        }
        return true;
    }

    /* renamed from: a */
    Drawable m2917a(Context context, bv bvVar, int i) {
        Drawable d = m2910d(context, i);
        if (d == null) {
            d = bvVar.m2803a(i);
        }
        return d != null ? m2894a(context, i, null, d) : null;
    }

    /* renamed from: a */
    static boolean m2902a(Context context, int i, Drawable drawable) {
        int round;
        Mode mode = f2218a;
        int i2 = 16842801;
        if (C0799m.m2905a(f2221d, i)) {
            i2 = C0581a.colorControlNormal;
        } else if (C0799m.m2905a(f2223f, i)) {
            i2 = C0581a.colorControlActivated;
        } else if (C0799m.m2905a(f2224g, i)) {
            mode = Mode.MULTIPLY;
        } else {
            if (i == C0585e.abc_list_divider_mtrl_alpha) {
                i2 = 16842800;
                round = Math.round(1109603123);
                i = 1;
            } else if (i != C0585e.abc_dialog_material_background) {
                i = 0;
                round = -1;
                i2 = 0;
            }
            if (i != 0) {
                return false;
            }
            if (al.m2615c(drawable) != 0) {
                drawable = drawable.mutate();
            }
            drawable.setColorFilter(C0799m.m2892a(bl.m2757a(context, i2), mode));
            if (round != -1) {
                drawable.setAlpha(round);
            }
            return true;
        }
        i = 1;
        round = -1;
        if (i != 0) {
            return false;
        }
        if (al.m2615c(drawable) != 0) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(C0799m.m2892a(bl.m2757a(context, i2), mode));
        if (round != -1) {
            drawable.setAlpha(round);
        }
        return true;
    }

    /* renamed from: a */
    private void m2901a(String str, C0798c c0798c) {
        if (this.f2228k == null) {
            this.f2228k = new C3211a();
        }
        this.f2228k.put(str, c0798c);
    }

    /* renamed from: a */
    private static boolean m2905a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return 1;
            }
        }
        return false;
    }

    /* renamed from: a */
    static Mode m2891a(int i) {
        return i == C0585e.abc_switch_thumb_material ? Mode.MULTIPLY : 0;
    }

    /* renamed from: b */
    ColorStateList m2919b(Context context, int i) {
        ColorStateList e = m2912e(context, i);
        if (e == null) {
            if (i == C0585e.abc_edit_text_material) {
                e = C0631b.m2109a(context, C0583c.abc_tint_edittext);
            } else if (i == C0585e.abc_switch_track_mtrl_alpha) {
                e = C0631b.m2109a(context, C0583c.abc_tint_switch_track);
            } else if (i == C0585e.abc_switch_thumb_material) {
                e = m2911e(context);
            } else if (i == C0585e.abc_btn_default_mtrl_shape) {
                e = m2906b(context);
            } else if (i == C0585e.abc_btn_borderless_material) {
                e = m2907c(context);
            } else if (i == C0585e.abc_btn_colored_material) {
                e = m2909d(context);
            } else {
                if (i != C0585e.abc_spinner_mtrl_am_alpha) {
                    if (i != C0585e.abc_spinner_textfield_background_material) {
                        if (C0799m.m2905a(f2222e, i)) {
                            e = bl.m2760b(context, C0581a.colorControlNormal);
                        } else if (C0799m.m2905a(f2225h, i)) {
                            e = C0631b.m2109a(context, C0583c.abc_tint_default);
                        } else if (C0799m.m2905a(f2226i, i)) {
                            e = C0631b.m2109a(context, C0583c.abc_tint_btn_checkable);
                        } else if (i == C0585e.abc_seekbar_thumb_material) {
                            e = C0631b.m2109a(context, C0583c.abc_tint_seek_thumb);
                        }
                    }
                }
                e = C0631b.m2109a(context, C0583c.abc_tint_spinner);
            }
            if (e != null) {
                m2897a(context, i, e);
            }
        }
        return e;
    }

    /* renamed from: e */
    private ColorStateList m2912e(Context context, int i) {
        ColorStateList colorStateList = null;
        if (this.f2227j == null) {
            return null;
        }
        C0464m c0464m = (C0464m) this.f2227j.get(context);
        if (c0464m != null) {
            colorStateList = (ColorStateList) c0464m.m1467a(i);
        }
        return colorStateList;
    }

    /* renamed from: a */
    private void m2897a(Context context, int i, ColorStateList colorStateList) {
        if (this.f2227j == null) {
            this.f2227j = new WeakHashMap();
        }
        C0464m c0464m = (C0464m) this.f2227j.get(context);
        if (c0464m == null) {
            c0464m = new C0464m();
            this.f2227j.put(context, c0464m);
        }
        c0464m.m1474c(i, colorStateList);
    }

    /* renamed from: b */
    private ColorStateList m2906b(Context context) {
        return m2913f(context, bl.m2757a(context, C0581a.colorButtonNormal));
    }

    /* renamed from: c */
    private ColorStateList m2907c(Context context) {
        return m2913f(context, 0);
    }

    /* renamed from: d */
    private ColorStateList m2909d(Context context) {
        return m2913f(context, bl.m2757a(context, C0581a.colorAccent));
    }

    /* renamed from: f */
    private ColorStateList m2913f(Context context, int i) {
        r1 = new int[4][];
        r0 = new int[4];
        int a = bl.m2757a(context, C0581a.colorControlHighlight);
        context = bl.m2761c(context, C0581a.colorButtonNormal);
        r1[0] = bl.f2119a;
        r0[0] = context;
        r1[1] = bl.f2122d;
        r0[1] = C0264a.m714a(a, i);
        r1[2] = bl.f2120b;
        r0[2] = C0264a.m714a(a, i);
        r1[3] = bl.f2126h;
        r0[3] = i;
        return new ColorStateList(r1, r0);
    }

    /* renamed from: e */
    private ColorStateList m2911e(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = bl.m2760b(context, C0581a.colorSwitchThumbNormal);
        if (b == null || !b.isStateful()) {
            iArr[0] = bl.f2119a;
            iArr2[0] = bl.m2761c(context, C0581a.colorSwitchThumbNormal);
            iArr[1] = bl.f2123e;
            iArr2[1] = bl.m2757a(context, C0581a.colorControlActivated);
            iArr[2] = bl.f2126h;
            iArr2[2] = bl.m2757a(context, C0581a.colorSwitchThumbNormal);
        } else {
            iArr[0] = bl.f2119a;
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = bl.f2123e;
            iArr2[1] = bl.m2757a(context, C0581a.colorControlActivated);
            iArr[2] = bl.f2126h;
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* renamed from: a */
    static void m2899a(Drawable drawable, bo boVar, int[] iArr) {
        if (!al.m2615c(drawable) || drawable.mutate() == drawable) {
            if (!boVar.f2136d) {
                if (!boVar.f2135c) {
                    drawable.clearColorFilter();
                    if (VERSION.SDK_INT <= 23) {
                        drawable.invalidateSelf();
                    }
                    return;
                }
            }
            drawable.setColorFilter(C0799m.m2893a(boVar.f2136d ? boVar.f2133a : null, boVar.f2135c ? boVar.f2134b : f2218a, iArr));
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
            return;
        }
        Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
    }

    /* renamed from: a */
    private static PorterDuffColorFilter m2893a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        if (colorStateList != null) {
            if (mode != null) {
                return C0799m.m2892a(colorStateList.getColorForState(iArr, 0), mode);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static PorterDuffColorFilter m2892a(int i, Mode mode) {
        PorterDuffColorFilter a = f2220c.m10623a(i, mode);
        if (a != null) {
            return a;
        }
        a = new PorterDuffColorFilter(i, mode);
        f2220c.m10624a(i, mode, a);
        return a;
    }

    /* renamed from: a */
    private static void m2898a(Drawable drawable, int i, Mode mode) {
        if (al.m2615c(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f2218a;
        }
        drawable.setColorFilter(C0799m.m2892a(i, mode));
    }

    /* renamed from: f */
    private void m2914f(Context context) {
        if (!this.f2233p) {
            this.f2233p = true;
            Drawable a = m2915a(context, C0585e.abc_vector_test);
            if (a == null || C0799m.m2904a(a) == null) {
                this.f2233p = null;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    /* renamed from: a */
    private static boolean m2904a(Drawable drawable) {
        if (!(drawable instanceof C4441i)) {
            if ("android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName()) == null) {
                return null;
            }
        }
        return true;
    }
}
