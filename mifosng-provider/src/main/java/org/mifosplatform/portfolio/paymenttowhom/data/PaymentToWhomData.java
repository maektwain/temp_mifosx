/**
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mifosplatform.portfolio.paymenttowhom.data;

public class PaymentToWhomData {

	@SuppressWarnings("unused")
	private Long id;
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private String description;
	@SuppressWarnings("unused")
	private Boolean isCashPayment;
	@SuppressWarnings("unused")
	private Long position;
	
	public PaymentToWhomData(final Long id, final String name, final String description, final Boolean isCashPayment, final Long position){
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.isCashPayment = isCashPayment;
		this.position = position;
		
	}
	
	public static PaymentToWhomData instance(final Long id, final String name,final String description, final Boolean isCashPayment, 
			final Long position){
		return new PaymentToWhomData(id, name, description, isCashPayment, position);
	}
	
	public static PaymentToWhomData instance(final Long id, final String name){
		String description = null;
		Boolean isCashPayment = null;
		Long position = null;
		
		return new PaymentToWhomData(id, name, description, isCashPayment, position);
	}
}
