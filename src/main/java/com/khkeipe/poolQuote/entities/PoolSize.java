package com.khkeipe.poolQuote.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class PoolSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int length;

    @Column
    private int width;

    @Column
    private int depth;

    @OneToMany(mappedBy = "size")
    private List<Pool> poolList;

    public PoolSize() {
    }

    public PoolSize(int length, int width, int depth) {
        this.length = length;
        this.width = width;
        this.depth = depth;

    }

    public PoolSize(int id, int length, int width, int depth) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.depth = depth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoolSize poolSize = (PoolSize) o;
        return id == poolSize.id &&
                length == poolSize.length &&
                width == poolSize.width &&
                depth == poolSize.depth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, length, width, depth);
    }

    @Override
    public String toString() {
        return "PoolSize{" +
                "id=" + id +
                ", length=" + length +
                ", width=" + width +
                ", depth=" + depth +
                '}';
    }
}
