package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C2836d;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.common.util.C2902m;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;

@cm
public final class eb extends C4363a {
    public static final Creator<eb> CREATOR = new ed();
    /* renamed from: a */
    private ParcelFileDescriptor f28624a;
    /* renamed from: b */
    private Parcelable f28625b;
    /* renamed from: c */
    private boolean f28626c;

    public eb(ParcelFileDescriptor parcelFileDescriptor) {
        this.f28624a = parcelFileDescriptor;
        this.f28625b = null;
        this.f28626c = true;
    }

    public eb(C2836d c2836d) {
        this.f28624a = null;
        this.f28625b = c2836d;
        this.f28626c = false;
    }

    /* renamed from: a */
    private final ParcelFileDescriptor m37460a() {
        if (this.f28624a == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.f28625b.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                this.f28624a = m37461a(marshall);
            } finally {
                obtain.recycle();
            }
        }
        return this.f28624a;
    }

    /* renamed from: a */
    private final <T> ParcelFileDescriptor m37461a(byte[] bArr) {
        Closeable autoCloseOutputStream;
        Throwable e;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new ec(this, autoCloseOutputStream, bArr)).start();
                return createPipe[0];
            } catch (IOException e2) {
                e = e2;
                mt.m19919b("Error transporting the ad response", e);
                ax.i().m30834a(e, "LargeParcelTeleporter.pipeData.2");
                C2902m.a(autoCloseOutputStream);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            autoCloseOutputStream = null;
            mt.m19919b("Error transporting the ad response", e);
            ax.i().m30834a(e, "LargeParcelTeleporter.pipeData.2");
            C2902m.a(autoCloseOutputStream);
            return null;
        }
    }

    /* renamed from: a */
    public final <T extends C2836d> T m37462a(Creator<T> creator) {
        if (this.f28626c) {
            if (this.f28624a == null) {
                mt.m19920c("File descriptor is empty, returning null.");
                return null;
            }
            byte[] autoCloseInputStream = new AutoCloseInputStream(this.f28624a);
            Closeable dataInputStream = new DataInputStream(autoCloseInputStream);
            Creator creator2;
            try {
                autoCloseInputStream = new byte[dataInputStream.readInt()];
                boolean z = false;
                dataInputStream.readFully(autoCloseInputStream, z, autoCloseInputStream.length);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(autoCloseInputStream, z, autoCloseInputStream.length);
                    obtain.setDataPosition(z);
                    this.f28625b = (C2836d) creator2.createFromParcel(obtain);
                    this.f28626c = z;
                } finally {
                    obtain.recycle();
                }
            } catch (IOException e) {
                creator2 = e;
                autoCloseInputStream = "Could not read from parcel file descriptor";
                mt.m19919b(autoCloseInputStream, creator2);
                return null;
            } finally {
                C2902m.a(dataInputStream);
            }
        }
        return (C2836d) this.f28625b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        m37460a();
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f28624a, i, false);
        C2835c.a(parcel, a);
    }
}
