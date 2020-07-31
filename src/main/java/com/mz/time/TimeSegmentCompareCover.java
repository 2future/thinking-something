package com.mz.time;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author mz
 * @version V1.0
 * @Title TimeConpare
 * @Package com.mz.time
 * @Description 时间端比较是否重叠
 * @date 2020/7/31 9:33 上午
 */
public class TimeSegmentCompareCover {
    /**
     * 第一个时间段
     */
    private TimeSegment partFir;
    /**
     * 第二个时间段
     */
    private TimeSegment partSed;


    public TimeSegmentCompareCover(TimeSegment partFir, TimeSegment partSed) {
        this.partFir = partFir;
        this.partSed = partSed;
    }

    /**
     * @return boolean  : cover result
     * @throws UnsupportedOperationException
     */
    public boolean isCoverSegment() {
        List<Date> timeNodesFir = partFir.getTimeNodes();
        TimeTemp timeTemp = new TimeTemp();
        for (Date timeNode : timeNodesFir) {
            if (timeTemp.isClean()) {
                timeTemp.coverTemp(convertToTimeStamp(timeNode));
            } else {
                long partFirDiff = Math.abs(timeTemp.getTemp()-(timeTemp.getTemp() - convertToTimeStamp(timeNode))/2);
                timeTemp.clean();
                List<Date> timeNodes = partSed.getTimeNodes();
                for (Date timeNodeSed : timeNodes) {
                    if (timeTemp.isClean()) {
                        timeTemp.coverTemp(convertToTimeStamp(timeNodeSed));
                    } else {
                        long partSedDiff = Math.abs(timeTemp.getTemp()-(timeTemp.getTemp() - convertToTimeStamp(timeNodeSed))/2);
                        //中间点 值差
                        long middleAbs = Math.abs(partFirDiff  - partSedDiff );
                        return (middleAbs < (partFir.getDiffAbs() / 2 + partSed.getDiffAbs() / 2));
                    }
                }
            }
        }
        throw new UnsupportedOperationException();
    }

    /**
     * 临时时间点
     */
   private class TimeTemp {

        private Long temp;

        public void coverTemp(Long timeStamp) {
            temp = timeStamp;
        }

        public Long getTemp() {
            return temp;
        }

        public boolean isClean() {
            return temp == null;
        }

        public void clean() {
            temp = null;
        }

    }

    private long convertToTimeStamp(Date date) {
        Objects.requireNonNull(date);
        return date.getTime();
    }

}