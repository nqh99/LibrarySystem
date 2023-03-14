package main.domain;

import main.utils.DateTimeUtils;

public class Renter
{

    private Audit  audit;

    private String phoneNumber;

    private String email;

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public Audit getAudit()
    {
        return audit;
    }

    public void setAudit(Audit audit)
    {
        this.audit = audit;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "Renter: " + " id=" + audit.getId() + " name=" + audit.getName() + " email=" + getEmail() + " phone_number=" + getPhoneNumber() + " createTime=" + DateTimeUtils.getDateTime(audit.getCreateTime()) + " update=" + DateTimeUtils.getDateTime(audit.getUpdateTime());
    }

}
