package com.facebook.react.views.modal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnShowListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.facebook.react.C1864R;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewGroup;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.ArrayList;

public class ReactModalHostView extends ViewGroup implements LifecycleEventListener {
    private String mAnimationType;
    private Dialog mDialog;
    private boolean mHardwareAccelerated;
    private DialogRootViewGroup mHostView;
    private OnRequestCloseListener mOnRequestCloseListener;
    private OnShowListener mOnShowListener;
    private boolean mPropertyRequiresNewDialog;
    private boolean mTransparent;

    /* renamed from: com.facebook.react.views.modal.ReactModalHostView$1 */
    class C19831 implements OnKeyListener {
        C19831() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 1) {
                if (i == 4) {
                    Assertions.assertNotNull(ReactModalHostView.this.mOnRequestCloseListener, "setOnRequestCloseListener must be called by the manager");
                    ReactModalHostView.this.mOnRequestCloseListener.onRequestClose(dialogInterface);
                    return true;
                }
                dialogInterface = ((ReactContext) ReactModalHostView.this.getContext()).getCurrentActivity();
                if (dialogInterface != null) {
                    return dialogInterface.onKeyUp(i, keyEvent);
                }
            }
            return null;
        }
    }

    public interface OnRequestCloseListener {
        void onRequestClose(DialogInterface dialogInterface);
    }

    static class DialogRootViewGroup extends ReactViewGroup implements RootView {
        private final JSTouchDispatcher mJSTouchDispatcher = new JSTouchDispatcher(this);

        public void requestDisallowInterceptTouchEvent(boolean z) {
        }

        public DialogRootViewGroup(Context context) {
            super(context);
        }

        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (getChildCount() > 0) {
                final int id = getChildAt(0).getId();
                i3 = getReactContext();
                final int i5 = i;
                final int i6 = i2;
                i3.runOnNativeModulesQueueThread(new GuardedRunnable(i3) {
                    public void runGuarded() {
                        ((UIManagerModule) DialogRootViewGroup.this.getReactContext().getNativeModule(UIManagerModule.class)).updateNodeSize(id, i5, i6);
                    }
                });
            }
        }

        public void handleException(Throwable th) {
            getReactContext().handleException(new RuntimeException(th));
        }

        private ReactContext getReactContext() {
            return (ReactContext) getContext();
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.mJSTouchDispatcher.handleTouchEvent(motionEvent, getEventDispatcher());
            return super.onInterceptTouchEvent(motionEvent);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            this.mJSTouchDispatcher.handleTouchEvent(motionEvent, getEventDispatcher());
            super.onTouchEvent(motionEvent);
            return true;
        }

        public void onChildStartedNativeGesture(MotionEvent motionEvent) {
            this.mJSTouchDispatcher.onChildStartedNativeGesture(motionEvent, getEventDispatcher());
        }

        private EventDispatcher getEventDispatcher() {
            return ((UIManagerModule) getReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }
    }

    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void onHostPause() {
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public ReactModalHostView(Context context) {
        super(context);
        ((ReactContext) context).addLifecycleEventListener(this);
        this.mHostView = new DialogRootViewGroup(context);
    }

    public void addView(View view, int i) {
        this.mHostView.addView(view, i);
    }

    public int getChildCount() {
        return this.mHostView.getChildCount();
    }

    public View getChildAt(int i) {
        return this.mHostView.getChildAt(i);
    }

    public void removeView(View view) {
        this.mHostView.removeView(view);
    }

    public void removeViewAt(int i) {
        this.mHostView.removeView(getChildAt(i));
    }

    public void onDropInstance() {
        ((ReactContext) getContext()).removeLifecycleEventListener(this);
        dismiss();
    }

    private void dismiss() {
        if (this.mDialog != null) {
            Activity currentActivity = getCurrentActivity();
            if (this.mDialog.isShowing() && (currentActivity == null || !currentActivity.isFinishing())) {
                this.mDialog.dismiss();
            }
            this.mDialog = null;
            ((ViewGroup) this.mHostView.getParent()).removeViewAt(0);
        }
    }

    protected void setOnRequestCloseListener(OnRequestCloseListener onRequestCloseListener) {
        this.mOnRequestCloseListener = onRequestCloseListener;
    }

    protected void setOnShowListener(OnShowListener onShowListener) {
        this.mOnShowListener = onShowListener;
    }

    protected void setTransparent(boolean z) {
        this.mTransparent = z;
    }

    protected void setAnimationType(String str) {
        this.mAnimationType = str;
        this.mPropertyRequiresNewDialog = true;
    }

    protected void setHardwareAccelerated(boolean z) {
        this.mHardwareAccelerated = z;
        this.mPropertyRequiresNewDialog = true;
    }

    public void onHostResume() {
        showOrUpdate();
    }

    public void onHostDestroy() {
        onDropInstance();
    }

    @VisibleForTesting
    public Dialog getDialog() {
        return this.mDialog;
    }

    private Activity getCurrentActivity() {
        return ((ReactContext) getContext()).getCurrentActivity();
    }

    protected void showOrUpdate() {
        if (this.mDialog != null) {
            if (this.mPropertyRequiresNewDialog) {
                dismiss();
            } else {
                updateProperties();
                return;
            }
        }
        this.mPropertyRequiresNewDialog = false;
        int i = C1864R.style.Theme_FullScreenDialog;
        if (this.mAnimationType.equals("fade")) {
            i = C1864R.style.Theme_FullScreenDialogAnimatedFade;
        } else if (this.mAnimationType.equals("slide")) {
            i = C1864R.style.Theme_FullScreenDialogAnimatedSlide;
        }
        Context currentActivity = getCurrentActivity();
        this.mDialog = new Dialog(currentActivity == null ? getContext() : currentActivity, i);
        this.mDialog.setContentView(getContentView());
        updateProperties();
        this.mDialog.setOnShowListener(this.mOnShowListener);
        this.mDialog.setOnKeyListener(new C19831());
        this.mDialog.getWindow().setSoftInputMode(16);
        if (this.mHardwareAccelerated) {
            this.mDialog.getWindow().addFlags(16777216);
        }
        if (!(currentActivity == null || currentActivity.isFinishing())) {
            this.mDialog.show();
        }
    }

    private View getContentView() {
        View frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.mHostView);
        frameLayout.setFitsSystemWindows(true);
        return frameLayout;
    }

    private void updateProperties() {
        Assertions.assertNotNull(this.mDialog, "mDialog must exist when we call updateProperties");
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            if ((currentActivity.getWindow().getAttributes().flags & 1024) != 0) {
                this.mDialog.getWindow().addFlags(1024);
            } else {
                this.mDialog.getWindow().clearFlags(1024);
            }
        }
        if (this.mTransparent) {
            this.mDialog.getWindow().clearFlags(2);
            return;
        }
        this.mDialog.getWindow().setDimAmount(0.5f);
        this.mDialog.getWindow().setFlags(2, 2);
    }
}
