package com.facebook.react.views.modal;

import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;

class ModalHostShadowNode extends LayoutShadowNode {
    private ModalHostShadowNode(ModalHostShadowNode modalHostShadowNode) {
        super(modalHostShadowNode);
    }

    protected ModalHostShadowNode copy() {
        return new ModalHostShadowNode(this);
    }

    public void addChildAt(ReactShadowNodeImpl reactShadowNodeImpl, int i) {
        super.addChildAt(reactShadowNodeImpl, i);
        i = ModalHostHelper.getModalHostSize(getThemedContext());
        reactShadowNodeImpl.setStyleWidth((float) i.x);
        reactShadowNodeImpl.setStyleHeight((float) i.y);
    }
}
