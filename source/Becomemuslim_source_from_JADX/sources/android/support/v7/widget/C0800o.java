package android.support.v7.widget;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* compiled from: AppCompatHintHelper */
/* renamed from: android.support.v7.widget.o */
class C0800o {
    /* renamed from: a */
    static InputConnection m2920a(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            for (view = view.getParent(); view instanceof View; view = view.getParent()) {
                if (view instanceof bz) {
                    editorInfo.hintText = ((bz) view).getHint();
                    break;
                }
            }
        }
        return inputConnection;
    }
}
