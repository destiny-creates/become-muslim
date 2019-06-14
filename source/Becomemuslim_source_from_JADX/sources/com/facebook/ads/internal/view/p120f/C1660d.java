package com.facebook.ads.internal.view.p120f;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.p120f.p121a.C3639c;
import com.facebook.ads.internal.view.p120f.p123c.C4597g;
import com.facebook.ads.internal.view.p120f.p124d.C1657c;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.internal.view.f.d */
public class C1660d extends RelativeLayout {
    /* renamed from: a */
    private final C1657c f4957a;
    /* renamed from: b */
    private C4597g f4958b;
    /* renamed from: c */
    private WeakReference<C1650a> f4959c;

    /* renamed from: com.facebook.ads.internal.view.f.d$a */
    public interface C1650a {
        /* renamed from: a */
        void mo961a();
    }

    public C1660d(Context context, C1657c c1657c) {
        super(context);
        this.f4957a = c1657c;
        C1523w.m5346b((View) this.f4957a);
        addView(this.f4957a.getView(), new LayoutParams(-1, -1));
    }

    /* renamed from: a */
    public void m5634a(C3639c c3639c) {
        addView(c3639c, new LayoutParams(-1, -1));
        this.f4958b = (C4597g) c3639c;
    }

    /* renamed from: b */
    public void m5635b(C3639c c3639c) {
        C1523w.m5346b(c3639c);
        this.f4958b = null;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ((View) this.f4957a).layout(0, 0, getWidth(), getHeight());
        if (this.f4958b != null) {
            this.f4958b.layout(0, 0, getWidth(), getHeight());
        }
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int videoWidth = this.f4957a.getVideoWidth();
        int videoHeight = this.f4957a.getVideoHeight();
        int defaultSize = C1660d.getDefaultSize(videoWidth, i);
        int defaultSize2 = C1660d.getDefaultSize(videoHeight, i2);
        if (videoWidth <= 0 || videoHeight <= 0) {
            i = defaultSize;
            i2 = defaultSize2;
            obj = null;
        } else {
            obj = 1;
            defaultSize2 = MeasureSpec.getMode(i);
            i = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i2);
            i2 = MeasureSpec.getSize(i2);
            if (defaultSize2 == 1073741824 && mode == 1073741824) {
                defaultSize2 = videoWidth * i2;
                mode = i * videoHeight;
                if (defaultSize2 < mode) {
                    i = defaultSize2 / videoHeight;
                } else if (defaultSize2 > mode) {
                    defaultSize2 = mode / videoWidth;
                }
            } else if (defaultSize2 == 1073741824) {
                defaultSize2 = (videoHeight * i) / videoWidth;
                if (mode == LinearLayoutManager.INVALID_OFFSET && defaultSize2 > i2) {
                }
            } else if (mode == 1073741824) {
                videoWidth = (videoWidth * i2) / videoHeight;
                if (defaultSize2 != LinearLayoutManager.INVALID_OFFSET || videoWidth <= i) {
                    i = videoWidth;
                }
            } else {
                if (mode != LinearLayoutManager.INVALID_OFFSET || videoHeight <= i2) {
                    mode = videoWidth;
                    i2 = videoHeight;
                } else {
                    mode = (i2 * videoWidth) / videoHeight;
                }
                if (defaultSize2 != LinearLayoutManager.INVALID_OFFSET || mode <= i) {
                    i = mode;
                } else {
                    defaultSize2 = (videoHeight * i) / videoWidth;
                }
            }
            i2 = defaultSize2;
        }
        setMeasuredDimension(i, i2);
        if (obj != null && this.f4959c != null && this.f4959c.get() != null) {
            ((C1650a) this.f4959c.get()).mo961a();
        }
    }

    public void setViewImplInflationListener(C1650a c1650a) {
        this.f4959c = new WeakReference(c1650a);
    }
}
