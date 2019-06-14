package com.facebook.react.views.text;

public class ReactVirtualTextShadowNode extends ReactBaseTextShadowNode {
    public boolean isVirtual() {
        return true;
    }

    private ReactVirtualTextShadowNode(ReactVirtualTextShadowNode reactVirtualTextShadowNode) {
        super(reactVirtualTextShadowNode);
    }

    protected ReactVirtualTextShadowNode copy() {
        return new ReactVirtualTextShadowNode(this);
    }
}
