package com.google.p217b.p231e;

import com.facebook.stetho.server.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EANManufacturerOrgSupport */
/* renamed from: com.google.b.e.m */
final class C5250m {
    /* renamed from: a */
    private final List<int[]> f17710a = new ArrayList();
    /* renamed from: b */
    private final List<String> f17711b = new ArrayList();

    C5250m() {
    }

    /* renamed from: a */
    String m22233a(String str) {
        m22231a();
        str = Integer.parseInt(str.substring(0, 3));
        int size = this.f17710a.size();
        for (int i = 0; i < size; i++) {
            int[] iArr = (int[]) this.f17710a.get(i);
            int i2 = iArr[0];
            if (str < i2) {
                return null;
            }
            if (iArr.length != 1) {
                i2 = iArr[1];
            }
            if (str <= i2) {
                return (String) this.f17711b.get(i);
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m22232a(int[] iArr, String str) {
        this.f17710a.add(iArr);
        this.f17711b.add(str);
    }

    /* renamed from: a */
    private synchronized void m22231a() {
        if (this.f17710a.isEmpty()) {
            m22232a(new int[]{0, 19}, "US/CA");
            m22232a(new int[]{30, 39}, "US");
            m22232a(new int[]{60, 139}, "US/CA");
            m22232a(new int[]{300, 379}, "FR");
            m22232a(new int[]{380}, "BG");
            m22232a(new int[]{383}, "SI");
            m22232a(new int[]{385}, "HR");
            m22232a(new int[]{387}, "BA");
            m22232a(new int[]{400, 440}, "DE");
            m22232a(new int[]{450, 459}, "JP");
            m22232a(new int[]{460, 469}, "RU");
            m22232a(new int[]{471}, "TW");
            m22232a(new int[]{474}, "EE");
            m22232a(new int[]{475}, "LV");
            m22232a(new int[]{476}, "AZ");
            m22232a(new int[]{477}, "LT");
            m22232a(new int[]{478}, "UZ");
            m22232a(new int[]{479}, "LK");
            m22232a(new int[]{480}, "PH");
            m22232a(new int[]{481}, "BY");
            m22232a(new int[]{482}, "UA");
            m22232a(new int[]{484}, "MD");
            m22232a(new int[]{485}, "AM");
            m22232a(new int[]{486}, "GE");
            m22232a(new int[]{487}, "KZ");
            m22232a(new int[]{489}, "HK");
            m22232a(new int[]{490, 499}, "JP");
            m22232a(new int[]{HttpStatus.HTTP_INTERNAL_SERVER_ERROR, 509}, "GB");
            m22232a(new int[]{520}, "GR");
            m22232a(new int[]{528}, "LB");
            m22232a(new int[]{529}, "CY");
            m22232a(new int[]{531}, "MK");
            m22232a(new int[]{535}, "MT");
            m22232a(new int[]{539}, "IE");
            m22232a(new int[]{540, 549}, "BE/LU");
            m22232a(new int[]{560}, "PT");
            m22232a(new int[]{569}, "IS");
            m22232a(new int[]{570, 579}, "DK");
            m22232a(new int[]{590}, "PL");
            m22232a(new int[]{594}, "RO");
            m22232a(new int[]{599}, "HU");
            m22232a(new int[]{600, 601}, "ZA");
            m22232a(new int[]{603}, "GH");
            m22232a(new int[]{608}, "BH");
            m22232a(new int[]{609}, "MU");
            m22232a(new int[]{611}, "MA");
            m22232a(new int[]{613}, "DZ");
            m22232a(new int[]{616}, "KE");
            m22232a(new int[]{618}, "CI");
            m22232a(new int[]{619}, "TN");
            m22232a(new int[]{621}, "SY");
            m22232a(new int[]{622}, "EG");
            m22232a(new int[]{624}, "LY");
            m22232a(new int[]{625}, "JO");
            m22232a(new int[]{626}, "IR");
            m22232a(new int[]{627}, "KW");
            m22232a(new int[]{628}, "SA");
            m22232a(new int[]{629}, "AE");
            m22232a(new int[]{640, 649}, "FI");
            m22232a(new int[]{690, 695}, "CN");
            m22232a(new int[]{700, 709}, "NO");
            m22232a(new int[]{729}, "IL");
            m22232a(new int[]{730, 739}, "SE");
            m22232a(new int[]{740}, "GT");
            m22232a(new int[]{741}, "SV");
            m22232a(new int[]{742}, "HN");
            m22232a(new int[]{743}, "NI");
            m22232a(new int[]{744}, "CR");
            m22232a(new int[]{745}, "PA");
            m22232a(new int[]{746}, "DO");
            m22232a(new int[]{750}, "MX");
            m22232a(new int[]{754, 755}, "CA");
            m22232a(new int[]{759}, "VE");
            m22232a(new int[]{760, 769}, "CH");
            m22232a(new int[]{770}, "CO");
            m22232a(new int[]{773}, "UY");
            m22232a(new int[]{775}, "PE");
            m22232a(new int[]{777}, "BO");
            m22232a(new int[]{779}, "AR");
            m22232a(new int[]{780}, "CL");
            m22232a(new int[]{784}, "PY");
            m22232a(new int[]{785}, "PE");
            m22232a(new int[]{786}, "EC");
            m22232a(new int[]{789, 790}, "BR");
            m22232a(new int[]{800, 839}, "IT");
            m22232a(new int[]{840, 849}, "ES");
            m22232a(new int[]{850}, "CU");
            m22232a(new int[]{858}, "SK");
            m22232a(new int[]{859}, "CZ");
            m22232a(new int[]{860}, "YU");
            m22232a(new int[]{865}, "MN");
            m22232a(new int[]{867}, "KP");
            m22232a(new int[]{868, 869}, "TR");
            m22232a(new int[]{870, 879}, "NL");
            m22232a(new int[]{880}, "KR");
            m22232a(new int[]{885}, "TH");
            m22232a(new int[]{888}, "SG");
            m22232a(new int[]{890}, "IN");
            m22232a(new int[]{893}, "VN");
            m22232a(new int[]{896}, "PK");
            m22232a(new int[]{899}, "ID");
            m22232a(new int[]{900, 919}, "AT");
            m22232a(new int[]{930, 939}, "AU");
            m22232a(new int[]{940, 949}, "AZ");
            m22232a(new int[]{955}, "MY");
            m22232a(new int[]{958}, "MO");
        }
    }
}
