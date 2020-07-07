package com.khkeipe.poolQuote.entities;

public enum PoolType {

    ADIRONDACK("ADERONDACK"), CUSTOM_FREEFORM("CUSTOM FREEFORM"), BLUE_LAGOON("BLUE LAGOON"),
    EMERALD("EMERALD"), GARNET("GARNET"), GRECIAN("CRECIAN"), KIDNEY("KIDNEY (FLATBACK)"),
    MOUNTAIN_LAKE("MOUNTAIN LAKE"), OVAL_IN_GROUND("OVAL IN GROUND"), OXBOW("OXBOW"), ROMAN_END("ROMAN END"),
    TOPAZ("TOPAZ"), LOCKED("LOCKED");

    private final String poolName;

    PoolType(String name) {
        this.poolName = name;
    }

    public static PoolType getByName(String name) {
        for(PoolType type : PoolType.values()) {
            if(type.poolName.equals(name)) {
                return type;
            }
        }
        return LOCKED;
    }

    @Override
    public String toString() {
        return "PoolType{" +
                "poolName='" + poolName + '\'' +
                '}';
    }
}
