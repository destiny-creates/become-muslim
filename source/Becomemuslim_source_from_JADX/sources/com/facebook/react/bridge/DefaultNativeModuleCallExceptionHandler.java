package com.facebook.react.bridge;

public class DefaultNativeModuleCallExceptionHandler implements NativeModuleCallExceptionHandler {
    public void handleException(Exception exception) {
        try {
            if (exception instanceof RuntimeException) {
                throw ((RuntimeException) exception);
            }
            throw new RuntimeException(exception);
        } catch (Exception exception2) {
            try {
                Class.forName("host.exp.exponent.ReactNativeStaticHelpers").getMethod("handleReactNativeError", new Class[]{Throwable.class, String.class, Object.class, Integer.class, Boolean.class}).invoke(null, new Object[]{exception2, exception2.getMessage(), null, Integer.valueOf(-1), Boolean.valueOf(true)});
            } catch (Exception exception22) {
                exception22.printStackTrace();
            }
        }
    }
}
