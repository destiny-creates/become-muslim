package host.exp.exponent.p339f;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import expolib_v1.p321a.C6214d;
import expolib_v1.p321a.C6246z.C6245a;
import host.exp.exponent.p343g.C6363c;
import host.exp.exponent.p343g.C6368f;
import host.exp.p333a.C6271b;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.inject.C6562a;
import org.spongycastle.util.encoders.Base64;

/* compiled from: Crypto */
/* renamed from: host.exp.exponent.f.a */
public class C6329a {
    /* renamed from: a */
    C6368f f20567a;

    /* compiled from: Crypto */
    /* renamed from: host.exp.exponent.f.a$a */
    public interface C6322a {
        /* renamed from: a */
        void mo5416a(String str, boolean z);

        /* renamed from: a */
        void mo5417a(boolean z);
    }

    @C6562a
    public C6329a(C6368f c6368f) {
        this.f20567a = c6368f;
    }

    /* renamed from: a */
    public void m26046a(String str, String str2, String str3, C6322a c6322a) {
        m26043a(true, str, str2, str3, c6322a);
    }

    /* renamed from: a */
    private void m26043a(boolean z, String str, String str2, String str3, C6322a c6322a) {
        final C6322a c6322a2 = c6322a;
        final String str4 = str2;
        final String str5 = str3;
        final boolean z2 = z;
        final String str6 = str;
        this.f20567a.m26115a().m26103a(new C6245a().m25814a(str).m25810a(z ? C6214d.f20164b : C6214d.f20163a).m25820b(), new C6363c(this) {
            /* renamed from: f */
            final /* synthetic */ C6329a f26145f;

            /* renamed from: a */
            public void mo5371a(IOException iOException) {
                c6322a2.mo5416a(iOException.toString(), true);
            }

            /* renamed from: a */
            public void mo5370a(host.exp.exponent.p343g.C6364d r8) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r7 = this;
                r0 = r7.f26145f;	 Catch:{ NoSuchPaddingException -> 0x002a, NoSuchAlgorithmException -> 0x0027, InvalidKeySpecException -> 0x0024, InvalidKeyException -> 0x0021, BadPaddingException -> 0x001e, IllegalBlockSizeException -> 0x001b, Exception -> 0x0018 }
                r8 = r8.mo5424b();	 Catch:{ NoSuchPaddingException -> 0x002a, NoSuchAlgorithmException -> 0x0027, InvalidKeySpecException -> 0x0024, InvalidKeyException -> 0x0021, BadPaddingException -> 0x001e, IllegalBlockSizeException -> 0x001b, Exception -> 0x0018 }
                r8 = r8.mo5419a();	 Catch:{ NoSuchPaddingException -> 0x002a, NoSuchAlgorithmException -> 0x0027, InvalidKeySpecException -> 0x0024, InvalidKeyException -> 0x0021, BadPaddingException -> 0x001e, IllegalBlockSizeException -> 0x001b, Exception -> 0x0018 }
                r1 = r5;	 Catch:{ NoSuchPaddingException -> 0x002a, NoSuchAlgorithmException -> 0x0027, InvalidKeySpecException -> 0x0024, InvalidKeyException -> 0x0021, BadPaddingException -> 0x001e, IllegalBlockSizeException -> 0x001b, Exception -> 0x0018 }
                r2 = r6;	 Catch:{ NoSuchPaddingException -> 0x002a, NoSuchAlgorithmException -> 0x0027, InvalidKeySpecException -> 0x0024, InvalidKeyException -> 0x0021, BadPaddingException -> 0x001e, IllegalBlockSizeException -> 0x001b, Exception -> 0x0018 }
                r8 = r0.m26045a(r8, r1, r2);	 Catch:{ NoSuchPaddingException -> 0x002a, NoSuchAlgorithmException -> 0x0027, InvalidKeySpecException -> 0x0024, InvalidKeyException -> 0x0021, BadPaddingException -> 0x001e, IllegalBlockSizeException -> 0x001b, Exception -> 0x0018 }
                r0 = r4;	 Catch:{ NoSuchPaddingException -> 0x002a, NoSuchAlgorithmException -> 0x0027, InvalidKeySpecException -> 0x0024, InvalidKeyException -> 0x0021, BadPaddingException -> 0x001e, IllegalBlockSizeException -> 0x001b, Exception -> 0x0018 }
                r0.mo5417a(r8);	 Catch:{ NoSuchPaddingException -> 0x002a, NoSuchAlgorithmException -> 0x0027, InvalidKeySpecException -> 0x0024, InvalidKeyException -> 0x0021, BadPaddingException -> 0x001e, IllegalBlockSizeException -> 0x001b, Exception -> 0x0018 }
                return;
            L_0x0018:
                r8 = "Error verifying.";
                goto L_0x002c;
            L_0x001b:
                r8 = "Error verifying.";
                goto L_0x002c;
            L_0x001e:
                r8 = "Error verifying.";
                goto L_0x002c;
            L_0x0021:
                r8 = "Error verifying.";
                goto L_0x002c;
            L_0x0024:
                r8 = "Error verifying.";
                goto L_0x002c;
            L_0x0027:
                r8 = "Error with RSA key.";
                goto L_0x002c;
            L_0x002a:
                r8 = "Error with RSA key.";
            L_0x002c:
                r0 = r7;
                if (r0 == 0) goto L_0x003f;
            L_0x0030:
                r1 = r7.f26145f;
                r2 = 0;
                r3 = r8;
                r4 = r5;
                r5 = r6;
                r6 = r4;
                r1.m26043a(r2, r3, r4, r5, r6);
                goto L_0x0045;
            L_0x003f:
                r0 = r4;
                r1 = 0;
                r0.mo5416a(r8, r1);
            L_0x0045:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.f.a.1.a(host.exp.exponent.g.d):void");
            }
        });
    }

    /* renamed from: a */
    private boolean m26045a(String str, String str2, String str3) {
        String str4 = "";
        for (String str5 : str.split("\\r?\\n")) {
            if (!str5.contains("PUBLIC KEY-----")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str4);
                stringBuilder.append(str5);
                stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                str4 = stringBuilder.toString();
            }
        }
        str = Signature.getInstance("SHA256withRSA", C6271b.m25906e());
        KeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.m29431a(str4));
        str.initVerify(KeyFactory.getInstance(x509EncodedKeySpec.getFormat()).generatePublic(x509EncodedKeySpec));
        str.update(str2.getBytes());
        return str.verify(Base64.m29431a(str3));
    }
}
