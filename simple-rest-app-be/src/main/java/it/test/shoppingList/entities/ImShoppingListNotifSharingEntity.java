package it.test.shoppingList.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "IM_SHOPPING_LIST_NOTIF_SHARING", schema = "LDS001", catalog = "LDS001")
public class ImShoppingListNotifSharingEntity {
    private long notifSharingId;
    private String usernameSender;
    private String usernameRecipient;
    private String message;
    private String userMessage;
    private Long sharedListId;
    private BigInteger read;
    private Integer type;
    private Timestamp insertDate;
    private Timestamp updateDate;
    private String ssoid;

    @Id
    @Column(name = "NOTIF_SHARING_ID")
    public long getNotifSharingId() {
        return notifSharingId;
    }

    public void setNotifSharingId(long notifSharingId) {
        this.notifSharingId = notifSharingId;
    }

    @Basic
    @Column(name = "USERNAME_SENDER")
    public String getUsernameSender() {
        return usernameSender;
    }

    public void setUsernameSender(String usernameSender) {
        this.usernameSender = usernameSender;
    }

    @Basic
    @Column(name = "USERNAME_RECIPIENT")
    public String getUsernameRecipient() {
        return usernameRecipient;
    }

    public void setUsernameRecipient(String usernameRecipient) {
        this.usernameRecipient = usernameRecipient;
    }

    @Basic
    @Column(name = "MESSAGE")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "USER_MESSAGE")
    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    @Basic
    @Column(name = "SHARED_LIST_ID")
    public Long getSharedListId() {
        return sharedListId;
    }

    public void setSharedListId(Long sharedListId) {
        this.sharedListId = sharedListId;
    }

    @Basic
    @Column(name = "READ")
    public BigInteger getRead() {
        return read;
    }

    public void setRead(BigInteger read) {
        this.read = read;
    }

    @Basic
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "INSERT_DATE")
    public Timestamp getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Timestamp insertDate) {
        this.insertDate = insertDate;
    }

    @Basic
    @Column(name = "UPDATE_DATE")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "SSOID")
    public String getSsoid() {
        return ssoid;
    }

    public void setSsoid(String ssoid) {
        this.ssoid = ssoid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImShoppingListNotifSharingEntity that = (ImShoppingListNotifSharingEntity) o;
        return notifSharingId == that.notifSharingId &&
                Objects.equals(usernameSender, that.usernameSender) &&
                Objects.equals(usernameRecipient, that.usernameRecipient) &&
                Objects.equals(message, that.message) &&
                Objects.equals(userMessage, that.userMessage) &&
                Objects.equals(sharedListId, that.sharedListId) &&
                Objects.equals(read, that.read) &&
                Objects.equals(type, that.type) &&
                Objects.equals(insertDate, that.insertDate) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(ssoid, that.ssoid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notifSharingId, usernameSender, usernameRecipient, message, userMessage, sharedListId, read, type, insertDate, updateDate, ssoid);
    }
}
