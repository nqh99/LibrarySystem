package main.domain;

public enum ObjectType
{
    BOOK("book"), LIBRARY("library"), RENTER("renter");

    private String value;

    ObjectType(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public static ObjectType fromValue(String value)
    {
        for (ObjectType objType : ObjectType.values())
        {
            if (objType.getValue().equals(value))
            {
                return objType;
            }
        }

        return null;
    }
}
