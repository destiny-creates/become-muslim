package com.facebook.react.views.picker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.picker.ReactPicker.OnSelectListener;
import com.facebook.react.views.picker.events.PickerItemSelectEvent;
import expolib_v1.com.facebook.infer.annotation.Assertions;

public abstract class ReactPickerManager extends SimpleViewManager<ReactPicker> {

    private static class ReactPickerAdapter extends ArrayAdapter<ReadableMap> {
        private final LayoutInflater mInflater;
        private Integer mPrimaryTextColor;

        public ReactPickerAdapter(Context context, ReadableMap[] readableMapArr) {
            super(context, 0, readableMapArr);
            this.mInflater = (LayoutInflater) Assertions.assertNotNull(context.getSystemService("layout_inflater"));
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getView(i, view, viewGroup, false);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return getView(i, view, viewGroup, true);
        }

        private View getView(int i, View view, ViewGroup viewGroup, boolean z) {
            ReadableMap readableMap = (ReadableMap) getItem(i);
            if (view == null) {
                view = this.mInflater.inflate(z ? 17367049 : 17367048, viewGroup, false);
            }
            TextView textView = (TextView) view;
            textView.setText(readableMap.getString("label"));
            if (!z && this.mPrimaryTextColor) {
                textView.setTextColor(this.mPrimaryTextColor.intValue());
            } else if (readableMap.hasKey(ViewProps.COLOR) && !readableMap.isNull(ViewProps.COLOR)) {
                textView.setTextColor(readableMap.getInt(ViewProps.COLOR));
            }
            return view;
        }

        public void setPrimaryTextColor(Integer num) {
            this.mPrimaryTextColor = num;
            notifyDataSetChanged();
        }
    }

    private static class PickerEventEmitter implements OnSelectListener {
        private final EventDispatcher mEventDispatcher;
        private final ReactPicker mReactPicker;

        public PickerEventEmitter(ReactPicker reactPicker, EventDispatcher eventDispatcher) {
            this.mReactPicker = reactPicker;
            this.mEventDispatcher = eventDispatcher;
        }

        public void onItemSelected(int i) {
            this.mEventDispatcher.dispatchEvent(new PickerItemSelectEvent(this.mReactPicker.getId(), i));
        }
    }

    @ReactProp(name = "items")
    public void setItems(ReactPicker reactPicker, ReadableArray readableArray) {
        if (readableArray != null) {
            ReadableMap[] readableMapArr = new ReadableMap[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                readableMapArr[i] = readableArray.getMap(i);
            }
            readableArray = new ReactPickerAdapter(reactPicker.getContext(), readableMapArr);
            readableArray.setPrimaryTextColor(reactPicker.getPrimaryColor());
            reactPicker.setAdapter(readableArray);
            return;
        }
        reactPicker.setAdapter(null);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ReactPicker reactPicker, Integer num) {
        reactPicker.setPrimaryColor(num);
        ReactPickerAdapter reactPickerAdapter = (ReactPickerAdapter) reactPicker.getAdapter();
        if (reactPickerAdapter != null) {
            reactPickerAdapter.setPrimaryTextColor(num);
        }
    }

    @ReactProp(name = "prompt")
    public void setPrompt(ReactPicker reactPicker, String str) {
        reactPicker.setPrompt(str);
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactPicker reactPicker, boolean z) {
        reactPicker.setEnabled(z);
    }

    @ReactProp(name = "selected")
    public void setSelected(ReactPicker reactPicker, int i) {
        reactPicker.setStagedSelection(i);
    }

    protected void onAfterUpdateTransaction(ReactPicker reactPicker) {
        super.onAfterUpdateTransaction(reactPicker);
        reactPicker.updateStagedSelection();
    }

    protected void addEventEmitters(ThemedReactContext themedReactContext, ReactPicker reactPicker) {
        reactPicker.setOnSelectListener(new PickerEventEmitter(reactPicker, ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher()));
    }
}
