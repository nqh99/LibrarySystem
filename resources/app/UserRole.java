package app;

public enum UserRole
{
    ADMIN("admin"), USER("user");

    private String value;

    UserRole(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public static UserRole fromValue(String value)
    {
        for (UserRole objType : UserRole.values())
        {
            if (objType.getValue().equals(value))
            {
                return objType;
            }
        }

        return null;
    }
}
