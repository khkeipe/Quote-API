package com.khkeipe.poolQuote.util;

import java.util.ArrayList;
import java.util.List;

public class GetList {

    public static <T> List<T> getListFromIterable(Iterable<T> e) {
        List<T> list = new ArrayList<>();
        e.forEach(list::add);
        return list;
    }
}
