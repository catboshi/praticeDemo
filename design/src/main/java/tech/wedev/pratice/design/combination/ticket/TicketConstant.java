package tech.wedev.pratice.design.combination.ticket;

import tech.wedev.pratice.design.combination.ticket.pojo.CompanyTicket;
import tech.wedev.pratice.design.combination.ticket.pojo.PersonalTicket;

public class TicketConstant {
    // 保存只具有公共属性的对象，供clone使用。
    public static PersonalTicket personalTicket = new PersonalTicket();
    public static CompanyTicket companyTicket = new CompanyTicket();

    static {
        personalTicket.setType("type");
        personalTicket.setFooter("footer");
        companyTicket.setType("type");
        companyTicket.setFooter("footer");
    }
}
