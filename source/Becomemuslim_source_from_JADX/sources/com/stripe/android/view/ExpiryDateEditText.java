package com.stripe.android.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.facebook.appevents.AppEventsConstants;

public class ExpiryDateEditText extends StripeEditText {
    /* renamed from: a */
    private C5790a f32844a;
    /* renamed from: b */
    private boolean f32845b;

    /* renamed from: com.stripe.android.view.ExpiryDateEditText$1 */
    class C57891 implements TextWatcher {
        /* renamed from: a */
        boolean f19186a = null;
        /* renamed from: b */
        int f19187b;
        /* renamed from: c */
        int f19188c;
        /* renamed from: d */
        String[] f19189d = new String[2];
        /* renamed from: e */
        final /* synthetic */ ExpiryDateEditText f19190e;

        C57891(ExpiryDateEditText expiryDateEditText) {
            this.f19190e = expiryDateEditText;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f19186a == null) {
                this.f19187b = i;
                this.f19188c = i3;
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f19186a == 0) {
                charSequence = charSequence.toString().replaceAll("/", "");
                if (charSequence.length() == 1 && this.f19187b == 0 && this.f19188c == 1) {
                    i = charSequence.charAt(0);
                    if (!(i == 48 || i == 49)) {
                        i = new StringBuilder();
                        i.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        i.append(charSequence);
                        charSequence = i.toString();
                        this.f19188c++;
                    }
                } else if (charSequence.length() == 2 && this.f19187b == 2 && this.f19188c == 0) {
                    charSequence = charSequence.substring(0, 1);
                }
                this.f19189d = C5807e.m24512b(charSequence);
                i = C5807e.m24511a(this.f19189d[0]) ^ 1;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.f19189d[0]);
                if ((this.f19189d[0].length() == 2 && this.f19188c > 0 && i == 0) || charSequence.length() > 2) {
                    stringBuilder.append("/");
                }
                stringBuilder.append(this.f19189d[1]);
                charSequence = stringBuilder.toString();
                i = this.f19190e.m44349a(charSequence.length(), this.f19187b, this.f19188c);
                this.f19186a = true;
                this.f19190e.setText(charSequence);
                this.f19190e.setSelection(i);
                this.f19186a = false;
            }
        }

        public void afterTextChanged(Editable editable) {
            editable = (this.f19189d[0].length() == 2 && C5807e.m24511a(this.f19189d[0]) == null) ? true : null;
            if (this.f19189d[0].length() == 2 && this.f19189d[1].length() == 2) {
                editable = this.f19190e.f32845b;
                this.f19190e.m44344a(this.f19189d);
                int a = this.f19190e.f32845b ^ 1;
                if (!(editable != null || this.f19190e.f32845b == null || this.f19190e.f32844a == null)) {
                    this.f19190e.f32844a.mo5075a();
                }
                editable = a;
            } else {
                this.f19190e.f32845b = false;
            }
            this.f19190e.setShouldShowError(editable);
        }
    }

    /* renamed from: com.stripe.android.view.ExpiryDateEditText$a */
    interface C5790a {
        /* renamed from: a */
        void mo5075a();
    }

    /* renamed from: a */
    int m44349a(int i, int i2, int i3) {
        Object obj = 1;
        int i4 = (i2 > 2 || i2 + i3 < 2) ? 0 : 1;
        if (i3 != 0 || i2 != 3) {
            obj = null;
        }
        i2 = (i2 + i3) + i4;
        if (obj != null && i2 > 0) {
            i2--;
        }
        return i2 <= i ? i2 : i;
    }

    public ExpiryDateEditText(Context context) {
        super(context);
        m44348b();
    }

    public ExpiryDateEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m44348b();
    }

    public ExpiryDateEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m44348b();
    }

    /* renamed from: a */
    public boolean mo6856a() {
        return this.f32845b;
    }

    public int[] getValidDateFields() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.f32845b;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = 2;
        r0 = new int[r0];
        r2 = r5.getText();
        r2 = r2.toString();
        r3 = "/";
        r4 = "";
        r2 = r2.replaceAll(r3, r4);
        r2 = com.stripe.android.view.C5807e.m24512b(r2);
        r3 = 0;
        r4 = r2[r3];	 Catch:{ NumberFormatException -> 0x0034 }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ NumberFormatException -> 0x0034 }
        r0[r3] = r4;	 Catch:{ NumberFormatException -> 0x0034 }
        r3 = 1;	 Catch:{ NumberFormatException -> 0x0034 }
        r2 = r2[r3];	 Catch:{ NumberFormatException -> 0x0034 }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x0034 }
        r2 = com.stripe.android.view.C5807e.m24507a(r2);	 Catch:{ NumberFormatException -> 0x0034 }
        r0[r3] = r2;	 Catch:{ NumberFormatException -> 0x0034 }
        return r0;
    L_0x0034:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.ExpiryDateEditText.getValidDateFields():int[]");
    }

    public void setExpiryDateEditListener(C5790a c5790a) {
        this.f32844a = c5790a;
    }

    /* renamed from: b */
    private void m44348b() {
        addTextChangedListener(new C57891(this));
    }

    /* renamed from: a */
    private void m44344a(java.lang.String[] r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = r6[r0];
        r1 = r1.length();
        r2 = 2;
        r3 = -1;
        if (r1 == r2) goto L_0x000d;
    L_0x000b:
        r0 = -1;
        goto L_0x0013;
    L_0x000d:
        r0 = r6[r0];	 Catch:{ NumberFormatException -> 0x000b }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x000b }
    L_0x0013:
        r1 = 1;
        r4 = r6[r1];
        r4 = r4.length();
        if (r4 == r2) goto L_0x001d;
    L_0x001c:
        goto L_0x0028;
    L_0x001d:
        r6 = r6[r1];	 Catch:{ NumberFormatException -> 0x0028 }
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ NumberFormatException -> 0x0028 }
        r6 = com.stripe.android.view.C5807e.m24507a(r6);	 Catch:{ NumberFormatException -> 0x0028 }
        r3 = r6;
    L_0x0028:
        r6 = com.stripe.android.view.C5807e.m24509a(r0, r3);
        r5.f32845b = r6;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.ExpiryDateEditText.a(java.lang.String[]):void");
    }
}
