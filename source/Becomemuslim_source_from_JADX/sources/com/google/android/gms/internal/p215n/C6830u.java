package com.google.android.gms.internal.p215n;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.C7877i;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.ai;

/* renamed from: com.google.android.gms.internal.n.u */
public abstract class C6830u extends C5063h implements C5071t {
    public C6830u() {
        super("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
    }

    /* renamed from: a */
    protected final boolean mo4775a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                mo6219a(parcel.readInt(), (MaskedWallet) C5064i.m21520a(parcel, MaskedWallet.CREATOR), (Bundle) C5064i.m21520a(parcel, Bundle.CREATOR));
                break;
            case 2:
                mo6218a(parcel.readInt(), (FullWallet) C5064i.m21520a(parcel, FullWallet.CREATOR), (Bundle) C5064i.m21520a(parcel, Bundle.CREATOR));
                break;
            case 3:
                mo6220a(parcel.readInt(), C5064i.m21523a(parcel), (Bundle) C5064i.m21520a(parcel, Bundle.CREATOR));
                break;
            case 4:
                mo6217a(parcel.readInt(), (Bundle) C5064i.m21520a(parcel, Bundle.CREATOR));
                break;
            case 6:
                mo6228b(parcel.readInt(), C5064i.m21523a(parcel), (Bundle) C5064i.m21520a(parcel, Bundle.CREATOR));
                break;
            case 7:
                mo6222a((Status) C5064i.m21520a(parcel, Status.CREATOR), (C7831l) C5064i.m21520a(parcel, C7831l.CREATOR), (Bundle) C5064i.m21520a(parcel, Bundle.CREATOR));
                break;
            case 8:
                mo6221a((Status) C5064i.m21520a(parcel, Status.CREATOR), (Bundle) C5064i.m21520a(parcel, Bundle.CREATOR));
                break;
            case 9:
                mo6227a((Status) C5064i.m21520a(parcel, Status.CREATOR), C5064i.m21523a(parcel), (Bundle) C5064i.m21520a(parcel, Bundle.CREATOR));
                break;
            case 10:
                mo6223a((Status) C5064i.m21520a(parcel, Status.CREATOR), (C7832n) C5064i.m21520a(parcel, C7832n.CREATOR), (Bundle) C5064i.m21520a(parcel, Bundle.CREATOR));
                break;
            case 11:
                mo6229b((Status) C5064i.m21520a(parcel, Status.CREATOR), (Bundle) C5064i.m21520a(parcel, Bundle.CREATOR));
                break;
            case 12:
                mo6225a((Status) C5064i.m21520a(parcel, Status.CREATOR), (ai) C5064i.m21520a(parcel, ai.CREATOR), (Bundle) C5064i.m21520a(parcel, Bundle.CREATOR));
                break;
            case 13:
                mo6230c((Status) C5064i.m21520a(parcel, Status.CREATOR), (Bundle) C5064i.m21520a(parcel, Bundle.CREATOR));
                break;
            case 14:
                mo6226a((Status) C5064i.m21520a(parcel, Status.CREATOR), (C7877i) C5064i.m21520a(parcel, C7877i.CREATOR), (Bundle) C5064i.m21520a(parcel, Bundle.CREATOR));
                break;
            case 15:
                mo6224a((Status) C5064i.m21520a(parcel, Status.CREATOR), (C7833p) C5064i.m21520a(parcel, C7833p.CREATOR), (Bundle) C5064i.m21520a(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
