package com.lfxiui.scaffolding.mapper;

import com.lfxiui.scaffolding.model.SUser;
import com.lfxiui.scaffolding.util.MyMapper;

import java.util.List;

public interface SUserMapper extends MyMapper<SUser> {
    List<SUser> all();
}