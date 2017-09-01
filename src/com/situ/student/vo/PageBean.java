package com.situ.student.vo;

import java.io.Serializable;
import java.util.List;

import com.situ.student.pojo.Student;

public class PageBean implements Serializable {
	/**
	 * 当前是第几页
	 */
	private Integer pageIndex;
	/**
	 * 一共有多少页
	 */
	private Integer totalPage;
	/**
	 * 每一页有多少条数据
	 */
	private Integer pageSize;
	/**
	 * 数据库中一共有多少条记录
	 */
	private Integer totalCount;
	/**
	 * 当前页的数据
	 */
	private List<Student> list;

	public PageBean() {
		super();
	}

	public PageBean(Integer pageIndex, Integer totalPage, Integer pageSize, Integer totalCount, List<Student> list) {
		super();
		this.pageIndex = pageIndex;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.list = list;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageBean [pageIndex=" + pageIndex + ", totalPage=" + totalPage + ", pageSize=" + pageSize
				+ ", totalCount=" + totalCount + ", list=" + list + "]";
	}

}
