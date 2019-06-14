package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.C0074c;
import android.arch.lifecycle.C0074c.C0073b;
import android.arch.lifecycle.C0088p;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.C3169a.C0273a;
import android.support.v4.app.C3169a.C0274b;
import android.support.v4.app.C3169a.C0275c;
import android.support.v4.util.C0464m;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import com.facebook.soloader.MinElf;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentActivity */
/* renamed from: android.support.v4.app.j */
public class C4890j extends C4826f implements C0273a, C0275c {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final C0306l mFragments = C0306l.m896a(new C4458a(this));
    final Handler mHandler = new C03031(this);
    C0344z mLoaderManager;
    int mNextCandidateRequestIndex;
    C0464m<String> mPendingFragmentActivityResults;
    boolean mReallyStopped = true;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped = true;
    private C0088p mViewModelStore;

    /* compiled from: FragmentActivity */
    /* renamed from: android.support.v4.app.j$1 */
    class C03031 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C4890j f820a;

        C03031(C4890j c4890j) {
            this.f820a = c4890j;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.f820a.mStopped != null) {
                        this.f820a.doReallyStop(false);
                        return;
                    }
                    return;
                case 2:
                    this.f820a.onResumeFragments();
                    this.f820a.mFragments.m922n();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* compiled from: FragmentActivity */
    /* renamed from: android.support.v4.app.j$b */
    static final class C0304b {
        /* renamed from: a */
        Object f821a;
        /* renamed from: b */
        C0088p f822b;
        /* renamed from: c */
        C0321p f823c;

        C0304b() {
        }
    }

    /* compiled from: FragmentActivity */
    /* renamed from: android.support.v4.app.j$a */
    class C4458a extends C3179m<C4890j> {
        /* renamed from: a */
        final /* synthetic */ C4890j f11909a;

        /* renamed from: g */
        public /* synthetic */ Object mo2680g() {
            return m14895c();
        }

        public C4458a(C4890j c4890j) {
            this.f11909a = c4890j;
            super(c4890j);
        }

        /* renamed from: a */
        public void mo2672a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            this.f11909a.dump(str, fileDescriptor, printWriter, strArr);
        }

        /* renamed from: a */
        public boolean mo2673a(C3178i c3178i) {
            return this.f11909a.isFinishing() ^ 1;
        }

        /* renamed from: b */
        public LayoutInflater mo2675b() {
            return this.f11909a.getLayoutInflater().cloneInContext(this.f11909a);
        }

        /* renamed from: c */
        public C4890j m14895c() {
            return this.f11909a;
        }

        /* renamed from: d */
        public void mo2677d() {
            this.f11909a.supportInvalidateOptionsMenu();
        }

        /* renamed from: a */
        public void mo2669a(C3178i c3178i, Intent intent, int i, Bundle bundle) {
            this.f11909a.startActivityFromFragment(c3178i, intent, i, bundle);
        }

        /* renamed from: a */
        public void mo2670a(C3178i c3178i, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
            this.f11909a.startIntentSenderFromFragment(c3178i, intentSender, i, intent, i2, i3, i4, bundle);
        }

        /* renamed from: a */
        public void mo2671a(C3178i c3178i, String[] strArr, int i) {
            this.f11909a.requestPermissionsFromFragment(c3178i, strArr, i);
        }

        /* renamed from: a */
        public boolean mo2674a(String str) {
            return C3169a.m9430a(this.f11909a, str);
        }

        /* renamed from: e */
        public boolean mo2678e() {
            return this.f11909a.getWindow() != null;
        }

        /* renamed from: f */
        public int mo2679f() {
            Window window = this.f11909a.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        /* renamed from: b */
        public void mo2676b(C3178i c3178i) {
            this.f11909a.onAttachFragment(c3178i);
        }

        /* renamed from: a */
        public View mo195a(int i) {
            return this.f11909a.findViewById(i);
        }

        /* renamed from: a */
        public boolean mo196a() {
            Window window = this.f11909a.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    public void onAttachFragment(C3178i c3178i) {
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.m907b();
        int i3 = i >> 16;
        if (i3 != 0) {
            i3--;
            String str = (String) this.mPendingFragmentActivityResults.m1467a(i3);
            this.mPendingFragmentActivityResults.m1473c(i3);
            if (str == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            C3178i a = this.mFragments.m897a(str);
            if (a == null) {
                i = TAG;
                i2 = new StringBuilder();
                i2.append("Activity result no fragment exists for who: ");
                i2.append(str);
                Log.w(i, i2.toString());
            } else {
                a.onActivityResult(i & MinElf.PN_XNUM, i2, intent);
            }
            return;
        }
        C0274b a2 = C3169a.m9424a();
        if (a2 == null || !a2.m751a(this, i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        C0309n a = this.mFragments.m898a();
        boolean d = a.mo206d();
        if (!d || VERSION.SDK_INT > 25) {
            if (d || !a.mo204b()) {
                super.onBackPressed();
            }
        }
    }

    public void supportFinishAfterTransition() {
        C3169a.m9431b(this);
    }

    public void setEnterSharedElementCallback(ai aiVar) {
        C3169a.m9428a((Activity) this, aiVar);
    }

    public void setExitSharedElementCallback(ai aiVar) {
        C3169a.m9432b(this, aiVar);
    }

    public void supportPostponeEnterTransition() {
        C3169a.m9433c(this);
    }

    public void supportStartPostponedEnterTransition() {
        C3169a.m9434d(this);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.m903a(z);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.m909b(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.m907b();
        this.mFragments.m900a(configuration);
    }

    public C0088p getViewModelStore() {
        if (getApplication() != null) {
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new C0088p();
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public C0074c getLifecycle() {
        return super.getLifecycle();
    }

    protected void onCreate(Bundle bundle) {
        C0321p c0321p = null;
        this.mFragments.m902a(null);
        super.onCreate(bundle);
        C0304b c0304b = (C0304b) getLastNonConfigurationInstance();
        if (c0304b != null) {
            this.mViewModelStore = c0304b.f822b;
        }
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable(FRAGMENTS_TAG);
            C0306l c0306l = this.mFragments;
            if (c0304b != null) {
                c0321p = c0304b.f823c;
            }
            c0306l.m901a(parcelable, c0321p);
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                bundle = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (!(intArray == null || bundle == null)) {
                    if (intArray.length == bundle.length) {
                        this.mPendingFragmentActivityResults = new C0464m(intArray.length);
                        for (int i = 0; i < intArray.length; i++) {
                            this.mPendingFragmentActivityResults.m1471b(intArray[i], bundle[i]);
                        }
                    }
                }
                Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new C0464m();
            this.mNextCandidateRequestIndex = 0;
        }
        this.mFragments.m913e();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            return super.onCreatePanelMenu(i, menu) | this.mFragments.m905a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i, menu);
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.m899a(view, str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        if (!(this.mViewModelStore == null || this.mRetaining)) {
            this.mViewModelStore.m205a();
        }
        this.mFragments.m920l();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.m921m();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mFragments.m906a(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.mFragments.m910b(menuItem);
    }

    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.mFragments.m908b(menu);
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.m917i();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.m907b();
    }

    public void onStateNotSaved() {
        this.mFragments.m907b();
    }

    protected void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.m922n();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.m922n();
    }

    protected void onResumeFragments() {
        this.mFragments.m916h();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        return onPrepareOptionsPanel(view, menu) | this.mFragments.m904a(menu);
    }

    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.mStopped) {
            doReallyStop(true);
        }
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        C0321p d = this.mFragments.m912d();
        if (d == null && this.mViewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        C0304b c0304b = new C0304b();
        c0304b.f821a = onRetainCustomNonConfigurationInstance;
        c0304b.f822b = this.mViewModelStore;
        c0304b.f823c = d;
        return c0304b;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        markFragmentsCreated();
        Parcelable c = this.mFragments.m911c();
        if (c != null) {
            bundle.putParcelable(FRAGMENTS_TAG, c);
        }
        if (this.mPendingFragmentActivityResults.m1469b() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.m1469b()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.m1469b()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.m1469b(); i++) {
                iArr[i] = this.mPendingFragmentActivityResults.m1475d(i);
                strArr[i] = (String) this.mPendingFragmentActivityResults.m1476e(i);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    protected void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.m914f();
        }
        this.mFragments.m907b();
        this.mFragments.m922n();
        this.mFragments.m915g();
    }

    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.m918j();
    }

    public Object getLastCustomNonConfigurationInstance() {
        C0304b c0304b = (C0304b) getLastNonConfigurationInstance();
        return c0304b != null ? c0304b.f821a : null;
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("  ");
        String stringBuilder2 = stringBuilder.toString();
        printWriter.print(stringBuilder2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print("mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.mReallyStopped);
        if (this.mLoaderManager != null) {
            this.mLoaderManager.mo176a(stringBuilder2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.m898a().mo203a(str, fileDescriptor, printWriter, strArr);
    }

    void doReallyStop(boolean z) {
        if (!this.mReallyStopped) {
            this.mReallyStopped = true;
            this.mRetaining = z;
            this.mHandler.removeMessages(1);
            onReallyStop();
        }
    }

    void onReallyStop() {
        this.mFragments.m919k();
    }

    public C0309n getSupportFragmentManager() {
        return this.mFragments.m898a();
    }

    public C0344z getSupportLoaderManager() {
        if (this.mLoaderManager != null) {
            return this.mLoaderManager;
        }
        this.mLoaderManager = new LoaderManagerImpl(this, getViewModelStore());
        return this.mLoaderManager;
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!(this.mStartedActivityFromFragment || i == -1)) {
            C4456e.checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i);
    }

    public final void validateRequestPermissionsRequestCode(int i) {
        if (!this.mRequestedPermissionsFromFragment && i != -1) {
            C4456e.checkForValidRequestCode(i);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.m907b();
        int i2 = (i >> 16) & MinElf.PN_XNUM;
        if (i2 != 0) {
            i2--;
            String str = (String) this.mPendingFragmentActivityResults.m1467a(i2);
            this.mPendingFragmentActivityResults.m1473c(i2);
            if (str == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            C3178i a = this.mFragments.m897a(str);
            if (a == null) {
                i = TAG;
                strArr = new StringBuilder();
                strArr.append("Activity result no fragment exists for who: ");
                strArr.append(str);
                Log.w(i, strArr.toString());
            } else {
                a.onRequestPermissionsResult(i & MinElf.PN_XNUM, strArr, iArr);
            }
        }
    }

    public void startActivityFromFragment(C3178i c3178i, Intent intent, int i) {
        startActivityFromFragment(c3178i, intent, i, null);
    }

    public void startActivityFromFragment(C3178i c3178i, Intent intent, int i, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        if (i == -1) {
            try {
                C3169a.m9426a(this, intent, -1, bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else {
            C4456e.checkForValidRequestCode(i);
            C3169a.m9426a(this, intent, ((allocateRequestIndex(c3178i) + 1) << 16) + (i & MinElf.PN_XNUM), bundle);
            this.mStartedActivityFromFragment = false;
        }
    }

    public void startIntentSenderFromFragment(C3178i c3178i, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        int i5 = i;
        this.mStartedIntentSenderFromFragment = true;
        if (i5 == -1) {
            try {
                C3169a.m9427a(this, intentSender, i, intent, i2, i3, i4, bundle);
            } finally {
                r9.mStartedIntentSenderFromFragment = false;
            }
        } else {
            C4456e.checkForValidRequestCode(i);
            C3169a.m9427a(this, intentSender, ((allocateRequestIndex(c3178i) + 1) << 16) + (i5 & MinElf.PN_XNUM), intent, i2, i3, i4, bundle);
            r9.mStartedIntentSenderFromFragment = false;
        }
    }

    private int allocateRequestIndex(C3178i c3178i) {
        if (this.mPendingFragmentActivityResults.m1469b() < MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            while (this.mPendingFragmentActivityResults.m1477f(this.mNextCandidateRequestIndex) >= 0) {
                this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
            }
            int i = this.mNextCandidateRequestIndex;
            this.mPendingFragmentActivityResults.m1471b(i, c3178i.mWho);
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % 65534;
            return i;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    void requestPermissionsFromFragment(C3178i c3178i, String[] strArr, int i) {
        if (i == -1) {
            C3169a.m9429a(this, strArr, i);
            return;
        }
        C4456e.checkForValidRequestCode(i);
        try {
            this.mRequestedPermissionsFromFragment = true;
            C3169a.m9429a(this, strArr, ((allocateRequestIndex(c3178i) + 1) << 16) + (i & MinElf.PN_XNUM));
        } finally {
            this.mRequestedPermissionsFromFragment = false;
        }
    }

    private void markFragmentsCreated() {
        do {
        } while (C4890j.markState(getSupportFragmentManager(), C0073b.CREATED));
    }

    private static boolean markState(C0309n c0309n, C0073b c0073b) {
        boolean z = false;
        for (C3178i c3178i : c0309n.mo205c()) {
            if (c3178i != null) {
                if (c3178i.getLifecycle().mo22a().m178a(C0073b.STARTED)) {
                    c3178i.mLifecycleRegistry.m9134a(c0073b);
                    z = true;
                }
                C0309n peekChildFragmentManager = c3178i.peekChildFragmentManager();
                if (peekChildFragmentManager != null) {
                    z |= C4890j.markState(peekChildFragmentManager, c0073b);
                }
            }
        }
        return z;
    }
}
