package versioned.host.exp.exponent.modules.api.screens;

import android.arch.lifecycle.C0074c;
import android.arch.lifecycle.C0075d;
import android.support.v4.app.C3178i;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import java.util.HashMap;
import java.util.Map;

public class LifecycleHelper {
    private OnLayoutChangeListener mRegisterOnLayoutChange = new C67531();
    private Map<View, C0074c> mViewToLifecycleMap = new HashMap();

    /* renamed from: versioned.host.exp.exponent.modules.api.screens.LifecycleHelper$1 */
    class C67531 implements OnLayoutChangeListener {
        C67531() {
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LifecycleHelper.this.registerViewWithLifecycleOwner(view);
            view.removeOnLayoutChangeListener(this);
        }
    }

    public static C3178i findNearestScreenFragmentAncestor(View view) {
        view = view.getParent();
        while (view != null && !(view instanceof Screen)) {
            view = view.getParent();
        }
        return view != null ? ((Screen) view).getFragment() : null;
    }

    private void registerViewWithLifecycleOwner(View view) {
        C3178i findNearestScreenFragmentAncestor = findNearestScreenFragmentAncestor(view);
        if (findNearestScreenFragmentAncestor != null && (view instanceof C0075d)) {
            C0074c lifecycle = findNearestScreenFragmentAncestor.getLifecycle();
            lifecycle.a((C0075d) view);
            this.mViewToLifecycleMap.put(view, lifecycle);
        }
    }

    public <T extends View & C0075d> void register(T t) {
        t.addOnLayoutChangeListener(this.mRegisterOnLayoutChange);
    }

    public <T extends View & C0075d> void unregister(T t) {
        C0074c c0074c = (C0074c) this.mViewToLifecycleMap.get(t);
        if (c0074c != null) {
            c0074c.b((C0075d) t);
        }
    }
}
