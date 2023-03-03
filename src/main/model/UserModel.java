package main.model;

public class UserModel
{
    private String  username;

    private String  password;

    private String  rule;

    private String  message;

    private boolean isAuthen;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRule()
    {
        return rule;
    }

    public void setRule(String rule)
    {
        this.rule = rule;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public boolean isAuthen()
    {
        return isAuthen;
    }

    public void setAuthen(boolean isAuthen)
    {
        this.isAuthen = isAuthen;
    }

}
