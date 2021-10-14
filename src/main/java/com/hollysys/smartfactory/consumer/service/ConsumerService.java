package com.hollysys.smartfactory.consumer.service;

import com.hollysys.smartfactory.consumer.entity.Consumer;

import java.util.List;

/**
 * (Consumer)表服务接口
 *
 * @author lizhi186545
 * @since 2021-09-28 11:22:02
 */
public interface ConsumerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Consumer queryById(Integer id);

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    List<Consumer> queryAll();

    /**
     * 新增数据
     *
     * @param consumer 实例对象
     * @return 实例对象
     */
    Consumer insert(Consumer consumer);
    /**
     * 批量新增数据
     *
     * @param consumers 实例对象
     * @return 实例对象
     */
    List<Consumer> insertBatch(List<Consumer> consumers);
    /**
     * 修改数据
     *
     * @param consumer 实例对象
     * @return 实例对象
     */
    Consumer update(Consumer consumer);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通过name删除数据
     *
     * @param consumer 实例对象
     * @return 影响行数
     */
    boolean deleteByName(Consumer consumer);

}
