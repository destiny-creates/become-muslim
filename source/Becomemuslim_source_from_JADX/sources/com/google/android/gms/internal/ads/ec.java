package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.util.C2902m;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class ec implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ OutputStream f15329a;
    /* renamed from: b */
    private final /* synthetic */ byte[] f15330b;

    ec(eb ebVar, OutputStream outputStream, byte[] bArr) {
        this.f15329a = outputStream;
        this.f15330b = bArr;
    }

    public final void run() {
        Throwable e;
        Throwable th;
        Closeable dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(this.f15329a);
            try {
                dataOutputStream.writeInt(this.f15330b.length);
                dataOutputStream.write(this.f15330b);
                C2902m.a(dataOutputStream);
            } catch (IOException e2) {
                e = e2;
                try {
                    mt.m19919b("Error transporting the ad response", e);
                    ax.i().m30834a(e, "LargeParcelTeleporter.pipeData.1");
                    if (dataOutputStream != null) {
                        C2902m.a(this.f15329a);
                    } else {
                        C2902m.a(dataOutputStream);
                    }
                } catch (Throwable th2) {
                    e = th2;
                    if (dataOutputStream == null) {
                        dataOutputStream = this.f15329a;
                    }
                    C2902m.a(dataOutputStream);
                    throw e;
                }
            }
        } catch (Throwable e3) {
            th = e3;
            dataOutputStream = null;
            e = th;
            mt.m19919b("Error transporting the ad response", e);
            ax.i().m30834a(e, "LargeParcelTeleporter.pipeData.1");
            if (dataOutputStream != null) {
                C2902m.a(dataOutputStream);
            } else {
                C2902m.a(this.f15329a);
            }
        } catch (Throwable e32) {
            th = e32;
            dataOutputStream = null;
            e = th;
            if (dataOutputStream == null) {
                dataOutputStream = this.f15329a;
            }
            C2902m.a(dataOutputStream);
            throw e;
        }
    }
}
