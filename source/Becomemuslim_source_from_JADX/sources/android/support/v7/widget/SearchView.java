package android.support.v7.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0487a;
import android.support.v4.widget.C3235f;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0584d;
import android.support.v7.view.C0641c;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.NativeProtocol;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends as implements C0641c {
    /* renamed from: i */
    static final C0720a f8634i = new C0720a();
    /* renamed from: A */
    private OnClickListener f8635A;
    /* renamed from: B */
    private boolean f8636B;
    /* renamed from: C */
    private boolean f8637C;
    /* renamed from: D */
    private boolean f8638D;
    /* renamed from: E */
    private CharSequence f8639E;
    /* renamed from: F */
    private boolean f8640F;
    /* renamed from: G */
    private boolean f8641G;
    /* renamed from: H */
    private int f8642H;
    /* renamed from: I */
    private boolean f8643I;
    /* renamed from: J */
    private CharSequence f8644J;
    /* renamed from: K */
    private boolean f8645K;
    /* renamed from: L */
    private int f8646L;
    /* renamed from: M */
    private Bundle f8647M;
    /* renamed from: N */
    private final Runnable f8648N;
    /* renamed from: O */
    private Runnable f8649O;
    /* renamed from: P */
    private final WeakHashMap<String, ConstantState> f8650P;
    /* renamed from: a */
    final SearchAutoComplete f8651a;
    /* renamed from: b */
    final ImageView f8652b;
    /* renamed from: c */
    final ImageView f8653c;
    /* renamed from: d */
    final ImageView f8654d;
    /* renamed from: e */
    final ImageView f8655e;
    /* renamed from: f */
    OnFocusChangeListener f8656f;
    /* renamed from: g */
    C3235f f8657g;
    /* renamed from: h */
    SearchableInfo f8658h;
    /* renamed from: j */
    private final View f8659j;
    /* renamed from: k */
    private final View f8660k;
    /* renamed from: l */
    private C0725f f8661l;
    /* renamed from: m */
    private Rect f8662m;
    /* renamed from: n */
    private Rect f8663n;
    /* renamed from: o */
    private int[] f8664o;
    /* renamed from: p */
    private int[] f8665p;
    /* renamed from: q */
    private final ImageView f8666q;
    /* renamed from: r */
    private final Drawable f8667r;
    /* renamed from: s */
    private final int f8668s;
    /* renamed from: t */
    private final int f8669t;
    /* renamed from: u */
    private final Intent f8670u;
    /* renamed from: v */
    private final Intent f8671v;
    /* renamed from: w */
    private final CharSequence f8672w;
    /* renamed from: x */
    private C0722c f8673x;
    /* renamed from: y */
    private C0721b f8674y;
    /* renamed from: z */
    private C0723d f8675z;

    /* renamed from: android.support.v7.widget.SearchView$a */
    private static class C0720a {
        /* renamed from: a */
        private Method f1865a;
        /* renamed from: b */
        private Method f1866b;
        /* renamed from: c */
        private Method f1867c;

        C0720a() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r6 = this;
            r6.<init>();
            r0 = 0;
            r1 = 1;
            r2 = android.widget.AutoCompleteTextView.class;	 Catch:{ NoSuchMethodException -> 0x0016 }
            r3 = "doBeforeTextChanged";	 Catch:{ NoSuchMethodException -> 0x0016 }
            r4 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0016 }
            r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0016 }
            r6.f1865a = r2;	 Catch:{ NoSuchMethodException -> 0x0016 }
            r2 = r6.f1865a;	 Catch:{ NoSuchMethodException -> 0x0016 }
            r2.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x0016 }
        L_0x0016:
            r2 = android.widget.AutoCompleteTextView.class;	 Catch:{ NoSuchMethodException -> 0x0027 }
            r3 = "doAfterTextChanged";	 Catch:{ NoSuchMethodException -> 0x0027 }
            r4 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0027 }
            r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0027 }
            r6.f1866b = r2;	 Catch:{ NoSuchMethodException -> 0x0027 }
            r2 = r6.f1866b;	 Catch:{ NoSuchMethodException -> 0x0027 }
            r2.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x0027 }
        L_0x0027:
            r2 = android.widget.AutoCompleteTextView.class;	 Catch:{ NoSuchMethodException -> 0x003c }
            r3 = "ensureImeVisible";	 Catch:{ NoSuchMethodException -> 0x003c }
            r4 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x003c }
            r5 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x003c }
            r4[r0] = r5;	 Catch:{ NoSuchMethodException -> 0x003c }
            r0 = r2.getMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x003c }
            r6.f1867c = r0;	 Catch:{ NoSuchMethodException -> 0x003c }
            r0 = r6.f1867c;	 Catch:{ NoSuchMethodException -> 0x003c }
            r0.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x003c }
        L_0x003c:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.a.<init>():void");
        }

        /* renamed from: a */
        void m2417a(android.widget.AutoCompleteTextView r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.f1865a;
            if (r0 == 0) goto L_0x000c;
        L_0x0004:
            r0 = r2.f1865a;	 Catch:{ Exception -> 0x000c }
            r1 = 0;	 Catch:{ Exception -> 0x000c }
            r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x000c }
            r0.invoke(r3, r1);	 Catch:{ Exception -> 0x000c }
        L_0x000c:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.a.a(android.widget.AutoCompleteTextView):void");
        }

        /* renamed from: b */
        void m2419b(android.widget.AutoCompleteTextView r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r2 = this;
            r0 = r2.f1866b;
            if (r0 == 0) goto L_0x000c;
        L_0x0004:
            r0 = r2.f1866b;	 Catch:{ Exception -> 0x000c }
            r1 = 0;	 Catch:{ Exception -> 0x000c }
            r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x000c }
            r0.invoke(r3, r1);	 Catch:{ Exception -> 0x000c }
        L_0x000c:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.a.b(android.widget.AutoCompleteTextView):void");
        }

        /* renamed from: a */
        void m2418a(android.widget.AutoCompleteTextView r4, boolean r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r3 = this;
            r0 = r3.f1867c;
            if (r0 == 0) goto L_0x0013;
        L_0x0004:
            r0 = r3.f1867c;	 Catch:{ Exception -> 0x0013 }
            r1 = 1;	 Catch:{ Exception -> 0x0013 }
            r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0013 }
            r2 = 0;	 Catch:{ Exception -> 0x0013 }
            r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ Exception -> 0x0013 }
            r1[r2] = r5;	 Catch:{ Exception -> 0x0013 }
            r0.invoke(r4, r1);	 Catch:{ Exception -> 0x0013 }
        L_0x0013:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.a.a(android.widget.AutoCompleteTextView, boolean):void");
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$b */
    public interface C0721b {
        /* renamed from: a */
        boolean m2420a();
    }

    /* renamed from: android.support.v7.widget.SearchView$c */
    public interface C0722c {
        /* renamed from: a */
        boolean m2421a(String str);
    }

    /* renamed from: android.support.v7.widget.SearchView$d */
    public interface C0723d {
    }

    /* renamed from: android.support.v7.widget.SearchView$f */
    private static class C0725f extends TouchDelegate {
        /* renamed from: a */
        private final View f1868a;
        /* renamed from: b */
        private final Rect f1869b = new Rect();
        /* renamed from: c */
        private final Rect f1870c = new Rect();
        /* renamed from: d */
        private final Rect f1871d = new Rect();
        /* renamed from: e */
        private final int f1872e;
        /* renamed from: f */
        private boolean f1873f;

        public C0725f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1872e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            m2425a(rect, rect2);
            this.f1868a = view;
        }

        /* renamed from: a */
        public void m2425a(Rect rect, Rect rect2) {
            this.f1869b.set(rect);
            this.f1871d.set(rect);
            this.f1871d.inset(-this.f1872e, -this.f1872e);
            this.f1870c.set(rect2);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r7) {
            /*
            r6 = this;
            r0 = r7.getX();
            r0 = (int) r0;
            r1 = r7.getY();
            r1 = (int) r1;
            r2 = r7.getAction();
            r3 = 1;
            r4 = 0;
            switch(r2) {
                case 0: goto L_0x0027;
                case 1: goto L_0x0019;
                case 2: goto L_0x0019;
                case 3: goto L_0x0014;
                default: goto L_0x0013;
            };
        L_0x0013:
            goto L_0x0033;
        L_0x0014:
            r2 = r6.f1873f;
            r6.f1873f = r4;
            goto L_0x0034;
        L_0x0019:
            r2 = r6.f1873f;
            if (r2 == 0) goto L_0x0034;
        L_0x001d:
            r5 = r6.f1871d;
            r5 = r5.contains(r0, r1);
            if (r5 != 0) goto L_0x0034;
        L_0x0025:
            r3 = 0;
            goto L_0x0034;
        L_0x0027:
            r2 = r6.f1869b;
            r2 = r2.contains(r0, r1);
            if (r2 == 0) goto L_0x0033;
        L_0x002f:
            r6.f1873f = r3;
            r2 = 1;
            goto L_0x0034;
        L_0x0033:
            r2 = 0;
        L_0x0034:
            if (r2 == 0) goto L_0x006b;
        L_0x0036:
            if (r3 == 0) goto L_0x0056;
        L_0x0038:
            r2 = r6.f1870c;
            r2 = r2.contains(r0, r1);
            if (r2 != 0) goto L_0x0056;
        L_0x0040:
            r0 = r6.f1868a;
            r0 = r0.getWidth();
            r0 = r0 / 2;
            r0 = (float) r0;
            r1 = r6.f1868a;
            r1 = r1.getHeight();
            r1 = r1 / 2;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
            goto L_0x0065;
        L_0x0056:
            r2 = r6.f1870c;
            r2 = r2.left;
            r0 = r0 - r2;
            r0 = (float) r0;
            r2 = r6.f1870c;
            r2 = r2.top;
            r1 = r1 - r2;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
        L_0x0065:
            r0 = r6.f1868a;
            r4 = r0.dispatchTouchEvent(r7);
        L_0x006b:
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.f.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    /* renamed from: android.support.v7.widget.SearchView$e */
    static class C3296e extends C0487a {
        public static final Creator<C3296e> CREATOR = new C07241();
        /* renamed from: a */
        boolean f8633a;

        /* renamed from: android.support.v7.widget.SearchView$e$1 */
        static class C07241 implements ClassLoaderCreator<C3296e> {
            C07241() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2422a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m2423a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2424a(i);
            }

            /* renamed from: a */
            public C3296e m2423a(Parcel parcel, ClassLoader classLoader) {
                return new C3296e(parcel, classLoader);
            }

            /* renamed from: a */
            public C3296e m2422a(Parcel parcel) {
                return new C3296e(parcel, null);
            }

            /* renamed from: a */
            public C3296e[] m2424a(int i) {
                return new C3296e[i];
            }
        }

        C3296e(Parcelable parcelable) {
            super(parcelable);
        }

        public C3296e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8633a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f8633a));
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SearchView.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" isIconified=");
            stringBuilder.append(this.f8633a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class SearchAutoComplete extends C3320g {
        /* renamed from: a */
        final Runnable f12053a;
        /* renamed from: b */
        private int f12054b;
        /* renamed from: c */
        private SearchView f12055c;
        /* renamed from: d */
        private boolean f12056d;

        /* renamed from: android.support.v7.widget.SearchView$SearchAutoComplete$1 */
        class C07191 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ SearchAutoComplete f1864a;

            C07191(SearchAutoComplete searchAutoComplete) {
                this.f1864a = searchAutoComplete;
            }

            public void run() {
                this.f1864a.m15144a();
            }
        }

        public void performCompletion() {
        }

        protected void replaceText(CharSequence charSequence) {
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0581a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f12053a = new C07191(this);
            this.f12054b = getThreshold();
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        void setSearchView(SearchView searchView) {
            this.f12055c = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f12054b = i;
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f12055c.hasFocus() && !getVisibility()) {
                this.f12056d = true;
                if (SearchView.m10271a(getContext())) {
                    SearchView.f8634i.m2418a(this, true);
                }
            }
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f12055c.m10292g();
        }

        public boolean enoughToFilter() {
            if (this.f12054b > 0) {
                if (!super.enoughToFilter()) {
                    return false;
                }
            }
            return true;
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    i = getKeyDispatcherState();
                    if (i != 0) {
                        i.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f12055c.clearFocus();
                        setImeVisibility(0);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                if (i < 640 || i2 < 480) {
                    return 160;
                }
            }
            return JfifUtil.MARKER_SOFn;
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            editorInfo = super.onCreateInputConnection(editorInfo);
            if (this.f12056d) {
                removeCallbacks(this.f12053a);
                post(this.f12053a);
            }
            return editorInfo;
        }

        /* renamed from: a */
        private void m15144a() {
            if (this.f12056d) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f12056d = false;
            }
        }

        private void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f12056d = false;
                removeCallbacks(this.f12053a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f12056d = false;
                removeCallbacks(this.f12053a);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f12056d = true;
            }
        }
    }

    int getSuggestionRowLayout() {
        return this.f8668s;
    }

    int getSuggestionCommitIconResId() {
        return this.f8669t;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f8658h = searchableInfo;
        if (this.f8658h != null) {
            m10281p();
            m10280o();
        }
        this.f8643I = m10275i();
        if (this.f8643I != null) {
            this.f8651a.setPrivateImeOptions("nm");
        }
        m10270a(m10288c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.f8647M = bundle;
    }

    public void setImeOptions(int i) {
        this.f8651a.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.f8651a.getImeOptions();
    }

    public void setInputType(int i) {
        this.f8651a.setInputType(i);
    }

    public int getInputType() {
        return this.f8651a.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f8641G || !isFocusable()) {
            return false;
        }
        if (m10288c()) {
            return super.requestFocus(i, rect);
        }
        i = this.f8651a.requestFocus(i, rect);
        if (i != 0) {
            m10270a(false);
        }
        return i;
    }

    public void clearFocus() {
        this.f8641G = true;
        super.clearFocus();
        this.f8651a.clearFocus();
        this.f8651a.setImeVisibility(false);
        this.f8641G = false;
    }

    public void setOnQueryTextListener(C0722c c0722c) {
        this.f8673x = c0722c;
    }

    public void setOnCloseListener(C0721b c0721b) {
        this.f8674y = c0721b;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f8656f = onFocusChangeListener;
    }

    public void setOnSuggestionListener(C0723d c0723d) {
        this.f8675z = c0723d;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.f8635A = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f8651a.getText();
    }

    /* renamed from: a */
    public void m10286a(CharSequence charSequence, boolean z) {
        this.f8651a.setText(charSequence);
        if (charSequence != null) {
            this.f8651a.setSelection(this.f8651a.length());
            this.f8644J = charSequence;
        }
        if (z && TextUtils.isEmpty(charSequence) == null) {
            m10289d();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f8639E = charSequence;
        m10280o();
    }

    public CharSequence getQueryHint() {
        if (this.f8639E != null) {
            return this.f8639E;
        }
        if (this.f8658h == null || this.f8658h.getHintId() == 0) {
            return this.f8672w;
        }
        return getContext().getText(this.f8658h.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f8636B != z) {
            this.f8636B = z;
            m10270a(z);
            m10280o();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            m10290e();
        } else {
            m10291f();
        }
    }

    /* renamed from: c */
    public boolean m10288c() {
        return this.f8637C;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f8638D = z;
        m10270a(m10288c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f8640F = z;
        if (this.f8657g instanceof bj) {
            ((bj) this.f8657g).m17173a(z ? true : true);
        }
    }

    public void setSuggestionsAdapter(C3235f c3235f) {
        this.f8657g = c3235f;
        this.f8651a.setAdapter(this.f8657g);
    }

    public C3235f getSuggestionsAdapter() {
        return this.f8657g;
    }

    public void setMaxWidth(int i) {
        this.f8642H = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.f8642H;
    }

    protected void onMeasure(int i, int i2) {
        if (m10288c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        i = MeasureSpec.getSize(i);
        if (mode == LinearLayoutManager.INVALID_OFFSET) {
            i = this.f8642H > 0 ? Math.min(this.f8642H, i) : Math.min(getPreferredWidth(), i);
        } else if (mode == 0) {
            i = this.f8642H > 0 ? this.f8642H : getPreferredWidth();
        } else if (mode == 1073741824) {
            if (this.f8642H > 0) {
                i = Math.min(this.f8642H, i);
            }
        }
        mode = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        if (mode == LinearLayoutManager.INVALID_OFFSET) {
            i2 = Math.min(getPreferredHeight(), i2);
        } else if (mode == 0) {
            i2 = getPreferredHeight();
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(i, 1073741824), MeasureSpec.makeMeasureSpec(i2, 1073741824));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m10269a(this.f8651a, this.f8662m);
            this.f8663n.set(this.f8662m.left, 0, this.f8662m.right, i4 - i2);
            if (this.f8661l) {
                this.f8661l.m2425a(this.f8663n, this.f8662m);
                return;
            }
            this.f8661l = new C0725f(this.f8663n, this.f8662m, this.f8651a);
            setTouchDelegate(this.f8661l);
        }
    }

    /* renamed from: a */
    private void m10269a(View view, Rect rect) {
        view.getLocationInWindow(this.f8664o);
        getLocationInWindow(this.f8665p);
        int i = this.f8664o[1] - this.f8665p[1];
        int i2 = this.f8664o[0] - this.f8665p[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0584d.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(C0584d.abc_search_view_preferred_height);
    }

    /* renamed from: a */
    private void m10270a(boolean z) {
        this.f8637C = z;
        int i = 8;
        boolean z2 = false;
        boolean isEmpty = TextUtils.isEmpty(this.f8651a.getText()) ^ true;
        this.f8652b.setVisibility(z ? 0 : 8);
        m10273b(isEmpty);
        this.f8659j.setVisibility(z ? true : false);
        if (this.f8666q.getDrawable()) {
            if (!this.f8636B) {
                i = 0;
            }
        }
        this.f8666q.setVisibility(i);
        m10278m();
        if (!isEmpty) {
            z2 = true;
        }
        m10274c(z2);
        m10277l();
    }

    /* renamed from: i */
    private boolean m10275i() {
        boolean z = false;
        if (this.f8658h != null && this.f8658h.getVoiceSearchEnabled()) {
            Intent intent = null;
            if (this.f8658h.getVoiceSearchLaunchWebSearch()) {
                intent = this.f8670u;
            } else if (this.f8658h.getVoiceSearchLaunchRecognizer()) {
                intent = this.f8671v;
            }
            if (intent != null) {
                if (getContext().getPackageManager().resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != null) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: k */
    private boolean m10276k() {
        return (this.f8638D || this.f8643I) && !m10288c();
    }

    /* renamed from: b */
    private void m10273b(boolean z) {
        z = (this.f8638D && m10276k() && hasFocus() && (z || !this.f8643I)) ? false : true;
        this.f8653c.setVisibility(z);
    }

    /* renamed from: l */
    private void m10277l() {
        int i = (m10276k() && (this.f8653c.getVisibility() == 0 || this.f8655e.getVisibility() == 0)) ? 0 : 8;
        this.f8660k.setVisibility(i);
    }

    /* renamed from: m */
    private void m10278m() {
        int i = 1;
        int isEmpty = TextUtils.isEmpty(this.f8651a.getText()) ^ 1;
        int i2 = 0;
        if (isEmpty == 0) {
            if (!this.f8636B || this.f8645K) {
                i = 0;
            }
        }
        ImageView imageView = this.f8654d;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.f8654d.getDrawable();
        if (drawable != null) {
            drawable.setState(isEmpty != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    /* renamed from: n */
    private void m10279n() {
        post(this.f8648N);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.f8648N);
        post(this.f8649O);
        super.onDetachedFromWindow();
    }

    /* renamed from: a */
    void m10285a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* renamed from: b */
    private CharSequence m10272b(CharSequence charSequence) {
        if (this.f8636B) {
            if (this.f8667r != null) {
                int textSize = (int) (((double) this.f8651a.getTextSize()) * 1.25d);
                this.f8667r.setBounds(0, 0, textSize, textSize);
                CharSequence spannableStringBuilder = new SpannableStringBuilder("   ");
                spannableStringBuilder.setSpan(new ImageSpan(this.f8667r), 1, 2, 33);
                spannableStringBuilder.append(charSequence);
                return spannableStringBuilder;
            }
        }
        return charSequence;
    }

    /* renamed from: o */
    private void m10280o() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f8651a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m10272b(queryHint));
    }

    /* renamed from: p */
    private void m10281p() {
        this.f8651a.setThreshold(this.f8658h.getSuggestThreshold());
        this.f8651a.setImeOptions(this.f8658h.getImeOptions());
        int inputType = this.f8658h.getInputType();
        int i = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f8658h.getSuggestAuthority() != null) {
                inputType = (inputType | NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) | 524288;
            }
        }
        this.f8651a.setInputType(inputType);
        if (this.f8657g != null) {
            this.f8657g.mo333a(null);
        }
        if (this.f8658h.getSuggestAuthority() != null) {
            this.f8657g = new bj(getContext(), this, this.f8658h, this.f8650P);
            this.f8651a.setAdapter(this.f8657g);
            bj bjVar = (bj) this.f8657g;
            if (this.f8640F) {
                i = 2;
            }
            bjVar.m17173a(i);
        }
    }

    /* renamed from: c */
    private void m10274c(boolean z) {
        if (this.f8643I && !m10288c() && z) {
            z = false;
            this.f8653c.setVisibility(8);
        } else {
            z = true;
        }
        this.f8655e.setVisibility(z);
    }

    /* renamed from: d */
    void m10289d() {
        CharSequence text = this.f8651a.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f8673x == null || !this.f8673x.m2421a(text.toString())) {
                if (this.f8658h != null) {
                    m10284a(0, null, text.toString());
                }
                this.f8651a.setImeVisibility(false);
                m10282q();
            }
        }
    }

    /* renamed from: q */
    private void m10282q() {
        this.f8651a.dismissDropDown();
    }

    /* renamed from: e */
    void m10290e() {
        if (!TextUtils.isEmpty(this.f8651a.getText())) {
            this.f8651a.setText("");
            this.f8651a.requestFocus();
            this.f8651a.setImeVisibility(true);
        } else if (!this.f8636B) {
        } else {
            if (this.f8674y == null || !this.f8674y.m2420a()) {
                clearFocus();
                m10270a(true);
            }
        }
    }

    /* renamed from: f */
    void m10291f() {
        m10270a(false);
        this.f8651a.requestFocus();
        this.f8651a.setImeVisibility(true);
        if (this.f8635A != null) {
            this.f8635A.onClick(this);
        }
    }

    /* renamed from: g */
    void m10292g() {
        m10270a(m10288c());
        m10279n();
        if (this.f8651a.hasFocus()) {
            m10293h();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m10279n();
    }

    /* renamed from: b */
    public void mo479b() {
        m10286a((CharSequence) "", false);
        clearFocus();
        m10270a(true);
        this.f8651a.setImeOptions(this.f8646L);
        this.f8645K = false;
    }

    /* renamed from: a */
    public void mo478a() {
        if (!this.f8645K) {
            this.f8645K = true;
            this.f8646L = this.f8651a.getImeOptions();
            this.f8651a.setImeOptions(this.f8646L | 33554432);
            this.f8651a.setText("");
            setIconified(false);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c3296e = new C3296e(super.onSaveInstanceState());
        c3296e.f8633a = m10288c();
        return c3296e;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C3296e) {
            C3296e c3296e = (C3296e) parcelable;
            super.onRestoreInstanceState(c3296e.m1558a());
            m10270a(c3296e.f8633a);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void setQuery(CharSequence charSequence) {
        this.f8651a.setText(charSequence);
        this.f8651a.setSelection(TextUtils.isEmpty(charSequence) ? null : charSequence.length());
    }

    /* renamed from: a */
    void m10284a(int i, String str, String str2) {
        getContext().startActivity(m10268a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    /* renamed from: a */
    private Intent m10268a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f8644J);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f8647M != null) {
            intent.putExtra("app_data", this.f8647M);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f8658h.getSearchActivity());
        return intent;
    }

    /* renamed from: h */
    void m10293h() {
        f8634i.m2417a(this.f8651a);
        f8634i.m2419b(this.f8651a);
    }

    /* renamed from: a */
    static boolean m10271a(Context context) {
        return context.getResources().getConfiguration().orientation == 2 ? true : null;
    }
}
