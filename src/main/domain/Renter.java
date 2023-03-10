package main.domain;

import main.utils.DateTimeUtils;

public class Renter extends RealObject
{

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
        return "Renter: " + " id=" + this.getId() + " name=" + this.getName() + " email=" + this.getEmail() + " phone_number=" + this.getPhoneNumber() + " createTime=" + DateTimeUtils.getDateTime(this.getCreateTime()) + " update=" + DateTimeUtils.getDateTime(this.getUpdateTime());
    }

}
