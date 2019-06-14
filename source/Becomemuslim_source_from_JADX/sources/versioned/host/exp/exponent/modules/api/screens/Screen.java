package versioned.host.exp.exponent.modules.api.screens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.C3178i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;

public class Screen extends ViewGroup implements ReactPointerEventsView {
    private boolean mActive;
    private ScreenContainer mContainer;
    private final C3178i mFragment = new ScreenFragment(this);
    private boolean mTransitioning;

    public static class ScreenFragment extends C3178i {
        private Screen mScreenView;

        public ScreenFragment() {
            throw new IllegalStateException("Screen fragments should never be restored");
        }

        @SuppressLint({"ValidFragment"})
        public ScreenFragment(Screen screen) {
            this.mScreenView = screen;
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return this.mScreenView;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void setLayerType(int i, Paint paint) {
    }

    public void setNeedsOffscreenAlphaCompositing(boolean z) {
    }

    public Screen(Context context) {
        super(context);
    }

    public void setTransitioning(boolean z) {
        if (this.mTransitioning != z) {
            this.mTransitioning = z;
            super.setLayerType(z ? true : false, null);
        }
    }

    public boolean hasOverlappingRendering() {
        return this.mTransitioning;
    }

    public PointerEvents getPointerEvents() {
        return this.mTransitioning ? PointerEvents.NONE : PointerEvents.AUTO;
    }

    protected void setContainer(ScreenContainer screenContainer) {
        this.mContainer = screenContainer;
    }

    protected ScreenContainer getContainer() {
        return this.mContainer;
    }

    protected C3178i getFragment() {
        return this.mFragment;
    }

    public void setActive(boolean z) {
        if (z != this.mActive) {
            this.mActive = z;
            if (this.mContainer) {
                this.mContainer.notifyChildUpdate();
            }
        }
    }

    public boolean isActive() {
        return this.mActive;
    }
}
