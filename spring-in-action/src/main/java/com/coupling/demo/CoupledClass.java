package com.coupling.demo;

public class CoupledClass {
	
	private CouplingClass couplingClass;
	
	public CoupledClass(){
		couplingClass = new CouplingClass();
	}

	/**
	 * @return the couplingClass
	 */
	public CouplingClass getCouplingClass() {
		return couplingClass;
	}

	/**
	 * @param couplingClass the couplingClass to set
	 */
	public void setCouplingClass(CouplingClass couplingClass) {
		this.couplingClass = couplingClass;
	}
	
	

}
