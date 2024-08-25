package com.example.seminar_registration_demo2.registrationdatadto;

import java.util.List;

public class ParticipantDataResponse {
	private List<ParticipantDataDTO> participantContent;
	private int pageNo;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	private boolean lastPage;
	
	public void setParticipantContent(List<ParticipantDataDTO> participantContent) {
		this.participantContent = participantContent;
	}
	
	public List<ParticipantDataDTO> getParticipantContent() {
		return participantContent;
	}
	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	
	public long getTotalElements() {
		return totalElements;
	}
	
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public void setLastPage (boolean lastPage) {
		this.lastPage = lastPage;
	}
	
	public boolean isLastPage() {
		return lastPage;
	}

}
