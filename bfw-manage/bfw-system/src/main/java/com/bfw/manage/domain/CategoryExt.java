package com.bfw.manage.domain;

/**
 *
 * @author barkley
 * @date 2019-08-15
 */
public class CategoryExt
{
    private Long id;

    private String cnName;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

}
