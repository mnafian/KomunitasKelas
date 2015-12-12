package com.inagata.komunitaskelas.data.api.response;

/**
 * Created on : December 10, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class Response
{
    private int code;

    public boolean getCode()
    {
        return code == 200;
    }

    public void setCode(int code)
    {
        this.code = code;
    }
}
