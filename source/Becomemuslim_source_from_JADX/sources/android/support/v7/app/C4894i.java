package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.app.C4831h.C4474a;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window;

/* compiled from: AppCompatDelegateImplV23 */
/* renamed from: android.support.v7.app.i */
class C4894i extends C4831h {
    /* renamed from: t */
    private final UiModeManager f14022t;

    /* compiled from: AppCompatDelegateImplV23 */
    /* renamed from: android.support.v7.app.i$a */
    class C4832a extends C4474a {
        /* renamed from: d */
        final /* synthetic */ C4894i f13688d;

        public ActionMode onWindowStartingActionMode(Callback callback) {
            return null;
        }

        C4832a(C4894i c4894i, Window.Callback callback) {
            this.f13688d = c4894i;
            super(c4894i, callback);
        }

        public ActionMode onWindowStartingActionMode(Callback callback, int i) {
            if (this.f13688d.mo3338o()) {
                if (i == 0) {
                    return m14988a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }
    }

    C4894i(Context context, Window window, C0610d c0610d) {
        super(context, window, c0610d);
        this.f14022t = (UiModeManager) context.getSystemService("uimode");
    }

    /* renamed from: a */
    Window.Callback mo3336a(Window.Callback callback) {
        return new C4832a(this, callback);
    }

    /* renamed from: d */
    int mo3337d(int i) {
        if (i == 0 && this.f14022t.getNightMode() == 0) {
            return -1;
        }
        return super.mo3337d(i);
    }
}
