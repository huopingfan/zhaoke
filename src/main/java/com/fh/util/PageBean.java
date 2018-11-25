package com.fh.util;

import java.util.List;

public class PageBean<T>
{
  private Integer totalcount;
  private Integer pagesum;
  private Integer pagesize = Integer.valueOf(2);
  private Integer pagenow = Integer.valueOf(1);
  private Integer startindex;
  private Integer endindex;
  private List<T> list;
  
  public void calculate()
  {
    int remainder = this.totalcount.intValue() % this.pagesize.intValue();
    if (remainder == 0) {
      this.pagesum = Integer.valueOf(this.totalcount.intValue() / this.pagesize.intValue());
    } else {
      this.pagesum = Integer.valueOf(this.totalcount.intValue() / this.pagesize.intValue() + 1);
    }
    this.startindex = Integer.valueOf((this.pagenow.intValue() - 1) * this.pagesize.intValue());
    
    this.endindex = Integer.valueOf(this.pagenow.intValue() * this.pagesize.intValue());
  }
  
  public Integer getTotalcount()
  {
    return this.totalcount;
  }
  
  public void setTotalcount(Integer totalcount)
  {
    this.totalcount = totalcount;
  }
  
  public Integer getPagesum()
  {
    return this.pagesum;
  }
  
  public void setPagesum(Integer pagesum)
  {
    this.pagesum = pagesum;
  }
  
  public Integer getPagesize()
  {
    return this.pagesize;
  }
  
  public void setPagesize(Integer pagesize)
  {
    this.pagesize = pagesize;
  }
  
  public Integer getPagenow()
  {
    return this.pagenow;
  }
  
  public void setPagenow(Integer pagenow)
  {
    this.pagenow = pagenow;
  }
  
  public Integer getStartindex()
  {
    return this.startindex;
  }
  
  public void setStartindex(Integer startindex)
  {
    this.startindex = startindex;
  }
  
  public Integer getEndindex()
  {
    return this.endindex;
  }
  
  public void setEndindex(Integer endindex)
  {
    this.endindex = endindex;
  }
  
  public List<T> getList()
  {
    return this.list;
  }
  
  public void setList(List<T> list)
  {
    this.list = list;
  }
}
