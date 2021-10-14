package com.hollysys.smartfactory.consumer.service.impl;

import com.hollysys.smartfactory.consumer.dao.ConsumerDao;
import com.hollysys.smartfactory.consumer.entity.Consumer;
import com.hollysys.smartfactory.consumer.service.ConsumerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Consumer)表服务实现类
 *
 * @author lizhi186545
 * @since 2021-09-28 11:22:02
 */
@Service("consumerService")
public class ConsumerServiceImpl implements ConsumerService {
    @Resource
    private ConsumerDao consumerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Consumer queryById(Integer id) {
        return this.consumerDao.queryById(id);
    }

    @Override
    public List<Consumer> queryAll() {
        return this.consumerDao.queryAll();
    }

    /**
     * 分页查询
     *
     * @param consumer 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param consumer 实例对象
     * @return 实例对象
     */
    @Override
    public Consumer insert(Consumer consumer) {
        this.consumerDao.insert(consumer);
        return consumer;
    }

    @Override
    public List<Consumer> insertBatch(List<Consumer> consumers) {
        this.consumerDao.insertBatch(consumers);
        return consumers;
    }

    /**
     * 修改数据
     *
     * @param consumer 实例对象
     * @return 实例对象
     */
    @Override
    public Consumer update(Consumer consumer) {
        this.consumerDao.update(consumer);
        return consumer;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        int ret = this.consumerDao.deleteById(id);
        this.consumerDao.alterTable(id-1);
        return ret > 0;
    }

    /**
     * 通过name删除数据
     *
     * @param consumer 实例对象
     * @return 影响行数
     */
    @Override
    public boolean deleteByName(Consumer consumer) {
        List<Consumer> consumers = this.consumerDao.queryByName(consumer.getName());
        int ret = this.consumerDao.deleteByName(consumer.getName());
        System.out.println("删除");
        int id = consumers.get(0).getId();
        this.consumerDao.alterTable(id-1);
        return ret > 0;
    }


}
