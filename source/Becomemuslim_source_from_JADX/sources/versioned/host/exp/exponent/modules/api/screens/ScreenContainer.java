package versioned.host.exp.exponent.modules.api.screens;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.v4.app.C0326t;
import android.support.v4.app.C4890j;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScreenContainer extends ViewGroup {
    private final Set<Screen> mActiveScreens = new HashSet();
    private C0326t mCurrentTransaction;
    private FrameCallback mFrameCallback = new C77981();
    private boolean mIsAttached;
    private boolean mNeedUpdate;
    private final ArrayList<Screen> mScreens = new ArrayList();

    /* renamed from: versioned.host.exp.exponent.modules.api.screens.ScreenContainer$1 */
    class C77981 extends FrameCallback {
        C77981() {
        }

        public void doFrame(long j) {
            ScreenContainer.this.updateIfNeeded();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public ScreenContainer(Context context) {
        super(context);
    }

    protected void markUpdated() {
        if (!this.mNeedUpdate) {
            this.mNeedUpdate = true;
            ReactChoreographer.getInstance().postFrameCallback(CallbackType.NATIVE_ANIMATED_MODULE, this.mFrameCallback);
        }
    }

    protected void notifyChildUpdate() {
        markUpdated();
    }

    protected void addScreen(Screen screen, int i) {
        this.mScreens.add(i, screen);
        screen.setContainer(this);
        markUpdated();
    }

    protected void removeScreenAt(int i) {
        ((Screen) this.mScreens.get(i)).setContainer(null);
        this.mScreens.remove(i);
        markUpdated();
    }

    protected int getScreenCount() {
        return this.mScreens.size();
    }

    protected Screen getScreenAt(int i) {
        return (Screen) this.mScreens.get(i);
    }

    private C4890j findRootFragmentActivity() {
        ViewParent viewParent = this;
        while (true) {
            Context context;
            boolean z = viewParent instanceof ReactRootView;
            if (!z && viewParent.getParent() != null) {
                viewParent = viewParent.getParent();
            } else if (z) {
                throw new IllegalStateException("ScreenContainer is not attached under ReactRootView");
            } else {
                context = ((ReactRootView) viewParent).getContext();
                while (true) {
                    z = context instanceof C4890j;
                    if (!z && (context instanceof ContextWrapper)) {
                        context = ((ContextWrapper) context).getBaseContext();
                    } else if (!z) {
                        return (C4890j) context;
                    } else {
                        throw new IllegalStateException("In order to use RNScreens components your app's activity need to extend ReactFragmentActivity or ReactCompatActivity");
                    }
                }
                if (!z) {
                    return (C4890j) context;
                }
                throw new IllegalStateException("In order to use RNScreens components your app's activity need to extend ReactFragmentActivity or ReactCompatActivity");
            }
        }
        if (z) {
            throw new IllegalStateException("ScreenContainer is not attached under ReactRootView");
        }
        context = ((ReactRootView) viewParent).getContext();
        while (true) {
            z = context instanceof C4890j;
            if (!z) {
                break;
            }
            break;
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (!z) {
            return (C4890j) context;
        }
        throw new IllegalStateException("In order to use RNScreens components your app's activity need to extend ReactFragmentActivity or ReactCompatActivity");
    }

    private C0326t getOrCreateTransaction() {
        if (this.mCurrentTransaction == null) {
            this.mCurrentTransaction = findRootFragmentActivity().getSupportFragmentManager().a();
            this.mCurrentTransaction.a(true);
        }
        return this.mCurrentTransaction;
    }

    private void tryCommitTransaction() {
        if (this.mCurrentTransaction != null) {
            this.mCurrentTransaction.d();
            this.mCurrentTransaction = null;
        }
    }

    private void attachScreen(Screen screen) {
        getOrCreateTransaction().a(getId(), screen.getFragment());
        this.mActiveScreens.add(screen);
    }

    private void moveToFront(Screen screen) {
        C0326t orCreateTransaction = getOrCreateTransaction();
        screen = screen.getFragment();
        orCreateTransaction.a(screen);
        orCreateTransaction.a(getId(), screen);
    }

    private void detachScreen(Screen screen) {
        getOrCreateTransaction().a(screen.getFragment());
        this.mActiveScreens.remove(screen);
    }

    protected boolean isScreenActive(Screen screen, List<Screen> list) {
        return screen.isActive();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttached = true;
        updateIfNeeded();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttached = false;
    }

    private void updateIfNeeded() {
        if (this.mNeedUpdate) {
            if (this.mIsAttached) {
                int i;
                int i2 = 0;
                this.mNeedUpdate = false;
                Set hashSet = new HashSet(this.mActiveScreens);
                int size = this.mScreens.size();
                for (i = 0; i < size; i++) {
                    Screen screen = (Screen) this.mScreens.get(i);
                    if (!isScreenActive(screen, this.mScreens) && this.mActiveScreens.contains(screen)) {
                        detachScreen(screen);
                    }
                    hashSet.remove(screen);
                }
                if (!hashSet.isEmpty()) {
                    Object[] toArray = hashSet.toArray();
                    for (Object obj : toArray) {
                        detachScreen((Screen) obj);
                    }
                }
                int size2 = this.mScreens.size();
                i = 0;
                for (size = 0; size < size2; size++) {
                    if (isScreenActive((Screen) this.mScreens.get(size), this.mScreens)) {
                        i++;
                    }
                }
                boolean z = i > 1;
                i = this.mScreens.size();
                Object obj2 = null;
                while (i2 < i) {
                    Screen screen2 = (Screen) this.mScreens.get(i2);
                    boolean isScreenActive = isScreenActive(screen2, this.mScreens);
                    if (isScreenActive && !this.mActiveScreens.contains(screen2)) {
                        attachScreen(screen2);
                        obj2 = 1;
                    } else if (isScreenActive && r4 != null) {
                        moveToFront(screen2);
                    }
                    screen2.setTransitioning(z);
                    i2++;
                }
                tryCommitTransaction();
            }
        }
    }
}
