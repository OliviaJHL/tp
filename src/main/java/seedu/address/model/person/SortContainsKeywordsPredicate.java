package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
public class SortContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public SortContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getGender().genderInfo, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SortContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((SortContainsKeywordsPredicate) other).keywords)); // state check
    }
}
