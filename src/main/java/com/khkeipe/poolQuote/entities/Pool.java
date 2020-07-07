package com.khkeipe.poolQuote.entities;

import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private PoolType poolType;

    @Column
    private String poolCode;

    @Column
    private String poolMetric;

    @Column
    private String metricCode;

    @ManyToOne
    @JoinColumn(nullable = false)
    private PoolSize size;

    public Pool() {
    }

    public Pool(PoolType poolType, String poolCode, String metric, String metricCode, PoolSize size) {
        this.poolType = poolType;
        this.poolCode = poolCode;
        this.poolMetric = metric;
        this.metricCode = metricCode;
        this.size = size;
    }

    public Pool(int id, PoolType poolType, String poolCode, String metric, String metricCode, PoolSize size) {
        this.id = id;
        this.poolType = poolType;
        this.poolCode = poolCode;
        this.poolMetric = metric;
        this.metricCode = metricCode;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PoolType getPoolType() {
        return poolType;
    }

    public void setPoolType(PoolType poolType) {
        this.poolType = poolType;
    }

    public String getPoolCode() {
        return poolCode;
    }

    public void setPoolCode(String poolCode) {
        this.poolCode = poolCode;
    }

    public String getMetric() {
        return poolMetric;
    }

    public void setMetric(String metric) {
        poolMetric = metric;
    }

    public String getMetricCode() {
        return metricCode;
    }

    public void setMetricCode(String metricCode) {
        this.metricCode = metricCode;
    }

    public PoolSize getSize() {
        return size;
    }

    public void setSize(PoolSize size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pool pool = (Pool) o;
        return id == pool.id &&
                Objects.equals(poolType, pool.poolType) &&
                Objects.equals(poolCode, pool.poolCode) &&
                Objects.equals(poolMetric, pool.poolMetric) &&
                Objects.equals(metricCode, pool.metricCode) &&
                Objects.equals(size, pool.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, poolType, poolCode, poolMetric, metricCode, size);
    }

    @Override
    public String toString() {
        return "Pool{" +
                "id=" + id +
                ", poolType=" + poolType +
                ", poolCode='" + poolCode + '\'' +
                ", Metric='" + poolMetric + '\'' +
                ", metricCode='" + metricCode + '\'' +
                ", size=" + size +
                '}';
    }
}
