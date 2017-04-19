/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musiccrawler.model;

import musiccrawler.common.HtmlToolFix;

/**
 *
 * @author Tavv
 */
public class Singer {
    
    private String id;
    private String name;
    private int age;
    private String description;
    private String avatar;

    public Singer() {
    }
    
    /**
     * @param id
     * @param name
     * @param age
     * @param description
     * @param avatar 
     */
    public Singer(String id, String name, int age, String description, String avatar) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
        this.avatar = avatar;
    }

    public String getName() {
        return HtmlToolFix.fixName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Singer{" + "id=" + id + ", name=" + name + ", age=" + age + ", description=" + description + ", avatar=" + avatar + '}';
    }

}
