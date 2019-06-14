package com.facebook.react.views.textinput;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;

class ReactEditTextInputConnectionWrapper extends InputConnectionWrapper {
    public static final String BACKSPACE_KEY_VALUE = "Backspace";
    public static final String ENTER_KEY_VALUE = "Enter";
    public static final String NEWLINE_RAW_VALUE = "\n";
    private ReactEditText mEditText;
    private EventDispatcher mEventDispatcher;
    private boolean mIsBatchEdit;
    private String mKey = null;

    public ReactEditTextInputConnectionWrapper(InputConnection inputConnection, ReactContext reactContext, ReactEditText reactEditText) {
        super(inputConnection, false);
        this.mEventDispatcher = ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        this.mEditText = reactEditText;
    }

    public boolean beginBatchEdit() {
        this.mIsBatchEdit = true;
        return super.beginBatchEdit();
    }

    public boolean endBatchEdit() {
        this.mIsBatchEdit = false;
        if (this.mKey != null) {
            dispatchKeyEvent(this.mKey);
            this.mKey = null;
        }
        return super.endBatchEdit();
    }

    public boolean setComposingText(CharSequence charSequence, int i) {
        int selectionStart = this.mEditText.getSelectionStart();
        int selectionEnd = this.mEditText.getSelectionEnd();
        charSequence = super.setComposingText(charSequence, i);
        i = this.mEditText.getSelectionStart();
        Object obj = null;
        Object obj2 = selectionStart == selectionEnd ? 1 : null;
        Object obj3 = i == selectionStart ? 1 : null;
        if (i < selectionStart || i <= 0) {
            obj = 1;
        }
        if (obj == null) {
            if (obj2 != null || obj3 == null) {
                i = String.valueOf(this.mEditText.getText().charAt(i - 1));
                dispatchKeyEventOrEnqueue(i);
                return charSequence;
            }
        }
        i = BACKSPACE_KEY_VALUE;
        dispatchKeyEventOrEnqueue(i);
        return charSequence;
    }

    public boolean commitText(CharSequence charSequence, int i) {
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() <= 1) {
            if (charSequence2.equals("")) {
                charSequence2 = BACKSPACE_KEY_VALUE;
            }
            dispatchKeyEventOrEnqueue(charSequence2);
        }
        return super.commitText(charSequence, i);
    }

    public boolean deleteSurroundingText(int i, int i2) {
        dispatchKeyEvent(BACKSPACE_KEY_VALUE);
        return super.deleteSurroundingText(i, i2);
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 67) {
                dispatchKeyEvent(BACKSPACE_KEY_VALUE);
            } else if (keyEvent.getKeyCode() == 66) {
                dispatchKeyEvent(ENTER_KEY_VALUE);
            }
        }
        return super.sendKeyEvent(keyEvent);
    }

    private void dispatchKeyEventOrEnqueue(String str) {
        if (this.mIsBatchEdit) {
            this.mKey = str;
        } else {
            dispatchKeyEvent(str);
        }
    }

    private void dispatchKeyEvent(String str) {
        if (str.equals(NEWLINE_RAW_VALUE)) {
            str = ENTER_KEY_VALUE;
        }
        this.mEventDispatcher.dispatchEvent(new ReactTextInputKeyPressEvent(this.mEditText.getId(), str));
    }
}
