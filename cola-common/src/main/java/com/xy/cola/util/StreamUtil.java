package com.xy.cola.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <功能介绍><br>
 * <p>
 * <>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class StreamUtil {

    /**
     * Filter list.
     *
     * @param <T>        the type parameter
     * @param unfiltered the unfiltered
     * @param predicate  the predicate
     * @return the list
     */
    public static <T> List<T> filter(Collection<T> unfiltered, Predicate<T> predicate) {
        return CollectionUtils.isEmpty(unfiltered) ? Collections.emptyList() : unfiltered.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * Reject list.
     *
     * @param <T>        the type parameter
     * @param unfiltered the unfiltered
     * @param predicate  the predicate
     * @return the list
     */
    public static <T> List<T> reject(Collection<T> unfiltered, Predicate<T> predicate) {
        return filter(unfiltered, predicate.negate());
    }

    /**
     * Map list.
     *
     * @param <F>    the type parameter
     * @param <T>    the type parameter
     * @param from   the from
     * @param mapper the mapper
     * @return the list
     */
    public static <F, T> List<T> map(Collection<F> from, Function<? super F, T> mapper) {
        return null == from ? null : from.stream().map(mapper).collect(Collectors.toList());
    }

    /**
     * Map to set set.
     *
     * @param <F>    the type parameter
     * @param <T>    the type parameter
     * @param from   the from
     * @param mapper the mapper
     * @return the set
     */
    public static <F, T> Set<T> mapToSet(Collection<F> from, Function<? super F, T> mapper) {
        return from.stream().map(mapper).collect(Collectors.toSet());
    }

    /**
     * Map list.
     *
     * @param <F>    the type parameter
     * @param <T>    the type parameter
     * @param from   the from
     * @param mapper the mapper
     * @return the list
     */
    public static <F, T> List<T> map(F[] from, Function<? super F, T> mapper) {
        return Arrays.stream(from).map(mapper).collect(Collectors.toList());
    }

    /**
     * Map list.
     *
     * @param <F>    the type parameter
     * @param <T>    the type parameter
     * @param from   the from
     * @param mapper the mapper
     * @return the list
     */
    public static <F, T> List<T> map(Stream<F> from, Function<? super F, T> mapper) {
        return from.map(mapper).collect(Collectors.toList());
    }

    /**
     * To map map.
     *
     * @param <K>         the type parameter
     * @param <V>         the type parameter
     * @param <F>         the type parameter
     * @param from        the from
     * @param keyMapper   the key mapper
     * @param valueMapper the value mapper
     * @return the map
     */
    public static <K, V, F> Map<K, V> toMap(Collection<F> from, Function<F, K> keyMapper, Function<F, V> valueMapper) {
        return from.stream().collect(Collectors.toMap(keyMapper, valueMapper));
    }

    /**
     * To map remove duplicate map.
     *
     * @param <K>           the type parameter
     * @param <V>           the type parameter
     * @param <F>           the type parameter
     * @param from          the from
     * @param keyMapper     the key mapper
     * @param valueMapper   the value mapper
     * @param mergeFunction the merge function
     * @return the map
     */
    public static <K, V, F> Map<K, V> toMapRemoveDuplicate(Collection<F> from,
                                                           Function<F, K> keyMapper,
                                                           Function<F, V> valueMapper,
                                                           BinaryOperator<V> mergeFunction) {
        // 为空, 返回空map
        if (CollectionUtils.isEmpty(from)) {
            return Maps.newHashMap();
        }
        // 转换, 并去重
        return from.stream().collect(Collectors.toMap(keyMapper, valueMapper, mergeFunction));
    }

    /**
     * Sum big decimal.
     *
     * @param <S>     the type parameter
     * @param src     the src
     * @param valueFn the value fn
     * @return the big decimal
     */
    public static <S> BigDecimal sum(Collection<S> src, Function<S, BigDecimal> valueFn) {
        return src.stream().map(valueFn).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Sum long long.
     *
     * @param <S>     the type parameter
     * @param src     the src
     * @param valueFn the value fn
     * @return the long
     */
    public static <S> Long sumLong(Collection<S> src, Function<S, Long> valueFn) {
        return src.stream().map(valueFn).reduce(0L, (a, b) -> a + b);
    }

    /**
     * Sum integer integer.
     *
     * @param <S>     the type parameter
     * @param src     the src
     * @param valueFn the value fn
     * @return the integer
     */
    public static <S> Integer sumInteger(Collection<S> src, Function<S, Integer> valueFn) {
        return src.stream().map(valueFn).reduce(0, (a, b) -> a + b);
    }

    /**
     * Grouping by map.
     *
     * @param <K>        the type parameter
     * @param <V>        the type parameter
     * @param from       the from
     * @param classifier the classifier
     * @return the map
     */
    public static <K, V> Map<K, List<V>> groupingBy(Collection<V> from, Function<V, K> classifier) {
        return groupingBy(from.stream(), classifier);
    }

    /**
     * Grouping by map.
     *
     * @param <K>        the type parameter
     * @param <V>        the type parameter
     * @param fromStream the from stream
     * @param classifier the classifier
     * @return the map
     */
    public static <K, V> Map<K, List<V>> groupingBy(Stream<V> fromStream, Function<V, K> classifier) {
        return fromStream.collect(Collectors.groupingBy(classifier));
    }

    /**
     * Grouping by after filter map.
     *
     * @param <K>        the type parameter
     * @param <V>        the type parameter
     * @param from       the from
     * @param predicate  the predicate
     * @param classifier the classifier
     * @return the map
     */
    public static <K, V> Map<K, List<V>> groupingByAfterFilter(Collection<V> from, Predicate<V> predicate,
                                                               Function<V, K> classifier) {
        if (CollectionUtils.isEmpty(from)) {
            return Maps.newHashMap();
        }
        return from.stream().filter(predicate).collect(Collectors.groupingBy(classifier));
    }

    /**
     * Distinct list.
     *
     * @param <T>    the type parameter
     * @param source the source
     * @return the list
     */
    public static <T> List<T> distinct(Collection<T> source) {
        if (CollectionUtils.isEmpty(source)) {
            return Lists.newArrayList();
        }
        return source.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Sort by keys list.
     *
     * @param <K>  the type parameter
     * @param <V>  the type parameter
     * @param keys the keys
     * @param map  the map
     * @return the list
     */
    public static <K, V> List<V> sortByKeys(List<K> keys, Map<K, V> map) {
        if (CollectionUtils.isEmpty(keys)) {
            return Lists.newArrayList();
        }
        return keys.stream().distinct().map(k -> map.get(k)).collect(Collectors.toList());
    }

    /**
     * Sort list.
     *
     * @param <V>        the type parameter
     * @param source     the source
     * @param comparator the comparator
     * @return the list
     */
    public static <V> List<V> sort(Collection<V> source, Comparator<? super V> comparator) {
        if (CollectionUtils.isEmpty(source)) {
            return Lists.newArrayList();
        }
        return source.stream().distinct().sorted(comparator).collect(Collectors.toList());
    }
}
