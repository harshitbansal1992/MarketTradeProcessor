# MarketTradeProcessor
http://localhost:8030/MarketTradeProcessor/rest/endpoint/tradeMessage
is the endpoint wher eyou post your json message in the mentioned format.

From the endpoint the message goes through to the consumer which filters it on the basis of country mentioned in the request.
List of the banned countries is iniailzed there itself, but wanted to initalize it at the AppStartup.

From Consumer the messsage can be deliverd to the various backend systems like File, MQ etc.
So, consumer has a field which gives backend and load the backend class dynamically.

Wanted to make the backend classes generic, so that they could accept any of the requested object. 


FrontEnd is displayed with the help of servlet using the following url:

http://localhost:8030/MarketTradeProcessor/TradeMessage
