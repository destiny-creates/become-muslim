package org.spongycastle.jce.provider;

import java.util.Collection;
import org.spongycastle.util.CollectionStore;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.X509StoreSpi;

public class X509StoreAttrCertCollection extends X509StoreSpi {
    /* renamed from: a */
    private CollectionStore f27613a;

    /* renamed from: a */
    public Collection mo5889a(Selector selector) {
        return this.f27613a.mo5936a(selector);
    }
}
