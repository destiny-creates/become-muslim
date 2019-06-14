package com.p050a.p051a.p055b;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.p050a.p051a.C0920c;
import com.p050a.p051a.C0958h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ImageAssetManager */
/* renamed from: com.a.a.b.b */
public class C0890b {
    /* renamed from: a */
    private static final Object f2500a = new Object();
    /* renamed from: b */
    private final Context f2501b;
    /* renamed from: c */
    private String f2502c;
    /* renamed from: d */
    private C0920c f2503d;
    /* renamed from: e */
    private final Map<String, C0958h> f2504e;
    /* renamed from: f */
    private final Map<String, Bitmap> f2505f = new HashMap();

    public C0890b(Callback callback, String str, C0920c c0920c, Map<String, C0958h> map) {
        this.f2502c = str;
        if (TextUtils.isEmpty(str) == null && this.f2502c.charAt(this.f2502c.length() - 1) != 47) {
            str = new StringBuilder();
            str.append(this.f2502c);
            str.append('/');
            this.f2502c = str.toString();
        }
        if ((callback instanceof View) == null) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f2504e = new HashMap();
            this.f2501b = null;
            return;
        }
        this.f2501b = ((View) callback).getContext();
        this.f2504e = map;
        m3160a(c0920c);
    }

    /* renamed from: a */
    public void m3160a(C0920c c0920c) {
        this.f2503d = c0920c;
    }

    /* renamed from: a */
    public Bitmap m3158a(String str) {
        Bitmap bitmap = (Bitmap) this.f2505f.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        C0958h c0958h = (C0958h) this.f2504e.get(str);
        if (c0958h == null) {
            return null;
        }
        if (this.f2503d != null) {
            bitmap = this.f2503d.m3230a(c0958h);
            if (bitmap != null) {
                m3157a(str, bitmap);
            }
            return bitmap;
        }
        String b = c0958h.m3403b();
        Options options = new Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!b.startsWith("data:") || b.indexOf("base64,") <= 0) {
            try {
                if (TextUtils.isEmpty(this.f2502c)) {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
                AssetManager assets = this.f2501b.getAssets();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.f2502c);
                stringBuilder.append(b);
                return m3157a(str, BitmapFactory.decodeStream(assets.open(stringBuilder.toString()), null, options));
            } catch (String str2) {
                Log.w("LOTTIE", "Unable to open asset.", str2);
                return null;
            }
        }
        try {
            byte[] decode = Base64.decode(b.substring(b.indexOf(44) + 1), 0);
            return m3157a(str2, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
        } catch (String str22) {
            Log.w("LOTTIE", "data URL did not have correct base64 format.", str22);
            return null;
        }
    }

    /* renamed from: a */
    public void m3159a() {
        synchronized (f2500a) {
            Iterator it = this.f2505f.entrySet().iterator();
            while (it.hasNext()) {
                ((Bitmap) ((Entry) it.next()).getValue()).recycle();
                it.remove();
            }
        }
    }

    /* renamed from: a */
    public boolean m3161a(Context context) {
        return (!(context == null && this.f2501b == null) && (context == null || this.f2501b.equals(context) == null)) ? null : true;
    }

    /* renamed from: a */
    private Bitmap m3157a(String str, Bitmap bitmap) {
        Bitmap bitmap2;
        synchronized (f2500a) {
            bitmap2 = (Bitmap) this.f2505f.put(str, bitmap);
        }
        return bitmap2;
    }
}
