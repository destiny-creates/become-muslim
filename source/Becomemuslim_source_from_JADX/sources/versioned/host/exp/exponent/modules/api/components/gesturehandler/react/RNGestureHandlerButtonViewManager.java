package versioned.host.exp.exponent.modules.api.components.gesturehandler.react;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

public class RNGestureHandlerButtonViewManager extends ViewGroupManager<ButtonViewGroup> {

    static class ButtonViewGroup extends ViewGroup {
        static TypedValue sResolveOutValue = new TypedValue();
        static ButtonViewGroup sResponder;
        int mBackgroundColor = 0;
        float mBorderRadius = 0.0f;
        boolean mNeedBackgroundUpdate = false;
        Integer mRippleColor;
        boolean mUseBorderless = false;
        boolean mUseForeground = false;

        public void dispatchDrawableHotspotChanged(float f, float f2) {
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        public ButtonViewGroup(Context context) {
            super(context);
            setClickable(true);
            setFocusable(true);
            this.mNeedBackgroundUpdate = true;
        }

        public void setBackgroundColor(int i) {
            this.mBackgroundColor = i;
            this.mNeedBackgroundUpdate = true;
        }

        public void setRippleColor(Integer num) {
            this.mRippleColor = num;
            this.mNeedBackgroundUpdate = true;
        }

        public void setBorderRadius(float f) {
            this.mBorderRadius = f * getResources().getDisplayMetrics().density;
            this.mNeedBackgroundUpdate = true;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                return true;
            }
            onTouchEvent(motionEvent);
            if (isPressed() != null) {
                return true;
            }
            return null;
        }

        private void updateBackground() {
            if (this.mNeedBackgroundUpdate) {
                this.mNeedBackgroundUpdate = false;
                if (this.mBackgroundColor == 0) {
                    setBackground(null);
                }
                if (VERSION.SDK_INT >= 23) {
                    setForeground(null);
                }
                if (this.mUseForeground && VERSION.SDK_INT >= 23) {
                    setForeground(createSelectableDrawable());
                    if (this.mBackgroundColor != 0) {
                        setBackgroundColor(this.mBackgroundColor);
                    }
                } else if (this.mBackgroundColor == 0) {
                    setBackground(createSelectableDrawable());
                } else {
                    PaintDrawable paintDrawable = new PaintDrawable(this.mBackgroundColor);
                    Drawable createSelectableDrawable = createSelectableDrawable();
                    if (this.mBorderRadius != 0.0f) {
                        paintDrawable.setCornerRadius(this.mBorderRadius);
                        if (VERSION.SDK_INT >= 21 && (createSelectableDrawable instanceof RippleDrawable)) {
                            Drawable paintDrawable2 = new PaintDrawable(-1);
                            paintDrawable2.setCornerRadius(this.mBorderRadius);
                            ((RippleDrawable) createSelectableDrawable).setDrawableByLayerId(16908334, paintDrawable2);
                        }
                    }
                    if (this.mRippleColor != null && VERSION.SDK_INT >= 21 && (createSelectableDrawable instanceof RippleDrawable)) {
                        int[][] iArr = new int[1][];
                        iArr[0] = new int[]{16842910};
                        ((RippleDrawable) createSelectableDrawable).setColor(new ColorStateList(iArr, new int[]{this.mRippleColor.intValue()}));
                    }
                    setBackground(new LayerDrawable(new Drawable[]{paintDrawable, createSelectableDrawable}));
                }
            }
        }

        public void setUseDrawableOnForeground(boolean z) {
            this.mUseForeground = z;
            this.mNeedBackgroundUpdate = true;
        }

        public void setUseBorderlessDrawable(boolean z) {
            this.mUseBorderless = z;
        }

        private Drawable createSelectableDrawable() {
            int i = VERSION.SDK_INT;
            String str = (!this.mUseBorderless || i < 21) ? "selectableItemBackground" : "selectableItemBackgroundBorderless";
            getContext().getTheme().resolveAttribute(getResources().getIdentifier(str, "attr", "android"), sResolveOutValue, true);
            if (i >= 21) {
                return getResources().getDrawable(sResolveOutValue.resourceId, getContext().getTheme());
            }
            return getResources().getDrawable(sResolveOutValue.resourceId);
        }

        public void drawableHotspotChanged(float f, float f2) {
            if (sResponder == null || sResponder == this) {
                super.drawableHotspotChanged(f, f2);
            }
        }

        public void setPressed(boolean z) {
            if (z && sResponder == null) {
                sResponder = this;
            }
            if (!z || sResponder == this) {
                super.setPressed(z);
            }
            if (!z && sResponder == this) {
                sResponder = false;
            }
        }
    }

    public String getName() {
        return "RNGestureHandlerButton";
    }

    public ButtonViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        return new ButtonViewGroup(themedReactContext);
    }

    @ReactProp(name = "foreground")
    @TargetApi(23)
    public void setForeground(ButtonViewGroup buttonViewGroup, boolean z) {
        buttonViewGroup.setUseDrawableOnForeground(z);
    }

    @ReactProp(name = "borderless")
    public void setBorderless(ButtonViewGroup buttonViewGroup, boolean z) {
        buttonViewGroup.setUseBorderlessDrawable(z);
    }

    @ReactProp(name = "enabled")
    public void setEnabled(ButtonViewGroup buttonViewGroup, boolean z) {
        buttonViewGroup.setEnabled(z);
    }

    @ReactProp(name = "borderRadius")
    public void setBorderRadius(ButtonViewGroup buttonViewGroup, float f) {
        buttonViewGroup.setBorderRadius(f);
    }

    @ReactProp(name = "rippleColor")
    public void setRippleColor(ButtonViewGroup buttonViewGroup, Integer num) {
        buttonViewGroup.setRippleColor(num);
    }

    protected void onAfterUpdateTransaction(ButtonViewGroup buttonViewGroup) {
        buttonViewGroup.updateBackground();
    }
}
