package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.infer.annotation.ReturnsOwnership;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements SimpleDraweeControllerBuilder {
    private static final NullPointerException NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
    private static final ControllerListener<Object> sAutoPlayAnimationsListener = new C46421();
    private static final AtomicLong sIdCounter = new AtomicLong();
    private boolean mAutoPlayAnimations;
    private final Set<ControllerListener> mBoundControllerListeners;
    private Object mCallerContext;
    private String mContentDescription;
    private final Context mContext;
    private ControllerListener<? super INFO> mControllerListener;
    private ControllerViewportVisibilityListener mControllerViewportVisibilityListener;
    private Supplier<DataSource<IMAGE>> mDataSourceSupplier;
    private REQUEST mImageRequest;
    private REQUEST mLowResImageRequest;
    private REQUEST[] mMultiImageRequests;
    private DraweeController mOldController;
    private boolean mRetainImageOnFailure;
    private boolean mTapToRetryEnabled;
    private boolean mTryCacheOnlyFirst;

    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    /* renamed from: com.facebook.drawee.controller.AbstractDraweeControllerBuilder$1 */
    static class C46421 extends BaseControllerListener<Object> {
        C46421() {
        }

        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    protected abstract DataSource<IMAGE> getDataSourceForRequest(DraweeController draweeController, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    protected final BUILDER getThis() {
        return this;
    }

    @ReturnsOwnership
    protected abstract AbstractDraweeController obtainController();

    protected AbstractDraweeControllerBuilder(Context context, Set<ControllerListener> set) {
        this.mContext = context;
        this.mBoundControllerListeners = set;
        init();
    }

    private void init() {
        this.mCallerContext = null;
        this.mImageRequest = null;
        this.mLowResImageRequest = null;
        this.mMultiImageRequests = null;
        this.mTryCacheOnlyFirst = true;
        this.mControllerListener = null;
        this.mControllerViewportVisibilityListener = null;
        this.mTapToRetryEnabled = false;
        this.mAutoPlayAnimations = false;
        this.mOldController = null;
        this.mContentDescription = null;
    }

    public BUILDER reset() {
        init();
        return getThis();
    }

    public BUILDER setCallerContext(Object obj) {
        this.mCallerContext = obj;
        return getThis();
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public BUILDER setImageRequest(REQUEST request) {
        this.mImageRequest = request;
        return getThis();
    }

    public REQUEST getImageRequest() {
        return this.mImageRequest;
    }

    public BUILDER setLowResImageRequest(REQUEST request) {
        this.mLowResImageRequest = request;
        return getThis();
    }

    public REQUEST getLowResImageRequest() {
        return this.mLowResImageRequest;
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] requestArr) {
        return setFirstAvailableImageRequests(requestArr, true);
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] requestArr, boolean z) {
        boolean z2;
        if (requestArr != null) {
            if (requestArr.length <= 0) {
                z2 = false;
                Preconditions.checkArgument(z2, "No requests specified!");
                this.mMultiImageRequests = requestArr;
                this.mTryCacheOnlyFirst = z;
                return getThis();
            }
        }
        z2 = true;
        Preconditions.checkArgument(z2, "No requests specified!");
        this.mMultiImageRequests = requestArr;
        this.mTryCacheOnlyFirst = z;
        return getThis();
    }

    public REQUEST[] getFirstAvailableImageRequests() {
        return this.mMultiImageRequests;
    }

    public BUILDER setDataSourceSupplier(Supplier<DataSource<IMAGE>> supplier) {
        this.mDataSourceSupplier = supplier;
        return getThis();
    }

    public Supplier<DataSource<IMAGE>> getDataSourceSupplier() {
        return this.mDataSourceSupplier;
    }

    public BUILDER setTapToRetryEnabled(boolean z) {
        this.mTapToRetryEnabled = z;
        return getThis();
    }

    public boolean getTapToRetryEnabled() {
        return this.mTapToRetryEnabled;
    }

    public BUILDER setRetainImageOnFailure(boolean z) {
        this.mRetainImageOnFailure = z;
        return getThis();
    }

    public boolean getRetainImageOnFailure() {
        return this.mRetainImageOnFailure;
    }

    public BUILDER setAutoPlayAnimations(boolean z) {
        this.mAutoPlayAnimations = z;
        return getThis();
    }

    public boolean getAutoPlayAnimations() {
        return this.mAutoPlayAnimations;
    }

    public BUILDER setControllerListener(ControllerListener<? super INFO> controllerListener) {
        this.mControllerListener = controllerListener;
        return getThis();
    }

    public ControllerListener<? super INFO> getControllerListener() {
        return this.mControllerListener;
    }

    public BUILDER setControllerViewportVisibilityListener(ControllerViewportVisibilityListener controllerViewportVisibilityListener) {
        this.mControllerViewportVisibilityListener = controllerViewportVisibilityListener;
        return getThis();
    }

    public ControllerViewportVisibilityListener getControllerViewportVisibilityListener() {
        return this.mControllerViewportVisibilityListener;
    }

    public BUILDER setContentDescription(String str) {
        this.mContentDescription = str;
        return getThis();
    }

    public String getContentDescription() {
        return this.mContentDescription;
    }

    public BUILDER setOldController(DraweeController draweeController) {
        this.mOldController = draweeController;
        return getThis();
    }

    public DraweeController getOldController() {
        return this.mOldController;
    }

    public AbstractDraweeController build() {
        validate();
        if (this.mImageRequest == null && this.mMultiImageRequests == null && this.mLowResImageRequest != null) {
            this.mImageRequest = this.mLowResImageRequest;
            this.mLowResImageRequest = null;
        }
        return buildController();
    }

    protected void validate() {
        boolean z;
        boolean z2 = false;
        if (this.mMultiImageRequests != null) {
            if (this.mImageRequest != null) {
                z = false;
                Preconditions.checkState(z, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
                if (this.mDataSourceSupplier == null || (this.mMultiImageRequests == null && this.mImageRequest == null && this.mLowResImageRequest == null)) {
                    z2 = true;
                }
                Preconditions.checkState(z2, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
            }
        }
        z = true;
        Preconditions.checkState(z, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        z2 = true;
        Preconditions.checkState(z2, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected AbstractDraweeController buildController() {
        AbstractDraweeController obtainController = obtainController();
        obtainController.setRetainImageOnFailure(getRetainImageOnFailure());
        obtainController.setContentDescription(getContentDescription());
        obtainController.setControllerViewportVisibilityListener(getControllerViewportVisibilityListener());
        maybeBuildAndSetRetryManager(obtainController);
        maybeAttachListeners(obtainController);
        return obtainController;
    }

    protected static String generateUniqueControllerId() {
        return String.valueOf(sIdCounter.getAndIncrement());
    }

    protected Supplier<DataSource<IMAGE>> obtainDataSourceSupplier(DraweeController draweeController, String str) {
        if (this.mDataSourceSupplier != null) {
            return this.mDataSourceSupplier;
        }
        Supplier<DataSource<IMAGE>> supplier = null;
        if (this.mImageRequest != null) {
            supplier = getDataSourceSupplierForRequest(draweeController, str, this.mImageRequest);
        } else if (this.mMultiImageRequests != null) {
            supplier = getFirstAvailableDataSourceSupplier(draweeController, str, this.mMultiImageRequests, this.mTryCacheOnlyFirst);
        }
        if (!(supplier == null || this.mLowResImageRequest == null)) {
            List arrayList = new ArrayList(2);
            arrayList.add(supplier);
            arrayList.add(getDataSourceSupplierForRequest(draweeController, str, this.mLowResImageRequest));
            supplier = IncreasingQualityDataSourceSupplier.create(arrayList, null);
        }
        if (supplier == null) {
            supplier = DataSources.getFailedDataSourceSupplier(NO_REQUEST_EXCEPTION);
        }
        return supplier;
    }

    protected Supplier<DataSource<IMAGE>> getFirstAvailableDataSourceSupplier(DraweeController draweeController, String str, REQUEST[] requestArr, boolean z) {
        List arrayList = new ArrayList(requestArr.length * 2);
        boolean z2 = false;
        if (z) {
            for (Object dataSourceSupplierForRequest : requestArr) {
                arrayList.add(getDataSourceSupplierForRequest(draweeController, str, dataSourceSupplierForRequest, CacheLevel.BITMAP_MEMORY_CACHE));
            }
        }
        while (z2 < requestArr.length) {
            arrayList.add(getDataSourceSupplierForRequest(draweeController, str, requestArr[z2]));
            z2++;
        }
        return FirstAvailableDataSourceSupplier.create(arrayList);
    }

    protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(DraweeController draweeController, String str, REQUEST request) {
        return getDataSourceSupplierForRequest(draweeController, str, request, CacheLevel.FULL_FETCH);
    }

    protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(DraweeController draweeController, String str, REQUEST request, CacheLevel cacheLevel) {
        final Object callerContext = getCallerContext();
        final DraweeController draweeController2 = draweeController;
        final String str2 = str;
        final REQUEST request2 = request;
        final CacheLevel cacheLevel2 = cacheLevel;
        return new Supplier<DataSource<IMAGE>>() {
            public DataSource<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.getDataSourceForRequest(draweeController2, str2, request2, callerContext, cacheLevel2);
            }

            public String toString() {
                return Objects.toStringHelper((Object) this).add(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, request2.toString()).toString();
            }
        };
    }

    protected void maybeAttachListeners(AbstractDraweeController abstractDraweeController) {
        if (this.mBoundControllerListeners != null) {
            for (ControllerListener addControllerListener : this.mBoundControllerListeners) {
                abstractDraweeController.addControllerListener(addControllerListener);
            }
        }
        if (this.mControllerListener != null) {
            abstractDraweeController.addControllerListener(this.mControllerListener);
        }
        if (this.mAutoPlayAnimations) {
            abstractDraweeController.addControllerListener(sAutoPlayAnimationsListener);
        }
    }

    protected void maybeBuildAndSetRetryManager(AbstractDraweeController abstractDraweeController) {
        if (this.mTapToRetryEnabled) {
            abstractDraweeController.getRetryManager().setTapToRetryEnabled(this.mTapToRetryEnabled);
            maybeBuildAndSetGestureDetector(abstractDraweeController);
        }
    }

    protected void maybeBuildAndSetGestureDetector(AbstractDraweeController abstractDraweeController) {
        if (abstractDraweeController.getGestureDetector() == null) {
            abstractDraweeController.setGestureDetector(GestureDetector.newInstance(this.mContext));
        }
    }

    protected Context getContext() {
        return this.mContext;
    }
}
