package com.mz.time;

import java.util.*;

/**
 * @author mz
 * @version V1.0
 * @Title TimeSegment
 * @Package com.mz.time
 * @Description 时间段对象
 * @date 2020/7/31 10:04 上午
 */
public class TimeSegment {
    /**
     * 开始时间点
     */
    private Date startPoint;

    /**
     * 结束时间点
     */
    private Date endPoint;

    public TimeSegment(Date startPoint, Date endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public List<Date> getTimeNodes() {
        Objects.requireNonNull(startPoint);
        Objects.requireNonNull(endPoint);
        List<Date> nodes = new ArrayList<>();
        nodes.addAll((Collection<? extends Date>) startPoint.clone());
        nodes.addAll((Collection<? extends Date>) endPoint.clone());
        return nodes;
    }

}