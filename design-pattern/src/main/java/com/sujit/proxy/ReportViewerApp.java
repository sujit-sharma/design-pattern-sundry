package com.sujit.proxy;

public class ReportViewerApp {
    public static void main(String[] args) {
        Report adminView = new ReportProxy("ADMIN", "Quarterly revenue: $1,250,000");
        adminView.display();

        Report guestView = new ReportProxy("GUEST", "Quarterly revenue: $1,250,000");
        guestView.display();
    }
}
