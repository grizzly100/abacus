package abacus.persist.entities;

import abacus.jobs.Postie;
import abacus.persist.embeddables.MoneyFields;
import com.google.common.base.MoreObjects;
import org.eclipse.persistence.indirection.ValueHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Represents a Credit or Debit Posting to an Account
 */
@Entity(name = "Posting")
public class PostingEntity implements Serializable {
    @Transient
    private Logger log = LoggerFactory.getLogger(PostingEntity.class);

    @Id
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    private AccountEntity account;

    @Column(insertable = false, updatable = false)
    private long accountId;

    /**
     * Business Date the Posting was recorded on
     */
    @Id
    @Temporal(TemporalType.DATE)
    private LocalDate bizDate;

    /**
     * Business Time the Posting was recorded on
     */
    @Id
    @Temporal(TemporalType.TIME)
    private LocalTime bizTime;

    @Embedded
    private MoneyFields value;

    @Column(length = 255)
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public LocalDate getBizDate() {
        return bizDate;
    }

    public void setBizDate(LocalDate bizDate) {
        this.bizDate = bizDate;
    }

    public LocalTime getBizTime() {
        return bizTime;
    }

    public void setBizTime(LocalTime bizTime) {
        this.bizTime = bizTime;
    }

    public MoneyFields getValue() {
        return value;
    }

    public void setValue(MoneyFields value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Helper

    public long getAccountId() {
        return getAccount().getId();
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("accountId", getAccountId())
                .add("bizDate", bizDate)
                .add("bizTime", bizTime)
                .add("value", value)
                .add("description", description)
                .toString();
    }
}
