package com.p079e.p080a;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import com.facebook.common.util.UriUtil;
import com.p079e.p080a.C1236t.C1233d;
import com.p079e.p080a.C1245y.C1244a;
import java.io.InputStream;

/* compiled from: ContactsPhotoRequestHandler */
/* renamed from: com.e.a.f */
class C3502f extends C1245y {
    /* renamed from: a */
    private static final UriMatcher f9333a = new UriMatcher(-1);
    /* renamed from: b */
    private final Context f9334b;

    @TargetApi(14)
    /* compiled from: ContactsPhotoRequestHandler */
    /* renamed from: com.e.a.f$a */
    private static class C1213a {
        /* renamed from: a */
        static InputStream m4261a(ContentResolver contentResolver, Uri uri) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }

    static {
        f9333a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f9333a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f9333a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f9333a.addURI("com.android.contacts", "contacts/#", 3);
        f9333a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    C3502f(Context context) {
        this.f9334b = context;
    }

    /* renamed from: a */
    public boolean mo821a(C1242w c1242w) {
        Uri uri = c1242w.f3540d;
        return (UriUtil.LOCAL_CONTENT_SCHEME.equals(uri.getScheme()) && Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f9333a.match(c1242w.f3540d) != -1) ? true : null;
    }

    /* renamed from: a */
    public C1244a mo820a(C1242w c1242w, int i) {
        InputStream b = m11291b(c1242w);
        return b != null ? new C1244a(b, C1233d.DISK) : 0;
    }

    /* renamed from: b */
    private InputStream m11291b(C1242w c1242w) {
        ContentResolver contentResolver = this.f9334b.getContentResolver();
        c1242w = c1242w.f3540d;
        switch (f9333a.match(c1242w)) {
            case 1:
                c1242w = Contacts.lookupContact(contentResolver, c1242w);
                if (c1242w == null) {
                    return null;
                }
                break;
            case 2:
            case 4:
                return contentResolver.openInputStream(c1242w);
            case 3:
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid uri: ");
                stringBuilder.append(c1242w);
                throw new IllegalStateException(stringBuilder.toString());
        }
        if (VERSION.SDK_INT < 14) {
            return Contacts.openContactPhotoInputStream(contentResolver, c1242w);
        }
        return C1213a.m4261a(contentResolver, c1242w);
    }
}
