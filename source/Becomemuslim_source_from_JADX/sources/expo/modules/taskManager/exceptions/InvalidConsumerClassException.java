package expo.modules.taskManager.exceptions;

public class InvalidConsumerClassException extends Exception {
    public InvalidConsumerClassException(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid task consumer. Cannot unregister task with name '");
        stringBuilder.append(str);
        stringBuilder.append("' because it is associated with different consumer class.");
        super(stringBuilder.toString());
    }
}
