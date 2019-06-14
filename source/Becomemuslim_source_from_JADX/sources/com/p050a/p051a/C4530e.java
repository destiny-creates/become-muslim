package com.p050a.p051a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.SparseArray;
import android.view.View.BaseSavedState;
import com.p050a.p051a.C0954f.C0949a;
import com.p050a.p051a.C0965l.C0964a;
import com.p050a.p051a.p056c.C0917e;
import com.p050a.p051a.p062f.C0952c;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: LottieAnimationView */
/* renamed from: com.a.a.e */
public class C4530e extends AppCompatImageView {
    /* renamed from: a */
    public static final C0941a f12234a = C0941a.Weak;
    /* renamed from: b */
    private static final String f12235b = C4530e.class.getSimpleName();
    /* renamed from: c */
    private static final SparseArray<C0954f> f12236c = new SparseArray();
    /* renamed from: d */
    private static final SparseArray<WeakReference<C0954f>> f12237d = new SparseArray();
    /* renamed from: e */
    private static final Map<String, C0954f> f12238e = new HashMap();
    /* renamed from: f */
    private static final Map<String, WeakReference<C0954f>> f12239f = new HashMap();
    /* renamed from: g */
    private final C0960j f12240g = new C33921(this);
    /* renamed from: h */
    private final C0957g f12241h = new C0957g();
    /* renamed from: i */
    private C0941a f12242i;
    /* renamed from: j */
    private String f12243j;
    /* renamed from: k */
    private int f12244k;
    /* renamed from: l */
    private boolean f12245l = false;
    /* renamed from: m */
    private boolean f12246m = false;
    /* renamed from: n */
    private boolean f12247n = false;
    /* renamed from: o */
    private C0888a f12248o;
    /* renamed from: p */
    private C0954f f12249p;

    /* compiled from: LottieAnimationView */
    /* renamed from: com.a.a.e$a */
    public enum C0941a {
        None,
        Weak,
        Strong
    }

    /* compiled from: LottieAnimationView */
    /* renamed from: com.a.a.e$b */
    private static class C0943b extends BaseSavedState {
        public static final Creator<C0943b> CREATOR = new C09421();
        /* renamed from: a */
        String f2627a;
        /* renamed from: b */
        int f2628b;
        /* renamed from: c */
        float f2629c;
        /* renamed from: d */
        boolean f2630d;
        /* renamed from: e */
        String f2631e;
        /* renamed from: f */
        int f2632f;
        /* renamed from: g */
        int f2633g;

        /* compiled from: LottieAnimationView */
        /* renamed from: com.a.a.e$b$1 */
        static class C09421 implements Creator<C0943b> {
            C09421() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m3290a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m3291a(i);
            }

            /* renamed from: a */
            public C0943b m3290a(Parcel parcel) {
                return new C0943b(parcel);
            }

            /* renamed from: a */
            public C0943b[] m3291a(int i) {
                return new C0943b[i];
            }
        }

        C0943b(Parcelable parcelable) {
            super(parcelable);
        }

        private C0943b(Parcel parcel) {
            super(parcel);
            this.f2627a = parcel.readString();
            this.f2629c = parcel.readFloat();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f2630d = z;
            this.f2631e = parcel.readString();
            this.f2632f = parcel.readInt();
            this.f2633g = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f2627a);
            parcel.writeFloat(this.f2629c);
            parcel.writeInt(this.f2630d);
            parcel.writeString(this.f2631e);
            parcel.writeInt(this.f2632f);
            parcel.writeInt(this.f2633g);
        }
    }

    /* compiled from: LottieAnimationView */
    /* renamed from: com.a.a.e$1 */
    class C33921 implements C0960j {
        /* renamed from: a */
        final /* synthetic */ C4530e f9024a;

        C33921(C4530e c4530e) {
            this.f9024a = c4530e;
        }

        /* renamed from: a */
        public void mo741a(C0954f c0954f) {
            if (c0954f != null) {
                this.f9024a.setComposition(c0954f);
            }
            this.f9024a.f12248o = null;
        }
    }

    public C4530e(Context context) {
        super(context);
        m15392a((AttributeSet) null);
    }

    /* renamed from: a */
    private void m15392a(AttributeSet attributeSet) {
        attributeSet = getContext().obtainStyledAttributes(attributeSet, C0964a.LottieAnimationView);
        this.f12242i = C0941a.values()[attributeSet.getInt(C0964a.LottieAnimationView_lottie_cacheStrategy, f12234a.ordinal())];
        if (!isInEditMode()) {
            boolean hasValue = attributeSet.hasValue(C0964a.LottieAnimationView_lottie_rawRes);
            boolean hasValue2 = attributeSet.hasValue(C0964a.LottieAnimationView_lottie_fileName);
            if (hasValue) {
                if (hasValue2) {
                    throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use use only one at once.");
                }
            }
            if (hasValue) {
                int resourceId = attributeSet.getResourceId(C0964a.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string = attributeSet.getString(C0964a.LottieAnimationView_lottie_fileName);
                if (string != null) {
                    setAnimation(string);
                }
            }
        }
        if (attributeSet.getBoolean(C0964a.LottieAnimationView_lottie_autoPlay, false)) {
            this.f12245l = true;
            this.f12246m = true;
        }
        if (attributeSet.getBoolean(C0964a.LottieAnimationView_lottie_loop, false)) {
            this.f12241h.m3386e(-1);
        }
        if (attributeSet.hasValue(C0964a.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(attributeSet.getInt(C0964a.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (attributeSet.hasValue(C0964a.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(attributeSet.getInt(C0964a.LottieAnimationView_lottie_repeatCount, -1));
        }
        setImageAssetsFolder(attributeSet.getString(C0964a.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(attributeSet.getFloat(C0964a.LottieAnimationView_lottie_progress, 0.0f));
        m15405a(attributeSet.getBoolean(C0964a.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (attributeSet.hasValue(C0964a.LottieAnimationView_lottie_colorFilter)) {
            C0966m c0966m = new C0966m(attributeSet.getColor(C0964a.LottieAnimationView_lottie_colorFilter, 0));
            m15403a(new C0917e("**"), C0959i.f2724x, new C0952c(c0966m));
        }
        if (attributeSet.hasValue(C0964a.LottieAnimationView_lottie_scale)) {
            this.f12241h.m3385e(attributeSet.getFloat(C0964a.LottieAnimationView_lottie_scale, 1.0f));
        }
        attributeSet.recycle();
        m15399k();
    }

    public void setImageResource(int i) {
        m15400a();
        m15397i();
        super.setImageResource(i);
    }

    public void setImageDrawable(Drawable drawable) {
        m15391a(drawable, true);
    }

    /* renamed from: a */
    private void m15391a(Drawable drawable, boolean z) {
        if (z && drawable != this.f12241h) {
            m15400a();
        }
        m15397i();
        super.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        m15400a();
        m15397i();
        super.setImageBitmap(bitmap);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (getDrawable() == this.f12241h) {
            super.invalidateDrawable(this.f12241h);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c0943b = new C0943b(super.onSaveInstanceState());
        c0943b.f2627a = this.f12243j;
        c0943b.f2628b = this.f12244k;
        c0943b.f2629c = this.f12241h.m3401t();
        c0943b.f2630d = this.f12241h.m3395n();
        c0943b.f2631e = this.f12241h.m3374b();
        c0943b.f2632f = this.f12241h.m3393l();
        c0943b.f2633g = this.f12241h.m3394m();
        return c0943b;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0943b) {
            C0943b c0943b = (C0943b) parcelable;
            super.onRestoreInstanceState(c0943b.getSuperState());
            this.f12243j = c0943b.f2627a;
            if (!TextUtils.isEmpty(this.f12243j)) {
                setAnimation(this.f12243j);
            }
            this.f12244k = c0943b.f2628b;
            if (this.f12244k != 0) {
                setAnimation(this.f12244k);
            }
            setProgress(c0943b.f2629c);
            if (c0943b.f2630d) {
                m15406b();
            }
            this.f12241h.m3369a(c0943b.f2631e);
            setRepeatMode(c0943b.f2632f);
            setRepeatCount(c0943b.f2633g);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f12246m && this.f12245l) {
            m15406b();
        }
    }

    protected void onDetachedFromWindow() {
        if (m15409c()) {
            m15410d();
            this.f12245l = true;
        }
        m15400a();
        super.onDetachedFromWindow();
    }

    /* renamed from: a */
    void m15400a() {
        if (this.f12241h != null) {
            this.f12241h.m3378c();
        }
    }

    /* renamed from: a */
    public void m15405a(boolean z) {
        this.f12241h.m3370a(z);
    }

    /* renamed from: b */
    public void m15407b(boolean z) {
        this.f12247n = z;
        m15399k();
    }

    public boolean getUseHardwareAcceleration() {
        return this.f12247n;
    }

    public void setAnimation(int i) {
        m15402a(i, this.f12242i);
    }

    /* renamed from: a */
    public void m15402a(final int i, final C0941a c0941a) {
        this.f12244k = i;
        this.f12243j = null;
        if (f12237d.indexOfKey(i) > 0) {
            C0954f c0954f = (C0954f) ((WeakReference) f12237d.get(i)).get();
            if (c0954f != null) {
                setComposition(c0954f);
                return;
            }
        } else if (f12236c.indexOfKey(i) > 0) {
            setComposition((C0954f) f12236c.get(i));
            return;
        }
        m15398j();
        m15397i();
        this.f12248o = C0949a.m3320a(getContext(), i, new C0960j(this) {
            /* renamed from: c */
            final /* synthetic */ C4530e f9027c;

            /* renamed from: a */
            public void mo741a(C0954f c0954f) {
                if (c0941a == C0941a.Strong) {
                    C4530e.f12236c.put(i, c0954f);
                } else if (c0941a == C0941a.Weak) {
                    C4530e.f12237d.put(i, new WeakReference(c0954f));
                }
                this.f9027c.setComposition(c0954f);
            }
        });
    }

    public void setAnimation(String str) {
        m15404a(str, this.f12242i);
    }

    /* renamed from: a */
    public void m15404a(final String str, final C0941a c0941a) {
        this.f12243j = str;
        this.f12244k = 0;
        if (f12239f.containsKey(str)) {
            C0954f c0954f = (C0954f) ((WeakReference) f12239f.get(str)).get();
            if (c0954f != null) {
                setComposition(c0954f);
                return;
            }
        } else if (f12238e.containsKey(str)) {
            setComposition((C0954f) f12238e.get(str));
            return;
        }
        m15398j();
        m15397i();
        this.f12248o = C0949a.m3321a(getContext(), str, new C0960j(this) {
            /* renamed from: c */
            final /* synthetic */ C4530e f9030c;

            /* renamed from: a */
            public void mo741a(C0954f c0954f) {
                if (c0941a == C0941a.Strong) {
                    C4530e.f12238e.put(str, c0954f);
                } else if (c0941a == C0941a.Weak) {
                    C4530e.f12239f.put(str, new WeakReference(c0954f));
                }
                this.f9030c.setComposition(c0954f);
            }
        });
    }

    @Deprecated
    public void setAnimation(JSONObject jSONObject) {
        setAnimation(new JsonReader(new StringReader(jSONObject.toString())));
    }

    public void setAnimationFromJson(String str) {
        setAnimation(new JsonReader(new StringReader(str)));
    }

    public void setAnimation(JsonReader jsonReader) {
        m15398j();
        m15397i();
        this.f12248o = C0949a.m3322a(jsonReader, this.f12240g);
    }

    /* renamed from: i */
    private void m15397i() {
        if (this.f12248o != null) {
            this.f12248o.mo740a();
            this.f12248o = null;
        }
    }

    public void setComposition(C0954f c0954f) {
        this.f12241h.setCallback(this);
        this.f12249p = c0954f;
        c0954f = this.f12241h.m3372a(c0954f);
        m15399k();
        if (getDrawable() != this.f12241h || c0954f != null) {
            setImageDrawable(null);
            setImageDrawable(this.f12241h);
            requestLayout();
        }
    }

    public C0954f getComposition() {
        return this.f12249p;
    }

    /* renamed from: b */
    public void m15406b() {
        this.f12241h.m3387f();
        m15399k();
    }

    public void setMinFrame(int i) {
        this.f12241h.m3363a(i);
    }

    public float getMinFrame() {
        return this.f12241h.m3389h();
    }

    public void setMinProgress(float f) {
        this.f12241h.m3362a(f);
    }

    public void setMaxFrame(int i) {
        this.f12241h.m3376b(i);
    }

    public float getMaxFrame() {
        return this.f12241h.m3390i();
    }

    public void setMaxProgress(float f) {
        this.f12241h.m3375b(f);
    }

    /* renamed from: a */
    public void m15401a(int i, int i2) {
        this.f12241h.m3364a(i, i2);
    }

    public void setSpeed(float f) {
        this.f12241h.m3379c(f);
    }

    public float getSpeed() {
        return this.f12241h.m3391j();
    }

    @Deprecated
    /* renamed from: c */
    public void m15408c(boolean z) {
        this.f12241h.m3386e(z ? true : false);
    }

    public void setRepeatMode(int i) {
        this.f12241h.m3383d(i);
    }

    public int getRepeatMode() {
        return this.f12241h.m3393l();
    }

    public void setRepeatCount(int i) {
        this.f12241h.m3386e(i);
    }

    public int getRepeatCount() {
        return this.f12241h.m3394m();
    }

    /* renamed from: c */
    public boolean m15409c() {
        return this.f12241h.m3395n();
    }

    public void setImageAssetsFolder(String str) {
        this.f12241h.m3369a(str);
    }

    public String getImageAssetsFolder() {
        return this.f12241h.m3374b();
    }

    public void setImageAssetDelegate(C0920c c0920c) {
        this.f12241h.m3367a(c0920c);
    }

    public void setFontAssetDelegate(C0891b c0891b) {
        this.f12241h.m3365a(c0891b);
    }

    public void setTextDelegate(C0967n c0967n) {
        this.f12241h.m3368a(c0967n);
    }

    /* renamed from: a */
    public <T> void m15403a(C0917e c0917e, T t, C0952c<T> c0952c) {
        this.f12241h.m3366a(c0917e, t, c0952c);
    }

    public void setScale(float f) {
        this.f12241h.m3385e(f);
        if (getDrawable() == this.f12241h) {
            m15391a((Drawable) 0.0f, false);
            m15391a(this.f12241h, false);
        }
    }

    public float getScale() {
        return this.f12241h.m3398q();
    }

    /* renamed from: d */
    public void m15410d() {
        this.f12241h.m3400s();
        m15399k();
    }

    public void setFrame(int i) {
        this.f12241h.m3380c(i);
    }

    public int getFrame() {
        return this.f12241h.m3392k();
    }

    public void setProgress(float f) {
        this.f12241h.m3382d(f);
    }

    public float getProgress() {
        return this.f12241h.m3401t();
    }

    public long getDuration() {
        return this.f12249p != null ? (long) this.f12249p.m3342c() : 0;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f12241h.m3377b(z);
    }

    public C0963k getPerformanceTracker() {
        return this.f12241h.m3381d();
    }

    /* renamed from: j */
    private void m15398j() {
        this.f12249p = null;
        this.f12241h.m3384e();
    }

    /* renamed from: k */
    private void m15399k() {
        int i = 1;
        Object obj = (this.f12247n && this.f12241h.m3395n()) ? 1 : null;
        if (obj != null) {
            i = 2;
        }
        setLayerType(i, null);
    }
}
