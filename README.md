# Readme

1. Java Maven Project

2. The app was tested on Wildfly 10.1 (http://wildfly.org/)

3. amortsch.faces is the index page, defined on web.xml

4. About "Interest 2", you can choose to calculate a Loan with an unique Interest for all the Term (Term = Interest 1 Term); or you can split the Term in 2 periods, and choose different interests for each one. You only need to specify the Interest 1 Term duration, and the different interests.

5. On the path /api/calculator/mock you can get a JSON mock of a LoanInformation. Then, on /api/calculator you can call a POST method and get in response the Amortization Schedule as a JSON
