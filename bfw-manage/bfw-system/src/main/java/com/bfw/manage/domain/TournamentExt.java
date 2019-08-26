package com.bfw.manage.domain;

/**
 *
 * @author barkley
 * @date 2019-08-15
 */
public class TournamentExt
{
    private Long id;

    private String logoUrl;

    private String name;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
