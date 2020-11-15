package com.mingyuan.bangbang.util;

import com.github.pagehelper.PageInfo;
import com.mingyuan.bangbang.pojo.PageResult;
import org.springframework.data.domain.PageRequest;

public class PageUtil {


    public static PageResult getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}