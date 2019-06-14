package expo.modules.taskManager.exceptions;

public class TaskRegisteringFailedException extends Exception {
    public TaskRegisteringFailedException(Class cls, Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Initializing task consumer '");
        stringBuilder.append(cls.getName());
        stringBuilder.append("' failed. Inherited error: ");
        stringBuilder.append(exception.getMessage());
        super(stringBuilder.toString());
    }
}
