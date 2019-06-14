package com.devmarvel.creditcardentry.p078b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p030f.C0392e;
import android.support.v4.p030f.C0393f;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.devmarvel.creditcardentry.C1175a.C1167a;
import com.devmarvel.creditcardentry.C1175a.C1170d;
import com.devmarvel.creditcardentry.C1175a.C1172f;
import com.devmarvel.creditcardentry.library.C1190a;
import com.devmarvel.creditcardentry.library.C1191b;
import com.devmarvel.creditcardentry.library.C1192c;
import com.devmarvel.creditcardentry.p077a.C1174b;
import com.devmarvel.creditcardentry.p077a.C3491a;
import com.devmarvel.creditcardentry.p077a.C3492c;
import com.devmarvel.creditcardentry.p077a.C3493d;
import com.devmarvel.creditcardentry.p077a.C3494e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
/* compiled from: CreditCardEntry */
/* renamed from: com.devmarvel.creditcardentry.b.a */
public class C3497a extends HorizontalScrollView implements OnGestureListener, OnTouchListener, C1184b {
    /* renamed from: a */
    private final Context f9309a;
    /* renamed from: b */
    private final Integer f9310b;
    /* renamed from: c */
    private ImageView f9311c;
    /* renamed from: d */
    private ImageView f9312d;
    /* renamed from: e */
    private final C3491a f9313e;
    /* renamed from: f */
    private final C3492c f9314f;
    /* renamed from: g */
    private final C3493d f9315g;
    /* renamed from: h */
    private final C3494e f9316h;
    /* renamed from: i */
    private Map<C1174b, C1174b> f9317i = new HashMap(4);
    /* renamed from: j */
    private Map<C1174b, C1174b> f9318j = new HashMap(4);
    /* renamed from: k */
    private List<C1174b> f9319k = new ArrayList(4);
    /* renamed from: l */
    private final TextView f9320l;
    /* renamed from: m */
    private TextView f9321m;
    /* renamed from: n */
    private boolean f9322n;
    /* renamed from: o */
    private boolean f9323o = false;
    /* renamed from: p */
    private boolean f9324p = true;
    /* renamed from: q */
    private C1191b f9325q;
    /* renamed from: r */
    private int f9326r;

    /* compiled from: CreditCardEntry */
    /* renamed from: com.devmarvel.creditcardentry.b.a$1 */
    class C11761 implements OnEditorActionListener {
        /* renamed from: a */
        final /* synthetic */ C3497a f3298a;

        C11761(C3497a c3497a) {
            this.f3298a = c3497a;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (6 != i) {
                return null;
            }
            this.f3298a.mo816c("");
            return true;
        }
    }

    /* compiled from: CreditCardEntry */
    /* renamed from: com.devmarvel.creditcardentry.b.a$2 */
    class C11772 implements OnEditorActionListener {
        /* renamed from: a */
        final /* synthetic */ C3497a f3299a;

        C11772(C3497a c3497a) {
            this.f3299a = c3497a;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (6 != i) {
                return null;
            }
            this.f3299a.mo810a();
            return true;
        }
    }

    /* compiled from: CreditCardEntry */
    /* renamed from: com.devmarvel.creditcardentry.b.a$3 */
    class C11783 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C3497a f3300a;

        C11783(C3497a c3497a) {
            this.f3300a = c3497a;
        }

        public void onClick(View view) {
            this.f3300a.m11263a(this.f3300a.f9313e);
        }
    }

    /* compiled from: CreditCardEntry */
    /* renamed from: com.devmarvel.creditcardentry.b.a$6 */
    class C11816 implements AnimatorUpdateListener {
        /* renamed from: a */
        final /* synthetic */ C3497a f3305a;

        C11816(C3497a c3497a) {
            this.f3305a = c3497a;
        }

        @TargetApi(12)
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3305a.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* compiled from: CreditCardEntry */
    /* renamed from: com.devmarvel.creditcardentry.b.a$a */
    static class C1183a extends BaseSavedState {
        public static final Creator<C1183a> CREATOR = C0392e.m1170a(new C34961());
        /* renamed from: a */
        SparseArray f3308a;

        /* compiled from: CreditCardEntry */
        /* renamed from: com.devmarvel.creditcardentry.b.a$a$1 */
        static class C34961 implements C0393f<C1183a> {
            C34961() {
            }

            /* renamed from: a */
            public /* synthetic */ Object mo817a(Parcel parcel, ClassLoader classLoader) {
                return m11244b(parcel, classLoader);
            }

            /* renamed from: a */
            public /* synthetic */ Object[] mo818a(int i) {
                return m11245b(i);
            }

            /* renamed from: b */
            public C1183a m11244b(Parcel parcel, ClassLoader classLoader) {
                return new C1183a(parcel, classLoader);
            }

            /* renamed from: b */
            public C1183a[] m11245b(int i) {
                return new C1183a[i];
            }
        }

        C1183a(Parcelable parcelable) {
            super(parcelable);
        }

        private C1183a(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            this.f3308a = parcel.readSparseArray(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeSparseArray(this.f3308a);
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }

    public C3497a(Context context, boolean z, boolean z2, boolean z3, AttributeSet attributeSet, int i) {
        int width;
        super(context);
        this.f9309a = context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1172f.CreditCardForm, 0, 0);
        if (obtainStyledAttributes.getBoolean(C1172f.CreditCardForm_default_text_colors, false)) {
            this.f9310b = null;
        } else {
            this.f9310b = Integer.valueOf(obtainStyledAttributes.getColor(C1172f.CreditCardForm_text_color, -16777216));
        }
        this.f9326r = obtainStyledAttributes.getDimensionPixelSize(C1172f.CreditCardForm_text_size, 26);
        obtainStyledAttributes.recycle();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT < 13) {
            width = defaultDisplay.getWidth();
        } else {
            Point point = new Point();
            defaultDisplay.getSize(point);
            width = point.x;
        }
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        setOnTouchListener(this);
        View linearLayout = new LinearLayout(context);
        linearLayout.setId(C1170d.cc_entry_internal);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        this.f9313e = new C3491a(context, attributeSet);
        this.f9313e.setId(C1170d.cc_card);
        this.f9313e.setDelegate(this);
        this.f9313e.setWidth(width);
        this.f9313e.setTextSize(0, (float) this.f9326r);
        linearLayout.addView(this.f9313e);
        this.f9319k.add(this.f9313e);
        Object obj = this.f9313e;
        this.f9320l = new TextView(context);
        this.f9320l.setId(C1170d.cc_four_digits);
        this.f9320l.setTextSize(0, (float) this.f9326r);
        if (this.f9310b != null) {
            this.f9320l.setTextColor(this.f9310b.intValue());
        }
        this.f9320l.setMinWidth(m11246a(this.f9320l, "4242"));
        linearLayout.addView(this.f9320l);
        this.f9314f = new C3492c(context, attributeSet);
        this.f9314f.setTextSize(0, (float) this.f9326r);
        this.f9314f.setId(C1170d.cc_exp);
        if (z) {
            this.f9314f.setDelegate(this);
            linearLayout.addView(this.f9314f);
            this.f9317i.put(obj, this.f9314f);
            this.f9318j.put(this.f9314f, obj);
            obj = this.f9314f;
            this.f9319k.add(obj);
        }
        this.f9315g = new C3493d(context, attributeSet);
        this.f9315g.setId(C1170d.cc_ccv);
        this.f9315g.setTextSize(0, (float) this.f9326r);
        if (z2) {
            this.f9315g.setDelegate(this);
            if (!z3) {
                this.f9315g.setImeActionLabel("Done", 6);
            }
            this.f9315g.setOnEditorActionListener(new C11761(this));
            linearLayout.addView(this.f9315g);
            this.f9317i.put(obj, this.f9315g);
            this.f9318j.put(this.f9315g, obj);
            obj = this.f9315g;
            this.f9319k.add(obj);
        }
        this.f9316h = new C3494e(context, attributeSet);
        this.f9316h.setId(C1170d.cc_zip);
        this.f9316h.setTextSize(0, (float) this.f9326r);
        if (z3) {
            this.f9316h.setDelegate(this);
            linearLayout.addView(this.f9316h);
            this.f9316h.setImeActionLabel("DONE", 6);
            this.f9316h.setOnEditorActionListener(new C11772(this));
            this.f9317i.put(obj, this.f9316h);
            this.f9318j.put(this.f9316h, obj);
            obj = this.f9316h;
            this.f9319k.add(obj);
        }
        this.f9317i.put(obj, null);
        addView(linearLayout);
        this.f9320l.setOnClickListener(new C11783(this));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        i3 = ((((i3 - i) - this.f9311c.getWidth()) - this.f9314f.getWidth()) - this.f9315g.getWidth()) - 20;
        if (i3 > 0) {
            this.f9320l.setPadding(0, 0, i3, 0);
        }
    }

    /* renamed from: a */
    public void mo812a(C1190a c1190a) {
        this.f9311c.setImageResource(c1190a.f3340k);
        this.f9312d.setImageResource(c1190a.f3341l);
        m11252a((boolean) null);
    }

    /* renamed from: a */
    public void mo813a(String str) {
        m11256b(this.f9313e, str);
        m11258d();
    }

    /* renamed from: b */
    public void mo815b(String str) {
        m11256b(this.f9314f, str);
    }

    /* renamed from: c */
    public void mo816c(String str) {
        m11256b(this.f9315g, str);
        m11252a((boolean) null);
    }

    /* renamed from: a */
    public void mo810a() {
        m11256b(this.f9316h, null);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        C1183a c1183a = (C1183a) parcelable;
        super.onRestoreInstanceState(c1183a.getSuperState());
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).restoreHierarchyState(c1183a.f3308a);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c1183a = new C1183a(super.onSaveInstanceState());
        c1183a.f3308a = new SparseArray();
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).saveHierarchyState(c1183a.f3308a);
        }
        return c1183a;
    }

    /* renamed from: a */
    public void mo811a(final EditText editText) {
        if (this.f9324p) {
            editText.startAnimation(AnimationUtils.loadAnimation(this.f9309a, C1167a.shake));
        }
        editText.setTextColor(-65536);
        new Handler().postDelayed(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C3497a f3302b;

            public void run() {
                if (this.f3302b.f9310b != null) {
                    editText.setTextColor(this.f3302b.f9310b.intValue());
                }
            }
        }, 1000);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f9313e.setOnFocusChangeListener(onFocusChangeListener);
        this.f9314f.setOnFocusChangeListener(onFocusChangeListener);
        this.f9315g.setOnFocusChangeListener(onFocusChangeListener);
        this.f9316h.setOnFocusChangeListener(onFocusChangeListener);
    }

    /* renamed from: a */
    public void m11263a(C1174b c1174b) {
        m11264a(c1174b, null);
    }

    /* renamed from: a */
    public void m11264a(final C1174b c1174b, String str) {
        c1174b.requestFocus();
        if (!this.f9323o) {
            this.f9323o = true;
            m11249a(c1174b instanceof C3491a ? 0 : c1174b.getLeft(), new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C3497a f3304b;

                public void run() {
                    this.f3304b.f9323o = false;
                    if (!c1174b.hasFocus()) {
                        View focusedChild = this.f3304b.getFocusedChild();
                        if (focusedChild instanceof C1174b) {
                            this.f3304b.m11263a((C1174b) focusedChild);
                        }
                    }
                }
            });
        }
        if (str != null && str.length() > 0) {
            c1174b.mo804a(str);
        }
        if (this.f9321m != null) {
            this.f9321m.setText(c1174b.getHelperText());
        }
        if ((c1174b instanceof C3493d) != null) {
            ((C3493d) c1174b).setType(this.f9313e.getType());
            m11252a(true);
        } else {
            m11252a(false);
        }
        c1174b.setSelection(c1174b.getText().length());
    }

    /* renamed from: a */
    private void m11249a(int i, final Runnable runnable) {
        if (getScrollX() == i) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (VERSION.SDK_INT >= 12) {
            i = ValueAnimator.ofInt(new int[]{r0, i}).setDuration(500);
            i.setInterpolator(new DecelerateInterpolator());
            i.addUpdateListener(new C11816(this));
            i.addListener(new AnimatorListenerAdapter(this) {
                /* renamed from: b */
                final /* synthetic */ C3497a f3307b;

                public void onAnimationEnd(Animator animator) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
            i.start();
        } else {
            smoothScrollTo(i, 0);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* renamed from: b */
    public void mo814b(C1174b c1174b) {
        c1174b = (C1174b) this.f9318j.get(c1174b);
        if (c1174b != null) {
            m11263a(c1174b);
        }
    }

    /* renamed from: a */
    private int m11246a(TextView textView, String str) {
        Paint paint = new Paint();
        Rect rect = new Rect();
        paint.setTextSize((float) this.f9326r);
        paint.getTextBounds(str, 0, str.length(), rect);
        textView.setText(str);
        return rect.width();
    }

    public void setCardNumberHint(String str) {
        this.f9313e.setHint(str);
    }

    /* renamed from: a */
    public void m11267a(String str, boolean z) {
        m11251a(this.f9313e, str, z);
    }

    public void setCardImageView(ImageView imageView) {
        this.f9311c = imageView;
    }

    /* renamed from: b */
    public void m11270b(String str, boolean z) {
        m11251a(this.f9314f, str, z);
    }

    /* renamed from: c */
    public void m11274c(String str, boolean z) {
        m11251a(this.f9315g, str, z);
    }

    public ImageView getBackCardImage() {
        return this.f9312d;
    }

    public void setBackCardImage(ImageView imageView) {
        this.f9312d = imageView;
    }

    public TextView getTextHelper() {
        return this.f9321m;
    }

    public void setTextHelper(TextView textView) {
        this.f9321m = textView;
    }

    /* renamed from: b */
    public boolean m11271b() {
        for (C1174b b : this.f9319k) {
            if (!b.m4142b()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m11251a(C1174b c1174b, String str, boolean z) {
        if (z) {
            z = false;
        } else {
            z = c1174b.getDelegate();
            c1174b.setDelegate(m11248a((C1184b) z));
        }
        c1174b.setText(str);
        if (z) {
            c1174b.setDelegate(z);
        }
    }

    public void setAnimateOnError(boolean z) {
        this.f9324p = z;
    }

    /* renamed from: a */
    private C1184b m11248a(final C1184b c1184b) {
        return new C1184b(this) {
            /* renamed from: b */
            final /* synthetic */ C3497a f9308b;

            /* renamed from: a */
            public void mo810a() {
            }

            /* renamed from: b */
            public void mo814b(C1174b c1174b) {
            }

            /* renamed from: b */
            public void mo815b(String str) {
            }

            /* renamed from: c */
            public void mo816c(String str) {
            }

            /* renamed from: a */
            public void mo812a(C1190a c1190a) {
                c1184b.mo812a(c1190a);
            }

            /* renamed from: a */
            public void mo813a(String str) {
                this.f9308b.m11258d();
            }

            /* renamed from: a */
            public void mo811a(EditText editText) {
                c1184b.mo811a(editText);
            }
        };
    }

    public C1192c getCreditCard() {
        return new C1192c(this.f9313e.getText().toString(), this.f9314f.getText().toString(), this.f9315g.getText().toString(), this.f9316h.getText().toString(), this.f9313e.getType());
    }

    /* renamed from: c */
    public void m11272c() {
        m11263a(this.f9313e);
    }

    /* renamed from: d */
    private void m11258d() {
        String obj = this.f9313e.getText().toString();
        this.f9320l.setText(obj.substring(obj.length() - 4));
        C3497a.m11250a((View) this);
    }

    /* renamed from: a */
    private static void m11250a(View view) {
        view.measure(MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    /* renamed from: b */
    private void m11256b(C1174b c1174b, String str) {
        C1174b c1174b2 = (C1174b) this.f9317i.get(c1174b);
        if (c1174b2 == null) {
            m11255b((View) c1174b);
        } else {
            m11264a(c1174b2, str);
        }
    }

    /* renamed from: b */
    private void m11255b(View view) {
        m11260f();
        view.clearFocus();
        if (this.f9325q != null) {
            this.f9325q.m4166a(getCreditCard());
        }
    }

    /* renamed from: a */
    private void m11252a(boolean z) {
        if (this.f9322n != z) {
            m11259e();
        }
        this.f9322n = z;
    }

    /* renamed from: e */
    private void m11259e() {
        Animation c1187d = new C1187d(this.f9311c, this.f9312d);
        if (this.f9311c.getVisibility() == 8) {
            c1187d.m4159a();
        }
        this.f9311c.startAnimation(c1187d);
    }

    /* renamed from: f */
    private void m11260f() {
        ((InputMethodManager) this.f9309a.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 2);
    }

    public void setOnCardValidCallback(C1191b c1191b) {
        this.f9325q = c1191b;
    }

    public void setCreditCardTextHelper(String str) {
        this.f9313e.setHelperText(str);
    }

    public void setCreditCardTextHint(String str) {
        this.f9313e.setHint(str);
    }

    public void setExpDateTextHelper(String str) {
        this.f9314f.setHelperText(str);
    }

    public void setExpDateTextHint(String str) {
        this.f9314f.setHint(str);
    }

    public void setSecurityCodeTextHelper(String str) {
        this.f9315g.setHelperText(str);
    }

    public void setSecurityCodeTextHint(String str) {
        this.f9315g.setHint(str);
    }

    public void setZipCodeTextHelper(String str) {
        this.f9316h.setHelperText(str);
    }

    public void setZipCodeTextHint(String str) {
        this.f9316h.setHint(str);
    }

    public void setTypeface(Typeface typeface) {
        this.f9313e.setTypeface(typeface);
        this.f9314f.setTypeface(typeface);
        this.f9315g.setTypeface(typeface);
        this.f9316h.setTypeface(typeface);
        this.f9320l.setTypeface(typeface);
    }
}
