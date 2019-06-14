package com.facebook.react.views.viewpager;

import android.support.v4.view.C0513q;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0473f;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import java.util.ArrayList;
import java.util.List;

public class ReactViewPager extends ViewPager {
    private final EventDispatcher mEventDispatcher;
    private boolean mIsCurrentItemFromJs;
    private boolean mScrollEnabled = true;
    private final Runnable measureAndLayout = new C19991();

    /* renamed from: com.facebook.react.views.viewpager.ReactViewPager$1 */
    class C19991 implements Runnable {
        C19991() {
        }

        public void run() {
            ReactViewPager.this.measure(MeasureSpec.makeMeasureSpec(ReactViewPager.this.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(ReactViewPager.this.getHeight(), 1073741824));
            ReactViewPager.this.layout(ReactViewPager.this.getLeft(), ReactViewPager.this.getTop(), ReactViewPager.this.getRight(), ReactViewPager.this.getBottom());
        }
    }

    private class Adapter extends C0513q {
        private boolean mIsViewPagerInIntentionallyInconsistentState;
        private final List<View> mViews;

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private Adapter() {
            this.mViews = new ArrayList();
            this.mIsViewPagerInIntentionallyInconsistentState = null;
        }

        void addView(View view, int i) {
            this.mViews.add(i, view);
            notifyDataSetChanged();
            ReactViewPager.this.setOffscreenPageLimit(this.mViews.size());
        }

        void removeViewAt(int i) {
            this.mViews.remove(i);
            notifyDataSetChanged();
            ReactViewPager.this.setOffscreenPageLimit(this.mViews.size());
        }

        void setViews(List<View> list) {
            this.mViews.clear();
            this.mViews.addAll(list);
            notifyDataSetChanged();
            this.mIsViewPagerInIntentionallyInconsistentState = null;
        }

        void removeAllViewsFromAdapter(ViewPager viewPager) {
            this.mViews.clear();
            viewPager.removeAllViews();
            this.mIsViewPagerInIntentionallyInconsistentState = true;
        }

        View getViewAt(int i) {
            return (View) this.mViews.get(i);
        }

        public int getCount() {
            return this.mViews.size();
        }

        public int getItemPosition(Object obj) {
            if (!this.mIsViewPagerInIntentionallyInconsistentState) {
                if (this.mViews.contains(obj)) {
                    return this.mViews.indexOf(obj);
                }
            }
            return -2;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = (View) this.mViews.get(i);
            viewGroup.addView(view, 0, ReactViewPager.this.generateDefaultLayoutParams());
            return view;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    private class PageChangeListener implements C0473f {
        private PageChangeListener() {
        }

        public void onPageScrolled(int i, float f, int i2) {
            ReactViewPager.this.mEventDispatcher.dispatchEvent(new PageScrollEvent(ReactViewPager.this.getId(), i, f));
        }

        public void onPageSelected(int i) {
            if (!ReactViewPager.this.mIsCurrentItemFromJs) {
                ReactViewPager.this.mEventDispatcher.dispatchEvent(new PageSelectedEvent(ReactViewPager.this.getId(), i));
            }
        }

        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    i = "idle";
                    break;
                case 1:
                    i = "dragging";
                    break;
                case 2:
                    i = "settling";
                    break;
                default:
                    throw new IllegalStateException("Unsupported pageScrollState");
            }
            ReactViewPager.this.mEventDispatcher.dispatchEvent(new PageScrollStateChangedEvent(ReactViewPager.this.getId(), i));
        }
    }

    public ReactViewPager(ReactContext reactContext) {
        super(reactContext);
        this.mEventDispatcher = ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        this.mIsCurrentItemFromJs = null;
        setOnPageChangeListener(new PageChangeListener());
        setAdapter(new Adapter());
    }

    public Adapter getAdapter() {
        return (Adapter) super.getAdapter();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        try {
            if (super.onInterceptTouchEvent(motionEvent)) {
                NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
                return true;
            }
        } catch (MotionEvent motionEvent2) {
            Log.w(ReactConstants.TAG, "Error intercepting touch event.", motionEvent2);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mScrollEnabled) {
            return super.onTouchEvent(motionEvent);
        }
        return null;
    }

    public void setCurrentItemFromJs(int i, boolean z) {
        this.mIsCurrentItemFromJs = true;
        setCurrentItem(i, z);
        this.mIsCurrentItemFromJs = false;
    }

    public void setScrollEnabled(boolean z) {
        this.mScrollEnabled = z;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestLayout();
        post(this.measureAndLayout);
    }

    void addViewToAdapter(View view, int i) {
        getAdapter().addView(view, i);
    }

    void removeViewFromAdapter(int i) {
        getAdapter().removeViewAt(i);
    }

    int getViewCountInAdapter() {
        return getAdapter().getCount();
    }

    View getViewFromAdapter(int i) {
        return getAdapter().getViewAt(i);
    }

    public void setViews(List<View> list) {
        getAdapter().setViews(list);
    }

    public void removeAllViewsFromAdapter() {
        getAdapter().removeAllViewsFromAdapter(this);
    }
}
