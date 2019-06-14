package com.facebook.react.views.textinput;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.QwertyKeyListener;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.views.text.CustomStyleSpan;
import com.facebook.react.views.text.ReactTagSpan;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.TextInlineImageSpan;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.ArrayList;
import java.util.Iterator;

public class ReactEditText extends EditText {
    private static final KeyListener sKeyListener = QwertyKeyListener.getInstanceForFullKeyboard();
    private Boolean mBlurOnSubmit;
    private boolean mContainsImages;
    private ContentSizeWatcher mContentSizeWatcher;
    private int mDefaultGravityHorizontal;
    private int mDefaultGravityVertical;
    private boolean mDetectScrollMovement = false;
    private boolean mDisableFullscreen;
    private final InputMethodManager mInputMethodManager;
    private boolean mIsJSSettingFocus;
    private boolean mIsSettingTextFromJS;
    private final InternalKeyListener mKeyListener;
    private float mLetterSpacingPt = 0.0f;
    private ArrayList<TextWatcher> mListeners;
    private int mMostRecentEventCount;
    private int mNativeEventCount;
    private boolean mOnKeyPress = false;
    private ReactViewBackgroundManager mReactBackgroundManager;
    private String mReturnKeyType;
    private ScrollWatcher mScrollWatcher;
    private SelectionWatcher mSelectionWatcher;
    private int mStagedInputType;
    private TextWatcherDelegator mTextWatcherDelegator;

    private static class InternalKeyListener implements KeyListener {
        private int mInputType = 0;

        public void setInputType(int i) {
            this.mInputType = i;
        }

        public int getInputType() {
            return this.mInputType;
        }

        public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
            return ReactEditText.sKeyListener.onKeyDown(view, editable, i, keyEvent);
        }

        public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
            return ReactEditText.sKeyListener.onKeyUp(view, editable, i, keyEvent);
        }

        public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
            return ReactEditText.sKeyListener.onKeyOther(view, editable, keyEvent);
        }

        public void clearMetaKeyState(View view, Editable editable, int i) {
            ReactEditText.sKeyListener.clearMetaKeyState(view, editable, i);
        }
    }

    private class TextWatcherDelegator implements TextWatcher {
        private TextWatcherDelegator() {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!ReactEditText.this.mIsSettingTextFromJS && ReactEditText.this.mListeners != null) {
                Iterator it = ReactEditText.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).beforeTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!(ReactEditText.this.mIsSettingTextFromJS || ReactEditText.this.mListeners == null)) {
                Iterator it = ReactEditText.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).onTextChanged(charSequence, i, i2, i3);
                }
            }
            ReactEditText.this.onContentSizeChange();
        }

        public void afterTextChanged(Editable editable) {
            if (!ReactEditText.this.mIsSettingTextFromJS && ReactEditText.this.mListeners != null) {
                Iterator it = ReactEditText.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).afterTextChanged(editable);
                }
            }
        }
    }

    public boolean isLayoutRequested() {
        return false;
    }

    public ReactEditText(Context context) {
        super(context);
        setFocusableInTouchMode(false);
        this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
        this.mInputMethodManager = (InputMethodManager) Assertions.assertNotNull(getContext().getSystemService("input_method"));
        this.mDefaultGravityHorizontal = getGravity() & 8388615;
        this.mDefaultGravityVertical = getGravity() & 112;
        this.mNativeEventCount = 0;
        this.mMostRecentEventCount = 0;
        this.mIsSettingTextFromJS = false;
        this.mIsJSSettingFocus = false;
        this.mBlurOnSubmit = null;
        this.mDisableFullscreen = false;
        this.mListeners = null;
        this.mTextWatcherDelegator = null;
        this.mStagedInputType = getInputType();
        this.mKeyListener = new InternalKeyListener();
        this.mScrollWatcher = null;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        onContentSizeChange();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDetectScrollMovement = true;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            if (this.mDetectScrollMovement) {
                if (!(canScrollVertically(-1) || canScrollVertically(1) || canScrollHorizontally(-1) || canScrollHorizontally(1))) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                this.mDetectScrollMovement = false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 66 || isMultiline()) {
            return super.onKeyUp(i, keyEvent);
        }
        hideSoftKeyboard();
        return true;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mScrollWatcher != null) {
            this.mScrollWatcher.onScrollChanged(i, i2, i3, i4);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        ReactContext reactContext = (ReactContext) getContext();
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && this.mOnKeyPress) {
            onCreateInputConnection = new ReactEditTextInputConnectionWrapper(onCreateInputConnection, reactContext, this);
        }
        if (isMultiline() && getBlurOnSubmit()) {
            editorInfo.imeOptions &= -1073741825;
        }
        return onCreateInputConnection;
    }

    public void clearFocus() {
        setFocusableInTouchMode(false);
        super.clearFocus();
        hideSoftKeyboard();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (isFocused()) {
            return true;
        }
        if (!this.mIsJSSettingFocus) {
            return false;
        }
        setFocusableInTouchMode(true);
        i = super.requestFocus(i, rect);
        showSoftKeyboard();
        return i;
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
            super.addTextChangedListener(getTextWatcherDelegator());
        }
        this.mListeners.add(textWatcher);
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        if (this.mListeners != null) {
            this.mListeners.remove(textWatcher);
            if (this.mListeners.isEmpty() != null) {
                this.mListeners = null;
                super.removeTextChangedListener(getTextWatcherDelegator());
            }
        }
    }

    public void setContentSizeWatcher(ContentSizeWatcher contentSizeWatcher) {
        this.mContentSizeWatcher = contentSizeWatcher;
    }

    public void setScrollWatcher(ScrollWatcher scrollWatcher) {
        this.mScrollWatcher = scrollWatcher;
    }

    public void setSelection(int i, int i2) {
        if (this.mMostRecentEventCount >= this.mNativeEventCount) {
            super.setSelection(i, i2);
        }
    }

    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (this.mSelectionWatcher != null && hasFocus()) {
            this.mSelectionWatcher.onSelectionChanged(i, i2);
        }
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z && this.mSelectionWatcher) {
            this.mSelectionWatcher.onSelectionChanged(getSelectionStart(), getSelectionEnd());
        }
    }

    public void setSelectionWatcher(SelectionWatcher selectionWatcher) {
        this.mSelectionWatcher = selectionWatcher;
    }

    public void setBlurOnSubmit(Boolean bool) {
        this.mBlurOnSubmit = bool;
    }

    public void setOnKeyPress(boolean z) {
        this.mOnKeyPress = z;
    }

    public boolean getBlurOnSubmit() {
        if (this.mBlurOnSubmit == null) {
            return isMultiline() ^ 1;
        }
        return this.mBlurOnSubmit.booleanValue();
    }

    public void setDisableFullscreenUI(boolean z) {
        this.mDisableFullscreen = z;
        updateImeOptions();
    }

    public boolean getDisableFullscreenUI() {
        return this.mDisableFullscreen;
    }

    public void setReturnKeyType(String str) {
        this.mReturnKeyType = str;
        updateImeOptions();
    }

    public String getReturnKeyType() {
        return this.mReturnKeyType;
    }

    int getStagedInputType() {
        return this.mStagedInputType;
    }

    void setStagedInputType(int i) {
        this.mStagedInputType = i;
    }

    void commitStagedInputType() {
        if (getInputType() != this.mStagedInputType) {
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            setInputType(this.mStagedInputType);
            setSelection(selectionStart, selectionEnd);
        }
    }

    public void setInputType(int i) {
        Typeface typeface = super.getTypeface();
        super.setInputType(i);
        this.mStagedInputType = i;
        super.setTypeface(typeface);
        this.mKeyListener.setInputType(i);
        setKeyListener(this.mKeyListener);
    }

    public void requestFocusFromJS() {
        this.mIsJSSettingFocus = true;
        requestFocus();
        this.mIsJSSettingFocus = false;
    }

    void clearFocusFromJS() {
        clearFocus();
    }

    public int incrementAndGetEventCounter() {
        int i = this.mNativeEventCount + 1;
        this.mNativeEventCount = i;
        return i;
    }

    public void maybeSetText(ReactTextUpdate reactTextUpdate) {
        if (!isSecureText() || !TextUtils.equals(getText(), reactTextUpdate.getText())) {
            this.mMostRecentEventCount = reactTextUpdate.getJsEventCounter();
            if (this.mMostRecentEventCount >= this.mNativeEventCount) {
                CharSequence spannableStringBuilder = new SpannableStringBuilder(reactTextUpdate.getText());
                manageSpans(spannableStringBuilder);
                this.mContainsImages = reactTextUpdate.containsImages();
                this.mIsSettingTextFromJS = true;
                getText().replace(0, length(), spannableStringBuilder);
                this.mIsSettingTextFromJS = false;
                if (VERSION.SDK_INT >= 23 && getBreakStrategy() != reactTextUpdate.getTextBreakStrategy()) {
                    setBreakStrategy(reactTextUpdate.getTextBreakStrategy());
                }
            }
        }
    }

    private void manageSpans(SpannableStringBuilder spannableStringBuilder) {
        int i = 0;
        Object[] spans = getText().getSpans(0, length(), Object.class);
        while (i < spans.length) {
            if (ForegroundColorSpan.class.isInstance(spans[i]) || BackgroundColorSpan.class.isInstance(spans[i]) || AbsoluteSizeSpan.class.isInstance(spans[i]) || CustomStyleSpan.class.isInstance(spans[i]) || ReactTagSpan.class.isInstance(spans[i])) {
                getText().removeSpan(spans[i]);
            }
            if ((getText().getSpanFlags(spans[i]) & 33) == 33) {
                Object obj = spans[i];
                int spanStart = getText().getSpanStart(spans[i]);
                int spanEnd = getText().getSpanEnd(spans[i]);
                int spanFlags = getText().getSpanFlags(spans[i]);
                getText().removeSpan(spans[i]);
                if (sameTextForSpan(getText(), spannableStringBuilder, spanStart, spanEnd)) {
                    spannableStringBuilder.setSpan(obj, spanStart, spanEnd, spanFlags);
                }
            }
            i++;
        }
    }

    private static boolean sameTextForSpan(Editable editable, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        if (i <= spannableStringBuilder.length()) {
            if (i2 <= spannableStringBuilder.length()) {
                while (i < i2) {
                    if (editable.charAt(i) != spannableStringBuilder.charAt(i)) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    private boolean showSoftKeyboard() {
        return this.mInputMethodManager.showSoftInput(this, 0);
    }

    private void hideSoftKeyboard() {
        this.mInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    private TextWatcherDelegator getTextWatcherDelegator() {
        if (this.mTextWatcherDelegator == null) {
            this.mTextWatcherDelegator = new TextWatcherDelegator();
        }
        return this.mTextWatcherDelegator;
    }

    private boolean isMultiline() {
        return (getInputType() & 131072) != 0;
    }

    private boolean isSecureText() {
        return (getInputType() & 144) != 0;
    }

    private void onContentSizeChange() {
        if (this.mContentSizeWatcher != null) {
            this.mContentSizeWatcher.onLayout();
        }
        setIntrinsicContentSize();
    }

    private void setIntrinsicContentSize() {
        ((UIManagerModule) ((ReactContext) getContext()).getNativeModule(UIManagerModule.class)).setViewLocalData(getId(), new ReactTextInputLocalData(this));
    }

    void setGravityHorizontal(int i) {
        if (i == 0) {
            i = this.mDefaultGravityHorizontal;
        }
        setGravity(i | ((getGravity() & -8) & -8388616));
    }

    void setGravityVertical(int i) {
        if (i == 0) {
            i = this.mDefaultGravityVertical;
        }
        setGravity(i | (getGravity() & -113));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateImeOptions() {
        /*
        r9 = this;
        r0 = r9.mReturnKeyType;
        r1 = 4;
        r2 = 3;
        r3 = 1;
        r4 = 5;
        r5 = 2;
        r6 = 6;
        if (r0 == 0) goto L_0x006a;
    L_0x000a:
        r0 = r9.mReturnKeyType;
        r7 = -1;
        r8 = r0.hashCode();
        switch(r8) {
            case -1273775369: goto L_0x0051;
            case -906336856: goto L_0x0047;
            case 3304: goto L_0x003d;
            case 3089282: goto L_0x0033;
            case 3377907: goto L_0x0029;
            case 3387192: goto L_0x001f;
            case 3526536: goto L_0x0015;
            default: goto L_0x0014;
        };
    L_0x0014:
        goto L_0x005b;
    L_0x0015:
        r8 = "send";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x005b;
    L_0x001d:
        r0 = 5;
        goto L_0x005c;
    L_0x001f:
        r8 = "none";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x005b;
    L_0x0027:
        r0 = 2;
        goto L_0x005c;
    L_0x0029:
        r8 = "next";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x005b;
    L_0x0031:
        r0 = 1;
        goto L_0x005c;
    L_0x0033:
        r8 = "done";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x005b;
    L_0x003b:
        r0 = 6;
        goto L_0x005c;
    L_0x003d:
        r8 = "go";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x005b;
    L_0x0045:
        r0 = 0;
        goto L_0x005c;
    L_0x0047:
        r8 = "search";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x005b;
    L_0x004f:
        r0 = 4;
        goto L_0x005c;
    L_0x0051:
        r8 = "previous";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x005b;
    L_0x0059:
        r0 = 3;
        goto L_0x005c;
    L_0x005b:
        r0 = -1;
    L_0x005c:
        switch(r0) {
            case 0: goto L_0x0068;
            case 1: goto L_0x0066;
            case 2: goto L_0x0064;
            case 3: goto L_0x0062;
            case 4: goto L_0x0060;
            case 5: goto L_0x006b;
            case 6: goto L_0x006a;
            default: goto L_0x005f;
        };
    L_0x005f:
        goto L_0x006a;
    L_0x0060:
        r1 = 3;
        goto L_0x006b;
    L_0x0062:
        r1 = 7;
        goto L_0x006b;
    L_0x0064:
        r1 = 1;
        goto L_0x006b;
    L_0x0066:
        r1 = 5;
        goto L_0x006b;
    L_0x0068:
        r1 = 2;
        goto L_0x006b;
    L_0x006a:
        r1 = 6;
    L_0x006b:
        r0 = r9.mDisableFullscreen;
        if (r0 == 0) goto L_0x0076;
    L_0x006f:
        r0 = 33554432; // 0x2000000 float:9.403955E-38 double:1.6578092E-316;
        r0 = r0 | r1;
        r9.setImeOptions(r0);
        goto L_0x0079;
    L_0x0076:
        r9.setImeOptions(r1);
    L_0x0079:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.textinput.ReactEditText.updateImeOptions():void");
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (this.mContainsImages) {
            Spanned text = getText();
            int i = 0;
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                if (textInlineImageSpanArr[i].getDrawable() == drawable) {
                    return true;
                }
                i++;
            }
        }
        return super.verifyDrawable(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.mContainsImages) {
            Spanned text = getText();
            int i = 0;
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                if (textInlineImageSpanArr[i].getDrawable() == drawable) {
                    invalidate();
                }
                i++;
            }
        }
        super.invalidateDrawable(drawable);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mContainsImages) {
            Spanned text = getText();
            int i = 0;
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].onDetachedFromWindow();
                i++;
            }
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mContainsImages) {
            Spanned text = getText();
            int i = 0;
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].onStartTemporaryDetach();
                i++;
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mContainsImages) {
            Spanned text = getText();
            int i = 0;
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].onAttachedToWindow();
                i++;
            }
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mContainsImages) {
            Spanned text = getText();
            int i = 0;
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].onFinishTemporaryDetach();
                i++;
            }
        }
    }

    public void setBackgroundColor(int i) {
        this.mReactBackgroundManager.setBackgroundColor(i);
    }

    public void setBorderWidth(int i, float f) {
        this.mReactBackgroundManager.setBorderWidth(i, f);
    }

    public void setBorderColor(int i, float f, float f2) {
        this.mReactBackgroundManager.setBorderColor(i, f, f2);
    }

    public void setBorderRadius(float f) {
        this.mReactBackgroundManager.setBorderRadius(f);
    }

    public void setBorderRadius(float f, int i) {
        this.mReactBackgroundManager.setBorderRadius(f, i);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.setBorderStyle(str);
    }

    public void setLetterSpacingPt(float f) {
        this.mLetterSpacingPt = f;
        updateLetterSpacing();
    }

    public void setTextSize(float f) {
        super.setTextSize(f);
        updateLetterSpacing();
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        updateLetterSpacing();
    }

    protected void updateLetterSpacing() {
        if (VERSION.SDK_INT >= 21) {
            setLetterSpacing(PixelUtil.toPixelFromSP(this.mLetterSpacingPt) / getTextSize());
        }
    }
}
