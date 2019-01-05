package info.sayederfanarefin.chat.helpers;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import info.sayederfanarefin.chat.R;
import info.sayederfanarefin.chat.commons.Commons;

import java.util.regex.Pattern;

public class Validate {

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PASSWORD_REGEX = "^[0-9a-zA-Z@#$%]{8,}$";
//    public static View errorView;

    private Validate() {
    }

    /**
     * Validates that the object is not null
     *
     * @param obj object to test
     */
    public static void notNull(Object obj) {
        if (obj == null)
            throw new IllegalArgumentException("Object must not be null");
    }

    /**
     * Validates that the object is not null
     *
     * @param obj object to test
     * @param msg message to output if validation fails
     */
    public static void notNull(Object obj, String msg) {
        if (obj == null)
            throw new IllegalArgumentException(msg);
    }

    /**
     * Validates that the value is true
     *
     * @param val object to test
     */
    public static void isTrue(boolean val) {
        if (!val)
            throw new IllegalArgumentException("Must be true");
    }

    /**
     * Validates that the value is true
     *
     * @param val object to test
     * @param msg message to output if validation fails
     */
    public static void isTrue(boolean val, String msg) {
        if (!val)
            throw new IllegalArgumentException(msg);
    }

    /**
     * Validates that the value is false
     *
     * @param val object to test
     */
    public static void isFalse(boolean val) {
        if (val)
            throw new IllegalArgumentException("Must be false");
    }

    /**
     * Validates that the value is false
     *
     * @param val object to test
     * @param msg message to output if validation fails
     */
    public static void isFalse(boolean val, String msg) {
        if (val)
            throw new IllegalArgumentException(msg);
    }

    /**
     * Validates that the array contains no null elements
     *
     * @param objects the array to test
     */
    public static void noNullElements(Object[] objects) {
        noNullElements(objects, "Array must not contain any null objects");
    }

    /**
     * Validates that the array contains no null elements
     *
     * @param objects the array to test
     * @param msg     message to output if validation fails
     */
    public static void noNullElements(Object[] objects, String msg) {
        for (Object obj : objects)
            if (obj == null)
                throw new IllegalArgumentException(msg);
    }

    /**
     * Validates that the string is not empty
     *
     * @param string the string to test
     */
    public static void notEmpty(String string) {
        if (string == null || string.length() == 0)
            throw new IllegalArgumentException("String must not be empty");
    }

    /**
     * Validates that the string is not empty
     *
     * @param string the string to test
     * @param msg    message to output if validation fails
     */
    public static void notEmpty(String string, String msg) {
        if (string == null || string.length() == 0)
            throw new IllegalArgumentException(msg);
    }

    /**
     * Cause a failure.
     *
     * @param msg message to output.
     */
    public static void fail(String msg) {
        throw new IllegalArgumentException(msg);
    }

    private static boolean isAvailable(TextInputLayout editTextLayout) {
        editTextLayout.setErrorEnabled(false);
        EditText editText = editTextLayout.getEditText();
        notNull(editText);
        return editText.isEnabled();
    }

    private static boolean checkRegex(String pattern, String text) {
        return Pattern.matches(pattern, text);
    }

    private static void setError(TextInputLayout editTextLayout, int resError) {
        editTextLayout.setError(editTextLayout.getContext().getString(resError));
        notNull(editTextLayout.getEditText());
        editTextLayout.getEditText().requestFocus();
//        errorView = editTextLayout.getEditText();
    }

    private static void setError(TextInputLayout editTextLayout, String resError) {
        editTextLayout.setError(resError);
        notNull(editTextLayout.getEditText());
        editTextLayout.getEditText().requestFocus();
//        errorView = editTextLayout.getEditText();
    }

    /**
     * @param editTextLayout
     * @return true, if validation passed
     */
    public static boolean checkRequiredField(TextInputLayout editTextLayout) {
        if (isAvailable(editTextLayout)) {
            notNull(editTextLayout.getEditText());
            if (editTextLayout.getEditText().getText().length() == 0) {
                setError(editTextLayout, R.string.error_requiredField);
                return false;
            } else if (Commons.containsSpecialCharacter(editTextLayout.getEditText().getText().toString())) {
                setError(editTextLayout, R.string.error_cannotContainSpecialCharacter);
                return false;
            }
        }
        return true;
    }

    public static boolean checkRequiredField(EditText editText) {
        if (editText.getText() == null || editText.getText().length() == 0) {
            editText.setError(editText.getContext().getResources().getString(R.string.error_requiredField));
            return false;
        }
        return true;
    }

    public static boolean checkRequiredField(TextInputLayout editTextLayout, String text) {
        if (text == null || text.length() < 2 ) {
            setError(editTextLayout, R.string.error_nameLength);
            return false;
        }
        return true;
    }

    public static boolean checkRequiredField(TextInputLayout editTextLayout, int length) {
        if (isAvailable(editTextLayout)) {
            notNull(editTextLayout.getEditText());
            if (editTextLayout.getEditText().getText().length() < length) {
                setError(editTextLayout, R.string.error_requiredField);
                return false;
            }
        }
        return true;
    }

    public static boolean isValidEmail(TextInputLayout editTextLayout) {
        if (isAvailable(editTextLayout)) {
            notNull(editTextLayout.getEditText());
            if (!checkRegex(EMAIL_REGEX, editTextLayout.getEditText().getText().toString())) {
                setError(editTextLayout, R.string.error_invalidEmail);
                return false;
            }
        }
        return true;
    }

    public static boolean isValidRange(TextInputLayout editTextLayout, int min, int max) {
        if (isAvailable(editTextLayout) && hasValue(editTextLayout)) {
            notNull(editTextLayout.getEditText());
            int input = Integer.parseInt(editTextLayout.getEditText().getText().toString());
            if (input < min || input > max) {
                setError(editTextLayout, editTextLayout.getContext().getString(R.string.error_invalidRange, min, max));
                return false;
            }
        }
        return true;
    }

    public static boolean isValidRange(TextInputLayout editTextLayout, double min, double max) {
        if (isAvailable(editTextLayout) && hasValue(editTextLayout)) {
            double input = Double.parseDouble(editTextLayout.getEditText().getText().toString());
            if (input < min || input > max) {
                setError(editTextLayout, editTextLayout.getContext().getString(R.string.error_invalidRangeDouble, min, max));
                return false;
            }
        }
        return true;
    }

    public static boolean hasValue(TextInputLayout editTextLayout) {
        return editTextLayout.getEditText().getText().length() != 0;
    }

    public static boolean isValidPhoneNumber(TextInputLayout editTextLayout) {
        if (isAvailable(editTextLayout)) {
            notNull(editTextLayout.getEditText());
//            if (PhoneNumberUtils.isGlobalPhoneNumber(editTextLayout.getEditText().getText().toString())) {
//                setError(editTextLayout, R.string.error_invalidPhoneNumber);
//                return false;
//            }
            String phoneNumber = editTextLayout.getEditText().getText().toString();
            if (phoneNumber.contains("[a-zA-Z]+") || phoneNumber.length() < 11) {
                setError(editTextLayout, R.string.error_invalidPhoneNumber);
                return false;
            }
        }
        return true;
    }

    public static boolean isEqualsOrMoreThan(TextInputLayout editTextLayout, int number) {
        if (isAvailable(editTextLayout)) {
            notNull(editTextLayout.getEditText());
            if (editTextLayout.getEditText().getText().length() < 6) {
                setError(editTextLayout, R.string.error_passwordSize);
                return false;
            }
        }
        return true;
    }

    public static boolean isValidPassword(TextInputLayout editTextLayout) {
        if (isAvailable(editTextLayout)) {
            notNull(editTextLayout.getEditText());
            if (!checkRegex(PASSWORD_REGEX, editTextLayout.getEditText().getText().toString())) {
                setError(editTextLayout, R.string.error_invalidPassword);
                return false;
            }
        }
        return true;
    }

    public static boolean isValidPassword(String password) {
        if (password == null || !checkRegex(PASSWORD_REGEX, password))
            return false;
        return true;
    }

    public static boolean isPasswordMatches(TextInputLayout editTextLayout, TextInputLayout follower) {
        if (isAvailable(editTextLayout) && isAvailable(follower)) {
            notNull(editTextLayout.getEditText());
            notNull(follower.getEditText());
            if (!editTextLayout.getEditText().getText().toString().equals(follower.getEditText().getText().toString())) {
                setError(follower, R.string.error_mismatchPassword);
                return false;
            }
        }
        return true;
    }

    public static boolean isValidHeight(EditText txtHeight, EditText txtHeight1) {
        try {
            int f = Integer.parseInt(txtHeight.getText().toString());
            try {
                int i = Integer.parseInt(txtHeight1.getText().toString());

                if (f > 7) {
                    txtHeight.setError("This value is not valid!");
                    txtHeight.requestFocus();
                    return false;
                }
                if (i > 11) {
                    txtHeight1.setError("This value is not valid!");
                    txtHeight1.requestFocus();
                    return false;
                }
                if (f == 0 && i == 0) {
                    txtHeight1.setError("This value is not valid!");
                    txtHeight1.requestFocus();
                    return false;
                }
                return true;
            } catch (NumberFormatException e) {
                txtHeight1.setError("Not a valid number");
                txtHeight1.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            txtHeight.setError("Not a valid number");
            txtHeight.requestFocus();
            return false;
        }
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

}