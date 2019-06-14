package com.gettipsi.stripe;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Xml;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.devmarvel.creditcardentry.library.CreditCardForm;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.gettipsi.stripe.C2116d.C2112c;
import com.gettipsi.stripe.C2116d.C2115f;
import org.xmlpull.v1.XmlPullParser;

public class CustomCardInputReactManager extends SimpleViewManager<CreditCardForm> {
    private static final String CCV = "cvc";
    private static final String EXP_MONTH = "expMonth";
    private static final String EXP_YEAR = "expYear";
    private static final String NUMBER = "number";
    public static final String REACT_CLASS = "CreditCardForm";
    private static final String TAG = "CustomCardInputReactManager";
    private String currentCCV;
    private int currentMonth;
    private String currentNumber;
    private WritableMap currentParams;
    private int currentYear;
    private ThemedReactContext reactContext;

    private void updateView(CreditCardForm creditCardForm) {
    }

    public String getName() {
        return REACT_CLASS;
    }

    protected CreditCardForm createViewInstance(final ThemedReactContext themedReactContext) {
        XmlPullParser xml = themedReactContext.getResources().getXml(C2115f.stub_material);
        try {
            xml.next();
            xml.nextTag();
        } catch (Exception e) {
            e.printStackTrace();
        }
        final CreditCardForm creditCardForm = new CreditCardForm(themedReactContext, Xml.asAttributeSet(xml));
        setListeners(creditCardForm);
        this.reactContext = themedReactContext;
        creditCardForm.post(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ CustomCardInputReactManager f5006c;

            public void run() {
                ThemedReactContext themedReactContext = themedReactContext;
                ThemedReactContext themedReactContext2 = themedReactContext;
                ((InputMethodManager) themedReactContext.getSystemService("input_method")).toggleSoftInputFromWindow(creditCardForm.getApplicationWindowToken(), 1, 0);
                creditCardForm.m4163b();
            }
        });
        return creditCardForm;
    }

    @ReactProp(name = "enabled")
    public void setEnabled(CreditCardForm creditCardForm, boolean z) {
        creditCardForm.setEnabled(z);
    }

    @ReactProp(name = "backgroundColor")
    public void setBackgroundColor(CreditCardForm creditCardForm, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setBackgroundColor: ");
        stringBuilder.append(i);
        Log.d("TAG", stringBuilder.toString());
        creditCardForm.setBackgroundColor(i);
    }

    @ReactProp(name = "cardNumber")
    public void setCardNumber(CreditCardForm creditCardForm, String str) {
        creditCardForm.m4161a(str, true);
    }

    @ReactProp(name = "expDate")
    public void setExpDate(CreditCardForm creditCardForm, String str) {
        creditCardForm.m4164b(str, true);
    }

    @ReactProp(name = "securityCode")
    public void setSecurityCode(CreditCardForm creditCardForm, String str) {
        creditCardForm.m4165c(str, true);
    }

    @ReactProp(name = "numberPlaceholder")
    public void setCreditCardTextHint(CreditCardForm creditCardForm, String str) {
        creditCardForm.setCreditCardTextHint(str);
    }

    @ReactProp(name = "expirationPlaceholder")
    public void setExpDateTextHint(CreditCardForm creditCardForm, String str) {
        creditCardForm.setExpDateTextHint(str);
    }

    @ReactProp(name = "cvcPlaceholder")
    public void setSecurityCodeTextHint(CreditCardForm creditCardForm, String str) {
        creditCardForm.setSecurityCodeTextHint(str);
    }

    private void setListeners(final CreditCardForm creditCardForm) {
        EditText editText = (EditText) creditCardForm.findViewById(C2112c.cc_exp);
        EditText editText2 = (EditText) creditCardForm.findViewById(C2112c.cc_ccv);
        ((EditText) creditCardForm.findViewById(C2112c.cc_card)).addTextChangedListener(new TextWatcher(this) {
            /* renamed from: b */
            final /* synthetic */ CustomCardInputReactManager f5008b;

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                i = CustomCardInputReactManager.TAG;
                i2 = new StringBuilder();
                i2.append("onTextChanged: cardNumber = ");
                i2.append(charSequence);
                Log.d(i, i2.toString());
                this.f5008b.currentNumber = charSequence.toString().replaceAll(" ", "");
                this.f5008b.postEvent(creditCardForm);
            }
        });
        editText.addTextChangedListener(new TextWatcher(this) {
            /* renamed from: b */
            final /* synthetic */ CustomCardInputReactManager f5010b;

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(java.lang.CharSequence r1, int r2, int r3, int r4) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                /*
                r0 = this;
                r2 = com.gettipsi.stripe.CustomCardInputReactManager.TAG;
                r3 = new java.lang.StringBuilder;
                r3.<init>();
                r4 = "onTextChanged: EXP_YEAR = ";
                r3.append(r4);
                r3.append(r1);
                r3 = r3.toString();
                android.util.Log.d(r2, r3);
                r2 = 0;
                r3 = r0.f5010b;	 Catch:{ Exception -> 0x002d }
                r4 = r5;	 Catch:{ Exception -> 0x002d }
                r4 = r4.getCreditCard();	 Catch:{ Exception -> 0x002d }
                r4 = r4.m4170c();	 Catch:{ Exception -> 0x002d }
                r4 = r4.intValue();	 Catch:{ Exception -> 0x002d }
                r3.currentMonth = r4;	 Catch:{ Exception -> 0x002d }
                goto L_0x0039;
                r1 = r1.length();
                if (r1 != 0) goto L_0x0039;
            L_0x0034:
                r1 = r0.f5010b;
                r1.currentMonth = r2;
            L_0x0039:
                r1 = r0.f5010b;	 Catch:{ Exception -> 0x004d }
                r3 = r5;	 Catch:{ Exception -> 0x004d }
                r3 = r3.getCreditCard();	 Catch:{ Exception -> 0x004d }
                r3 = r3.m4171d();	 Catch:{ Exception -> 0x004d }
                r3 = r3.intValue();	 Catch:{ Exception -> 0x004d }
                r1.currentYear = r3;	 Catch:{ Exception -> 0x004d }
                goto L_0x0052;
            L_0x004d:
                r1 = r0.f5010b;
                r1.currentYear = r2;
            L_0x0052:
                r1 = r0.f5010b;
                r2 = r5;
                r1.postEvent(r2);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.gettipsi.stripe.CustomCardInputReactManager.3.onTextChanged(java.lang.CharSequence, int, int, int):void");
            }
        });
        editText2.addTextChangedListener(new TextWatcher(this) {
            /* renamed from: b */
            final /* synthetic */ CustomCardInputReactManager f5012b;

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                i = CustomCardInputReactManager.TAG;
                i2 = new StringBuilder();
                i2.append("onTextChanged: CCV = ");
                i2.append(charSequence);
                Log.d(i, i2.toString());
                this.f5012b.currentCCV = charSequence.toString();
                this.f5012b.postEvent(creditCardForm);
            }
        });
    }

    private void postEvent(CreditCardForm creditCardForm) {
        this.currentParams = Arguments.createMap();
        this.currentParams.putString(NUMBER, this.currentNumber);
        this.currentParams.putInt(EXP_MONTH, this.currentMonth);
        this.currentParams.putInt(EXP_YEAR, this.currentYear);
        this.currentParams.putString(CCV, this.currentCCV);
        ((UIManagerModule) this.reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new C3986a(creditCardForm.getId(), this.currentParams, creditCardForm.m4162a()));
    }
}
