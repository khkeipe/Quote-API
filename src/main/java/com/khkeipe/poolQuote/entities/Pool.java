package com.khkeipe.poolQuote.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String poolType;

    @Column
    private String poolCode;

    @Column
    private String Metric;

    @Column
    private String metricCode;

    @ManyToOne
    @JoinColumn(nullable = false)
    private PoolSize pooSize;

    public Pool() {
    }

    public Pool(String poolType, String poolCode, String metric, String metricCode, PoolSize pooSize) {
        this.poolType = poolType;
        this.poolCode = poolCode;
        Metric = metric;
        this.metricCode = metricCode;
        this.pooSize = pooSize;
    }

    public Pool(int id, String poolType, String poolCode, String metric, String metricCode, PoolSize pooSize) {
        this.id = id;
        this.poolType = poolType;
        this.poolCode = poolCode;
        Metric = metric;
        this.metricCode = metricCode;
        this.pooSize = pooSize;
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

    public String getMetric() {
        return Metric;
    }

    public void setMetric(String metric) {
        Metric = metric;
    }

    public String getMetricCode() {
        return metricCode;
    }

    public void setMetricCode(String metricCode) {
        this.metricCode = metricCode;
    }

    public PoolSize getPooSize() {
        return pooSize;
    }

    public void setPooSize(PoolSize pooSize) {
        this.pooSize = pooSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pool pool = (Pool) o;
        return id == pool.id &&
                Objects.equals(poolType, pool.poolType) &&
                Objects.equals(poolCode, pool.poolCode) &&
                Objects.equals(Metric, pool.Metric) &&
                Objects.equals(metricCode, pool.metricCode) &&
                Objects.equals(pooSize, pool.pooSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, poolType, poolCode, Metric, metricCode, pooSize);
    }

    @Override
    public String toString() {
        return "Pool{" +
                "id=" + id +
                ", poolType='" + poolType + '\'' +
                ", poolCode='" + poolCode + '\'' +
                ", Metric='" + Metric + '\'' +
                ", metricCode='" + metricCode + '\'' +
                ", pooSize=" + pooSize +
                '}';
    }
}
