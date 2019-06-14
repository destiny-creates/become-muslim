package com.facebook.react.uimanager;

import android.annotation.TargetApi;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnDismissListener;
import android.widget.PopupMenu.OnMenuItemClickListener;
import com.facebook.common.logging.FLog;
import com.facebook.react.C1864R;
import com.facebook.react.animation.Animation;
import com.facebook.react.animation.AnimationListener;
import com.facebook.react.animation.AnimationRegistry;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationController;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationListener;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import expolib_v1.com.facebook.infer.annotation.Assertions;

public class NativeViewHierarchyManager {
    public static String TAG = "NativeViewHierarchyManager";
    public final AnimationRegistry mAnimationRegistry;
    public final JSResponderHandler mJSResponderHandler;
    public boolean mLayoutAnimationEnabled;
    public final LayoutAnimationController mLayoutAnimator;
    public PopupMenu mPopupMenu;
    public final SparseBooleanArray mRootTags;
    public final RootViewManager mRootViewManager;
    public final SparseArray<ViewManager> mTagsToViewManagers;
    public final SparseArray<View> mTagsToViews;
    public final ViewManagerRegistry mViewManagers;

    private static class PopupMenuCallbackHandler implements OnDismissListener, OnMenuItemClickListener {
        public boolean mConsumed;
        public final Callback mSuccess;

        private PopupMenuCallbackHandler(Callback callback) {
            this.mConsumed = false;
            this.mSuccess = callback;
        }

        public void onDismiss(PopupMenu popupMenu) {
            if (this.mConsumed == null) {
                this.mSuccess.invoke(UIManagerModuleConstants.ACTION_DISMISSED);
                this.mConsumed = true;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (this.mConsumed) {
                return false;
            }
            this.mSuccess.invoke(UIManagerModuleConstants.ACTION_ITEM_SELECTED, Integer.valueOf(menuItem.getOrder()));
            this.mConsumed = true;
            return true;
        }
    }

    public NativeViewHierarchyManager(ViewManagerRegistry viewManagerRegistry) {
        this(viewManagerRegistry, new RootViewManager());
    }

    public NativeViewHierarchyManager(ViewManagerRegistry viewManagerRegistry, RootViewManager rootViewManager) {
        this.mJSResponderHandler = new JSResponderHandler();
        this.mLayoutAnimator = new LayoutAnimationController();
        this.mAnimationRegistry = new AnimationRegistry();
        this.mViewManagers = viewManagerRegistry;
        this.mTagsToViews = new SparseArray();
        this.mTagsToViewManagers = new SparseArray();
        this.mRootTags = new SparseBooleanArray();
        this.mRootViewManager = rootViewManager;
    }

    public final synchronized View resolveView(int i) {
        View view;
        view = (View) this.mTagsToViews.get(i);
        if (view == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trying to resolve view with tag ");
            stringBuilder.append(i);
            stringBuilder.append(" which doesn't exist");
            throw new IllegalViewOperationException(stringBuilder.toString());
        }
        return view;
    }

    public final synchronized ViewManager resolveViewManager(int i) {
        ViewManager viewManager;
        viewManager = (ViewManager) this.mTagsToViewManagers.get(i);
        if (viewManager == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ViewManager for tag ");
            stringBuilder.append(i);
            stringBuilder.append(" could not be found");
            throw new IllegalViewOperationException(stringBuilder.toString());
        }
        return viewManager;
    }

    public AnimationRegistry getAnimationRegistry() {
        return this.mAnimationRegistry;
    }

    public void setLayoutAnimationEnabled(boolean z) {
        this.mLayoutAnimationEnabled = z;
    }

    public synchronized void updateInstanceHandle(int i, long j) {
        UiThreadUtil.assertOnUiThread();
        try {
            updateInstanceHandle(resolveView(i), j);
        } catch (Throwable e) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to update properties for view tag ");
            stringBuilder.append(i);
            FLog.m5675e(str, stringBuilder.toString(), e);
        }
        return;
    }

    public synchronized void updateProperties(int r4, com.facebook.react.uimanager.ReactStylesDiffMap r5) {
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
        monitor-enter(r3);
        com.facebook.react.bridge.UiThreadUtil.assertOnUiThread();	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        r0 = r3.resolveViewManager(r4);	 Catch:{ IllegalViewOperationException -> 0x0012 }
        r1 = r3.resolveView(r4);	 Catch:{ IllegalViewOperationException -> 0x0012 }
        if (r5 == 0) goto L_0x002d;	 Catch:{ IllegalViewOperationException -> 0x0012 }
    L_0x000e:
        r0.updateProperties(r1, r5);	 Catch:{ IllegalViewOperationException -> 0x0012 }
        goto L_0x002d;
    L_0x0012:
        r5 = move-exception;
        r0 = TAG;	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        r1.<init>();	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        r2 = "Unable to update properties for view tag ";	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        r1.append(r2);	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        r1.append(r4);	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        r4 = r1.toString();	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        com.facebook.common.logging.FLog.m5675e(r0, r4, r5);	 Catch:{ Throwable -> 0x002d, all -> 0x002a }
        goto L_0x002d;
    L_0x002a:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
    L_0x002d:
        monitor-exit(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.NativeViewHierarchyManager.updateProperties(int, com.facebook.react.uimanager.ReactStylesDiffMap):void");
    }

    public synchronized void updateViewExtraData(int i, Object obj) {
        UiThreadUtil.assertOnUiThread();
        resolveViewManager(i).updateExtraData(resolveView(i), obj);
    }

    public synchronized void updateLayout(int i, int i2, int i3, int i4, int i5, int i6) {
        UiThreadUtil.assertOnUiThread();
        SystraceMessage.beginSection(0, "NativeViewHierarchyManager_updateLayout").arg("parentTag", i).arg("tag", i2).flush();
        try {
            View resolveView = resolveView(i2);
            resolveView.measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), MeasureSpec.makeMeasureSpec(i6, 1073741824));
            ViewParent parent = resolveView.getParent();
            if (parent instanceof RootView) {
                parent.requestLayout();
            }
            if (this.mRootTags.get(i)) {
                updateLayout(resolveView, i3, i4, i5, i6);
            } else {
                ViewManager viewManager = (ViewManager) this.mTagsToViewManagers.get(i);
                if (viewManager instanceof ViewGroupManager) {
                    ViewGroupManager viewGroupManager = (ViewGroupManager) viewManager;
                    if (viewGroupManager != null && viewGroupManager.needsCustomLayoutForChildren() == 0) {
                        updateLayout(resolveView, i3, i4, i5, i6);
                    }
                } else {
                    i3 = new StringBuilder();
                    i3.append("Trying to use view with tag ");
                    i3.append(i2);
                    i3.append(" as a parent, but its Manager doesn't extends ViewGroupManager");
                    throw new IllegalViewOperationException(i3.toString());
                }
            }
        } finally {
            Systrace.endSection(0);
        }
    }

    @TargetApi(4)
    private void updateInstanceHandle(View view, long j) {
        UiThreadUtil.assertOnUiThread();
        view.setTag(C1864R.id.view_tag_instance_handle, Long.valueOf(j));
    }

    @TargetApi(4)
    public long getInstanceHandle(int i) {
        View view = (View) this.mTagsToViews.get(i);
        if (view != null) {
            Long l = (Long) view.getTag(C1864R.id.view_tag_instance_handle);
            if (l != null) {
                return l.longValue();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to find instanceHandle for tag: ");
            stringBuilder.append(i);
            throw new IllegalViewOperationException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to find view for tag: ");
        stringBuilder.append(i);
        throw new IllegalViewOperationException(stringBuilder.toString());
    }

    private void updateLayout(View view, int i, int i2, int i3, int i4) {
        if (this.mLayoutAnimationEnabled && this.mLayoutAnimator.shouldAnimateLayout(view)) {
            this.mLayoutAnimator.applyLayoutUpdate(view, i, i2, i3, i4);
        } else {
            view.layout(i, i2, i3 + i, i4 + i2);
        }
    }

    public synchronized void createView(ThemedReactContext themedReactContext, int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
        UiThreadUtil.assertOnUiThread();
        SystraceMessage.beginSection(0, "NativeViewHierarchyManager_createView").arg("tag", i).arg("className", (Object) str).flush();
        try {
            str = this.mViewManagers.get(str);
            themedReactContext = str.createView(themedReactContext, this.mJSResponderHandler);
            this.mTagsToViews.put(i, themedReactContext);
            this.mTagsToViewManagers.put(i, str);
            themedReactContext.setId(i);
            if (reactStylesDiffMap != null) {
                str.updateProperties(themedReactContext, reactStylesDiffMap);
            }
        } finally {
            Systrace.endSection(0);
        }
    }

    private static String constructManageChildrenErrorMessage(ViewGroup viewGroup, ViewGroupManager viewGroupManager, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        if (viewGroup != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("View tag:");
            stringBuilder2.append(viewGroup.getId());
            stringBuilder2.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("  children(");
            stringBuilder2.append(viewGroupManager.getChildCount(viewGroup));
            stringBuilder2.append("): [\n");
            stringBuilder.append(stringBuilder2.toString());
            for (i = 0; i < viewGroupManager.getChildCount(viewGroup); i += 16) {
                int i2 = 0;
                while (true) {
                    int i3 = i + i2;
                    if (i3 >= viewGroupManager.getChildCount(viewGroup) || i2 >= 16) {
                        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                    } else {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(viewGroupManager.getChildAt(viewGroup, i3).getId());
                        stringBuilder3.append(",");
                        stringBuilder.append(stringBuilder3.toString());
                        i2++;
                    }
                }
                stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
            stringBuilder.append(" ],\n");
        }
        if (iArr != null) {
            viewGroup = new StringBuilder();
            viewGroup.append("  indicesToRemove(");
            viewGroup.append(iArr.length);
            viewGroup.append("): [\n");
            stringBuilder.append(viewGroup.toString());
            for (viewGroup = null; viewGroup < iArr.length; viewGroup += 16) {
                viewGroupManager = null;
                while (true) {
                    i = viewGroup + viewGroupManager;
                    if (i >= iArr.length || viewGroupManager >= 16) {
                        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                    } else {
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(iArr[i]);
                        stringBuilder4.append(",");
                        stringBuilder.append(stringBuilder4.toString());
                        viewGroupManager++;
                    }
                }
                stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
            stringBuilder.append(" ],\n");
        }
        if (viewAtIndexArr != null) {
            viewGroup = new StringBuilder();
            viewGroup.append("  viewsToAdd(");
            viewGroup.append(viewAtIndexArr.length);
            viewGroup.append("): [\n");
            stringBuilder.append(viewGroup.toString());
            for (viewGroup = null; viewGroup < viewAtIndexArr.length; viewGroup += 16) {
                viewGroupManager = null;
                while (true) {
                    iArr = viewGroup + viewGroupManager;
                    if (iArr >= viewAtIndexArr.length || viewGroupManager >= 16) {
                        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                    } else {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("[");
                        stringBuilder2.append(viewAtIndexArr[iArr].mIndex);
                        stringBuilder2.append(",");
                        stringBuilder2.append(viewAtIndexArr[iArr].mTag);
                        stringBuilder2.append("],");
                        stringBuilder.append(stringBuilder2.toString());
                        viewGroupManager++;
                    }
                }
                stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
            stringBuilder.append(" ],\n");
        }
        if (iArr2 != null) {
            viewGroup = new StringBuilder();
            viewGroup.append("  tagsToDelete(");
            viewGroup.append(iArr2.length);
            viewGroup.append("): [\n");
            stringBuilder.append(viewGroup.toString());
            for (viewGroup = null; viewGroup < iArr2.length; viewGroup += 16) {
                viewGroupManager = null;
                while (true) {
                    iArr = viewGroup + viewGroupManager;
                    if (iArr >= iArr2.length || viewGroupManager >= 16) {
                        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                    } else {
                        viewAtIndexArr = new StringBuilder();
                        viewAtIndexArr.append(iArr2[iArr]);
                        viewAtIndexArr.append(",");
                        stringBuilder.append(viewAtIndexArr.toString());
                        viewGroupManager++;
                    }
                }
                stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
            stringBuilder.append(" ]\n");
        }
        return stringBuilder.toString();
    }

    public synchronized void manageChildren(int i, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
        UiThreadUtil.assertOnUiThread();
        final ViewGroup viewGroup = (ViewGroup) this.mTagsToViews.get(i);
        final ViewGroupManager viewGroupManager = (ViewGroupManager) resolveViewManager(i);
        StringBuilder stringBuilder;
        if (viewGroup != null) {
            int childCount = viewGroupManager.getChildCount(viewGroup);
            if (iArr != null) {
                int length = iArr.length - 1;
                while (length >= 0) {
                    int i2 = iArr[length];
                    if (i2 < 0) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Trying to remove a negative view index:");
                        stringBuilder.append(i2);
                        stringBuilder.append(" view tag: ");
                        stringBuilder.append(i);
                        stringBuilder.append("\n detail: ");
                        stringBuilder.append(constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                        throw new IllegalViewOperationException(stringBuilder.toString());
                    } else if (i2 >= viewGroupManager.getChildCount(viewGroup)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Trying to remove a view index above child count ");
                        stringBuilder.append(i2);
                        stringBuilder.append(" view tag: ");
                        stringBuilder.append(i);
                        stringBuilder.append("\n detail: ");
                        stringBuilder.append(constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                        throw new IllegalViewOperationException(stringBuilder.toString());
                    } else if (i2 < childCount) {
                        View childAt = viewGroupManager.getChildAt(viewGroup, i2);
                        if (this.mLayoutAnimationEnabled && this.mLayoutAnimator.shouldAnimateLayout(childAt) && arrayContains(iArr2, childAt.getId())) {
                            viewGroupManager.startViewTransition(viewGroup, childAt);
                        }
                        viewGroupManager.removeViewAt(viewGroup, i2);
                        length--;
                        childCount = i2;
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Trying to remove an out of order view index:");
                        stringBuilder.append(i2);
                        stringBuilder.append(" view tag: ");
                        stringBuilder.append(i);
                        stringBuilder.append("\n detail: ");
                        stringBuilder.append(constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                        throw new IllegalViewOperationException(stringBuilder.toString());
                    }
                }
            }
            i = 0;
            if (viewAtIndexArr != null) {
                childCount = 0;
                while (childCount < viewAtIndexArr.length) {
                    ViewAtIndex viewAtIndex = viewAtIndexArr[childCount];
                    View view = (View) this.mTagsToViews.get(viewAtIndex.mTag);
                    if (view != null) {
                        viewGroupManager.addView(viewGroup, view, viewAtIndex.mIndex);
                        childCount++;
                    } else {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Trying to add unknown view tag: ");
                        stringBuilder2.append(viewAtIndex.mTag);
                        stringBuilder2.append("\n detail: ");
                        stringBuilder2.append(constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                        throw new IllegalViewOperationException(stringBuilder2.toString());
                    }
                }
            }
            if (iArr2 != null) {
                while (i < iArr2.length) {
                    childCount = iArr2[i];
                    final View view2 = (View) this.mTagsToViews.get(childCount);
                    if (view2 != null) {
                        if (this.mLayoutAnimationEnabled && this.mLayoutAnimator.shouldAnimateLayout(view2)) {
                            this.mLayoutAnimator.deleteView(view2, new LayoutAnimationListener() {
                                public void onAnimationEnd() {
                                    viewGroupManager.endViewTransition(viewGroup, view2);
                                    NativeViewHierarchyManager.this.dropView(view2);
                                }
                            });
                        } else {
                            dropView(view2);
                        }
                        i++;
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Trying to destroy unknown view tag: ");
                        stringBuilder.append(childCount);
                        stringBuilder.append("\n detail: ");
                        stringBuilder.append(constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                        throw new IllegalViewOperationException(stringBuilder.toString());
                    }
                }
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Trying to manageChildren view with tag ");
        stringBuilder.append(i);
        stringBuilder.append(" which doesn't exist\n detail: ");
        stringBuilder.append(constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
        throw new IllegalViewOperationException(stringBuilder.toString());
    }

    private boolean arrayContains(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return 1;
            }
        }
        return false;
    }

    private static String constructSetChildrenErrorMessage(ViewGroup viewGroup, ViewGroupManager viewGroupManager, ReadableArray readableArray) {
        ViewAtIndex[] viewAtIndexArr = new ViewAtIndex[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            viewAtIndexArr[i] = new ViewAtIndex(readableArray.getInt(i), i);
        }
        return constructManageChildrenErrorMessage(viewGroup, viewGroupManager, null, viewAtIndexArr, null);
    }

    public synchronized void setChildren(int i, ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        ViewGroup viewGroup = (ViewGroup) this.mTagsToViews.get(i);
        ViewGroupManager viewGroupManager = (ViewGroupManager) resolveViewManager(i);
        int i2 = 0;
        while (i2 < readableArray.size()) {
            View view = (View) this.mTagsToViews.get(readableArray.getInt(i2));
            if (view != null) {
                viewGroupManager.addView(viewGroup, view, i2);
                i2++;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Trying to add unknown view tag: ");
                stringBuilder.append(readableArray.getInt(i2));
                stringBuilder.append("\n detail: ");
                stringBuilder.append(constructSetChildrenErrorMessage(viewGroup, viewGroupManager, readableArray));
                throw new IllegalViewOperationException(stringBuilder.toString());
            }
        }
    }

    public synchronized void addRootView(int i, SizeMonitoringFrameLayout sizeMonitoringFrameLayout, ThemedReactContext themedReactContext) {
        addRootViewGroup(i, sizeMonitoringFrameLayout, themedReactContext);
    }

    protected final synchronized void addRootViewGroup(int i, ViewGroup viewGroup, ThemedReactContext themedReactContext) {
        if (viewGroup.getId() == -1) {
            this.mTagsToViews.put(i, viewGroup);
            this.mTagsToViewManagers.put(i, this.mRootViewManager);
            this.mRootTags.put(i, true);
            viewGroup.setId(i);
        } else {
            throw new IllegalViewOperationException("Trying to add a root view with an explicit id already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
        }
    }

    protected synchronized void dropView(View view) {
        UiThreadUtil.assertOnUiThread();
        if (!this.mRootTags.get(view.getId())) {
            resolveViewManager(view.getId()).onDropViewInstance(view);
        }
        ViewManager viewManager = (ViewManager) this.mTagsToViewManagers.get(view.getId());
        if ((view instanceof ViewGroup) && (viewManager instanceof ViewGroupManager)) {
            ViewGroup viewGroup = (ViewGroup) view;
            ViewGroupManager viewGroupManager = (ViewGroupManager) viewManager;
            for (int childCount = viewGroupManager.getChildCount(viewGroup) - 1; childCount >= 0; childCount--) {
                View childAt = viewGroupManager.getChildAt(viewGroup, childCount);
                if (this.mTagsToViews.get(childAt.getId()) != null) {
                    dropView(childAt);
                }
            }
            viewGroupManager.removeAllViews(viewGroup);
        }
        this.mTagsToViews.remove(view.getId());
        this.mTagsToViewManagers.remove(view.getId());
    }

    public synchronized void removeRootView(int i) {
        UiThreadUtil.assertOnUiThread();
        if (!this.mRootTags.get(i)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("View with tag ");
            stringBuilder.append(i);
            stringBuilder.append(" is not registered as a root view");
            SoftAssertions.assertUnreachable(stringBuilder.toString());
        }
        dropView((View) this.mTagsToViews.get(i));
        this.mRootTags.delete(i);
    }

    public synchronized void measure(int i, int[] iArr) {
        UiThreadUtil.assertOnUiThread();
        View view = (View) this.mTagsToViews.get(i);
        if (view != null) {
            View view2 = (View) RootViewUtil.getRootView(view);
            if (view2 != null) {
                view2.getLocationInWindow(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                view.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i2;
                iArr[1] = iArr[1] - i3;
                iArr[2] = view.getWidth();
                iArr[3] = view.getHeight();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Native view ");
                stringBuilder.append(i);
                stringBuilder.append(" is no longer on screen");
                throw new NoSuchNativeViewException(stringBuilder.toString());
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("No native view for ");
        stringBuilder.append(i);
        stringBuilder.append(" currently exists");
        throw new NoSuchNativeViewException(stringBuilder.toString());
    }

    public synchronized void measureInWindow(int i, int[] iArr) {
        UiThreadUtil.assertOnUiThread();
        View view = (View) this.mTagsToViews.get(i);
        if (view != null) {
            view.getLocationOnScreen(iArr);
            i = view.getContext().getResources();
            int identifier = i.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                iArr[1] = iArr[1] - ((int) i.getDimension(identifier));
            }
            iArr[2] = view.getWidth();
            iArr[3] = view.getHeight();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No native view for ");
            stringBuilder.append(i);
            stringBuilder.append(" currently exists");
            throw new NoSuchNativeViewException(stringBuilder.toString());
        }
    }

    public synchronized int findTargetTagForTouch(int i, float f, float f2) {
        View view;
        UiThreadUtil.assertOnUiThread();
        view = (View) this.mTagsToViews.get(i);
        if (view != null) {
        } else {
            f2 = new StringBuilder();
            f2.append("Could not find view with tag ");
            f2.append(i);
            throw new JSApplicationIllegalArgumentException(f2.toString());
        }
        return TouchTargetHelper.findTargetTagForTouch(f, f2, (ViewGroup) view);
    }

    public synchronized void setJSResponder(int i, int i2, boolean z) {
        if (z) {
            View view = (View) this.mTagsToViews.get(i);
            if (i2 == i || !(view instanceof ViewParent)) {
                if (this.mRootTags.get(i)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Cannot block native responder on ");
                    stringBuilder.append(i);
                    stringBuilder.append(" that is a root view");
                    SoftAssertions.assertUnreachable(stringBuilder.toString());
                }
                this.mJSResponderHandler.setJSResponder(i2, view.getParent());
                return;
            }
            this.mJSResponderHandler.setJSResponder(i2, (ViewParent) view);
            return;
        }
        this.mJSResponderHandler.setJSResponder(i2, false);
    }

    public void clearJSResponder() {
        this.mJSResponderHandler.clearJSResponder();
    }

    void configureLayoutAnimation(ReadableMap readableMap) {
        this.mLayoutAnimator.initializeFromConfig(readableMap);
    }

    void clearLayoutAnimation() {
        this.mLayoutAnimator.reset();
    }

    synchronized void startAnimationForNativeView(int i, Animation animation, final Callback callback) {
        UiThreadUtil.assertOnUiThread();
        View view = (View) this.mTagsToViews.get(i);
        final int animationID = animation.getAnimationID();
        if (view != null) {
            animation.setAnimationListener(new AnimationListener() {
                public void onFinished() {
                    Assertions.assertNotNull(NativeViewHierarchyManager.this.mAnimationRegistry.removeAnimation(animationID), "Animation was already removed somehow!");
                    if (callback != null) {
                        callback.invoke(Boolean.valueOf(true));
                    }
                }

                public void onCancel() {
                    Assertions.assertNotNull(NativeViewHierarchyManager.this.mAnimationRegistry.removeAnimation(animationID), "Animation was already removed somehow!");
                    if (callback != null) {
                        callback.invoke(Boolean.valueOf(false));
                    }
                }
            });
            animation.start(view);
        } else {
            callback = new StringBuilder();
            callback.append("View with tag ");
            callback.append(i);
            callback.append(" not found");
            throw new IllegalViewOperationException(callback.toString());
        }
    }

    public synchronized void dispatchCommand(int i, int i2, ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        View view = (View) this.mTagsToViews.get(i);
        if (view != null) {
            resolveViewManager(i).receiveCommand(view, i2, readableArray);
        } else {
            readableArray = new StringBuilder();
            readableArray.append("Trying to send command to a non-existing view with tag ");
            readableArray.append(i);
            throw new IllegalViewOperationException(readableArray.toString());
        }
    }

    public synchronized void showPopupMenu(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
        UiThreadUtil.assertOnUiThread();
        View view = (View) this.mTagsToViews.get(i);
        if (view == null) {
            readableArray = new Object[1];
            callback = new StringBuilder();
            callback.append("Can't display popup. Could not find view with tag ");
            callback.append(i);
            readableArray[0] = callback.toString();
            callback2.invoke(readableArray);
            return;
        }
        this.mPopupMenu = new PopupMenu(getReactContextForView(i), view);
        i = this.mPopupMenu.getMenu();
        for (callback2 = null; callback2 < readableArray.size(); callback2++) {
            i.add(0, 0, callback2, readableArray.getString(callback2));
        }
        i = new PopupMenuCallbackHandler(callback);
        this.mPopupMenu.setOnMenuItemClickListener(i);
        this.mPopupMenu.setOnDismissListener(i);
        this.mPopupMenu.show();
    }

    public void dismissPopupMenu() {
        if (this.mPopupMenu != null) {
            this.mPopupMenu.dismiss();
        }
    }

    private ThemedReactContext getReactContextForView(int i) {
        View view = (View) this.mTagsToViews.get(i);
        if (view != null) {
            return (ThemedReactContext) view.getContext();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not find view with tag ");
        stringBuilder.append(i);
        throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
    }

    public void sendAccessibilityEvent(int i, int i2) {
        View view = (View) this.mTagsToViews.get(i);
        if (view != null) {
            AccessibilityHelper.sendAccessibilityEvent(view, i2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not find view with tag ");
        stringBuilder.append(i);
        throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
    }
}
