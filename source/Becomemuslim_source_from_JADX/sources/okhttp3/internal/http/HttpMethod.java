package okhttp3.internal.http;

public final class HttpMethod {
    public static boolean invalidatesCache(String str) {
        if (!(str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE"))) {
            if (str.equals("MOVE") == null) {
                return null;
            }
        }
        return true;
    }

    public static boolean requiresRequestBody(String str) {
        if (!(str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH"))) {
            if (str.equals("REPORT") == null) {
                return null;
            }
        }
        return true;
    }

    public static boolean permitsRequestBody(String str) {
        return (str.equals("GET") || str.equals("HEAD") != null) ? null : true;
    }

    public static boolean redirectsWithBody(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean redirectsToGet(String str) {
        return str.equals("PROPFIND") ^ 1;
    }

    private HttpMethod() {
    }
}
