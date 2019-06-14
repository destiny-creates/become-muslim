package org.spongycastle.jce.provider;

import java.util.Collection;
import org.spongycastle.util.CollectionStore;
import org.spongycastle.util.Selector;
import org.spongycastle.x509.X509StoreSpi;

public class X509StoreCRLCollection extends X509StoreSpi {
    /* renamed from: a */
    private CollectionStore f27614a;

    /* renamed from: a */
    public Collection mo5889a(Selector selector) {
        return this.f27614a.mo5936a(selector);
    }
}
