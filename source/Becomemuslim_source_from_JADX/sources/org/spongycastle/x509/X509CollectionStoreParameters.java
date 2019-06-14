package org.spongycastle.x509;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.util.Collection;

public class X509CollectionStoreParameters implements X509StoreParameters {
    /* renamed from: a */
    private Collection f27923a;

    public X509CollectionStoreParameters(Collection collection) {
        if (collection != null) {
            this.f27923a = collection;
            return;
        }
        throw new NullPointerException("collection cannot be null");
    }

    public Object clone() {
        return new X509CollectionStoreParameters(this.f27923a);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("X509CollectionStoreParameters: [\n");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  collection: ");
        stringBuilder.append(this.f27923a);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuffer.append(stringBuilder.toString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
