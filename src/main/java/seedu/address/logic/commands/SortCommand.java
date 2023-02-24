package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Comparator;
import java.util.function.Predicate;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;
import seedu.address.model.person.SortContainsKeywordsPredicate;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case-insensitive.
 */
public class SortCommand extends Command {
    //private Predicate<Person> predicate;

    public static final String COMMAND_WORD = "sort";


    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts all persons in the address book by gender. "
            + "and dispalys them as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD + " female";

    private final SortContainsKeywordsPredicate predicate;

    public SortCommand(SortContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || other instanceof SortCommand; // instanceof handles nulls
    }
}