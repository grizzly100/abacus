package abacus.domain.posting;

import abacus.domain.money.Money;
import com.google.common.base.MoreObjects;

/**
 * A Debit or Credit of Money against an Account
 */
public class Posting {

    private long id;

    private String description;

    private Money value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Money getValue() {
        return value;
    }

    public void setValue(Money value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("description", description)
                .add("value", value)
                .toString();
    }
}