package com.tosansoha.library.models;

import java.io.Serializable;

import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Embeddable
public class OwnershipKey implements Serializable{
    @Column(name = "bookId")
    private Integer bookId;
    @Column(name = "memberId")
    private Integer memberId;

    public OwnershipKey() {
    }

    public OwnershipKey(Integer bookId, Integer memberId) {
        this.bookId = bookId;
        this.memberId = memberId;
    }

    public Integer getBookId() {
        return this.bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    
    public Integer getMemberId() {
        return this.memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
