package host.exp.exponent;

/* compiled from: ABIVersion */
/* renamed from: host.exp.exponent.a */
public class C6290a {
    /* renamed from: a */
    public static float m25954a(String str) {
        if (str.equals("UNVERSIONED")) {
            return 1000.0f;
        }
        String str2 = "\\.";
        if (str.contains("_")) {
            str2 = "_";
        }
        float f = 0.0f;
        float f2 = 1.0f;
        str = str.split(str2);
        for (String parseFloat : str) {
            f += Float.parseFloat(parseFloat) * f2;
            f2 = (float) (((double) f2) / 100.0d);
        }
        return f;
    }
}
