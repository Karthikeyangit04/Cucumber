#Author: your.email@your.domain.com




Feature: Title of your feature
  I want to use this template for my feature file

  #@tag1
  #Scenario: Title of your scenario
    #Given launch the browser
    #When enter the customer details
  #|fname|karthi|
  #|lname|keyan|
  #|email|karthikyan32@gmail.com|
  #|address|chennai|
  #|phone|55451851548454|
    #Then I validate the outcomes

    
  @tag2
  Scenario Outline: Title of your scenario
    Given launch the browser
    When click the customer details "<fname>","<lname>","<email>","<adderss>","<phone>"   
    Then I validate the outcomes
    
     Examples:
	       |fname|lname|email|adderss|phone|
	       |karthi|Keyan|karthik@gmail.com|Chennai|36985244|
	       |Arun|Kumar|arun@gmail.com|cuddalur|86957523|       
	       |dinesh|kumar|dinsh@gmail.com|kumbakonam|86558558|
	
	


 