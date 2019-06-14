package com.devmarvel.creditcardentry.p077a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import com.devmarvel.creditcardentry.C1175a.C1172f;
import com.devmarvel.creditcardentry.p078b.C1184b;

/* compiled from: CreditEntryFieldBase */
/* renamed from: com.devmarvel.creditcardentry.a.b */
public abstract class C1174b extends EditText implements TextWatcher, OnClickListener, OnKeyListener {
    /* renamed from: a */
    C1184b f3294a;
    /* renamed from: b */
    final Context f3295b;
    /* renamed from: c */
    String f3296c = null;
    /* renamed from: d */
    private boolean f3297d = false;

    /* compiled from: CreditEntryFieldBase */
    /* renamed from: com.devmarvel.creditcardentry.a.b$a */
    private class C1173a extends InputConnectionWrapper {
        /* renamed from: a */
        final /* synthetic */ C1174b f3293a;

        public C1173a(C1174b c1174b, InputConnection inputConnection) {
            this.f3293a = c1174b;
            super(inputConnection, null);
        }

        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67) {
                this.f3293a.m4137c();
            }
            return super.sendKeyEvent(keyEvent);
        }

        public boolean deleteSurroundingText(int i, int i2) {
            C1173a c1173a = this;
            if (VERSION.SDK_INT < 11) {
                return super.deleteSurroundingText(i, i2);
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = uptimeMillis;
            KeyEvent keyEvent = r2;
            KeyEvent keyEvent2 = new KeyEvent(uptimeMillis, j, 0, 67, 0, 0, -1, 0, 22);
            sendKeyEvent(keyEvent);
            sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), j, 1, 67, 0, 0, -1, 0, 22));
            return true;
        }
    }

    /* renamed from: a */
    public void mo809a(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* renamed from: a */
    public abstract void mo804a(String str);

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public abstract String getHelperText();

    public abstract void setHelperText(String str);

    public C1174b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3295b = context;
        m4139a(attributeSet);
    }

    /* renamed from: a */
    void mo803a() {
        m4139a(null);
    }

    /* renamed from: a */
    void m4139a(AttributeSet attributeSet) {
        setGravity(17);
        setImeOptions(268435456);
        setBackgroundColor(getResources().getColor(17170445));
        setInputType(2);
        addTextChangedListener(this);
        setOnKeyListener(this);
        setOnClickListener(this);
        setPadding(50, 0, 50, 0);
        setStyle(attributeSet);
    }

    void setStyle(AttributeSet attributeSet) {
        if (attributeSet != null) {
            attributeSet = this.f3295b.obtainStyledAttributes(attributeSet, C1172f.CreditCardForm);
            if (!attributeSet.getBoolean(C1172f.CreditCardForm_default_text_colors, false)) {
                setTextColor(attributeSet.getColor(C1172f.CreditCardForm_text_color, -16777216));
                setHintTextColor(attributeSet.getColor(C1172f.CreditCardForm_hint_text_color, -3355444));
                setCursorDrawableColor(attributeSet.getColor(C1172f.CreditCardForm_cursor_color, -16777216));
            }
            attributeSet.recycle();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (i != 0 || i2 != 1 || charSequence.length() != 0) {
            String valueOf = String.valueOf(charSequence);
            if (!valueOf.equals(this.f3296c)) {
                this.f3296c = valueOf;
                mo809a(charSequence, i, i2, i3);
            }
        } else if (this.f3294a != null) {
            this.f3294a.mo814b(this);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        editorInfo.actionLabel = null;
        editorInfo.inputType = 0;
        editorInfo.imeOptions = 1;
        return new C1173a(this, super.onCreateInputConnection(editorInfo));
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (!(keyEvent.getAction() == null || i == 57 || i == 58 || i == 59)) {
            if (i != 60) {
                if (i == 67 && getText().toString().length() == null && this.f3294a != null) {
                    this.f3294a.mo814b(this);
                }
                return false;
            }
        }
        return false;
    }

    public void onClick(View view) {
        setSelection(getText().length());
    }

    public C1184b getDelegate() {
        return this.f3294a;
    }

    public void setDelegate(C1184b c1184b) {
        this.f3294a = c1184b;
    }

    /* renamed from: b */
    public boolean m4142b() {
        return this.f3297d;
    }

    void setValid(boolean z) {
        this.f3297d = z;
    }

    /* renamed from: c */
    private void m4137c() {
        if (getText().toString().length() == 0 && this.f3294a != null) {
            this.f3294a.mo814b(this);
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putBoolean("focus", hasFocus());
        bundle.putString("stateToSave", String.valueOf(getText()));
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            setText(bundle.getString("stateToSave"));
            if (bundle.getBoolean("focus", false) != null) {
                requestFocus();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setCursorDrawableColor(int r8) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r7 = this;
        r0 = android.widget.TextView.class;	 Catch:{ Throwable -> 0x0055 }
        r1 = "mCursorDrawableRes";	 Catch:{ Throwable -> 0x0055 }
        r0 = r0.getDeclaredField(r1);	 Catch:{ Throwable -> 0x0055 }
        r1 = 1;	 Catch:{ Throwable -> 0x0055 }
        r0.setAccessible(r1);	 Catch:{ Throwable -> 0x0055 }
        r0 = r0.getInt(r7);	 Catch:{ Throwable -> 0x0055 }
        r2 = android.widget.TextView.class;	 Catch:{ Throwable -> 0x0055 }
        r3 = "mEditor";	 Catch:{ Throwable -> 0x0055 }
        r2 = r2.getDeclaredField(r3);	 Catch:{ Throwable -> 0x0055 }
        r2.setAccessible(r1);	 Catch:{ Throwable -> 0x0055 }
        r2 = r2.get(r7);	 Catch:{ Throwable -> 0x0055 }
        r3 = r2.getClass();	 Catch:{ Throwable -> 0x0055 }
        r4 = "mCursorDrawable";	 Catch:{ Throwable -> 0x0055 }
        r3 = r3.getDeclaredField(r4);	 Catch:{ Throwable -> 0x0055 }
        r3.setAccessible(r1);	 Catch:{ Throwable -> 0x0055 }
        r4 = 2;	 Catch:{ Throwable -> 0x0055 }
        r4 = new android.graphics.drawable.Drawable[r4];	 Catch:{ Throwable -> 0x0055 }
        r5 = r7.getContext();	 Catch:{ Throwable -> 0x0055 }
        r5 = android.support.v4.content.C0366b.m1103a(r5, r0);	 Catch:{ Throwable -> 0x0055 }
        r6 = 0;	 Catch:{ Throwable -> 0x0055 }
        r4[r6] = r5;	 Catch:{ Throwable -> 0x0055 }
        r5 = r7.getContext();	 Catch:{ Throwable -> 0x0055 }
        r0 = android.support.v4.content.C0366b.m1103a(r5, r0);	 Catch:{ Throwable -> 0x0055 }
        r4[r1] = r0;	 Catch:{ Throwable -> 0x0055 }
        r0 = r4[r6];	 Catch:{ Throwable -> 0x0055 }
        r5 = android.graphics.PorterDuff.Mode.SRC_IN;	 Catch:{ Throwable -> 0x0055 }
        r0.setColorFilter(r8, r5);	 Catch:{ Throwable -> 0x0055 }
        r0 = r4[r1];	 Catch:{ Throwable -> 0x0055 }
        r1 = android.graphics.PorterDuff.Mode.SRC_IN;	 Catch:{ Throwable -> 0x0055 }
        r0.setColorFilter(r8, r1);	 Catch:{ Throwable -> 0x0055 }
        r3.set(r2, r4);	 Catch:{ Throwable -> 0x0055 }
    L_0x0055:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devmarvel.creditcardentry.a.b.setCursorDrawableColor(int):void");
    }
}
