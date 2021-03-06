/**
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mifosplatform.portfolio.paymenttowhom.domain;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.portfolio.paymenttowhom.api.PaymentToWhomApiResourceConstants;
import org.mifosplatform.portfolio.paymenttowhom.data.PaymentToWhomData;
import org.mifosplatform.portfolio.paymenttowhom.api.PaymentToWhomApiResourceConstants;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "m_payment_to_whom")
public class PaymentToWhom extends AbstractPersistable<Long>{
	@Column(name = "value")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_cash_payment")
    private Boolean isCashPayment;

    @Column(name = "order_position")
    private Long position;	
    
    protected PaymentToWhom() {}
    
    public PaymentToWhom(final String name, final String description,final Boolean isCashPayment,final Long position){
    	this.name = name;
    	this.description = description;
    	this.isCashPayment = isCashPayment;
    	this.position = position;
    }
    
    public static PaymentToWhom create(String name, String description,Boolean isCashPayment,Long position){
    	return new PaymentToWhom(name, description, isCashPayment, position);
    }
    public Map<String, Object> update(final JsonCommand command) {

        final Map<String, Object> actualChanges = new LinkedHashMap<>(3);

        if (command.isChangeInStringParameterNamed(PaymentToWhomApiResourceConstants.NAME, this.name)) {
            final String newValue = command.stringValueOfParameterNamed(PaymentToWhomApiResourceConstants.NAME);
            actualChanges.put(PaymentToWhomApiResourceConstants.NAME, newValue);
            this.name = StringUtils.defaultIfEmpty(newValue, null);
        }

        if (command.isChangeInStringParameterNamed(PaymentToWhomApiResourceConstants.DESCRIPTION, this.description)) {
            final String newDescription = command.stringValueOfParameterNamed(PaymentToWhomApiResourceConstants.DESCRIPTION);
            actualChanges.put(PaymentToWhomApiResourceConstants.DESCRIPTION, newDescription);
            this.description = StringUtils.defaultIfEmpty(newDescription, null);
        }

        if (command.isChangeInBooleanParameterNamed(PaymentToWhomApiResourceConstants.ISCASHPAYMENT, this.isCashPayment)) {
            final Boolean newCashPaymentType = command.booleanObjectValueOfParameterNamed(PaymentToWhomApiResourceConstants.ISCASHPAYMENT);
            actualChanges.put(PaymentToWhomApiResourceConstants.ISCASHPAYMENT, newCashPaymentType);
            this.isCashPayment = newCashPaymentType.booleanValue();
        }

        if (command.isChangeInLongParameterNamed(PaymentToWhomApiResourceConstants.POSITION, this.position)) {
            final Long newPosition = command.longValueOfParameterNamed(PaymentToWhomApiResourceConstants.POSITION);
            actualChanges.put(PaymentToWhomApiResourceConstants.POSITION, newPosition);
            this.position = newPosition;
        }

        return actualChanges;
    }
    
    public PaymentToWhomData toData(){
    	return PaymentToWhomData.instance(getId(),this.name, this.description,this.isCashPayment,this.position);
    }
}
