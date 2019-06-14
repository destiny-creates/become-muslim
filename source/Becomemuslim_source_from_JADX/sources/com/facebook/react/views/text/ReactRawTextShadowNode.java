package com.facebook.react.views.text;

import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ReactRawTextShadowNode extends ReactShadowNodeImpl {
    @VisibleForTesting
    public static final String PROP_TEXT = "text";
    private String mText = null;

    public boolean isVirtual() {
        return true;
    }

    private ReactRawTextShadowNode(ReactRawTextShadowNode reactRawTextShadowNode) {
        super(reactRawTextShadowNode);
        this.mText = reactRawTextShadowNode.mText;
    }

    protected ReactShadowNodeImpl copy() {
        return new ReactRawTextShadowNode(this);
    }

    @ReactProp(name = "text")
    public void setText(String str) {
        this.mText = str;
        markUpdated();
    }

    public String getText() {
        return this.mText;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getViewClass());
        stringBuilder.append(" [text: ");
        stringBuilder.append(this.mText);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
