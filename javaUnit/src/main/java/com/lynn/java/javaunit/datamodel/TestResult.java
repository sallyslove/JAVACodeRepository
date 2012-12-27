package com.lynn.java.javaunit.datamodel;

public class TestResult {
    private int caseFailed;
    private int caseSucceed;
    private int caseRunned;
    
    public TestResult(){
        super();
        caseFailed = 0;
        caseSucceed = 0;
        caseRunned = 0;
    }
    public int getCaseFailed() {
        return caseFailed;
    }
    public void incrementCaseFailed() {
        ++this.caseFailed;
    }
    public int getCaseSucceed() {
        return caseSucceed;
    }
    public void incrementCaseSucceed() {
        ++this.caseSucceed;
    }
    
    public void incrementCaseRunned(){
        ++this.caseRunned;
    }
    
    public int getCaseRunned() {
        return caseRunned;
    }
    
    public void print(){
        System.out.println("test cases runned:"+this.caseRunned);
        System.out.println("test cases succed:"+this.caseSucceed);
        System.out.println("test cases failed:"+this.caseFailed);
    }
}
