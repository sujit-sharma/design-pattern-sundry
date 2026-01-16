package com.sujit.proxy;

import java.util.logging.Logger;

/** Checks the caller's access before delegating to the confidential report. */
public class ReportProxy implements Report {
    private final String userRole;
    private final Report report;

    public ReportProxy(String userRole, String reportContent) {
        this.userRole = userRole;
        this.report = new ConfidentialReport(reportContent);
    }

    @Override
    public void display() {
        if ("ADMIN".equalsIgnoreCase(userRole)) {
            report.display();
        } else {
            Logger.getGlobal().info("Access denied: only an admin can view this report");
        }
    }
}
