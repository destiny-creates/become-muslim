package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.C1743R;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.request.ImageRequest;

public class SimpleDraweeView extends GenericDraweeView {
    private static Supplier<? extends AbstractDraweeControllerBuilder> sDraweecontrollerbuildersupplier;
    private AbstractDraweeControllerBuilder mControllerBuilder;

    public static void initialize(Supplier<? extends AbstractDraweeControllerBuilder> supplier) {
        sDraweecontrollerbuildersupplier = supplier;
    }

    public static void shutDown() {
        sDraweecontrollerbuildersupplier = null;
    }

    public SimpleDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        init(context, null);
    }

    public SimpleDraweeView(Context context) {
        super(context);
        init(context, null);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    @TargetApi(21)
    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            Preconditions.checkNotNull(sDraweecontrollerbuildersupplier, "SimpleDraweeView was not initialized!");
            this.mControllerBuilder = (AbstractDraweeControllerBuilder) sDraweecontrollerbuildersupplier.get();
            if (attributeSet != null) {
                context = context.obtainStyledAttributes(attributeSet, C1743R.styleable.SimpleDraweeView);
                try {
                    if (context.hasValue(C1743R.styleable.SimpleDraweeView_actualImageUri) != null) {
                        setImageURI(Uri.parse(context.getString(C1743R.styleable.SimpleDraweeView_actualImageUri)), null);
                    } else if (context.hasValue(C1743R.styleable.SimpleDraweeView_actualImageResource) != null) {
                        attributeSet = context.getResourceId(C1743R.styleable.SimpleDraweeView_actualImageResource, -1);
                        if (attributeSet != -1) {
                            setActualImageResource(attributeSet);
                        }
                    }
                    context.recycle();
                } catch (Throwable th) {
                    context.recycle();
                }
            }
        }
    }

    protected AbstractDraweeControllerBuilder getControllerBuilder() {
        return this.mControllerBuilder;
    }

    public void setImageRequest(ImageRequest imageRequest) {
        setController(this.mControllerBuilder.setImageRequest(imageRequest).setOldController(getController()).build());
    }

    public void setImageURI(Uri uri) {
        setImageURI(uri, null);
    }

    public void setImageURI(String str) {
        setImageURI(str, null);
    }

    public void setImageURI(Uri uri, Object obj) {
        setController(this.mControllerBuilder.setCallerContext(obj).setUri(uri).setOldController(getController()).build());
    }

    public void setImageURI(String str, Object obj) {
        setImageURI(str != null ? Uri.parse(str) : null, obj);
    }

    public void setActualImageResource(int i) {
        setActualImageResource(i, null);
    }

    public void setActualImageResource(int i, Object obj) {
        setImageURI(UriUtil.getUriForResourceId(i), obj);
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
    }
}
