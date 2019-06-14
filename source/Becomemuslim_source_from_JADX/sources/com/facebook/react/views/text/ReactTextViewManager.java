package com.facebook.react.views.text;

import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;

@ReactModule(name = "RCTText")
public class ReactTextViewManager extends ReactTextAnchorViewManager<ReactTextView, ReactTextShadowNode> {
    @VisibleForTesting
    public static final String REACT_CLASS = "RCTText";

    public String getName() {
        return REACT_CLASS;
    }

    public ReactTextView createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactTextView(themedReactContext);
    }

    public void updateExtraData(ReactTextView reactTextView, Object obj) {
        ReactTextUpdate reactTextUpdate = (ReactTextUpdate) obj;
        if (reactTextUpdate.containsImages()) {
            TextInlineImageSpan.possiblyUpdateInlineImageSpans(reactTextUpdate.getText(), reactTextView);
        }
        reactTextView.setText(reactTextUpdate);
    }

    public ReactTextShadowNode createShadowNodeInstance() {
        return new ReactTextShadowNode();
    }

    public Class<ReactTextShadowNode> getShadowNodeClass() {
        return ReactTextShadowNode.class;
    }

    protected void onAfterUpdateTransaction(ReactTextView reactTextView) {
        super.onAfterUpdateTransaction(reactTextView);
        reactTextView.updateView();
    }
}
