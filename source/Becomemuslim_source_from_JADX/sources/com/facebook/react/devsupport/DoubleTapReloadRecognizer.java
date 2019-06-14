package com.facebook.react.devsupport;

import android.os.Handler;
import android.view.View;
import android.widget.EditText;

public class DoubleTapReloadRecognizer {
    private static final long DOUBLE_TAP_DELAY = 200;
    private boolean mDoRefresh = false;

    /* renamed from: com.facebook.react.devsupport.DoubleTapReloadRecognizer$1 */
    class C19161 implements Runnable {
        C19161() {
        }

        public void run() {
            DoubleTapReloadRecognizer.this.mDoRefresh = false;
        }
    }

    public boolean didDoubleTapR(int i, View view) {
        if (i == 46 && (view instanceof EditText) == 0) {
            if (this.mDoRefresh != 0) {
                this.mDoRefresh = false;
                return true;
            }
            this.mDoRefresh = true;
            new Handler().postDelayed(new C19161(), DOUBLE_TAP_DELAY);
        }
        return false;
    }
}
