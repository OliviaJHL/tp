package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's gender in the address book.
 */
public class Gender {
    public static final String MESSAGE_CONSTRAINTS =
            "Gender should only be either Male or Female";

    /*
     * The gender must be either "male" or "female".
     */
    public static final String VALIDATION_REGEX = "(?i)(male|female)";

    public final String genderInfo;

    /**
     * Constructs a {@code Gender}.
     *
     * @param gender male or female.
     */
    public Gender(String gender) {
        requireNonNull(gender);
        checkArgument(isValidName(gender), MESSAGE_CONSTRAINTS);
        genderInfo = gender;
    }

    /**
     * Returns true if a given string is a valid gender.
     */
    public static boolean isValidName(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return genderInfo;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Gender // instanceof handles nulls
                && genderInfo.equals(((Gender) other).genderInfo)); // state check
    }

    @Override
    public int hashCode() {
        return genderInfo.hashCode();
    }
}
