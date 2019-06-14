package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;

public class ServerDHParams {
    /* renamed from: a */
    protected DHPublicKeyParameters f22554a;

    public ServerDHParams(DHPublicKeyParameters dHPublicKeyParameters) {
        if (dHPublicKeyParameters != null) {
            this.f22554a = dHPublicKeyParameters;
            return;
        }
        throw new IllegalArgumentException("'publicKey' cannot be null");
    }

    /* renamed from: a */
    public DHPublicKeyParameters m27604a() {
        return this.f22554a;
    }

    /* renamed from: a */
    public void m27605a(OutputStream outputStream) {
        DHParameters b = this.f22554a.m40790b();
        BigInteger c = this.f22554a.m43366c();
        TlsDHUtils.m27644a(b.m35638a(), outputStream);
        TlsDHUtils.m27644a(b.m35639b(), outputStream);
        TlsDHUtils.m27644a(c, outputStream);
    }

    /* renamed from: a */
    public static ServerDHParams m27603a(InputStream inputStream) {
        return new ServerDHParams(TlsDHUtils.m27643a(new DHPublicKeyParameters(TlsDHUtils.m27638a(inputStream), new DHParameters(TlsDHUtils.m27638a(inputStream), TlsDHUtils.m27638a(inputStream)))));
    }
}
