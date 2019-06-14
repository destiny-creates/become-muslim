package com.google.android.exoplayer2.p157i.p198c;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.exoplayer2.p157i.C2458b;
import com.google.android.exoplayer2.p157i.C2464e;
import com.google.android.exoplayer2.p157i.C4725c;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2522g;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: SsaDecoder */
/* renamed from: com.google.android.exoplayer2.i.c.a */
public final class C4861a extends C4725c {
    /* renamed from: a */
    private static final Pattern f13883a = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    /* renamed from: b */
    private final boolean f13884b;
    /* renamed from: c */
    private int f13885c;
    /* renamed from: d */
    private int f13886d;
    /* renamed from: e */
    private int f13887e;
    /* renamed from: f */
    private int f13888f;

    /* renamed from: a */
    protected /* synthetic */ C2464e mo3431a(byte[] bArr, int i, boolean z) {
        return m17367b(bArr, i, z);
    }

    public C4861a() {
        this(null);
    }

    public C4861a(List<byte[]> list) {
        super("SsaDecoder");
        if (list == null || list.isEmpty()) {
            this.f13884b = false;
            return;
        }
        this.f13884b = true;
        String str = new String((byte[]) list.get(0));
        C2516a.m7017a(str.startsWith("Format: "));
        m17365b(str);
        m17362a(new C2529l((byte[]) list.get(1)));
    }

    /* renamed from: b */
    protected C4226b m17367b(byte[] bArr, int i, boolean z) {
        List arrayList = new ArrayList();
        C2522g c2522g = new C2522g();
        C2529l c2529l = new C2529l(bArr, i);
        if (this.f13884b == null) {
            m17362a(c2529l);
        }
        m17363a(c2529l, arrayList, c2522g);
        bArr = new C2458b[arrayList.size()];
        arrayList.toArray(bArr);
        return new C4226b(bArr, c2522g.m7046b());
    }

    /* renamed from: a */
    private void m17362a(C2529l c2529l) {
        String z;
        do {
            z = c2529l.m7122z();
            if (z == null) {
                return;
            }
        } while (!z.startsWith("[Events]"));
    }

    /* renamed from: a */
    private void m17363a(C2529l c2529l, List<C2458b> list, C2522g c2522g) {
        while (true) {
            String z = c2529l.m7122z();
            if (z == null) {
                return;
            }
            if (!this.f13884b && z.startsWith("Format: ")) {
                m17365b(z);
            } else if (z.startsWith("Dialogue: ")) {
                m17364a(z, (List) list, c2522g);
            }
        }
    }

    /* renamed from: b */
    private void m17365b(String str) {
        str = TextUtils.split(str.substring("Format: ".length()), ",");
        this.f13885c = str.length;
        this.f13886d = -1;
        this.f13887e = -1;
        this.f13888f = -1;
        for (int i = 0; i < this.f13885c; i++) {
            Object obj;
            String d = C2541v.m7190d(str[i].trim());
            int hashCode = d.hashCode();
            if (hashCode != 100571) {
                if (hashCode != 3556653) {
                    if (hashCode == 109757538) {
                        if (d.equals(ViewProps.START)) {
                            obj = null;
                            switch (obj) {
                                case null:
                                    this.f13886d = i;
                                    break;
                                case 1:
                                    this.f13887e = i;
                                    break;
                                case 2:
                                    this.f13888f = i;
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                } else if (d.equals("text")) {
                    obj = 2;
                    switch (obj) {
                        case null:
                            this.f13886d = i;
                            break;
                        case 1:
                            this.f13887e = i;
                            break;
                        case 2:
                            this.f13888f = i;
                            break;
                        default:
                            break;
                    }
                }
            } else if (d.equals(ViewProps.END)) {
                obj = 1;
                switch (obj) {
                    case null:
                        this.f13886d = i;
                        break;
                    case 1:
                        this.f13887e = i;
                        break;
                    case 2:
                        this.f13888f = i;
                        break;
                    default:
                        break;
                }
            }
            obj = -1;
            switch (obj) {
                case null:
                    this.f13886d = i;
                    break;
                case 1:
                    this.f13887e = i;
                    break;
                case 2:
                    this.f13888f = i;
                    break;
                default:
                    break;
            }
        }
        if (this.f13886d == -1 || this.f13887e == -1 || this.f13888f == -1) {
            this.f13885c = 0;
        }
    }

    /* renamed from: a */
    private void m17364a(String str, List<C2458b> list, C2522g c2522g) {
        if (this.f13885c == 0) {
            c2522g = new StringBuilder();
            c2522g.append("Skipping dialogue line before complete format: ");
            c2522g.append(str);
            Log.w("SsaDecoder", c2522g.toString());
            return;
        }
        String[] split = str.substring("Dialogue: ".length()).split(",", this.f13885c);
        if (split.length != this.f13885c) {
            c2522g = new StringBuilder();
            c2522g.append("Skipping dialogue line with fewer columns than format: ");
            c2522g.append(str);
            Log.w("SsaDecoder", c2522g.toString());
            return;
        }
        long a = C4861a.m17361a(split[this.f13886d]);
        if (a == -9223372036854775807L) {
            c2522g = new StringBuilder();
            c2522g.append("Skipping invalid timing: ");
            c2522g.append(str);
            Log.w("SsaDecoder", c2522g.toString());
            return;
        }
        long j;
        String str2 = split[this.f13887e];
        if (str2.trim().isEmpty()) {
            j = -9223372036854775807L;
        } else {
            j = C4861a.m17361a(str2);
            if (j == -9223372036854775807L) {
                c2522g = new StringBuilder();
                c2522g.append("Skipping invalid timing: ");
                c2522g.append(str);
                Log.w("SsaDecoder", c2522g.toString());
                return;
            }
        }
        list.add(new C2458b(split[this.f13888f].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE).replaceAll("\\\\n", ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)));
        c2522g.m7045a(a);
        if (j != -9223372036854775807L) {
            list.add(null);
            c2522g.m7045a(j);
        }
    }

    /* renamed from: a */
    public static long m17361a(String str) {
        str = f13883a.matcher(str);
        if (str.matches()) {
            return (((((Long.parseLong(str.group(1)) * 60) * 60) * 1000000) + ((Long.parseLong(str.group(2)) * 60) * 1000000)) + (Long.parseLong(str.group(3)) * 1000000)) + (Long.parseLong(str.group(4)) * 10000);
        }
        return -9223372036854775807L;
    }
}
