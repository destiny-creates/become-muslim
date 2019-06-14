package com.facebook.react.views.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import com.facebook.react.common.annotations.VisibleForTesting;

public class ReactPicker extends Spinner {
    private int mMode = null;
    private OnSelectListener mOnSelectListener;
    private Integer mPrimaryColor;
    private Integer mStagedSelection;
    private boolean mSuppressNextEvent;
    private final Runnable measureAndLayout = new C19841();

    /* renamed from: com.facebook.react.views.picker.ReactPicker$1 */
    class C19841 implements Runnable {
        C19841() {
        }

        public void run() {
            ReactPicker.this.measure(MeasureSpec.makeMeasureSpec(ReactPicker.this.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(ReactPicker.this.getHeight(), 1073741824));
            ReactPicker.this.layout(ReactPicker.this.getLeft(), ReactPicker.this.getTop(), ReactPicker.this.getRight(), ReactPicker.this.getBottom());
        }
    }

    /* renamed from: com.facebook.react.views.picker.ReactPicker$2 */
    class C19852 implements OnItemSelectedListener {
        C19852() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (ReactPicker.this.mSuppressNextEvent == null && ReactPicker.this.mOnSelectListener != null) {
                ReactPicker.this.mOnSelectListener.onItemSelected(i);
            }
            ReactPicker.this.mSuppressNextEvent = null;
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
            if (ReactPicker.this.mSuppressNextEvent == null && ReactPicker.this.mOnSelectListener != null) {
                ReactPicker.this.mOnSelectListener.onItemSelected(-1);
            }
            ReactPicker.this.mSuppressNextEvent = false;
        }
    }

    public interface OnSelectListener {
        void onItemSelected(int i);
    }

    public ReactPicker(Context context) {
        super(context);
    }

    public ReactPicker(Context context, int i) {
        super(context, i);
        this.mMode = i;
    }

    public ReactPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ReactPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ReactPicker(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mMode = i2;
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        if (getOnItemSelectedListener() == null) {
            this.mSuppressNextEvent = true;
            setOnItemSelectedListener(new C19852());
        }
        this.mOnSelectListener = onSelectListener;
    }

    public OnSelectListener getOnSelectListener() {
        return this.mOnSelectListener;
    }

    public void setStagedSelection(int i) {
        this.mStagedSelection = Integer.valueOf(i);
    }

    public void updateStagedSelection() {
        if (this.mStagedSelection != null) {
            setSelectionWithSuppressEvent(this.mStagedSelection.intValue());
            this.mStagedSelection = null;
        }
    }

    private void setSelectionWithSuppressEvent(int i) {
        if (i != getSelectedItemPosition()) {
            this.mSuppressNextEvent = true;
            setSelection(i);
        }
    }

    public Integer getPrimaryColor() {
        return this.mPrimaryColor;
    }

    public void setPrimaryColor(Integer num) {
        this.mPrimaryColor = num;
    }

    @VisibleForTesting
    public int getMode() {
        return this.mMode;
    }
}
