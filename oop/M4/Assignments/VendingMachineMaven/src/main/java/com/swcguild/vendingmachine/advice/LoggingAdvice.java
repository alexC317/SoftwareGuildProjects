/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachine.advice;

import com.swcguild.vendingmachine.dao.VendingMachineAuditDao;
import com.swcguild.vendingmachine.dao.VendingMachinePersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Alex
 */
public class LoggingAdvice {

    VendingMachineAuditDao auditDao;

    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void createAuditEntry(JoinPoint jp, Exception message) {
        String auditEntry = message.toString();
        
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachinePersistenceException e) {
            System.err.println(
                    "Error: Could not create audit entry in LoggingAdvice.");
        }
    }
}
