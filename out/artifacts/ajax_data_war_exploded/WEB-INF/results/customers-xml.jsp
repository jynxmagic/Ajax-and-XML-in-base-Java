<%@ page import="coreservlets.Customer" %>
<?xml version="1.0" encoding="UTF-8"?>
<customers>
    <headings>
        <heading>First Name</heading>
        <heading>Last name</heading>
        <heading>Balance</heading>
    </headings>
    <%
        Customer[] customers = (Customer[]) request.getAttribute("customers");

        for(Customer customer : customers) {
    %>
            <customer>
                <firstName><%=customer.getFirstName()%></firstName>
                <lastName><%=customer.getLastName()%></lastName>
                <balance><%=customer.getFormattedBalance()%></balance>
            </customer>
    <% } %>
</customers>