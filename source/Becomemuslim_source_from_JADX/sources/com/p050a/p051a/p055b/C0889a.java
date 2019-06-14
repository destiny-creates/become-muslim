package com.p050a.p051a.p055b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable.Callback;
import android.util.Log;
import android.view.View;
import com.p050a.p051a.C0891b;
import com.p050a.p051a.p056c.C0919g;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FontAssetManager */
/* renamed from: com.a.a.b.a */
public class C0889a {
    /* renamed from: a */
    private final C0919g<String> f2494a = new C0919g();
    /* renamed from: b */
    private final Map<C0919g<String>, Typeface> f2495b = new HashMap();
    /* renamed from: c */
    private final Map<String, Typeface> f2496c = new HashMap();
    /* renamed from: d */
    private final AssetManager f2497d;
    /* renamed from: e */
    private C0891b f2498e;
    /* renamed from: f */
    private String f2499f = ".ttf";

    public C0889a(Callback callback, C0891b c0891b) {
        this.f2498e = c0891b;
        if ((callback instanceof View) == null) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f2497d = null;
            return;
        }
        this.f2497d = ((View) callback).getContext().getAssets();
    }

    /* renamed from: a */
    public void m3156a(C0891b c0891b) {
        this.f2498e = c0891b;
    }

    /* renamed from: a */
    public Typeface m3155a(String str, String str2) {
        this.f2494a.m3229a(str, str2);
        Typeface typeface = (Typeface) this.f2495b.get(this.f2494a);
        if (typeface != null) {
            return typeface;
        }
        str = m3153a(m3154a(str), str2);
        this.f2495b.put(this.f2494a, str);
        return str;
    }

    /* renamed from: a */
    private Typeface m3154a(String str) {
        Typeface typeface = (Typeface) this.f2496c.get(str);
        if (typeface != null) {
            return typeface;
        }
        typeface = null;
        if (this.f2498e != null) {
            typeface = this.f2498e.m3162a(str);
        }
        if (this.f2498e != null && r0 == null) {
            String b = this.f2498e.m3163b(str);
            if (b != null) {
                typeface = Typeface.createFromAsset(this.f2497d, b);
            }
        }
        if (typeface == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fonts/");
            stringBuilder.append(str);
            stringBuilder.append(this.f2499f);
            typeface = Typeface.createFromAsset(this.f2497d, stringBuilder.toString());
        }
        this.f2496c.put(str, typeface);
        return typeface;
    }

    /* renamed from: a */
    private Typeface m3153a(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        str = str.contains("Bold");
        str = (!contains || str == null) ? contains ? 2 : str != null ? true : null : 3;
        if (typeface.getStyle() == str) {
            return typeface;
        }
        return Typeface.create(typeface, str);
    }
}
