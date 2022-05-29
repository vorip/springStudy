package co.kr.spring.vo;

public class CrawlingVo {
	//페이지 크롤링
	String billNum ="";
	String lawName = "";
	String lawType = "";
	String revisionType = "";
	String lawDept = "";
	String lawStatus = "";
	//검색어 크롤링
	String lsKndCd="";
	String cptOfiOrgCd="";
	String stDtFmt="2021.+3.+20.";
	String edDtFmt="2022.+4.+20.";
	String lbPrcStsCd="";
	String lsNmKo="규칙";
	//국회입법 검색어
	String sortCol = "";
	String sortOrder = "";
	String sugCd = "21";
	String sgtCls = "";
	String searchStDtNew = "";
	String rslRsltNmL = "";
	String rslRsltNmR = "";
	String scCptPpostCmt = "";
	String searchEdDtNew = "";
	String scPpsUsr = "";
	String scBlNmSct = "의원";
	
	//국회입법페이지
	String lawTime = "";
	String lawMakinTime = "";
	String finalTime= "";
	
	//LAWMAKING KEYWORD
	int seq=0;
	String keyword="";
	String reg_id="";
	int reg_date=0;
	
	//LAWMAKING GOV
	String revision="";
	String department="";
	String promotion="";
	
	//LAWMAKING NSM
	String promonent="";
	String committee="";
	String stateCode="";
	String decisionRe="";
	public String getBillNum() {
		return billNum;
	}
	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}
	public String getLawName() {
		return lawName;
	}
	public void setLawName(String lawName) {
		this.lawName = lawName;
	}
	public String getLawType() {
		return lawType;
	}
	public void setLawType(String lawType) {
		this.lawType = lawType;
	}
	public String getRevisionType() {
		return revisionType;
	}
	public void setRevisionType(String revisionType) {
		this.revisionType = revisionType;
	}
	public String getLawDept() {
		return lawDept;
	}
	public void setLawDept(String lawDept) {
		this.lawDept = lawDept;
	}
	public String getLawStatus() {
		return lawStatus;
	}
	public void setLawStatus(String lawStatus) {
		this.lawStatus = lawStatus;
	}
	public String getLsKndCd() {
		return lsKndCd;
	}
	public void setLsKndCd(String lsKndCd) {
		this.lsKndCd = lsKndCd;
	}
	public String getCptOfiOrgCd() {
		return cptOfiOrgCd;
	}
	public void setCptOfiOrgCd(String cptOfiOrgCd) {
		this.cptOfiOrgCd = cptOfiOrgCd;
	}
	public String getStDtFmt() {
		return stDtFmt;
	}
	public void setStDtFmt(String stDtFmt) {
		this.stDtFmt = stDtFmt;
	}
	public String getEdDtFmt() {
		return edDtFmt;
	}
	public void setEdDtFmt(String edDtFmt) {
		this.edDtFmt = edDtFmt;
	}
	public String getLbPrcStsCd() {
		return lbPrcStsCd;
	}
	public void setLbPrcStsCd(String lbPrcStsCd) {
		this.lbPrcStsCd = lbPrcStsCd;
	}
	public String getLsNmKo() {
		return lsNmKo;
	}
	public void setLsNmKo(String lsNmKo) {
		this.lsNmKo = lsNmKo;
	}
	public String getSortCol() {
		return sortCol;
	}
	public void setSortCol(String sortCol) {
		this.sortCol = sortCol;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getSugCd() {
		return sugCd;
	}
	public void setSugCd(String sugCd) {
		this.sugCd = sugCd;
	}
	public String getSgtCls() {
		return sgtCls;
	}
	public void setSgtCls(String sgtCls) {
		this.sgtCls = sgtCls;
	}
	public String getSearchStDtNew() {
		return searchStDtNew;
	}
	public void setSearchStDtNew(String searchStDtNew) {
		this.searchStDtNew = searchStDtNew;
	}
	public String getRslRsltNmL() {
		return rslRsltNmL;
	}
	public void setRslRsltNmL(String rslRsltNmL) {
		this.rslRsltNmL = rslRsltNmL;
	}
	public String getRslRsltNmR() {
		return rslRsltNmR;
	}
	public void setRslRsltNmR(String rslRsltNmR) {
		this.rslRsltNmR = rslRsltNmR;
	}
	public String getScCptPpostCmt() {
		return scCptPpostCmt;
	}
	public void setScCptPpostCmt(String scCptPpostCmt) {
		this.scCptPpostCmt = scCptPpostCmt;
	}
	public String getSearchEdDtNew() {
		return searchEdDtNew;
	}
	public void setSearchEdDtNew(String searchEdDtNew) {
		this.searchEdDtNew = searchEdDtNew;
	}
	public String getScPpsUsr() {
		return scPpsUsr;
	}
	public void setScPpsUsr(String scPpsUsr) {
		this.scPpsUsr = scPpsUsr;
	}
	public String getScBlNmSct() {
		return scBlNmSct;
	}
	public void setScBlNmSct(String scBlNmSct) {
		this.scBlNmSct = scBlNmSct;
	}
	public String getLawTime() {
		return lawTime;
	}
	public void setLawTime(String lawTime) {
		this.lawTime = lawTime;
	}
	public String getLawMakinTime() {
		return lawMakinTime;
	}
	public void setLawMakinTime(String lawMakinTime) {
		this.lawMakinTime = lawMakinTime;
	}
	public String getFinalTime() {
		return finalTime;
	}
	public void setFinalTime(String finalTime) {
		this.finalTime = finalTime;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public int getReg_date() {
		return reg_date;
	}
	public void setReg_date(int reg_date) {
		this.reg_date = reg_date;
	}
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public String getPromonent() {
		return promonent;
	}
	public void setPromonent(String promonent) {
		this.promonent = promonent;
	}
	public String getCommittee() {
		return committee;
	}
	public void setCommittee(String committee) {
		this.committee = committee;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getDecisionRe() {
		return decisionRe;
	}
	public void setDecisionRe(String decisionRe) {
		this.decisionRe = decisionRe;
	}
	
	
}
