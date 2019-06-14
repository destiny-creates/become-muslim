package com.facebook.react.views.text.frescosupport;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.ReactTextInlineImageShadowNode;
import com.facebook.react.views.text.TextInlineImageSpan;
import java.util.Locale;

public class FrescoBasedReactTextInlineImageShadowNode extends ReactTextInlineImageShadowNode {
    private final Object mCallerContext;
    private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    private ReadableMap mHeaders;
    private float mHeight = 1.0E21f;
    private int mTintColor = 0;
    private Uri mUri;
    private float mWidth = 1.0E21f;

    public boolean isVirtual() {
        return true;
    }

    public FrescoBasedReactTextInlineImageShadowNode(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Object obj) {
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mCallerContext = obj;
    }

    private FrescoBasedReactTextInlineImageShadowNode(FrescoBasedReactTextInlineImageShadowNode frescoBasedReactTextInlineImageShadowNode) {
        super(frescoBasedReactTextInlineImageShadowNode);
        this.mHeaders = frescoBasedReactTextInlineImageShadowNode.mHeaders;
        this.mWidth = frescoBasedReactTextInlineImageShadowNode.mWidth;
        this.mHeight = frescoBasedReactTextInlineImageShadowNode.mHeight;
        this.mTintColor = frescoBasedReactTextInlineImageShadowNode.mTintColor;
        this.mDraweeControllerBuilder = frescoBasedReactTextInlineImageShadowNode.mDraweeControllerBuilder;
        this.mCallerContext = frescoBasedReactTextInlineImageShadowNode.mCallerContext;
        this.mUri = frescoBasedReactTextInlineImageShadowNode.mUri;
    }

    protected FrescoBasedReactTextInlineImageShadowNode copy() {
        return new FrescoBasedReactTextInlineImageShadowNode(this);
    }

    @com.facebook.react.uimanager.annotations.ReactProp(name = "src")
    public void setSource(com.facebook.react.bridge.ReadableArray r4) {
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
        r3 = this;
        r0 = 0;
        if (r4 == 0) goto L_0x0016;
    L_0x0003:
        r1 = r4.size();
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0016;
    L_0x000a:
        r1 = 0;
        r4 = r4.getMap(r1);
        r1 = "uri";
        r4 = r4.getString(r1);
        goto L_0x0017;
    L_0x0016:
        r4 = r0;
    L_0x0017:
        if (r4 == 0) goto L_0x002f;
    L_0x0019:
        r1 = android.net.Uri.parse(r4);	 Catch:{ Exception -> 0x0025 }
        r2 = r1.getScheme();	 Catch:{ Exception -> 0x0024 }
        if (r2 != 0) goto L_0x0024;
    L_0x0023:
        goto L_0x0025;
    L_0x0024:
        r0 = r1;
    L_0x0025:
        if (r0 != 0) goto L_0x002f;
    L_0x0027:
        r0 = r3.getThemedContext();
        r0 = getResourceDrawableUri(r0, r4);
    L_0x002f:
        r4 = r3.mUri;
        if (r0 == r4) goto L_0x0036;
    L_0x0033:
        r3.markUpdated();
    L_0x0036:
        r3.mUri = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageShadowNode.setSource(com.facebook.react.bridge.ReadableArray):void");
    }

    @ReactProp(name = "headers")
    public void setHeaders(ReadableMap readableMap) {
        this.mHeaders = readableMap;
    }

    @ReactProp(name = "tintColor")
    public void setTintColor(int i) {
        this.mTintColor = i;
    }

    public void setWidth(Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Number) {
            this.mWidth = (float) dynamic.asDouble();
            return;
        }
        throw new JSApplicationIllegalArgumentException("Inline images must not have percentage based width");
    }

    public void setHeight(Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.Number) {
            this.mHeight = (float) dynamic.asDouble();
            return;
        }
        throw new JSApplicationIllegalArgumentException("Inline images must not have percentage based height");
    }

    public Uri getUri() {
        return this.mUri;
    }

    public ReadableMap getHeaders() {
        return this.mHeaders;
    }

    private static Uri getResourceDrawableUri(Context context, String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                return new Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(context.getResources().getIdentifier(str.toLowerCase(Locale.getDefault()).replace("-", "_"), "drawable", context.getPackageName()))).build();
            }
        }
        return null;
    }

    public TextInlineImageSpan buildInlineImageSpan() {
        return new FrescoBasedReactTextInlineImageSpan(getThemedContext().getResources(), (int) Math.ceil((double) this.mHeight), (int) Math.ceil((double) this.mWidth), this.mTintColor, getUri(), getHeaders(), getDraweeControllerBuilder(), getCallerContext());
    }

    public AbstractDraweeControllerBuilder getDraweeControllerBuilder() {
        return this.mDraweeControllerBuilder;
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }
}
