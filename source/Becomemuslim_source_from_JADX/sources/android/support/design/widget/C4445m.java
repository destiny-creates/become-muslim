package android.support.design.widget;

import android.content.Context;
import android.support.v7.widget.C3326n;
import android.support.v7.widget.bz;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* compiled from: TextInputEditText */
/* renamed from: android.support.design.widget.m */
public class C4445m extends C3326n {
    public C4445m(Context context) {
        super(context);
    }

    public C4445m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C4445m(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
                if (parent instanceof bz) {
                    editorInfo.hintText = ((bz) parent).getHint();
                    break;
                }
            }
        }
        return onCreateInputConnection;
    }
}
