package tech.wedev.pratice.design.combination.service;

import tech.wedev.pratice.design.combination.pojo.TicketParam;

import java.util.List;

public interface UserService {

    List<String> suggestRequirement(String username);

    Object getTicket(TicketParam ticketParam);

    Boolean login(String name, String pwd, String type);

}
