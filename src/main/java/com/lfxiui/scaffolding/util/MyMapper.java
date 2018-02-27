package com.lfxiui.scaffolding.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author lfxiui
 * @date 2018/2/26 0026 17:33
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
