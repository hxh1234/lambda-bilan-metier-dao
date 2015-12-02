package com.lambda.bilan.domain;

import java.util.List;

public class BAP {

	private String periode;
	private List<FeedBack> feedBacks;
	private FicheObjectifs ficheObjectifs;
	private PlanAmelioration planAmelioration;
	private String status;
	public BAP(String periode, List<FeedBack> feedBacks, FicheObjectifs ficheObjectifs,
			PlanAmelioration planAmelioration, String status) {
		super();
		this.periode = periode;
		this.feedBacks = feedBacks;
		this.ficheObjectifs = ficheObjectifs;
		this.planAmelioration = planAmelioration;
		this.status = status;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	public List<FeedBack> getFeedBacks() {
		return feedBacks;
	}
	public void setFeedBacks(List<FeedBack> feedBacks) {
		this.feedBacks = feedBacks;
	}
	public FicheObjectifs getFicheObjectifs() {
		return ficheObjectifs;
	}
	public void setFicheObjectifs(FicheObjectifs ficheObjectifs) {
		this.ficheObjectifs = ficheObjectifs;
	}
	public PlanAmelioration getPlanAmelioration() {
		return planAmelioration;
	}
	public void setPlanAmelioration(PlanAmelioration planAmelioration) {
		this.planAmelioration = planAmelioration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
