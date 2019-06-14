package org.apache.p378b.p379a.p383e;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import org.apache.p378b.p379a.C6657c;
import org.apache.p378b.p379a.p382d.C8277c;

/* compiled from: PropertiesUtil */
/* renamed from: org.apache.b.a.e.b */
public final class C6666b {
    /* renamed from: a */
    private static final C6666b f21411a = new C6666b("log4j2.component.properties");
    /* renamed from: b */
    private static final C6657c f21412b = C8277c.m42922c();
    /* renamed from: c */
    private final Properties f21413c;

    /* renamed from: a */
    static Properties m27117a(InputStream inputStream, Object obj) {
        C6657c c6657c;
        String str;
        Object[] objArr;
        Properties properties = new Properties();
        if (inputStream != null) {
            try {
                properties.load(inputStream);
                try {
                    inputStream.close();
                } catch (InputStream inputStream2) {
                    c6657c = f21412b;
                    str = "Unable to close {}";
                    objArr = new Object[]{obj, inputStream2};
                    c6657c.mo6431b(str, objArr);
                    return properties;
                }
            } catch (IOException e) {
                f21412b.mo6431b("Unable to read {}", obj, e);
                try {
                    inputStream2.close();
                } catch (InputStream inputStream22) {
                    c6657c = f21412b;
                    str = "Unable to close {}";
                    objArr = new Object[]{obj, inputStream22};
                    c6657c.mo6431b(str, objArr);
                    return properties;
                }
            } catch (Throwable th) {
                try {
                    inputStream22.close();
                } catch (InputStream inputStream222) {
                    f21412b.mo6431b("Unable to close {}", obj, inputStream222);
                }
                throw th;
            }
        }
        return properties;
    }

    public C6666b(String str) {
        InputStream openStream;
        C6657c c6657c;
        String str2;
        Object[] objArr;
        IOException e;
        Properties properties = new Properties();
        for (URL openStream2 : C6665a.m27114b(str)) {
            try {
                openStream = openStream2.openStream();
                try {
                    properties.load(openStream);
                    if (openStream != null) {
                        try {
                            openStream.close();
                        } catch (IOException e2) {
                            c6657c = f21412b;
                            str2 = "Unable to close {}";
                            objArr = new Object[]{openStream2.toString(), e2};
                            c6657c.mo6431b(str2, objArr);
                        }
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        f21412b.mo6431b("Unable to read {}", openStream2.toString(), e2);
                        if (openStream != null) {
                            try {
                                openStream.close();
                            } catch (IOException e22) {
                                c6657c = f21412b;
                                str2 = "Unable to close {}";
                                objArr = new Object[]{openStream2.toString(), e22};
                                c6657c.mo6431b(str2, objArr);
                            }
                        }
                    } catch (Throwable th) {
                        str = th;
                    }
                }
            } catch (IOException e4) {
                IOException iOException = e4;
                openStream = null;
                e22 = iOException;
                f21412b.mo6431b("Unable to read {}", openStream2.toString(), e22);
                if (openStream != null) {
                    openStream.close();
                }
            } catch (Throwable th2) {
                str = th2;
                openStream = null;
            }
        }
        this.f21413c = properties;
        return;
        if (openStream != null) {
            try {
                openStream.close();
            } catch (IOException e5) {
                f21412b.mo6431b("Unable to close {}", openStream2.toString(), e5);
            }
        }
        throw str;
        throw str;
    }

    /* renamed from: a */
    public static C6666b m27118a() {
        return f21411a;
    }

    /* renamed from: a */
    public java.lang.String m27120a(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = java.lang.System.getProperty(r2);	 Catch:{ SecurityException -> 0x0005 }
        goto L_0x0006;
    L_0x0005:
        r0 = 0;
    L_0x0006:
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r1.f21413c;
        r0 = r0.getProperty(r2);
    L_0x000e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.b.a.e.b.a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public int m27119a(java.lang.String r2, int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = java.lang.System.getProperty(r2);	 Catch:{ SecurityException -> 0x0005 }
        goto L_0x0006;
    L_0x0005:
        r0 = 0;
    L_0x0006:
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r1.f21413c;
        r0 = r0.getProperty(r2);
    L_0x000e:
        if (r0 == 0) goto L_0x0016;
    L_0x0010:
        r2 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x0015 }
        return r2;
    L_0x0015:
        return r3;
    L_0x0016:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.b.a.e.b.a(java.lang.String, int):int");
    }

    /* renamed from: a */
    public String m27121a(String str, String str2) {
        str = m27120a(str);
        return str == null ? str2 : str;
    }

    /* renamed from: b */
    public boolean m27123b(String str) {
        return m27122a(str, false);
    }

    /* renamed from: a */
    public boolean m27122a(String str, boolean z) {
        str = m27120a(str);
        return str == null ? z : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str);
    }
}
