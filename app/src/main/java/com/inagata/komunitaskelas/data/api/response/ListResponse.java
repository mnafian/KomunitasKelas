package com.inagata.komunitaskelas.data.api.response;

import java.util.List;

/**
 * Created on : December 10, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class ListResponse<Data> extends Response
{
    private List<Data> result;

    public List<Data> getResult()
    {
        return result;
    }

    public void setResult(List<Data> result)
    {
        this.result = result;
    }
}
