package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.C0088p;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.C0309n.C0307a;
import android.support.v4.app.C0309n.C0308b;
import android.support.v4.app.C3178i.C0300c;
import android.support.v4.util.C0448b;
import android.support.v4.util.C0450d;
import android.support.v4.util.C0451e;
import android.support.v4.util.C0461j;
import android.support.v4.view.C0517s;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: FragmentManager */
/* renamed from: android.support.v4.app.o */
final class C3184o extends C0309n implements Factory2 {
    /* renamed from: F */
    static final Interpolator f8187F = new DecelerateInterpolator(2.5f);
    /* renamed from: G */
    static final Interpolator f8188G = new DecelerateInterpolator(1.5f);
    /* renamed from: H */
    static final Interpolator f8189H = new AccelerateInterpolator(2.5f);
    /* renamed from: I */
    static final Interpolator f8190I = new AccelerateInterpolator(1.5f);
    /* renamed from: a */
    static boolean f8191a = false;
    /* renamed from: q */
    static Field f8192q;
    /* renamed from: A */
    Bundle f8193A = null;
    /* renamed from: B */
    SparseArray<Parcelable> f8194B = null;
    /* renamed from: C */
    ArrayList<C3183i> f8195C;
    /* renamed from: D */
    C0321p f8196D;
    /* renamed from: E */
    Runnable f8197E = new C03101(this);
    /* renamed from: J */
    private final CopyOnWriteArrayList<C0461j<C0307a, Boolean>> f8198J = new CopyOnWriteArrayList();
    /* renamed from: b */
    ArrayList<C0320g> f8199b;
    /* renamed from: c */
    boolean f8200c;
    /* renamed from: d */
    int f8201d = 0;
    /* renamed from: e */
    final ArrayList<C3178i> f8202e = new ArrayList();
    /* renamed from: f */
    SparseArray<C3178i> f8203f;
    /* renamed from: g */
    ArrayList<C3176c> f8204g;
    /* renamed from: h */
    ArrayList<C3178i> f8205h;
    /* renamed from: i */
    ArrayList<C3176c> f8206i;
    /* renamed from: j */
    ArrayList<Integer> f8207j;
    /* renamed from: k */
    ArrayList<C0308b> f8208k;
    /* renamed from: l */
    int f8209l = 0;
    /* renamed from: m */
    C3179m f8210m;
    /* renamed from: n */
    C0305k f8211n;
    /* renamed from: o */
    C3178i f8212o;
    /* renamed from: p */
    C3178i f8213p;
    /* renamed from: r */
    boolean f8214r;
    /* renamed from: s */
    boolean f8215s;
    /* renamed from: t */
    boolean f8216t;
    /* renamed from: u */
    boolean f8217u;
    /* renamed from: v */
    String f8218v;
    /* renamed from: w */
    boolean f8219w;
    /* renamed from: x */
    ArrayList<C3176c> f8220x;
    /* renamed from: y */
    ArrayList<Boolean> f8221y;
    /* renamed from: z */
    ArrayList<C3178i> f8222z;

    /* compiled from: FragmentManager */
    /* renamed from: android.support.v4.app.o$1 */
    class C03101 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3184o f825a;

        C03101(C3184o c3184o) {
            this.f825a = c3184o;
        }

        public void run() {
            this.f825a.m9594f();
        }
    }

    /* compiled from: FragmentManager */
    /* renamed from: android.support.v4.app.o$b */
    private static class C0315b implements AnimationListener {
        /* renamed from: a */
        private final AnimationListener f836a;

        private C0315b(AnimationListener animationListener) {
            this.f836a = animationListener;
        }

        public void onAnimationStart(Animation animation) {
            if (this.f836a != null) {
                this.f836a.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f836a != null) {
                this.f836a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.f836a != null) {
                this.f836a.onAnimationRepeat(animation);
            }
        }
    }

    /* compiled from: FragmentManager */
    /* renamed from: android.support.v4.app.o$c */
    private static class C0316c {
        /* renamed from: a */
        public final Animation f837a;
        /* renamed from: b */
        public final Animator f838b;

        private C0316c(Animation animation) {
            this.f837a = animation;
            this.f838b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        private C0316c(Animator animator) {
            this.f837a = null;
            this.f838b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* compiled from: FragmentManager */
    /* renamed from: android.support.v4.app.o$d */
    private static class C0317d extends AnimatorListenerAdapter {
        /* renamed from: a */
        View f839a;

        C0317d(View view) {
            this.f839a = view;
        }

        public void onAnimationStart(Animator animator) {
            this.f839a.setLayerType(2, null);
        }

        public void onAnimationEnd(Animator animator) {
            this.f839a.setLayerType(0, null);
            animator.removeListener(this);
        }
    }

    /* compiled from: FragmentManager */
    /* renamed from: android.support.v4.app.o$e */
    private static class C0318e extends AnimationSet implements Runnable {
        /* renamed from: a */
        private final ViewGroup f840a;
        /* renamed from: b */
        private final View f841b;
        /* renamed from: c */
        private boolean f842c;
        /* renamed from: d */
        private boolean f843d;

        C0318e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f840a = viewGroup;
            this.f841b = view;
            addAnimation(animation);
        }

        public boolean getTransformation(long j, Transformation transformation) {
            if (this.f842c) {
                return this.f843d ^ 1;
            }
            if (super.getTransformation(j, transformation) == null) {
                this.f842c = true;
                ag.m835a(this.f840a, this);
            }
            return true;
        }

        public boolean getTransformation(long j, Transformation transformation, float f) {
            if (this.f842c) {
                return this.f843d ^ 1;
            }
            if (super.getTransformation(j, transformation, f) == null) {
                this.f842c = true;
                ag.m835a(this.f840a, this);
            }
            return true;
        }

        public void run() {
            this.f840a.endViewTransition(this.f841b);
            this.f843d = true;
        }
    }

    /* compiled from: FragmentManager */
    /* renamed from: android.support.v4.app.o$f */
    static class C0319f {
        /* renamed from: a */
        public static final int[] f844a = new int[]{16842755, 16842960, 16842961};
    }

    /* compiled from: FragmentManager */
    /* renamed from: android.support.v4.app.o$g */
    interface C0320g {
        /* renamed from: a */
        boolean mo187a(ArrayList<C3176c> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* compiled from: FragmentManager */
    /* renamed from: android.support.v4.app.o$a */
    private static class C3181a extends C0315b {
        /* renamed from: a */
        View f8179a;

        /* compiled from: FragmentManager */
        /* renamed from: android.support.v4.app.o$a$1 */
        class C03141 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C3181a f835a;

            C03141(C3181a c3181a) {
                this.f835a = c3181a;
            }

            public void run() {
                this.f835a.f8179a.setLayerType(0, null);
            }
        }

        C3181a(View view, AnimationListener animationListener) {
            super(animationListener);
            this.f8179a = view;
        }

        public void onAnimationEnd(Animation animation) {
            if (!C0517s.m1683A(this.f8179a)) {
                if (VERSION.SDK_INT < 24) {
                    this.f8179a.setLayerType(0, null);
                    super.onAnimationEnd(animation);
                }
            }
            this.f8179a.post(new C03141(this));
            super.onAnimationEnd(animation);
        }
    }

    /* compiled from: FragmentManager */
    /* renamed from: android.support.v4.app.o$h */
    private class C3182h implements C0320g {
        /* renamed from: a */
        final String f8180a;
        /* renamed from: b */
        final int f8181b;
        /* renamed from: c */
        final int f8182c;
        /* renamed from: d */
        final /* synthetic */ C3184o f8183d;

        C3182h(C3184o c3184o, String str, int i, int i2) {
            this.f8183d = c3184o;
            this.f8180a = str;
            this.f8181b = i;
            this.f8182c = i2;
        }

        /* renamed from: a */
        public boolean mo187a(ArrayList<C3176c> arrayList, ArrayList<Boolean> arrayList2) {
            if (this.f8183d.f8213p != null && this.f8181b < 0 && this.f8180a == null) {
                C0309n peekChildFragmentManager = this.f8183d.f8213p.peekChildFragmentManager();
                if (peekChildFragmentManager != null && peekChildFragmentManager.mo204b()) {
                    return null;
                }
            }
            return this.f8183d.m9567a((ArrayList) arrayList, (ArrayList) arrayList2, this.f8180a, this.f8181b, this.f8182c);
        }
    }

    /* compiled from: FragmentManager */
    /* renamed from: android.support.v4.app.o$i */
    static class C3183i implements C0300c {
        /* renamed from: a */
        private final boolean f8184a;
        /* renamed from: b */
        private final C3176c f8185b;
        /* renamed from: c */
        private int f8186c;

        C3183i(C3176c c3176c, boolean z) {
            this.f8184a = z;
            this.f8185b = c3176c;
        }

        /* renamed from: a */
        public void mo198a() {
            this.f8186c--;
            if (this.f8186c == 0) {
                this.f8185b.f8149a.m9541z();
            }
        }

        /* renamed from: b */
        public void mo199b() {
            this.f8186c++;
        }

        /* renamed from: c */
        public boolean m9506c() {
            return this.f8186c == 0;
        }

        /* renamed from: d */
        public void m9507d() {
            int i = this.f8186c > 0 ? 1 : 0;
            C3184o c3184o = this.f8185b.f8149a;
            int size = c3184o.f8202e.size();
            for (int i2 = 0; i2 < size; i2++) {
                C3178i c3178i = (C3178i) c3184o.f8202e.get(i2);
                c3178i.setOnStartEnterTransitionListener(null);
                if (i != 0 && c3178i.isPostponed()) {
                    c3178i.startPostponedEnterTransition();
                }
            }
            this.f8185b.f8149a.m9517a(this.f8185b, this.f8184a, i ^ true, true);
        }

        /* renamed from: e */
        public void m9508e() {
            this.f8185b.f8149a.m9517a(this.f8185b, this.f8184a, false, false);
        }
    }

    /* renamed from: b */
    public static int m9530b(int i, boolean z) {
        return i != 4097 ? i != 4099 ? i != 8194 ? -1 : z ? 3 : 4 : z ? 5 : 6 : z ? 1 : 2;
    }

    /* renamed from: d */
    public static int m9537d(int i) {
        return i != 4097 ? i != 4099 ? i != 8194 ? 0 : 4097 : 4099 : 8194;
    }

    /* renamed from: x */
    Factory2 m9623x() {
        return this;
    }

    C3184o() {
    }

    /* renamed from: a */
    static boolean m9527a(C0316c c0316c) {
        if (c0316c.f837a instanceof AlphaAnimation) {
            return true;
        }
        if (!(c0316c.f837a instanceof AnimationSet)) {
            return C3184o.m9526a(c0316c.f838b);
        }
        c0316c = ((AnimationSet) c0316c.f837a).getAnimations();
        for (int i = 0; i < c0316c.size(); i++) {
            if (c0316c.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m9526a(Animator animator) {
        if (animator == null) {
            return false;
        }
        int i;
        if (animator instanceof ValueAnimator) {
            animator = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : animator) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            animator = ((AnimatorSet) animator).getChildAnimations();
            for (i = 0; i < animator.size(); i++) {
                if (C3184o.m9526a((Animator) animator.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m9528a(View view, C0316c c0316c) {
        boolean z = false;
        if (view != null) {
            if (c0316c != null) {
                if (VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && C0517s.m1723q(view) != null && C3184o.m9527a(c0316c) != null) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m9523a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0451e("FragmentManager"));
        if (this.f8210m != null) {
            try {
                this.f8210m.mo2672a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                mo203a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    /* renamed from: a */
    public C0326t mo201a() {
        return new C3176c(this);
    }

    /* renamed from: b */
    public boolean mo204b() {
        m9540y();
        return m9529a(null, -1, 0);
    }

    /* renamed from: a */
    public void mo202a(int i, int i2) {
        if (i >= 0) {
            m9560a(new C3182h(this, null, i, i2), (boolean) 0);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad id: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    private boolean m9529a(String str, int i, int i2) {
        m9594f();
        m9535c(true);
        if (this.f8213p != null && i < 0 && str == null) {
            C0309n peekChildFragmentManager = this.f8213p.peekChildFragmentManager();
            if (peekChildFragmentManager != null && peekChildFragmentManager.mo204b()) {
                return true;
            }
        }
        str = m9567a(this.f8220x, this.f8221y, str, i, i2);
        if (str != null) {
            this.f8200c = true;
            try {
                m9533b(this.f8220x, this.f8221y);
            } finally {
                m9509A();
            }
        }
        m9595g();
        m9512D();
        return str;
    }

    /* renamed from: a */
    public void m9551a(Bundle bundle, String str, C3178i c3178i) {
        if (c3178i.mIndex < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(c3178i);
            stringBuilder.append(" is not currently in the FragmentManager");
            m9523a(new IllegalStateException(stringBuilder.toString()));
        }
        bundle.putInt(str, c3178i.mIndex);
    }

    /* renamed from: a */
    public C3178i m9543a(Bundle bundle, String str) {
        bundle = bundle.getInt(str, -1);
        if (bundle == -1) {
            return null;
        }
        C3178i c3178i = (C3178i) this.f8203f.get(bundle);
        if (c3178i == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment no longer exists for key ");
            stringBuilder.append(str);
            stringBuilder.append(": index ");
            stringBuilder.append(bundle);
            m9523a(new IllegalStateException(stringBuilder.toString()));
        }
        return c3178i;
    }

    /* renamed from: c */
    public List<C3178i> mo205c() {
        if (this.f8202e.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<C3178i> list;
        synchronized (this.f8202e) {
            list = (List) this.f8202e.clone();
        }
        return list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f8212o != null) {
            C0450d.m1408a(this.f8212o, stringBuilder);
        } else {
            C0450d.m1408a(this.f8210m, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void mo203a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        C3178i c3178i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("    ");
        String stringBuilder2 = stringBuilder.toString();
        if (this.f8203f != null) {
            size = this.f8203f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    c3178i = (C3178i) this.f8203f.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c3178i);
                    if (c3178i != null) {
                        c3178i.dump(stringBuilder2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        size = this.f8202e.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (i = 0; i < size; i++) {
                c3178i = (C3178i) this.f8202e.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(c3178i.toString());
            }
        }
        if (this.f8205h != null) {
            size = this.f8205h.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    c3178i = (C3178i) this.f8205h.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c3178i.toString());
                }
            }
        }
        if (this.f8204g != null) {
            size = this.f8204g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C3176c c3176c = (C3176c) this.f8204g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c3176c.toString());
                    c3176c.m9462a(stringBuilder2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f8206i != null) {
                fileDescriptor = this.f8206i.size();
                if (fileDescriptor > null) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (strArr = null; strArr < fileDescriptor; strArr++) {
                        C3176c c3176c2 = (C3176c) this.f8206i.get(strArr);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(strArr);
                        printWriter.print(": ");
                        printWriter.println(c3176c2);
                    }
                }
            }
            if (this.f8207j != null && this.f8207j.size() > null) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f8207j.toArray()));
            }
        }
        if (this.f8199b != null) {
            fileDescriptor = this.f8199b.size();
            if (fileDescriptor > null) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i2 = 0; i2 < fileDescriptor; i2++) {
                    C0320g c0320g = (C0320g) this.f8199b.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(c0320g);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f8210m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f8211n);
        if (this.f8212o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f8212o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f8209l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f8215s);
        printWriter.print(" mStopped=");
        printWriter.print(this.f8216t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f8217u);
        if (this.f8214r != null) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f8214r);
        }
        if (this.f8218v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f8218v);
        }
    }

    /* renamed from: a */
    static C0316c m9515a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f8187F);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        Animation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(f8188G);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new C0316c(animationSet);
    }

    /* renamed from: a */
    static C0316c m9514a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f8188G);
        alphaAnimation.setDuration(3.08E-43f);
        return new C0316c(alphaAnimation);
    }

    /* renamed from: a */
    android.support.v4.app.C3184o.C0316c m9545a(android.support.v4.app.C3178i r6, int r7, boolean r8, int r9) {
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
        r0 = r6.getNextAnim();
        r1 = r6.onCreateAnimation(r7, r8, r0);
        r2 = 0;
        if (r1 == 0) goto L_0x0011;
    L_0x000b:
        r6 = new android.support.v4.app.o$c;
        r6.<init>(r1);
        return r6;
    L_0x0011:
        r6 = r6.onCreateAnimator(r7, r8, r0);
        if (r6 == 0) goto L_0x001d;
    L_0x0017:
        r7 = new android.support.v4.app.o$c;
        r7.<init>(r6);
        return r7;
    L_0x001d:
        if (r0 == 0) goto L_0x0076;
    L_0x001f:
        r6 = r5.f8210m;
        r6 = r6.m9498i();
        r6 = r6.getResources();
        r6 = r6.getResourceTypeName(r0);
        r1 = "anim";
        r6 = r1.equals(r6);
        r1 = 0;
        if (r6 == 0) goto L_0x004c;
    L_0x0036:
        r3 = r5.f8210m;	 Catch:{ NotFoundException -> 0x004a, RuntimeException -> 0x004c }
        r3 = r3.m9498i();	 Catch:{ NotFoundException -> 0x004a, RuntimeException -> 0x004c }
        r3 = android.view.animation.AnimationUtils.loadAnimation(r3, r0);	 Catch:{ NotFoundException -> 0x004a, RuntimeException -> 0x004c }
        if (r3 == 0) goto L_0x0048;	 Catch:{ NotFoundException -> 0x004a, RuntimeException -> 0x004c }
    L_0x0042:
        r4 = new android.support.v4.app.o$c;	 Catch:{ NotFoundException -> 0x004a, RuntimeException -> 0x004c }
        r4.<init>(r3);	 Catch:{ NotFoundException -> 0x004a, RuntimeException -> 0x004c }
        return r4;
    L_0x0048:
        r1 = 1;
        goto L_0x004c;
    L_0x004a:
        r6 = move-exception;
        throw r6;
    L_0x004c:
        if (r1 != 0) goto L_0x0076;
    L_0x004e:
        r1 = r5.f8210m;	 Catch:{ RuntimeException -> 0x0060 }
        r1 = r1.m9498i();	 Catch:{ RuntimeException -> 0x0060 }
        r1 = android.animation.AnimatorInflater.loadAnimator(r1, r0);	 Catch:{ RuntimeException -> 0x0060 }
        if (r1 == 0) goto L_0x0076;	 Catch:{ RuntimeException -> 0x0060 }
    L_0x005a:
        r3 = new android.support.v4.app.o$c;	 Catch:{ RuntimeException -> 0x0060 }
        r3.<init>(r1);	 Catch:{ RuntimeException -> 0x0060 }
        return r3;
    L_0x0060:
        r1 = move-exception;
        if (r6 != 0) goto L_0x0075;
    L_0x0063:
        r6 = r5.f8210m;
        r6 = r6.m9498i();
        r6 = android.view.animation.AnimationUtils.loadAnimation(r6, r0);
        if (r6 == 0) goto L_0x0076;
    L_0x006f:
        r7 = new android.support.v4.app.o$c;
        r7.<init>(r6);
        return r7;
    L_0x0075:
        throw r1;
    L_0x0076:
        if (r7 != 0) goto L_0x0079;
    L_0x0078:
        return r2;
    L_0x0079:
        r6 = android.support.v4.app.C3184o.m9530b(r7, r8);
        if (r6 >= 0) goto L_0x0080;
    L_0x007f:
        return r2;
    L_0x0080:
        r7 = 1064933786; // 0x3f79999a float:0.975 double:5.26147199E-315;
        r8 = 0;
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        switch(r6) {
            case 1: goto L_0x00d4;
            case 2: goto L_0x00c9;
            case 3: goto L_0x00be;
            case 4: goto L_0x00b0;
            case 5: goto L_0x00a5;
            case 6: goto L_0x009a;
            default: goto L_0x0089;
        };
    L_0x0089:
        if (r9 != 0) goto L_0x00e1;
    L_0x008b:
        r6 = r5.f8210m;
        r6 = r6.mo2678e();
        if (r6 == 0) goto L_0x00e1;
    L_0x0093:
        r6 = r5.f8210m;
        r9 = r6.mo2679f();
        goto L_0x00e1;
    L_0x009a:
        r6 = r5.f8210m;
        r6 = r6.m9498i();
        r6 = android.support.v4.app.C3184o.m9514a(r6, r0, r8);
        return r6;
    L_0x00a5:
        r6 = r5.f8210m;
        r6 = r6.m9498i();
        r6 = android.support.v4.app.C3184o.m9514a(r6, r8, r0);
        return r6;
    L_0x00b0:
        r6 = r5.f8210m;
        r6 = r6.m9498i();
        r7 = 1065982362; // 0x3f89999a float:1.075 double:5.26665264E-315;
        r6 = android.support.v4.app.C3184o.m9515a(r6, r0, r7, r0, r8);
        return r6;
    L_0x00be:
        r6 = r5.f8210m;
        r6 = r6.m9498i();
        r6 = android.support.v4.app.C3184o.m9515a(r6, r7, r0, r8, r0);
        return r6;
    L_0x00c9:
        r6 = r5.f8210m;
        r6 = r6.m9498i();
        r6 = android.support.v4.app.C3184o.m9515a(r6, r0, r7, r0, r8);
        return r6;
    L_0x00d4:
        r6 = r5.f8210m;
        r6 = r6.m9498i();
        r7 = 1066401792; // 0x3f900000 float:1.125 double:5.2687249E-315;
        r6 = android.support.v4.app.C3184o.m9515a(r6, r7, r0, r8, r0);
        return r6;
    L_0x00e1:
        if (r9 != 0) goto L_0x00e4;
    L_0x00e3:
        return r2;
    L_0x00e4:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.o.a(android.support.v4.app.i, int, boolean, int):android.support.v4.app.o$c");
    }

    /* renamed from: a */
    public void m9553a(C3178i c3178i) {
        if (c3178i.mDeferStart) {
            if (this.f8200c) {
                this.f8219w = true;
                return;
            }
            c3178i.mDeferStart = false;
            m9554a(c3178i, this.f8209l, 0, 0, false);
        }
    }

    /* renamed from: b */
    private static void m9532b(View view, C0316c c0316c) {
        if (view != null) {
            if (c0316c != null) {
                if (C3184o.m9528a(view, c0316c)) {
                    if (c0316c.f838b != null) {
                        c0316c.f838b.addListener(new C0317d(view));
                    } else {
                        AnimationListener a = C3184o.m9516a(c0316c.f837a);
                        view.setLayerType(2, null);
                        c0316c.f837a.setAnimationListener(new C3181a(view, a));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static AnimationListener m9516a(Animation animation) {
        try {
            if (f8192q == null) {
                f8192q = Animation.class.getDeclaredField("mListener");
                f8192q.setAccessible(true);
            }
            return (AnimationListener) f8192q.get(animation);
        } catch (Animation animation2) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", animation2);
            return null;
        } catch (Animation animation22) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", animation22);
            return null;
        }
    }

    /* renamed from: a */
    boolean m9563a(int i) {
        return this.f8209l >= i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    void m9554a(android.support.v4.app.C3178i r16, int r17, int r18, int r19, boolean r20) {
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
        r15 = this;
        r6 = r15;
        r7 = r16;
        r0 = r7.mAdded;
        r8 = 1;
        if (r0 == 0) goto L_0x0010;
    L_0x0008:
        r0 = r7.mDetached;
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        goto L_0x0010;
    L_0x000d:
        r0 = r17;
        goto L_0x0015;
    L_0x0010:
        r0 = r17;
        if (r0 <= r8) goto L_0x0015;
    L_0x0014:
        r0 = 1;
    L_0x0015:
        r1 = r7.mRemoving;
        if (r1 == 0) goto L_0x002b;
    L_0x0019:
        r1 = r7.mState;
        if (r0 <= r1) goto L_0x002b;
    L_0x001d:
        r0 = r7.mState;
        if (r0 != 0) goto L_0x0029;
    L_0x0021:
        r0 = r16.isInBackStack();
        if (r0 == 0) goto L_0x0029;
    L_0x0027:
        r0 = 1;
        goto L_0x002b;
    L_0x0029:
        r0 = r7.mState;
    L_0x002b:
        r1 = r7.mDeferStart;
        r9 = 4;
        r10 = 3;
        if (r1 == 0) goto L_0x0039;
    L_0x0031:
        r1 = r7.mState;
        if (r1 >= r9) goto L_0x0039;
    L_0x0035:
        if (r0 <= r10) goto L_0x0039;
    L_0x0037:
        r11 = 3;
        goto L_0x003a;
    L_0x0039:
        r11 = r0;
    L_0x003a:
        r0 = r7.mState;
        r12 = 2;
        r13 = 0;
        r14 = 0;
        if (r0 > r11) goto L_0x02fa;
    L_0x0041:
        r0 = r7.mFromLayout;
        if (r0 == 0) goto L_0x004a;
    L_0x0045:
        r0 = r7.mInLayout;
        if (r0 != 0) goto L_0x004a;
    L_0x0049:
        return;
    L_0x004a:
        r0 = r16.getAnimatingAway();
        if (r0 != 0) goto L_0x0056;
    L_0x0050:
        r0 = r16.getAnimator();
        if (r0 == 0) goto L_0x0069;
    L_0x0056:
        r7.setAnimatingAway(r13);
        r7.setAnimator(r13);
        r2 = r16.getStateAfterAnimating();
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0 = r15;
        r1 = r16;
        r0.m9554a(r1, r2, r3, r4, r5);
    L_0x0069:
        r0 = r7.mState;
        switch(r0) {
            case 0: goto L_0x0070;
            case 1: goto L_0x01af;
            case 2: goto L_0x02ac;
            case 3: goto L_0x02b0;
            case 4: goto L_0x02d2;
            default: goto L_0x006e;
        };
    L_0x006e:
        goto L_0x045f;
    L_0x0070:
        if (r11 <= 0) goto L_0x01af;
    L_0x0072:
        r0 = f8191a;
        if (r0 == 0) goto L_0x008c;
    L_0x0076:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x008c:
        r0 = r7.mSavedFragmentState;
        if (r0 == 0) goto L_0x00e3;
    L_0x0090:
        r0 = r7.mSavedFragmentState;
        r1 = r6.f8210m;
        r1 = r1.m9498i();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r7.mSavedFragmentState;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r7.mSavedViewState = r0;
        r0 = r7.mSavedFragmentState;
        r1 = "android:target_state";
        r0 = r15.m9543a(r0, r1);
        r7.mTarget = r0;
        r0 = r7.mTarget;
        if (r0 == 0) goto L_0x00c1;
    L_0x00b7:
        r0 = r7.mSavedFragmentState;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r14);
        r7.mTargetRequestCode = r0;
    L_0x00c1:
        r0 = r7.mSavedUserVisibleHint;
        if (r0 == 0) goto L_0x00d0;
    L_0x00c5:
        r0 = r7.mSavedUserVisibleHint;
        r0 = r0.booleanValue();
        r7.mUserVisibleHint = r0;
        r7.mSavedUserVisibleHint = r13;
        goto L_0x00da;
    L_0x00d0:
        r0 = r7.mSavedFragmentState;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r8);
        r7.mUserVisibleHint = r0;
    L_0x00da:
        r0 = r7.mUserVisibleHint;
        if (r0 != 0) goto L_0x00e3;
    L_0x00de:
        r7.mDeferStart = r8;
        if (r11 <= r10) goto L_0x00e3;
    L_0x00e2:
        r11 = 3;
    L_0x00e3:
        r0 = r6.f8210m;
        r7.mHost = r0;
        r0 = r6.f8212o;
        r7.mParentFragment = r0;
        r0 = r6.f8212o;
        if (r0 == 0) goto L_0x00f4;
    L_0x00ef:
        r0 = r6.f8212o;
        r0 = r0.mChildFragmentManager;
        goto L_0x00fa;
    L_0x00f4:
        r0 = r6.f8210m;
        r0 = r0.m9500k();
    L_0x00fa:
        r7.mFragmentManager = r0;
        r0 = r7.mTarget;
        if (r0 == 0) goto L_0x0145;
    L_0x0100:
        r0 = r6.f8203f;
        r1 = r7.mTarget;
        r1 = r1.mIndex;
        r0 = r0.get(r1);
        r1 = r7.mTarget;
        if (r0 != r1) goto L_0x011f;
    L_0x010e:
        r0 = r7.mTarget;
        r0 = r0.mState;
        if (r0 >= r8) goto L_0x0145;
    L_0x0114:
        r1 = r7.mTarget;
        r2 = 1;
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0 = r15;
        r0.m9554a(r1, r2, r3, r4, r5);
        goto L_0x0145;
    L_0x011f:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1.append(r2);
        r1.append(r7);
        r2 = " declared target fragment ";
        r1.append(r2);
        r2 = r7.mTarget;
        r1.append(r2);
        r2 = " that does not belong to this FragmentManager!";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0145:
        r0 = r6.f8210m;
        r0 = r0.m9498i();
        r15.m9555a(r7, r0, r14);
        r7.mCalled = r14;
        r0 = r6.f8210m;
        r0 = r0.m9498i();
        r7.onAttach(r0);
        r0 = r7.mCalled;
        if (r0 == 0) goto L_0x0193;
    L_0x015d:
        r0 = r7.mParentFragment;
        if (r0 != 0) goto L_0x0167;
    L_0x0161:
        r0 = r6.f8210m;
        r0.mo2676b(r7);
        goto L_0x016c;
    L_0x0167:
        r0 = r7.mParentFragment;
        r0.onAttachFragment(r7);
    L_0x016c:
        r0 = r6.f8210m;
        r0 = r0.m9498i();
        r15.m9572b(r7, r0, r14);
        r0 = r7.mIsCreated;
        if (r0 != 0) goto L_0x0189;
    L_0x0179:
        r0 = r7.mSavedFragmentState;
        r15.m9556a(r7, r0, r14);
        r0 = r7.mSavedFragmentState;
        r7.performCreate(r0);
        r0 = r7.mSavedFragmentState;
        r15.m9573b(r7, r0, r14);
        goto L_0x0190;
    L_0x0189:
        r0 = r7.mSavedFragmentState;
        r7.restoreChildFragmentState(r0);
        r7.mState = r8;
    L_0x0190:
        r7.mRetaining = r14;
        goto L_0x01af;
    L_0x0193:
        r0 = new android.support.v4.app.aj;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1.append(r2);
        r1.append(r7);
        r2 = " did not call through to super.onAttach()";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x01af:
        r15.m9582c(r16);
        if (r11 <= r8) goto L_0x02ac;
    L_0x01b4:
        r0 = f8191a;
        if (r0 == 0) goto L_0x01ce;
    L_0x01b8:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x01ce:
        r0 = r7.mFromLayout;
        if (r0 != 0) goto L_0x0297;
    L_0x01d2:
        r0 = r7.mContainerId;
        if (r0 == 0) goto L_0x0246;
    L_0x01d6:
        r0 = r7.mContainerId;
        r1 = -1;
        if (r0 != r1) goto L_0x01f9;
    L_0x01db:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Cannot create fragment ";
        r1.append(r2);
        r1.append(r7);
        r2 = " for a container view with no id";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r15.m9523a(r0);
    L_0x01f9:
        r0 = r6.f8211n;
        r1 = r7.mContainerId;
        r0 = r0.mo195a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0247;
    L_0x0205:
        r1 = r7.mRestored;
        if (r1 != 0) goto L_0x0247;
    L_0x0209:
        r1 = r16.getResources();	 Catch:{ NotFoundException -> 0x0214 }
        r2 = r7.mContainerId;	 Catch:{ NotFoundException -> 0x0214 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x0214 }
        goto L_0x0216;
    L_0x0214:
        r1 = "unknown";
    L_0x0216:
        r2 = new java.lang.IllegalArgumentException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "No view found for id 0x";
        r3.append(r4);
        r4 = r7.mContainerId;
        r4 = java.lang.Integer.toHexString(r4);
        r3.append(r4);
        r4 = " (";
        r3.append(r4);
        r3.append(r1);
        r1 = ") for fragment ";
        r3.append(r1);
        r3.append(r7);
        r1 = r3.toString();
        r2.<init>(r1);
        r15.m9523a(r2);
        goto L_0x0247;
    L_0x0246:
        r0 = r13;
    L_0x0247:
        r7.mContainer = r0;
        r1 = r7.mSavedFragmentState;
        r1 = r7.performGetLayoutInflater(r1);
        r2 = r7.mSavedFragmentState;
        r1 = r7.performCreateView(r1, r0, r2);
        r7.mView = r1;
        r1 = r7.mView;
        if (r1 == 0) goto L_0x0295;
    L_0x025b:
        r1 = r7.mView;
        r7.mInnerView = r1;
        r1 = r7.mView;
        r1.setSaveFromParentEnabled(r14);
        if (r0 == 0) goto L_0x026b;
    L_0x0266:
        r1 = r7.mView;
        r0.addView(r1);
    L_0x026b:
        r0 = r7.mHidden;
        if (r0 == 0) goto L_0x0276;
    L_0x026f:
        r0 = r7.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0276:
        r0 = r7.mView;
        r1 = r7.mSavedFragmentState;
        r7.onViewCreated(r0, r1);
        r0 = r7.mView;
        r1 = r7.mSavedFragmentState;
        r15.m9557a(r7, r0, r1, r14);
        r0 = r7.mView;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x0291;
    L_0x028c:
        r0 = r7.mContainer;
        if (r0 == 0) goto L_0x0291;
    L_0x0290:
        goto L_0x0292;
    L_0x0291:
        r8 = 0;
    L_0x0292:
        r7.mIsNewlyAdded = r8;
        goto L_0x0297;
    L_0x0295:
        r7.mInnerView = r13;
    L_0x0297:
        r0 = r7.mSavedFragmentState;
        r7.performActivityCreated(r0);
        r0 = r7.mSavedFragmentState;
        r15.m9583c(r7, r0, r14);
        r0 = r7.mView;
        if (r0 == 0) goto L_0x02aa;
    L_0x02a5:
        r0 = r7.mSavedFragmentState;
        r7.restoreViewState(r0);
    L_0x02aa:
        r7.mSavedFragmentState = r13;
    L_0x02ac:
        if (r11 <= r12) goto L_0x02b0;
    L_0x02ae:
        r7.mState = r10;
    L_0x02b0:
        if (r11 <= r10) goto L_0x02d2;
    L_0x02b2:
        r0 = f8191a;
        if (r0 == 0) goto L_0x02cc;
    L_0x02b6:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02cc:
        r16.performStart();
        r15.m9574b(r7, r14);
    L_0x02d2:
        if (r11 <= r9) goto L_0x045f;
    L_0x02d4:
        r0 = f8191a;
        if (r0 == 0) goto L_0x02ee;
    L_0x02d8:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02ee:
        r16.performResume();
        r15.m9584c(r7, r14);
        r7.mSavedFragmentState = r13;
        r7.mSavedViewState = r13;
        goto L_0x045f;
    L_0x02fa:
        r0 = r7.mState;
        if (r0 <= r11) goto L_0x045f;
    L_0x02fe:
        r0 = r7.mState;
        switch(r0) {
            case 1: goto L_0x03e9;
            case 2: goto L_0x0369;
            case 3: goto L_0x034a;
            case 4: goto L_0x0328;
            case 5: goto L_0x0305;
            default: goto L_0x0303;
        };
    L_0x0303:
        goto L_0x045f;
    L_0x0305:
        r0 = 5;
        if (r11 >= r0) goto L_0x0328;
    L_0x0308:
        r0 = f8191a;
        if (r0 == 0) goto L_0x0322;
    L_0x030c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0322:
        r16.performPause();
        r15.m9587d(r7, r14);
    L_0x0328:
        if (r11 >= r9) goto L_0x034a;
    L_0x032a:
        r0 = f8191a;
        if (r0 == 0) goto L_0x0344;
    L_0x032e:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0344:
        r16.performStop();
        r15.m9591e(r7, r14);
    L_0x034a:
        if (r11 >= r10) goto L_0x0369;
    L_0x034c:
        r0 = f8191a;
        if (r0 == 0) goto L_0x0366;
    L_0x0350:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0366:
        r16.performReallyStop();
    L_0x0369:
        if (r11 >= r12) goto L_0x03e9;
    L_0x036b:
        r0 = f8191a;
        if (r0 == 0) goto L_0x0385;
    L_0x036f:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0385:
        r0 = r7.mView;
        if (r0 == 0) goto L_0x0398;
    L_0x0389:
        r0 = r6.f8210m;
        r0 = r0.mo2673a(r7);
        if (r0 == 0) goto L_0x0398;
    L_0x0391:
        r0 = r7.mSavedViewState;
        if (r0 != 0) goto L_0x0398;
    L_0x0395:
        r15.m9610m(r16);
    L_0x0398:
        r16.performDestroyView();
        r15.m9593f(r7, r14);
        r0 = r7.mView;
        if (r0 == 0) goto L_0x03e1;
    L_0x03a2:
        r0 = r7.mContainer;
        if (r0 == 0) goto L_0x03e1;
    L_0x03a6:
        r0 = r7.mContainer;
        r1 = r7.mView;
        r0.endViewTransition(r1);
        r0 = r7.mView;
        r0.clearAnimation();
        r0 = r6.f8209l;
        r1 = 0;
        if (r0 <= 0) goto L_0x03d2;
    L_0x03b7:
        r0 = r6.f8217u;
        if (r0 != 0) goto L_0x03d2;
    L_0x03bb:
        r0 = r7.mView;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x03d2;
    L_0x03c3:
        r0 = r7.mPostponedAlpha;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x03d2;
    L_0x03c9:
        r0 = r18;
        r2 = r19;
        r0 = r15.m9545a(r7, r0, r14, r2);
        goto L_0x03d3;
    L_0x03d2:
        r0 = r13;
    L_0x03d3:
        r7.mPostponedAlpha = r1;
        if (r0 == 0) goto L_0x03da;
    L_0x03d7:
        r15.m9518a(r7, r0, r11);
    L_0x03da:
        r0 = r7.mContainer;
        r1 = r7.mView;
        r0.removeView(r1);
    L_0x03e1:
        r7.mContainer = r13;
        r7.mView = r13;
        r7.mInnerView = r13;
        r7.mInLayout = r14;
    L_0x03e9:
        if (r11 >= r8) goto L_0x045f;
    L_0x03eb:
        r0 = r6.f8217u;
        if (r0 == 0) goto L_0x0410;
    L_0x03ef:
        r0 = r16.getAnimatingAway();
        if (r0 == 0) goto L_0x0400;
    L_0x03f5:
        r0 = r16.getAnimatingAway();
        r7.setAnimatingAway(r13);
        r0.clearAnimation();
        goto L_0x0410;
    L_0x0400:
        r0 = r16.getAnimator();
        if (r0 == 0) goto L_0x0410;
    L_0x0406:
        r0 = r16.getAnimator();
        r7.setAnimator(r13);
        r0.cancel();
    L_0x0410:
        r0 = r16.getAnimatingAway();
        if (r0 != 0) goto L_0x045b;
    L_0x0416:
        r0 = r16.getAnimator();
        if (r0 == 0) goto L_0x041d;
    L_0x041c:
        goto L_0x045b;
    L_0x041d:
        r0 = f8191a;
        if (r0 == 0) goto L_0x0437;
    L_0x0421:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1.append(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0437:
        r0 = r7.mRetaining;
        if (r0 != 0) goto L_0x0442;
    L_0x043b:
        r16.performDestroy();
        r15.m9597g(r7, r14);
        goto L_0x0444;
    L_0x0442:
        r7.mState = r14;
    L_0x0444:
        r16.performDetach();
        r15.m9600h(r7, r14);
        if (r20 != 0) goto L_0x045f;
    L_0x044c:
        r0 = r7.mRetaining;
        if (r0 != 0) goto L_0x0454;
    L_0x0450:
        r15.m9596g(r16);
        goto L_0x045f;
    L_0x0454:
        r7.mHost = r13;
        r7.mParentFragment = r13;
        r7.mFragmentManager = r13;
        goto L_0x045f;
    L_0x045b:
        r7.setStateAfterAnimating(r11);
        goto L_0x0460;
    L_0x045f:
        r8 = r11;
    L_0x0460:
        r0 = r7.mState;
        if (r0 == r8) goto L_0x0493;
    L_0x0464:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1.append(r2);
        r1.append(r7);
        r2 = " not updated inline; ";
        r1.append(r2);
        r2 = "expected state ";
        r1.append(r2);
        r1.append(r8);
        r2 = " found ";
        r1.append(r2);
        r2 = r7.mState;
        r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r7.mState = r8;
    L_0x0493:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.o.a(android.support.v4.app.i, int, int, int, boolean):void");
    }

    /* renamed from: a */
    private void m9518a(final C3178i c3178i, C0316c c0316c, int i) {
        final View view = c3178i.mView;
        final ViewGroup viewGroup = c3178i.mContainer;
        viewGroup.startViewTransition(view);
        c3178i.setStateAfterAnimating(i);
        if (c0316c.f837a != 0) {
            Animation c0318e = new C0318e(c0316c.f837a, viewGroup, view);
            c3178i.setAnimatingAway(c3178i.mView);
            c0318e.setAnimationListener(new C0315b(this, C3184o.m9516a(c0318e)) {
                /* renamed from: c */
                final /* synthetic */ C3184o f8178c;

                /* compiled from: FragmentManager */
                /* renamed from: android.support.v4.app.o$2$1 */
                class C03111 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C31802 f826a;

                    C03111(C31802 c31802) {
                        this.f826a = c31802;
                    }

                    public void run() {
                        if (c3178i.getAnimatingAway() != null) {
                            c3178i.setAnimatingAway(null);
                            this.f826a.f8178c.m9554a(c3178i, c3178i.getStateAfterAnimating(), 0, 0, false);
                        }
                    }
                }

                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    viewGroup.post(new C03111(this));
                }
            });
            C3184o.m9532b(view, c0316c);
            c3178i.mView.startAnimation(c0318e);
            return;
        }
        i = c0316c.f838b;
        c3178i.setAnimator(c0316c.f838b);
        i.addListener(new AnimatorListenerAdapter(this) {
            /* renamed from: d */
            final /* synthetic */ C3184o f830d;

            public void onAnimationEnd(Animator animator) {
                viewGroup.endViewTransition(view);
                animator = c3178i.getAnimator();
                c3178i.setAnimator(null);
                if (animator != null && viewGroup.indexOfChild(view) < null) {
                    this.f830d.m9554a(c3178i, c3178i.getStateAfterAnimating(), 0, 0, false);
                }
            }
        });
        i.setTarget(c3178i.mView);
        C3184o.m9532b(c3178i.mView, c0316c);
        i.start();
    }

    /* renamed from: b */
    void m9571b(C3178i c3178i) {
        m9554a(c3178i, this.f8209l, 0, 0, false);
    }

    /* renamed from: c */
    void m9582c(C3178i c3178i) {
        if (c3178i.mFromLayout && !c3178i.mPerformedCreateView) {
            c3178i.mView = c3178i.performCreateView(c3178i.performGetLayoutInflater(c3178i.mSavedFragmentState), null, c3178i.mSavedFragmentState);
            if (c3178i.mView != null) {
                c3178i.mInnerView = c3178i.mView;
                c3178i.mView.setSaveFromParentEnabled(false);
                if (c3178i.mHidden) {
                    c3178i.mView.setVisibility(8);
                }
                c3178i.onViewCreated(c3178i.mView, c3178i.mSavedFragmentState);
                m9557a(c3178i, c3178i.mView, c3178i.mSavedFragmentState, false);
                return;
            }
            c3178i.mInnerView = null;
        }
    }

    /* renamed from: d */
    void m9585d(final C3178i c3178i) {
        if (c3178i.mView != null) {
            C0316c a = m9545a(c3178i, c3178i.getNextTransition(), c3178i.mHidden ^ true, c3178i.getNextTransitionStyle());
            if (a == null || a.f838b == null) {
                if (a != null) {
                    C3184o.m9532b(c3178i.mView, a);
                    c3178i.mView.startAnimation(a.f837a);
                    a.f837a.start();
                }
                int i = (!c3178i.mHidden || c3178i.isHideReplaced()) ? 0 : 8;
                c3178i.mView.setVisibility(i);
                if (c3178i.isHideReplaced()) {
                    c3178i.setHideReplaced(false);
                }
            } else {
                a.f838b.setTarget(c3178i.mView);
                if (!c3178i.mHidden) {
                    c3178i.mView.setVisibility(0);
                } else if (c3178i.isHideReplaced()) {
                    c3178i.setHideReplaced(false);
                } else {
                    final ViewGroup viewGroup = c3178i.mContainer;
                    final View view = c3178i.mView;
                    viewGroup.startViewTransition(view);
                    a.f838b.addListener(new AnimatorListenerAdapter(this) {
                        /* renamed from: d */
                        final /* synthetic */ C3184o f834d;

                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (c3178i.mView != null) {
                                c3178i.mView.setVisibility(8);
                            }
                        }
                    });
                }
                C3184o.m9532b(c3178i.mView, a);
                a.f838b.start();
            }
        }
        if (c3178i.mAdded && c3178i.mHasMenu && c3178i.mMenuVisible) {
            this.f8214r = true;
        }
        c3178i.mHiddenChanged = false;
        c3178i.onHiddenChanged(c3178i.mHidden);
    }

    /* renamed from: e */
    void m9590e(C3178i c3178i) {
        if (c3178i != null) {
            int i = this.f8209l;
            if (c3178i.mRemoving) {
                if (c3178i.isInBackStack()) {
                    i = Math.min(i, 1);
                } else {
                    i = Math.min(i, 0);
                }
            }
            m9554a(c3178i, i, c3178i.getNextTransition(), c3178i.getNextTransitionStyle(), false);
            if (c3178i.mView != null) {
                C3178i p = m9539p(c3178i);
                if (p != null) {
                    View view = p.mView;
                    ViewGroup viewGroup = c3178i.mContainer;
                    i = viewGroup.indexOfChild(view);
                    int indexOfChild = viewGroup.indexOfChild(c3178i.mView);
                    if (indexOfChild < i) {
                        viewGroup.removeViewAt(indexOfChild);
                        viewGroup.addView(c3178i.mView, i);
                    }
                }
                if (c3178i.mIsNewlyAdded && c3178i.mContainer != null) {
                    if (c3178i.mPostponedAlpha > 0.0f) {
                        c3178i.mView.setAlpha(c3178i.mPostponedAlpha);
                    }
                    c3178i.mPostponedAlpha = 0.0f;
                    c3178i.mIsNewlyAdded = false;
                    C0316c a = m9545a(c3178i, c3178i.getNextTransition(), true, c3178i.getNextTransitionStyle());
                    if (a != null) {
                        C3184o.m9532b(c3178i.mView, a);
                        if (a.f837a != null) {
                            c3178i.mView.startAnimation(a.f837a);
                        } else {
                            a.f838b.setTarget(c3178i.mView);
                            a.f838b.start();
                        }
                    }
                }
            }
            if (c3178i.mHiddenChanged) {
                m9585d(c3178i);
            }
        }
    }

    /* renamed from: a */
    void m9549a(int i, boolean z) {
        if (this.f8210m == null) {
            if (i != 0) {
                throw new IllegalStateException("No activity");
            }
        }
        if (z || i != this.f8209l) {
            this.f8209l = i;
            if (this.f8203f != 0) {
                int i2;
                i = this.f8202e.size();
                for (i2 = 0; i2 < i; i2++) {
                    m9590e((C3178i) this.f8202e.get(i2));
                }
                i = this.f8203f.size();
                for (i2 = 0; i2 < i; i2++) {
                    C3178i c3178i = (C3178i) this.f8203f.valueAt(i2);
                    if (c3178i != null && ((c3178i.mRemoving || c3178i.mDetached) && !c3178i.mIsNewlyAdded)) {
                        m9590e(c3178i);
                    }
                }
                m9589e();
                if (!(this.f8214r == 0 || this.f8210m == 0 || this.f8209l != 5)) {
                    this.f8210m.mo2677d();
                    this.f8214r = false;
                }
            }
        }
    }

    /* renamed from: e */
    void m9589e() {
        if (this.f8203f != null) {
            for (int i = 0; i < this.f8203f.size(); i++) {
                C3178i c3178i = (C3178i) this.f8203f.valueAt(i);
                if (c3178i != null) {
                    m9553a(c3178i);
                }
            }
        }
    }

    /* renamed from: f */
    void m9592f(C3178i c3178i) {
        if (c3178i.mIndex < 0) {
            int i = this.f8201d;
            this.f8201d = i + 1;
            c3178i.setIndex(i, this.f8212o);
            if (this.f8203f == null) {
                this.f8203f = new SparseArray();
            }
            this.f8203f.put(c3178i.mIndex, c3178i);
            if (f8191a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Allocated fragment index ");
                stringBuilder.append(c3178i);
                Log.v("FragmentManager", stringBuilder.toString());
            }
        }
    }

    /* renamed from: g */
    void m9596g(C3178i c3178i) {
        if (c3178i.mIndex >= 0) {
            if (f8191a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Freeing fragment index ");
                stringBuilder.append(c3178i);
                Log.v("FragmentManager", stringBuilder.toString());
            }
            this.f8203f.put(c3178i.mIndex, null);
            c3178i.initState();
        }
    }

    /* renamed from: a */
    public void m9558a(C3178i c3178i, boolean z) {
        if (f8191a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("add: ");
            stringBuilder.append(c3178i);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        m9592f(c3178i);
        if (!c3178i.mDetached) {
            if (this.f8202e.contains(c3178i)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Fragment already added: ");
                stringBuilder2.append(c3178i);
                throw new IllegalStateException(stringBuilder2.toString());
            }
            synchronized (this.f8202e) {
                this.f8202e.add(c3178i);
            }
            c3178i.mAdded = true;
            c3178i.mRemoving = false;
            if (c3178i.mView == null) {
                c3178i.mHiddenChanged = false;
            }
            if (c3178i.mHasMenu && c3178i.mMenuVisible) {
                this.f8214r = true;
            }
            if (z) {
                m9571b(c3178i);
            }
        }
    }

    /* renamed from: h */
    public void m9599h(C3178i c3178i) {
        if (f8191a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("remove: ");
            stringBuilder.append(c3178i);
            stringBuilder.append(" nesting=");
            stringBuilder.append(c3178i.mBackStackNesting);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        int isInBackStack = c3178i.isInBackStack() ^ 1;
        if (!c3178i.mDetached || isInBackStack != 0) {
            synchronized (this.f8202e) {
                this.f8202e.remove(c3178i);
            }
            if (c3178i.mHasMenu && c3178i.mMenuVisible) {
                this.f8214r = true;
            }
            c3178i.mAdded = false;
            c3178i.mRemoving = true;
        }
    }

    /* renamed from: i */
    public void m9602i(C3178i c3178i) {
        if (f8191a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("hide: ");
            stringBuilder.append(c3178i);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        if (!c3178i.mHidden) {
            c3178i.mHidden = true;
            c3178i.mHiddenChanged = true ^ c3178i.mHiddenChanged;
        }
    }

    /* renamed from: j */
    public void m9604j(C3178i c3178i) {
        if (f8191a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("show: ");
            stringBuilder.append(c3178i);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        if (c3178i.mHidden) {
            c3178i.mHidden = false;
            c3178i.mHiddenChanged ^= 1;
        }
    }

    /* renamed from: k */
    public void m9606k(C3178i c3178i) {
        if (f8191a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("detach: ");
            stringBuilder.append(c3178i);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        if (!c3178i.mDetached) {
            c3178i.mDetached = true;
            if (c3178i.mAdded) {
                if (f8191a) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("remove from detach: ");
                    stringBuilder2.append(c3178i);
                    Log.v("FragmentManager", stringBuilder2.toString());
                }
                synchronized (this.f8202e) {
                    this.f8202e.remove(c3178i);
                }
                if (c3178i.mHasMenu && c3178i.mMenuVisible) {
                    this.f8214r = true;
                }
                c3178i.mAdded = false;
            }
        }
    }

    /* renamed from: l */
    public void m9608l(C3178i c3178i) {
        if (f8191a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("attach: ");
            stringBuilder.append(c3178i);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        if (c3178i.mDetached) {
            c3178i.mDetached = false;
            if (!c3178i.mAdded) {
                if (this.f8202e.contains(c3178i)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Fragment already added: ");
                    stringBuilder.append(c3178i);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                if (f8191a) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("add from attach: ");
                    stringBuilder.append(c3178i);
                    Log.v("FragmentManager", stringBuilder.toString());
                }
                synchronized (this.f8202e) {
                    this.f8202e.add(c3178i);
                }
                c3178i.mAdded = true;
                if (c3178i.mHasMenu && c3178i.mMenuVisible != null) {
                    this.f8214r = true;
                }
            }
        }
    }

    /* renamed from: b */
    public C3178i m9568b(int i) {
        int size;
        for (size = this.f8202e.size() - 1; size >= 0; size--) {
            C3178i c3178i = (C3178i) this.f8202e.get(size);
            if (c3178i != null && c3178i.mFragmentId == i) {
                return c3178i;
            }
        }
        if (this.f8203f != null) {
            for (size = this.f8203f.size() - 1; size >= 0; size--) {
                c3178i = (C3178i) this.f8203f.valueAt(size);
                if (c3178i != null && c3178i.mFragmentId == i) {
                    return c3178i;
                }
            }
        }
        return 0;
    }

    /* renamed from: a */
    public C3178i mo200a(String str) {
        int size;
        C3178i c3178i;
        if (str != null) {
            for (size = this.f8202e.size() - 1; size >= 0; size--) {
                c3178i = (C3178i) this.f8202e.get(size);
                if (c3178i != null && str.equals(c3178i.mTag)) {
                    return c3178i;
                }
            }
        }
        if (!(this.f8203f == null || str == null)) {
            for (size = this.f8203f.size() - 1; size >= 0; size--) {
                c3178i = (C3178i) this.f8203f.valueAt(size);
                if (c3178i != null && str.equals(c3178i.mTag)) {
                    return c3178i;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public C3178i m9569b(String str) {
        if (!(this.f8203f == null || str == null)) {
            for (int size = this.f8203f.size() - 1; size >= 0; size--) {
                C3178i c3178i = (C3178i) this.f8203f.valueAt(size);
                if (c3178i != null) {
                    c3178i = c3178i.findFragmentByWho(str);
                    if (c3178i != null) {
                        return c3178i;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: y */
    private void m9540y() {
        if (mo206d()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f8218v != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can not perform this action inside of ");
            stringBuilder.append(this.f8218v);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: d */
    public boolean mo206d() {
        if (!this.f8215s) {
            if (!this.f8216t) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void m9560a(C0320g c0320g, boolean z) {
        if (!z) {
            m9540y();
        }
        synchronized (this) {
            if (!this.f8217u) {
                if (this.f8210m != null) {
                    if (!this.f8199b) {
                        this.f8199b = new ArrayList();
                    }
                    this.f8199b.add(c0320g);
                    m9541z();
                    return;
                }
            }
            if (z) {
                return;
            }
            throw new IllegalStateException("Activity has been destroyed");
        }
    }

    /* renamed from: z */
    private void m9541z() {
        synchronized (this) {
            Object obj = null;
            Object obj2 = (this.f8195C == null || this.f8195C.isEmpty()) ? null : 1;
            if (this.f8199b != null && this.f8199b.size() == 1) {
                obj = 1;
            }
            if (!(obj2 == null && r1 == null)) {
                this.f8210m.m9499j().removeCallbacks(this.f8197E);
                this.f8210m.m9499j().post(this.f8197E);
            }
        }
    }

    /* renamed from: a */
    public int m9542a(C3176c c3176c) {
        synchronized (this) {
            int intValue;
            if (this.f8207j != null) {
                if (this.f8207j.size() > 0) {
                    intValue = ((Integer) this.f8207j.remove(this.f8207j.size() - 1)).intValue();
                    if (f8191a) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Adding back stack index ");
                        stringBuilder.append(intValue);
                        stringBuilder.append(" with ");
                        stringBuilder.append(c3176c);
                        Log.v("FragmentManager", stringBuilder.toString());
                    }
                    this.f8206i.set(intValue, c3176c);
                    return intValue;
                }
            }
            if (this.f8206i == null) {
                this.f8206i = new ArrayList();
            }
            intValue = this.f8206i.size();
            if (f8191a) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Setting back stack index ");
                stringBuilder.append(intValue);
                stringBuilder.append(" to ");
                stringBuilder.append(c3176c);
                Log.v("FragmentManager", stringBuilder.toString());
            }
            this.f8206i.add(c3176c);
            return intValue;
        }
    }

    /* renamed from: a */
    public void m9548a(int i, C3176c c3176c) {
        synchronized (this) {
            if (this.f8206i == null) {
                this.f8206i = new ArrayList();
            }
            int size = this.f8206i.size();
            StringBuilder stringBuilder;
            if (i < size) {
                if (f8191a) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Setting back stack index ");
                    stringBuilder.append(i);
                    stringBuilder.append(" to ");
                    stringBuilder.append(c3176c);
                    Log.v("FragmentManager", stringBuilder.toString());
                }
                this.f8206i.set(i, c3176c);
            } else {
                while (size < i) {
                    this.f8206i.add(null);
                    if (this.f8207j == null) {
                        this.f8207j = new ArrayList();
                    }
                    if (f8191a) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Adding available back stack index ");
                        stringBuilder2.append(size);
                        Log.v("FragmentManager", stringBuilder2.toString());
                    }
                    this.f8207j.add(Integer.valueOf(size));
                    size++;
                }
                if (f8191a) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Adding back stack index ");
                    stringBuilder.append(i);
                    stringBuilder.append(" with ");
                    stringBuilder.append(c3176c);
                    Log.v("FragmentManager", stringBuilder.toString());
                }
                this.f8206i.add(c3176c);
            }
        }
    }

    /* renamed from: c */
    public void m9581c(int i) {
        synchronized (this) {
            this.f8206i.set(i, null);
            if (this.f8207j == null) {
                this.f8207j = new ArrayList();
            }
            if (f8191a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Freeing back stack index ");
                stringBuilder.append(i);
                Log.v("FragmentManager", stringBuilder.toString());
            }
            this.f8207j.add(Integer.valueOf(i));
        }
    }

    /* renamed from: c */
    private void m9535c(boolean z) {
        if (this.f8200c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f8210m == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() == this.f8210m.m9499j().getLooper()) {
            if (!z) {
                m9540y();
            }
            if (!this.f8220x) {
                this.f8220x = new ArrayList();
                this.f8221y = new ArrayList();
            }
            this.f8200c = true;
            try {
                m9524a(null, null);
            } finally {
                this.f8200c = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    /* renamed from: b */
    public void m9575b(C0320g c0320g, boolean z) {
        if (!z || (this.f8210m != null && !this.f8217u)) {
            m9535c(z);
            if (c0320g.mo187a(this.f8220x, this.f8221y) != null) {
                this.f8200c = true;
                try {
                    m9533b(this.f8220x, this.f8221y);
                } finally {
                    m9509A();
                }
            }
            m9595g();
            m9512D();
        }
    }

    /* renamed from: A */
    private void m9509A() {
        this.f8200c = false;
        this.f8221y.clear();
        this.f8220x.clear();
    }

    /* renamed from: f */
    public boolean m9594f() {
        m9535c(true);
        boolean z = false;
        while (m9536c(this.f8220x, this.f8221y)) {
            this.f8200c = true;
            try {
                m9533b(this.f8220x, this.f8221y);
                m9509A();
                z = true;
            } catch (Throwable th) {
                m9509A();
                throw th;
            }
        }
        m9595g();
        m9512D();
        return z;
    }

    /* renamed from: a */
    private void m9524a(ArrayList<C3176c> arrayList, ArrayList<Boolean> arrayList2) {
        int size = this.f8195C == null ? 0 : this.f8195C.size();
        int i = 0;
        while (i < size) {
            int indexOf;
            C3183i c3183i = (C3183i) this.f8195C.get(i);
            if (!(arrayList == null || c3183i.f8184a)) {
                indexOf = arrayList.indexOf(c3183i.f8185b);
                if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    c3183i.m9508e();
                    i++;
                }
            }
            if (c3183i.m9506c() || (arrayList != null && c3183i.f8185b.m9464a((ArrayList) arrayList, 0, arrayList.size()))) {
                this.f8195C.remove(i);
                i--;
                size--;
                if (!(arrayList == null || c3183i.f8184a)) {
                    indexOf = arrayList.indexOf(c3183i.f8185b);
                    if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                        c3183i.m9508e();
                    }
                }
                c3183i.m9507d();
            }
            i++;
        }
    }

    /* renamed from: b */
    private void m9533b(ArrayList<C3176c> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null) {
            if (!arrayList.isEmpty()) {
                if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                    throw new IllegalStateException("Internal error with the back stack records");
                }
                m9524a((ArrayList) arrayList, (ArrayList) arrayList2);
                int size = arrayList.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    if (!((C3176c) arrayList.get(i)).f8168t) {
                        if (i2 != i) {
                            m9525a((ArrayList) arrayList, (ArrayList) arrayList2, i2, i);
                        }
                        i2 = i + 1;
                        if (((Boolean) arrayList2.get(i)).booleanValue()) {
                            while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((C3176c) arrayList.get(i2)).f8168t) {
                                i2++;
                            }
                        }
                        m9525a((ArrayList) arrayList, (ArrayList) arrayList2, i, i2);
                        i = i2 - 1;
                    }
                    i++;
                }
                if (i2 != size) {
                    m9525a((ArrayList) arrayList, (ArrayList) arrayList2, i2, size);
                }
            }
        }
    }

    /* renamed from: a */
    private void m9525a(ArrayList<C3176c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        ArrayList<C3176c> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i5 = i;
        int i6 = i2;
        boolean z = ((C3176c) arrayList3.get(i5)).f8168t;
        if (this.f8222z == null) {
            r6.f8222z = new ArrayList();
        } else {
            r6.f8222z.clear();
        }
        r6.f8222z.addAll(r6.f8202e);
        C3178i w = m9622w();
        Object obj = null;
        for (i3 = i5; i3 < i6; i3++) {
            C3176c c3176c = (C3176c) arrayList3.get(i3);
            if (((Boolean) arrayList4.get(i3)).booleanValue()) {
                w = c3176c.m9467b(r6.f8222z, w);
            } else {
                w = c3176c.m9452a(r6.f8222z, w);
            }
            if (obj == null) {
                if (!c3176c.f8157i) {
                    obj = null;
                }
            }
            obj = 1;
        }
        r6.f8222z.clear();
        if (!z) {
            C0332u.m981a(this, (ArrayList) arrayList, (ArrayList) arrayList2, i, i2, false);
        }
        C3184o.m9534b(arrayList, arrayList2, i, i2);
        if (z) {
            C0448b c0448b = new C0448b();
            m9531b(c0448b);
            i3 = m9513a((ArrayList) arrayList, (ArrayList) arrayList2, i, i2, c0448b);
            m9522a(c0448b);
            i4 = i3;
        } else {
            i4 = i6;
        }
        if (i4 != i5 && z) {
            C0332u.m981a(this, (ArrayList) arrayList, (ArrayList) arrayList2, i, i4, true);
            m9549a(r6.f8209l, true);
        }
        while (i5 < i6) {
            C3176c c3176c2 = (C3176c) arrayList3.get(i5);
            if (((Boolean) arrayList4.get(i5)).booleanValue() && c3176c2.f8161m >= 0) {
                m9581c(c3176c2.f8161m);
                c3176c2.f8161m = -1;
            }
            c3176c2.m9469b();
            i5++;
        }
        if (obj != null) {
            m9598h();
        }
    }

    /* renamed from: a */
    private void m9522a(C0448b<C3178i> c0448b) {
        int size = c0448b.size();
        for (int i = 0; i < size; i++) {
            C3178i c3178i = (C3178i) c0448b.m1400b(i);
            if (!c3178i.mAdded) {
                View view = c3178i.getView();
                c3178i.mPostponedAlpha = view.getAlpha();
                view.setAlpha(0.0f);
            }
        }
    }

    /* renamed from: a */
    private int m9513a(ArrayList<C3176c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, C0448b<C3178i> c0448b) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            C3176c c3176c = (C3176c) arrayList.get(i4);
            boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
            Object obj = (!c3176c.m9478h() || c3176c.m9464a((ArrayList) arrayList, i4 + 1, i2)) ? null : 1;
            if (obj != null) {
                if (this.f8195C == null) {
                    this.f8195C = new ArrayList();
                }
                C0300c c3183i = new C3183i(c3176c, booleanValue);
                this.f8195C.add(c3183i);
                c3176c.m9461a(c3183i);
                if (booleanValue) {
                    c3176c.m9477g();
                } else {
                    c3176c.m9473c(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, c3176c);
                }
                m9531b((C0448b) c0448b);
            }
        }
        return i3;
    }

    /* renamed from: a */
    private void m9517a(C3176c c3176c, boolean z, boolean z2, boolean z3) {
        if (z) {
            c3176c.m9473c(z3);
        } else {
            c3176c.m9477g();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(c3176c);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            C0332u.m981a(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            m9549a(this.f8209l, true);
        }
        if (this.f8203f) {
            z = this.f8203f.size();
            for (boolean z4 = false; z4 < z; z4++) {
                C3178i c3178i = (C3178i) this.f8203f.valueAt(z4);
                if (c3178i != null && c3178i.mView != null && c3178i.mIsNewlyAdded && c3176c.m9470b(c3178i.mContainerId)) {
                    if (c3178i.mPostponedAlpha > 0.0f) {
                        c3178i.mView.setAlpha(c3178i.mPostponedAlpha);
                    }
                    if (z3) {
                        c3178i.mPostponedAlpha = 0.0f;
                    } else {
                        c3178i.mPostponedAlpha = -1.0f;
                        c3178i.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }

    /* renamed from: p */
    private C3178i m9539p(C3178i c3178i) {
        ViewGroup viewGroup = c3178i.mContainer;
        View view = c3178i.mView;
        if (viewGroup != null) {
            if (view != null) {
                for (c3178i = this.f8202e.indexOf(c3178i) - 1; c3178i >= null; c3178i--) {
                    C3178i c3178i2 = (C3178i) this.f8202e.get(c3178i);
                    if (c3178i2.mContainer == viewGroup && c3178i2.mView != null) {
                        return c3178i2;
                    }
                }
                return null;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static void m9534b(ArrayList<C3176c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            C3176c c3176c = (C3176c) arrayList.get(i);
            boolean z = true;
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                c3176c.m9459a(-1);
                if (i != i2 - 1) {
                    z = false;
                }
                c3176c.m9473c(z);
            } else {
                c3176c.m9459a(1);
                c3176c.m9477g();
            }
            i++;
        }
    }

    /* renamed from: b */
    private void m9531b(C0448b<C3178i> c0448b) {
        if (this.f8209l >= 1) {
            int min = Math.min(this.f8209l, 4);
            int size = this.f8202e.size();
            for (int i = 0; i < size; i++) {
                C3178i c3178i = (C3178i) this.f8202e.get(i);
                if (c3178i.mState < min) {
                    m9554a(c3178i, min, c3178i.getNextAnim(), c3178i.getNextTransition(), false);
                    if (!(c3178i.mView == null || c3178i.mHidden || !c3178i.mIsNewlyAdded)) {
                        c0448b.add(c3178i);
                    }
                }
            }
        }
    }

    /* renamed from: B */
    private void m9510B() {
        if (this.f8195C != null) {
            while (!this.f8195C.isEmpty()) {
                ((C3183i) this.f8195C.remove(0)).m9507d();
            }
        }
    }

    /* renamed from: C */
    private void m9511C() {
        int i = 0;
        int size = this.f8203f == null ? 0 : this.f8203f.size();
        while (i < size) {
            C3178i c3178i = (C3178i) this.f8203f.valueAt(i);
            if (c3178i != null) {
                if (c3178i.getAnimatingAway() != null) {
                    int stateAfterAnimating = c3178i.getStateAfterAnimating();
                    View animatingAway = c3178i.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    c3178i.setAnimatingAway(null);
                    m9554a(c3178i, stateAfterAnimating, 0, 0, false);
                } else if (c3178i.getAnimator() != null) {
                    c3178i.getAnimator().end();
                }
            }
            i++;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private boolean m9536c(java.util.ArrayList<android.support.v4.app.C3176c> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.f8199b;	 Catch:{ all -> 0x003c }
        r1 = 0;
        if (r0 == 0) goto L_0x003a;
    L_0x0006:
        r0 = r4.f8199b;	 Catch:{ all -> 0x003c }
        r0 = r0.size();	 Catch:{ all -> 0x003c }
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x003a;
    L_0x000f:
        r0 = r4.f8199b;	 Catch:{ all -> 0x003c }
        r0 = r0.size();	 Catch:{ all -> 0x003c }
        r2 = 0;
    L_0x0016:
        if (r1 >= r0) goto L_0x0028;
    L_0x0018:
        r3 = r4.f8199b;	 Catch:{ all -> 0x003c }
        r3 = r3.get(r1);	 Catch:{ all -> 0x003c }
        r3 = (android.support.v4.app.C3184o.C0320g) r3;	 Catch:{ all -> 0x003c }
        r3 = r3.mo187a(r5, r6);	 Catch:{ all -> 0x003c }
        r2 = r2 | r3;
        r1 = r1 + 1;
        goto L_0x0016;
    L_0x0028:
        r5 = r4.f8199b;	 Catch:{ all -> 0x003c }
        r5.clear();	 Catch:{ all -> 0x003c }
        r5 = r4.f8210m;	 Catch:{ all -> 0x003c }
        r5 = r5.m9499j();	 Catch:{ all -> 0x003c }
        r6 = r4.f8197E;	 Catch:{ all -> 0x003c }
        r5.removeCallbacks(r6);	 Catch:{ all -> 0x003c }
        monitor-exit(r4);	 Catch:{ all -> 0x003c }
        return r2;
    L_0x003a:
        monitor-exit(r4);	 Catch:{ all -> 0x003c }
        return r1;
    L_0x003c:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003c }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.o.c(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    /* renamed from: g */
    void m9595g() {
        if (this.f8219w) {
            this.f8219w = false;
            m9589e();
        }
    }

    /* renamed from: h */
    void m9598h() {
        if (this.f8208k != null) {
            for (int i = 0; i < this.f8208k.size(); i++) {
                ((C0308b) this.f8208k.get(i)).m937a();
            }
        }
    }

    /* renamed from: b */
    void m9570b(C3176c c3176c) {
        if (this.f8204g == null) {
            this.f8204g = new ArrayList();
        }
        this.f8204g.add(c3176c);
    }

    /* renamed from: a */
    boolean m9567a(ArrayList<C3176c> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        if (this.f8204g == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            str = this.f8204g.size() - 1;
            if (str < null) {
                return false;
            }
            arrayList.add(this.f8204g.remove(str));
            arrayList2.add(Boolean.valueOf(true));
        } else {
            int i3;
            if (str == null) {
                if (i < 0) {
                    i3 = -1;
                    if (i3 == this.f8204g.size() - 1) {
                        return false;
                    }
                    for (str = this.f8204g.size() - 1; str > i3; str--) {
                        arrayList.add(this.f8204g.remove(str));
                        arrayList2.add(Boolean.valueOf(true));
                    }
                }
            }
            i3 = this.f8204g.size() - 1;
            while (i3 >= 0) {
                C3176c c3176c = (C3176c) this.f8204g.get(i3);
                if (str == null || !str.equals(c3176c.m9479i())) {
                    if (i >= 0 && i == c3176c.f8161m) {
                        break;
                    }
                    i3--;
                } else {
                    break;
                }
            }
            if (i3 < 0) {
                return false;
            }
            if ((i2 & 1) != 0) {
                i3--;
                while (i3 >= 0) {
                    C3176c c3176c2 = (C3176c) this.f8204g.get(i3);
                    if ((str == null || !str.equals(c3176c2.m9479i())) && (i < 0 || i != c3176c2.f8161m)) {
                        break;
                    }
                    i3--;
                }
            }
            if (i3 == this.f8204g.size() - 1) {
                return false;
            }
            for (str = this.f8204g.size() - 1; str > i3; str--) {
                arrayList.add(this.f8204g.remove(str));
                arrayList2.add(Boolean.valueOf(true));
            }
        }
        return true;
    }

    /* renamed from: i */
    C0321p m9601i() {
        C3184o.m9521a(this.f8196D);
        return this.f8196D;
    }

    /* renamed from: a */
    private static void m9521a(C0321p c0321p) {
        if (c0321p != null) {
            List<C3178i> a = c0321p.m946a();
            if (a != null) {
                for (C3178i c3178i : a) {
                    c3178i.mRetaining = true;
                }
            }
            C0321p<C0321p> b = c0321p.m947b();
            if (b != null) {
                for (C0321p a2 : b) {
                    C3184o.m9521a(a2);
                }
            }
        }
    }

    /* renamed from: j */
    void m9603j() {
        List list;
        List list2;
        List list3;
        if (this.f8203f != null) {
            list = null;
            list2 = list;
            list3 = list2;
            for (int i = 0; i < this.f8203f.size(); i++) {
                C3178i c3178i = (C3178i) this.f8203f.valueAt(i);
                if (c3178i != null) {
                    Object obj;
                    if (c3178i.mRetainInstance) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(c3178i);
                        c3178i.mTargetIndex = c3178i.mTarget != null ? c3178i.mTarget.mIndex : -1;
                        if (f8191a) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("retainNonConfig: keeping retained ");
                            stringBuilder.append(c3178i);
                            Log.v("FragmentManager", stringBuilder.toString());
                        }
                    }
                    if (c3178i.mChildFragmentManager != null) {
                        c3178i.mChildFragmentManager.m9603j();
                        obj = c3178i.mChildFragmentManager.f8196D;
                    } else {
                        obj = c3178i.mChildNonConfig;
                    }
                    if (list2 == null && obj != null) {
                        list2 = new ArrayList(this.f8203f.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            list2.add(null);
                        }
                    }
                    if (list2 != null) {
                        list2.add(obj);
                    }
                    if (list3 == null && c3178i.mViewModelStore != null) {
                        list3 = new ArrayList(this.f8203f.size());
                        for (int i3 = 0; i3 < i; i3++) {
                            list3.add(null);
                        }
                    }
                    if (list3 != null) {
                        list3.add(c3178i.mViewModelStore);
                    }
                }
            }
        } else {
            list = null;
            list2 = list;
            list3 = list2;
        }
        if (list == null && list2 == null && list3 == null) {
            this.f8196D = null;
        } else {
            this.f8196D = new C0321p(list, list2, list3);
        }
    }

    /* renamed from: m */
    void m9610m(C3178i c3178i) {
        if (c3178i.mInnerView != null) {
            if (this.f8194B == null) {
                this.f8194B = new SparseArray();
            } else {
                this.f8194B.clear();
            }
            c3178i.mInnerView.saveHierarchyState(this.f8194B);
            if (this.f8194B.size() > 0) {
                c3178i.mSavedViewState = this.f8194B;
                this.f8194B = null;
            }
        }
    }

    /* renamed from: n */
    Bundle m9611n(C3178i c3178i) {
        Bundle bundle;
        if (this.f8193A == null) {
            this.f8193A = new Bundle();
        }
        c3178i.performSaveInstanceState(this.f8193A);
        m9586d(c3178i, this.f8193A, false);
        if (this.f8193A.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f8193A;
            this.f8193A = null;
        }
        if (c3178i.mView != null) {
            m9610m(c3178i);
        }
        if (c3178i.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", c3178i.mSavedViewState);
        }
        if (!c3178i.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", c3178i.mUserVisibleHint);
        }
        return bundle;
    }

    /* renamed from: k */
    Parcelable m9605k() {
        m9510B();
        m9511C();
        m9594f();
        this.f8215s = true;
        C0294d[] c0294dArr = null;
        this.f8196D = null;
        if (this.f8203f != null) {
            if (this.f8203f.size() > 0) {
                int i;
                int size = this.f8203f.size();
                C0325s[] c0325sArr = new C0325s[size];
                Object obj = null;
                for (i = 0; i < size; i++) {
                    C3178i c3178i = (C3178i) this.f8203f.valueAt(i);
                    if (c3178i != null) {
                        StringBuilder stringBuilder;
                        if (c3178i.mIndex < 0) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Failure saving state: active ");
                            stringBuilder2.append(c3178i);
                            stringBuilder2.append(" has cleared index: ");
                            stringBuilder2.append(c3178i.mIndex);
                            m9523a(new IllegalStateException(stringBuilder2.toString()));
                        }
                        C0325s c0325s = new C0325s(c3178i);
                        c0325sArr[i] = c0325s;
                        if (c3178i.mState <= 0 || c0325s.f863k != null) {
                            c0325s.f863k = c3178i.mSavedFragmentState;
                        } else {
                            c0325s.f863k = m9611n(c3178i);
                            if (c3178i.mTarget != null) {
                                if (c3178i.mTarget.mIndex < 0) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Failure saving state: ");
                                    stringBuilder.append(c3178i);
                                    stringBuilder.append(" has target not in fragment manager: ");
                                    stringBuilder.append(c3178i.mTarget);
                                    m9523a(new IllegalStateException(stringBuilder.toString()));
                                }
                                if (c0325s.f863k == null) {
                                    c0325s.f863k = new Bundle();
                                }
                                m9551a(c0325s.f863k, "android:target_state", c3178i.mTarget);
                                if (c3178i.mTargetRequestCode != 0) {
                                    c0325s.f863k.putInt("android:target_req_state", c3178i.mTargetRequestCode);
                                }
                            }
                        }
                        if (f8191a) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Saved state of ");
                            stringBuilder.append(c3178i);
                            stringBuilder.append(": ");
                            stringBuilder.append(c0325s.f863k);
                            Log.v("FragmentManager", stringBuilder.toString());
                        }
                        obj = 1;
                    }
                }
                if (obj == null) {
                    if (f8191a) {
                        Log.v("FragmentManager", "saveAllState: no fragments!");
                    }
                    return null;
                }
                int[] iArr;
                int size2 = this.f8202e.size();
                if (size2 > 0) {
                    iArr = new int[size2];
                    for (i = 0; i < size2; i++) {
                        StringBuilder stringBuilder3;
                        iArr[i] = ((C3178i) this.f8202e.get(i)).mIndex;
                        if (iArr[i] < 0) {
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("Failure saving state: active ");
                            stringBuilder3.append(this.f8202e.get(i));
                            stringBuilder3.append(" has cleared index: ");
                            stringBuilder3.append(iArr[i]);
                            m9523a(new IllegalStateException(stringBuilder3.toString()));
                        }
                        if (f8191a) {
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("saveAllState: adding fragment #");
                            stringBuilder3.append(i);
                            stringBuilder3.append(": ");
                            stringBuilder3.append(this.f8202e.get(i));
                            Log.v("FragmentManager", stringBuilder3.toString());
                        }
                    }
                } else {
                    iArr = null;
                }
                if (this.f8204g != null) {
                    size2 = this.f8204g.size();
                    if (size2 > 0) {
                        c0294dArr = new C0294d[size2];
                        for (int i2 = 0; i2 < size2; i2++) {
                            c0294dArr[i2] = new C0294d((C3176c) this.f8204g.get(i2));
                            if (f8191a) {
                                StringBuilder stringBuilder4 = new StringBuilder();
                                stringBuilder4.append("saveAllState: adding back stack #");
                                stringBuilder4.append(i2);
                                stringBuilder4.append(": ");
                                stringBuilder4.append(this.f8204g.get(i2));
                                Log.v("FragmentManager", stringBuilder4.toString());
                            }
                        }
                    }
                }
                Parcelable c0323q = new C0323q();
                c0323q.f848a = c0325sArr;
                c0323q.f849b = iArr;
                c0323q.f850c = c0294dArr;
                if (this.f8213p != null) {
                    c0323q.f851d = this.f8213p.mIndex;
                }
                c0323q.f852e = this.f8201d;
                m9603j();
                return c0323q;
            }
        }
        return null;
    }

    /* renamed from: a */
    void m9552a(Parcelable parcelable, C0321p c0321p) {
        if (parcelable != null) {
            C0323q c0323q = (C0323q) parcelable;
            if (c0323q.f848a != null) {
                List b;
                List c;
                if (c0321p != null) {
                    List a = c0321p.m946a();
                    b = c0321p.m947b();
                    c = c0321p.m948c();
                    int size = a != null ? a.size() : 0;
                    for (int i = 0; i < size; i++) {
                        C3178i c3178i = (C3178i) a.get(i);
                        if (f8191a) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("restoreAllState: re-attaching retained ");
                            stringBuilder.append(c3178i);
                            Log.v("FragmentManager", stringBuilder.toString());
                        }
                        int i2 = 0;
                        while (i2 < c0323q.f848a.length && c0323q.f848a[i2].f854b != c3178i.mIndex) {
                            i2++;
                        }
                        if (i2 == c0323q.f848a.length) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Could not find active fragment with index ");
                            stringBuilder2.append(c3178i.mIndex);
                            m9523a(new IllegalStateException(stringBuilder2.toString()));
                        }
                        C0325s c0325s = c0323q.f848a[i2];
                        c0325s.f864l = c3178i;
                        c3178i.mSavedViewState = null;
                        c3178i.mBackStackNesting = 0;
                        c3178i.mInLayout = false;
                        c3178i.mAdded = false;
                        c3178i.mTarget = null;
                        if (c0325s.f863k != null) {
                            c0325s.f863k.setClassLoader(this.f8210m.m9498i().getClassLoader());
                            c3178i.mSavedViewState = c0325s.f863k.getSparseParcelableArray("android:view_state");
                            c3178i.mSavedFragmentState = c0325s.f863k;
                        }
                    }
                } else {
                    b = null;
                    c = b;
                }
                this.f8203f = new SparseArray(c0323q.f848a.length);
                int i3 = 0;
                while (i3 < c0323q.f848a.length) {
                    C0325s c0325s2 = c0323q.f848a[i3];
                    if (c0325s2 != null) {
                        C0321p c0321p2 = (b == null || i3 >= b.size()) ? null : (C0321p) b.get(i3);
                        C0088p c0088p = (c == null || i3 >= c.size()) ? null : (C0088p) c.get(i3);
                        C3178i a2 = c0325s2.m953a(this.f8210m, this.f8211n, this.f8212o, c0321p2, c0088p);
                        if (f8191a) {
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("restoreAllState: active #");
                            stringBuilder3.append(i3);
                            stringBuilder3.append(": ");
                            stringBuilder3.append(a2);
                            Log.v("FragmentManager", stringBuilder3.toString());
                        }
                        this.f8203f.put(a2.mIndex, a2);
                        c0325s2.f864l = null;
                    }
                    i3++;
                }
                if (c0321p != null) {
                    c0321p = c0321p.m946a();
                    i3 = c0321p != null ? c0321p.size() : 0;
                    for (int i4 = 0; i4 < i3; i4++) {
                        C3178i c3178i2 = (C3178i) c0321p.get(i4);
                        if (c3178i2.mTargetIndex >= 0) {
                            c3178i2.mTarget = (C3178i) this.f8203f.get(c3178i2.mTargetIndex);
                            if (c3178i2.mTarget == null) {
                                StringBuilder stringBuilder4 = new StringBuilder();
                                stringBuilder4.append("Re-attaching retained fragment ");
                                stringBuilder4.append(c3178i2);
                                stringBuilder4.append(" target no longer exists: ");
                                stringBuilder4.append(c3178i2.mTargetIndex);
                                Log.w("FragmentManager", stringBuilder4.toString());
                            }
                        }
                    }
                }
                this.f8202e.clear();
                if (c0323q.f849b != null) {
                    for (c0321p = null; c0321p < c0323q.f849b.length; c0321p++) {
                        StringBuilder stringBuilder5;
                        C3178i c3178i3 = (C3178i) this.f8203f.get(c0323q.f849b[c0321p]);
                        if (c3178i3 == null) {
                            stringBuilder5 = new StringBuilder();
                            stringBuilder5.append("No instantiated fragment for index #");
                            stringBuilder5.append(c0323q.f849b[c0321p]);
                            m9523a(new IllegalStateException(stringBuilder5.toString()));
                        }
                        c3178i3.mAdded = true;
                        if (f8191a) {
                            stringBuilder5 = new StringBuilder();
                            stringBuilder5.append("restoreAllState: added #");
                            stringBuilder5.append(c0321p);
                            stringBuilder5.append(": ");
                            stringBuilder5.append(c3178i3);
                            Log.v("FragmentManager", stringBuilder5.toString());
                        }
                        if (this.f8202e.contains(c3178i3)) {
                            throw new IllegalStateException("Already added!");
                        }
                        synchronized (this.f8202e) {
                            this.f8202e.add(c3178i3);
                        }
                    }
                }
                if (c0323q.f850c != null) {
                    this.f8204g = new ArrayList(c0323q.f850c.length);
                    for (c0321p = null; c0321p < c0323q.f850c.length; c0321p++) {
                        C3176c a3 = c0323q.f850c[c0321p].m868a(this);
                        if (f8191a) {
                            StringBuilder stringBuilder6 = new StringBuilder();
                            stringBuilder6.append("restoreAllState: back stack #");
                            stringBuilder6.append(c0321p);
                            stringBuilder6.append(" (index ");
                            stringBuilder6.append(a3.f8161m);
                            stringBuilder6.append("): ");
                            stringBuilder6.append(a3);
                            Log.v("FragmentManager", stringBuilder6.toString());
                            PrintWriter printWriter = new PrintWriter(new C0451e("FragmentManager"));
                            a3.m9463a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f8204g.add(a3);
                        if (a3.f8161m >= 0) {
                            m9548a(a3.f8161m, a3);
                        }
                    }
                } else {
                    this.f8204g = null;
                }
                if (c0323q.f851d >= null) {
                    this.f8213p = (C3178i) this.f8203f.get(c0323q.f851d);
                }
                this.f8201d = c0323q.f852e;
            }
        }
    }

    /* renamed from: D */
    private void m9512D() {
        if (this.f8203f != null) {
            for (int size = this.f8203f.size() - 1; size >= 0; size--) {
                if (this.f8203f.valueAt(size) == null) {
                    this.f8203f.delete(this.f8203f.keyAt(size));
                }
            }
        }
    }

    /* renamed from: a */
    public void m9559a(C3179m c3179m, C0305k c0305k, C3178i c3178i) {
        if (this.f8210m == null) {
            this.f8210m = c3179m;
            this.f8211n = c0305k;
            this.f8212o = c3178i;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    /* renamed from: l */
    public void m9607l() {
        this.f8196D = null;
        int i = 0;
        this.f8215s = false;
        this.f8216t = false;
        int size = this.f8202e.size();
        while (i < size) {
            C3178i c3178i = (C3178i) this.f8202e.get(i);
            if (c3178i != null) {
                c3178i.noteStateNotSaved();
            }
            i++;
        }
    }

    /* renamed from: m */
    public void m9609m() {
        this.f8215s = false;
        this.f8216t = false;
        m9538e(1);
    }

    /* renamed from: n */
    public void m9612n() {
        this.f8215s = false;
        this.f8216t = false;
        m9538e(2);
    }

    /* renamed from: o */
    public void m9613o() {
        this.f8215s = false;
        this.f8216t = false;
        m9538e(4);
    }

    /* renamed from: p */
    public void m9615p() {
        this.f8215s = false;
        this.f8216t = false;
        m9538e(5);
    }

    /* renamed from: q */
    public void m9616q() {
        m9538e(4);
    }

    /* renamed from: r */
    public void m9617r() {
        this.f8216t = true;
        m9538e(3);
    }

    /* renamed from: s */
    public void m9618s() {
        m9538e(2);
    }

    /* renamed from: t */
    public void m9619t() {
        m9538e(1);
    }

    /* renamed from: u */
    public void m9620u() {
        this.f8217u = true;
        m9594f();
        m9538e(0);
        this.f8210m = null;
        this.f8211n = null;
        this.f8212o = null;
    }

    /* renamed from: e */
    private void m9538e(int i) {
        try {
            this.f8200c = true;
            m9549a(i, false);
            m9594f();
        } finally {
            this.f8200c = false;
        }
    }

    /* renamed from: a */
    public void m9562a(boolean z) {
        for (int size = this.f8202e.size() - 1; size >= 0; size--) {
            C3178i c3178i = (C3178i) this.f8202e.get(size);
            if (c3178i != null) {
                c3178i.performMultiWindowModeChanged(z);
            }
        }
    }

    /* renamed from: b */
    public void m9577b(boolean z) {
        for (int size = this.f8202e.size() - 1; size >= 0; size--) {
            C3178i c3178i = (C3178i) this.f8202e.get(size);
            if (c3178i != null) {
                c3178i.performPictureInPictureModeChanged(z);
            }
        }
    }

    /* renamed from: a */
    public void m9550a(Configuration configuration) {
        for (int i = 0; i < this.f8202e.size(); i++) {
            C3178i c3178i = (C3178i) this.f8202e.get(i);
            if (c3178i != null) {
                c3178i.performConfigurationChanged(configuration);
            }
        }
    }

    /* renamed from: v */
    public void m9621v() {
        for (int i = 0; i < this.f8202e.size(); i++) {
            C3178i c3178i = (C3178i) this.f8202e.get(i);
            if (c3178i != null) {
                c3178i.performLowMemory();
            }
        }
    }

    /* renamed from: a */
    public boolean m9565a(Menu menu, MenuInflater menuInflater) {
        int i = 0;
        if (this.f8209l < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (int i2 = 0; i2 < this.f8202e.size(); i2++) {
            C3178i c3178i = (C3178i) this.f8202e.get(i2);
            if (c3178i != null && c3178i.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(c3178i);
                z = true;
            }
        }
        if (this.f8205h != null) {
            while (i < this.f8205h.size()) {
                C3178i c3178i2 = (C3178i) this.f8205h.get(i);
                if (arrayList == null || arrayList.contains(c3178i2) == null) {
                    c3178i2.onDestroyOptionsMenu();
                }
                i++;
            }
        }
        this.f8205h = arrayList;
        return z;
    }

    /* renamed from: a */
    public boolean m9564a(Menu menu) {
        int i = 0;
        if (this.f8209l < 1) {
            return false;
        }
        boolean z = false;
        while (i < this.f8202e.size()) {
            C3178i c3178i = (C3178i) this.f8202e.get(i);
            if (c3178i != null && c3178i.performPrepareOptionsMenu(menu)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    /* renamed from: a */
    public boolean m9566a(MenuItem menuItem) {
        if (this.f8209l < 1) {
            return false;
        }
        for (int i = 0; i < this.f8202e.size(); i++) {
            C3178i c3178i = (C3178i) this.f8202e.get(i);
            if (c3178i != null && c3178i.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean m9579b(MenuItem menuItem) {
        if (this.f8209l < 1) {
            return false;
        }
        for (int i = 0; i < this.f8202e.size(); i++) {
            C3178i c3178i = (C3178i) this.f8202e.get(i);
            if (c3178i != null && c3178i.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public void m9576b(Menu menu) {
        if (this.f8209l >= 1) {
            for (int i = 0; i < this.f8202e.size(); i++) {
                C3178i c3178i = (C3178i) this.f8202e.get(i);
                if (c3178i != null) {
                    c3178i.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    /* renamed from: o */
    public void m9614o(C3178i c3178i) {
        if (c3178i != null) {
            if (this.f8203f.get(c3178i.mIndex) == c3178i) {
                if (c3178i.mHost != null) {
                    if (c3178i.getFragmentManager() == this) {
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(c3178i);
            stringBuilder.append(" is not an active fragment of FragmentManager ");
            stringBuilder.append(this);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.f8213p = c3178i;
    }

    /* renamed from: w */
    public C3178i m9622w() {
        return this.f8213p;
    }

    /* renamed from: a */
    void m9555a(C3178i c3178i, Context context, boolean z) {
        if (this.f8212o != null) {
            C0309n fragmentManager = this.f8212o.getFragmentManager();
            if (fragmentManager instanceof C3184o) {
                ((C3184o) fragmentManager).m9555a(c3178i, context, true);
            }
        }
        Iterator it = this.f8198J.iterator();
        while (it.hasNext()) {
            C0461j c0461j = (C0461j) it.next();
            if (!z || ((Boolean) c0461j.f1190b).booleanValue()) {
                ((C0307a) c0461j.f1189a).m924a((C0309n) this, c3178i, context);
            }
        }
    }

    /* renamed from: b */
    void m9572b(C3178i c3178i, Context context, boolean z) {
        if (this.f8212o != null) {
            C0309n fragmentManager = this.f8212o.getFragmentManager();
            if (fragmentManager instanceof C3184o) {
                ((C3184o) fragmentManager).m9572b(c3178i, context, true);
            }
        }
        Iterator it = this.f8198J.iterator();
        while (it.hasNext()) {
            C0461j c0461j = (C0461j) it.next();
            if (!z || ((Boolean) c0461j.f1190b).booleanValue()) {
                ((C0307a) c0461j.f1189a).m928b((C0309n) this, c3178i, context);
            }
        }
    }

    /* renamed from: a */
    void m9556a(C3178i c3178i, Bundle bundle, boolean z) {
        if (this.f8212o != null) {
            C0309n fragmentManager = this.f8212o.getFragmentManager();
            if (fragmentManager instanceof C3184o) {
                ((C3184o) fragmentManager).m9556a(c3178i, bundle, true);
            }
        }
        Iterator it = this.f8198J.iterator();
        while (it.hasNext()) {
            C0461j c0461j = (C0461j) it.next();
            if (!z || ((Boolean) c0461j.f1190b).booleanValue()) {
                ((C0307a) c0461j.f1189a).m925a((C0309n) this, c3178i, bundle);
            }
        }
    }

    /* renamed from: b */
    void m9573b(C3178i c3178i, Bundle bundle, boolean z) {
        if (this.f8212o != null) {
            C0309n fragmentManager = this.f8212o.getFragmentManager();
            if (fragmentManager instanceof C3184o) {
                ((C3184o) fragmentManager).m9573b(c3178i, bundle, true);
            }
        }
        Iterator it = this.f8198J.iterator();
        while (it.hasNext()) {
            C0461j c0461j = (C0461j) it.next();
            if (!z || ((Boolean) c0461j.f1190b).booleanValue()) {
                ((C0307a) c0461j.f1189a).m929b((C0309n) this, c3178i, bundle);
            }
        }
    }

    /* renamed from: c */
    void m9583c(C3178i c3178i, Bundle bundle, boolean z) {
        if (this.f8212o != null) {
            C0309n fragmentManager = this.f8212o.getFragmentManager();
            if (fragmentManager instanceof C3184o) {
                ((C3184o) fragmentManager).m9583c(c3178i, bundle, true);
            }
        }
        Iterator it = this.f8198J.iterator();
        while (it.hasNext()) {
            C0461j c0461j = (C0461j) it.next();
            if (!z || ((Boolean) c0461j.f1190b).booleanValue()) {
                ((C0307a) c0461j.f1189a).m931c(this, c3178i, bundle);
            }
        }
    }

    /* renamed from: a */
    void m9557a(C3178i c3178i, View view, Bundle bundle, boolean z) {
        if (this.f8212o != null) {
            C0309n fragmentManager = this.f8212o.getFragmentManager();
            if (fragmentManager instanceof C3184o) {
                ((C3184o) fragmentManager).m9557a(c3178i, view, bundle, true);
            }
        }
        Iterator it = this.f8198J.iterator();
        while (it.hasNext()) {
            C0461j c0461j = (C0461j) it.next();
            if (!z || ((Boolean) c0461j.f1190b).booleanValue()) {
                ((C0307a) c0461j.f1189a).m926a(this, c3178i, view, bundle);
            }
        }
    }

    /* renamed from: b */
    void m9574b(C3178i c3178i, boolean z) {
        if (this.f8212o != null) {
            C0309n fragmentManager = this.f8212o.getFragmentManager();
            if (fragmentManager instanceof C3184o) {
                ((C3184o) fragmentManager).m9574b(c3178i, true);
            }
        }
        Iterator it = this.f8198J.iterator();
        while (it.hasNext()) {
            C0461j c0461j = (C0461j) it.next();
            if (!z || ((Boolean) c0461j.f1190b).booleanValue()) {
                ((C0307a) c0461j.f1189a).m923a(this, c3178i);
            }
        }
    }

    /* renamed from: c */
    void m9584c(C3178i c3178i, boolean z) {
        if (this.f8212o != null) {
            C0309n fragmentManager = this.f8212o.getFragmentManager();
            if (fragmentManager instanceof C3184o) {
                ((C3184o) fragmentManager).m9584c(c3178i, true);
            }
        }
        Iterator it = this.f8198J.iterator();
        while (it.hasNext()) {
            C0461j c0461j = (C0461j) it.next();
            if (!z || ((Boolean) c0461j.f1190b).booleanValue()) {
                ((C0307a) c0461j.f1189a).m927b(this, c3178i);
            }
        }
    }

    /* renamed from: d */
    void m9587d(C3178i c3178i, boolean z) {
        if (this.f8212o != null) {
            C0309n fragmentManager = this.f8212o.getFragmentManager();
            if (fragmentManager instanceof C3184o) {
                ((C3184o) fragmentManager).m9587d(c3178i, true);
            }
        }
        Iterator it = this.f8198J.iterator();
        while (it.hasNext()) {
            C0461j c0461j = (C0461j) it.next();
            if (!z || ((Boolean) c0461j.f1190b).booleanValue()) {
                ((C0307a) c0461j.f1189a).m930c(this, c3178i);
            }
        }
    }

    /* renamed from: e */
    void m9591e(C3178i c3178i, boolean z) {
        if (this.f8212o != null) {
            C0309n fragmentManager = this.f8212o.getFragmentManager();
            if (fragmentManager instanceof C3184o) {
                ((C3184o) fragmentManager).m9591e(c3178i, true);
            }
        }
        Iterator it = this.f8198J.iterator();
        while (it.hasNext()) {
            C0461j c0461j = (C0461j) it.next();
            if (!z || ((Boolean) c0461j.f1190b).booleanValue()) {
                ((C0307a) c0461j.f1189a).m932d(this, c3178i);
            }
        }
    }

    /* renamed from: d */
    void m9586d(C3178i c3178i, Bundle bundle, boolean z) {
        if (this.f8212o != null) {
            C0309n fragmentManager = this.f8212o.getFragmentManager();
            if (fragmentManager instanceof C3184o) {
                ((C3184o) fragmentManager).m9586d(c3178i, bundle, true);
            }
        }
        Iterator it = this.f8198J.iterator();
        while (it.hasNext()) {
            C0461j c0461j = (C0461j) it.next();
            if (!z || ((Boolean) c0461j.f1190b).booleanValue()) {
                ((C0307a) c0461j.f1189a).m933d(this, c3178i, bundle);
            }
        }
    }

    /* renamed from: f */
    void m9593f(C3178i c3178i, boolean z) {
        if (this.f8212o != null) {
            C0309n fragmentManager = this.f8212o.getFragmentManager();
            if (fragmentManager instanceof C3184o) {
                ((C3184o) fragmentManager).m9593f(c3178i, true);
            }
        }
        Iterator it = this.f8198J.iterator();
        while (it.hasNext()) {
            C0461j c0461j = (C0461j) it.next();
            if (!z || ((Boolean) c0461j.f1190b).booleanValue()) {
                ((C0307a) c0461j.f1189a).m934e(this, c3178i);
            }
        }
    }

    /* renamed from: g */
    void m9597g(C3178i c3178i, boolean z) {
        if (this.f8212o != null) {
            C0309n fragmentManager = this.f8212o.getFragmentManager();
            if (fragmentManager instanceof C3184o) {
                ((C3184o) fragmentManager).m9597g(c3178i, true);
            }
        }
        Iterator it = this.f8198J.iterator();
        while (it.hasNext()) {
            C0461j c0461j = (C0461j) it.next();
            if (!z || ((Boolean) c0461j.f1190b).booleanValue()) {
                ((C0307a) c0461j.f1189a).m935f(this, c3178i);
            }
        }
    }

    /* renamed from: h */
    void m9600h(C3178i c3178i, boolean z) {
        if (this.f8212o != null) {
            C0309n fragmentManager = this.f8212o.getFragmentManager();
            if (fragmentManager instanceof C3184o) {
                ((C3184o) fragmentManager).m9600h(c3178i, true);
            }
        }
        Iterator it = this.f8198J.iterator();
        while (it.hasNext()) {
            C0461j c0461j = (C0461j) it.next();
            if (!z || ((Boolean) c0461j.f1190b).booleanValue()) {
                ((C0307a) c0461j.f1189a).m936g(this, c3178i);
            }
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        C3184o c3184o = this;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        String str2 = str;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, C0319f.f844a);
        int i = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str3 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!C3178i.isSupportFragmentClass(c3184o.f8210m.m9498i(), str3)) {
            return null;
        }
        C3178i c3178i;
        if (view != null) {
            i = view.getId();
        }
        if (i == -1 && resourceId == -1) {
            if (string == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(attributeSet.getPositionDescription());
                stringBuilder.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
                stringBuilder.append(str3);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        C3178i b = resourceId != -1 ? m9568b(resourceId) : null;
        if (b == null && string != null) {
            b = mo200a(string);
        }
        if (b == null && i != -1) {
            b = m9568b(i);
        }
        if (f8191a) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("onCreateView: id=0x");
            stringBuilder2.append(Integer.toHexString(resourceId));
            stringBuilder2.append(" fname=");
            stringBuilder2.append(str3);
            stringBuilder2.append(" existing=");
            stringBuilder2.append(b);
            Log.v("FragmentManager", stringBuilder2.toString());
        }
        if (b == null) {
            C3178i a = c3184o.f8211n.mo194a(context2, str3, null);
            a.mFromLayout = true;
            a.mFragmentId = resourceId != 0 ? resourceId : i;
            a.mContainerId = i;
            a.mTag = string;
            a.mInLayout = true;
            a.mFragmentManager = c3184o;
            a.mHost = c3184o.f8210m;
            a.onInflate(c3184o.f8210m.m9498i(), attributeSet2, a.mSavedFragmentState);
            m9558a(a, true);
            c3178i = a;
        } else if (b.mInLayout) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(attributeSet.getPositionDescription());
            stringBuilder.append(": Duplicate id 0x");
            stringBuilder.append(Integer.toHexString(resourceId));
            stringBuilder.append(", tag ");
            stringBuilder.append(string);
            stringBuilder.append(", or parent id 0x");
            stringBuilder.append(Integer.toHexString(i));
            stringBuilder.append(" with another fragment for ");
            stringBuilder.append(str3);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            b.mInLayout = true;
            b.mHost = c3184o.f8210m;
            if (!b.mRetaining) {
                b.onInflate(c3184o.f8210m.m9498i(), attributeSet2, b.mSavedFragmentState);
            }
            c3178i = b;
        }
        if (c3184o.f8209l >= 1 || !c3178i.mFromLayout) {
            m9571b(c3178i);
        } else {
            m9554a(c3178i, 1, 0, 0, false);
        }
        if (c3178i.mView != null) {
            if (resourceId != 0) {
                c3178i.mView.setId(resourceId);
            }
            if (c3178i.mView.getTag() == null) {
                c3178i.mView.setTag(string);
            }
            return c3178i.mView;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Fragment ");
        stringBuilder3.append(str3);
        stringBuilder3.append(" did not create a view.");
        throw new IllegalStateException(stringBuilder3.toString());
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
