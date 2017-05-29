package com.bot.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class WordnikWord implements Serializable {

    private static final long serialVersionUID = -1053525283944026030L;

    private int id;

    private String word;


    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("word", word)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        WordnikWord wordnikWord1 = (WordnikWord) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(id, wordnikWord1.id)
                .append(word, wordnikWord1.word)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(id)
                .append(word)
                .toHashCode();
    }

}
