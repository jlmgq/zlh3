package cn.yingchuang.jboa.command.util;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/3/5 0005.
 */
public class PageUtil<T>{
    private long total;
    private List<T> rows;

    public PageUtil(PageInfo<T> pageInfo){
        this.total = pageInfo.getTotal();
        this.rows = pageInfo.getList();
    }
    @Override
    public String toString() {
        return "PageUtil{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageUtil(long total, List<T> rows) {

        this.total = total;
        this.rows = rows;
    }

    public PageUtil() {

    }
}
