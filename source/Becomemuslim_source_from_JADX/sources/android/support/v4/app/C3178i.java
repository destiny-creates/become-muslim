package android.support.v4.app;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.C0074c;
import android.arch.lifecycle.C0074c.C0072a;
import android.arch.lifecycle.C0076e;
import android.arch.lifecycle.C0088p;
import android.arch.lifecycle.C3107f;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.C0450d;
import android.support.v4.util.C0463l;
import android.support.v4.view.C0503f;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Fragment */
/* renamed from: android.support.v4.app.i */
public class C3178i implements C0076e, ComponentCallbacks, OnCreateContextMenuListener {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 5;
    static final int STARTED = 4;
    static final int STOPPED = 3;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    private static final C0463l<String, Class<?>> sClassMap = new C0463l();
    boolean mAdded;
    C0298a mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mCalled;
    C3184o mChildFragmentManager;
    C0321p mChildNonConfig;
    ViewGroup mContainer;
    int mContainerId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    C3184o mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    C3179m mHost;
    boolean mInLayout;
    int mIndex = -1;
    View mInnerView;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    LayoutInflater mLayoutInflater;
    C3107f mLifecycleRegistry = new C3107f(this);
    LoaderManagerImpl mLoaderManager;
    boolean mMenuVisible = true;
    C3178i mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetaining;
    Bundle mSavedFragmentState;
    Boolean mSavedUserVisibleHint;
    SparseArray<Parcelable> mSavedViewState;
    int mState = 0;
    String mTag;
    C3178i mTarget;
    int mTargetIndex = -1;
    int mTargetRequestCode;
    boolean mUserVisibleHint = true;
    View mView;
    C0088p mViewModelStore;
    String mWho;

    /* compiled from: Fragment */
    /* renamed from: android.support.v4.app.i$1 */
    class C02971 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3178i f799a;

        C02971(C3178i c3178i) {
            this.f799a = c3178i;
        }

        public void run() {
            this.f799a.callStartTransitionListener();
        }
    }

    /* compiled from: Fragment */
    /* renamed from: android.support.v4.app.i$a */
    static class C0298a {
        /* renamed from: a */
        View f800a;
        /* renamed from: b */
        Animator f801b;
        /* renamed from: c */
        int f802c;
        /* renamed from: d */
        int f803d;
        /* renamed from: e */
        int f804e;
        /* renamed from: f */
        int f805f;
        /* renamed from: g */
        ai f806g = null;
        /* renamed from: h */
        ai f807h = null;
        /* renamed from: i */
        boolean f808i;
        /* renamed from: j */
        C0300c f809j;
        /* renamed from: k */
        boolean f810k;
        /* renamed from: l */
        private Object f811l = null;
        /* renamed from: m */
        private Object f812m = C3178i.USE_DEFAULT_TRANSITION;
        /* renamed from: n */
        private Object f813n = null;
        /* renamed from: o */
        private Object f814o = C3178i.USE_DEFAULT_TRANSITION;
        /* renamed from: p */
        private Object f815p = null;
        /* renamed from: q */
        private Object f816q = C3178i.USE_DEFAULT_TRANSITION;
        /* renamed from: r */
        private Boolean f817r;
        /* renamed from: s */
        private Boolean f818s;

        C0298a() {
        }
    }

    /* compiled from: Fragment */
    /* renamed from: android.support.v4.app.i$b */
    public static class C0299b extends RuntimeException {
        public C0299b(String str, Exception exception) {
            super(str, exception);
        }
    }

    /* compiled from: Fragment */
    /* renamed from: android.support.v4.app.i$c */
    interface C0300c {
        /* renamed from: a */
        void mo198a();

        /* renamed from: b */
        void mo199b();
    }

    /* compiled from: Fragment */
    /* renamed from: android.support.v4.app.i$d */
    public static class C0302d implements Parcelable {
        public static final Creator<C0302d> CREATOR = new C03011();
        /* renamed from: a */
        final Bundle f819a;

        /* compiled from: Fragment */
        /* renamed from: android.support.v4.app.i$d$1 */
        static class C03011 implements Creator<C0302d> {
            C03011() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m891a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m892a(i);
            }

            /* renamed from: a */
            public C0302d m891a(Parcel parcel) {
                return new C0302d(parcel, null);
            }

            /* renamed from: a */
            public C0302d[] m892a(int i) {
                return new C0302d[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        C0302d(Parcel parcel, ClassLoader classLoader) {
            this.f819a = parcel.readBundle();
            if (classLoader != null && this.f819a != null) {
                this.f819a.setClassLoader(classLoader);
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f819a);
        }
    }

    /* compiled from: Fragment */
    /* renamed from: android.support.v4.app.i$2 */
    class C31772 extends C0305k {
        /* renamed from: a */
        final /* synthetic */ C3178i f8170a;

        C31772(C3178i c3178i) {
            this.f8170a = c3178i;
        }

        /* renamed from: a */
        public View mo195a(int i) {
            if (this.f8170a.mView != null) {
                return this.f8170a.mView.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        /* renamed from: a */
        public boolean mo196a() {
            return this.f8170a.mView != null;
        }

        /* renamed from: a */
        public C3178i mo194a(Context context, String str, Bundle bundle) {
            return this.f8170a.mHost.mo194a(context, str, bundle);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onAttachFragment(C3178i c3178i) {
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public C0074c getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public C0088p getViewModelStore() {
        if (getContext() != null) {
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new C0088p();
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public static C3178i instantiate(Context context, String str) {
        return C3178i.instantiate(context, str, null);
    }

    public static C3178i instantiate(Context context, String str, Bundle bundle) {
        StringBuilder stringBuilder;
        try {
            Class cls = (Class) sClassMap.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                sClassMap.put(str, cls);
            }
            C3178i c3178i = (C3178i) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(c3178i.getClass().getClassLoader());
                c3178i.setArguments(bundle);
            }
            return c3178i;
        } catch (Context context2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to instantiate fragment ");
            stringBuilder.append(str);
            stringBuilder.append(": make sure class name exists, is public, and has an");
            stringBuilder.append(" empty constructor that is public");
            throw new C0299b(stringBuilder.toString(), context2);
        } catch (Context context22) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to instantiate fragment ");
            stringBuilder.append(str);
            stringBuilder.append(": make sure class name exists, is public, and has an");
            stringBuilder.append(" empty constructor that is public");
            throw new C0299b(stringBuilder.toString(), context22);
        } catch (Context context222) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to instantiate fragment ");
            stringBuilder.append(str);
            stringBuilder.append(": make sure class name exists, is public, and has an");
            stringBuilder.append(" empty constructor that is public");
            throw new C0299b(stringBuilder.toString(), context222);
        } catch (Context context2222) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to instantiate fragment ");
            stringBuilder.append(str);
            stringBuilder.append(": could not find Fragment constructor");
            throw new C0299b(stringBuilder.toString(), context2222);
        } catch (Context context22222) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to instantiate fragment ");
            stringBuilder.append(str);
            stringBuilder.append(": calling Fragment constructor caused an exception");
            throw new C0299b(stringBuilder.toString(), context22222);
        }
    }

    static boolean isSupportFragmentClass(android.content.Context r1, java.lang.String r2) {
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
        r0 = sClassMap;	 Catch:{ ClassNotFoundException -> 0x001e }
        r0 = r0.get(r2);	 Catch:{ ClassNotFoundException -> 0x001e }
        r0 = (java.lang.Class) r0;	 Catch:{ ClassNotFoundException -> 0x001e }
        if (r0 != 0) goto L_0x0017;	 Catch:{ ClassNotFoundException -> 0x001e }
    L_0x000a:
        r1 = r1.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x001e }
        r0 = r1.loadClass(r2);	 Catch:{ ClassNotFoundException -> 0x001e }
        r1 = sClassMap;	 Catch:{ ClassNotFoundException -> 0x001e }
        r1.put(r2, r0);	 Catch:{ ClassNotFoundException -> 0x001e }
    L_0x0017:
        r1 = android.support.v4.app.C3178i.class;	 Catch:{ ClassNotFoundException -> 0x001e }
        r1 = r1.isAssignableFrom(r0);	 Catch:{ ClassNotFoundException -> 0x001e }
        return r1;
    L_0x001e:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.i.isSupportFragmentClass(android.content.Context, java.lang.String):boolean");
    }

    final void restoreViewState(Bundle bundle) {
        if (this.mSavedViewState != null) {
            this.mInnerView.restoreHierarchyState(this.mSavedViewState);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (this.mCalled == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onViewStateRestored()");
            throw new aj(stringBuilder.toString());
        }
    }

    final void setIndex(int i, C3178i c3178i) {
        this.mIndex = i;
        if (c3178i != null) {
            i = new StringBuilder();
            i.append(c3178i.mWho);
            i.append(":");
            i.append(this.mIndex);
            this.mWho = i.toString();
            return;
        }
        i = new StringBuilder();
        i.append("android:fragment:");
        i.append(this.mIndex);
        this.mWho = i.toString();
    }

    final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        C0450d.m1408a(this, stringBuilder);
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.mFragmentId != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.mTag);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final String getTag() {
        return this.mTag;
    }

    public void setArguments(Bundle bundle) {
        if (this.mIndex >= 0) {
            if (isStateSaved()) {
                throw new IllegalStateException("Fragment already active and state has been saved");
            }
        }
        this.mArguments = bundle;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final boolean isStateSaved() {
        if (this.mFragmentManager == null) {
            return false;
        }
        return this.mFragmentManager.mo206d();
    }

    public void setInitialSavedState(C0302d c0302d) {
        if (this.mIndex < 0) {
            c0302d = (c0302d == null || c0302d.f819a == null) ? null : c0302d.f819a;
            this.mSavedFragmentState = c0302d;
            return;
        }
        throw new IllegalStateException("Fragment already active");
    }

    public void setTargetFragment(C3178i c3178i, int i) {
        C0309n fragmentManager = getFragmentManager();
        C0309n fragmentManager2 = c3178i != null ? c3178i.getFragmentManager() : null;
        if (!(fragmentManager == null || fragmentManager2 == null)) {
            if (fragmentManager != fragmentManager2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Fragment ");
                stringBuilder.append(c3178i);
                stringBuilder.append(" must share the same FragmentManager to be set as a target fragment");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        C3178i c3178i2 = c3178i;
        while (c3178i2 != null) {
            if (c3178i2 != this) {
                c3178i2 = c3178i2.getTargetFragment();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Setting ");
                stringBuilder.append(c3178i);
                stringBuilder.append(" as the target of ");
                stringBuilder.append(this);
                stringBuilder.append(" would create a target cycle");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        this.mTarget = c3178i;
        this.mTargetRequestCode = i;
    }

    public final C3178i getTargetFragment() {
        return this.mTarget;
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public Context getContext() {
        return this.mHost == null ? null : this.mHost.m9498i();
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" not attached to a context.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final C4890j getActivity() {
        return this.mHost == null ? null : (C4890j) this.mHost.m9497h();
    }

    public final C4890j requireActivity() {
        C4890j activity = getActivity();
        if (activity != null) {
            return activity;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" not attached to an activity.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final Object getHost() {
        return this.mHost == null ? null : this.mHost.mo2680g();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" not attached to a host.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final C0309n getFragmentManager() {
        return this.mFragmentManager;
    }

    public final C0309n requireFragmentManager() {
        C0309n fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            return fragmentManager;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" not associated with a fragment manager.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final C0309n getChildFragmentManager() {
        if (this.mChildFragmentManager == null) {
            instantiateChildFragmentManager();
            if (this.mState >= 5) {
                this.mChildFragmentManager.m9615p();
            } else if (this.mState >= 4) {
                this.mChildFragmentManager.m9613o();
            } else if (this.mState >= 2) {
                this.mChildFragmentManager.m9612n();
            } else if (this.mState >= 1) {
                this.mChildFragmentManager.m9609m();
            }
        }
        return this.mChildFragmentManager;
    }

    C0309n peekChildFragmentManager() {
        return this.mChildFragmentManager;
    }

    public final C3178i getParentFragment() {
        return this.mParentFragment;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isResumed() {
        return this.mState >= 5;
    }

    public final boolean isVisible() {
        return (!isAdded() || isHidden() || this.mView == null || this.mView.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (isAdded() && !isHidden()) {
                this.mHost.mo2677d();
            }
        }
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.mo2677d();
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 4 && this.mFragmentManager != null && isAdded()) {
            this.mFragmentManager.m9553a(this);
        }
        this.mUserVisibleHint = z;
        z = this.mState < 4 && !z;
        this.mDeferStart = z;
        if (this.mSavedFragmentState) {
            this.mSavedUserVisibleHint = Boolean.valueOf(this.mUserVisibleHint);
        }
    }

    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public C0344z getLoaderManager() {
        if (this.mLoaderManager != null) {
            return this.mLoaderManager;
        }
        this.mLoaderManager = new LoaderManagerImpl(this, getViewModelStore());
        return this.mLoaderManager;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        if (this.mHost != null) {
            this.mHost.mo2669a(this, intent, -1, bundle);
            return;
        }
        bundle = new StringBuilder();
        bundle.append("Fragment ");
        bundle.append(this);
        bundle.append(" not attached to Activity");
        throw new IllegalStateException(bundle.toString());
    }

    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (this.mHost != null) {
            this.mHost.mo2669a(this, intent, i, bundle);
            return;
        }
        i = new StringBuilder();
        i.append("Fragment ");
        i.append(this);
        i.append(" not attached to Activity");
        throw new IllegalStateException(i.toString());
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (this.mHost != null) {
            r9.mHost.mo2670a(this, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" not attached to Activity");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final void requestPermissions(String[] strArr, int i) {
        if (this.mHost != null) {
            this.mHost.mo2671a(this, strArr, i);
            return;
        }
        i = new StringBuilder();
        i.append("Fragment ");
        i.append(this);
        i.append(" not attached to Activity");
        throw new IllegalStateException(i.toString());
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        return this.mHost != null ? this.mHost.mo2674a(str) : null;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public final LayoutInflater getLayoutInflater() {
        if (this.mLayoutInflater == null) {
            return performGetLayoutInflater(null);
        }
        return this.mLayoutInflater;
    }

    LayoutInflater performGetLayoutInflater(Bundle bundle) {
        this.mLayoutInflater = onGetLayoutInflater(bundle);
        return this.mLayoutInflater;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        if (this.mHost != null) {
            bundle = this.mHost.mo2675b();
            getChildFragmentManager();
            C0503f.m1591b(bundle, this.mChildFragmentManager.m9623x());
            return bundle;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        Activity h = this.mHost == null ? null : this.mHost.m9497h();
        if (h != null) {
            this.mCalled = false;
            onInflate(h, attributeSet, bundle);
        }
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        Activity h = this.mHost == null ? null : this.mHost.m9497h();
        if (h != null) {
            this.mCalled = false;
            onAttach(h);
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager != null && this.mChildFragmentManager.m9563a(1) == null) {
            this.mChildFragmentManager.m9609m();
        }
    }

    void restoreChildFragmentState(Bundle bundle) {
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.mChildFragmentManager == null) {
                    instantiateChildFragmentManager();
                }
                this.mChildFragmentManager.m9552a(parcelable, this.mChildNonConfig);
                this.mChildNonConfig = null;
                this.mChildFragmentManager.m9609m();
            }
        }
    }

    public View getView() {
        return this.mView;
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDestroy() {
        this.mCalled = true;
        if (this.mViewModelStore != null && !this.mHost.f8174d.f8215s) {
            this.mViewModelStore.m205a();
        }
    }

    void initState() {
        this.mIndex = -1;
        this.mWho = null;
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = null;
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
        this.mRetaining = false;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        getActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public void setEnterSharedElementCallback(ai aiVar) {
        ensureAnimationInfo().f806g = aiVar;
    }

    public void setExitSharedElementCallback(ai aiVar) {
        ensureAnimationInfo().f807h = aiVar;
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().f811l = obj;
    }

    public Object getEnterTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.f811l;
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().f812m = obj;
    }

    public Object getReturnTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        Object enterTransition;
        if (this.mAnimationInfo.f812m == USE_DEFAULT_TRANSITION) {
            enterTransition = getEnterTransition();
        } else {
            enterTransition = this.mAnimationInfo.f812m;
        }
        return enterTransition;
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().f813n = obj;
    }

    public Object getExitTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.f813n;
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().f814o = obj;
    }

    public Object getReenterTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        Object exitTransition;
        if (this.mAnimationInfo.f814o == USE_DEFAULT_TRANSITION) {
            exitTransition = getExitTransition();
        } else {
            exitTransition = this.mAnimationInfo.f814o;
        }
        return exitTransition;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().f815p = obj;
    }

    public Object getSharedElementEnterTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.f815p;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().f816q = obj;
    }

    public Object getSharedElementReturnTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        Object sharedElementEnterTransition;
        if (this.mAnimationInfo.f816q == USE_DEFAULT_TRANSITION) {
            sharedElementEnterTransition = getSharedElementEnterTransition();
        } else {
            sharedElementEnterTransition = this.mAnimationInfo.f816q;
        }
        return sharedElementEnterTransition;
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().f818s = Boolean.valueOf(z);
    }

    public boolean getAllowEnterTransitionOverlap() {
        if (this.mAnimationInfo != null) {
            if (this.mAnimationInfo.f818s != null) {
                return this.mAnimationInfo.f818s.booleanValue();
            }
        }
        return true;
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().f817r = Boolean.valueOf(z);
    }

    public boolean getAllowReturnTransitionOverlap() {
        if (this.mAnimationInfo != null) {
            if (this.mAnimationInfo.f817r != null) {
                return this.mAnimationInfo.f817r.booleanValue();
            }
        }
        return true;
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().f808i = true;
    }

    public void startPostponedEnterTransition() {
        if (this.mFragmentManager != null) {
            if (this.mFragmentManager.f8210m != null) {
                if (Looper.myLooper() != this.mFragmentManager.f8210m.m9499j().getLooper()) {
                    this.mFragmentManager.f8210m.m9499j().postAtFrontOfQueue(new C02971(this));
                    return;
                } else {
                    callStartTransitionListener();
                    return;
                }
            }
        }
        ensureAnimationInfo().f808i = false;
    }

    private void callStartTransitionListener() {
        C0300c c0300c;
        if (this.mAnimationInfo == null) {
            c0300c = null;
        } else {
            this.mAnimationInfo.f808i = false;
            c0300c = this.mAnimationInfo.f809j;
            this.mAnimationInfo.f809j = null;
        }
        if (c0300c != null) {
            c0300c.mo198a();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mIndex=");
        printWriter.print(this.mIndex);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mRetaining=");
        printWriter.print(this.mRetaining);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mTarget != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.mTarget);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (getNextAnim() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(getNextAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(getStateAfterAnimating());
        }
        if (this.mLoaderManager != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            LoaderManagerImpl loaderManagerImpl = this.mLoaderManager;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("  ");
            loaderManagerImpl.mo176a(stringBuilder.toString(), fileDescriptor, printWriter, strArr);
        }
        if (this.mChildFragmentManager != null) {
            printWriter.print(str);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Child ");
            stringBuilder2.append(this.mChildFragmentManager);
            stringBuilder2.append(":");
            printWriter.println(stringBuilder2.toString());
            C3184o c3184o = this.mChildFragmentManager;
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("  ");
            c3184o.mo203a(stringBuilder.toString(), fileDescriptor, printWriter, strArr);
        }
    }

    C3178i findFragmentByWho(String str) {
        if (str.equals(this.mWho)) {
            return this;
        }
        return this.mChildFragmentManager != null ? this.mChildFragmentManager.m9569b(str) : null;
    }

    void instantiateChildFragmentManager() {
        if (this.mHost != null) {
            this.mChildFragmentManager = new C3184o();
            this.mChildFragmentManager.m9559a(this.mHost, new C31772(this), this);
            return;
        }
        throw new IllegalStateException("Fragment has not been attached yet.");
    }

    void performCreate(Bundle bundle) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9607l();
        }
        this.mState = 1;
        this.mCalled = false;
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled != null) {
            this.mLifecycleRegistry.m9133a(C0072a.ON_CREATE);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onCreate()");
        throw new aj(stringBuilder.toString());
    }

    View performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9607l();
        }
        this.mPerformedCreateView = true;
        return onCreateView(layoutInflater, viewGroup, bundle);
    }

    void performActivityCreated(Bundle bundle) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9607l();
        }
        this.mState = 2;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onActivityCreated()");
            throw new aj(stringBuilder.toString());
        } else if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9612n();
        }
    }

    void performStart() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9607l();
            this.mChildFragmentManager.m9594f();
        }
        this.mState = 4;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.m9613o();
            }
            this.mLifecycleRegistry.m9133a(C0072a.ON_START);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onStart()");
        throw new aj(stringBuilder.toString());
    }

    void performResume() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9607l();
            this.mChildFragmentManager.m9594f();
        }
        this.mState = 5;
        this.mCalled = false;
        onResume();
        if (this.mCalled) {
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.m9615p();
                this.mChildFragmentManager.m9594f();
            }
            this.mLifecycleRegistry.m9133a(C0072a.ON_RESUME);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onResume()");
        throw new aj(stringBuilder.toString());
    }

    void noteStateNotSaved() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9607l();
        }
    }

    void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9562a(z);
        }
    }

    void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9577b(z);
        }
    }

    void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9550a(configuration);
        }
    }

    void performLowMemory() {
        onLowMemory();
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9621v();
        }
    }

    boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return this.mChildFragmentManager != null ? z | this.mChildFragmentManager.m9565a(menu, menuInflater) : z;
    }

    boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return this.mChildFragmentManager != null ? z | this.mChildFragmentManager.m9564a(menu) : z;
    }

    boolean performOptionsItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
                return true;
            }
            if (!(this.mChildFragmentManager == null || this.mChildFragmentManager.m9566a(menuItem) == null)) {
                return true;
            }
        }
        return null;
    }

    boolean performContextItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (onContextItemSelected(menuItem)) {
                return true;
            }
            if (!(this.mChildFragmentManager == null || this.mChildFragmentManager.m9579b(menuItem) == null)) {
                return true;
            }
        }
        return null;
    }

    void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.m9576b(menu);
            }
        }
    }

    void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        if (this.mChildFragmentManager != null) {
            Parcelable k = this.mChildFragmentManager.m9605k();
            if (k != null) {
                bundle.putParcelable("android:support:fragments", k);
            }
        }
    }

    void performPause() {
        this.mLifecycleRegistry.m9133a(C0072a.ON_PAUSE);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9616q();
        }
        this.mState = 4;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onPause()");
            throw new aj(stringBuilder.toString());
        }
    }

    void performStop() {
        this.mLifecycleRegistry.m9133a(C0072a.ON_STOP);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9617r();
        }
        this.mState = 3;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onStop()");
            throw new aj(stringBuilder.toString());
        }
    }

    void performReallyStop() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9618s();
        }
        this.mState = 2;
    }

    void performDestroyView() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9619t();
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            if (this.mLoaderManager != null) {
                this.mLoaderManager.m9421a();
            }
            this.mPerformedCreateView = false;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onDestroyView()");
        throw new aj(stringBuilder.toString());
    }

    void performDestroy() {
        this.mLifecycleRegistry.m9133a(C0072a.ON_DESTROY);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m9620u();
        }
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            this.mChildFragmentManager = null;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onDestroy()");
        throw new aj(stringBuilder.toString());
    }

    void performDetach() {
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        StringBuilder stringBuilder;
        if (!this.mCalled) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onDetach()");
            throw new aj(stringBuilder.toString());
        } else if (this.mChildFragmentManager == null) {
        } else {
            if (this.mRetaining) {
                this.mChildFragmentManager.m9620u();
                this.mChildFragmentManager = null;
                return;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Child FragmentManager of ");
            stringBuilder.append(this);
            stringBuilder.append(" was not ");
            stringBuilder.append(" destroyed and this fragment is not retaining instance");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    void setOnStartEnterTransitionListener(C0300c c0300c) {
        ensureAnimationInfo();
        if (c0300c != this.mAnimationInfo.f809j) {
            if (c0300c != null) {
                if (this.mAnimationInfo.f809j != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Trying to set a replacement startPostponedEnterTransition on ");
                    stringBuilder.append(this);
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            if (this.mAnimationInfo.f808i) {
                this.mAnimationInfo.f809j = c0300c;
            }
            if (c0300c != null) {
                c0300c.mo199b();
            }
        }
    }

    private C0298a ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new C0298a();
        }
        return this.mAnimationInfo;
    }

    int getNextAnim() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.f803d;
    }

    void setNextAnim(int i) {
        if (this.mAnimationInfo != null || i != 0) {
            ensureAnimationInfo().f803d = i;
        }
    }

    int getNextTransition() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.f804e;
    }

    void setNextTransition(int i, int i2) {
        if (this.mAnimationInfo != null || i != 0 || i2 != 0) {
            ensureAnimationInfo();
            this.mAnimationInfo.f804e = i;
            this.mAnimationInfo.f805f = i2;
        }
    }

    int getNextTransitionStyle() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.f805f;
    }

    ai getEnterTransitionCallback() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.f806g;
    }

    ai getExitTransitionCallback() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.f807h;
    }

    View getAnimatingAway() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.f800a;
    }

    void setAnimatingAway(View view) {
        ensureAnimationInfo().f800a = view;
    }

    void setAnimator(Animator animator) {
        ensureAnimationInfo().f801b = animator;
    }

    Animator getAnimator() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.f801b;
    }

    int getStateAfterAnimating() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.f802c;
    }

    void setStateAfterAnimating(int i) {
        ensureAnimationInfo().f802c = i;
    }

    boolean isPostponed() {
        if (this.mAnimationInfo == null) {
            return false;
        }
        return this.mAnimationInfo.f808i;
    }

    boolean isHideReplaced() {
        if (this.mAnimationInfo == null) {
            return false;
        }
        return this.mAnimationInfo.f810k;
    }

    void setHideReplaced(boolean z) {
        ensureAnimationInfo().f810k = z;
    }
}
