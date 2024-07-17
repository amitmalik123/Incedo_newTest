package com.amk.cucumber.utility.models;

import java.sql.Array;

public class Transactions {
		
	private String _id;
	private String accountNumber;
	private String transactionType;
	private String debitOrCreditIndicator;
	private String definerCode;
	
	private String effectiveDate;
	
	private String endingBalance;  // it should be in int
	private String miscellaneousInformation;
	private String originCode;
	private String sourceCode;
	private String terminalNumber;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String string) {
		this._id = string;
	}
	
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	private String timeStamp;
	private String traceNumber;
	private String transCode;
	private String transactionAmount; //int
	private String transactionCode;
	private String transactionDate;
	private String dailySequenceNumber;
	private String acctTypeCode;
		
	


	public String getAccountTypeCode() {
		return acctTypeCode;
	}
	public void setAccountTypeCode(String accountTypeCode) {
		this.acctTypeCode = accountTypeCode;
	}
	private String branchNumber;
	public String getBranchNumber() {
		return branchNumber;
	}
	public void setBranchNumber(String branchNumber) {
		this.branchNumber = branchNumber;
	}
	public String getDailySequenceNumber() {
		return dailySequenceNumber;
	}
	public void setDailySequenceNumber(String dailySequenceNumber) {
		this.dailySequenceNumber = dailySequenceNumber;
	}
	public String getDebitOrCreditIndicator() {
		return debitOrCreditIndicator;
	}
	public void setDebitOrCreditIndicator(String debitOrCreditIndicator) {
		this.debitOrCreditIndicator = debitOrCreditIndicator;
	}
	public String getDefinerCode() {
		return definerCode;
	}
	public void setDefinerCode(String definerCode) {
		this.definerCode = definerCode;
	}
	/*public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}*/
	public String getEndingBalance() {
		return endingBalance;
	}
	
	public void setEndingBalance(String endingBalance) {
		this.endingBalance = endingBalance;
	}
	public String getMiscellaneousInformation() {
		return miscellaneousInformation;
	}
	public void setMiscellaneousInformation(String miscellaneousInformation) {
		this.miscellaneousInformation = miscellaneousInformation;
	}
	public String getOriginCode() {
		return originCode;
	}
	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}
	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	public String getTerminalNumber() {
		return terminalNumber;
	}
	public void setTerminalNumber(String terminalNumber) {
		this.terminalNumber = terminalNumber;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getTraceNumber() {
		return traceNumber;
	}
	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}
	public String getTransCode() {
		return transCode;
	}
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	
	

}
