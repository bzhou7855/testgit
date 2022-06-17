package com.dream.model1;

/**
 * 	课程类
 * @author 攀博课堂(www.pbteach.com)
 *
 */
public class PbCourse implements Comparable<PbCourse> {

    //课程标识
    private long id;
    //课程名称
    private String courseName;
    //课程价格
    private int  price;
    //课程分类
    private String category;

    @Override
    public int compareTo(PbCourse o) {
        //新数减旧数，大于0表示新数排在后边
        return this.price - o.getPrice();
    }

    public PbCourse() {

    }
    public PbCourse(long id, String courseName, int price) {
        this.id = id;
        this.courseName = courseName;
        this.price = price;
    }
    public PbCourse(long id, String courseName, int price,String category) {
        this.id = id;
        this.courseName = courseName;
        this.price = price;
        this.category=category;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        return 1;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PbCourse other = (PbCourse) obj;
        if (courseName == null) {
            if (other.courseName != null)
                return false;
        } else if (!courseName.equals(other.courseName))
            return false;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PbCourse [id=" + id + ", courseName=" + courseName + ", price=" + price + ", category=" + category
                + "]";
    }



}
