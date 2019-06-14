package org.spongycastle.crypto.tls;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.crypto.agreement.srp.SRP6StandardGroups;
import org.spongycastle.crypto.params.SRP6GroupParameters;

public class DefaultTlsSRPGroupVerifier implements TlsSRPGroupVerifier {
    /* renamed from: a */
    protected static final Vector f27307a = new Vector();
    /* renamed from: b */
    protected Vector f27308b;

    static {
        f27307a.addElement(SRP6StandardGroups.f22250a);
        f27307a.addElement(SRP6StandardGroups.f22251b);
        f27307a.addElement(SRP6StandardGroups.f22252c);
        f27307a.addElement(SRP6StandardGroups.f22253d);
        f27307a.addElement(SRP6StandardGroups.f22254e);
        f27307a.addElement(SRP6StandardGroups.f22255f);
        f27307a.addElement(SRP6StandardGroups.f22256g);
    }

    public DefaultTlsSRPGroupVerifier() {
        this(f27307a);
    }

    public DefaultTlsSRPGroupVerifier(Vector vector) {
        this.f27308b = vector;
    }

    /* renamed from: a */
    public boolean mo5833a(SRP6GroupParameters sRP6GroupParameters) {
        for (int i = 0; i < this.f27308b.size(); i++) {
            if (m35881a(sRP6GroupParameters, (SRP6GroupParameters) this.f27308b.elementAt(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    protected boolean m35881a(SRP6GroupParameters sRP6GroupParameters, SRP6GroupParameters sRP6GroupParameters2) {
        if (sRP6GroupParameters != sRP6GroupParameters2) {
            if (!m35879a(sRP6GroupParameters.m27501b(), sRP6GroupParameters2.m27501b()) || m35879a(sRP6GroupParameters.m27500a(), sRP6GroupParameters2.m27500a()) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    protected boolean m35879a(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger != bigInteger2) {
            if (bigInteger.equals(bigInteger2) == null) {
                return null;
            }
        }
        return true;
    }
}
