package com.facebook.react.views.textinput;

import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.Utility;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.facebook.react.views.text.DefaultStyleValuesUtil;
import com.facebook.react.views.text.ReactFontManager;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.TextInlineImageSpan;
import com.facebook.stetho.server.http.HttpStatus;
import com.facebook.yoga.YogaConstants;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.LinkedList;
import java.util.Map;

@ReactModule(name = "AndroidTextInput")
public class ReactTextInputManager extends BaseViewManager<ReactEditText, LayoutShadowNode> {
    private static final int BLUR_TEXT_INPUT = 2;
    private static final InputFilter[] EMPTY_FILTERS = new InputFilter[0];
    private static final int FOCUS_TEXT_INPUT = 1;
    private static final int IME_ACTION_ID = 1648;
    private static final int INPUT_TYPE_KEYBOARD_DECIMAL_PAD = 8194;
    private static final int INPUT_TYPE_KEYBOARD_NUMBERED = 12290;
    private static final int INPUT_TYPE_KEYBOARD_NUMBER_PAD = 2;
    private static final String KEYBOARD_TYPE_DECIMAL_PAD = "decimal-pad";
    private static final String KEYBOARD_TYPE_EMAIL_ADDRESS = "email-address";
    private static final int KEYBOARD_TYPE_FLAGS = 12339;
    private static final String KEYBOARD_TYPE_NUMBER_PAD = "number-pad";
    private static final String KEYBOARD_TYPE_NUMERIC = "numeric";
    private static final String KEYBOARD_TYPE_PHONE_PAD = "phone-pad";
    private static final String KEYBOARD_TYPE_VISIBLE_PASSWORD = "visible-password";
    private static final int PASSWORD_VISIBILITY_FLAG = 16;
    protected static final String REACT_CLASS = "AndroidTextInput";
    private static final int[] SPACING_TYPES = new int[]{8, 0, 2, 1, 3};
    private static final int UNSET = -1;

    private class ReactTextInputTextWatcher implements TextWatcher {
        private ReactEditText mEditText;
        private EventDispatcher mEventDispatcher;
        private String mPreviousText = null;

        public void afterTextChanged(Editable editable) {
        }

        public ReactTextInputTextWatcher(ReactContext reactContext, ReactEditText reactEditText) {
            this.mEventDispatcher = ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
            this.mEditText = reactEditText;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mPreviousText = charSequence.toString();
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i3 != 0 || i2 != 0) {
                Assertions.assertNotNull(this.mPreviousText);
                String substring = charSequence.toString().substring(i, i + i3);
                int i4 = i + i2;
                String substring2 = this.mPreviousText.substring(i, i4);
                if (i3 != i2 || substring.equals(substring2) == 0) {
                    this.mEventDispatcher.dispatchEvent(new ReactTextChangedEvent(this.mEditText.getId(), charSequence.toString(), this.mEditText.incrementAndGetEventCounter()));
                    this.mEventDispatcher.dispatchEvent(new ReactTextInputEvent(this.mEditText.getId(), substring, substring2, i, i4));
                }
            }
        }
    }

    private class ReactContentSizeWatcher implements ContentSizeWatcher {
        private ReactEditText mEditText;
        private EventDispatcher mEventDispatcher;
        private int mPreviousContentHeight = 0;
        private int mPreviousContentWidth = 0;

        public ReactContentSizeWatcher(ReactEditText reactEditText) {
            this.mEditText = reactEditText;
            this.mEventDispatcher = ((UIManagerModule) ((ReactContext) reactEditText.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }

        public void onLayout() {
            int width = this.mEditText.getWidth();
            int height = this.mEditText.getHeight();
            if (this.mEditText.getLayout() != null) {
                width = (this.mEditText.getCompoundPaddingLeft() + this.mEditText.getLayout().getWidth()) + this.mEditText.getCompoundPaddingRight();
                height = (this.mEditText.getCompoundPaddingTop() + this.mEditText.getLayout().getHeight()) + this.mEditText.getCompoundPaddingBottom();
            }
            if (width != this.mPreviousContentWidth || height != this.mPreviousContentHeight) {
                this.mPreviousContentHeight = height;
                this.mPreviousContentWidth = width;
                this.mEventDispatcher.dispatchEvent(new ReactContentSizeChangedEvent(this.mEditText.getId(), PixelUtil.toDIPFromPixel((float) width), PixelUtil.toDIPFromPixel((float) height)));
            }
        }
    }

    private class ReactScrollWatcher implements ScrollWatcher {
        private EventDispatcher mEventDispatcher;
        private int mPreviousHoriz;
        private int mPreviousVert;
        private ReactEditText mReactEditText;

        public ReactScrollWatcher(ReactEditText reactEditText) {
            this.mReactEditText = reactEditText;
            this.mEventDispatcher = ((UIManagerModule) ((ReactContext) reactEditText.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }

        public void onScrollChanged(int i, int i2, int i3, int i4) {
            if (this.mPreviousHoriz != i || this.mPreviousVert != i2) {
                this.mEventDispatcher.dispatchEvent(ScrollEvent.obtain(this.mReactEditText.getId(), ScrollEventType.SCROLL, i, i2, 0.0f, 0.0f, 0, 0, this.mReactEditText.getWidth(), this.mReactEditText.getHeight()));
                this.mPreviousHoriz = i;
                this.mPreviousVert = i2;
            }
        }
    }

    private class ReactSelectionWatcher implements SelectionWatcher {
        private EventDispatcher mEventDispatcher;
        private int mPreviousSelectionEnd;
        private int mPreviousSelectionStart;
        private ReactEditText mReactEditText;

        public ReactSelectionWatcher(ReactEditText reactEditText) {
            this.mReactEditText = reactEditText;
            this.mEventDispatcher = ((UIManagerModule) ((ReactContext) reactEditText.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }

        public void onSelectionChanged(int i, int i2) {
            if (this.mPreviousSelectionStart != i || this.mPreviousSelectionEnd != i2) {
                this.mEventDispatcher.dispatchEvent(new ReactTextInputSelectionEvent(this.mReactEditText.getId(), i, i2));
                this.mPreviousSelectionStart = i;
                this.mPreviousSelectionEnd = i2;
            }
        }
    }

    public String getName() {
        return REACT_CLASS;
    }

    public ReactEditText createViewInstance(ThemedReactContext themedReactContext) {
        ReactEditText reactEditText = new ReactEditText(themedReactContext);
        reactEditText.setInputType(reactEditText.getInputType() & -131073);
        reactEditText.setReturnKeyType("done");
        reactEditText.setTextSize(0, (float) ((int) Math.ceil((double) PixelUtil.toPixelFromSP(14.0f))));
        return reactEditText;
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new ReactTextInputShadowNode();
    }

    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return ReactTextInputShadowNode.class;
    }

    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put("topSubmitEditing", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onSubmitEditing", "captured", "onSubmitEditingCapture"))).put("topEndEditing", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onEndEditing", "captured", "onEndEditingCapture"))).put(ReactTextInputEvent.EVENT_NAME, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onTextInput", "captured", "onTextInputCapture"))).put("topFocus", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onFocus", "captured", "onFocusCapture"))).put("topBlur", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onBlur", "captured", "onBlurCapture"))).put(ReactTextInputKeyPressEvent.EVENT_NAME, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onKeyPress", "captured", "onKeyPressCapture"))).build();
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put(ScrollEventType.SCROLL.getJSEventName(), MapBuilder.of("registrationName", "onScroll")).build();
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("focusTextInput", Integer.valueOf(1), "blurTextInput", Integer.valueOf(2));
    }

    public void receiveCommand(ReactEditText reactEditText, int i, ReadableArray readableArray) {
        switch (i) {
            case 1:
                reactEditText.requestFocusFromJS();
                return;
            case 2:
                reactEditText.clearFocusFromJS();
                return;
            default:
                return;
        }
    }

    public void updateExtraData(ReactEditText reactEditText, Object obj) {
        if (obj instanceof ReactTextUpdate) {
            ReactTextUpdate reactTextUpdate = (ReactTextUpdate) obj;
            reactEditText.setPadding((int) reactTextUpdate.getPaddingLeft(), (int) reactTextUpdate.getPaddingTop(), (int) reactTextUpdate.getPaddingRight(), (int) reactTextUpdate.getPaddingBottom());
            if (reactTextUpdate.containsImages()) {
                TextInlineImageSpan.possiblyUpdateInlineImageSpans(reactTextUpdate.getText(), reactEditText);
            }
            reactEditText.maybeSetText(reactTextUpdate);
        }
    }

    @ReactProp(defaultFloat = 14.0f, name = "fontSize")
    public void setFontSize(ReactEditText reactEditText, float f) {
        reactEditText.setTextSize(0, (float) ((int) Math.ceil((double) PixelUtil.toPixelFromSP(f))));
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(ReactEditText reactEditText, String str) {
        reactEditText.setTypeface(ReactFontManager.getInstance().getTypeface(str, reactEditText.getTypeface() != null ? reactEditText.getTypeface().getStyle() : 0, reactEditText.getContext().getAssets()));
    }

    @ReactProp(name = "fontWeight")
    public void setFontWeight(ReactEditText reactEditText, String str) {
        int i = -1;
        int parseNumericFontWeight = str != null ? parseNumericFontWeight(str) : -1;
        if (parseNumericFontWeight < HttpStatus.HTTP_INTERNAL_SERVER_ERROR) {
            if (!"bold".equals(str)) {
                if ("normal".equals(str) != null || (parseNumericFontWeight != -1 && parseNumericFontWeight < HttpStatus.HTTP_INTERNAL_SERVER_ERROR)) {
                    i = 0;
                }
                str = reactEditText.getTypeface();
                if (str == null) {
                    str = Typeface.DEFAULT;
                }
                if (i != str.getStyle()) {
                    reactEditText.setTypeface(str, i);
                }
            }
        }
        i = 1;
        str = reactEditText.getTypeface();
        if (str == null) {
            str = Typeface.DEFAULT;
        }
        if (i != str.getStyle()) {
            reactEditText.setTypeface(str, i);
        }
    }

    @ReactProp(name = "fontStyle")
    public void setFontStyle(ReactEditText reactEditText, String str) {
        str = "italic".equals(str) ? 2 : "normal".equals(str) != null ? null : -1;
        Typeface typeface = reactEditText.getTypeface();
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        if (str != typeface.getStyle()) {
            reactEditText.setTypeface(typeface, str);
        }
    }

    @ReactProp(name = "selection")
    public void setSelection(ReactEditText reactEditText, ReadableMap readableMap) {
        if (readableMap != null && readableMap.hasKey(ViewProps.START) && readableMap.hasKey(ViewProps.END)) {
            reactEditText.setSelection(readableMap.getInt(ViewProps.START), readableMap.getInt(ViewProps.END));
        }
    }

    @ReactProp(defaultBoolean = false, name = "onSelectionChange")
    public void setOnSelectionChange(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setSelectionWatcher(new ReactSelectionWatcher(reactEditText));
        } else {
            reactEditText.setSelectionWatcher(false);
        }
    }

    @ReactProp(name = "blurOnSubmit")
    public void setBlurOnSubmit(ReactEditText reactEditText, Boolean bool) {
        reactEditText.setBlurOnSubmit(bool);
    }

    @ReactProp(defaultBoolean = false, name = "onContentSizeChange")
    public void setOnContentSizeChange(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setContentSizeWatcher(new ReactContentSizeWatcher(reactEditText));
        } else {
            reactEditText.setContentSizeWatcher(false);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onScroll")
    public void setOnScroll(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setScrollWatcher(new ReactScrollWatcher(reactEditText));
        } else {
            reactEditText.setScrollWatcher(false);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onKeyPress")
    public void setOnKeyPress(ReactEditText reactEditText, boolean z) {
        reactEditText.setOnKeyPress(z);
    }

    @ReactProp(defaultFloat = 0.0f, name = "letterSpacing")
    public void setLetterSpacing(ReactEditText reactEditText, float f) {
        reactEditText.setLetterSpacingPt(f);
    }

    @ReactProp(name = "placeholder")
    public void setPlaceholder(ReactEditText reactEditText, String str) {
        reactEditText.setHint(str);
    }

    @ReactProp(customType = "Color", name = "placeholderTextColor")
    public void setPlaceholderTextColor(ReactEditText reactEditText, Integer num) {
        if (num == null) {
            reactEditText.setHintTextColor(DefaultStyleValuesUtil.getDefaultTextColorHint(reactEditText.getContext()));
        } else {
            reactEditText.setHintTextColor(num.intValue());
        }
    }

    @ReactProp(customType = "Color", name = "selectionColor")
    public void setSelectionColor(ReactEditText reactEditText, Integer num) {
        if (num == null) {
            reactEditText.setHighlightColor(DefaultStyleValuesUtil.getDefaultTextColorHighlight(reactEditText.getContext()));
        } else {
            reactEditText.setHighlightColor(num.intValue());
        }
        setCursorColor(reactEditText, num);
    }

    private void setCursorColor(com.facebook.react.views.textinput.ReactEditText r4, java.lang.Integer r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = android.widget.TextView.class;	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r1 = "mCursorDrawableRes";	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r0 = r0.getDeclaredField(r1);	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r1 = 1;	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r0 = r0.getInt(r4);	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        if (r0 != 0) goto L_0x0013;	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
    L_0x0012:
        return;	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
    L_0x0013:
        r2 = r4.getContext();	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r0 = android.support.v4.content.C0366b.m1103a(r2, r0);	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        if (r5 == 0) goto L_0x0026;	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
    L_0x001d:
        r5 = r5.intValue();	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r2 = android.graphics.PorterDuff.Mode.SRC_IN;	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r0.setColorFilter(r5, r2);	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
    L_0x0026:
        r5 = 2;	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r5 = new android.graphics.drawable.Drawable[r5];	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r2 = 0;	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r5[r2] = r0;	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r5[r1] = r0;	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r0 = android.widget.TextView.class;	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r2 = "mEditor";	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r0 = r0.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r4 = r0.get(r4);	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r0 = r4.getClass();	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r2 = "mCursorDrawable";	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r0 = r0.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
        r0.set(r4, r5);	 Catch:{ NoSuchFieldException -> 0x004d, NoSuchFieldException -> 0x004d }
    L_0x004d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.textinput.ReactTextInputManager.setCursorColor(com.facebook.react.views.textinput.ReactEditText, java.lang.Integer):void");
    }

    @ReactProp(defaultBoolean = false, name = "caretHidden")
    public void setCaretHidden(ReactEditText reactEditText, boolean z) {
        reactEditText.setCursorVisible(z ^ 1);
    }

    @ReactProp(defaultBoolean = false, name = "contextMenuHidden")
    public void setContextMenuHidden(ReactEditText reactEditText, final boolean z) {
        reactEditText.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View view) {
                return z;
            }
        });
    }

    @ReactProp(defaultBoolean = false, name = "selectTextOnFocus")
    public void setSelectTextOnFocus(ReactEditText reactEditText, boolean z) {
        reactEditText.setSelectAllOnFocus(z);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ReactEditText reactEditText, Integer num) {
        if (num == null) {
            reactEditText.setTextColor(DefaultStyleValuesUtil.getDefaultTextColor(reactEditText.getContext()));
        } else {
            reactEditText.setTextColor(num.intValue());
        }
    }

    @ReactProp(customType = "Color", name = "underlineColorAndroid")
    public void setUnderlineColor(ReactEditText reactEditText, Integer num) {
        reactEditText = reactEditText.getBackground();
        if (reactEditText.getConstantState() != null) {
            reactEditText = reactEditText.mutate();
        }
        if (num == null) {
            reactEditText.clearColorFilter();
        } else {
            reactEditText.setColorFilter(num.intValue(), Mode.SRC_IN);
        }
    }

    @ReactProp(name = "textAlign")
    public void setTextAlign(ReactEditText reactEditText, String str) {
        if (str != null) {
            if (!"auto".equals(str)) {
                if (ViewProps.LEFT.equals(str)) {
                    reactEditText.setGravityHorizontal(3);
                    return;
                } else if (ViewProps.RIGHT.equals(str)) {
                    reactEditText.setGravityHorizontal(5);
                    return;
                } else if ("center".equals(str)) {
                    reactEditText.setGravityHorizontal(1);
                    return;
                } else if ("justify".equals(str)) {
                    reactEditText.setGravityHorizontal(3);
                    return;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid textAlign: ");
                    stringBuilder.append(str);
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
                }
            }
        }
        reactEditText.setGravityHorizontal(null);
    }

    @ReactProp(name = "textAlignVertical")
    public void setTextAlignVertical(ReactEditText reactEditText, String str) {
        if (str != null) {
            if (!"auto".equals(str)) {
                if (ViewProps.TOP.equals(str)) {
                    reactEditText.setGravityVertical(48);
                    return;
                } else if (ViewProps.BOTTOM.equals(str)) {
                    reactEditText.setGravityVertical(80);
                    return;
                } else if ("center".equals(str)) {
                    reactEditText.setGravityVertical(16);
                    return;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid textAlignVertical: ");
                    stringBuilder.append(str);
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
                }
            }
        }
        reactEditText.setGravityVertical(null);
    }

    @ReactProp(name = "inlineImageLeft")
    public void setInlineImageLeft(ReactEditText reactEditText, String str) {
        reactEditText.setCompoundDrawablesWithIntrinsicBounds(ResourceDrawableIdHelper.getInstance().getResourceDrawableId(reactEditText.getContext(), str), 0, 0, 0);
    }

    @ReactProp(name = "inlineImagePadding")
    public void setInlineImagePadding(ReactEditText reactEditText, int i) {
        reactEditText.setCompoundDrawablePadding(i);
    }

    @ReactProp(defaultBoolean = true, name = "editable")
    public void setEditable(ReactEditText reactEditText, boolean z) {
        reactEditText.setEnabled(z);
    }

    @ReactProp(defaultInt = 1, name = "numberOfLines")
    public void setNumLines(ReactEditText reactEditText, int i) {
        reactEditText.setLines(i);
    }

    @ReactProp(name = "maxLength")
    public void setMaxLength(ReactEditText reactEditText, Integer num) {
        Object filters = reactEditText.getFilters();
        InputFilter[] inputFilterArr = EMPTY_FILTERS;
        int i = 0;
        if (num == null) {
            if (filters.length > null) {
                num = new LinkedList();
                while (i < filters.length) {
                    if (!(filters[i] instanceof LengthFilter)) {
                        num.add(filters[i]);
                    }
                    i++;
                }
                if (!num.isEmpty()) {
                    inputFilterArr = (InputFilter[]) num.toArray(new InputFilter[num.size()]);
                }
            }
        } else if (filters.length > 0) {
            Object obj = null;
            for (int i2 = 0; i2 < filters.length; i2++) {
                if (filters[i2] instanceof LengthFilter) {
                    filters[i2] = new LengthFilter(num.intValue());
                    obj = 1;
                }
            }
            if (obj == null) {
                inputFilterArr = new InputFilter[(filters.length + 1)];
                System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
                filters[filters.length] = new LengthFilter(num.intValue());
            } else {
                inputFilterArr = filters;
            }
        } else {
            inputFilterArr = new InputFilter[]{new LengthFilter(num.intValue())};
        }
        reactEditText.setFilters(inputFilterArr);
    }

    @ReactProp(name = "autoCorrect")
    public void setAutoCorrect(ReactEditText reactEditText, Boolean bool) {
        bool = bool != null ? bool.booleanValue() != null ? 32768 : 524288 : null;
        updateStagedInputTypeFlag(reactEditText, 557056, bool);
    }

    @ReactProp(defaultBoolean = false, name = "multiline")
    public void setMultiline(ReactEditText reactEditText, boolean z) {
        int i = 131072;
        int i2 = z ? 0 : 131072;
        if (!z) {
            i = 0;
        }
        updateStagedInputTypeFlag(reactEditText, i2, i);
    }

    @ReactProp(defaultBoolean = false, name = "secureTextEntry")
    public void setSecureTextEntry(ReactEditText reactEditText, boolean z) {
        int i = 0;
        int i2 = z ? 0 : 144;
        if (z) {
            i = 128;
        }
        updateStagedInputTypeFlag(reactEditText, i2, i);
        checkPasswordType(reactEditText);
    }

    @ReactProp(name = "autoCapitalize")
    public void setAutoCapitalize(ReactEditText reactEditText, int i) {
        updateStagedInputTypeFlag(reactEditText, 28672, i);
    }

    @ReactProp(name = "keyboardType")
    public void setKeyboardType(ReactEditText reactEditText, String str) {
        str = KEYBOARD_TYPE_NUMERIC.equalsIgnoreCase(str) ? INPUT_TYPE_KEYBOARD_NUMBERED : KEYBOARD_TYPE_NUMBER_PAD.equalsIgnoreCase(str) ? 2 : KEYBOARD_TYPE_DECIMAL_PAD.equalsIgnoreCase(str) ? INPUT_TYPE_KEYBOARD_DECIMAL_PAD : KEYBOARD_TYPE_EMAIL_ADDRESS.equalsIgnoreCase(str) ? 33 : KEYBOARD_TYPE_PHONE_PAD.equalsIgnoreCase(str) ? 3 : KEYBOARD_TYPE_VISIBLE_PASSWORD.equalsIgnoreCase(str) != null ? 144 : true;
        updateStagedInputTypeFlag(reactEditText, KEYBOARD_TYPE_FLAGS, str);
        checkPasswordType(reactEditText);
    }

    @ReactProp(name = "returnKeyType")
    public void setReturnKeyType(ReactEditText reactEditText, String str) {
        reactEditText.setReturnKeyType(str);
    }

    @ReactProp(defaultBoolean = false, name = "disableFullscreenUI")
    public void setDisableFullscreenUI(ReactEditText reactEditText, boolean z) {
        reactEditText.setDisableFullscreenUI(z);
    }

    @ReactProp(name = "returnKeyLabel")
    public void setReturnKeyLabel(ReactEditText reactEditText, String str) {
        reactEditText.setImeActionLabel(str, IME_ACTION_ID);
    }

    @ReactPropGroup(defaultFloat = 1.0E21f, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactEditText reactEditText, int i, float f) {
        if (!YogaConstants.isUndefined(f)) {
            f = PixelUtil.toPixelFromDIP(f);
        }
        if (i == 0) {
            reactEditText.setBorderRadius(f);
        } else {
            reactEditText.setBorderRadius(f, i - 1);
        }
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactEditText reactEditText, String str) {
        reactEditText.setBorderStyle(str);
    }

    @ReactPropGroup(defaultFloat = 1.0E21f, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactEditText reactEditText, int i, float f) {
        if (!YogaConstants.isUndefined(f)) {
            f = PixelUtil.toPixelFromDIP(f);
        }
        reactEditText.setBorderWidth(SPACING_TYPES[i], f);
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactEditText reactEditText, int i, Integer num) {
        float f = 1.0E21f;
        float intValue = num == null ? 1.0E21f : (float) (num.intValue() & 16777215);
        if (num != null) {
            f = (float) (num.intValue() >>> 24);
        }
        reactEditText.setBorderColor(SPACING_TYPES[i], intValue, f);
    }

    protected void onAfterUpdateTransaction(ReactEditText reactEditText) {
        super.onAfterUpdateTransaction(reactEditText);
        reactEditText.commitStagedInputType();
    }

    private static void checkPasswordType(ReactEditText reactEditText) {
        if ((reactEditText.getStagedInputType() & INPUT_TYPE_KEYBOARD_NUMBERED) != 0 && (reactEditText.getStagedInputType() & 128) != 0) {
            updateStagedInputTypeFlag(reactEditText, 128, 16);
        }
    }

    private static int parseNumericFontWeight(String str) {
        return (str.length() != 3 || !str.endsWith("00") || str.charAt(0) > '9' || str.charAt(0) < '1') ? -1 : (str.charAt(0) - 48) * 100;
    }

    private static void updateStagedInputTypeFlag(ReactEditText reactEditText, int i, int i2) {
        reactEditText.setStagedInputType(((~i) & reactEditText.getStagedInputType()) | i2);
    }

    protected void addEventEmitters(final ThemedReactContext themedReactContext, final ReactEditText reactEditText) {
        reactEditText.addTextChangedListener(new ReactTextInputTextWatcher(themedReactContext, reactEditText));
        reactEditText.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                view = ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
                if (z) {
                    view.dispatchEvent(new ReactTextInputFocusEvent(reactEditText.getId()));
                    return;
                }
                view.dispatchEvent(new ReactTextInputBlurEvent(reactEditText.getId()));
                view.dispatchEvent(new ReactTextInputEndEditingEvent(reactEditText.getId(), reactEditText.getText().toString()));
            }
        });
        reactEditText.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                keyEvent = true;
                if ((i & JfifUtil.MARKER_FIRST_BYTE) <= null) {
                    if (i != 0) {
                        return true;
                    }
                }
                textView = reactEditText.getBlurOnSubmit();
                i = (reactEditText.getInputType() & 131072) != 0 ? 1 : 0;
                ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactTextInputSubmitEditingEvent(reactEditText.getId(), reactEditText.getText().toString()));
                if (textView != null) {
                    reactEditText.clearFocus();
                }
                if (textView == null) {
                    if (i != 0) {
                        keyEvent = null;
                    }
                }
                return keyEvent;
            }
        });
    }

    public Map getExportedViewConstants() {
        return MapBuilder.of("AutoCapitalizationType", MapBuilder.of(ViewProps.NONE, Integer.valueOf(0), "characters", Integer.valueOf(4096), "words", Integer.valueOf(Utility.DEFAULT_STREAM_BUFFER_SIZE), "sentences", Integer.valueOf(16384)));
    }
}
