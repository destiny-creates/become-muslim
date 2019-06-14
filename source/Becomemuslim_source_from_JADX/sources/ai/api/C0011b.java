package ai.api;

import ai.api.p006b.C0010a;
import ai.api.p007c.C0013c;
import ai.api.p007c.C0019h;
import ai.api.p007c.C3090b;
import ai.api.p009e.C0029a;
import ai.api.p009e.C0031c;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.server.http.HttpHeaders;
import com.google.p127a.C2157f;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.p378b.p379a.C6650b;
import org.apache.p378b.p379a.C6657c;

/* compiled from: AIDataService */
/* renamed from: ai.api.b */
public class C0011b {
    /* renamed from: a */
    static final /* synthetic */ boolean f45a = (C0011b.class.desiredAssertionStatus() ^ 1);
    /* renamed from: b */
    private static final C6657c f46b = C6650b.a(C0011b.class);
    /* renamed from: c */
    private static final C0028d f47c = null;
    /* renamed from: d */
    private static final C2157f f48d = C0038g.m111b().m113a();
    /* renamed from: e */
    private final C0009a f49e;
    /* renamed from: f */
    private final C0028d f50f;

    public C0011b(C0009a c0009a, C0028d c0028d) {
        if (c0009a != null) {
            this.f49e = c0009a.m31f();
            if (c0028d == null) {
                this.f50f = new C0035e().m108a().m109b();
                return;
            } else {
                this.f50f = c0028d;
                return;
            }
        }
        throw new IllegalArgumentException("config should not be null");
    }

    /* renamed from: a */
    public C0013c m42a(C3090b c3090b) {
        return m43a(c3090b, (C0044j) null);
    }

    /* renamed from: a */
    public C0013c m43a(C3090b c3090b, C0044j c0044j) {
        return m44a(c3090b, c0044j, f47c);
    }

    /* renamed from: a */
    public C0013c m44a(C3090b c3090b, C0044j c0044j, C0028d c0028d) {
        if (c3090b != null) {
            f46b.a("Start request");
            try {
                c3090b.m59c(this.f49e.m28c());
                c3090b.m60d(m39a(c0028d));
                if (C0031c.m89a(c3090b.m54a())) {
                    c3090b.m57b(m40b(c0028d));
                }
                Map map = null;
                if (c0044j != null) {
                    m41b(c3090b, c0044j);
                    map = c0044j.m117c();
                }
                String a = m49a(this.f49e.m26a(m39a(c0028d)), f48d.m5979a((Object) c3090b), map);
                if (C0031c.m89a(a) == null) {
                    c0044j = f46b;
                    c0028d = new StringBuilder();
                    c0028d.append("Response json: ");
                    c0028d.append(a.replaceAll("[\r\n]+", " "));
                    c0044j.a(c0028d.toString());
                    C0013c c0013c = (C0013c) f48d.m5976a(a, C0013c.class);
                    if (c0013c == null) {
                        throw new C0036f("API.AI response parsed as null. Check debug log for details.");
                    } else if (c0013c.m52b() == null) {
                        c0013c.m53c();
                        return c0013c;
                    } else {
                        throw new C0036f(c0013c);
                    }
                }
                throw new C0036f("Empty response from ai service. Please check configuration and Internet connection.");
            } catch (C3090b c3090b2) {
                f46b.a("Malformed url should not be raised", c3090b2);
                throw new C0036f("Wrong configuration. Please, connect to API.AI Service support", c3090b2);
            } catch (C3090b c3090b22) {
                throw new C0036f("Wrong service answer format. Please, connect to API.AI Service support", c3090b22);
            }
        }
        throw new IllegalArgumentException("Request argument must not be null");
    }

    /* renamed from: a */
    public C0013c m45a(InputStream inputStream, C0044j c0044j) {
        return m46a(inputStream, c0044j, f47c);
    }

    /* renamed from: a */
    public C0013c m46a(InputStream inputStream, C0044j c0044j, C0028d c0028d) {
        if (!f45a) {
            if (inputStream == null) {
                throw new AssertionError();
            }
        }
        f46b.a("Start voice request");
        try {
            Object c3090b = new C3090b();
            c3090b.m59c(this.f49e.m28c());
            c3090b.m60d(m39a(c0028d));
            c3090b.m57b((String) m40b(c0028d));
            Map map = null;
            if (c0044j != null) {
                m41b(c3090b, c0044j);
                map = c0044j.m117c();
            }
            String a = f48d.m5979a(c3090b);
            C6657c c6657c = f46b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Request json: ");
            stringBuilder.append(a);
            c6657c.a(stringBuilder.toString());
            String a2 = m47a(inputStream, a, map);
            if (C0031c.m89a(a2) == null) {
                c0044j = f46b;
                c0028d = new StringBuilder();
                c0028d.append("Response json: ");
                c0028d.append(a2);
                c0044j.a(c0028d.toString());
                C0013c c0013c = (C0013c) f48d.m5976a(a2, C0013c.class);
                if (c0013c == null) {
                    throw new C0036f("API.AI response parsed as null. Check debug log for details.");
                } else if (c0013c.m52b() == null) {
                    c0013c.m53c();
                    return c0013c;
                } else {
                    throw new C0036f(c0013c);
                }
            }
            throw new C0036f("Empty response from ai service. Please check configuration.");
        } catch (InputStream inputStream2) {
            f46b.a("Malformed url should not be raised", inputStream2);
            throw new C0036f("Wrong configuration. Please, connect to AI Service support", inputStream2);
        } catch (InputStream inputStream22) {
            throw new C0036f("Wrong service answer format. Please, connect to API.AI Service support", inputStream22);
        }
    }

    /* renamed from: a */
    protected String m49a(String str, String str2, Map<String, String> map) {
        if (!f45a) {
            if (str == null) {
                throw new AssertionError();
            }
        }
        if (!f45a) {
            if (str2 == null) {
                throw new AssertionError();
            }
        }
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(str);
            str = f46b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Request json: ");
            stringBuilder.append(str2);
            str.a(stringBuilder.toString());
            if (this.f49e.m30e() != null) {
                str = (HttpURLConnection) url.openConnection(this.f49e.m30e());
            } else {
                str = (HttpURLConnection) url.openConnection();
            }
            String str3 = str;
            str3.setRequestMethod("POST");
            str3.setDoOutput(true);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Bearer ");
            stringBuilder2.append(this.f49e.m25a());
            str3.addRequestProperty("Authorization", stringBuilder2.toString());
            str3.addRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
            str3.addRequestProperty("Accept", "application/json");
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    str3.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            str3.connect();
            OutputStream bufferedOutputStream = new BufferedOutputStream(str3.getOutputStream());
            C0029a.m83a(str2, bufferedOutputStream);
            bufferedOutputStream.close();
            InputStream bufferedInputStream = new BufferedInputStream(str3.getInputStream());
            str2 = C0029a.m80a(bufferedInputStream);
            bufferedInputStream.close();
            if (str3 != null) {
                str3.disconnect();
            }
            return str2;
        } catch (String str4) {
            if (httpURLConnection != null) {
                InputStream errorStream = httpURLConnection.getErrorStream();
                if (errorStream != null) {
                    str2 = C0029a.m80a(errorStream);
                    f46b.a(str2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return str2;
                }
                throw new C0036f("Can't connect to the api.ai service.", str4);
            }
        } catch (String str22) {
            f46b.d("Can't read error response", str22);
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        f46b.a("Can't make request to the API.AI service. Please, check connection settings and API access token.", str4);
        throw new C0036f("Can't make request to the API.AI service. Please, check connection settings and API access token.", str4);
    }

    /* renamed from: a */
    protected String m47a(InputStream inputStream, String str, Map<String, String> map) {
        return m48a(inputStream, str, map, f47c);
    }

    /* renamed from: a */
    protected String m48a(InputStream inputStream, String str, Map<String, String> map, C0028d c0028d) {
        C0013c c0013c;
        if (!f45a) {
            if (inputStream == null) {
                throw new AssertionError();
            }
        }
        if (!f45a) {
            if (str == null) {
                throw new AssertionError();
            }
        }
        C0010a c0010a = null;
        try {
            URL url = new URL(this.f49e.m26a(m39a(c0028d)));
            f46b.a("Connecting to {}", new Object[]{url});
            if (this.f49e.m30e() != null) {
                c0028d = (HttpURLConnection) url.openConnection(this.f49e.m30e());
            } else {
                c0028d = (HttpURLConnection) url.openConnection();
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Bearer ");
                stringBuilder.append(this.f49e.m25a());
                c0028d.addRequestProperty("Authorization", stringBuilder.toString());
                c0028d.addRequestProperty("Accept", "application/json");
                if (map != null) {
                    map = map.entrySet().iterator();
                    while (map.hasNext()) {
                        Entry entry = (Entry) map.next();
                        c0028d.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                c0028d.setRequestMethod("POST");
                c0028d.setDoInput(true);
                c0028d.setDoOutput(true);
                map = new C0010a(c0028d);
                try {
                    map.m35a(this.f49e.m29d());
                    map.m32a();
                    map.m33a(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, str);
                    map.m34a("voiceData", "voice.wav", inputStream);
                    map.m36b();
                    inputStream = map.m37c();
                    if (c0028d != null) {
                        c0028d.disconnect();
                    }
                    return inputStream;
                } catch (IOException e) {
                    inputStream = e;
                    c0010a = map;
                    if (c0010a != null) {
                        try {
                            str = c0010a.m38d();
                            f46b.a(str);
                            if (C0031c.m89a(str) != null) {
                                if (c0028d != null) {
                                    c0028d.disconnect();
                                }
                                return str;
                            } else if ((inputStream instanceof HttpRetryException) != null) {
                                c0013c = new C0013c();
                                map = C0019h.m65a(((HttpRetryException) inputStream).responseCode());
                                map.m70b(((HttpRetryException) inputStream).getReason());
                                c0013c.m51a(map);
                                throw new C0036f(c0013c);
                            }
                        } catch (Throwable th) {
                            inputStream = th;
                            if (c0028d != null) {
                                c0028d.disconnect();
                            }
                            throw inputStream;
                        }
                    }
                    f46b.a("Can't make request to the API.AI service. Please, check connection settings and API.AI keys.", inputStream);
                    throw new C0036f("Can't make request to the API.AI service. Please, check connection settings and API.AI keys.", inputStream);
                }
            } catch (IOException e2) {
                inputStream = e2;
                if (c0010a != null) {
                    str = c0010a.m38d();
                    f46b.a(str);
                    if (C0031c.m89a(str) != null) {
                        if (c0028d != null) {
                            c0028d.disconnect();
                        }
                        return str;
                    } else if ((inputStream instanceof HttpRetryException) != null) {
                        c0013c = new C0013c();
                        map = C0019h.m65a(((HttpRetryException) inputStream).responseCode());
                        map.m70b(((HttpRetryException) inputStream).getReason());
                        c0013c.m51a(map);
                        throw new C0036f(c0013c);
                    }
                }
                f46b.a("Can't make request to the API.AI service. Please, check connection settings and API.AI keys.", inputStream);
                throw new C0036f("Can't make request to the API.AI service. Please, check connection settings and API.AI keys.", inputStream);
            }
        } catch (IOException e3) {
            inputStream = e3;
            c0028d = null;
            if (c0010a != null) {
                str = c0010a.m38d();
                f46b.a(str);
                if (C0031c.m89a(str) != null) {
                    if (c0028d != null) {
                        c0028d.disconnect();
                    }
                    return str;
                } else if ((inputStream instanceof HttpRetryException) != null) {
                    c0013c = new C0013c();
                    map = C0019h.m65a(((HttpRetryException) inputStream).responseCode());
                    map.m70b(((HttpRetryException) inputStream).getReason());
                    c0013c.m51a(map);
                    throw new C0036f(c0013c);
                }
            }
            f46b.a("Can't make request to the API.AI service. Please, check connection settings and API.AI keys.", inputStream);
            throw new C0036f("Can't make request to the API.AI service. Please, check connection settings and API.AI keys.", inputStream);
        } catch (Throwable th2) {
            inputStream = th2;
            c0028d = null;
            if (c0028d != null) {
                c0028d.disconnect();
            }
            throw inputStream;
        }
    }

    /* renamed from: b */
    private void m41b(C3090b c3090b, C0044j c0044j) {
        if (!f45a) {
            if (c3090b == null) {
                throw new AssertionError();
            }
        }
        if (!f45a) {
            if (c0044j == null) {
                throw new AssertionError();
            }
        }
        if (c0044j.m119e()) {
            c3090b.m9037a(c0044j.m115a());
        }
        if (c0044j.m120f()) {
            c3090b.m58b(c0044j.m116b());
        }
        if (c0044j.m118d() != null) {
            c3090b.m55a(c0044j.m118d());
        }
    }

    /* renamed from: a */
    private String m39a(C0028d c0028d) {
        if (c0028d != null) {
            return c0028d.mo2a();
        }
        return this.f50f.mo2a();
    }

    /* renamed from: b */
    private String m40b(C0028d c0028d) {
        if (c0028d != null) {
            c0028d = c0028d.mo3b();
        } else {
            c0028d = this.f50f.mo3b();
        }
        if (c0028d == null) {
            c0028d = Calendar.getInstance().getTimeZone();
        }
        return c0028d.getID();
    }
}
