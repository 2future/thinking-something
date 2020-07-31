package com.mz.time;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Date;

/**
 * @author mz
 * @version V1.0
 * @Title TimeSegmentCompareCoverTest
 * @Package com.mz.time
 * @Description
 * @date 2020/7/31 3:11 下午
 */
public class TimeSegmentCompareCoverTest {

    @Test
    void testSegmentCover() {
        //2020-07-31 15:58:14  2020-08-20 15:58:14
        TimeSegment segmentFir = new TimeSegment(new Date(1596182294000L), new Date(1597910294000L));
        //2020-06-20 15:58:14  2020-09-20 15:58:14
        TimeSegment segmentSed = new TimeSegment(new Date(1592639894000L), new Date(1600588694000L));
        TimeSegmentCompareCover compareCover = new TimeSegmentCompareCover(segmentFir, segmentSed);
        boolean coverSegment = compareCover.isCoverSegment();
        assumeTrue(()->coverSegment,"coverSegment is not true");
    }

    @Test
    void testAllCover() {
        // 2020-06-20 15:58:14   2020-09-20 15:58:14
        TimeSegment segmentFir = new TimeSegment(new Date(1592639894000L ), new Date(1600588694000L));
        //2020-08-20 15:58:14  2020-07-31 15:58:14
        TimeSegment segmentSed = new TimeSegment(new Date(1597910294000L), new Date(1596182294000L));
        TimeSegmentCompareCover compareCover = new TimeSegmentCompareCover(segmentFir, segmentSed);
        boolean coverSegment = compareCover.isCoverSegment();
        assumeTrue(()->coverSegment,"coverSegment is not true");
    }

    @Test
    void testUnCover() {
        // 2020-06-20 15:58:14  2020-07-31 15:58:14
        TimeSegment segmentFir = new TimeSegment(new Date(1592639894000L ), new Date(1596182294000L));
        //2020-08-20 15:58:14  2020-09-20 15:58:14
        TimeSegment segmentSed = new TimeSegment(new Date(1597910294000L), new Date(1600588694000L));
        TimeSegmentCompareCover compareCover = new TimeSegmentCompareCover(segmentFir, segmentSed);
        boolean coverSegment = compareCover.isCoverSegment();
        assumeFalse(()->coverSegment,"coverSegment is not true");
    }



}