package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.C0514r;
import android.support.v4.view.C0517s;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p037c.p038a.C0631b;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* compiled from: AppCompatSpinner */
/* renamed from: android.support.v7.widget.y */
public class C3332y extends Spinner implements C0514r {
    /* renamed from: a */
    private static final int[] f8857a = new int[]{16843505};
    /* renamed from: b */
    private final C0795h f8858b;
    /* renamed from: c */
    private final Context f8859c;
    /* renamed from: d */
    private ap f8860d;
    /* renamed from: e */
    private SpinnerAdapter f8861e;
    /* renamed from: f */
    private final boolean f8862f;
    /* renamed from: g */
    private C4493b f8863g;
    /* renamed from: h */
    private int f8864h;
    /* renamed from: i */
    private final Rect f8865i;

    /* compiled from: AppCompatSpinner */
    /* renamed from: android.support.v7.widget.y$a */
    private static class C0806a implements ListAdapter, SpinnerAdapter {
        /* renamed from: a */
        private SpinnerAdapter f2245a;
        /* renamed from: b */
        private ListAdapter f2246b;

        public int getItemViewType(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public C0806a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.f2245a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f2246b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof bm) {
                bm bmVar = (bm) spinnerAdapter;
                if (bmVar.m2762a() == null) {
                    bmVar.m2763a(theme);
                }
            }
        }

        public int getCount() {
            return this.f2245a == null ? 0 : this.f2245a.getCount();
        }

        public Object getItem(int i) {
            return this.f2245a == null ? 0 : this.f2245a.getItem(i);
        }

        public long getItemId(int i) {
            return this.f2245a == null ? -1 : this.f2245a.getItemId(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.f2245a == null) {
                return 0;
            }
            return this.f2245a.getDropDownView(i, view, viewGroup);
        }

        public boolean hasStableIds() {
            return this.f2245a != null && this.f2245a.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2245a != null) {
                this.f2245a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2245a != null) {
                this.f2245a.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f2246b;
            return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f2246b;
            return listAdapter != null ? listAdapter.isEnabled(i) : true;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* compiled from: AppCompatSpinner */
    /* renamed from: android.support.v7.widget.y$b */
    private class C4493b extends au {
        /* renamed from: a */
        ListAdapter f12101a;
        /* renamed from: b */
        final /* synthetic */ C3332y f12102b;
        /* renamed from: h */
        private CharSequence f12103h;
        /* renamed from: i */
        private final Rect f12104i = new Rect();

        /* compiled from: AppCompatSpinner */
        /* renamed from: android.support.v7.widget.y$b$2 */
        class C08082 implements OnGlobalLayoutListener {
            /* renamed from: a */
            final /* synthetic */ C4493b f2249a;

            C08082(C4493b c4493b) {
                this.f2249a = c4493b;
            }

            public void onGlobalLayout() {
                if (this.f2249a.m15222a(this.f2249a.f12102b)) {
                    this.f2249a.mo2788f();
                    super.mo634a();
                    return;
                }
                this.f2249a.mo635c();
            }
        }

        public C4493b(final C3332y c3332y, Context context, AttributeSet attributeSet, int i) {
            this.f12102b = c3332y;
            super(context, attributeSet, i);
            m10456b((View) c3332y);
            m10454a(true);
            m10448a((int) null);
            m10451a((OnItemClickListener) new OnItemClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C4493b f2248b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.f2248b.f12102b.setSelection(i);
                    if (this.f2248b.f12102b.getOnItemClickListener() != null) {
                        this.f2248b.f12102b.performItemClick(view, i, this.f2248b.f12101a.getItemId(i));
                    }
                    this.f2248b.mo635c();
                }
            });
        }

        /* renamed from: a */
        public void mo2786a(ListAdapter listAdapter) {
            super.mo2786a(listAdapter);
            this.f12101a = listAdapter;
        }

        /* renamed from: b */
        public CharSequence mo2787b() {
            return this.f12103h;
        }

        /* renamed from: a */
        public void m15221a(CharSequence charSequence) {
            this.f12103h = charSequence;
        }

        /* renamed from: f */
        void mo2788f() {
            int i;
            Drawable h = m10467h();
            int i2 = 0;
            if (h != null) {
                h.getPadding(this.f12102b.f8865i);
                if (by.m2841a(this.f12102b)) {
                    i = this.f12102b.f8865i.right;
                } else {
                    i = -this.f12102b.f8865i.left;
                }
                i2 = i;
            } else {
                Rect b = this.f12102b.f8865i;
                this.f12102b.f8865i.right = 0;
                b.left = 0;
            }
            i = this.f12102b.getPaddingLeft();
            int paddingRight = this.f12102b.getPaddingRight();
            int width = this.f12102b.getWidth();
            if (this.f12102b.f8864h == -2) {
                int a = this.f12102b.m10637a((SpinnerAdapter) this.f12101a, m10467h());
                int i3 = (this.f12102b.getContext().getResources().getDisplayMetrics().widthPixels - this.f12102b.f8865i.left) - this.f12102b.f8865i.right;
                if (a > i3) {
                    a = i3;
                }
                m10465g(Math.max(a, (width - i) - paddingRight));
            } else if (this.f12102b.f8864h == -1) {
                m10465g((width - i) - paddingRight);
            } else {
                m10465g(this.f12102b.f8864h);
            }
            m10459c(by.m2841a(this.f12102b) ? i2 + ((width - paddingRight) - m10473l()) : i2 + i);
        }

        /* renamed from: a */
        public void mo634a() {
            boolean d = mo636d();
            mo2788f();
            m10468h(2);
            super.mo634a();
            mo637e().setChoiceMode(1);
            m10470i(this.f12102b.getSelectedItemPosition());
            if (!d) {
                ViewTreeObserver viewTreeObserver = this.f12102b.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener c08082 = new C08082(this);
                    viewTreeObserver.addOnGlobalLayoutListener(c08082);
                    m10453a(new OnDismissListener(this) {
                        /* renamed from: b */
                        final /* synthetic */ C4493b f2251b;

                        public void onDismiss() {
                            ViewTreeObserver viewTreeObserver = this.f2251b.f12102b.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(c08082);
                            }
                        }
                    });
                }
            }
        }

        /* renamed from: a */
        boolean m15222a(View view) {
            return (!C0517s.m1683A(view) || view.getGlobalVisibleRect(this.f12104i) == null) ? null : true;
        }
    }

    public C3332y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0581a.spinnerStyle);
    }

    public C3332y(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public C3332y(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C3332y(android.content.Context r8, android.util.AttributeSet r9, int r10, int r11, android.content.res.Resources.Theme r12) {
        /*
        r7 = this;
        r7.<init>(r8, r9, r10);
        r0 = new android.graphics.Rect;
        r0.<init>();
        r7.f8865i = r0;
        r0 = android.support.v7.p035a.C0591a.C0590j.Spinner;
        r1 = 0;
        r0 = android.support.v7.widget.bq.m2769a(r8, r9, r0, r10, r1);
        r2 = new android.support.v7.widget.h;
        r2.<init>(r7);
        r7.f8858b = r2;
        r2 = 0;
        if (r12 == 0) goto L_0x0023;
    L_0x001b:
        r3 = new android.support.v7.view.d;
        r3.<init>(r8, r12);
        r7.f8859c = r3;
        goto L_0x003e;
    L_0x0023:
        r12 = android.support.v7.p035a.C0591a.C0590j.Spinner_popupTheme;
        r12 = r0.m2786g(r12, r1);
        if (r12 == 0) goto L_0x0033;
    L_0x002b:
        r3 = new android.support.v7.view.d;
        r3.<init>(r8, r12);
        r7.f8859c = r3;
        goto L_0x003e;
    L_0x0033:
        r12 = android.os.Build.VERSION.SDK_INT;
        r3 = 23;
        if (r12 >= r3) goto L_0x003b;
    L_0x0039:
        r12 = r8;
        goto L_0x003c;
    L_0x003b:
        r12 = r2;
    L_0x003c:
        r7.f8859c = r12;
    L_0x003e:
        r12 = r7.f8859c;
        r3 = 1;
        if (r12 == 0) goto L_0x00ad;
    L_0x0043:
        r12 = -1;
        if (r11 != r12) goto L_0x0075;
    L_0x0046:
        r12 = f8857a;	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r12 = r8.obtainStyledAttributes(r9, r12, r10, r1);	 Catch:{ Exception -> 0x0062, all -> 0x005f }
        r4 = r12.hasValue(r1);	 Catch:{ Exception -> 0x005d }
        if (r4 == 0) goto L_0x0057;
    L_0x0052:
        r4 = r12.getInt(r1, r1);	 Catch:{ Exception -> 0x005d }
        r11 = r4;
    L_0x0057:
        if (r12 == 0) goto L_0x0075;
    L_0x0059:
        r12.recycle();
        goto L_0x0075;
    L_0x005d:
        r4 = move-exception;
        goto L_0x0064;
    L_0x005f:
        r8 = move-exception;
        r12 = r2;
        goto L_0x006f;
    L_0x0062:
        r4 = move-exception;
        r12 = r2;
    L_0x0064:
        r5 = "AppCompatSpinner";
        r6 = "Could not read android:spinnerMode";
        android.util.Log.i(r5, r6, r4);	 Catch:{ all -> 0x006e }
        if (r12 == 0) goto L_0x0075;
    L_0x006d:
        goto L_0x0059;
    L_0x006e:
        r8 = move-exception;
    L_0x006f:
        if (r12 == 0) goto L_0x0074;
    L_0x0071:
        r12.recycle();
    L_0x0074:
        throw r8;
    L_0x0075:
        if (r11 != r3) goto L_0x00ad;
    L_0x0077:
        r11 = new android.support.v7.widget.y$b;
        r12 = r7.f8859c;
        r11.<init>(r7, r12, r9, r10);
        r12 = r7.f8859c;
        r4 = android.support.v7.p035a.C0591a.C0590j.Spinner;
        r12 = android.support.v7.widget.bq.m2769a(r12, r9, r4, r10, r1);
        r1 = android.support.v7.p035a.C0591a.C0590j.Spinner_android_dropDownWidth;
        r4 = -2;
        r1 = r12.m2784f(r1, r4);
        r7.f8864h = r1;
        r1 = android.support.v7.p035a.C0591a.C0590j.Spinner_android_popupBackground;
        r1 = r12.m2773a(r1);
        r11.m10450a(r1);
        r1 = android.support.v7.p035a.C0591a.C0590j.Spinner_android_prompt;
        r1 = r0.m2781d(r1);
        r11.m15221a(r1);
        r12.m2774a();
        r7.f8863g = r11;
        r12 = new android.support.v7.widget.y$1;
        r12.<init>(r7, r7, r11);
        r7.f8860d = r12;
    L_0x00ad:
        r11 = android.support.v7.p035a.C0591a.C0590j.Spinner_android_entries;
        r11 = r0.m2785f(r11);
        if (r11 == 0) goto L_0x00c5;
    L_0x00b5:
        r12 = new android.widget.ArrayAdapter;
        r1 = 17367048; // 0x1090008 float:2.5162948E-38 double:8.580462E-317;
        r12.<init>(r8, r1, r11);
        r8 = android.support.v7.p035a.C0591a.C0587g.support_simple_spinner_dropdown_item;
        r12.setDropDownViewResource(r8);
        r7.setAdapter(r12);
    L_0x00c5:
        r0.m2774a();
        r7.f8862f = r3;
        r8 = r7.f8861e;
        if (r8 == 0) goto L_0x00d5;
    L_0x00ce:
        r8 = r7.f8861e;
        r7.setAdapter(r8);
        r7.f8861e = r2;
    L_0x00d5:
        r8 = r7.f8858b;
        r8.m2877a(r9, r10);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.y.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    public Context getPopupContext() {
        if (this.f8863g != null) {
            return this.f8859c;
        }
        return VERSION.SDK_INT >= 23 ? super.getPopupContext() : null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f8863g != null) {
            this.f8863g.m10450a(drawable);
        } else if (VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0631b.m2112b(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.f8863g != null) {
            return this.f8863g.m10467h();
        }
        return VERSION.SDK_INT >= 16 ? super.getPopupBackground() : null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.f8863g != null) {
            this.f8863g.m10460d(i);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.f8863g != null) {
            return this.f8863g.m10472k();
        }
        return VERSION.SDK_INT >= 16 ? super.getDropDownVerticalOffset() : 0;
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.f8863g != null) {
            this.f8863g.m10459c(i);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.f8863g != null) {
            return this.f8863g.m10471j();
        }
        return VERSION.SDK_INT >= 16 ? super.getDropDownHorizontalOffset() : 0;
    }

    public void setDropDownWidth(int i) {
        if (this.f8863g != null) {
            this.f8864h = i;
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.f8863g != null) {
            return this.f8864h;
        }
        return VERSION.SDK_INT >= 16 ? super.getDropDownWidth() : 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f8862f) {
            super.setAdapter(spinnerAdapter);
            if (this.f8863g != null) {
                this.f8863g.mo2786a(new C0806a(spinnerAdapter, (this.f8859c == null ? getContext() : this.f8859c).getTheme()));
            }
            return;
        }
        this.f8861e = spinnerAdapter;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f8863g != null && this.f8863g.mo636d()) {
            this.f8863g.mo635c();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8860d == null || !this.f8860d.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f8863g != 0 && MeasureSpec.getMode(i) == LinearLayoutManager.INVALID_OFFSET) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m10637a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.f8863g == null) {
            return super.performClick();
        }
        if (!this.f8863g.mo636d()) {
            this.f8863g.mo634a();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.f8863g != null) {
            this.f8863g.m15221a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        return this.f8863g != null ? this.f8863g.mo2787b() : super.getPrompt();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f8858b != null) {
            this.f8858b.m2873a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f8858b != null) {
            this.f8858b.m2876a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f8858b != null) {
            this.f8858b.m2874a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f8858b != null ? this.f8858b.m2872a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f8858b != null) {
            this.f8858b.m2875a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f8858b != null ? this.f8858b.m2878b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f8858b != null) {
            this.f8858b.m2880c();
        }
    }

    /* renamed from: a */
    int m10637a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (max = Math.max(0, max - (15 - (min - max))); max < min; max++) {
            int itemViewType = spinnerAdapter.getItemViewType(max);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.f8865i);
            i2 += this.f8865i.left + this.f8865i.right;
        }
        return i2;
    }
}
