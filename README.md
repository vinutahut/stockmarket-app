# stockmarket-app-phase 3

## 1.company-details
### Endpoints-
- companies/{compId}
|  Method - GET
|  Returns company with company ID
-  companies/matching/{compName}
| Method - GET
| Returns list of companies with company Name pattern
- companies/sector/{sector}
| Method - GET
| Returns list of companies in given sector
- companies/se/{se} Method - GET
| Returns list of companies with given Stock Exchange
- companies/add
| Method - POST
| Add the company details to the database

## 2.ipo-service
### Endpoints-
- ipos/{compId}
| Method - GET
| Returns list of ipos using company ID

## 3. se-service
### Endpoints-
- /se/{seId}
  Method - GET
  Returns the Stock Exchange object with the given seId
- /se/
  Method - POST
  Add the stock exchange details to the database
- /se
  Method - GET
  Returns list of all Stock Exchange object
