package com.khkeipe.poolQuote.entities;

import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pools")
public class Pool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String poolType;

    @Column
    private String poolCode;

    @Column
    private int length;

    @Column
    private int width;

    @Column
    private int height;

    @Column
    private int hopperSize;

    public Pool() {
    }

    public Pool(String poolType, String poolCode, int length, int width, int height, int hopperSize) {
        this.poolType = poolType;
        this.poolCode = poolCode;
        this.length = length;
        this.width = width;
        this.height = height;
        this.hopperSize = hopperSize;
    }

    public Pool(int id, String poolType, String poolCode, int length, int width, int height, int hopperSize) {
        this.id = id;
        this.poolType = poolType;
        this.poolCode = poolCode;
        this.length = length;
        this.width = width;
        this.height = height;
        this.hopperSize = hopperSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoolType() {
        return poolType;
    }

    public void setPoolType(String poolType) {
        this.poolType = poolType;
    }

    public String getPoolCode() {
        return poolCode;
    }

    public void setPoolCode(String poolCode) {
        this.poolCode = poolCode;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHopperSize() {
        return hopperSize;
    }

    public void setHopperSize(int hopperSize) {
        this.hopperSize = hopperSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pool pool = (Pool) o;
        return id == pool.id &&
                length == pool.length &&
                width == pool.width &&
                height == pool.height &&
                hopperSize == pool.hopperSize &&
                Objects.equals(poolType, pool.poolType) &&
                Objects.equals(poolCode, pool.poolCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, poolType, poolCode, length, width, height, hopperSize);
    }

    @Override
    public String toString() {
        return "Pool{" +
                "id=" + id +
                ", poolType='" + poolType + '\'' +
                ", poolCode='" + poolCode + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", hopperSize=" + hopperSize +
                '}';
    }
}
