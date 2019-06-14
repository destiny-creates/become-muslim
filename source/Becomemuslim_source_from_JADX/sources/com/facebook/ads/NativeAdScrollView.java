package com.facebook.ads;

import android.content.Context;
import android.support.v4.view.C0513q;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.ads.NativeAdView.Type;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import java.util.ArrayList;
import java.util.List;

public class NativeAdScrollView extends LinearLayout {
    public static final int DEFAULT_INSET = 20;
    public static final int DEFAULT_MAX_ADS = 10;
    /* renamed from: a */
    private final Context f3697a;
    /* renamed from: b */
    private final NativeAdsManager f3698b;
    /* renamed from: c */
    private final AdViewProvider f3699c;
    /* renamed from: d */
    private final Type f3700d;
    /* renamed from: e */
    private final int f3701e;
    /* renamed from: f */
    private final C3533b f3702f;
    /* renamed from: g */
    private final NativeAdViewAttributes f3703g;

    public interface AdViewProvider {
        View createView(NativeAd nativeAd, int i);

        void destroyView(NativeAd nativeAd, View view);
    }

    /* renamed from: com.facebook.ads.NativeAdScrollView$a */
    private class C3532a extends C0513q {
        /* renamed from: a */
        final /* synthetic */ NativeAdScrollView f9402a;
        /* renamed from: b */
        private List<NativeAd> f9403b = new ArrayList();

        public C3532a(NativeAdScrollView nativeAdScrollView) {
            this.f9402a = nativeAdScrollView;
        }

        /* renamed from: a */
        public void m11398a() {
            this.f9403b.clear();
            int min = Math.min(this.f9402a.f3701e, this.f9402a.f3698b.getUniqueNativeAdCount());
            for (int i = 0; i < min; i++) {
                NativeAd nextNativeAd = this.f9402a.f3698b.nextNativeAd();
                nextNativeAd.m11394a(true);
                this.f9403b.add(nextNativeAd);
            }
            notifyDataSetChanged();
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i < this.f9403b.size()) {
                if (this.f9402a.f3700d != null) {
                    ((NativeAd) this.f9403b.get(i)).unregisterView();
                } else {
                    this.f9402a.f3699c.destroyView((NativeAd) this.f9403b.get(i), (View) obj);
                }
            }
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return this.f9403b.size();
        }

        public int getItemPosition(Object obj) {
            int indexOf = this.f9403b.indexOf(obj);
            return indexOf >= 0 ? indexOf : -2;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View render = this.f9402a.f3700d != null ? NativeAdView.render(this.f9402a.f3697a, (NativeAd) this.f9403b.get(i), this.f9402a.f3700d, this.f9402a.f3703g) : this.f9402a.f3699c.createView((NativeAd) this.f9403b.get(i), i);
            viewGroup.addView(render);
            return render;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* renamed from: com.facebook.ads.NativeAdScrollView$b */
    private class C3533b extends ViewPager {
        /* renamed from: a */
        final /* synthetic */ NativeAdScrollView f9404a;

        public C3533b(NativeAdScrollView nativeAdScrollView, Context context) {
            this.f9404a = nativeAdScrollView;
            super(context);
        }

        protected void onMeasure(int i, int i2) {
            int i3 = 0;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                childAt.measure(i, MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i3) {
                    i3 = measuredHeight;
                }
            }
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(i3, 1073741824));
        }
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider) {
        this(context, nativeAdsManager, adViewProvider, null, null, 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider, int i) {
        this(context, nativeAdsManager, adViewProvider, null, null, i);
    }

    private NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider, Type type, NativeAdViewAttributes nativeAdViewAttributes, int i) {
        super(context);
        if (nativeAdsManager.isLoaded()) {
            if (type == null) {
                if (adViewProvider == null) {
                    throw new IllegalArgumentException("Must provide a NativeAdView.Type or AdViewProvider");
                }
            }
            this.f3697a = context;
            this.f3698b = nativeAdsManager;
            this.f3703g = nativeAdViewAttributes;
            this.f3699c = adViewProvider;
            this.f3700d = type;
            this.f3701e = i;
            C0513q c3532a = new C3532a(this);
            this.f3702f = new C3533b(this, context);
            this.f3702f.setAdapter(c3532a);
            setInset(20);
            c3532a.m11398a();
            addView(this.f3702f);
            return;
        }
        throw new IllegalStateException("NativeAdsManager not loaded");
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, Type type) {
        this(context, nativeAdsManager, null, type, new NativeAdViewAttributes(), 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        this(context, nativeAdsManager, null, type, nativeAdViewAttributes, 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, Type type, NativeAdViewAttributes nativeAdViewAttributes, int i) {
        this(context, nativeAdsManager, null, type, nativeAdViewAttributes, i);
    }

    public void setInset(int i) {
        if (i > 0) {
            float f = C1523w.f4503b;
            int round = Math.round(((float) i) * f);
            this.f3702f.setPadding(round, 0, round, 0);
            this.f3702f.setPageMargin(Math.round(((float) (i / 2)) * f));
            this.f3702f.setClipToPadding(false);
        }
    }
}
