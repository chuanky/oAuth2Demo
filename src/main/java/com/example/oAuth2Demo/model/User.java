package com.example.oAuth2Demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Chuanqi Shi
 * @date 2021/Apr/29
 */
@Entity
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private int role;
    private String roleName;
    private Integer loginTimes;
    private Integer seq;
    private String cellphone;
    private String mailbox;
    private String telephone;
    private String weekdaysOfMail;
    private String languageIdsOfMail;
    private Byte subscribedSm;
    private Byte subscribedMail;

    @Basic
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "role")
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Basic
    @Column(name = "rolename")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "logintimes")
    public Integer getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    @Basic
    @Column(name = "seq")
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Basic
    @Column(name = "cellphone")
    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Basic
    @Column(name = "mailbox")
    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "weekdaysofmail")
    public String getWeekdaysOfMail() {
        return weekdaysOfMail;
    }

    public void setWeekdaysOfMail(String weekdaysOfMail) {
        this.weekdaysOfMail = weekdaysOfMail;
    }

    @Basic
    @Column(name = "languageidsofmail")
    public String getLanguageIdsOfMail() {
        return languageIdsOfMail;
    }

    public void setLanguageIdsOfMail(String languageIdsOfMail) {
        this.languageIdsOfMail = languageIdsOfMail;
    }

    @Basic
    @Column(name = "subscribedsm")
    public Byte getSubscribedSm() {
        return subscribedSm;
    }

    public void setSubscribedSm(Byte subscribedSm) {
        this.subscribedSm = subscribedSm;
    }

    @Basic
    @Column(name = "subscribedmail")
    public Byte getSubscribedMail() {
        return subscribedMail;
    }

    public void setSubscribedMail(Byte subscribedMail) {
        this.subscribedMail = subscribedMail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", roleName='" + roleName + '\'' +
                ", loginTimes=" + loginTimes +
                ", seq=" + seq +
                ", cellphone='" + cellphone + '\'' +
                ", mailbox='" + mailbox + '\'' +
                ", telephone='" + telephone + '\'' +
                ", weekdaysOfMail='" + weekdaysOfMail + '\'' +
                ", languageIdsOfMail='" + languageIdsOfMail + '\'' +
                ", subscribedSm=" + subscribedSm +
                ", subscribedMail=" + subscribedMail +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (role != user.role) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (roleName != null ? !roleName.equals(user.roleName) : user.roleName != null) return false;
        if (loginTimes != null ? !loginTimes.equals(user.loginTimes) : user.loginTimes != null) return false;
        if (seq != null ? !seq.equals(user.seq) : user.seq != null) return false;
        if (cellphone != null ? !cellphone.equals(user.cellphone) : user.cellphone != null) return false;
        if (mailbox != null ? !mailbox.equals(user.mailbox) : user.mailbox != null) return false;
        if (telephone != null ? !telephone.equals(user.telephone) : user.telephone != null) return false;
        if (weekdaysOfMail != null ? !weekdaysOfMail.equals(user.weekdaysOfMail) : user.weekdaysOfMail != null)
            return false;
        if (languageIdsOfMail != null ? !languageIdsOfMail.equals(user.languageIdsOfMail) : user.languageIdsOfMail != null)
            return false;
        if (subscribedSm != null ? !subscribedSm.equals(user.subscribedSm) : user.subscribedSm != null) return false;
        if (subscribedMail != null ? !subscribedMail.equals(user.subscribedMail) : user.subscribedMail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + role;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (loginTimes != null ? loginTimes.hashCode() : 0);
        result = 31 * result + (seq != null ? seq.hashCode() : 0);
        result = 31 * result + (cellphone != null ? cellphone.hashCode() : 0);
        result = 31 * result + (mailbox != null ? mailbox.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (weekdaysOfMail != null ? weekdaysOfMail.hashCode() : 0);
        result = 31 * result + (languageIdsOfMail != null ? languageIdsOfMail.hashCode() : 0);
        result = 31 * result + (subscribedSm != null ? subscribedSm.hashCode() : 0);
        result = 31 * result + (subscribedMail != null ? subscribedMail.hashCode() : 0);
        return result;
    }
}
