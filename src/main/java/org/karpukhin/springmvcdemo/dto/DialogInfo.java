package org.karpukhin.springmvcdemo.dto;

/**
 * @author Pavel Karpukhin
 */
public class DialogInfo {

    private String dialog;
    private String message;
    private String action;

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
