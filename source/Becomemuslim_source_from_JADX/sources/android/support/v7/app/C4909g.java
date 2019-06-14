package android.support.v7.app;

import android.content.Context;
import android.support.v7.app.C4478j.C0617d;
import android.support.v7.app.C4894i.C4832a;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import android.view.Window.Callback;
import java.util.List;

/* compiled from: AppCompatDelegateImplN */
/* renamed from: android.support.v7.app.g */
class C4909g extends C4894i {

    /* compiled from: AppCompatDelegateImplN */
    /* renamed from: android.support.v7.app.g$a */
    class C4893a extends C4832a {
        /* renamed from: b */
        final /* synthetic */ C4909g f14021b;

        C4893a(C4909g c4909g, Callback callback) {
            this.f14021b = c4909g;
            super(c4909g, callback);
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            C0617d a = this.f14021b.m15010a(0, true);
            if (a == null || a.f1581j == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, a.f1581j, i);
            }
        }
    }

    C4909g(Context context, Window window, C0610d c0610d) {
        super(context, window, c0610d);
    }

    /* renamed from: a */
    Callback mo3336a(Callback callback) {
        return new C4893a(this, callback);
    }
}
