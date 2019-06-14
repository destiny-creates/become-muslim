package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.C0140a.C0136g;
import android.support.design.C0140a.C0137h;
import android.support.design.C0140a.C0138i;
import android.support.design.C0140a.C0139j;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v4.view.C0487a;
import android.support.v4.view.C0494b;
import android.support.v4.view.C0517s;
import android.support.v4.view.p033a.C0483b;
import android.support.v4.widget.C0561p;
import android.support.v4.widget.C0573r;
import android.support.v4.widget.C0580v;
import android.support.v7.p037c.p038a.C0631b;
import android.support.v7.widget.C0799m;
import android.support.v7.widget.al;
import android.support.v7.widget.bq;
import android.support.v7.widget.bz;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextInputLayout extends LinearLayout implements bz {
    private static final int ANIMATION_DURATION = 200;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimator mAnimator;
    final CollapsingTextHelper mCollapsingTextHelper;
    boolean mCounterEnabled;
    private int mCounterMaxLength;
    private int mCounterOverflowTextAppearance;
    private boolean mCounterOverflowed;
    private int mCounterTextAppearance;
    private TextView mCounterView;
    private ColorStateList mDefaultTextColor;
    EditText mEditText;
    private CharSequence mError;
    private boolean mErrorEnabled;
    private boolean mErrorShown;
    private int mErrorTextAppearance;
    TextView mErrorView;
    private ColorStateList mFocusedTextColor;
    private boolean mHasPasswordToggleTintList;
    private boolean mHasPasswordToggleTintMode;
    private boolean mHasReconstructedEditTextBackground;
    private CharSequence mHint;
    private boolean mHintAnimationEnabled;
    private boolean mHintEnabled;
    private boolean mHintExpanded;
    private boolean mInDrawableStateChanged;
    private LinearLayout mIndicatorArea;
    private int mIndicatorsAdded;
    private final FrameLayout mInputFrame;
    private Drawable mOriginalEditTextEndDrawable;
    private CharSequence mOriginalHint;
    private CharSequence mPasswordToggleContentDesc;
    private Drawable mPasswordToggleDrawable;
    private Drawable mPasswordToggleDummyDrawable;
    private boolean mPasswordToggleEnabled;
    private ColorStateList mPasswordToggleTintList;
    private Mode mPasswordToggleTintMode;
    private CheckableImageButton mPasswordToggleView;
    private boolean mPasswordToggledVisible;
    private boolean mRestoringSavedState;
    private Paint mTmpPaint;
    private final Rect mTmpRect;
    private Typeface mTypeface;

    /* renamed from: android.support.design.widget.TextInputLayout$1 */
    class C01601 implements TextWatcher {
        /* renamed from: a */
        final /* synthetic */ TextInputLayout f356a;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        C01601(TextInputLayout textInputLayout) {
            this.f356a = textInputLayout;
        }

        public void afterTextChanged(Editable editable) {
            this.f356a.updateLabelState(this.f356a.mRestoringSavedState ^ 1);
            if (this.f356a.mCounterEnabled) {
                this.f356a.updateCounter(editable.length());
            }
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$2 */
    class C01612 extends AnimatorListenerAdapter {
        /* renamed from: a */
        final /* synthetic */ TextInputLayout f357a;

        C01612(TextInputLayout textInputLayout) {
            this.f357a = textInputLayout;
        }

        public void onAnimationStart(Animator animator) {
            this.f357a.mErrorView.setVisibility(0);
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$4 */
    class C01634 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ TextInputLayout f360a;

        C01634(TextInputLayout textInputLayout) {
            this.f360a = textInputLayout;
        }

        public void onClick(View view) {
            this.f360a.passwordVisibilityToggleRequested(false);
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$5 */
    class C01645 implements AnimatorUpdateListener {
        /* renamed from: a */
        final /* synthetic */ TextInputLayout f361a;

        C01645(TextInputLayout textInputLayout) {
            this.f361a = textInputLayout;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f361a.mCollapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$a */
    static class C3129a extends C0487a {
        public static final Creator<C3129a> CREATOR = new C01651();
        /* renamed from: a */
        CharSequence f8028a;
        /* renamed from: b */
        boolean f8029b;

        /* renamed from: android.support.design.widget.TextInputLayout$a$1 */
        static class C01651 implements ClassLoaderCreator<C3129a> {
            C01651() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m373a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m374a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m375a(i);
            }

            /* renamed from: a */
            public C3129a m374a(Parcel parcel, ClassLoader classLoader) {
                return new C3129a(parcel, classLoader);
            }

            /* renamed from: a */
            public C3129a m373a(Parcel parcel) {
                return new C3129a(parcel, null);
            }

            /* renamed from: a */
            public C3129a[] m375a(int i) {
                return new C3129a[i];
            }
        }

        C3129a(Parcelable parcelable) {
            super(parcelable);
        }

        C3129a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8028a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            classLoader = true;
            if (parcel.readInt() != 1) {
                classLoader = null;
            }
            this.f8029b = classLoader;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f8028a, parcel, i);
            parcel.writeInt(this.f8029b);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TextInputLayout.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" error=");
            stringBuilder.append(this.f8028a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$b */
    private class C3130b extends C0494b {
        /* renamed from: a */
        final /* synthetic */ TextInputLayout f8030a;

        C3130b(TextInputLayout textInputLayout) {
            this.f8030a = textInputLayout;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            view = this.f8030a.mCollapsingTextHelper.getText();
            if (!TextUtils.isEmpty(view)) {
                accessibilityEvent.getText().add(view);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0483b c0483b) {
            super.onInitializeAccessibilityNodeInfo(view, c0483b);
            c0483b.m1512b(TextInputLayout.class.getSimpleName());
            CharSequence text = this.f8030a.mCollapsingTextHelper.getText();
            if (!TextUtils.isEmpty(text)) {
                c0483b.m1517c(text);
            }
            if (this.f8030a.mEditText != null) {
                c0483b.m1521d(this.f8030a.mEditText);
            }
            text = this.f8030a.mErrorView != null ? this.f8030a.mErrorView.getText() : null;
            if (!TextUtils.isEmpty(text)) {
                c0483b.m1541l(true);
                c0483b.m1525e(text);
            }
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mTmpRect = new Rect();
        this.mCollapsingTextHelper = new CollapsingTextHelper(this);
        C0197n.m454a(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.mInputFrame = new FrameLayout(context);
        this.mInputFrame.setAddStatesFromChildren(true);
        addView(this.mInputFrame);
        this.mCollapsingTextHelper.setTextSizeInterpolator(C0166a.f363b);
        this.mCollapsingTextHelper.setPositionInterpolator(new AccelerateInterpolator());
        this.mCollapsingTextHelper.setCollapsedTextGravity(8388659);
        context = bq.m2769a(context, attributeSet, C0139j.TextInputLayout, i, C0138i.Widget_Design_TextInputLayout);
        this.mHintEnabled = context.m2775a(C0139j.TextInputLayout_hintEnabled, true);
        setHint(context.m2779c(C0139j.TextInputLayout_android_hint));
        this.mHintAnimationEnabled = context.m2775a(C0139j.TextInputLayout_hintAnimationEnabled, true);
        if (context.m2787g(C0139j.TextInputLayout_android_textColorHint) != null) {
            attributeSet = context.m2783e(C0139j.TextInputLayout_android_textColorHint);
            this.mFocusedTextColor = attributeSet;
            this.mDefaultTextColor = attributeSet;
        }
        if (context.m2786g(C0139j.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(context.m2786g(C0139j.TextInputLayout_hintTextAppearance, 0));
        }
        this.mErrorTextAppearance = context.m2786g(C0139j.TextInputLayout_errorTextAppearance, 0);
        attributeSet = context.m2775a(C0139j.TextInputLayout_errorEnabled, false);
        boolean a = context.m2775a(C0139j.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(context.m2771a(C0139j.TextInputLayout_counterMaxLength, -1));
        this.mCounterTextAppearance = context.m2786g(C0139j.TextInputLayout_counterTextAppearance, 0);
        this.mCounterOverflowTextAppearance = context.m2786g(C0139j.TextInputLayout_counterOverflowTextAppearance, 0);
        this.mPasswordToggleEnabled = context.m2775a(C0139j.TextInputLayout_passwordToggleEnabled, false);
        this.mPasswordToggleDrawable = context.m2773a(C0139j.TextInputLayout_passwordToggleDrawable);
        this.mPasswordToggleContentDesc = context.m2779c(C0139j.TextInputLayout_passwordToggleContentDescription);
        if (context.m2787g(C0139j.TextInputLayout_passwordToggleTint)) {
            this.mHasPasswordToggleTintList = true;
            this.mPasswordToggleTintList = context.m2783e(C0139j.TextInputLayout_passwordToggleTint);
        }
        if (context.m2787g(C0139j.TextInputLayout_passwordToggleTintMode)) {
            this.mHasPasswordToggleTintMode = true;
            this.mPasswordToggleTintMode = C0199q.m460a(context.m2771a(C0139j.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        context.m2774a();
        setErrorEnabled(attributeSet);
        setCounterEnabled(a);
        applyPasswordToggleTint();
        if (C0517s.m1709d(this) == null) {
            C0517s.m1688a((View) this, 1);
        }
        C0517s.m1695a((View) this, new C3130b(this));
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof EditText) {
            i = new FrameLayout.LayoutParams(layoutParams);
            i.gravity = (i.gravity & -113) | 16;
            this.mInputFrame.addView(view, i);
            this.mInputFrame.setLayoutParams(layoutParams);
            updateInputLayoutMargins();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void setTypeface(Typeface typeface) {
        if ((this.mTypeface != null && !this.mTypeface.equals(typeface)) || (this.mTypeface == null && typeface != null)) {
            this.mTypeface = typeface;
            this.mCollapsingTextHelper.setTypefaces(typeface);
            if (this.mCounterView != null) {
                this.mCounterView.setTypeface(typeface);
            }
            if (this.mErrorView != null) {
                this.mErrorView.setTypeface(typeface);
            }
        }
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        if (this.mOriginalHint != null) {
            if (this.mEditText != null) {
                CharSequence hint = this.mEditText.getHint();
                this.mEditText.setHint(this.mOriginalHint);
                try {
                    super.dispatchProvideAutofillStructure(viewStructure, i);
                    return;
                } finally {
                    this.mEditText.setHint(hint);
                }
            }
        }
        super.dispatchProvideAutofillStructure(viewStructure, i);
    }

    private void setEditText(EditText editText) {
        if (this.mEditText == null) {
            if (!(editText instanceof C4445m)) {
                Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.mEditText = editText;
            if (hasPasswordTransformation() == null) {
                this.mCollapsingTextHelper.setTypefaces(this.mEditText.getTypeface());
            }
            this.mCollapsingTextHelper.setExpandedTextSize(this.mEditText.getTextSize());
            editText = this.mEditText.getGravity();
            this.mCollapsingTextHelper.setCollapsedTextGravity((editText & -113) | 48);
            this.mCollapsingTextHelper.setExpandedTextGravity(editText);
            this.mEditText.addTextChangedListener(new C01601(this));
            if (this.mDefaultTextColor == null) {
                this.mDefaultTextColor = this.mEditText.getHintTextColors();
            }
            if (!(this.mHintEnabled == null || TextUtils.isEmpty(this.mHint) == null)) {
                this.mOriginalHint = this.mEditText.getHint();
                setHint(this.mOriginalHint);
                this.mEditText.setHint(null);
            }
            if (this.mCounterView != null) {
                updateCounter(this.mEditText.getText().length());
            }
            if (this.mIndicatorArea != null) {
                adjustIndicatorPadding();
            }
            updatePasswordToggleView();
            updateLabelState(null, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void updateInputLayoutMargins() {
        int i;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mInputFrame.getLayoutParams();
        if (this.mHintEnabled) {
            if (this.mTmpPaint == null) {
                this.mTmpPaint = new Paint();
            }
            this.mTmpPaint.setTypeface(this.mCollapsingTextHelper.getCollapsedTypeface());
            this.mTmpPaint.setTextSize(this.mCollapsingTextHelper.getCollapsedTextSize());
            i = (int) (-this.mTmpPaint.ascent());
        } else {
            i = 0;
        }
        if (i != layoutParams.topMargin) {
            layoutParams.topMargin = i;
            this.mInputFrame.requestLayout();
        }
    }

    void updateLabelState(boolean z) {
        updateLabelState(z, false);
    }

    void updateLabelState(boolean z, boolean z2) {
        boolean isEnabled = isEnabled();
        Object obj = (this.mEditText == null || TextUtils.isEmpty(this.mEditText.getText())) ? null : 1;
        boolean arrayContains = arrayContains(getDrawableState(), 16842908);
        int isEmpty = 1 ^ TextUtils.isEmpty(getError());
        if (this.mDefaultTextColor != null) {
            this.mCollapsingTextHelper.setExpandedTextColor(this.mDefaultTextColor);
        }
        if (isEnabled && this.mCounterOverflowed && this.mCounterView != null) {
            this.mCollapsingTextHelper.setCollapsedTextColor(this.mCounterView.getTextColors());
        } else if (isEnabled && arrayContains && this.mFocusedTextColor != null) {
            this.mCollapsingTextHelper.setCollapsedTextColor(this.mFocusedTextColor);
        } else if (this.mDefaultTextColor != null) {
            this.mCollapsingTextHelper.setCollapsedTextColor(this.mDefaultTextColor);
        }
        if (obj == null) {
            if (isEnabled()) {
                if (!arrayContains) {
                    if (isEmpty != 0) {
                    }
                }
            }
            if (z2 || !this.mHintExpanded) {
                expandHint(z);
                return;
            }
            return;
        }
        if (z2 || this.mHintExpanded) {
            collapseHint(z);
        }
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    public void setHint(CharSequence charSequence) {
        if (this.mHintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        this.mHint = charSequence;
        this.mCollapsingTextHelper.setText(charSequence);
    }

    public CharSequence getHint() {
        return this.mHintEnabled ? this.mHint : null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.mHintEnabled) {
            this.mHintEnabled = z;
            z = this.mEditText.getHint();
            if (!this.mHintEnabled) {
                if (!TextUtils.isEmpty(this.mHint) && TextUtils.isEmpty(z)) {
                    this.mEditText.setHint(this.mHint);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(z)) {
                if (TextUtils.isEmpty(this.mHint)) {
                    setHint(z);
                }
                this.mEditText.setHint(null);
            }
            if (this.mEditText) {
                updateInputLayoutMargins();
            }
        }
    }

    public boolean isHintEnabled() {
        return this.mHintEnabled;
    }

    public void setHintTextAppearance(int i) {
        this.mCollapsingTextHelper.setCollapsedTextAppearance(i);
        this.mFocusedTextColor = this.mCollapsingTextHelper.getCollapsedTextColor();
        if (this.mEditText != 0) {
            updateLabelState(0);
            updateInputLayoutMargins();
        }
    }

    private void addIndicator(TextView textView, int i) {
        if (this.mIndicatorArea == null) {
            this.mIndicatorArea = new LinearLayout(getContext());
            this.mIndicatorArea.setOrientation(0);
            addView(this.mIndicatorArea, -1, -2);
            this.mIndicatorArea.addView(new C0561p(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.mEditText != null) {
                adjustIndicatorPadding();
            }
        }
        this.mIndicatorArea.setVisibility(0);
        this.mIndicatorArea.addView(textView, i);
        this.mIndicatorsAdded++;
    }

    private void adjustIndicatorPadding() {
        C0517s.m1690a(this.mIndicatorArea, C0517s.m1713g(this.mEditText), 0, C0517s.m1714h(this.mEditText), this.mEditText.getPaddingBottom());
    }

    private void removeIndicator(TextView textView) {
        if (this.mIndicatorArea != null) {
            this.mIndicatorArea.removeView(textView);
            textView = this.mIndicatorsAdded - 1;
            this.mIndicatorsAdded = textView;
            if (textView == null) {
                this.mIndicatorArea.setVisibility(8);
            }
        }
    }

    public void setErrorEnabled(boolean r6) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r5 = this;
        r0 = r5.mErrorEnabled;
        if (r0 == r6) goto L_0x008a;
    L_0x0004:
        r0 = r5.mErrorView;
        if (r0 == 0) goto L_0x0011;
    L_0x0008:
        r0 = r5.mErrorView;
        r0 = r0.animate();
        r0.cancel();
    L_0x0011:
        r0 = 0;
        if (r6 == 0) goto L_0x007b;
    L_0x0014:
        r1 = new android.support.v7.widget.AppCompatTextView;
        r2 = r5.getContext();
        r1.<init>(r2);
        r5.mErrorView = r1;
        r1 = r5.mErrorView;
        r2 = android.support.design.C0140a.C0134e.textinput_error;
        r1.setId(r2);
        r1 = r5.mTypeface;
        if (r1 == 0) goto L_0x0031;
    L_0x002a:
        r1 = r5.mErrorView;
        r2 = r5.mTypeface;
        r1.setTypeface(r2);
    L_0x0031:
        r1 = 1;
        r2 = r5.mErrorView;	 Catch:{ Exception -> 0x0051 }
        r3 = r5.mErrorTextAppearance;	 Catch:{ Exception -> 0x0051 }
        android.support.v4.widget.C0573r.m1902a(r2, r3);	 Catch:{ Exception -> 0x0051 }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0051 }
        r3 = 23;	 Catch:{ Exception -> 0x0051 }
        if (r2 < r3) goto L_0x004f;	 Catch:{ Exception -> 0x0051 }
    L_0x003f:
        r2 = r5.mErrorView;	 Catch:{ Exception -> 0x0051 }
        r2 = r2.getTextColors();	 Catch:{ Exception -> 0x0051 }
        r2 = r2.getDefaultColor();	 Catch:{ Exception -> 0x0051 }
        r3 = -65281; // 0xffffffffffff00ff float:NaN double:NaN;
        if (r2 != r3) goto L_0x004f;
    L_0x004e:
        goto L_0x0051;
    L_0x004f:
        r2 = 0;
        goto L_0x0052;
    L_0x0051:
        r2 = 1;
    L_0x0052:
        if (r2 == 0) goto L_0x006a;
    L_0x0054:
        r2 = r5.mErrorView;
        r3 = android.support.v7.p035a.C0591a.C0589i.TextAppearance_AppCompat_Caption;
        android.support.v4.widget.C0573r.m1902a(r2, r3);
        r2 = r5.mErrorView;
        r3 = r5.getContext();
        r4 = android.support.v7.p035a.C0591a.C0583c.error_color_material;
        r3 = android.support.v4.content.C0366b.m1112c(r3, r4);
        r2.setTextColor(r3);
    L_0x006a:
        r2 = r5.mErrorView;
        r3 = 4;
        r2.setVisibility(r3);
        r2 = r5.mErrorView;
        android.support.v4.view.C0517s.m1703b(r2, r1);
        r1 = r5.mErrorView;
        r5.addIndicator(r1, r0);
        goto L_0x0088;
    L_0x007b:
        r5.mErrorShown = r0;
        r5.updateEditTextBackground();
        r0 = r5.mErrorView;
        r5.removeIndicator(r0);
        r0 = 0;
        r5.mErrorView = r0;
    L_0x0088:
        r5.mErrorEnabled = r6;
    L_0x008a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TextInputLayout.setErrorEnabled(boolean):void");
    }

    public void setErrorTextAppearance(int i) {
        this.mErrorTextAppearance = i;
        if (this.mErrorView != null) {
            C0573r.m1902a(this.mErrorView, i);
        }
    }

    public boolean isErrorEnabled() {
        return this.mErrorEnabled;
    }

    public void setError(CharSequence charSequence) {
        boolean z = C0517s.m1730x(this) && isEnabled() && (this.mErrorView == null || !TextUtils.equals(this.mErrorView.getText(), charSequence));
        setError(charSequence, z);
    }

    private void setError(final CharSequence charSequence, boolean z) {
        this.mError = charSequence;
        if (!this.mErrorEnabled) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        this.mErrorShown = TextUtils.isEmpty(charSequence) ^ true;
        this.mErrorView.animate().cancel();
        if (this.mErrorShown) {
            this.mErrorView.setText(charSequence);
            this.mErrorView.setVisibility(0);
            if (z) {
                if (this.mErrorView.getAlpha() == 1.0f) {
                    this.mErrorView.setAlpha(0.0f);
                }
                this.mErrorView.animate().alpha(1.0f).setDuration(200).setInterpolator(C0166a.f365d).setListener(new C01612(this)).start();
            } else {
                this.mErrorView.setAlpha(1.0f);
            }
        } else if (this.mErrorView.getVisibility() == 0) {
            if (z) {
                this.mErrorView.animate().alpha(0.0f).setDuration(200).setInterpolator(C0166a.f364c).setListener(new AnimatorListenerAdapter(this) {
                    /* renamed from: b */
                    final /* synthetic */ TextInputLayout f359b;

                    public void onAnimationEnd(Animator animator) {
                        this.f359b.mErrorView.setText(charSequence);
                        this.f359b.mErrorView.setVisibility(4);
                    }
                }).start();
            } else {
                this.mErrorView.setText(charSequence);
                this.mErrorView.setVisibility(4);
            }
        }
        updateEditTextBackground();
        updateLabelState(z);
    }

    public void setCounterEnabled(boolean r4) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = r3.mCounterEnabled;
        if (r0 == r4) goto L_0x006e;
    L_0x0004:
        if (r4 == 0) goto L_0x0064;
    L_0x0006:
        r0 = new android.support.v7.widget.AppCompatTextView;
        r1 = r3.getContext();
        r0.<init>(r1);
        r3.mCounterView = r0;
        r0 = r3.mCounterView;
        r1 = android.support.design.C0140a.C0134e.textinput_counter;
        r0.setId(r1);
        r0 = r3.mTypeface;
        if (r0 == 0) goto L_0x0023;
    L_0x001c:
        r0 = r3.mCounterView;
        r1 = r3.mTypeface;
        r0.setTypeface(r1);
    L_0x0023:
        r0 = r3.mCounterView;
        r1 = 1;
        r0.setMaxLines(r1);
        r0 = r3.mCounterView;	 Catch:{ Exception -> 0x0031 }
        r1 = r3.mCounterTextAppearance;	 Catch:{ Exception -> 0x0031 }
        android.support.v4.widget.C0573r.m1902a(r0, r1);	 Catch:{ Exception -> 0x0031 }
        goto L_0x0047;
    L_0x0031:
        r0 = r3.mCounterView;
        r1 = android.support.v7.p035a.C0591a.C0589i.TextAppearance_AppCompat_Caption;
        android.support.v4.widget.C0573r.m1902a(r0, r1);
        r0 = r3.mCounterView;
        r1 = r3.getContext();
        r2 = android.support.v7.p035a.C0591a.C0583c.error_color_material;
        r1 = android.support.v4.content.C0366b.m1112c(r1, r2);
        r0.setTextColor(r1);
    L_0x0047:
        r0 = r3.mCounterView;
        r1 = -1;
        r3.addIndicator(r0, r1);
        r0 = r3.mEditText;
        if (r0 != 0) goto L_0x0056;
    L_0x0051:
        r0 = 0;
        r3.updateCounter(r0);
        goto L_0x006c;
    L_0x0056:
        r0 = r3.mEditText;
        r0 = r0.getText();
        r0 = r0.length();
        r3.updateCounter(r0);
        goto L_0x006c;
    L_0x0064:
        r0 = r3.mCounterView;
        r3.removeIndicator(r0);
        r0 = 0;
        r3.mCounterView = r0;
    L_0x006c:
        r3.mCounterEnabled = r4;
    L_0x006e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TextInputLayout.setCounterEnabled(boolean):void");
    }

    public boolean isCounterEnabled() {
        return this.mCounterEnabled;
    }

    public void setCounterMaxLength(int i) {
        if (this.mCounterMaxLength != i) {
            if (i > 0) {
                this.mCounterMaxLength = i;
            } else {
                this.mCounterMaxLength = -1;
            }
            if (this.mCounterEnabled != 0) {
                updateCounter(this.mEditText == 0 ? 0 : this.mEditText.getText().length());
            }
        }
    }

    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    private static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.mCounterMaxLength;
    }

    void updateCounter(int i) {
        boolean z = this.mCounterOverflowed;
        if (this.mCounterMaxLength == -1) {
            this.mCounterView.setText(String.valueOf(i));
            this.mCounterOverflowed = false;
        } else {
            this.mCounterOverflowed = i > this.mCounterMaxLength;
            if (z != this.mCounterOverflowed) {
                C0573r.m1902a(this.mCounterView, this.mCounterOverflowed ? this.mCounterOverflowTextAppearance : this.mCounterTextAppearance);
            }
            this.mCounterView.setText(getContext().getString(C0137h.character_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.mCounterMaxLength)}));
        }
        if (this.mEditText != 0 && z != this.mCounterOverflowed) {
            updateLabelState(false);
            updateEditTextBackground();
        }
    }

    private void updateEditTextBackground() {
        if (this.mEditText != null) {
            Drawable background = this.mEditText.getBackground();
            if (background != null) {
                ensureBackgroundDrawableStateWorkaround();
                if (al.m2615c(background)) {
                    background = background.mutate();
                }
                if (this.mErrorShown && this.mErrorView != null) {
                    background.setColorFilter(C0799m.m2892a(this.mErrorView.getCurrentTextColor(), Mode.SRC_IN));
                } else if (!this.mCounterOverflowed || this.mCounterView == null) {
                    C0259a.m702f(background);
                    this.mEditText.refreshDrawableState();
                } else {
                    background.setColorFilter(C0799m.m2892a(this.mCounterView.getCurrentTextColor(), Mode.SRC_IN));
                }
            }
        }
    }

    private void ensureBackgroundDrawableStateWorkaround() {
        int i = VERSION.SDK_INT;
        if (i == 21 || i == 22) {
            Drawable background = this.mEditText.getBackground();
            if (!(background == null || this.mHasReconstructedEditTextBackground)) {
                Drawable newDrawable = background.getConstantState().newDrawable();
                if (background instanceof DrawableContainer) {
                    this.mHasReconstructedEditTextBackground = C0181d.m398a((DrawableContainer) background, newDrawable.getConstantState());
                }
                if (!this.mHasReconstructedEditTextBackground) {
                    C0517s.m1694a(this.mEditText, newDrawable);
                    this.mHasReconstructedEditTextBackground = true;
                }
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable c3129a = new C3129a(super.onSaveInstanceState());
        if (this.mErrorShown) {
            c3129a.f8028a = getError();
        }
        c3129a.f8029b = this.mPasswordToggledVisible;
        return c3129a;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C3129a) {
            C3129a c3129a = (C3129a) parcelable;
            super.onRestoreInstanceState(c3129a.m1558a());
            setError(c3129a.f8028a);
            if (c3129a.f8029b != null) {
                passwordVisibilityToggleRequested(true);
            }
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.mRestoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.mRestoringSavedState = null;
    }

    public CharSequence getError() {
        return this.mErrorEnabled ? this.mError : null;
    }

    public boolean isHintAnimationEnabled() {
        return this.mHintAnimationEnabled;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.mHintAnimationEnabled = z;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mHintEnabled) {
            this.mCollapsingTextHelper.draw(canvas);
        }
    }

    protected void onMeasure(int i, int i2) {
        updatePasswordToggleView();
        super.onMeasure(i, i2);
    }

    private void updatePasswordToggleView() {
        if (this.mEditText != null) {
            Drawable[] a;
            if (shouldShowPasswordIcon()) {
                if (this.mPasswordToggleView == null) {
                    this.mPasswordToggleView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(C0136g.design_text_input_password_icon, this.mInputFrame, false);
                    this.mPasswordToggleView.setImageDrawable(this.mPasswordToggleDrawable);
                    this.mPasswordToggleView.setContentDescription(this.mPasswordToggleContentDesc);
                    this.mInputFrame.addView(this.mPasswordToggleView);
                    this.mPasswordToggleView.setOnClickListener(new C01634(this));
                }
                if (this.mEditText != null && C0517s.m1716j(this.mEditText) <= 0) {
                    this.mEditText.setMinimumHeight(C0517s.m1716j(this.mPasswordToggleView));
                }
                this.mPasswordToggleView.setVisibility(0);
                this.mPasswordToggleView.setChecked(this.mPasswordToggledVisible);
                if (this.mPasswordToggleDummyDrawable == null) {
                    this.mPasswordToggleDummyDrawable = new ColorDrawable();
                }
                this.mPasswordToggleDummyDrawable.setBounds(0, 0, this.mPasswordToggleView.getMeasuredWidth(), 1);
                a = C0573r.m1904a(this.mEditText);
                if (a[2] != this.mPasswordToggleDummyDrawable) {
                    this.mOriginalEditTextEndDrawable = a[2];
                }
                C0573r.m1903a(this.mEditText, a[0], a[1], this.mPasswordToggleDummyDrawable, a[3]);
                this.mPasswordToggleView.setPadding(this.mEditText.getPaddingLeft(), this.mEditText.getPaddingTop(), this.mEditText.getPaddingRight(), this.mEditText.getPaddingBottom());
            } else {
                if (this.mPasswordToggleView != null && this.mPasswordToggleView.getVisibility() == 0) {
                    this.mPasswordToggleView.setVisibility(8);
                }
                if (this.mPasswordToggleDummyDrawable != null) {
                    a = C0573r.m1904a(this.mEditText);
                    if (a[2] == this.mPasswordToggleDummyDrawable) {
                        C0573r.m1903a(this.mEditText, a[0], a[1], this.mOriginalEditTextEndDrawable, a[3]);
                        this.mPasswordToggleDummyDrawable = null;
                    }
                }
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? C0631b.m2112b(getContext(), i) : 0);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.mPasswordToggleDrawable = drawable;
        if (this.mPasswordToggleView != null) {
            this.mPasswordToggleView.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : 0);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.mPasswordToggleContentDesc = charSequence;
        if (this.mPasswordToggleView != null) {
            this.mPasswordToggleView.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.mPasswordToggleDrawable;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.mPasswordToggleContentDesc;
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        return this.mPasswordToggleEnabled;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.mPasswordToggleEnabled != z) {
            this.mPasswordToggleEnabled = z;
            if (!z && this.mPasswordToggledVisible && this.mEditText) {
                this.mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.mPasswordToggledVisible = false;
            updatePasswordToggleView();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.mPasswordToggleTintList = colorStateList;
        this.mHasPasswordToggleTintList = true;
        applyPasswordToggleTint();
    }

    public void setPasswordVisibilityToggleTintMode(Mode mode) {
        this.mPasswordToggleTintMode = mode;
        this.mHasPasswordToggleTintMode = true;
        applyPasswordToggleTint();
    }

    private void passwordVisibilityToggleRequested(boolean z) {
        if (this.mPasswordToggleEnabled) {
            int selectionEnd = this.mEditText.getSelectionEnd();
            if (hasPasswordTransformation()) {
                this.mEditText.setTransformationMethod(null);
                this.mPasswordToggledVisible = true;
            } else {
                this.mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.mPasswordToggledVisible = false;
            }
            this.mPasswordToggleView.setChecked(this.mPasswordToggledVisible);
            if (z) {
                this.mPasswordToggleView.jumpDrawablesToCurrentState();
            }
            this.mEditText.setSelection(selectionEnd);
        }
    }

    private boolean hasPasswordTransformation() {
        return this.mEditText != null && (this.mEditText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean shouldShowPasswordIcon() {
        return this.mPasswordToggleEnabled && (hasPasswordTransformation() || this.mPasswordToggledVisible);
    }

    private void applyPasswordToggleTint() {
        if (this.mPasswordToggleDrawable == null) {
            return;
        }
        if (this.mHasPasswordToggleTintList || this.mHasPasswordToggleTintMode) {
            this.mPasswordToggleDrawable = C0259a.m703g(this.mPasswordToggleDrawable).mutate();
            if (this.mHasPasswordToggleTintList) {
                C0259a.m692a(this.mPasswordToggleDrawable, this.mPasswordToggleTintList);
            }
            if (this.mHasPasswordToggleTintMode) {
                C0259a.m695a(this.mPasswordToggleDrawable, this.mPasswordToggleTintMode);
            }
            if (this.mPasswordToggleView != null && this.mPasswordToggleView.getDrawable() != this.mPasswordToggleDrawable) {
                this.mPasswordToggleView.setImageDrawable(this.mPasswordToggleDrawable);
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mHintEnabled && this.mEditText) {
            z = this.mTmpRect;
            C0580v.m1962b(this, this.mEditText, z);
            i = z.left + this.mEditText.getCompoundPaddingLeft();
            i3 = z.right - this.mEditText.getCompoundPaddingRight();
            this.mCollapsingTextHelper.setExpandedBounds(i, z.top + this.mEditText.getCompoundPaddingTop(), i3, z.bottom - this.mEditText.getCompoundPaddingBottom());
            this.mCollapsingTextHelper.setCollapsedBounds(i, getPaddingTop(), i3, (i4 - i2) - getPaddingBottom());
            this.mCollapsingTextHelper.recalculate();
        }
    }

    private void collapseHint(boolean z) {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (z && this.mHintAnimationEnabled) {
            animateToExpansionFraction(1.0f);
        } else {
            this.mCollapsingTextHelper.setExpansionFraction(1.0f);
        }
        this.mHintExpanded = false;
    }

    protected void drawableStateChanged() {
        if (!this.mInDrawableStateChanged) {
            boolean z = true;
            this.mInDrawableStateChanged = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            if (!C0517s.m1730x(this) || !isEnabled()) {
                z = false;
            }
            updateLabelState(z);
            updateEditTextBackground();
            if ((this.mCollapsingTextHelper != null ? this.mCollapsingTextHelper.setState(drawableState) | 0 : 0) != 0) {
                invalidate();
            }
            this.mInDrawableStateChanged = false;
        }
    }

    private void expandHint(boolean z) {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (z && this.mHintAnimationEnabled) {
            animateToExpansionFraction(0.0f);
        } else {
            this.mCollapsingTextHelper.setExpansionFraction(0.0f);
        }
        this.mHintExpanded = true;
    }

    void animateToExpansionFraction(float f) {
        if (this.mCollapsingTextHelper.getExpansionFraction() != f) {
            if (this.mAnimator == null) {
                this.mAnimator = new ValueAnimator();
                this.mAnimator.setInterpolator(C0166a.f362a);
                this.mAnimator.setDuration(200);
                this.mAnimator.addUpdateListener(new C01645(this));
            }
            this.mAnimator.setFloatValues(new float[]{this.mCollapsingTextHelper.getExpansionFraction(), f});
            this.mAnimator.start();
        }
    }

    final boolean isHintExpanded() {
        return this.mHintExpanded;
    }

    private static boolean arrayContains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return 1;
            }
        }
        return false;
    }
}
