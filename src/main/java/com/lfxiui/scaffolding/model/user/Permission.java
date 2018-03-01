package com.lfxiui.scaffolding.model.user;

import javax.persistence.*;

public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源
     */
    private String url;

    /**
     * 资源描述
     */
    private String name;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取资源
     *
     * @return url - 资源
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置资源
     *
     * @param url 资源
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取资源描述
     *
     * @return name - 资源描述
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资源描述
     *
     * @param name 资源描述
     */
    public void setName(String name) {
        this.name = name;
    }
}