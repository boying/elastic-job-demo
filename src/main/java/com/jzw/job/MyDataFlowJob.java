package com.jzw.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;

import java.util.Arrays;
import java.util.List;

/**
 * Created by boying on 2019/1/16.
 */
public class MyDataFlowJob implements DataflowJob<Long> {
    public List<Long> fetchData(ShardingContext shardingContext) {
        return Arrays.asList(1L, 2L, 3L);
    }

    public void processData(ShardingContext shardingContext, List<Long> list) {
        System.out.println(String.format("------MyDataFlowJob Thread ID: %s, 任务总片数: %s, 当前分片项: %s",
                Thread.currentThread().getId(), shardingContext.getShardingTotalCount(), shardingContext.getShardingItem()));
        System.out.println(list.size());
        try {
            Thread.sleep(10000);
        } catch (Exception ignored) {
        }
    }
}
