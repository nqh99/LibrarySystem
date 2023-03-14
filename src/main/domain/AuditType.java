package main.domain;

public enum AuditType
{
    BOOK("book"), LIBRARY("library"), RENTER("renter");

    private String value;

    AuditType(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public static AuditType fromValue(String value)
    {
        for (AuditType objType : AuditType.values())
        {
            if (objType.getValue().equals(value))
            {
                return objType;
            }
        }

        return null;
    }
}
