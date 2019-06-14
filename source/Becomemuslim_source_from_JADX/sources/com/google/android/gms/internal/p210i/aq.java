package com.google.android.gms.internal.p210i;

import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.i.aq */
class aq<T extends ap> extends C5006n {
    /* renamed from: a */
    private ar<T> f24431a;

    public aq(C5008q c5008q, ar<T> arVar) {
        super(c5008q);
        this.f24431a = arVar;
    }

    /* renamed from: a */
    public final T m31303a(int i) {
        try {
            return m31302a(m21041i().m21060b().getResources().getXml(i));
        } catch (int i2) {
            m21034d("inflate() called with unknown resourceId", i2);
            return null;
        }
    }

    /* renamed from: a */
    private final T m31302a(XmlResourceParser xmlResourceParser) {
        Object trim;
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase(Locale.US);
                    String trim2;
                    if (toLowerCase.equals("screenname")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim2 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim2))) {
                            this.f24431a.mo4417a(toLowerCase, trim2);
                        }
                    } else if (toLowerCase.equals("string")) {
                        Object attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim2 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || trim2 == null)) {
                            this.f24431a.mo4419b(attributeValue, trim2);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            try {
                                this.f24431a.mo4418a(toLowerCase, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                m21033c("Error parsing bool configuration value", trim, e);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            try {
                                this.f24431a.mo4416a(toLowerCase, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                m21033c("Error parsing int configuration value", trim, e2);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlResourceParser xmlResourceParser2) {
            m21037e("Error parsing tracker configuration file", xmlResourceParser2);
        }
        return this.f24431a.mo4415a();
    }
}
