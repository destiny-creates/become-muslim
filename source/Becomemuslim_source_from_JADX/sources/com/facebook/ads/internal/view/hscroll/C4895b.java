package com.facebook.ads.internal.view.hscroll;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.C0689a;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.facebook.ads.internal.view.hscroll.C4846d.C1665a;

/* renamed from: com.facebook.ads.internal.view.hscroll.b */
public class C4895b extends C4846d implements C1665a {
    /* renamed from: c */
    private final HScrollLinearLayoutManager f14023c;
    /* renamed from: d */
    private C1663a f14024d;
    /* renamed from: e */
    private int f14025e = -1;
    /* renamed from: f */
    private int f14026f = -1;
    /* renamed from: g */
    private int f14027g = 0;
    /* renamed from: h */
    private int f14028h = 0;

    /* renamed from: com.facebook.ads.internal.view.hscroll.b$a */
    public interface C1663a {
        /* renamed from: a */
        void m5639a(int i, int i2);
    }

    public C4895b(Context context) {
        super(context);
        this.f14023c = new HScrollLinearLayoutManager(context, new C1664c(), new C1662a());
        m17539a();
    }

    public C4895b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14023c = new HScrollLinearLayoutManager(context, new C1664c(), new C1662a());
        m17539a();
    }

    public C4895b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14023c = new HScrollLinearLayoutManager(context, new C1664c(), new C1662a());
        m17539a();
    }

    /* renamed from: a */
    private void m17539a() {
        this.f14023c.setOrientation(0);
        setLayoutManager(this.f14023c);
        setSaveEnabled(false);
        setSnapDelegate(this);
    }

    /* renamed from: a */
    private void m17540a(int i, int i2) {
        if (i != this.f14025e || i2 != this.f14026f) {
            this.f14025e = i;
            this.f14026f = i2;
            if (this.f14024d != null) {
                this.f14024d.m5639a(this.f14025e, this.f14026f);
            }
        }
    }

    /* renamed from: b */
    private int m17541b(int i) {
        int i2 = this.f14028h * 2;
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - i2;
        int itemCount = getAdapter().getItemCount();
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        while (i4 > i) {
            i3++;
            if (i3 >= itemCount) {
                return i;
            }
            i4 = (int) (((float) (measuredWidth - (i3 * i2))) / (((float) i3) + 0.333f));
        }
        return i4;
    }

    /* renamed from: a */
    public int mo3485a(int i) {
        i = Math.abs(i);
        if (i <= this.a) {
            return 0;
        }
        int i2 = 1;
        if (this.f14027g != 0) {
            i2 = 1 + (i / this.f14027g);
        }
        return i2;
    }

    /* renamed from: a */
    protected void mo3486a(int i, boolean z) {
        super.mo3486a(i, z);
        m17540a(i, 0);
    }

    public int getChildSpacing() {
        return this.f14028h;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        i = Math.round(((float) getMeasuredWidth()) / 1.91f);
        int mode = MeasureSpec.getMode(i2);
        if (mode == LinearLayoutManager.INVALID_OFFSET) {
            i = Math.min(MeasureSpec.getSize(i2), i);
        } else if (mode == 1073741824) {
            i = MeasureSpec.getSize(i2);
        }
        i2 = getPaddingTop() + getPaddingBottom();
        i = m17541b(i - i2);
        setMeasuredDimension(getMeasuredWidth(), i2 + i);
        setChildWidth(i + (this.f14028h * 2));
    }

    public void setAdapter(C0689a c0689a) {
        this.f14023c.m15957a(c0689a == null ? -1 : c0689a.hashCode());
        super.setAdapter(c0689a);
    }

    public void setChildSpacing(int i) {
        this.f14028h = i;
    }

    public void setChildWidth(int i) {
        this.f14027g = i;
        i = getMeasuredWidth();
        this.f14023c.m15958b((((i - getPaddingLeft()) - getPaddingRight()) - this.f14027g) / 2);
        this.f14023c.m15956a(((double) this.f14027g) / ((double) i));
    }

    public void setCurrentPosition(int i) {
        mo3486a(i, false);
    }

    public void setOnPageChangedListener(C1663a c1663a) {
        this.f14024d = c1663a;
    }
}
