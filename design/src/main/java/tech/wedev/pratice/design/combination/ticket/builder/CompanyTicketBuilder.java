package tech.wedev.pratice.design.combination.ticket.builder;

import tech.wedev.pratice.design.combination.ticket.TicketConstant;
import tech.wedev.pratice.design.combination.ticket.pojo.CompanyTicket;

public class CompanyTicketBuilder extends TicketBuilder<CompanyTicket> {

    private CompanyTicket companyTicket = TicketConstant.companyTicket.clone(); // new 关键字

    @Override
    public void setBankInfo(String bankInfo) {
        companyTicket.setBankInfo(bankInfo);
    }

    @Override
    public void setParam(String account, String title) {
        companyTicket.setTitle(title);
        companyTicket.setAccount(account);
    }

    @Override
    public void setContent(String content) {
        companyTicket.setContent(content);
    }

    @Override
    public void setProduct(String product) {
        companyTicket.setProduct(product);
    }

    @Override
    public CompanyTicket buildTicket() {
        return companyTicket;
    }
}
