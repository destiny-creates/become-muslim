package expolib_v1.p321a.p322a.p323a;

import expolib_v1.p332b.C6257r;
import expolib_v1.p332b.C7498g;
import expolib_v1.p332b.C8170c;
import java.io.IOException;

/* compiled from: FaultHidingSink */
/* renamed from: expolib_v1.a.a.a.e */
class C8162e extends C7498g {
    /* renamed from: a */
    private boolean f30335a;

    /* renamed from: a */
    protected void mo6766a(IOException iOException) {
    }

    public C8162e(C6257r c6257r) {
        super(c6257r);
    }

    /* renamed from: a */
    public void mo5257a(C8170c c8170c, long j) {
        if (this.f30335a) {
            c8170c.mo6387h(j);
            return;
        }
        try {
            super.mo5257a(c8170c, j);
        } catch (C8170c c8170c2) {
            this.f30335a = 1;
            mo6766a(c8170c2);
        }
    }

    public void flush() {
        if (!this.f30335a) {
            try {
                super.flush();
            } catch (IOException e) {
                this.f30335a = true;
                mo6766a(e);
            }
        }
    }

    public void close() {
        if (!this.f30335a) {
            try {
                super.close();
            } catch (IOException e) {
                this.f30335a = true;
                mo6766a(e);
            }
        }
    }
}
