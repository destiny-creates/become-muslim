package okhttp3;

public interface Authenticator {
    public static final Authenticator NONE = new C76481();

    /* renamed from: okhttp3.Authenticator$1 */
    class C76481 implements Authenticator {
        public Request authenticate(Route route, Response response) {
            return null;
        }

        C76481() {
        }
    }

    Request authenticate(Route route, Response response);
}
