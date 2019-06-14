package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.C0517s;
import android.support.v4.widget.C0560n;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0590j;
import android.support.v7.view.menu.C0666s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow */
public class au implements C0666s {
    /* renamed from: a */
    private static Method f8754a;
    /* renamed from: b */
    private static Method f8755b;
    /* renamed from: h */
    private static Method f8756h;
    /* renamed from: A */
    private Drawable f8757A;
    /* renamed from: B */
    private OnItemClickListener f8758B;
    /* renamed from: C */
    private OnItemSelectedListener f8759C;
    /* renamed from: D */
    private final C0768d f8760D;
    /* renamed from: E */
    private final C0767c f8761E;
    /* renamed from: F */
    private final C0765a f8762F;
    /* renamed from: G */
    private Runnable f8763G;
    /* renamed from: H */
    private final Rect f8764H;
    /* renamed from: I */
    private Rect f8765I;
    /* renamed from: J */
    private boolean f8766J;
    /* renamed from: c */
    am f8767c;
    /* renamed from: d */
    int f8768d;
    /* renamed from: e */
    final C0769e f8769e;
    /* renamed from: f */
    final Handler f8770f;
    /* renamed from: g */
    PopupWindow f8771g;
    /* renamed from: i */
    private Context f8772i;
    /* renamed from: j */
    private ListAdapter f8773j;
    /* renamed from: k */
    private int f8774k;
    /* renamed from: l */
    private int f8775l;
    /* renamed from: m */
    private int f8776m;
    /* renamed from: n */
    private int f8777n;
    /* renamed from: o */
    private int f8778o;
    /* renamed from: p */
    private boolean f8779p;
    /* renamed from: q */
    private boolean f8780q;
    /* renamed from: r */
    private boolean f8781r;
    /* renamed from: s */
    private boolean f8782s;
    /* renamed from: t */
    private int f8783t;
    /* renamed from: u */
    private boolean f8784u;
    /* renamed from: v */
    private boolean f8785v;
    /* renamed from: w */
    private View f8786w;
    /* renamed from: x */
    private int f8787x;
    /* renamed from: y */
    private DataSetObserver f8788y;
    /* renamed from: z */
    private View f8789z;

    /* compiled from: ListPopupWindow */
    /* renamed from: android.support.v7.widget.au$1 */
    class C07631 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ au f2044a;

        C07631(au auVar) {
            this.f2044a = auVar;
        }

        public void run() {
            View i = this.f2044a.m10469i();
            if (i != null && i.getWindowToken() != null) {
                this.f2044a.mo634a();
            }
        }
    }

    /* compiled from: ListPopupWindow */
    /* renamed from: android.support.v7.widget.au$2 */
    class C07642 implements OnItemSelectedListener {
        /* renamed from: a */
        final /* synthetic */ au f2045a;

        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        C07642(au auVar) {
            this.f2045a = auVar;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                adapterView = this.f2045a.f8767c;
                if (adapterView != null) {
                    adapterView.setListSelectionHidden(null);
                }
            }
        }
    }

    /* compiled from: ListPopupWindow */
    /* renamed from: android.support.v7.widget.au$a */
    private class C0765a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ au f2046a;

        C0765a(au auVar) {
            this.f2046a = auVar;
        }

        public void run() {
            this.f2046a.m10474m();
        }
    }

    /* compiled from: ListPopupWindow */
    /* renamed from: android.support.v7.widget.au$b */
    private class C0766b extends DataSetObserver {
        /* renamed from: a */
        final /* synthetic */ au f2047a;

        C0766b(au auVar) {
            this.f2047a = auVar;
        }

        public void onChanged() {
            if (this.f2047a.mo636d()) {
                this.f2047a.mo634a();
            }
        }

        public void onInvalidated() {
            this.f2047a.mo635c();
        }
    }

    /* compiled from: ListPopupWindow */
    /* renamed from: android.support.v7.widget.au$c */
    private class C0767c implements OnScrollListener {
        /* renamed from: a */
        final /* synthetic */ au f2048a;

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        C0767c(au auVar) {
            this.f2048a = auVar;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && this.f2048a.m10475n() == null && this.f2048a.f8771g.getContentView() != null) {
                this.f2048a.f8770f.removeCallbacks(this.f2048a.f8769e);
                this.f2048a.f8769e.run();
            }
        }
    }

    /* compiled from: ListPopupWindow */
    /* renamed from: android.support.v7.widget.au$d */
    private class C0768d implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ au f2049a;

        C0768d(au auVar) {
            this.f2049a = auVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            view = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            motionEvent = (int) motionEvent.getY();
            if (view == null && this.f2049a.f8771g != null && this.f2049a.f8771g.isShowing() && x >= 0 && x < this.f2049a.f8771g.getWidth() && motionEvent >= null && motionEvent < this.f2049a.f8771g.getHeight()) {
                this.f2049a.f8770f.postDelayed(this.f2049a.f8769e, 250);
            } else if (view == 1) {
                this.f2049a.f8770f.removeCallbacks(this.f2049a.f8769e);
            }
            return null;
        }
    }

    /* compiled from: ListPopupWindow */
    /* renamed from: android.support.v7.widget.au$e */
    private class C0769e implements Runnable {
        /* renamed from: a */
        final /* synthetic */ au f2050a;

        C0769e(au auVar) {
            this.f2050a = auVar;
        }

        public void run() {
            if (this.f2050a.f8767c != null && C0517s.m1683A(this.f2050a.f8767c) && this.f2050a.f8767c.getCount() > this.f2050a.f8767c.getChildCount() && this.f2050a.f8767c.getChildCount() <= this.f2050a.f8768d) {
                this.f2050a.f8771g.setInputMethodMode(2);
                this.f2050a.mo634a();
            }
        }
    }

    static {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = 0;
        r1 = 1;
        r2 = android.widget.PopupWindow.class;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r3 = "setClipToScreenEnabled";	 Catch:{ NoSuchMethodException -> 0x0013 }
        r4 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0013 }
        r5 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r4[r0] = r5;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0013 }
        f8754a = r2;	 Catch:{ NoSuchMethodException -> 0x0013 }
        goto L_0x001a;
    L_0x0013:
        r2 = "ListPopupWindow";
        r3 = "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.";
        android.util.Log.i(r2, r3);
    L_0x001a:
        r2 = android.widget.PopupWindow.class;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r3 = "getMaxAvailableHeight";	 Catch:{ NoSuchMethodException -> 0x0035 }
        r4 = 3;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r4 = new java.lang.Class[r4];	 Catch:{ NoSuchMethodException -> 0x0035 }
        r5 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r4[r0] = r5;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r5 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r5 = 2;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r4[r5] = r6;	 Catch:{ NoSuchMethodException -> 0x0035 }
        r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0035 }
        f8755b = r2;	 Catch:{ NoSuchMethodException -> 0x0035 }
        goto L_0x003c;
    L_0x0035:
        r2 = "ListPopupWindow";
        r3 = "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.";
        android.util.Log.i(r2, r3);
    L_0x003c:
        r2 = android.widget.PopupWindow.class;	 Catch:{ NoSuchMethodException -> 0x004d }
        r3 = "setEpicenterBounds";	 Catch:{ NoSuchMethodException -> 0x004d }
        r1 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x004d }
        r4 = android.graphics.Rect.class;	 Catch:{ NoSuchMethodException -> 0x004d }
        r1[r0] = r4;	 Catch:{ NoSuchMethodException -> 0x004d }
        r0 = r2.getDeclaredMethod(r3, r1);	 Catch:{ NoSuchMethodException -> 0x004d }
        f8756h = r0;	 Catch:{ NoSuchMethodException -> 0x004d }
        goto L_0x0054;
    L_0x004d:
        r0 = "ListPopupWindow";
        r1 = "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.";
        android.util.Log.i(r0, r1);
    L_0x0054:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.au.<clinit>():void");
    }

    public au(Context context) {
        this(context, null, C0581a.listPopupWindowStyle);
    }

    public au(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public au(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f8774k = -2;
        this.f8775l = -2;
        this.f8778o = 1002;
        this.f8780q = true;
        this.f8783t = 0;
        this.f8784u = false;
        this.f8785v = false;
        this.f8768d = Integer.MAX_VALUE;
        this.f8787x = 0;
        this.f8769e = new C0769e(this);
        this.f8760D = new C0768d(this);
        this.f8761E = new C0767c(this);
        this.f8762F = new C0765a(this);
        this.f8764H = new Rect();
        this.f8772i = context;
        this.f8770f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0590j.ListPopupWindow, i, i2);
        this.f8776m = obtainStyledAttributes.getDimensionPixelOffset(C0590j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f8777n = obtainStyledAttributes.getDimensionPixelOffset(C0590j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f8777n != 0) {
            this.f8779p = true;
        }
        obtainStyledAttributes.recycle();
        this.f8771g = new C0802s(context, attributeSet, i, i2);
        this.f8771g.setInputMethodMode(1);
    }

    /* renamed from: a */
    public void mo2786a(ListAdapter listAdapter) {
        if (this.f8788y == null) {
            this.f8788y = new C0766b(this);
        } else if (this.f8773j != null) {
            this.f8773j.unregisterDataSetObserver(this.f8788y);
        }
        this.f8773j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f8788y);
        }
        if (this.f8767c != null) {
            this.f8767c.setAdapter(this.f8773j);
        }
    }

    /* renamed from: a */
    public void m10448a(int i) {
        this.f8787x = i;
    }

    /* renamed from: a */
    public void m10454a(boolean z) {
        this.f8766J = z;
        this.f8771g.setFocusable(z);
    }

    /* renamed from: g */
    public boolean m10466g() {
        return this.f8766J;
    }

    /* renamed from: h */
    public Drawable m10467h() {
        return this.f8771g.getBackground();
    }

    /* renamed from: a */
    public void m10450a(Drawable drawable) {
        this.f8771g.setBackgroundDrawable(drawable);
    }

    /* renamed from: b */
    public void m10455b(int i) {
        this.f8771g.setAnimationStyle(i);
    }

    /* renamed from: i */
    public View m10469i() {
        return this.f8789z;
    }

    /* renamed from: b */
    public void m10456b(View view) {
        this.f8789z = view;
    }

    /* renamed from: j */
    public int m10471j() {
        return this.f8776m;
    }

    /* renamed from: c */
    public void m10459c(int i) {
        this.f8776m = i;
    }

    /* renamed from: k */
    public int m10472k() {
        if (this.f8779p) {
            return this.f8777n;
        }
        return 0;
    }

    /* renamed from: d */
    public void m10460d(int i) {
        this.f8777n = i;
        this.f8779p = true;
    }

    /* renamed from: a */
    public void m10449a(Rect rect) {
        this.f8765I = rect;
    }

    /* renamed from: e */
    public void m10463e(int i) {
        this.f8783t = i;
    }

    /* renamed from: l */
    public int m10473l() {
        return this.f8775l;
    }

    /* renamed from: f */
    public void m10464f(int i) {
        this.f8775l = i;
    }

    /* renamed from: g */
    public void m10465g(int i) {
        Drawable background = this.f8771g.getBackground();
        if (background != null) {
            background.getPadding(this.f8764H);
            this.f8775l = (this.f8764H.left + this.f8764H.right) + i;
            return;
        }
        m10464f(i);
    }

    /* renamed from: a */
    public void m10451a(OnItemClickListener onItemClickListener) {
        this.f8758B = onItemClickListener;
    }

    /* renamed from: a */
    public void mo634a() {
        int f = mo2788f();
        boolean n = m10475n();
        C0560n.m1894a(this.f8771g, this.f8778o);
        boolean z = true;
        if (!this.f8771g.isShowing()) {
            int i;
            if (this.f8775l == -1) {
                i = -1;
            } else if (this.f8775l == -2) {
                i = m10469i().getWidth();
            } else {
                i = this.f8775l;
            }
            if (this.f8774k == -1) {
                f = -1;
            } else if (this.f8774k != -2) {
                f = this.f8774k;
            }
            this.f8771g.setWidth(i);
            this.f8771g.setHeight(f);
            mo2773c(true);
            PopupWindow popupWindow = this.f8771g;
            n = (this.f8785v || this.f8784u) ? false : true;
            popupWindow.setOutsideTouchable(n);
            this.f8771g.setTouchInterceptor(this.f8760D);
            if (this.f8782s) {
                C0560n.m1896a(this.f8771g, this.f8781r);
            }
            if (f8756h != null) {
                try {
                    f8756h.invoke(this.f8771g, new Object[]{this.f8765I});
                } catch (Throwable e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
            C0560n.m1895a(this.f8771g, m10469i(), this.f8776m, this.f8777n, this.f8783t);
            this.f8767c.setSelection(-1);
            if (!this.f8766J || this.f8767c.isInTouchMode()) {
                m10474m();
            }
            if (!this.f8766J) {
                this.f8770f.post(this.f8762F);
            }
        } else if (C0517s.m1683A(m10469i())) {
            int i2;
            if (this.f8775l == -1) {
                i2 = -1;
            } else if (this.f8775l == -2) {
                i2 = m10469i().getWidth();
            } else {
                i2 = this.f8775l;
            }
            if (this.f8774k == -1) {
                if (!n) {
                    f = -1;
                }
                if (n) {
                    this.f8771g.setWidth(this.f8775l == -1 ? -1 : 0);
                    this.f8771g.setHeight(0);
                } else {
                    this.f8771g.setWidth(this.f8775l == -1 ? -1 : 0);
                    this.f8771g.setHeight(-1);
                }
            } else if (this.f8774k != -2) {
                f = this.f8774k;
            }
            PopupWindow popupWindow2 = this.f8771g;
            if (this.f8785v || this.f8784u) {
                z = false;
            }
            popupWindow2.setOutsideTouchable(z);
            this.f8771g.update(m10469i(), this.f8776m, this.f8777n, i2 < 0 ? -1 : i2, f < 0 ? -1 : f);
        }
    }

    /* renamed from: c */
    public void mo635c() {
        this.f8771g.dismiss();
        mo2787b();
        this.f8771g.setContentView(null);
        this.f8767c = null;
        this.f8770f.removeCallbacks(this.f8769e);
    }

    /* renamed from: a */
    public void m10453a(OnDismissListener onDismissListener) {
        this.f8771g.setOnDismissListener(onDismissListener);
    }

    /* renamed from: b */
    private void mo2787b() {
        if (this.f8786w != null) {
            ViewParent parent = this.f8786w.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f8786w);
            }
        }
    }

    /* renamed from: h */
    public void m10468h(int i) {
        this.f8771g.setInputMethodMode(i);
    }

    /* renamed from: i */
    public void m10470i(int i) {
        am amVar = this.f8767c;
        if (mo636d() && amVar != null) {
            amVar.setListSelectionHidden(false);
            amVar.setSelection(i);
            if (amVar.getChoiceMode() != 0) {
                amVar.setItemChecked(i, true);
            }
        }
    }

    /* renamed from: m */
    public void m10474m() {
        am amVar = this.f8767c;
        if (amVar != null) {
            amVar.setListSelectionHidden(true);
            amVar.requestLayout();
        }
    }

    /* renamed from: d */
    public boolean mo636d() {
        return this.f8771g.isShowing();
    }

    /* renamed from: n */
    public boolean m10475n() {
        return this.f8771g.getInputMethodMode() == 2;
    }

    /* renamed from: e */
    public ListView mo637e() {
        return this.f8767c;
    }

    /* renamed from: a */
    am mo2772a(Context context, boolean z) {
        return new am(context, z);
    }

    /* renamed from: f */
    private int mo2788f() {
        int i;
        int i2;
        boolean z = true;
        if (this.f8767c == null) {
            Context context = this.f8772i;
            this.f8763G = new C07631(this);
            this.f8767c = mo2772a(context, this.f8766J ^ true);
            if (this.f8757A != null) {
                this.f8767c.setSelector(this.f8757A);
            }
            this.f8767c.setAdapter(this.f8773j);
            this.f8767c.setOnItemClickListener(this.f8758B);
            this.f8767c.setFocusable(true);
            this.f8767c.setFocusableInTouchMode(true);
            this.f8767c.setOnItemSelectedListener(new C07642(this));
            this.f8767c.setOnScrollListener(this.f8761E);
            if (this.f8759C != null) {
                this.f8767c.setOnItemSelectedListener(this.f8759C);
            }
            View view = this.f8767c;
            View view2 = this.f8786w;
            if (view2 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.f8787x) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(view, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(view, layoutParams);
                        linearLayout.addView(view2);
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid hint position ");
                        stringBuilder.append(this.f8787x);
                        Log.e("ListPopupWindow", stringBuilder.toString());
                        break;
                }
                if (this.f8775l >= 0) {
                    i = this.f8775l;
                    i2 = LinearLayoutManager.INVALID_OFFSET;
                } else {
                    i = 0;
                    i2 = 0;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = (view2.getMeasuredHeight() + layoutParams2.topMargin) + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i = 0;
            }
            this.f8771g.setContentView(view);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f8771g.getContentView();
            View view3 = this.f8786w;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i = (view3.getMeasuredHeight() + layoutParams3.topMargin) + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.f8771g.getBackground();
        if (background != null) {
            background.getPadding(this.f8764H);
            i2 = this.f8764H.top + this.f8764H.bottom;
            if (!this.f8779p) {
                this.f8777n = -this.f8764H.top;
            }
        } else {
            this.f8764H.setEmpty();
            i2 = 0;
        }
        if (this.f8771g.getInputMethodMode() != 2) {
            z = false;
        }
        int a = m10442a(m10469i(), this.f8777n, z);
        if (!this.f8784u) {
            if (this.f8774k != -1) {
                int makeMeasureSpec;
                switch (this.f8775l) {
                    case -2:
                        makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f8772i.getResources().getDisplayMetrics().widthPixels - (this.f8764H.left + this.f8764H.right), LinearLayoutManager.INVALID_OFFSET);
                        break;
                    case -1:
                        makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f8772i.getResources().getDisplayMetrics().widthPixels - (this.f8764H.left + this.f8764H.right), 1073741824);
                        break;
                    default:
                        makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f8775l, 1073741824);
                        break;
                }
                makeMeasureSpec = this.f8767c.mo638a(makeMeasureSpec, 0, -1, a - i, -1);
                if (makeMeasureSpec > 0) {
                    i += i2 + (this.f8767c.getPaddingTop() + this.f8767c.getPaddingBottom());
                }
                return makeMeasureSpec + i;
            }
        }
        return a + i2;
    }

    /* renamed from: b */
    public void m10457b(boolean z) {
        this.f8782s = true;
        this.f8781r = z;
    }

    /* renamed from: c */
    private void mo2773c(boolean r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = f8754a;
        if (r0 == 0) goto L_0x001d;
    L_0x0004:
        r0 = f8754a;	 Catch:{ Exception -> 0x0016 }
        r1 = r4.f8771g;	 Catch:{ Exception -> 0x0016 }
        r2 = 1;	 Catch:{ Exception -> 0x0016 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0016 }
        r3 = 0;	 Catch:{ Exception -> 0x0016 }
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ Exception -> 0x0016 }
        r2[r3] = r5;	 Catch:{ Exception -> 0x0016 }
        r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0016 }
        goto L_0x001d;
    L_0x0016:
        r5 = "ListPopupWindow";
        r0 = "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.";
        android.util.Log.i(r5, r0);
    L_0x001d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.au.c(boolean):void");
    }

    /* renamed from: a */
    private int m10442a(android.view.View r6, int r7, boolean r8) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r5 = this;
        r0 = f8755b;
        if (r0 == 0) goto L_0x002e;
    L_0x0004:
        r0 = f8755b;	 Catch:{ Exception -> 0x0027 }
        r1 = r5.f8771g;	 Catch:{ Exception -> 0x0027 }
        r2 = 3;	 Catch:{ Exception -> 0x0027 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0027 }
        r3 = 0;	 Catch:{ Exception -> 0x0027 }
        r2[r3] = r6;	 Catch:{ Exception -> 0x0027 }
        r3 = 1;	 Catch:{ Exception -> 0x0027 }
        r4 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0027 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0027 }
        r3 = 2;	 Catch:{ Exception -> 0x0027 }
        r8 = java.lang.Boolean.valueOf(r8);	 Catch:{ Exception -> 0x0027 }
        r2[r3] = r8;	 Catch:{ Exception -> 0x0027 }
        r8 = r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0027 }
        r8 = (java.lang.Integer) r8;	 Catch:{ Exception -> 0x0027 }
        r8 = r8.intValue();	 Catch:{ Exception -> 0x0027 }
        return r8;
    L_0x0027:
        r8 = "ListPopupWindow";
        r0 = "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.";
        android.util.Log.i(r8, r0);
    L_0x002e:
        r8 = r5.f8771g;
        r6 = r8.getMaxAvailableHeight(r6, r7);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.au.a(android.view.View, int, boolean):int");
    }
}
