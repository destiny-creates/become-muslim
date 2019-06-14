package expo.modules.taskManager.exceptions;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Task '");
        stringBuilder.append(str);
        stringBuilder.append("' not found for app ID '");
        stringBuilder.append(str2);
        stringBuilder.append("'.");
        super(stringBuilder.toString());
    }
}
